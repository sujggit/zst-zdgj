package com.zzst.dao.meeting.authorization;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.authorization.AuthorizationVO;

/**
 * class description: Authorization MQB
 * 
 * @date Tue May 28 11:26:12 CST 2013
 * @author ryan
 */
public class AuthorizationMQB extends MasterQueryObject {
	static Logger logger = CbfLogger
			.getLogger(AuthorizationMQB.class.getName());

	public static int QUERY_FROM_AUTHORIZATION = 1;
	public static int QUERY_FROM_AUTHORIZATION_BY_IDS = 2;

	private AuthorizationVO authorizationVO;
	private ArrayList<AuthorizationVO> listAuthorization = new ArrayList<AuthorizationVO>();

	private int _operatorType = -1;
	private String ids = "";

	public AuthorizationMQB(int operatorType, AuthorizationVO authorizationVO) {
		_operatorType = operatorType;
		this.authorizationVO = authorizationVO;
		makeSql();
	}

	public AuthorizationMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql
				.append("select id,Infotype,InfoKey,InfoValue,description,REF1,REF2,REF3 ");
		strsql.append(" from z_t_authorization ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_AUTHORIZATION == _operatorType) {
			if (null != authorizationVO) {
				if (!StringUtils.isNullOrBlank(authorizationVO.getId())) {
					strsql.append(" and id= ? ");
					super.addStringForField(authorizationVO.getId());
				}
				if (!StringUtils.isNullOrBlank(authorizationVO.getInfotype())) {
					strsql.append(" and Infotype= ? ");
					super.addStringForField(authorizationVO.getInfotype());
				}
				if (!StringUtils.isNullOrBlank(authorizationVO.getInfoKey())) {
					strsql.append(" and InfoKey= ? ");
					super.addStringForField(authorizationVO.getInfoKey());
				}
				if (!StringUtils.isNullOrBlank(authorizationVO.getInfoValue())) {
					strsql.append(" and InfoValue= ? ");
					super.addStringForField(authorizationVO.getInfoValue());
				}
				if (!StringUtils
						.isNullOrBlank(authorizationVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(authorizationVO.getDescription());
				}
				if (!StringUtils.isNullOrBlank(authorizationVO.getREF1())) {
					strsql.append(" and REF1= ? ");
					super.addStringForField(authorizationVO.getREF1());
				}
				if (!StringUtils.isNullOrBlank(authorizationVO.getREF2())) {
					strsql.append(" and REF2= ? ");
					super.addStringForField(authorizationVO.getREF2());
				}
				if (!StringUtils.isNullOrBlank(authorizationVO.getREF3())) {
					strsql.append(" and REF3= ? ");
					super.addStringForField(authorizationVO.getREF3());
				}
			}
		} else if (QUERY_FROM_AUTHORIZATION_BY_IDS == _operatorType) {
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
		authorizationVO = new AuthorizationVO();
		authorizationVO.setId(rs.getString("id"));
		authorizationVO.setInfotype(rs.getString("Infotype"));
		authorizationVO.setInfoKey(rs.getString("InfoKey"));
		authorizationVO.setInfoValue(rs.getString("InfoValue"));
		authorizationVO.setDescription(rs.getString("description"));
		authorizationVO.setREF1(rs.getString("REF1"));
		authorizationVO.setREF2(rs.getString("REF2"));
		authorizationVO.setREF3(rs.getString("REF3"));
		listAuthorization.add(authorizationVO);
	}

	public ArrayList<AuthorizationVO> getAuthorizationList() {
		return listAuthorization;
	}

	public AuthorizationVO getAuthorizationVO() {
		return authorizationVO;
	}

}
