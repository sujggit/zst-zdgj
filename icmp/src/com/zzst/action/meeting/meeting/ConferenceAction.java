package com.zzst.action.meeting.meeting;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.enums.MeetingRoomEnum;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.user.UserVO;


/**
 *@Description
 *@date 2012-1-13下午02:14:29
 *@author ryan
 */
public class ConferenceAction extends CjfAction {
 
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(ConferenceAction.class.getName());
	
	private MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
	private ArrayList<MeetingRoomVO> meetingRoomList = new ArrayList<MeetingRoomVO>();
	private MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
	private ArrayList<MeetingDetailVO>  lst_conference = new ArrayList<MeetingDetailVO>();

	public	String	conferenceList(){
		logger.info("ConferenceAction	conferenceList		begin");
		try{
			QueryTimeSlot();
			
//			//查询会议室列表　add by xiamj on 2011-08-11
//			meetingRoomVO.setVenueProperty(MeetingRoomVO.VENUE_MEETING_ROOM);
//			
//			UserVO userVO	=	(UserVO)getCjfUserVO();
//			if(userVO.getUserData(CindaInfoVO.MEETING_ROOM_QUERY_CONDITION)!=null ){
//				meetingRoomVO.setCommQueryCondition(userVO.getUserData(CindaInfoVO.MEETING_ROOM_QUERY_CONDITION).trim());
//			}
//			
//			
			meetingRoomVO.setStatus(MeetingRoomEnum.ROOM_STATUS_VALID);
			if(meetingRoomVO.getMeetingRoomID()!=null&&meetingRoomVO.getMeetingRoomID().length()>0){
				meetingRoomList = ServiceFactory.getMeetingRoomService().queryByIDs(meetingRoomVO.getMeetingRoomID(),null);
			}else{
				meetingRoomList = ServiceFactory.getMeetingRoomService().query(meetingRoomVO, null);
			}
			
			for(MeetingRoomVO mv :meetingRoomList){
				MeetingDetailVO vo = new MeetingDetailVO();
				
				vo.setMeetingStartTime(meetingDetailVO.getMeetingStartTime());
				vo.setMeetingEndTime(meetingDetailVO.getMeetingEndTime());
				vo.setMeetingRoomID(mv.getMeetingRoomID());
				vo.setStatus(MeetingDetailEnum.STATUS_ING+","+MeetingDetailEnum.STATUS_APPROVED_PASS+","+MeetingDetailEnum.STATUS_END);
//				vo.setTemplateTag(MeetingVO.tag_meeting);
				//根据会议查询，该会议室下一定时间内的所有会议
				ArrayList<MeetingDetailVO> listConference = ServiceFactory.getMeetingDetailService().queryForPandect(vo,null);
				logger.info(mv.getMeetingRoomID()+"**z总览&&&**"+mv.getMeetingRoomName()+"==="+listConference.size()+"=&&&="+vo.getMeetingEndTime()+"=###=="+vo.getMeetingStartTime());
				mv.setViewStr(setViewStr(mv,vo,listConference));
			}
			
			this.getCurHttpServletRequest().setAttribute("startHour", MeetingAppConfig.QUERY_VIEW_START_HOUR);
			this.getCurHttpServletRequest().setAttribute("endHour", MeetingAppConfig.QUERY_VIEW_END_HOUR);
			
			//显示列数
			int n = Integer.parseInt((meetingDetailVO.getMeetingEndTime().getTime()-meetingDetailVO.getMeetingStartTime().getTime())/(60*60*1000)+"");
			String[] viewHour = new String[Integer.parseInt(n+"")];
			
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(meetingDetailVO.getMeetingStartTime().getTime());
			for(int i=0;i<n;i++){
				viewHour[i] = c.get(Calendar.HOUR_OF_DAY)+"";
				c.add(Calendar.HOUR_OF_DAY, 1);
			}
			this.getCurHttpServletRequest().setAttribute("viewHour",viewHour);		
			
			//列的样式
			int h = MeetingAppConfig.QUERY_VIEW_END_HOUR-MeetingAppConfig.QUERY_VIEW_START_HOUR;
			this.getCurHttpServletRequest().setAttribute("clospanNumber",h);
			this.getCurHttpServletRequest().setAttribute("viewPercent",h/90.0*100);
			this.getCurHttpServletRequest().setAttribute("commRoomType", MeetingRoomEnum.ROOM_TYPE_VEDIO);
		}catch(Exception e){
			logger.error("ConferenceAction	conferenceList	error："+e.getMessage());
			return ERROR;
		}
		logger.info("ConferenceAction	conferenceList		end");
		return "SUCCESS";
	}
	
