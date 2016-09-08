/**
 * 
 */
package com.zzst.service.meeting.auth;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.zzst.model.meeting.auth.FuncVO;
import com.zzst.model.meeting.auth.RoleFunc;
import com.zzst.model.meeting.auth.RoleVO;
import com.zzst.model.meeting.user.UserVO;

/**
 * func inter
 * @author zhangliang
 * @Apr 18, 2011
 */
public interface FuncService {
	

	public ArrayList<FuncVO> getallChild(String id) throws Exception ;
	
	/**
	 * method description : add FunctionVO	object
	 * @param FunctionVO
	 * @return FunctionVO
	 * @throws Exception
	 */
	public FuncVO add(FuncVO functionVO ) throws Exception;

	/**
	 * method description : query	Function	list
	 * @param FunctionVO
	 * @param PageController
	 * @return ArrayList<FunctionVO>
	 * @throws Exception
	 */
	public  ArrayList<FuncVO> query(FuncVO functionVO,PageController pageController) throws Exception;

	/**
	 * method description : query	FunctionVO	by	id
	 * @param id
	 * @return FunctionVO
	 * @throws Exception
	 */
	public  FuncVO queryByID(String id) throws Exception;

	/**
	 * method description : query	FunctionVO	by	ids
	 * @param String example: 1,2,3,4
	 * @return FunctionVO
	 * @throws Exception
	 */
	public   ArrayList<FuncVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify	FunctionVO	by id
	 * @param FunctionVO
	 * @return FunctionVO
	 * @throws Exception
	 */
	public FuncVO modify(FuncVO functionVO )throws Exception;


	/**
	 * method description : delete FunctionVO by	id
	 * @param String	
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id )throws Exception;

	/**
	 * method description : delete FunctionVO by	ids
	 * @param String example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id )throws Exception;
	public boolean ishaveChild(String funcid)  throws Exception ;
	public  ArrayList<FuncVO> getFuncList(UserVO userVO,PageController mPageController) throws SQLException;
	
	public  ArrayList<FuncVO> getRoleFuncList(RoleVO roleVO,PageController mPageController) throws SQLException;
	
	public void updateRoleFunc(RoleVO vRoleVO,ArrayList<RoleFunc> list,TransactionManager tManager) throws SQLException ;
	
}
