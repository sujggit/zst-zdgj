package com.zzst.mcu.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.zzst.mcu.service.McuObject;
import com.zzst.mcu.service.impl.rmx2000.impl.MCU2000ServiceImplHelp;
import com.zzst.mcu.service.impl.vo.ControlLoginVO;
import com.zzst.mcu.service.impl.vo.ExceptionVO;
import com.zzst.mcu.service.impl.vo.IDEnum;
import com.zzst.mcu.service.impl.vo.MeetingInfoVO;
import com.zzst.mcu.service.impl.vo.TerminalVO;
import com.zzst.mcu.service.snmp.SnmpMcuImpl;
import com.zzst.util.ZZSTControlException;


/**
 *@Description
 *@date 2011-3-14下午05:02:53
 *@author ryan
 */
public class MCUServiceImpl extends McuObject {
	public MCUServiceImpl(String[] mcuInfoes) {
		super(mcuInfoes);
		
		//计划完善snmp部分，在设备注册完成时提取相应信息
		//initDateFromSnmp();
	}
	

	
	public boolean test()  throws ZZSTControlException{
		if(!login())	return false;
		String	command =	MCU2000ServiceImplHelp.test(this.getLoginVO().getMcu_token(),this.getLoginVO().getMcu_user_token(),null,this.getLoginVO().getYour_token1(),this.getLoginVO().getYour_tokend2());
		if(command==null||command.length()<0){
			System.out.println("测试命令为空");
			return false;
		}
		System.out.println(command);
		//发送命令，返回信息。
		String	reStr	=	MCUClientThread.sendCommand(this.mcuIP, command);
		System.out.println(reStr);
		return true;
	}
	
	@Override
	public boolean getMeetingProfilesListFromMcu() throws ZZSTControlException {
		if(!login())	return false;
		
		if(MCU_TYPE_1000.equalsIgnoreCase(this.mcuType)){
		
		}else if(MCU_TYPE_2000.equalsIgnoreCase(this.mcuType)){
			
		}else if(MCU_TYPE_2000C.equalsIgnoreCase(this.mcuType)){
			
		}
		return true;
	}
	
	@Override
	public boolean callVenue() throws ZZSTControlException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean getRESListFromMcu() throws ZZSTControlException {
		if(!login())	return false;
		
		if(MCU_TYPE_1000.equalsIgnoreCase(this.mcuType)){
		
		}else if(MCU_TYPE_2000.equalsIgnoreCase(this.mcuType)){
			return getRESListFromMcu2000();
		}else if(MCU_TYPE_2000C.equalsIgnoreCase(this.mcuType)){
			
		}
		return true;
	}
	
	/**
	 * 计划不对外提供接口
	 * @return
	 * @throws ZZSTControlException
	 */
	@Override
	public boolean getMeetingListFromMcu() throws ZZSTControlException {
		if(!login())	return false;
		
		if(MCU_TYPE_1000.equalsIgnoreCase(this.mcuType)){
		
		}else if(MCU_TYPE_2000.equalsIgnoreCase(this.mcuType)){
			return getMeetingListFromMcu2000();
		}else if(MCU_TYPE_2000C.equalsIgnoreCase(this.mcuType)){
			
		}
		return true;
	}
	
	@Override
	public boolean getVenueFromMeetingList(String meetingID) throws ZZSTControlException {
		if(!login())	return false;
		
		if(MCU_TYPE_1000.equalsIgnoreCase(this.mcuType)){
		
		}else if(MCU_TYPE_2000.equalsIgnoreCase(this.mcuType)){
			return getVenueFormMeetingList2000(meetingID);
		}else if(MCU_TYPE_2000C.equalsIgnoreCase(this.mcuType)){
			
		}
		return true;
	}
	
	@Override
	public boolean getVenueFromMCUList() throws ZZSTControlException {
		if(!login())	return false;
		
		if(MCU_TYPE_1000.equalsIgnoreCase(this.mcuType)){
		
		}else if(MCU_TYPE_2000.equalsIgnoreCase(this.mcuType)){
			return getVenueFromMcuList2000();
		}else if(MCU_TYPE_2000C.equalsIgnoreCase(this.mcuType)){
			
		}
		return	true;
	}

