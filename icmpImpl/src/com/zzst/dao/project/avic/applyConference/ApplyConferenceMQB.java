package com.zzst.dao.project.avic.applyConference;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.enums.ApplyEnum;
import com.zzst.model.project.avic.applyConference.ApplyConferenceVO;

/**
 * class description:	ApplyConference MQB
 * @date Wed Sep 19 16:15:16 CST 2012
 * @author ryan
 */
public class ApplyConferenceMQB extends MasterQueryObject {
	
	static Logger logger = CbfLogger.getLogger(ApplyConferenceMQB.class
			.getName());

	public static int QUERY_FROM_APPLYCONFERENCE = 1;
	public static int QUERY_FROM_APPLYCONFERENCE_BY_IDS = 2;
	public static int QUERY_NOSERVICECONFERENCE = 3;
	public static final int QUERY_FROM_BY_USERID = 4;
	public static final int QUERY_HISTORY = 5;
	public static final int QUERY_HISTORY_ALL = 6;

	public static final int QUERY_BUSY_MEETINGROOM = 7;

	private ApplyConferenceVO applyConferenceVO;
	private ArrayList<ApplyConferenceVO> listApplyConference = new ArrayList<ApplyConferenceVO>();

	private int _operatorType = -1;
	private String ids = "";

	public ApplyConferenceMQB(int operatorType,
			ApplyConferenceVO applyConferenceVO) {
		_operatorType = operatorType;
		this.applyConferenceVO = applyConferenceVO;
		makeSql();
	}

