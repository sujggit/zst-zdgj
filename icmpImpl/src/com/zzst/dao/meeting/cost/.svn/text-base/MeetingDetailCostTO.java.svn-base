package com.zzst.dao.meeting.cost;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.cost.MeetingDetailCostVO;

/**
 * class description: MeetingDetailCost TO
 * 
 * @date Fri May 17 15:30:40 CST 2013
 * @author ryan
 */
public class MeetingDetailCostTO extends TransactionObject {

	public static final int MODIFYCOUT_MEETINGDETAILCOST = 4;
	private static Logger logger = CbfLogger
			.getLogger(MeetingDetailCostTO.class.getName());
	private int operatorType = -1;

	public static int ADD_MEETINGDETAILCOST = 1;
	public static int MODIFY_MEETINGDETAILCOST = 2;
	public static int DEL_MEETINGDETAILCOST = 3;
	private int result = 0;

	private MeetingDetailCostVO meetingDetailCostVO;

	public MeetingDetailCostTO(int operatorType,
			MeetingDetailCostVO meetingDetailCostVO) {
		this.operatorType = operatorType;
		this.meetingDetailCostVO = meetingDetailCostVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_MEETINGDETAILCOST == operatorType) {
			sqlstr.append("insert into z_t_meetingdetail_cost ");
			sqlstr
					.append("(id,meetingDetailId,costItem,cout,costValue,createUserId,createTime,status,description,revision)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(meetingDetailCostVO.getId());
			super.addStringForField(meetingDetailCostVO.getMeetingDetailId());
			super.addStringForField(meetingDetailCostVO.getCostItem());
			super.addIntForField(meetingDetailCostVO.getCout());
			super.addIntForField(meetingDetailCostVO.getCostValue());
			super.addStringForField(meetingDetailCostVO.getCreateUserId());
			super.addTimestampForField(meetingDetailCostVO.getCreateTime());
			super.addIntForField(meetingDetailCostVO.getStatus());
			super.addStringForField(meetingDetailCostVO.getDescription());
			super.addLongForField(meetingDetailCostVO.getRevision());
		} else if (MODIFY_MEETINGDETAILCOST == operatorType) {
			sqlstr.append("update  z_t_meetingdetail_cost set ");
			sqlstr.append(" id = id ");

			if (meetingDetailCostVO.getMeetingDetailId() != null) {
				sqlstr.append(" , meetingDetailId=? ");
				super.addStringForField(meetingDetailCostVO
						.getMeetingDetailId());
			}

			if (meetingDetailCostVO.getCostItem() != null) {
				sqlstr.append(" , costItem=? ");
				super.addStringForField(meetingDetailCostVO.getCostItem());
			}

			if (meetingDetailCostVO.getCout() != Integer.MIN_VALUE) {
				sqlstr.append(" , cout=?");
				super.addIntForField(meetingDetailCostVO.getCout());
			}

			if (meetingDetailCostVO.getCostValue() != Integer.MIN_VALUE) {
				sqlstr.append(" , costValue=?");
				super.addIntForField(meetingDetailCostVO.getCostValue());
			}

			if (meetingDetailCostVO.getCreateUserId() != null) {
				sqlstr.append(" , createUserId=? ");
				super.addStringForField(meetingDetailCostVO.getCreateUserId());
			}

			if (meetingDetailCostVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(meetingDetailCostVO.getCreateTime());
			}

			if (meetingDetailCostVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(meetingDetailCostVO.getStatus());
			}

			if (meetingDetailCostVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(meetingDetailCostVO.getDescription());
			}

			if (meetingDetailCostVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(meetingDetailCostVO.getRevision());
			}

			sqlstr.append(" where id in (?) ");
			if (meetingDetailCostVO.getId() != null) {
				super.addStringForField(meetingDetailCostVO.getId());
			}
		} else if (DEL_MEETINGDETAILCOST == operatorType) {
			sqlstr.append("delete  from  z_t_meetingdetail_cost ");
			sqlstr.append(" where id in (?) ");
			super.addStringForField(meetingDetailCostVO.getId());
		} else if (MODIFYCOUT_MEETINGDETAILCOST == operatorType) {
			sqlstr.append("update  z_t_meetingdetail_cost set ");
			sqlstr.append(" id = id ");
			
			if (meetingDetailCostVO.getCout() != Integer.MIN_VALUE) {
				sqlstr.append(" , cout=?");
				super.addIntForField(meetingDetailCostVO.getCout());
			}

			if (meetingDetailCostVO.getCostValue() != Integer.MIN_VALUE) {
				sqlstr.append(" , costValue=?");
				super.addIntForField(meetingDetailCostVO.getCostValue());
			}

			if (meetingDetailCostVO.getCreateUserId() != null) {
				sqlstr.append(" , createUserId=? ");
				super.addStringForField(meetingDetailCostVO.getCreateUserId());
			}

			if (meetingDetailCostVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(meetingDetailCostVO.getCreateTime());
			}

			if (meetingDetailCostVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(meetingDetailCostVO.getStatus());
			}

			if (meetingDetailCostVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(meetingDetailCostVO.getDescription());
			}

			if (meetingDetailCostVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(meetingDetailCostVO.getRevision());
			}

			sqlstr.append(" where meetingDetailId in (?) ");
			if (meetingDetailCostVO.getMeetingDetailId() != null) {
				super.addStringForField(meetingDetailCostVO
						.getMeetingDetailId());
			}
			
			sqlstr.append(" and costItem in (?) ");
			if (meetingDetailCostVO.getCostItem() != null) {
				super.addStringForField(meetingDetailCostVO.getCostItem());
			}
			
			if (meetingDetailCostVO.getId() != null) {
				sqlstr.append(" and id in (?) ");
				super.addStringForField(meetingDetailCostVO.getId());
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
