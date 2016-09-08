package com.zzst.dao.meeting.dictionary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.dictionary.DictionaryVO;

/**
 * class description: Dictionary MQB
 * 
 * @date Tue Feb 19 17:00:51 CST 2013
 * @author ryan
 */
public class DictionaryMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(DictionaryMQB.class.getName());

	public static int QUERY_FROM_DICTIONARY = 1;
	public static int QUERY_FROM_DICTIONARY_BY_IDS = 2;

	private DictionaryVO dictionaryVO;
	private ArrayList<DictionaryVO> listDictionary = new ArrayList<DictionaryVO>();

	private int _operatorType = -1;
	private String ids = "";

	public DictionaryMQB(int operatorType, DictionaryVO dictionaryVO) {
		_operatorType = operatorType;
		this.dictionaryVO = dictionaryVO;
		makeSql();
	}

	public DictionaryMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql
				.append("select dicID,dicType,dicViewName,dicValue,sysValue,createUserID,createTime,description ");
		strsql.append(" from z_t_dictionary ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_DICTIONARY == _operatorType) {
			if (null != dictionaryVO) {
				if (!StringUtils.isNullOrBlank(dictionaryVO.getDicID())) {
					strsql.append(" and dicID= ? ");
					super.addStringForField(dictionaryVO.getDicID());
				}
				if (!StringUtils.isNullOrBlank(dictionaryVO.getDicType())) {
					strsql.append(" and dicType= ? ");
					super.addStringForField(dictionaryVO.getDicType());
				}
				if (!StringUtils.isNullOrBlank(dictionaryVO.getDicViewName())) {
					strsql.append(" and dicViewName= ? ");
					super.addStringForField(dictionaryVO.getDicViewName());
				}
				if (!StringUtils.isNullOrBlank(dictionaryVO.getDicValue())) {
					strsql.append(" and dicValue= ? ");
					super.addStringForField(dictionaryVO.getDicValue());
				}
				if (Integer.MIN_VALUE != dictionaryVO.getSysValue()) {
					strsql.append(" and sysValue= ? ");
					super.addIntForField(dictionaryVO.getSysValue());
				}
				if (!StringUtils.isNullOrBlank(dictionaryVO.getCreateUserID())) {
					strsql.append(" and createUserID= ? ");
					super.addStringForField(dictionaryVO.getCreateUserID());
				}
				if (!StringUtils.isNullOrBlank(dictionaryVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(dictionaryVO.getDescription());
				}
			}
			strsql.append(" order by dicID");
			
		} else if (QUERY_FROM_DICTIONARY_BY_IDS == _operatorType) {
			strsql.append(" and dicID in (?) ");
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
		dictionaryVO = new DictionaryVO();
		dictionaryVO.setDicID(rs.getString("dicID"));
		dictionaryVO.setDicType(rs.getString("dicType"));
		dictionaryVO.setDicViewName(rs.getString("dicViewName"));
		dictionaryVO.setDicValue(rs.getString("dicValue"));
		dictionaryVO.setSysValue(rs.getInt("sysValue"));
		dictionaryVO.setCreateUserID(rs.getString("createUserID"));
		dictionaryVO.setCreateTime(rs.getTimestamp("createTime"));
		dictionaryVO.setDescription(rs.getString("description"));
		listDictionary.add(dictionaryVO);
	}

	public ArrayList<DictionaryVO> getDictionaryList() {
		return listDictionary;
	}

	public DictionaryVO getDictionaryVO() {
		return dictionaryVO;
	}

}
