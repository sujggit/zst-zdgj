package com.zzst.action.meeting.schedule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.schedule.util.WeekUtil;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.schedule.ScheduleVO;
import com.zzst.model.meeting.scheduleWork.ScheduleWorkVO;
import com.zzst.model.mobileInfo.MobileInfoVO;
import com.zzst.service.meeting.meetingDetail.MeetingDetailService;
import com.zzst.service.meeting.meetingDetail.MeetingDetailServiceImpl;
import com.zzst.service.meeting.schedule.ScheduleService;
import com.zzst.service.meeting.schedule.ScheduleServiceImpl;
import com.zzst.service.meeting.scheduleWork.ScheduleWorkService;
import com.zzst.service.meeting.scheduleWork.ScheduleWorkServiceImpl;
import com.zzst.service.mobileInfo.MobileInfoService;
import com.zzst.service.mobileInfo.MobileInfoServiceImpl;
import com.zzst.util.tools.export.ExportFileObject;


/**
 *@Description
 *@date 2011-12-14下午07:53:57
 *@author ryan
 */
public class ScheduleAction  extends CjfAction {
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(ScheduleAction.class.getName());
	private ScheduleWorkVO scheduleWorkVO;
	private ArrayList<ScheduleWorkVO> scheduleWorkVOList = new ArrayList<ScheduleWorkVO>();
	private MobileInfoVO mobileInfoVO = new MobileInfoVO();
	private ArrayList<MobileInfoVO> mobileInfoVOList = new ArrayList<MobileInfoVO>();
	private MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
	private ArrayList<MeetingDetailVO> meetingDetailVOList = new ArrayList<MeetingDetailVO>();
	private ArrayList<String> weekList = new ArrayList<String>();
	private String nowWeek = new String();
	private ArrayList<ScheduleVO> scheduleVOList = new ArrayList<ScheduleVO>();
	private ScheduleVO scheduleVO = new ScheduleVO();
	private String createTime = new String();
	private String status;
	//五个VO，存储每天的信息。
	private ScheduleVO sv1 = new ScheduleVO();
	private ScheduleVO sv2 = new ScheduleVO();
	private ScheduleVO sv3 = new ScheduleVO();
	private ScheduleVO sv4 = new ScheduleVO();
	private ScheduleVO sv5 = new ScheduleVO();
	private ScheduleVO sv6 = new ScheduleVO();
	private ScheduleVO sv7 = new ScheduleVO();
	private String applyId = new String();//联络员id
	private String leaderId = new String();//领导id
	//审批状态 applySug 1通过，0不通过
	private String applySug;//审批意见
	private String suggest;//审批内容
	//导出用
	private InputStream wordStream;
	private String fileName;
	/**
	 * word文档导出
	 * @return
	 */
	public String exportSchedule(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hhmmss");
		fileName = sdf.format(new Date());
		XWPFDocument doc = new XWPFDocument();
		//时间_备注,时间_备注,时间_备注（大事记）
		String s = "时间_备注,时间_备注,时间_备注（大事记）";
		String[] strs = s.split(",");
		XWPFParagraph p1 = doc.createParagraph();
		p1.setAlignment(ParagraphAlignment.LEFT);
		p1.setSpacingLineRule(LineSpacingRule.EXACT);
		//p1.setIndentationFirstLine(600);
		XWPFRun r1 = p1.createRun();
		String[] tem;
		for(int i=0;i<strs.length;i++){
			tem=strs[i].split("_");
			r1.setText(tem[0]);
			r1.addBreak();
			r1.setText(tem[1]);
			r1.addBreak();
			r1.addBreak();
		}
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC +fileName);
			doc.write(out);
			wordStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "success";
	}
	/**
	 * 修改一周的详细内容
	 * @return
	 */
	public String scheduleModify(){
		logger.info("ScheduleAction.scheduleModify()...begin");
		ScheduleService ss = new ScheduleServiceImpl();
		try {
			ss.modify(sv1);
			ss.modify(sv2);
			ss.modify(sv3);
			ss.modify(sv4);
			ss.modify(sv5);
			ss.modify(sv6);
			ss.modify(sv7);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("ScheduleAction.scheduleModify()...end");
		return "success";
	}
	/**
	 * 日程修改跳转
	 * @return
	 */
	public String scheduleModifyBefore(){
		logger.info("ScheduleAction.scheduleModifyBefore()...begin");
		ScheduleService ss = new ScheduleServiceImpl();
		ScheduleWorkService sws = new ScheduleWorkServiceImpl();
		MeetingDetailService mds = new MeetingDetailServiceImpl();
		try {
			scheduleWorkVOList = sws.query(scheduleWorkVO, null);//工作安排信息
			meetingDetailVOList = mds.query(meetingDetailVO , null);//会议信息,所有的（应该是显示此天的，待修改）
			scheduleVO.setCreateTime(Timestamp.valueOf(createTime));
			scheduleVOList = ss.query(scheduleVO, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("ScheduleAction.scheduleModifyBefore()...end");
		return "success";
	}
	/**
	 * 审批
	 * @return
	 */
	public String apply(){
		logger.info("ScheduleAction.apply()...begin");
		//生成审批时间
		Timestamp ts = new Timestamp(new Date().getTime());
		sv1.setStatus(applySug);sv1.setApplysug(suggest);sv1.setApplyTime(ts);
		sv2.setStatus(applySug);sv2.setApplysug(suggest);sv2.setApplyPeopleId(sv1.getApplyPeopleId());sv2.setApplyTime(ts);
		sv3.setStatus(applySug);sv3.setApplysug(suggest);sv3.setApplyPeopleId(sv1.getApplyPeopleId());sv3.setApplyTime(ts);
		sv4.setStatus(applySug);sv4.setApplysug(suggest);sv4.setApplyPeopleId(sv1.getApplyPeopleId());sv4.setApplyTime(ts);
		sv5.setStatus(applySug);sv5.setApplysug(suggest);sv5.setApplyPeopleId(sv1.getApplyPeopleId());sv5.setApplyTime(ts);
		sv6.setStatus(applySug);sv6.setApplysug(suggest);sv6.setApplyPeopleId(sv1.getApplyPeopleId());sv6.setApplyTime(ts);
		sv7.setStatus(applySug);sv7.setApplysug(suggest);sv7.setApplyPeopleId(sv1.getApplyPeopleId());sv7.setApplyTime(ts);
		ScheduleService ss = new ScheduleServiceImpl();
		try {
			ss.modify(sv1);
			ss.modify(sv2);
			ss.modify(sv3);
			ss.modify(sv4);
			ss.modify(sv5);
			ss.modify(sv6);
			ss.modify(sv7);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("ScheduleAction.apply()...end");
		return "success";
	}
	/**
	 * 审批之前
	 * @return
	 */
	public String beforeApply(){
		logger.info("ScheduleAction.beforeApply()...begin");
		ScheduleService ss = new ScheduleServiceImpl();
		try {
			scheduleVO.setCreateTime(Timestamp.valueOf(createTime));
			scheduleVOList = ss.query(scheduleVO, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("ScheduleAction.beforeApply()...end");
		return "success";
	}
	/**
	 * 查询一星期的详细内容
	 * @return
	 */
	public String scheduleQuery(){
		logger.info("ScheduleAction.scheduleQuery()...begin");
		ScheduleService ss = new ScheduleServiceImpl();
		try {
			scheduleVO.setCreateTime(Timestamp.valueOf(createTime));
			scheduleVOList = ss.query(scheduleVO, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("ScheduleAction.scheduleQuery()...end");
		return "success";
	}
	/**
	 * 全部按星期分组查询
	 * @return
	 */
	public String meetingScheduleQuery(){
		logger.info("ScheduleAction.meetingScheduleQuery()...begin");
		ScheduleService ss = new ScheduleServiceImpl();
		try {
			scheduleVOList = ss.queryByWeek(" ",status,getPageControler());
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("ScheduleAction.meetingScheduleQuery()...end");
		return "success";
	}
	/**
	 * 领导日程安排添加
	 * @return
	 */
	public String meetingScheduleAdd(){
		logger.info("ScheduleAction.meetingScheduleAdd()...begin");
		//创建时间
		Timestamp s = new Timestamp(new Date().getTime());
		sv1.setApplyId(applyId);sv1.setLeaderId(leaderId);sv1.setScheduleTime(nowWeek);sv1.setCreateTime(s);
		sv2.setApplyId(applyId);sv2.setLeaderId(leaderId);sv2.setScheduleTime(nowWeek);sv2.setCreateTime(s);
		sv3.setApplyId(applyId);sv3.setLeaderId(leaderId);sv3.setScheduleTime(nowWeek);sv3.setCreateTime(s);
		sv4.setApplyId(applyId);sv4.setLeaderId(leaderId);sv4.setScheduleTime(nowWeek);sv4.setCreateTime(s);
		sv5.setApplyId(applyId);sv5.setLeaderId(leaderId);sv5.setScheduleTime(nowWeek);sv5.setCreateTime(s);
		sv6.setApplyId(applyId);sv6.setLeaderId(leaderId);sv6.setScheduleTime(nowWeek);sv6.setCreateTime(s);
		sv7.setApplyId(applyId);sv7.setLeaderId(leaderId);sv7.setScheduleTime(nowWeek);sv7.setCreateTime(s);
		ScheduleService ss = new ScheduleServiceImpl();
		try {
			ss.add(sv1);
			ss.add(sv2);
			ss.add(sv3);
			ss.add(sv4);
			ss.add(sv5);
			ss.add(sv6);
			ss.add(sv7);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("ScheduleAction.meetingScheduleAdd()...end");
		return "success";
	}
	
	/**
	 * 领导日程安排录入页面
	 * @return
	 */
	public String meetingScheduleEntry(){
		logger.info("ScheduleAction.meetingScheduleEntry()...begin");
		ScheduleWorkService sws = new ScheduleWorkServiceImpl();
		MobileInfoService mis = new MobileInfoServiceImpl();
		MeetingDetailService mds = new MeetingDetailServiceImpl();
		try {
			//拿到对应星期的七天
			weekList = WeekUtil.getWeekList();
			//按周一所在周定义所在周
			nowWeek = WeekUtil.getMonthAndWeek();
			//拿到所有的领导
			mobileInfoVOList = mis.query(mobileInfoVO, null);
			//拿到所有的安排信息
			scheduleWorkVOList = sws.query(scheduleWorkVO, null);
			//拿到所有的会议信息（下一周，一周的会议信息）
			meetingDetailVOList = mds.queryNextWeekMeeting(new Timestamp(new Date().getTime()), new Timestamp(new Date().getTime()+1000l*60l*60l*24l*7l));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("ScheduleAction.meetingScheduleEntry()...end");
		return "success";
	}
	public ScheduleWorkVO getScheduleWorkVO() {
		return scheduleWorkVO;
	}
	public void setScheduleWorkVO(ScheduleWorkVO scheduleWorkVO) {
		this.scheduleWorkVO = scheduleWorkVO;
	}
	public ArrayList<ScheduleWorkVO> getScheduleWorkVOList() {
		return scheduleWorkVOList;
	}
	public void setScheduleWorkVOList(ArrayList<ScheduleWorkVO> scheduleWorkVOList) {
		this.scheduleWorkVOList = scheduleWorkVOList;
	}
	public MobileInfoVO getMobileInfoVO() {
		return mobileInfoVO;
	}
	public void setMobileInfoVO(MobileInfoVO mobileInfoVO) {
		this.mobileInfoVO = mobileInfoVO;
	}
	public ArrayList<MobileInfoVO> getMobileInfoVOList() {
		return mobileInfoVOList;
	}
	public void setMobileInfoVOList(ArrayList<MobileInfoVO> mobileInfoVOList) {
		this.mobileInfoVOList = mobileInfoVOList;
	}
	public MeetingDetailVO getMeetingDetailVO() {
		return meetingDetailVO;
	}
	public void setMeetingDetailVO(MeetingDetailVO meetingDetailVO) {
		this.meetingDetailVO = meetingDetailVO;
	}
	public ArrayList<MeetingDetailVO> getMeetingDetailVOList() {
		return meetingDetailVOList;
	}
	public void setMeetingDetailVOList(
			ArrayList<MeetingDetailVO> meetingDetailVOList) {
		this.meetingDetailVOList = meetingDetailVOList;
	}
	public ArrayList<String> getWeekList() {
		return weekList;
	}
	public void setWeekList(ArrayList<String> weekList) {
		this.weekList = weekList;
	}
	public String getNowWeek() {
		return nowWeek;
	}
	public void setNowWeek(String nowWeek) {
		this.nowWeek = nowWeek;
	}

	public ScheduleVO getSv1() {
		return sv1;
	}

	public void setSv1(ScheduleVO sv1) {
		this.sv1 = sv1;
	}

	public ScheduleVO getSv2() {
		return sv2;
	}

	public void setSv2(ScheduleVO sv2) {
		this.sv2 = sv2;
	}

	public ScheduleVO getSv3() {
		return sv3;
	}

	public void setSv3(ScheduleVO sv3) {
		this.sv3 = sv3;
	}

	public ScheduleVO getSv4() {
		return sv4;
	}

	public void setSv4(ScheduleVO sv4) {
		this.sv4 = sv4;
	}

	public ScheduleVO getSv5() {
		return sv5;
	}

	public void setSv5(ScheduleVO sv5) {
		this.sv5 = sv5;
	}

	public ScheduleVO getSv6() {
		return sv6;
	}

	public void setSv6(ScheduleVO sv6) {
		this.sv6 = sv6;
	}

	public ScheduleVO getSv7() {
		return sv7;
	}

	public void setSv7(ScheduleVO sv7) {
		this.sv7 = sv7;
	}

	public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	public String getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}
	public ArrayList<ScheduleVO> getScheduleVOList() {
		return scheduleVOList;
	}
	public void setScheduleVOList(ArrayList<ScheduleVO> scheduleVOList) {
		this.scheduleVOList = scheduleVOList;
	}
	public ScheduleVO getScheduleVO() {
		return scheduleVO;
	}
	public void setScheduleVO(ScheduleVO scheduleVO) {
		this.scheduleVO = scheduleVO;
	}
	public String getApplySug() {
		return applySug;
	}
	public void setApplySug(String applySug) {
		this.applySug = applySug;
	}
	public String getSuggest() {
		return suggest;
	}
	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public InputStream getWordStream() {
		return wordStream;
	}
	public void setWordStream(InputStream wordStream) {
		this.wordStream = wordStream;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
