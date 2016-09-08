/**
 * 
 */
package com.zzst.dao.meeting.auth;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.cbf.log.CbfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.auth.FuncVO;
import com.zzst.model.meeting.auth.RoleFunc;
import com.zzst.model.meeting.auth.RoleVO;
import com.zzst.model.meeting.user.UserVO;

/**
 * 功能DAO
 * @author zhangliang
 * @Apr 18, 2011
 */
public class FuncDAO {
	
	private static Logger logger = CbfLogger.getLogger(FuncDAO.class.getName());
	/**
	 * add FunctionVO	object
	 * @param FunctionVO
	 * @param TransactionManager
	 * @return FunctionVO
	 * @throws Exception
	 */
	public static FuncVO add(FuncVO functionVO,TransactionManager tManager)throws Exception{
		logger.info("DAO	add	begin");
		functionVO.setFunc_id(UtilDAO.getUUid());
		FuncTO functionTO=new FuncTO(FuncTO.ADD_FUNCTION,functionVO);
		functionTO.setSqlStr();
		logger.info("sqlStr	:	"+functionTO.getSqlStr());
		if (tManager == null) {
		   TransactionTemplate.executeTransaction(functionTO, true);
		}else{
		   TransactionTemplate.executeTransaction(functionTO, tManager);
		}
		logger.info("DAO	add	end");
		return functionVO;
	}



