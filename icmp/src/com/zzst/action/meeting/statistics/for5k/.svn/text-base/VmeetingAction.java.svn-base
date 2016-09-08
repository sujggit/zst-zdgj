package com.zzst.action.meeting.statistics.for5k;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gsiec.cjf.system.CjfAction;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.enums.VmeetingDetailEnum;
import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.dictionary.DictionaryVO;
import com.zzst.model.meeting.equipment.maintain.EquipmentMaintainVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.view.VmeetingVO;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
public class VmeetingAction extends CjfAction {
	private static final long serialVersionUID = -1360496765900473839L;

	ArrayList<VmeetingVO> vlist=new ArrayList<VmeetingVO>();
	ArrayList<VmeetingVO> vlist2=new ArrayList<VmeetingVO>();
	ArrayList<VmeetingVO> vlistPie=new ArrayList<VmeetingVO>();
	List<VmeetingVO> meetList=new ArrayList<VmeetingVO>();
    ArrayList<Integer> yearList=new ArrayList<Integer>();
    VmeetingVO findvm=new VmeetingVO();
    EquipmentMaintainVO equipmentMaintainVO=new	EquipmentMaintainVO();
    
    String info="";
    
	String strsql;
	String[][] strtype;
	String[][] strname;
   
    //是否打印
	private String isPrint = null;
    public String getIsPrint() {
		return isPrint;
	}
	public void setIsPrint(String isPrint) {
		this.isPrint = isPrint;
	}

	/**
     * 按月份统计
     * @author zhangjy
     * @return
     */
    public String viewMonthTotal(){
		VmeetingVO tempvm=new VmeetingVO();
		
		GregorianCalendar g=new GregorianCalendar();
	    int nowY=(int)g.get(Calendar.YEAR);
		if(findvm.getViewMeetingYear()!=null&&findvm.getViewMeetingYear()!=0){
			tempvm.setViewMeetingYear(findvm.getViewMeetingYear());
		}
		if(findvm.getStrsql()!=null){
			tempvm.setStrsql(findvm.getStrsql());
		}
		
	    Set<Integer> tempSet=new HashSet<Integer>();
	    for(int i=1;i<=12;i++){
	    	tempSet.add(i);
	    }
	    for(Integer s:tempSet){
	    	VmeetingVO temp=new VmeetingVO();
	    	VmeetingVO tempvm2=new VmeetingVO();
	    	tempvm2.setViewMeetingYear(findvm.getViewMeetingYear());
	    	tempvm2.setViewMeetingMonth(s);
	    	tempvm2.setStrsql(findvm.getStrsql());
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
	        vlist.add(temp);
	    }
	    
        for(int i=nowY;i>=(nowY-5);i--){
        	yearList.add(i);
        }
	    for(int i=0;i<vlist.size()&&i<12;i++){
	    	vlist2.add(vlist.get(i));
	    }
	    isPrint = null;
		isPrint = getServletRequest().getParameter("isPrint");
	    return SUCCESS;
	}
	
