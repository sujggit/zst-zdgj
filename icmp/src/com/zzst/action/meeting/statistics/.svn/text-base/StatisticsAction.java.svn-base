package com.zzst.action.meeting.statistics;

import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.util.tools.export.ExportFileObject;
import com.zzst.util.tools.export.ExportObjectHelp;
import com.zzst.util.tools.export.ecxel.CellVO;
import com.zzst.util.tools.export.ecxel.PngVO;

@SuppressWarnings("serial")
public class StatisticsAction extends CjfAction {
	private static Logger logger = CjfLogger.getLogger(StatisticsAction.class.getName());
	public ArrayList<MeetingRoomVO>  listMeetingRoom=new  ArrayList<MeetingRoomVO>();
	public MeetingRoomVO meetingRoomVO=new MeetingRoomVO();
	private InputStream  excelStream;
	private String modeChange;
	
	/**
	 * 导出时长
	 * @return
	 */
	private void setTitleOfLong(ArrayList<CellVO[]> list){
		CellVO[] cellTitle = new CellVO[3];
		CellVO ex0 = new CellVO();
		ex0.setValue("序号");
		cellTitle[0] = ex0;
		ex0 = new CellVO();
		ex0.setValue("会议室名称");
		cellTitle[1] = ex0;
		ex0 = new CellVO();
		ex0.setValue("使用时长");
		cellTitle[2] = ex0;
		
		list.add(cellTitle);
	}
	
	private void setTitleOfNum(ArrayList<CellVO[]> list){
		CellVO[] cellTitle = new CellVO[3];
		CellVO ex0 = new CellVO();
		ex0.setValue("序号");
		cellTitle[0] = ex0;
		ex0 = new CellVO();
		ex0.setValue("会议室名称");
		cellTitle[1] = ex0;
		ex0 = new CellVO();
		ex0.setValue("使用次数");
		cellTitle[2] = ex0;
	
		list.add(cellTitle);
	}

	//导出时长
	public String exportLongQuery(){
		//是列表模式时导出列表；
		logger.info("exportLongQuery	exportLongQuery	begin");
		if(modeChange.equals("tableShow")){
			try{
				listMeetingRoom=ServiceFactory.getStatisticsService().calculateMeetingRoom(meetingRoomVO,null );//getPageControler()
				for (MeetingRoomVO meetingRoom : listMeetingRoom) {
					if(meetingRoom.getUseTime()==null){
						meetingRoom.setUseTime("0");
					}else{
						String useTime = meetingRoom.getUseTime().substring(0, meetingRoom.getUseTime().length()-2);
						meetingRoom.setUseTime(useTime);
					}
				}
				String fileName = "exportLong.xls";
				ExportFileObject fileObj = new ExportFileObject();
				fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
				fileObj.setExportFileName(fileName);
				ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
				setTitleOfLong(list);//添加表头
				
				if(listMeetingRoom!=null&&listMeetingRoom.size()>0){
					
					for (int i = 0; i < listMeetingRoom.size(); i++) {
						MeetingRoomVO mVO = listMeetingRoom.get(i);
						CellVO[] cell = new CellVO[3];
						CellVO ex0 = new CellVO();
						ex0.setValue(i+1+"");
						cell[0] = ex0;
						
						CellVO ex1 = new CellVO();
						ex1.setValue(mVO.getMeetingRoomName());
						cell[1] = ex1;
						
						CellVO ex2 = new CellVO();
					     ex2.setValue(mVO.getUseTime());			
						cell[2] = ex2;
					
						list.add(cell);
						
					}
				}
				ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
		        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
			}catch(Exception e){
				logger.error("exportLongQuery	exportLongQuery	error:"+e.getMessage());
				return ERROR;
			}
			logger.info("exportLongQuery	exportLongQuery	end");
			return "success";
		}
		//是图像模式时导出图像
		if(modeChange.equals("picShow")){
			
			if(creatLongPng()){
				try{
					String fileName = "time.xls";
					ExportFileObject fileObj = new ExportFileObject();
					fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
					fileObj.setExportFileName(fileName);
					ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
					
					CellVO[] cell = new CellVO[5];
					CellVO ex0 = new CellVO();
					
					ex0.setValuetype(CellVO.TYPE_PNG);
					PngVO p = new PngVO();
					p.setHeight(10);
					p.setWidth(30);
					p.setFile(new File(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.STATISTICS_SRC+MeetingAppConfig.STATISTICS_TIME_NAME+".png"));
					ex0.setPngFile(p);
					cell[0] = ex0;
					list.add(cell);
					ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
			        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
				}catch(Exception e){
					return "error";	
				}
				return "success";
			}else{
				return "error";
			}
		}else{
			return "error";
			
		}
	}
	
