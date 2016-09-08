package com.zzst.dao.meeting.template;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.template.TemplateVO;

/**
 * class description: Template MQB
 * 
 * @date Wed Mar 20 17:56:26 CST 2013
 * @author ryan
 */
public class TemplateMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(TemplateMQB.class.getName());

	public static int QUERY_FROM_TEMPLATE = 1;
	public static int QUERY_FROM_TEMPLATE_BY_IDS = 2;

	private TemplateVO templateVO;
	private ArrayList<TemplateVO> listTemplate = new ArrayList<TemplateVO>();

	private int _operatorType = -1;
	private String ids = "";

	public TemplateMQB(int operatorType, TemplateVO templateVO) {
		_operatorType = operatorType;
		this.templateVO = templateVO;
		makeSql();
	}

	public TemplateMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select id,templateName,duration,createUserID,createTime,updateTime,status,description ");
		strsql.append(" from z_t_template ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_TEMPLATE == _operatorType) {
			if (null != templateVO) {
				if (!StringUtils.isNullOrBlank(templateVO.getId())) {
					strsql.append(" and id= ? ");
					super.addStringForField(templateVO.getId());
				}
				if (!StringUtils.isNullOrBlank(templateVO.getTemplateName())) {
					strsql.append(" and templateName like ? ");
					super.addStringForField("%"+templateVO.getTemplateName().trim()+"%");
				}
				if (!StringUtils.isNullOrBlank(templateVO.getDuration())) {
					strsql.append(" and duration= ? ");
					super.addStringForField(templateVO.getDuration());
				}
				if (!StringUtils.isNullOrBlank(templateVO.getCreateUserID())) {
					strsql.append(" and createUserID= ? ");
					super.addStringForField(templateVO.getCreateUserID());
				}
				if (Integer.MIN_VALUE != templateVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(templateVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(templateVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(templateVO.getDescription());
				}
				
				if(templateVO.isLevel()){
					strsql.append(templateVO.getLsql());
				}
			}
		} else if (QUERY_FROM_TEMPLATE_BY_IDS == _operatorType) {
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
		templateVO = new TemplateVO();
		templateVO.setId(rs.getString("id"));
		templateVO.setTemplateName(rs.getString("templateName"));
		templateVO.setDuration(rs.getString("duration"));
		templateVO.setCreateUserID(rs.getString("createUserID"));
		templateVO.setCreateTime(rs.getTimestamp("createTime"));
		templateVO.setUpdateTime(rs.getTimestamp("updateTime"));
		templateVO.setStatus(rs.getInt("status"));
		templateVO.setDescription(rs.getString("description"));
		listTemplate.add(templateVO);
	}

	public ArrayList<TemplateVO> getTemplateList() {
		return listTemplate;
	}

	public TemplateVO getTemplateVO() {
		return templateVO;
	}

}