	@Override
	public boolean creatMeeting(String meetingName,Timestamp	startTime,Timestamp	endTime,int speed) throws ZZSTControlException {
		if(!login())	return false;
		
		if(MCU_TYPE_1000.equalsIgnoreCase(this.mcuType)){
		
		}else if(MCU_TYPE_2000.equalsIgnoreCase(this.mcuType)){
			creatMeeting2000( meetingName,	startTime,	endTime, speed);
		}else if(MCU_TYPE_2000C.equalsIgnoreCase(this.mcuType)){
			creatMeeting2000C( meetingName,	startTime,	endTime, speed);
		}
		return true;
	}
 
	@Override
	public boolean endMeeting(String meetingID)throws ZZSTControlException  {
		if(!login())	return false;
		
		if(MCU_TYPE_1000.equalsIgnoreCase(this.mcuType)){
		
		}else if(MCU_TYPE_2000.equalsIgnoreCase(this.mcuType)){
			endMeeting2000( meetingID);
		}else if(MCU_TYPE_2000C.equalsIgnoreCase(this.mcuType)){
			
		}
		return false;
	}

	
	@Override
	public void hangupVenue()throws ZZSTControlException  {
		
	}
 
	@Override
	public boolean modifyMeetingEndTime(String meetingID,Timestamp	endTime)throws ZZSTControlException  {
		if(!login())	return false;
		
		if(MCU_TYPE_1000.equalsIgnoreCase(this.mcuType)){
		
		}else if(MCU_TYPE_2000.equalsIgnoreCase(this.mcuType)){
			modifyMeeitngEndTime2000( meetingID,	endTime);
		}else if(MCU_TYPE_2000C.equalsIgnoreCase(this.mcuType)){
			
		}
		return false;
	}

	@Override
	public boolean addVenue(String meetingID,String terminalIP,String terminalName) throws ZZSTControlException {
		if(!login())	return false;
		if(MCU_TYPE_1000.equalsIgnoreCase(this.mcuType)){
		
		}else if(MCU_TYPE_2000.equalsIgnoreCase(this.mcuType)){
			return addVenue_2000(meetingID,terminalIP,terminalName);
		}else if(MCU_TYPE_2000C.equalsIgnoreCase(this.mcuType)){
			return addVenue_2000C(meetingID,terminalIP,terminalName);
		}
		return false;
	}
	
	@Override
	public boolean getMeetingRoomFromMCUList() throws ZZSTControlException {
		if(!login())	return false;
		
		if(MCU_TYPE_1000.equalsIgnoreCase(this.mcuType)){
		
		}else if(MCU_TYPE_2000.equalsIgnoreCase(this.mcuType)){
			return getMeetingRoomFromMcuList2000();
		}else if(MCU_TYPE_2000C.equalsIgnoreCase(this.mcuType)){
			
		}
		return	true;
	}
	
	@Override
	public boolean registerVenueToMCU()  throws ZZSTControlException{
		if(!login())	return false;
		
		if(MCU_TYPE_1000.equalsIgnoreCase(this.mcuType)){
		
		}else if(MCU_TYPE_2000.equalsIgnoreCase(this.mcuType)){
			return registerVenueToMcu2000();
		}else if(MCU_TYPE_2000C.equalsIgnoreCase(this.mcuType)){
			
		}
		return	true;
	}
	
	private boolean getRESListFromMcu2000() throws ZZSTControlException {
		//组织命令
		String	command =	MCU2000ServiceImplHelp.produceGetRESListFormMcuCommand_2000(this.getLoginVO().getMcu_token(),this.getLoginVO().getMcu_user_token(),null);
		if(command==null||command.length()<0){
			this.meetingInfoVO.setException("查询会议ID组建命令失败",ExceptionVO.defID);
			return false;
		}
		//发送命令，返回信息。
		String	reStr	=	MCUClientThread.sendCommand(this.mcuIP, command);
		System.out.println(reStr);
		if(reStr==null||reStr.length()<0){
			this.meetingInfoVO.setException("查询会议ID返回异常",ExceptionVO.defID);
			return false;
		}
		
		MCU2000ServiceImplHelp.assayGetRESListFromMcuReStr_2000();
		
		return true;
	}
	private boolean getMeetingListFromMcu2000() throws ZZSTControlException {
		//组织命令
		String	command =	MCU2000ServiceImplHelp.produceGetMeetingListFormMcuCommand_2000(this.getLoginVO().getMcu_token(),this.getLoginVO().getMcu_user_token(),null);
		if(command==null||command.length()<0){
			this.meetingInfoVO.setException("查询会议列表组建命令失败",ExceptionVO.defID);
			return false;
		}
		//发送命令，返回信息。
		String	reStr	=	MCUClientThread.sendCommand(this.mcuIP, command);
		System.out.println(reStr);
		if(reStr==null||reStr.length()<0){
			this.meetingInfoVO.setException("查询会议列表返回异常",ExceptionVO.defID);
			return false;
		}
		
		MCU2000ServiceImplHelp.assayGetMeetingListFromMcuReStr_2000();
		
		return true;
	}
	
