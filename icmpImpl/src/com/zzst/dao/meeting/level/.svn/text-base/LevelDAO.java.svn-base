package com.zzst.dao.meeting.level;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.level.LevelVO;

import org.apache.log4j.Logger;

/**
 * class description: Level DAO
 * 
 * @date Thu Nov 14 10:43:30 CST 2013
 * @author ryan
 */
public class LevelDAO {
	private static Logger logger = CjfLogger
			.getLogger(LevelDAO.class.getName());

	private static final String id = "LevelID";

	/**
	 * add LevelVO object
	 * 
	 * @param LevelVO
	 * @param TransactionManager
	 * @return LevelVO
	 * @throws Exception
	 */
	public static LevelVO add(LevelVO levelVO, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	add	begin");
		if (levelVO.getLevelID() == null) {
			levelVO.setLevelID(UtilDAO.getUUid());
		}
		LevelTO levelGradeTO = new LevelTO(LevelTO.ADD_LEVELGRADE, levelVO);
		levelGradeTO.setSqlStr();
		logger.info("sqlStr	:	" + levelGradeTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(levelGradeTO, true);
		} else {
			TransactionTemplate.executeTransaction(levelGradeTO, tManager);
		}
		logger.info("DAO	add	end");
		return levelVO;
	}

	/**
	 * query LevelVO list
	 * 
	 * @param LevelVO
	 * @param PageController
	 * @return ArrayList<LevelVO>
	 * @throws Exception
	 */
	public static ArrayList<LevelVO> query(LevelVO levelVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		LevelMQB levelGradeMQB = new LevelMQB(LevelMQB.QUERY_FROM_LEVELGRADE,
				levelVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + levelGradeMQB.getSql());
		QueryTemplate.executeQueryForList(levelGradeMQB, pageController);
		logger.info("list size	:	" + levelGradeMQB.getLevelGradeList().size());
		logger.info("DAO	query	end");
		return levelGradeMQB.getLevelGradeList();
	}

