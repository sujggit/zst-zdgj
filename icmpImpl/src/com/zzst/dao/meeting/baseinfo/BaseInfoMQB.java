package com.zzst.dao.meeting.baseinfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.config.BaseInfoVO;

/**
 * class description: BaseInfo MQB
 * 
 * @date Fri Jun 15 13:43:00 CST 2012
 * @author ryan
 */
public class BaseInfoMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(BaseInfoMQB.class.getName());

	public static int QUERY_FROM_BASEINFO = 1;
	public static int QUERY_FROM_BASEINFO_BY_IDS = 2;
	public static int QUERY_FOR_KST_INIT = 9;

	private BaseInfoVO baseInfoVO;
	private ArrayList<BaseInfoVO> listBaseInfo = new ArrayList<BaseInfoVO>();

	private int _operatorType = -1;
	private String ids = "";

	public BaseInfoMQB(int operatorType, BaseInfoVO baseInfoVO) {
		_operatorType = operatorType;
		this.baseInfoVO = baseInfoVO;
		makeSql();
	}

	public BaseInfoMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select id,infotype,infoname,infovalue,description,ordernum ");
		strsql.append(" from z_t_baseinfo ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_BASEINFO == _operatorType) {
			if (null != baseInfoVO) {
				if (!StringUtils.isNullOrBlank(baseInfoVO.getId())) {
					strsql.append(" and id= ? ");
					super.addStringForField(baseInfoVO.getId());
				}
				if (!StringUtils.isNullOrBlank(baseInfoVO.getInfoType())) {
					strsql.append(" and infotype= ? ");
					super.addStringForField(baseInfoVO.getInfoType());
				}
				if (!StringUtils.isNullOrBlank(baseInfoVO.getInfoName())) {
					strsql.append(" and infoname= ? ");
					super.addStringForField(baseInfoVO.getInfoName());
				}
				if (!StringUtils.isNullOrBlank(baseInfoVO.getInfoValue())) {
					strsql.append(" and infovalue= ? ");
					super.addStringForField(baseInfoVO.getInfoValue());
				}
				if (!StringUtils.isNullOrBlank(baseInfoVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(baseInfoVO.getDescription());
				}
				if (!StringUtils.isNullOrBlank(baseInfoVO.getOrder())) {
					strsql.append(" and ordernum= ? ");
					super.addStringForField(baseInfoVO.getOrder());
				}
			}
		} else if (QUERY_FROM_BASEINFO_BY_IDS == _operatorType) {
			strsql.append(" and id in (?) ");
			super.addStringForField(ids);
		} else if (QUERY_FOR_KST_INIT == _operatorType){
			if (null != baseInfoVO) {
				if (!StringUtils.isNullOrBlank(baseInfoVO.getInfoType())) {
					strsql.append(" and infotype like '"+baseInfoVO.getInfoType()+"%'");
				}
			}
		
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
		baseInfoVO = new BaseInfoVO();
		baseInfoVO.setId(rs.getString("id"));
		baseInfoVO.setInfoType(rs.getString("infotype"));
		baseInfoVO.setInfoName(rs.getString("infoname"));
		baseInfoVO.setInfoValue(rs.getString("infovalue"));
		baseInfoVO.setDescription(rs.getString("description"));
		baseInfoVO.setOrder(rs.getString("ordernum"));
		listBaseInfo.add(baseInfoVO);
	}

	public ArrayList<BaseInfoVO> getBaseInfoList() {
		return listBaseInfo;
	}

	public BaseInfoVO getBaseInfoVO() {
		return baseInfoVO;
	}

}
