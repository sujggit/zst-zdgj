package com.zzst.action.meeting.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.cbf.log.CbfLogger;
import com.cbf.web.util.PageSplittor;
import com.zzst.action.meeting.util.DelFileUtil;
import com.zzst.action.meeting.util.FtpClientUtil;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.model.enums.FileEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingDetailUser.MeetingDetailUserVO;
import com.zzst.model.meeting.uploadFile.UploadFileImpowerVO;
import com.zzst.model.meeting.uploadFile.UploadFileVO;
import com.zzst.model.meeting.user.UserVO;

/**
 * File action会议资料管理
 * @author xiongshun
 * 2013-05-07 11:24:59 AM
 */
public class FileAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;

	private static Logger logger = CbfLogger.getLogger(FileAction.class.getName());
	
	private UploadFileVO uploadFileVO = new UploadFileVO();
	private List<UploadFileVO> uploadFileVOList = new ArrayList<UploadFileVO>();
	
	private MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
	private List<MeetingDetailVO> lst_conference = new ArrayList<MeetingDetailVO>();
	
	private String fileName;
	private String path;
	
	/**
	 * list MeetingFile;会议资料管理页面~会议级别
	 * @return
	 */
	public String manageMeetingFileList(){
		logger.info("FileAction	manageMeetingFileList		begin");
		PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
		try{
			//当查询条件为”请选择“时的处理
			if(meetingDetailVO.getStatus()!=null&&meetingDetailVO.getStatus().equalsIgnoreCase(Integer.MIN_VALUE+"")){
				meetingDetailVO.setStatus("");
			}
			//取出session中的用户信息,权限部分,将登录用户的userID存入不会用到的equipmentVO的equipmentID
			UserVO userVO = (UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			String loginUserID = userVO.getUserID();
			//是否具有上传的权限；会议资料管理员和超级管理员统一上传
			UserVO uVO = new UserVO();
			List<UserVO> uList = new ArrayList<UserVO>();
			uVO.setLoginName(UserEnum.SUPER_ADMIN);
			uList = ServiceFactory.getUserService().getUserList(uVO, null);
			String adminId = "";
			if(uList!=null&&uList.size()>0){
				adminId = uList.get(0).getUserID();
			}
			lst_conference = ServiceFactory.getMeetingDetailService().getMeetingDetailAndFileList(meetingDetailVO, pSplittor.getPControler());
			//会议管理的取会议列表方法，很慢，故而重新写一个20130809
			//lst_conference = ServiceFactory.getMeetingDetailService().getMeetingDetailList(meetingDetailVO, pSplittor.getPControler());
			for(MeetingDetailVO mdVO:lst_conference){
				if(loginUserID.equals(adminId)){
					mdVO.setEndTDNumber(1);
					if(mdVO.getStartTDNumber()==1){//此时表明已经上传过文件
						mdVO.setStartTDNumber(2);
					}
				}else if(loginUserID.equals(mdVO.getConfDocAdminId())){
					mdVO.setEndTDNumber(1);
					if(mdVO.getStartTDNumber()==1){//此时表明已经上传过文件
						mdVO.setStartTDNumber(2);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			return REQUEST_FAILURE;	
		}
		logger.info("FileAction	manageMeetingFileList		end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * meetingFileDownloadList会议资料下载管理页面~文件级别
	 * @return
	 */
	public String meetingFileDownloadList(){
		logger.info("FileAction		meetingFileDownloadList	begin");
		PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
		try{
			//取出session中的用户信息,权限部分,将登录用户的userID存入不会用到的equipmentVO的equipmentID
			Object pUserVO = request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			UserVO userVO = (UserVO)pUserVO;
			UploadFileImpowerVO uploadFileImpowerVO = new UploadFileImpowerVO();
			uploadFileImpowerVO.setUserId(userVO.getUserID());
			uploadFileVO.setUploadFileImpowerVO(uploadFileImpowerVO);
			//uploadFileVO.setUploadType(FileEnum.MEETING_FILE);
			uploadFileVOList = ServiceFactory.getFileuploadService().queryByPower(uploadFileVO,pSplittor.getPControler());
		}catch(Exception e){
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		logger.info("FileAction		meetingFileDownloadList	end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * list EquipmentFile;
	 * @return
	 */
	public String manageEquipmentFileList(){
		logger.info("FileAction		manageEquipmentFileList	begin");
		PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
		try{
			uploadFileVO.setUploadType(FileEnum.EQUIPMENT_FILE);
			uploadFileVOList = ServiceFactory.getFileuploadService().query(uploadFileVO,pSplittor.getPControler());
		}catch(Exception e){
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		logger.info("FileAction		manageEquipmentFileList	end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * meetingFileDownloadList会议资料下载管理页面~文件级别
	 * @return
	 */
	public String detailMeetingFile(){
		logger.info("FileAction		detailMeetingFile	begin");
		try{
			String uploadId = request.getParameter("uploadId");
			Integer uploadType =Integer.valueOf(request.getParameter("uploadType"));
			uploadFileVO.setUploadType(uploadType);
			uploadFileVO.setUploadID(uploadId);
			uploadFileVOList = ServiceFactory.getFileuploadService().queryBaseInfo(uploadFileVO, null);
			if(uploadFileVOList!=null&&uploadFileVOList.size()>0){
				uploadFileVO = uploadFileVOList.get(0);
				//被授予下载权限的人员
				UploadFileImpowerVO uploadFileImpowerVO = new UploadFileImpowerVO();
				List<UploadFileImpowerVO> uiList = new ArrayList<UploadFileImpowerVO>();
				uploadFileImpowerVO.setUploadId(uploadFileVO.getUploadID());
				uploadFileImpowerVO.setStatus(FileEnum.STATUS_IMPOWER_DOWNLOAD);
				uiList = ServiceFactory.getUploadFileImpowerService().query(uploadFileImpowerVO, null);
				if(uiList!=null&&uiList.size()>0){
					String users = "";
					UserVO userVO = new UserVO();
					List<UserVO> uList = new ArrayList<UserVO>();
					for(UploadFileImpowerVO vo:uiList){
						userVO.setUserID(vo.getUserId());
						uList = ServiceFactory.getUserService().getUserList(userVO, null);
						if(uList!=null&& uList.size()>0){
							users += uList.get(0).getName();
							if(!"".equals(users)){
								users += ",";
							}
						}
					}
					users = users.substring(0,users.length()-1);
					uploadFileImpowerVO.setDescription(users);//此字段不会用到，暂时存放被授予下载权限人员，
					uploadFileVO.setUploadFileImpowerVO(uploadFileImpowerVO);
				}
				return REQUEST_SUCCESS;
			}
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		logger.info("FileAction		detailMeetingFile	end");
		return REQUEST_FAILURE;
	}
	
	/**
	 * delete File;
	 * @return String
	 */
	public String delFile(){
		logger.info("FileAction		delMeetingFile	begin");
		try{
			uploadFileVOList = ServiceFactory.getFileuploadService().query(uploadFileVO,null);
			if(uploadFileVOList!=null&&uploadFileVOList.size()>0){
				String filePath = ServletActionContext.getServletContext().getRealPath("/")+uploadFileVOList.get(0).getFileUrl();
				DelFileUtil.DeleteFolder(filePath);
			}
			ServiceFactory.getFileuploadService().deleteByID(uploadFileVO.getUploadID());//bug968	假删改为真删即可屏蔽20131227
			
		}catch(Exception e){
			request.setAttribute("info", "ϵͳ删除时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		logger.info("FileAction		delMeetingFile	end");
		if(FileEnum.MEETING_FILE == uploadFileVO.getUploadType()){
			UploadFileImpowerVO uploadFileImpowerVO = new UploadFileImpowerVO();
			uploadFileImpowerVO.setUploadId(uploadFileVO.getUploadID());
			try {
				ServiceFactory.getUploadFileImpowerService().delete(uploadFileImpowerVO);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return "SUCCESS_MEETING";
		}
		if(FileEnum.EQUIPMENT_FILE == uploadFileVO.getUploadType()){
			return "SUCCESS_EQUIPMENT";
		}
		if(FileEnum.MEETINGROOM_FILE == uploadFileVO.getUploadType()){
			return "SUCCESS_MEETINGROOM";
		}
		return REQUEST_FAILURE;
	}

	public String addMeetingFile(){
		logger.info("FileAction		addMeetingFile	start");
		try {
			String fileUrlArr = request.getParameter("fileUrlArr");
			fileUrlArr = new String(fileUrlArr.getBytes("ISO8859-1"), "UTF-8"); 
			String[] fileUrls = fileUrlArr.split(",/");
			uploadFileVO.setUploadType(FileEnum.MEETING_FILE);
			uploadFileVO.setStatus(FileEnum.STATUS_VALID);
			uploadFileVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			logger.info("FileAction		addMeetingFile	开始	上传");
			for(int i = 0;i<fileUrls.length;i++){
				String fileNameTemp ="";
				fileNameTemp = fileUrls[i].substring(fileUrls[i].lastIndexOf("/")+1);
				fileName = fileNameTemp.substring(0, (fileNameTemp.lastIndexOf(".")-14))+fileNameTemp.substring(fileNameTemp.lastIndexOf("."));
				if(i==0){
					uploadFileVO.setFileUrl(fileUrls[i]);
				}else{
					uploadFileVO.setFileUrl("/"+fileUrls[i]);
				}
				uploadFileVO.setFileName(fileName);
				uploadFileVO.setFileType(fileName.substring(fileName.lastIndexOf(".")+1));
				ServiceFactory.getFileuploadService().add(true,uploadFileVO);
			}
			logger.info("FileAction		addMeetingFile	结束 上传");
			//上传成功后取得刚上传的文件
			List<UploadFileVO> ufList = new ArrayList<UploadFileVO>();
			UploadFileVO ufVO = new UploadFileVO();
			ufVO.setUploadKey(uploadFileVO.getUploadKey());
			ufVO.setUploadType(uploadFileVO.getUploadType());
			ufVO.setCreateUserID(uploadFileVO.getCreateUserID());
			ufVO.setCreateTime(uploadFileVO.getCreateTime());
			ufList = ServiceFactory.getFileuploadService().queryBaseInfo(ufVO, null);
			if(ufList != null && ufList.size()>0){
				//与会人员给予可见权限，即该会议的参会人员;上传者赋予管理权限（？超级管理员）
				MeetingDetailUserVO vMeetingDetailUserVO = new MeetingDetailUserVO();
				List<MeetingDetailUserVO> aList = new ArrayList<MeetingDetailUserVO>();
				vMeetingDetailUserVO.setMeetingDetailID(uploadFileVO.getUploadKey());
				aList = ServiceFactory.getMeetingDetailUserService().getMeetingDetailUserList(vMeetingDetailUserVO, null);
				
				UploadFileImpowerVO uploadFileImpowerVO = new UploadFileImpowerVO();
				uploadFileImpowerVO.setCreateUserId(uploadFileVO.getCreateUserID());//文件上传者的UserId
				uploadFileImpowerVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
				//获取超级管理员的userId
				UserVO vUserVO = new UserVO();
				vUserVO.setLoginName(UserEnum.SUPER_ADMIN);
				String SUPER_ADMIN_ID = ServiceFactory.getUserService().getUserList(vUserVO, null).get(0).getUserID();
				logger.info("FileAction		addMeetingFile	开始 赋予文件权限");
				for(UploadFileVO vo:ufList){
					uploadFileImpowerVO.setUploadId(vo.getUploadID());
					uploadFileImpowerVO.setStatus(FileEnum.STATUS_IMPOWER_MANAGER);
					if(!uploadFileVO.getCreateUserID().equals(SUPER_ADMIN_ID)){//超级管理员有所有权限
						uploadFileImpowerVO.setUserId(SUPER_ADMIN_ID);
						ServiceFactory.getUploadFileImpowerService().add(uploadFileImpowerVO);
					}
					uploadFileImpowerVO.setUserId(uploadFileVO.getCreateUserID());
					ServiceFactory.getUploadFileImpowerService().add(uploadFileImpowerVO);
					if(aList!=null&&aList.size()>0){
						for(MeetingDetailUserVO mVO:aList){
							if(!mVO.getUserID().equals(uploadFileVO.getCreateUserID())){
								uploadFileImpowerVO.setStatus(FileEnum.STATUS_IMPOWER_VISIBLE);
								uploadFileImpowerVO.setUserId(mVO.getUserID());
								ServiceFactory.getUploadFileImpowerService().add(uploadFileImpowerVO);
							}
						}
					}
				}
				logger.info("FileAction		addMeetingFile	 赋予文件权限结束");
			}
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}
		logger.info("FileAction		addMeetingFile	end");
		return REQUEST_SUCCESS;
	}
	
	public String download() throws Exception {
		logger.info("download action execute...........");
		return "success";
	}
	//stream视图中已经指定用这个方法获得下载文件的输入流，
	public InputStream getInputStream() throws FileNotFoundException, UnsupportedEncodingException {
		String realPath = request.getParameter("fileName");
		try {   
			realPath = new String(realPath.getBytes("ISO8859-1"), "UTF-8");   
		} catch (UnsupportedEncodingException e) {   
		    e.printStackTrace();   
		} 
		InputStream in = ServletActionContext.getServletContext().getResourceAsStream(realPath);
		if(null==in){
			System.out.println("文件路徑出錯");
		}

		String serverFileName = realPath.substring(fileName.lastIndexOf("/")+1);
		String serverFileNameTemp = serverFileName.substring(0,serverFileName.lastIndexOf("."));
		serverFileNameTemp = serverFileNameTemp.substring(0,serverFileNameTemp.length()-14);//时间戳20130510163512
		
		StringBuffer sb = new StringBuffer();
		sb.append(serverFileNameTemp);
		sb.append(serverFileName.substring(serverFileName.lastIndexOf(".")));
		fileName = sb.toString();//除去时间戳之后的文件名
		fileName = new String(fileName.getBytes("gb2312"),"ISO8859-1");
		response.setHeader("Content-Disposition", "attachment;filename="+fileName);
        return in;
    }
	
	
	public String beforeRecordRelation(){
		try {
			String meetingDetailID = request.getParameter("meetingDetailID");
			String meetingName = request.getParameter("meetingName");
			meetingName = new String(meetingName.getBytes("iso-8859-1"),"utf-8");
			UploadFileVO uploadFileVO = new UploadFileVO();
			uploadFileVO.setUploadKey(meetingDetailID);
			uploadFileVO.setUploadType(FileEnum.MEETING_RECORD_FILE);
			//已经关联的文件
			List<UploadFileVO> fileList = ServiceFactory.getFileuploadService().query(uploadFileVO, null);
			
			FtpClientUtil fcu = new FtpClientUtil();
			fcu.connectServer();
			Map<String,String> fileMap = fcu.getFileList(MeetingAppConfig.FTP_LOCATION);
			fcu.closeServer();
			request.setAttribute("fileMap", fileMap);
			request.setAttribute("meetingDetailID", meetingDetailID);
			request.setAttribute("meetingName",meetingName);
			request.setAttribute("fileList", fileList);
		} catch (SocketException e) {
			e.printStackTrace();
			return ERROR;
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return REQUEST_SUCCESS;
	}
	
	public String getVideoFile(){
		
		
		try {
			//path = URLDecoder.decode(request.getParameter("path"), "utf-8");
			
			path = URLEncoder.encode(path,"iso-8859-1");
			fileName = new String(request.getParameter("fileName").getBytes("iso-8859-1"),"utf-8");
			fileName = URLEncoder.encode(URLEncoder.encode(fileName, "gbk"),"iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		
		
		return REQUEST_SUCCESS;
	}
	
	public UploadFileVO getUploadFileVO() {
		return uploadFileVO;
	}

	public void setUploadFileVO(UploadFileVO uploadFileVO) {
		this.uploadFileVO = uploadFileVO;
	}

	public List<UploadFileVO> getUploadFileVOList() {
		return uploadFileVOList;
	}

	public void setUploadFileVOList(List<UploadFileVO> uploadFileVOList) {
		this.uploadFileVOList = uploadFileVOList;
	}
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public MeetingDetailVO getMeetingDetailVO() {
		return meetingDetailVO;
	}

	public void setMeetingDetailVO(MeetingDetailVO meetingDetailVO) {
		this.meetingDetailVO = meetingDetailVO;
	}

	public List<MeetingDetailVO> getLst_conference() {
		return lst_conference;
	}

	public void setLst_conference(List<MeetingDetailVO> lstConference) {
		lst_conference = lstConference;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}
	
}
