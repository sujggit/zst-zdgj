package com.zzst.action.meeting.statistics.for5k;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.gsiec.cjf.system.CjfAction;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.dictionary.DictionaryVO;
import com.zzst.model.meeting.equipment.maintain.EquipmentMaintainVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.view.VmeetingVO;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;

/**
 * 统计导出
 * @author John.Zhang
 *
 */
public class VmeetingExcelAction extends CjfAction {
	private static final long serialVersionUID = -1360496765900473839L;

	ArrayList<VmeetingVO> evlist=new ArrayList<VmeetingVO>();
	ArrayList<VmeetingVO> evlist2=new ArrayList<VmeetingVO>();
	ArrayList<VmeetingVO> evlistPie=new ArrayList<VmeetingVO>();
	List<VmeetingVO> emeetList=new ArrayList<VmeetingVO>();
    ArrayList<Integer> eyearList=new ArrayList<Integer>();
    VmeetingVO efindvm=new VmeetingVO();
    EquipmentMaintainVO equipmentMaintainVO=new	EquipmentMaintainVO();
    private InputStream  excelStream;
    WritableCellFormat wcfColor = new WritableCellFormat();//内容标题样式
    WritableCellFormat blankStyle = new WritableCellFormat();//空白或内容样式

	public VmeetingExcelAction() {
		super();
		try {
			Border b=Border.ALL;
			BorderLineStyle ls=BorderLineStyle.THIN;  
			wcfColor.setBackground(Colour.GRAY_25);
			wcfColor.setBorder(b, ls);
			wcfColor.setWrap(true);
			blankStyle.setBorder(b, ls);
			blankStyle.setAlignment(Alignment.CENTRE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据会议室统计
	 * @author zhangjy
	 * @date 2014-01-17
	 */
	public String viewRoomTotalExport(){
		VmeetingVO tempvm=new VmeetingVO();
		 ///////////////统计分级分权 @author:zhangjy///////////////////////////
		UserVO suv = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
		if(MeetingAppConfig.LEVEL_IS_POEN){
			if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
				tempvm.setLevel(true);
				tempvm.setLsql(suv.getLvoids());
			}
		}
        /////////////////////////////////end/////////////////////////////////////
		if(efindvm.getViewMeetingYear()!=null&&efindvm.getViewMeetingYear()!=0){
			tempvm.setViewMeetingYear(efindvm.getViewMeetingYear());
		}else{
			 GregorianCalendar g=new GregorianCalendar();
			 int currentYear=(int)g.get(Calendar.YEAR);
			 tempvm.setViewMeetingYear(currentYear);
		}
		if(efindvm.getViewMeetingMonth()!=null&&efindvm.getViewMeetingMonth()!=0){
			tempvm.setViewMeetingMonth(efindvm.getViewMeetingMonth());
		}
		MeetingRoomVO meetingRoomVO=new MeetingRoomVO();
		List<MeetingRoomVO> meetingRoomVOList=new ArrayList<MeetingRoomVO>();
		try {
			meetingRoomVOList=ServiceFactory.getMeetingRoomService().query(meetingRoomVO, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	    Set<String> tempSet=new HashSet<String>();
	    for(MeetingRoomVO m:meetingRoomVOList){
	    tempSet.add(m.getMeetingRoomName()+","+m.getMeetingRoomID());
	    }
	   
	    for(String s:tempSet){
	    	VmeetingVO temp=new VmeetingVO();
	    	VmeetingVO tempvm2=new VmeetingVO();
	    	if(efindvm.getViewMeetingYear()!=null&&efindvm.getViewMeetingYear()!=0){
				tempvm2.setViewMeetingYear(efindvm.getViewMeetingYear());
			}else{
				 GregorianCalendar g=new GregorianCalendar();
				 int currentYear=(int)g.get(Calendar.YEAR);
				 tempvm2.setViewMeetingYear(currentYear);
			}
			if(efindvm.getViewMeetingMonth()!=null&&efindvm.getViewMeetingMonth()!=0){
				tempvm2.setViewMeetingMonth(efindvm.getViewMeetingMonth());
			}
			tempvm2.setViewMeetingRoomName(s.split(",")[0]);
          
	    	List<VmeetingVO> templist2=ServiceFactory.getVmeetingService().getAll(tempvm2, null);	    	
	        temp.setViewMeetingDeptName(s.split(",")[0]);
	        temp.setViewMeetRoomId(s.split(",")[1]);
	        temp.setViewMeetingMonth(templist2.size());
	        float longh=0.00f;
	        for(VmeetingVO vv: templist2){
	        longh+=vv.getViewTimeLong();
	        }
	   
	        temp.setViewTimeLong(longh);
	        evlist.add(temp);
	    }

	   
	    Collections.sort(evlist, new VmeetingSortByCS());
	    
	    try {
	    	String excelname="meetroomList.xls";
			 WritableWorkbook book  =  Workbook.createWorkbook( new  File(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+excelname));
			  for(int i=0;i<evlist.size();i++){
				 VmeetingVO vvexcl=evlist.get(i);
				 VmeetingVO serchvo=new VmeetingVO();
				 serchvo.setViewMeetRoomId(vvexcl.getViewMeetRoomId());
				 serchvo.setViewMeetingYear(tempvm.getViewMeetingYear());
				 serchvo.setViewMeetingMonth(tempvm.getViewMeetingMonth());
				 //////////////////////////填充sheet//////////////////
	     		if(MeetingAppConfig.LEVEL_IS_POEN){
	     			if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
	     				serchvo.setLevel(true);
	     				serchvo.setLsql(suv.getLvoids());
	     			}
	     		}
	             /////////////////////////////////end/////////////////////////////////////
	     		emeetList=ServiceFactory.getVmeetingService().getAll(serchvo, null);
				 if(!(emeetList.size()>0))continue;	
				 
				 WritableSheet sheet  =  book.createSheet(vvexcl.getViewMeetingDeptName() ,  i );
	             String[] titleName={"序号","会议名称","开始时间","结束时间","会议类型","预约人"};
	             for(int t=0;t<titleName.length;t++){
	            	 sheet.addCell(new Label(t ,0,titleName[t],wcfColor)); 
	             }
	             for(int index=1;index<=emeetList.size();index++){
	            	 VmeetingVO vvrow=emeetList.get(index-1);
	            	 String meetType="视频会议";
	            	 if(vvrow.getViewMeetingType().toString().equals("1")){
	            		 meetType="本地会议";
	            	 }
	            	 String[] rowCont={""+index,vvrow.getViewMeetingName(),
	            			 this.formatDate(vvrow.getViewStartTime()),
	            			 this.formatDate(vvrow.getViewEndTime()),
	            			 meetType,vvrow.getViewUserName()};
	            	 for(int t=0;t<rowCont.length;t++){
		            	 sheet.addCell(new Label(t ,index,rowCont[t],blankStyle)); 
		             }
	             }
	     		
			    }
			 book.write();
             book.close();
             excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+excelname);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	     
	    return SUCCESS;
	}
	
   /**
     * 按月份统计导出
     * @author zhangjy
     * @return
     */
    public String viewMonthTotal(){
		VmeetingVO tempvm=new VmeetingVO();
		
		
		if(efindvm.getViewMeetingYear()!=null&&efindvm.getViewMeetingYear()!=0){
			tempvm.setViewMeetingYear(efindvm.getViewMeetingYear());
		}
		if(efindvm.getStrsql()!=null){
			tempvm.setStrsql(efindvm.getStrsql());
		}
		
	    Set<Integer> tempSet=new HashSet<Integer>();
	    for(int i=1;i<=12;i++){
	    	tempSet.add(i);
	    }
	    for(Integer s:tempSet){
	    	VmeetingVO temp=new VmeetingVO();
	    	VmeetingVO tempvm2=new VmeetingVO();
	    	tempvm2.setViewMeetingYear(efindvm.getViewMeetingYear());
	    	tempvm2.setViewMeetingMonth(s);
	    	tempvm2.setStrsql(efindvm.getStrsql());
	    	  /////////////// @author:zhangjy///////////////////////////
			UserVO suv = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if(MeetingAppConfig.LEVEL_IS_POEN){
				if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
					tempvm2.setLevel(true);
					tempvm2.setLsql(suv.getLvoids());
				}
			}
	        /////////////////////////////////end/////////////////////////////////////
	    	List<VmeetingVO> templist2=ServiceFactory.getVmeetingService().getAllGroupBY(tempvm2, null);	    	
	        temp.setViewMeetingDeptName(s+"月");
	        temp.setViewMeetingType(s);
	        temp.setViewMeetingMonth(templist2.size());
	        String strs="";
	        float longh=0.00f;
	     
	        for(VmeetingVO vv: templist2){
	        	strs+=" "+vv.getViewMeetingName();
	        	longh+=vv.getViewTimeLong();
	        }
	      
	        temp.setViewMeetingName(strs);
	        temp.setViewTimeLong(longh);
	        evlist.add(temp);
	    }
	        
	        try {
		    	String excelname="meetMonthList.xls";
				 WritableWorkbook book  =  Workbook.createWorkbook( new  File(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+excelname));
				
				 for(int i=0;i<evlist.size();i++){
					 VmeetingVO vvexcl=evlist.get(i);
					 VmeetingVO serchvo=new VmeetingVO();
					 serchvo.setViewMeetingMonth(vvexcl.getViewMeetingType());
					 if(efindvm.getViewMeetingYear()!=null&&efindvm.getViewMeetingYear()!=0){
						 serchvo.setViewMeetingYear(efindvm.getViewMeetingYear());
						}
						if(efindvm.getStrsql()!=null){
						serchvo.setStrsql(efindvm.getStrsql());
						}
			
		             /////////////////////////////////end/////////////////////////////////////
		     		emeetList=getMeetingInfoList(serchvo);
					 if(!(emeetList.size()>0))continue;	
					 
					 WritableSheet sheet  =  book.createSheet(vvexcl.getViewMeetingDeptName() ,  i );
		             String[] titleName={"序号","会议名称","开始时间","会议类型","会议标签","参会人数","预约人"};
		             for(int t=0;t<titleName.length;t++){
		            	 sheet.addCell(new Label(t ,0,titleName[t],wcfColor)); 
		             }
		             for(int index=1;index<=emeetList.size();index++){
		            	 VmeetingVO vvrow=emeetList.get(index-1);
		            	 String meetType="视频会议";
		            	 if(vvrow.getViewMeetingType().toString().equals("1")){
		            		 meetType="本地会议";
		            	 }
		            	 String[] rowCont={""+index,vvrow.getViewMeetingName(),
		            			 this.formatDate(vvrow.getViewStartTime()),
		            			 meetType,vvrow.getViewMeetingInfo(),""+vvrow.getViewManNum(),vvrow.getViewUserName()};
		            	 for(int t=0;t<rowCont.length;t++){
			            	 sheet.addCell(new Label(t ,index,rowCont[t],blankStyle)); 
			             }
		             }
		     		
				    }
				 book.write();
	             book.close();
	             excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+excelname);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (RowsExceededException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
	        
	    
	    
     
	    return SUCCESS;
	}
	
    /**
     * 按照部门统计
     * @return
     */
	public String viewDeptTotal(){
		VmeetingVO tempvm=new VmeetingVO();
		UserVO suv = (UserVO)getCurHttpServletRequest().getSession().getAttribute("user_session");
	    if ((MeetingAppConfig.LEVEL_IS_POEN) && 
	      (!suv.getLvoids().contains("'a-0'"))) {
	      tempvm.setLevel(true);
	      tempvm.setLsql(suv.getLvoids());
	    }

	    if ((this.efindvm.getViewMeetingYear() != null) && (this.efindvm.getViewMeetingYear().intValue() != 0)) {
	      tempvm.setViewMeetingYear(this.efindvm.getViewMeetingYear());
	    }
	    if ((this.efindvm.getViewMeetingMonth() != null) && (this.efindvm.getViewMeetingMonth().intValue() != 0)) {
	      tempvm.setViewMeetingMonth(this.efindvm.getViewMeetingMonth());
	    }
	    if(efindvm.getStrsql()!=null){
			tempvm.setStrsql(efindvm.getStrsql());
		}
	    List<VmeetingVO> templist = ServiceFactory.getVmeetingService().getAll(tempvm, null);
	    Set<String> tempSet = new HashSet<String>();
	    for (VmeetingVO v : templist) {
	      tempSet.add(v.getViewMeetingDeptName());
	    }
	    for (String s : tempSet) {
	      VmeetingVO temp = new VmeetingVO();
	      VmeetingVO tempvm2 = new VmeetingVO();
	      if ((this.efindvm.getViewMeetingYear() != null) && (this.efindvm.getViewMeetingYear().intValue() != 0)) {
	        tempvm2.setViewMeetingYear(this.efindvm.getViewMeetingYear());
	      }
	      if ((this.efindvm.getViewMeetingMonth() != null) && (this.efindvm.getViewMeetingMonth().intValue() != 0)) {
	        tempvm2.setViewMeetingMonth(this.efindvm.getViewMeetingMonth());
	      }
	      if(efindvm.getStrsql()!=null){
				tempvm2.setStrsql(efindvm.getStrsql());
			}
	      tempvm2.setViewMeetingDeptName(s);

	      if ((MeetingAppConfig.LEVEL_IS_POEN) && 
	        (!suv.getLvoids().contains("'a-0'"))) {
	        tempvm2.setLevel(true);
	        tempvm2.setLsql(suv.getLvoids());
	      }

	      List<VmeetingVO> templist2 = ServiceFactory.getVmeetingService().getAllGroupBY(tempvm2, null);
	      temp.setViewMeetingDeptName(s);
	      temp.setViewMeetingMonth(Integer.valueOf(templist2.size()));
	      String strs = "";
	      float longh = 0.0F;

	      for (VmeetingVO vv : templist2) {
	        strs = strs + " " + vv.getViewMeetingName();
	        longh += vv.getViewTimeLong();
	      }

	      temp.setViewMeetingName(strs);
	      temp.setViewTimeLong(longh);
	      this.evlist.add(temp);
	    }
	    
	    try {
	    	String excelname="meetDepList.xls";
			 WritableWorkbook book  =  Workbook.createWorkbook( new  File(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+excelname));
			
			 for(int i=0;i<evlist.size();i++){
				 VmeetingVO vvexcl=evlist.get(i);
				 VmeetingVO serchvo=new VmeetingVO();
				serchvo.setViewMeetingDeptName(vvexcl.getViewMeetingDeptName());
				   if(efindvm.getViewMeetingYear()!=null&&efindvm.getViewMeetingYear()!=0){
					 serchvo.setViewMeetingYear(efindvm.getViewMeetingYear());
					}
					if(efindvm.getStrsql()!=null){
					serchvo.setStrsql(efindvm.getStrsql());
					}
		
	             /////////////////////////////////end/////////////////////////////////////
	     		emeetList=getMeetingInfoList(serchvo);
				 if(!(emeetList.size()>0))continue;	
				 
				 WritableSheet sheet  =  book.createSheet(vvexcl.getViewMeetingDeptName() ,  i );
	             String[] titleName={"序号","会议名称","开始时间","会议类型","会议标签","参会人数","预约人"};
	             for(int t=0;t<titleName.length;t++){
	            	 sheet.addCell(new Label(t ,0,titleName[t],wcfColor)); 
	             }
	             for(int index=1;index<=emeetList.size();index++){
	            	 VmeetingVO vvrow=emeetList.get(index-1);
	            	 String meetType="视频会议";
	            	 if(vvrow.getViewMeetingType().toString().equals("1")){
	            		 meetType="本地会议";
	            	 }
	            	 String[] rowCont={""+index,vvrow.getViewMeetingName(),
	            			 this.formatDate(vvrow.getViewStartTime()),
	            			 meetType,vvrow.getViewMeetingInfo(),""+vvrow.getViewManNum(),vvrow.getViewUserName()};
	            	 for(int t=0;t<rowCont.length;t++){
		            	 sheet.addCell(new Label(t ,index,rowCont[t],blankStyle)); 
		             }
	             }
	     		
			    }
			 book.write();
             book.close();
             excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+excelname);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
        

	    return "success";
	}
	
	/**
	 * 根据标标签导出
	 * @author zhangjy
	 * @date 2013-09-26
	 */
	public String viewNoticeTotal(){
		VmeetingVO tempvm=new VmeetingVO();
	  	  ///////////////统计分级分权 @author:zhangjy///////////////////////////
			UserVO suv = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if(MeetingAppConfig.LEVEL_IS_POEN){
				if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
					tempvm.setLevel(true);
					tempvm.setLsql(suv.getLvoids());
				}
			}
	        /////////////////////////////////end/////////////////////////////////////
			if(efindvm.getViewMeetingYear()!=null&&efindvm.getViewMeetingYear()!=0){
				tempvm.setViewMeetingYear(efindvm.getViewMeetingYear());
			}
			if(efindvm.getViewMeetingMonth()!=null&&efindvm.getViewMeetingMonth()!=0){
				tempvm.setViewMeetingMonth(efindvm.getViewMeetingMonth());
			}
			if(efindvm.getStrsql()!=null){
				tempvm.setStrsql(efindvm.getStrsql());
			}
			 DictionaryVO dv=new DictionaryVO();
		     dv.setDicType("meetLable");
		     ArrayList<DictionaryVO> dvList=new ArrayList<DictionaryVO>();
			try {
				dvList = ServiceFactory.getDictionaryService().query(dv, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		        
		    Set<String> tempSet=new HashSet<String>();
		    for(DictionaryVO v:dvList){
		    	tempSet.add(v.getDicViewName());
		    }
		    
		    for(String s:tempSet){
		    	VmeetingVO temp=new VmeetingVO();
		    	VmeetingVO tempvm2=new VmeetingVO();
		    	////////////////////////分级分权//////////////////
	    		if(MeetingAppConfig.LEVEL_IS_POEN){
	    			if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
		    			tempvm2.setLevel(true);
		    			tempvm2.setLsql(suv.getLvoids());
		    		}
		    	}
		    	/////////////////////////////////////////////////////////
		    	if(efindvm.getViewMeetingYear()!=null&&efindvm.getViewMeetingYear()!=0){
					tempvm2.setViewMeetingYear(efindvm.getViewMeetingYear());
				}
				if(efindvm.getViewMeetingMonth()!=null&&efindvm.getViewMeetingMonth()!=0){
					tempvm2.setViewMeetingMonth(efindvm.getViewMeetingMonth());
				}
				if(efindvm.getStrsql()!=null){
					tempvm2.setStrsql(efindvm.getStrsql());
				}
		    	tempvm2.setViewMeetingInfo(s);
		    	List<VmeetingVO> templist2=ServiceFactory.getVmeetingService().getAllGroupBY(tempvm2, null);	    	
		        temp.setViewMeetingDeptName(s);
		        temp.setViewMeetingMonth(templist2.size());
		        String strs="";
		        float longh=0.00f;
		     
		        for(VmeetingVO vv: templist2){
		        	strs+=" "+vv.getViewMeetingName();
		        	longh+=vv.getViewTimeLong();
		        }
		      
		        temp.setViewMeetingName(strs);
		        temp.setViewTimeLong(longh);
		        evlist.add(temp);
		    }
		   
	    
	    try {
	    	String excelname="meetNoticeList.xls";
			 WritableWorkbook book  =  Workbook.createWorkbook( new  File(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+excelname));
			 for(int i=0;i<evlist.size();i++){
				 VmeetingVO vvexcl=evlist.get(i);
				 VmeetingVO serchvo=new VmeetingVO();
				 serchvo.setViewMeetingInfo(vvexcl.getViewMeetingDeptName());
				   if(efindvm.getViewMeetingYear()!=null&&efindvm.getViewMeetingYear()!=0){
					 serchvo.setViewMeetingYear(efindvm.getViewMeetingYear());
					}
					if(efindvm.getStrsql()!=null){
					serchvo.setStrsql(efindvm.getStrsql());
					}
		
	             /////////////////////////////////end/////////////////////////////////////
	     		emeetList=getMeetingInfoList(serchvo);
				 if(!(emeetList.size()>0))continue;	
				 
				 WritableSheet sheet  =  book.createSheet(vvexcl.getViewMeetingDeptName() ,  i );
	             String[] titleName={"序号","会议名称","开始时间","会议类型","会议标签","参会人数","预约人"};
	             for(int t=0;t<titleName.length;t++){
	            	 sheet.addCell(new Label(t ,0,titleName[t],wcfColor)); 
	             }
	             for(int index=1;index<=emeetList.size();index++){
	            	 VmeetingVO vvrow=emeetList.get(index-1);
	            	 String meetType="视频会议";
	            	 if(vvrow.getViewMeetingType().toString().equals("1")){
	            		 meetType="本地会议";
	            	 }
	            	 String[] rowCont={""+index,vvrow.getViewMeetingName(),
	            			 this.formatDate(vvrow.getViewStartTime()),
	            			 meetType,vvrow.getViewMeetingInfo(),""+vvrow.getViewManNum(),vvrow.getViewUserName()};
	            	 for(int t=0;t<rowCont.length;t++){
		            	 sheet.addCell(new Label(t ,index,rowCont[t],blankStyle)); 
		             }
	             }
	     		
			    }
			 book.write();
             book.close();
             excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+excelname);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
        
	    return SUCCESS;
	}
	
    
	/**
	 * 根据类型统计
	 * @author zhangjy
	 * @date 2013-09-26
	 */
	public String viewTypeTotal(){
		VmeetingVO tempvm=new VmeetingVO();
		 ///////////////统计分级分权 @author:zhangjy///////////////////////////
		UserVO suv = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
		if(MeetingAppConfig.LEVEL_IS_POEN){
			if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
				tempvm.setLevel(true);
				tempvm.setLsql(suv.getLvoids());
			}
		}
        /////////////////////////////////end/////////////////////////////////////
		if(efindvm.getViewMeetingYear()!=null&&efindvm.getViewMeetingYear()!=0){
			tempvm.setViewMeetingYear(efindvm.getViewMeetingYear());
		}
		if(efindvm.getViewMeetingMonth()!=null&&efindvm.getViewMeetingMonth()!=0){
			tempvm.setViewMeetingMonth(efindvm.getViewMeetingMonth());
		}
		if(efindvm.getStrsql()!=null){
			tempvm.setStrsql(efindvm.getStrsql());
		}
	    Set<String> tempSet=new HashSet<String>();
	    tempSet.add(MeetingDetailEnum.TYPE_GENERAL_NAME);
	    tempSet.add(MeetingDetailEnum.TYPE_VEDIO_NAME);
	    for(String s:tempSet){
	    	VmeetingVO temp=new VmeetingVO();
	    	VmeetingVO tempvm2=new VmeetingVO();
           ////////////////////////分级分权//////////////////
    		if(MeetingAppConfig.LEVEL_IS_POEN){
    			if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
	    			tempvm2.setLevel(true);
	    			tempvm2.setLsql(suv.getLvoids());
	    		}
	    	}
	    	/////////////////////////////////////////////////////////
	    	if(efindvm.getViewMeetingYear()!=null&&efindvm.getViewMeetingYear()!=0){
				tempvm2.setViewMeetingYear(efindvm.getViewMeetingYear());
			}
			if(efindvm.getViewMeetingMonth()!=null&&efindvm.getViewMeetingMonth()!=0){
				tempvm2.setViewMeetingMonth(efindvm.getViewMeetingMonth());
			}
			if(efindvm.getStrsql()!=null){
				tempvm2.setStrsql(efindvm.getStrsql());
			}
			if(s.equals(MeetingDetailEnum.TYPE_GENERAL_NAME)){
			temp.setViewMeetingType(MeetingDetailEnum.TYPE_GENERAL);
	    	tempvm2.setViewMeetingType(MeetingDetailEnum.TYPE_GENERAL);
			}else if(s.equals(MeetingDetailEnum.TYPE_VEDIO_NAME)){
			temp.setViewMeetingType(MeetingDetailEnum.TYPE_VEDIO);
			tempvm2.setViewMeetingType(MeetingDetailEnum.TYPE_VEDIO);
			}
	    	List<VmeetingVO> templist2=ServiceFactory.getVmeetingService().getAllGroupBY(tempvm2, null);	    	
	        temp.setViewMeetingDeptName(s);
	        temp.setViewMeetingMonth(templist2.size());
	        String strs="";
	        float longh=0.00f;
	     
	        for(VmeetingVO vv: templist2){
	        	strs+=" "+vv.getViewMeetingName();
	        	longh+=vv.getViewTimeLong();
	        }
	      
	        temp.setViewMeetingName(strs);
	        temp.setViewTimeLong(longh);
	        evlist.add(temp);
	    }
	    try {
	    	String excelname="meetTypeList.xls";
			 WritableWorkbook book  =  Workbook.createWorkbook( new  File(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+excelname));
			 for(int i=0;i<evlist.size();i++){
				 VmeetingVO vvexcl=evlist.get(i);
				 VmeetingVO serchvo=new VmeetingVO();
				 serchvo.setViewMeetingType(vvexcl.getViewMeetingType());
				   if(efindvm.getViewMeetingYear()!=null&&efindvm.getViewMeetingYear()!=0){
					 serchvo.setViewMeetingYear(efindvm.getViewMeetingYear());
					}
					if(efindvm.getStrsql()!=null){
					serchvo.setStrsql(efindvm.getStrsql());
					}
		
	             /////////////////////////////////end/////////////////////////////////////
	     		emeetList=getMeetingInfoList(serchvo);
				 if(!(emeetList.size()>0))continue;	
				 
				 WritableSheet sheet  =  book.createSheet(vvexcl.getViewMeetingDeptName() ,  i );
	             String[] titleName={"序号","会议名称","开始时间","会议类型","会议标签","参会人数","预约人"};
	             for(int t=0;t<titleName.length;t++){
	            	 sheet.addCell(new Label(t ,0,titleName[t],wcfColor)); 
	             }
	             for(int index=1;index<=emeetList.size();index++){
	            	 VmeetingVO vvrow=emeetList.get(index-1);
	            	 String meetType="视频会议";
	            	 if(vvrow.getViewMeetingType().toString().equals("1")){
	            		 meetType="本地会议";
	            	 }
	            	 String[] rowCont={""+index,vvrow.getViewMeetingName(),
	            			 this.formatDate(vvrow.getViewStartTime()),
	            			 meetType,vvrow.getViewMeetingInfo(),""+vvrow.getViewManNum(),vvrow.getViewUserName()};
	            	 for(int t=0;t<rowCont.length;t++){
		            	 sheet.addCell(new Label(t ,index,rowCont[t],blankStyle)); 
		             }
	             }
	     		
			    }
			 book.write();
             book.close();
             excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+excelname);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
        
	    return SUCCESS;
	}
	
    
    

	
	public String getMeetingInfoListExport(){
		VmeetingVO  tempvm2 =new VmeetingVO();
		if(efindvm.getViewMeetingYear()!=null&&efindvm.getViewMeetingYear()!=0){
			tempvm2.setViewMeetingYear(efindvm.getViewMeetingYear());
		}
		if(efindvm.getViewMeetingMonth()!=null&&efindvm.getViewMeetingMonth()!=0){
			tempvm2.setViewMeetingMonth(efindvm.getViewMeetingMonth());
		}
		if(efindvm.getStrsql()!=null){
			tempvm2.setStrsql(efindvm.getStrsql());
		}
		List<VmeetingVO> vlists=getMeetingInfoList(tempvm2);
		
		try {
	    	String excelname="meetList.xls";
			 WritableWorkbook book  =  Workbook.createWorkbook( new  File(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+excelname));
				 WritableSheet sheet  =  book.createSheet("会议列表" ,  0);
	             String[] titleName={"序号","会议名称","开始时间","会议类型","会议标签","参会人数","预约人"};
	             for(int t=0;t<titleName.length;t++){
	            	 sheet.addCell(new Label(t ,0,titleName[t],wcfColor)); 
	             }
	             for(int index=1;index<=vlists.size();index++){
	            	 VmeetingVO vvrow=vlists.get(index-1);
	            	 String meetType="视频会议";
	            	 if(vvrow.getViewMeetingType().toString().equals("1")){
	            		 meetType="本地会议";
	            	 }
	            	 String[] rowCont={""+index,vvrow.getViewMeetingName(),
	            			 this.formatDate(vvrow.getViewStartTime()),
	            meetType,vvrow.getViewMeetingInfo(),""+vvrow.getViewManNum(),vvrow.getViewUserName()};
	            	 for(int t=0;t<rowCont.length;t++){
		            	 sheet.addCell(new Label(t ,index,rowCont[t],blankStyle)); 
		             }
	             }
	     		
			 book.write();
             book.close();
             excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+excelname);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
        
             return this.SUCCESS;
	} 
	
	public List<VmeetingVO> getMeetingInfoList(VmeetingVO vmeetingVO){
		if(MeetingAppConfig.LEVEL_IS_POEN){
			UserVO suv = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
				vmeetingVO.setLevel(true);
				vmeetingVO.setLsql(suv.getLvoids());
 			}
 		}
		List<VmeetingVO> vlists=ServiceFactory.getVmeetingService().getAllGroupBY(vmeetingVO, null);
		
		return vlists;
	} 
	

	
	public ArrayList<VmeetingVO> getEvlist() {
		return evlist;
	}

