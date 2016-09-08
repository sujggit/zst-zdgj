package com.zzst.dao.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cbf.db.MasterQueryObject;
import com.zzst.model.view.VmeetingVO;

public class VmeetingMQB extends MasterQueryObject {
	public static int QUERY_FROM_VM = 1;
	public static int QUERY_FROM_NUM_TIME = 2;
    List<VmeetingVO> vmeetList=new ArrayList<VmeetingVO>();
    private int _operatorType = -1;

	public VmeetingMQB(int operatorType) {
		_operatorType = operatorType;
	}
	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}
    
	@Override
	public void getDataForRow(ResultSet rs) throws SQLException {
		if(_operatorType==QUERY_FROM_VM){
		VmeetingVO vm=new VmeetingVO();
		//vm.setViewMeetingDeptName(rs.getString("view_meeting_dept_name"));
		vm.setViewMeetingInfo(rs.getString("view_meeting_info"));
		vm.setViewMeetingMonth(rs.getInt("view_meeting_month"));
		vm.setViewMeetingName(rs.getString("view_meeting_name"));
		vm.setViewMeetingRoomName(rs.getString("view_meeting_room_name"));
		vm.setViewMeetingType(rs.getInt("view_meeting_type"));
		vm.setViewMeetingYear(rs.getInt("view_meeting_year"));
		vm.setViewTimeLong(rs.getFloat("view_time_long"));
		//vm.setViewDeptId(rs.getString("view_deptId"));
		//vm.setViewDeptPid(rs.getString("view_deptPid"));
		
		//vm.setViewUserName(rs.getString("view_userName"));
		vm.setViewStartTime(rs.getTimestamp("view_startTime"));
		vm.setViewEndTime(rs.getTimestamp("view_endTime"));
		vm.setViewMeetingId(rs.getString("view_meeting_id"));
		vm.setViewMeetRoomId(rs.getString("meetingroomID"));
		vm.setViewManNum(rs.getInt("view_manNum"));
		vmeetList.add(vm);
		}else if(_operatorType==QUERY_FROM_NUM_TIME){
		VmeetingVO vm=new VmeetingVO();
		vm.setViewTimeLong(rs.getFloat("longtime"));
		vm.setMeetingNum(rs.getInt("tiaoshu"));
		vmeetList.add(vm);
		}
	}
	public List<VmeetingVO> getVmeetList() {
		return vmeetList;
	}
	public void setVmeetList(List<VmeetingVO> vmeetList) {
		this.vmeetList = vmeetList;
	}

}
