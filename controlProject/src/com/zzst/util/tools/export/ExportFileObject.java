package com.zzst.util.tools.export;


/**
 *@Description	导出文件的属性
 *@date 2012-6-26下午06:59:38
 *@author ryan
 */
public class ExportFileObject {

	public static final	String exportType_word = "1";
	public static final	String exportType_ppt = "2";
	public static final	String exportType_excel = "3";
	
	public static final	String objDateType_int = "1";
	public static final	String objDateType_double = "2";
	public static final	String objDateType_String = "3";
	public static final	String objDateType_date = "4";
	
	/**
	 * 导出文档类型
	 */
	private String  exportFileType = "";
	
	/**
	 * 导出文档名称
	 * 如：test.xls
	 */
	private String  exportFileName = "";
	
	/**
	 * 导出文档创建者
	 */
	private String  exportFileCreatUserName = "";
	
	/**
	 * 导出文档的绝对路径
	 * 已“/”结尾
	 */
	private String  exportFilePath = "";
	
	
	
	public String getExportFileType() {
		return exportFileType;
	}

	public void setExportFileType(String exportFileType) {
		this.exportFileType = exportFileType;
	}

	public String getExportFileName() {
		return exportFileName;
	}

	public void setExportFileName(String exportFileName) {
		this.exportFileName = exportFileName;
	}

	public String getExportFileCreatUserName() {
		return exportFileCreatUserName;
	}

	public void setExportFileCreatUserName(String exportFileCreatUserName) {
		this.exportFileCreatUserName = exportFileCreatUserName;
	}

	public String getExportFilePath() {
		return exportFilePath;
	}

	public void setExportFilePath(String exportFilePath) {
		this.exportFilePath = exportFilePath;
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
}
