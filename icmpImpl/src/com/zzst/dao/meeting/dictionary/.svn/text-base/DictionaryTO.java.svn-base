package com.zzst.dao.meeting.dictionary;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.dictionary.DictionaryVO;

/**
 * class description: Dictionary TO
 * 
 * @date Tue Feb 19 17:00:51 CST 2013
 * @author ryan
 */
public class DictionaryTO extends TransactionObject {

	public static final int MODIFY_DICVALUE_DICTIONARY = 4;
	
	private static Logger logger = CbfLogger.getLogger(DictionaryTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_DICTIONARY = 1;
	public static int MODIFY_DICTIONARY = 2;
	public static int DEL_DICTIONARY = 3;
	private int result = 0;
	public static final int DEL_DICTIONARY_BYVO = 5;

	private DictionaryVO dictionaryVO;
	private String ids = "";

	public DictionaryTO(int operatorType, DictionaryVO dictionaryVO) {
		this.operatorType = operatorType;
		this.dictionaryVO = dictionaryVO;
	}

	public DictionaryTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_DICTIONARY == operatorType) {
			sqlstr.append("insert into z_t_dictionary ");
			sqlstr
					.append("(dicID,dicType,dicViewName,dicValue,sysValue,createUserID,createTime,description)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?)");
			super.addStringForField(dictionaryVO.getDicID());
			super.addStringForField(dictionaryVO.getDicType());
			super.addStringForField(dictionaryVO.getDicViewName());
			super.addStringForField(dictionaryVO.getDicValue());
			super.addIntForField(dictionaryVO.getSysValue());
			super.addStringForField(dictionaryVO.getCreateUserID());
			super.addTimestampForField(dictionaryVO.getCreateTime());
			super.addStringForField(dictionaryVO.getDescription());
		} else if (MODIFY_DICTIONARY == operatorType) {
			sqlstr.append("update  z_t_dictionary set ");
			sqlstr.append(" dicID = dicID ");

			if (dictionaryVO.getDicType() != null) {
				sqlstr.append(" , dicType=? ");
				super.addStringForField(dictionaryVO.getDicType());
			}

			if (dictionaryVO.getDicViewName() != null) {
				sqlstr.append(" , dicViewName=? ");
				super.addStringForField(dictionaryVO.getDicViewName());
			}

			if (dictionaryVO.getDicValue() != null) {
				sqlstr.append(" , dicValue=? ");
				super.addStringForField(dictionaryVO.getDicValue());
			}

			if (dictionaryVO.getSysValue() != Integer.MIN_VALUE) {
				sqlstr.append(" , sysValue=?");
				super.addIntForField(dictionaryVO.getSysValue());
			}

			if (dictionaryVO.getCreateUserID() != null) {
				sqlstr.append(" , createUserID=? ");
				super.addStringForField(dictionaryVO.getCreateUserID());
			}

			if (dictionaryVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(dictionaryVO.getCreateTime());
			}

			if (dictionaryVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(dictionaryVO.getDescription());
			}

			sqlstr.append(" where dicID in (?) ");
			if (dictionaryVO.getDicID() != null) {
				super.addStringForField(dictionaryVO.getDicID());
			}
		}else if (MODIFY_DICVALUE_DICTIONARY == operatorType) {
			sqlstr.append("update  z_t_dictionary set ");
			sqlstr.append(" dicID = dicID ");

			if (dictionaryVO.getDicType() != null) {
				sqlstr.append(" , dicType=? ");
				super.addStringForField(dictionaryVO.getDicType());
			}

			if (dictionaryVO.getDicValue() != null) {
				sqlstr.append(" , dicValue=? ");
				super.addStringForField(dictionaryVO.getDicValue());
			}

			if (dictionaryVO.getSysValue() != Integer.MIN_VALUE) {
				sqlstr.append(" , sysValue=?");
				super.addIntForField(dictionaryVO.getSysValue());
			}

			if (dictionaryVO.getCreateUserID() != null) {
				sqlstr.append(" , createUserID=? ");
				super.addStringForField(dictionaryVO.getCreateUserID());
			}

			if (dictionaryVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(dictionaryVO.getCreateTime());
			}

			if (dictionaryVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(dictionaryVO.getDescription());
			}
			
			sqlstr.append(" where dicViewName in (?) ");
			if (dictionaryVO.getDicViewName() != null) {
				//sqlstr.append(" , dicViewName=? ");
				super.addStringForField(dictionaryVO.getDicViewName());
			}
			
			if (dictionaryVO.getDicID() != null) {
				sqlstr.append(" where dicID in (?) ");
				super.addStringForField(dictionaryVO.getDicID());
			}
		} else if (DEL_DICTIONARY == operatorType) {
			sqlstr.append("delete  from  z_t_dictionary ");
			sqlstr.append(" where dicID in (?) ");
			super.addStringForField(ids);
		} else if (DEL_DICTIONARY_BYVO == operatorType) {
			sqlstr.append("delete  from  z_t_dictionary ");
			sqlstr.append(" where 1=1 ");
			if (null != dictionaryVO) {
				if (!StringUtils.isNullOrBlank(dictionaryVO.getDicID())) {
					sqlstr.append(" and dicID= ? ");
					super.addStringForField(dictionaryVO.getDicID());
				}
				if (!StringUtils.isNullOrBlank(dictionaryVO.getDicType())) {
					sqlstr.append(" and dicType= ? ");
					super.addStringForField(dictionaryVO.getDicType());
				}
				if (!StringUtils.isNullOrBlank(dictionaryVO.getDicViewName())) {
					sqlstr.append(" and dicViewName= ? ");
					super.addStringForField(dictionaryVO.getDicViewName());
				}
				if (!StringUtils.isNullOrBlank(dictionaryVO.getDicValue())) {
					sqlstr.append(" and dicValue= ? ");
					super.addStringForField(dictionaryVO.getDicValue());
				}
				if (Integer.MIN_VALUE != dictionaryVO.getSysValue()) {
					sqlstr.append(" and sysValue= ? ");
					super.addIntForField(dictionaryVO.getSysValue());
				}
				if (!StringUtils.isNullOrBlank(dictionaryVO.getCreateUserID())) {
					sqlstr.append(" and createUserID= ? ");
					super.addStringForField(dictionaryVO.getCreateUserID());
				}
				if (!StringUtils.isNullOrBlank(dictionaryVO.getDescription())) {
					sqlstr.append(" and description= ? ");
					super.addStringForField(dictionaryVO.getDescription());
				}
			}else{
				sqlstr.append(" and 1!=1");//不允许全部删除数据字典表
			}
		}
		this.sqlStr = sqlstr.toString();
	}

	public String getSqlStr() {
		return this.sqlStr;
	}

	public void setValues() throws SQLException {

	}

	public void execute() throws SQLException {
		result = this.stmt.executeUpdate();
	}

	public int getexecuteResult() {
		return result;
	}

}
