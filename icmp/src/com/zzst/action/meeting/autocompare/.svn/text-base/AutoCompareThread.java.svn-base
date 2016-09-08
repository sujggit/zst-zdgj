package com.zzst.action.meeting.autocompare;

import java.sql.Timestamp;
import java.util.List;

import com.zzst.action.meeting.meeting.McuControlDwr;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.application.mcuUtil.MCUConfig;
import com.zzst.application.mcuVO.ZZOMainStatusVO;
import com.zzst.application.mcuVO.ZZOPtsChannel;
import com.zzst.application.meeting.mcu.operate.OperateUtil;
import com.zzst.application.meeting.mcuFactory.ZZOMcuFactory;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.meeting.comparison.ComparisonVO;
import com.zzst.model.meeting.equipment.EquipmentVO;

public class AutoCompareThread extends Thread{
	private String meetingDetailId;
	private ZZOMainStatusVO mainStatusVO;
	private List<ZZOMainStatusVO> mainStatusVOList;
	
	private EquipmentVO mainEndPointVO;
	private EquipmentVO mainCenterControlVO;
	private EquipmentVO mainVideoCardInfoVO;
	
	private EquipmentVO branchEndPointVO;
	private EquipmentVO branchCenterControlVO;
	private EquipmentVO branchVideoCardVO;
	public AutoCompareThread(){
		
	}
	public AutoCompareThread(String meetingDetailId, ZZOMainStatusVO mainStatusVO, List<ZZOMainStatusVO> mainStatusVOList){
		this.meetingDetailId = meetingDetailId;
		this.mainStatusVO = mainStatusVO;
		this.mainStatusVOList = mainStatusVOList;
	}
	/**
	 *auto compare process.
	 */
	public void run(){
		try {
			//获取主会场
			EquipmentVO mainEndPointVO = new EquipmentVO();
			mainEndPointVO.setIp(mainStatusVO.getMcu_participant_ip());
			mainEndPointVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
			List<EquipmentVO> equipList = ServiceFactory.getEquipmentService().query(mainEndPointVO, null);
			if(equipList == null || equipList.size() <= 0){
				return;
			}
			mainEndPointVO = equipList.get(0);
			/*
			//主会场比对卡彩条输出切换给主终端视频输入
			mainCenterControlVO = new EquipmentVO();
			mainCenterControlVO.setIp(mainStatusVO.getMcu_participant_ip());
			mainCenterControlVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
			equipList = ServiceFactory.getEquipmentService().query(mainCenterControlVO, null);
			if(equipList == null || equipList.size() <= 0){
				return;
			}
			mainCenterControlVO = equipList.get(0);
			//send matrix switch command 
			//....to do .....
			*/
			
			//主会场比对卡发送彩条
			mainVideoCardInfoVO = new EquipmentVO();
			mainVideoCardInfoVO.setMeetingRoomVO(mainEndPointVO.getMeetingRoomVO());
			mainVideoCardInfoVO.setEquipmentType(EquipmentEnum.TYPE_ID_VIDEOCARD);
			equipList = ServiceFactory.getEquipmentService().query(mainVideoCardInfoVO, null);
			if(equipList == null || equipList.size() <= 0){
				return;
			}
			mainVideoCardInfoVO = equipList.get(0);
			VideoCardNew mainVideoCard = new VideoCardNew(mainVideoCardInfoVO.getIp());
			byte[] setCommand = new byte[9];
			setCommand[0]=0x02; //msg type。 0x02:设置视频参数命令
			setCommand[1]=0x55;	//fixed byte
			setCommand[2]=(byte)0xA6; //A6: colorful bar A8:frame mode
			setCommand[3]=(byte)0xB0; //B0: 1080P60 B1:1080P50 B7:720P60
			setCommand[4]=(byte)0xC2; //C0:DVI C1:VGA C2:YPbPr  out
			setCommand[5]=(byte)0xD2; //D0:DVI D1:VGA D2:YPbPr  in
			setCommand[6]=(byte)0xE0; //E0:绝对偏差(彩条) E1:平均偏差(彩条) E2:自标准差(冻结帧) E3:自平均(冻结帧) E4:源标准差(冻结帧) E5:源平均(冻结帧)
			setCommand[7]=0x00;
			setCommand[8]=0x00;
			//发送视频参数命令设置命令
			mainVideoCard.setCommand(setCommand);
			ComparisonVO comparisonVO = null;
			//循环选定一个在线分会场
			for(ZZOMainStatusVO branchMainstatusVO : mainStatusVOList){
				try{
					if(branchMainstatusVO.getIsSpeaker()!=MCUConfig.IS_SPEAKER && branchMainstatusVO.getCascadeRole().equalsIgnoreCase(MCUConfig.CASCADE_NONE)){
						//主会场到分会场图像的比对流程
						comparisonVO = downVideoCompare(branchMainstatusVO.getMcu_participant_ip());
						//分会场到主会场图像的比对流程
						comparisonVO = upVideoCompare(branchMainstatusVO, comparisonVO);
						//获取分会场终端当前时间的丢包率和帧率
						comparisonVO = getPtsChannel(branchMainstatusVO, comparisonVO);
						//保存
						
						//comparisonVO.setMeetingRoomName(branchMainstatusVO.getMcu_participant_name());
						//comparisonVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
					//	ServiceFactory.getConparisonService().add(comparisonVO);
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 主会场到分会场图像的比对流程
	 * @param endpointIp
	 * @return
	 * @throws Exception
	 */
	private ComparisonVO downVideoCompare(String endpointIp) throws Exception{
		ComparisonVO comparisonVO = null;
		//获取分会场
		branchEndPointVO = new EquipmentVO();
		branchEndPointVO.setIp(endpointIp);
		branchEndPointVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
		List<EquipmentVO> equipList = ServiceFactory.getEquipmentService().query(branchEndPointVO, null);
		if(equipList == null || equipList.size() <= 0){
			return comparisonVO;
		}
		branchEndPointVO = equipList.get(0);
		/*
		//分会场比对卡彩条输出切换给终端视频输入
		branchCenterControlVO = new EquipmentVO();
		branchCenterControlVO.setMeetingRoomVO(branchEndPointVO.getMeetingRoomVO());
		branchCenterControlVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
		equipList = ServiceFactory.getEquipmentService().query(branchCenterControlVO, null);
		if(equipList == null || equipList.size() <= 0){
			return comparisonVO;
		}
		branchCenterControlVO = equipList.get(0);
		//send matrix switch command 
		//....to do .....
		*/
		
		//视频评价结果请求
		branchVideoCardVO = new EquipmentVO();
		branchVideoCardVO.setMeetingRoomVO(branchEndPointVO.getMeetingRoomVO());
		branchVideoCardVO.setEquipmentType(EquipmentEnum.TYPE_ID_VIDEOCARD);
		equipList = ServiceFactory.getEquipmentService().query(branchVideoCardVO, null);
		if(equipList == null || equipList.size() <= 0){
			return comparisonVO;
		}
		branchVideoCardVO = equipList.get(0);
		VideoCardNew mainVideoCard = new VideoCardNew(branchVideoCardVO.getIp());
		
		byte getByte = 0x00;
		byte[] revByte = mainVideoCard.getCommand(getByte);
		
		comparisonVO = new ComparisonVO();
		//comparisonVO.setDownVideoQuality(revByte[2]+"_"+revByte[3]+"_"+revByte[4]);
		return comparisonVO;
	}
	
	/**
	 * 分会场到主会场图像的比对流程
	 * @param endpointIp
	 * @return
	 * @throws Exception
	 */
	private ComparisonVO upVideoCompare(ZZOMainStatusVO branchMainstatusVO, ComparisonVO comparisonVO) throws Exception{
		//分会场终端被设为发言人
		McuControlDwr mcd = new McuControlDwr();
		String monitor = mainStatusVO.getMcu_participant_name()+"__"+mainStatusVO.getMcuMeetingID()+"__"+mainStatusVO.getMcuIp()+"__"+mainStatusVO.getMcu_participant_id();
		String[] roomInfos = new String[1];
		//pId,meetingID,flagId,mcuIp,pName
		roomInfos[0]=branchMainstatusVO.getMcu_participant_id()+"_"+branchMainstatusVO.getMcuMeetingID()+"_"+branchMainstatusVO.getConfFlagId() + "_" + branchMainstatusVO.getMcuIp() + "_" + branchMainstatusVO.getMcu_participant_name();
		mcd.setPersonal(roomInfos, monitor, MCUConfig.layoutTypes[1]);
		
		//分会场比对卡彩条输出切换给终端视频输入
		//branchCenterControlVO
		//send matrix switch command 
		//....to do .....
		
		//分会场比对卡发送彩条
		VideoCardNew branchVideoCard = new VideoCardNew(branchVideoCardVO.getIp());
		byte[] setCommand = new byte[9];
		setCommand[0]=0x02; //msg type。 0x02:设置视频参数命令
		setCommand[1]=0x55;	//fixed byte
		setCommand[2]=(byte)0xA6; //A6: colorful bar A8:frame mode
		setCommand[3]=(byte)0xB0; //B0: 1080P60 B1:1080P50 B7:720P60
		setCommand[4]=(byte)0xC2; //C0:DVI C1:VGA C2:YPbPr  out
		setCommand[5]=(byte)0xD2; //D0:DVI D1:VGA D2:YPbPr  in
		setCommand[6]=(byte)0xE0; //E0:绝对偏差(彩条) E1:平均偏差(彩条) E2:自标准差(冻结帧) E3:自平均(冻结帧) E4:源标准差(冻结帧) E5:源平均(冻结帧)
		setCommand[7]=0x00;
		setCommand[8]=0x00;
		//发送视频参数命令设置命令
		branchVideoCard.setCommand(setCommand);
		
		//主会场的终端视频输出切换给比对卡输入
		//mainCenterControlVO
		//send matrix switch command 
		//....to do .....
		
		
		//会管获取主会场比对卡评测值
		VideoCardNew mainVideoCard = new VideoCardNew(mainVideoCardInfoVO.getIp());
		
		byte getByte = 0x00;
		byte[] revByte = mainVideoCard.getCommand(getByte);
		//comparisonVO.setUpVideoQuality(revByte[2]+"_"+revByte[3]+"_"+revByte[4]);
		//会管计算比对结果
		
		return comparisonVO;
	}
	
	private ComparisonVO getPtsChannel(ZZOMainStatusVO branchMainstatusVO, ComparisonVO comparisonVO){
		List<ZZOPtsChannel> ptsChannelList = ZZOMcuFactory.getInstance().getMcuControlHelper().getPtsChannel(meetingDetailId, 
				branchMainstatusVO.getMcu_participant_name()+"__"+branchMainstatusVO.getMcuMeetingID()+"__"+branchMainstatusVO.getMcuIp());
		if(ptsChannelList != null && ptsChannelList.size() > 0){
			boolean isInExisted = false, isOutExisted = false;;
			for(ZZOPtsChannel ptsChannel : ptsChannelList){
				if(ptsChannel.getChannelType().equals(MCUConfig.VIDEO_IN_TEXT)){
					isInExisted = true;
					if(OperateUtil.isAvailable(ptsChannel.getFractionLoss()) && OperateUtil.isAvailable(ptsChannel.getFractionLossPeak())){
				//		comparisonVO.setReceivePacketLoss((Float.parseFloat(ptsChannel.getFractionLoss()))/100 + "%(" + (Float.parseFloat(ptsChannel.getFractionLossPeak()))/100 + "%)");
					}
			//		comparisonVO.setSendframeRate("");
				}
				if(ptsChannel.getChannelType().equals(MCUConfig.VIDEO_OUT_TEXT)){
					isOutExisted = true;
					//mainStatusVO.setSendPacketLoss(ptsChannel.getFractionLoss() + "%(" + ptsChannel.getFractionLossPeak() + "%)");
					if(OperateUtil.isAvailable(ptsChannel.getFractionLoss()) && OperateUtil.isAvailable(ptsChannel.getFractionLossPeak())){
				//		comparisonVO.setSendPacketLoss((Float.parseFloat(ptsChannel.getFractionLoss()))/100 + "%(" + (Float.parseFloat(ptsChannel.getFractionLossPeak()))/100 + "%)");
					}
				//	comparisonVO.setReceiveframeRate("");
				}
				if(isInExisted && isOutExisted){
					break;
				}
			}
		}
		
		return comparisonVO;
	}
}