	public ApplyConferenceMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}
	
	public ApplyConferenceMQB(int operatorType) {
		_operatorType = operatorType;
	}
	
	public ApplyConferenceMQB(int operatorType,ApplyConferenceVO applyConferenceVO, String ids) {
		_operatorType = operatorType;
		this.applyConferenceVO = applyConferenceVO;
		this.ids = ids;
		makeSql2();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select * ");
		strsql.append(" from avic_t_vc_apply_info ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_APPLYCONFERENCE == _operatorType) {
			if (null != applyConferenceVO) {
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getApplyID())) {
					strsql.append(" and applyID= ? ");
					super.addStringForField(applyConferenceVO.getApplyID());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getDepartmentID())) {
					strsql.append(" and departmentID= ? ");
					super.addStringForField(applyConferenceVO.getDepartmentID());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getDepartmentName())) {
					strsql.append(" and departmentName= ? ");
					super.addStringForField(applyConferenceVO.getDepartmentName());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getDepartmentCode())) {
					strsql.append(" and departmentCode= ? ");
					super.addStringForField(applyConferenceVO.getDepartmentCode());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getLinkManID())) {
					strsql.append(" and linkManID= ? ");
					super.addStringForField(applyConferenceVO.getLinkManID());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getLinkManName())) {
					strsql.append(" and linkManName= ? ");
					super.addStringForField(applyConferenceVO.getLinkManName());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getLinkManPhone())) {
					strsql.append(" and linkManPhone= ? ");
					super.addStringForField(applyConferenceVO.getLinkManPhone());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getLinkManCellPhone())) {
					strsql.append(" and linkManCellPhone= ? ");
					super.addStringForField(applyConferenceVO
							.getLinkManCellPhone());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getLinkManFax())) {
					strsql.append(" and linkManFax= ? ");
					super.addStringForField(applyConferenceVO.getLinkManFax());
				}
				if (Integer.MIN_VALUE != applyConferenceVO.getSecurity()) {
					strsql.append(" and security= ? ");
					super.addIntForField(applyConferenceVO.getSecurity());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getConferenceName())) {
					strsql.append(" and conferenceName= ? ");
					super.addStringForField(applyConferenceVO
							.getConferenceName());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getConferenceAgenda())) {
					strsql.append(" and conferenceAgenda= ? ");
					super.addStringForField(applyConferenceVO
							.getConferenceAgenda());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getGraphicsDepartmentName())) {
					strsql.append(" and graphicsDepartmentName= ? ");
					super.addStringForField(applyConferenceVO
							.getGraphicsDepartmentName());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getSplitScreent())) {
					strsql.append(" and splitScreent= ? ");
					super.addStringForField(applyConferenceVO.getSplitScreent());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getPoll())) {
					strsql.append(" and poll= ? ");
					super.addStringForField(applyConferenceVO.getPoll());
				}
				if (Integer.MIN_VALUE != applyConferenceVO.getVideotape()) {
					strsql.append(" and videotape= ? ");
					super.addIntForField(applyConferenceVO.getVideotape());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getOtherRequire())) {
					strsql.append(" and otherRequire= ? ");
					super.addStringForField(applyConferenceVO.getOtherRequire());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentGroupLeadIDs())) {
					strsql.append(" and departmentGroupLeadIDs= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentGroupLeadIDs());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentGroupLeadNames())) {
					strsql.append(" and departmentGroupLeadNames= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentGroupLeadNames());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentGroupIDS())) {
					strsql.append(" and departmentGroupIDS= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentGroupIDS());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentGroupNames())) {
					strsql.append(" and departmentGroupNames= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentGroupNames());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentDirectlyIDS())) {
					strsql.append(" and departmentDirectlyIDS= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentDirectlyIDS());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentDirectlyNames())) {
					strsql.append(" and departmentDirectlyNames= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentDirectlyNames());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentMemberIDS())) {
					strsql.append(" and departmentMemberIDS= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentMemberIDS());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentMemberNames())) {
					strsql.append(" and departmentMemberNames= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentMemberNames());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentOutMemberIDS())) {
					strsql.append(" and departmentOutMemberIDS= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentOutMemberIDS());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentOutMemberNames())) {
					strsql.append(" and departmentOutMemberNames= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentOutMemberNames());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getCreateUserID())) {
					strsql.append(" and createUserID= ? ");
					super
							.addStringForField(applyConferenceVO
									.getCreateUserID());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getMainVenueNumber())) {
					strsql.append(" and mainVenueNumber= ? ");
					super.addStringForField(applyConferenceVO
							.getMainVenueNumber());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getVenueNumber())) {
					strsql.append(" and venueNumber= ? ");
					super.addStringForField(applyConferenceVO.getVenueNumber());
				}
				if (Integer.MIN_VALUE != applyConferenceVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(applyConferenceVO.getStatus());
				}
				if (Long.MIN_VALUE != applyConferenceVO.getRevision()) {
					strsql.append(" and revision= ? ");
					super.addLongForField(applyConferenceVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(applyConferenceVO.getDescription());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getVenueConference())) {
					strsql.append(" and venueConference= ? ");
					super.addStringForField(applyConferenceVO.getVenueConference());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getMainConference())) {
					strsql.append(" and mainConference= ? ");
					super.addStringForField(applyConferenceVO.getMainConference());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getVenueConferenceIDs())) {
					strsql.append(" and venueConferenceIDs= ? ");
					super.addStringForField(applyConferenceVO.getVenueConferenceIDs());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getMainConferenceID())) {
					strsql.append(" and mainConferenceID= ? ");
					super.addStringForField(applyConferenceVO.getMainConferenceID());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getCountNumber())) {
					strsql.append(" and countNumber= ? ");
					super.addStringForField(applyConferenceVO.getCountNumber());
				}
				if(!StringUtils.isNullOrBlank(applyConferenceVO.getFlowId())){
					strsql.append(" and flowId= ? ");
					super.addStringForField(applyConferenceVO.getFlowId());
				}
				if(!StringUtils.isNullOrBlank(applyConferenceVO.getMeetingDetailID())){
					strsql.append(" and meetingDetailID= ? ");
					super.addStringForField(applyConferenceVO.getMeetingDetailID());
				}
				if(applyConferenceVO.getStartTime()!= null){
					strsql.append(" and startTime>'" + applyConferenceVO.getStartTime()+"'");
				}
				if(applyConferenceVO.getEndTime()!= null){
					strsql.append(" and endTime<'" + applyConferenceVO.getEndTime()+"'");
				}
			}
		} else if (QUERY_FROM_APPLYCONFERENCE_BY_IDS == _operatorType) {
			strsql.append(" and applyID in (?) ");
			super.addStringForField(ids);
		} else if(QUERY_BUSY_MEETINGROOM == _operatorType){
			strsql.append(" and status not in("+ApplyEnum.STATUS_REJECT+","+ApplyEnum.STATUS_REVOKE+")");
			strsql.append(" and (startTime <= '" + applyConferenceVO.getEndTime() + "' " +
					" and endTime >= '" + applyConferenceVO.getStartTime() + "')");
		}
		setSql(strsql.toString());
	}
	private void makeSql2() {
		StringBuffer strsql = new StringBuffer();
		if (QUERY_FROM_BY_USERID == _operatorType) {
			strsql.append("select cai.* ");
			strsql.append(" from avic_t_vc_apply_info cai ,z_t_apply_detail ad");
			strsql.append(" where 1=1 and ad.status="+ApplyEnum.STATUS_ING+" and cai.applyID=ad.applyDetailID and cai.status != 3 ");
			strsql.append(" and ad.checkUserIDs like '%," + ids + ",%'");
			//super.addStringForField(ids);
			if (null != applyConferenceVO) {
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getApplyID())) {
					strsql.append(" and cai.applyID= ? ");
					super.addStringForField(applyConferenceVO.getApplyID());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getDepartmentID())) {
					strsql.append(" and cai.departmentID= ? ");
					super.addStringForField(applyConferenceVO.getDepartmentID());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getDepartmentName())) {
					strsql.append(" and cai.departmentName like ? ");
					super.addStringForField("%" + applyConferenceVO.getDepartmentName().trim() + "%");
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getDepartmentCode())) {
					strsql.append(" and cai.departmentCode= ? ");
					super.addStringForField(applyConferenceVO.getDepartmentCode());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getLinkManID())) {
					strsql.append(" and cai.linkManID= ? ");
					super.addStringForField(applyConferenceVO.getLinkManID());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getLinkManName())) {
					strsql.append(" and cai.linkManName= ? ");
					super.addStringForField(applyConferenceVO.getLinkManName());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getLinkManPhone())) {
					strsql.append(" and cai.linkManPhone= ? ");
					super.addStringForField(applyConferenceVO.getLinkManPhone());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getLinkManCellPhone())) {
					strsql.append(" and cai.linkManCellPhone= ? ");
					super.addStringForField(applyConferenceVO.getLinkManCellPhone());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getLinkManFax())) {
					strsql.append(" and cai.linkManFax= ? ");
					super.addStringForField(applyConferenceVO.getLinkManFax());
				}
				if (Integer.MIN_VALUE != applyConferenceVO.getSecurity()) {
					strsql.append(" and cai.security= ? ");
					super.addIntForField(applyConferenceVO.getSecurity());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getConferenceName())) {
					strsql.append(" and cai.conferenceName like ? ");
					super.addStringForField("%" + applyConferenceVO.getConferenceName().trim() + "%");
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getConferenceAgenda())) {
					strsql.append(" and cai.conferenceAgenda= ? ");
					super.addStringForField(applyConferenceVO.getConferenceAgenda());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getGraphicsDepartmentName())) {
					strsql.append(" and cai.graphicsDepartmentName= ? ");
					super.addStringForField(applyConferenceVO.getGraphicsDepartmentName());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getSplitScreent())) {
					strsql.append(" and cai.splitScreent= ? ");
					super.addStringForField(applyConferenceVO.getSplitScreent());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getPoll())) {
					strsql.append(" and cai.poll= ? ");
					super.addStringForField(applyConferenceVO.getPoll());
				}
				if (Integer.MIN_VALUE != applyConferenceVO.getVideotape()) {
					strsql.append(" and cai.videotape= ? ");
					super.addIntForField(applyConferenceVO.getVideotape());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getOtherRequire())) {
					strsql.append(" and cai.otherRequire= ? ");
					super.addStringForField(applyConferenceVO.getOtherRequire());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getDepartmentGroupLeadIDs())) {
					strsql.append(" and cai.departmentGroupLeadIDs= ? ");
					super.addStringForField(applyConferenceVO.getDepartmentGroupLeadIDs());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getDepartmentGroupLeadNames())) {
					strsql.append(" and cai.departmentGroupLeadNames= ? ");
					super.addStringForField(applyConferenceVO.getDepartmentGroupLeadNames());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getDepartmentGroupIDS())) {
					strsql.append(" and cai.departmentGroupIDS= ? ");
					super.addStringForField(applyConferenceVO.getDepartmentGroupIDS());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getDepartmentGroupNames())) {
					strsql.append(" and cai.departmentGroupNames= ? ");
					super.addStringForField(applyConferenceVO.getDepartmentGroupNames());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getDepartmentDirectlyIDS())) {
					strsql.append(" and cai.departmentDirectlyIDS= ? ");
					super.addStringForField(applyConferenceVO.getDepartmentDirectlyIDS());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getDepartmentDirectlyNames())) {
					strsql.append(" and cai.departmentDirectlyNames= ? ");
					super.addStringForField(applyConferenceVO.getDepartmentDirectlyNames());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getDepartmentMemberIDS())) {
					strsql.append(" and cai.departmentMemberIDS= ? ");
					super.addStringForField(applyConferenceVO.getDepartmentMemberIDS());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getDepartmentMemberNames())) {
					strsql.append(" and cai.departmentMemberNames= ? ");
					super.addStringForField(applyConferenceVO.getDepartmentMemberNames());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getDepartmentOutMemberIDS())) {
					strsql.append(" and cai.departmentOutMemberIDS= ? ");
					super.addStringForField(applyConferenceVO.getDepartmentOutMemberIDS());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getDepartmentOutMemberNames())) {
					strsql.append(" and cai.departmentOutMemberNames= ? ");
					super.addStringForField(applyConferenceVO.getDepartmentOutMemberNames());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getCreateUserID())) {
					strsql.append(" and cai.createUserID= ? ");
					super.addStringForField(applyConferenceVO.getCreateUserID());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getMainVenueNumber())) {
					strsql.append(" and cai.mainVenueNumber= ? ");
					super.addStringForField(applyConferenceVO.getMainVenueNumber());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getVenueNumber())) {
					strsql.append(" and cai.venueNumber= ? ");
					super.addStringForField(applyConferenceVO.getVenueNumber());
				}
				if (Integer.MIN_VALUE != applyConferenceVO.getStatus()) {
					strsql.append(" and cai.status= ? ");
					super.addIntForField(applyConferenceVO.getStatus());
				}
				if (Long.MIN_VALUE != applyConferenceVO.getRevision()) {
					strsql.append(" and cai.revision= ? ");
					super.addLongForField(applyConferenceVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getDescription())) {
					strsql.append(" and cai.description= ? ");
					super.addStringForField(applyConferenceVO.getDescription());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getVenueConference())) {
					strsql.append(" and cai.venueConference= ? ");
					super.addStringForField(applyConferenceVO.getVenueConference());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getMainConference())) {
					strsql.append(" and cai.mainConference= ? ");
					super.addStringForField(applyConferenceVO.getMainConference());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getVenueConferenceIDs())) {
					strsql.append(" and venueConferenceIDs= ? ");
					super.addStringForField(applyConferenceVO.getVenueConferenceIDs());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getMainConferenceID())) {
					strsql.append(" and mainConferenceID= ? ");
					super.addStringForField(applyConferenceVO.getMainConferenceID());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getCountNumber())) {
					strsql.append(" and cai.countNumber= ? ");
					super.addStringForField(applyConferenceVO.getCountNumber());
				}
				if(!StringUtils.isNullOrBlank(applyConferenceVO.getFlowId())){
					strsql.append(" and cai.flowId= ? ");
					super.addStringForField(applyConferenceVO.getFlowId());
				}
				if(!StringUtils.isNullOrBlank(applyConferenceVO.getMeetingDetailID())){
					strsql.append(" and cai.meetingDetailID= ? ");
					super.addStringForField(applyConferenceVO.getMeetingDetailID());
				}
			}
			strsql.append(" group by cai.applyID order by cai.startTime desc");
		}else if(QUERY_HISTORY == _operatorType) {
			strsql.append("select cai.*");
			strsql.append(" from avic_t_vc_apply_info cai , z_t_apply_detail ad");
			strsql.append(" where 1=1 and cai.applyID = ad.applyDetailID and ad.userId = ? ");
			super.addStringForField(ids);
			if (null != applyConferenceVO) {
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getApplyID())) {
					strsql.append(" and cai.applyID= ? ");
					super.addStringForField(applyConferenceVO.getApplyID());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getDepartmentID())) {
					strsql.append(" and cai.departmentID= ? ");
					super.addStringForField(applyConferenceVO.getDepartmentID());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getDepartmentName())) {
					strsql.append(" and cai.departmentName= ? ");
					super.addStringForField(applyConferenceVO.getDepartmentName());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getDepartmentCode())) {
					strsql.append(" and cai.departmentCode= ? ");
					super.addStringForField(applyConferenceVO.getDepartmentCode());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getLinkManID())) {
					strsql.append(" and cai.linkManID= ? ");
					super.addStringForField(applyConferenceVO.getLinkManID());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getLinkManName())) {
					strsql.append(" and cai.linkManName= ? ");
					super.addStringForField(applyConferenceVO.getLinkManName());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getLinkManPhone())) {
					strsql.append(" and cai.linkManPhone= ? ");
					super.addStringForField(applyConferenceVO.getLinkManPhone());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getLinkManCellPhone())) {
					strsql.append(" and cai.linkManCellPhone= ? ");
					super.addStringForField(applyConferenceVO
							.getLinkManCellPhone());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getLinkManFax())) {
					strsql.append(" and cai.linkManFax= ? ");
					super.addStringForField(applyConferenceVO.getLinkManFax());
				}
				if (Integer.MIN_VALUE != applyConferenceVO.getSecurity()) {
					strsql.append(" and cai.security= ? ");
					super.addIntForField(applyConferenceVO.getSecurity());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getConferenceName())) {
					strsql.append(" and cai.conferenceName like ? ");
					super.addStringForField("%" + applyConferenceVO
							.getConferenceName().trim() + "%");
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getConferenceAgenda())) {
					strsql.append(" and cai.conferenceAgenda= ? ");
					super.addStringForField(applyConferenceVO
							.getConferenceAgenda());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getGraphicsDepartmentName())) {
					strsql.append(" and cai.graphicsDepartmentName= ? ");
					super.addStringForField(applyConferenceVO
							.getGraphicsDepartmentName());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getSplitScreent())) {
					strsql.append(" and cai.splitScreent= ? ");
					super.addStringForField(applyConferenceVO.getSplitScreent());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getPoll())) {
					strsql.append(" and cai.poll= ? ");
					super.addStringForField(applyConferenceVO.getPoll());
				}
				if (Integer.MIN_VALUE != applyConferenceVO.getVideotape()) {
					strsql.append(" and cai.videotape= ? ");
					super.addIntForField(applyConferenceVO.getVideotape());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getOtherRequire())) {
					strsql.append(" and cai.otherRequire= ? ");
					super.addStringForField(applyConferenceVO.getOtherRequire());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentGroupLeadIDs())) {
					strsql.append(" and cai.departmentGroupLeadIDs= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentGroupLeadIDs());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentGroupLeadNames())) {
					strsql.append(" and cai.departmentGroupLeadNames= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentGroupLeadNames());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentGroupIDS())) {
					strsql.append(" and cai.departmentGroupIDS= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentGroupIDS());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentGroupNames())) {
					strsql.append(" and cai.departmentGroupNames= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentGroupNames());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentDirectlyIDS())) {
					strsql.append(" and cai.departmentDirectlyIDS= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentDirectlyIDS());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentDirectlyNames())) {
					strsql.append(" and cai.departmentDirectlyNames= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentDirectlyNames());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentMemberIDS())) {
					strsql.append(" and cai.departmentMemberIDS= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentMemberIDS());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentMemberNames())) {
					strsql.append(" and cai.departmentMemberNames= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentMemberNames());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentOutMemberIDS())) {
					strsql.append(" and cai.departmentOutMemberIDS= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentOutMemberIDS());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentOutMemberNames())) {
					strsql.append(" and cai.departmentOutMemberNames= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentOutMemberNames());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getCreateUserID())) {
					strsql.append(" and cai.createUserID= ? ");
					super.addStringForField(applyConferenceVO.getCreateUserID());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getMainVenueNumber())) {
					strsql.append(" and cai.mainVenueNumber= ? ");
					super.addStringForField(applyConferenceVO
							.getMainVenueNumber());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getVenueNumber())) {
					strsql.append(" and cai.venueNumber= ? ");
					super.addStringForField(applyConferenceVO.getVenueNumber());
				}
				if (Integer.MIN_VALUE != applyConferenceVO.getStatus()) {
					strsql.append(" and cai.status= ? ");
					super.addIntForField(applyConferenceVO.getStatus());
				}
				if (Long.MIN_VALUE != applyConferenceVO.getRevision()) {
					strsql.append(" and cai.revision= ? ");
					super.addLongForField(applyConferenceVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDescription())) {
					strsql.append(" and cai.description= ? ");
					super.addStringForField(applyConferenceVO.getDescription());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getVenueConference())) {
					strsql.append(" and cai.venueConference= ? ");
					super.addStringForField(applyConferenceVO.getVenueConference());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getMainConference())) {
					strsql.append(" and cai.mainConference= ? ");
					super.addStringForField(applyConferenceVO.getMainConference());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getVenueConferenceIDs())) {
					strsql.append(" and venueConferenceIDs= ? ");
					super.addStringForField(applyConferenceVO.getVenueConferenceIDs());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getMainConferenceID())) {
					strsql.append(" and mainConferenceID= ? ");
					super.addStringForField(applyConferenceVO.getMainConferenceID());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getCountNumber())) {
					strsql.append(" and cai.countNumber= ? ");
					super.addStringForField(applyConferenceVO.getCountNumber());
				}
				if(!StringUtils.isNullOrBlank(applyConferenceVO.getFlowId())){
					strsql.append(" and cai.flowId= ? ");
					super.addStringForField(applyConferenceVO.getFlowId());
				}
				if(!StringUtils.isNullOrBlank(applyConferenceVO.getMeetingDetailID())){
					strsql.append(" and cai.meetingDetailID= ? ");
					super.addStringForField(applyConferenceVO.getMeetingDetailID());
				}
			}
			strsql.append(" group by cai.applyID order by cai.startTime desc");
		}else if(QUERY_HISTORY_ALL == _operatorType) {
			strsql.append("select cai.* ");
			strsql.append("from avic_t_vc_apply_info cai , z_t_apply_detail ad ");
			strsql.append("where 1=1 and cai.applyID = ad.applyDetailID ");
			if (null != applyConferenceVO) {
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getApplyID())) {
					strsql.append(" and cai.applyID= ? ");
					super.addStringForField(applyConferenceVO.getApplyID());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getDepartmentID())) {
					strsql.append(" and cai.departmentID= ? ");
					super.addStringForField(applyConferenceVO.getDepartmentID());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getDepartmentName())) {
					strsql.append(" and cai.departmentName= ? ");
					super.addStringForField(applyConferenceVO.getDepartmentName());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getDepartmentCode())) {
					strsql.append(" and cai.departmentCode= ? ");
					super.addStringForField(applyConferenceVO.getDepartmentCode());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getLinkManID())) {
					strsql.append(" and cai.linkManID= ? ");
					super.addStringForField(applyConferenceVO.getLinkManID());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getLinkManName())) {
					strsql.append(" and cai.linkManName= ? ");
					super.addStringForField(applyConferenceVO.getLinkManName());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getLinkManPhone())) {
					strsql.append(" and cai.linkManPhone= ? ");
					super.addStringForField(applyConferenceVO.getLinkManPhone());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getLinkManCellPhone())) {
					strsql.append(" and cai.linkManCellPhone= ? ");
					super.addStringForField(applyConferenceVO
							.getLinkManCellPhone());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getLinkManFax())) {
					strsql.append(" and cai.linkManFax= ? ");
					super.addStringForField(applyConferenceVO.getLinkManFax());
				}
				if (Integer.MIN_VALUE != applyConferenceVO.getSecurity()) {
					strsql.append(" and cai.security= ? ");
					super.addIntForField(applyConferenceVO.getSecurity());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getConferenceName())) {
					strsql.append(" and cai.conferenceName like ? ");
					super.addStringForField("%" + applyConferenceVO
							.getConferenceName().trim() + "%");
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getConferenceAgenda())) {
					strsql.append(" and cai.conferenceAgenda= ? ");
					super.addStringForField(applyConferenceVO
							.getConferenceAgenda());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getGraphicsDepartmentName())) {
					strsql.append(" and cai.graphicsDepartmentName= ? ");
					super.addStringForField(applyConferenceVO
							.getGraphicsDepartmentName());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getSplitScreent())) {
					strsql.append(" and cai.splitScreent= ? ");
					super
							.addStringForField(applyConferenceVO
									.getSplitScreent());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getPoll())) {
					strsql.append(" and cai.poll= ? ");
					super.addStringForField(applyConferenceVO.getPoll());
				}
				if (Integer.MIN_VALUE != applyConferenceVO.getVideotape()) {
					strsql.append(" and cai.videotape= ? ");
					super.addIntForField(applyConferenceVO.getVideotape());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getOtherRequire())) {
					strsql.append(" and cai.otherRequire= ? ");
					super
							.addStringForField(applyConferenceVO
									.getOtherRequire());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentGroupLeadIDs())) {
					strsql.append(" and cai.departmentGroupLeadIDs= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentGroupLeadIDs());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentGroupLeadNames())) {
					strsql.append(" and cai.departmentGroupLeadNames= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentGroupLeadNames());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentGroupIDS())) {
					strsql.append(" and cai.departmentGroupIDS= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentGroupIDS());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentGroupNames())) {
					strsql.append(" and cai.departmentGroupNames= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentGroupNames());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentDirectlyIDS())) {
					strsql.append(" and cai.departmentDirectlyIDS= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentDirectlyIDS());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentDirectlyNames())) {
					strsql.append(" and cai.departmentDirectlyNames= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentDirectlyNames());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentMemberIDS())) {
					strsql.append(" and cai.departmentMemberIDS= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentMemberIDS());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentMemberNames())) {
					strsql.append(" and cai.departmentMemberNames= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentMemberNames());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentOutMemberIDS())) {
					strsql.append(" and cai.departmentOutMemberIDS= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentOutMemberIDS());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDepartmentOutMemberNames())) {
					strsql.append(" and cai.departmentOutMemberNames= ? ");
					super.addStringForField(applyConferenceVO
							.getDepartmentOutMemberNames());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getCreateUserID())) {
					strsql.append(" and cai.createUserID= ? ");
					super.addStringForField(applyConferenceVO.getCreateUserID());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getMainVenueNumber())) {
					strsql.append(" and cai.mainVenueNumber= ? ");
					super.addStringForField(applyConferenceVO
							.getMainVenueNumber());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getVenueNumber())) {
					strsql.append(" and cai.venueNumber= ? ");
					super.addStringForField(applyConferenceVO.getVenueNumber());
				}
				if (Integer.MIN_VALUE != applyConferenceVO.getStatus()) {
					strsql.append(" and cai.status= ? ");
					super.addIntForField(applyConferenceVO.getStatus());
				}
				if (Long.MIN_VALUE != applyConferenceVO.getRevision()) {
					strsql.append(" and cai.revision= ? ");
					super.addLongForField(applyConferenceVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getDescription())) {
					strsql.append(" and cai.description= ? ");
					super.addStringForField(applyConferenceVO.getDescription());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getVenueConference())) {
					strsql.append(" and cai.venueConference= ? ");
					super.addStringForField(applyConferenceVO.getVenueConference());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getMainConference())) {
					strsql.append(" and cai.mainConference= ? ");
					super.addStringForField(applyConferenceVO.getMainConference());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getVenueConferenceIDs())) {
					strsql.append(" and venueConferenceIDs= ? ");
					super.addStringForField(applyConferenceVO.getVenueConferenceIDs());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO.getMainConferenceID())) {
					strsql.append(" and mainConferenceID= ? ");
					super.addStringForField(applyConferenceVO.getMainConferenceID());
				}
				if (!StringUtils.isNullOrBlank(applyConferenceVO
						.getCountNumber())) {
					strsql.append(" and cai.countNumber= ? ");
					super.addStringForField(applyConferenceVO.getCountNumber());
				}
				if(!StringUtils.isNullOrBlank(applyConferenceVO.getFlowId())){
					strsql.append(" and cai.flowId= ? ");
					super.addStringForField(applyConferenceVO.getFlowId());
				}
				if(!StringUtils.isNullOrBlank(applyConferenceVO.getMeetingDetailID())){
					strsql.append(" and cai.meetingDetailID= ? ");
					super.addStringForField(applyConferenceVO.getMeetingDetailID());
				}
			}
			strsql.append(" group by cai.applyID order by cai.startTime desc");
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
		if( QUERY_NOSERVICECONFERENCE == _operatorType){
			applyConferenceVO = new ApplyConferenceVO();
			applyConferenceVO.setApplyID(rs.getString("applyID"));
			applyConferenceVO.setConferenceName(rs.getString("conferenceName"));
			applyConferenceVO.setLinkManID(rs.getString("linkManID"));
			applyConferenceVO.setLinkManName(rs.getString("linkManName"));
			listApplyConference.add(applyConferenceVO);
		}else{
			applyConferenceVO = new ApplyConferenceVO();
			applyConferenceVO.setApplyID(rs.getString("applyID"));
			applyConferenceVO.setDepartmentID(rs.getString("departmentID"));
			applyConferenceVO.setDepartmentName(rs.getString("departmentName"));
			applyConferenceVO.setDepartmentCode(rs.getString("departmentCode"));
			applyConferenceVO.setLinkManID(rs.getString("linkManID"));
			applyConferenceVO.setLinkManName(rs.getString("linkManName"));
			applyConferenceVO.setLinkManPhone(rs.getString("linkManPhone"));
			applyConferenceVO.setLinkManCellPhone(rs.getString("linkManCellPhone"));
			applyConferenceVO.setLinkManFax(rs.getString("linkManFax"));
			applyConferenceVO.setSecurity(rs.getInt("security"));
			applyConferenceVO.setStartTime(rs.getTimestamp("startTime"));
			applyConferenceVO.setEndTime(rs.getTimestamp("endTime"));
			applyConferenceVO.setConferenceName(rs.getString("conferenceName"));
			applyConferenceVO.setConferenceAgenda(rs.getString("conferenceAgenda"));
			applyConferenceVO.setGraphicsDepartmentName(rs
					.getString("graphicsDepartmentName"));
			applyConferenceVO.setSplitScreent(rs.getString("splitScreent"));
			applyConferenceVO.setPoll(rs.getString("poll"));
			applyConferenceVO.setVideotape(rs.getInt("videotape"));
			applyConferenceVO.setOtherRequire(rs.getString("otherRequire"));
			applyConferenceVO.setDepartmentGroupLeadIDs(rs
					.getString("departmentGroupLeadIDs"));
			applyConferenceVO.setDepartmentGroupLeadNames(rs
					.getString("departmentGroupLeadNames"));
			applyConferenceVO.setDepartmentGroupIDS(rs
					.getString("departmentGroupIDS"));
			applyConferenceVO.setDepartmentGroupNames(rs
					.getString("departmentGroupNames"));
			applyConferenceVO.setDepartmentDirectlyIDS(rs
					.getString("departmentDirectlyIDS"));
			applyConferenceVO.setDepartmentDirectlyNames(rs
					.getString("departmentDirectlyNames"));
			applyConferenceVO.setDepartmentMemberIDS(rs
					.getString("departmentMemberIDS"));
			applyConferenceVO.setDepartmentMemberNames(rs
					.getString("departmentMemberNames"));
			applyConferenceVO.setDepartmentOutMemberIDS(rs
					.getString("departmentOutMemberIDS"));
			applyConferenceVO.setDepartmentOutMemberNames(rs
					.getString("departmentOutMemberNames"));
			applyConferenceVO.setCreateUserID(rs.getString("createUserID"));
			applyConferenceVO.setMainVenueNumber(rs.getString("mainVenueNumber"));
			applyConferenceVO.setVenueNumber(rs.getString("venueNumber"));
			applyConferenceVO.setCreateTime(rs.getTimestamp("createTime"));
			applyConferenceVO.setStatus(rs.getInt("status"));
			applyConferenceVO.setRevision(rs.getLong("revision"));
			applyConferenceVO.setDescription(rs.getString("description"));
			applyConferenceVO.setVenueConference(rs.getString("venueConference"));
			applyConferenceVO.setMainConference(rs.getString("mainConference"));
			applyConferenceVO.setVenueConferenceIDs(rs.getString("venueConferenceIDs"));
			applyConferenceVO.setMainConferenceID(rs.getString("mainConferenceID"));
			applyConferenceVO.setCountNumber(rs.getString("countNumber"));
			applyConferenceVO.setFlowId(rs.getString("flowId"));
			applyConferenceVO.setMeetingDetailID(rs.getString("meetingDetailID"));
			listApplyConference.add(applyConferenceVO);
		}
	}

	public ArrayList<ApplyConferenceVO> getApplyConferenceList() {
		return listApplyConference;
	}

	public ApplyConferenceVO getApplyConferenceVO() {
		return applyConferenceVO;
	}

}