package com.zzst.dao.meeting.kst;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.kst.WallPresetVO;

/**
 * class description: WallPreset TO
 * 
 * @date Mon Jul 30 14:19:01 CST 2012
 * @author ryan
 */
public class WallPresetTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(WallPresetTO.class.getName());
	private int operatorType = -1;

	public static int ADD_WALLPRESET = 1;
	public static int MODIFY_WALLPRESET = 2;
	public static int DEL_WALLPRESET = 3;
	public static int DEL_WALLPRESET_ALL = 4;
	
	private int result = 0;

	private WallPresetVO wallPresetVO;
	private String ids = "";

	public WallPresetTO(int operatorType, WallPresetVO wallPresetVO) {
		this.operatorType = operatorType;
		this.wallPresetVO = wallPresetVO;
	}

	public WallPresetTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_WALLPRESET == operatorType) {
			sqlstr.append("insert into z_kst_wallpreset ");
			sqlstr.append("(id,viewname,status,description,parentID,leaf)");
			sqlstr.append(" values (?,?,?,?,?,?)");
			super.addStringForField(wallPresetVO.getId());
			super.addStringForField(wallPresetVO.getViewName());
			super.addStringForField(wallPresetVO.getStatus());
			super.addStringForField(wallPresetVO.getDescription());
			super.addStringForField(wallPresetVO.getParentID());
			super.addStringForField(wallPresetVO.getLeaf());
		} else if (MODIFY_WALLPRESET == operatorType) {
			sqlstr.append("update  z_kst_wallpreset set ");
			sqlstr.append(" id = id ");

			if (wallPresetVO.getViewName() != null) {
				sqlstr.append(" , viewname=? ");
				super.addStringForField(wallPresetVO.getViewName());
			}

			if (wallPresetVO.getStatus() != null) {
				sqlstr.append(" , status=? ");
				super.addStringForField(wallPresetVO.getStatus());
			}

			if (wallPresetVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(wallPresetVO.getDescription());
			}

			if (wallPresetVO.getParentID() != null) {
				sqlstr.append(" , parentID=? ");
				super.addStringForField(wallPresetVO.getParentID());
			}

			if (wallPresetVO.getLeaf() != null) {
				sqlstr.append(" , leaf=? ");
				super.addStringForField(wallPresetVO.getLeaf());
			}

			sqlstr.append(" where id in (?) ");
			if (wallPresetVO.getId() != null) {
				super.addStringForField(wallPresetVO.getId());
			}
		} else if (DEL_WALLPRESET == operatorType) {
			sqlstr.append("delete  from  z_kst_wallpreset ");
			sqlstr.append(" where id in (?) ");
			super.addStringForField(ids);
		} else if (DEL_WALLPRESET_ALL == operatorType) {
			sqlstr.append("delete  from  z_kst_wallpreset ");
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
