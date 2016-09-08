package com.zzst.action.meeting.level;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cbf.web.util.PageSplittor;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.model.enums.BaseInfoEnum;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.auth.FuncVO;
import com.zzst.model.meeting.config.BaseInfoVO;
import com.zzst.model.meeting.level.LevelVO;
import com.zzst.model.meeting.levelConfig.LevelConfigVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.service.meeting.levelConfig.LevelConfigService;
import com.zzst.service.meeting.levelConfig.LevelConfigServiceImpl;

public class LevelConfigAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(LevelConfigAction.class.getName());
	private LevelVO levelVO = new LevelVO();
	private List<LevelVO> levelList = new ArrayList<LevelVO>();
	private LevelConfigVO levelConfigVO = new LevelConfigVO();
	private List<LevelConfigVO> levelConfigList = new ArrayList<LevelConfigVO>();
	public static final String styleBackColor = "#fff";
	
	private FuncVO funcVO = new FuncVO();
	
	private List<FuncVO> fcList = new ArrayList<FuncVO>();
	
	private String level_pId;
	
	
	public String getLevel_pId() {
		return level_pId;
	}

	public void setLevel_pId(String levelPId) {
		level_pId = levelPId;
	}

	/**
	 * 分级配置列表。
	 * @return
	 */
	public String levelConfigList(){
		logger.info("LevelConfigAction	levelConfigList	begin");
		try {
			level_pId = request.getParameter("parentId");
			UserVO userVO = (UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			fcList = ServiceFactory.getFuncService().getFuncList(userVO, null);
			if(fcList!=null&&fcList.size()>0){
				for(int i=0;i<fcList.size();i++){
					for(FuncVO vo:fcList){
						vo = fcList.get(i);
						if("8a8690153947d1f4013947d4325e9915".equals(vo.getFunc_id())){
							return "z_t_user";
						}else if("8a8690153947d1f4013947d4325e9916".equals(vo.getFunc_id())){
							return "z_t_meetingroom";
						}
					}
				}
			}
			logger.info("LevelConfigAction	levelConfigList	end");
		} catch (Exception e) {
			logger.error("LevelConfigAction	levelConfigList	error:"+e.getMessage());
			return ERROR;
		}
		this.request.setAttribute("failure_message","没有分级配置的基础数据！");
		return "failure_meeting";
	}
	
	public String userLevelList(){
		logger.info("LevelConfigAction	userLevelList 	begin");
		try {
			level_pId = request.getParameter("parentId");
			if(level_pId==""||level_pId==null){
				level_pId = request.getParameter("level_pId");
			}
			request.setAttribute("level_pId", level_pId);
			BaseInfoVO baseInfoVO = new BaseInfoVO();
			baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_LEVLEL);
			try {
				ArrayList<BaseInfoVO> baseInfoList = ServiceFactory.getBaseInfoService().query(baseInfoVO, null);
				request.setAttribute("baseInfoList", baseInfoList);
				
				String levelName = levelConfigVO.getDescription();
				levelConfigVO.setLevelType(LevelEnum.LEVEL_USER);
				levelVO.setLevelID(levelConfigVO.getLevelID());
				levelConfigVO.setDescription(null);
				if(levelConfigVO.getLevelKey()==null||levelConfigVO.getLevelKey()==""){
				levelConfigList = ServiceFactory.getLevelConfigService().queryWithType(levelConfigVO, null);
				levelVO.setPId(level_pId);
				levelList = ServiceFactory.getLevelService().queryByPid(levelVO, null);
				levelConfigVO.setDescription(levelName);
				for(int j=0;j<levelList.size();j++){
					StringBuffer sb = new StringBuffer();
					StringBuffer sb_super = new StringBuffer();
					for(LevelConfigVO vo:levelConfigList){
						if(vo.getSuperPower()==LevelEnum.LEVELCONFIG_SUPERPOWER){
							if(levelList.get(j).getLevelID().equals(vo.getLevelID())){
								sb_super.append(vo.getLevelKeyName()+",");
							}
						}
						if(vo.getSuperPower()==LevelEnum.LEVELCONFIG_SUPERPOWER_CLOSE){
							if(levelList.get(j).getLevelID().equals(vo.getLevelID())){
								sb.append(vo.getLevelKeyName()+",");
							}
						}
					}
					if(sb_super.length()>0){
						levelList.get(j).setLevelKeyNames1(sb_super.substring(0,sb_super.length()-1));
					}
					if(sb.length()>0){
						levelList.get(j).setLevelKeyNames2(sb.substring(0,sb.length()-1));
					}
				}
				}else{//“查询”按钮功能的实现
					levelConfigList = ServiceFactory.getLevelConfigService().queryWithType(levelConfigVO, null);
					levelVO.setPId(level_pId);
					levelList = ServiceFactory.getLevelService().queryByPid(levelVO, null);
					levelConfigVO.setDescription(levelName);
					for(int j=0;j<levelList.size();j++){
						StringBuffer sb = new StringBuffer();
						StringBuffer sb_super = new StringBuffer();
						for(LevelConfigVO vo:levelConfigList){
							if(vo.getSuperPower()==LevelEnum.LEVELCONFIG_SUPERPOWER){
								if(levelList.get(j).getLevelID().equals(vo.getLevelID())){
									sb_super.append(vo.getLevelKeyName()+",");
								}
							}
							if(vo.getSuperPower()==LevelEnum.LEVELCONFIG_SUPERPOWER_CLOSE){
								if(levelList.get(j).getLevelID().equals(vo.getLevelID())){
									sb.append(vo.getLevelKeyName()+",");
								}
							}
						}
						if(sb_super.length()>0){
							levelList.get(j).setLevelKeyNames1(sb_super.substring(0,sb_super.length()-1));
						}
						if(sb.length()>0){
							levelList.get(j).setLevelKeyNames2(sb.substring(0,sb.length()-1));
						}
					}
					//点击“查询”按钮只查询出用户所属分级的信息。
					List<LevelVO> levelList1 = new ArrayList<LevelVO>();
					for(int i=0;i<levelList.size();i++){
						if(levelList.get(i).getLevelKeyNames1()==null&&levelList.get(i).getLevelKeyNames2()==null){
							levelList1.add(levelList.get(i));
						}
					}
					levelList.removeAll(levelList1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("style1", styleBackColor);
		} catch (Exception e) {
			logger.error("LevelConfigAction	userLevelList	 error:"+e.getMessage());
			return ERROR;
		}
		logger.info("LevelConfigAction	userLevelList	end");
		return SUCCESS;
	}
	/**
	 * 查看详细用户分级配置信息
	 * @return
	 */
	public String userLevelDetail(){
		logger.info("LevelConfigAction	userLevelDetail 	begin");
		try {
			try {
				levelConfigVO.setLevelType(LevelEnum.LEVEL_USER);
				levelConfigVO.setLevelID(levelVO.getLevelID());
				levelConfigList = ServiceFactory.getLevelConfigService().queryWithType(levelConfigVO, null);
				levelList = ServiceFactory.getLevelService().query(levelVO, null);
				StringBuffer sb = new StringBuffer();
				StringBuffer sb_super = new StringBuffer();
				if(levelList!=null&&levelList.size()>0){
					levelVO = levelList.get(0);
					if(levelConfigList!=null&&levelConfigList.size()>0){
						for(LevelConfigVO vo:levelConfigList){
							if(vo.getSuperPower()==LevelEnum.LEVELCONFIG_SUPERPOWER){
								sb_super.append(vo.getLevelKeyName()+",");
							}
							if(vo.getSuperPower()==LevelEnum.LEVELCONFIG_SUPERPOWER_CLOSE){
								sb.append(vo.getLevelKeyName()+",");
							}
						}
						if(sb_super.length()>0){
							levelVO.setLevelKeyNames1(sb_super.substring(0,sb_super.length()-1));
						}
						if(sb.length()>0){
							levelVO.setLevelKeyNames2(sb.substring(0,sb.length()-1));
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			logger.error("LevelConfigAction	userLevelDetail	 error:"+e.getMessage());
			return ERROR;
		}
		logger.info("LevelConfigAction	userLevelDetail	end");
		return SUCCESS;
	}
	
	/**
	 * 修改用户分级配置信息前
	 * @return
	 */
	public String userLevelModifyBefore(){
		logger.info("LevelConfigAction	userLevelModifyBefore 	begin");
		try {
			level_pId = request.getParameter("level_pId");
			request.setAttribute("level_pId", level_pId);
			Object pUserVO = request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			UserVO userVO = (UserVO)pUserVO;
			if(MeetingAppConfig.LEVEL_IS_POEN){
				if(userVO.getLvoids()!=null){
					if(userVO.getLvoids().contains("'"+levelVO.getLevelID()+"'")){
						request.setAttribute("power", "hasPower");
					}else{
						request.setAttribute("power", "noPower");
					}
				}
			}else{
				request.setAttribute("power", "LEVEL_IS_CLOSE");
			}
			levelConfigVO.setLevelType(LevelEnum.LEVEL_USER);
			levelConfigVO.setLevelID(levelVO.getLevelID());
			levelConfigList = ServiceFactory.getLevelConfigService().queryWithType(levelConfigVO, null);
			levelList = ServiceFactory.getLevelService().query(levelVO, null);
			StringBuffer sb = new StringBuffer();
			StringBuffer sb_super = new StringBuffer();
			StringBuffer sbId = new StringBuffer();
			StringBuffer sbId_super = new StringBuffer();
			if(levelList!=null&&levelList.size()>0){
				levelVO = levelList.get(0);
				if(levelConfigList!=null&&levelConfigList.size()>0){
					for(LevelConfigVO vo:levelConfigList){
						if(vo.getSuperPower()==LevelEnum.LEVELCONFIG_SUPERPOWER){
							sb_super.append(vo.getLevelKeyName()+",");
							sbId_super.append(vo.getLevelKey()+",");
						}
						if(vo.getSuperPower()==LevelEnum.LEVELCONFIG_SUPERPOWER_CLOSE){
							sb.append(vo.getLevelKeyName()+",");
							sbId.append(vo.getLevelKey()+",");
						}
					}
					if(sb_super.length()>0){
						levelVO.setLevelKeyNames1(sb_super.substring(0,sb_super.length()-1));
						levelVO.setLevelKeyIds1(sbId_super.substring(0,sbId_super.length()-1));
					}
					if(sb.length()>0){
						levelVO.setLevelKeyNames2(sb.substring(0,sb.length()-1));
						levelVO.setLevelKeyIds2(sbId.substring(0,sbId.length()-1));
					}
				}
			}
		} catch (Exception e) {
			logger.error("LevelConfigAction	userLevelModifyBefore	 error:"+e.getMessage());
			return ERROR;
		}
		logger.info("LevelConfigAction	userLevelModifyBefore	end");
		return SUCCESS;
	}
	
	/**
	 * 修改用户分级配置
	 * @return
	 */
	public String userLevelModify(){
		logger.info("LevelConfigAction	userLevelModify 	begin");
		
		level_pId = request.getParameter("level_pId");
		request.setAttribute("level_pId", level_pId);
		if("".equals(levelConfigVO.getLevelKey())&&"".equals(levelConfigVO.getDescription())){
			return SUCCESS;
		}
		LevelConfigService lcService = ServiceFactory.getLevelConfigService();
		String levelKey = levelConfigVO.getLevelKey();
		//删除分级下的用户
		try {
			levelConfigVO.setLevelKey(null);
			lcService.delLevelVO(levelConfigVO, null);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		//重新增加分级下的用户
		String levelKey_super = levelConfigVO.getDescription();
		String[] levelKeys_super = levelKey_super.split(",");
		String[] levelKeys = levelKey.split(",");
		try {
			Object pUserVO = request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			UserVO userVO = (UserVO)pUserVO;
			levelConfigVO.setStatus(LevelEnum.STATUS_LEVELCONFIG_VALID);
			levelConfigVO.setCreateUserId(userVO.getUserID());
			levelConfigVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			for(String str:levelKeys_super){
				if(str!=null&&!"".equals(str)){
					levelConfigVO.setLevelKey(str);
					levelConfigVO.setSuperPower(LevelEnum.LEVELCONFIG_SUPERPOWER);
					lcService.add(levelConfigVO);
				}
			}
			for(String str:levelKeys){
				if(str!=null&&!"".equals(str)){
					levelConfigVO.setLevelKey(str);
					levelConfigVO.setSuperPower(LevelEnum.LEVELCONFIG_SUPERPOWER_CLOSE);
					lcService.add(levelConfigVO);
				}
			}
		} catch (Exception e) {
			logger.error("LevelConfigAction	levelConfigAdd	 error:"+e.getMessage());
			e.printStackTrace();
		}
		logger.info("LevelConfigAction	userLevelModify	end");
		return SUCCESS;
	}
	
	/**
	 * 获取会议室级别列表
	 * @return
	 */
	public String roomLevelList(){
		logger.info("LevelConfigAction	roomLevelList 	begin");
		try {
			level_pId = request.getParameter("parentId");
			if(level_pId==""||level_pId==null){
				level_pId = request.getParameter("level_pId");
			}
			request.setAttribute("level_pId", level_pId);
			BaseInfoVO baseInfoVO = new BaseInfoVO();
			
			baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_LEVLEL);
			try {
				ArrayList<BaseInfoVO> baseInfoList = ServiceFactory.getBaseInfoService().query(baseInfoVO, null);
				request.setAttribute("baseInfoList", baseInfoList);
				
				String levelName = levelConfigVO.getDescription();
				levelConfigVO.setLevelType(LevelEnum.LEVEL_ROOM);
				levelConfigVO.setDescription(null);
				levelVO.setLevelID(levelConfigVO.getLevelID());
				if(levelConfigVO.getLevelKey()==null||levelConfigVO.getLevelKey()==""){
				levelConfigList = ServiceFactory.getLevelConfigService().queryWithType(levelConfigVO, null);
				levelVO.setPId(level_pId);
				levelList = ServiceFactory.getLevelService().queryByPid(levelVO, null);
				levelConfigVO.setDescription(levelName);
				for(int j=0;j<levelList.size();j++){
					StringBuffer sb = new StringBuffer();
					for(LevelConfigVO vo:levelConfigList){
						if(levelList.get(j).getLevelID().equals(vo.getLevelID())){
							sb.append(vo.getLevelKeyName()+",");
							//levelConfigList.remove(vo);
						}
					}
					if(sb.length()>0){
						levelList.get(j).setLevelKeyNames1(sb.toString().substring(0,sb.length()-1));
					}
				}
				}else{//"查询"按钮功能的实现
					levelConfigList = ServiceFactory.getLevelConfigService().queryWithType(levelConfigVO, null);
					levelVO.setPId(level_pId);
					levelList = ServiceFactory.getLevelService().queryByPid(levelVO, null);
					levelConfigVO.setDescription(levelName);
					for(int j=0;j<levelList.size();j++){
						StringBuffer sb = new StringBuffer();
						for(LevelConfigVO vo:levelConfigList){
							if(levelList.get(j).getLevelID().equals(vo.getLevelID())){
								sb.append(vo.getLevelKeyName()+",");
								//levelConfigList.remove(vo);
							}
						}
						if(sb.length()>0){
							levelList.get(j).setLevelKeyNames1(sb.toString().substring(0,sb.length()-1));
						}
					}
					//点击“查询”按钮只查询出用户所属分级的信息。
					List<LevelVO> levelList1 = new ArrayList<LevelVO>();
					for(int i=0;i<levelList.size();i++){
						if(levelList.get(i).getLevelKeyNames1()==null&&levelList.get(i).getLevelKeyNames2()==null){
							levelList1.add(levelList.get(i));
						}
					}
					levelList.removeAll(levelList1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("style2", styleBackColor);
		} catch (Exception e) {
			logger.error("LevelConfigAction	roomLevelList	 error:"+e.getMessage());
			return ERROR;
		}
		logger.info("LevelConfigAction	roomLevelList	end");
		return SUCCESS;
	}
	/**
	 * 查看会议室分级配置的详细信息
	 * @return
	 */
	public String roomLevelDetail(){
		logger.info("LevelConfigAction	roomLevelDetail 	begin");
		try {
			BaseInfoVO baseInfoVO = new BaseInfoVO();
			LevelConfigVO levelConfigVO = new LevelConfigVO();
			
			baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_LEVLEL);
			PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
			try {
				ArrayList<BaseInfoVO> baseInfoList = ServiceFactory.getBaseInfoService().query(baseInfoVO, null);
				request.setAttribute("baseInfoList", baseInfoList);
				
				String levelName = levelConfigVO.getDescription();
				levelConfigVO.setLevelType(LevelEnum.LEVEL_ROOM);
				levelConfigList = ServiceFactory.getLevelConfigService().queryWithType(levelConfigVO, pSplittor.getPControler());
				levelList = ServiceFactory.getLevelService().query(levelVO, null);
				levelConfigVO.setDescription(levelName);
				for(int j=0;j<levelList.size();j++){
					StringBuffer sb = new StringBuffer();
					for(LevelConfigVO vo:levelConfigList){
						if(levelList.get(j).getLevelID().equals(vo.getLevelID())){
							sb.append(vo.getLevelKeyName()+",");
						}
					}
					if(sb.length()>0){
						levelList.get(j).setDescription(sb.toString().substring(0,sb.length()-1));
					}
				}
				if(levelList!=null&&levelList.size()>0){
					levelVO = levelList.get(0);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("style2", styleBackColor);
		} catch (Exception e) {
			logger.error("LevelConfigAction	roomLevelDetail	 error:"+e.getMessage());
			return ERROR;
		}
		logger.info("LevelConfigAction	roomLevelDetail	end");
		return SUCCESS;
	}
	/**
	 * 分级配置~~会议室分级配置信息修改前
	 * @return
	 */
	public String roomLevelModifyBefore(){
		logger.info("LevelConfigAction	roomLevelModifyBefore 	begin");
		try {
			level_pId = request.getParameter("level_pId");
			request.setAttribute("level_pId", level_pId);
			
			Object pUserVO = request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			UserVO userVO = (UserVO)pUserVO;
			if(MeetingAppConfig.LEVEL_IS_POEN){
				if(userVO.getLvoids()!=null){
					if(userVO.getLvoids().contains("'"+levelVO.getLevelID()+"'")){
						request.setAttribute("power", "hasPower");
					}else{
						request.setAttribute("power", "noPower");
					}
				}
			}else{
				request.setAttribute("power", "LEVEL_IS_CLOSE");
			}
			levelConfigVO.setLevelType(LevelEnum.LEVEL_ROOM);
			levelConfigList = ServiceFactory.getLevelConfigService().queryWithType(levelConfigVO, null);
			levelList = ServiceFactory.getLevelService().query(levelVO, null);
			for(int j=0;j<levelList.size();j++){
				levelVO = levelList.get(0);
				StringBuffer sb = new StringBuffer();
				StringBuffer sbIds = new StringBuffer();
				for(LevelConfigVO vo:levelConfigList){
					if(levelVO.getLevelID().equals(vo.getLevelID())){
						sb.append(vo.getLevelKeyName()+",");
						sbIds.append(vo.getLevelKey()+",");
					}
				}
				if(sb.length()>0){
					levelVO.setLevelKeyNames1(sb.toString().substring(0,sb.length()-1));
					levelVO.setLevelKeyIds1(sbIds.toString().substring(0,sbIds.length()-1));
				}
			}
		} catch (Exception e) {
			logger.error("LevelConfigAction	roomLevelModifyBefore	 error:"+e.getMessage());
			return ERROR;
		}
		logger.info("LevelConfigAction	roomLevelModifyBefore	end");
		return SUCCESS;
	}
	/**
	 * 分级配置~~会议室配置~~修改会议室配置信息
	 * @return
	 */
	public String roomLevelModify(){
		logger.info("LevelConfigAction	roomLevelModify 	begin");
		level_pId = request.getParameter("level_pId");
		request.setAttribute("level_pId", level_pId);
		//删除分级下的所有会议室信息
		LevelConfigService lcService = new LevelConfigServiceImpl();
		String levelKey = levelConfigVO.getLevelKey();
		try {
			levelConfigVO.setLevelKey(null);
			lcService.delLevelVO(levelConfigVO, null);
		} catch (Exception e1) {
			e1.printStackTrace();
		
		}
		//重新增加分级下的会议室
		
		String[] levelKeys = levelKey.split(",");
		try {
			Object pUserVO = request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			UserVO userVO = (UserVO)pUserVO;
			levelConfigVO.setSuperPower(0);
			levelConfigVO.setStatus(LevelEnum.STATUS_LEVELCONFIG_VALID);
			levelConfigVO.setCreateUserId(userVO.getUserID());
			levelConfigVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			for(String str:levelKeys){
				if(str!=null&&!"".equals(str)){
					levelConfigVO.setLevelKey(str);
					lcService.add(levelConfigVO);
				}
			}
		} catch (Exception e) {
			logger.error("LevelConfigAction	roomLevelModify	 error:"+e.getMessage());
			e.printStackTrace();
		}
		logger.info("LevelConfigAction	roomLevelModify	end");
		return SUCCESS;
	}
	
	/**
	 * 分级配置增加
	 * @return
	 */
	public String levelConfigAdd(){
		logger.info("LevelConfigAction	levelConfigAdd 	begin");
		LevelConfigService lcService = ServiceFactory.getLevelConfigService();
		String levelKey_super = levelConfigVO.getDescription();
		String[] levelKeys_super = levelKey_super.split(",");
		String levelKey = levelConfigVO.getLevelKey();
		String[] levelKeys = levelKey.split(",");
		String returnStr = "failure_meeting";
		
		if(LevelEnum.LEVEL_USER.equals(levelConfigVO.getLevelType())){
			returnStr = LevelEnum.LEVEL_USER;
		}else if(LevelEnum.LEVEL_ROOM.equals(levelConfigVO.getLevelType())){
			returnStr = LevelEnum.LEVEL_ROOM;
		}else{
			this.request.setAttribute("failure_message","没有分级配置的基础数据！");
			logger.info("LevelConfigAction	levelConfigAdd	end");
			return returnStr;
		}
		try {
			Object pUserVO = request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			UserVO userVO = (UserVO)pUserVO;
			levelConfigVO.setStatus(LevelEnum.STATUS_LEVELCONFIG_VALID);
			levelConfigVO.setCreateUserId(userVO.getUserID());
			levelConfigVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			levelConfigVO.setSuperPower(LevelEnum.LEVELCONFIG_SUPERPOWER);//默认向下兼容
			for(String str:levelKeys_super){
				if(str!=null&&!"".equals(str)){
					levelConfigVO.setLevelKey(str);
					levelConfigVO.setSuperPower(LevelEnum.LEVELCONFIG_SUPERPOWER);
					lcService.add(levelConfigVO);
				}
			}
			for(String str:levelKeys){
				if(str!=null&&!"".equals(str)){
					levelConfigVO.setLevelKey(str);
					levelConfigVO.setSuperPower(LevelEnum.LEVELCONFIG_SUPERPOWER_CLOSE);
					lcService.add(levelConfigVO);
				}
			}
		} catch (Exception e) {
			this.request.setAttribute("failure_message","添加分级配置失败！");
			returnStr = "failure_meeting";
			logger.error("LevelConfigAction	levelConfigAdd	 error:"+e.getMessage());
			e.printStackTrace();
		}
		logger.info("LevelConfigAction	levelConfigAdd	end");
		return returnStr+"";
	}
	
	/**
	 * 删除分级配置
	 * @return
	 */
	public String levelConfigDel(){
		logger.info("LevelConfigAction	levelConfigDel 	begin");
		level_pId = request.getParameter("level_pId");
		request.setAttribute("level_pId", level_pId);
		LevelConfigService lcService = ServiceFactory.getLevelConfigService();
		String returnStr = "failure_meeting";
		
		if(LevelEnum.LEVEL_USER.equals(levelConfigVO.getLevelType())){
			returnStr = LevelEnum.LEVEL_USER;
		}else if(LevelEnum.LEVEL_ROOM.equals(levelConfigVO.getLevelType())){
			returnStr = LevelEnum.LEVEL_ROOM;
		}else{
			this.request.setAttribute("failure_message","没有分级配置的基础数据！");
			logger.info("LevelConfigAction	levelConfigDel	end");
			return returnStr;
		}
		try {
			levelConfigVO.setStatus(LevelEnum.STATUS_LEVELCONFIG_VALID);
			lcService.delLevelVO(levelConfigVO, null);
		} catch (Exception e) {
			this.request.setAttribute("failure_message","删除分级配置失败！");
			returnStr = "failure_meeting";
			logger.error("LevelConfigAction	levelConfigDel	 error:"+e.getMessage());
			e.printStackTrace();
		}
		logger.info("LevelConfigAction	levelConfigDel	end");
		return returnStr+"";
	}
	
	public static String levelConfigDefaultAdd(LevelConfigVO levelConfigVO){//默认分级配置的添加
		if(MeetingAppConfig.LEVEL_IS_POEN){
			logger.info("LevelConfigAction	levelConfigDefaultAdd 	begin");
			try {
				if(levelConfigVO.getLevelID()==null||"".equals(levelConfigVO.getLevelID())||levelConfigVO.getLevelType()==null||"".equals(levelConfigVO.getLevelType())||levelConfigVO.getLevelType()==null||"".endsWith(levelConfigVO.getLevelType())){
					return null;//levelId，levelKey,levelType必填
				}
				if(levelConfigVO.getStatus()==Integer.MIN_VALUE){
					levelConfigVO.setStatus(LevelEnum.STATUS_LEVEL_VALID);
				}
				if(levelConfigVO.getCreateTime()==null){
					levelConfigVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
				}
				if(levelConfigVO.getSuperPower()==Integer.MIN_VALUE){
					levelConfigVO.setSuperPower(LevelEnum.LEVELCONFIG_SUPERPOWER);
				}
				ServiceFactory.getLevelConfigService().add(levelConfigVO);
			} catch (Exception e) {
				logger.error("LevelConfigAction	levelConfigDefaultAdd	 error:"+e.getMessage());
				e.printStackTrace();
			}
			logger.info("LevelConfigAction	levelConfigDefaultAdd 	end");
		}
		return null;
	}
	
	/**
	 * 分级配置~~会议室分级配置信息修改前
	 * @return
	 */
	public String beforeModifyNode(){
		logger.info("LevelConfigAction	beforeModifyNode 	begin");
		try {
			levelList = ServiceFactory.getLevelService().query(levelVO, null);
			if(levelList!=null && levelList.size()>0){
				levelVO = levelList.get(0);
			}
			Object pUserVO = request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			UserVO userVO = (UserVO)pUserVO;
			if(MeetingAppConfig.LEVEL_IS_POEN){
				if(userVO.getLvoids()!=null){
					if(userVO.getLvoids().contains("'"+levelVO.getLevelID()+"'")){
						request.setAttribute("power", "hasPower");
					}else{
						request.setAttribute("power", "noPower");
					}
				}
			}else{
				request.setAttribute("power", "LEVEL_IS_CLOSE");
			}
		} catch (Exception e) {
			logger.error("LevelConfigAction	beforeModifyNode	 error:"+e.getMessage());
			return ERROR;
		}
		logger.info("LevelConfigAction	beforeModifyNode	end");
		return SUCCESS;
	}
	
	public LevelConfigVO getLevelConfigVO() {
		return levelConfigVO;
	}

	public void setLevelConfigVO(LevelConfigVO levelConfigVO) {
		this.levelConfigVO = levelConfigVO;
	}

	public List<LevelConfigVO> getLevelConfigList() {
		return levelConfigList;
	}

	public void setLevelConfigList(List<LevelConfigVO> levelConfigList) {
		this.levelConfigList = levelConfigList;
	}

	public LevelVO getLevelVO() {
		return levelVO;
	}

	public void setLevelVO(LevelVO levelVO) {
		this.levelVO = levelVO;
	}

	public List<LevelVO> getLevelList() {
		return levelList;
	}

	public void setLevelList(List<LevelVO> levelList) {
		this.levelList = levelList;
	}
	
}
