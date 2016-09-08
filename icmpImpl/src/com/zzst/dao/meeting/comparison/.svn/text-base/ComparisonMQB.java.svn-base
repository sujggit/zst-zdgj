package com.zzst.dao.meeting.comparison;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.comparison.ComparisonVO;

/**
 * class description:	Comparison MQB
 * @date Sat Apr 27 13:39:44 CST 2013
 * @author ryan
 */
public class ComparisonMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(ComparisonMQB.class.getName());

	public static int  QUERY_FROM_COMPARISON		=	1;
	public static int  QUERY_FROM_COMPARISON_BY_IDS =	2;
	public static int  QUERY_FROM_COMPARISON_HISTORY =	3;

	private ComparisonVO  comparisonVO;
	private ArrayList<ComparisonVO> listComparison=new ArrayList<ComparisonVO>();


	private int _operatorType=-1;
	private	String	ids = "";

	public ComparisonMQB(int operatorType,ComparisonVO  comparisonVO){
		_operatorType=operatorType;
		this.comparisonVO = comparisonVO;
		makeSql();
	}
	public ComparisonMQB(int operatorType, String	ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}
	private	void	makeSql(){
		StringBuffer strsql=new StringBuffer();
		strsql.append("select ID,compDetailID,meetingDetailID,meetingRoomID,upVideoQuality,downVideoQuality,upAudioQuality,downAudioQuality,sendPacketLoss,receivePacketLoss,sendframeRate,receiveframeRate,updateTime,updateUserID,result,status,description ");
		strsql.append(" from Z_T_MEETING_COMPARISON ");
		strsql.append(" where 1=1 ");	

		if (QUERY_FROM_COMPARISON == _operatorType) {
			if(null!=comparisonVO){
				if(!StringUtils.isNullOrBlank(comparisonVO.getID())){
					strsql.append(" and ID= ? ");
					super.addStringForField(comparisonVO.getID());
				}
				if(!StringUtils.isNullOrBlank(comparisonVO.getCompDetailID())){
					strsql.append(" and compDetailID= ? ");
					super.addStringForField(comparisonVO.getCompDetailID());
				}
				if(!StringUtils.isNullOrBlank(comparisonVO.getMeetingDetailID())){
					strsql.append(" and meetingDetailID= ? ");
					super.addStringForField(comparisonVO.getMeetingDetailID());
				}
				if(!StringUtils.isNullOrBlank(comparisonVO.getMeetingRoomID())){
					strsql.append(" and meetingRoomID= ? ");
					super.addStringForField(comparisonVO.getMeetingRoomID());
				}
				if(Integer.MIN_VALUE!=comparisonVO.getUpVideoQuality()){
					strsql.append(" and upVideoQuality= ? ");
					super.addIntForField(comparisonVO.getUpVideoQuality());
				}
				if(Integer.MIN_VALUE!=comparisonVO.getDownVideoQuality()){
					strsql.append(" and downVideoQuality= ? ");
					super.addIntForField(comparisonVO.getDownVideoQuality());
				}
				if(Integer.MIN_VALUE!=comparisonVO.getUpAudioQuality()){
					strsql.append(" and upAudioQuality= ? ");
					super.addIntForField(comparisonVO.getUpAudioQuality());
				}
				if(Integer.MIN_VALUE!=comparisonVO.getDownAudioQuality()){
					strsql.append(" and downAudioQuality= ? ");
					super.addIntForField(comparisonVO.getDownAudioQuality());
				}
				if(Float.MIN_VALUE!=comparisonVO.getSendPacketLoss()){
					strsql.append(" and sendPacketLoss= ? ");
					super.addFloatForField(comparisonVO.getSendPacketLoss());
				}
				if(Float.MIN_VALUE!=comparisonVO.getReceivePacketLoss()){
					strsql.append(" and receivePacketLoss= ? ");
					super.addFloatForField(comparisonVO.getReceivePacketLoss());
				}
				if(Integer.MIN_VALUE!=comparisonVO.getSendframeRate()){
					strsql.append(" and sendframeRate= ? ");
					super.addIntForField(comparisonVO.getSendframeRate());
				}
				if(Integer.MIN_VALUE!=comparisonVO.getReceiveframeRate()){
					strsql.append(" and receiveframeRate= ? ");
					super.addIntForField(comparisonVO.getReceiveframeRate());
				}
				if(!StringUtils.isNullOrBlank(comparisonVO.getUpdateUserID())){
					strsql.append(" and updateUserID= ? ");
					super.addStringForField(comparisonVO.getUpdateUserID());
				}
				if(Integer.MIN_VALUE!=comparisonVO.getResult()){
					strsql.append(" and result= ? ");
					super.addIntForField(comparisonVO.getResult());
				}
				if(Integer.MIN_VALUE!=comparisonVO.getStatus()){
					strsql.append(" and status= ? ");
					super.addIntForField(comparisonVO.getStatus());
				}
				if(!StringUtils.isNullOrBlank(comparisonVO.getDescription())){
					strsql.append(" and description= ? ");
					super.addStringForField(comparisonVO.getDescription());
				}
				
				strsql.append("  and  updateTime in (select  max(updateTime)  from Z_T_MEETING_COMPARISON where 1=1 ");
				if(!StringUtils.isNullOrBlank(comparisonVO.getMeetingDetailID())){
					strsql.append(" and meetingDetailID= ? ");
					super.addStringForField(comparisonVO.getMeetingDetailID());
				}
				if(!StringUtils.isNullOrBlank(comparisonVO.getMeetingRoomID())){
					strsql.append(" and meetingRoomID= ? ");
					super.addStringForField(comparisonVO.getMeetingRoomID());
				}
				
				if(!StringUtils.isNullOrBlank(comparisonVO.getStartTime())){
					strsql.append("and '"+comparisonVO.getStartTime()+"'< updateTime ");
					
				}
				if(!StringUtils.isNullOrBlank(comparisonVO.getEndTime())){
					strsql.append("and updateTime <'"+comparisonVO.getEndTime()+"'");
					
				}
				strsql.append(" GROUP BY meetingroomid ) ");
			}
			
			
		}
		else if (QUERY_FROM_COMPARISON_HISTORY == _operatorType) {
			if(null!=comparisonVO){
				if(!StringUtils.isNullOrBlank(comparisonVO.getID())){
					strsql.append(" and ID= ? ");
					super.addStringForField(comparisonVO.getID());
				}
				if(!StringUtils.isNullOrBlank(comparisonVO.getCompDetailID())){
					strsql.append(" and compDetailID= ? ");
					super.addStringForField(comparisonVO.getCompDetailID());
				}
				if(!StringUtils.isNullOrBlank(comparisonVO.getMeetingDetailID())){
					strsql.append(" and meetingDetailID= ? ");
					super.addStringForField(comparisonVO.getMeetingDetailID());
				}
				if(!StringUtils.isNullOrBlank(comparisonVO.getMeetingRoomID())){
					strsql.append(" and meetingRoomID= ? ");
					super.addStringForField(comparisonVO.getMeetingRoomID());
				}
				if(Integer.MIN_VALUE!=comparisonVO.getUpVideoQuality()){
					strsql.append(" and upVideoQuality= ? ");
					super.addIntForField(comparisonVO.getUpVideoQuality());
				}
				if(Integer.MIN_VALUE!=comparisonVO.getDownVideoQuality()){
					strsql.append(" and downVideoQuality= ? ");
					super.addIntForField(comparisonVO.getDownVideoQuality());
				}
				if(Integer.MIN_VALUE!=comparisonVO.getUpAudioQuality()){
					strsql.append(" and upAudioQuality= ? ");
					super.addIntForField(comparisonVO.getUpAudioQuality());
				}
				if(Integer.MIN_VALUE!=comparisonVO.getDownAudioQuality()){
					strsql.append(" and downAudioQuality= ? ");
					super.addIntForField(comparisonVO.getDownAudioQuality());
				}
				if(Float.MIN_VALUE!=comparisonVO.getSendPacketLoss()){
					strsql.append(" and sendPacketLoss= ? ");
					super.addFloatForField(comparisonVO.getSendPacketLoss());
				}
				if(Float.MIN_VALUE!=comparisonVO.getReceivePacketLoss()){
					strsql.append(" and receivePacketLoss= ? ");
					super.addFloatForField(comparisonVO.getReceivePacketLoss());
				}
				if(Integer.MIN_VALUE!=comparisonVO.getSendframeRate()){
					strsql.append(" and sendframeRate= ? ");
					super.addIntForField(comparisonVO.getSendframeRate());
				}
				if(Integer.MIN_VALUE!=comparisonVO.getReceiveframeRate()){
					strsql.append(" and receiveframeRate= ? ");
					super.addIntForField(comparisonVO.getReceiveframeRate());
				}
				if(!StringUtils.isNullOrBlank(comparisonVO.getUpdateUserID())){
					strsql.append(" and updateUserID= ? ");
					super.addStringForField(comparisonVO.getUpdateUserID());
				}
				if(Integer.MIN_VALUE!=comparisonVO.getResult()){
					strsql.append(" and result= ? ");
					super.addIntForField(comparisonVO.getResult());
				}
				if(Integer.MIN_VALUE!=comparisonVO.getStatus()){
					strsql.append(" and status= ? ");
					super.addIntForField(comparisonVO.getStatus());
				}
				if(!StringUtils.isNullOrBlank(comparisonVO.getDescription())){
					strsql.append(" and description= ? ");
					super.addStringForField(comparisonVO.getDescription());
				}
				if(!StringUtils.isNullOrBlank(comparisonVO.getMeetingDetailID())){
					strsql.append(" and meetingDetailID= ? ");
					super.addStringForField(comparisonVO.getMeetingDetailID());
				}
				if(!StringUtils.isNullOrBlank(comparisonVO.getMeetingRoomID())){
					strsql.append(" and meetingRoomID= ? ");
					super.addStringForField(comparisonVO.getMeetingRoomID());
				}
				
				if(!StringUtils.isNullOrBlank(comparisonVO.getStartTime())){
					strsql.append("and '"+comparisonVO.getStartTime()+"'< updateTime ");
					
				}
				if(!StringUtils.isNullOrBlank(comparisonVO.getEndTime())){
					strsql.append("and updateTime <'"+comparisonVO.getEndTime()+"'");
					
				}
				
			}
			
			
			
		}	
		else if (QUERY_FROM_COMPARISON_BY_IDS == _operatorType) {
			strsql.append(" and ID in (?) ");
			super.addStringForField(ids);
		}
		setSql(strsql.toString());
	}

	public void setSql(String sqlstr){
		this.sqlStr=sqlstr;
	}

	public String getSql(){
		return this.sqlStr;
	}
	public void getDataForRow(ResultSet rs) throws SQLException {
		comparisonVO=new ComparisonVO();
		comparisonVO.setID(rs.getString("ID"));
		comparisonVO.setCompDetailID(rs.getString("compDetailID"));
		comparisonVO.setMeetingDetailID(rs.getString("meetingDetailID"));
		comparisonVO.setMeetingRoomID(rs.getString("meetingRoomID"));
		comparisonVO.setUpVideoQuality(rs.getInt("upVideoQuality"));
		comparisonVO.setDownVideoQuality(rs.getInt("downVideoQuality"));
		comparisonVO.setUpAudioQuality(rs.getInt("upAudioQuality"));
		comparisonVO.setDownAudioQuality(rs.getInt("downAudioQuality"));
		comparisonVO.setSendPacketLoss(rs.getFloat("sendPacketLoss"));
		comparisonVO.setReceivePacketLoss(rs.getFloat("receivePacketLoss"));
		comparisonVO.setSendframeRate(rs.getInt("sendframeRate"));
		comparisonVO.setReceiveframeRate(rs.getInt("receiveframeRate"));
		comparisonVO.setUpdateTime(rs.getTimestamp("updateTime"));
		comparisonVO.setUpdateUserID(rs.getString("updateUserID"));
		comparisonVO.setResult(rs.getInt("result"));
		comparisonVO.setStatus(rs.getInt("status"));
		comparisonVO.setDescription(rs.getString("description"));
		listComparison.add(comparisonVO);
	}

	public ArrayList<ComparisonVO> getComparisonList(){
		return listComparison;
	}
	public ComparisonVO getComparisonVO(){
		return comparisonVO;
	}

}



