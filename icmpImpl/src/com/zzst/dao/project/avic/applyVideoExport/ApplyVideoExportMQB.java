package com.zzst.dao.project.avic.applyVideoExport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.enums.ApplyEnum;
import com.zzst.model.project.avic.applyVideoExport.ApplyVideoExportVO;

/**
 * class description: ApplyVideoExport MQB
 * 
 * @date Tue Sep 25 16:50:34 CST 2012
 * @author ryan
 */
public class ApplyVideoExportMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(ApplyVideoExportMQB.class
			.getName());

	public static int QUERY_FROM_APPLY_VIDEO_EXPORT = 1;
	public static int QUERY_FROM_APPLY_VIDEO_EXPORT_BY_IDS = 2;
	public static int QUERY_FROM_BY_USERID = 3;
	public static int QUERY_HISTORY_FROM_BY_USERID = 4;
	public static int QUERY_HISTORY_ALL = 5;

	private ApplyVideoExportVO applyVideoExportVO;
	private ArrayList<ApplyVideoExportVO> listApplyVideoExport = new ArrayList<ApplyVideoExportVO>();

	private int _operatorType = -1;
	private String ids = "";

	public ApplyVideoExportMQB(int operatorType,
			ApplyVideoExportVO applyVideoExportVO) {
		_operatorType = operatorType;
		this.applyVideoExportVO = applyVideoExportVO;
		makeSql();
	}

	public ApplyVideoExportMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}
	public ApplyVideoExportMQB(int operatorType,ApplyVideoExportVO applyVideoExportVO, String ids) {
		_operatorType = operatorType;
		this.applyVideoExportVO = applyVideoExportVO;
		this.ids = ids;
		makeSql();
	}
	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		if(QUERY_FROM_BY_USERID == _operatorType ){
			strsql.append("select ave.*");
			strsql.append(" from avic_t_apply_video_export ave ,z_t_apply_detail ad");
			strsql.append(" where 1=1 and ad.status="+ApplyEnum.STATUS_ING+" and ave.applyID=ad.applyDetailID and ave.status!="+ApplyEnum.STATUS_REJECT);
			strsql.append(" and ad.checkUserIDs like '%," + ids + ",%'");
			if (null != applyVideoExportVO) {
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getApplyID())) {
					strsql.append(" and ave.applyID= ? ");
					super.addStringForField(applyVideoExportVO.getApplyID());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getDepartmentID())) {
					strsql.append(" and ave.departmentID= ? ");
					super.addStringForField(applyVideoExportVO.getDepartmentID());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getDepartmentName())) {
					strsql.append(" and ave.departmentName like ? ");
					super.addStringForField("%" +applyVideoExportVO.getDepartmentName().trim() + "%");
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getApplyUserID())) {
					strsql.append(" and ave.applyUserID= ? ");
					super.addStringForField(applyVideoExportVO.getApplyUserID());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getApplyUserName())) {
					strsql.append(" and ave.applyUserName= ? ");
					super.addStringForField(applyVideoExportVO.getApplyUserName());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getContactWay())) {
					strsql.append(" and ave.contactWay= ? ");
					super.addStringForField(applyVideoExportVO.getContactWay());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getMeetingDetailID())) {
					strsql.append(" and ave.meetingDetailID= ? ");
					super.addStringForField(applyVideoExportVO.getMeetingDetailID());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getMeetingDetailName())) {
					strsql.append(" and ave.meetingDetailName like ? ");
					super.addStringForField("%" + applyVideoExportVO.getMeetingDetailName().trim() + "%");
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getApplyWay())) {
					strsql.append(" and ave.applyWay= ? ");
					super.addStringForField(applyVideoExportVO.getApplyWay());
				}
				if (Integer.MIN_VALUE != applyVideoExportVO.getApplyNumber()) {
					strsql.append(" and ave.applyNumber= ? ");
					super.addIntForField(applyVideoExportVO.getApplyNumber());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getMediaCode())) {
					strsql.append(" and ave.mediaCode= ? ");
					super.addStringForField(applyVideoExportVO.getMediaCode());
				}
				if (Integer.MIN_VALUE != applyVideoExportVO.getSecurity()) {
					strsql.append(" and ave.security= ? ");
					super.addIntForField(applyVideoExportVO.getSecurity());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getExportUserName())) {
					strsql.append(" and ave.exportUserName= ? ");
					super.addStringForField(applyVideoExportVO.getExportUserName());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getPickUpUserName())) {
					strsql.append(" and ave.pickUpUserName= ? ");
					super.addStringForField(applyVideoExportVO.getPickUpUserName());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getExportDes())) {
					strsql.append(" and ave.exportDes= ? ");
					super.addStringForField(applyVideoExportVO.getExportDes());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getFlowID())) {
					strsql.append(" and ave.flowID= ? ");
					super.addStringForField(applyVideoExportVO.getFlowID());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getCreateUserID())) {
					strsql.append(" and ave.createUserID= ? ");
					super.addStringForField(applyVideoExportVO.getCreateUserID());
				}
				if (Integer.MIN_VALUE != applyVideoExportVO.getStatus()) {
					strsql.append(" and ave.status= ? ");
					super.addIntForField(applyVideoExportVO.getStatus());
				}
				if (Long.MIN_VALUE != applyVideoExportVO.getRevision()) {
					strsql.append(" and ave.revision= ? ");
					super.addLongForField(applyVideoExportVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getDescription())) {
					strsql.append(" and ave.description= ? ");
					super.addStringForField(applyVideoExportVO.getDescription());
				}
			}
			strsql.append(" group by ave.applyID order by ave.createTime desc");
		}else if(QUERY_HISTORY_FROM_BY_USERID == _operatorType){//历史查询
			strsql.append("SELECT ave.* ");
			strsql.append(" from avic_t_apply_video_export ave , z_t_apply_detail ad");
			strsql.append(" where 1=1 and ave.applyID = ad.applyDetailID and ad.userId = ? ");
			super.addStringForField(ids);
			if (null != applyVideoExportVO) {
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getApplyID())) {
					strsql.append(" and ave.applyID= ? ");
					super.addStringForField(applyVideoExportVO.getApplyID());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getDepartmentID())) {
					strsql.append(" and ave.departmentID= ? ");
					super.addStringForField(applyVideoExportVO.getDepartmentID());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getDepartmentName())) {
					strsql.append(" and ave.departmentName like ? ");
					super.addStringForField("%"+applyVideoExportVO.getDepartmentName().trim()+"%");
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getApplyUserID())) {
					strsql.append(" and ave.applyUserID= ? ");
					super.addStringForField(applyVideoExportVO.getApplyUserID());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getApplyUserName())) {
					strsql.append(" and ave.applyUserName= ? ");
					super.addStringForField(applyVideoExportVO.getApplyUserName());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getContactWay())) {
					strsql.append(" and ave.contactWay= ? ");
					super.addStringForField(applyVideoExportVO.getContactWay());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getMeetingDetailID())) {
					strsql.append(" and ave.meetingDetailID= ? ");
					super.addStringForField(applyVideoExportVO.getMeetingDetailID());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getMeetingDetailName())) {
					strsql.append(" and ave.meetingDetailName like ? ");
					super.addStringForField("%"+applyVideoExportVO.getMeetingDetailName().trim()+"%");
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getApplyWay())) {
					strsql.append(" and ave.applyWay= ? ");
					super.addStringForField(applyVideoExportVO.getApplyWay());
				}
				if (Integer.MIN_VALUE != applyVideoExportVO.getApplyNumber()) {
					strsql.append(" and ave.applyNumber= ? ");
					super.addIntForField(applyVideoExportVO.getApplyNumber());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getMediaCode())) {
					strsql.append(" and ave.mediaCode= ? ");
					super.addStringForField(applyVideoExportVO.getMediaCode());
				}
				if (Integer.MIN_VALUE != applyVideoExportVO.getSecurity()) {
					strsql.append(" and ave.security= ? ");
					super.addIntForField(applyVideoExportVO.getSecurity());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getExportUserName())) {
					strsql.append(" and ave.exportUserName= ? ");
					super.addStringForField(applyVideoExportVO.getExportUserName());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getPickUpUserName())) {
					strsql.append(" and ave.pickUpUserName= ? ");
					super.addStringForField(applyVideoExportVO.getPickUpUserName());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getExportDes())) {
					strsql.append(" and ave.exportDes= ? ");
					super.addStringForField(applyVideoExportVO.getExportDes());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getFlowID())) {
					strsql.append(" and ave.flowID= ? ");
					super.addStringForField(applyVideoExportVO.getFlowID());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getCreateUserID())) {
					strsql.append(" and ave.createUserID= ? ");
					super.addStringForField(applyVideoExportVO.getCreateUserID());
				}
				if (Integer.MIN_VALUE != applyVideoExportVO.getStatus()) {
					strsql.append(" and ave.status= ? ");
					super.addIntForField(applyVideoExportVO.getStatus());
				}
				if (Long.MIN_VALUE != applyVideoExportVO.getRevision()) {
					strsql.append(" and ave.revision= ? ");
					super.addLongForField(applyVideoExportVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getDescription())) {
					strsql.append(" and ave.description= ? ");
					super.addStringForField(applyVideoExportVO.getDescription());
				}
			}
			strsql.append(" group by ave.applyID order by ave.createTime desc");
		}else if(QUERY_HISTORY_ALL == _operatorType){//历时查询
			strsql.append("SELECT ave.* ");
			strsql.append("from avic_t_apply_video_export ave , z_t_apply_detail ad ");
			strsql.append("where 1=1 and ave.applyID = ad.applyDetailID ");
			if (null != applyVideoExportVO) {
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getApplyID())) {
					strsql.append(" and ave.applyID= ? ");
					super.addStringForField(applyVideoExportVO.getApplyID());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getDepartmentID())) {
					strsql.append(" and ave.departmentID= ? ");
					super.addStringForField(applyVideoExportVO.getDepartmentID());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getDepartmentName())) {
					strsql.append(" and ave.departmentName like ? ");
					super.addStringForField("%"+applyVideoExportVO.getDepartmentName().trim()+"%");
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getApplyUserID())) {
					strsql.append(" and ave.applyUserID= ? ");
					super.addStringForField(applyVideoExportVO.getApplyUserID());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getApplyUserName())) {
					strsql.append(" and ave.applyUserName= ? ");
					super.addStringForField(applyVideoExportVO.getApplyUserName());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getContactWay())) {
					strsql.append(" and ave.contactWay= ? ");
					super.addStringForField(applyVideoExportVO.getContactWay());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getMeetingDetailID())) {
					strsql.append(" and ave.meetingDetailID= ? ");
					super.addStringForField(applyVideoExportVO.getMeetingDetailID());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getMeetingDetailName())) {
					strsql.append(" and ave.meetingDetailName like ? ");
					super.addStringForField("%"+applyVideoExportVO.getMeetingDetailName().trim()+"%");
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getApplyWay())) {
					strsql.append(" and ave.applyWay= ? ");
					super.addStringForField(applyVideoExportVO.getApplyWay());
				}
				if (Integer.MIN_VALUE != applyVideoExportVO.getApplyNumber()) {
					strsql.append(" and ave.applyNumber= ? ");
					super.addIntForField(applyVideoExportVO.getApplyNumber());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getMediaCode())) {
					strsql.append(" and ave.mediaCode= ? ");
					super.addStringForField(applyVideoExportVO.getMediaCode());
				}
				if (Integer.MIN_VALUE != applyVideoExportVO.getSecurity()) {
					strsql.append(" and ave.security= ? ");
					super.addIntForField(applyVideoExportVO.getSecurity());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getExportUserName())) {
					strsql.append(" and ave.exportUserName= ? ");
					super.addStringForField(applyVideoExportVO.getExportUserName());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getPickUpUserName())) {
					strsql.append(" and ave.pickUpUserName= ? ");
					super.addStringForField(applyVideoExportVO.getPickUpUserName());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getExportDes())) {
					strsql.append(" and ave.exportDes= ? ");
					super.addStringForField(applyVideoExportVO.getExportDes());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getFlowID())) {
					strsql.append(" and ave.flowID= ? ");
					super.addStringForField(applyVideoExportVO.getFlowID());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getCreateUserID())) {
					strsql.append(" and ave.createUserID= ? ");
					super.addStringForField(applyVideoExportVO.getCreateUserID());
				}
				if (Integer.MIN_VALUE != applyVideoExportVO.getStatus()) {
					strsql.append(" and ave.status= ? ");
					super.addIntForField(applyVideoExportVO.getStatus());
				}
				if (Long.MIN_VALUE != applyVideoExportVO.getRevision()) {
					strsql.append(" and ave.revision= ? ");
					super.addLongForField(applyVideoExportVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(applyVideoExportVO.getDescription())) {
					strsql.append(" and ave.description= ? ");
					super.addStringForField(applyVideoExportVO.getDescription());
				}
			}
			strsql.append(" group by ave.applyID order by ave.createTime desc");
		} else  {
			strsql.append("select ave.* ");
			strsql.append(" from avic_t_apply_video_export ave");
			strsql.append(" where 1=1 ");
			if (QUERY_FROM_APPLY_VIDEO_EXPORT == _operatorType) {
				if (null != applyVideoExportVO) {
					if (!StringUtils.isNullOrBlank(applyVideoExportVO.getApplyID())) {
						strsql.append(" and ave.applyID= ? ");
						super.addStringForField(applyVideoExportVO.getApplyID());
					}
					if (!StringUtils.isNullOrBlank(applyVideoExportVO.getDepartmentID())) {
						strsql.append(" and ave.departmentID= ? ");
						super.addStringForField(applyVideoExportVO.getDepartmentID());
					}
					if (!StringUtils.isNullOrBlank(applyVideoExportVO.getDepartmentName())) {
						strsql.append(" and ave.departmentName= ? ");
						super.addStringForField(applyVideoExportVO.getDepartmentName());
					}
					if (!StringUtils.isNullOrBlank(applyVideoExportVO.getApplyUserID())) {
						strsql.append(" and ave.applyUserID= ? ");
						super.addStringForField(applyVideoExportVO.getApplyUserID());
					}
					if (!StringUtils.isNullOrBlank(applyVideoExportVO.getApplyUserName())) {
						strsql.append(" and ave.applyUserName= ? ");
						super.addStringForField(applyVideoExportVO.getApplyUserName());
					}
					if (!StringUtils.isNullOrBlank(applyVideoExportVO.getContactWay())) {
						strsql.append(" and ave.contactWay= ? ");
						super.addStringForField(applyVideoExportVO.getContactWay());
					}
					if (!StringUtils.isNullOrBlank(applyVideoExportVO.getMeetingDetailID())) {
						strsql.append(" and ave.meetingDetailID= ? ");
						super.addStringForField(applyVideoExportVO.getMeetingDetailID());
					}
					if (!StringUtils.isNullOrBlank(applyVideoExportVO.getMeetingDetailName())) {
						strsql.append(" and ave.meetingDetailName= ? ");
						super.addStringForField(applyVideoExportVO.getMeetingDetailName());
					}
					if (!StringUtils.isNullOrBlank(applyVideoExportVO.getApplyWay())) {
						strsql.append(" and ave.applyWay= ? ");
						super.addStringForField(applyVideoExportVO.getApplyWay());
					}
					if (Integer.MIN_VALUE != applyVideoExportVO.getApplyNumber()) {
						strsql.append(" and ave.applyNumber= ? ");
						super.addIntForField(applyVideoExportVO.getApplyNumber());
					}
					if (!StringUtils.isNullOrBlank(applyVideoExportVO.getMediaCode())) {
						strsql.append(" and ave.mediaCode= ? ");
						super.addStringForField(applyVideoExportVO.getMediaCode());
					}
					if (Integer.MIN_VALUE != applyVideoExportVO.getSecurity()) {
						strsql.append(" and ave.security= ? ");
						super.addIntForField(applyVideoExportVO.getSecurity());
					}
					if (!StringUtils.isNullOrBlank(applyVideoExportVO.getExportUserName())) {
						strsql.append(" and ave.exportUserName= ? ");
						super.addStringForField(applyVideoExportVO.getExportUserName());
					}
					if (!StringUtils.isNullOrBlank(applyVideoExportVO.getPickUpUserName())) {
						strsql.append(" and ave.pickUpUserName= ? ");
						super.addStringForField(applyVideoExportVO.getPickUpUserName());
					}
					if (!StringUtils.isNullOrBlank(applyVideoExportVO.getExportDes())) {
						strsql.append(" and ave.exportDes= ? ");
						super.addStringForField(applyVideoExportVO.getExportDes());
					}
					if (!StringUtils.isNullOrBlank(applyVideoExportVO.getFlowID())) {
						strsql.append(" and ave.flowID= ? ");
						super.addStringForField(applyVideoExportVO.getFlowID());
					}
					if (!StringUtils.isNullOrBlank(applyVideoExportVO.getCreateUserID())) {
						strsql.append(" and ave.createUserID= ? ");
						super.addStringForField(applyVideoExportVO.getCreateUserID());
					}
					if (Integer.MIN_VALUE != applyVideoExportVO.getStatus()) {
						strsql.append(" and ave.status= ? ");
						super.addIntForField(applyVideoExportVO.getStatus());
					}
					if (Long.MIN_VALUE != applyVideoExportVO.getRevision()) {
						strsql.append(" and ave.revision= ? ");
						super.addLongForField(applyVideoExportVO.getRevision());
					}
					if (!StringUtils.isNullOrBlank(applyVideoExportVO.getDescription())) {
						strsql.append(" and ave.description= ? ");
						super.addStringForField(applyVideoExportVO.getDescription());
					}
				}
				
			}else if (QUERY_FROM_APPLY_VIDEO_EXPORT_BY_IDS == _operatorType) {
				strsql.append(" and ave.applyID in (?) ");
				super.addStringForField(ids);
			}
			strsql.append(" order by ave.createTime desc");
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
		applyVideoExportVO = new ApplyVideoExportVO();
		applyVideoExportVO.setApplyID(rs.getString("applyID"));
		applyVideoExportVO.setDepartmentID(rs.getString("departmentID"));
		applyVideoExportVO.setDepartmentName(rs.getString("departmentName"));
		applyVideoExportVO.setApplyUserID(rs.getString("applyUserID"));
		applyVideoExportVO.setApplyUserName(rs.getString("applyUserName"));
		applyVideoExportVO.setContactWay(rs.getString("contactWay"));
		applyVideoExportVO.setMeetingDetailID(rs.getString("meetingDetailID"));
		applyVideoExportVO.setMeetingDetailName(rs.getString("meetingDetailName"));
		applyVideoExportVO.setApplyWay(rs.getString("applyWay"));
		applyVideoExportVO.setApplyNumber(rs.getInt("applyNumber"));
		applyVideoExportVO.setMediaCode(rs.getString("mediaCode"));
		applyVideoExportVO.setSecurity(rs.getInt("security"));
		applyVideoExportVO.setExportUserName(rs.getString("exportUserName"));
		applyVideoExportVO.setPickUpUserName(rs.getString("pickUpUserName"));
		applyVideoExportVO.setExportDes(rs.getString("exportDes"));
		applyVideoExportVO.setFlowID(rs.getString("flowID"));
		applyVideoExportVO.setCreateUserID(rs.getString("createUserID"));
		applyVideoExportVO.setCreateTime(rs.getTimestamp("createTime"));
		applyVideoExportVO.setStatus(rs.getInt("status"));
		applyVideoExportVO.setRevision(rs.getLong("revision"));
		applyVideoExportVO.setDescription(rs.getString("description"));
		listApplyVideoExport.add(applyVideoExportVO);
	}

	public ArrayList<ApplyVideoExportVO> getApplyVideoExportList() {
		return listApplyVideoExport;
	}

	public ApplyVideoExportVO getApplyVideoExportVO() {
		return applyVideoExportVO;
	}

}
