package com.zzst.action.meeting.func;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.model.meeting.auth.FuncVO;
import com.zzst.model.meeting.auth.RoleVO;
import com.zzst.service.meeting.auth.FuncService;
import com.zzst.service.meeting.auth.FuncServiceImpl;


/**
 * 功能Action
 * @author zhangliang
 * @3:52:35 PM Mar 21, 2011
 */
public class FuncAction  extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(FuncAction.class);

	private RoleVO roleVO = new RoleVO();
	private ArrayList<FuncVO> funcList = new ArrayList<FuncVO>();
	
	
	//判断节点是否有子节点
	public  boolean ishaveChild(String funcid)
	{
		boolean is = false;
		//业务
		FuncService handle = new FuncServiceImpl();
		try {
			 return handle.ishaveChild(funcid);
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return is;
	}
	
	
    //取得功能树
	public String getFuncList()
	{
		logger.info("FuncAction		getfunclist	begin");
		FuncService funcService = new FuncServiceImpl();
		
		try {
			//查询全部功能
			ArrayList treelist = funcService.getFuncList(null, null);
			request.setAttribute("treelist", treelist);
			//查询角色功能
			ArrayList rolelist = funcService.getRoleFuncList(roleVO, null);
			request.setAttribute("rolelist", rolelist);
			request.setAttribute("roleID", roleVO.getRoleID());
			
			logger.info("FuncAction		getfunclist	end");
			return REQUEST_SUCCESS;
			
		}catch (Exception e) {
			request.setAttribute("info", "系统异常！");
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.info("FuncAction		userLogin	end");
		return REQUEST_FAILURE;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public String queryCheck()
	{
		logger.info("FuncAction		queryCheck	begin");
		FuncService funcService = new FuncServiceImpl();
		try {
			//查询全部功能
			funcList = funcService.getFuncList(null, null);
			//查询角色功能
			ArrayList<FuncVO> lis = funcService.getRoleFuncList(roleVO, null);
			Map<String,String> map = new HashMap<String,String>();
			for(FuncVO vo : lis){
				map.put(vo.getFunc_id(), vo.getFunc_id());
			}
			request.setAttribute("roleFuncMap", map);
			request.setAttribute("roleID", roleVO.getRoleID());
			logger.info("FuncAction		queryCheck	end");
		}catch (Exception e) {
			logger.error("FuncAction		ququeryCheckery	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("FuncAction		queryCheck	end");
		return SUCCESS;
	}
	
//	//修改角色挂接功能
//	public String updateRoleFunc()
//	{
//		logger.info("FuncAction updaterolefunc	begin");
//		FuncService funcService = new FuncServiceImpl();
//		try {
//	
//			String roleID = request.getParameter("roleID");
//			String checkeditem = (String)request.getParameter("checkeditem");
//			RoleVO roleVO = new RoleVO();
//			roleVO.setRoleID(Integer.parseInt(roleID));
//			
//			ArrayList<RoleFunc> list =new ArrayList();
//			String treevalue[] ={};
//			if(checkeditem !=null && !"".equals(checkeditem))
//			{
//			   treevalue = checkeditem.split(",");
//			}
//			for(int i=0;i< treevalue.length;i++ )
//			{
//				RoleFunc rf = new RoleFunc();
//				rf.setRoleID(Integer.parseInt(roleID));
//				rf.setFuncID(Integer.parseInt(treevalue[i]));
//				list.add(rf);
//			}
//			funcService.updateRoleFunc(roleVO, list, null);
//			
//			logger.info("FuncAction		getfunclist	end");
//			return REQUEST_SUCCESS;
//			
//		}catch (Exception e) {
//			request.setAttribute("info", "系统异常！");
//			e.printStackTrace();
//			logger.error(e.getMessage());
//		}
//		logger.info("UserAction		userLogin	end");
//
//		return REQUEST_FAILURE;
//	}
	public RoleVO getRoleVO() {
		return roleVO;
	}

	public void setRoleVO(RoleVO roleVO) {
		this.roleVO = roleVO;
	}
}
