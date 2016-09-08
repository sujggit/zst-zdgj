package com.zzst.dao.meeting.userPost;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.userPost.UserPostVO;

/**
 * class description: UserPost MQB
 * 
 * @date Sun Jun 30 12:58:57 CST 2013
 * @author ryan
 */
public class UserPostMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(UserPostMQB.class.getName());

	public static int QUERY_FROM_USERPOST = 1;
	public static int QUERY_FROM_USERPOST_BY_IDS = 2;

	private UserPostVO userPostVO;
	private ArrayList<UserPostVO> listUserPost = new ArrayList<UserPostVO>();

	private int _operatorType = -1;
	private String ids = "";

	public UserPostMQB(int operatorType, UserPostVO userPostVO) {
		_operatorType = operatorType;
		this.userPostVO = userPostVO;
		makeSql();
	}

	public UserPostMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select userID,postNO,status,revision,description ");
		strsql.append(" from z_t_user_post ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_USERPOST == _operatorType) {
			if (null != userPostVO) {
				if (!StringUtils.isNullOrBlank(userPostVO.getUserID())) {
					strsql.append(" and userID= ? ");
					super.addStringForField(userPostVO.getUserID());
				}
				if (!StringUtils.isNullOrBlank(userPostVO.getPostNO())) {
					strsql.append(" and postNO= ? ");
					super.addStringForField(userPostVO.getPostNO());
				}
				if (Integer.MIN_VALUE != userPostVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(userPostVO.getStatus());
				}
				if (Long.MIN_VALUE != userPostVO.getRevision()) {
					strsql.append(" and revision= ? ");
					super.addLongForField(userPostVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(userPostVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(userPostVO.getDescription());
				}
			}
		} else if (QUERY_FROM_USERPOST_BY_IDS == _operatorType) {
			strsql.append(" and userID in (?) ");
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
		userPostVO = new UserPostVO();
		userPostVO.setUserID(rs.getString("userID"));
		userPostVO.setPostNO(rs.getString("postNO"));
		userPostVO.setStatus(rs.getInt("status"));
		userPostVO.setRevision(rs.getLong("revision"));
		userPostVO.setDescription(rs.getString("description"));
		listUserPost.add(userPostVO);
	}

	public ArrayList<UserPostVO> getUserPostList() {
		return listUserPost;
	}

	public UserPostVO getUserPostVO() {
		return userPostVO;
	}

}
