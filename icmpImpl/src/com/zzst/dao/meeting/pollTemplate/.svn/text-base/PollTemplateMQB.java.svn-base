package com.zzst.dao.meeting.pollTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.pollTemplate.PollTemplateVO;

/**
 * class description: PollTemplate MQB
 * 
 * @date Thu May 16 15:21:34 CST 2013
 * @author ryan
 */
public class PollTemplateMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(PollTemplateMQB.class.getName());

	public static int QUERY_FROM_POLLTEMPLATE = 1;
	public static int QUERY_FROM_POLLTEMPLATE_BY_IDS = 2;

	private PollTemplateVO pollTemplateVO;
	private ArrayList<PollTemplateVO> listPollTemplate = new ArrayList<PollTemplateVO>();

	private int _operatorType = -1;
	private String ids = "";

	public PollTemplateMQB(int operatorType, PollTemplateVO pollTemplateVO) {
		_operatorType = operatorType;
		this.pollTemplateVO = pollTemplateVO;
		makeSql();
	}

	public PollTemplateMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql
				.append("select pollTemplateID,pollTemplateName,createUserID,createTime,description,status ");
		strsql.append(" from z_t_poll_template ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_POLLTEMPLATE == _operatorType) {
			if (null != pollTemplateVO) {
				if (!StringUtils.isNullOrBlank(pollTemplateVO
						.getPollTemplateID())) {
					strsql.append(" and pollTemplateID= ? ");
					super.addStringForField(pollTemplateVO.getPollTemplateID());
				}
				if (!StringUtils.isNullOrBlank(pollTemplateVO
						.getPollTemplateName())) {
					strsql.append(" and pollTemplateName like ? ");
					super.addStringForField("%"
							+ pollTemplateVO.getPollTemplateName() + "%");
				}
				if (!StringUtils
						.isNullOrBlank(pollTemplateVO.getCreateUserID())) {
					strsql.append(" and createUserID= ? ");
					super.addStringForField(pollTemplateVO.getCreateUserID());
				}
				if (!StringUtils.isNullOrBlank(pollTemplateVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(pollTemplateVO.getDescription());
				}
				if (Integer.MIN_VALUE != pollTemplateVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(pollTemplateVO.getStatus());
				}
			}
		} else if (QUERY_FROM_POLLTEMPLATE_BY_IDS == _operatorType) {
			strsql.append(" and pollTemplateID in (?) ");
			super.addStringForField(ids);
		}
		strsql.append("order by createTime desc");
		setSql(strsql.toString());
	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public String getSql() {
		return this.sqlStr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		pollTemplateVO = new PollTemplateVO();
		pollTemplateVO.setPollTemplateID(rs.getString("pollTemplateID"));
		pollTemplateVO.setPollTemplateName(rs.getString("pollTemplateName"));
		pollTemplateVO.setCreateUserID(rs.getString("createUserID"));
		pollTemplateVO.setCreateTime(rs.getTimestamp("createTime"));
		pollTemplateVO.setDescription(rs.getString("description"));
		pollTemplateVO.setStatus(rs.getInt("status"));
		listPollTemplate.add(pollTemplateVO);
	}

	public ArrayList<PollTemplateVO> getPollTemplateList() {
		return listPollTemplate;
	}

	public PollTemplateVO getPollTemplateVO() {
		return pollTemplateVO;
	}

}
