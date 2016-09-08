package com.zzst.reach.service.impl.communication.cm200;

import org.apache.log4j.Logger;

import com.zzst.reach.service.ReachObject;
import com.zzst.reach.service.vo.ReachVO;
import com.zzst.util.ExcuteResultVO;

public class ObjectImplCM200 extends ReachObject{
	private static Logger logger = Logger.getLogger(ObjectImplCM200.class
			.getName());
	
	public ObjectImplCM200(ReachVO vo) {
		super(vo);
		logger.info("CM200设备接口");
	}
	
	public ExcuteResultVO connect(int channelID,int bhighrate,String[] ips) {
		resultVO = new	ExcuteResultVO();
		if(!checkEquipmentStatus()) return resultVO;
		
		if(bhighrate>1||bhighrate<0){
			resultVO.setDes("只能为0或者1");
			return	resultVO;
		}else if(ips.length>6){
			resultVO.setDes("最多支持6个编码盒");
			return	resultVO;
		}
		if(channelID>2){
			resultVO.setDes("通道数只能为0或者1");
			return	resultVO;
		}else{
			String comment = CommnadEnues.connect_channelID[0];
			String c = comment.replaceFirst("##1",channelID+"").replaceFirst("##2", bhighrate+"");
			
			for(int i=0;i<ips.length;i++){
				int ipNum = i+1;
				c += "ip"+ipNum+":"+ips[i]+" ";
			}
			
			try {
				String s =new ClientSoket(this.getVo().getServerIP(),this.getVo().getServerPort()).sendCommand(c);
				if(CommnadEnues.connect_channelID[1].equalsIgnoreCase(s)){
					resultVO.setSuccess(true);
				}else
					resultVO.setDes(s);
			} catch (Exception e) {
				resultVO.setDes(e.getMessage());
				logger.error(e.getMessage());
			}
		}
		return resultVO;
	}

	public ExcuteResultVO play(String fileName, int channelID) {
		resultVO = new	ExcuteResultVO();
		if(!checkEquipmentStatus()) return resultVO;
		
		if(channelID>2){
			resultVO.setDes("通道数只能为0或者1");
			return	resultVO;
		}else{
			String comment = CommnadEnues.record[0];
			
			String c ="";
			if(fileName!=null&&fileName.length()>0)
				c = comment.replaceFirst("##1",channelID+"").replaceFirst("##2", fileName+"");
			else
				c = comment.replaceFirst("##1",channelID+"").replaceFirst("##2", "");
			
			try {
				String s =new ClientSoket(this.getVo().getServerIP(),this.getVo().getServerPort()).sendCommand(c);
				if(CommnadEnues.record[1].equalsIgnoreCase(s)){
					resultVO.setSuccess(true);
				}else
					resultVO.setDes(s);
			} catch (Exception e) {
				resultVO.setDes(e.getMessage());
				logger.error(e.getMessage());
			}
		}
		return resultVO;
	}

	public ExcuteResultVO continuePlay(int channelID) {
		resultVO = new	ExcuteResultVO();
		if(!checkEquipmentStatus()) return resultVO;
		
		if(channelID>2){
			resultVO.setDes("通道数只能为0或者1");
			return	resultVO;
		}else{
			String comment = CommnadEnues.continue_record[0];
			
			String c = comment.replaceFirst("##1",channelID+"");
			
			try {
				String s =new ClientSoket(this.getVo().getServerIP(),this.getVo().getServerPort()).sendCommand(c);
				if(CommnadEnues.continue_record[1].equalsIgnoreCase(s)){
					resultVO.setSuccess(true);
				}else
					resultVO.setDes(s);
			} catch (Exception e) {
				resultVO.setDes(e.getMessage());
				logger.error(e.getMessage());
			}
		}
		return resultVO;
	}

	public ExcuteResultVO pausePlay(int channelID) {
		resultVO = new	ExcuteResultVO();
		if(!checkEquipmentStatus()) return resultVO;
		
		if(channelID>2){
			resultVO.setDes("通道数只能为0或者1");
			return	resultVO;
		}else{
			String comment = CommnadEnues.pause_record[0];
			
			String c = comment.replaceFirst("##1",channelID+"");
			
			try {
				String s =new ClientSoket(this.getVo().getServerIP(),this.getVo().getServerPort()).sendCommand(c);
				if(CommnadEnues.pause_record[1].equalsIgnoreCase(s)){
					resultVO.setSuccess(true);
				}else
					resultVO.setDes(s);
			} catch (Exception e) {
				resultVO.setDes(e.getMessage());
				logger.error(e.getMessage());
			}
		}
		return resultVO;
	}
	
