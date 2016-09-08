package com.zzst.dao.meeting.dictionary;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.gsiec.cjf.util.CjfSequenceUtil;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.dao.common.UtilDAO;
import com.zzst.dao.meeting.address.AddressMQB;
import com.zzst.model.meeting.address.AddressVO;
import com.zzst.model.meeting.dictionary.DictionaryEquipmentVO;

import org.apache.log4j.Logger;

/**
 * class description: DictionaryEquipment DAO
 * 
 * @date Tue Jan 14 10:15:59 CST 2014
 * @author ryan
 */
public class DictionaryEquipmentDAO {
	private static Logger logger = CjfLogger
			.getLogger(DictionaryEquipmentDAO.class.getName());

	private static final String id = "DicID";

	/**
	 * add DictionaryEquipmentVO object
	 * 
	 * @param DictionaryEquipmentVO
	 * @param TransactionManager
	 * @return DictionaryEquipmentVO
	 * @throws Exception
	 */
	public static DictionaryEquipmentVO add(
			DictionaryEquipmentVO dictionaryEquipmentVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		dictionaryEquipmentVO.setDicID(UtilDAO.getUUid());
		DictionaryEquipmentTO dictionaryEquipmentTO = new DictionaryEquipmentTO(
				DictionaryEquipmentTO.ADD_DICTIONARYEQUIPMENT,
				dictionaryEquipmentVO);

		dictionaryEquipmentTO.setSqlStr();
		logger.info("sqlStr	:	" + dictionaryEquipmentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(dictionaryEquipmentTO, true);
		} else {
			TransactionTemplate.executeTransaction(dictionaryEquipmentTO,
					tManager);
		}
		logger.info("DAO	add	end");
		return dictionaryEquipmentVO;
	}

	/**
	 * query DictionaryEquipmentVO list
	 * 
	 * @param DictionaryEquipmentVO
	 * @param PageController
	 * @return ArrayList<DictionaryEquipmentVO>
	 * @throws Exception
	 */
	public static ArrayList<DictionaryEquipmentVO> query(
			DictionaryEquipmentVO dictionaryEquipmentVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		DictionaryEquipmentMQB dictionaryEquipmentMQB = new DictionaryEquipmentMQB(
				DictionaryEquipmentMQB.QUERY_FROM_DICTIONARYEQUIPMENT,
				dictionaryEquipmentVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + dictionaryEquipmentMQB.getSql());
		QueryTemplate.executeQueryForList(dictionaryEquipmentMQB,
				pageController);
		logger.info("list size	:	"
				+ dictionaryEquipmentMQB.getDictionaryEquipmentList().size());
		logger.info("DAO	query	end");
		return dictionaryEquipmentMQB.getDictionaryEquipmentList();
	}

	public static ArrayList<DictionaryEquipmentVO> queryByValue(
			DictionaryEquipmentVO dictionaryEquipmentVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		DictionaryEquipmentMQB dictionaryEquipmentMQB = new DictionaryEquipmentMQB(
				DictionaryEquipmentMQB.QUERY_BY_VALUE,
				dictionaryEquipmentVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + dictionaryEquipmentMQB.getSql());
		QueryTemplate.executeQueryForList(dictionaryEquipmentMQB,
				pageController);
		logger.info("list size	:	"
				+ dictionaryEquipmentMQB.getDictionaryEquipmentList().size());
		logger.info("DAO	query	end");
		return dictionaryEquipmentMQB.getDictionaryEquipmentList();
	}
	
