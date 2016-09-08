package com.zzst.dao.project.avic.videoConferenceFeedBack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.enums.ApplyEnum;
import com.zzst.model.project.avic.videoConferenceFeedBack.VideoConferenceFeedBackVO;

/**
 * class description: VideoConferenceFeedBack MQB
 * 
 * @date Tue Sep 25 17:18:45 CST 2012
 * @author ryan
 */
public class VideoConferenceFeedBackMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(VideoConferenceFeedBackMQB.class
			.getName());

	public static int QUERY_FROM_VIDEO_FEEDBACK = 1;
	public static int QUERY_FROM_VIDEO_FEEDBACK_BY_IDS = 2;
	public static int QUERY_FROM_BY_USERID = 3;
	public static int QUERY_HISTORY_FROM_BY_USERID = 4;
	public static int QUERY_HISTORY_ALL = 5;

	private VideoConferenceFeedBackVO feedBackVO;
	private ArrayList<VideoConferenceFeedBackVO> listVideoConferenceFeedBack = new ArrayList<VideoConferenceFeedBackVO>();

	private int _operatorType = -1;
	private String ids = "";

	public VideoConferenceFeedBackMQB(int operatorType,
			VideoConferenceFeedBackVO videoConferenceFeedBackVO) {
		_operatorType = operatorType;
		this.feedBackVO = videoConferenceFeedBackVO;
		makeSql();
	}
	public VideoConferenceFeedBackMQB(int operatorType,
			VideoConferenceFeedBackVO videoConferenceFeedBackVO,String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		this.feedBackVO = videoConferenceFeedBackVO;
		makeSql();
	}
	public VideoConferenceFeedBackMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		if(QUERY_FROM_BY_USERID == _operatorType ){
			strsql.append("select vcf.* ");
			strsql.append(" from avic_t_vc_feedback vcf ,z_t_apply_detail ad");
			strsql.append(" where 1=1 and ad.status="+ApplyEnum.STATUS_ING+" and vcf.feedBackID=ad.applyDetailID and vcf.status!="+ApplyEnum.STATUS_REJECT);
			strsql.append(" and ad.checkUserIDs like '%," + ids + ",%'");
			if (null != feedBackVO) {
				if (!StringUtils.isNullOrBlank(feedBackVO.getFeedBackID())) {
					strsql.append(" and vcf.feedBackID= ? ");
					super.addStringForField(feedBackVO.getFeedBackID());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO.getDepartmentID())) {
					strsql.append(" and vcf.departmentID= ? ");
					super.addStringForField(feedBackVO.getDepartmentID());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO.getDepartmentName())) {
					strsql.append(" and vcf.departmentName like ? ");
					super.addStringForField("%"+feedBackVO.getDepartmentName().trim()+"%");
				}
				if (!StringUtils.isNullOrBlank(feedBackVO.getDepartmentCode())) {
					strsql.append(" and vcf.departmentCode= ? ");
					super.addStringForField(feedBackVO.getDepartmentCode());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO.getMeetingDetailID())) {
					strsql.append(" and vcf.meetingDetailID= ? ");
					super.addStringForField(feedBackVO.getMeetingDetailID());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO.getMeetingDetailName())) {
					strsql.append(" and vcf.meetingDetailName like ? ");
					super.addStringForField( "%"+feedBackVO.getMeetingDetailName().trim()+"%");
				}
				if (!StringUtils.isNullOrBlank(feedBackVO.getUserName())) {
					strsql.append(" and vcf.userName= ? ");
					super.addStringForField(feedBackVO.getUserName());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO.getUserPhone())) {
					strsql.append(" and vcf.userPhone= ? ");
					super.addStringForField(feedBackVO.getUserPhone());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO.getBBuDes())) {
					strsql.append(" and vcf.bBuDes= ? ");
					super.addStringForField(feedBackVO.getBBuDes());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO.getFlowID())) {
					strsql.append(" and vcf.flowID= ? ");
					super.addStringForField(feedBackVO.getFlowID());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO.getCreateUserID())) {
					strsql.append(" and vcf.createUserID= ? ");
					super.addStringForField(feedBackVO.getCreateUserID());
				}
				if (Integer.MIN_VALUE != feedBackVO.getStatus()) {
					strsql.append(" and vcf.status= ? ");
					super.addIntForField(feedBackVO.getStatus());
				}
				if (Long.MIN_VALUE != feedBackVO.getRevision()) {
					strsql.append(" and vcf.revision= ? ");
					super.addLongForField(feedBackVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO.getDescription())) {
					strsql.append(" and vcf.description= ? ");
					super.addStringForField(feedBackVO.getDescription());
				}
			}
			strsql.append(" group by vcf.feedBackID order by vcf.createTime desc");
		} else if(QUERY_HISTORY_FROM_BY_USERID == _operatorType){//历史查询
			strsql.append("select vcf.* ");
			strsql.append(" from  avic_t_vc_feedback vcf , z_t_apply_detail ad ");
			strsql.append(" where 1=1 and vcf.feedBackID = ad.applyDetailID and ad.userId = ? ");
			super.addStringForField(ids);
			if (null != feedBackVO) {
				if (!StringUtils.isNullOrBlank(feedBackVO
						.getFeedBackID())) {
					strsql.append(" and vcf.feedBackID= ? ");
					super.addStringForField(feedBackVO
							.getFeedBackID());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO
						.getDepartmentID())) {
					strsql.append(" and vcf.departmentID= ? ");
					super.addStringForField(feedBackVO
							.getDepartmentID());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO
						.getDepartmentName())) {
					strsql.append(" and vcf.departmentName like ? ");
					super.addStringForField("%" + feedBackVO
							.getDepartmentName().trim() + "%");
				}
				if (!StringUtils.isNullOrBlank(feedBackVO
						.getDepartmentCode())) {
					strsql.append(" and vcf.departmentCode= ? ");
					super.addStringForField(feedBackVO
							.getDepartmentCode());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO
						.getMeetingDetailID())) {
					strsql.append(" and vcf.meetingDetailID= ? ");
					super.addStringForField(feedBackVO
							.getMeetingDetailID());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO
						.getMeetingDetailName())) {
					strsql.append(" and vcf.meetingDetailName like ? ");
					super.addStringForField("%" + feedBackVO
							.getMeetingDetailName().trim() + "%");
				}
				if (!StringUtils.isNullOrBlank(feedBackVO
						.getUserName())) {
					strsql.append(" and vcf.userName= ? ");
					super.addStringForField(feedBackVO
							.getUserName());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO
						.getUserPhone())) {
					strsql.append(" and vcf.userPhone= ? ");
					super.addStringForField(feedBackVO
							.getUserPhone());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO
						.getBBuDes())) {
					strsql.append(" and vcf.bBuDes= ? ");
					super.addStringForField(feedBackVO
							.getBBuDes());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO
						.getFlowID())) {
					strsql.append(" and vcf.flowID= ? ");
					super.addStringForField(feedBackVO
							.getFlowID());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO
						.getCreateUserID())) {
					strsql.append(" and vcf.createUserID= ? ");
					super.addStringForField(feedBackVO
							.getCreateUserID());
				}
				if (Integer.MIN_VALUE != feedBackVO.getStatus()) {
					strsql.append(" and vcf.status= ? ");
					super.addIntForField(feedBackVO.getStatus());
				}
				if (Long.MIN_VALUE != feedBackVO.getRevision()) {
					strsql.append(" and vcf.revision= ? ");
					super.addLongForField(feedBackVO
							.getRevision());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO
						.getDescription())) {
					strsql.append(" and vcf.description= ? ");
					super.addStringForField(feedBackVO
							.getDescription());
				}
			}
			strsql.append(" group by vcf.feedBackID order by vcf.createTime desc");
		}else if(QUERY_HISTORY_ALL == _operatorType){//历史查询
			strsql.append("SELECT vcf.* ");
			strsql.append("from  avic_t_vc_feedback vcf , z_t_apply_detail ad ");
			strsql.append("where 1=1 and vcf.feedBackID = ad.applyDetailID ");
			if (null != feedBackVO) {
				if (!StringUtils.isNullOrBlank(feedBackVO
						.getFeedBackID())) {
					strsql.append(" and vcf.feedBackID= ? ");
					super.addStringForField(feedBackVO
							.getFeedBackID());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO
						.getDepartmentID())) {
					strsql.append(" and vcf.departmentID= ? ");
					super.addStringForField(feedBackVO
							.getDepartmentID());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO
						.getDepartmentName())) {
					strsql.append(" and vcf.departmentName like ? ");
					super.addStringForField("%" + feedBackVO
							.getDepartmentName().trim() + "%");
				}
				if (!StringUtils.isNullOrBlank(feedBackVO
						.getDepartmentCode())) {
					strsql.append(" and vcf.departmentCode= ? ");
					super.addStringForField(feedBackVO
							.getDepartmentCode());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO
						.getMeetingDetailID())) {
					strsql.append(" and vcf.meetingDetailID= ? ");
					super.addStringForField(feedBackVO
							.getMeetingDetailID());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO
						.getMeetingDetailName())) {
					strsql.append(" and vcf.meetingDetailName like ? ");
					super.addStringForField("%" + feedBackVO
							.getMeetingDetailName().trim() + "%");
				}
				if (!StringUtils.isNullOrBlank(feedBackVO
						.getUserName())) {
					strsql.append(" and vcf.userName= ? ");
					super.addStringForField(feedBackVO
							.getUserName());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO
						.getUserPhone())) {
					strsql.append(" and vcf.userPhone= ? ");
					super.addStringForField(feedBackVO
							.getUserPhone());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO
						.getBBuDes())) {
					strsql.append(" and vcf.bBuDes= ? ");
					super.addStringForField(feedBackVO
							.getBBuDes());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO
						.getFlowID())) {
					strsql.append(" and vcf.flowID= ? ");
					super.addStringForField(feedBackVO
							.getFlowID());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO
						.getCreateUserID())) {
					strsql.append(" and vcf.createUserID= ? ");
					super.addStringForField(feedBackVO
							.getCreateUserID());
				}
				if (Integer.MIN_VALUE != feedBackVO.getStatus()) {
					strsql.append(" and vcf.status= ? ");
					super.addIntForField(feedBackVO.getStatus());
				}
				if (Long.MIN_VALUE != feedBackVO.getRevision()) {
					strsql.append(" and vcf.revision= ? ");
					super.addLongForField(feedBackVO
							.getRevision());
				}
				if (!StringUtils.isNullOrBlank(feedBackVO
						.getDescription())) {
					strsql.append(" and vcf.description= ? ");
					super.addStringForField(feedBackVO
							.getDescription());
				}
			}
			strsql.append(" group by vcf.feedBackID order by vcf.createTime desc");
		}else {
			strsql.append("select vcf.* ");
			strsql.append(" from avic_t_vc_feedback vcf ");
			strsql.append(" where 1=1 ");
			if (QUERY_FROM_VIDEO_FEEDBACK == _operatorType) {
				if (null != feedBackVO) {
					if (!StringUtils.isNullOrBlank(feedBackVO
							.getFeedBackID())) {
						strsql.append(" and vcf.feedBackID= ? ");
						super.addStringForField(feedBackVO
								.getFeedBackID());
					}
					if (!StringUtils.isNullOrBlank(feedBackVO
							.getDepartmentID())) {
						strsql.append(" and vcf.departmentID= ? ");
						super.addStringForField(feedBackVO
								.getDepartmentID());
					}
					if (!StringUtils.isNullOrBlank(feedBackVO
							.getDepartmentName())) {
						strsql.append(" and vcf.departmentName= ? ");
						super.addStringForField(feedBackVO
								.getDepartmentName());
					}
					if (!StringUtils.isNullOrBlank(feedBackVO
							.getDepartmentCode())) {
						strsql.append(" and vcf.departmentCode= ? ");
						super.addStringForField(feedBackVO
								.getDepartmentCode());
					}
					if (!StringUtils.isNullOrBlank(feedBackVO
							.getMeetingDetailID())) {
						strsql.append(" and vcf.meetingDetailID= ? ");
						super.addStringForField(feedBackVO
								.getMeetingDetailID());
					}
					if (!StringUtils.isNullOrBlank(feedBackVO
							.getMeetingDetailName())) {
						strsql.append(" and vcf.meetingDetailName= ? ");
						super.addStringForField(feedBackVO
								.getMeetingDetailName());
					}
					if (!StringUtils.isNullOrBlank(feedBackVO
							.getUserName())) {
						strsql.append(" and vcf.userName= ? ");
						super.addStringForField(feedBackVO
								.getUserName());
					}
					if (!StringUtils.isNullOrBlank(feedBackVO
							.getUserPhone())) {
						strsql.append(" and vcf.userPhone= ? ");
						super.addStringForField(feedBackVO
								.getUserPhone());
					}
					if (!StringUtils.isNullOrBlank(feedBackVO
							.getBBuDes())) {
						strsql.append(" and vcf.bBuDes= ? ");
						super.addStringForField(feedBackVO
								.getBBuDes());
					}
					if (!StringUtils.isNullOrBlank(feedBackVO
							.getFlowID())) {
						strsql.append(" and vcf.flowID= ? ");
						super.addStringForField(feedBackVO
								.getFlowID());
					}
					if (!StringUtils.isNullOrBlank(feedBackVO
							.getCreateUserID())) {
						strsql.append(" and vcf.createUserID= ? ");
						super.addStringForField(feedBackVO
								.getCreateUserID());
					}
					if (Integer.MIN_VALUE != feedBackVO.getStatus()) {
						strsql.append(" and vcf.status= ? ");
						super.addIntForField(feedBackVO.getStatus());
					}
					if (Long.MIN_VALUE != feedBackVO.getRevision()) {
						strsql.append(" and vcf.revision= ? ");
						super.addLongForField(feedBackVO
								.getRevision());
					}
					if (!StringUtils.isNullOrBlank(feedBackVO
							.getDescription())) {
						strsql.append(" and vcf.description= ? ");
						super.addStringForField(feedBackVO
								.getDescription());
					}
				}
			} else if (QUERY_FROM_VIDEO_FEEDBACK_BY_IDS == _operatorType) {
				strsql.append(" and vcf.feedBackID in (?) ");
				super.addStringForField(ids);
			}
			strsql.append(" group by vcf.feedBackID order by vcf.createTime desc");
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
		feedBackVO = new VideoConferenceFeedBackVO();
		feedBackVO.setFeedBackID(rs.getString("feedBackID"));
		feedBackVO.setDepartmentID(rs.getString("departmentID"));
		feedBackVO.setDepartmentName(rs.getString("departmentName"));
		feedBackVO.setDepartmentCode(rs.getString("departmentCode"));
		feedBackVO.setMeetingDetailID(rs.getString("meetingDetailID"));
		feedBackVO.setMeetingDetailName(rs.getString("meetingDetailName"));
		feedBackVO.setMeetingDetailTime(rs.getTimestamp("meetingDetailTime"));
		feedBackVO.setUserName(rs.getString("userName"));
		feedBackVO.setUserPhone(rs.getString("userPhone"));
		feedBackVO.setBBuDes(rs.getString("bBuDes"));
		feedBackVO.setFlowID(rs.getString("flowID"));
		feedBackVO.setCreateUserID(rs.getString("createUserID"));
		feedBackVO.setCreateTime(rs.getTimestamp("createTime"));
		feedBackVO.setStatus(rs.getInt("status"));
		feedBackVO.setRevision(rs.getLong("revision"));
		feedBackVO.setDescription(rs.getString("description"));
		listVideoConferenceFeedBack.add(feedBackVO);
	}
	public VideoConferenceFeedBackVO getFeedBackVO() {
		return feedBackVO;
	}
	public void setFeedBackVO(VideoConferenceFeedBackVO feedBackVO) {
		this.feedBackVO = feedBackVO;
	}
	public ArrayList<VideoConferenceFeedBackVO> getListVideoConferenceFeedBack() {
		return listVideoConferenceFeedBack;
	}
	public void setListVideoConferenceFeedBack(
			ArrayList<VideoConferenceFeedBackVO> listVideoConferenceFeedBack) {
		this.listVideoConferenceFeedBack = listVideoConferenceFeedBack;
	}

}