	/**
	 * 
	 * @param levelVO
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<LevelVO> queryByPid(LevelVO levelVO,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByPid	begin");
		LevelMQB levelGradeMQB = new LevelMQB(LevelMQB.QUERY_FROM_LEVELBYPID,
				levelVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + levelGradeMQB.getSql());
		QueryTemplate.executeQueryForList(levelGradeMQB, pageController);
		logger.info("list size	:	" + levelGradeMQB.getLevelGradeList().size());
		logger.info("DAO	queryByPid	end");
		return levelGradeMQB.getLevelGradeList();
	}

	/**
	 * query LevelVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<LevelVO>
	 * @throws Exception
	 */
	public static ArrayList<LevelVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		LevelMQB levelGradeMQB = new LevelMQB(
				LevelMQB.QUERY_FROM_LEVELGRADE_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + levelGradeMQB.getSql());
		QueryTemplate.executeQueryForList(levelGradeMQB, pageController);
		logger.info("list size	:	" + levelGradeMQB.getLevelGradeList().size());
		logger.info("DAO	queryByIDs	end");
		return levelGradeMQB.getLevelGradeList();
	}

	/**
	 * modify LevelVO column by ID
	 * 
	 * @param LevelVO
	 * @param TransactionManager
	 * @return LevelVO
	 * @throws Exception
	 */
	public static LevelVO modify(LevelVO levelVO, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	modify	begin");
		LevelTO levelGradeTO = new LevelTO(LevelTO.MODIFY_LEVELGRADE, levelVO);
		levelGradeTO.setSqlStr();
		logger.info("sqlStr	:	" + levelGradeTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(levelGradeTO, true);
		} else {
			TransactionTemplate.executeTransaction(levelGradeTO, tManager);
		}
		logger.info("DAO	modify	end");
		return levelVO;
	}

	/**
	 * delete LevelVO by id
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return LevelVO
	 * @throws Exception
	 */
	public static int deleteByID(String id, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		LevelVO levelVO = new LevelVO();
		levelVO.setLevelID(id);
		LevelTO levelGradeTO = new LevelTO(LevelTO.DEL_LEVELGRADE, levelVO);

		levelGradeTO.setSqlStr();
		logger.info("sqlStr	:	" + levelGradeTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(levelGradeTO, true);
		} else {
			TransactionTemplate.executeTransaction(levelGradeTO, tManager);
		}
		logger.info("result	:	" + levelGradeTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return levelGradeTO.getexecuteResult();
	}

	/**
	 * 判断节点是否有子节点
	 * 
	 * @param node_id
	 * @return boolean author:tanzanlong
	 * @throws SQLException
	 */
	public static boolean ishaveChild(String node_id) throws SQLException {
		logger.info("LevelGradeDAO	 ishaveChild	begin");
		String sql = "select * from z_t_level  where pId ='" + node_id + "'";
		LevelMQB levelGradeMQB = new LevelMQB(LevelMQB.QUERY_CHECK_CHILD);
		levelGradeMQB.setSql(sql.toString());
		PageController mPageController = new PageController();
		mPageController.setAll(true);
		QueryTemplate.executeQueryForList(levelGradeMQB, mPageController);
		logger.info("FuncDAO	 ishaveChild	end");
		return levelGradeMQB.getres();
	}
	/**
	 * 判断是否有子节点。
	 * @param levelVO
	 * @param pageController
	 * @return
	 * @throws SQLException
	 */
	public static List<LevelVO> ishaveChildOne(LevelVO levelVO,PageController pageController) throws SQLException {
		logger.info("LevelGradeDAO	 ishaveChildOne  	begin");
		LevelMQB levelGradeMQB = new LevelMQB(
				LevelMQB.QUERY_CHECK_CHILD_ONE, levelVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + levelGradeMQB.getSql());
		QueryTemplate.executeQueryForList(levelGradeMQB, pageController);
		logger.info("list size	:	" + levelGradeMQB.getLevelGradeList().size());
		
		logger.info("DAO	ishaveChildOne	end");
		return levelGradeMQB.getLevelGradeList();
	}

	/**
	 * 获得指定节点的所有子节点
	 * 
	 * @param id
	 *            author:tanzanlong
	 * @return List<FuncVO>
	 */
	public static List<LevelVO> getChildrenById(String id) {
		logger.info("LevelGradeDAO	 getChildrenById	begin");
		StringBuffer strsql = new StringBuffer();
		strsql.append("select * from z_t_level where pId = '");
		strsql.append(id);
		strsql.append("' order by levelID");

		LevelMQB vlevelGradeMQB = new LevelMQB(LevelMQB.QUERY_FROM_LEVELGRADE);
		vlevelGradeMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		PageController mPageController = new PageController();
		mPageController.setAll(true);

		try {
			QueryTemplate.executeQueryForList(vlevelGradeMQB, mPageController);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.info("LevelGradeDAO	 getChildrenById	end");
		return vlevelGradeMQB.getLevelGradeList();

	}

	public static List<LevelVO> queryForLevelPath(String keystr) {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select * from z_t_level where levelPath like '%");
		strsql.append(keystr);
		strsql.append("%' order by levelID");

		LevelMQB vlevelGradeMQB = new LevelMQB(LevelMQB.QUERY_FROM_LEVELGRADE);
		vlevelGradeMQB.setSql(strsql.toString());
		logger.info(" queryForLevelPath query sql is :" + strsql.toString());

		PageController mPageController = new PageController();
		mPageController.setAll(true);

		try {
			QueryTemplate.executeQueryForList(vlevelGradeMQB, mPageController);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.info("LevelGradeDAO	 getChildrenById	end");
		return vlevelGradeMQB.getLevelGradeList();
	}

	public static int deleteByPID(String id, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByPID	begin");
		LevelVO levelVO = new LevelVO();
		levelVO.setLevelID(id);
		LevelTO levelGradeTO = new LevelTO(LevelTO.DEL_LEVELBYPID, levelVO);

		levelGradeTO.setSqlStr();
		logger.info("sqlStr	:	" + levelGradeTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(levelGradeTO, true);
		} else {
			TransactionTemplate.executeTransaction(levelGradeTO, tManager);
		}
		logger.info("result	:	" + levelGradeTO.getexecuteResult());
		logger.info("DAO	deleteByPID	end");
		return levelGradeTO.getexecuteResult();
	}

}
