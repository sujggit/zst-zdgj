package com.zzst.dao.meeting.department;

import java.io.Serializable;
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
import com.zzst.model.meeting.department.DepartmentVO;


/**
 * DepartmentDAO
 * @author zhangliang
 * Nov 1, 2011 3:42:52 PM
 */
public class DepartmentDAO {

	private static Logger logger = CbfLogger.getLogger(DepartmentDAO.class.getName());
	/**
	 * 获得指定部门下所有的部门ID
	 * @param id
	 * @return
	 */
	public static ArrayList<DepartmentVO> getAllChildIDByParentID(String id){
		StringBuffer strsql = new StringBuffer();
		strsql.append("select * from z_t_department where like '%,"+id+",%'");		
		DepartmentMQB vDepartmentMQB = new DepartmentMQB(DepartmentMQB.QUERY_CHILD);
		vDepartmentMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		PageController	mPageController = new PageController();
		mPageController.setAll(true);	

		try {
			QueryTemplate.executeQueryForList(vDepartmentMQB, mPageController);
		} catch (SQLException e) {
		}

		return vDepartmentMQB.getDepartmentList();
	}
	
	/**
	 * 获得指定ID的数据
	 * @param id
	 * @return
	 */
	public static DepartmentVO get(Serializable id){
		StringBuffer strsql = new StringBuffer();

		strsql.append("select * from z_t_department where id = '"+id+"'");		

		DepartmentMQB vDepartmentMQB = new DepartmentMQB(DepartmentMQB.QUERY_FOR_ONE);
		vDepartmentMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		try {
			QueryTemplate.executeQueryForEntity(vDepartmentMQB);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vDepartmentMQB.getDepartmentVO();
	}
    /**
     *  获得指定节点的所有子节点
     * @param id
     * @return List<DepartmentVO>
     */
	public static List<DepartmentVO> getChildrenById(String id){

		StringBuffer strsql = new StringBuffer();

		strsql.append("select * from z_t_department where parentID = '");
		strsql.append(id);
		strsql.append("' order by id");
	
		DepartmentMQB vDepartmentMQB = new DepartmentMQB(DepartmentMQB.QUERY_FROM_DEPARTMENT);
		vDepartmentMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		PageController	mPageController = new PageController();
		mPageController.setAll(true);	

		try {
			QueryTemplate.executeQueryForList(vDepartmentMQB, mPageController);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vDepartmentMQB.getDepartmentList();
		
	}
	/**
	 * 
	 * @param vDepartmentVO
	 * @param tManager
	 * @return vDepartmentVO
	 * @throws SQLException
	 */
	public static DepartmentVO addDepartment(DepartmentVO vDepartmentVO, boolean isAutoId) 
	{
		//生成ID
		if( isAutoId ){
			vDepartmentVO.setId(UtilDAO.getUUid());
		}
		
		try{
			DepartmentVO dVo = new DepartmentVO();
			dVo.setId(vDepartmentVO.getParentId());
			ArrayList<DepartmentVO> list = (ArrayList<DepartmentVO>)DepartmentDAO.query(dVo, null);
			if(list!=null&&list.size()==1)
				vDepartmentVO.setLinkCodeID(list.get(0).getLinkCodeID()+vDepartmentVO.getId()+",");	
			
		}catch(Exception e){
		}
		
		DepartmentTO vDepartmentTO = new DepartmentTO(DepartmentTO.ADD_DEPARTMENT, vDepartmentVO);
		vDepartmentTO.setSqlStr();
		logger.info("add sql is :" + vDepartmentTO.getSqlStr());
		
		try {
			TransactionTemplate.executeTransaction(vDepartmentTO, true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vDepartmentVO;
	}

	/**
	 * 
	 * @param vDepartmentVO
	 * @param tManager
	 * @return DepartmentVO
	 * @throws SQLException
	 */
	public static DepartmentVO modifyParent(String id,String parentID) {
		
		DepartmentVO vDepartmentVO = new DepartmentVO();
		DepartmentVO dVo = new DepartmentVO();
		dVo.setId(parentID);
		ArrayList<DepartmentVO> list;
		try {
			list = (ArrayList<DepartmentVO>)DepartmentDAO.query(dVo, null);
			if(list!=null&&list.size()==1)
				vDepartmentVO.setLinkCodeID(id+","+list.get(0).getLinkCodeID());	
			
		} catch (SQLException e1) {
		}
		
		vDepartmentVO.setId(id);
		vDepartmentVO.setParentId(parentID);
		DepartmentTO vDepartmentTO = new DepartmentTO(
				DepartmentTO.MODIFY_PARENT, vDepartmentVO);
		vDepartmentTO.setSqlStr();
		logger.info("modify sql is :" + vDepartmentTO.getSqlStr());

		try {
			TransactionTemplate.executeTransaction(vDepartmentTO, true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return vDepartmentVO;
	}
	
	/**
	 * 
	 * @param vDepartmentVO
	 * @param tManager
	 * @return DepartmentVO
	 * @throws SQLException
	 */
	public static DepartmentVO modifyDepartment(DepartmentVO vDepartmentVO) {
		DepartmentVO dVo = new DepartmentVO();
		dVo.setId(vDepartmentVO.getId());
		ArrayList<DepartmentVO> list;
		try {
			list = (ArrayList<DepartmentVO>)DepartmentDAO.query(dVo, null);
			if(list!=null&&list.size()==1)
				vDepartmentVO.setLinkCodeID(vDepartmentVO.getId()+","+list.get(0).getLinkCodeID());	
			
		} catch (SQLException e1) {
		}
		
		DepartmentTO vDepartmentTO = new DepartmentTO(
				DepartmentTO.MODIFY_DEPARTMENT, vDepartmentVO);
		vDepartmentTO.setSqlStr();
		logger.info("modify sql is :" + vDepartmentTO.getSqlStr());

		try {
			TransactionTemplate.executeTransaction(vDepartmentTO, true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return vDepartmentVO;
	}
	/**
	 * 异步更新标题
	 * @param id
	 * @param title
	 * @return true-修改成功 false-修改失败
	 */
	public static Boolean ajaxUpdateTitle(String id,String title){
		Boolean flag = false;
		
		DepartmentVO vDepartmentVO = new DepartmentVO();
		try {
			DepartmentVO dVo = new DepartmentVO();
			
			dVo.setId(id);
			ArrayList<DepartmentVO> list;
			
			list = (ArrayList<DepartmentVO>)DepartmentDAO.query(dVo, null);
			if(list!=null&&list.size()==1)
				vDepartmentVO.setLinkCodeID(list.get(0).getLinkCodeID());	
			vDepartmentVO.setId(id);
			vDepartmentVO.setTitle(title);
			DepartmentTO vDepartmentTO = new DepartmentTO(DepartmentTO.MODIFY_TITLE, vDepartmentVO);
			vDepartmentTO.setSqlStr();
			logger.info("modify sql is :" + vDepartmentTO.getSqlStr());

			TransactionTemplate.executeTransaction(vDepartmentTO, true);
			flag =true;
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return flag;
	}
	
	/**
	 * del byid
	 * @param vDepartmentVO
	 */
	public static int delDepartment(String id) {
		
		DepartmentVO vDepartmentVO = new DepartmentVO();
		vDepartmentVO.setId(id+"");
		DepartmentTO vDepartmentTO = new DepartmentTO(DepartmentTO.DEL_DEPARTMENT, vDepartmentVO);
		vDepartmentTO.setSqlStr();
		logger.info("delete sql is :" + vDepartmentTO.getSqlStr());

		try {
			TransactionTemplate.executeTransaction(vDepartmentTO, true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 异步删除数据，包括其子孙节点
	 * @param id
	 * @param title
	 */
	@SuppressWarnings("unchecked")
	public static void ajaxRemoveNode(String id){
		List list = getChildrenById(id);
		for (Object object : list) {
			DepartmentVO obj = (DepartmentVO)object;
			ajaxRemoveNode(obj.getId());
		}
		delDepartment(id);
	}
    
	public static ArrayList<DepartmentVO> getAllList(DepartmentVO d,PageController pageController)
	{
		StringBuffer strsql = new StringBuffer();

		strsql.append("select * from z_t_department  ");
		strsql.append(" order by id");
	
		DepartmentMQB vDepartmentMQB = new DepartmentMQB(DepartmentMQB.QUERY_FROM_DEPARTMENT);
		vDepartmentMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
        if(pageController ==null)
        {
        	pageController = new PageController();
        	pageController.setAll(true);	
        }
		try {
			QueryTemplate.executeQueryForList(vDepartmentMQB, pageController);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vDepartmentMQB.getDepartmentList();
		
	}
	/**
	 * 判断节点是否有子节点
	 * @param node_id
	 * @return boolean
	 * @throws SQLException
	 */
	public static boolean  ishaveChild(String node_id) {
		String sql = "select count(1) from z_t_department  where parentID =" + node_id ;
		
		DepartmentMQB vDepartmentMQB = new DepartmentMQB(DepartmentMQB.QUERY_CHECK_CHILD);
		vDepartmentMQB.setSql(sql);
		logger.info("query sql is :" + sql);
       
        PageController pageController = new PageController();
        pageController.setAll(true);	
        
		try {
			QueryTemplate.executeQueryForList(vDepartmentMQB, pageController);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vDepartmentMQB.getRes();
	}
	
	public static int deleteAll( TransactionManager tManager ) throws Exception {
		logger.info("DAO	deleteAll	begin");
		DepartmentVO departmentRoomVO = new DepartmentVO();
		DepartmentTO departmentRoomTO = new DepartmentTO(
				DepartmentTO.DEL_ALL,
				departmentRoomVO);

		departmentRoomTO.setSqlStr();
		logger.info("sqlStr	:	" + departmentRoomTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate
					.executeTransaction(departmentRoomTO, true);
		} else {
			TransactionTemplate.executeTransaction(departmentRoomTO,
					tManager);
		}
		logger.info("result	:	" + departmentRoomTO.getexecuteResult());
		logger.info("DAO	deleteAll	end");
		return departmentRoomTO.getexecuteResult();
	}
	public static List query(DepartmentVO dVo, PageController pageController) throws SQLException {
		logger.info("DAO	queryWithType	begin");
		DepartmentMQB vDepartmentMQB = new DepartmentMQB(DepartmentMQB.QUERY_FROM_DEPARTMENT,dVo);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + vDepartmentMQB.getSql());
		QueryTemplate.executeQueryForList(vDepartmentMQB, pageController);
		logger.info("list size	:	" + vDepartmentMQB.getDepartmentList().size());
		logger.info("DAO	queryWithType	end");
		return vDepartmentMQB.getDepartmentList();
	}
	
}