	public ExcuteResultVO stopPlay(int channelID) {
		resultVO = new	ExcuteResultVO();
		if(!checkEquipmentStatus()) return resultVO;
		
		if(channelID>2){
			resultVO.setDes("通道数只能为0或者1");
			return	resultVO;
		}else{
			String comment = CommnadEnues.stop_record[0];
			
			String c = comment.replaceFirst("##1",channelID+"");
			
			try {
				String s =new ClientSoket(this.getVo().getServerIP(),this.getVo().getServerPort()).sendCommand(c);
				if(CommnadEnues.stop_record[1].equalsIgnoreCase(s)){
					resultVO.setSuccess(true);
				}else
					resultVO.setDes(s);
			} catch (Exception e) {
				resultVO.setDes(e.getMessage());
				logger.error(e.getMessage());
			}
		}
		return resultVO;
	}

	public ExcuteResultVO unConnect(int channelID) {
		resultVO = new	ExcuteResultVO();
		if(!checkEquipmentStatus()) return resultVO;
		
		if(channelID>2){
			resultVO.setDes("通道数只能为0或者1");
			return	resultVO;
		}else{
			String comment = CommnadEnues.unConnect_channelID[0];
			String c = comment.replaceFirst("##1",channelID+"");
			
			try {
				String s =new ClientSoket(this.getVo().getServerIP(),this.getVo().getServerPort()).sendCommand(c);
				if(CommnadEnues.unConnect_channelID[1].equalsIgnoreCase(s)){
					resultVO.setSuccess(true);
				}else
					resultVO.setDes(s);
			} catch (Exception e) {
				resultVO.setDes(e.getMessage());
				logger.error(e.getMessage());
			}
		}
		return resultVO;
	}

	
	@Override
	public ExcuteResultVO channelStatus(int channelID) {
		resultVO = new	ExcuteResultVO();
		if(!checkEquipmentStatus()) return resultVO;
		if(channelID>2){
			resultVO.setDes("通道数只能为0或者1");
			return	resultVO;
		}else{
			String comment = CommnadEnues.channel_status[0];
			String c = comment.replaceFirst("##1",channelID+"");
			
			try {
				String s =new ClientSoket(this.getVo().getServerIP(),this.getVo().getServerPort()).sendCommand(c);
				if(s.indexOf("state: 0")>0){
					resultVO.setSuccess(true);
				}else
					resultVO.setDes(s);
			} catch (Exception e) {
				resultVO.setDes(e.getMessage());
				logger.error(e.getMessage());
			}
		}
		return resultVO;
	}

	@Override
	public ExcuteResultVO getRecordStatus(int channelID) {
		resultVO = new	ExcuteResultVO();
		if(!checkEquipmentStatus()) return resultVO;
		if(channelID>2){
			resultVO.setDes("通道数只能为0或者1");
			return	resultVO;
		}else{
			String comment = CommnadEnues.record_status[0];
			String c = comment.replaceFirst("##1",channelID+"");
			
			try {
				String s =new ClientSoket(this.getVo().getServerIP(),this.getVo().getServerPort()).sendCommand(c);
				if(s.toLowerCase().indexOf("record state: record")>=0){
					resultVO.setSuccess(true);
					resultVO.setObject(ReachObject.recordEX_play);
				}else if(s.toLowerCase().indexOf("record state: pause")>=0){
					resultVO.setSuccess(true);
					resultVO.setObject(ReachObject.recordEX_pausePlay);
				}else if(s.toLowerCase().indexOf("record state: stop")>=0){
					resultVO.setSuccess(true);
					resultVO.setObject(ReachObject.recordEX_stopPlay);
				}else
					resultVO.setDes(s);
			} catch (Exception e) {
				resultVO.setDes(e.getMessage());
				logger.error(e.getMessage());
			}
		}
		return resultVO;
	}
	
}
