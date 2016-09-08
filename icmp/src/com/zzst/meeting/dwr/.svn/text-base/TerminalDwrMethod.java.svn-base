package com.zzst.meeting.dwr;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import uk.ltd.getahead.dwr.WebContext;
import uk.ltd.getahead.dwr.WebContextFactory;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.equipmentControl.fNetTelnet;
import com.zzst.action.meeting.util.LogUtil;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.action.meeting.util.TcpClientSocket;
import com.zzst.action.meeting.util.UdpClientSocket;
import com.zzst.centerContor.service.CenterControlObject;
import com.zzst.centerContor.vo.MatrixSwitchVO;
import com.zzst.centerContor.vo.ViewScreentVO;
import com.zzst.model.enums.CenterControlEnum;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.log.LogVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.terminal.service.TerminalObject;
import com.zzst.util.ControlFactory;
import com.zzst.util.ExcuteResultVO;

public class TerminalDwrMethod {
	private static Logger logger = CjfLogger.getLogger(TerminalDwrMethod.class.getName());
	
	private ArrayList<EquipmentVO> equipmentVOList = new ArrayList<EquipmentVO>();
	/**************************************视频终端*************************************/
	public String booleanStatus(String id){
		logger.info("TerminalDwrMethod		booleanStatus		begin");
		ArrayList<EquipmentVO> list=new ArrayList<EquipmentVO>() ;
		String stautus="";
		try {
			list = ServiceFactory.getEquipmentService().queryByIDs(id);
			String ip=list.get(0).getIp();
			TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
			if(tobj==null){
				logger.info(ip+"为空");
			}else{
				stautus=tobj.getStatus().toString();
			}
			
		} catch (Exception e) {
			logger.info("TerminalDwrMethod		booleanStatus		error:"+e.getMessage());
		}
		
		
		logger.info("TerminalDwrMethod		booleanStatus		end");
		return stautus;
	}
	
	
	
	
	
	
	public ArrayList<String> booleanTerminalStatus(String data,String id,String ids,String flag){
		logger.info("TerminalDwrMethod		booleanTerminalStatus		begin");
		ArrayList<EquipmentVO> list=new ArrayList<EquipmentVO>() ;
		try {
			list = ServiceFactory.getEquipmentService().queryByIDs(ids);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String ip=list.get(0).getIp();
		TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
		String stautus=tobj.getStatus().toString();
		logger.info("TerminalDwrMethod	booleanTerminalStatus		end");
		ArrayList<String> stringList=new ArrayList<String>();
		stringList.add(data);
		stringList.add(id);
		stringList.add(stautus);
		stringList.add(flag);
		stringList.add(ids);
		return stringList;
		
	}
	
	
	public ArrayList<String> booleanNumkeyStatus(String num,String ids){
		logger.info("TerminalDwrMethod		booleanNumkeyStatus		begin");
		ArrayList<EquipmentVO> list=new ArrayList<EquipmentVO>() ;
		try {
			list = ServiceFactory.getEquipmentService().queryByIDs(ids);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String ip=list.get(0).getIp();
		TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
		String stautus=tobj.getStatus().toString();
		ArrayList<String> stringList=new ArrayList<String>();
		stringList.add(num);
		stringList.add(stautus);
		logger.info("TerminalDwrMethod		booleanNumkeyStatus		end");
		return stringList;
		
	}
		
	
	public ArrayList<String> booleanDirectekeyStatus(String num,String id,String ids){
		logger.info("TerminalDwrMethod		booleanDirectekeyStatus		begin");
		ArrayList<EquipmentVO> list=new ArrayList<EquipmentVO>() ;
		try {
			list = ServiceFactory.getEquipmentService().queryByIDs(ids);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String ip=list.get(0).getIp();
		TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
		String stautus=tobj.getStatus().toString();
		ArrayList<String> stringList=new ArrayList<String>();
		stringList.add(num);
		stringList.add(id);
		stringList.add(stautus);
		logger.info("TerminalDwrMethod		booleanDirectekeyStatus		end");
		return stringList;
		
	}
		
	/**
	 * 控制终端
	 * @param id
	 * @param mark
	 * @param values
	 * @return	boolean
	 */
	public boolean terminalControl(String id,String mark,String values){
		logger.info("TerminalDwrMethod		terminalPhone		begin");
		boolean result=true;
		String ip="";
			try{
				ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
				if(list==null||list.size()==0){
					logger.info("终端不存在");
					return false;
				}
				
				if(mark.equals("dialing")){    //呼叫
					ip=list.get(0).getIp();
					TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
					if(tobj==null){
						addLog(ip+"终端控制-画中画操作失败");
						result=false;
					}else{
						String[] val = values.split("\\.");
						if(val.length==4){
							tobj.callIP(1024,values);
							addLog(ip+"终端控制-呼叫ip"+values+"成功");
						}else{
							tobj.callPhone(values);
							addLog(ip+"终端控制-呼叫电话"+values+"成功");
						}
					}
				}else if(mark.equals("hangup")){  //挂断
					ip=list.get(0).getIp();
					TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
					tobj.hangupAll();
					addLog(ip+"终端控制-挂号操作成功");
				}
			}catch(Exception e){
				logger.error("TerminalDwrMethod		terminalPhone		error:"+e.getMessage());
				result = false;	
			}
			logger.info("TerminalDwrMethod		terminalPhone		end");
			return result;
	}
	
	
	
	
	
	public boolean controlTerminalById(String id,String values){
		logger.info("TerminalDwrMethod		controlTerminalById		begin");
		boolean result=true;
		String ip="";
		try{
			ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
			if(list==null||list.size()==0){
				logger.info("终端不存在");
				return false;
			}
			
			if(values.equals("painted")){    //画中画
					
					ip=list.get(0).getIp();
					TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
					if(tobj==null){
						addLog(ip+"终端控制-画中画操作失败");
						result=false;
					}else{
					   tobj.monitorSetViewFarOrNear("1");
						addLog(ip+"终端控制-画中画操作成功");	
					}
			}else if(values.equals("cameras")){    //摄像机
					ip=list.get(0).getIp();
					TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
					if(tobj.buttonCamera()!=true){
						addLog(ip+"终端控制-摄像机操作失败");
						result=false;
					}else{
						addLog(ip+"终端控制-摄像机操作成功");	
					}
			}else if(values.equals("content")){    //内容
					ip=list.get(0).getIp();
					TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
					if(tobj.buttonGraphics()!=true){
						addLog(ip+"终端控制-内容操作失败");	
						result=false;
					}else{
						addLog(ip+"终端控制-内容操作成功");	
					}
			}else if(values.equals("messages")){   //信息
					ip=list.get(0).getIp();
					TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
					tobj.buttonInfo();//add by ryan on 2013-0508
					addLog(ip+"终端控制-信息操作成功");
			}else if(values.equals("buttonfar")){   //远端
					ip=list.get(0).getIp();
					TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
					if(tobj.cameraMoveFar()!=true){
						addLog(ip+"终端控制-远端操作失败");
						result=false;
					}else{
						addLog(ip+"终端控制-远端操作成功");	
					}
			}else if(values.equals("buttonnear")){  //近端
					ip=list.get(0).getIp();
					TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
					if(tobj.cameraMoveNear()!=true){
						addLog(ip+"终端控制-近端操作失败");
						result=false;
					}else{
						addLog(ip+"终端控制-近端操作成功");	
					}
			}else if(values.equals("back")){   //返回
					ip=list.get(0).getIp();
					TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
					if(tobj.buttonBack()!=true){
						addLog(ip+"终端控制-返回操作失败");
						result=false;
					}else{
						addLog(ip+"终端控制-返回操作成功");	
					}
			}else if(values.equals("directory")){  //目录
					ip=list.get(0).getIp();
					TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
					if(tobj.buttonDirectory()!=true){
						addLog(ip+"终端控制-目录操作失败");
						result=false;
					}else{
						addLog(ip+"终端控制-目录操作成功");	
					}
			}else if(values.equals("home")){   //主页
					ip=list.get(0).getIp();
					TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
					if(tobj.buttonHome()!=true){
						addLog(ip+"终端控制-主页操作失败");
						result=false;
					}else{
						addLog(ip+"终端控制-主页操作成功");	
					}
			}else if(values.equals("keyboard")){  //键盘
					ip=list.get(0).getIp();
					TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
					if(tobj.buttonKeyboard()!=true){
						addLog(ip+"终端控制-键盘操作失败");
						result=false;
					}else{
						addLog(ip+"终端控制-键盘操作成功");	
					}
			}else if(values.equals("delete")){  //删除
					ip=list.get(0).getIp();
					TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
					if(tobj.buttonDelete()!=true){
						addLog(ip+"终端控制-删除操作失败");
						result=false;
					}else{
						addLog(ip+"终端控制-删除操作成功");	
					}
			}else if(values.equals("mute")){  //静音
					ip=list.get(0).getIp();
					TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
					if(tobj.buttonMute()!=true){
						addLog(ip+"终端控制-静音操作失败");
						result=false;
					}else{
						addLog(ip+"终端控制-静音操作成功");	
					}
			}else if(values.equals("dot")){  //圆点
					ip=list.get(0).getIp();
					TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
					//未实现调用圆点方法
					if(tobj.buttonPeriod()!=true){
						addLog(ip+"终端控制-圆点操作失败");	
						result = false;
					}else{
						addLog(ip+"终端控制-圆点操作成功");
					}
					
			}else if(values.equals("dialing")){  //拨号
					ip=list.get(0).getIp();
					TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
					if(tobj.buttonCallhangup()!=true){
						addLog(ip+"终端控制-拨号操作失败");
						result=false;
					}else{
						addLog(ip+"终端控制-拨号操作成功");	
					}
			}else if(values.equals("hangup")){  //挂断
					ip=list.get(0).getIp();
					TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
					if(tobj.buttonCallhangup()!=true){
						addLog(ip+"终端控制-挂号操作失败");
						result=false;
					}else{
						addLog(ip+"终端控制-挂号操作成功");	
					}
			}
		}catch (Exception e) {
			addLog(ip+"终端控制-操作异常");
			result=false;
			logger.error("操作异常："+e.getMessage());
		}
		logger.info("TerminalDwrMethod		controlTerminalById		end");
		return result;
	}
	
	
	
	//数字键
	public boolean numKeys(String id,String values){
		logger.info("TerminalDwrMethod		numKeys		begin");
		boolean result=true;
		String ip="";
		if(values.equals("1")){
			try {
				ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
				ip=list.get(0).getIp();
				TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
				if(tobj.buttonNum("1")!=true){
					result=false;
				  }
			} catch (Exception e) {
				result=false;
				e.printStackTrace();
			}
		}else if(values.equals("2")){
			try {
				ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
				ip=list.get(0).getIp();
				TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
				if(tobj.buttonNum("2")!=true){
					result=false;
				  }
			} catch (Exception e) {
				result=false;
				e.printStackTrace();
			}
			
		}else if(values.equals("3")){
			try {
				ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
				ip=list.get(0).getIp();
				TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
				if(tobj.buttonNum("3")!=true){
					result=false;
				  }
			} catch (Exception e) {
				result=false;
				e.printStackTrace();
			}
			
		}else if(values.equals("4")){
			try {
				ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
				ip=list.get(0).getIp();
				TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
				if(tobj.buttonNum("4")!=true){
					result=false;
				  }
			} catch (Exception e) {
				result=false;
				e.printStackTrace();
			}
			
		}else if(values.equals("5")){
			try {
				ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
				ip=list.get(0).getIp();
				TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
				if(tobj.buttonNum("5")!=true){
					result=false;
				  }
			} catch (Exception e) {
				result=false;
				e.printStackTrace();
			}
			
		}else if(values.equals("6")){
			try {
				ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
				ip=list.get(0).getIp();
				TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
				if(tobj.buttonNum("6")!=true){
					result=false;
				  }
			} catch (Exception e) {
				result=false;
				e.printStackTrace();
			}
			
		}else if(values.equals("7")){
			try {
				ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
				ip=list.get(0).getIp();
				TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
				if(tobj.buttonNum("7")!=true){
					result=false;
				  }
			} catch (Exception e) {
				result=false;
				e.printStackTrace();
			}
			
		}else if(values.equals("8")){
			try {
				ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
				ip=list.get(0).getIp();
				TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
				if(tobj.buttonNum("8")!=true){
					result=false;
				  }
			} catch (Exception e) {
				result=false;
				e.printStackTrace();
			}
			
		}else if(values.equals("9")){
			try {
				ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
				ip=list.get(0).getIp();
				TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
				if(tobj.buttonNum("9")!=true){
					result=false;
				  }
			} catch (Exception e) {
				result=false;
				e.printStackTrace();
			}
			
		}else if(values.equals("0")){
			try {
				ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
				ip=list.get(0).getIp();
				TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
				if(tobj.buttonNum("0")!=true){
					result=false;
				  }
			} catch (Exception e) {
				result=false;
				e.printStackTrace();
			}
			
		}else if(values.equals("#")){
			try {
				ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
				ip=list.get(0).getIp();
				TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
				if(tobj.buttonNum("#")!=true){
					result=false;
				  }
			} catch (Exception e) {
				result=false;
				e.printStackTrace();
			}
			
		}else if(values.equals("*")){
			try {
				ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
				ip=list.get(0).getIp();
				TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
				if(tobj.buttonNum("*")!=true){
					result=false;
				  }
			} catch (Exception e) {
				result=false;
				e.printStackTrace();
			}
			
		}
		logger.info("TerminalDwrMethod		numKeys		end");
		return result;
	}
	//方向键
	public boolean directionKey(String id,String values){
		boolean result=true;
		String ip="";
		if(values.equals("up")){
			try {
				ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
				ip=list.get(0).getIp();
				TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
				if(tobj.buttonUp()!=true){
					result=false;
				}
			} catch (Exception e){
				    result=false;
				e.printStackTrace();
			}
		}else if(values.equals("down")){	
			try {
				ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
				ip=list.get(0).getIp();
				TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
				if(tobj.buttonDown()!=true){
					result=false;
				}
			} catch (Exception e) {
				result=false;
				e.printStackTrace();
			}
		}else if(values.equals("centers")){
			try {
				ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
				ip=list.get(0).getIp();
				TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
				if(tobj.buttonSelect()!=true){
					result=false;
				}
			} catch (Exception e) {
				result=false;
				e.printStackTrace();
			}
		}else if(values.equals("lefts")){
			try {
				ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
				ip=list.get(0).getIp();
				TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
				if(tobj.buttonLeft()!=true){
					result=false;
				}
			} catch (Exception e) {
				result=false;
				e.printStackTrace();
			}
			
		}else if(values.equals("rights")){
			try {
				ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
				ip=list.get(0).getIp();
				TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
				if(tobj.buttonRight()!=true){
					result=false;
				}
			} catch (Exception e) {
				result=false;
				e.printStackTrace();
			}
			
		}
		return result;
	}
	//方向键鼠标移开
	public boolean undirectionKey(String id,String values){
		boolean result=true;
		ArrayList<EquipmentVO> list;
		try {
			list = ServiceFactory.getEquipmentService().queryByIDs(id);
			TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(list.get(0).getIp());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	//2015-09-27方向键控制摄像机
	public boolean directionKeyCamera(String id,String values){
		boolean result=true;
		String ip="";
		if(values.equals("up")){
			try {
				ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
				ip=list.get(0).getIp();
				TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
				if(tobj.cameraMoveUp()!=true){
					result=false;
				}
			} catch (Exception e){
				    result=false;
				e.printStackTrace();
			}
		}else if(values.equals("down")){	
			try {
				ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
				ip=list.get(0).getIp();
				TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
				if(tobj.cameraMoveDown()!=true){
					result=false;
				}
			} catch (Exception e) {
				result=false;
				e.printStackTrace();
			}
		}else if(values.equals("centers")){
			try {
				ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
				ip=list.get(0).getIp();
				TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
				if(tobj.buttonSelect()!=true){
					result=false;
				}
			} catch (Exception e) {
				result=false;
				e.printStackTrace();
			}
		}else if(values.equals("lefts")){
			try {
				ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
				ip=list.get(0).getIp();
				TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
				if(tobj.cameraMoveLeft()!=true){
					result=false;
				}
			} catch (Exception e) {
				result=false;
				e.printStackTrace();
			}
			
		}else if(values.equals("rights")){
			try {
				ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
				ip=list.get(0).getIp();
				TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
				if(tobj.cameraMoveRight()!=true){
					result=false;
				}
			} catch (Exception e) {
				result=false;
				e.printStackTrace();
			}
			
		}
		return result;
	}
	
	//2015-09-27方向键控制摄像机停止
	public boolean directionKeyCameraStop(String id){
		boolean result=true;
		String ip="";
		try {
			ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryByIDs(id);
			ip=list.get(0).getIp();
			TerminalObject tobj = (TerminalObject)ControlFactory.getTerminalObject(ip);
			if(tobj.cameraMoveStop()!=true){
				result=false;
			}
		} catch (Exception e){
			    result=false;
			e.printStackTrace();
		}
		return result;
	}
	
	/*******************************************矩阵************************************************************/
	
	public boolean matriSwitchesByIP(String meetingID,String MatriID,String inputValues,String outputValues){
		//MeetingRoomVO meetingRoomVO=ServiceFactory.getMeetingRoomService().queryByID(meetingID);
		boolean result=true;
		EquipmentVO equipmentVO=new EquipmentVO();
		String ccIp = "";
	   if(meetingID!=null&& !meetingID.equals("")){
		 equipmentVO.getMeetingRoomVO().setMeetingRoomID(meetingID);
		}
		equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
		ArrayList<EquipmentVO> list;
		//String[][] out = null;
		try {
			list = ServiceFactory.getEquipmentService().query(equipmentVO, null);
			CenterControlObject obj = (CenterControlObject)ControlFactory.getCenterControlObject(list.get(0).getIp());
			ccIp = list.get(0).getIp();
			String[] outputValue=outputValues.split(",");
			for(int i=0;i<outputValue.length;i++){
				if(outputValue.length>0){
				   if(outputValue.length==1){
					   ExcuteResultVO resultVO = obj.matrixSwitch(MatriID, inputValues, outputValues);
				  	 if(!resultVO.isSuccess()){
						result=false;
					}
				   }else{
					   ExcuteResultVO resultVO= obj.matrixSwitch(MatriID, inputValues, outputValue[i]);
						 if(!resultVO.isSuccess()){
								result=false;
						}
				   }
				}
			}
		 //	(MatrixSwitchVO)resultVO.getObject();
			//ExcuteResultVO resultVO = obj.viewScreentModelStatus("1");
		} catch (Exception e) {
			e.printStackTrace();
			result=false;
			logger.error("TerminalDwrMethod		matriSwitchesByIP		erro："+e.getMessage());
		}
		String[] infos = LogUtil.getMeetingRoomNameandEquimentName(ccIp,MatriID,CenterControlEnum.type_matrix_id);
		String info = infos[0]+"("+ccIp+")"+infos[1]+"--矩阵切换";
		if(result){
			LogUtil.addLogForOperate(info+"成功");
		}else{
			LogUtil.addLogForOperate(info+"失败");
		}
		return result;
	}
	/**
	 * add by xiongshun提取矩阵上输入对应的输出列表
	 * @param ccip
	 * @param MatriID
	 * @param inputValues
	 * @return
	 */
	public String matriSwitchOut(String ccip,String MatriID,String inputValues){
		try {
			//调用中控接口
			CenterControlObject obj = (CenterControlObject) ControlFactory
					.getCenterControlObject(ccip);
			//提取矩阵上输入对应的输出列表
			ExcuteResultVO vo = obj.matrixSwitchOut(MatriID, inputValues);
			ArrayList outList = (ArrayList) vo.getObject();
			String outputValues = "";
			if(vo.isSuccess()&&outList!=null&&outList.size()>0){
				for(int i=0;i<outList.size();i++){
					outputValues += outList.get(i);
					outputValues += ",";
				}
				logger.info("矩阵的输入"+inputValues+"，对应的输出为："+outputValues);
				return outputValues;
			}
			
			
		 //	(MatrixSwitchVO)resultVO.getObject();
			//ExcuteResultVO resultVO = obj.viewScreentModelStatus("1");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("TerminalDwrMethod		matriSwitchOut		erro："+e.getMessage());
		}
		return null;
	}
	
/*******************************************矩阵网控************************************************************/
	
	public String matriSwitchesByNet(String meetingID,String equipmentID,String inputValues,String outputValues){
		//MeetingRoomVO meetingRoomVO=ServiceFactory.getMeetingRoomService().queryByID(meetingID);
		EquipmentVO equipmentVO=new EquipmentVO();
//		String ccIp = "";
//	   if(meetingID!=null&& !meetingID.equals("")){
//		 equipmentVO.getMeetingRoomVO().setMeetingRoomID(meetingID);
//		}
//	   equipmentVO.setEquipmentID(equipmentID);
//		equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
		ArrayList<EquipmentVO> list;
		//String[][] out = null;
		try {
//			list = ServiceFactory.getEquipmentService().query(equipmentVO, null);
//			CenterControlObject obj = (CenterControlObject)ControlFactory.getCenterControlObject(list.get(0).getIp());
//			ccIp = list.get(0).getIp();
//			String[] outputValue=outputValues.split(",");
//			for(int i=0;i<outputValue.length;i++){
//				if(outputValue.length>0){
//				   if(outputValue.length==1){
//					   ExcuteResultVO resultVO = obj.matrixSwitch(MatriID, inputValues, outputValues);
//				  	 if(!resultVO.isSuccess()){
//						result=false;
//					}
//				   }else{
//					   ExcuteResultVO resultVO= obj.matrixSwitch(MatriID, inputValues, outputValue[i]);
//						 if(!resultVO.isSuccess()){
//								result=false;
//						}
//				   }
//				}
//			}
			equipmentVO = ServiceFactory.getEquipmentService().queryByID(equipmentID);
			String[] outputValue=outputValues.split(",");
			String returninfo = "";
			if(equipmentVO!=null && equipmentVO.getEquipmentName().indexOf("捷控")>-1) {
				for(int i=0;i<outputValue.length;i++){
					if(outputValue.length>0){
//						System.out.println("捷控==="+inputValues+"V"+outputValues+".");
//					   if(outputValue.length==1){
//						   returninfo = new UdpClientSocket().sendMessage(equipmentVO.getIp(), equipmentVO.getPort(), inputValues+"V"+outputValues+".");
//					   }else{
//						   returninfo = new UdpClientSocket().sendMessage(equipmentVO.getIp(), equipmentVO.getPort(), inputValues+"V"+outputValue[i]+".");
//					   }
//						String all = outputValues.replaceAll("!", ",");
						String outInfo = outputValues.replaceAll("!", ",");
						returninfo = new UdpClientSocket().sendMessage(equipmentVO.getIp(), equipmentVO.getPort(), inputValues+"V"+outInfo+".");
					}
				}
			}else if(equipmentVO!=null && equipmentVO.getEquipmentName().indexOf("快捷")>-1) {
				for(int i=0;i<outputValue.length;i++){
					if(outputValue.length>0){
//						System.out.println("快捷==="+inputValues+"V"+outputValues+".");
//					   if(outputValue.length==1){
//						   returninfo = new TcpClientSocket().sendMessage(equipmentVO.getIp(), equipmentVO.getPort(), inputValues+"V"+outputValues+".");
//					   }else{
//						   returninfo = new TcpClientSocket().sendMessage(equipmentVO.getIp(), equipmentVO.getPort(), inputValues+"V"+outputValue[i]+".");
//					   }
						String outInfo = outputValues.replaceAll("!", ",");
						returninfo = new TcpClientSocket().sendMessage(equipmentVO.getIp(), equipmentVO.getPort(), inputValues+"V"+outInfo+".");
					}
				}
			}
			
			if(returninfo==null || returninfo.length()==0){
				return "矩阵无响应，请重试！";
			}else if(returninfo.contains("No route to host: connect")){
				return "矩阵无法连通！";
			}else if(returninfo.contains("Connection timed out: connect")){
				return "矩阵无法连通！";
			}else{
				return "success";
			}
			
//			new UdpClientSocket().sendMessage(equipmentVO.getIp(), equipmentVO.getPort(), inputValues+"V"+outputValues+".");
		 //	(MatrixSwitchVO)resultVO.getObject();
			//ExcuteResultVO resultVO = obj.viewScreentModelStatus("1");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("TerminalDwrMethod		matriSwitchesByIP		erro："+e.getMessage());
		}
//		String[] infos = LogUtil.getMeetingRoomNameandEquimentName(ccIp,MatriID,CenterControlEnum.type_matrix_id);
//		String info = infos[0]+"("+ccIp+")"+infos[1]+"--矩阵切换";
//		if(result){
//			LogUtil.addLogForOperate(info+"成功");
//		}else{
//			LogUtil.addLogForOperate(info+"失败");
//		}
		return "";
	}
	
	/**
	 * add by xiongshun提取矩阵上输入对应的输出列表
	 * @param ccip
	 * @param MatriID
	 * @param inputValues
	 * @return
	 */
	public String matriSwitchOutNet(String ccip,String equipmentID,String inputValues){
		try {
			/**
			EquipmentVO equipmentVO=new EquipmentVO();
			String ccIp = "";
			ArrayList<EquipmentVO> list;
				equipmentVO = ServiceFactory.getEquipmentService().queryByID(equipmentID);
				String returninfo = "";
				if(equipmentVO!=null && equipmentVO.getEquipmentName().indexOf("捷控")>-1) {
					returninfo = new UdpClientSocket().sendMessage(equipmentVO.getIp(), equipmentVO.getPort(), "Status"+inputValues);
					if(returninfo==null || returninfo.length()==0){
						return null;
					}else{
						String outputValues = "";
//							for(int i=0;i<outList.size();i++){
//								outputValues += outList.get(i);
//								outputValues += ",";
//							}
							logger.info("矩阵的输入"+inputValues+"，对应的输出为："+outputValues);
							return outputValues;
					}
				}else if(equipmentVO!=null && equipmentVO.getEquipmentName().indexOf("快捷")>-1) {
//					for(int i=0;i<outputValue.length;i++){
//						if(outputValue.length>0){
//							System.out.println("快捷===Status"+inputValues+".");
////						   if(outputValue.length==1){
////							   returninfo = new TcpClientSocket().sendMessage(equipmentVO.getIp(), equipmentVO.getPort(), inputValues+"V"+outputValues+".");
////						   }else{
////							   returninfo = new TcpClientSocket().sendMessage(equipmentVO.getIp(), equipmentVO.getPort(), inputValues+"V"+outputValue[i]+".");
////						   }
//							returninfo = new TcpClientSocket().sendMessage(equipmentVO.getIp(), equipmentVO.getPort(), inputValues+"V"+outputValue[i]+".");
//							if(returninfo==null || returninfo.length()==0){
//								return false;
//							}
//						}
//					}
				}
			*/
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("TerminalDwrMethod		matriSwitchOut		erro："+e.getMessage());
		}
		return null;
	}
	
	/*******************************************大屏监控************************************************************/
    
	public boolean bigscreenChoose(String bgID,String modelID,String MatriID,String inputValues,String outputValues){
		boolean result=true;
		//String[][] out = null;
		try {
			CenterControlObject obj = (CenterControlObject)ControlFactory.getCenterControlObject(bgID);
			String[] outputValue=outputValues.split(",");
			for(int i=0;i<outputValue.length;i++){
			   if(outputValue.length==1){
				   ExcuteResultVO resultVO = obj.viewScreentModelSwitch(MeetingAppConfig.CC_DEF_ID, modelID, MatriID, inputValues, outputValues);
			  	 if(!resultVO.isSuccess()){
					result=false;
				}
			   }else{
				   ExcuteResultVO resultVO= obj.matrixSwitch(MatriID, inputValues, outputValue[i]);
				   Thread.sleep(400);
					 if(!resultVO.isSuccess()){
							result=false;
					}
			   }
			}
		 //	(MatrixSwitchVO)resultVO.getObject();
			//ExcuteResultVO resultVO = obj.viewScreentModelStatus("1");
		} catch (Exception e) {
			e.printStackTrace();
			result=false;
			logger.error("TerminalDwrMethod		matriSwitchesByIP		erro："+e.getMessage());
		}
		return result;
	}
	
	public String bigscreenMonitor(String ips,String valuess){
    	String result="";
//        ArrayList<EquipmentVO> list;
//        EquipmentVO equipmentVO=new EquipmentVO();
//        equipmentVO.setIp(ips);
        try {
//			list = ServiceFactory.getEquipmentService().query(equipmentVO, null);
//            equipmentVO=list.get(0);
			CenterControlObject obj = (CenterControlObject)ControlFactory.getCenterControlObject(ips);
			ExcuteResultVO resultVO=obj.viewScreentModel("1", valuess);
	    	//ExcuteResultVO resultVO = obj.viewScreentModelStatus("1");
			if(resultVO != null && resultVO.isSuccess()){
				result = ips;
				//ViewScreentVO vsVO = (ViewScreentVO)resultVO.getObject();
			    //equipmentVO.setDescription(vsVO.getModel());
			}else{
				result="";
			}
		}catch (Exception e) {
			 result="";
			e.printStackTrace();
		}
    	return result;
    }
    
	 public MatrixSwitchVO bigscreenInputBefore(String ips,String id){
		    MatrixSwitchVO matrixSwitchVO = null;
		    ArrayList<MatrixSwitchVO> list;
	        try {
	        	CenterControlObject obj = (CenterControlObject)ControlFactory.getCenterControlObject(ips);
	    		 list = obj.getMatrixSwitchList();
	    		 matrixSwitchVO=new MatrixSwitchVO();
	    		//	System.out.print("输入"+list.get(0).getIn());
	    		if(list != null && list.size() > 0){
	    			if(id!= null){
	    				for(MatrixSwitchVO switchVO : list){
	    					if(switchVO.getId().equals(id)){
	    						matrixSwitchVO = switchVO;
	    						//list.add(matrixSwitchVO);
	    						break;
	    					}
	    				}
	    			}else{
	    				matrixSwitchVO = list.get(0);
	    			}
	    		
	    		}
			}catch (Exception e) {
				e.printStackTrace();
			}
	    	return matrixSwitchVO;
	    }
    
    
    
    
	public ArrayList<EquipmentVO> getEquipmentVOList() {
		return equipmentVOList;
	}

	public void setEquipmentVOList(ArrayList<EquipmentVO> equipmentVOList) {
		this.equipmentVOList = equipmentVOList;
	}
	
	/**
	 * 添加操作日志
	 * @param operatorContent
	 */
	private void addLog(String operatorContent){
		try{
			WebContext ctx = WebContextFactory.get(); 
			HttpSession session = ctx.getHttpServletRequest().getSession(); 

			UserVO userVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);

			LogVO vLogVO = new LogVO();
			vLogVO.setLogType(LogEnum.TYPE_CONTROL_OPERATION);
			vLogVO.setUserIP(ctx.getHttpServletRequest().getRemoteHost());
			vLogVO.setUserID(userVO.getUserID());
			vLogVO.setUserName(userVO.getName());
			if(operatorContent!=null&&operatorContent.length()>0){
				vLogVO.setOperatorContent(operatorContent);	
			}
//			ServiceFactory.getLogService().add(vLogVO);
			LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
		}catch(Exception e){
			
		}
	}
	
	public EquipmentVO changeScreent(String ips,String valuess){
		EquipmentVO eqVO = new EquipmentVO();
		String[] choose_model = valuess.split("-");
        try {
        	CenterControlObject obj = (CenterControlObject) ControlFactory.getCenterControlObject(ips);
        	ExcuteResultVO resultVO = obj.viewScreentModelStatus(MeetingAppConfig.CC_DEF_ID);
        	if(resultVO != null && resultVO.isSuccess()){
        		ViewScreentVO vsVO = (ViewScreentVO)resultVO.getObject();
        		vsVO.setModel(choose_model[0]);
        		vsVO.setType(choose_model[1]);
        		String screenModelViewStr = vsVO.getModelViewStr(40);
				eqVO.setDescriptionNew(screenModelViewStr);
				eqVO.setDescription(valuess);
				eqVO.setIp(ips);
				eqVO.setEquipmentNO(vsVO.getModelSwitchOutPort(valuess));
        	}
		}catch (Exception e) {
			eqVO=null;
			e.printStackTrace();
		}
    	return eqVO;
    }
	
	//录播服务器控制--开始--guohn--20151024
	public String recorded(String id, String type){
		
		String result = "";
		try {
			EquipmentVO equ = ServiceFactory.getEquipmentService().queryByID(id);
			if(equ != null){
				result = fNetTelnet.execCommand(equ.getIp(), equ.getPort(), equ.getEquroomID(), equ.getLoginName(), equ.getPassword(), type);
			}
		} catch (Exception e) {
			logger.error("TerminalDwrMethod		recorded		erro："+e.getMessage());
		}
		
		return result;
	}
	//录播服务器控制--结束--guohn--20151024
}
