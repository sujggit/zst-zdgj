package com.zzst.action.meeting.log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.log4j.Logger;
import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.meeting.GeneralMeetingAction;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.meeting.log.LogVO;
import com.zzst.util.tools.export.ExportFileObject;
import com.zzst.util.tools.export.ExportObjectHelp;
import com.zzst.util.tools.export.ecxel.CellVO;


/**
 *@Description
 *@date 2011-12-14下午07:53:57
 *@author ryan
 */
public class LoginAction  extends CjfAction {
 
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(LoginAction.class.getName());
	
	private LogVO logVO = new LogVO();
	private ArrayList<LogVO> logVOList = new ArrayList<LogVO>();
	private InputStream  excelStream;
	
	
	
	/**
	 * 查询列表
	 * @return
	 */
	public String query(){
		logger.info("LoginAction	query	begin");////日志输出.
		try{
			logVOList = ServiceFactory.getLogService().query(logVO, getPageControler());
			System.out.println("----:"+logVOList.size());
		}catch(Exception e){
			logger.error("LoginAction	query	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("LoginAction	query	end");
		return "success";
	}
	
	/**
	 * 删除
	 * add by tanzanlong
	 * @return
	 */
	public String DelLog(){
		logger.info("LoginAction	DelLog	begin");////日志输出.
		try{
		
			String id=logVO.getLogID();
			System.out.println(id+"id......................................");
			ServiceFactory.getLogService().deleteByIDs(id);
		
		}catch(Exception e){
			logger.error("LoginAction	DelLog	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("LoginAction	DelLog	end");
		return "success";
	}
	
	/**
	 * 查询日志详细内容 add by liujf 20131203
	 * @return
	 */
	public String detail(){
		logger.info("LoginAction	detail	begin");////日志输出.
		try{
			
			String id = logVO.getLogID();
			logVO.setLogID(id);
			logVOList = ServiceFactory.getLogService().queryInital(logVO, null);
			if(logVOList!=null&&logVOList.size()>0){
				logVO = logVOList.get(0);
			}
		}catch(Exception e){
			logger.error("LoginAction	detail	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("LoginAction	detail	end");
		return "success";
	}
	
	/**
	 * 导出
	 * @return
	 */
	public String exportQuery(){
		logger.info("LoginAction	exportQuery	begin");
		String[] title = {"序号","日志类型","日志描述","操作时间","操作人"};
		int maxSize = 30000;//定义excel导出单个sheet的最大值，超过本数量自动放入下一个sheet	add by xiongshun20140124
		try{
			logVOList = ServiceFactory.getLogService().query(logVO, null);
			String fileName = "log.xls";
//			File file=new File(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+"费用统计.xls");
			OutputStream ops = new FileOutputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+"log.xls");
			WritableWorkbook wb = Workbook.createWorkbook(ops);
			int size = logVOList.size()/maxSize + 1;
			for(int i=0;i<size;i++){
				int index0 = i*maxSize;
				int index1 = (i+1)*maxSize;
				if((i+1)*maxSize>=logVOList.size()){
					index1 = logVOList.size();
				}
				WritableSheet sheet = wb.createSheet("第"+(i+1)+"页", i);//创建sheet
				Label label;
				for(int j=0;j<title.length;j++){
					label = new Label(j,0,title[j]);
					sheet.addCell(label);
				}
				for(int j=index0;j<index1;j++){
					int currIndex = j+1-index0;
					sheet.addCell(new Label(0,currIndex,(j+1)+""));
					
					LogVO lVO = logVOList.get(j);
					for(String[] s : LogEnum.getLogType()){
						 if(s==null)	continue;
						 if(s[0].equalsIgnoreCase(lVO.getLogType()+"")){
							 sheet.addCell(new Label(1,currIndex,s[1]));
							 continue;
						 }
					 }
					sheet.addCell(new Label(2,currIndex,lVO.getOperatorContent()));
					sheet.addCell(new Label(3,currIndex,lVO.getOperatorDate()+""));
					sheet.addCell(new Label(4,currIndex,lVO.getUserName()));
				}
			}
			
			wb.write();
			wb.close();
			ops.flush();
			ops.close();
			
	        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);// ByteArrayInputStream(excelString.getBytes(), 0, excelString.length());
			
		}catch(Exception e){
			logger.error("LoginAction	exportQuery	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("LoginAction	exportQuery	end");
		return "success";
	}
	
	private void setTitle(ArrayList<CellVO[]> list){
		CellVO[] cellTitle = new CellVO[5];
		CellVO ex0 = new CellVO();
		ex0.setValue("序号");
		cellTitle[0] = ex0;
		ex0 = new CellVO();
		ex0.setValue("日志类型");
		cellTitle[1] = ex0;
		ex0 = new CellVO();
		ex0.setValue("日志描述");
		cellTitle[2] = ex0;
		ex0 = new CellVO();
		ex0.setValue("操作时间");
		cellTitle[3] = ex0;
		ex0 = new CellVO();
		ex0.setValue("操作人");
		cellTitle[4] = ex0;
		list.add(cellTitle);
	}
	public InputStream getExcelStream() {
		return excelStream;
	}


	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}


	public LogVO getLogVO() {
		return logVO;
	}


	public void setLogVO(LogVO logVO) {
		this.logVO = logVO;
	}


	public ArrayList<LogVO> getLogVOList() {
		return logVOList;
	}


	public void setLogVOList(ArrayList<LogVO> logVOList) {
		this.logVOList = logVOList;
	}


}