	private boolean	endMeeting2000(String meetingID){
		MeetingInfoVO meetingInfoVO	=	this.getMeetingVO(this.mcuIP, meetingID);
		//组织命令
		String	command =	MCU2000ServiceImplHelp.produceEndMeetingCommand_2000(meetingInfoVO,this.getLoginVO().getMcu_token(),this.getLoginVO().getMcu_user_token(),null);
		if(command==null||command.length()<0){
			this.meetingInfoVO.setException("结束会议组建命令失败",ExceptionVO.defID);
			return false;
		}
		//发送命令，返回信息。
		String	reStr	=	MCUClientThread.sendCommand(this.mcuIP, command);
		if(reStr==null||reStr.length()<0){
			this.meetingInfoVO.setException("结束会议返回异常",ExceptionVO.defID);
			return false;
		}
		meetingInfoVO	=MCU2000ServiceImplHelp.assayEndMeetingReStr_2000(meetingInfoVO, reStr);
		if(meetingInfoVO==null||!IDEnum.end_onLingMeeting_succeed.equalsIgnoreCase(meetingInfoVO.getId())){
			return false;
		}else{
			meetingInfoVO.setHasMeeting(false);
			this.setMeetingVO(this.mcuIP, meetingInfoVO);
		}
		return true;
	}
	
	private	boolean	registerVenueToMcu2000(){
		TerminalVO vo = new TerminalVO();
		//组织命令
		String	command =	MCU2000ServiceImplHelp.produceRegisterVenueToMCUCommand_2000(vo,this.getLoginVO().getMcu_token(),this.getLoginVO().getMcu_user_token(),null);
		if(command==null||command.length()<0){
			this.meetingInfoVO.setException("提取mcu上的所有终端组建命令失败",ExceptionVO.defID);
			return false;
		}
		System.out.println(command);
		//发送命令，返回信息。
		String	reStr	=	MCUClientThread.sendCommand(this.mcuIP, command);
		System.out.println(reStr);
		if(reStr==null||reStr.length()<0){
			this.meetingInfoVO.setException("修改会议结束时间返回异常",ExceptionVO.defID);
			return false;
		}
		vo	=MCU2000ServiceImplHelp.assayRegisterVenueToMCUReStr_2000(vo, reStr);
		return true;
	}
	
	/**
	 * 2000版本提取mcu中的会议室列表
	 * @return
	 */
	private	boolean	getMeetingRoomFromMcuList2000(){
		//组织命令
		String	command =	MCU2000ServiceImplHelp.produceGetMeetingRoomFromMcuCommand_2000(this.getLoginVO().getMcu_token(),this.getLoginVO().getMcu_user_token(),null,null);
		if(command==null||command.length()<0){
			this.meetingInfoVO.setException("提取mcu上的所有终端组建命令失败",ExceptionVO.defID);
			return false;
		}
		//发送命令，返回信息。
		String	reStr	=	MCUClientThread.sendCommand(this.mcuIP, command);
		if(reStr==null||reStr.length()<0){
			this.meetingInfoVO.setException("修改会议结束时间返回异常",ExceptionVO.defID);
			return false;
		}
		MCU2000ServiceImplHelp.assayGetMeetingRoomFromMcuReStr_2000(null,reStr);
		return true;
	}
	
	/**
	 * 提取mcu上的所有终端
	 * @return
	 */
	private	boolean	getVenueFromMcuList2000(){
		//组织命令
		String	command =	MCU2000ServiceImplHelp.produceGetVenueFromMcuCommand_2000(this.getLoginVO().getMcu_token(),this.getLoginVO().getMcu_user_token(),null,null);
		if(command==null||command.length()<0){
			this.meetingInfoVO.setException("提取mcu上的所有终端组建命令失败",ExceptionVO.defID);
			return false;
		}
		//发送命令，返回信息。
		String	reStr	=	MCUClientThread.sendCommand(this.mcuIP, command);
		System.out.println(reStr);
		if(reStr==null||reStr.length()<0){
			this.meetingInfoVO.setException("修改会议结束时间返回异常",ExceptionVO.defID);
			return false;
		}
		return true;
	}
	
