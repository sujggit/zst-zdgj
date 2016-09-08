package com.zzst.dao.meeting.comparison;


	import java.util.ArrayList;
	import com.cbf.db.PageController;
	import com.cbf.db.QueryTemplate;
	import com.cbf.db.TransactionManager;
	import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
	import com.gsiec.cjf.util.CjfSequenceUtil;
	import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.comparison.ComparisonCriteriaVO;

import org.apache.log4j.Logger;

	/**
	 * class description:	ComparisonCriteria DAO
	 * @date Fri Apr 26 16:04:41 CST 2013
	 * @author ryan
	 */
    public class ComparisonCriteriaDAO {
		private static Logger logger = CjfLogger.getLogger(ComparisonCriteriaDAO.class.getName());

		private static 	final	String	id="ComCriteriaID";
		
		/**
		 * add ComparisonCriteriaVO	object
		 * @param ComparisonCriteriaVO
		 * @param TransactionManager
		 * @return ComparisonCriteriaVO
		 * @throws Exception
		 */
		public static ComparisonCriteriaVO add(ComparisonCriteriaVO comparisonCriteriaVO,TransactionManager tManager)throws Exception{
			logger.info("DAO	add	begin");
			comparisonCriteriaVO.setComCriteriaID(UtilDAO.getUUid());
			ComparisonCriteriaTO comparisonCriteriaTO=new ComparisonCriteriaTO(ComparisonCriteriaTO.ADD_COMPARISONCRITERIA,comparisonCriteriaVO);
			
			comparisonCriteriaTO.setSqlStr();
			logger.info("sqlStr	:	"+comparisonCriteriaTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(comparisonCriteriaTO, true);
			}else{
			   TransactionTemplate.executeTransaction(comparisonCriteriaTO, tManager);
			}
			logger.info("DAO	add	end");
			return comparisonCriteriaVO;
		}
	

	
		/**
		 * query ComparisonCriteriaVO	list
		 * @param ComparisonCriteriaVO
		 * @param PageController
		 * @return ArrayList<ComparisonCriteriaVO> 
		 * @throws Exception
		 */
		public static ArrayList<ComparisonCriteriaVO> query(ComparisonCriteriaVO comparisonCriteriaVO,PageController pageController) throws Exception{
			logger.info("DAO	query	begin");
	 		ComparisonCriteriaMQB comparisonCriteriaMQB=new ComparisonCriteriaMQB(ComparisonCriteriaMQB.QUERY_FROM_COMPARISONCRITERIA,comparisonCriteriaVO);
			
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	"+comparisonCriteriaMQB.getSql());
			QueryTemplate.executeQueryForList(comparisonCriteriaMQB, pageController);
			logger.info("list size	:	"+comparisonCriteriaMQB.getComparisonCriteriaList().size());
			logger.info("DAO	query	end");
			return comparisonCriteriaMQB.getComparisonCriteriaList();
		}
		
		/**
		 * query ComparisonCriteriaVO	list	by	IDs
		 * @param String
		 * @param PageController
		 * @return ArrayList<ComparisonCriteriaVO> 
		 * @throws Exception
		 */
		public static ArrayList<ComparisonCriteriaVO> queryByIDs(String ids,PageController pageController) throws Exception{
			logger.info("DAO	queryByIDs	begin");
	 		ComparisonCriteriaMQB comparisonCriteriaMQB=new ComparisonCriteriaMQB(ComparisonCriteriaMQB.QUERY_FROM_COMPARISONCRITERIA_BY_IDS,ids);
			
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	"+comparisonCriteriaMQB.getSql());
			QueryTemplate.executeQueryForList(comparisonCriteriaMQB, pageController);
			logger.info("list size	:	"+comparisonCriteriaMQB.getComparisonCriteriaList().size());
			logger.info("DAO	queryByIDs	end");
			return comparisonCriteriaMQB.getComparisonCriteriaList();
		}

		/**
		 * modify ComparisonCriteriaVO column by ID
		 * @param ComparisonCriteriaVO
		 * @param TransactionManager
		 * @return ComparisonCriteriaVO
		 * @throws Exception
		 */
		public static ComparisonCriteriaVO modify(ComparisonCriteriaVO comparisonCriteriaVO,TransactionManager tManager)throws Exception{
			logger.info("DAO	modify	begin");
			ComparisonCriteriaTO comparisonCriteriaTO=new ComparisonCriteriaTO(ComparisonCriteriaTO.MODIFY_COMPARISONCRITERIA,comparisonCriteriaVO);		
			comparisonCriteriaTO.setSqlStr();
			logger.info("sqlStr	:	"+comparisonCriteriaTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(comparisonCriteriaTO, true);
			}else{
			   TransactionTemplate.executeTransaction(comparisonCriteriaTO, tManager);
			}
			logger.info("DAO	modify	end");
			return comparisonCriteriaVO;
		}
		
		
		
		/**
		 * delete	ComparisonCriteriaVO by ids
		 * @param String
		 * @param TransactionManager
		 * @return ComparisonCriteriaVO
		 * @throws Exception
		 */
		public static int deleteByID(String ids,TransactionManager tManager)throws Exception{
			logger.info("DAO	deleteByID	begin");
			ComparisonCriteriaVO comparisonCriteriaVO = new ComparisonCriteriaVO();
			comparisonCriteriaVO.setComCriteriaID(ids);
			ComparisonCriteriaTO comparisonCriteriaTO=new ComparisonCriteriaTO(ComparisonCriteriaTO.DEL_COMPARISONCRITERIA,comparisonCriteriaVO);
			
			comparisonCriteriaTO.setSqlStr();
			logger.info("sqlStr	:	"+comparisonCriteriaTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(comparisonCriteriaTO, true);
			}else{
			   TransactionTemplate.executeTransaction(comparisonCriteriaTO, tManager);
			}
			logger.info("result	:	"+comparisonCriteriaTO.getexecuteResult());
			logger.info("DAO	deleteByID	end");
			return comparisonCriteriaTO.getexecuteResult();
		}
    }

    