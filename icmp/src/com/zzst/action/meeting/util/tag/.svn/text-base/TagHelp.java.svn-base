package com.zzst.action.meeting.util.tag;

import java.util.ArrayList;

import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.service.meeting.department.DepartmentService;
import com.zzst.service.meeting.user.UserService;


/**
 *@Description
 *@date 2012-9-26下午03:14:23
 *@author ryan
 */
public class TagHelp {

	/**
	 * addby chenshuo
	 * 提取人员id,name
	 * @return
	 */
	public static String[][] getUsers(){
		UserVO vUserVO = new UserVO();
		vUserVO.setState(UserEnum.VALID);
		UserService userService = ServiceFactory.getUserService();
		String[][] userStr = null;
		try{
			ArrayList<UserVO> userList = userService.getUserList(vUserVO, null);
			int num = userList.size();
			userStr = new String[num][2];
			for( int i=0; i<num; i++){ 
				userStr[i][0] = userList.get(i).getUserID();
				userStr[i][1] = userList.get(i).getName();
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return userStr;
	}
	
	/**
	 * addby chenshuo
	 * 提取部门id，name
	 * @return
	 */
	public static String[][] getDepartments(){
		DepartmentVO vDepartmentVO = new DepartmentVO();
		DepartmentService departmentService = ServiceFactory.getDepartmentService();
		String[][] departmentStr = null;
		try{
			ArrayList<DepartmentVO> departmentList =  departmentService.getAllFuncList(vDepartmentVO, null);
			int num = departmentList.size();
			departmentStr = new String[num][2];
			for( int i=0; i<num; i++){ 
				departmentStr[i][0] = departmentList.get(i).getId();
				departmentStr[i][1] = departmentList.get(i).getTitle();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return departmentStr;
	}
	
	/**
	 * 根据id提取节点
	 */
	public static String[][] getApplyFlowByID(){
//		ApplyFlowVO vApplyFlowVO = new ApplyFlowVO();
//		ApplyFlowService applyFlowService = ServiceFactory.getApplyFlowService();
		String[][] applyFlowStr = null;
//		try{
//			ArrayList<ApplyFlowVO> applyFlowList =  applyFlowService.query(vApplyFlowVO, null);
//			int num = applyFlowList.size();
//			applyFlowStr = new String[num][2];
//			for( int i=0; i<num; i++){ 
//				applyFlowStr[i][0] = applyFlowList.get(i).getFlowID();
//				applyFlowStr[i][1] = applyFlowList.get(i).getFlowName();
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		return applyFlowStr;
	}
	
	/**addby chenshuo
	 * 提取所有审批流程
	 */
	public static String[][] getApply(){
//		ApplyVO vApplyVO = new ApplyVO();
//		vApplyVO.setStatus(ApplyEnum.STATUS_VALID);
//		ApplyService applyService = ServiceFactory.getApplyService();
		String[][] applyStr = null;
//		try{
//			ArrayList<ApplyVO> applyList =  applyService.query(vApplyVO, null);
//			int num = applyList.size();
//			applyStr = new String[num][2];
//			for( int i=0; i<num; i++){ 
//				applyStr[i][0] = applyList.get(i).getApplyID();
//				applyStr[i][1] = applyList.get(i).getApplyName();
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		return applyStr;
	}
	
}
