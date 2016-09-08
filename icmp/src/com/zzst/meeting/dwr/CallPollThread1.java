package com.zzst.meeting.dwr;

import java.util.ArrayList;
import java.util.List;

import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.application.mcuUtil.MCUConfig;
import com.zzst.application.mcuVO.ZZOConfVO;
import com.zzst.application.mcuVO.ZZOMainStatusVO;
import com.zzst.application.mcuVO.ZZOMediaSourcesVO;
import com.zzst.application.meeting.mcuFactory.ZZOMcuFactory;
import com.zzst.model.enums.VideoconferenceEnum;

public class CallPollThread1 implements Runnable {
	private String meetingDetailId;
	private String layoutMode;
	private Integer count;
	private String[][] infos;
	private String nowInfo;
	private int num; // 设置分屏成功次数
	private int intervalTime;
	private String meetingMode;
	private String monitor;
	private boolean flag = true;
	private Thread t;
	private String meetings;//会议分配信息
	
	private boolean isSuspend = false;
	/**
	 * 构造函数
	 * 
	 * @param meetingDetailId
	 * @param layoutMode
	 *            分屏模式
	 * @param count
	 *            分屏数量
	 * @param infos
	 *            二维数组 会场信息 pId,meetingID,confFlagId,mcuIp,pName
	 * @param intervalTime
	 *            间隔时间(秒)
	 * @param meetingMode
	 *            会议模式
	 * @param monitor
	 *            监视器信息
	 * @author zhangjz
	 */
	public CallPollThread1(String meetingDetailId, String layoutMode,
			Integer count, String[][] infos, int intervalTime,
			String meetingMode, String monitor,String meetings) {
		this.meetingDetailId = meetingDetailId;
		this.layoutMode = layoutMode;
		this.count = count;
		this.infos = infos;
		this.num = 0;
		this.intervalTime = intervalTime;
		this.meetingMode = meetingMode;
		this.monitor = monitor;
		this.meetings = meetings;
		this.t = new Thread(this);
		t.start();
	}

	
	
	public CallPollThread1() {
		super();
	}



	public void run() {
		try {
			if((VideoconferenceEnum.LECTURERMODE).equals(meetingMode)||(VideoconferenceEnum.SAMELAYOUTMODE).equals(meetingMode)){
				while (flag) {
					callPoll();
					Thread.sleep(intervalTime * 1000-1000);
					synchronized(this){
						while(isSuspend){
							wait();
						}
					}
				}
			}else if((VideoconferenceEnum.PERSONALMODE).equals(meetingMode)){
				while(flag){
					callPollByPersonal();
					Thread.sleep(intervalTime * 1000-1000);
					synchronized(this){
						while(isSuspend){
							wait();
						}
					}
				
				}
			}
		} catch (InterruptedException e) {
			flag = false;
			MeetingAppConfig.pollMap.remove(meetingDetailId);
			e.printStackTrace();
		} catch (Exception e){
			flag = false;
			MeetingAppConfig.pollMap.remove(meetingDetailId);
			e.printStackTrace();
			
		}

	}
/**
 * 演讲者及相同分屏轮询入口
 */
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
				
