/**
 * 
 */
package com.zzst.service.meeting.auth;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.auth.FuncDAO;
import com.zzst.model.meeting.auth.FuncVO;
import com.zzst.model.meeting.auth.RoleFunc;
import com.zzst.model.meeting.auth.RoleVO;
import com.zzst.model.meeting.user.UserVO;

/**
 * 功能接口实现层
 * @author zhangliang
 * @Apr 18, 2011
 */
public class FuncServiceImpl implements FuncService
{
	private static Logger logger = CjfLogger.getLogger(FuncServiceImpl.class.getName());

	   //判断是否为叶子节点
	public boolean ishaveChild(String funcid) throws Exception {
		return FuncDAO.ishaveChild(funcid);
	}
	
	//获得当前节点的所有子节点
	public ArrayList<FuncVO> getallChild(String id) throws Exception {
		ArrayList<FuncVO> FuncVO_=(ArrayList<FuncVO>) FuncDAO.getChildrenById(id);
		return FuncVO_;
	}
	
	
    //查询功能列表
	public ArrayList<FuncVO> getFuncList(UserVO userVO, PageController pageController)
			throws SQLException {

		return FuncDAO.getFuncList(userVO, pageController);
	}

	//查询角色对应功能列表
	public ArrayList<FuncVO> getRoleFuncList(RoleVO roleVO,
			PageController pageController) throws SQLException {

		return FuncDAO.getRoleFuncList(roleVO, pageController);
	}

	//角色修改功能列表
	public void updateRoleFunc(RoleVO roleVO, ArrayList<RoleFunc> list,
			TransactionManager manager) throws SQLException {
		FuncDAO.updateRoleFunc(roleVO, list, manager);
	}
	
	
	@Override
	public FuncVO add(FuncVO functionVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		functionVO=FuncDAO.add(functionVO, null);
		logger.info("serviceImpl	add	end");
		return functionVO;
	}

	@Override
	public  ArrayList<FuncVO> query(FuncVO functionVO,PageController pageController) throws Exception{
		logger.info("serviceImpl	query	begin");
		ArrayList<FuncVO> listFunction = FuncDAO.query(functionVO,pageController);
		logger.info("serviceImpl	query	end");
		return  listFunction;
	}

	@Override
	public  FuncVO queryByID(String id) throws Exception{
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<FuncVO> listFunction = FuncDAO.queryByIDs(id,null);
		if(listFunction!=null&&listFunction.size()==1){
			logger.info("serviceImpl	end");
			return listFunction.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public  ArrayList<FuncVO> queryByIDs(String ids) throws Exception{
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<FuncVO> listFunction = FuncDAO.queryByIDs(ids,null);
		logger.info("serviceImpl	queryByIDs	end");
		return listFunction;
	}

	@Override
	public FuncVO modify(FuncVO functionVO )throws Exception{
		logger.info("serviceImpl	modify	begin");
		functionVO=FuncDAO.modify(functionVO,null);
		logger.info("serviceImpl	modify	end");
		return functionVO;
	}
	
	@Override
	public boolean deleteByID(String id )throws Exception{
		logger.info("serviceImpl	deleteByID	begin");
		int num	= FuncDAO.deleteByID(id,null);
		if(num==1){
			logger.info("serviceImpl	deleteByID	end");
			return true;
		}else{
			logger.info("serviceImpl	deleteByID	end");
			return false;
		}
	}

	@Override
	public int deleteByIDs(String ids )throws Exception{
		logger.info("serviceImpl	deleteByIDs	begin");
		int num	= FuncDAO.deleteByID(ids,null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

}
