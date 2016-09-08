package com.zzst.dao.meeting.userPost;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.userPost.UserPostVO;

/**
 * class description: UserPost TO
 * 
 * @date Sun Jun 30 12:58:57 CST 2013
 * @author ryan
 */
public class UserPostTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(UserPostTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_USERPOST = 1;
	public static int MODIFY_USERPOST = 2;
	public static int DEL_USERPOST = 3;
	private int result = 0;

	private UserPostVO userPostVO;

	public UserPostTO(int operatorType, UserPostVO userPostVO) {
		this.operatorType = operatorType;
		this.userPostVO = userPostVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_USERPOST == operatorType) {
			sqlstr.append("insert into z_t_user_post ");
			sqlstr.append("(userID,postNO,status,revision,description)");
			sqlstr.append(" values (?,?,?,?,?)");
			super.addStringForField(userPostVO.getUserID());
			super.addStringForField(userPostVO.getPostNO());
			super.addIntForField(userPostVO.getStatus());
			super.addLongForField(userPostVO.getRevision());
			super.addStringForField(userPostVO.getDescription());
		} else if (MODIFY_USERPOST == operatorType) {
			sqlstr.append("update  z_t_user_post set ");
			sqlstr.append(" userID = userID ");

			if (userPostVO.getPostNO() != null) {
				sqlstr.append(" , postNO=? ");
				super.addStringForField(userPostVO.getPostNO());
			}

			if (userPostVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(userPostVO.getStatus());
			}

			if (userPostVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(userPostVO.getRevision());
			}

			if (userPostVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(userPostVO.getDescription());
			}

			sqlstr.append(" where userID in (?) ");
			if (userPostVO.getUserID() != null) {
				super.addStringForField(userPostVO.getUserID());
			}
		} else if (DEL_USERPOST == operatorType) {
			sqlstr.append("delete  from  z_t_user_post ");
			sqlstr.append(" where userID in (?) ");
			super.addStringForField(userPostVO.getUserID());
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
