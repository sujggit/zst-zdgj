package com.zzst.dao.project.avic.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.enums.ApplyEnum;
import com.zzst.model.meeting.apply.flow.ApplyFlowVO;
import com.zzst.model.project.avic.service.AvicServiceVO;

/**
 * class description: AvicService MQB
 * 
 * @date Thu Sep 20 15:23:06 CST 2012
 * @author ryan
 */
public class AvicServiceMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(AvicServiceMQB.class.getName());

	public static int QUERY_FROM_AVICSERVICE = 1;
	public static int QUERY_FROM_AVICSERVICE_BY_IDS = 2;
	public static int QUERY_FROM_BY_USERID = 3 ;
	public static int QUERY_HISTORY = 4;
	public static int QUERY_HISTORY_ALL = 5;
	private AvicServiceVO avicServiceVO;
	private ApplyFlowVO applyFlowVO;
	private ArrayList<AvicServiceVO> listAvicService = new ArrayList<AvicServiceVO>();

	private int _operatorType = -1;
	private String ids = "";

	public AvicServiceMQB(int operatorType, AvicServiceVO avicServiceVO) {
		_operatorType = operatorType;
		this.avicServiceVO = avicServiceVO;
		makeSql();
	}

	public AvicServiceMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}
	
	public AvicServiceMQB(int operatorType, AvicServiceVO avicServiceVO ,  String ids) {
		_operatorType = operatorType;
		this.avicServiceVO = avicServiceVO;
		this.ids = ids;
		makeSql();
	}
	
	public AvicServiceMQB(int operatorType, AvicServiceVO avicServiceVO , ApplyFlowVO applyFlowVO , String ids) {
		_operatorType = operatorType;
		this.avicServiceVO = avicServiceVO;
		this.ids = ids;
		this.applyFlowVO = applyFlowVO;
		makeSql();
	}
	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		if (QUERY_FROM_BY_USERID == _operatorType) {
			strsql.append("select ats.recordID,ats.departmentID,ats.departmentName,ats.departmentCode,ats.meetingDetailID,ats.meetingDetailName,ats.headQuarterLeaderNumber,ats.departmentLeaderNumber,ats.headQuarterEastNumber,ats.headQuarterWestNumber,ats.jinHangNetWorkNumber,ats.otherVenueNumber,ats.netWorkNumber,ats.recordService,ats.otherDes,ats.realityVenueNumber,ats.realityPersonnelNumber,ats.venuePrincipal,ats.createUserID,ats.createTime,ats.status,ats.revision,ats.description ,ats.flowId");
			strsql.append(" from avic_t_service ats ,z_t_apply_detail ad");
			strsql.append(" where 1=1 and ad.status="+ApplyEnum.STATUS_ING+" and ats.recordID=ad.applyDetailID and ats.status!="+ApplyEnum.STATUS_REJECT);
			strsql.append(" and ad.checkUserIDs like '%," + ids + ",%'");
			if (null != avicServiceVO) {
				if (!StringUtils.isNullOrBlank(avicServiceVO.getRecordID())) {
					strsql.append(" and ats.recordID= ? ");
					super.addStringForField(avicServiceVO.getRecordID());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getDepartmentID())) {
					strsql.append(" and ats.departmentID= ? ");
					super.addStringForField(avicServiceVO.getDepartmentID());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getDepartmentName())) {
					strsql.append(" and ats.departmentName like ? ");
					super.addStringForField("%" + avicServiceVO.getDepartmentName() +"%");
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getDepartmentCode())) {
					strsql.append(" and ats.departmentCode= ? ");
					super.addStringForField(avicServiceVO.getDepartmentCode());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getMeetingDetailID())) {
					strsql.append(" and ats.meetingDetailID= ? ");
					super.addStringForField(avicServiceVO.getMeetingDetailID());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getMeetingDetailName())) {
					strsql.append(" and ats.meetingDetailName like ? ");
					super.addStringForField("%"+avicServiceVO.getMeetingDetailName()+"%");
				}
				if (Integer.MIN_VALUE != avicServiceVO.getHeadQuarterLeaderNumber()) {
					strsql.append(" and ats.headQuarterLeaderNumber= ? ");
					super.addIntForField(avicServiceVO
							.getHeadQuarterLeaderNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getDepartmentLeaderNumber()) {
					strsql.append(" and ats.departmentLeaderNumber= ? ");
					super.addIntForField(avicServiceVO
							.getDepartmentLeaderNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getHeadQuarterEastNumber()) {
					strsql.append(" and ats.headQuarterEastNumber= ? ");
					super.addIntForField(avicServiceVO
							.getHeadQuarterEastNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getHeadQuarterWestNumber()) {
					strsql.append(" and ats.headQuarterWestNumber= ? ");
					super.addIntForField(avicServiceVO
							.getHeadQuarterWestNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getJinHangNetWorkNumber()) {
					strsql.append(" and ats.jinHangNetWorkNumber= ? ");
					super.addIntForField(avicServiceVO
							.getJinHangNetWorkNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getOtherVenueNumber()) {
					strsql.append(" and ats.otherVenueNumber= ? ");
					super.addIntForField(avicServiceVO.getOtherVenueNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getNetWorkNumber()) {
					strsql.append(" and ats.netWorkNumber= ? ");
					super.addIntForField(avicServiceVO.getNetWorkNumber());
				}
				if (!StringUtils
						.isNullOrBlank(avicServiceVO.getRecordService())) {
					strsql.append(" and ats.recordService= ? ");
					super.addStringForField(avicServiceVO.getRecordService());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getOtherDes())) {
					strsql.append(" and ats.otherDes= ? ");
					super.addStringForField(avicServiceVO.getOtherDes());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getRealityVenueNumber()) {
					strsql.append(" and ats.realityVenueNumber= ? ");
					super.addIntForField(avicServiceVO.getRealityVenueNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO
						.getRealityPersonnelNumber()) {
					strsql.append(" and ats.realityPersonnelNumber= ? ");
					super.addIntForField(avicServiceVO
							.getRealityPersonnelNumber());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO
						.getVenuePrincipal())) {
					strsql.append(" and ats.venuePrincipal= ? ");
					super.addStringForField(avicServiceVO.getVenuePrincipal());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getCreateUserID())) {
					strsql.append(" and ats.createUserID= ? ");
					super.addStringForField(avicServiceVO.getCreateUserID());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getStatus()) {
					strsql.append(" and ats.status= ? ");
					super.addIntForField(avicServiceVO.getStatus());
				}
				if (Long.MIN_VALUE != avicServiceVO.getRevision()) {
					strsql.append(" and ats.revision= ? ");
					super.addLongForField(avicServiceVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getDescription())) {
					strsql.append(" and ats.description= ? ");
					super.addStringForField(avicServiceVO.getDescription());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getFlowId())) {
					strsql.append(" and ats.flowId= ? ");
					super.addStringForField(avicServiceVO.getFlowId());
				}
			}
			strsql.append(" group by ats.recordID order by ats.createTime desc");
		}else if(QUERY_HISTORY == _operatorType) {
			strsql.append("select ats.recordID,ats.departmentID,ats.departmentName,ats.departmentCode,ats.meetingDetailID,ats.meetingDetailName,ats.headQuarterLeaderNumber,ats.departmentLeaderNumber,ats.headQuarterEastNumber,ats.headQuarterWestNumber,ats.jinHangNetWorkNumber,ats.otherVenueNumber,ats.netWorkNumber,ats.recordService,ats.otherDes,ats.realityVenueNumber,ats.realityPersonnelNumber,ats.venuePrincipal,ats.createUserID,ats.createTime,ats.status,ats.revision,ats.description ,ats.flowId ");
			strsql.append("from avic_t_service ats , z_t_apply_detail ad ");
			strsql.append("where 1=1 and ats.recordID = ad.applyDetailID and ad.userId = ? ");
			super.addStringForField(ids);
			if (null != avicServiceVO) {
				if (!StringUtils.isNullOrBlank(avicServiceVO.getRecordID())) {
					strsql.append(" and ats.recordID= ? ");
					super.addStringForField(avicServiceVO.getRecordID());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getDepartmentID())) {
					strsql.append(" and ats.departmentID= ? ");
					super.addStringForField(avicServiceVO.getDepartmentID());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getDepartmentName())) {
					strsql.append(" and ats.departmentName like ? ");
					super.addStringForField("%" + avicServiceVO.getDepartmentName() +"%");
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getDepartmentCode())) {
					strsql.append(" and ats.departmentCode= ? ");
					super.addStringForField(avicServiceVO.getDepartmentCode());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getMeetingDetailID())) {
					strsql.append(" and ats.meetingDetailID= ? ");
					super.addStringForField(avicServiceVO.getMeetingDetailID());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getMeetingDetailName())) {
					strsql.append(" and ats.meetingDetailName like ? ");
					super.addStringForField("%"+avicServiceVO.getMeetingDetailName()+"%");
				}
				if (Integer.MIN_VALUE != avicServiceVO.getHeadQuarterLeaderNumber()) {
					strsql.append(" and ats.headQuarterLeaderNumber= ? ");
					super.addIntForField(avicServiceVO
							.getHeadQuarterLeaderNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getDepartmentLeaderNumber()) {
					strsql.append(" and ats.departmentLeaderNumber= ? ");
					super.addIntForField(avicServiceVO
							.getDepartmentLeaderNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getHeadQuarterEastNumber()) {
					strsql.append(" and ats.headQuarterEastNumber= ? ");
					super.addIntForField(avicServiceVO
							.getHeadQuarterEastNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getHeadQuarterWestNumber()) {
					strsql.append(" and ats.headQuarterWestNumber= ? ");
					super.addIntForField(avicServiceVO
							.getHeadQuarterWestNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getJinHangNetWorkNumber()) {
					strsql.append(" and ats.jinHangNetWorkNumber= ? ");
					super.addIntForField(avicServiceVO
							.getJinHangNetWorkNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getOtherVenueNumber()) {
					strsql.append(" and ats.otherVenueNumber= ? ");
					super.addIntForField(avicServiceVO.getOtherVenueNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getNetWorkNumber()) {
					strsql.append(" and ats.netWorkNumber= ? ");
					super.addIntForField(avicServiceVO.getNetWorkNumber());
				}
				if (!StringUtils
						.isNullOrBlank(avicServiceVO.getRecordService())) {
					strsql.append(" and ats.recordService= ? ");
					super.addStringForField(avicServiceVO.getRecordService());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getOtherDes())) {
					strsql.append(" and ats.otherDes= ? ");
					super.addStringForField(avicServiceVO.getOtherDes());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getRealityVenueNumber()) {
					strsql.append(" and ats.realityVenueNumber= ? ");
					super.addIntForField(avicServiceVO.getRealityVenueNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO
						.getRealityPersonnelNumber()) {
					strsql.append(" and ats.realityPersonnelNumber= ? ");
					super.addIntForField(avicServiceVO
							.getRealityPersonnelNumber());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO
						.getVenuePrincipal())) {
					strsql.append(" and ats.venuePrincipal= ? ");
					super.addStringForField(avicServiceVO.getVenuePrincipal());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getCreateUserID())) {
					strsql.append(" and ats.createUserID= ? ");
					super.addStringForField(avicServiceVO.getCreateUserID());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getStatus()) {
					strsql.append(" and ats.status= ? ");
					super.addIntForField(avicServiceVO.getStatus());
				}
				if (Long.MIN_VALUE != avicServiceVO.getRevision()) {
					strsql.append(" and ats.revision= ? ");
					super.addLongForField(avicServiceVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getDescription())) {
					strsql.append(" and ats.description= ? ");
					super.addStringForField(avicServiceVO.getDescription());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getFlowId())) {
					strsql.append(" and ats.flowId= ? ");
					super.addStringForField(avicServiceVO.getFlowId());
				}
			}
			strsql.append(" group by ats.recordID order by ats.createTime desc");
		}else if(QUERY_HISTORY_ALL == _operatorType) {
			strsql.append("select ats.recordID,ats.departmentID,ats.departmentName,ats.departmentCode,ats.meetingDetailID,ats.meetingDetailName,ats.headQuarterLeaderNumber,ats.departmentLeaderNumber,ats.headQuarterEastNumber,ats.headQuarterWestNumber,ats.jinHangNetWorkNumber,ats.otherVenueNumber,ats.netWorkNumber,ats.recordService,ats.otherDes,ats.realityVenueNumber,ats.realityPersonnelNumber,ats.venuePrincipal,ats.createUserID,ats.createTime,ats.status,ats.revision,ats.description ,ats.flowId ");
			strsql.append("from avic_t_service ats , z_t_apply_detail ad ");
			strsql.append("where 1=1 and ats.recordID = ad.applyDetailID ");
			if (null != avicServiceVO) {
				if (!StringUtils.isNullOrBlank(avicServiceVO.getRecordID())) {
					strsql.append(" and ats.recordID= ? ");
					super.addStringForField(avicServiceVO.getRecordID());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getDepartmentID())) {
					strsql.append(" and ats.departmentID= ? ");
					super.addStringForField(avicServiceVO.getDepartmentID());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getDepartmentName())) {
					strsql.append(" and ats.departmentName like ? ");
					super.addStringForField("%" + avicServiceVO.getDepartmentName().trim() +"%");
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getDepartmentCode())) {
					strsql.append(" and ats.departmentCode= ? ");
					super.addStringForField(avicServiceVO.getDepartmentCode());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getMeetingDetailID())) {
					strsql.append(" and ats.meetingDetailID= ? ");
					super.addStringForField(avicServiceVO.getMeetingDetailID());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getMeetingDetailName())) {
					strsql.append(" and ats.meetingDetailName like ? ");
					super.addStringForField("%"+avicServiceVO.getMeetingDetailName()+"%");
				}
				if (Integer.MIN_VALUE != avicServiceVO.getHeadQuarterLeaderNumber()) {
					strsql.append(" and ats.headQuarterLeaderNumber= ? ");
					super.addIntForField(avicServiceVO
							.getHeadQuarterLeaderNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getDepartmentLeaderNumber()) {
					strsql.append(" and ats.departmentLeaderNumber= ? ");
					super.addIntForField(avicServiceVO
							.getDepartmentLeaderNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getHeadQuarterEastNumber()) {
					strsql.append(" and ats.headQuarterEastNumber= ? ");
					super.addIntForField(avicServiceVO
							.getHeadQuarterEastNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getHeadQuarterWestNumber()) {
					strsql.append(" and ats.headQuarterWestNumber= ? ");
					super.addIntForField(avicServiceVO
							.getHeadQuarterWestNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getJinHangNetWorkNumber()) {
					strsql.append(" and ats.jinHangNetWorkNumber= ? ");
					super.addIntForField(avicServiceVO
							.getJinHangNetWorkNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getOtherVenueNumber()) {
					strsql.append(" and ats.otherVenueNumber= ? ");
					super.addIntForField(avicServiceVO.getOtherVenueNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getNetWorkNumber()) {
					strsql.append(" and ats.netWorkNumber= ? ");
					super.addIntForField(avicServiceVO.getNetWorkNumber());
				}
				if (!StringUtils
						.isNullOrBlank(avicServiceVO.getRecordService())) {
					strsql.append(" and ats.recordService= ? ");
					super.addStringForField(avicServiceVO.getRecordService());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getOtherDes())) {
					strsql.append(" and ats.otherDes= ? ");
					super.addStringForField(avicServiceVO.getOtherDes());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getRealityVenueNumber()) {
					strsql.append(" and ats.realityVenueNumber= ? ");
					super.addIntForField(avicServiceVO.getRealityVenueNumber());
				}
				if (Integer.MIN_VALUE != avicServiceVO
						.getRealityPersonnelNumber()) {
					strsql.append(" and ats.realityPersonnelNumber= ? ");
					super.addIntForField(avicServiceVO
							.getRealityPersonnelNumber());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO
						.getVenuePrincipal())) {
					strsql.append(" and ats.venuePrincipal= ? ");
					super.addStringForField(avicServiceVO.getVenuePrincipal());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getCreateUserID())) {
					strsql.append(" and ats.createUserID= ? ");
					super.addStringForField(avicServiceVO.getCreateUserID());
				}
				if (Integer.MIN_VALUE != avicServiceVO.getStatus()) {
					strsql.append(" and ats.status= ? ");
					super.addIntForField(avicServiceVO.getStatus());
				}
				if (Long.MIN_VALUE != avicServiceVO.getRevision()) {
					strsql.append(" and ats.revision= ? ");
					super.addLongForField(avicServiceVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getDescription())) {
					strsql.append(" and ats.description= ? ");
					super.addStringForField(avicServiceVO.getDescription());
				}
				if (!StringUtils.isNullOrBlank(avicServiceVO.getFlowId())) {
					strsql.append(" and ats.flowId= ? ");
					super.addStringForField(avicServiceVO.getFlowId());
				}
			}
			strsql.append(" group by ats.recordID order by ats.createTime desc");
		}else{
			strsql.append("select recordID,departmentID,departmentName,departmentCode,meetingDetailID,meetingDetailName,headQuarterLeaderNumber,departmentLeaderNumber,headQuarterEastNumber,headQuarterWestNumber,jinHangNetWorkNumber,otherVenueNumber,netWorkNumber,recordService,otherDes,realityVenueNumber,realityPersonnelNumber,venuePrincipal,createUserID,createTime,status,revision,description,flowId ");
			strsql.append(" from avic_t_service ");
			strsql.append(" where 1=1 ");
	
			if (QUERY_FROM_AVICSERVICE == _operatorType) {
				if (null != avicServiceVO) {
					if (!StringUtils.isNullOrBlank(avicServiceVO.getRecordID())) {
						strsql.append(" and recordID= ? ");
						super.addStringForField(avicServiceVO.getRecordID());
					}
					if (!StringUtils.isNullOrBlank(avicServiceVO.getDepartmentID())) {
						strsql.append(" and departmentID= ? ");
						super.addStringForField(avicServiceVO.getDepartmentID());
					}
					if (!StringUtils.isNullOrBlank(avicServiceVO.getDepartmentName())) {
						strsql.append(" and departmentName like ? ");
						super.addStringForField("%" + avicServiceVO.getDepartmentName() +"%");
					}
					if (!StringUtils.isNullOrBlank(avicServiceVO.getDepartmentCode())) {
						strsql.append(" and departmentCode= ? ");
						super.addStringForField(avicServiceVO.getDepartmentCode());
					}
					if (!StringUtils.isNullOrBlank(avicServiceVO.getMeetingDetailID())) {
						strsql.append(" and meetingDetailID= ? ");
						super.addStringForField(avicServiceVO.getMeetingDetailID());
					}
					if (!StringUtils.isNullOrBlank(avicServiceVO.getMeetingDetailName())) {
						strsql.append(" and meetingDetailName like ? ");
						super.addStringForField("%"+avicServiceVO.getMeetingDetailName()+"%");
					}
					if (Integer.MIN_VALUE != avicServiceVO.getHeadQuarterLeaderNumber()) {
						strsql.append(" and headQuarterLeaderNumber= ? ");
						super.addIntForField(avicServiceVO
								.getHeadQuarterLeaderNumber());
					}
					if (Integer.MIN_VALUE != avicServiceVO.getDepartmentLeaderNumber()) {
						strsql.append(" and departmentLeaderNumber= ? ");
						super.addIntForField(avicServiceVO
								.getDepartmentLeaderNumber());
					}
					if (Integer.MIN_VALUE != avicServiceVO.getHeadQuarterEastNumber()) {
						strsql.append(" and headQuarterEastNumber= ? ");
						super.addIntForField(avicServiceVO
								.getHeadQuarterEastNumber());
					}
					if (Integer.MIN_VALUE != avicServiceVO.getHeadQuarterWestNumber()) {
						strsql.append(" and headQuarterWestNumber= ? ");
						super.addIntForField(avicServiceVO
								.getHeadQuarterWestNumber());
					}
					if (Integer.MIN_VALUE != avicServiceVO.getJinHangNetWorkNumber()) {
						strsql.append(" and jinHangNetWorkNumber= ? ");
						super.addIntForField(avicServiceVO
								.getJinHangNetWorkNumber());
					}
					if (Integer.MIN_VALUE != avicServiceVO.getOtherVenueNumber()) {
						strsql.append(" and otherVenueNumber= ? ");
						super.addIntForField(avicServiceVO.getOtherVenueNumber());
					}
					if (Integer.MIN_VALUE != avicServiceVO.getNetWorkNumber()) {
						strsql.append(" and netWorkNumber= ? ");
						super.addIntForField(avicServiceVO.getNetWorkNumber());
					}
					if (!StringUtils
							.isNullOrBlank(avicServiceVO.getRecordService())) {
						strsql.append(" and recordService= ? ");
						super.addStringForField(avicServiceVO.getRecordService());
					}
					if (!StringUtils.isNullOrBlank(avicServiceVO.getOtherDes())) {
						strsql.append(" and otherDes= ? ");
						super.addStringForField(avicServiceVO.getOtherDes());
					}
					if (Integer.MIN_VALUE != avicServiceVO.getRealityVenueNumber()) {
						strsql.append(" and realityVenueNumber= ? ");
						super.addIntForField(avicServiceVO.getRealityVenueNumber());
					}
					if (Integer.MIN_VALUE != avicServiceVO
							.getRealityPersonnelNumber()) {
						strsql.append(" and realityPersonnelNumber= ? ");
						super.addIntForField(avicServiceVO
								.getRealityPersonnelNumber());
					}
					if (!StringUtils.isNullOrBlank(avicServiceVO
							.getVenuePrincipal())) {
						strsql.append(" and venuePrincipal= ? ");
						super.addStringForField(avicServiceVO.getVenuePrincipal());
					}
					if (!StringUtils.isNullOrBlank(avicServiceVO.getCreateUserID())) {
						strsql.append(" and createUserID= ? ");
						super.addStringForField(avicServiceVO.getCreateUserID());
					}
					if (Integer.MIN_VALUE != avicServiceVO.getStatus()) {
						strsql.append(" and status= ? ");
						super.addIntForField(avicServiceVO.getStatus());
					}
					if (Long.MIN_VALUE != avicServiceVO.getRevision()) {
						strsql.append(" and revision= ? ");
						super.addLongForField(avicServiceVO.getRevision());
					}
					if (!StringUtils.isNullOrBlank(avicServiceVO.getDescription())) {
						strsql.append(" and description= ? ");
						super.addStringForField(avicServiceVO.getDescription());
					}
					if (!StringUtils.isNullOrBlank(avicServiceVO.getFlowId())) {
						strsql.append(" and flowId= ? ");
						super.addStringForField(avicServiceVO.getFlowId());
					}
				}
			} else if (QUERY_FROM_AVICSERVICE_BY_IDS == _operatorType) {
				strsql.append(" and recordID in (?) ");
				super.addStringForField(ids);
			}
			strsql.append(" group by recordID order by createTime desc");
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
		avicServiceVO = new AvicServiceVO();
		avicServiceVO.setRecordID(rs.getString("recordID"));
		avicServiceVO.setDepartmentID(rs.getString("departmentID"));
		avicServiceVO.setDepartmentName(rs.getString("departmentName"));
		avicServiceVO.setDepartmentCode(rs.getString("departmentCode"));
		avicServiceVO.setMeetingDetailID(rs.getString("meetingDetailID"));
		avicServiceVO.setMeetingDetailName(rs.getString("meetingDetailName"));
		avicServiceVO.setHeadQuarterLeaderNumber(rs
				.getInt("headQuarterLeaderNumber"));
		avicServiceVO.setDepartmentLeaderNumber(rs
				.getInt("departmentLeaderNumber"));
		avicServiceVO.setHeadQuarterEastNumber(rs
				.getInt("headQuarterEastNumber"));
		avicServiceVO.setHeadQuarterWestNumber(rs
				.getInt("headQuarterWestNumber"));
		avicServiceVO
				.setJinHangNetWorkNumber(rs.getInt("jinHangNetWorkNumber"));
		avicServiceVO.setOtherVenueNumber(rs.getInt("otherVenueNumber"));
		avicServiceVO.setNetWorkNumber(rs.getInt("netWorkNumber"));
		avicServiceVO.setRecordService(rs.getString("recordService"));
		avicServiceVO.setOtherDes(rs.getString("otherDes"));
		avicServiceVO.setRealityVenueNumber(rs.getInt("realityVenueNumber"));
		avicServiceVO.setRealityPersonnelNumber(rs
				.getInt("realityPersonnelNumber"));
		avicServiceVO.setVenuePrincipal(rs.getString("venuePrincipal"));
		avicServiceVO.setCreateUserID(rs.getString("createUserID"));
		avicServiceVO.setCreateTime(rs.getTimestamp("createTime"));
		avicServiceVO.setStatus(rs.getInt("status"));
		avicServiceVO.setRevision(rs.getLong("revision"));
		avicServiceVO.setDescription(rs.getString("description"));
		avicServiceVO.setFlowId(rs.getString("flowId"));
		listAvicService.add(avicServiceVO);
	}

	public ArrayList<AvicServiceVO> getAvicServiceList() {
		return listAvicService;
	}

	public AvicServiceVO getAvicServiceVO() {
		return avicServiceVO;
	}

	public ApplyFlowVO getApplyFlowVO() {
		return applyFlowVO;
	}

}
