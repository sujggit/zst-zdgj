package com.zzst.action.meeting.meeting;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.cbf.log.CbfLogger;
import com.gsiec.cjf.system.CjfAction;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.meeting.uploadFile.UploadFileVO;

public class DownLoadAction extends CjfAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fileName; 
	private String savePath;
	private static Logger logger = CbfLogger.getLogger(DownLoadAction.class
			.getName());	
	private String contentDisposition;
	private String meetingName;
	private String meetingDetailID;
	
	public String download() throws Exception {
		System.out.println("download action execute...........");
		return "success";
	}
	
	
	public String getdownloadlist() throws Exception {
		System.out.println("进入列表页。。。。"+meetingName+"    "+meetingDetailID);
		ArrayList<UploadFileVO> list=new ArrayList<UploadFileVO>();
		UploadFileVO uploadFileVO=new UploadFileVO();
		uploadFileVO.setUploadKey(meetingDetailID);
		list=ServiceFactory.getFileuploadService().query(uploadFileVO, null);
		System.out.println("DownLoadAction中Action查找的list size="+list.size());
		this.getCurHttpServletRequest().setAttribute("upload_list", list);
		return "SUCCESS";
	}
	
	
	
	
	//stream视图中已经指定用这个方法获得下载文件的输入流，
	public InputStream getInputStream() throws FileNotFoundException {
	String 	path =ServletActionContext.getServletContext().getRealPath(savePath)+"/"+this.fileName;
		System.out.println(path);
		System.out.println("inputStream path.................");	
		System.out.println(this.fileName);
		InputStream is = new FileInputStream(path);
		return is;
	}

	

	public String getContentDisposition() {
		return contentDisposition;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

		


	public String getFileName() {
		return fileName;
	}

	public String getDownloadChineseFileName() {   
			        String downloadChineseFileName = fileName;   
	  
		        try {   
		           downloadChineseFileName = new String(downloadChineseFileName.getBytes(), "ISO8859-1");   
		        } catch (UnsupportedEncodingException e) {   
		            e.printStackTrace();   
		        }   
		  
		        return downloadChineseFileName;   
			    }   
		  

	

	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}


	public String getMeetingName() {
		return meetingName;
	}


	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}


	public String getMeetingDetailID() {
		return meetingDetailID;
	}


	public void setMeetingDetailID(String meetingDetailID) {
		this.meetingDetailID = meetingDetailID;
	}
	
}