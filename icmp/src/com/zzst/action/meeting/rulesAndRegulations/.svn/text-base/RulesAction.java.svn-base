package com.zzst.action.meeting.rulesAndRegulations;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.cbf.log.CbfLogger;
import com.cbf.web.util.PageSplittor;
import com.zzst.action.meeting.util.DelFileUtil;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.model.enums.FileEnum;
import com.zzst.model.meeting.uploadFile.UploadFileVO;
import com.zzst.service.meeting.uploadFile.UploadFileService;
import com.zzst.service.meeting.uploadFile.UploadFileServiceImpl;

/**
 * rules action
 * @author xiongshun
 * 2013-05-07 11:24:59 AM
 */
public class RulesAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;

	private static Logger logger = CbfLogger.getLogger(RulesAction.class.getName());
	
	private UploadFileVO uploadFileVO = new UploadFileVO();
	private List<UploadFileVO> uploadFileVOList = new ArrayList<UploadFileVO>();
	
	private String fileName;
	/**
	 * add a rules
	 * @return
	 */
	public String addRules() {
		logger.info("RulesAction		addRules	begin");
		try {	
			UploadFileService uploadFileService = new UploadFileServiceImpl();
			uploadFileVO.setUploadType(FileEnum.RULE_FILE);
			uploadFileVO.setStatus(FileEnum.STATUS_VALID);
			uploadFileService.add(true,uploadFileVO);
		} catch (Exception e) {
			request.setAttribute("info", "ϵͳ添加规章制度时发生异常！");
			logger.error(e.getMessage());
			return "failure_meeting";
		}
		logger.info("RulesAction		addRules	end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * edit a rules
	 * @return
	 */
	public String getRulesInfo(){
		logger.info("RulesAction		getRulesInfo	begin");
		try{
			UploadFileService uploadFileService = new UploadFileServiceImpl();
			uploadFileVOList = uploadFileService.query(uploadFileVO, null);
			if(uploadFileVOList != null && uploadFileVOList.size() > 0){
				uploadFileVO = uploadFileVOList.get(0);
			}
		}catch(Exception e){
			request.setAttribute("info", "ϵͳ获取规章制度信息时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		logger.info("RulesAction		getRulesInfo	end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * modify a rules
	 * @return
	 */
	public String modifyRules(){
		logger.info("RulesAction		modifyRules	begin");
		try{
			UploadFileService uploadFileService = new UploadFileServiceImpl();
			uploadFileService.modify(uploadFileVO);
		}catch(Exception e){
			request.setAttribute("info", "ϵͳ修改规章制度信息时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		logger.info("RulesAction		modifyRules	end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * list rules;
	 * @return
	 */
	public String manageRulesList(){
		logger.info("RulesAction		manageRulesList	begin");
		PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
		try{
			UploadFileService uploadFileService = new UploadFileServiceImpl();
			uploadFileVO.setUploadType(FileEnum.RULE_FILE);
			uploadFileVOList = uploadFileService.query(uploadFileVO,pSplittor.getPControler());
		}catch(Exception e){
			request.setAttribute("info", "ϵͳ获取规章制度列表时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		logger.info("RulesAction		manageRulesList	end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * delete rules;
	 * @return String
	 */
	public String delRules(){
		logger.info("RulesAction		delRules	begin");
		try{
			uploadFileVO.setUploadType(FileEnum.RULE_FILE);
			uploadFileVOList = ServiceFactory.getFileuploadService().query(uploadFileVO,null);
			if(uploadFileVOList!=null&&uploadFileVOList.size()>0){
				String filePath = ServletActionContext.getServletContext().getRealPath("/")+uploadFileVOList.get(0).getFileUrl();
				DelFileUtil.DeleteFolder(filePath);
			}
			UploadFileService uploadFileService = new UploadFileServiceImpl();
			uploadFileService.delFileForState(uploadFileVO.getUploadID());
		}catch(Exception e){
			request.setAttribute("info", "ϵͳ删除规章制度时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		logger.info("RulesAction		delRules	end");
		return REQUEST_SUCCESS;
	}

	public String download() throws Exception {
		System.out.println("download action execute...........");
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
}
