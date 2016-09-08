package com.zzst.action.meeting.equipmentControl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.meeting.GeneralMeetingAction;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.centerContor.service.CenterControlObject;
import com.zzst.centerContor.vo.AudioControlVO;
import com.zzst.centerContor.vo.CameraVO;
import com.zzst.centerContor.vo.CurtainVO;
import com.zzst.centerContor.vo.LightVO;
import com.zzst.centerContor.vo.MatrixSwitchVO;
import com.zzst.centerContor.vo.PlaVO;
import com.zzst.centerContor.vo.ProjVO;
import com.zzst.centerContor.vo.RoomModelVO;
import com.zzst.centerContor.vo.SysPowerVO;
import com.zzst.centerContor.vo.UpDownScreenVO;
import com.zzst.centerContor.vo.VideomVO;
import com.zzst.centerContor.vo.ViewScreentVO;
import com.zzst.meeting.dwr.DwrMethod;
import com.zzst.model.enums.BaseInfoEnum;
import com.zzst.model.enums.CenterControlEnum;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.address.AddressVO;
import com.zzst.model.meeting.config.BaseInfoVO;
import com.zzst.model.meeting.equipment.EquipmentCameraVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.terminal.service.TerminalObject;
import com.zzst.util.ControlFactory;
import com.zzst.util.ExcuteResultVO;
import com.zzst.util.tools.export.ExportFileObject;
import com.zzst.util.tools.export.ExportObjectHelp;
import com.zzst.util.tools.export.ecxel.CellVO;

/**
 *@Description
 *@date 2011-12-14下午03:51:04
 *@author ryan
 */
public class EquipmentControlAction extends CjfAction {
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger
			.getLogger(GeneralMeetingAction.class.getName());

	private ArrayList<MeetingRoomVO> roomList = new ArrayList<MeetingRoomVO>();
	private MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
	private EquipmentVO equipmentVO = new EquipmentVO();
	private ArrayList<EquipmentVO> equipmentList = new ArrayList<EquipmentVO>();
	private MatrixSwitchVO matrixSwitchVO = new MatrixSwitchVO();
	private ViewScreentVO viewScreentVO = new ViewScreentVO();
	private CameraVO cameraVO = new CameraVO();
	private VideomVO videomVO = new VideomVO();
	private String matrixid;
	private InputStream  excelStream;
	private EquipmentCameraVO equipmentCameraVO;
	private String powerStatus;
	private String ztreeDate;//终端树数据
	private RoomModelVO roomModelVO = new RoomModelVO();
	private SysPowerVO sysPowerVO = new SysPowerVO();
	
	public String fixedTimeBefore() {
		logger.info("EquipmentControlAction		fixedTimeBefore	begin");
		try {
			//电源状态涉及哪几类：如：screent_view,sysPower,
			if(powerStatus!=null&&powerStatus.length()>0){
				powerStatus = powerStatus.substring(0,powerStatus.length()-1);
			}else{
				powerStatus = CenterControlEnum.type_sysPower_id;
			}
			// 查询有中控设备的会议室
			equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
			ArrayList<EquipmentVO> lst = ServiceFactory.getEquipmentService().query(
					equipmentVO, getPageControler());
			
			if (lst != null && lst.size() > 0) {
				for (int i = 0; i < lst.size(); i++) {
					EquipmentVO eVO =  lst.get(i);
					BaseInfoVO infoVO = new BaseInfoVO();
					 infoVO.setInfoType(BaseInfoEnum.TYPE_FIXEDTIME);
					 infoVO.setInfoName(eVO.getIp());
					ArrayList<BaseInfoVO> list = ServiceFactory.getBaseInfoService().query(infoVO, null);
					eVO.setPort(EquipmentEnum.STATUS_INVALID);
					eVO.setStatus(EquipmentEnum.STATUS_INVALID);
					if(list==null||list.size()==0){
						equipmentList.add(eVO);
						this.getCurHttpServletRequest().setAttribute("ccVO", eVO);
						continue;
					}
					for(BaseInfoVO vo : list){
						if(vo.getInfoValue().equalsIgnoreCase("on")){//定时开
							eVO.setStatus(EquipmentEnum.STATUS_VALID);
							/**
							 * add by xiongshun 20130227 15:25
							 * 从z_t_baseinfo表中取出description字段，也就是存入的中控的定时开机时间，
							 * 然后传值给页面，使得页面刷新后依然可以看到定时开机的设置，
							 * 避免设置过定时开关机后，但是用户仍然不知道的情况发生
							 */
							String[] str = vo.getDescription().split("-");
							if(str.length>=2){
								eVO.setMac(str[0]);
								eVO.setDescription(str[1]);
							}
							////////////
						}
						if(vo.getInfoValue().equalsIgnoreCase("off")){//定时关
							eVO.setPort(EquipmentEnum.STATUS_VALID);
							/**
							 * add by xiongshun 20130227 15:25
							 * 从z_t_baseinfo表中取出description字段，也就是存入的中控的定时关机时间，
							 * 然后传值给页面，使得页面刷新后依然可以看到定时关机的设置，
							 * 避免设置过定时关机后，但是用户仍然不知道的情况发生
							 */
							String[] str = vo.getDescription().split("-");
							if(str.length>=2){
								eVO.setEquipmentNO(str[0]);
								eVO.setEquipmentModel(str[1]);
							}
							//////////
						}
					}
					equipmentList.add(eVO);
					this.getCurHttpServletRequest().setAttribute("ccVO", eVO);
				}
			}
		} catch (Exception e) {
			logger.error("EquipmentControlAction		fixedTimeBefore	error："
					+ e.getMessage());
			return "FAILURE";
		}
		logger.info("EquipmentControlAction		fixedTimeBefore	end");
		return "SUCCESS";
	}
	
