package com.zzst.dao.meeting.videoconference;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.videoconference.VideoconferenceVO;

/**
 * class description: Videoconference MQB
 * 
 * @author ryan
 * @date Mon Aug 24 13:32:23 CST 2009
 */

public class VideoconferenceMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(VideoconferenceMQB.class
			.getName());

	public static int QUERY_FROM_VIDEOCONFERENCE = 1;
	
	public static int QUERY_FROM_VIDEOCONFERENCE_NOMEETINGROOM = 2;

	private VideoconferenceVO vVideoconferenceVO;

	private ArrayList<VideoconferenceVO> lstVideoconference = new ArrayList<VideoconferenceVO>();

	private int _operatorType = -1;

	public VideoconferenceMQB(int operatorType) {
		_operatorType = operatorType;

	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		if (QUERY_FROM_VIDEOCONFERENCE == _operatorType) {
			vVideoconferenceVO = new VideoconferenceVO();
			vVideoconferenceVO.setMeetingDetailID(rs.getString("meetingDetailID"));
			vVideoconferenceVO.setSubmeetingRoomID(rs.getString("meetingroomID"));
			//vVideoconferenceVO.setOldMeetingRoomID(vVideoconferenceVO.getSubmeetingRoomID());
			vVideoconferenceVO.setSubmeetingRoomName(rs.getString("meetingRoomName"));
			vVideoconferenceVO.setIsmain(rs.getInt("ismain"));
			vVideoconferenceVO.setRate(rs.getInt("rate"));
			vVideoconferenceVO.setDescription(rs.getString("description"));
			vVideoconferenceVO.setRevision(rs.getLong("revision"));
			vVideoconferenceVO.setRank(rs.getString("rank"));
			lstVideoconference.add(vVideoconferenceVO);
			
		}
		
		if(QUERY_FROM_VIDEOCONFERENCE_NOMEETINGROOM == _operatorType){
			vVideoconferenceVO = new VideoconferenceVO();
			vVideoconferenceVO.setMeetingDetailID(rs.getString("meetingDetailID"));
			vVideoconferenceVO.setSubmeetingRoomID(rs.getString("meetingroomID"));
			//vVideoconferenceVO.setOldMeetingRoomID(vVideoconferenceVO.getSubmeetingRoomID());
			vVideoconferenceVO.setIsmain(rs.getInt("ismain"));
			vVideoconferenceVO.setRate(rs.getInt("rate"));
			vVideoconferenceVO.setDescription(rs.getString("description"));
			vVideoconferenceVO.setRevision(rs.getLong("revision"));
			vVideoconferenceVO.setRank(rs.getString("rank"));
			lstVideoconference.add(vVideoconferenceVO);
		}

	}

	public ArrayList<VideoconferenceVO> getVideoconferenceList() {
		return lstVideoconference;

	}

	public VideoconferenceVO getVideoconferenceVO() {
		return vVideoconferenceVO;
	}

}
