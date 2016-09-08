package com.zzst.dao.project.avic.service;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.project.avic.service.AvicServiceVO;

/**
 * class description: AvicService TO
 * 
 * @date Thu Sep 20 15:23:06 CST 2012
 * @author ryan
 */
public class AvicServiceTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(AvicServiceTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_AVICSERVICE = 1;
	public static int MODIFY_AVICSERVICE = 2;
	public static int DEL_AVICSERVICE = 3;
	private int result = 0;

	private AvicServiceVO avicServiceVO;
	private String ids = "";

	public AvicServiceTO(int operatorType, AvicServiceVO avicServiceVO) {
		this.operatorType = operatorType;
		this.avicServiceVO = avicServiceVO;
	}

	public AvicServiceTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_AVICSERVICE == operatorType) {
			sqlstr.append("insert into avic_t_service ");
			sqlstr
					.append("(recordID,departmentID,departmentName,departmentCode,meetingDetailID,meetingDetailName,headQuarterLeaderNumber,departmentLeaderNumber,headQuarterEastNumber,headQuarterWestNumber,jinHangNetWorkNumber,otherVenueNumber,netWorkNumber,recordService,otherDes,realityVenueNumber,realityPersonnelNumber,venuePrincipal,createUserID,createTime,status,revision,description,flowId)");
			sqlstr
					.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(avicServiceVO.getRecordID());
			super.addStringForField(avicServiceVO.getDepartmentID());
			super.addStringForField(avicServiceVO.getDepartmentName());
			super.addStringForField(avicServiceVO.getDepartmentCode());
			super.addStringForField(avicServiceVO.getMeetingDetailID());
			super.addStringForField(avicServiceVO.getMeetingDetailName());
			super.addIntForField(avicServiceVO.getHeadQuarterLeaderNumber());
			super.addIntForField(avicServiceVO.getDepartmentLeaderNumber());
			super.addIntForField(avicServiceVO.getHeadQuarterEastNumber());
			super.addIntForField(avicServiceVO.getHeadQuarterWestNumber());
			super.addIntForField(avicServiceVO.getJinHangNetWorkNumber());
			super.addIntForField(avicServiceVO.getOtherVenueNumber());
			super.addIntForField(avicServiceVO.getNetWorkNumber());
			super.addStringForField(avicServiceVO.getRecordService());
			super.addStringForField(avicServiceVO.getOtherDes());
			super.addIntForField(avicServiceVO.getRealityVenueNumber());
			super.addIntForField(avicServiceVO.getRealityPersonnelNumber());
			super.addStringForField(avicServiceVO.getVenuePrincipal());
			super.addStringForField(avicServiceVO.getCreateUserID());
			super.addTimestampForField(avicServiceVO.getCreateTime());
			super.addIntForField(avicServiceVO.getStatus());
			super.addLongForField(avicServiceVO.getRevision());
			super.addStringForField(avicServiceVO.getDescription());
			super.addStringForField(avicServiceVO.getFlowId());
		} else if (MODIFY_AVICSERVICE == operatorType) {
			sqlstr.append("update  avic_t_service set ");
			sqlstr.append(" recordID = recordID ");

			if (avicServiceVO.getDepartmentID() != null) {
				sqlstr.append(" , departmentID=? ");
				super.addStringForField(avicServiceVO.getDepartmentID());
			}

			if (avicServiceVO.getDepartmentName() != null) {
				sqlstr.append(" , departmentName=? ");
				super.addStringForField(avicServiceVO.getDepartmentName());
			}

			if (avicServiceVO.getDepartmentCode() != null) {
				sqlstr.append(" , departmentCode=? ");
				super.addStringForField(avicServiceVO.getDepartmentCode());
			}

			if (avicServiceVO.getMeetingDetailID() != null) {
				sqlstr.append(" , meetingDetailID=? ");
				super.addStringForField(avicServiceVO.getMeetingDetailID());
			}

			if (avicServiceVO.getMeetingDetailName() != null) {
				sqlstr.append(" , meetingDetailName=? ");
				super.addStringForField(avicServiceVO.getMeetingDetailName());
			}

			if (avicServiceVO.getHeadQuarterLeaderNumber() != Integer.MIN_VALUE) {
				sqlstr.append(" , headQuarterLeaderNumber=?");
				super
						.addIntForField(avicServiceVO
								.getHeadQuarterLeaderNumber());
			}

			if (avicServiceVO.getDepartmentLeaderNumber() != Integer.MIN_VALUE) {
				sqlstr.append(" , departmentLeaderNumber=?");
				super.addIntForField(avicServiceVO.getDepartmentLeaderNumber());
			}

			if (avicServiceVO.getHeadQuarterEastNumber() != Integer.MIN_VALUE) {
				sqlstr.append(" , headQuarterEastNumber=?");
				super.addIntForField(avicServiceVO.getHeadQuarterEastNumber());
			}

			if (avicServiceVO.getHeadQuarterWestNumber() != Integer.MIN_VALUE) {
				sqlstr.append(" , headQuarterWestNumber=?");
				super.addIntForField(avicServiceVO.getHeadQuarterWestNumber());
			}

			if (avicServiceVO.getJinHangNetWorkNumber() != Integer.MIN_VALUE) {
				sqlstr.append(" , jinHangNetWorkNumber=?");
				super.addIntForField(avicServiceVO.getJinHangNetWorkNumber());
			}

			if (avicServiceVO.getOtherVenueNumber() != Integer.MIN_VALUE) {
				sqlstr.append(" , otherVenueNumber=?");
				super.addIntForField(avicServiceVO.getOtherVenueNumber());
			}

			if (avicServiceVO.getNetWorkNumber() != Integer.MIN_VALUE) {
				sqlstr.append(" , netWorkNumber=?");
				super.addIntForField(avicServiceVO.getNetWorkNumber());
			}

			if (avicServiceVO.getRecordService() != null) {
				sqlstr.append(" , recordService=? ");
				super.addStringForField(avicServiceVO.getRecordService());
			}

			if (avicServiceVO.getOtherDes() != null) {
				sqlstr.append(" , otherDes=? ");
				super.addStringForField(avicServiceVO.getOtherDes());
			}

			if (avicServiceVO.getRealityVenueNumber() != Integer.MIN_VALUE) {
				sqlstr.append(" , realityVenueNumber=?");
				super.addIntForField(avicServiceVO.getRealityVenueNumber());
			}

			if (avicServiceVO.getRealityPersonnelNumber() != Integer.MIN_VALUE) {
				sqlstr.append(" , realityPersonnelNumber=?");
				super.addIntForField(avicServiceVO.getRealityPersonnelNumber());
			}

			if (avicServiceVO.getVenuePrincipal() != null) {
				sqlstr.append(" , venuePrincipal=? ");
				super.addStringForField(avicServiceVO.getVenuePrincipal());
			}

			if (avicServiceVO.getCreateUserID() != null) {
				sqlstr.append(" , createUserID=? ");
				super.addStringForField(avicServiceVO.getCreateUserID());
			}

			if (avicServiceVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(avicServiceVO.getCreateTime());
			}

			if (avicServiceVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(avicServiceVO.getStatus());
			}

			if (avicServiceVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(avicServiceVO.getRevision());
			}

			if (avicServiceVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(avicServiceVO.getDescription());
			}
			if (avicServiceVO.getFlowId() != null) {
				sqlstr.append(" , flowId=? ");
				super.addStringForField(avicServiceVO.getFlowId());
			}
			sqlstr.append(" where recordID in (?) ");
			if (avicServiceVO.getRecordID() != null) {
				super.addStringForField(avicServiceVO.getRecordID());
			}
		} else if (DEL_AVICSERVICE == operatorType) {
			sqlstr.append("delete  from  avic_t_service ");
			sqlstr.append(" where recordID in (?) ");
			super.addStringForField(avicServiceVO.getRecordID());
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
