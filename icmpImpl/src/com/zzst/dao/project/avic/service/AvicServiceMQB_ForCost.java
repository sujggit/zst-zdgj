package com.zzst.dao.project.avic.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.enums.ApplyEnum;
import com.zzst.model.project.avic.applyConference.ApplyConferenceVO;
import com.zzst.model.project.avic.service.AvicServiceVO;

/**
 * class description: AvicService MQB
 * 
 * @date Thu Sep 20 15:23:06 CST 2012
 * @author ryan
 */
public class AvicServiceMQB_ForCost extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(AvicServiceMQB_ForCost.class.getName());

	public static int QUERY_FOR_COST_STATISTICES = 6;
	private AvicServiceVO avicServiceVO;
	private ArrayList<AvicServiceVO> listAvicService = new ArrayList<AvicServiceVO>();

	private int _operatorType = -1;
	private String ids = "";

	public AvicServiceMQB_ForCost(int operatorType, AvicServiceVO avicServiceVO) {
		_operatorType = operatorType;
		this.avicServiceVO = avicServiceVO;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		if(QUERY_FOR_COST_STATISTICES == _operatorType) {
			strsql.append("select atvcai.conferenceName,atvcai.startTime,atvcai.endTime,ats.* ");
			strsql.append(" from avic_t_service ats , avic_t_vc_apply_info atvcai ");
			strsql.append(" where 1=1 and ats.meetingDetailID=atvcai.applyID");
			strsql.append(" and ats.status not in("+ApplyEnum.STATUS_REVOKE+","+ApplyEnum.STATUS_REJECT+") ");
			if (null != avicServiceVO) {
				if (!StringUtils.isNullOrBlank(avicServiceVO.getRecordID())) {
					strsql.append(" and ats.recordID= ? ");
					super.addStringForField(avicServiceVO.getRecordID());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getDepartmentID())) {
					strsql.append(" and ats.departmentID= ? ");
					super.addStringForField(avicServiceVO.getDepartmentID());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getDepartmentName())) {
					strsql.append(" and ats.departmentName like ? ");
					super.addStringForField("%" + avicServiceVO.getDepartmentName().trim() +"%");
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getDepartmentCode())) {
					strsql.append(" and ats.departmentCode= ? ");
					super.addStringForField(avicServiceVO.getDepartmentCode());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getMeetingDetailID())) {
					strsql.append(" and ats.meetingDetailID= ? ");
					super.addStringForField(avicServiceVO.getMeetingDetailID());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getMeetingDetailName())) {
					strsql.append(" and ats.meetingDetailName like ? ");
					super.addStringForField("%"+avicServiceVO.getMeetingDetailName()+"%");
				}
				if (Integer.MIN_VALUE != avicServiceVO.getHeadQuarterLeaderNumber()) {
					strsql.append(" and ats.headQuarterLeaderNumber= ? ");
					super.addIntForField(avicServiceVO
							.getHeadQuarterLeaderNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getDepartmentLeaderNumber()) {
					strsql.append(" and ats.departmentLeaderNumber= ? ");
					super.addIntForField(avicServiceVO
							.getDepartmentLeaderNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getHeadQuarterEastNumber()) {
					strsql.append(" and ats.headQuarterEastNumber= ? ");
					super.addIntForField(avicServiceVO
							.getHeadQuarterEastNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getHeadQuarterWestNumber()) {
					strsql.append(" and ats.headQuarterWestNumber= ? ");
					super.addIntForField(avicServiceVO
							.getHeadQuarterWestNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getJinHangNetWorkNumber()) {
					strsql.append(" and ats.jinHangNetWorkNumber= ? ");
					super.addIntForField(avicServiceVO
							.getJinHangNetWorkNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getOtherVenueNumber()) {
					strsql.append(" and ats.otherVenueNumber= ? ");
					super.addIntForField(avicServiceVO.getOtherVenueNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getNetWorkNumber()) {
					strsql.append(" and ats.netWorkNumber= ? ");
					super.addIntForField(avicServiceVO.getNetWorkNumber());
				}
				if (!StringUtils
						.isNullOrBlank(avicServiceVO.getRecordService())) {
					strsql.append(" and ats.recordService= ? ");
					super.addStringForField(avicServiceVO.getRecordService());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getOtherDes())) {
					strsql.append(" and ats.otherDes= ? ");
					super.addStringForField(avicServiceVO.getOtherDes());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getRealityVenueNumber()) {
					strsql.append(" and ats.realityVenueNumber= ? ");
					super.addIntForField(avicServiceVO.getRealityVenueNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO
						.getRealityPersonnelNumber()) {
					strsql.append(" and ats.realityPersonnelNumber= ? ");
					super.addIntForField(avicServiceVO
							.getRealityPersonnelNumber());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO
						.getVenuePrincipal())) {
					strsql.append(" and ats.venuePrincipal= ? ");
					super.addStringForField(avicServiceVO.getVenuePrincipal());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getCreateUserID())) {
					strsql.append(" and ats.createUserID= ? ");
					super.addStringForField(avicServiceVO.getCreateUserID());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getStatus()) {
					strsql.append(" and ats.status= ? ");
					super.addIntForField(avicServiceVO.getStatus());
				}else{
					strsql.append(" and ats.status!="+Integer.MIN_VALUE);
				}
				if (Long.MIN_VALUE != avicServiceVO.getRevision()) {
					strsql.append(" and ats.revision= ? ");
					super.addLongForField(avicServiceVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getDescription())) {
					strsql.append(" and ats.description= ? ");
					super.addStringForField(avicServiceVO.getDescription());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getFlowId())) {
					strsql.append(" and ats.flowId= ? ");
					super.addStringForField(avicServiceVO.getFlowId());
				}if (avicServiceVO.getApplyConferenceVO().getStartTime()!=null) {
					strsql.append(" and atvcai.startTime>'" + avicServiceVO.getApplyConferenceVO().getStartTime()+"'");
				}
				if (avicServiceVO.getApplyConferenceVO().getEndTime()!=null) {
					strsql.append(" and atvcai.endTime<'" + avicServiceVO.getApplyConferenceVO().getEndTime()+"'");
				}
			}
			strsql.append(" order by atvcai.startTime desc");
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
		avicServiceVO = new AvicServiceVO();
		avicServiceVO.setRecordID(rs.getString("recordID"));
		avicServiceVO.setDepartmentID(rs.getString("departmentID"));
		avicServiceVO.setDepartmentName(rs.getString("departmentName"));
		avicServiceVO.setDepartmentCode(rs.getString("departmentCode"));
		avicServiceVO.setMeetingDetailID(rs.getString("meetingDetailID"));
		avicServiceVO.setMeetingDetailName(rs.getString("meetingDetailName"));
		avicServiceVO.setHeadQuarterLeaderNumber(rs
				.getInt("headQuarterLeaderNumber"));
		avicServiceVO.setDepartmentLeaderNumber(rs
				.getInt("departmentLeaderNumber"));
		avicServiceVO.setHeadQuarterEastNumber(rs
				.getInt("headQuarterEastNumber"));
		avicServiceVO.setHeadQuarterWestNumber(rs
				.getInt("headQuarterWestNumber"));
		avicServiceVO
				.setJinHangNetWorkNumber(rs.getInt("jinHangNetWorkNumber"));
		avicServiceVO.setOtherVenueNumber(rs.getInt("otherVenueNumber"));
		avicServiceVO.setNetWorkNumber(rs.getInt("netWorkNumber"));
		avicServiceVO.setRecordService(rs.getString("recordService"));
		avicServiceVO.setOtherDes(rs.getString("otherDes"));
		avicServiceVO.setRealityVenueNumber(rs.getInt("realityVenueNumber"));
		avicServiceVO.setRealityPersonnelNumber(rs
				.getInt("realityPersonnelNumber"));
		avicServiceVO.setVenuePrincipal(rs.getString("venuePrincipal"));
		avicServiceVO.setCreateUserID(rs.getString("createUserID"));
		avicServiceVO.setCreateTime(rs.getTimestamp("createTime"));
		avicServiceVO.setStatus(rs.getInt("status"));
		avicServiceVO.setRevision(rs.getLong("revision"));
		avicServiceVO.setDescription(rs.getString("description"));
		avicServiceVO.setFlowId(rs.getString("flowId"));
		ApplyConferenceVO applyConferenceVO = new ApplyConferenceVO();
		applyConferenceVO.setConferenceName(rs.getString("conferenceName"));
		applyConferenceVO.setStartTime(rs.getTimestamp("startTime"));
		applyConferenceVO.setEndTime(rs.getTimestamp("endTime"));
		avicServiceVO.setApplyConferenceVO(applyConferenceVO);
		listAvicService.add(avicServiceVO);
	}

	public ArrayList<AvicServiceVO> getAvicServiceList() {
		return listAvicService;
	}

	public AvicServiceVO getAvicServiceVO() {
		return avicServiceVO;
	}

}
