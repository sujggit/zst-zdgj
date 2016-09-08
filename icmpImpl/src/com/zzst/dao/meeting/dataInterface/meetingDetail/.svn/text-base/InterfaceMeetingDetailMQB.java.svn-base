package com.zzst.dao.meeting.dataInterface.meetingDetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.dataInterface.meetingDetail.InterfaceMeetingDetailVO;

/**
 * class description: InterfaceMeetingDetail MQB
 * 
 * @date Thu May 30 11:03:50 CST 2013
 * @author ryan
 */
public class InterfaceMeetingDetailMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(InterfaceMeetingDetailMQB.class.getName());

	public static int QUERY_FROM_INTERFACEMEETINGDETAIL = 1;
	public static int QUERY_FROM_INTERFACEMEETINGDETAIL_BY_IDS = 2;

	private InterfaceMeetingDetailVO interfaceMeetingDetailVO;
	private ArrayList<InterfaceMeetingDetailVO> listInterfaceMeetingDetail = new ArrayList<InterfaceMeetingDetailVO>();

	private int _operatorType = -1;
	private String ids = "";

	public InterfaceMeetingDetailMQB(int operatorType, InterfaceMeetingDetailVO interfaceMeetingDetailVO) {
		_operatorType = operatorType;
		this.interfaceMeetingDetailVO = interfaceMeetingDetailVO;
		makeSql();
	}

	public InterfaceMeetingDetailMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql
				.append("select id,meetingname,starttime,endtime,meetingType,isRecord,meetingLevel,meetingStatus,notifyType,createUserName,createTime,roomNos,confProfileID,modelID,status,description,ref1,ref2,mainroomno ");
		strsql.append(" from z_interface_in_meetingdetail ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_INTERFACEMEETINGDETAIL == _operatorType) {
			if (null != interfaceMeetingDetailVO) {
				if (!StringUtils.isNullOrBlank(interfaceMeetingDetailVO.getId())) {
					strsql.append(" and id= ? ");
					super.addStringForField(interfaceMeetingDetailVO.getId());
				}
				if (!StringUtils.isNullOrBlank(interfaceMeetingDetailVO.getMeetingname())) {
					strsql.append(" and meetingname= ? ");
					super.addStringForField(interfaceMeetingDetailVO.getMeetingname());
				}
				if (Integer.MIN_VALUE != interfaceMeetingDetailVO.getMeetingType()) {
					strsql.append(" and meetingType= ? ");
					super.addIntForField(interfaceMeetingDetailVO.getMeetingType());
				}
				if (Integer.MIN_VALUE != interfaceMeetingDetailVO.getIsRecord()) {
					strsql.append(" and isRecord= ? ");
					super.addIntForField(interfaceMeetingDetailVO.getIsRecord());
				}
				if (Integer.MIN_VALUE != interfaceMeetingDetailVO.getLevel()) {
					strsql.append(" and meetingLevel= ? ");
					super.addIntForField(interfaceMeetingDetailVO.getLevel());
				}
				if (Integer.MIN_VALUE != interfaceMeetingDetailVO.getMeetingStatus()) {
					strsql.append(" and meetingStatus= ? ");
					super.addIntForField(interfaceMeetingDetailVO.getMeetingStatus());
				}
				if (Integer.MIN_VALUE != interfaceMeetingDetailVO.getNotifyType()) {
					strsql.append(" and notifyType= ? ");
					super.addIntForField(interfaceMeetingDetailVO.getNotifyType());
				}
				if (!StringUtils.isNullOrBlank(interfaceMeetingDetailVO.getCreateUserName())) {
					strsql.append(" and createUserName= ? ");
					super.addStringForField(interfaceMeetingDetailVO.getCreateUserName());
				}
				if (!StringUtils.isNullOrBlank(interfaceMeetingDetailVO.getRoomNos())) {
					strsql.append(" and roomNos= ? ");
					super.addStringForField(interfaceMeetingDetailVO.getRoomNos());
				}
				if (!StringUtils.isNullOrBlank(interfaceMeetingDetailVO.getConfProfileID())) {
					strsql.append(" and confProfileID= ? ");
					super.addStringForField(interfaceMeetingDetailVO.getConfProfileID());
				}
				if (!StringUtils.isNullOrBlank(interfaceMeetingDetailVO.getModelID())) {
					strsql.append(" and modelID= ? ");
					super.addStringForField(interfaceMeetingDetailVO.getModelID());
				}
				if (Integer.MIN_VALUE != interfaceMeetingDetailVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(interfaceMeetingDetailVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(interfaceMeetingDetailVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(interfaceMeetingDetailVO.getDescription());
				}
				if (!StringUtils.isNullOrBlank(interfaceMeetingDetailVO.getRef1())) {
					strsql.append(" and ref1= ? ");
					super.addStringForField(interfaceMeetingDetailVO.getRef1());
				}
				if (!StringUtils.isNullOrBlank(interfaceMeetingDetailVO.getRef2())) {
					strsql.append(" and ref2= ? ");
					super.addStringForField(interfaceMeetingDetailVO.getRef2());
				}
				if (!StringUtils.isNullOrBlank(interfaceMeetingDetailVO.getMainRoomNO())) {
					strsql.append(" and mainroomno= ? ");
					super.addStringForField(interfaceMeetingDetailVO.getMainRoomNO());
				}
				
			}
		} else if (QUERY_FROM_INTERFACEMEETINGDETAIL_BY_IDS == _operatorType) {
			strsql.append(" and id in (?) ");
			super.addStringForField(ids);
		}
		setSql(strsql.toString());
	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public String getSql() {
		return this.sqlStr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		interfaceMeetingDetailVO = new InterfaceMeetingDetailVO();
		interfaceMeetingDetailVO.setId(rs.getString("id"));
		interfaceMeetingDetailVO.setMeetingname(rs.getString("meetingname"));
		interfaceMeetingDetailVO.setStarttime(rs.getTimestamp("starttime"));
		interfaceMeetingDetailVO.setEndtime(rs.getTimestamp("endtime"));
		interfaceMeetingDetailVO.setMeetingType(rs.getInt("meetingType"));
		interfaceMeetingDetailVO.setIsRecord(rs.getInt("isRecord"));
		interfaceMeetingDetailVO.setLevel(rs.getInt("meetingLevel"));
		interfaceMeetingDetailVO.setMeetingStatus(rs.getInt("meetingStatus"));
		interfaceMeetingDetailVO.setNotifyType(rs.getInt("notifyType"));
		interfaceMeetingDetailVO.setCreateUserName(rs.getString("createUserName"));
		interfaceMeetingDetailVO.setCreateTime(rs.getTimestamp("createTime"));
		interfaceMeetingDetailVO.setRoomNos(rs.getString("roomNos"));
		interfaceMeetingDetailVO.setConfProfileID(rs.getString("confProfileID"));
		interfaceMeetingDetailVO.setModelID(rs.getString("modelID"));
		interfaceMeetingDetailVO.setStatus(rs.getInt("status"));
		interfaceMeetingDetailVO.setDescription(rs.getString("description"));
		interfaceMeetingDetailVO.setRef1(rs.getString("ref1"));
		interfaceMeetingDetailVO.setRef2(rs.getString("ref2"));
		interfaceMeetingDetailVO.setMainRoomNO(rs.getString("mainroomno"));
		
		listInterfaceMeetingDetail.add(interfaceMeetingDetailVO);
	}

	public ArrayList<InterfaceMeetingDetailVO> getInterfaceMeetingDetailList() {
		return listInterfaceMeetingDetail;
	}

	public InterfaceMeetingDetailVO getInterfaceMeetingDetailVO() {
		return interfaceMeetingDetailVO;
	}

}
