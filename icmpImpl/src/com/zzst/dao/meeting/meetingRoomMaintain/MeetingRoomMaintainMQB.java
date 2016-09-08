package com.zzst.dao.meeting.meetingRoomMaintain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbf.system.CbfConfig;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.meetingRoomMaintain.MeetingRoomMaintainVO;

/**
 * class description: MeetingRoomMaintain MQB
 * 
 * @date Wed Sep 12 09:42:15 CST 2012
 * @author ryan
 */
public class MeetingRoomMaintainMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(MeetingRoomMaintainMQB.class.getName());

	public static int QUERY_FROM_MEETINGROOMMAINTAIN = 1;
	public static int QUERY_FROM_MEETINGROOMMAINTAIN_BY_IDS = 2;

	private MeetingRoomMaintainVO meetingRoomMaintainVO;
	private ArrayList<MeetingRoomMaintainVO> listMeetingRoomMaintain = new ArrayList<MeetingRoomMaintainVO>();

	private int _operatorType = -1;
	private String ids = "";

	public MeetingRoomMaintainMQB(int operatorType,
			MeetingRoomMaintainVO meetingRoomMaintainVO) {
		_operatorType = operatorType;
		this.meetingRoomMaintainVO = meetingRoomMaintainVO;
		makeSql();
	}

	public MeetingRoomMaintainMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		
		strsql.append("select mm.*,mr.meetingroomName");
		strsql.append(" from z_t_meetingroom_maintain mm ,z_t_meetingRoom mr where  mr.meetingroomID=mm.roomID and 1=1");
		
		if (QUERY_FROM_MEETINGROOMMAINTAIN == _operatorType) {
			if (null != meetingRoomMaintainVO) {
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getMaintainID())) {
					strsql.append(" and mm.maintainID= ? ");
					super.addStringForField(meetingRoomMaintainVO.getMaintainID());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getRoomID())) {
					strsql.append(" and mm.roomID= ? ");
					super.addStringForField(meetingRoomMaintainVO.getRoomID());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getMaintainUserName())) {
					strsql.append(" and mm.maintainUserName= ? ");
					super.addStringForField(meetingRoomMaintainVO.getMaintainUserName());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getCreateUserID())) {
					strsql.append(" and mm.createUserID= ? ");
					super.addStringForField(meetingRoomMaintainVO.getCreateUserID());
				}
				if (Integer.MIN_VALUE != meetingRoomMaintainVO.getStatus()) {
					strsql.append(" and mm.STATUS= ? ");
					super.addIntForField(meetingRoomMaintainVO.getStatus());
				}
				if (Long.MIN_VALUE != meetingRoomMaintainVO.getRevision()) {
					strsql.append(" and mm.REVISION= ? ");
					super.addLongForField(meetingRoomMaintainVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getDescription())) {
					strsql.append(" and mm.DESCRIPTION= ? ");
					super.addStringForField(meetingRoomMaintainVO.getDescription());
				}
				
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getMaintainKey())) {
					strsql.append(" and mm.maintainKey= ? ");
					super.addStringForField(meetingRoomMaintainVO.getMaintainKey());
				}
				if (Integer.MIN_VALUE != meetingRoomMaintainVO.getMaintainType()) {
					strsql.append(" and mm.maintainType= ? ");
					super.addIntForField(meetingRoomMaintainVO.getMaintainType());
				}
				if (Integer.MIN_VALUE != meetingRoomMaintainVO.getProcessStatus()) {
					strsql.append(" and mm.processStatus= ? ");
					super.addIntForField(meetingRoomMaintainVO.getProcessStatus());
				}
				if(meetingRoomMaintainVO.getCreateTime()!=null){
					if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
						strsql.append(" and mm.createTime="+UtilDAO.oracleToDate(meetingRoomMaintainVO.getCreateTime()));
					}else{
						strsql.append(" and mm.createTime= ? ");
						super.addTimestampForField(meetingRoomMaintainVO.getCreateTime());
					}
				}
			}
		} else if (QUERY_FROM_MEETINGROOMMAINTAIN_BY_IDS == _operatorType) {
			strsql.append(" and mm.maintainID in (?) ");
			super.addStringForField(ids);
		}
		strsql.append(" order by mm.createTime desc");
		setSql(strsql.toString());
	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public String getSql() {
		return this.sqlStr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		meetingRoomMaintainVO = new MeetingRoomMaintainVO();
		meetingRoomMaintainVO.setMaintainID(rs.getString("maintainID"));
		meetingRoomMaintainVO.setRoomID(rs.getString("roomID"));
		meetingRoomMaintainVO.setMaintainUserName(rs.getString("maintainUserName"));
		meetingRoomMaintainVO.setCreateUserID(rs.getString("createUserID"));
		meetingRoomMaintainVO.setCreateTime(rs.getTimestamp("createTime"));
		meetingRoomMaintainVO.setStatus(rs.getInt("status"));
		meetingRoomMaintainVO.setRevision(rs.getLong("REVISION"));
		meetingRoomMaintainVO.setDescription(rs.getString("DESCRIPTION"));
		meetingRoomMaintainVO.setMaintainKey(rs.getString("maintainKey"));
		meetingRoomMaintainVO.setMaintainType(rs.getInt("maintainType"));
		meetingRoomMaintainVO.setProcessStatus(rs.getInt("processStatus"));
		meetingRoomMaintainVO.getMeetingRoomVO().setMeetingRoomName(rs.getString("meetingroomName"));
		listMeetingRoomMaintain.add(meetingRoomMaintainVO);
	}

	public ArrayList<MeetingRoomMaintainVO> getMeetingRoomMaintainList() {
		return listMeetingRoomMaintain;
	}

	public MeetingRoomMaintainVO getMeetingRoomMaintainVO() {
		return meetingRoomMaintainVO;
	}

}
