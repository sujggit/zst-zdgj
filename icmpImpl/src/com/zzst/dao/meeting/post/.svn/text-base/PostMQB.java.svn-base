package com.zzst.dao.meeting.post;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.enums.PostEnum;
import com.zzst.model.meeting.post.PostVO;

/**
 * class description: Post MQB
 * 
 * @date Fri Jun 28 15:38:38 CST 2013
 * @author ryan
 */
public class PostMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(PostMQB.class.getName());

	public static int QUERY_FROM_POST = 1;
	public static int QUERY_FROM_POST_BY_IDS = 2;

	private PostVO postVO;
	private ArrayList<PostVO> listPost = new ArrayList<PostVO>();

	private int _operatorType = -1;
	private String ids = "";

	public PostMQB(int operatorType, PostVO postVO) {
		_operatorType = operatorType;
		this.postVO = postVO;
		makeSql();
	}

	public PostMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql
				.append("select postNO,postName,parentNO,createUserID,createTime,status,revision,description,id ");
		strsql.append(" from z_t_post ");
		strsql.append(" where 1=1 ");
		strsql.append(" and status="+PostEnum.STATUS_VALID);
		if (QUERY_FROM_POST == _operatorType) {
			if (null != postVO) {
				if (!StringUtils.isNullOrBlank(postVO.getDescription())) {
					strsql.append(" and id= ? ");
					super.addStringForField(postVO.getId());
				}
				if (!StringUtils.isNullOrBlank(postVO.getPostNO())) {
					strsql.append(" and postNO like '%"+ postVO.getPostNO().trim() + "%'");
				}
				if (!StringUtils.isNullOrBlank(postVO.getPostName())) {
					strsql.append(" and postName like '%"+ postVO.getPostName().trim() + "%'");
				}
				if (!StringUtils.isNullOrBlank(postVO.getParentNO())) {
					strsql.append(" and parentNO= ? ");
					super.addStringForField(postVO.getParentNO());
				}
				if (!StringUtils.isNullOrBlank(postVO.getCreateUserID())) {
					strsql.append(" and createUserID= ? ");
					super.addStringForField(postVO.getCreateUserID());
				}
				if (Integer.MIN_VALUE != postVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(postVO.getStatus());
				}
				if (Long.MIN_VALUE != postVO.getRevision()) {
					strsql.append(" and revision= ? ");
					super.addLongForField(postVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(postVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(postVO.getDescription());
				}
			}
		} else if (QUERY_FROM_POST_BY_IDS == _operatorType) {
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
		postVO = new PostVO();
		postVO.setPostNO(rs.getString("postNO"));
		postVO.setPostName(rs.getString("postName"));
		postVO.setParentNO(rs.getString("parentNO"));
		postVO.setCreateUserID(rs.getString("createUserID"));
		postVO.setCreateTime(rs.getTimestamp("createTime"));
		postVO.setStatus(rs.getInt("status"));
		postVO.setRevision(rs.getLong("revision"));
		postVO.setDescription(rs.getString("description"));
		postVO.setId(rs.getString("id"));
		listPost.add(postVO);
	}

	public ArrayList<PostVO> getPostList() {
		return listPost;
	}

	public PostVO getPostVO() {
		return postVO;
	}

}
