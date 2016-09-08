
package com.zzst.dao.meeting.templateMeeting;
    
    import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.templateMeeting.TemplateMeetingVO;

	/**
	 * class description:	TemplateMeeting DAO
	 * @date Wed Mar 20 17:56:26 CST 2013
	 * @author ryan
	 */
    public class TemplateMeetingDAO {
		private static Logger logger = CjfLogger.getLogger(TemplateMeetingDAO.class.getName());

		private static 	final	String	id="Id";
		
		/**
		 * add TemplateMeetingVO	object
		 * @param TemplateMeetingVO
		 * @param TransactionManager
		 * @return TemplateMeetingVO
		 * @throws Exception
		 */
		public static TemplateMeetingVO add(TemplateMeetingVO templateMeetingVO,TransactionManager tManager)throws Exception{
			logger.info("DAO	add	begin");
			templateMeetingVO.setId(UtilDAO.getUUid());
			TemplateMeetingTO templateMeetingTO=new TemplateMeetingTO(TemplateMeetingTO.ADD_TEMPLATEMEETING,templateMeetingVO);
			
			templateMeetingTO.setSqlStr();
			logger.info("sqlStr	:	"+templateMeetingTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(templateMeetingTO, true);
			}else{
			   TransactionTemplate.executeTransaction(templateMeetingTO, tManager);
			}
			logger.info("DAO	add	end");
			return templateMeetingVO;
		}
	

	
		/**
		 * query TemplateMeetingVO	list
		 * @param TemplateMeetingVO
		 * @param PageController
		 * @return ArrayList<TemplateMeetingVO> 
		 * @throws Exception
		 */
		public static ArrayList<TemplateMeetingVO> query(TemplateMeetingVO templateMeetingVO,PageController pageController) throws Exception{
			logger.info("DAO	query	begin");
	 		TemplateMeetingMQB templateMeetingMQB=new TemplateMeetingMQB(TemplateMeetingMQB.QUERY_FROM_TEMPLATEMEETING,templateMeetingVO);
			
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	"+templateMeetingMQB.getSql());
			QueryTemplate.executeQueryForList(templateMeetingMQB, pageController);
			logger.info("list size	:	"+templateMeetingMQB.getTemplateMeetingList().size());
			logger.info("DAO	query	end");
			return templateMeetingMQB.getTemplateMeetingList();
		}
		
		/**
		 * query TemplateMeetingVO	list	by	IDs
		 * @param String
		 * @param PageController
		 * @return ArrayList<TemplateMeetingVO> 
		 * @throws Exception
		 */
		public static ArrayList<TemplateMeetingVO> queryByIDs(String ids,PageController pageController) throws Exception{
			logger.info("DAO	queryByIDs	begin");
	 		TemplateMeetingMQB templateMeetingMQB=new TemplateMeetingMQB(TemplateMeetingMQB.QUERY_FROM_TEMPLATEMEETING_BY_IDS,ids);
			
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	"+templateMeetingMQB.getSql());
			QueryTemplate.executeQueryForList(templateMeetingMQB, pageController);
			logger.info("list size	:	"+templateMeetingMQB.getTemplateMeetingList().size());
			logger.info("DAO	queryByIDs	end");
			return templateMeetingMQB.getTemplateMeetingList();
		}

		/**
		 * modify TemplateMeetingVO column by ID
		 * @param TemplateMeetingVO
		 * @param TransactionManager
		 * @return TemplateMeetingVO
		 * @throws Exception
		 */
		public static TemplateMeetingVO modify(TemplateMeetingVO templateMeetingVO,TransactionManager tManager)throws Exception{
			logger.info("DAO	modify	begin");
			TemplateMeetingTO templateMeetingTO=new TemplateMeetingTO(TemplateMeetingTO.MODIFY_TEMPLATEMEETING,templateMeetingVO);		
			templateMeetingTO.setSqlStr();
			logger.info("sqlStr	:	"+templateMeetingTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(templateMeetingTO, true);
			}else{
			   TransactionTemplate.executeTransaction(templateMeetingTO, tManager);
			}
			logger.info("DAO	modify	end");
			return templateMeetingVO;
		}
		
		
		
		/**
		 * delete	TemplateMeetingVO by ids
		 * @param String
		 * @param TransactionManager
		 * @return TemplateMeetingVO
		 * @throws Exception
		 */
		public static int deleteByID(String ids,TransactionManager tManager)throws Exception{
			logger.info("DAO	deleteByID	begin");
			TemplateMeetingVO templateMeetingVO = new TemplateMeetingVO();
			templateMeetingVO.setId(ids);
			TemplateMeetingTO templateMeetingTO=new TemplateMeetingTO(TemplateMeetingTO.DEL_TEMPLATEMEETING,templateMeetingVO);
			
			templateMeetingTO.setSqlStr();
			logger.info("sqlStr	:	"+templateMeetingTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(templateMeetingTO, true);
			}else{
			   TransactionTemplate.executeTransaction(templateMeetingTO, tManager);
			}
			logger.info("result	:	"+templateMeetingTO.getexecuteResult());
			logger.info("DAO	deleteByID	end");
			return templateMeetingTO.getexecuteResult();
		}
		
		
		/**
		 * delete	TemplateMeetingVO by templateId
		 * @param String
		 * @param TransactionManager
		 * @return TemplateMeetingVO
		 * @throws Exception
		 */
		public static int deleteByTemplateId(String templateId,TransactionManager tManager)throws Exception{
			logger.info("DAO	deleteByTemplateId	begin");
			TemplateMeetingVO templateMeetingVO = new TemplateMeetingVO();
			TemplateMeetingTO templateMeetingTO=new TemplateMeetingTO(TemplateMeetingTO.DEL_TEMPLATEMEETING_BYTEMPLATEID,templateId);
			
			templateMeetingTO.setSqlStr();
			logger.info("sqlStr	:	"+templateMeetingTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(templateMeetingTO, true);
			}else{
			   TransactionTemplate.executeTransaction(templateMeetingTO, tManager);
			}
			logger.info("result	:	"+templateMeetingTO.getexecuteResult());
			logger.info("DAO	deleteByTemplateId	end");
			return templateMeetingTO.getexecuteResult();
		}
    }

    