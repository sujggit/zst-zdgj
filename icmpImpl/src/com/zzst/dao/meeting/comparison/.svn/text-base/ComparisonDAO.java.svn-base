package com.zzst.dao.meeting.comparison;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.comparison.ComparisonVO;

/**
 * class description:	Comparison DAO
 * @date Sat Apr 27 13:39:44 CST 2013
 * @author ryan
 */
public class ComparisonDAO {
	private static Logger logger = CjfLogger.getLogger(ComparisonDAO.class.getName());

	private static 	final	String	id="ID";

	/**
	 * add ComparisonVO	object
	 * @param ComparisonVO
	 * @param TransactionManager
	 * @return ComparisonVO
	 * @throws Exception
	 */
	public static ComparisonVO add(ComparisonVO comparisonVO,TransactionManager tManager)throws Exception{
		logger.info("DAO	add	begin");
		comparisonVO.setID(UtilDAO.getUUid());
		ComparisonTO comparisonTO=new ComparisonTO(ComparisonTO.ADD_COMPARISON,comparisonVO);

		comparisonTO.setSqlStr();
		logger.info("sqlStr	:	"+comparisonTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(comparisonTO, true);
		}else{
			TransactionTemplate.executeTransaction(comparisonTO, tManager);
		}
		logger.info("DAO	add	end");
		return comparisonVO;
	}
	/**
	 * replace ComparisonVO	object
	 * @param ComparisonVO
	 * @param TransactionManager
	 * @return ComparisonVO
	 * @throws Exception
	 */
	public static ComparisonVO replace(ComparisonVO comparisonVO,TransactionManager tManager)throws Exception{
		logger.info("DAO	replace	begin");
		ComparisonTO comparisonTO=new ComparisonTO(ComparisonTO.REPLACE_COMPARISON,comparisonVO);

		comparisonTO.setSqlStr();
		logger.info("sqlStr	:	"+comparisonTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(comparisonTO, true);
		}else{
			TransactionTemplate.executeTransaction(comparisonTO, tManager);
		}
		logger.info("DAO	replace	end");
		return comparisonVO;
	}
	
	/**
	 * 更新音频部分数据
	 * @param comparisonVO
	 * @param tManager
	 * @return
	 * @throws Exception
	 */
	public static ComparisonVO replaceAudio(ComparisonVO comparisonVO,TransactionManager tManager)throws Exception{
		logger.info("DAO	replace	begin");
		ComparisonTO comparisonTO=new ComparisonTO(ComparisonTO.MODIFY_COMPARISON_AUDIO,comparisonVO);

		comparisonTO.setSqlStr();
		logger.info("sqlStr	:	"+comparisonTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(comparisonTO, true);
		}else{
			TransactionTemplate.executeTransaction(comparisonTO, tManager);
		}
		logger.info("DAO	replace	end");
		return comparisonVO;
	}

	/**
	 * query ComparisonVO	list
	 * @param ComparisonVO
	 * @param PageController
	 * @return ArrayList<ComparisonVO> 
	 * @throws Exception
	 */
	public static ArrayList<ComparisonVO> query(ComparisonVO comparisonVO,PageController pageController) throws Exception{
		logger.info("DAO	query	begin");
		ComparisonMQB comparisonMQB=new ComparisonMQB(ComparisonMQB.QUERY_FROM_COMPARISON,comparisonVO);

		if(pageController==null){
			pageController=new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	"+comparisonMQB.getSql());
		QueryTemplate.executeQueryForList(comparisonMQB, pageController);
		logger.info("list size	:	"+comparisonMQB.getComparisonList().size());
		logger.info("DAO	query	end");
		return comparisonMQB.getComparisonList();
	}

	
	

	/**
	 * query ComparisonVO	list
	 * @param ComparisonVO
	 * @param PageController
	 * @return ArrayList<ComparisonVO> 
	 * @throws Exception
	 */
	public static ArrayList<ComparisonVO> queryHistory(ComparisonVO comparisonVO,PageController pageController) throws Exception{
		logger.info("DAO	query	begin");
		ComparisonMQB comparisonMQB=new ComparisonMQB(ComparisonMQB.QUERY_FROM_COMPARISON_HISTORY,comparisonVO);

		if(pageController==null){
			pageController=new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	"+comparisonMQB.getSql());
		QueryTemplate.executeQueryForList(comparisonMQB, pageController);
		logger.info("list size	:	"+comparisonMQB.getComparisonList().size());
		logger.info("DAO	query	end");
		return comparisonMQB.getComparisonList();
	}

	/**
	 * query ComparisonVO	list	by	IDs
	 * @param String
	 * @param PageController
	 * @return ArrayList<ComparisonVO> 
	 * @throws Exception
	 */
	public static ArrayList<ComparisonVO> queryByIDs(String ids,PageController pageController) throws Exception{
		logger.info("DAO	queryByIDs	begin");
		ComparisonMQB comparisonMQB=new ComparisonMQB(ComparisonMQB.QUERY_FROM_COMPARISON_BY_IDS,ids);

		if(pageController==null){
			pageController=new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	"+comparisonMQB.getSql());
		QueryTemplate.executeQueryForList(comparisonMQB, pageController);
		logger.info("list size	:	"+comparisonMQB.getComparisonList().size());
		logger.info("DAO	queryByIDs	end");
		return comparisonMQB.getComparisonList();
	}

	/**
	 * modify ComparisonVO column by ID
	 * @param ComparisonVO
	 * @param TransactionManager
	 * @return ComparisonVO
	 * @throws Exception
	 */
	public static ComparisonVO modify(ComparisonVO comparisonVO,TransactionManager tManager)throws Exception{
		logger.info("DAO	modify	begin");
		ComparisonTO comparisonTO=new ComparisonTO(ComparisonTO.MODIFY_COMPARISON,comparisonVO);		
		comparisonTO.setSqlStr();
		logger.info("sqlStr	:	"+comparisonTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(comparisonTO, true);
		}else{
			TransactionTemplate.executeTransaction(comparisonTO, tManager);
		}
		logger.info("DAO	modify	end");
		return comparisonVO;
	}



	/**
	 * delete	ComparisonVO by ids
	 * @param String
	 * @param TransactionManager
	 * @return ComparisonVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids,TransactionManager tManager)throws Exception{
		logger.info("DAO	deleteByID	begin");
		ComparisonVO comparisonVO = new ComparisonVO();
		comparisonVO.setID(ids);
		ComparisonTO comparisonTO=new ComparisonTO(ComparisonTO.DEL_COMPARISON,comparisonVO);

		comparisonTO.setSqlStr();
		logger.info("sqlStr	:	"+comparisonTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(comparisonTO, true);
		}else{
			TransactionTemplate.executeTransaction(comparisonTO, tManager);
		}
		logger.info("result	:	"+comparisonTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return comparisonTO.getexecuteResult();
	}
	
	public static int deleteByMeetingDetailID(String ids,TransactionManager tManager)throws Exception{
		logger.info("DAO	deleteByMeetingDetailID	begin");
		ComparisonTO comparisonTO=new ComparisonTO(ComparisonTO.DEL_BYMEETINGID_COMPARISON,ids);

		comparisonTO.setSqlStr();
		logger.info("sqlStr	:	"+comparisonTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(comparisonTO, true);
		}else{
			TransactionTemplate.executeTransaction(comparisonTO, tManager);
		}
		logger.info("result	:	"+comparisonTO.getexecuteResult());
		logger.info("DAO	deleteByMeetingDetailID	end");
		return comparisonTO.getexecuteResult();
	}
}

