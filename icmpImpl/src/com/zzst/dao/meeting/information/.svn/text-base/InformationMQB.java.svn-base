package com.zzst.dao.meeting.information;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.swh.db.model.DBFields;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.information.InformationVO;

/**
 * class description:	Information MQB
 * @date Tue Jan 29 18:25:43 CST 2013
 * @author ryan
 */
public class InformationMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(InformationMQB.class.getName());

	public static int  QUERY_FROM_INFORMATION		=	1;
	public static int  QUERY_FROM_INFORMATION_BY_IDS =	2;
	public static int  QUERY_FROM_INFORMATION_OPER = 3;

	private InformationVO  informationVO;
	private ArrayList<InformationVO> listInformation=new ArrayList<InformationVO>();


	private int _operatorType=-1;
	private	String	ids = "";

	public InformationMQB(int operatorType,InformationVO  informationVO){
		_operatorType=operatorType;
		this.informationVO = informationVO;
		makeSql();
	}
	public InformationMQB(int operatorType, String	ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}
	private	void	makeSql(){
		StringBuffer strsql=new StringBuffer();
		strsql.append("select infoID,infoType,title,content,createTime,status,description, ");
		strsql.append("sourceName,meetingDetailId,rank,scanStatus");
		
		 
		strsql.append(" from z_t_information ");
		strsql.append(" where 1=1 ");	

		if (QUERY_FROM_INFORMATION == _operatorType) {
			if(null!=informationVO){
				if(!StringUtils.isNullOrBlank(informationVO.getInfoID())){
					strsql.append(" and infoID= ? ");
					super.addStringForField(informationVO.getInfoID());
				}
				if(Integer.MIN_VALUE!=informationVO.getInfoType()){
					strsql.append(" and infoType= ? ");
					super.addIntForField(informationVO.getInfoType());
				}
				if(!StringUtils.isNullOrBlank(informationVO.getTitle())){
					strsql.append(" and title= ? ");
					super.addStringForField(informationVO.getTitle());
				}
				if(!StringUtils.isNullOrBlank(informationVO.getContent())){
					strsql.append(" and content= ? ");
					super.addStringForField(informationVO.getContent());
				}
//				if(!StringUtils.isNullOrBlank(informationVO.getCreateUserID())){
//					strsql.append(" and createUserID= ? ");
//					super.addStringForField(informationVO.getCreateUserID());
//				}
				if(!StringUtils.isNullOrBlank(informationVO.getSourceName())){
					strsql.append(" and sourceName= ? ");
					super.addStringForField(informationVO.getSourceName());
				}
				
				if(!StringUtils.isNullOrBlank(informationVO.getMeetingDetailId())){
					strsql.append(" and meetingDetailId= ? ");
					super.addStringForField(informationVO.getMeetingDetailId());
				}
				
				if(Integer.MIN_VALUE!=informationVO.getRank()){
					strsql.append(" and rank= ? ");
					super.addIntForField(informationVO.getRank());
				}
				
				if(Integer.MIN_VALUE!=informationVO.getScanStatus()){
					strsql.append(" and scanStatus= ? ");
					super.addIntForField(informationVO.getScanStatus());
				}
				
				if(Integer.MIN_VALUE!=informationVO.getStatus()){
					strsql.append(" and status= ? ");
					super.addIntForField(informationVO.getStatus());
				}
				if(!StringUtils.isNullOrBlank(informationVO.getDescription())){
					strsql.append(" and description= ? ");
					super.addStringForField(informationVO.getDescription());
				}
				else {
					if(informationVO.getStartTime()!= null){
						strsql.append(" and createTime>'" + informationVO.getStartTime()+"'");
					}
					if(informationVO.getEndTime()!= null){
						strsql.append(" and createTime<'" + informationVO.getEndTime()+"'");
					}
				}
				
			}
		}else if (QUERY_FROM_INFORMATION_BY_IDS == _operatorType) {
			strsql.append(" and infoID in (?) ");
			super.addStringForField(ids);
		}else if (QUERY_FROM_INFORMATION_OPER == _operatorType){
			if(null!=informationVO){
				if(!StringUtils.isNullOrBlank(informationVO.getInfoID())){
					strsql.append(" and infoID= ? ");
					super.addStringForField(informationVO.getInfoID());
				}
				if(Integer.MIN_VALUE!=informationVO.getInfoType()){
					strsql.append(" and infoType= ? ");
					super.addIntForField(informationVO.getInfoType());
				}
				if(!StringUtils.isNullOrBlank(informationVO.getTitle())){
					strsql.append(" and title= ? ");
					super.addStringForField(informationVO.getTitle());
				}
				if(!StringUtils.isNullOrBlank(informationVO.getContent())){
					strsql.append(" and content= ? ");
					super.addStringForField(informationVO.getContent());
				}
//				if(!StringUtils.isNullOrBlank(informationVO.getCreateUserID())){
//					strsql.append(" and createUserID= ? ");
//					super.addStringForField(informationVO.getCreateUserID());
//				}
				if(!StringUtils.isNullOrBlank(informationVO.getSourceName())){
					strsql.append(" and sourceName= ? ");
					super.addStringForField(informationVO.getSourceName());
				}
				
				if(!StringUtils.isNullOrBlank(informationVO.getMeetingDetailId())){
					strsql.append(" and meetingDetailId= ? ");
					super.addStringForField(informationVO.getMeetingDetailId());
				}
				
				if(Integer.MIN_VALUE!=informationVO.getRank()){
					strsql.append(" and rank= ? ");
					super.addIntForField(informationVO.getRank());
				}
				
				if(Integer.MIN_VALUE!=informationVO.getScanStatus()){
					strsql.append(" and scanStatus= ? ");
					super.addIntForField(informationVO.getScanStatus());
				}
				
				if(Integer.MIN_VALUE!=informationVO.getStatus()){
					strsql.append(" and status= ? ");
					super.addIntForField(informationVO.getStatus());
				}
				if(!StringUtils.isNullOrBlank(informationVO.getDescription())){
					strsql.append(" and description= ? ");
					super.addStringForField(informationVO.getDescription());
				}
				if(informationVO.getCreateTime()!=null){
					strsql.append(" order by createTime= ? ");
					super.addTimestampForField(informationVO.getCreateTime());
				}
			}
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
		informationVO=new InformationVO();
		informationVO.setInfoID(rs.getString("infoID"));
		informationVO.setInfoType(rs.getInt("infoType"));
		informationVO.setTitle(rs.getString("title"));
		informationVO.setContent(rs.getString("content"));
		informationVO.setCreateUserID(rs.getString("sourceName"));
		informationVO.setCreateTime(rs.getTimestamp("createTime"));
		informationVO.setStatus(rs.getInt("status"));
		informationVO.setDescription(rs.getString("description"));
		
		informationVO.setSourceName(rs.getString("sourceName"));
		informationVO.setMeetingDetailId(rs.getString("meetingDetailId"));
		informationVO.setRank(rs.getInt("rank"));
		informationVO.setScanStatus(rs.getInt("scanStatus"));
		
		listInformation.add(informationVO);
	}

	public ArrayList<InformationVO> getInformationList(){
		return listInformation;
	}
	public InformationVO getInformationVO(){
		return informationVO;
	}

}



