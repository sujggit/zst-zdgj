package com.zzst.dao.meeting.comparison;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.comparison.ComparisonDetailVO;

/**
 * class description:	ComparisonDetail TO
 * @date Sun Apr 28 13:09:54 CST 2013
 * @author ryan
 */
public class ComparisonDetailTO extends TransactionObject {

	private	static Logger logger = CbfLogger.getLogger(ComparisonDetailTO.class.getName());
	private int operatorType=-1;

	public static int 	ADD_COMPARISONDETAIL=1;
	public static int 	MODIFY_COMPARISONDETAIL=2;
	public static int 	DEL_COMPARISONDETAIL=3;
	private int result = 0;

	private ComparisonDetailVO comparisonDetailVO;
	private	String	ids = "";

	public ComparisonDetailTO(int operatorType,ComparisonDetailVO comparisonDetailVO){
		this.operatorType = operatorType;
		this.comparisonDetailVO = comparisonDetailVO;
	}
	public ComparisonDetailTO(int operatorType,String ids){
		this.operatorType = operatorType;
		this.ids = ids;
	}

































	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_COMPARISONDETAIL == operatorType) {
			sqlstr.append("insert into Z_T_MEETING_COMPARISON_DETAIL ");	
			sqlstr.append("(ID,R_Pr,G_Y,B_Pb,uplinkR_Pr,uplinkG_Y,uplinkB_Pb,S_R,S_R_gap,S_R_result,S_G,S_G_gap,S_G_result,S_B,S_B_gap,S_B_result,uplinkS_R,uplinkS_R_gap,uplinkS_R_result,uplinkS_G,uplinkS_G_gap,uplinkS_G_result,uplinkS_B,uplinkS_B_gap,uplinkS_B_result,type,updateTime,updateUserID,status,description)");									
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(comparisonDetailVO.getID());
			super.addStringForField(comparisonDetailVO.getR_Pr());
			super.addStringForField(comparisonDetailVO.getG_Y());
			super.addStringForField(comparisonDetailVO.getB_Pb());
			super.addStringForField(comparisonDetailVO.getUplinkR_Pr());
			super.addStringForField(comparisonDetailVO.getUplinkG_Y());
			super.addStringForField(comparisonDetailVO.getUplinkB_Pb());
			super.addIntForField(comparisonDetailVO.getS_R());
			super.addFloatForField(comparisonDetailVO.getS_R_gap());
			super.addIntForField(comparisonDetailVO.getS_R_result());
			super.addIntForField(comparisonDetailVO.getS_G());
			super.addFloatForField(comparisonDetailVO.getS_G_gap());
			super.addIntForField(comparisonDetailVO.getS_G_result());
			super.addIntForField(comparisonDetailVO.getS_B());
			super.addFloatForField(comparisonDetailVO.getS_B_gap());
			super.addIntForField(comparisonDetailVO.getS_B_result());
			super.addIntForField(comparisonDetailVO.getUplinkS_R());
			super.addFloatForField(comparisonDetailVO.getUplinkS_R_gap());
			super.addIntForField(comparisonDetailVO.getUplinkS_R_result());
			super.addIntForField(comparisonDetailVO.getUplinkS_G());
			super.addFloatForField(comparisonDetailVO.getUplinkS_G_gap());
			super.addIntForField(comparisonDetailVO.getUplinkS_G_result());
			super.addIntForField(comparisonDetailVO.getUplinkS_B());
			super.addFloatForField(comparisonDetailVO.getUplinkS_B_gap());
			super.addIntForField(comparisonDetailVO.getUplinkS_B_result());
			super.addIntForField(comparisonDetailVO.getType());
			super.addTimestampForField(comparisonDetailVO.getUpdateTime());
			super.addStringForField(comparisonDetailVO.getUpdateUserID());
			super.addIntForField(comparisonDetailVO.getStatus());
			super.addStringForField(comparisonDetailVO.getDescription());
		}else if (MODIFY_COMPARISONDETAIL == operatorType) {
			sqlstr.append("update  Z_T_MEETING_COMPARISON_DETAIL set ");
			sqlstr.append(" ID = ID ");



			if(comparisonDetailVO.getR_Pr()!=null){
				sqlstr.append(" , R_Pr=? ");
				super.addStringForField(comparisonDetailVO.getR_Pr());
			}	

			if(comparisonDetailVO.getG_Y()!=null){
				sqlstr.append(" , G_Y=? ");
				super.addStringForField(comparisonDetailVO.getG_Y());
			}	

			if(comparisonDetailVO.getB_Pb()!=null){
				sqlstr.append(" , B_Pb=? ");
				super.addStringForField(comparisonDetailVO.getB_Pb());
			}	

			if(comparisonDetailVO.getUplinkR_Pr()!=null){
				sqlstr.append(" , uplinkR_Pr=? ");
				super.addStringForField(comparisonDetailVO.getUplinkR_Pr());
			}	

			if(comparisonDetailVO.getUplinkG_Y()!=null){
				sqlstr.append(" , uplinkG_Y=? ");
				super.addStringForField(comparisonDetailVO.getUplinkG_Y());
			}	

			if(comparisonDetailVO.getUplinkB_Pb()!=null){
				sqlstr.append(" , uplinkB_Pb=? ");
				super.addStringForField(comparisonDetailVO.getUplinkB_Pb());
			}	

			if(comparisonDetailVO.getS_R()!=Integer.MIN_VALUE){
				sqlstr.append(" , S_R=?");	
				super.addIntForField(comparisonDetailVO.getS_R());
			}

			if(comparisonDetailVO.getS_R_gap()!=Float.MIN_VALUE){
				sqlstr.append(" , S_R_gap=? ");
				super.addFloatForField(comparisonDetailVO.getS_R_gap());
			}

			if(comparisonDetailVO.getS_R_result()!=Integer.MIN_VALUE){
				sqlstr.append(" , S_R_result=?");	
				super.addIntForField(comparisonDetailVO.getS_R_result());
			}

			if(comparisonDetailVO.getS_G()!=Integer.MIN_VALUE){
				sqlstr.append(" , S_G=?");	
				super.addIntForField(comparisonDetailVO.getS_G());
			}

			if(comparisonDetailVO.getS_G_gap()!=Float.MIN_VALUE){
				sqlstr.append(" , S_G_gap=? ");
				super.addFloatForField(comparisonDetailVO.getS_G_gap());
			}

			if(comparisonDetailVO.getS_G_result()!=Integer.MIN_VALUE){
				sqlstr.append(" , S_G_result=?");	
				super.addIntForField(comparisonDetailVO.getS_G_result());
			}

			if(comparisonDetailVO.getS_B()!=Integer.MIN_VALUE){
				sqlstr.append(" , S_B=?");	
				super.addIntForField(comparisonDetailVO.getS_B());
			}

			if(comparisonDetailVO.getS_B_gap()!=Float.MIN_VALUE){
				sqlstr.append(" , S_B_gap=? ");
				super.addFloatForField(comparisonDetailVO.getS_B_gap());
			}

			if(comparisonDetailVO.getS_B_result()!=Integer.MIN_VALUE){
				sqlstr.append(" , S_B_result=?");	
				super.addIntForField(comparisonDetailVO.getS_B_result());
			}

			if(comparisonDetailVO.getUplinkS_R()!=Integer.MIN_VALUE){
				sqlstr.append(" , uplinkS_R=?");	
				super.addIntForField(comparisonDetailVO.getUplinkS_R());
			}

			if(comparisonDetailVO.getUplinkS_R_gap()!=Float.MIN_VALUE){
				sqlstr.append(" , uplinkS_R_gap=? ");
				super.addFloatForField(comparisonDetailVO.getUplinkS_R_gap());
			}

			if(comparisonDetailVO.getUplinkS_R_result()!=Integer.MIN_VALUE){
				sqlstr.append(" , uplinkS_R_result=?");	
				super.addIntForField(comparisonDetailVO.getUplinkS_R_result());
			}

			if(comparisonDetailVO.getUplinkS_G()!=Integer.MIN_VALUE){
				sqlstr.append(" , uplinkS_G=?");	
				super.addIntForField(comparisonDetailVO.getUplinkS_G());
			}

			if(comparisonDetailVO.getUplinkS_G_gap()!=Float.MIN_VALUE){
				sqlstr.append(" , uplinkS_G_gap=? ");
				super.addFloatForField(comparisonDetailVO.getUplinkS_G_gap());
			}

			if(comparisonDetailVO.getUplinkS_G_result()!=Integer.MIN_VALUE){
				sqlstr.append(" , uplinkS_G_result=?");	
				super.addIntForField(comparisonDetailVO.getUplinkS_G_result());
			}

			if(comparisonDetailVO.getUplinkS_B()!=Integer.MIN_VALUE){
				sqlstr.append(" , uplinkS_B=?");	
				super.addIntForField(comparisonDetailVO.getUplinkS_B());
			}

			if(comparisonDetailVO.getUplinkS_B_gap()!=Float.MIN_VALUE){
				sqlstr.append(" , uplinkS_B_gap=? ");
				super.addFloatForField(comparisonDetailVO.getUplinkS_B_gap());
			}

			if(comparisonDetailVO.getUplinkS_B_result()!=Integer.MIN_VALUE){
				sqlstr.append(" , uplinkS_B_result=?");	
				super.addIntForField(comparisonDetailVO.getUplinkS_B_result());
			}

			if(comparisonDetailVO.getType()!=Integer.MIN_VALUE){
				sqlstr.append(" , type=?");	
				super.addIntForField(comparisonDetailVO.getType());
			}

			if(comparisonDetailVO.getUpdateTime()!=null){
				sqlstr.append(" , updateTime=? ");
				super.addTimestampForField(comparisonDetailVO.getUpdateTime());
			}	

			if(comparisonDetailVO.getUpdateUserID()!=null){
				sqlstr.append(" , updateUserID=? ");
				super.addStringForField(comparisonDetailVO.getUpdateUserID());
			}	

			if(comparisonDetailVO.getStatus()!=Integer.MIN_VALUE){
				sqlstr.append(" , status=?");	
				super.addIntForField(comparisonDetailVO.getStatus());
			}

			if(comparisonDetailVO.getDescription()!=null){
				sqlstr.append(" , description=? ");
				super.addStringForField(comparisonDetailVO.getDescription());
			}	


			sqlstr.append(" where ID in (?) ");
			if(comparisonDetailVO.getID()!=null){
				super.addStringForField(comparisonDetailVO.getID());
			}	
		}else if (DEL_COMPARISONDETAIL == operatorType) {
			sqlstr.append("delete  from  Z_T_MEETING_COMPARISON_DETAIL ");
			sqlstr.append(" where ID in (?) ");
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


