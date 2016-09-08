package com.zzst.action.meeting.meetingDetailRoom;

import java.sql.SQLException;
import java.util.List;

import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.model.meeting.meetingDetailRoom.MeetingDetailRoomVO;


/**
 * 
 * @author zhangjy 2014-01-15
 *
 */
public class MeetingDetailRoomAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
	List<MeetingDetailRoomVO> mrvlist;
	MeetingDetailRoomVO mdrv;
	String meetingName;
	
	public String queryList(){
		MeetingDetailRoomVO tmdv=new MeetingDetailRoomVO();
		tmdv.setMeetingDetailId(mdrv.getMeetingDetailId());
		try {
			mrvlist=ServiceFactory.getMeetingDetailRoomService().getMeetingDetailRoomList(tmdv, null);
			if(mrvlist.size()>0){
				meetingName=mrvlist.get(0).getMeetingDetailName();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.SUCCESS;
	}

	public List<MeetingDetailRoomVO> getMrvlist() {
		return mrvlist;
	}

	public void setMrvlist(List<MeetingDetailRoomVO> mrvlist) {
		this.mrvlist = mrvlist;
	}

	public MeetingDetailRoomVO getMdrv() {
		return mdrv;
	}

	public void setMdrv(MeetingDetailRoomVO mdrv) {
		this.mdrv = mdrv;
	}

	public String getMeetingName() {
		return meetingName;
	}

	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}
	
	
}
