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
import com.zzst.model.meeting.comparison.ComparisonReferenceVO;

import org.apache.log4j.Logger;

	/**
	 * class description:	ComparisonReference DAO
	 * @date Sat Apr 27 11:12:39 CST 2013
	 * @author ryan
	 */
    public class ComparisonReferenceDAO {
		private static Logger logger = CjfLogger.getLogger(ComparisonReferenceDAO.class.getName());

		private static 	final	String	id="ID";
		
		/**
		 * add ComparisonReferenceVO	object
		 * @param ComparisonReferenceVO
		 * @param TransactionManager
		 * @return ComparisonReferenceVO
		 * @throws Exception
		 */
		public static ComparisonReferenceVO add(ComparisonReferenceVO comparisonReferenceVO,TransactionManager tManager)throws Exception{
			logger.info("DAO	add	begin");
			comparisonReferenceVO.setID(UtilDAO.getUUid());
			ComparisonReferenceTO comparisonReferenceTO=new ComparisonReferenceTO(ComparisonReferenceTO.ADD_COMPARISONREFERENCE,comparisonReferenceVO);
			
			comparisonReferenceTO.setSqlStr();
			logger.info("sqlStr	:	"+comparisonReferenceTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(comparisonReferenceTO, true);
			}else{
			   TransactionTemplate.executeTransaction(comparisonReferenceTO, tManager);
			}
			logger.info("DAO	add	end");
			return comparisonReferenceVO;
		}
	

	
		/**
		 * query ComparisonReferenceVO	list
		 * @param ComparisonReferenceVO
		 * @param PageController
		 * @return ArrayList<ComparisonReferenceVO> 
		 * @throws Exception
		 */
		public static ArrayList<ComparisonReferenceVO> query(ComparisonReferenceVO comparisonReferenceVO,PageController pageController) throws Exception{
			logger.info("DAO	query	begin");
	 		ComparisonReferenceMQB comparisonReferenceMQB=new ComparisonReferenceMQB(ComparisonReferenceMQB.QUERY_FROM_COMPARISONREFERENCE,comparisonReferenceVO);
			
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	"+comparisonReferenceMQB.getSql());
			QueryTemplate.executeQueryForList(comparisonReferenceMQB, pageController);
			logger.info("list size	:	"+comparisonReferenceMQB.getComparisonReferenceList().size());
			logger.info("DAO	query	end");
			return comparisonReferenceMQB.getComparisonReferenceList();
		}
		
		/**
		 * query ComparisonReferenceVO	list	by	IDs
		 * @param String
		 * @param PageController
		 * @return ArrayList<ComparisonReferenceVO> 
		 * @throws Exception
		 */
		public static ArrayList<ComparisonReferenceVO> queryByIDs(String ids,PageController pageController) throws Exception{
			logger.info("DAO	queryByIDs	begin");
	 		ComparisonReferenceMQB comparisonReferenceMQB=new ComparisonReferenceMQB(ComparisonReferenceMQB.QUERY_FROM_COMPARISONREFERENCE_BY_IDS,ids);
			
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	"+comparisonReferenceMQB.getSql());
			QueryTemplate.executeQueryForList(comparisonReferenceMQB, pageController);
			logger.info("list size	:	"+comparisonReferenceMQB.getComparisonReferenceList().size());
			logger.info("DAO	queryByIDs	end");
			return comparisonReferenceMQB.getComparisonReferenceList();
		}

		/**
		 * modify ComparisonReferenceVO column by ID
		 * @param ComparisonReferenceVO
		 * @param TransactionManager
		 * @return ComparisonReferenceVO
		 * @throws Exception
		 */
		public static ComparisonReferenceVO modify(ComparisonReferenceVO comparisonReferenceVO,TransactionManager tManager)throws Exception{
			logger.info("DAO	modify	begin");
			ComparisonReferenceTO comparisonReferenceTO=new ComparisonReferenceTO(ComparisonReferenceTO.MODIFY_COMPARISONREFERENCE,comparisonReferenceVO);		
			comparisonReferenceTO.setSqlStr();
			logger.info("sqlStr	:	"+comparisonReferenceTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(comparisonReferenceTO, true);
			}else{
			   TransactionTemplate.executeTransaction(comparisonReferenceTO, tManager);
			}
			logger.info("DAO	modify	end");
			return comparisonReferenceVO;
		}
		
		
		
		/**
		 * delete	ComparisonReferenceVO by ids
		 * @param String
		 * @param TransactionManager
		 * @return ComparisonReferenceVO
		 * @throws Exception
		 */
		public static int deleteByID(String ids,TransactionManager tManager)throws Exception{
			logger.info("DAO	deleteByID	begin");
			ComparisonReferenceVO comparisonReferenceVO = new ComparisonReferenceVO();
			comparisonReferenceVO.setID(ids);
			ComparisonReferenceTO comparisonReferenceTO=new ComparisonReferenceTO(ComparisonReferenceTO.DEL_COMPARISONREFERENCE,comparisonReferenceVO);
			
			comparisonReferenceTO.setSqlStr();
			logger.info("sqlStr	:	"+comparisonReferenceTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(comparisonReferenceTO, true);
			}else{
			   TransactionTemplate.executeTransaction(comparisonReferenceTO, tManager);
			}
			logger.info("result	:	"+comparisonReferenceTO.getexecuteResult());
			logger.info("DAO	deleteByID	end");
			return comparisonReferenceTO.getexecuteResult();
		}
    }

    