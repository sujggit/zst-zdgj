package com.zzst.dao.meeting.VideoCard;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.videoCard.VideoCardVO;

/**
 * class description:	VideoCard MQB
 * @date Mon May 13 10:45:05 CST 2013
 * @author ryan
 */
public class VideoCardMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(VideoCardMQB.class.getName());

	public static int  QUERY_FROM_VIDEOCARD		=	1;
	public static int  QUERY_FROM_VIDEOCARD_BY_IDS =	2;

	private VideoCardVO  videoCardVO;
	private ArrayList<VideoCardVO> listVideoCard=new ArrayList<VideoCardVO>();


	private int _operatorType=-1;
	private	String	ids = "";

	public VideoCardMQB(int operatorType,VideoCardVO  videoCardVO){
		_operatorType=operatorType;
		this.videoCardVO = videoCardVO;
		makeSql();
	}
	public VideoCardMQB(int operatorType, String	ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}
	private	void	makeSql(){
		StringBuffer strsql=new StringBuffer();
		strsql.append("select equipmentID,appraisalTaskNum,showFormatFlag,outputModel,appraisalModel,collectModel,loginPassword,loginName,inputModel,description,revision ");
		strsql.append(" from Z_T_EQUIPMENT_VIDEOCARD ");
		strsql.append(" where 1=1 ");	

		if (QUERY_FROM_VIDEOCARD == _operatorType) {
			if(null!=videoCardVO){
				if(!StringUtils.isNullOrBlank(videoCardVO.getEquipmentID())){
					strsql.append(" and equipmentID= ? ");
					super.addStringForField(videoCardVO.getEquipmentID());
				}
				if(!StringUtils.isNullOrBlank(videoCardVO.getAppraisalTaskNum())){
					strsql.append(" and appraisalTaskNum= ? ");
					super.addStringForField(videoCardVO.getAppraisalTaskNum());
				}
				if(!StringUtils.isNullOrBlank(videoCardVO.getShowFormatFlag())){
					strsql.append(" and showFormatFlag= ? ");
					super.addStringForField(videoCardVO.getShowFormatFlag());
				}
				if(!StringUtils.isNullOrBlank(videoCardVO.getOutputModel())){
					strsql.append(" and outputModel= ? ");
					super.addStringForField(videoCardVO.getOutputModel());
				}
				if(!StringUtils.isNullOrBlank(videoCardVO.getAppraisalModel())){
					strsql.append(" and appraisalModel= ? ");
					super.addStringForField(videoCardVO.getAppraisalModel());
				}
				if(!StringUtils.isNullOrBlank(videoCardVO.getCollectModel())){
					strsql.append(" and collectModel= ? ");
					super.addStringForField(videoCardVO.getCollectModel());
				}
				if(!StringUtils.isNullOrBlank(videoCardVO.getLoginPassWord())){
					strsql.append(" and loginPassword= ? ");
					super.addStringForField(videoCardVO.getLoginPassWord());
				}
				if(!StringUtils.isNullOrBlank(videoCardVO.getLoginName())){
					strsql.append(" and loginName= ? ");
					super.addStringForField(videoCardVO.getLoginName());
				}
				if(!StringUtils.isNullOrBlank(videoCardVO.getInputModel())){
					strsql.append(" and inputModel= ? ");
					super.addStringForField(videoCardVO.getInputModel());
				}
				if(!StringUtils.isNullOrBlank(videoCardVO.getDescription())){
					strsql.append(" and description= ? ");
					super.addStringForField(videoCardVO.getDescription());
				}
				if(Long.MIN_VALUE != videoCardVO.getRevision()){
					strsql.append(" and revision= ? ");
					super.addLongForField(videoCardVO.getRevision());
				}
			}
		}else if (QUERY_FROM_VIDEOCARD_BY_IDS == _operatorType) {
			strsql.append(" and equipmentID in (?) ");
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
		videoCardVO=new VideoCardVO();
		videoCardVO.setEquipmentID(rs.getString("equipmentID"));
		videoCardVO.setAppraisalTaskNum(rs.getString("appraisalTaskNum"));
		videoCardVO.setShowFormatFlag(rs.getString("showFormatFlag"));
		videoCardVO.setOutputModel(rs.getString("outputModel"));
		videoCardVO.setAppraisalModel(rs.getString("appraisalModel"));
		videoCardVO.setCollectModel(rs.getString("collectModel"));
		videoCardVO.setLoginPassWord(rs.getString("loginPassword"));
		videoCardVO.setLoginName(rs.getString("loginName"));
		videoCardVO.setInputModel(rs.getString("inputModel"));
		videoCardVO.setDescription(rs.getString("description"));
		videoCardVO.setRevision(rs.getLong("revision"));
		listVideoCard.add(videoCardVO);
	}

	public ArrayList<VideoCardVO> getVideoCardList(){
		return listVideoCard;
	}
	public VideoCardVO getVideoCardVO(){
		return videoCardVO;
	}

}



