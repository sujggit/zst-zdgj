package com.zzst.dao.meeting.post;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.post.PostVO;

/**
 * class description: Post TO
 * 
 * @date Fri Jun 28 15:38:38 CST 2013
 * @author ryan
 */
public class PostTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(PostTO.class.getName());
	private int operatorType = -1;

	public static int ADD_POST = 1;
	public static int MODIFY_POST = 2;
	public static int DEL_POST = 3;
	private int result = 0;

	private PostVO postVO;

	public PostTO(int operatorType, PostVO postVO) {
		this.operatorType = operatorType;
		this.postVO = postVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_POST == operatorType) {
			sqlstr.append("insert into z_t_post ");
			sqlstr
					.append("(postNO,postName,parentNO,createUserID,createTime,status,revision,description,id)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?)");
			super.addStringForField(postVO.getPostNO());
			super.addStringForField(postVO.getPostName());
			super.addStringForField(postVO.getParentNO());
			super.addStringForField(postVO.getCreateUserID());
			super.addTimestampForField(postVO.getCreateTime());
			super.addIntForField(postVO.getStatus());
			super.addLongForField(postVO.getRevision());
			super.addStringForField(postVO.getDescription());
			super.addStringForField(postVO.getId());
		} else if (MODIFY_POST == operatorType) {
			sqlstr.append("update  z_t_post set ");
			sqlstr.append(" postNO = postNO ");

			if (postVO.getPostName() != null) {
				sqlstr.append(" , postName=? ");
				super.addStringForField(postVO.getPostName());
			}

			if (postVO.getParentNO() != null) {
				sqlstr.append(" , parentNO=? ");
				super.addStringForField(postVO.getParentNO());
			}

			if (postVO.getCreateUserID() != null) {
				sqlstr.append(" , createUserID=? ");
				super.addStringForField(postVO.getCreateUserID());
			}

			if (postVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(postVO.getCreateTime());
			}

			if (postVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(postVO.getStatus());
			}

			if (postVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(postVO.getRevision());
			}

			if (postVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(postVO.getDescription());
			}

			sqlstr.append(" where id in (?) ");
			if (postVO.getPostNO() != null) {
				super.addStringForField(postVO.getId());
			}
		} else if (DEL_POST == operatorType) {
			sqlstr.append("delete  from  z_t_post ");
			sqlstr.append(" where id in (?) ");
			super.addStringForField(postVO.getId());
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
