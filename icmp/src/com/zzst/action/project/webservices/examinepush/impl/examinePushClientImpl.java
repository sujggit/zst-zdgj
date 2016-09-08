package com.zzst.action.project.webservices.examinepush.impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.XPath;
import org.dom4j.Element;

import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.project.webservices.examinepush.TranslateXml;
import com.zzst.action.project.webservices.timer.xmlexaminePushClient;
import com.zzst.application.mcudao.common.UtilDAO;
import com.zzst.dao.meeting.apply.applyDetail.ApplyDetailDAO;
import com.zzst.dao.project.avic.applyConference.ApplyConferenceDAO;
import com.zzst.model.enums.ApplyEnum;
import com.zzst.model.meeting.apply.applyDetail.ApplyDetailVO;
import com.zzst.model.project.avic.applyConference.ApplyConferenceVO;

public class examinePushClientImpl   implements xmlexaminePushClient{
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(examinePushClientImpl.class.getName());

	private ApplyDetailDAO  applydetaildao;
	private ApplyConferenceDAO applyconferencedao;
	private static final Logger log = LogManager.getLogger(examinePushClientImpl.class);
	
	public ApplyConferenceDAO getApplyconferencedao() {
		return applyconferencedao;
	}
	public void setApplyconferencedao(ApplyConferenceDAO applyconferencedao) {
		this.applyconferencedao = applyconferencedao;
	}
	
	public ApplyDetailDAO getApplydetaildao() {
		return applydetaildao;
	}
	public void setApplydetaildao(ApplyDetailDAO applydetaildao) {
		this.applydetaildao = applydetaildao;
	}
	public static Logger getLog() {
		return log;
	}

