package com.zzst.dao.meeting.address;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.dao.meeting.department.DepartmentMQB;
import com.zzst.model.meeting.address.AddressVO;
import com.zzst.model.meeting.department.DepartmentVO;

/**
 * class description: Address DAO
 * 
 * @date Tue Jul 10 17:01:48 CST 2012
 * @author ryan
 */
public class AddressDAO {
	private static Logger logger = CjfLogger.getLogger(AddressDAO.class.getName());

	/**
	 * add AddressVO object
	 * 
	 * @param AddressVO
	 * @param TransactionManager
	 * @return AddressVO
	 * @throws Exception
	 */
	public static AddressVO add(AddressVO addressVO, TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		addressVO.setAddressID(UtilDAO.getUUid());
		AddressTO addressTO = new AddressTO(AddressTO.ADD_ADDRESS, addressVO);

		addressTO.setSqlStr();
		logger.info("sqlStr	:	" + addressTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(addressTO, true);
		} else {
			TransactionTemplate.executeTransaction(addressTO, tManager);
		}
		logger.info("DAO	add	end");
		return addressVO;
	}

	/**
	 * query AddressVO list
	 * 
	 * @param AddressVO
	 * @param PageController
	 * @return ArrayList<AddressVO>
	 * @throws Exception
	 */
	public static ArrayList<AddressVO> query(AddressVO addressVO, PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		AddressMQB addressMQB = new AddressMQB(AddressMQB.QUERY_FROM_ADDRESS, addressVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + addressMQB.getSql());
		QueryTemplate.executeQueryForList(addressMQB, pageController);
		logger.info("list size	:	" + addressMQB.getAddressList().size());
		logger.info("DAO	query	end");
		return addressMQB.getAddressList();
	}

	/**
	 * query AddressVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<AddressVO>
	 * @throws Exception
	 */
	public static ArrayList<AddressVO> queryByIDs(String ids, PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		AddressMQB addressMQB = new AddressMQB(AddressMQB.QUERY_FROM_ADDRESS_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + addressMQB.getSql());
		QueryTemplate.executeQueryForList(addressMQB, pageController);
		logger.info("list size	:	" + addressMQB.getAddressList().size());
		logger.info("DAO	queryByIDs	end");
		return addressMQB.getAddressList();
	}

	/**
	 * modify AddressVO column by ID
	 * 
	 * @param AddressVO
	 * @param TransactionManager
	 * @return AddressVO
	 * @throws Exception
	 */
	public static AddressVO modify(AddressVO addressVO, TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		AddressTO addressTO = new AddressTO(AddressTO.MODIFY_ADDRESS, addressVO);
		addressTO.setSqlStr();
		logger.info("sqlStr	:	" + addressTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(addressTO, true);
		} else {
			TransactionTemplate.executeTransaction(addressTO, tManager);
		}
		logger.info("DAO	modify	end");
		return addressVO;
	}

	/**
	 * delete AddressVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return AddressVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager) throws Exception {
		logger.info("DAO	deleteByID	begin");
		AddressVO addressVO = new AddressVO();
		addressVO.setAddressID(ids);
		AddressTO addressTO = new AddressTO(AddressTO.DEL_ADDRESS, addressVO);

		addressTO.setSqlStr();
		logger.info("sqlStr	:	" + addressTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(addressTO, true);
		} else {
			TransactionTemplate.executeTransaction(addressTO, tManager);
		}
		logger.info("result	:	" + addressTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return addressTO.getexecuteResult();
	}
	
	/**
	 * 判断节点是否有子节点
	 * @author tanzanlong
	 * @param node_id
	 * @return boolean
	 * @throws SQLException
	 */
	public static boolean  ishaveChild(String node_id) {
		logger.info("DAO	ishaveChild	begin");
		String sql = "select count(1) from  z_t_address  where parentID =" + node_id ;
		AddressMQB vAddressMQB = new AddressMQB(AddressMQB.QUERY_CHECK_CHILD);
		vAddressMQB.setSql(sql);
		logger.info("query sql is :" + sql); 
        PageController pageController = new PageController();
        pageController.setAll(true);	
        
		try {
			QueryTemplate.executeQueryForList(vAddressMQB, pageController);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("DAO	ishaveChild	end");
		return vAddressMQB.getRes();
	}
	
	/**
     *  获得指定节点的所有子节点
     *  @author tanzanlong
     * @param id
     * @return List<DepartmentVO>
     */
	public static List<AddressVO> getChildrenById(String id){
		logger.info("DAO	getChildrenById	begin");
		StringBuffer strsql = new StringBuffer();
		strsql.append("select * from z_t_address where parentID = '");
		strsql.append(id);
		strsql.append("' order by addressid");
		AddressMQB vAddressMQB = new AddressMQB(AddressMQB.QUERY_FROM_ADDRESS);
		vAddressMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
		PageController	mPageController = new PageController();
		mPageController.setAll(true);	
		try {
			QueryTemplate.executeQueryForList(vAddressMQB, mPageController);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("DAO	getChildrenById	end");
		return vAddressMQB.getAddressList();
		
	}
	
}
