package com.zzst.action.meeting.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.MeetingAppConfig;



public class HelperAction extends CjfAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(HelperAction.class.getName());
	private InputStream  excelStream;
	String fileName = "helper.docx";
	private String contentDisposition;
	/**
	 *页头帮助对应的的导出功能
	 * @return
	 */
	public String HerlperexportQuery(){
		logger.info("HelperAction	HerlperexportQuery	begin");
	
		logger.info("HelperAction	HerlperexportQuery	end");
		return SUCCESS;
	}
	public InputStream getExcelStream() {
		return excelStream;
	}
	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
	
	
	public InputStream getInputStream() throws FileNotFoundException {
		String 	path =ServletActionContext.getServletContext().getRealPath(MeetingAppConfig.HELPER_SRC)+"/"+this.fileName;
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

	
	
}