	private String setViewStr(MeetingRoomVO meetingRoomVO,MeetingDetailVO meetingVO,ArrayList<MeetingDetailVO> meetingList){ 
		long 	delayTimes		=	30*60*1000	;
		long	nextDelayTimes	=	MeetingAppConfig.MeetingBook_NextDelays	;
		String green="bar4";
		String red="bar2";
		String disable="bar3";
		
		String  strDefaultLen	=	"99";
		long 	defaultLen	=	99l;
		String	bookMeetingCaption	=	"";
		String	alreadyBookCaption	=	"";
		
		Timestamp sysTime 		= new Timestamp(System.currentTimeMillis());
		Timestamp lastTime 	= meetingVO.getMeetingStartTime();
		Timestamp endTime 	= meetingVO.getMeetingEndTime();
		
		double	allTime		= endTime.getTime()-lastTime.getTime();
		double  	allPercent	=	0;
		String str = "<div class='graph'>";
		
		if(meetingList==null||meetingList.size()==0){
			if(sysTime.after(endTime)){
				str += "<strong   class='"+disable+"' style='width: "+strDefaultLen+"%;'></strong>";	
			}else if(sysTime.before(lastTime)){
				str += "<strong  onclick=bookMeeting('"+meetingRoomVO.getMeetingRoomType()+"','"+meetingRoomVO.getMeetingRoomID()+"','code','"+meetingRoomVO.getMeetingRoomName()+"','"+getTimeStr(lastTime)+"','"+getTimeStr(new Timestamp(lastTime.getTime()+delayTimes))+"'); " +
				"class='"+green+"' style='width: "+strDefaultLen+"%;'>"+bookMeetingCaption+"</strong>";	
			}else{
				double percent = ((sysTime.getTime()-lastTime.getTime())*98.6)/allTime;
				str += "<strong   class='"+disable+"' style='width: "+percent+"%;'></strong>";
				str += "<strong  onclick=bookMeeting('"+meetingRoomVO.getMeetingRoomType()+"','"+meetingRoomVO.getMeetingRoomID()+"','code','"+meetingRoomVO.getMeetingRoomName()+"','"+getTimeStr(sysTime)+"','"+getTimeStr(new Timestamp(sysTime.getTime()+delayTimes))+"'); " +
				"class='"+green+"' style='width: "+(defaultLen-percent)+"%;'>"+bookMeetingCaption+"</strong>";	

			}
			str += "</div>";
			return str;
		}
		 
		double percent =0;
			for(MeetingDetailVO mv : meetingList){
				logger.info(mv.getMeetingName()+mv.getMeetingStartTime()+"-"+mv.getMeetingEndTime());
				Timestamp startTimePlan	=	mv.getMeetingStartTime()	;
				if(mv.getMeetingStartTime().after(lastTime) && sysTime.after(mv.getMeetingStartTime())){
					percent = ((mv.getMeetingStartTime().getTime()-lastTime.getTime())*98.6)/allTime;
					str += "<strong   class='"+disable+"' style='width: "+percent+"%;'></strong>";	
					allPercent+=percent	;
				}else if(mv.getMeetingStartTime().after(lastTime) && sysTime.after(lastTime)){
					percent = ((sysTime.getTime()-lastTime.getTime())*98.6)/allTime;
					str += "<strong   class='"+disable+"' style='width: "+percent+"%;'></strong>";	
					allPercent+=percent	;
					
					percent = ((mv.getMeetingStartTime().getTime()-sysTime.getTime())*98.6)/allTime;
					str += "<strong  onclick=bookMeeting('"+meetingRoomVO.getMeetingRoomType()+"','"+meetingRoomVO.getMeetingRoomID()+"','code','"+meetingRoomVO.getMeetingRoomName()+"','"+getTimeStr(new Timestamp(mv.getMeetingStartTime().getTime()+nextDelayTimes))+"','"+getTimeStr(new Timestamp(mv.getMeetingStartTime().getTime()+delayTimes+nextDelayTimes))+"'); " +
					"class='"+green+"' style='width: "+percent+"%;'>"+bookMeetingCaption+"</strong>";
					allPercent+=percent	;
				}else if(mv.getMeetingStartTime().after(lastTime) && sysTime.before(lastTime)){
					percent = ((mv.getMeetingStartTime().getTime()-lastTime.getTime())*98.6)/allTime;
					str += "<strong  onclick=bookMeeting('"+meetingRoomVO.getMeetingRoomType()+"','"+meetingRoomVO.getMeetingRoomID()+"','code','"+meetingRoomVO.getMeetingRoomName()+"','"+getTimeStr(new Timestamp(lastTime.getTime() ))+"','"+getTimeStr(new Timestamp(lastTime.getTime()+delayTimes ))+"'); " +
					"class='"+green+"' style='width: "+percent+"%;'>"+bookMeetingCaption+"</strong>";
					allPercent+=percent	;
					
				}else if(!mv.getMeetingStartTime().after(lastTime)){
					startTimePlan	=	lastTime	;
				}
				
				if(endTime.after(mv.getMeetingEndTime()) ){
					percent = ((mv.getMeetingEndTime().getTime()-startTimePlan.getTime())*98.6)/allTime;
					str += "<strong "+setTitle(mv)+
					"class='"+red+"' style='width: "+percent+"%;'>"+alreadyBookCaption/**mv.getMeetingName()**/+"</strong>";
					allPercent+=percent	;
					lastTime = mv.getMeetingEndTime();
				}else{
					str += "<strong "+setTitle(mv)+
					"class='"+red+"' style='width: "+(defaultLen-allPercent)+"%;'>"+alreadyBookCaption/**mv.getMeetingName()**/+"</strong>";
					allPercent=100	;
					break;
				}
				
			}	
	 
			if(allPercent<100){
				if(lastTime.before(sysTime) && sysTime.before(endTime) ){
					percent = ((sysTime.getTime()-lastTime.getTime())*98.6)/allTime;
					str += "<strong   class='"+disable+"' style='width: "+percent+"%;'></strong>";	
					allPercent+=percent	;
					
				 
					str += "<strong  onclick=bookMeeting('"+meetingRoomVO.getMeetingRoomType()+"','"+meetingRoomVO.getMeetingRoomID()+"','code','"+meetingRoomVO.getMeetingRoomName()+"','"+getTimeStr(sysTime)+"','"+getTimeStr(new Timestamp(sysTime.getTime()+delayTimes))+"'); " +
					"class='"+green+"' style='width: "+(defaultLen-allPercent)+"%;'>"+bookMeetingCaption+"</strong>";
					allPercent+=percent	;
				}else if(lastTime.before(endTime) && endTime.before(sysTime) ){
					 
					str += "<strong   class='"+disable+"' style='width: "+(defaultLen-allPercent)+"%;'></strong>";	
					 
				}else if(lastTime.before(endTime) && sysTime.before(lastTime) ){
					str += "<strong  onclick=bookMeeting('"+meetingRoomVO.getMeetingRoomType()+"','"+meetingRoomVO.getMeetingRoomID()+"','code','"+meetingRoomVO.getMeetingRoomName()+"','"+getTimeStr(new Timestamp(lastTime.getTime()+nextDelayTimes))+"','"+getTimeStr(new Timestamp(lastTime.getTime()+delayTimes+nextDelayTimes))+"'); " +
					"class='"+green+"' style='width: "+(defaultLen-allPercent)+"%;'>"+bookMeetingCaption+"</strong>";
					allPercent+=percent	;
				}
					
				
			}
		str += "</div>";
		return str;
	}
	