	public void setEvlist(ArrayList<VmeetingVO> evlist) {
		this.evlist = evlist;
	}

	public List<VmeetingVO> getEmeetList() {
		return emeetList;
	}

	public void setEmeetList(List<VmeetingVO> emeetList) {
		this.emeetList = emeetList;
	}

	public VmeetingVO getEfindvm() {
		return efindvm;
	}

	public void setEfindvm(VmeetingVO efindvm) {
		this.efindvm = efindvm;
	}

	public EquipmentMaintainVO getEquipmentMaintainVO() {
		return equipmentMaintainVO;
	}

	public void setEquipmentMaintainVO(EquipmentMaintainVO equipmentMaintainVO) {
		this.equipmentMaintainVO = equipmentMaintainVO;
	}

	private String formatDate(Timestamp time){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String dateStr= df.format(new Date(time.getTime()));
		return dateStr;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public ArrayList<VmeetingVO> getEvlist2() {
		return evlist2;
	}

	public void setEvlist2(ArrayList<VmeetingVO> evlist2) {
		this.evlist2 = evlist2;
	}

	public ArrayList<VmeetingVO> getEvlistPie() {
		return evlistPie;
	}

	public void setEvlistPie(ArrayList<VmeetingVO> evlistPie) {
		this.evlistPie = evlistPie;
	}

	public ArrayList<Integer> getEyearList() {
		return eyearList;
	}

	public void setEyearList(ArrayList<Integer> eyearList) {
		this.eyearList = eyearList;
	}

	public WritableCellFormat getWcfColor() {
		return wcfColor;
	}

	public void setWcfColor(WritableCellFormat wcfColor) {
		this.wcfColor = wcfColor;
	}

	public WritableCellFormat getBlankStyle() {
		return blankStyle;
	}

	public void setBlankStyle(WritableCellFormat blankStyle) {
		this.blankStyle = blankStyle;
	}
	
	
	
	
}
