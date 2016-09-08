package com.zzst.dao.meeting.comparison;


import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.comparison.ComparisonDetailVO;

/**
 * class description:	ComparisonDetail DAO
 * @date Sun Apr 28 13:09:54 CST 2013
 * @author ryan
 */
public class ComparisonDetailDAO {
	private static Logger logger = CjfLogger.getLogger(ComparisonDetailDAO.class.getName());

	private static 	final	String	id="ID";

	/**
	 * add ComparisonDetailVO	object
	 * @param ComparisonDetailVO
	 * @param TransactionManager
	 * @return ComparisonDetailVO
	 * @throws Exception
	 */
	public static ComparisonDetailVO add(ComparisonDetailVO comparisonDetailVO,TransactionManager tManager)throws Exception{
		logger.info("DAO	add	begin");
		comparisonDetailVO.setID(UtilDAO.getUUid());
		ComparisonDetailTO comparisonDetailTO=new ComparisonDetailTO(ComparisonDetailTO.ADD_COMPARISONDETAIL,comparisonDetailVO);

		comparisonDetailTO.setSqlStr();
		logger.info("sqlStr	:	"+comparisonDetailTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(comparisonDetailTO, true);
		}else{
			TransactionTemplate.executeTransaction(comparisonDetailTO, tManager);
		}
		logger.info("DAO	add	end");
		return comparisonDetailVO;
	}



	/**
	 * query ComparisonDetailVO	list
	 * @param ComparisonDetailVO
	 * @param PageController
	 * @return ArrayList<ComparisonDetailVO> 
	 * @throws Exception
	 */
	public static ArrayList<ComparisonDetailVO> query(ComparisonDetailVO comparisonDetailVO,PageController pageController) throws Exception{
		logger.info("DAO	query	begin");
		ComparisonDetailMQB comparisonDetailMQB=new ComparisonDetailMQB(ComparisonDetailMQB.QUERY_FROM_COMPARISONDETAIL,comparisonDetailVO);

		if(pageController==null){
			pageController=new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	"+comparisonDetailMQB.getSql());
		QueryTemplate.executeQueryForList(comparisonDetailMQB, pageController);
		logger.info("list size	:	"+comparisonDetailMQB.getComparisonDetailList().size());
		logger.info("DAO	query	end");
		return comparisonDetailMQB.getComparisonDetailList();
	}

	/**
	 * query ComparisonDetailVO	list	by	IDs
	 * @param String
	 * @param PageController
	 * @return ArrayList<ComparisonDetailVO> 
	 * @throws Exception
	 */
	public static ArrayList<ComparisonDetailVO> queryByIDs(String ids,PageController pageController) throws Exception{
		logger.info("DAO	queryByIDs	begin");
		ComparisonDetailMQB comparisonDetailMQB=new ComparisonDetailMQB(ComparisonDetailMQB.QUERY_FROM_COMPARISONDETAIL_BY_IDS,ids);

		if(pageController==null){
			pageController=new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	"+comparisonDetailMQB.getSql());
		QueryTemplate.executeQueryForList(comparisonDetailMQB, pageController);
		logger.info("list size	:	"+comparisonDetailMQB.getComparisonDetailList().size());
		logger.info("DAO	queryByIDs	end");
		return comparisonDetailMQB.getComparisonDetailList();
	}

	/**
	 * modify ComparisonDetailVO column by ID
	 * @param ComparisonDetailVO
	 * @param TransactionManager
	 * @return ComparisonDetailVO
	 * @throws Exception
	 */
	public static ComparisonDetailVO modify(ComparisonDetailVO comparisonDetailVO,TransactionManager tManager)throws Exception{
		logger.info("DAO	modify	begin");
		ComparisonDetailTO comparisonDetailTO=new ComparisonDetailTO(ComparisonDetailTO.MODIFY_COMPARISONDETAIL,comparisonDetailVO);		
		comparisonDetailTO.setSqlStr();
		logger.info("sqlStr	:	"+comparisonDetailTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(comparisonDetailTO, true);
		}else{
			TransactionTemplate.executeTransaction(comparisonDetailTO, tManager);
		}
		logger.info("DAO	modify	end");
		return comparisonDetailVO;
	}



	/**
	 * delete	ComparisonDetailVO by ids
	 * @param String
	 * @param TransactionManager
	 * @return ComparisonDetailVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids,TransactionManager tManager)throws Exception{
		logger.info("DAO	deleteByID	begin");
		ComparisonDetailVO comparisonDetailVO = new ComparisonDetailVO();
		comparisonDetailVO.setID(ids);
		ComparisonDetailTO comparisonDetailTO=new ComparisonDetailTO(ComparisonDetailTO.DEL_COMPARISONDETAIL,comparisonDetailVO);

		comparisonDetailTO.setSqlStr();
		logger.info("sqlStr	:	"+comparisonDetailTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(comparisonDetailTO, true);
		}else{
			TransactionTemplate.executeTransaction(comparisonDetailTO, tManager);
		}
		logger.info("result	:	"+comparisonDetailTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return comparisonDetailTO.getexecuteResult();
	}
}