	/**
	 * 登录mcu
	 * @return
	 */
	private boolean login() {
		if(this.getLoginVO().hasLogin())	return true;
		if(MCU_TYPE_1000.equalsIgnoreCase(this.mcuType)){
			return true;
		}else if(MCU_TYPE_2000.equalsIgnoreCase(this.mcuType)){
			return login_2000();
		}else if(MCU_TYPE_2000C.equalsIgnoreCase(this.mcuType)){
			 return login_2000C();
		}
		return false;
	}
	
	/**
	 * 修改会议结束时间2000版本
	 * @param meetingID
	 * @param endTime
	 * @return
	 */
	private boolean modifyMeeitngEndTime2000(String meetingID,Timestamp	endTime){
		MeetingInfoVO meetingInfoVO	=	this.getMeetingVO(this.mcuIP, meetingID);
		meetingInfoVO.setEndTime(endTime);
		//组织命令
		String	command =	MCU2000ServiceImplHelp.produceModifyMeetingEndTimeCommand_2000(meetingID,null,this.getLoginVO().getMcu_token(),this.getLoginVO().getMcu_user_token(),null);
		if(command==null||command.length()<0){
			this.meetingInfoVO.setException("修改会议结束时间组建命令失败",ExceptionVO.defID);
			return false;
		}
		//发送命令，返回信息。
		String	reStr	=	MCUClientThread.sendCommand(this.mcuIP, command);
		if(reStr==null||reStr.length()<0){
			this.meetingInfoVO.setException("修改会议结束时间返回异常",ExceptionVO.defID);
			return false;
		}
		
		MeetingInfoVO v =MCU2000ServiceImplHelp.assayModifyMeetingEndTimeReStr_2000(meetingInfoVO,reStr);
		if(!IDEnum.succeed.equalsIgnoreCase(v.getId())){
			this.meetingInfoVO.setException(v.getDescription(),v.getId());
			return false;
		}
		this.setMeetingVO(this.mcuIP, v);
		
	
		return true;
	}
	/**
	 *  2000C版本添加会场
	 * @param meetingID
	 * @param terminalIP
	 * @param terminalName
	 * @return
	 */
	private boolean  addVenue_2000C(String meetingID,String terminalIP,String terminalName){
		return true;
	}
	
	/**
	 * 2000版本添加会场
	 * @param meetingID
	 * @param terminalIP
	 * @param terminalName
	 * @return
	 */
	private boolean  addVenue_2000(String meetingID,String terminalIP,String terminalName){
		MeetingInfoVO meetingInfoVO	=	this.meetingInfoVO;
		
		TerminalVO	terminalVO = new TerminalVO();
		terminalVO.setIp(terminalIP);
		terminalVO.setName(terminalName);
		terminalVO.setId(String.valueOf(meetingInfoVO.getTerminalVOList().size()));
		
		//组织命令
		String command =	MCU2000ServiceImplHelp.produceCallVenueCommand_2000(meetingInfoVO,terminalVO,this.getLoginVO().getMcu_token(),this.getLoginVO().getMcu_user_token(),null);
		if(command==null||command.length()<0){
			this.meetingInfoVO.setException("添加会场组建命令失败",ExceptionVO.defID);
			return false;
		}
		//发送命令，返回信息。
		String	reStr	=	MCUClientThread.sendCommand(this.mcuIP, command);
		if(reStr==null||reStr.length()<0){
			this.meetingInfoVO.setException("添加会场返回异常",ExceptionVO.defID);
			return false;
		}
		
		MeetingInfoVO v =MCU2000ServiceImplHelp.assayCallVenueReStr_2000(meetingInfoVO,reStr);
		if(!IDEnum.succeed.equalsIgnoreCase(v.getId())){
			this.meetingInfoVO.setException(v.getDescription(),v.getId());
			return false;
		}
		return true;
	}
	
	/**
	 * 2000C版本登录
	 * @return
	 */
	private	boolean  login_2000C(){
		return true;
	}
	
	/**
	 * 2000版本登录
	 * @return
	 */
	private	boolean  login_2000(){
		String	command	=	MCU2000ServiceImplHelp.produceLoginCommand_2000(this.mcuIP,this.loginName,this.loginPassword);	
		if(command==null||command.length()<0){
			this.meetingInfoVO.setException("mcu2000登录命令为空",ExceptionVO.defID);
			return false;
		}
		
		//发送命令，返回信息。
		String	reStr	=	MCUClientThread.sendCommand(this.mcuIP, command);
		if(reStr==null||reStr.length()<0){
			this.meetingInfoVO.setException("mcu2000发送登录命令后，返回null",ExceptionVO.defID);
			return false;
		}
		ControlLoginVO vo	=	MCU2000ServiceImplHelp.assayLoginReStr_2000(this.getLoginVO(),reStr);
		if(vo==null){
			this.getLoginVO().setLogin(false);
		}else{
			this.setLoginVO(vo);
			this.getLoginVO().setLogin(true);
		}
		return this.getLoginVO().hasLogin();
	}
	
