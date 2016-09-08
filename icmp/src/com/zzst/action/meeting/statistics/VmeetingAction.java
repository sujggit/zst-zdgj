package com.zzst.action.meeting.statistics;

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
    
    public String getAllChildDept(String deptIds,String deptId){
    	List<DepartmentVO> dList = new ArrayList<DepartmentVO>();
    	VmeetingAction vm = new VmeetingAction();
    	dList = vm.getChildDept(deptId);
    	if(dList!=null&&dList.size()>0){
    		//deptList.addAll(dList);
    		for(DepartmentVO vo:dList){
    			//deptList.add(vo);
    			deptIds += "'"+vo.getId()+"',";
    			deptIds = getAllChildDept(deptIds,vo.getId());
    			//getAllChildDept(deptIds,vo.getId());
    		}
    	}
    	return deptIds;
    }
    
    public List<DepartmentVO> getChildDept(String deptId){
    	List<DepartmentVO> dList = new ArrayList<DepartmentVO>();
    	try {
			dList = ServiceFactory.getDepartmentService().getallChild(deptId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dList;
    }
    public static void main(String[] args) {
    	VmeetingAction vm = new VmeetingAction();
    	List<DepartmentVO> dList = new ArrayList<DepartmentVO>();
    	//dList = vm.getAllChildDept(dList,"0");
    	System.out.print("========================="+dList.size());
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
		}else{
		   findvm.setViewMeetingYear(nowY);
		   tempvm.setViewMeetingYear(findvm.getViewMeetingYear());
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
     * 按照部门统计（add by xiongshun 20140115）
     * @return
     */
	public String viewDeptTotal(){
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
		
		if(findvm.getViewDeptPid()!=null&&!"".equals(findvm.getViewDeptPid())){
			
		}else{
			findvm.setViewDeptPid("0");
		}
		String resultInfo = "";
		String deptIds = "";
		List<DepartmentVO> dList = new ArrayList<DepartmentVO>();
		try {
			VmeetingAction vm = new VmeetingAction();
			dList = vm.getChildDept(findvm.getViewDeptPid());
			VmeetingVO vmTemp =new VmeetingVO();
			if(dList!=null&&dList.size()>0){
				for(DepartmentVO vo:dList){
					VmeetingVO temp=new VmeetingVO();
					deptIds = vm.getAllChildDept("",vo.getId());
					if(deptIds.endsWith(",")||"".equals(deptIds)){
						deptIds += "'"+vo.getId()+"'";
					}else{
						deptIds += ",'"+vo.getId()+"'";
					}
					//deptIds += ",'"+vo.getId()+"'";
					VmeetingVO temp2=new VmeetingVO();
					vmTemp = findvm;
					vmTemp.setViewDeptId(deptIds);
					temp2 = getVmeeting(vmTemp);
					temp2.setViewMeetingDeptName(vo.getTitle());
					vlist.add(temp2);
				}
			}
			
			DepartmentVO dVo = new DepartmentVO();
			List<DepartmentVO> dListTemp = new ArrayList<DepartmentVO>();
			dVo.setId(findvm.getViewDeptPid());
			dListTemp = ServiceFactory.getDepartmentService().query(dVo, null);
			if(dListTemp!=null && dListTemp.size()>0){
				this.getCurHttpServletRequest().setAttribute("deptName", dListTemp.get(0).getTitle());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
		GregorianCalendar g=new GregorianCalendar();
	    int nowY=(int)g.get(Calendar.YEAR);
        for(int i=nowY;i>=(nowY-5);i--){
        	yearList.add(i);
        }
	    for(int i=0;i<vlist.size()&&i<12;i++){
	    	vlist2.add(vlist.get(i));
	    }
	    return SUCCESS;
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
	 * 根据标签统计
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
			if(s.equals(MeetingDetailEnum.TYPE_GENERAL_NAME)){
	    	tempvm2.setViewMeetingType(MeetingDetailEnum.TYPE_GENERAL);
			}else if(s.equals(MeetingDetailEnum.TYPE_VEDIO_NAME)){
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
	    return SUCCESS;
	}
	
	/**
	 * 根据会议室统计
	 * @author zhangjy
	 * @date 2013-09-26
	 */
	public String viewRoomTotal(){
		VmeetingVO tempvm=new VmeetingVO();
		MeetingRoomVO meetingRoomVO=new MeetingRoomVO();
		 ///////////////统计分级分权 @author:zhangjy///////////////////////////
		UserVO suv = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
		if(MeetingAppConfig.LEVEL_IS_POEN){
			if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
				tempvm.setLevel(true);
				meetingRoomVO.setLevel(true);
				tempvm.setLsql(suv.getLvoids());
				meetingRoomVO.setLsql(suv.getLvoids());
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
	/**
	 * 根据人数查询会议
	 * @return
	 */
	public String viewNumTotal(){
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

	
	
	
}
