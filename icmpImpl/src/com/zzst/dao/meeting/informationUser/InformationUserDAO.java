package com.zzst.dao.meeting.informationUser;

	import java.util.ArrayList;
	import com.cbf.db.PageController;
	import com.cbf.db.QueryTemplate;
	import com.cbf.db.TransactionManager;
	import com.cbf.db.TransactionTemplate;
import com.cbf.log.CbfLogger;
	import com.gsiec.cjf.util.CjfSequenceUtil;
	import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.informationUser.InformationUserVO;

import org.apache.log4j.Logger;

	/**
	 * class description:	InformationUser DAO
	 * @date Tue Jan 29 18:25:43 CST 2013
	 * @author ryan
	 */
    public class InformationUserDAO {
		private static Logger logger = CbfLogger.getLogger(InformationUserDAO.class.getName());

		private static 	final	String	id="InfoID";
		
		/**
		 * add InformationUserVO	object
		 * @param InformationUserVO
		 * @param TransactionManager
		 * @return InformationUserVO
		 * @throws Exception
		 */
		public static InformationUserVO add(InformationUserVO informationUserVO,TransactionManager tManager)throws Exception{
			logger.info("DAO	add	begin");
			informationUserVO.setInfoID(UtilDAO.getUUid());
			InformationUserTO informationUserTO=new InformationUserTO(InformationUserTO.ADD_INFORMATIONUSER,informationUserVO);
			
			informationUserTO.setSqlStr();
			logger.info("sqlStr	:	"+informationUserTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(informationUserTO, true);
			}else{
			   TransactionTemplate.executeTransaction(informationUserTO, tManager);
			}
			logger.info("DAO	add	end");
			return informationUserVO;
		}
	

	
		/**
		 * query InformationUserVO	list
		 * @param InformationUserVO
		 * @param PageController
		 * @return ArrayList<InformationUserVO> 
		 * @throws Exception
		 */
		public static ArrayList<InformationUserVO> query(InformationUserVO informationUserVO,PageController pageController) throws Exception{
			logger.info("DAO	query	begin");
	 		InformationUserMQB informationUserMQB=new InformationUserMQB(InformationUserMQB.QUERY_FROM_INFORMATIONUSER,informationUserVO);
			
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	"+informationUserMQB.getSql());
			QueryTemplate.executeQueryForList(informationUserMQB, pageController);
			logger.info("list size	:	"+informationUserMQB.getInformationUserList().size());
			logger.info("DAO	query	end");
			return informationUserMQB.getInformationUserList();
		}
		
		/**
		 * query InformationUserVO	list	by	IDs
		 * @param String
		 * @param PageController
		 * @return ArrayList<InformationUserVO> 
		 * @throws Exception
		 */
		public static ArrayList<InformationUserVO> queryByIDs(String ids,PageController pageController) throws Exception{
			logger.info("DAO	queryByIDs	begin");
	 		InformationUserMQB informationUserMQB=new InformationUserMQB(InformationUserMQB.QUERY_FROM_INFORMATIONUSER_BY_IDS,ids);
			
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	"+informationUserMQB.getSql());
			QueryTemplate.executeQueryForList(informationUserMQB, pageController);
			logger.info("list size	:	"+informationUserMQB.getInformationUserList().size());
			logger.info("DAO	queryByIDs	end");
			return informationUserMQB.getInformationUserList();
		}

		/**
		 * modify InformationUserVO column by ID
		 * @param InformationUserVO
		 * @param TransactionManager
		 * @return InformationUserVO
		 * @throws Exception
		 */
		public static InformationUserVO modify(InformationUserVO informationUserVO,TransactionManager tManager)throws Exception{
			logger.info("DAO	modify	begin");
			InformationUserTO informationUserTO=new InformationUserTO(InformationUserTO.MODIFY_INFORMATIONUSER,informationUserVO);		
			informationUserTO.setSqlStr();
			logger.info("sqlStr	:	"+informationUserTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(informationUserTO, true);
			}else{
			   TransactionTemplate.executeTransaction(informationUserTO, tManager);
			}
			logger.info("DAO	modify	end");
			return informationUserVO;
		}
		
		
		
		/**
		 * delete	InformationUserVO by ids
		 * @param String
		 * @param TransactionManager
		 * @return InformationUserVO
		 * @throws Exception
		 */
		public static int deleteByID(String ids,TransactionManager tManager)throws Exception{
			logger.info("DAO	deleteByID	begin");
			InformationUserVO informationUserVO = new InformationUserVO();
			informationUserVO.setInfoID(ids);
			InformationUserTO informationUserTO=new InformationUserTO(InformationUserTO.DEL_INFORMATIONUSER,informationUserVO);
			
			informationUserTO.setSqlStr();
			logger.info("sqlStr	:	"+informationUserTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(informationUserTO, true);
			}else{
			   TransactionTemplate.executeTransaction(informationUserTO, tManager);
			}
			logger.info("result	:	"+informationUserTO.getexecuteResult());
			logger.info("DAO	deleteByID	end");
			return informationUserTO.getexecuteResult();
		}
    }

    