	/**
	 * 2000C版本创建会议
	 * @param meetingName	会议名称
	 * @param startTime		会议开始时间
	 * @param endTime		会议结束时间
	 * @param speed			会议速率
	 * @return
	 */
	private boolean	creatMeeting2000C(String meetingName,Timestamp	startTime,Timestamp	endTime,int speed){
		return true;
	}
	
	/**
	 * 2000版本创建会议
	 * @param meetingName	会议名称
	 * @param startTime		会议开始时间
	 * @param endTime		会议结束时间
	 * @param speed			会议速率
	 * @return
	 */
	private boolean	creatMeeting2000(String meetingName,Timestamp	startTime,Timestamp	endTime,int speed){
		MeetingInfoVO vo	=	this.getMeetingVO(this.mcuIP, null);
		vo.setMeetingName(meetingName+System.currentTimeMillis());
		vo.setStartTime(startTime);
		vo.setEndTime(endTime);
		vo.setSpeed(speed);
		
		//组织命令
		String command	=	MCU2000ServiceImplHelp.produceCreatMeetingCommand_2000(vo,this.getLoginVO().getMcu_token(),this.getLoginVO().getMcu_user_token(),null);
		if(command==null||command.length()<0){
			this.meetingInfoVO.setException("创建会议组建命令失败",ExceptionVO.defID);
			return false;
		}
		//发送命令，返回信息。
		String	reStr	=	MCUClientThread.sendCommand(this.mcuIP, command);
		if(reStr==null||reStr.length()<0){
			this.meetingInfoVO.setException("创建会议返回异常",ExceptionVO.defID);
			return false;
		}
		
		vo = MCU2000ServiceImplHelp.assayCreatMeetingReStr_2000(vo,reStr);
		
		if(!IDEnum.succeed.equalsIgnoreCase(vo.getId())){
			this.meetingInfoVO.setException(vo.getDescription(),vo.getId());
			return false;
		}
		this.setMeetingVO(this.mcuIP, vo);
		this.meetingInfoVO = vo;
		return true;
	}

	/**
	 * 2000版本提取会议中的会场列表
	 * @param meetingID
	 * @return
	 */
	private	boolean	getVenueFormMeetingList2000(String meetingID){
		MeetingInfoVO meetingInfoVO	=	this.getMeetingVO(this.mcuIP, meetingID);
		//组织命令
		String	command =	MCU2000ServiceImplHelp.produceGetVenueFromMeetingCommand_2000(meetingInfoVO,this.getLoginVO().getMcu_token(),this.getLoginVO().getMcu_user_token(),null);
		if(command==null||command.length()<0){
			this.meetingInfoVO.setException("提取会议ID为"+meetingID+"上的所有终端组建命令失败",ExceptionVO.defID);
			return false;
		}
		//发送命令，返回信息。
		String	reStr	=	MCUClientThread.sendCommand(this.mcuIP, command);
		if(reStr==null||reStr.length()<0){
			this.meetingInfoVO.setException("提取会议ID为"+meetingID+"上的所有终端返回异常",ExceptionVO.defID);
			return false;
		}
		meetingInfoVO =MCU2000ServiceImplHelp.assayGetVenueFromMeetingReStr_2000(meetingInfoVO, reStr);
		this.setMeetingVO(this.mcuIP, meetingInfoVO);
		return true;
	}

	
	 
	/**
	 * 在设备注册完成询问信息
	 */
	private  void  initDateFromSnmp(){
		new SnmpMcuImpl().snmpGet(this.mcuIP, "1.3.6.1.4.1.13885.9.2.1.2.2.2.1");
		new SnmpMcuImpl().snmpGet(this.mcuIP, "1.3.6.1.4.1.13885.9.2.1.2.2.2.1");
		new SnmpMcuImpl().snmpGet(this.mcuIP, "1.3.6.1.4.1.13885.9.2.1.2.2.2.1");
	}
	
	/**
	 * 根据oid询问终端相应状态，只负责发送命令
	 * @param oid
	 */
	private  void  answerInfoFromSnmp(String oid){
		new SnmpMcuImpl().snmpGet(this.mcuIP, oid);
	}
	
}
