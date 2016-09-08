package com.zzst.centerContor.service.impl;

import org.apache.log4j.Logger;
import org.hibernate.dialect.IngresDialect;

import com.zzst.centerContor.service.impl.communication.CenterControlClientThread;
import com.zzst.centerContor.service.impl.communication.CommandHelp;
import com.zzst.centerContor.service.impl.communication.ControlCommandHelp;
import com.zzst.centerContor.vo.CameraVO;
import com.zzst.util.ExcuteResultVO;


/**
 *@Description	摄像头控制
 *@date 2011-12-31上午09:51:29
 *@author ryan
 */
public class CameraControlImpl {
	private static Logger logger = Logger.getLogger(CameraControlImpl.class
			.getName());
	
	private String centerControlIP  ;
	private int centerControlPort  ;
	private CameraVO cameraVO  ;
	
	private ExcuteResultVO resultVO = new ExcuteResultVO();
	
	public CameraControlImpl(String ip,int port,CameraVO cameraVO){
		this.centerControlIP = ip;
		this.centerControlPort = port;
		this.cameraVO = cameraVO;
	}
	
	
	
	public ExcuteResultVO cameraStop() {
		logger.info("摄像头设备控制：cameraStop		begin");
		String command  = null;
		//String id = cameraVO.getId();//id ! stop,up
		/*String id = ids.split("!")[0];
		String op = ids.split(",")[1];*/
		//command = CommandHelp.ml[Integer.parseInt(id)]+",";
		/*if(id.equals("42")||id.equals("43")||id.equals("44")){//党组
			if(op.equals("right")){
				command = CommandHelp.ml[98];
			}else if(op.equals("left")){
				command = CommandHelp.ml[97];
			}else if(op.equals("down")){
				command = CommandHelp.ml[96];
			}else if(op.equals("up")){
				command = CommandHelp.ml[95];
			}
		}else if(id.equals("40")||id.equals("41")){//中型
			if(op.equals("right")){
				command = CommandHelp.ml[48];
			}else if(op.equals("left")){
				command = CommandHelp.ml[47];
			}else if(op.equals("down")){
				command = CommandHelp.ml[46];
			}else if(op.equals("up")){
				command = CommandHelp.ml[45];
			}
		}*/
		
			command = CommandHelp.cammeraStop+",";
		
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command))
				resultVO.setSuccess(true);
		}catch(Exception e){
			resultVO.setDes(e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：cameraStop		end");
		return resultVO;
	}
	
	public ExcuteResultVO cameraDown() {
		logger.info("摄像头设备控制：cameraDown		begin");
		String command  = null;
		String ids = cameraVO.getId();
		if(CommandHelp.floorNum.equals("13F")){//13F
			if(ids.equals("42")||ids.equals("43")||ids.equals("44")){//党组
				command = CommandHelp.ml[96];
			}else if(ids.equals("40")||ids.equals("41")){//中型
				command = CommandHelp.ml[46];
			}
		}else if(CommandHelp.floorNum.equals("12F")){
			command = CommandHelp.ml[158];
		}
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command))
				resultVO.setSuccess(true);
		}catch(Exception e){
			resultVO.setDes(e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：cameraDown		end");
		return resultVO;
	}

	public ExcuteResultVO cameraGetSpeed() {
		logger.info("摄像头设备控制：cameraGetSpeed		begin");
		String command  = ControlCommandHelp.CAMERA_GETSPEED[0].replaceFirst("##1", cameraVO.getId());
		try{
			new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command);
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("异常："+e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：cameraGetSpeed		end");
		return resultVO;
	}


	public ExcuteResultVO cameraLeft() {
		logger.info("摄像头设备控制：cameraLeft		begin");
		String command  = null;
		String ids = cameraVO.getId();
		if(CommandHelp.floorNum.equals("13F")){//13F
			if(ids.equals("42")||ids.equals("43")||ids.equals("44")){//党组
				command = CommandHelp.ml[97];
			}else if(ids.equals("40")||ids.equals("41")){//中型
				command = CommandHelp.ml[47];
			}
		}else if(CommandHelp.floorNum.equals("12F")){
			command = CommandHelp.ml[159];
		}
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command))
				resultVO.setSuccess(true);
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：cameraLeft		end");
		return resultVO;
	}


	public ExcuteResultVO cameraRight() {
		logger.info("摄像头设备控制：cameraRight		begin");
		String command  = null;
		String ids = cameraVO.getId();
		if(CommandHelp.floorNum.equals("13F")){//13F
			if(ids.equals("42")||ids.equals("43")||ids.equals("44")){//党组
				command = CommandHelp.ml[98];
			}else if(ids.equals("40")||ids.equals("41")){//中型
				command = CommandHelp.ml[48];
			}
		}else if(CommandHelp.floorNum.equals("12F")){
			command = CommandHelp.ml[160];
		}
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command))
				resultVO.setSuccess(true);
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：cameraRight		end");
		return resultVO;
	}


	public ExcuteResultVO cameraSetSpeed(String num) {
		logger.info("摄像头设备控制：cameraSetSpeed		begin");
		String command  = ControlCommandHelp.CAMERA_SETSPEED[0].replaceFirst("##1", cameraVO.getId());
		command  = command.replaceFirst("##2", num);
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
				cameraVO.setSpeed(num);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("异常："+e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：cameraSetSpeed		end");
		return resultVO;
	}

	public ExcuteResultVO cameraRecall(String num) {
		//this.cameraVO
		logger.info("摄像头设备控制：cameraRecall		begin");
		/*String command  = ControlCommandHelp.CAMERA_RECALL[0].replaceFirst("##1", cameraVO.getId());
		command  = command.replaceFirst("##2", num);*/
		String command  = null;
		String ids = cameraVO.getId();
		int index = 0;
		if(CommandHelp.floorNum.equals("13F")){//13F
			if(ids.equals("42")||ids.equals("43")||ids.equals("44")){//党组
				switch (Integer.parseInt(num)) {
					case 1:index=103;break;
					case 2:index=104;break;
					case 3:index=105;break;
					case 4:index=106;break;
					case 5:index=107;break;
					case 6:index=108;break;
					case 7:index=109;break;
					case 8:index=110;break;
				};
				CommandHelp.sendCommands.put(CommandHelp.sendCommands.size(), CommandHelp.ml[102]);
				command = CommandHelp.ml[index];
			}else if(ids.equals("40")||ids.equals("41")){//中型
				switch (Integer.parseInt(num)) {
					case 1:index=53;break;
					case 2:index=54;break;
					case 3:index=55;break;
					case 4:index=56;break;
					case 5:index=57;break;
					case 6:index=58;break;
					case 7:index=59;break;
					case 8:index=60;break;
					case 9:index=61;break;
					case 10:index=62;break;
				};
				CommandHelp.sendCommands.put(CommandHelp.sendCommands.size(), CommandHelp.ml[52]);
				command = CommandHelp.ml[index];
			}
		}else if(CommandHelp.floorNum.equals("12F")){
			switch (Integer.parseInt(num)) {
				case 1:index=165;break;
				case 2:index=166;break;
				case 3:index=167;break;
				case 4:index=168;break;
				case 5:index=169;break;
				case 6:index=170;break;
				case 7:index=171;break;
				case 8:index=172;break;
			};
			CommandHelp.sendCommands.put(CommandHelp.sendCommands.size(), CommandHelp.ml[164]);
			command = CommandHelp.ml[index];
		}
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				cameraVO.setStore(num);
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("异常："+e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：cameraRecall		end");
		return resultVO;
	}
	
	//存储当前位置为预置位
	public ExcuteResultVO cameraStore(String num) {
		logger.info("摄像头设备控制：cameraStore		begin");
		/*String command  = ControlCommandHelp.CAMERA_STORE[0].replaceFirst("##1", cameraVO.getId());
		command  = command.replaceFirst("##2", num);*/
		String command  = null;
		String ids = cameraVO.getId();
		int index = 0;
		if(CommandHelp.floorNum.equals("13F")){//13F
			if(ids.equals("42")||ids.equals("43")||ids.equals("44")){//党组
				switch (Integer.parseInt(num)) {
					case 1:index=103;break;
					case 2:index=104;break;
					case 3:index=105;break;
					case 4:index=106;break;
					case 5:index=107;break;
					case 6:index=108;break;
					case 7:index=109;break;
					case 8:index=110;break;
				};
				CommandHelp.sendCommands.put(CommandHelp.sendCommands.size(), CommandHelp.ml[101]);
				command = CommandHelp.ml[index];
			}else if(ids.equals("40")||ids.equals("41")){//中型
				switch (Integer.parseInt(num)) {
					case 1:index=53;break;
					case 2:index=54;break;
					case 3:index=55;break;
					case 4:index=56;break;
					case 5:index=57;break;
					case 6:index=58;break;
					case 7:index=59;break;
					case 8:index=60;break;
					case 9:index=61;break;
					case 10:index=62;break;
				};
				CommandHelp.sendCommands.put(CommandHelp.sendCommands.size(), CommandHelp.ml[51]);
				command = CommandHelp.ml[index];
			}
		}else if(CommandHelp.floorNum.equals("12F")){
			switch (Integer.parseInt(num)) {
				case 1:index=165;break;
				case 2:index=166;break;
				case 3:index=167;break;
				case 4:index=168;break;
				case 5:index=169;break;
				case 6:index=170;break;
				case 7:index=171;break;
				case 8:index=172;break;
			};
			CommandHelp.sendCommands.put(CommandHelp.sendCommands.size(), CommandHelp.ml[163]);
			command = CommandHelp.ml[index];
		}
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("异常："+e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：cameraStore		end");
		return resultVO;
	}


	public ExcuteResultVO cameraUp() {
		logger.info("摄像头设备控制：cameraUp		begin");
		String command  = null;//ControlCommandHelp.CAMERA_UP[0].replaceFirst("##1", cameraVO.getId());
		String ids = cameraVO.getId();
		if(CommandHelp.floorNum.equals("13F")){//13F
			if(ids.equals("42")||ids.equals("43")||ids.equals("44")){//党组
				command = CommandHelp.ml[95];
			}else if(ids.equals("40")||ids.equals("41")){//中型
				command = CommandHelp.ml[45];
			}
		}else if(CommandHelp.floorNum.equals("12F")){
			command = CommandHelp.ml[157];
		}
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command))
				resultVO.setSuccess(true);
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：cameraUp		end");
		return resultVO;
	}
	
	public ExcuteResultVO zoomAdd() {
		logger.info("摄像头设备控制：zoomAdd		begin");
		//String command  = ControlCommandHelp.CAMERA_ZOOM_ADD[0].replaceFirst("##1", cameraVO.getId());
		String command  = null;
		String ids = cameraVO.getId();
		if(CommandHelp.floorNum.equals("13F")){//13F
			if(ids.equals("42")||ids.equals("43")||ids.equals("44")){//党组
				command = CommandHelp.ml[99];
			}else if(ids.equals("40")||ids.equals("41")){//中型
				command = CommandHelp.ml[49];
			}
		}else if(CommandHelp.floorNum.equals("12F")){
			command = CommandHelp.ml[161];
		}
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command))
				resultVO.setSuccess(true);
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：zoomAdd		end");
		return resultVO;
	}
	
	public ExcuteResultVO zoomSubtract() {
		logger.info("摄像头设备控制：zoomSubtract		begin");
		//String command  = ControlCommandHelp.CAMERA_ZOOM_SUBTRACT[0].replaceFirst("##1", cameraVO.getId());
		String command  = null;
		String ids = cameraVO.getId();
		if(CommandHelp.floorNum.equals("13F")){//13F
			if(ids.equals("42")||ids.equals("43")||ids.equals("44")){//党组
				command = CommandHelp.ml[100];
			}else if(ids.equals("40")||ids.equals("41")){//中型
				command = CommandHelp.ml[50];
			}
		}else if(CommandHelp.floorNum.equals("12F")){
			command = CommandHelp.ml[162];
		}
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command))
				resultVO.setSuccess(true);
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：zoomSubtract		end");
		return resultVO;
	}
	
	public ExcuteResultVO cameraAutoTrackGetStatus() {
		logger.info("摄像头设备控制：cameraAutoTrackStatus		begin");
		String command  = ControlCommandHelp.CAMERA_AUTO_TRACK_STATUS[0].replaceFirst("##1", cameraVO.getId());
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command))
				resultVO.setSuccess(true);
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：cameraAutoTrackStatus		end");
		return resultVO;
	}
	
	public ExcuteResultVO cameraAutoTrackOff() {
		logger.info("摄像头设备控制：cameraAutoTrackOff		begin");
		//String command  = ControlCommandHelp.CAMERA_AUTO_TRACK_OFF[0].replaceFirst("##1", cameraVO.getId());
		String command  = null;
		String ids = cameraVO.getId();
		if(CommandHelp.floorNum.equals("13F")){//13F
			if(ids.equals("42")||ids.equals("43")||ids.equals("44")){//党组
				command = CommandHelp.ml[113];
			}else if(ids.equals("40")||ids.equals("41")){//中型
				command = CommandHelp.ml[115];
			}
		}else if(CommandHelp.floorNum.equals("12F")){
			command = CommandHelp.ml[177];
		}
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				cameraVO.setAutoTrack(CameraVO.autoStack_off);	
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：cameraAutoTrackOff		end");
		return resultVO;
	}
	
	public ExcuteResultVO cameraAutoTrackOn() {//开启跟踪
		logger.info("摄像头设备控制：cameraAutoTrackOn		begin");
		//String command  = ControlCommandHelp.CAMERA_AUTO_TRACK_ON[0].replaceFirst("##1", cameraVO.getId());
		String command  = null;//ControlCommandHelp.CAMERA_UP[0].replaceFirst("##1", cameraVO.getId());
		String ids = cameraVO.getId();
		if(CommandHelp.floorNum.equals("13F")){//13F
			if(ids.equals("42")||ids.equals("43")||ids.equals("44")){//党组
				command = CommandHelp.ml[112];
			}else if(ids.equals("40")||ids.equals("41")){//中型
				command = CommandHelp.ml[114];
			}
		}else if(CommandHelp.floorNum.equals("12F")){
			command = CommandHelp.ml[176];
		}
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				cameraVO.setAutoTrack(CameraVO.autoStack_on);
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：cameraAutoTrackOn		end");
		return resultVO;
	}
	

	public ExcuteResultVO cameraeBackLight(boolean b) {
		logger.info("摄像头设备控制：cameraeBackLight		begin");
		String command  = ControlCommandHelp.CAMERA_INFO_BACKLIGHT[0].replaceFirst("##1", cameraVO.getId());
		command = command.replaceFirst("##2", b+"");
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				cameraVO.setBackLight(b);
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("异常："+e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：cameraeBackLight		end");
		return resultVO;
	}

	public ExcuteResultVO cameraeBackLightStatus() {
		logger.info("摄像头设备控制：cameraeBackLightStatus		begin");
		String command  = ControlCommandHelp.CAMERA_INFO_BACKLIGHT_STATUS[0].replaceFirst("##1", cameraVO.getId());
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
				Thread.sleep(1000*2);//中控接口1.5s后才能给出正确的返回值20130822
				resultVO.setObject(cameraVO);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("获取背光异常："+e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：cameraeBackLightStatus		end");
		return resultVO;
	}

	public ExcuteResultVO cameraeExposureManuaIris(String iris) {
		logger.info("摄像头设备控制：cameraeExposureManuaLiris		begin");
		String command  = ControlCommandHelp.CAMERA_INFO_ExposureManuaIris[0].replaceFirst("##1", cameraVO.getId());
		String commandInfo = "";
		if("F0".equals(iris)){
			commandInfo = iris;
		}else{
			Double irisDouble = Double.parseDouble(iris.substring(1,iris.length()))/10;
			commandInfo += "F";
			commandInfo += irisDouble;
		}
		command = command.replaceFirst("##2", commandInfo);
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				cameraVO.setExposureManuaIris(iris);
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("异常："+e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：cameraeExposureManuaLiris		end");
		return resultVO;
	}

	public ExcuteResultVO cameraeExposureManual(boolean b) {
		logger.info("摄像头设备控制：cameraeExposureManual		begin");
		String command  = ControlCommandHelp.CAMERA_INFO_EXPOSUREMANUAL[0].replaceFirst("##1", cameraVO.getId());
		command = command.replaceFirst("##2", b+"");
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				cameraVO.setExposureManual(b);
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("异常："+e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：cameraeExposureManual		end");
		return resultVO;
	}

	public ExcuteResultVO cameraeExposureManualGain(int gain) {
		logger.info("摄像头设备控制：cameraeExposureManualGain		begin");
		try{
			String command  = ControlCommandHelp.CAMERA_INFO_ExposureManuaGain[0].replaceFirst("##1", cameraVO.getId());
			if(gain<10&&gain>=0){//20130730中控接口收到的字符串需要是字符串，需要完整的2位的;eg：发送指令02，返回值是2，补齐2位
				command = command.replaceFirst("##2", "0"+gain);
			}else{
				command = command.replaceFirst("##2", ""+gain);
			}
		
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				cameraVO.setExposureManuaGain(gain);
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("异常："+e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：cameraeExposureManualGain		end");
		return resultVO;
	}

	
	
	public ExcuteResultVO cameraeExposureManualSpeed(String speed) {
		logger.info("摄像头设备控制：cameraeExposureManualSpeed		begin");
		try{
			String command  = ControlCommandHelp.CAMERA_INFO_ExposureManuaSpeed[0].replaceFirst("##1", cameraVO.getId());
			String[] speeds = speed.split("/");
			int speedInt = Integer.valueOf(speeds[1]);
			String commandInfo = speed;
			if(speedInt<10){//20130730中控接口收到的字符串需要是字符串，需要完整的5位的;eg：发送指令1/00001，返回值是1/1，分母补齐5位;但是返回值不做任何处理
				commandInfo = speeds[0] + "/0000"+speedInt;
			}else if(speedInt<100){
				commandInfo = speeds[0] + "/000"+speedInt;
			}else if(speedInt<1000){
				commandInfo = speeds[0] + "/00"+speedInt;
			}else if(speedInt<10000){
				commandInfo = speeds[0] + "/0"+speedInt;
			}
			command = command.replaceFirst("##2", commandInfo);
		
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				cameraVO.setExposureManuaSpeed(speed);
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("异常："+e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：cameraeExposureManualSpeed		end");
		return resultVO;
	}

	public ExcuteResultVO cameraeExposureManualStatus() {
		logger.info("摄像头设备控制：cameraeExposureManualStatus		begin");
		String command  = ControlCommandHelp.CAMERA_INFO_EXPOSUREMANUAL_STATUS[0].replaceFirst("##1", cameraVO.getId());
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
				Thread.sleep(1000*5);//中控接口4s后才能给出正确的返回值20130822
				resultVO.setObject(cameraVO);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("获取曝光异常："+e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：cameraeExposureManualStatus		end");
		return resultVO;
	}

	public ExcuteResultVO cameraeWhiteBalanceManual(boolean b) {
		logger.info("摄像头设备控制：cameraeWhiteBalanceManual		begin");
		String command  = ControlCommandHelp.CAMERA_INFO_WhiteBalanceManual[0].replaceFirst("##1", cameraVO.getId());
		command = command.replaceFirst("##2", b+"");
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				cameraVO.setWhiteBalanceManual(b);
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("异常："+e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：cameraeWhiteBalanceManual		end");
		return resultVO;
	}

	public ExcuteResultVO cameraeWhiteBalanceManualB(int b) {
		logger.info("摄像头设备控制：cameraeWhiteBalanceManualB		begin");
		String command  = ControlCommandHelp.CAMERA_INFO_WhiteBalanceManual_B[0].replaceFirst("##1", cameraVO.getId());
		if(b>=0){
			if(b<10){//20130730中控接口收到的字符串需要是字符串，需要完整的3位的；但是返回值不作处理
				command = command.replaceFirst("##2", "00"+b);
			}else if(b<100){
				command = command.replaceFirst("##2", "0"+b);
			}else{
				command = command.replaceFirst("##2", ""+b);
			}
		}else{
			if(b>-10){
				command = command.replaceFirst("##2", "-00"+Math.abs(b));
			}else if(b>-100){
				command = command.replaceFirst("##2", "-0"+Math.abs(b));
			}else{
				command = command.replaceFirst("##2", ""+b);
			}
		}
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				cameraVO.setWhiteBalanceManualB(b);
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("异常："+e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：cameraeWhiteBalanceManualB		end");
		return resultVO;
	}

	public ExcuteResultVO cameraeWhiteBalanceManualR(int r) {
		logger.info("摄像头设备控制：cameraeWhiteBalanceManualR		begin");
		String command  = ControlCommandHelp.CAMERA_INFO_WhiteBalanceManual_R[0].replaceFirst("##1", cameraVO.getId());
		if(r>=0){
			if(r<10){
				command = command.replaceFirst("##2", "00"+r);
			}else if(r<100){
				command = command.replaceFirst("##2", "0"+r);
			}else{
				command = command.replaceFirst("##2", ""+r);
			}
		}else{
			if(r>-10){
				command = command.replaceFirst("##2", "-00"+Math.abs(r));
			}else if(r>-100){
				command = command.replaceFirst("##2", "-0"+Math.abs(r));
			}else{
				command = command.replaceFirst("##2", ""+r);
			}
		}
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				cameraVO.setWhiteBalanceManualR(r);
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("异常："+e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：cameraeWhiteBalanceManualR		end");
		return resultVO;
	}

	public ExcuteResultVO cameraeWhiteBalanceManualStatus() {
		logger.info("摄像头设备控制：cameraeWhiteBalanceManualStatus		begin");
		String command  = ControlCommandHelp.CAMERA_INFO_WhiteBalanceManual_STATUS[0].replaceFirst("##1", cameraVO.getId());
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
				Thread.sleep(1000*4);//中控接口3.5s后才能给出正确的返回值20130822
				resultVO.setObject(cameraVO);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("获取白平衡异常："+e.getMessage());
		}
		resultVO.setObject(cameraVO);
		logger.info("摄像头设备控制：cameraeWhiteBalanceManualStatus		end");
		return resultVO;
	}
}
