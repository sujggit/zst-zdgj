package com.zzst.dao.meeting.kst;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.kst.WallPresetVO;

/**
 * class description: WallPreset DAO
 * 
 * @date Mon Jul 30 14:19:01 CST 2012
 * @author ryan
 */
public class WallPresetDAO {
	private static Logger logger = CjfLogger.getLogger(WallPresetDAO.class.getName());


	/**
	 * add WallPresetVO object
	 * 
	 * @param WallPresetVO
	 * @param TransactionManager
	 * @return WallPresetVO
	 * @throws Exception
	 */
	public static WallPresetVO add(WallPresetVO wallPresetVO, TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		if(wallPresetVO.getId()==null||wallPresetVO.getId().length()==0)
			wallPresetVO.setId(UtilDAO.getUUid());
		WallPresetTO wallPresetTO = new WallPresetTO(WallPresetTO.ADD_WALLPRESET, wallPresetVO);

		wallPresetTO.setSqlStr();
		logger.info("sqlStr	:	" + wallPresetTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(wallPresetTO, true);
		} else {
			TransactionTemplate.executeTransaction(wallPresetTO, tManager);
		}
		logger.info("DAO	add	end");
		return wallPresetVO;
	}

	/**
	 * query WallPresetVO list
	 * 
	 * @param WallPresetVO
	 * @param PageController
	 * @return ArrayList<WallPresetVO>
	 * @throws Exception
	 */
	public static ArrayList<WallPresetVO> query(WallPresetVO wallPresetVO, PageController pageController)
			throws Exception {
		logger.info("DAO	query	begin");
		WallPresetMQB wallPresetMQB = new WallPresetMQB(WallPresetMQB.QUERY_FROM_WALLPRESET, wallPresetVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + wallPresetMQB.getSql());
		QueryTemplate.executeQueryForList(wallPresetMQB, pageController);
		logger.info("list size	:	" + wallPresetMQB.getWallPresetList().size());
		logger.info("DAO	query	end");
		return wallPresetMQB.getWallPresetList();
	}

	/**
	 * query WallPresetVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<WallPresetVO>
	 * @throws Exception
	 */
	public static ArrayList<WallPresetVO> queryByIDs(String ids, PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		WallPresetVO wallPresetVO =new WallPresetVO();
		wallPresetVO.setId(ids);
		WallPresetMQB wallPresetMQB = new WallPresetMQB(WallPresetMQB.QUERY_FROM_WALLPRESET_BY_IDS, wallPresetVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + wallPresetMQB.getSql());
		QueryTemplate.executeQueryForList(wallPresetMQB, pageController);
		logger.info("list size	:	" + wallPresetMQB.getWallPresetList().size());
		logger.info("DAO	queryByIDs	end");
		return wallPresetMQB.getWallPresetList();
	}

	/**
	 * modify WallPresetVO column by ID
	 * 
	 * @param WallPresetVO
	 * @param TransactionManager
	 * @return WallPresetVO
	 * @throws Exception
	 */
	public static WallPresetVO modify(WallPresetVO wallPresetVO, TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		WallPresetTO wallPresetTO = new WallPresetTO(WallPresetTO.MODIFY_WALLPRESET, wallPresetVO);
		wallPresetTO.setSqlStr();
		logger.info("sqlStr	:	" + wallPresetTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(wallPresetTO, true);
		} else {
			TransactionTemplate.executeTransaction(wallPresetTO, tManager);
		}
		logger.info("DAO	modify	end");
		return wallPresetVO;
	}

	/**
	 * delete WallPresetVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return WallPresetVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager) throws Exception {
		logger.info("DAO	deleteByID	begin");
		WallPresetVO wallPresetVO = new WallPresetVO();
		wallPresetVO.setId(ids);
		WallPresetTO wallPresetTO = new WallPresetTO(WallPresetTO.DEL_WALLPRESET, wallPresetVO);

		wallPresetTO.setSqlStr();
		logger.info("sqlStr	:	" + wallPresetTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(wallPresetTO, true);
		} else {
			TransactionTemplate.executeTransaction(wallPresetTO, tManager);
		}
		logger.info("result	:	" + wallPresetTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return wallPresetTO.getexecuteResult();
	}
	
	public static int deleteAll(TransactionManager tManager) throws Exception {
		logger.info("DAO	deleteAll	begin");
		WallPresetVO wallPresetVO = new WallPresetVO();
		WallPresetTO wallPresetTO = new WallPresetTO(WallPresetTO.DEL_WALLPRESET_ALL, wallPresetVO);

		wallPresetTO.setSqlStr();
		logger.info("sqlStr	:	" + wallPresetTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(wallPresetTO, true);
		} else {
			TransactionTemplate.executeTransaction(wallPresetTO, tManager);
		}
		logger.info("result	:	" + wallPresetTO.getexecuteResult());
		logger.info("DAO	deleteAll	end");
		return wallPresetTO.getexecuteResult();
	}
}
