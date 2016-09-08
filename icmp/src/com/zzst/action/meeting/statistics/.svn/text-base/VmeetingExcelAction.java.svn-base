package com.zzst.action.meeting.statistics;

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
	
	
	
	
	
	public ArrayList<VmeetingVO> getEvlist() {
		return evlist;
	}

	public void setEvlist(ArrayList<VmeetingVO> evlist) {
		this.evlist = evlist;
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

	public List<VmeetingVO> getEmeetList() {
		return emeetList;
	}

	public void setEmeetList(List<VmeetingVO> emeetList) {
		this.emeetList = emeetList;
	}

	public ArrayList<Integer> getEyearList() {
		return eyearList;
	}

	public void setEyearList(ArrayList<Integer> eyearList) {
		this.eyearList = eyearList;
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
	
	
	
	
}
