package com.zzst.dao.meeting.post;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.post.PostVO;

import org.apache.log4j.Logger;

/**
 * class description: Post DAO
 * 
 * @date Fri Jun 28 15:38:38 CST 2013
 * @author ryan
 */
public class PostDAO {
	private static Logger logger = CjfLogger.getLogger(PostDAO.class.getName());

	private static final String id = "PostNO";

	/**
	 * add PostVO object
	 * 
	 * @param PostVO
	 * @param TransactionManager
	 * @return PostVO
	 * @throws Exception
	 */
	public static PostVO add(PostVO postVO, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	add	begin");
		postVO.setId(UtilDAO.getUUid());
		PostTO postTO = new PostTO(PostTO.ADD_POST, postVO);

		postTO.setSqlStr();
		logger.info("sqlStr	:	" + postTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(postTO, true);
		} else {
			TransactionTemplate.executeTransaction(postTO, tManager);
		}
		logger.info("DAO	add	end");
		return postVO;
	}

	/**
	 * query PostVO list
	 * 
	 * @param PostVO
	 * @param PageController
	 * @return ArrayList<PostVO>
	 * @throws Exception
	 */
	public static ArrayList<PostVO> query(PostVO postVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		PostMQB postMQB = new PostMQB(PostMQB.QUERY_FROM_POST, postVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + postMQB.getSql());
		QueryTemplate.executeQueryForList(postMQB, pageController);
		logger.info("list size	:	" + postMQB.getPostList().size());
		logger.info("DAO	query	end");
		return postMQB.getPostList();
	}

	/**
	 * query PostVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<PostVO>
	 * @throws Exception
	 */
	public static ArrayList<PostVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		PostMQB postMQB = new PostMQB(PostMQB.QUERY_FROM_POST_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + postMQB.getSql());
		QueryTemplate.executeQueryForList(postMQB, pageController);
		logger.info("list size	:	" + postMQB.getPostList().size());
		logger.info("DAO	queryByIDs	end");
		return postMQB.getPostList();
	}

	/**
	 * modify PostVO column by ID
	 * 
	 * @param PostVO
	 * @param TransactionManager
	 * @return PostVO
	 * @throws Exception
	 */
	public static PostVO modify(PostVO postVO, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	modify	begin");
		PostTO postTO = new PostTO(PostTO.MODIFY_POST, postVO);
		postTO.setSqlStr();
		logger.info("sqlStr	:	" + postTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(postTO, true);
		} else {
			TransactionTemplate.executeTransaction(postTO, tManager);
		}
		logger.info("DAO	modify	end");
		return postVO;
	}

	/**
	 * delete PostVO by id
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return PostVO
	 * @throws Exception
	 */
	public static int deleteByID(String id, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		PostVO postVO = new PostVO();
		postVO.setId(id);
		PostTO postTO = new PostTO(PostTO.DEL_POST, postVO);

		postTO.setSqlStr();
		logger.info("sqlStr	:	" + postTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(postTO, true);
		} else {
			TransactionTemplate.executeTransaction(postTO, tManager);
		}
		logger.info("result	:	" + postTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return postTO.getexecuteResult();
	}
}
