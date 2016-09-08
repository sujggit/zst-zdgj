package com.zzst.action.meeting.file;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cbf.log.CbfLogger;
import com.cbf.web.util.PageSplittor;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.model.enums.FileEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.uploadFile.UploadFileImpowerVO;
import com.zzst.model.meeting.uploadFile.UploadFileVO;
import com.zzst.model.meeting.user.UserVO;

/**
 * MeetingRoomFileAction会议室资料管理
 * @author xiongshun
 * 2013-08-27 11:24:59 AM
 */
public class MeetingRoomFileAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;

	private static Logger logger = CbfLogger.getLogger(MeetingRoomFileAction.class.getName());
	
	private UploadFileVO uploadFileVO = new UploadFileVO();
	private List<UploadFileVO> uploadFileVOList = new ArrayList<UploadFileVO>();
	
	private	MeetingRoomVO	meetingRoomVO = new MeetingRoomVO();
	private ArrayList<MeetingRoomVO> meetingRoomVOList = new ArrayList<MeetingRoomVO>();
	
	private String fileName;
	
	/**
	 * list MeetingRoomFile;会议室资料管理页面~会议级别
	 * @return
	 */
	public String manageMeetingRoomFileList(){
		logger.info("MeetingRoomFileAction	manageMeetingRoomFileList		begin");
		PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
		try{
			meetingRoomVOList=ServiceFactory.getMeetingRoomService().query(meetingRoomVO, pSplittor.getPControler());
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			return REQUEST_FAILURE;	
		}
		logger.info("MeetingRoomFileAction	manageMeetingRoomFileList		end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * MeetingRoomFileDownload会议室资料下载管理页面~文件级别
	 * @return
	 */
	public String meetingRoomFileDownloadList(){
		logger.info("MeetingRoomFileAction		meetingRoomFileDownloadList		begin");
		PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
		try{
			//取出session中的用户信息,权限部分,将登录用户的userID存入不会用到的equipmentVO的equipmentID
			Object pUserVO = request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			UserVO userVO = (UserVO)pUserVO;
			UploadFileImpowerVO uploadFileImpowerVO = new UploadFileImpowerVO();
			uploadFileImpowerVO.setUserId(userVO.getUserID());
			//uploadFileVO.setUploadFileImpowerVO(uploadFileImpowerVO);
			uploadFileVO.setUploadType(FileEnum.MEETINGROOM_FILE);
			uploadFileVOList = ServiceFactory.getFileuploadService().queryByPower(uploadFileVO,pSplittor.getPControler());
		}catch(Exception e){
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		logger.info("MeetingRoomFileAction		meetingFileDownloadList	end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * @return
	 */
	public String detailMeetingRoomFile(){
		logger.info("MeetingRoomFileAction		detailMeetingRoomFile	begin");
		try{
			PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
			uploadFileVOList = ServiceFactory.getFileuploadService().queryByPower(uploadFileVO,pSplittor.getPControler());
			if(uploadFileVOList!=null&&uploadFileVOList.size()>0){
				uploadFileVO = uploadFileVOList.get(0);
			}
		}catch(Exception e){
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		logger.info("MeetingRoomFileAction		detailMeetingRoomFile	end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * 会议室资料文件上传后保存至数据库
	 * @return
	 */
	public String addMeetingRoomFile(){
		logger.info("MeetingRoomFileAction		addMeetingRoomFile	start");
		try {
			String fileUrlArr = request.getParameter("fileUrlArr");
			fileUrlArr = new String(fileUrlArr.getBytes("ISO8859-1"), "UTF-8"); 
			String[] fileUrls = fileUrlArr.split(",/");
			uploadFileVO.setUploadType(FileEnum.MEETINGROOM_FILE);
			uploadFileVO.setStatus(FileEnum.STATUS_VALID);
			uploadFileVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			logger.info("MeetingRoomFileAction		addMeetingRoomFile	开始	上传会议室资料文件");
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
			logger.info("MeetingRoomFileAction		addMeetingRoomFile	会议室资料文件 结束 上传");
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}
		logger.info("MeetingRoomFileAction		addMeetingRoomFile	end");
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


	public MeetingRoomVO getMeetingRoomVO() {
		return meetingRoomVO;
	}

	public void setMeetingRoomVO(MeetingRoomVO meetingRoomVO) {
		this.meetingRoomVO = meetingRoomVO;
	}

	public ArrayList<MeetingRoomVO> getMeetingRoomVOList() {
		return meetingRoomVOList;
	}

	public void setMeetingRoomVOList(ArrayList<MeetingRoomVO> meetingRoomVOList) {
		this.meetingRoomVOList = meetingRoomVOList;
	}
	
}
