package com.zzst.dao.meeting.comparison;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.comparison.ComparisonReferenceVO;

/**
 * class description:	ComparisonReference TO
 * @date Sat Apr 27 11:12:39 CST 2013
 * @author ryan
 */
public class ComparisonReferenceTO extends TransactionObject {

	private	static Logger logger = CbfLogger.getLogger(ComparisonReferenceTO.class.getName());
	private int operatorType=-1;

	public static int 	ADD_COMPARISONREFERENCE=1;
	public static int 	MODIFY_COMPARISONREFERENCE=2;
	public static int 	DEL_COMPARISONREFERENCE=3;
	private int result = 0;

	private ComparisonReferenceVO comparisonReferenceVO;
	private	String	ids = "";

	public ComparisonReferenceTO(int operatorType,ComparisonReferenceVO comparisonReferenceVO){
		this.operatorType = operatorType;
		this.comparisonReferenceVO = comparisonReferenceVO;
	}
	public ComparisonReferenceTO(int operatorType,String ids){
		this.operatorType = operatorType;
		this.ids = ids;
	}





















	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_COMPARISONREFERENCE == operatorType) {
			sqlstr.append("insert into Z_T_COMPARISON_REFERENCE ");	
			sqlstr.append("(ID,meetingRoomID,R_Pr,G_Y,B_Pb,rIndex,gIndex,bIndex,S_R,S_G,S_B,x_min,x_max,type,updateTime,updateUserID,status,description)");									
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(comparisonReferenceVO.getID());
			super.addStringForField(comparisonReferenceVO.getMeetingRoomID());
			super.addStringForField(comparisonReferenceVO.getR_Pr());
			super.addStringForField(comparisonReferenceVO.getG_Y());
			super.addStringForField(comparisonReferenceVO.getB_Pb());
			super.addIntForField(comparisonReferenceVO.getRIndex());
			super.addIntForField(comparisonReferenceVO.getGIndex());
			super.addIntForField(comparisonReferenceVO.getBIndex());
			super.addIntForField(comparisonReferenceVO.getS_R());
			super.addIntForField(comparisonReferenceVO.getS_G());
			super.addIntForField(comparisonReferenceVO.getS_B());
			super.addIntForField(comparisonReferenceVO.getX_min());
			super.addIntForField(comparisonReferenceVO.getX_max());
			super.addIntForField(comparisonReferenceVO.getType());
			super.addTimestampForField(comparisonReferenceVO.getUpdateTime());
			super.addStringForField(comparisonReferenceVO.getUpdateUserID());
			super.addIntForField(comparisonReferenceVO.getStatus());
			super.addStringForField(comparisonReferenceVO.getDescription());
		}else if (MODIFY_COMPARISONREFERENCE == operatorType) {
			sqlstr.append("update  Z_T_COMPARISON_REFERENCE set ");
			sqlstr.append(" ID = ID ");



			if(comparisonReferenceVO.getMeetingRoomID()!=null){
				sqlstr.append(" , meetingRoomID=? ");
				super.addStringForField(comparisonReferenceVO.getMeetingRoomID());
			}	

			if(comparisonReferenceVO.getR_Pr()!=null){
				sqlstr.append(" , R_Pr=? ");
				super.addStringForField(comparisonReferenceVO.getR_Pr());
			}	

			if(comparisonReferenceVO.getG_Y()!=null){
				sqlstr.append(" , G_Y=? ");
				super.addStringForField(comparisonReferenceVO.getG_Y());
			}	

			if(comparisonReferenceVO.getB_Pb()!=null){
				sqlstr.append(" , B_Pb=? ");
				super.addStringForField(comparisonReferenceVO.getB_Pb());
			}	

			if(comparisonReferenceVO.getRIndex()!=Integer.MIN_VALUE){
				sqlstr.append(" , rIndex=?");	
				super.addIntForField(comparisonReferenceVO.getRIndex());
			}

			if(comparisonReferenceVO.getGIndex()!=Integer.MIN_VALUE){
				sqlstr.append(" , gIndex=?");	
				super.addIntForField(comparisonReferenceVO.getGIndex());
			}

			if(comparisonReferenceVO.getBIndex()!=Integer.MIN_VALUE){
				sqlstr.append(" , bIndex=?");	
				super.addIntForField(comparisonReferenceVO.getBIndex());
			}

			if(comparisonReferenceVO.getS_R()!=Integer.MIN_VALUE){
				sqlstr.append(" , S_R=?");	
				super.addIntForField(comparisonReferenceVO.getS_R());
			}

			if(comparisonReferenceVO.getS_G()!=Integer.MIN_VALUE){
				sqlstr.append(" , S_G=?");	
				super.addIntForField(comparisonReferenceVO.getS_G());
			}

			if(comparisonReferenceVO.getS_B()!=Integer.MIN_VALUE){
				sqlstr.append(" , S_B=?");	
				super.addIntForField(comparisonReferenceVO.getS_B());
			}

			if(comparisonReferenceVO.getX_min()!=Integer.MIN_VALUE){
				sqlstr.append(" , x_min=?");	
				super.addIntForField(comparisonReferenceVO.getX_min());
			}

			if(comparisonReferenceVO.getX_max()!=Integer.MIN_VALUE){
				sqlstr.append(" , x_max=?");	
				super.addIntForField(comparisonReferenceVO.getX_max());
			}

			if(comparisonReferenceVO.getType()!=Integer.MIN_VALUE){
				sqlstr.append(" , type=?");	
				super.addIntForField(comparisonReferenceVO.getType());
			}

			if(comparisonReferenceVO.getUpdateTime()!=null){
				sqlstr.append(" , updateTime=? ");
				super.addTimestampForField(comparisonReferenceVO.getUpdateTime());
			}	

			if(comparisonReferenceVO.getUpdateUserID()!=null){
				sqlstr.append(" , updateUserID=? ");
				super.addStringForField(comparisonReferenceVO.getUpdateUserID());
			}	

			if(comparisonReferenceVO.getStatus()!=Integer.MIN_VALUE){
				sqlstr.append(" , status=?");	
				super.addIntForField(comparisonReferenceVO.getStatus());
			}

			if(comparisonReferenceVO.getDescription()!=null){
				sqlstr.append(" , description=? ");
				super.addStringForField(comparisonReferenceVO.getDescription());
			}	


			sqlstr.append(" where ID in (?) ");
			if(comparisonReferenceVO.getID()!=null){
				super.addStringForField(comparisonReferenceVO.getID());
			}	
		}else if (DEL_COMPARISONREFERENCE == operatorType) {
			sqlstr.append("delete  from  Z_T_COMPARISON_REFERENCE ");
			sqlstr.append(" where ID in (?) ");
			super.addStringForField(comparisonReferenceVO.getID());
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


