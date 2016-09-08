package com.zzst.meeting.dwr;

import java.util.ArrayList;
import java.util.List;

import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.application.mcuUtil.MCUConfig;
import com.zzst.application.mcuVO.ZZOConfVO;
import com.zzst.application.mcuVO.ZZOMainStatusVO;
import com.zzst.application.meeting.mcuFactory.ZZOMcuFactory;

public class CallPollThread implements Runnable{
	private String meetingDetailId;
	private String layoutMode;
	private Integer count;
	private String[][] infos;
	private int num;		//设置分屏成功次数
	private int intervalTime;
	/**
	 * 构造函数
	 * @param meetingDetailId		
	 * @param layoutMode		分屏模式
	 * @param count				分屏数量
	 * @param infos				二维数组 会场信息
	 * @param intervalTime		间隔时间
	 */
	public CallPollThread(String meetingDetailId,String layoutMode,Integer count,String[][] infos,int intervalTime){
		this.meetingDetailId = meetingDetailId;
		this.layoutMode = layoutMode;
		this.count = count;
		this.infos = infos;
		this.num = 0; 
		this.intervalTime = intervalTime;
	}
	
	public void run(){
		try {
			while(true){
				callPoll();
				Thread.sleep(intervalTime*1000);
			}
		} catch (InterruptedException e) {
			MeetingAppConfig.pollMap.remove(meetingDetailId);
			e.printStackTrace();
		}
	
	}
	
	public void callPoll(){
		
		ZZOConfVO confVO = new ZZOConfVO();
		confVO.setConfFlagId(meetingDetailId);
		List<ZZOConfVO> confList = ZZOMcuFactory.getInstance().getConfManager().getConfList(confVO);
		for(ZZOConfVO cVO : confList){
			if(cVO.getIsMasterConf()==MCUConfig.IS_MASTER_CONF){
				confVO = cVO;					//取得主会
			}
		}
		if(confVO.getIsMasterConf()==MCUConfig.IS_MASTER_CONF){
			String[] info;                        //会场数组0:pId、1:meetingID、2:flagId、3:mcuIp、4:pName
			String ids = "";					 //设置分屏时的pId组合
			for(int i=0;i<infos.length;i++){
				int k = 0;							//当前该数组的下标
				if(infos[i].length!=1){
					if(num>=infos[i].length){		
						k = num%infos[i].length;	//k为总次数对数组长度取余
					}
				}else{
					k = 0;							//数组长度为1， 
				}
				
				if(num>=infos[i].length){
					info = infos[i][k].split("_");
				}else{
					info = infos[i][num].split("_");
				}
				
				if(info.length==1||info[1].equals(confVO.getGuid())){		//如果会场属于主会，直接将pId加入ids
					if(ids!=""){
						ids += "_";
					}
					ids += info[0];
				}else{										//否则，找出该会场所属会议的级联点
					for(ZZOConfVO cVO : confList){
						if((cVO.getGuid()+cVO.getMcuIP()).equals(info[1]+info[3])){//取得该从会confVO
							//将该会场所在会议设置为单分屏显示该会场
							ZZOMcuFactory.getInstance().getMcuControlHelper().setVideo(meetingDetailId, cVO.getConfID(), "", "", MCUConfig.LAYOUT_MODE_1X1, 1, info[0], "");
							List<ZZOMainStatusVO> confTerminalList = new ArrayList<ZZOMainStatusVO>();
							confTerminalList = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(meetingDetailId, cVO.getMcuIP(), confVO.getGuid());//取出主会所有终端
							for(ZZOMainStatusVO zVO : confTerminalList){
								if(!zVO.getCascadeRole().equals("none")&&(zVO.getAliasName()+zVO.getMcu_participant_ip()).equals(cVO.getE164()+cVO.getMcuCommandIP())){
									if(ids!=""){
										ids += "_";
									}
									ids += zVO.getMcu_participant_id();
								}
							}	
						}
					}
				}
			}
			//设置主会的分屏
			ZZOMcuFactory.getInstance().getMcuControlHelper().setVideo(meetingDetailId, confVO.getConfID(), "", "", layoutMode, count, ids, "");	
			num++; 
		}
	
	
	}
}
