package com.zzst.centerContor.service.impl.communication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.zzst.centerContor.service.CCNetStatusTask;
import com.zzst.centerContor.service.CenterControlObjectHelp;
import com.zzst.centerContor.vo.AudioControlVO;
import com.zzst.centerContor.vo.CameraVO;
import com.zzst.centerContor.vo.LightVO;
import com.zzst.centerContor.vo.MatrixSwitchVO;
import com.zzst.centerContor.vo.PlaVO;
import com.zzst.centerContor.vo.ProjVO;
import com.zzst.centerContor.vo.RoomModelVO;
import com.zzst.centerContor.vo.SysPowerVO;
import com.zzst.centerContor.vo.UpDownScreenVO;
import com.zzst.centerContor.vo.ViewScreentVO;

/**
 * 在CCNetStatusTask内维护线程的开始、关闭
 * 
 * @author ryan
 * @since	20130801
 */
public class ReturnValueThread extends Thread{
	
	private static Logger logger = Logger.getLogger(ReturnValueThread.class
			.getName());
		
		private String ip;
		private int port;
		
		public ReturnValueThread(String ip,int port) {
			this.ip = ip;
			this.port =port;
		}
		
		 /**
		  * 发送命令并接收返回值
		  */
		@Override
		public void run() {
			this.setName("中控（"+ip+"）接受返回值");
			while(CenterControlObjectHelp.flagMap.get(ip)){
				Socket server =  CCNetStatusTask.checkConnection(ip,port);
//				try {
//					server =CenterControlObjectHelp.socketMap.get(ip); 
//					if(server==null){
//						server = new Socket(ip,port);
//						CenterControlObjectHelp.socketMap.put(ip, server);
//						Thread.sleep(500);
//					}
//				} catch (Exception e) {
//					logger.warn("检查中控（"+ip+"）的("+port+")端口通讯：异常");
//					ServerSocketEnues.removeCenterControlSocket(ip);
//					try {
//						Thread.sleep(2000);
//					} catch (InterruptedException e1) {
//						e1.printStackTrace();
//					}
//					continue;
//				}
				
				if(server!=null){
					try{
						BufferedReader in = new BufferedReader(new InputStreamReader(server
								.getInputStream()));
						String reStr=in.readLine();
						if(reStr==null||reStr.length()==0||"NULL".equalsIgnoreCase(reStr)||"icmpheartbeat".equalsIgnoreCase(reStr)){
//							logger.info("###"+reStr);
							continue;
						}
						logger.info(ip+"返回值："+reStr);
						if(reStr.indexOf("AUDIO.")==0){//音频相关返回值
							audio(reStr);	continue;
						}else if(reStr.indexOf("POWER.")==0){//系统电源相关返回值
							sysPower(reStr);	continue;
						}else if(reStr.indexOf("CAMERA.")==0){//摄像头相关返回值
							camera(reStr);	continue;
						}else if(reStr.indexOf("CURTAIN.")==0){//窗帘相关返回值
							curtain(reStr);	continue;
						}else if(reStr.indexOf("LIGHT.")==0){//灯光相关返回值
							light(reStr);	continue;
						}else if(reStr.indexOf("PLA.")==0){//等离子相关返回值
							pla(reStr);	continue;
						}else if(reStr.indexOf("PROJ.")==0){//投影机相关返回值
							proj(reStr);	continue;
						}else if(reStr.indexOf("SJP.")==0){//升降屏相关返回值
							sjp(reStr);	continue;
						}else if(reStr.indexOf("MATRIX.")==0){//矩阵相关返回值
							matrixSwitch(reStr);	continue;
						}else if(reStr.indexOf("ROOM.")==0){//会议室模式相关返回值
							room(reStr);	continue;
						}else if(reStr.indexOf("SCREENT.")==0){//会议室模式相关返回值
							screent(reStr);	continue;
						}
					}catch(Exception e){
						 CCNetStatusTask.netException(ip);
						 logger.error("系统异常："+e.getMessage());
						 try {
							Thread.sleep(500);
						} catch (InterruptedException e1) {}
					}
				}else{
					 CCNetStatusTask.netException(ip);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						logger.error("系统异常："+e.getMessage());
					}
				}
			}
		}

		private void screent(String reStr){
			String equipmentNum = reStr.substring(reStr.indexOf(".")+1,reStr.indexOf(":"));
			ViewScreentVO viewScreentVO = CenterControlObjectHelp.getViewScreentList(this.ip).get(equipmentNum);
			if(reStr.indexOf(":STATUS>ON")>0){
				viewScreentVO.setStatus(ViewScreentVO.status_on);return;
			}else if(reStr.indexOf(":STATUS>OFF")>0){
				viewScreentVO.setStatus(ViewScreentVO.status_off);return;
			}else if(reStr.indexOf(":STATUS>MODEL")>0){
				String modelType = reStr.substring(reStr.indexOf(":STATUS>MODEL")+13, reStr.length());
				String[] ss = modelType.split("-");
				if(ss.length==2){//修正前端取不到type问题 2013-07-16 ryan
					viewScreentVO.setModel(ss[0]);
					viewScreentVO.setType(ss[1]);
				}return;
			}else if(reStr.indexOf(":STATUS>TRUE")>0){
				viewScreentVO.setAvailable(true);return;
			}else if(reStr.indexOf(":STATUS>FALSE")>0){
				viewScreentVO.setAvailable(false);return;
			}
		}
		
		private void room(String reStr){
			String equipmentNum = reStr.substring(reStr.indexOf(".")+1,reStr.indexOf(":"));
			RoomModelVO roomVO = CenterControlObjectHelp.getRoomModelVOList(this.ip).get(equipmentNum);
			if(reStr.indexOf(":MODEL>STATUS>")>0){
				String model = reStr.substring(reStr.indexOf(":MODEL>STATUS>")+14,reStr.length());
				roomVO.setModel(model);	return;
			}else if(reStr.indexOf(":STATUS>TRUE")>0){
				roomVO.setAvailable(true);return;
			}else if(reStr.indexOf(":STATUS>FALSE")>0){
				roomVO.setAvailable(false);return;
			}
		}
		
		private void matrixSwitch(String reStr){
			String equipmentNum = reStr.substring(reStr.indexOf(".")+1,reStr.indexOf(":"));
			MatrixSwitchVO mv = CenterControlObjectHelp.getMatrixList(this.ip).get(equipmentNum);
			if(reStr.indexOf(">SWITCH>")>0){
//				String allSwitch = reStr.substring(reStr.indexOf(">SWITCH>")+8,reStr.length());
				mv.setAllSwitch(reStr);	return;
			}else if(reStr.indexOf(":STATUS>TRUE")>0){
				mv.setAvailable(true);return;
			}else if(reStr.indexOf(":STATUS>FALSE")>0){
				mv.setAvailable(false);return;
			}
			
		}
		
		private void sjp(String reStr){
			String equipmentNum = reStr.substring(reStr.indexOf(".")+1,reStr.indexOf(":"));
			UpDownScreenVO cv = CenterControlObjectHelp.getUpDownScreenList(this.ip).get(equipmentNum);
			if(reStr.indexOf(":STATUS>DOWN")>0){
				cv.setStatus(UpDownScreenVO.status_up);	return;
			}else if(reStr.indexOf(":STATUS>UP")>0){
				cv.setStatus(UpDownScreenVO.status_down);	return;
			}else if(reStr.indexOf(":STATUS>TRUE")>0){
				cv.setAvailable(true);return;
			}else if(reStr.indexOf(":STATUS>FALSE")>0){
				cv.setAvailable(false);return;
			}
		}
		private void proj(String reStr){
			String equipmentNum = reStr.substring(reStr.indexOf(".")+1,reStr.indexOf(":"));
			ProjVO projVO = CenterControlObjectHelp.getProjList(this.ip).get(equipmentNum);
			if(reStr.indexOf(":STATUS>ON")>0){
				projVO.setStatus(PlaVO.status_on);	return;
			}else if(reStr.indexOf(":STATUS>OFF")>0){
				projVO.setStatus(PlaVO.status_off);	return;
			}else if(reStr.indexOf(":DISPLAY>")>0){
				String type = reStr.substring(reStr.indexOf(":DISPLAY>")+9,reStr.length());
				projVO.setDisplay_type(type);	return;
			}else if(reStr.indexOf(":STATUS>TRUE")>0){
				projVO.setAvailable(true);return;
			}else if(reStr.indexOf(":STATUS>FALSE")>0){
				projVO.setAvailable(false);return;
			}
		}
		
		private void pla(String reStr){
			String equipmentNum = reStr.substring(reStr.indexOf(".")+1,reStr.indexOf(":"));
			PlaVO plaVO = CenterControlObjectHelp.getPlaList(this.ip).get(equipmentNum);
			if(reStr.indexOf("STATUS>ON")>0){
				plaVO.setStatus(PlaVO.status_on);	return;
			}else if(reStr.indexOf(":STATUS>OFF")>0){
				plaVO.setStatus(PlaVO.status_off);	return;
			}else if(reStr.indexOf(":SWITCHSTATUS>")>0){
				String num = reStr.substring(reStr.indexOf("SWITCHSTATUS>")+13,reStr.length());
				plaVO.setChannel(num);	return;
			}else if(reStr.indexOf(":STATUS>TRUE")>0){
				plaVO.setAvailable(true);return;
			}else if(reStr.indexOf(":STATUS>FALSE")>0){
				plaVO.setAvailable(false);return;
			}
		}
		
		private void light(String reStr){
			String equipmentNum = reStr.substring(reStr.indexOf(".")+1,reStr.indexOf(":"));
			LightVO lightVO = CenterControlObjectHelp.getLightList(this.ip).get(equipmentNum);
			if(reStr.indexOf(":STATUS>ON")>0){
				lightVO.setStatus(LightVO.status_on);	return;
			}else if(reStr.indexOf(":STATUS>OFF")>0){
				lightVO.setStatus(LightVO.status_off);	return;
			}else if(reStr.indexOf(":STATUS>TRUE")>0){
				lightVO.setAvailable(true);return;
			}else if(reStr.indexOf(":STATUS>FALSE")>0){
				lightVO.setAvailable(false);return;
			}
		}
		
		private void curtain(String reStr){
			 
		}
		
		private void camera(String reStr){
			String equipmentNum = reStr.substring(reStr.indexOf(".")+1,reStr.indexOf(":"));
			CameraVO cameraVO = CenterControlObjectHelp.getCameraList(this.ip).get(equipmentNum);
			
			if(reStr.indexOf(">RECALL")>0){//预置位
				String num = reStr.substring(reStr.indexOf(">RECALL")+7,reStr.length());
				cameraVO.setStore(num);	return;
			}else if(reStr.indexOf(":CAMSPEED")>0){//转速
				String speed = reStr.substring(reStr.indexOf(":CAMSPEED")+9,reStr.length());	
				cameraVO.setSpeed(speed);return;
			}else if(reStr.indexOf(">BACKLIGHT>TRUE")>0){//背光true
				cameraVO.setBackLight(true);	return;
			}else if(reStr.indexOf(">BACKLIGHT>FALSE")>0){//背光false
				cameraVO.setBackLight(false);return;	
			}else if(reStr.indexOf(">WHITEBALANCEMANUAL>")>0){
				if(reStr!=null&&reStr.indexOf(ControlCommandHelp.CAMERA_INFO_WhiteBalanceManual_STATUS[1].replaceFirst("##1",cameraVO.getId()))>=0){
					reStr = reStr.substring(reStr.indexOf("WHITEBALANCEMANUAL>".replaceFirst("##1",cameraVO.getId()))+19);
					
					String[] info = reStr.split(":");
					if(info!=null){
						if(info[0]!=null)
							cameraVO.setWhiteBalanceManual(Boolean.valueOf(info[0]));	
						if("FALSE".equalsIgnoreCase(info[0])){//FALSE手动
							if(info[1]!=null)
								cameraVO.setWhiteBalanceManualR(Integer.valueOf(info[1]));
							else
								cameraVO.setWhiteBalanceManualR(Integer.MIN_VALUE);
							if(info[2]!=null)
								cameraVO.setWhiteBalanceManualB(Integer.valueOf(info[2]));
							else
								cameraVO.setWhiteBalanceManualB(Integer.MIN_VALUE);
						}
					}
				}return;
			}else if(reStr.indexOf(">EXPOSUREMANUAL>")>0){
				if(reStr!=null&&reStr.indexOf(ControlCommandHelp.CAMERA_INFO_EXPOSUREMANUAL_STATUS[1].replaceFirst("##1",cameraVO.getId()))>=0){
					reStr = reStr.substring(reStr.indexOf("EXPOSUREMANUAL>".replaceFirst("##1",cameraVO.getId()))+15);
					
					String[] info = reStr.split(":");
					if(info!=null){
						if(info[0]!=null)
							cameraVO.setExposureManual(Boolean.valueOf(info[0]));
						
						if("FALSE".equalsIgnoreCase(info[0])){
							if(info[1]!=null)
								cameraVO.setExposureManuaGain(Integer.valueOf(info[1]));
							else
								cameraVO.setExposureManuaGain(Integer.MIN_VALUE);
							if(info[2]!=null)
								cameraVO.setExposureManuaSpeed(info[2]);
							else
								cameraVO.setExposureManuaSpeed("");
							if(info[3]!=null)
								cameraVO.setExposureManuaIris(info[3]);
							else
								cameraVO.setExposureManuaIris("");
						}
					}
				}return;
			}else if(reStr.indexOf(":STATUS>ON")>0){//自动跟踪开
				cameraVO.setAutoTrack(CameraVO.autoStack_on);	return;
			}else if(reStr.indexOf(":STATUS>OFF")>0){//自动跟踪关
				cameraVO.setAutoTrack(CameraVO.autoStack_off);return;	
			}else if(reStr.indexOf(":STATUS>TRUE")>0){
				cameraVO.setAvailable(true);return;
			}else if(reStr.indexOf(":STATUS>FALSE")>0){
				cameraVO.setAvailable(false);return;
			}
		}
		
		private void sysPower(String reStr){
			String equipmentNum = reStr.substring(reStr.indexOf(".")+1,reStr.indexOf(":"));
			SysPowerVO sysPowerVO = CenterControlObjectHelp.getSysPowerList(this.ip).get(equipmentNum);
			if(reStr.indexOf(":STATUS>ON")>0){
				sysPowerVO.setStatus(SysPowerVO.status_on);	return;
			}else if(reStr.indexOf(":STATUS>OFF")>0){
				sysPowerVO.setStatus(SysPowerVO.status_off);	return;
			}else if(reStr.indexOf(":STATUS>TRUE")>0){
				sysPowerVO.setAvailable(true);return;
			}else if(reStr.indexOf(":STATUS>FALSE")>0){
				sysPowerVO.setAvailable(false);return;
			}
		}
	
		private void audio(String reStr){
			String equipmentNum = reStr.substring(reStr.indexOf(".")+1,reStr.indexOf(":"));
			AudioControlVO audioVO = CenterControlObjectHelp.getAudioList(this.ip).get(equipmentNum);
			if(reStr.indexOf(":STATUS>MUTEON")>0){
				audioVO.setStatus(AudioControlVO.status_on);return;
			}else if(reStr.indexOf(":STATUS>MUTEOFF")>0){
				audioVO.setStatus(AudioControlVO.status_off);return;
			}else if(reStr.indexOf(":VALUE>")>0){
				audioVO.setValue(reStr.substring(reStr.indexOf(":VALUE>")+7, reStr.length()));return;
			}else if(reStr.indexOf(":STATUS>TRUE")>0){
				audioVO.setAvailable(true);return;
			}else if(reStr.indexOf(":STATUS>FALSE")>0){
				audioVO.setAvailable(false);return;
			}
			
		}
}
