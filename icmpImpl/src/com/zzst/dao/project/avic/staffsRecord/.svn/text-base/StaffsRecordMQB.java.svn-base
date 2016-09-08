package com.zzst.dao.project.avic.staffsRecord;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.project.avic.StaffsRecordVO;

/**
 * class description: StaffsRecord MQB
 * 
 * @date Fri Sep 14 18:17:43 CST 2012
 * @author ryan
 */
public class StaffsRecordMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(StaffsRecordMQB.class.getName());

	public static int QUERY_FROM_STAFFSRECORD = 1;
	public static int QUERY_FROM_STAFFSRECORD_BY_IDS = 2;

	private StaffsRecordVO staffsRecordVO;
	private ArrayList<StaffsRecordVO> listStaffsRecord = new ArrayList<StaffsRecordVO>();

	private int _operatorType = -1;
	private String ids = "";

	public StaffsRecordMQB(int operatorType, StaffsRecordVO staffsRecordVO) {
		_operatorType = operatorType;
		this.staffsRecordVO = staffsRecordVO;
		makeSql();
	}

	public StaffsRecordMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql
				.append("select staffsRecordID,departmentName,departmentID,departmentNo,facsimile,meetingRoomAddressOne,peopleCountOne,meetingRoomAddressTwo,peopleCountTwo,leaderName,leaderMobile,leaderTel,technicalName,technicalMobile,technicalTel,technicalEmail,netTechnicalName,netTechnicalMobile,netTechnicalTel,netTechnicalEmail,creatPersonID,createDate,description,revision,status ");
		strsql.append(" from avic_t_staffs_record ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_STAFFSRECORD == _operatorType) {
			if (null != staffsRecordVO) {
				if (!StringUtils.isNullOrBlank(staffsRecordVO
						.getStaffsRecordID())) {
					strsql.append(" and staffsRecordID= ? ");
					super.addStringForField(staffsRecordVO.getStaffsRecordID());
				}
				if (!StringUtils.isNullOrBlank(staffsRecordVO
						.getDepartmentName())) {
					strsql.append(" and departmentName like '%"+staffsRecordVO.getDepartmentName().trim()+"%'");
					//super.addStringForField(staffsRecordVO.getDepartmentName());
				}
				if (!StringUtils
						.isNullOrBlank(staffsRecordVO.getDepartmentID())) {
					strsql.append(" and departmentID= ? ");
					super.addStringForField(staffsRecordVO.getDepartmentID());
				}
				if (!StringUtils
						.isNullOrBlank(staffsRecordVO.getDepartmentNo())) {
					strsql.append(" and departmentNo like '%" +staffsRecordVO.getDepartmentNo().trim() + "%'");
					//super.addStringForField(staffsRecordVO.getDepartmentNo());
				}
				if (!StringUtils.isNullOrBlank(staffsRecordVO.getFacsimile())) {
					strsql.append(" and facsimile like '%"+staffsRecordVO.getFacsimile()+"%'");
					//super.addStringForField(staffsRecordVO.getFacsimile());
				}
				if (!StringUtils.isNullOrBlank(staffsRecordVO
						.getMeetingRoomAddressOne())) {
					strsql.append(" and meetingRoomAddressOne= ? ");
					super.addStringForField(staffsRecordVO
							.getMeetingRoomAddressOne());
				}
				if (Integer.MIN_VALUE != staffsRecordVO.getPeopleCountOne()) {
					strsql.append(" and peopleCountOne= ? ");
					super.addIntForField(staffsRecordVO.getPeopleCountOne());
				}
				if (!StringUtils.isNullOrBlank(staffsRecordVO
						.getMeetingRoomAddressTwo())) {
					strsql.append(" and meetingRoomAddressTwo= ? ");
					super.addStringForField(staffsRecordVO
							.getMeetingRoomAddressTwo());
				}
				if (Integer.MIN_VALUE != staffsRecordVO.getPeopleCountTwo()) {
					strsql.append(" and peopleCountTwo= ? ");
					super.addIntForField(staffsRecordVO.getPeopleCountTwo());
				}
				if (!StringUtils.isNullOrBlank(staffsRecordVO.getLeaderName())) {
					strsql.append(" and leaderName= ? ");
					super.addStringForField(staffsRecordVO.getLeaderName());
				}
				if (!StringUtils
						.isNullOrBlank(staffsRecordVO.getLeaderMobile())) {
					strsql.append(" and leaderMobile= ? ");
					super.addStringForField(staffsRecordVO.getLeaderMobile());
				}
				if (!StringUtils.isNullOrBlank(staffsRecordVO.getLeaderTel())) {
					strsql.append(" and leaderTel= ? ");
					super.addStringForField(staffsRecordVO.getLeaderTel());
				}
				if (!StringUtils.isNullOrBlank(staffsRecordVO
						.getTechnicalName())) {
					strsql.append(" and technicalName= ? ");
					super.addStringForField(staffsRecordVO.getTechnicalName());
				}
				if (!StringUtils.isNullOrBlank(staffsRecordVO
						.getTechnicalMobile())) {
					strsql.append(" and technicalMobile= ? ");
					super
							.addStringForField(staffsRecordVO
									.getTechnicalMobile());
				}
				if (!StringUtils
						.isNullOrBlank(staffsRecordVO.getTechnicalTel())) {
					strsql.append(" and technicalTel= ? ");
					super.addStringForField(staffsRecordVO.getTechnicalTel());
				}
				if (!StringUtils.isNullOrBlank(staffsRecordVO
						.getTechnicalEmail())) {
					strsql.append(" and technicalEmail= ? ");
					super.addStringForField(staffsRecordVO.getTechnicalEmail());
				}
				if (!StringUtils.isNullOrBlank(staffsRecordVO
						.getNetTechnicalName())) {
					strsql.append(" and netTechnicalName= ? ");
					super.addStringForField(staffsRecordVO
							.getNetTechnicalName());
				}
				if (!StringUtils.isNullOrBlank(staffsRecordVO
						.getNetTechnicalMobile())) {
					strsql.append(" and netTechnicalMobile= ? ");
					super.addStringForField(staffsRecordVO
							.getNetTechnicalMobile());
				}
				if (!StringUtils.isNullOrBlank(staffsRecordVO
						.getNetTechnicalTel())) {
					strsql.append(" and netTechnicalTel= ? ");
					super.addStringForField(staffsRecordVO.getNetTechnicalTel());
				}
				if (!StringUtils.isNullOrBlank(staffsRecordVO
						.getNetTechnicalEmail())) {
					strsql.append(" and netTechnicalEmail= ? ");
					super.addStringForField(staffsRecordVO
							.getNetTechnicalEmail());
				}
				if (!StringUtils.isNullOrBlank(staffsRecordVO
						.getCreatPersonID())) {
					strsql.append(" and creatPersonID= ? ");
					super.addStringForField(staffsRecordVO.getCreatPersonID());
				}
				if (!StringUtils.isNullOrBlank(staffsRecordVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(staffsRecordVO.getDescription());
				}
				if (Long.MIN_VALUE != staffsRecordVO.getRevision()) {
					strsql.append(" and revision= ? ");
					super.addLongForField(staffsRecordVO.getRevision());
				}
				if (Integer.MIN_VALUE != staffsRecordVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(staffsRecordVO.getStatus());
				}
			}
		} else if (QUERY_FROM_STAFFSRECORD_BY_IDS == _operatorType) {
			strsql.append(" and staffsRecordID in (?) ");
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
		staffsRecordVO = new StaffsRecordVO();
		staffsRecordVO.setStaffsRecordID(rs.getString("staffsRecordID"));
		staffsRecordVO.setDepartmentName(rs.getString("departmentName"));
		staffsRecordVO.setDepartmentID(rs.getString("departmentID"));
		staffsRecordVO.setDepartmentNo(rs.getString("departmentNo"));
		staffsRecordVO.setFacsimile(rs.getString("facsimile"));
		staffsRecordVO.setMeetingRoomAddressOne(rs
				.getString("meetingRoomAddressOne"));
		staffsRecordVO.setPeopleCountOne(rs.getInt("peopleCountOne"));
		staffsRecordVO.setMeetingRoomAddressTwo(rs
				.getString("meetingRoomAddressTwo"));
		staffsRecordVO.setPeopleCountTwo(rs.getInt("peopleCountTwo"));
		staffsRecordVO.setLeaderName(rs.getString("leaderName"));
		staffsRecordVO.setLeaderMobile(rs.getString("leaderMobile"));
		staffsRecordVO.setLeaderTel(rs.getString("leaderTel"));
		staffsRecordVO.setTechnicalName(rs.getString("technicalName"));
		staffsRecordVO.setTechnicalMobile(rs.getString("technicalMobile"));
		staffsRecordVO.setTechnicalTel(rs.getString("technicalTel"));
		staffsRecordVO.setTechnicalEmail(rs.getString("technicalEmail"));
		staffsRecordVO.setNetTechnicalName(rs.getString("netTechnicalName"));
		staffsRecordVO.setNetTechnicalMobile(rs.getString("netTechnicalMobile"));
		staffsRecordVO.setNetTechnicalTel(rs.getString("netTechnicalTel"));
		staffsRecordVO.setNetTechnicalEmail(rs.getString("netTechnicalEmail"));
		staffsRecordVO.setCreatPersonID(rs.getString("creatPersonID"));
		staffsRecordVO.setCreateDate(rs.getTimestamp("createDate"));
		staffsRecordVO.setDescription(rs.getString("description"));
		staffsRecordVO.setRevision(rs.getLong("revision"));
		staffsRecordVO.setStatus(rs.getInt("status"));
		listStaffsRecord.add(staffsRecordVO);
	}

	public ArrayList<StaffsRecordVO> getStaffsRecordList() {
		return listStaffsRecord;
	}

	public StaffsRecordVO getStaffsRecordVO() {
		return staffsRecordVO;
	}

}
