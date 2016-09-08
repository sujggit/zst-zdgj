package com.zzst.dao.meeting.equipment;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.equipment.EquipmentGroupVO;
import com.zzst.model.meeting.equipment.EquipmentVO;

/**
 * class description: EquipmentGroup DAO
 * 
 * @date Thu Apr 24 11:55:59 CST 2014
 * @author ryan
 */
public class EquipmentGroupDAO {
	private static Logger logger = CjfLogger.getLogger(EquipmentGroupDAO.class
			.getName());

	/**
	 * add EquipmentGroupVO object
	 * 
	 * @param EquipmentGroupVO
	 * @param TransactionManager
	 * @return EquipmentGroupVO
	 * @throws Exception
	 */
	public static EquipmentGroupVO add(EquipmentGroupVO equipmentGroupVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		equipmentGroupVO.setId(UtilDAO.getUUid());
		EquipmentGroupTO equipmentGroupTO = new EquipmentGroupTO(
				EquipmentGroupTO.ADD_EQUIPMENTGROUP, equipmentGroupVO);

		equipmentGroupTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentGroupTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentGroupTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentGroupTO, tManager);
		}
		logger.info("DAO	add	end");
		return equipmentGroupVO;
	}

	/**
	 * modify EquipmentGroupVO column by ID
	 * 
	 * @param EquipmentGroupVO
	 * @param TransactionManager
	 * @return EquipmentGroupVO
	 * @throws Exception
	 */
	public static EquipmentGroupVO modify(EquipmentGroupVO equipmentGroupVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		EquipmentGroupTO equipmentGroupTO = new EquipmentGroupTO(
				EquipmentGroupTO.MODIFY_EQUIPMENTGROUP, equipmentGroupVO);
		equipmentGroupTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentGroupTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentGroupTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentGroupTO, tManager);
		}
		logger.info("DAO	modify	end");
		return equipmentGroupVO;
	}

	/**
	 * query EquipmentGroupVO list 注意：
	 * 查询当前表状态不为失效的数据，如果包含关联查询不过滤其状态。如：关联用户信息，不管用户是否正常都需要查询出该数据。 需要把关联信息的状态带到前台
	 * 
	 * @param EquipmentGroupVO
	 * @param PageController
	 * @return ArrayList<EquipmentGroupVO>
	 * @throws Exception
	 */
	public static ArrayList<EquipmentGroupVO> query(
			EquipmentGroupVO equipmentGroupVO, PageController pageController)
			throws Exception {
		logger.info("DAO	query	begin");
		EquipmentGroupMQB equipmentGroupMQB = new EquipmentGroupMQB(
				EquipmentGroupMQB.QUERY_FROM_EQUIPMENTGROUP, equipmentGroupVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentGroupMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentGroupMQB, pageController);
		logger.info("list size	:	"
				+ equipmentGroupMQB.getEquipmentGroupList().size());
		logger.info("DAO	query	end");
		return equipmentGroupMQB.getEquipmentGroupList();
	}

	public static ArrayList<EquipmentGroupVO> query(
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		EquipmentGroupMQB equipmentGroupMQB = new EquipmentGroupMQB(
				EquipmentGroupMQB.QUERY_FROM_EQUIPMENTGROUP_group, null);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentGroupMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentGroupMQB, pageController);
		logger.info("list size	:	"
				+ equipmentGroupMQB.getEquipmentGroupList().size());
		logger.info("DAO	query	end");
		return equipmentGroupMQB.getEquipmentGroupList();
	}

	/**
	 * query EquipmentGroupVO list by IDs 查询多个id时，id格式为：a,b,c,d
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<EquipmentGroupVO>
	 * @throws Exception
	 */
	public static ArrayList<EquipmentGroupVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		EquipmentGroupVO equipmentGroupVO = new EquipmentGroupVO();
		equipmentGroupVO.setId(ids);
		EquipmentGroupMQB equipmentGroupMQB = new EquipmentGroupMQB(
				EquipmentGroupMQB.QUERY_FROM_EQUIPMENTGROUP_BY_IDS,
				equipmentGroupVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentGroupMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentGroupMQB, pageController);
		logger.info("list size	:	"
				+ equipmentGroupMQB.getEquipmentGroupList().size());
		logger.info("DAO	queryByIDs	end");
		return equipmentGroupMQB.getEquipmentGroupList();
	}

	/**
	 * delete EquipmentGroupVO by ids 多个id时，id格式为：a,b,c,d
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return EquipmentGroupVO
	 * @throws Exception
	 */
	public static int deleteByIDs(String ids, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		EquipmentGroupVO equipmentGroupVO = new EquipmentGroupVO();
		equipmentGroupVO.setId(ids);
		EquipmentGroupTO equipmentGroupTO = new EquipmentGroupTO(
				EquipmentGroupTO.DEL_EQUIPMENTGROUP, equipmentGroupVO);

		equipmentGroupTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentGroupTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentGroupTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentGroupTO, tManager);
		}
		logger.info("result	:	" + equipmentGroupTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return equipmentGroupTO.getexecuteResult();
	}

	/**
	 * query EquipmentGroupVO list 模糊查询
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<EquipmentGroupVO>
	 * @throws Exception
	 */
	public static ArrayList<EquipmentGroupVO> queryFuzzySearch(String str,
			PageController pageController) throws Exception {
		
		logger.info("DAO	queryFuzzySearch	begin");
		
		EquipmentGroupVO egVO = new EquipmentGroupVO();
		egVO.setGroupname(str);
		EquipmentGroupMQB equipmentGroupMQB = new EquipmentGroupMQB(
				EquipmentGroupMQB.QUERY_FROM_EQUIPMENTGROUP_GROUPNAME, egVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentGroupMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentGroupMQB, pageController);
		logger.info("list size	:	"
				+ equipmentGroupMQB.getEquipmentGroupList().size());
		logger.info("DAO	queryFuzzySearch	end");
		return equipmentGroupMQB.getEquipmentGroupList();
	}

	public static int deleteByName(String groupname, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByName	begin");
		EquipmentGroupVO equipmentGroupVO = new EquipmentGroupVO();
		equipmentGroupVO.setGroupname(groupname);
		EquipmentGroupTO equipmentGroupTO = new EquipmentGroupTO(
				EquipmentGroupTO.DEL_BYGROUPNAME, equipmentGroupVO);

		equipmentGroupTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentGroupTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentGroupTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentGroupTO, tManager);
		}
		logger.info("result	:	" + equipmentGroupTO.getexecuteResult());
		logger.info("DAO	deleteByName	end");
		return equipmentGroupTO.getexecuteResult();
	}
}