	/**
	 * 导出次数
	 * @return
	public String exportLongQuery(){
		if(creatNumPng()){
			try{
				String fileName = "time.xls";
				ExportFileObject fileObj = new ExportFileObject();
				fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
				fileObj.setExportFileName(fileName);
				ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
				
				CellVO[] cell = new CellVO[5];
				CellVO ex0 = new CellVO();
				
				ex0.setValuetype(CellVO.TYPE_PNG);
				PngVO p = new PngVO();
				p.setHeight(10);
				p.setWidth(30);
				p.setFile(new File(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.STATISTICS_SRC+MeetingAppConfig.STATISTICS_COUNT_NAME+".png"));
				ex0.setPngFile(p);
				cell[0] = ex0;
				list.add(cell);
				ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
		        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
			}catch(Exception e){
				return "error";	
			}
			return "success";
		}else{
			return "error";
		}
	} */
	
	/**
	 * 导出次数
	 * @return
	 */
	public String exportNumberQuery(){
		logger.info("exportNumberQuery	exportNumberQuery	begin");
		try {
			if(modeChange.equals("tableShow")){
				String fileName = "number.xls";
				listMeetingRoom=ServiceFactory.getStatisticsService().calculateMeetingRoom(meetingRoomVO,null );//getPageControler()
				ExportFileObject fileObj = new ExportFileObject();
				fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
				fileObj.setExportFileName(fileName);
				ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
				setTitleOfNum(list);//添加表头

				if(listMeetingRoom!=null&&listMeetingRoom.size()>0){
					for (int i = 0; i < listMeetingRoom.size(); i++) {
						MeetingRoomVO mVO = listMeetingRoom.get(i);
						CellVO[] cell = new CellVO[3];
						CellVO ex0 = new CellVO();
						ex0.setValue(i+1+"");
						cell[0] = ex0;
						
						CellVO ex1 = new CellVO();
						ex1.setValue(mVO.getMeetingRoomName());
						cell[1] = ex1;
						
						CellVO ex2 = new CellVO();
					     ex2.setValue(mVO.getUseCount());
						cell[2] = ex2;
					
						list.add(cell);
					}
				}
				
				ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
		        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
			}else if(modeChange.equals("picShow")){
				if(creatNumPng()){
					String fileName = "number.xls";
					ExportFileObject fileObj = new ExportFileObject();
					fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
					fileObj.setExportFileName(fileName);
					ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
					
					CellVO[] cell = new CellVO[5];
					CellVO ex0 = new CellVO();
					
					ex0.setValuetype(CellVO.TYPE_PNG);
					PngVO p = new PngVO();
					p.setHeight(10);
					p.setWidth(30);
					p.setFile(new File(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.STATISTICS_SRC+MeetingAppConfig.STATISTICS_COUNT_NAME+".png"));
					ex0.setPngFile(p);
					cell[0] = ex0;
					list.add(cell);
					ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
			        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
				}else{
					return "error";
				}
			}else{
				return "error";
			}
		}catch (Exception e) {
			logger.error("exportLongQuery	exportLongQuery	error:"+e.getMessage());
			return "error";
		}
		logger.info("exportLongQuery	exportLongQuery	end");
		return "success";
	}
	
	/**
	 * 导出时长
	 * @return
	public String exportNumberQuery(){
		if(creatNumPng()){
			try{
				String fileName = "number.xls";
				ExportFileObject fileObj = new ExportFileObject();
				fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
				fileObj.setExportFileName(fileName);
				ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
				
				CellVO[] cell = new CellVO[5];
				CellVO ex0 = new CellVO();
				
				ex0.setValuetype(CellVO.TYPE_PNG);
				PngVO p = new PngVO();
				p.setHeight(10);
				p.setWidth(30);
				p.setFile(new File(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.STATISTICS_SRC+MeetingAppConfig.STATISTICS_TIME_NAME+".png"));
				ex0.setPngFile(p);
				cell[0] = ex0;
				list.add(cell);
				ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
		        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
			}catch(Exception e){
				return "error";	
			}
			return "success";
		}else{
			return "error";
		}
	}*/
	
	
	@SuppressWarnings("unchecked")
	public String query(){
		if(creatLongPng())
			return "success";
		else
			return "error";	
	}
	