				String infoTemp ="";
				if (num >= infos[i].length) {
					infoTemp = isSuspendVideo(infos,i,k,k);
					info = infoTemp.split("_");
					//info = infos[i][k].split("_");
				} else {
					infoTemp = isSuspendVideo(infos,i,num,num);
					info = infoTemp.split("_");
					//info = infos[i][num].split("_");
				}
				nowInfo=infoTemp;
				/*
				if(num>=infos[i].length){
					nowInfo=infos[i][k];
					info = infos[i][k].split("_");
				}else{
					nowInfo=infos[i][num];
					info = infos[i][num].split("_");
				}
				*/
				if(info.length==1||info[1].equals(confVO.getGuid())){		//如果会场属于主会，直接将pId加入ids
					if(ids!=""){
						ids += "_";
					}
					ids += info[0];
				}else{										//否则，找出该会场所属会议的级联点
					for(ZZOConfVO cVO : confList){
						if((cVO.getGuid()+cVO.getMcuIP()).equals(info[1]+info[3])){
							//将该会场所在会议设置为单分屏显示该会场
							if((cVO.getMcuType()).equals(MCUConfig.RMX1000_EQUIPMENT_MODEL_ID)){ //rmx1000
								List<ZZOMainStatusVO> confTerminalList = new ArrayList<ZZOMainStatusVO>();
								confTerminalList = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(meetingDetailId, cVO.getMcuIP(), cVO.getGuid());
								for(ZZOMainStatusVO zVO : confTerminalList){
									if(zVO.getIsLecturer()==1){
										cVO.setLectureName(zVO.getMcu_participant_name());
									}
								}
								ZZOMcuFactory.getInstance().getMcuControlHelper().set1000Video(cVO.getConfID(), cVO.getVideoMode(), cVO.getLectureName(), false, MCUConfig.LAYOUT_MODE_101, count, info[0], "");
							}else{
								ZZOMcuFactory.getInstance().getMcuControlHelper().setVideo(meetingDetailId, cVO.getConfID(), "", "", MCUConfig.LAYOUT_MODE_1X1, 1, info[0], "");
							}
							
							List<ZZOMainStatusVO> confTerminalList = new ArrayList<ZZOMainStatusVO>();
							confTerminalList = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(meetingDetailId, confVO.getMcuIP(), confVO.getGuid());
							for(ZZOMainStatusVO zVO : confTerminalList){
								if((!"none".equals(zVO.getCascadeRole())||zVO.getCascadeRole()!=null)&&(zVO.getAliasName()+zVO.getMcu_participant_ip()).equals(cVO.getE164()+cVO.getMcuCommandIP())){
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
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				MeetingAppConfig.pollMap.remove(meetingDetailId);
				e.printStackTrace();
			}
			if((confVO.getMcuType()).equals(MCUConfig.RMX1000_EQUIPMENT_MODEL_ID)){ //rmx1000
				List<ZZOMainStatusVO> confTerminalList = new ArrayList<ZZOMainStatusVO>();
				confTerminalList = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(meetingDetailId, confVO.getMcuIP(), confVO.getGuid());
				for(ZZOMainStatusVO zVO : confTerminalList){
					if(zVO.getIsLecturer()==1){
						confVO.setLectureName(zVO.getMcu_participant_name());
					}
				}
				
				ZZOMcuFactory.getInstance().getMcuControlHelper().set1000Video(confVO.getConfID(), confVO.getVideoMode(), confVO.getLectureName(), false, layoutMode, count,ids , "");
			}else{
				ZZOMcuFactory.getInstance().getMcuControlHelper().setVideo(meetingDetailId, confVO.getConfID(), "", "", layoutMode, count, ids, "");	
			}
			
			
			num++; 
		}
	}
	
	/**
	 * 个人模式轮询入口
	 */
	private void callPollByPersonal(){
		String[] monitorInfo = monitor.split("__");
		String[] idArray = new String[count];
		ZZOConfVO confVO = new ZZOConfVO();
		confVO.setConfFlagId(meetingDetailId);
		List<ZZOConfVO> confList = ZZOMcuFactory.getInstance().getConfManager().getConfList(confVO);
		for (ZZOConfVO cVO : confList) {
			if (cVO.getIsMasterConf() == MCUConfig.IS_MASTER_CONF) {
				confVO = cVO; // 取得主会
			}
		}
		if (confVO.getIsMasterConf() == MCUConfig.IS_MASTER_CONF) {
			String[] info; // 会场数组0:pId、1:meetingID、2:flagId、3:mcuIp、4:pName
			 
			for (int i = 0; i < infos.length; i++) {
				int k = 0; // 当前该数组的下标
				if (infos[i].length != 1) {
					if (num >= infos[i].length) {
						k = num % infos[i].length; // k为总次数对数组长度取余
					}
				} else {
					k = 0; // 数组长度为1，
				}
				String infoTemp ="";
				if (num >= infos[i].length) {
					infoTemp = isSuspendVideo(infos,i,k,k);
					info = infoTemp.split("_");
					//info = infos[i][k].split("_");
				} else {
					infoTemp = isSuspendVideo(infos,i,num,num);
					info = infoTemp.split("_");
					//info = infos[i][num].split("_");
				}
				
				nowInfo=infoTemp;
				
				if (info.length == 1 || info[1].equals(confVO.getGuid())) {
					idArray[i] = info[0];
				} else {
					List<ZZOMainStatusVO> confRoomList = new ArrayList<ZZOMainStatusVO>();
					// 取得被看会场的会议中会场列表confRoomList
					confRoomList = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(meetingDetailId, info[3], info[1]);
					for (int j = 0; j < confRoomList.size(); j++) {
						// 找出该会议中的级联点
						if ((!confRoomList.get(j).getCascadeRole().equals("none"))&&confRoomList.get(j).getCascadeRole()!=null) {
							String[] forceIdArray1 = new String[1];
							forceIdArray1[0] = info[0];
							ZZOMediaSourcesVO zzoMediaSourcesVO1 = new ZZOMediaSourcesVO();
							List<ZZOMediaSourcesVO> mediaList1 = new ArrayList<ZZOMediaSourcesVO>();
							zzoMediaSourcesVO1.setLayout("1x1");
							zzoMediaSourcesVO1.setLayoutType("personal");
							zzoMediaSourcesVO1.setMcuIP(confRoomList.get(j).getMcuIp());
							zzoMediaSourcesVO1.setMcuMeetingID(confRoomList.get(j).getMcuMeetingID());
							zzoMediaSourcesVO1.setMcuParticipantId(confRoomList.get(j).getMcu_participant_id());
							zzoMediaSourcesVO1.setForceIdArray(forceIdArray1);
							mediaList1.add(zzoMediaSourcesVO1);

							ZZOMcuFactory.getInstance().getMcuControlHelper().setMediaSources(mediaList1);

							// 取得会议列表 confList
							List<ZZOConfVO> confList1 = ZZOMcuFactory.getInstance().getInnerConfPts().getConfList(info[2]);
							for (int m = 0; m < confList1.size(); m++) {
								// 取得级联点所属会议
								if ((confList1.get(m).getConfName() + confList1.get(m).getMcuIP()).equals(confRoomList.get(j).getMeetingName()+ confRoomList.get(j).getMcuIp())) {
									List<ZZOMainStatusVO> confRoomList1 = new ArrayList<ZZOMainStatusVO>();
									// 取得主会下会场
									confRoomList1 = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(info[2],monitorInfo[2],monitorInfo[1]);
									for (int n = 0; n < confRoomList1.size(); n++) {
										if ((confRoomList1.get(n).getAliasName()+confRoomList1.get(n).getMcu_participant_ip()).equals(confList.get(m).getE164()+confList.get(m).getMcuCommandIP())) {
											// 将主会中级联点存入forceIdArray
											idArray[i] = confRoomList1.get(n).getMcu_participant_id();
										}
									}
								}

							}
						}
					}
				}
			}
			
			//String layoutType = MCUConfig.LAYOUT_MODE_1X1;
			ZZOMediaSourcesVO zzoMediaSourcesVO = new ZZOMediaSourcesVO();
			List<ZZOMediaSourcesVO> mediaList = new ArrayList<ZZOMediaSourcesVO>();

			
			zzoMediaSourcesVO.setLayout(layoutMode);
			zzoMediaSourcesVO.setLayoutType("personal");
			zzoMediaSourcesVO.setMcuIP(monitorInfo[2]);
			zzoMediaSourcesVO.setMcuMeetingID(monitorInfo[1]);
			zzoMediaSourcesVO.setMcuParticipantId(monitorInfo[3]);
			zzoMediaSourcesVO.setForceIdArray(idArray);
			mediaList.add(zzoMediaSourcesVO);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				MeetingAppConfig.pollMap.remove(meetingDetailId);
				e.printStackTrace();
			}
			ZZOMcuFactory.getInstance().getMcuControlHelper().setMediaSources(mediaList);
			num++;
		}
	}
	
	/**
	 * 过滤视频屏蔽或不在线的会场
	 * @param infos 轮询会场集合
	 * @param i		第i块屏幕
	 * @param k		第k个会场
	 * @author zhangjz
	 * @return String 返回非视频屏蔽会场信息
	 */
	public String isSuspendVideo(String[][] infos,int i,int k,int currentNum){
		String str = "";
		String info = infos[i][k];
		String[] infoA = info.split("_");
		if(infoA.length>1){
		List<ZZOMainStatusVO> confRoomList = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(meetingDetailId, infoA[3], infoA[1]);
		if(confRoomList!=null){
			for(ZZOMainStatusVO zVO : confRoomList){
				if((zVO.getMcu_participant_id()).equals(infoA[0])){
					if(zVO.getVideo()==1||zVO.getConnectStatus()!=1){
						if(k>=infos[i].length-1){
							k = -1;
						}
						int m = k+1;//m为下一个终端数组下表
						if(m==currentNum){//循环一周没有找到任何一个在线或者没被视频屏蔽的终端则设为自动
							str = "auto";
						}else{
							str =	isSuspendVideo(infos,i,m,currentNum);
							num++;
						}
					}else{
						str = info;
					}
				}
			}
		}
		}else{
			str = infoA[0];
		}
		return str;
	}
	/*annotated by wangle 2013-12-18. this method shouldn't be here.
	public static String getMcuOnLine(String str){
		String info = str;
		String[] infoA = info.split("_");
		if(infoA.length>1){
		List<ZZOMainStatusVO> confRoomList = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(meetingDetailId, infoA[3], infoA[1]);
		if(confRoomList!=null){
			for(ZZOMainStatusVO zVO : confRoomList){
				if((zVO.getMcu_participant_id()).equals(infoA[0])){
					String zip=zVO.getMcu_participant_ip();
					if(zVO.getVideo()==1||zVO.getConnectStatus()!=1||zip==null||zip.equals("")){
						return "outLine";
						}else{
						return zip;
						}
					}
				}
			}
		}
		
		
		return "outLine";
	}
	*/
	public void setSuspend(){
		this.isSuspend = true;
	}
	
	public synchronized void setResume(){
		this.isSuspend = false;
		notify();
	}
	
	public Thread getThread(){
		return this.t;
	}

	public  String[][] getInfos() {
		return infos;
	}

	public  void setInfos(String[][] infos) {
		this.infos = infos;
	}

	public  String getNowInfo() {
		return nowInfo;
	}

	public  void setNowInfo(String nowInfo) {
		this.nowInfo = nowInfo;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getMeetings() {
		return meetings;
	}

	public void setMeetings(String meetings) {
		this.meetings = meetings;
	}

	public int getIntervalTime() {
		return intervalTime;
	}

	public void setIntervalTime(int intervalTime) {
		this.intervalTime = intervalTime;
	}

	
	

	
}
