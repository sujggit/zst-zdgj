package com.zzst.dao.meeting.VideoCard;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.videoCard.VideoCardVO;

/**
 * class description:	VideoCard TO
 * @date Mon May 13 10:45:05 CST 2013
 * @author ryan
 */
public class VideoCardTO extends TransactionObject {

	private	static Logger logger = CbfLogger.getLogger(VideoCardTO.class.getName());
	private int operatorType=-1;

	public static int 	ADD_VIDEOCARD=1;
	public static int 	MODIFY_VIDEOCARD=2;
	public static int 	DEL_VIDEOCARD=3;
	private int result = 0;

	private VideoCardVO videoCardVO;
	private	String	ids = "";

	public VideoCardTO(int operatorType,VideoCardVO videoCardVO){
		this.operatorType = operatorType;
		this.videoCardVO = videoCardVO;
	}
	public VideoCardTO(int operatorType,String ids){
		this.operatorType = operatorType;
		this.ids = ids;
	}














	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_VIDEOCARD == operatorType) {
			sqlstr.append("insert into Z_T_EQUIPMENT_VIDEOCARD ");	
			sqlstr.append("(equipmentID,appraisalTaskNum,showFormatFlag,outputModel,appraisalModel,collectModel,loginPassword,loginName,inputModel,description,revision)");									
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(videoCardVO.getEquipmentID());
			super.addStringForField(videoCardVO.getAppraisalTaskNum());
			super.addStringForField(videoCardVO.getShowFormatFlag());
			super.addStringForField(videoCardVO.getOutputModel());
			super.addStringForField(videoCardVO.getAppraisalModel());
			super.addStringForField(videoCardVO.getCollectModel());
			super.addStringForField(videoCardVO.getLoginPassWord());
			super.addStringForField(videoCardVO.getLoginName());
			super.addStringForField(videoCardVO.getInputModel());
			super.addStringForField(videoCardVO.getDescription());
			super.addLongForField(videoCardVO.getRevision());
		}else if (MODIFY_VIDEOCARD == operatorType) {
			sqlstr.append("update  Z_T_EQUIPMENT_VIDEOCARD set ");
			sqlstr.append(" equipmentID = equipmentID ");

			if(videoCardVO.getAppraisalTaskNum()!=null){
				sqlstr.append(" , appraisalTaskNum=? ");
				super.addStringForField(videoCardVO.getAppraisalTaskNum());
			}	

			if(videoCardVO.getShowFormatFlag()!=null){
				sqlstr.append(" , showFormatFlag=? ");
				super.addStringForField(videoCardVO.getShowFormatFlag());
			}	

			if(videoCardVO.getOutputModel()!=null){
				sqlstr.append(" , outputModel=? ");
				super.addStringForField(videoCardVO.getOutputModel());
			}	

			if(videoCardVO.getAppraisalModel()!=null){
				sqlstr.append(" , appraisalModel=? ");
				super.addStringForField(videoCardVO.getAppraisalModel());
			}	

			if(videoCardVO.getCollectModel()!=null){
				sqlstr.append(" , collectModel=? ");
				super.addStringForField(videoCardVO.getCollectModel());
			}	

			if(videoCardVO.getLoginPassWord()!=null){
				sqlstr.append(" , loginPassword=? ");
				super.addStringForField(videoCardVO.getLoginPassWord());
			}	

			if(videoCardVO.getLoginName()!=null){
				sqlstr.append(" , loginName=? ");
				super.addStringForField(videoCardVO.getLoginName());
			}	

			if(videoCardVO.getInputModel()!=null){
				sqlstr.append(" , inputModel=? ");
				super.addStringForField(videoCardVO.getInputModel());
			}	

			if(videoCardVO.getDescription()!=null){
				sqlstr.append(" , description=? ");
				super.addStringForField(videoCardVO.getDescription());
			}	

			if(videoCardVO.getRevision()!=Long.MIN_VALUE){
				sqlstr.append(" , revision=? ");
				super.addLongForField(videoCardVO.getRevision());
			}


			sqlstr.append(" where equipmentID in (?) ");
			if(videoCardVO.getEquipmentID()!=null){
				super.addStringForField(videoCardVO.getEquipmentID());
			}	
		}else if (DEL_VIDEOCARD == operatorType) {
			sqlstr.append("delete  from  Z_T_EQUIPMENT_VIDEOCARD ");
			sqlstr.append(" where equipmentID in (?) ");
			super.addStringForField(ids);
		}
		this.sqlStr = sqlstr.toString();
	}

	public String getSqlStr(){
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


