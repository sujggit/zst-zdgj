package com.zzst.dao.meeting.templateMeeting;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.templateMeeting.TemplateMeetingVO;

/**
 * class description: TemplateMeeting MQB
 * 
 * @date Wed Mar 20 17:56:26 CST 2013
 * @author ryan
 */
public class TemplateMeetingMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(TemplateMeetingMQB.class
			.getName());

	public static int QUERY_FROM_TEMPLATEMEETING = 1;
	public static int QUERY_FROM_TEMPLATEMEETING_BY_IDS = 2;

	private TemplateMeetingVO templateMeetingVO;
	private ArrayList<TemplateMeetingVO> listTemplateMeeting = new ArrayList<TemplateMeetingVO>();

	private int _operatorType = -1;
	private String ids = "";

	public TemplateMeetingMQB(int operatorType,
			TemplateMeetingVO templateMeetingVO) {
		_operatorType = operatorType;
		this.templateMeetingVO = templateMeetingVO;
		makeSql();
	}

	public TemplateMeetingMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql
				.append("select id,templateId,meetingName,meetingNumber,mcuEquipmentId,isMain,parentId,groupId,mcuTemplateID,createUserID,createTime,updateTime,status,description,rank ");
		strsql.append(" from z_t_template_meeting ");
		strsql.append(" where 1=1 and status !=1 ");

		if (QUERY_FROM_TEMPLATEMEETING == _operatorType) {
			if (null != templateMeetingVO) {
				if (!StringUtils.isNullOrBlank(templateMeetingVO.getId())) {
					strsql.append(" and id= ? ");
					super.addStringForField(templateMeetingVO.getId());
				}
				if (!StringUtils.isNullOrBlank(templateMeetingVO
						.getTemplateId())) {
					strsql.append(" and templateId= ? ");
					super.addStringForField(templateMeetingVO.getTemplateId());
				}
				if (!StringUtils.isNullOrBlank(templateMeetingVO
						.getMeetingName())) {
					strsql.append(" and meetingName like ? ");
					super.addStringForField("%"+templateMeetingVO.getMeetingName().trim()+"%");
				}
				if (!StringUtils.isNullOrBlank(templateMeetingVO
						.getMeetingNumber())) {
					strsql.append(" and meetingNumber= ? ");
					super.addStringForField(templateMeetingVO
							.getMeetingNumber());
				}
				if (!StringUtils.isNullOrBlank(templateMeetingVO
						.getMcuEquipmentId())) {
					strsql.append(" and mcuEquipmentId= ? ");
					super.addStringForField(templateMeetingVO
							.getMcuEquipmentId());
				}
				if (Integer.MIN_VALUE != templateMeetingVO.getIsMain()) {
					strsql.append(" and isMain= ? ");
					super.addIntForField(templateMeetingVO.getIsMain());
				}
				if (!StringUtils.isNullOrBlank(templateMeetingVO.getParentId())) {
					strsql.append(" and parentId= ? ");
					super.addStringForField(templateMeetingVO.getParentId());
				}
				if (!StringUtils.isNullOrBlank(templateMeetingVO.getGroupId())) {
					strsql.append(" and groupId= ? ");
					super.addStringForField(templateMeetingVO.getGroupId());
				}
				
				
				if (!StringUtils.isNullOrBlank(templateMeetingVO
						.getCreateUserID())) {
					strsql.append(" and createUserID= ? ");
					super
							.addStringForField(templateMeetingVO
									.getCreateUserID());
				}
				
				if (Integer.MIN_VALUE != templateMeetingVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(templateMeetingVO.getStatus());
				}
				
				if (!StringUtils.isNullOrBlank(templateMeetingVO
						.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(templateMeetingVO.getDescription());
				}
				
				if (Integer.MIN_VALUE != templateMeetingVO.getRank()) {
					strsql.append(" and rank= ? ");
					super.addIntForField(templateMeetingVO.getRank());
				}
			}
		} else if (QUERY_FROM_TEMPLATEMEETING_BY_IDS == _operatorType) {
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
		templateMeetingVO = new TemplateMeetingVO();
		templateMeetingVO.setId(rs.getString("id"));
		templateMeetingVO.setTemplateId(rs.getString("templateId"));
		templateMeetingVO.setMeetingName(rs.getString("meetingName"));
		templateMeetingVO.setMeetingNumber(rs.getString("meetingNumber"));
		templateMeetingVO.setMcuEquipmentId(rs.getString("mcuEquipmentId"));
		templateMeetingVO.setIsMain(rs.getInt("isMain"));
		templateMeetingVO.setParentId(rs.getString("parentId"));
		templateMeetingVO.setGroupId(rs.getString("groupId"));
		templateMeetingVO.setMcuTemplateID(rs.getString("mcuTemplateID"));
		templateMeetingVO.setStatus(rs.getInt("status"));
		templateMeetingVO.setDescription(rs.getString("description"));
		templateMeetingVO.setRank(rs.getInt("rank"));
		templateMeetingVO.setCreateUserID(rs.getString("createUserID"));
		templateMeetingVO.setCreateTime(rs.getTimestamp("createTime"));
		templateMeetingVO.setUpdateTime(rs.getTimestamp("updateTime"));
		listTemplateMeeting.add(templateMeetingVO);
	}

	public ArrayList<TemplateMeetingVO> getTemplateMeetingList() {
		return listTemplateMeeting;
	}

	public TemplateMeetingVO getTemplateMeetingVO() {
		return templateMeetingVO;
	}

}
