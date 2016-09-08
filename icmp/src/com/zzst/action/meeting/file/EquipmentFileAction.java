package com.zzst.action.meeting.file;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cbf.log.CbfLogger;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.model.enums.FileEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.uploadFile.UploadFileImpowerVO;
import com.zzst.model.meeting.uploadFile.UploadFileVO;
import com.zzst.model.meeting.user.UserVO;

/**
 * EquipmentFileAction设备资料管理
 * @author xiongshun
 * 2013-08-28 14:24:59
 */
public class EquipmentFileAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;

	private static Logger logger = CbfLogger.getLogger(EquipmentFileAction.class.getName());
	
	private UploadFileVO uploadFileVO = new UploadFileVO();
	private List<UploadFileVO> uploadFileVOList = new ArrayList<UploadFileVO>();
	
	private EquipmentVO equipmentVO = new EquipmentVO();
	private ArrayList<EquipmentVO> equipmentVOList = new ArrayList<EquipmentVO>();
	
	private String fileName;
	
	/**
	 * list manageEquipmentFileList;设备资料管理页面~会议级别
	 * @return
	 */
	public String manageEquipmentFileList(){
		logger.info("EquipmentFileAction	manageEquipmentFileList		begin");
		try{
			equipmentVOList=ServiceFactory.getEquipmentService().query(equipmentVO, null);
			int equipmentTypes= equipmentVO.getEquipmentType();
			this.request.setAttribute("equipmentTypes", equipmentTypes);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			return REQUEST_FAILURE;	
		}
		logger.info("EquipmentFileAction	manageEquipmentFileList		end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * equipmentFileDownloadList设备资料下载管理页面~文件级别
	 * @return
	 */
	public String equipmentFileDownloadList(){
		logger.info("EquipmentFileAction		equipmentFileDownloadList		begin");
		try{
			//取出session中的用户信息,权限部分,将登录用户的userID存入不会用到的equipmentVO的equipmentID
			Object pUserVO = request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			UserVO userVO = (UserVO)pUserVO;
			UploadFileImpowerVO uploadFileImpowerVO = new UploadFileImpowerVO();
			uploadFileImpowerVO.setUserId(userVO.getUserID());
			//uploadFileVO.setUploadFileImpowerVO(uploadFileImpowerVO);
			uploadFileVO.setUploadType(FileEnum.EQUIPMENT_FILE);
			uploadFileVOList = ServiceFactory.getFileuploadService().queryByPower(uploadFileVO,null);
		}catch(Exception e){
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		logger.info("EquipmentFileAction		equipmentFileDownloadList	end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * @return
	 */
	public String detailEquipmentFile(){
		logger.info("EquipmentFileAction		detailEquipmentFile		begin");
		try{
			uploadFileVOList = ServiceFactory.getFileuploadService().queryByPower(uploadFileVO,null);
			if(uploadFileVOList!=null&&uploadFileVOList.size()>0){
				uploadFileVO = uploadFileVOList.get(0);
			}
		}catch(Exception e){
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		logger.info("EquipmentFileAction		detailEquipmentFile		end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * 设备资料文件上传后保存至数据库
	 * @return
	 */
	public String addEquipmentFile(){
		logger.info("EquipmentFileAction		addEquipmentFile	start");
		try {
			String fileUrlArr = request.getParameter("fileUrlArr");
			fileUrlArr = new String(fileUrlArr.getBytes("ISO8859-1"), "UTF-8"); 
			String[] fileUrls = fileUrlArr.split(",/");
			uploadFileVO.setUploadType(FileEnum.EQUIPMENT_FILE);
			uploadFileVO.setStatus(FileEnum.STATUS_VALID);
			uploadFileVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			logger.info("EquipmentFileAction		addEquipmentFile	开始	上传设备资料文件");
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
			logger.info("EquipmentFileAction		addEquipmentFile	设备资料文件 结束 上传");
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}
		logger.info("EquipmentFileAction		addEquipmentFile	end");
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

	public EquipmentVO getEquipmentVO() {
		return equipmentVO;
	}

	public void setEquipmentVO(EquipmentVO equipmentVO) {
		this.equipmentVO = equipmentVO;
	}

	public ArrayList<EquipmentVO> getEquipmentVOList() {
		return equipmentVOList;
	}

	public void setEquipmentVOList(ArrayList<EquipmentVO> equipmentVOList) {
		this.equipmentVOList = equipmentVOList;
	}

}
