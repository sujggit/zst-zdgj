package com.zzst.dao.meeting.information;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.information.InformationVO;

/**
 * class description: Information TO
 * 
 * @date Tue Jan 29 18:25:43 CST 2013
 * @author ryan
 */
public class InformationTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(InformationTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_INFORMATION = 1;
	public static int MODIFY_INFORMATION = 2;
	public static int DEL_INFORMATION = 3;
	private int result = 0;

	private InformationVO informationVO;
	private String ids = "";

	public InformationTO(int operatorType, InformationVO informationVO) {
		this.operatorType = operatorType;
		this.informationVO = informationVO;
	}

	public InformationTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_INFORMATION == operatorType) {
			sqlstr.append("insert into z_t_information ");
			sqlstr.append("(infoID,infoType,title,content,createTime,status,description,");
			sqlstr.append("sourceName,meetingDetailId,rank,scanStatus)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(informationVO.getInfoID());
			super.addIntForField(informationVO.getInfoType());
			super.addStringForField(informationVO.getTitle());
			super.addStringForField(informationVO.getContent());
			//super.addStringForField(informationVO.getCreateUserID());
			super.addTimestampForField(informationVO.getCreateTime());
			super.addIntForField(informationVO.getStatus());
			super.addStringForField(informationVO.getDescription());
			super.addStringForField(informationVO.getSourceName());
			super.addStringForField(informationVO.getMeetingDetailId());
			super.addIntForField(informationVO.getRank());
			super.addIntForField(informationVO.getScanStatus());
		} else if (MODIFY_INFORMATION == operatorType) {
			sqlstr.append("update  z_t_information set ");
			sqlstr.append(" infoID = infoID ");

			if (informationVO.getInfoType() != Integer.MIN_VALUE) {
				sqlstr.append(" , infoType=?");
				super.addIntForField(informationVO.getInfoType());
			}

			if (informationVO.getTitle() != null) {
				sqlstr.append(" , title=? ");
				super.addStringForField(informationVO.getTitle());
			}

			if (informationVO.getContent() != null) {
				sqlstr.append(" , content=? ");
				super.addStringForField(informationVO.getContent());
			}

//			if (informationVO.getCreateUserID() != null) {
//				sqlstr.append(" , createUserID=? ");
//				super.addStringForField(informationVO.getCreateUserID());
//			}
			if(!StringUtils.isNullOrBlank(informationVO.getSourceName())){
				sqlstr.append(" , sourceName= ? ");
				super.addStringForField(informationVO.getSourceName());
			}
			
			if(!StringUtils.isNullOrBlank(informationVO.getMeetingDetailId())){
				sqlstr.append(" , meetingDetailId= ? ");
				super.addStringForField(informationVO.getMeetingDetailId());
			}
			
			if(Integer.MIN_VALUE!=informationVO.getRank()){
				sqlstr.append(" , rank= ? ");
				super.addIntForField(informationVO.getRank());
			}
			
			if(Integer.MIN_VALUE!=informationVO.getScanStatus()){
				sqlstr.append(" , scanStatus= ? ");
				super.addIntForField(informationVO.getScanStatus());
			}
			
			if (informationVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(informationVO.getCreateTime());
			}

			if (informationVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(informationVO.getStatus());
			}

			if (informationVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(informationVO.getDescription());
			}

			sqlstr.append(" where infoID in (?) ");
			if (informationVO.getInfoID() != null) {
				super.addStringForField(informationVO.getInfoID());
			}
		} else if (DEL_INFORMATION == operatorType) {
			sqlstr.append("delete  from  z_t_information ");
			sqlstr.append(" where infoID in (?) ");
			super.addStringForField(ids);
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
