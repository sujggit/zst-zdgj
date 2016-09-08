package com.zzst.dao.meeting.information;
  
	import java.util.ArrayList;
	import com.cbf.db.PageController;
	import com.cbf.db.QueryTemplate;
	import com.cbf.db.TransactionManager;
	import com.cbf.db.TransactionTemplate;
import com.cbf.log.CbfLogger;
	import com.gsiec.cjf.util.CjfSequenceUtil;
	import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.information.InformationVO;

import org.apache.log4j.Logger;

	/**
	 * class description:	Information DAO
	 * @date Tue Jan 29 18:25:43 CST 2013
	 * @author ryan
	 */
    public class InformationDAO {
		private static Logger logger = CbfLogger.getLogger(InformationDAO.class.getName());

		private static 	final	String	id="InfoID";
		
		/**
		 * add InformationVO	object
		 * @param InformationVO
		 * @param TransactionManager
		 * @return InformationVO
		 * @throws Exception
		 */
		public static InformationVO add(InformationVO informationVO,TransactionManager tManager)throws Exception{
			logger.info("DAO	add	begin");
			informationVO.setInfoID(UtilDAO.getUUid());
			InformationTO informationTO=new InformationTO(InformationTO.ADD_INFORMATION,informationVO);
			
			informationTO.setSqlStr();
			logger.info("sqlStr	:	"+informationTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(informationTO, true);
			}else{
			   TransactionTemplate.executeTransaction(informationTO, tManager);
			}
			logger.info("DAO	add	end");
			return informationVO;
		}
	

	
		/**
		 * query InformationVO	list
		 * @param InformationVO
		 * @param PageController
		 * @return ArrayList<InformationVO> 
		 * @throws Exception
		 */
		public static ArrayList<InformationVO> query(InformationVO informationVO,PageController pageController) throws Exception{
			logger.info("DAO	query	begin");
	 		InformationMQB informationMQB=new InformationMQB(InformationMQB.QUERY_FROM_INFORMATION,informationVO);
			
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	"+informationMQB.getSql());
			QueryTemplate.executeQueryForList(informationMQB, pageController);
			logger.info("list size	:	"+informationMQB.getInformationList().size());
			logger.info("DAO	query	end");
			return informationMQB.getInformationList();
		}
		
		/**
		 * query InformationVO	list
		 * @param InformationVO
		 * @param PageController
		 * @return ArrayList<InformationVO> 
		 * @throws Exception
		 */
		public static ArrayList<InformationVO> queryNew(InformationVO informationVO,PageController pageController) throws Exception{
			logger.info("DAO	query	begin");
	 		InformationMQB informationMQB=new InformationMQB(InformationMQB.QUERY_FROM_INFORMATION_OPER,informationVO);
			
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	"+informationMQB.getSql());
			QueryTemplate.executeQueryForList(informationMQB, pageController);
			logger.info("list size	:	"+informationMQB.getInformationList().size());
			logger.info("DAO	query	end");
			return informationMQB.getInformationList();
		}
		
		/**
		 * query InformationVO	list	by	IDs
		 * @param String
		 * @param PageController
		 * @return ArrayList<InformationVO> 
		 * @throws Exception
		 */
		public static ArrayList<InformationVO> queryByIDs(String ids,PageController pageController) throws Exception{
			logger.info("DAO	queryByIDs	begin");
	 		InformationMQB informationMQB=new InformationMQB(InformationMQB.QUERY_FROM_INFORMATION_BY_IDS,ids);
			
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	"+informationMQB.getSql());
			QueryTemplate.executeQueryForList(informationMQB, pageController);
			logger.info("list size	:	"+informationMQB.getInformationList().size());
			logger.info("DAO	queryByIDs	end");
			return informationMQB.getInformationList();
		}

		/**
		 * modify InformationVO column by ID
		 * @param InformationVO
		 * @param TransactionManager
		 * @return InformationVO
		 * @throws Exception
		 */
		public static InformationVO modify(InformationVO informationVO,TransactionManager tManager)throws Exception{
			logger.info("DAO	modify	begin");
			InformationTO informationTO=new InformationTO(InformationTO.MODIFY_INFORMATION,informationVO);		
			informationTO.setSqlStr();
			logger.info("sqlStr	:	"+informationTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(informationTO, true);
			}else{
			   TransactionTemplate.executeTransaction(informationTO, tManager);
			}
			logger.info("DAO	modify	end");
			return informationVO;
		}
		
		
		
		/**
		 * delete	InformationVO by ids
		 * @param String
		 * @param TransactionManager
		 * @return InformationVO
		 * @throws Exception
		 */
		public static int deleteByID(String ids,TransactionManager tManager)throws Exception{
			logger.info("DAO	deleteByID	begin");		
			InformationTO informationTO=new InformationTO(InformationTO.DEL_INFORMATION,ids);
			
			informationTO.setSqlStr();
			logger.info("sqlStr	:	"+informationTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(informationTO, true);
			}else{
			   TransactionTemplate.executeTransaction(informationTO, tManager);
			}
			logger.info("result	:	"+informationTO.getexecuteResult());
			logger.info("DAO	deleteByID	end");
			return informationTO.getexecuteResult();
		}
    }

    