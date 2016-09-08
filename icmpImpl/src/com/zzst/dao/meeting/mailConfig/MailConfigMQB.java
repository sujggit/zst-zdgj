package com.zzst.dao.meeting.mailConfig;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.swh.db.model.DBFields;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.mailConfig.MailConfigVO;

/**
 * class description: MailConfig MQB
 * 
 * @date Mon Nov 11 14:59:57 CST 2013
 * @author ryan
 */
public class MailConfigMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(MailConfigMQB.class.getName());

	public static int QUERY_FROM_MAILCONFIG = 1;
	public static int QUERY_FROM_MAILCONFIG_BY_IDS = 2;

	private MailConfigVO mailConfigVO;
	private ArrayList<MailConfigVO> listMailConfig = new ArrayList<MailConfigVO>();

	private int _operatorType = -1;
	private String ids = "";

	public MailConfigMQB(int operatorType, MailConfigVO mailConfigVO) {
		_operatorType = operatorType;
		this.mailConfigVO = mailConfigVO;
		makeSql();
	}

	public MailConfigMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select id,mailSmtp,mailName,mailPass ");
		strsql.append(" from z_t_mailconfig ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_MAILCONFIG == _operatorType) {
			if (null != mailConfigVO) {
				if (Integer.MIN_VALUE != mailConfigVO.getId()) {
					strsql.append(" and id= ? ");
					super.addIntForField(mailConfigVO.getId());
				}
				if (!StringUtils.isNullOrBlank(mailConfigVO.getMailSmtp())) {
					strsql.append(" and mailSmtp= ? ");
					super.addStringForField(mailConfigVO.getMailSmtp());
				}
				if (!StringUtils.isNullOrBlank(mailConfigVO.getMailName())) {
					strsql.append(" and mailName= ? ");
					super.addStringForField(mailConfigVO.getMailName());
				}
				if (!StringUtils.isNullOrBlank(mailConfigVO.getMailPass())) {
					strsql.append(" and mailPass= ? ");
					super.addStringForField(mailConfigVO.getMailPass());
				}
			}
		} else if (QUERY_FROM_MAILCONFIG_BY_IDS == _operatorType) {
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
		mailConfigVO = new MailConfigVO();
		mailConfigVO.setId(rs.getInt("id"));
		mailConfigVO.setMailSmtp(rs.getString("mailSmtp"));
		mailConfigVO.setMailName(rs.getString("mailName"));
		mailConfigVO.setMailPass(rs.getString("mailPass"));
		listMailConfig.add(mailConfigVO);
	}

	public ArrayList<MailConfigVO> getMailConfigList() {
		return listMailConfig;
	}

	public MailConfigVO getMailConfigVO() {
		return mailConfigVO;
	}

}