	/**
	 * query DictionaryEquipmentVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<DictionaryEquipmentVO>
	 * @throws Exception
	 */
	public static ArrayList<DictionaryEquipmentVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		DictionaryEquipmentMQB dictionaryEquipmentMQB = new DictionaryEquipmentMQB(
				DictionaryEquipmentMQB.QUERY_FROM_DICTIONARYEQUIPMENT_BY_IDS,
				ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + dictionaryEquipmentMQB.getSql());
		QueryTemplate.executeQueryForList(dictionaryEquipmentMQB,
				pageController);
		logger.info("list size	:	"
				+ dictionaryEquipmentMQB.getDictionaryEquipmentList().size());
		logger.info("DAO	queryByIDs	end");
		return dictionaryEquipmentMQB.getDictionaryEquipmentList();
	}

	/**
	 * modify DictionaryEquipmentVO column by ID
	 * 
	 * @param DictionaryEquipmentVO
	 * @param TransactionManager
	 * @return DictionaryEquipmentVO
	 * @throws Exception
	 */
	public static DictionaryEquipmentVO modify(
			DictionaryEquipmentVO dictionaryEquipmentVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		DictionaryEquipmentTO dictionaryEquipmentTO = new DictionaryEquipmentTO(
				DictionaryEquipmentTO.MODIFY_DICTIONARYEQUIPMENT,
				dictionaryEquipmentVO);
		dictionaryEquipmentTO.setSqlStr();
		logger.info("sqlStr	:	" + dictionaryEquipmentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(dictionaryEquipmentTO, true);
		} else {
			TransactionTemplate.executeTransaction(dictionaryEquipmentTO,
					tManager);
		}
		logger.info("DAO	modify	end");
		return dictionaryEquipmentVO;
	}

	/**
	 * delete DictionaryEquipmentVO by id
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return DictionaryEquipmentVO
	 * @throws Exception
	 */
	public static int deleteByID(String id, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		DictionaryEquipmentVO dictionaryEquipmentVO = new DictionaryEquipmentVO();
		dictionaryEquipmentVO.setDicID(id);
		DictionaryEquipmentTO dictionaryEquipmentTO = new DictionaryEquipmentTO(
				DictionaryEquipmentTO.DEL_DICTIONARYEQUIPMENT,
				dictionaryEquipmentVO);

		dictionaryEquipmentTO.setSqlStr();
		logger.info("sqlStr	:	" + dictionaryEquipmentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(dictionaryEquipmentTO, true);
		} else {
			TransactionTemplate.executeTransaction(dictionaryEquipmentTO,
					tManager);
		}
		logger.info("result	:	" + dictionaryEquipmentTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return dictionaryEquipmentTO.getexecuteResult();
	}
	
	/**
     *  获得指定节点的所有子节点
     *  @author liujf
     * @param id
     * @return List<DepartmentVO>
     */
	public static List<DictionaryEquipmentVO> getChildrenById(String id){
		logger.info("DAO	getChildrenById	  begin");
		StringBuffer strsql = new StringBuffer();
		strsql.append("select * from z_t_equipment_dictionary where parentID = '");
		strsql.append(id);
		strsql.append("' order by dicID");
		DictionaryEquipmentMQB dicEquipmentMQB = new DictionaryEquipmentMQB(DictionaryEquipmentMQB.QUERY_FROM_DICTIONARYEQUIPMENT);
		dicEquipmentMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
		PageController	mPageController = new PageController();
		mPageController.setAll(true);	
		try {
			QueryTemplate.executeQueryForList(dicEquipmentMQB, mPageController);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.info("DAO	getChildrenById	end");
		return dicEquipmentMQB.getDictionaryEquipmentList();
		
	}
	/**
	 * 根据pid获取网络拓扑树的一级节点。
	 * @param dictionaryEquipmentVO
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<DictionaryEquipmentVO> queryByPid(
			DictionaryEquipmentVO dictionaryEquipmentVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		DictionaryEquipmentMQB dictionaryEquipmentMQB = new DictionaryEquipmentMQB(
				DictionaryEquipmentMQB.QUERY_FROM_DICTIONARYEQUIPMENT_BY_PID,
				dictionaryEquipmentVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + dictionaryEquipmentMQB.getSql());
		QueryTemplate.executeQueryForList(dictionaryEquipmentMQB,
				pageController);
		logger.info("list size	:	"
				+ dictionaryEquipmentMQB.getDictionaryEquipmentList().size());
		logger.info("DAO	query	end");
		return dictionaryEquipmentMQB.getDictionaryEquipmentList();
	}
	
	public static ArrayList<DictionaryEquipmentVO> queryByStatusAndSysvalue(
			DictionaryEquipmentVO dictionaryEquipmentVO,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByStatusAndSysvalue	begin");
		DictionaryEquipmentMQB dictionaryEquipmentMQB = new DictionaryEquipmentMQB(
				DictionaryEquipmentMQB.QUERY_FROM_DICTIONARYEQUIPMENTALL,
				dictionaryEquipmentVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + dictionaryEquipmentMQB.getSql());
		QueryTemplate.executeQueryForList(dictionaryEquipmentMQB,
				pageController);
		logger.info("list size	:	"
				+ dictionaryEquipmentMQB.getDictionaryEquipmentList().size());
		logger.info("DAO	queryByStatusAndSysvalue	end");
		return dictionaryEquipmentMQB.getDictionaryEquipmentList();
	}
}