	@SuppressWarnings("unchecked")
	public String queryNum(){
		if(creatNumPng())
			return "success";
		else
			return "error";	
	}
	
	public Timestamp convertTime(String timeParam){
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		 Timestamp convertTime = null;
		try {
			convertTime = new Timestamp(df.parse(timeParam).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 return convertTime;
	}
	
    private static CategoryDataset createNumDataset(ArrayList<MeetingRoomVO> lst_time)
    {
    	String s = "First";
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();

        for(int i=0;i<lst_time.size();i++){
        	MeetingRoomVO tTimeStatisticVO = lst_time.get(i);
        	defaultcategorydataset.addValue(Integer.valueOf(tTimeStatisticVO.getUseCount()).intValue(),s,tTimeStatisticVO.getMeetingRoomName());
        }

        return defaultcategorydataset;
    }
    
    private static CategoryDataset createLongDataset(ArrayList<MeetingRoomVO> lst_time)
    {
    	String s = "First";
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();

        for(int i=0;i<lst_time.size();i++){
        	MeetingRoomVO tTimeStatisticVO = lst_time.get(i);
        	if(tTimeStatisticVO.getUseTime()!=null){
        	defaultcategorydataset.addValue(Double.valueOf(tTimeStatisticVO.getUseTime()),s,tTimeStatisticVO.getMeetingRoomName());
        	}else{
          defaultcategorydataset.addValue(0,s,tTimeStatisticVO.getMeetingRoomName());	
        	}
        }

        return defaultcategorydataset;
    }

    private static JFreeChart createNumChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createBarChart("会议室使用次数统计", "", "", categorydataset, PlotOrientation.VERTICAL, false, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = jfreechart.getCategoryPlot();
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setDomainGridlinePaint(Color.white);
        categoryplot.setRangeGridlinePaint(Color.white);
        /****************设置柱状参数*********************/
        BarRenderer renderer = new BarRenderer(); 
        //设置柱子宽度
        renderer.setMaximumBarWidth(3);//0.1
        //设置柱子高度
        renderer.setMinimumBarLength(3);//0.2
        //设置柱子的颜色
        renderer.setSeriesPaint(0, new Color(233, 12, 123));
        renderer.setItemMargin(5); //0.5
        //显示每个柱的数值，并修改该数值的字体属性
        renderer.setIncludeBaseInRange(true);
        //将修改后的属性值保存到图中，这一步很重要，否则上面对颜色的设置都无效
        categoryplot.setRenderer(renderer);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis.setUpperMargin(0.14999999999999999D);
        CategoryItemRenderer categoryitemrenderer = categoryplot.getRenderer();
        categoryitemrenderer.setSeriesItemLabelsVisible(0, Boolean.TRUE);
        CategoryAxis categoryaxis = categoryplot.getDomainAxis();
        categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        Font xfont = new Font("宋体",Font.PLAIN,10) ;// X轴  12 
        categoryaxis.setLabelFont(xfont);
        categoryaxis.setTickLabelFont(xfont);
        return jfreechart;
    }
    
    private static JFreeChart createLongChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createBarChart("会议室使用时长统计", "", "", categorydataset, PlotOrientation.VERTICAL, false, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = jfreechart.getCategoryPlot();
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setDomainGridlinePaint(Color.white);
        categoryplot.setRangeGridlinePaint(Color.white);

        /****************设置柱状参数*********************/
        BarRenderer renderer = new BarRenderer(); 
        //设置柱子宽度
        renderer.setMaximumBarWidth(3); //0.1
        //设置柱子高度
        renderer.setMinimumBarLength(3);//0.2
        //设置柱子的颜色
        renderer.setSeriesPaint(0, new Color(233, 12, 123));
        renderer.setItemMargin(5);//0.5
             //显示每个柱的数值，并修改该数值的字体属性
        renderer.setIncludeBaseInRange(true);
             //将修改后的属性值保存到图中，这一步很重要，否则上面对颜色的设置都无效
        categoryplot.setRenderer(renderer);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis.setUpperMargin(0.14999999999999999D);
        CategoryItemRenderer categoryitemrenderer = categoryplot.getRenderer();
        categoryitemrenderer.setSeriesItemLabelsVisible(0, Boolean.TRUE);
        CategoryAxis categoryaxis = categoryplot.getDomainAxis();
        categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        Font xfont = new Font("宋体",Font.PLAIN,10) ;// X轴   12
        categoryaxis.setLabelFont(xfont);
        categoryaxis.setTickLabelFont(xfont);
        return jfreechart;
    }
  
    private boolean creatLongPng(){
		try {
			listMeetingRoom=ServiceFactory.getStatisticsService().calculateMeetingRoom(meetingRoomVO,getPageControler() );//getPageControler()
			for (MeetingRoomVO meetingRoom : listMeetingRoom) {
				if(meetingRoom.getUseTime()==null){
					meetingRoom.setUseTime("0");
				}else{
					String useTime = meetingRoom.getUseTime().substring(0, meetingRoom.getUseTime().length()-2);
					meetingRoom.setUseTime(useTime);
				}
			}
			ArrayList<MeetingRoomVO>listMeetingRoom_=ServiceFactory.getStatisticsService().calculateMeetingRoom(meetingRoomVO,null );//getPageControler()
			 
			CategoryDataset categorydataset;
			 ArrayList newMeetingTimeList = new ArrayList();
			if(null!=listMeetingRoom_&&listMeetingRoom_.size()>20){
				 newMeetingTimeList = new ArrayList(listMeetingRoom_.subList(0,20)) ;
				 categorydataset = createLongDataset(newMeetingTimeList);
			 }else{
				 categorydataset = createLongDataset(listMeetingRoom_);//listMeetingRoom
			 }
	         JFreeChart jfreechart = createLongChart(categorydataset);
	         String sFont = "宋体"; 
	         jfreechart.getTitle().setFont(new Font(sFont,Font.BOLD,10)); //14
             String roomUseTimeImageName = MeetingAppConfig.STATISTICS_TIME_NAME+".png";
            this.getServletRequest().setAttribute("roomUseTimeImageName", roomUseTimeImageName);
	         File file = new File(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.STATISTICS_SRC+roomUseTimeImageName);	
			 ChartUtilities.saveChartAsPNG(file, jfreechart, MeetingAppConfig.STATISTICS_IMAGE_WIDTH,MeetingAppConfig.STATISTICS_IMAGE_HEIGTH);
			for (MeetingRoomVO meetingRoom : listMeetingRoom_) {
				if(meetingRoom.getUseTime()==null){
					meetingRoom.setUseTime("0");
				}else{
					String useTime = meetingRoom.getUseTime().substring(0, meetingRoom.getUseTime().length()-2);
					meetingRoom.setUseTime(useTime);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return	false;
		}
		return true;
	}
    
    //getPageControler()
    private boolean creatNumPng(){
		try {
			 listMeetingRoom=ServiceFactory.getStatisticsService().calculateMeetingRoom(meetingRoomVO, getPageControler());//getPageControler()
			ArrayList<MeetingRoomVO> listMeetingRoom_=ServiceFactory.getStatisticsService().calculateMeetingRoom(meetingRoomVO, null);//getPageControler()
			 
			 
			 CategoryDataset categorydataset;
			 ArrayList newMeetingTimeList = new ArrayList();
			if(null!=listMeetingRoom_&&listMeetingRoom_.size()>20){
				 newMeetingTimeList = new ArrayList(listMeetingRoom_.subList(0,20)) ;
				 categorydataset = createNumDataset(newMeetingTimeList);
			 }else{
				 categorydataset = createNumDataset(listMeetingRoom_);
			 }
	         JFreeChart jfreechart = createNumChart(categorydataset);
	         String sFont = "黑体"; 
	         jfreechart.getTitle().setFont(new Font(sFont,Font.BOLD,13));
	         jfreechart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
            String roomUseTimeImageName = MeetingAppConfig.STATISTICS_COUNT_NAME+".png";
            this.getServletRequest().setAttribute("roomUseTimeImageName", roomUseTimeImageName);
	         File file = new File(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.STATISTICS_SRC+roomUseTimeImageName);	
			 ChartUtilities.saveChartAsPNG(file, jfreechart, MeetingAppConfig.STATISTICS_IMAGE_WIDTH,MeetingAppConfig.STATISTICS_IMAGE_HEIGTH);
		} catch (Exception e) {
			e.printStackTrace();
			return	false;
		}
		return true;
	}
    
	public ArrayList<MeetingRoomVO> getListMeetingRoom() {
		return listMeetingRoom;
	}

	public void setListMeetingRoom(ArrayList<MeetingRoomVO> listMeetingRoom) {
		this.listMeetingRoom = listMeetingRoom;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public String getModeChange() {
		return modeChange;
	}

	public void setModeChange(String modeChange) {
		this.modeChange = modeChange;
	}
	
}