	//运行解析
	public String getXml(String strXml) {
		logger.info("examinePushClientImpl	getXml	begin");
		logger.info("xml传入内容为："+strXml);
		String status=TranslateXml.getValue(strXml, "status");
		String id=TranslateXml.getValue(strXml, "applyId");
		try{
		 //占用时完成添加
			if(status.equals("0")||status.equals("5") ){
				ApplyConferenceVO vo=this.getApplyConferenceVOById(id);
				if(vo.getConferenceName()!=null){
					this.update(strXml);
				}else{
					this.add(strXml);
				}
			}
			
		    if(status.equals("1")||status.equals("3") ){
				ApplyConferenceVO vo=this.getApplyConferenceVOById(id);
				if(vo.getConferenceName()!=null) {
					this.updates(strXml);
			    }else{
					this.add(strXml);
					this.getUpdatedetail(strXml);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		logger.info("examinePushClientImpl	getXml	end");
		return strXml;
	}
	
	//第一种情况修改
	@SuppressWarnings({ "static-access"})
	public String add(String strXml) throws ParseException{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<ApplyConferenceVO> deptList = new ArrayList<ApplyConferenceVO>();
		String applyId=TranslateXml.getValue(strXml, "applyId");
		String departmentId=TranslateXml.getValue(strXml, "departmentId");
		String departmentName=TranslateXml.getValue(strXml, "departmentName");
		String departmentCode=TranslateXml.getValue(strXml, "departmentCode");
		String linkManID=TranslateXml.getValue(strXml, "linkManID");
		String linkManName=TranslateXml.getValue(strXml, "linkManName");
		String linkManPhone=TranslateXml.getValue(strXml, "linkManPhone");   
		String linkManFax=TranslateXml.getValue(strXml, "linkManFax");
		String linkManCellPhone=TranslateXml.getValue(strXml, "linkManCellPhone");
		String security=TranslateXml.getValue(strXml, "security");
		String startTime=TranslateXml.getValue(strXml, "startTime");
		String endTime=TranslateXml.getValue(strXml, "endTime");
		String conferenceName=TranslateXml.getValue(strXml, "conferenceName");
		String conferenceAgenda=TranslateXml.getValue(strXml, "conferenceAgenda");
		String countNumber=TranslateXml.getValue(strXml, "countNumber");
		String departmentGroupLeadIdS=TranslateXml.getValue(strXml, "departmentGroupLeadIdS");
		String departmentGroupLeadNameS=TranslateXml.getValue(strXml, "departmentGroupLeadNameS");
		String departmentGroupIdS=TranslateXml.getValue(strXml, "departmentGroupIdS");
		String departmentGroupNameS=TranslateXml.getValue(strXml, "departmentGroupNameS");
		String departmentDirectlyIdS=TranslateXml.getValue(strXml, "departmentDirectlyIdS");
		String departmentDirectlyNameS=TranslateXml.getValue(strXml, "departmentDirectlyNameS");
		String departmentMemberIdS=TranslateXml.getValue(strXml, "departmentMemberIdS");
		String departmentMemberNameS=TranslateXml.getValue(strXml, "departmentMemberNameS");
		String departmentOutMemberIdS=TranslateXml.getValue(strXml, "departmentOutMemberIdS");
		String departmentOutMemberNameS=TranslateXml.getValue(strXml, "departmentOutMemberNameS");
		String mainConferenceId=TranslateXml.getValue(strXml, "mainConferenceId");
		String mainConference=TranslateXml.getValue(strXml, "mainConference");
		String mainVenueNumber=TranslateXml.getValue(strXml, "mainVenueNumber");
		String venueConferenceIdS=TranslateXml.getValue(strXml, "venueConferenceIdS");
		String venueConference=TranslateXml.getValue(strXml, "venueConference");
		String createTime=TranslateXml.getValue(strXml, "createTime");
		String status=TranslateXml.getValue(strXml, "status");
		Date startTimeDate = format.parse(startTime);
		Date endTimeDate = format.parse(endTime);
		Date createTimeDate = format.parse(createTime);
		ApplyConferenceVO	dept = this.getApplyConferenceVOById(applyId);
				if(dept!=null){
					
					if(applyId!=null){
						dept.setApplyID(applyId);
					}
					if(departmentId!=null){
						dept.setDepartmentID(departmentId);
					}
					if(departmentName!=null){
						dept.setDepartmentName(departmentName);
					}
					if(departmentCode!=null){
						dept.setDepartmentCode(departmentCode);
						}

					if(linkManID!=null){
						dept.setLinkManID(linkManID);
						dept.setCreateUserID(linkManID);
					}
					if(linkManName!=null){
						dept.setLinkManName(linkManName);
					}
					if(linkManPhone!=null){
						dept.setLinkManPhone(linkManPhone);
					}
					if(linkManFax!=null){
						dept.setLinkManFax(linkManFax);
					}
					if(linkManCellPhone!=null){
						dept.setLinkManCellPhone(linkManCellPhone);
					}
					if(security!=null){
						int se=Integer.valueOf(security);
						dept.setSecurity(se);
					}
					if(startTime!=null){
						dept.setStartTime(new Timestamp(startTimeDate.getTime()));
					}
					if(endTime!=null){
						dept.setEndTime(new Timestamp(endTimeDate.getTime()));
					}
					if(conferenceName!=null){
						dept.setConferenceName(conferenceName);
					}
					if(conferenceAgenda!=null){
						dept.setConferenceAgenda(conferenceAgenda);
					}
					if(countNumber!=null){
						dept.setCountNumber(countNumber);
					}
					if(departmentGroupLeadIdS!=null){
						dept.setDepartmentGroupLeadIDs(departmentGroupLeadIdS);
					}
					if(departmentGroupLeadNameS!=null){
						dept.setDepartmentGroupLeadNames(departmentGroupLeadNameS);
					}
					if(departmentGroupIdS!=null){
						dept.setDepartmentGroupIDS(departmentGroupIdS);
					}
					if(departmentGroupNameS!=null){
						dept.setDepartmentGroupNames(departmentGroupNameS);
					}
					if(departmentDirectlyIdS!=null){
						dept.setDepartmentDirectlyIDS(departmentDirectlyIdS);
					}
					if(departmentDirectlyNameS!=null){
						dept.setDepartmentDirectlyNames(departmentDirectlyNameS);
					}
					if(departmentMemberIdS!=null){
						dept.setDepartmentMemberIDS(departmentMemberIdS);
					}
					if(departmentMemberNameS!=null){
						dept.setDepartmentMemberNames(departmentMemberNameS);
					}
					if(departmentOutMemberIdS!=null){
						dept.setDepartmentOutMemberIDS(departmentOutMemberIdS);
					}
					if(departmentOutMemberNameS!=null){
						dept.setDepartmentOutMemberNames(departmentOutMemberNameS);
					}
					if(mainConferenceId!=null){
						dept.setMainConferenceID(mainConferenceId);
					}
					if(mainConference!=null){
						dept.setMainConference(mainConference);
					}
					if(mainVenueNumber!=null){
						dept.setMainVenueNumber(mainVenueNumber);
					}
					if(venueConferenceIdS!=null){
						dept.setVenueConferenceIDs(venueConferenceIdS);
					}
					if(venueConference!=null){
						dept.setVenueConference(venueConference);
					}
					if(createTime!=null){
						dept.setCreateTime(new Timestamp(createTimeDate.getTime()));
					}
					if(status!=null){
						int stat=Integer.valueOf(status);
						dept.setStatus(stat);
					}
				}else{
					dept = new ApplyConferenceVO();
					if(applyId!=null){
						dept.setApplyID(applyId);
					}
					if(departmentId!=null){
						dept.setDepartmentID(departmentId);
					}
					if(departmentName!=null){
						dept.setDepartmentName(departmentName);
					}
					if(departmentCode!=null){
						dept.setDepartmentCode(departmentCode);
					}
					if(linkManID!=null){
						dept.setLinkManID(linkManID);
						dept.setCreateUserID(linkManID);
					}
					if(linkManName!=null){
						dept.setLinkManName(linkManName);
					}
					if(linkManPhone!=null){
						dept.setLinkManPhone(linkManPhone);
					}
					if(linkManFax!=null){
						dept.setLinkManFax(linkManPhone);
					}
					if(linkManCellPhone!=null){
						dept.setLinkManCellPhone(linkManCellPhone);
					}
					if(security!=null){
						int se=Integer.valueOf(security);
						dept.setSecurity(se);
					}
					if(startTime!=null){
						dept.setStartTime(new Timestamp(startTimeDate.getTime()));
					}
					if(endTime!=null){
						dept.setEndTime(new Timestamp(endTimeDate.getTime()));
					}
					if(conferenceName!=null){
						dept.setConferenceName(conferenceName);
					}
					if(conferenceAgenda!=null){
						dept.setConferenceAgenda(conferenceAgenda);
					}
					if(countNumber!=null){
						dept.setCountNumber(countNumber);
					}
					if(departmentGroupLeadIdS!=null){
						dept.setDepartmentGroupLeadIDs(departmentGroupLeadIdS);
					}
					if(departmentGroupLeadNameS!=null){
						dept.setDepartmentGroupLeadNames(departmentGroupLeadNameS);
					}
					if(departmentGroupIdS!=null){
						dept.setDepartmentGroupIDS(departmentGroupIdS);
					}
					if(departmentGroupNameS!=null){
						dept.setDepartmentGroupNames(departmentGroupNameS);
					}
					if(departmentDirectlyIdS!=null){
						dept.setDepartmentDirectlyIDS(departmentDirectlyIdS);
					}
					if(departmentDirectlyNameS!=null){
						dept.setDepartmentDirectlyNames(departmentDirectlyNameS);
					}
					if(departmentMemberIdS!=null){
						dept.setDepartmentMemberIDS(departmentMemberIdS);
					}
					if(departmentMemberNameS!=null){
						dept.setDepartmentMemberNames(departmentMemberNameS);
					}
					if(departmentOutMemberIdS!=null){
						dept.setDepartmentOutMemberIDS(departmentOutMemberIdS);
					}
					if(departmentOutMemberNameS!=null){
						dept.setDepartmentOutMemberNames(departmentOutMemberNameS);
					}
					if(mainConferenceId!=null){
						dept.setMainConferenceID(mainConferenceId);
					}
					if(mainConference!=null){
						dept.setMainConference(mainConference);
					}
					if(mainVenueNumber!=null){
						dept.setMainVenueNumber(mainVenueNumber);
					}
					if(venueConferenceIdS!=null){
						dept.setVenueConferenceIDs(venueConferenceIdS);
					}
					if(venueConference!=null){
						dept.setVenueConference(venueConference);
					}
					if(createTime!=null){
						dept.setCreateTime(new Timestamp(createTimeDate.getTime()));
					}
					if(status!=null){
						int stat=Integer.valueOf(status);
						dept.setStatus(stat);
					}
				}
				deptList.add(dept);
				try {
					if(deptList!=null&&deptList.size()>0){
						for(ApplyConferenceVO vo:deptList){
							applyconferencedao.add(vo, null);
						}
					}
					} catch (Exception e) {
					e.printStackTrace();
				}
		return strXml;
	}
	
	
	@SuppressWarnings({ "static-access"})
	public String update(String strXml) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<ApplyConferenceVO> deptList = new ArrayList<ApplyConferenceVO>();
		String applyId=TranslateXml.getValue(strXml, "applyId");
		String departmentId=TranslateXml.getValue(strXml, "departmentId");
		String departmentName=TranslateXml.getValue(strXml, "departmentName");
		String departmentCode=TranslateXml.getValue(strXml, "departmentCode");
		String linkManID=TranslateXml.getValue(strXml, "linkManID");
		String linkManName=TranslateXml.getValue(strXml, "linkManName");
		String linkManPhone=TranslateXml.getValue(strXml, "linkManPhone");   
		String linkManFax=TranslateXml.getValue(strXml, "linkManFax");
		String linkManCellPhone=TranslateXml.getValue(strXml, "linkManCellPhone");
		String security=TranslateXml.getValue(strXml, "security");
		String startTime=TranslateXml.getValue(strXml, "startTime");
		String endTime=TranslateXml.getValue(strXml, "endTime");
		String conferenceName=TranslateXml.getValue(strXml, "conferenceName");
		String conferenceAgenda=TranslateXml.getValue(strXml, "conferenceAgenda");
		String countNumber=TranslateXml.getValue(strXml, "countNumber");
		String departmentGroupLeadIdS=TranslateXml.getValue(strXml, "departmentGroupLeadIdS");
		String departmentGroupLeadNameS=TranslateXml.getValue(strXml, "departmentGroupLeadNameS");
		String departmentGroupIdS=TranslateXml.getValue(strXml, "departmentGroupIdS");
		String departmentGroupNameS=TranslateXml.getValue(strXml, "departmentGroupNameS");
		String departmentDirectlyIdS=TranslateXml.getValue(strXml, "departmentDirectlyIdS");
		String departmentDirectlyNameS=TranslateXml.getValue(strXml, "departmentDirectlyNameS");
		String departmentMemberIdS=TranslateXml.getValue(strXml, "departmentMemberIdS");
		String departmentMemberNameS=TranslateXml.getValue(strXml, "departmentMemberNameS");
		String departmentOutMemberIdS=TranslateXml.getValue(strXml, "departmentOutMemberIdS");
		String departmentOutMemberNameS=TranslateXml.getValue(strXml, "departmentOutMemberNameS");
		String mainConferenceId=TranslateXml.getValue(strXml, "mainConferenceId");
		String mainConference=TranslateXml.getValue(strXml, "mainConference");
		String mainVenueNumber=TranslateXml.getValue(strXml, "mainVenueNumber");
		String venueConferenceIdS=TranslateXml.getValue(strXml, "venueConferenceIdS");
		String venueConference=TranslateXml.getValue(strXml, "venueConference");
		String createTime=TranslateXml.getValue(strXml, "createTime");
		String status=TranslateXml.getValue(strXml, "status");
		Date startTimeDate = format.parse(startTime);
		Date endTimeDate = format.parse(endTime);
		Date createTimeDate = format.parse(createTime);
				ApplyConferenceVO	dept = this.getApplyConferenceVOById(applyId);
				if(dept!=null){
					if(applyId!=null){
						dept.setApplyID(applyId);
					}
					if(departmentId!=null){
						dept.setDepartmentID(departmentId);
					}
					if(departmentName!=null){
						dept.setDepartmentName(departmentName);
					}
					if(departmentCode!=null){
						dept.setDepartmentCode(departmentCode);
						}
					if(linkManID!=null){
						dept.setLinkManID(linkManID);
						dept.setCreateUserID(linkManID);
					}
					if(linkManPhone!=null){
						dept.setLinkManPhone(linkManPhone);
					}
					if(linkManName!=null){
						dept.setLinkManName(linkManName);
					}
					if(linkManFax!=null){
						dept.setLinkManFax(linkManPhone);
					}
					if(linkManCellPhone!=null){
						dept.setLinkManCellPhone(linkManCellPhone);
					}
					if(security!=null){
						int se=Integer.valueOf(security);
						dept.setSecurity(se);
					}
					if(startTime!=null){
						dept.setStartTime(new Timestamp(startTimeDate.getTime()));
					}
					if(endTime!=null){
						dept.setEndTime(new Timestamp(endTimeDate.getTime()));
					}
					if(conferenceName!=null){
						dept.setConferenceName(conferenceName);
					}
					if(conferenceAgenda!=null){
						dept.setConferenceAgenda(conferenceAgenda);
					}
					if(countNumber!=null){
						dept.setCountNumber(countNumber);
					}
					if(departmentGroupLeadIdS!=null){
						dept.setDepartmentGroupLeadIDs(departmentGroupLeadIdS);
					}
					if(departmentGroupLeadNameS!=null){
						dept.setDepartmentGroupLeadNames(departmentGroupLeadNameS);
					}
					if(departmentGroupIdS!=null){
						dept.setDepartmentGroupIDS(departmentGroupIdS);
					}
					if(departmentGroupNameS!=null){
						dept.setDepartmentGroupNames(departmentGroupNameS);
					}
					if(departmentDirectlyIdS!=null){
						dept.setDepartmentDirectlyIDS(departmentDirectlyIdS);
					}
					if(departmentDirectlyNameS!=null){
						dept.setDepartmentDirectlyNames(departmentDirectlyNameS);
					}
					if(departmentMemberIdS!=null){
						dept.setDepartmentMemberIDS(departmentMemberIdS);
					}
					if(departmentMemberNameS!=null){
						dept.setDepartmentMemberNames(departmentMemberNameS);
					}
					if(departmentOutMemberIdS!=null){
						dept.setDepartmentOutMemberIDS(departmentOutMemberIdS);
					}
					if(departmentOutMemberNameS!=null){
						dept.setDepartmentOutMemberNames(departmentOutMemberNameS);
					}
					if(mainConferenceId!=null){
						dept.setMainConferenceID(mainConferenceId);
					}
					if(mainConference!=null){
						dept.setMainConference(mainConference);
					}
					if(mainVenueNumber!=null){
						dept.setMainVenueNumber(mainVenueNumber);
					}
					if(venueConferenceIdS!=null){
						dept.setVenueConferenceIDs(venueConferenceIdS);
					}
					if(venueConference!=null){
						dept.setVenueConference(venueConference);
					}
					if(createTime!=null){
						dept.setCreateTime(new Timestamp(createTimeDate.getTime()));
					}
					if(status!=null){
						int stat=Integer.valueOf(status);
						dept.setStatus(stat);
					}
				}else{
					dept= new ApplyConferenceVO();
					if(applyId!=null){
						dept.setApplyID(applyId);
					}
					if(departmentId!=null){
						dept.setDepartmentID(departmentId);
					}
					if(departmentName!=null){
						dept.setDepartmentName(departmentName);
					}
					if(departmentCode!=null){
						dept.setDepartmentCode(departmentCode);
						}
					if(linkManID!=null){
						dept.setLinkManID(linkManID);
						dept.setCreateUserID(linkManID);
					}
					if(linkManName!=null){
						dept.setLinkManName(linkManName);
					}
					if(linkManPhone!=null){
						dept.setLinkManPhone(linkManPhone);
					}
					if(linkManFax!=null){
						dept.setLinkManFax(linkManPhone);
					}
					if(linkManCellPhone!=null){
						dept.setLinkManCellPhone(linkManCellPhone);
					}
					if(security!=null){
						int se=Integer.valueOf(security);
						dept.setSecurity(se);
					}
					if(startTime!=null){
						dept.setStartTime(new Timestamp(startTimeDate.getTime()));
					}
					if(endTime!=null){
						dept.setEndTime(new Timestamp(endTimeDate.getTime()));
					}
					if(conferenceName!=null){
						dept.setConferenceName(conferenceName);
					}
					if(conferenceAgenda!=null){
						dept.setConferenceAgenda(conferenceAgenda);
					}
					if(countNumber!=null){
						dept.setCountNumber(countNumber);
					}
					if(departmentGroupLeadIdS!=null){
						dept.setDepartmentGroupLeadIDs(departmentGroupLeadIdS);
					}
					if(departmentGroupLeadNameS!=null){
						dept.setDepartmentGroupLeadNames(departmentGroupLeadNameS);
					}
					if(departmentGroupIdS!=null){
						dept.setDepartmentGroupIDS(departmentGroupIdS);
					}
					if(departmentGroupNameS!=null){
						dept.setDepartmentGroupNames(departmentGroupNameS);
					}
					if(departmentDirectlyIdS!=null){
						dept.setDepartmentDirectlyIDS(departmentDirectlyIdS);
					}
					if(departmentDirectlyNameS!=null){
						dept.setDepartmentDirectlyNames(departmentDirectlyNameS);
					}
					if(departmentMemberIdS!=null){
						dept.setDepartmentMemberIDS(departmentMemberIdS);
					}
					if(departmentMemberNameS!=null){
						dept.setDepartmentMemberNames(departmentMemberNameS);
					}
					if(departmentOutMemberIdS!=null){
						dept.setDepartmentOutMemberIDS(departmentOutMemberIdS);
					}
					if(departmentOutMemberNameS!=null){
						dept.setDepartmentOutMemberNames(departmentOutMemberNameS);
					}
					if(mainConferenceId!=null){
						dept.setMainConferenceID(mainConferenceId);
					}
					if(mainConference!=null){
						dept.setMainConference(mainConference);
					}
					if(mainVenueNumber!=null){
						dept.setMainVenueNumber(mainVenueNumber);
					}
					if(venueConferenceIdS!=null){
						dept.setVenueConferenceIDs(venueConferenceIdS);
					}
					if(venueConference!=null){
						dept.setVenueConference(venueConference);
					}
					if(createTime!=null){
						dept.setCreateTime(new Timestamp(createTimeDate.getTime()));
					}
					if(status!=null){
						int stat=Integer.valueOf(status);
						dept.setStatus(stat);
					}
				}
				deptList.add(dept);
				try {
					if(deptList!=null&&deptList.size()>0){
						for(ApplyConferenceVO vo:deptList){
							applyconferencedao.modify(vo, null);
						}
					}
					} catch (Exception e) {
					e.printStackTrace();
				}
		return strXml;
	}
	
	
	
	//修改的解析方法
	@SuppressWarnings({ "static-access" })
	public String updates(String strXml) throws Exception{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<ApplyConferenceVO> deptList = new ArrayList<ApplyConferenceVO>();
		String applyId=TranslateXml.getValue(strXml, "applyId");
		String departmentId=TranslateXml.getValue(strXml, "departmentId");
		String departmentName=TranslateXml.getValue(strXml, "departmentName");
		String departmentCode=TranslateXml.getValue(strXml, "departmentCode");
		String linkManID=TranslateXml.getValue(strXml, "linkManID");
		String linkManName=TranslateXml.getValue(strXml, "linkManName");
		String linkManPhone=TranslateXml.getValue(strXml, "linkManPhone");   
		String linkManFax=TranslateXml.getValue(strXml, "linkManFax");
		String linkManCellPhone=TranslateXml.getValue(strXml, "linkManCellPhone");
		String security=TranslateXml.getValue(strXml, "security");
		String startTime=TranslateXml.getValue(strXml, "startTime");
		String endTime=TranslateXml.getValue(strXml, "endTime");
		String conferenceName=TranslateXml.getValue(strXml, "conferenceName");
		String conferenceAgenda=TranslateXml.getValue(strXml, "conferenceAgenda");
		String countNumber=TranslateXml.getValue(strXml, "countNumber");
		String departmentGroupLeadIdS=TranslateXml.getValue(strXml, "departmentGroupLeadIdS");
		String departmentGroupLeadNameS=TranslateXml.getValue(strXml, "departmentGroupLeadNameS");
		String departmentGroupIdS=TranslateXml.getValue(strXml, "departmentGroupIdS");
		String departmentGroupNameS=TranslateXml.getValue(strXml, "departmentGroupNameS");
		String departmentDirectlyIdS=TranslateXml.getValue(strXml, "departmentDirectlyIdS");
		String departmentDirectlyNameS=TranslateXml.getValue(strXml, "departmentDirectlyNameS");
		String departmentMemberIdS=TranslateXml.getValue(strXml, "departmentMemberIdS");
		String departmentMemberNameS=TranslateXml.getValue(strXml, "departmentMemberNameS");
		String departmentOutMemberIdS=TranslateXml.getValue(strXml, "departmentOutMemberIdS");
		String departmentOutMemberNameS=TranslateXml.getValue(strXml, "departmentOutMemberNameS");
		String mainConferenceId=TranslateXml.getValue(strXml, "mainConferenceId");
		String mainConference=TranslateXml.getValue(strXml, "mainConference");
		String mainVenueNumber=TranslateXml.getValue(strXml, "mainVenueNumber");
		String venueConferenceIdS=TranslateXml.getValue(strXml, "venueConferenceIdS");
		String venueConference=TranslateXml.getValue(strXml, "venueConference");
		String createTime=TranslateXml.getValue(strXml, "createTime");
		String status=TranslateXml.getValue(strXml, "status");
		Date startTimeDate = format.parse(startTime);
		Date endTimeDate = format.parse(endTime);
		Date createTimeDate = format.parse(createTime);
		this.getUpdatedetail(strXml);
		ApplyConferenceVO	dept = this.getApplyConferenceVOById(applyId);
				if(dept!=null){
					if(applyId!=null){
						dept.setApplyID(applyId);
					}
					if(departmentId!=null){
						dept.setDepartmentID(departmentId);
					}
					if(departmentName!=null){
						dept.setDepartmentName(departmentName);
					}
					if(departmentCode!=null){
						dept.setDepartmentCode(departmentCode);
						}

					if(linkManID!=null){
						dept.setLinkManID(linkManID);
						dept.setCreateUserID(linkManID);
					}
					if(linkManName!=null){
						dept.setLinkManName(linkManName);
					}
					if(linkManPhone!=null){
						dept.setLinkManPhone(linkManPhone);
					}
					if(linkManFax!=null){
						dept.setLinkManFax(linkManPhone);
					}
					if(linkManCellPhone!=null){
						dept.setLinkManCellPhone(linkManCellPhone);
					}
					if(security!=null){
						int se=Integer.valueOf(security);
						dept.setSecurity(se);
					}
					if(startTime!=null){
						dept.setStartTime(new Timestamp(startTimeDate.getTime()));
					}
					if(endTime!=null){
						dept.setEndTime(new Timestamp(endTimeDate.getTime()));
					}
					if(conferenceName!=null){
						dept.setConferenceName(conferenceName);
					}
					if(conferenceAgenda!=null){
						dept.setConferenceAgenda(conferenceAgenda);
					}
					if(countNumber!=null){
						dept.setCountNumber(countNumber);
					}
					if(departmentGroupLeadIdS!=null){
						dept.setDepartmentGroupLeadIDs(departmentGroupLeadIdS);
					}
					if(departmentGroupLeadNameS!=null){
						dept.setDepartmentGroupLeadNames(departmentGroupLeadNameS);
					}
					if(departmentGroupIdS!=null){
						dept.setDepartmentGroupIDS(departmentGroupIdS);
					}
					if(departmentGroupNameS!=null){
						dept.setDepartmentGroupNames(departmentGroupNameS);
					}
					if(departmentDirectlyIdS!=null){
						dept.setDepartmentDirectlyIDS(departmentDirectlyIdS);
					}
					if(departmentDirectlyNameS!=null){
						dept.setDepartmentDirectlyNames(departmentDirectlyNameS);
					}
					if(departmentMemberIdS!=null){
						dept.setDepartmentMemberIDS(departmentMemberIdS);
					}
					if(departmentMemberNameS!=null){
						dept.setDepartmentMemberNames(departmentMemberNameS);
					}
					if(departmentOutMemberIdS!=null){
						dept.setDepartmentOutMemberIDS(departmentOutMemberIdS);
					}
					if(departmentOutMemberNameS!=null){
						dept.setDepartmentOutMemberNames(departmentOutMemberNameS);
					}
					if(mainConferenceId!=null){
						dept.setMainConferenceID(mainConferenceId);
					}
					if(mainConference!=null){
						dept.setMainConference(mainConference);
					}
					if(mainVenueNumber!=null){
						dept.setMainVenueNumber(mainVenueNumber);
					}
					if(venueConferenceIdS!=null){
						dept.setVenueConferenceIDs(venueConferenceIdS);
					}
					if(venueConference!=null){
						dept.setVenueConference(venueConference);
					}
					if(createTime!=null){
						dept.setCreateTime(new Timestamp(createTimeDate.getTime()));
					}
					if(status!=null){
						int stat=Integer.valueOf(status);
						dept.setStatus(stat);
					}
				}else{
					dept = new ApplyConferenceVO();
					if(applyId!=null){
						dept.setApplyID(applyId);
					}
					if(departmentId!=null){
						dept.setDepartmentID(departmentId);
					}
					if(departmentName!=null){
						dept.setDepartmentName(departmentName);
					}
					if(departmentCode!=null){
						dept.setDepartmentCode(departmentCode);
					}
					if(linkManID!=null){
						dept.setLinkManID(linkManID);
						dept.setCreateUserID(linkManID);
					}
					if(linkManName!=null){
						dept.setLinkManName(linkManName);
					}
					if(linkManPhone!=null){
						dept.setLinkManPhone(linkManPhone);
					}
					if(linkManFax!=null){
						dept.setLinkManFax(linkManPhone);
					}
					if(linkManCellPhone!=null){
						dept.setLinkManCellPhone(linkManCellPhone);
					}
					if(security!=null){
						int se=Integer.valueOf(security);
						dept.setSecurity(se);
					}
					if(startTime!=null){
						dept.setStartTime(new Timestamp(startTimeDate.getTime()));
					}
					if(endTime!=null){
						dept.setEndTime(new Timestamp(endTimeDate.getTime()));
					}
					if(conferenceName!=null){
						dept.setConferenceName(conferenceName);
					}
					if(conferenceAgenda!=null){
						dept.setConferenceAgenda(conferenceAgenda);
					}
					if(countNumber!=null){
						dept.setCountNumber(countNumber);
					}
					if(departmentGroupLeadIdS!=null){
						dept.setDepartmentGroupLeadIDs(departmentGroupLeadIdS);
					}
					if(departmentGroupLeadNameS!=null){
						dept.setDepartmentGroupLeadNames(departmentGroupLeadNameS);
					}
					if(departmentGroupIdS!=null){
						dept.setDepartmentGroupIDS(departmentGroupIdS);
					}
					if(departmentGroupNameS!=null){
						dept.setDepartmentGroupNames(departmentGroupNameS);
					}
					if(departmentDirectlyIdS!=null){
						dept.setDepartmentDirectlyIDS(departmentDirectlyIdS);
					}
					if(departmentDirectlyNameS!=null){
						dept.setDepartmentDirectlyNames(departmentDirectlyNameS);
					}
					if(departmentMemberIdS!=null){
						dept.setDepartmentMemberIDS(departmentMemberIdS);
					}
					if(departmentMemberNameS!=null){
						dept.setDepartmentMemberNames(departmentMemberNameS);
					}
					if(departmentOutMemberIdS!=null){
						dept.setDepartmentOutMemberIDS(departmentOutMemberIdS);
					}
					if(departmentOutMemberNameS!=null){
						dept.setDepartmentOutMemberNames(departmentOutMemberNameS);
					}
					if(mainConferenceId!=null){
						dept.setMainConferenceID(mainConferenceId);
					}
					if(mainConference!=null){
						dept.setMainConference(mainConference);
					}
					if(mainVenueNumber!=null){
						dept.setMainVenueNumber(mainVenueNumber);
					}
					if(venueConferenceIdS!=null){
						dept.setVenueConferenceIDs(venueConferenceIdS);
					}
					if(venueConference!=null){
						dept.setVenueConference(venueConference);
					}
					if(createTime!=null){
						dept.setCreateTime(new Timestamp(createTimeDate.getTime()));
					}
					if(status!=null){
						int stat=Integer.valueOf(status);
						dept.setStatus(stat);
					}
				}
				deptList.add(dept);
				try {
					if(deptList!=null&&deptList.size()>0){
						for(ApplyConferenceVO vo:deptList){
							applyconferencedao.modify(vo, null);
						}
					}
					} catch (Exception e) {
					e.printStackTrace();
				}
		return strXml;
	}
	
	//循环的修改update
	@SuppressWarnings({ "static-access"})
	public String getUpdatedetail(String strXml) throws Exception{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Document doc = null;		//xml文件
		Element root = null;		//根节点
		String namespace = null;	//命名空间
		try {
			doc = DocumentHelper.parseText(strXml);  //从xmlString读取xml信息
			root = doc.getRootElement();				//获取根节点
			namespace = root.getNamespaceURI();			//获取根节点命名空间
		} catch (DocumentException e) {
			log.error("xml解析异常,请核查传入xml是否规范！！！");
			return null;
		}
		Map map = new HashMap(); 					
		map.put("TJ", namespace);
		XPath x = doc.createXPath("//TJ:"+"applyDetailId");
		x.setNamespaceURIs(map);
		List nodelist = x.selectNodes(doc);
		if(nodelist!=null&&nodelist.size()>0){
			String linkManID=TranslateXml.getValue(strXml, "linkManID");
			String linkManName=TranslateXml.getValue(strXml, "linkManName");
			String applyDetailID=TranslateXml.getValue(strXml, "applyDetailId");
			String createTime=TranslateXml.getValue(strXml, "createTime");
			ApplyDetailVO aVO = new ApplyDetailVO();
			aVO.setApplyDetailID(applyDetailID);
			aVO.setUserID(linkManID);
			aVO.setFlownodeName(linkManName);
			aVO.setCreateTime(new Timestamp(format.parse(createTime).getTime()));
			aVO.setFlowID("1");
			aVO.setFlownodeID("2");
			aVO.setFlowType(ApplyEnum.ZH_VIDEO_CONFERENCE);
			aVO.setCheckType(ApplyEnum.CHECKTYPE_PERSON);
			applydetaildao.add(aVO, null);
			
			for(int m=0;m<nodelist.size();m++){
				String flownodeName=TranslateXml.getValue(strXml, "flownodeName",m);
//				String id=TranslateXml.getValue(strXml, "applyId");
//				String detailId=TranslateXml.getValue(strXml, "detailId");
//				String orderNum=TranslateXml.getValue(strXml, "orderNum");
				String applyDetailId=TranslateXml.getValue(strXml, "applyDetailId",m);
				String userId=TranslateXml.getValue(strXml, "userId",m);
				String suggestion=TranslateXml.getValue(strXml, "suggestion",m);
				String detailcreateTime=TranslateXml.getValue(strXml, "detailcreateTime",m);
				Date detailcreateTimeDate = format.parse(detailcreateTime);
				List<ApplyDetailVO> depList = new ArrayList<ApplyDetailVO>();
			        ApplyDetailVO de= new ApplyDetailVO();
						de.setDetailID(UtilDAO.getUUid());
//						de.setOrderNum(m+1);
			        	if(flownodeName!=null){
							de.setFlownodeName(flownodeName);
						}
			        	if(applyDetailId!=null){
							de.setApplyDetailID(applyDetailId);
						}
			        	if(userId!=null){
			        		de.setUserID(userId);
			        	}
			        	if(suggestion!=null){
							de.setSuggestion(suggestion);			
			            }
		        	    if(detailcreateTime!=null){
		        	    	de.setCreateTime(new Timestamp(detailcreateTimeDate.getTime()));
		                }
		        	    de.setFlowID("1");
		        	    de.setFlownodeID("2");
		        	    de.setFlowType(ApplyEnum.ZH_VIDEO_CONFERENCE);
		        	    de.setCheckType(ApplyEnum.CHECKTYPE_PERSON);
			        depList.add(de);
		        	if(depList!=null&&depList.size()>0){
						for(ApplyDetailVO vo:depList){
							applydetaildao.add(vo, null);
						}
					}
				
			}
		}
		
		
		
		return strXml;
	}
	
	
	
			
	@SuppressWarnings("unchecked")
	public static List getElementList(String xmlString ,String node,String nodeNext){
			List list = new ArrayList();
			Element ele = null;
			try{
				Document doc = DocumentHelper.parseText(xmlString);
				Element root = (Element) doc.getRootElement();
				Iterator nodeIter = ((org.dom4j.Element) root).elementIterator(node);
				while(nodeIter.hasNext()){
					Element element = (Element)nodeIter.next();
					Iterator item = ((org.dom4j.Element) element).elementIterator(nodeNext);
					List modelList = null;
					while(item.hasNext()){
						Element itemElement = (Element)item.next();
						List eleList = ((org.dom4j.Element) itemElement).elements();
						modelList = new ArrayList();
						for(int i=0;i<eleList.size();i++){			
							ele =(Element) eleList.get(i);
							modelList.add(((org.dom4j.Element) ele).getTextTrim());
						}
						list.add(modelList);
					}
				}
			}catch (DocumentException e){
				e.printStackTrace();
			}
			return list;
		}
		
	public static Date getDateByStr(String aStr) {
			SimpleDateFormat df =null;
			if (aStr == null) return null;
			if(aStr.indexOf(":")>0 )//如果有时间　
				df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			else //如果没有时间
				df = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date result = df.parse(aStr);
				return result;
			}
			catch (Exception e) {
				return null;
			}
		}		
		
	@SuppressWarnings("static-access")
	public ApplyConferenceVO getApplyConferenceVOById(String id){
			ApplyConferenceVO applyConferenceVO = new ApplyConferenceVO();
			List<ApplyConferenceVO> aList = new ArrayList<ApplyConferenceVO>();
			if(id!=null && id.trim().length()>0){
				try {
					applyConferenceVO.setApplyID(id);
					aList = applyconferencedao.query(applyConferenceVO, null);
					if(aList!=null&&aList.size()>0){
						applyConferenceVO = aList.get(0);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return applyConferenceVO;
		}	
	
	
	
	/*public static void main (String [] args){
		XMLProcessor x = new XMLProcessor();
		x.getLeafElementValue(document, xmlPath)
		examinePushClientImpl s = new examinePushClientImpl();
		String   strXml="<publishData><DateSet><data><applyId>12323214123</applyId><departmentId>100001</departmentId><departmentName>申请单位名称</departmentName><departmentCode>100001</departmentCode><linkManID>1</linkManID><linkManName>申请人名称</linkManName><linkManPhone>01012345678</linkManPhone><linkManFax>01012345678</linkManFax><linkManCellPhone>13787180117</linkManCellPhone><security>0</security><startTime>2013-09-2511:40:00</startTime><endTime>2013-09-2515:30:00</endTime><conferenceName>会议名称测试</conferenceName><conferenceAgenda></conferenceAgenda><countNumber></countNumber><departmentGroupLeadIdS></departmentGroupLeadIdS><departmentGroupLeadNameS></departmentGroupLeadNameS><departmentGroupIdS></departmentGroupIdS><departmentGroupNameS></departmentGroupNameS><departmentDirectlyIdS></departmentDirectlyIdS><departmentDirectlyNameS></departmentDirectlyNameS><departmentMemberIdS></departmentMemberIdS><departmentMemberNameS></departmentMemberNameS><departmentOutMemberIdS></departmentOutMemberIdS><departmentOutMemberNameS></departmentOutMemberNameS><mainConferenceId>8a8188024061dd97014061ff1f8b0005</mainConferenceId><mainConference>本地会议室测试</mainConference><mainVenueNumber></mainVenueNumber><venueConferenceIdS></venueConferenceIdS><venueConference></venueConference><createTime>2013-09-2411:50:00</createTime><status>0</status><list><listdate><detailId></detailId><orderNum></orderNum><flownodeName></flownodeName><applyDetailId></applyDetailId><userId></userId><suggestion>7</suggestion><detailcreateTime></detailcreateTime></listdate></list></data></DateSet></publishData>";
		s.updates(strXml);
	}	
	*/
	
	
	
	
	
}
