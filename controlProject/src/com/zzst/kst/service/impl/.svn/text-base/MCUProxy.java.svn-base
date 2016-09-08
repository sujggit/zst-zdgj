package com.zzst.kst.service.impl;

import Ice.Communicator;

import com.vmediax.oneplusn.ice.api.vmxICE.CmdResult;
import com.vmediax.oneplusn.ice.api.vmxICE.Conference;
import com.vmediax.oneplusn.ice.api.vmxICE.ConferenceParam;
import com.vmediax.oneplusn.ice.api.vmxICE.LiveMeetTemplate;
import com.vmediax.oneplusn.ice.api.vmxICE.MC2Prx;
import com.vmediax.oneplusn.ice.api.vmxICE.MC2PrxHelper;
import com.vmediax.oneplusn.ice.api.vmxICE.MC3Prx;
import com.vmediax.oneplusn.ice.api.vmxICE.MC3PrxHelper;
import com.vmediax.oneplusn.ice.api.vmxICE.MutiTemplateInfo;
import com.vmediax.oneplusn.ice.api.vmxICE.SipInfo;
import com.vmediax.oneplusn.ice.api.vmxICE.TerminalInfo;

public class MCUProxy {
	private MC3Prx mcuProx = null;
	private MC2Prx mcuProx2 = null;
	private static Communicator ic;
	//
	public String MCUIp;
	public int MCUPort;

   private Communicator initICE(){
	   String[] ss = new String[1];
		ss[0] = "1";
		 ic = Ice.Util.initialize(ss);
		return ic;
		
   }
   public void destroyICE(){
	   ic.destroy();
   }
	
	public MCUProxy() {
	}