    public VmeetingVO getVmeeting(VmeetingVO vm){
    	vm.setViewDeptPid(null);
    	VmeetingVO temp=new VmeetingVO();
    	List<VmeetingVO> templist2=ServiceFactory.getVmeetingService().getAllChildGroupBY(vm, null);
    	if(templist2!=null&&templist2.size()>0){
    		//temp.setViewMeetingDeptName(vo.getTitle());
	        temp.setViewMeetingMonth(templist2.size());
	        String strs="";
	        float longh=0.00f;
	     
	        for(VmeetingVO vv: templist2){
	        	strs+=vv.getViewMeetingName()+",";
	        	longh+=vv.getViewTimeLong();
	        }
	      
	        temp.setViewMeetingName(strs);
	        temp.setViewTimeLong(longh);
    	}else{
    		//temp.setViewMeetingName(vo.getTitle());
    		//temp.setViewMeetingMonth(templist2.size());
    		temp.setViewMeetingName("");
    		temp.setViewMeetingMonth(templist2.size());
    		temp.setViewTimeLong(0);
    	}
    	return temp;
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

	    if ((this.findvm.getViewMeetingYear() != null) && (this.findvm.getViewMeetingYear().intValue() != 0)) {
	      tempvm.setViewMeetingYear(this.findvm.getViewMeetingYear());
	    }
	    if ((this.findvm.getViewMeetingMonth() != null) && (this.findvm.getViewMeetingMonth().intValue() != 0)) {
	      tempvm.setViewMeetingMonth(this.findvm.getViewMeetingMonth());
	    }
	    if(findvm.getStrsql()!=null){
			tempvm.setStrsql(findvm.getStrsql());
		}
	    List<VmeetingVO> templist = ServiceFactory.getVmeetingService().getAll(tempvm, null);
	    Set<String> tempSet = new HashSet<String>();
	    for (VmeetingVO v : templist) {
	      tempSet.add(v.getViewMeetingDeptName());
	    }
	    for (String s : tempSet) {
	      VmeetingVO temp = new VmeetingVO();
	      VmeetingVO tempvm2 = new VmeetingVO();
	      if ((this.findvm.getViewMeetingYear() != null) && (this.findvm.getViewMeetingYear().intValue() != 0)) {
	        tempvm2.setViewMeetingYear(this.findvm.getViewMeetingYear());
	      }
	      if ((this.findvm.getViewMeetingMonth() != null) && (this.findvm.getViewMeetingMonth().intValue() != 0)) {
	        tempvm2.setViewMeetingMonth(this.findvm.getViewMeetingMonth());
	      }
	      if(findvm.getStrsql()!=null){
				tempvm2.setStrsql(findvm.getStrsql());
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
	      this.vlist.add(temp);
	    }
	    GregorianCalendar g = new GregorianCalendar();
	    int nowY = g.get(1);
	    for (int i = nowY; i >= 1990; i--) {
	      this.yearList.add(Integer.valueOf(i));
	    }
	    Collections.sort(this.vlist, new VmeetingSortByCS());
	    for (int i = 0; (i < this.vlist.size()) && (i < 10); i++) {
	      this.vlist2.add((VmeetingVO)this.vlist.get(i));
	    }

	    return "success";
	}
	
	
	//viewNoticeTotal
	/**
	 * 根据标签统计
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
		if(findvm.getViewMeetingYear()!=null&&findvm.getViewMeetingYear()!=0){
			tempvm.setViewMeetingYear(findvm.getViewMeetingYear());
		}
		if(findvm.getViewMeetingMonth()!=null&&findvm.getViewMeetingMonth()!=0){
			tempvm.setViewMeetingMonth(findvm.getViewMeetingMonth());
		}
		if(findvm.getStrsql()!=null){
			tempvm.setStrsql(findvm.getStrsql());
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
	    	if(findvm.getViewMeetingYear()!=null&&findvm.getViewMeetingYear()!=0){
				tempvm2.setViewMeetingYear(findvm.getViewMeetingYear());
			}
			if(findvm.getViewMeetingMonth()!=null&&findvm.getViewMeetingMonth()!=0){
				tempvm2.setViewMeetingMonth(findvm.getViewMeetingMonth());
			}
			if(findvm.getStrsql()!=null){
				tempvm2.setStrsql(findvm.getStrsql());
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
	        vlist.add(temp);
	    }
	    GregorianCalendar g=new GregorianCalendar();
	    int nowY=(int)g.get(Calendar.YEAR);
        for(int i=nowY;i>=(nowY-5);i--){
        	yearList.add(i);
        }
	    Collections.sort(vlist, new VmeetingSortByCS());
	    for(int i=0;i<vlist.size()&&i<10;i++){
	    	vlist2.add(vlist.get(i));
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
		if(findvm.getViewMeetingYear()!=null&&findvm.getViewMeetingYear()!=0){
			tempvm.setViewMeetingYear(findvm.getViewMeetingYear());
		}
		if(findvm.getViewMeetingMonth()!=null&&findvm.getViewMeetingMonth()!=0){
			tempvm.setViewMeetingMonth(findvm.getViewMeetingMonth());
		}
		if(findvm.getStrsql()!=null){
			tempvm.setStrsql(findvm.getStrsql());
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
	    	if(findvm.getViewMeetingYear()!=null&&findvm.getViewMeetingYear()!=0){
				tempvm2.setViewMeetingYear(findvm.getViewMeetingYear());
			}
			if(findvm.getViewMeetingMonth()!=null&&findvm.getViewMeetingMonth()!=0){
				tempvm2.setViewMeetingMonth(findvm.getViewMeetingMonth());
			}
			if(findvm.getStrsql()!=null){
				tempvm2.setStrsql(findvm.getStrsql());
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
	        vlist.add(temp);
	    }
	    GregorianCalendar g=new GregorianCalendar();
	    int nowY=(int)g.get(Calendar.YEAR);
        for(int i=nowY;i>=(nowY-5);i--){
        	yearList.add(i);
        }
	    Collections.sort(vlist, new VmeetingSortByCS());
	    for(int i=0;i<vlist.size()&&i<10;i++){
	    	vlist2.add(vlist.get(i));
	    }
	    isPrint = null;
		isPrint = getServletRequest().getParameter("isPrint");
	    return SUCCESS;
	}
	
	/**
	 * 根据会议室统计
	 * @author zhangjy
	 * @date 2013-09-26
	 */
	public String viewRoomTotal(){
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
		if(findvm.getViewMeetingYear()!=null&&findvm.getViewMeetingYear()!=0){
			tempvm.setViewMeetingYear(findvm.getViewMeetingYear());
		}else{
			 GregorianCalendar g=new GregorianCalendar();
			 int currentYear=(int)g.get(Calendar.YEAR);
			 tempvm.setViewMeetingYear(currentYear);
		}
		if(findvm.getViewMeetingMonth()!=null&&findvm.getViewMeetingMonth()!=0){
			tempvm.setViewMeetingMonth(findvm.getViewMeetingMonth());
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
	    	if(findvm.getViewMeetingYear()!=null&&findvm.getViewMeetingYear()!=0){
				tempvm2.setViewMeetingYear(findvm.getViewMeetingYear());
			}else{
				 GregorianCalendar g=new GregorianCalendar();
				 int currentYear=(int)g.get(Calendar.YEAR);
				 tempvm2.setViewMeetingYear(currentYear);
			}
			if(findvm.getViewMeetingMonth()!=null&&findvm.getViewMeetingMonth()!=0){
				tempvm2.setViewMeetingMonth(findvm.getViewMeetingMonth());
			}
			tempvm2.setViewMeetingRoomName(s.split(",")[0]);
            ////////////////////////分级分权//////////////////
    		if(MeetingAppConfig.LEVEL_IS_POEN){
    			if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
	    			tempvm2.setLevel(true);
	    			tempvm2.setLsql(suv.getLvoids());
	    		}
	    	}
	    	/////////////////////////////////////////////////////////
	    	List<VmeetingVO> templist2=ServiceFactory.getVmeetingService().getAll(tempvm2, null);	    	
	        temp.setViewMeetingDeptName(s.split(",")[0]);
	        temp.setViewMeetRoomId(s.split(",")[1]);
	        temp.setViewMeetingMonth(templist2.size());
	        float longh=0.00f;
	     
	        for(VmeetingVO vv: templist2){
	        	longh+=vv.getViewTimeLong();
	        }
	      
	        temp.setViewTimeLong(longh);
	        vlist.add(temp);
	    }
	    GregorianCalendar g=new GregorianCalendar();
	    int nowY=(int)g.get(Calendar.YEAR);
        for(int i=nowY;i>=(nowY-5);i--){
        	yearList.add(i);
        }
	    Collections.sort(vlist, new VmeetingSortByCS());
	    for(int i=0;i<vlist.size()&&i<10;i++){
	    	vlist2.add(vlist.get(i));
	    }
	    return SUCCESS;
	}
	
	
	
	
	/**
	  * 统计会议室设备维修次数费用
	  * @author zhangjy
	  * @date 2013-11-27
	  */
	public String viewRoomAssets(){
		try {
           ///////////////分级分权 @author:zhangjy///////////////////////////
			UserVO suv = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if(MeetingAppConfig.LEVEL_IS_POEN){
				if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
					equipmentMaintainVO.setLevel(true);
					equipmentMaintainVO.setLsql(suv.getLvoids());
				}
			}
            /////////////////////////////////end/////////////////////////////////////
		String sqls="";
		if(findvm.getViewMeetingInfo()!=null&&!(findvm.getViewMeetingInfo().equals(""))){
			sqls+=" and a.updateTime>='"+findvm.getViewMeetingInfo()+"' ";	
		}
		if(findvm.getViewMeetingRoomName()!=null&&!(findvm.getViewMeetingRoomName().equals(""))){
			sqls+=" and a.updateTime<='"+findvm.getViewMeetingRoomName()+"' ";	
		}
		equipmentMaintainVO.setSqls(sqls);
		List<EquipmentMaintainVO> list = ServiceFactory.getEquipmentMaintainService().queryEquipmentMaintain(equipmentMaintainVO, this.getPageControler());
		for(EquipmentMaintainVO em:list){
		VmeetingVO temp=new VmeetingVO();
		temp.setViewMeetingDeptName(em.getEquipmentVO().getEquipmentNO());
		temp.setViewMeetingMonth(em.getMaintainTime());
		if(em.getSumCost()<0){
		temp.setViewTimeLong(0);
		}else{
		temp.setViewTimeLong(em.getSumCost());	
		}
		temp.setViewMeetingName(em.getEquipmentVO().getMeetingRoomVO().getMeetingRoomName());
		vlist.add(temp);
		}
		 Collections.sort(vlist, new VmeetingSortByCS());
		    for(int i=0;i<vlist.size()&&i<10;i++){
		    	vlist2.add(vlist.get(i));
		    }
		} catch (Exception e) {
			return ERROR;
		}
	    return SUCCESS;
	}
	
	/**
	 * 查出一个时间段内会议详情
	 * @author John.Zhang
	 * @return
	 */
	public String getListForRoom(){
		VmeetingVO serchvo=new VmeetingVO();
		serchvo.setViewMeetRoomId(findvm.getViewMeetRoomId());
	    serchvo.setViewMeetingYear(findvm.getViewMeetingYear());
		serchvo.setViewMeetingMonth(findvm.getViewMeetingMonth());
		///////////////分级分权 @author:zhangjy///////////////////////////
		UserVO suv = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
		if(MeetingAppConfig.LEVEL_IS_POEN){
			if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
				serchvo.setLevel(true);
				serchvo.setLsql(suv.getLvoids());
			}
		}
        /////////////////////////////////end/////////////////////////////////////
		meetList=ServiceFactory.getVmeetingService().getAll(serchvo, null);
		if(meetList.size()>0){
			info=meetList.get(0).getViewMeetingRoomName();
		}
		return this.SUCCESS;
	}
	
	public String getMeetingInfoList(){
		if(MeetingAppConfig.LEVEL_IS_POEN){
			UserVO suv = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
				findvm.setLevel(true);
				findvm.setLsql(suv.getLvoids());
 			}
 		}
		List<VmeetingVO> vlists=ServiceFactory.getVmeetingService().getAllGroupBY(findvm, null);
		for(VmeetingVO v:vlists){
			vlist.add(v);
		}
		isPrint = null;
		isPrint = getServletRequest().getParameter("isPrint");
		return this.SUCCESS;
	} 
	
	
	public String queryBefore(){
		strtype=VmeetingDetailEnum.getType();
		strname=VmeetingDetailEnum.getSelectName();
		  GregorianCalendar g=new GregorianCalendar();
		 int nowY=(int)g.get(Calendar.YEAR);
		findvm.setViewMeetingYear(nowY);
		return "success";
	}
	
	public ArrayList<VmeetingVO> getVlistPie() {
		return vlistPie;
	}

	public void setVlistPie(ArrayList<VmeetingVO> vlistPie) {
		this.vlistPie = vlistPie;
	}

	public List<VmeetingVO> getMeetList() {
		return meetList;
	}

	public void setMeetList(List<VmeetingVO> meetList) {
		this.meetList = meetList;
	}

	//viewRoomTotal
	public ArrayList<VmeetingVO> getVlist() {
		return vlist;
	}

	public void setVlist(ArrayList<VmeetingVO> vlist) {
		this.vlist = vlist;
	}

	public ArrayList<VmeetingVO> getVlist2() {
		return vlist2;
	}



	public void setVlist2(ArrayList<VmeetingVO> vlist2) {
		this.vlist2 = vlist2;
	}



	public ArrayList<Integer> getYearList() {
		return yearList;
	}



	public void setYearList(ArrayList<Integer> yearList) {
		this.yearList = yearList;
	}



	public VmeetingVO getFindvm() {
		return findvm;
	}



	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public void setFindvm(VmeetingVO findvm) {
		this.findvm = findvm;
	}

	public EquipmentMaintainVO getEquipmentMaintainVO() {
		return equipmentMaintainVO;
	}

	public void setEquipmentMaintainVO(EquipmentMaintainVO equipmentMaintainVO) {
		this.equipmentMaintainVO = equipmentMaintainVO;
	}

	public String getStrsql() {
		return strsql;
	}

	public void setStrsql(String strsql) {
		this.strsql = strsql;
	}

	public String[][] getStrtype() {
		return strtype;
	}

	public void setStrtype(String[][] strtype) {
		this.strtype = strtype;
	}

	public String[][] getStrname() {
		return strname;
	}

	public void setStrname(String[][] strname) {
		this.strname = strname;
	}

	
	
	
}