	public String fixedTimeBeforeNew() {
		logger.info("EquipmentControlAction		fixedTimeBeforeNew	begin");
		try {
//			电源状态涉及哪几类：如：screent_view,sysPower,
			if(powerStatus!=null&&powerStatus.length()>0){
				powerStatus = powerStatus.substring(0,powerStatus.length()-1);
			}else{
				powerStatus = CenterControlEnum.type_sysPower_id;
			}
			
			
			//查询有中控设备的会议室
			EquipmentVO oldEquipmentVO = new EquipmentVO();
			oldEquipmentVO
					.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
			equipmentList = ServiceFactory.getEquipmentService().query(
					oldEquipmentVO, null);
			if (equipmentList != null && equipmentList.size() > 0) {
				if (equipmentVO.getIp() != null) {
					for (EquipmentVO equipVO : equipmentList) {
						if (equipVO.getIp().equals(equipmentVO.getIp())) {
							equipmentVO = equipVO;
							break;
						}
					}
				} else {
					equipmentVO = equipmentList.get(0);
				}

				if (equipmentVO.getIp() != null) {
					CenterControlObject obj = (CenterControlObject) ControlFactory
							.getCenterControlObject(equipmentVO.getIp());
					ArrayList<SysPowerVO> splist = obj.getSysPowerList();
					if (splist != null && splist.size() > 0) {
						if (sysPowerVO.getId() != null) {
							for (SysPowerVO sVO : splist) {
								if (sVO.getId().equals(sysPowerVO.getId())) {
									
									EquipmentVO eVO =  equipmentVO;
									BaseInfoVO infoVO = new BaseInfoVO();
									 infoVO.setInfoType(BaseInfoEnum.TYPE_FIXEDTIME);
									 infoVO.setInfoName(eVO.getIp());
									ArrayList<BaseInfoVO> list = ServiceFactory.getBaseInfoService().query(infoVO, null);
									eVO.setPort(EquipmentEnum.STATUS_INVALID);
									eVO.setStatus(EquipmentEnum.STATUS_INVALID);
//									eVO.setEquipmentName(sVO.getName());
									if(list==null||list.size()==0){
										equipmentList.add(eVO);
										this.getCurHttpServletRequest().setAttribute("ccVO", eVO);
										continue;
									}
									if(sysPowerVO.getId().equals(splist.get(0).getId())){
										
									
									for(BaseInfoVO vo : list){
										if(vo.getInfoValue().equalsIgnoreCase("on")){//定时开
											eVO.setStatus(EquipmentEnum.STATUS_VALID);
											/**
											 * add by xiongshun 20130227 15:25
											 * 从z_t_baseinfo表中取出description字段，也就是存入的中控的定时开机时间，
											 * 然后传值给页面，使得页面刷新后依然可以看到定时开机的设置，
											 * 避免设置过定时开关机后，但是用户仍然不知道的情况发生
											 */
											String[] str = vo.getDescription().split("-");
											if(str.length>=2){
												eVO.setMac(str[0]);
												eVO.setDescription(str[1]);
											}
											////////////
										}
										if(vo.getInfoValue().equalsIgnoreCase("off")){//定时关
											eVO.setPort(EquipmentEnum.STATUS_VALID);
											/**
											 * add by xiongshun 20130227 15:25
											 * 从z_t_baseinfo表中取出description字段，也就是存入的中控的定时关机时间，
											 * 然后传值给页面，使得页面刷新后依然可以看到定时关机的设置，
											 * 避免设置过定时关机后，但是用户仍然不知道的情况发生
											 */
											String[] str = vo.getDescription().split("-");
											if(str.length>=2){
												eVO.setEquipmentNO(str[0]);
												eVO.setEquipmentModel(str[1]);
											}
											//////////
										}
									}
									}
									sysPowerVO = sVO;
									this.getCurHttpServletRequest().setAttribute("ccVO", eVO);
									break;
								}
							}
						} else {
							EquipmentVO eVO =  equipmentVO;
							BaseInfoVO infoVO = new BaseInfoVO();
							 infoVO.setInfoType(BaseInfoEnum.TYPE_FIXEDTIME);
							 infoVO.setInfoName(eVO.getIp());
							ArrayList<BaseInfoVO> list = ServiceFactory.getBaseInfoService().query(infoVO, null);
							eVO.setPort(EquipmentEnum.STATUS_INVALID);
							eVO.setStatus(EquipmentEnum.STATUS_INVALID);
							if(list==null||list.size()==0){
								equipmentList.add(eVO);
								this.getCurHttpServletRequest().setAttribute("ccVO", eVO);
							}
							for(BaseInfoVO vo : list){
								if(vo.getInfoValue().equalsIgnoreCase("on")){//定时开
									eVO.setStatus(EquipmentEnum.STATUS_VALID);
									/**
									 * add by xiongshun 20130227 15:25
									 * 从z_t_baseinfo表中取出description字段，也就是存入的中控的定时开机时间，
									 * 然后传值给页面，使得页面刷新后依然可以看到定时开机的设置，
									 * 避免设置过定时开关机后，但是用户仍然不知道的情况发生
									 */
									String[] str = vo.getDescription().split("-");
									if(str.length>=2){
										eVO.setMac(str[0]);
										eVO.setDescription(str[1]);
									}
									////////////
								}
								if(vo.getInfoValue().equalsIgnoreCase("off")){//定时关
									eVO.setPort(EquipmentEnum.STATUS_VALID);
									/**
									 * add by xiongshun 20130227 15:25
									 * 从z_t_baseinfo表中取出description字段，也就是存入的中控的定时关机时间，
									 * 然后传值给页面，使得页面刷新后依然可以看到定时关机的设置，
									 * 避免设置过定时关机后，但是用户仍然不知道的情况发生
									 */
									String[] str = vo.getDescription().split("-");
									if(str.length>=2){
										eVO.setEquipmentNO(str[0]);
										eVO.setEquipmentModel(str[1]);
									}
									//////////
								}
							}
							equipmentList.add(eVO);
//							eVO.setEquipmentName(splist.get(0).getName());
							this.getCurHttpServletRequest().setAttribute("ccVO", eVO);
							sysPowerVO = splist.get(0);
						}
					}
					this.getCurHttpServletRequest().setAttribute(
							"sysList", obj.getSysPowerList());
				}

			}
		} catch (Exception e) {
			logger.error("EquipmentControlAction		fixedTimeBeforeNew	error："
					+ e.getMessage());
			return "FAILURE";
		}
		logger.info("EquipmentControlAction		fixedTimeBeforeNew	end");
		return "SUCCESS";
	}
	