	public void CreateMC2Prx() {
		try {
			initICE();
			mcuProx2 = GetMC2Prx(MCUIp, MCUPort);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private MC2Prx GetMC2Prx(String ip, int port) {
		MC2Prx mPrx = null;
		try {
			
			String property = "mc2:default -h " + ip + " -p " + port;
			Ice.ObjectPrx obj = ic.stringToProxy(property).ice_twoway()
					.ice_timeout(2000).ice_secure(false);
			mPrx = MC2PrxHelper.checkedCast(obj);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			// mPrx = null;
			// System.Diagnostics.Debug.WriteLine(ex.Message + ex.StackTrace);
		}
		return mPrx;
	}

	public void CreateMC3Prx() {
		try {
			initICE();
			mcuProx = GetMC3Prx(MCUIp, MCUPort);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	private MC3Prx GetMC3Prx(String ip, int port) {
		MC3Prx mPrx = null;
		try {
			
			String property = "cit:default -h " + ip + " -p " + port;
			Ice.ObjectPrx obj = ic.stringToProxy(property).ice_twoway()
					.ice_timeout(2000).ice_secure(false);
			
			mPrx = MC3PrxHelper.checkedCast(obj);
			
		} catch (Exception ex) {
			mPrx = null;
			ex.printStackTrace();
		}finally{
			//ic.destroy();
		}
		return mPrx;
	}
	

	public CmdResult SetAudioSev(String serverip, String username, String pwd) {
		return mcuProx.setAudioServ(serverip, username, pwd);
	}

	// 添加终端
	public CmdResult AddTerminal(TerminalInfo ter) {
		return mcuProx.addTerminal(ter);
	}

	// 修改终端
	public CmdResult UpdateTerminal(TerminalInfo ter) {
		return mcuProx.updateTerminal(ter);
	}

	// 删除终端
	public CmdResult DeleteTerminal(String name) {
		return mcuProx.deleteTerminal(name);
	}

	// 添加模板
	public CmdResult AddTemplate(MutiTemplateInfo mutiTemplate) {
		return mcuProx.addMutiTemplate(mutiTemplate);
	}

	// 修改模板
	public CmdResult UpdateTemplate(MutiTemplateInfo mutiTemplate) {
		return mcuProx.updateMutiTemplate(mutiTemplate);
	}

	// 删除模板
	public CmdResult DeleteTemplate(String name) {
		return mcuProx.deleteMutiTemplate(name);
	}

	// 添加即时模板
	public CmdResult AddLivemeetTemplate(LiveMeetTemplate liveTemplate) {
		return mcuProx.addLiveMeetTemplate(liveTemplate);
	}

	// 修改即时模板
	public CmdResult UpdateLiveMeetTemplate(LiveMeetTemplate liveTemplate) {
		return mcuProx.updateLiveMeetTemplate(liveTemplate);
	}

	// 删除即时模板
	public CmdResult DeleteLiveTemplate(String name) {
		return mcuProx.deleteLiveMeetTemplate(name);
	}

	// 开始会议
	public CmdResult StartTemplateMeet(Conference conf, String templatename) {
		return mcuProx.startTemplateMeet(conf, templatename);
	}

	
	// 终止终端
	public CmdResult KickMutiTerminal(TerminalInfo terminal, String number) {
		return mcuProx.kickMutiTerminal(number, terminal);
	}


	public CmdResult DisconnectMutiTerminal(TerminalInfo terminal, String number) {
		return mcuProx.disconnectMutiTerminal(number, terminal);
	}

	// 呼叫终端
	public CmdResult ConnectMutiTerminal(TerminalInfo terminal, String number) {
		return mcuProx.connectMutiTerminal(number, terminal);
	}

	// 全部挂断
	public CmdResult DisconnectAll(String number) {
		return mcuProx.disconnectAll(number);
	}

	// 全部呼叫
	public CmdResult ConnectAll(String number) {
		return mcuProx.connectAll(number);
	}

	// 麦克风控制 mic 0:关闭 1:打开
	public CmdResult MuteMicrophone(String number, TerminalInfo terminal,
			String mic) {
		return mcuProx.muteMutiMicrophone(number, terminal, mic);
	}

	// 音响控制 speaker 0:关闭 1:打开
	public CmdResult MuteSpeaker(String number, TerminalInfo terminal,
			String speaker) {
		return mcuProx.muteMutiSpeaker(number, terminal, speaker);
	}

	// 关闭所有麦克风
	public CmdResult MuteAllMicrophone(String number) {
		return mcuProx.muteAllMicrophone(number);
	}

	// 打开所有麦克风
	public CmdResult OpenAllMicrophone(String number) {
		return mcuProx.openAllMicrophone(number);
	}

	// 关闭所有音响
	public CmdResult MuteAllSpeaker(String number) {
		return mcuProx.muteAllSpeaker(number);
	}

	// 打开所有音响
	public CmdResult OpenAllSpeaker(String number) {
		return mcuProx.openAllSpeaker(number);
	}

	// 获取当前的分屏模式
	public String GetVScreen(String number) {
		return mcuProx.getVscreen(number);
	}

	
	// 点名 state:next,forward
	public int SetQueue(String number, String index, TerminalInfo terminal) {
		return mcuProx.setQueue(number, index, terminal);
	}

	// 保存会议参数
	public int SaveConferenceParam(String number, ConferenceParam cp) {
		return mcuProx.saveConferenceParam(number, cp);
	}

	// 发言设置 lecture 0:没有 1:发言
	public int SetLecture(String number, TerminalInfo terminal, String lecture) {
		return mcuProx.setLecture(number, terminal, lecture);
	}

	// 主席设置 chair 0:没有 1:主席
	public int SetChair(String number, TerminalInfo terminal, String chair) {
		return mcuProx.setChair(number, terminal, chair);
	}

	

	// 远摇设置 actionType PanLeft:128 PanRight:192 ZoomOut:8 ZoomIn:12 FocusIn:3
	// FocusOut:2 TiltUp:48 TiltDown:32
	public int SetFecc(String number, TerminalInfo terminal, int actionType) {
		return mcuProx.setFecc(number, terminal, actionType);
	}

	// 停止远遥
	public int StopFecc(String number, TerminalInfo terminal) {
		return mcuProx.stopFecc(number, terminal);
	}

	// 设置323终端通信质量(会议中)
	public int SetQualityH323(String number, TerminalInfo terminal,
			String bandwidth, String vsize) {
		return mcuProx.setQualityH323(number, terminal, bandwidth, vsize);
	}

	// 设置软终端通信质量(会议中) type high,middle,low
	public int SetQualitySoft(String number, TerminalInfo terminal, String type) {
		return mcuProx.setQualitySoft(number, terminal, type);
	}

	// 强拆
	public CmdResult AudioDismantle(String terIp) {
		return mcuProx.audioDismantle(terIp);
	}

	// 强插
	public CmdResult AudioInsert(String terIp1, String terIp2) {
		return mcuProx.audioInsert(terIp1, terIp2);
	}

	// 保持
	public CmdResult AudioHold(String terIp) {
		return mcuProx.audioHold(terIp);
	}

	// 取消保持
	public CmdResult AudioUnHold(String terIp) {
		return mcuProx.audioUnHold(terIp);
	}

	// 转接-盲转
	public CmdResult AudioTansfer(String terNumber, String targetNumber) {
		return mcuProx.audioTansfer(terNumber, targetNumber);
	}

	// 监听
	public CmdResult AudioStartSpy(String spy, String terNumber) {
		return mcuProx.audioStartSpy(spy, terNumber);
	}

	// 监听 停止
	public CmdResult AudioStopSpy(String spy) {
		return mcuProx.audioStopSpy(spy);
	}

	// 录音
	public CmdResult AudioStartRecord(String terIp) {
		return mcuProx.audioStartRecord(terIp);
	}

	// 录音-停止
	public CmdResult AudioStopRecord(String terIp) {
		return mcuProx.audioStopRecord(terIp);
	}

	// 强接
	public CmdResult AudioPowerPickUp(String num, String terIp) {
		return mcuProx.powerPickUp(num, terIp);
	}

	// 呼叫
	public CmdResult AudioCallUp(String num, String terIp) {
		return mcuProx.callback(num, terIp);
	}

	// 合并会议
	public CmdResult AudioMeetShift(String audiomeetnum, String meetnum) {
		return mcuProx.meetShift(audiomeetnum, meetnum);
	}

	// public CmdResult Consult(String conNum, String targetNum)
	// {
	// return mcuProx.consult(conNum, targetNum);
	// }

	public int AddSip(SipInfo sipTerminalInfo) {
		return mcuProx2.addSip(sipTerminalInfo);
	}

	public int UpdateSip(SipInfo sipTerminalInfo) {
		return mcuProx2.updateSip(sipTerminalInfo);
	}

	public int DeleteSip(String sipIp) {
		return mcuProx2.deleteSip(sipIp);
	}

	public String getMCUIp() {
		return MCUIp;
	}

	public void setMCUIp(String ip) {
		MCUIp = ip;
	}

	public int getMCUPort() {
		return MCUPort;
	}

	public void setMCUPort(int port) {
		MCUPort = port;
	}

	public MC3Prx getMcuProx() {
		return mcuProx;
	}

	public void setMcuProx(MC3Prx mcuProx) {
		this.mcuProx = mcuProx;
	}

	public MC2Prx getMcuProx2() {
		return mcuProx2;
	}

	public void setMcuProx2(MC2Prx mcuProx2) {
		this.mcuProx2 = mcuProx2;
	}

}

// enum Phases
// {
// UninitialisedPhase = 0,
// SetUpPhase,
// AlertingPhase,
// ConnectedPhase,//正在连接
// EstablishedPhase,//连接上
// ReleasingPhase,
// ReleasedPhase,
// NumPhases;
// }