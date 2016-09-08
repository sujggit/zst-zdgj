package com.zzst.dao.meeting.levelConfig;

import java.sql.SQLException;
import java.util.ArrayList;


import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.levelConfig.LevelConfigVO;

import org.apache.log4j.Logger;

/**
 * class description: LevelConfig DAO
 * 
 * @date Mon Nov 18 11:28:49 CST 2013
 * @author ryan
 */
public class LevelConfigDAO {
	private static Logger logger = CjfLogger.getLogger(LevelConfigDAO.class
			.getName());


	/**
	 * add LevelConfigVO object
	 * 
	 * @param LevelConfigVO
	 * @param TransactionManager
	 * @return LevelConfigVO
	 * @throws Exception
	 */
	public static LevelConfigVO add(LevelConfigVO levelConfigVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		// levelConfigVO.setLevelID(UtilDAO.getUUid());
		levelConfigVO.setLid(UtilDAO.getUUid());//增加lid，确保数据唯一性
		LevelConfigTO levelConfigTO = new LevelConfigTO(
				LevelConfigTO.ADD_LEVELCONFIG, levelConfigVO);

		levelConfigTO.setSqlStr();
		logger.info("sqlStr	:	" + levelConfigTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(levelConfigTO, true);
		} else {
			TransactionTemplate.executeTransaction(levelConfigTO, tManager);
		}
		logger.info("DAO	add	end");
		return levelConfigVO;
	}

	/**
	 * query LevelConfigVO list
	 * 
	 * @param LevelConfigVO
	 * @param PageController
	 * @return ArrayList<LevelConfigVO>
	 * @throws Exception
	 */
	public static ArrayList<LevelConfigVO> query(LevelConfigVO levelConfigVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		LevelConfigMQB levelConfigMQB = new LevelConfigMQB(
				LevelConfigMQB.QUERY_FROM_LEVELCONFIG, levelConfigVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + levelConfigMQB.getSql());
		QueryTemplate.executeQueryForList(levelConfigMQB, pageController);
		logger
				.info("list size	:	"
						+ levelConfigMQB.getLevelConfigList().size());
		logger.info("DAO	query	end");
		return levelConfigMQB.getLevelConfigList();
	}

	/**
	 * query LevelConfigVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<LevelConfigVO>
	 * @throws Exception
	 */
	public static ArrayList<LevelConfigVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		LevelConfigMQB levelConfigMQB = new LevelConfigMQB(
				LevelConfigMQB.QUERY_FROM_LEVELCONFIG_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + levelConfigMQB.getSql());
		QueryTemplate.executeQueryForList(levelConfigMQB, pageController);
		logger
				.info("list size	:	"
						+ levelConfigMQB.getLevelConfigList().size());
		logger.info("DAO	queryByIDs	end");
		return levelConfigMQB.getLevelConfigList();
	}

	/**
	 * modify LevelConfigVO column by ID
	 * 
	 * @param LevelConfigVO
	 * @param TransactionManager
	 * @return LevelConfigVO
	 * @throws Exception
	 */
	public static LevelConfigVO modify(LevelConfigVO levelConfigVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		LevelConfigTO levelConfigTO = new LevelConfigTO(
				LevelConfigTO.MODIFY_LEVELCONFIG, levelConfigVO);
		levelConfigTO.setSqlStr();
		logger.info("sqlStr	:	" + levelConfigTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(levelConfigTO, true);
		} else {
			TransactionTemplate.executeTransaction(levelConfigTO, tManager);
		}
		logger.info("DAO	modify	end");
		return levelConfigVO;
	}

	/**
	 * delete LevelConfigVO by id
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return LevelConfigVO
	 * @throws Exception
	 */
	public static int deleteByID(String id, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		LevelConfigVO levelConfigVO = new LevelConfigVO();
		levelConfigVO.setLevelID(id);
		LevelConfigTO levelConfigTO = new LevelConfigTO(
				LevelConfigTO.DEL_LEVELCONFIG, levelConfigVO);

		levelConfigTO.setSqlStr();
		logger.info("sqlStr	:	" + levelConfigTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(levelConfigTO, true);
		} else {
			TransactionTemplate.executeTransaction(levelConfigTO, tManager);
		}
		logger.info("result	:	" + levelConfigTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return levelConfigTO.getexecuteResult();
	}

	public static ArrayList<LevelConfigVO> queryWithType(
			LevelConfigVO levelConfigVO, PageController pageController)
			throws Exception {
		logger.info("DAO	queryWithType	begin");
		LevelConfigJoinMQB levelConfigJoinMQB = new LevelConfigJoinMQB(
				LevelConfigJoinMQB.QUERY_FROM_LEVELCONFIG, levelConfigVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + levelConfigJoinMQB.getSql());
		QueryTemplate.executeQueryForList(levelConfigJoinMQB, pageController);
		logger.info("list size	:	"
				+ levelConfigJoinMQB.getLevelConfigList().size());
		logger.info("DAO	queryWithType	end");
		return levelConfigJoinMQB.getLevelConfigList();
	}

	//@author:zhangjy
	public static ArrayList<LevelConfigVO> queryTypeAndLids(String lids,String levelType) throws Exception {
		PageController pageController=new PageController();
		logger.info("DAO	queryTypeAndLids	begin");
		LevelConfigJoinMQB levelConfigJoinMQB = new LevelConfigJoinMQB(LevelConfigJoinMQB.QUERY_FROM_LEVELCONFIG_ONLY,new LevelConfigVO());
		String sql="select * from z_t_level_config as ztl where 1=1 ";
		sql+=" and ztl.levelType='"+levelType+"'";
		sql+=" and ztl.levelID in("+lids+")";
		levelConfigJoinMQB.setSql(sql);
		
		 pageController.setAll(true);
		
		logger.info("sqlStr	:	" + levelConfigJoinMQB.getSql());
		QueryTemplate.executeQueryForList(levelConfigJoinMQB, pageController);
		logger.info("list size	:	" + levelConfigJoinMQB.getLevelConfigList().size());
		logger.info("DAO	queryTypeAndLids	end");
		return levelConfigJoinMQB.getLevelConfigList();
	}

	/**
	 * 删除分级下的所有用户。
	 * @param levelConfigVO
	 * @param tManager
	 * @return
	 * @throws SQLException
	 */
	public static int delLevelVO(LevelConfigVO levelConfigVO, TransactionManager tManager)
			throws SQLException {
		LevelConfigTO levelConfigTO = new LevelConfigTO(LevelConfigTO.DEL_LEVELVO, levelConfigVO);
		levelConfigTO.setSqlStr();
		logger.info("delete sql is :" + levelConfigTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(levelConfigTO, true);
		} else {
			TransactionTemplate.executeTransaction(levelConfigTO, tManager);
		}
		return levelConfigTO.getexecuteResult();
	}

}