	/**
	 * 导出
	 * @return
	 */
	public String exportQuery(){
		logger.info("EquipmentControlAction		exportQuery		begin");
		try {
			// 查询有中控设备的会议室
			equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
			equipmentList = ServiceFactory.getEquipmentService().query(
					equipmentVO, null);
			
			//所有设置定时的会场
			BaseInfoVO infoVO = new BaseInfoVO();
			infoVO.setInfoType(BaseInfoEnum.TYPE_FIXEDTIME);
			ArrayList<BaseInfoVO> baseList = ServiceFactory.getBaseInfoService().query(infoVO, null);
			Map<String,BaseInfoVO> m = new HashMap<String,BaseInfoVO>();
			for (int i = 0; i < baseList.size(); i++) {
				m.put(baseList.get(i).getInfoName()+baseList.get(i).getInfoValue(), baseList.get(i));
			}
			
			
			String fileName = "fixedTime.xls";
			ExportFileObject fileObj = new ExportFileObject();
			fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
			fileObj.setExportFileName(fileName);
			
			if(equipmentList!=null&&equipmentList.size()>0){
			ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
			setTitle(list);//添加表头
			
			if (equipmentList != null && equipmentList.size() > 0) {
				for (int i = 0; i < equipmentList.size(); i++) {
							EquipmentVO uVO = equipmentList.get(i);
							CellVO[] cell = new CellVO[5];
							CellVO ex0 = new CellVO();
							ex0.setValue(i+"");
							cell[0] = ex0;
							
							CellVO ex2 = new CellVO();
							ex2.setValue(uVO.getEquipmentNO());
							cell[1] = ex2;
							
							CellVO ex3 = new CellVO();
							ex3.setValue(uVO.getIp());
							cell[2] = ex3;
							
							CellVO ex4 = new CellVO();
							if(m.get(uVO.getIp()+"on")!=null){
								String des = m.get(uVO.getIp()+"on").getDescription();
								if(des!=null&&des.length()>0){
									String[] str = m.get(uVO.getIp()+"on").getDescription().split("-");
									ex4.setValue(str[0]+"点"+str[1]+"分");
								}else
									ex4.setValue("禁止");	
							}else
								ex4.setValue("禁止");
							cell[3] = ex4;
							
							CellVO ex5 = new CellVO();
							if(m.get(uVO.getIp()+"off")!=null){
								String des = m.get(uVO.getIp()+"off").getDescription();
								if(des!=null&&des.length()>0){
									String[] str = m.get(uVO.getIp()+"on").getDescription().split("-");
									ex5.setValue(str[0]+"点"+str[1]+"分");
								}else
									ex5.setValue("禁止");
							}else
								ex5.setValue("禁止");
							cell[4] = ex5;
							
							list.add(cell);
							
						}
						
						ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
				        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);// ByteArrayInputStream(excelString.getBytes(), 0, excelString.length());
					}
					
				}
		} catch (Exception e) {
			logger.error("EquipmentControlAction		exportQuery	error："
					+ e.getMessage());
			return "FAILURE";
		}
		logger.info("EquipmentControlAction		exportQuery	end");
		return "SUCCESS";
	}
	
	private void setTitle(ArrayList<CellVO[]> list){
		CellVO[] cellTitle = new CellVO[5];
		CellVO ex0 = new CellVO();
		ex0.setValue("序号");
		cellTitle[0] = ex0;
		ex0 = new CellVO();
		ex0.setValue("分会场");
		cellTitle[1] = ex0;
		ex0 = new CellVO();
		ex0.setValue("设备IP");
		cellTitle[2] = ex0;
		ex0 = new CellVO();
		ex0.setValue("开启时间");
		cellTitle[3] = ex0;
		ex0 = new CellVO();
		ex0.setValue("关闭时间");
		cellTitle[4] = ex0;
		list.add(cellTitle);
	}
	
	public String audioControlBefore() {
		logger.info("EquipmentControlAction		audioControlBefor	begin");
		try {
			// 查询有中控设备的会议室
			equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
			equipmentList = ServiceFactory.getEquipmentService().query(
					equipmentVO, null);
			// roomList = ServiceFactory.getMeetingRoomService().query(null,
			// null);
			/***
			if (equipmentList != null && equipmentList.size() > 0) {
				for (int i = 0; i < equipmentList.size(); i++) {
					EquipmentVO e = equipmentList.get(i);
					// 调用中控接口
					CenterControlObject obj = (CenterControlObject) ControlFactory
							.getCenterControlObject(e.getIp());
					// 获取电源状态
					if (obj != null) {
						ExcuteResultVO vo = obj.audioStatus(MeetingAppConfig.CC_DEF_ID);
						if (vo != null && vo.isSuccess()) {
							AudioControlVO sv = (AudioControlVO) vo.getObject();
							String status = sv.getStatus();
							equipmentList.get(i).setStatus(
									Integer.parseInt(status));
						}
					}
				}
			}
			***/
			if(equipmentList != null && equipmentList.size() > 0){
				if(equipmentVO.getIp() != null){
					for (EquipmentVO eqVO : equipmentList) {
						if(equipmentVO.getIp().equals(eqVO.getIp())){
							equipmentVO = eqVO;
							break;
						}
					}
				}
				else{
					equipmentVO = equipmentList.get(0);
				}
				CenterControlObject obj = (CenterControlObject) ControlFactory.getCenterControlObject(equipmentVO.getIp());
				ArrayList<AudioControlVO> list = obj.getAudioList();
				this.getCurHttpServletRequest().setAttribute("audioControlVOList", list);
			}
		} catch (Exception e) {
			logger.error("EquipmentControlAction		audioControlBefor	error："
					+ e.getMessage());
			return "FAILURE";
		}
		logger.info("EquipmentControlAction		audioControlBefor	end");
		return "SUCCESS";
	}

	// add by yangyi 得到中控状态信息
	public String centerControlBefore() {
		logger.info("EquipmentControlAction		centerControlBefore	begin");
		try {
			equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
			equipmentList = ServiceFactory.getEquipmentService().query(
					equipmentVO, null);
		} catch (Exception e) {
			logger.error("EquipmentControlAction		centerControlBefore	error："
					+ e.getMessage());
			return "FAILURE";
		}

		return "success";
	}

	// add by yangyi 得到终端状态信息
	public String terminalControlBefore() {
		logger.info("EquipmentControlAction		terminalControlBefore	begin");
		try {
			this.getCurHttpServletRequest().setAttribute("numberTerStatus", DwrMethod.numberTerStatus);
			
			//////////////////构造树数据 zjy/////////////////////////////
			List<AddressVO> aList = new ArrayList<AddressVO>();
			StringBuffer sbUser = new StringBuffer();
			aList = ServiceFactory.getAddressService().query(new AddressVO(), null);
				sbUser.append("[");
				if(aList!=null && aList.size()>0){
					for(int i=0;i<aList.size();i++){
						AddressVO addressVO  = aList.get(i);
						MeetingRoomVO mrv=new MeetingRoomVO();
						mrv.setAddressVO(addressVO);
						 ///////////////设备控制分级分权 @author:zhangjy///////////////////////////
						EquipmentVO tevo=new EquipmentVO();
						tevo.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
						UserVO suv = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
						if(MeetingAppConfig.LEVEL_IS_POEN){
							if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
								tevo.setLevel(true);
								tevo.setLsql(suv.getLvoids());
							}
						}
			            /////////////////////////////////end/////////////////////////////////////
						tevo.setMeetingRoomVO(mrv);
						List<EquipmentVO> tList = ServiceFactory.getEquipmentService().query(tevo, null);
						if(tList!=null&&tList.size()>0){
						if(addressVO.getParentID().indexOf("-")>=0 || addressVO.getParentID()==null || "".equals(addressVO.getParentID())){//只展开树的一级节点，功能优化
				        	sbUser.append("{id:'"+addressVO.getAddressID()+"',pId:'"+addressVO.getParentID()+"',name:'"+addressVO.getName()+"',open:true,isParent:true,isaddress:'true'},");
				         }else{
				        	sbUser.append("{id:'"+addressVO.getAddressID()+"',pId:'"+addressVO.getParentID()+"',name:'"+addressVO.getName()+"',open:false,isaddress:'true'},");
				         }
						for(EquipmentVO ev:tList){
							String ip=ev.getIp();
							int status=1;
					    TerminalObject obj = (TerminalObject)ControlFactory.getTerminalObject(ip);
						if(obj == null){
							logger.info(ip + ":null");
						 }else {
							if(obj.isOnLine()){
								status = 0;
							}else{
								status = 1;
							}
							
						}
							
							String iconSrc="";
							String statusName="";
							if (status == 0) {
								statusName="开启";
								iconSrc = "/icmp/meeting/equipmentControl/image/open1.png";
							} else if (status == 1) {
								statusName="关闭";
								iconSrc = "/icmp/meeting/equipmentControl/image/close1.png";
							} else {
								statusName="未知";
								iconSrc = "/icmp/meeting/equipmentControl/image/wait1.gif";
							}
							 
							 sbUser.append("{id:'"+ev.getEquipmentID()+"',pId:'"+addressVO.getAddressID()+"',name:'"+ev.getEquipmentNO()+"',fullName:'"+ev.getEquipmentName()+"("+statusName+")',icon:'"+iconSrc+"',open:false,isaddress:'false'},");
						}
						
						}
					}
				}
				
				ztreeDate=sbUser.substring(0, sbUser.length()-1);
				ztreeDate += "];";
		} catch (Exception e) {
			
			logger.error("EquipmentControlAction		terminalControlBefore	error："
					+ e.getMessage());
			return "FAILURE";
		}
        
		return "success";
	}

	public String plaControlBefore(){
		logger.info("EquipmentControlAction		plaControlBefore	begin");
		try {
			// 查询有中控设备的会议室
			equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
			
			ArrayList<EquipmentVO> eqmtList = ServiceFactory.getEquipmentService().query(equipmentVO, null);
			if (eqmtList != null && eqmtList.size() > 0) {
				for (int i = 0; i < eqmtList.size(); i++) {
					EquipmentVO e = eqmtList.get(i);
					// 调用中控接口
					CenterControlObject obj = (CenterControlObject) ControlFactory
							.getCenterControlObject(e.getIp());
					// 获取此中控下的等离子列表
					ArrayList<PlaVO> plaVOs= obj.getPlaList();
					for (PlaVO plaVO : plaVOs) {
						EquipmentVO eqVO = new EquipmentVO();
						eqVO.setMeetingRoomVO(e.getMeetingRoomVO());
						eqVO.setIp(e.getIp());
						ExcuteResultVO rsVO = 
							obj.plaStatus(plaVO.getId());
						if (rsVO.isSuccess()) {
							PlaVO pla = (PlaVO)rsVO.getObject();
							eqVO.setStatus(Integer.valueOf(pla.getStatus()));
							eqVO.setDescription(pla.getName());
							eqVO.setEquipmentID(pla.getId());
							equipmentList.add(eqVO);
						}
					}
				}
			}
			// roomList = ServiceFactory.getMeetingRoomService().query(null,
			// null);
		} catch (Exception e) {
			logger.error("EquipmentControlAction		plaControlBefore	error："
					+ e.getMessage());
			return "FAILURE";
		}
		logger.info("EquipmentControlAction		plaControlBefore	end");
		return "success";
	}
	
	public String sysPowerBefore() {
		logger.info("EquipmentControlAction		sysPowerBefore	begin");
		try {
			// 查询有中控设备的会议室
			equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
			equipmentList = ServiceFactory.getEquipmentService().query(
					equipmentVO, null);
			
//			if (equipmentList != null && equipmentList.size() > 0) {
//				for (int i = 0; i < equipmentList.size(); i++) {
//					EquipmentVO e = equipmentList.get(i);
//					// 调用中控接口
//					CenterControlObject obj = (CenterControlObject) ControlFactory
//							.getCenterControlObject(e.getIp());
//					// 获取电源状态
//					ExcuteResultVO vo = obj.sysPowerStatus(MeetingAppConfig.CC_DEF_ID);
//					if (vo.isSuccess()) {
//						SysPowerVO sv = (SysPowerVO) vo.getObject();
//						String status = sv.getStatus();
//						equipmentList.get(i)
//								.setStatus(Integer.parseInt(status));
//					}
//				}
//			}
			// roomList = ServiceFactory.getMeetingRoomService().query(null,
			// null);
		} catch (Exception e) {
			logger.error("EquipmentControlAction		sysPowerBefore	error："
					+ e.getMessage());
			return "FAILURE";
		}
		logger.info("EquipmentControlAction		sysPowerBefore	end");
		return "SUCCESS";
	}
	
	/**
	 * DVD控制
	 * 
	 */
	public String dvdControlBefore(){
		logger.info("EquipmentControlAction		dvdControlBefore	begin");
		try {
			// 查询有中控设备的会议室
			EquipmentVO oldEquipmentVO = new EquipmentVO();
			oldEquipmentVO
					.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
			equipmentList = ServiceFactory.getEquipmentService().query(
					oldEquipmentVO, null);
			if (equipmentList != null && equipmentList.size() > 0) {
				if (equipmentVO.getIp() != null) {
					for (EquipmentVO equipVO : equipmentList) {
						if (equipVO.getIp().equals(equipmentVO.getIp())) {
							equipmentVO = equipVO;
							break;
						}
					}
				} else {
					equipmentVO = equipmentList.get(0);
				}
			}
		} catch (Exception e) {
			logger.error("EquipmentControlAction		dvdControlBefore	error："
					+ e.getMessage());
			return "FAILURE";
		}
		logger.info("EquipmentControlAction		dvdControlBefore	end");
		return "success";
	}
	
	/**
	 * 窗帘控制
	 * 
	 */
	public String curtainControlBefore(){
		logger.info("EquipmentControlAction		curtainControlBefore 	begin");
		try {
			EquipmentVO eqmtVO = new EquipmentVO();
			eqmtVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
			equipmentList=ServiceFactory.getEquipmentService().query(eqmtVO, null);
			if(equipmentList != null && equipmentList.size() > 0){
				if(equipmentVO.getIp() != null){
					for (EquipmentVO eqVO : equipmentList) {
						if(equipmentVO.getIp().equals(eqVO.getIp())){
							equipmentVO = eqVO;
							break;
						}
					}
				}
				else{
					equipmentVO = equipmentList.get(0);
				}
				CenterControlObject obj = (CenterControlObject) ControlFactory.getCenterControlObject(equipmentVO.getIp());
				ArrayList<CurtainVO> list = obj.getCurtainList();
				this.getCurHttpServletRequest().setAttribute("curtainVOList", list);
			}
			
		} catch (Exception e) {
			logger.error("EquipmentControlAction  curtainControlBefore	error："
					+ e.getMessage());
			return "FAILURE";
		}
		return "success";
	}
	
	
	/**
	 * 投影机控制
	 * 
	 */
	public String projControlBefore(){
		logger.info("EquipmentControlAction		projControlBefore 	begin");
		try {
			EquipmentVO eqmtVO = new EquipmentVO();
			eqmtVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
			equipmentList=ServiceFactory.getEquipmentService().query(eqmtVO, null);
			if(equipmentList != null && equipmentList.size() > 0){
				if(equipmentVO.getIp() != null){
					for (EquipmentVO eqVO : equipmentList) {
						if(equipmentVO.getIp().equals(eqVO.getIp())){
							equipmentVO = eqVO;
							break;
						}
					}
				}
				else{
					equipmentVO = equipmentList.get(0);
				}
				CenterControlObject obj = (CenterControlObject) ControlFactory.getCenterControlObject(equipmentVO.getIp());
				ArrayList<ProjVO> list = obj.getProjList();
				this.getCurHttpServletRequest().setAttribute("projVOList", list);
			}
		} catch (Exception e) {
			logger.error("EquipmentControlAction  projControlBefore	error："
					+ e.getMessage());
			return "FAILURE";
		}
		return "success";
	}
	
	/**
	 * 摄像头控制
	 * 
	 * @return
	 */
	public String cameraBefore() {
		logger.info("EquipmentControlAction		cameraBefore	begin");
		try {
			// 查询有中控设备的会议室
			EquipmentVO oldEquipmentVO = new EquipmentVO();
			oldEquipmentVO
					.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
			equipmentList = ServiceFactory.getEquipmentService().query(
					oldEquipmentVO, null);
			if (equipmentList != null && equipmentList.size() > 0) {
				if (equipmentVO.getIp() != null) {
					for (EquipmentVO equipVO : equipmentList) {
						if (equipVO.getIp().equals(equipmentVO.getIp())) {
							equipmentVO = equipVO;
							break;
						}
					}
				} else {
					equipmentVO = equipmentList.get(0);
				}

				if (equipmentVO.getIp() != null) {
					CenterControlObject obj = (CenterControlObject) ControlFactory
							.getCenterControlObject(equipmentVO.getIp());
					ArrayList<CameraVO> list = obj.getCameraList();
					if (list != null && list.size() > 0) {
						if (cameraVO.getId() != null) {
							for (CameraVO cameVO : list) {
								if (cameVO.getId().equals(cameraVO.getId())) {
									cameraVO = cameVO;
									// list.add(matrixSwitchVO);
									break;
								}
							}
						} else {
							cameraVO = list.get(0);
						}
					}
					this.getCurHttpServletRequest().setAttribute(
							"cameraList", obj.getCameraList());
				}

			}
		} catch (Exception e) {
			logger.error("EquipmentControlAction		cameraBefore	error："
					+ e.getMessage());
			return "FAILURE";
		}
		logger.info("EquipmentControlAction		cameraBefore	end");
		return "SUCCESS";
	}

	/**
	 * 视频终端
	 * 
	 * @return
	 */
	public String videoEndPointBefore() {
		logger.info("EquipmentControlAction		videoEndPointBefore	begin");
		try {
			// 查询有视频终端的会议室
			EquipmentVO oldEquipmentVO = new EquipmentVO();
			oldEquipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
			equipmentList = ServiceFactory.getEquipmentService().query(
					oldEquipmentVO, null);
			if (equipmentList != null && equipmentList.size() > 0) {
				if (equipmentVO.getEquipmentID() != null) {
					for (EquipmentVO equipmentVOs : equipmentList) {
						if (equipmentVOs.getEquipmentID().equals(
								equipmentVO.getEquipmentID())) {
							equipmentVO = equipmentVOs;
							break;
						}
					}
				} else {
					equipmentVO = equipmentList.get(0);
				}
			}
		

		} catch (Exception e) {
			logger.error("EquipmentControlAction		videoEndPointBefore	error："
					+ e.getMessage());
			return "FAILURE";
		}
		logger.info("EquipmentControlAction		videoEndPointBefore	end");
		return "SUCCESS";
	}

	/**
	 * 会议矩阵切换
	 * 
	 * @return
	 */
	public String matrixNetControlBefore() {
		// 查询会议矩阵
		logger.info("EquipmentControlAction		matrixNetControlBefore	begin");
		try {
			ArrayList<EquipmentVO> equipmentList2 = new ArrayList<EquipmentVO>();
			EquipmentVO oldEquipmentVO = new EquipmentVO();
			oldEquipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_OTHEREQUIPMENT);
			equipmentList2 = ServiceFactory.getEquipmentService().query(
					oldEquipmentVO, null);
//			String meetingRoomID = equipmentVO.getMeetingRoomVO()
//					.getMeetingRoomID();
//			if (meetingRoomID != null) {
//				meetingRoomVO = ServiceFactory.getMeetingRoomService()
//						.queryByID(meetingRoomID);
//			}
			if (equipmentList2 != null && equipmentList2.size() > 0) {
//				if (meetingRoomID != null) {
//					for (EquipmentVO equipVO : equipmentList) {
//						if (equipVO.getMeetingRoomVO().getMeetingRoomID()
//								.equals(meetingRoomID)) {
//							equipmentVO = equipVO;
//							break;
//						}
//					}
//				} else {
				for(EquipmentVO equipVO : equipmentList2){
					if (equipVO.getEquipmentName().indexOf("捷控")>-1
							|| equipVO.getEquipmentName().indexOf("快捷")>-1) {
						equipmentList.add(equipVO);
					}
				}
				
				
				if(equipmentList!=null && equipmentList.size()>0){
					if(equipmentVO.getEquipmentID()==null){
						equipmentVO = equipmentList.get(0);
						meetingRoomVO = equipmentVO.getMeetingRoomVO();
					}else{
						for (EquipmentVO equip : equipmentList) {
							if(equip.getEquipmentID().equals(equipmentVO.getEquipmentID())){
								equipmentVO = equip;
								break;
							}
						}
					}
				}
				
				String[][] in = null;
				String[][] out = null;
				String initDate = equipmentVO.getDescription();
				if(initDate!=null&&initDate.length()>0){
					//int inNum = initDate.indexOf("in:");
					int outNum = initDate.indexOf("out:");
					String inStr = initDate.substring(3, outNum);
					String outStr = initDate.substring(outNum+4,initDate.length());
					if(inStr!=null&&inStr.length()>0){
						String[] s = inStr.split(";");
						in = new String[s.length][2];
						for(int i=0;i<s.length;i++){
							String[] str = s[i].split("-");
							if(str==null||str.length!=2) continue;
							in[i][0] = str[0];
							in[i][1] = str[1];
						}
					}
					
					if(outStr!=null&&outStr.length()>0){
						String[] s = outStr.split(";");
						out = new String[s.length][2];
						for(int i=0;i<s.length;i++){
							String[] str = s[i].split("-");
							if(str==null||str.length!=2) continue;
							out[i][0] = str[0];
							out[i][1] = str[1];
						}
					}
				}
				
				matrixSwitchVO.setId(equipmentVO.getEquipmentID());
				matrixSwitchVO.setIp(equipmentVO.getIp());
				matrixSwitchVO.setName(equipmentVO.getEquipmentNO());
				matrixSwitchVO.setIn(in);
				matrixSwitchVO.setOut(out);
				
				/////////////矩阵页面终端发送双流--begin////////////////////////
//				ArrayList<EquipmentVO> tList = new ArrayList<EquipmentVO>();
//				EquipmentVO eqvo = new EquipmentVO();
//				eqvo.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
//				eqvo.getMeetingRoomVO().setMeetingRoomID(equipmentVO.getMeetingRoomVO().getMeetingRoomID());
//				tList = ServiceFactory.getEquipmentService().query(eqvo, null);
//				this.getCurHttpServletRequest().setAttribute("tList", tList);
				
				/////////////矩阵页面终端发送双流----end////////////////////////	
//				CenterControlObject obj = (CenterControlObject) ControlFactory
//						.getCenterControlObject(equipmentVO.getIp());
//				ArrayList<MatrixSwitchVO> list = obj.getMatrixSwitchList();
//				// System.out.print("输入"+list.get(0).getIn());
//				if (list != null && list.size() > 0) {
//					if (matrixSwitchVO.getId() != null) {
//						for (MatrixSwitchVO switchVO : list) {
//							// System.out.print("//////////////"+switchVO.getId().equals(matrixSwitchVO.getId())+"//////////");
//							// logger.info("矩阵id@@@@@@"+matrixSwitchVO.getId());
//							// logger.info("举证id######"+switchVO.getId());
//							if (switchVO.getId().equals(matrixSwitchVO.getId())) {
//								matrixSwitchVO = switchVO;
//								// list.add(matrixSwitchVO);
//								break;
//							}
//						}
//					} else {
//						matrixSwitchVO = list.get(0);
//					}
//				}
//
//				// for(String[] s : matrixSwitchVO.getOut()){
//				// logger.info(equipmentVO.getIp()+"****"+s[0]+"=out=="+s[1]);
//				// }
//				// for(String[] s : matrixSwitchVO.getIn()){
//				// logger.info(equipmentVO.getIp()+"*****"+s[0]+"=in=="+s[1]);
//				// }
//				this.getCurHttpServletRequest().setAttribute(
//						"matrixSwitchVOList", list);
			}
		} catch (Exception e) {
			logger.error("EquipmentControlAction		matrixNetControlBefore	error："
					+ e.getMessage());
			return "FAILURE";
		}
		logger.info("EquipmentControlAction		matrixNetControlBefore	end");
		return "SUCCESS";
	}
	
	/**
	 * 会议矩阵切换
	 * 
	 * @return
	 */
	public String matrixBefore() {
		// 查询会议矩阵
		logger.info("EquipmentControlAction		matrixBefore	begin");
		try {
			EquipmentVO oldEquipmentVO = new EquipmentVO();
			oldEquipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
			equipmentList = ServiceFactory.getEquipmentService().query(
					oldEquipmentVO, null);
//			String meetingRoomID = equipmentVO.getMeetingRoomVO()
//					.getMeetingRoomID();
//			if (meetingRoomID != null) {
//				meetingRoomVO = ServiceFactory.getMeetingRoomService()
//						.queryByID(meetingRoomID);
//			}
			if (equipmentList != null && equipmentList.size() > 0) {
//				if (meetingRoomID != null) {
//					for (EquipmentVO equipVO : equipmentList) {
//						if (equipVO.getMeetingRoomVO().getMeetingRoomID()
//								.equals(meetingRoomID)) {
//							equipmentVO = equipVO;
//							break;
//						}
//					}
//				} else {
				if(equipmentVO.getIp()==null){
					equipmentVO = equipmentList.get(0);
					meetingRoomVO = equipmentVO.getMeetingRoomVO();
				}else{
					for (EquipmentVO equip : equipmentList) {
						if(equip.getIp().equals(equipmentVO.getIp())){
							equipmentVO = equip;
							break;
						}
					}
				}
				/////////////矩阵页面终端发送双流--begin////////////////////////
				ArrayList<EquipmentVO> tList = new ArrayList<EquipmentVO>();
				EquipmentVO eqvo = new EquipmentVO();
				eqvo.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
				eqvo.getMeetingRoomVO().setMeetingRoomID(equipmentVO.getMeetingRoomVO().getMeetingRoomID());
				tList = ServiceFactory.getEquipmentService().query(eqvo, null);
				this.getCurHttpServletRequest().setAttribute("tList", tList);
				
				/////////////矩阵页面终端发送双流----end////////////////////////	
				CenterControlObject obj = (CenterControlObject) ControlFactory
						.getCenterControlObject(equipmentVO.getIp());
				ArrayList<MatrixSwitchVO> list = obj.getMatrixSwitchList();
				// System.out.print("输入"+list.get(0).getIn());
				if (list != null && list.size() > 0) {
					if (matrixSwitchVO.getId() != null) {
						for (MatrixSwitchVO switchVO : list) {
							// System.out.print("//////////////"+switchVO.getId().equals(matrixSwitchVO.getId())+"//////////");
							// logger.info("矩阵id@@@@@@"+matrixSwitchVO.getId());
							// logger.info("举证id######"+switchVO.getId());
							if (switchVO.getId().equals(matrixSwitchVO.getId())) {
								matrixSwitchVO = switchVO;
								// list.add(matrixSwitchVO);
								break;
							}
						}
					} else {
						matrixSwitchVO = list.get(0);
					}
				}

				// for(String[] s : matrixSwitchVO.getOut()){
				// logger.info(equipmentVO.getIp()+"****"+s[0]+"=out=="+s[1]);
				// }
				// for(String[] s : matrixSwitchVO.getIn()){
				// logger.info(equipmentVO.getIp()+"*****"+s[0]+"=in=="+s[1]);
				// }
				this.getCurHttpServletRequest().setAttribute(
						"matrixSwitchVOList", list);
			}
		} catch (Exception e) {
			logger.error("EquipmentControlAction		matrixBefore	error："
					+ e.getMessage());
			return "FAILURE";
		}
		logger.info("EquipmentControlAction		matrixBefore	end");
		return "SUCCESS";
	}

	/**
	 * 大屏监控
	 * 
	 * @return
	 */
	public String bigscreenMonitorBefore() {
		logger.info("EquipmentControlAction		bigscreenMonitorBefore	begin");
		ArrayList<EquipmentVO> deleteList = new ArrayList<EquipmentVO>();
		try {
			// 查询有中控设备的会议室
			EquipmentVO equipVO = new EquipmentVO();
			equipVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
			equipmentList = ServiceFactory.getEquipmentService().query(
					equipVO, null);
			if (equipmentList != null && equipmentList.size() > 0) {
				for (EquipmentVO screent : equipmentList) {
					CenterControlObject obj = (CenterControlObject) ControlFactory
							.getCenterControlObject(screent.getIp());
					ExcuteResultVO resultVO = obj.viewScreentModelStatus(MeetingAppConfig.CC_DEF_ID);
					 if(resultVO != null && !resultVO.isSuccess()){
						 //equipmentList.remove(screent);
						 deleteList.add(screent);
						 continue;
					 }
					 if(resultVO != null && resultVO.isSuccess()){
						 viewScreentVO = (ViewScreentVO)resultVO.getObject();
						 if(screent.getIp().equals(equipmentVO.getIp())){
							 String chooseModel = equipmentVO.getDescription();
							 screent.setDescription(chooseModel);
							 String[] choose_model = chooseModel.split("-");
							 if(choose_model.length == 2){
								 String model_choose = choose_model[0];
								 String type_choose = choose_model[1];
								 viewScreentVO.setModel(model_choose);
								 viewScreentVO.setType(type_choose);
							 }
						 }else{
							 screent.setDescription(viewScreentVO.getModel()+"-"+viewScreentVO.getType());
							 //viewScreentVO.getType()
						 }
						 String screenModelViewStr = viewScreentVO.getModelViewStr(40);
						 screent.getMeetingRoomVO().setDescription(screenModelViewStr);
						 screent.setEquipmentNO(viewScreentVO.getModelSwitchOutPort(viewScreentVO.getModel()+viewScreentVO.getType()));
					 }
//					screent.setDescription("31");
//					screent.setEquipmentNO("223,555,888");
				}
				equipmentList.removeAll(deleteList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger
					.error("EquipmentControlAction		bigscreenMonitorBefore	error："
							+ e.getMessage());
			return "FAILURE";
		}
		logger.info("EquipmentControlAction		bigscreenMonitorBefore	end");
		return "SUCCESS";
	}

	/**
	 * 大屏电源
	 * 
	 * @return
	 */
	public String bigscreenPowerBefore() {
		logger.info("EquipmentControlAction		bigscreenPowerBefore	begin");
		logger.info("EquipmentControlAction	bigscreenMonitorBefore	begin");
		try {
			// 查询有中控设备的会议室
//			EquipmentVO equipVO = new EquipmentVO();
			ArrayList<EquipmentVO> list = new ArrayList<EquipmentVO>();
//			equipVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
//			equipmentList = ServiceFactory.getEquipmentService().query(
//					equipVO, null);
//			if(equipmentList != null && equipmentList.size() > 0){
//				if(equipmentVO.getIp() != null){
//					for (EquipmentVO eqVO : equipmentList) {
//						if(equipmentVO.getIp().equals(eqVO.getIp())){
//							equipmentVO = eqVO;
//							break;
//						}
//					}
//				}
//				else{
//					equipmentVO = equipmentList.get(0);
//				}
				CenterControlObject obj = (CenterControlObject) ControlFactory
					.getCenterControlObject(equipmentVO.getIp());
		ExcuteResultVO resultVO = obj.viewScreentModelStatus(MeetingAppConfig.CC_DEF_ID);
		 if(resultVO != null && resultVO.isSuccess()){
			 viewScreentVO = (ViewScreentVO)resultVO.getObject();
			 if(viewScreentVO.getAllModel()!=null){
				 for(int i=0;i<viewScreentVO.getAllModel().length;i++){
					 EquipmentVO eqvo = new EquipmentVO();
					 eqvo.setEquipmentID(String.valueOf(i+1));
					 eqvo.setIp(equipmentVO.getIp());
					 //if(viewScreentVO.getType()==null || viewScreentVO.getType()==""){
						 String chooseModel = viewScreentVO.getAllModel()[i][0];
						 //equipmentVO.setDescription(chooseModel);
						 String[] choose_model = chooseModel.split("-");
						 if(choose_model.length == 2){
							 String model_choose = choose_model[0];
							 String type_choose = choose_model[1];
							 viewScreentVO.setModel(model_choose);
							 viewScreentVO.setType(type_choose);
						 }
						 eqvo.setDescription(viewScreentVO.getModel()+"-"+viewScreentVO.getType());
					 //}else{
						 //equipmentVO.setDescription(viewScreentVO.getModel()+"-"+viewScreentVO.getType());
						 //viewScreentVO.getType()
					 //}
				CenterControlObject objN = (CenterControlObject) ControlFactory.getCenterControlObject(equipmentVO.getIp());
				ExcuteResultVO resultVON = objN.viewScreentModelStatus(MeetingAppConfig.CC_DEF_ID);
				if(resultVON != null && resultVON.isSuccess()){
					 viewScreentVO = (ViewScreentVO)resultVON.getObject();
					 String screenModelViewStr = viewScreentVO.getModelViewStr(40);
					 eqvo.getMeetingRoomVO().setDescription(screenModelViewStr);
					 eqvo.setEquipmentNO(viewScreentVO.getModelSwitchOutPort(viewScreentVO.getModel()+viewScreentVO.getType()));
					 
				}
				list.add(eqvo);
				}
			 }
			 
		 }
		 
//		screent.setDescription("31");
//		screent.setEquipmentNO("223,555,888");
//	}
	this.getCurHttpServletRequest().setAttribute("equipmentModelList", list);
				/**
				 * 当前模式：一个中控对应一个大屏，而大屏的编号为1
				 * 提取大屏当前显示模式
				 */
//				ExcuteResultVO resultVO = obj.viewScreentModelStatus(MeetingAppConfig.CC_DEF_ID);
//				resultVO.setSuccess(true);
//				//ceshi
//				ViewScreentVO vvo = new ViewScreentVO();
//				vvo.setModel("2");
//				resultVO.setObject(vvo);
//				//========================================end 
//				 if(resultVO != null && resultVO.isSuccess()){
//					 viewScreentVO = (ViewScreentVO)resultVO.getObject();
					 //viewScreentVO.setModel("2");
					 
	//				 页面调用接口
	//				 viewScreentVO.getAllModel();【】【】
	//				 viewScreentVO.getModelViewStr(Integer.MIN_VALUE);
		} catch (Exception e) {
			logger.error("EquipmentControlAction		bigscreenPowerBefore	error："
					+ e.getMessage());
			return "FAILURE";
		}
		logger.info("EquipmentControlAction		bigscreenPowerBefore	end");
		return "SUCCESS";
	}

	public String bigScreenInputChooseBefore() {
		logger.info("EquipmentControlAction		bsInputChooseBefore 	begin");
		return bigscreenInputBefore();
	}

	/**
	 * 获取大屏监控的输入输出
	 * 
	 * @return
	 */
	public String bigscreenInputBefore() {
		logger.info("EquipmentControlAction		bigscreenInputBefore	begin");
		String ips = equipmentVO.getIp();
		String mode = equipmentVO.getDescription();
		try {
			CenterControlObject obj = (CenterControlObject) ControlFactory
					.getCenterControlObject(ips);
			ArrayList<MatrixSwitchVO> list = obj.getMatrixSwitchList();
			// System.out.print("输入"+list.get(0).getIn());
			if (list != null && list.size() > 0) {
				if (matrixSwitchVO.getId() != null) {
					for (MatrixSwitchVO switchVO : list) {
						if (switchVO.getId().equals(matrixSwitchVO.getId())) {
							matrixSwitchVO = switchVO;
							// list.add(matrixSwitchVO);
							break;
						}
					}
				} else {
					matrixSwitchVO = list.get(0);
				}
			}
			
			 ExcuteResultVO resultVO = obj.viewScreentModelStatus(MeetingAppConfig.CC_DEF_ID);
			 if(resultVO != null && resultVO.isSuccess()){
			 viewScreentVO = (ViewScreentVO)resultVO.getObject();
			 if(equipmentVO.getDescription()!=null && equipmentVO.getDescription()!=""){
				 String[] str = equipmentVO.getDescription().split("-");
				 viewScreentVO.setModel(str[0]);
				 viewScreentVO.setType(str[1]);
			 }
			 CenterControlObject objN = (CenterControlObject) ControlFactory
				.getCenterControlObject(ips);
			 ExcuteResultVO resultVON = objN.viewScreentModelStatus(MeetingAppConfig.CC_DEF_ID);
			 if(resultVON != null && resultVON.isSuccess()){
				 viewScreentVO = (ViewScreentVO)resultVON.getObject();
			 }
			 	String allModelSwitchOutPort = viewScreentVO
						.getModelSwitchOutPort(mode);
			 	
			 	String modeInfo = viewScreentVO.getModelViewStr(MeetingAppConfig.def_px);
			 	
			 	if(modeInfo.length()!=0){
			 		String[] bigScreenList = modeInfo.split("</div>");
			 		int bgLsLength = bigScreenList.length;
			 		this.getCurHttpServletRequest().setAttribute("bgLsLength",bgLsLength);
			 	}
			 	
			 	equipmentVO.getMeetingRoomVO().setDescription(modeInfo+"</div>");
			 	
			 	this.getCurHttpServletRequest().setAttribute(
			 			"allModelSwitchOutPort", allModelSwitchOutPort);
			 }
			this.getCurHttpServletRequest().setAttribute("matrixSwitchVOList",
					list);
		} catch (Exception e) {
			logger.error("EquipmentControlAction  bigscreenInputBefore	error："
					+ e.getMessage());
			return "FAILURE";
		}
		equipmentVO.setEquipmentModel(mode);
		logger.info("EquipmentControlAction		bigscreenInputBefore	end");
		return "SUCCESS";
	}

	/** 灯光控制 **/
	public String getLightControl(){
		logger.info("EquipmentControlAction		getLightControl 	begin");
		try {
			EquipmentVO listVO = new EquipmentVO();
			listVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
			equipmentList=ServiceFactory.getEquipmentService().query(listVO, null);
			if(equipmentList != null && equipmentList.size() > 0){
				if(equipmentVO.getIp() != null){
					for (EquipmentVO eqVO : equipmentList) {
						if(equipmentVO.getIp().equals(eqVO.getIp())){
							equipmentVO = eqVO;
							break;
						}
					}
				}
				else{
					equipmentVO = equipmentList.get(0);
				}
				CenterControlObject obj = (CenterControlObject) ControlFactory.getCenterControlObject(equipmentVO.getIp());
				ArrayList<LightVO> list = new ArrayList<LightVO>();
				if(obj!=null)
					 list = obj.getLightList();
				this.getCurHttpServletRequest().setAttribute("lightVOList", list);
			}
			
		} catch (Exception e) {
			logger.error("EquipmentControlAction  getLightControl	error："
					+ e.getMessage());
			return "FAILURE";
		}
		return "success";
	}
	
	/** 升降屏控制**/
	public String getLiftingScreen(){
		logger.info("EquipmentControlAction		getLiftingScreen	begin");
		try {
			EquipmentVO listVO = new EquipmentVO();
			listVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
			equipmentList=ServiceFactory.getEquipmentService().query(listVO, null);
			if(equipmentList != null && equipmentList.size() > 0){
				if(equipmentVO.getIp() != null){
					for (EquipmentVO eqVO : equipmentList) {
						if(equipmentVO.getIp().equals(eqVO.getIp())){
							equipmentVO = eqVO;
							break;
						}
					}
				}
				else{
					equipmentVO = equipmentList.get(0);
				}
				CenterControlObject obj = (CenterControlObject) ControlFactory.getCenterControlObject(equipmentVO.getIp());
				ArrayList<UpDownScreenVO> list = new ArrayList<UpDownScreenVO>();
				if(obj!=null)
					list = obj.getUpDownScreenList();
				this.getCurHttpServletRequest().setAttribute("liftingScreenVOList", list);
			}
		} catch (Exception e) {
			logger.error("EquipmentControlAction  getLiftingScreen	error："
					+ e.getMessage());
			return "FAILURE";
		}
		return "success";
	}
	
	/**等离子控制**/
	public String getPlasmaTV(){
		logger.info("EquipmentControlAction		getPlasmaTV 	begin");
		try {
			EquipmentVO listVO = new EquipmentVO();
			listVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
			equipmentList=ServiceFactory.getEquipmentService().query(listVO, null);
			if(equipmentList != null && equipmentList.size() > 0){
				if(equipmentVO.getIp() != null){
					for (EquipmentVO eqVO : equipmentList) {
						if(equipmentVO.getIp().equals(eqVO.getIp())){
							equipmentVO = eqVO;
							break;
						}
					}
				}
				else{
					equipmentVO = equipmentList.get(0);
				}
				CenterControlObject obj = (CenterControlObject) ControlFactory.getCenterControlObject(equipmentVO.getIp());
				ArrayList<PlaVO> list1 = new ArrayList<PlaVO>();
				ArrayList<PlaVO> list = new ArrayList<PlaVO>();
				if(obj!=null)
					list1 = obj.getPlaList();
				//这里只写了两个，修改成for循环则可以写多个
				for(int i=0;i<list1.size();i++){
					list.add(list1.get(i));
				}
				this.getCurHttpServletRequest().setAttribute("plasmaTVVOList", list);
			}
		} catch (Exception e) {
			logger.error("EquipmentControlAction  getPlasmaTV	error："
					+ e.getMessage());
			return "FAILURE";
		}
		return "success";
	}
	/**
	 *投影仪控制 
	 * @return
	 */
	public String getProjector(){
		logger.info("EquipmentControlAction		getProjector	begin");
		try {
			EquipmentVO listVO = new EquipmentVO();
			listVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
			equipmentList=ServiceFactory.getEquipmentService().query(listVO, null);
			if(equipmentList != null && equipmentList.size() > 0){
				if(equipmentVO.getIp() != null){
					for (EquipmentVO eqVO : equipmentList) {
						if(equipmentVO.getIp().equals(eqVO.getIp())){
							equipmentVO = eqVO;
							break;
						}
					}
				}
				else{
					equipmentVO = equipmentList.get(0);
				}
				CenterControlObject obj = (CenterControlObject) ControlFactory.getCenterControlObject(equipmentVO.getIp());
				ArrayList<ProjVO> list1 = new ArrayList<ProjVO>();
				ArrayList<ProjVO> list = new ArrayList<ProjVO>();
				if(obj!=null)
					list1 = obj.getProjList();
				for(int i = 0; i < list1.size(); i++){
					list.add(list1.get(i));
				}
				this.getCurHttpServletRequest().setAttribute("projectorVOList", list);
			}
			
		} catch (Exception e) {
			logger.error("EquipmentControlAction  getProjector	error："
					+ e.getMessage());
			return "FAILURE";
		}
		return "success";
	}
	/**
	 * add by xiongshun 画面分割器
	 * @return
	 */
	public String getVideom(){
		logger.info("EquipmentControlAction		getVideom	begin");
		try {
			EquipmentVO oldEquipmentVO = new EquipmentVO();
			oldEquipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
			equipmentList = ServiceFactory.getEquipmentService().query(
					oldEquipmentVO, null);
			if (equipmentList != null && equipmentList.size() > 0) {
				if(equipmentVO.getIp()==null){
					equipmentVO = equipmentList.get(0);
					meetingRoomVO = equipmentVO.getMeetingRoomVO();
				}else{
					for (EquipmentVO equip : equipmentList) {
						if(equip.getIp().equals(equipmentVO.getIp())){
							equipmentVO = equip;
							break;
						}
					}
				}

				CenterControlObject obj = (CenterControlObject) ControlFactory
						.getCenterControlObject(equipmentVO.getIp());
				ArrayList<VideomVO> list = new ArrayList<VideomVO>();
				if(obj!=null)
					list = obj.getVideomList();
				
				if (list != null && list.size() > 0) {
					if (videomVO.getId() != null) {
						for (VideomVO vidVO : list) {
							if (vidVO.getId().equals(videomVO.getId())) {
								videomVO = vidVO;
								break;
							}
						}
					} else {
						videomVO = list.get(0);
					}
				}
				this.getCurHttpServletRequest().setAttribute(
						"videomVOList", list);
			}
		} catch (Exception e) {
			logger.error("EquipmentControlAction  getVideom	error："
					+ e.getMessage());
			return "FAILURE";
		}
		return "success";
	}
	
	/**
	 * add by xiongshun 会议室组合键（会议模式）
	 * @return
	 */
	public String roomModelControlBefore(){
		logger.info("EquipmentControlAction		roomModelControlBefore	begin");
		try {
			EquipmentVO oldEquipmentVO = new EquipmentVO();
			oldEquipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
			equipmentList = ServiceFactory.getEquipmentService().query(
					oldEquipmentVO, null);
			if (equipmentList != null && equipmentList.size() > 0) {
				if(equipmentVO.getIp()==null){
					equipmentVO = equipmentList.get(0);
					meetingRoomVO = equipmentVO.getMeetingRoomVO();
				}else{
					for (EquipmentVO equip : equipmentList) {
						if(equip.getIp().equals(equipmentVO.getIp())){
							equipmentVO = equip;
							break;
						}
					}
				}
				
				CenterControlObject obj = (CenterControlObject) ControlFactory
						.getCenterControlObject(equipmentVO.getIp());
				
				if(obj!=null){
//					一个中控下只允许配置一个会议模式控制
//				    ExcuteResultVO resultVO = obj.getRoomModelList(MeetingAppConfig.CC_DEF_ID);
//				    
//				    if(resultVO.isSuccess()==true){
//				    	RoomModelVO roomModelVO = (RoomModelVO) resultVO.getObject();
//				    	this.getCurHttpServletRequest().setAttribute(
//								"roomModelVO", roomModelVO);
//				    }	
					ArrayList<RoomModelVO> mrList = obj.getRoomModelList();
					if (mrList != null && mrList.size() > 0) {
						if (roomModelVO.getId() != null) {
							for (RoomModelVO rmVO : mrList) {
								if (rmVO.getId().equals(roomModelVO.getId())) {
									roomModelVO = rmVO;
									// list.add(matrixSwitchVO);
									break;
								}
							}
						} else {
							roomModelVO = mrList.get(0);
						}
					}
					this.getCurHttpServletRequest().setAttribute(
							"mrlist", mrList);
				}
			}
		} catch (Exception e) {
			logger.error("EquipmentControlAction  roomModelControlBefore	error："
					+ e.getMessage());
			return "FAILURE";
		}
		return "success";
	}
	
	/**
	 * 跳转至录播服务器控制页面
	 * add by guohn
	 * 2015-10-24
	 */
	public String toRecorded(){
		// 查询录播服务器
		logger.info("EquipmentControlAction		toRecorded	begin");
		try {
			ArrayList<EquipmentVO> equipmentList2 = new ArrayList<EquipmentVO>();
			EquipmentVO oldEquipmentVO = new EquipmentVO();
			oldEquipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_OTHEREQUIPMENT);
			equipmentList2 = ServiceFactory.getEquipmentService().query(oldEquipmentVO, null);
			if (equipmentList2 != null && equipmentList2.size() > 0) {
				for(EquipmentVO equipVO : equipmentList2){
					if (equipVO.getEquipmentName().indexOf("录播")>-1) {
						equipmentList.add(equipVO);
					}
				}
			}
		} catch (Exception e) {
			logger.error("EquipmentControlAction		toRecorded	error："
					+ e.getMessage());
			return "FAILURE";
		}
		logger.info("EquipmentControlAction		toRecorded	end");
		return "SUCCESS";
	}
	
	
	
	
	
	public MatrixSwitchVO getMatrixSwitchVO() {
		return matrixSwitchVO;
	}

	public void setMatrixSwitchVO(MatrixSwitchVO matrixSwitchVO) {
		this.matrixSwitchVO = matrixSwitchVO;
	}

	public ArrayList<MeetingRoomVO> getRoomList() {
		return roomList;
	}

	public void setRoomList(ArrayList<MeetingRoomVO> roomList) {
		this.roomList = roomList;
	}

	public MeetingRoomVO getMeetingRoomVO() {
		return meetingRoomVO;
	}

	public void setMeetingRoomVO(MeetingRoomVO meetingRoomVO) {
		this.meetingRoomVO = meetingRoomVO;
	}

	public ArrayList<EquipmentVO> getEquipmentList() {
		return equipmentList;
	}

	public void setEquipmentList(ArrayList<EquipmentVO> equipmentList) {
		this.equipmentList = equipmentList;
	}

	public EquipmentVO getEquipmentVO() {
		return equipmentVO;
	}

	public void setEquipmentVO(EquipmentVO equipmentVO) {
		this.equipmentVO = equipmentVO;
	}

	public String getMatrixid() {
		return matrixid;
	}

	public void setMatrixid(String matrixid) {
		this.matrixid = matrixid;
	}

	public static void main(String[] args) {

	}

	public ViewScreentVO getViewScreentVO() {
		return viewScreentVO;
	}

	public void setViewScreentVO(ViewScreentVO viewScreentVO) {
		this.viewScreentVO = viewScreentVO;
	}

	public CameraVO getCameraVO() {
		return cameraVO;
	}

	public void setCameraVO(CameraVO cameraVO) {
		this.cameraVO = cameraVO;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public VideomVO getVideomVO() {
		return videomVO;
	}

	public void setVideomVO(VideomVO videomVO) {
		this.videomVO = videomVO;
	}

	public EquipmentCameraVO getEquipmentCameraVO() {
		return equipmentCameraVO;
	}

	public void setEquipmentCameraVO(EquipmentCameraVO equipmentCameraVO) {
		this.equipmentCameraVO = equipmentCameraVO;
	}

	public String getPowerStatus() {
		return powerStatus;
	}

	public void setPowerStatus(String powerStatus) {
		this.powerStatus = powerStatus;
	}

	public String getZtreeDate() {
		return ztreeDate;
	}

	public void setZtreeDate(String ztreeDate) {
		this.ztreeDate = ztreeDate;
	}

	public RoomModelVO getRoomModelVO() {
		return roomModelVO;
	}

	public void setRoomModelVO(RoomModelVO roomModelVO) {
		this.roomModelVO = roomModelVO;
	}

	public SysPowerVO getSysPowerVO() {
		return sysPowerVO;
	}

	public void setSysPowerVO(SysPowerVO sysPowerVO) {
		this.sysPowerVO = sysPowerVO;
	}
	
}