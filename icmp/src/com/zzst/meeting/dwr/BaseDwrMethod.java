package com.zzst.meeting.dwr;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import uk.ltd.getahead.dwr.WebContext;
import uk.ltd.getahead.dwr.WebContextFactory;

import com.gsiec.cjf.system.CjfLogger;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import com.zzst.action.meeting.util.LogUtil;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.enums.AddressEnu;
import com.zzst.model.enums.DateBaseEnum;
import com.zzst.model.enums.DictionaryEnum;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.address.AddressVO;
import com.zzst.model.meeting.centerControl.CenterControlVO;
import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.dictionary.DictionaryEquipmentVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.level.LevelVO;
import com.zzst.model.meeting.levelConfig.LevelConfigVO;
import com.zzst.model.meeting.log.LogVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.user.UserVO;

public class BaseDwrMethod {
	private static Logger logger = CjfLogger.getLogger(BaseDwrMethod.class.getName());
	
	/**
	 * 添加操作日志,如果logType或level无法确定，就传Integer.MIN_VALUE
	 * @param operatorContent
	 */
	private void addLog(String operatorContent,int logType,int level){
		logger.info("BaseDwrMethod	addLog	begin");
		try{
			WebContext ctx = WebContextFactory.get(); 
			HttpSession session = ctx.getHttpServletRequest().getSession(); 
			UserVO userVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);

			LogVO vLogVO = new LogVO();
			if(operatorContent!=null&&operatorContent.length()>0){
				vLogVO.setOperatorContent(operatorContent);	
			}else{
				return;
			}
			if(logType==Integer.MIN_VALUE){
				logType = LogEnum.TYPE_DEFAULT;
			}
			if(level == Integer.MIN_VALUE){
				level = LogEnum.LEVEL_DeFAULT;
			}
			vLogVO.setLogType(logType);
			vLogVO.setLevel(level);
			vLogVO.setUserIP(ctx.getHttpServletRequest().getRemoteHost());
			vLogVO.setUserID(userVO.getUserID());
			
			LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
		}catch(Exception e){
			e.printStackTrace();
			logger.error("BaseDwrMethod 	addLog	error:	"+e.getMessage());
		}
		logger.info("BaseDwrMethod	addLog	end");
	}
	
	/**
	 * 会议资源占用情况
	 * @param year
	 * @param month
	 * @return
	 */
	public String getMeetingOccupy(String year,String month){
		logger.info("BaseDwrMethod	getMeetingOccupy	begin");
		MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
		List<MeetingDetailVO> mdList = new ArrayList<MeetingDetailVO>();
		String result = "";
		try {
			//mdvo.getInfo3();mdvo.getInfo4();mdvo.getInfo5()分别代表年月日
			mdList = ServiceFactory.getMeetingDetailService().queryMeetingOccupy(meetingDetailVO, null);
			if(mdList==null&&mdList.size()>0){
				logger.info("DwrMethod	getMeetingOccupy	end");
				return null;
			}
			
			if(year==null||"".equals(year)){//不传入年
				return null;
			}
			int january = 0;//Jan一月
			int february = 0;//Feb二月
			int march = 0;//Mar三月
			int	April = 0;//Apr四月
			int may = 0;//May五月
			int june = 0;//Jun六月
			int july = 0;//Jul七月
			int augest = 0;//Aug八月
			int september = 0;//Sep九月
			int october = 0;//Oct十月
			int november = 0;//Nov十一月
			int december = 0;//Dec十二月
			if(month==null||"".equals(month)){//如果只传入年份
				//一年分为12个月
				for(MeetingDetailVO mdvo:mdList){
					if(mdvo.getInfo3().equals(year)){
						if(mdvo.getInfo4().equals("1")){
							january++;
						}else if(mdvo.getInfo4().equals("2")){
							february++;
						}else if(mdvo.getInfo4().equals("3")){
							march++;
						}else if(mdvo.getInfo4().equals("4")){
							April++;
						}else if(mdvo.getInfo4().equals("5")){
							may++;
						}else if(mdvo.getInfo4().equals("6")){
							june++;
						}else if(mdvo.getInfo4().equals("7")){
							july++;
						}else if(mdvo.getInfo4().equals("8")){
							augest++;
						}else if(mdvo.getInfo4().equals("9")){
							september++;
						}else if(mdvo.getInfo4().equals("10")){
							october++;
						}else if(mdvo.getInfo4().equals("11")){
							november++;
						}else if(mdvo.getInfo4().equals("12")){
							december++;
						}
					}
				}
				result = "1:"+january+";2:"+february+";3:"+march+";4:"+April+";5:"+may+";6:"+june+";7:"+july+";8:"+augest+";9:"+september+";10:"+october+";11:"+november+";12:"+december;
			}else{//同时传入年和月
				int info13 = 0;//13
				int info14 = 0;//14
				int info15 = 0;//15
				int info16 = 0;//16
				int info17 = 0;//17
				int info18 = 0;//18
				int info19 = 0;//19
				int info20 = 0;//20
				int info21 = 0;//21
				int info22 = 0;//22
				int info23 = 0;//23
				int info24 = 0;//24
				int info25 = 0;//25
				int info26 = 0;//26
				int info27 = 0;//27
				int info28 = 0;//28
				int info29 = 0;//29
				int info30 = 0;//30
				int info31 = 0;//31
				for(MeetingDetailVO mdvo:mdList){
					if(mdvo.getInfo3().equals(year)&&mdvo.getInfo4().equals(month)){
						if(mdvo.getInfo5().equals("1")){
							january++;
						}else if(mdvo.getInfo5().equals("2")){
							february++;
						}else if(mdvo.getInfo5().equals("3")){
							march++;
						}else if(mdvo.getInfo5().equals("4")){
							April++;
						}else if(mdvo.getInfo5().equals("5")){
							may++;
						}else if(mdvo.getInfo5().equals("6")){
							june++;
						}else if(mdvo.getInfo5().equals("7")){
							july++;
						}else if(mdvo.getInfo5().equals("8")){
							augest++;
						}else if(mdvo.getInfo5().equals("9")){
							september++;
						}else if(mdvo.getInfo5().equals("10")){
							october++;
						}else if(mdvo.getInfo5().equals("11")){
							november++;
						}else if(mdvo.getInfo5().equals("12")){
							december++;
						}else if(mdvo.getInfo5().equals("13")){
							info13++;
						}else if(mdvo.getInfo5().equals("14")){
							info14++;
						}else if(mdvo.getInfo5().equals("15")){
							info15++;
						}else if(mdvo.getInfo5().equals("16")){
							info16++;
						}else if(mdvo.getInfo5().equals("17")){
							info17++;
						}else if(mdvo.getInfo5().equals("18")){
							info18++;
						}else if(mdvo.getInfo5().equals("19")){
							info19++;
						}else if(mdvo.getInfo5().equals("20")){
							info20++;
						}else if(mdvo.getInfo5().equals("21")){
							info21++;
						}else if(mdvo.getInfo5().equals("22")){
							info22++;
						}else if(mdvo.getInfo5().equals("23")){
							info23++;
						}else if(mdvo.getInfo5().equals("24")){
							info24++;
						}else if(mdvo.getInfo5().equals("25")){
							info25++;
						}else if(mdvo.getInfo5().equals("26")){
							info26++;
						}else if(mdvo.getInfo5().equals("27")){
							info27++;
						}else if(mdvo.getInfo5().equals("28")){
							info28++;
						}else if(mdvo.getInfo5().equals("29")){
							info29++;
						}else if(mdvo.getInfo5().equals("30")){
							info30++;
						}else if(mdvo.getInfo5().equals("31")){
							info31++;
						}
					}
				}
				result += "1:"+january+";2:"+february+";3:"+march+";4:"+April+";5:"+may+";6:"+june+";7:"+july+";8:"+augest+";9:"+september+";10:"+october+";11:"+november+";12:"+december;
				result += ";13:"+info13+";14:"+info14+";15:"+info15+";16:"+info16+";17:"+info17+";18:"+info18+";19:"+info19+";20:"+info20;
				result += ";21:"+info21+";22:"+info22+";23:"+info23+";24:"+info24+";25:"+info25+";26:"+info26+";27:"+info27+";28:"+info28+";29:"+info29+";30:"+info30+";31:"+info31;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("BaseDwrMethod 	getMeetingOccupy	error:	"+e.getMessage());	
		}
		logger.info("BaseDwrMethod	getMeetingOccupy	end");
		return result;
	}
	
	
	//中控配置设备名称和设备编号校验。
	public String checkCenterControlInfo(String ccIP,String equipmentType,String equipmentName,String ccNO){
		logger.info("BaseDwrMethod	checkCenterControlInfo	begin");
		CenterControlVO centerControlVO = new CenterControlVO();
		List<CenterControlVO> cList = new ArrayList<CenterControlVO>();
		StringBuffer result = new StringBuffer();

		centerControlVO.setCcIP(ccIP);
		centerControlVO.setEquipmentType(equipmentType);
		try {
			if(ccIP==null||"".equals(ccIP) || equipmentType==null||"".equals(equipmentType)){
				logger.info("BaseDwrMethod	checkCenterControlInfo	end");
				return result.toString();
			}
			if(("".equals(equipmentName) || equipmentName==null) && ("".equals(ccNO) || ccNO==null)){
				logger.info("BaseDwrMethod	checkCenterControlInfo	end");
				return result.toString();
			}
			cList = ServiceFactory.getCenterControlService().query(centerControlVO, null);
			if(cList!=null && cList.size()>0){
				for(CenterControlVO vo:cList){
					if(equipmentName.trim().equals(vo.getEquipmentName())){
						result.append("设备名称"+equipmentName+"被占用;");
						equipmentName = "";//解决数据库冗余数据的问题
					}
					if(ccNO.trim().equals(vo.getCcNO())){
						result.append("设备编号"+ccNO+"被占用;");
						ccNO = "";
					}
				}
				if(!"".equals(result)&&result.length()>0){
					result.substring(0,result.length()-1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("BaseDwrMethod 	checkCenterControlInfo	error:	"+e.getMessage());
		}
		logger.info("BaseDwrMethod	checkCenterControlInfo	end");
		return result.toString();
	}
	
	//修改分级名称
	public boolean modifyLevel(String id,String name){
		logger.info("BaseDwrMethod	modifyLevel begin"+name);
		LevelVO levelGradeVO=new LevelVO();
		levelGradeVO.setLevelID(id);
		levelGradeVO.setLevelName(name);
		try{
			ServiceFactory.getLevelService().modify(levelGradeVO);
			//添加日志
			String operatorContent = "修改分级信息，分级名称："+name;
			int logType = LogEnum.TYPE_DEFAULT;
			int level = LogEnum.LEVEL_DeFAULT;
			addLog(operatorContent, logType, level);
		}
		catch(Exception e){
			e.printStackTrace();
			logger.error("BaseDwrMethod modifyLevel	error:	"+e.getMessage());
		}
		logger.info("BaseDwrMethod	modifyLevel end"+name);
		return true;
	}
	
	//删除菜单管理(func)节点
	/*判断父节点是否有子节点
	 * 如果当前节点没有子节点，则将当前节点删除，如果有子节点，则将字节点删除，再将父节点删除
	*/
	public boolean removeLevel(String id,String levelName){
		logger.info("BaseDwrMethod	removeLevel begin"+id);
		LevelVO levelGradeVO=new LevelVO();
		levelGradeVO.setLevelID(id);
		List<LevelVO> levelList = new ArrayList<LevelVO>();
		try{
			levelList = ServiceFactory.getLevelService().ishaveChildOne(levelGradeVO, null);
			if(levelList==null){
				ServiceFactory.getLevelService().deleteByID(id);
			}else{
				ServiceFactory.getLevelService().deleteByPID(id);
				ServiceFactory.getLevelService().deleteByID(id);
			}
	      }catch(Exception e){
	    	  e.printStackTrace();
			  logger.error("BaseDwrMethod removeLevel	error:	"+e.getMessage());
			  return false;
	      }
	    //添加日志
			String operatorContent = "删除分级信息，分级名称："+levelName;
			int logType = LogEnum.TYPE_DEFAULT;
			int level = LogEnum.LEVEL_DeFAULT;
			addLog(operatorContent, logType, level);
	      logger.info("BaseDwrMethod	removeLevel end"+id);
		  return true;
	}
	
	public boolean dragLevel(String levelId,String newpId,String levelName,String levelName2){
		logger.info("BaseDwrMethod	dragLevel	begin ");
		LevelVO levelVO=new LevelVO();
		levelVO.setLevelID(levelId);
		levelVO.setPId(newpId);
		try{
			ServiceFactory.getLevelService().modify(levelVO);
			//添加日志
			String operatorContent = "修改分级信息，将分级“"+levelName+"”置于“"+levelName2+"”下";
			int logType = LogEnum.TYPE_DEFAULT;
			int level = LogEnum.LEVEL_DeFAULT;
			addLog(operatorContent, logType, level);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("BaseDwrMethod dragLevel	error:	"+e.getMessage());	
		}
		logger.info("BaseDwrMethod	dragLevel	end ");
		return true;
	}
	
	/**
	 * 添加分级信息
	 * @param id
	 * @param newName
	 * @return
	 */
	public String addLevel(String pId,String levelName,String pName,String levelPath){
		logger.info("BaseDwrMethod	addLevel	begin");
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session = ctx.getHttpServletRequest().getSession(); 
		UserVO userVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
		String result = "";
		LevelVO levelVO=new LevelVO();
		levelVO.setLevelID(UtilDAO.getUUid());
		levelVO.setPId(pId);
		levelVO.setLevelName(levelName);
		levelVO.setLevelPath(levelPath.concat(levelVO.getLevelID())+",");
		levelVO.setStatus(LevelEnum.STATUS_LEVEL_VALID);
		levelVO.setCreateUserId(userVO.getUserID());
		levelVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
		levelVO.setNodeServer(1);//默认添加的分级不是节点服务器
		try{
			levelVO = ServiceFactory.getLevelService().add(levelVO);
			
			//添加日志
			String operatorContent = "添加分级信息“"+levelName+"”至“"+pName+"”下";
			int logType = LogEnum.TYPE_DEFAULT;
			int level = LogEnum.LEVEL_DeFAULT;
			addLog(operatorContent, logType, level);
			result = levelVO.getLevelID()+";"+levelVO.getLevelPath();
		}catch(Exception e){
			e.printStackTrace();
			logger.error("BaseDwrMethod addLevel	error:	"+e.getMessage());	
		}
		logger.info("BaseDwrMethod	addLevel	end");
		return result;
	}
	
	/**
	 * 产品发布~分级管理~获取分级信息树
	 * @return
	 */
	public String getLevelList(){
		List<LevelVO> lList = new ArrayList<LevelVO>();
		LevelVO levelVO = new LevelVO();
		//构造树数据 
		StringBuffer sbUser = new StringBuffer();
		try {
			lList = ServiceFactory.getLevelService().query(new LevelVO(), null);
			sbUser.append("[");
			if(lList!=null && lList.size()>0){
				for(int i=0;i<lList.size();i++){
					levelVO = lList.get(i);
					if(levelVO.getPId().indexOf("-")>=0 || levelVO.getPId()==null || "".equals(levelVO.getPId())){//只展开树的一级节点，功能优化
			        	sbUser.append("{id:'"+levelVO.getLevelID()+"',pId:'"+levelVO.getPId()+"',name:'"+levelVO.getLevelName()+"',levelPath:'"+levelVO.getLevelPath()+"',open:true,isParent:true},");
			         }else{
			        	sbUser.append("{id:'"+levelVO.getLevelID()+"',pId:'"+levelVO.getPId()+"',name:'"+levelVO.getLevelName()+"',levelPath:'"+levelVO.getLevelPath()+"',open:false},");
			         }
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("获取分级信息失败！");
			return null;
		}
		String str = sbUser.substring(0, sbUser.length()-1);
		str += "];";
		logger.info("获取分级信息成功！");
		return str;
	}
	
	/**
	 * 产品发布~分级管理~获取分级信息树
	 * @return
	 */
	public String getLevelListByPower(){
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session = ctx.getHttpServletRequest().getSession(); 
		UserVO userVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
		
		List<LevelVO> lList = new ArrayList<LevelVO>();
		LevelVO levelVO = new LevelVO();
		Boolean isAll = false;
		//构造树数据 
		StringBuffer sbUser = new StringBuffer();
		String str = "[";
		try {
			lList = ServiceFactory.getLevelService().query(new LevelVO(), null);
			if(lList!=null && lList.size()>0){
				if(!userVO.getOpenlevel()){
					isAll = true;
				}else if(userVO.getLvoids()!=null && userVO.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'")){
					isAll = true;
				}
				if(isAll){
					for(int i=0;i<lList.size();i++){
						levelVO = lList.get(i);
						levelVO = lList.get(i);
						if(levelVO.getPId().indexOf("-")>=0 || levelVO.getPId()==null || "".equals(levelVO.getPId())){//只展开树的一级节点，功能优化
				        	sbUser.append("{id:'"+levelVO.getLevelID()+"',pId:'"+levelVO.getPId()+"',name:'"+levelVO.getLevelName()+"',levelPath:'"+levelVO.getLevelPath()+"',open:true,isParent:true},");
				         }else{
				        	sbUser.append("{id:'"+levelVO.getLevelID()+"',pId:'"+levelVO.getPId()+"',name:'"+levelVO.getLevelName()+"',levelPath:'"+levelVO.getLevelPath()+"',open:false},");
				         }
					}
				}else{
					String levelIds = userVO.getLvoids();//拥有的级别Id的集合
					String levelIdsTemp = ",".concat(levelIds.concat(",")).replace("'", "");
					for(int i=0;i<lList.size();i++){
						levelVO = lList.get(i);
						if(levelIdsTemp.indexOf(","+levelVO.getLevelID()+",")>-1){
							sbUser.append("{id:'"+levelVO.getLevelID()+"',pId:'"+levelVO.getPId()+"',name:'"+levelVO.getLevelName()+"',levelPath:'"+levelVO.getLevelPath()+"',open:true},");
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("获取分级信息失败！");
			return null;
		}
		
		if(sbUser.length()>0){
			str += sbUser.substring(0, sbUser.length()-1);
		}
		str += "];";
		logger.info("获取分级信息成功！");
		return str;
	}
	
	public String checkLevelConfig(String levelID,String levelType){
		String flag = "";
		if(levelID!=null&&!"".equals(levelID)){
			LevelConfigVO lcVO = new LevelConfigVO();
			List<LevelConfigVO> lcList = new ArrayList<LevelConfigVO>();
			lcVO.setLevelID(levelID);
			lcVO.setLevelType(levelType);
			try {
				lcList = ServiceFactory.getLevelConfigService().query(lcVO, null);
				if(lcList!=null&&lcList.size()>0){
					flag = "此分级已经被占用";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public String checkLevelDel(String levelID){
		String flag = "";
		if(levelID!=null&&!"".equals(levelID)){
			WebContext ctx = WebContextFactory.get(); 
			HttpSession session = ctx.getHttpServletRequest().getSession(); 
			UserVO userVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
			
			LevelVO lVO = new LevelVO();
			List<LevelVO> lList = new ArrayList<LevelVO>();
			lVO.setLevelID(levelID);
			try {
				lList = ServiceFactory.getLevelService().query(lVO, null);
				if(lList!=null&&lList.size()>0){
					if(userVO.getLvoids().indexOf("'"+lList.get(0).getPId()+"'")<0){

					}else{
						flag = lList.get(0).getPId();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	/**
	 * 系统管理~区域管理~获取区域信息树 add by liujf 20131206
	 * @return
	 */
	public String addressTreeList(){
		List<AddressVO> aList = new ArrayList<AddressVO>();
		AddressVO addressVO = new AddressVO();
		//构造树数据 
		StringBuffer sbUser = new StringBuffer();
		try {
			aList = ServiceFactory.getAddressService().query(addressVO, null);
			sbUser.append("[");
			if(aList!=null && aList.size()>0){
				for(int i=0;i<aList.size();i++){
					addressVO = aList.get(i);
					if(addressVO.getParentID().indexOf("-")>=0 || addressVO.getParentID()==null || "".equals(addressVO.getParentID())){//只展开树的一级节点，功能优化
			        	sbUser.append("{id:'"+addressVO.getAddressID()+"',pId:'"+addressVO.getParentID()+"',name:'"+addressVO.getName()+"',leaf:'"+addressVO.getLeaf()+"',open:true,isParent:true},");
			         }else{
			        	sbUser.append("{id:'"+addressVO.getAddressID()+"',pId:'"+addressVO.getParentID()+"',name:'"+addressVO.getName()+"',leaf:'"+addressVO.getLeaf()+"',open:false},");
			         }
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("获取区域信息失败！");
			return null;
		}
		String str = sbUser.substring(0, sbUser.length()-1);
		str += "];";
		logger.info("获取区域信息成功！");
		return str;
	}
	/**
	 * 系统管理~~网络拓扑~~获取设备类型、厂家、型号级联关系树 add by liujf20140114
	 * @return
	 */
	public String dicEquipmentList(){
		List<DictionaryEquipmentVO> dList = new ArrayList<DictionaryEquipmentVO>();
		DictionaryEquipmentVO dicEquipmentVO = new DictionaryEquipmentVO();
		//构造树数据 
		StringBuffer sbUser = new StringBuffer();
		try {
			dList = ServiceFactory.getDictionaryEquipmentService().query(dicEquipmentVO, null);
			sbUser.append("[");
			if(dList!=null && dList.size()>0){
				for(int i=0;i<dList.size();i++){
					dicEquipmentVO = dList.get(i);
					if(dicEquipmentVO.getParentID().indexOf("-")>=0 || dicEquipmentVO.getParentID()==null || "".equals(dicEquipmentVO.getParentID())){//只展开树的一级节点，功能优化
			        	sbUser.append("{id:'"+dicEquipmentVO.getDicID()+"',pId:'"+dicEquipmentVO.getParentID()+"',name:'"+dicEquipmentVO.getDicName()+"',open:true,isParent:true},");
			         }else{
			        	sbUser.append("{id:'"+dicEquipmentVO.getDicID()+"',pId:'"+dicEquipmentVO.getParentID()+"',name:'"+dicEquipmentVO.getDicName()+"',open:false},");
			         }
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("获取拓扑结构失败！");
			return null;
		}
		String str = sbUser.substring(0, sbUser.length()-1);
		str += "];";
		logger.info("获取拓扑结构成功！");
		return str;
	}
	/**
	 * 系统管理~~设备配置~~修改节点名称。add by liujf 20140114
	 * @param id
	 * @param name
	 * @return
	 */
	public boolean modifyDicEquipmentName(String id,String name,String level){
		logger.info("BaseDwrMethod	 modifyDicEquipmentName	 begin:"+id+"==="+name);
		DictionaryEquipmentVO dicEquipmentVO = new DictionaryEquipmentVO();
		dicEquipmentVO.setDicID(id);
		dicEquipmentVO.setDicName(name);
		try{
			if(level.equals("2")){
				DictionaryEquipmentVO dVo = ServiceFactory.getDictionaryEquipmentService().queryByID(id);
				EquipmentVO eVo = new EquipmentVO();
				eVo.setEquipmentType(Integer.parseInt(dVo.getParentID()));
				eVo.setEquipmentName(dVo.getDicName());
				ServiceFactory.getDictionaryEquipmentService().modify(dicEquipmentVO);
				ArrayList<EquipmentVO> eList = ServiceFactory.getEquipmentService().queryByTypeAndName(eVo, null);
				if(eList!=null&&eList.size()>0){
					for(EquipmentVO vo:eList){
						vo.setEquipmentName(name);
						vo.setEquipmentType(Integer.parseInt(dVo.getParentID()));
						ServiceFactory.getEquipmentService().modify(vo);
					}
				}
			}else{
				ServiceFactory.getDictionaryEquipmentService().modify(dicEquipmentVO);
			}
		}catch(Exception e){
			logger.error("BaseDwrMethod	 modifyDicEquipmentName	 error:	 "+e.getMessage());
		}
		return true;
	}
	/**
	 * 系统管理~~网络拓扑~~删除节点  add by liujf 20140114
	 * @param id
	 * @return
	 */
	public boolean removeDicEquipmentName(String id){
		logger.info("BaseDwrMethod	removeDicEquipmentName  begin"+id);
		DictionaryEquipmentVO dicEquipmentVO = new DictionaryEquipmentVO();
		dicEquipmentVO.setDicID(id);
		try {
			ArrayList<DictionaryEquipmentVO> list=ServiceFactory.getDictionaryEquipmentService().queryAllchildrenByID(id);
			int childrenSize=list.size();
			//flag=ServiceFactory.getAddressService().ishaveChild(id);
			if(list==null||childrenSize==0){
				dicEquipmentVO.setStatus(0);
				ServiceFactory.getDictionaryEquipmentService().modify(dicEquipmentVO);
			}else{
				for(int i=0;i<list.size();i++){
					DictionaryEquipmentVO dicEquipmentVO_ = new DictionaryEquipmentVO();
					dicEquipmentVO_=(DictionaryEquipmentVO) list.get(i);
					removeDicEquipmentName(dicEquipmentVO_.getDicID());
				}
				dicEquipmentVO.setStatus(0);
				ServiceFactory.getDictionaryEquipmentService().modify(dicEquipmentVO);
			}
		} catch (Exception e) {
			logger.error("BaseDwrMethod  removeDicEquipmentName	  error:	"+e.getMessage());
		}
		return true;
	}
	/**
	 * 系统管理~~网络拓扑~~增加节点  add by liujf 20140114
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public String addDicEquipmentName(String id,String newName) throws Exception{
		logger.info("BaseDwrMethod	addDicEquipmentName	begin"+newName);
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session = ctx.getHttpServletRequest().getSession(); 
		UserVO userVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
		
		DictionaryEquipmentVO dicEquipmentVO_=new DictionaryEquipmentVO();
		//dicEquipmentVO_.setParentID(id);
		//对于z_t_equipment_dictionary表中的dicValue字段。
		ArrayList<DictionaryEquipmentVO> deList = new ArrayList<DictionaryEquipmentVO>();
		deList = ServiceFactory.getDictionaryEquipmentService().query(dicEquipmentVO_, null);
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<deList.size();i++){
			list.add(deList.get(i).getDicValue());
		}
		int dicValue = (new Random().nextInt(10000));
		while(list.contains(dicValue)){
			dicValue = (new Random().nextInt(10000));
		}
		
		DictionaryEquipmentVO dicEquipmentVO=new DictionaryEquipmentVO();
		dicEquipmentVO.setDicID(UtilDAO.getUUid());
		dicEquipmentVO.setUpdateUser(userVO.getUserID());
		dicEquipmentVO.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		dicEquipmentVO.setParentID(id);
		dicEquipmentVO.setDicName(newName);
		dicEquipmentVO.setDicValue(dicValue);
		dicEquipmentVO.setSysValue(DictionaryEnum.sysValue);
		dicEquipmentVO.setStatus(DictionaryEnum.STATUS_VALID);
		try{
			dicEquipmentVO = ServiceFactory.getDictionaryEquipmentService().add(dicEquipmentVO);
		}catch(Exception e){
			logger.error("BaseDwrMethod	addDicEquipmentName	error:	"+e.getMessage());
		}
		return dicEquipmentVO.getDicID();
	}
	
	/**
	 * 系统管理~部门管理~获取部门信息树
	 * @return
	 */
	public String departmentTreeList(){
		List<DepartmentVO> dList = new ArrayList<DepartmentVO>();
		DepartmentVO departmentVO = new DepartmentVO();
		//构造树数据 
		StringBuffer sbUser = new StringBuffer();
		try {
			dList = ServiceFactory.getDepartmentService().query(departmentVO, null);
			sbUser.append("[");
			if(dList!=null && dList.size()>0){
				for(int i=0;i<dList.size();i++){
					departmentVO = dList.get(i);
					if(departmentVO.getParentId().indexOf("-")>=0 || departmentVO.getParentId()==null || "".equals(departmentVO.getParentId())){//只展开树的一级节点，功能优化
			        	sbUser.append("{id:'"+departmentVO.getId()+"',pId:'"+departmentVO.getParentId()+"',name:'"+departmentVO.getTitle()+"',leaf:'"+departmentVO.getLeaf()+"',open:true,isParent:true},");
			         }else{
			        	sbUser.append("{id:'"+departmentVO.getId()+"',pId:'"+departmentVO.getParentId()+"',name:'"+departmentVO.getTitle()+"',leaf:'"+departmentVO.getLeaf()+"',open:false},");
			         }
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("获取区域信息失败！");
			return null;
		}
		String str = sbUser.substring(0, sbUser.length()-1);
		str += "];";
		logger.info("获取区域信息成功！");
		return str;
	}
	/**
	 * 判断是否重名
	 * @param id
	 * @param name
	 * @return
	 */
	public boolean checkDicEquipmentName(String id,String name){
		logger.info("BaseDwrMethod	 checkDicEquipmentName	 begin:"+id+"==="+name);
		boolean isExit=true;
		DictionaryEquipmentVO dicEquipmentVO = new DictionaryEquipmentVO();
		try {
			dicEquipmentVO = ServiceFactory.getDictionaryEquipmentService().queryByID(id);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		dicEquipmentVO.getParentID();
		DictionaryEquipmentVO dicEquipmentVO_ = new DictionaryEquipmentVO();
		dicEquipmentVO_.setParentID(dicEquipmentVO.getParentID());
		ArrayList<DictionaryEquipmentVO> deList = new ArrayList<DictionaryEquipmentVO>();
		try {
			deList = ServiceFactory.getDictionaryEquipmentService().queryByPid(dicEquipmentVO_, null);
			for(int i=0;i<deList.size();i++){
				if(!deList.get(i).getDicID().equals(id)){
					if(!deList.get(i).getDicName().equals(name)){
						continue;
					}else{
						isExit=false;
						break;
					}
				}
				
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error("BaseDwrMethod	addDicEquipmentName	error:	"+e1.getMessage());
		}
		return isExit;
	}
}