	/**
	 * query FunctionVO	list
	 * @param FunctionVO
	 * @param PageController
	 * @return ArrayList<FunctionVO> 
	 * @throws Exception
	 */
	public static ArrayList<FuncVO> query(FuncVO functionVO,PageController pageController) throws Exception{
		logger.info("DAO	query	begin");
		FuncMQB functionMQB=new FuncMQB(FuncMQB.QUERY_FROM_FUNCTION,functionVO);
		if(pageController==null){
			pageController=new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	"+functionMQB.getSQL());
		QueryTemplate.executeQueryForList(functionMQB, pageController);
		logger.info("list size	:	"+functionMQB.getFuncList().size());
		logger.info("DAO	query	end");
		return functionMQB.getFuncList();
	}
	
	 
	/**
	 * query FunctionVO	list	by	IDs
	 * @param String
	 * @param PageController
	 * @return ArrayList<FunctionVO> 
	 * @throws Exception
	 */
	public static ArrayList<FuncVO> queryByIDs(String ids,PageController pageController) throws Exception{
		logger.info("DAO	queryByIDs	begin");
 		FuncMQB functionMQB=new FuncMQB(FuncMQB.QUERY_FROM_FUNCTION_BY_IDS,ids);
		if(pageController==null){
			pageController=new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	"+functionMQB.getSQL());
		QueryTemplate.executeQueryForList(functionMQB, pageController);
		logger.info("list size	:	"+functionMQB.getFuncList().size());
		logger.info("DAO	queryByIDs	end");
		return functionMQB.getFuncList();
	}
	
	/**
	 * modify FunctionVO column by ID
	 * @param FunctionVO
	 * @param TransactionManager
	 * @return FunctionVO
	 * @throws Exception
	 */
	public static FuncVO modify(FuncVO functionVO,TransactionManager tManager)throws Exception{
		logger.info("DAO	modify	begin");
		FuncTO functionTO=new FuncTO(FuncTO.MODIFY_FUNCTION,functionVO);		
		functionTO.setSqlStr();
		logger.info("sqlStr	:	"+functionTO.getSqlStr());
		if (tManager == null) {
		   TransactionTemplate.executeTransaction(functionTO, true);
		}else{
		   TransactionTemplate.executeTransaction(functionTO, tManager);
		}
		logger.info("DAO	modify	end");
		return functionVO;
	}
	
	
	
	/**
	 * delete	FunctionVO by ids
	 * @param String
	 * @param TransactionManager
	 * @return FunctionVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids,TransactionManager tManager)throws Exception{
		logger.info("DAO	deleteByID	begin");
		FuncVO functionVO = new FuncVO();
		functionVO.setFunc_id(ids);
		FuncTO functionTO=new FuncTO(FuncTO.DEL_FUNCTION,functionVO);
		functionTO.setSqlStr();
		logger.info("sqlStr	:	"+functionTO.getSqlStr());
		if (tManager == null) {
		   TransactionTemplate.executeTransaction(functionTO, true);
		}else{
		   TransactionTemplate.executeTransaction(functionTO, tManager);
		}
		logger.info("result	:	"+functionTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return functionTO.getexecuteResult();
	}
	/**
	 * 根据用户查询功能列表
	 * @param userVO
	 * @param mPageController
	 * @return ArrayList<RoleVO>
	 * @throws SQLException
	 */
	public static ArrayList<FuncVO> getFuncList(UserVO userVO,PageController mPageController) throws SQLException {

		StringBuffer strsql = new StringBuffer();

		strsql.append("select funcID,funcName,funcURL,parentID,leaf,orderNum ,description,className,funcNo from z_t_function ");
        strsql.append(" where 1=1 ") ;      
		if (userVO !=null) 
		{			
			strsql.append(" and funcID in ( select distinct  funcID from z_t_role_func  where roleID in (select roleID from z_t_user_role where userID='" + userVO.getUserID()+"' ))");
		}
		strsql.append(" order by orderNum ") ;
		
		FuncMQB funcMQB = new FuncMQB(FuncMQB.QUERY_FROM_FUNC);
		funcMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
		
		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(funcMQB, mPageController);

		return funcMQB.getFuncList();
	}
	/**
	 * 判断节点是否有子节点
	 * @param node_id
	 * @return boolean
	 * author:tanzanlong
	 * @throws SQLException
	 */
	public static boolean  ishaveChild(String node_id)throws SQLException {
		logger.info("FuncDAO	 ishaveChild	begin");
		String sql = "select count(1) from z_t_function  where parentid ='" + node_id + "'";
		FuncMQB funcMQB = new FuncMQB(FuncMQB.QUERY_CHECK_CHILD);
		funcMQB.setSql(sql);
		PageController mPageController = new PageController();
		mPageController.setAll(true);
		QueryTemplate.executeQueryForList(funcMQB, mPageController);
		logger.info("FuncDAO	 ishaveChild	end");
		return funcMQB.getres();
	}
	
	 /**
     *  获得指定节点的所有子节点
     * @param id
     * author:tanzanlong
     * @return List<FuncVO>
     */
	public static List<FuncVO> getChildrenById(String id){
		logger.info("FuncDAO	 getChildrenById	begin");
		FuncVO functionVO = new FuncVO();
		functionVO.setParent_id(id);
		FuncMQB vFuncMQB = new FuncMQB(FuncMQB.QUERY_FROM_FUNCTION,functionVO);
		PageController pageController=new PageController();
		pageController.setAll(true);
		logger.info("sqlStr	:	"+vFuncMQB.getSQL());
		try {
			QueryTemplate.executeQueryForList(vFuncMQB, pageController);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		logger.info("FuncDAO	 getChildrenById	end");
		return vFuncMQB.getFuncList();
		
	}
	
	
	/**
	 * 根据角色查询功能
	 * @param roleVO
	 * @param mPageController
	 * @return ArrayList<FuncVO>
	 * @throws SQLException
	 */
	public static ArrayList<FuncVO> getRoleFuncList(RoleVO roleVO,PageController mPageController) throws SQLException {
		if(roleVO ==null)
		{
			logger.info("角色不能为空。" );
			return null;
		}
		
		StringBuffer strsql = new StringBuffer();

		strsql.append("select funcID from z_t_role_func where roleID ='"+roleVO.getRoleID()+"'");
				
		FuncMQB funcMQB = new FuncMQB(FuncMQB.QUERY_ROLE_FUNC);
		funcMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
		
		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(funcMQB, mPageController);

		return funcMQB.getFuncList();
	}
	
	//角色挂接功能
	public static void updateRoleFunc(RoleVO vRoleVO,ArrayList<RoleFunc> list,TransactionManager manager) throws SQLException {
		
		FuncTO vRoleTO = new FuncTO(FuncTO.DEL_ROLE_FUNC, vRoleVO);
		vRoleTO.setSqlStr();
		logger.info("del sql is :" + vRoleTO.getSqlStr());

		if (manager == null) {
			TransactionTemplate.executeTransaction(vRoleTO, true);
		} else {
			TransactionTemplate.executeTransaction(vRoleTO, manager);
		}
		
		if(list !=null && list.size()>0)
		{
			for(int i=0;i< list.size();i++)
			{
				RoleFunc rf = list.get(i);	
				rf.setRid(UtilDAO.getUUid());//增加rid，确保数据的唯一性
				vRoleTO = new FuncTO(FuncTO.ADD_ROLE_FUNC, rf);
				vRoleTO.setSqlStr();
				logger.info("add sql is :" + vRoleTO.getSqlStr());
				if (manager == null) {
					TransactionTemplate.executeTransaction(vRoleTO, true);
				} else {
					TransactionTemplate.executeTransaction(vRoleTO, manager);
				}
			}			
		}		
	}
}