	private String getTimeStr(Timestamp time){
		return time.toString().replace(" ", "*");
	}
	
	/**
	 * 会议信息
	 * @param MeetingVO
	 * @return
	 */
	private String setTitle(MeetingDetailVO mv){
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTimeInMillis(mv.getMeetingStartTime().getTime());
		
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTimeInMillis(mv.getMeetingEndTime().getTime());
		String userName="";
		String depName ="";
		try {
			UserVO vo = new UserVO();
				vo.setUserID(mv.getCreateUserID());
			ArrayList<UserVO> uList = ServiceFactory.getUserService().getUserList(vo, null);
			if(uList!=null){
				userName = uList.get(0).getName();
				depName = uList.get(0).getDepartmentVO().getTitle();
			}
				
		} catch (SQLException e) {
			logger.info("查询预订人异常："+e.getMessage());
		}
		
		String str="title=\"";
		str+="会议名称："+mv.getMeetingName()+"&#13;";
		str+="预约人："+userName+"&#13;";
		str+="预约部门："+depName+"&#13;";
		str+="开始时间："+startCalendar.get(Calendar.HOUR_OF_DAY)+":"+startCalendar.get(Calendar.MINUTE)+"&#13;";
		str+="结束时间："+endCalendar.get(Calendar.HOUR_OF_DAY)+":"+endCalendar.get(Calendar.MINUTE)+"&#13;";
//		str+="预 订 人："+mv.getCreateUserName()+"&#13;";
		str+="\"";
		return str;
	}
	/**
	 * 设置页面--时间段显示
	 * @return
	 */
	private void	QueryTimeSlot(){
		Calendar calendar = Calendar.getInstance();
		calendar.clear(Calendar.HOUR_OF_DAY);
		calendar.clear(Calendar.SECOND);
		calendar.clear(Calendar.MINUTE);
		calendar.clear(Calendar.MILLISECOND);
		if(meetingDetailVO.getMeetingDetailID()!=null&&meetingDetailVO.getMeetingDetailID().length()>0){
			try{
				MeetingDetailVO vo = new MeetingDetailVO();
				vo.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
				 ArrayList<MeetingDetailVO> list = ServiceFactory.getMeetingDetailService().getMeetingDetailList(vo, null);
				 if(list!=null&&list.size()==1)
					 meetingDetailVO = list.get(0);
			}catch(Exception e){
				logger.error("==========="+e.getMessage());
			}
		}
		
		//预订界面返回时，停留在上次进入的时间段------begin  modfiy by ryan 0n 2011-11-1
		if(meetingDetailVO.getMeetingStartTime()==null){
			calendar.set(Calendar.HOUR_OF_DAY, MeetingAppConfig.QUERY_VIEW_START_HOUR);
			meetingDetailVO.setMeetingStartTime(new Timestamp(calendar.getTimeInMillis()));
		}else{
			Calendar cs = Calendar.getInstance();
			cs.setTimeInMillis(meetingDetailVO.getMeetingStartTime().getTime());
			cs.set(Calendar.HOUR_OF_DAY, MeetingAppConfig.QUERY_VIEW_START_HOUR);
			cs.clear(Calendar.SECOND);
			cs.clear(Calendar.MINUTE);
			cs.clear(Calendar.MILLISECOND);
			meetingDetailVO.setMeetingStartTime(new Timestamp(cs.getTimeInMillis()));
		}
		
		if(meetingDetailVO.getMeetingEndTime()==null){
			calendar.set(Calendar.HOUR_OF_DAY, MeetingAppConfig.QUERY_VIEW_END_HOUR);
			meetingDetailVO.setMeetingEndTime(new Timestamp(calendar.getTimeInMillis()));
		}else{
			Calendar ce = Calendar.getInstance();
			ce.setTimeInMillis(meetingDetailVO.getMeetingEndTime().getTime());
			ce.set(Calendar.HOUR_OF_DAY, MeetingAppConfig.QUERY_VIEW_END_HOUR);
			ce.clear(Calendar.SECOND);
			ce.clear(Calendar.MINUTE);
			ce.clear(Calendar.MILLISECOND);
			meetingDetailVO.setMeetingEndTime(new Timestamp(ce.getTimeInMillis()));
		}
		//预订界面返回时，停留在上次进入的时间段------end
		
		String changeTime = this.getParameter("changeTime");
		if(changeTime!=null&&changeTime.length()>0){
			Timestamp t1 = meetingDetailVO.getMeetingStartTime();
			Timestamp t2 = meetingDetailVO.getMeetingEndTime();
			if(changeTime.equals("left")){
				calendar.setTimeInMillis(t1.getTime());
				calendar.add(Calendar.DAY_OF_MONTH, -1);
				meetingDetailVO.setMeetingStartTime(new Timestamp(calendar.getTimeInMillis()));
				calendar.setTimeInMillis(t2.getTime());
				calendar.add(Calendar.DAY_OF_MONTH, -1);
				meetingDetailVO.setMeetingEndTime(new Timestamp(calendar.getTimeInMillis()));
			}else if(changeTime.equals("right")){
				calendar.setTimeInMillis(t1.getTime());
				calendar.add(Calendar.DAY_OF_MONTH, 1);
				meetingDetailVO.setMeetingStartTime(new Timestamp(calendar.getTimeInMillis()));
				calendar.setTimeInMillis(t2.getTime());
				calendar.add(Calendar.DAY_OF_MONTH, 1);
				meetingDetailVO.setMeetingEndTime(new Timestamp(calendar.getTimeInMillis()));
			}
		}
	}
	
	public MeetingDetailVO getMeetingDetailVO() {
		return meetingDetailVO;
	}

	public void setMeetingDetailVO(MeetingDetailVO meetingDetailVO) {
		this.meetingDetailVO = meetingDetailVO;
	}

	public ArrayList<MeetingDetailVO> getLst_conference() {
		return lst_conference;
	}

	public void setLst_conference(ArrayList<MeetingDetailVO> lstConference) {
		lst_conference = lstConference;
	}

	public ArrayList<MeetingRoomVO> getMeetingRoomList() {
		return meetingRoomList;
	}

	public void setMeetingRoomList(ArrayList<MeetingRoomVO> meetingRoomList) {
		this.meetingRoomList = meetingRoomList;
	}

	public MeetingRoomVO getMeetingRoomVO() {
		return meetingRoomVO;
	}

	public void setMeetingRoomVO(MeetingRoomVO meetingRoomVO) {
		this.meetingRoomVO = meetingRoomVO;
	}

}
