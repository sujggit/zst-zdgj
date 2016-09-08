package com.zzst.action.meeting.meeting;

import java.io.File;
import java.sql.Timestamp;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.cbf.log.CbfLogger;
import com.gsiec.cbf.util.FileUtil;
import com.gsiec.cjf.system.CjfAction;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.enums.FileEnum;
import com.zzst.model.meeting.uploadFile.UploadFileVO;

public class FileUploadAction extends CjfAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = CbfLogger.getLogger(FileUploadAction.class
			.getName());
	private File[] myFile;// 实际上传文件
	private String[] myFileContentType; // 文件的内容类型
	private String[] myFileFileName; // 上传文件名
	private String savePath;
	private String meetingDetailID;
	private String meetingName;

	public void fileupload() throws Exception {
		logger.info("FileUploadAction execute begin.........");
		System.out.println(savePath);
		String path = ServletActionContext.getServletContext().getRealPath(savePath);
		if(!new File(path).isDirectory()){   //判断文件夹是否存在，不存在新建
			new File(path).mkdir();
		}
		
		// 获得路径
		for (int i = 0; i < myFile.length; i++) {
			UploadFileVO uploadFileVO = new UploadFileVO();
			String myPath = path + "/" + this.myFileFileName[i];
			System.out.println(myPath);
			// String URL=myPath+myFileFileName[i];
			uploadFileVO.setFileUrl("url");
			System.out.println(myFileFileName[i]);
			uploadFileVO.setCreateUserID("1");
			uploadFileVO
					.setCreateTime(new Timestamp(System.currentTimeMillis()));
			uploadFileVO.setUploadType(FileEnum.MEETING_FILE);
			uploadFileVO.setFileName(myFileFileName[i]);
			System.out.println("upload zhogn de meetingdetailid is"
					+ meetingDetailID);
			uploadFileVO.setUploadKey(meetingDetailID);
			//InputStream is = new FileInputStream(myFile[i]);
			//OutputStream os = new FileOutputStream(myPath);
			try {
				File currentFile=new File(path, this.myFileFileName[i]);
				ServiceFactory.getFileuploadService().add(true,uploadFileVO);
				FileUtil.copy(myFile[i],currentFile);
				//byte[] temp = new byte[1024];
				//int len = 0;
				//while ((len = is.read(temp)) > 0) {
					//os.write(temp, 0, len);
				//}
				//HttpServletResponse response=getServletResponse();
				//response.setCharacterEncoding("UTF-8");
				//PrintWriter out=getServletResponse().getWriter();				
				//String alert="<script >alert('恭喜你，成功上传！');</script>";
				//out.print(alert);
				//out.flush();
				//out.close();

			} catch (Exception e) {

				e.printStackTrace();
				addActionError(e.getMessage());
				
			} finally {
				//os.close();
				//is.close();
			}
			return;

		}

		

	}

	public File[] getMyFile() {
		return myFile;
	}

	public void setMyFile(File[] myFile) {
		this.myFile = myFile;
	}

	public String[] getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String[] myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String[] getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String[] myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getMeetingDetailID() {
		return meetingDetailID;
	}

	public void setMeetingDetailID(String meetingDetailID) {
		this.meetingDetailID = meetingDetailID;
	}

	public String getMeetingName() {
		return meetingName;
	}

	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}

}
