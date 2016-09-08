package com.zzst.dao.project.avic.applyConference;
    
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.model.enums.ApplyEnum;
import com.zzst.model.project.avic.applyConference.ApplyConferenceVO;

	/**
	 * class description:	ApplyConference DAO
	 * @date Wed Sep 19 16:15:16 CST 2012
	 * @author ryan
	 */
    public class ApplyConferenceDAO {
		private static Logger logger = CjfLogger.getLogger(ApplyConferenceDAO.class.getName());

//		private static 	final	String	id="ApplyID";
		
		/**
		 * add ApplyConferenceVO	object
		 * @param ApplyConferenceVO
		 * @param TransactionManager
		 * @return ApplyConferenceVO
		 * @throws Exception
		 */
		public static ApplyConferenceVO add(ApplyConferenceVO applyConferenceVO,TransactionManager tManager)throws Exception{
			logger.info("DAO	add	begin");
//			applyConferenceVO.setApplyID(UtilDAO.getUUid());
			ApplyConferenceTO applyConferenceTO=new ApplyConferenceTO(ApplyConferenceTO.ADD_APPLYCONFERENCE,applyConferenceVO);
			
			applyConferenceTO.setSqlStr();
			logger.info("sqlStr	:	"+applyConferenceTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(applyConferenceTO, true);
			}else{
			   TransactionTemplate.executeTransaction(applyConferenceTO, tManager);
			}
			logger.info("DAO	add	end");
			return applyConferenceVO;
		}
	

	
		/**
		 * query ApplyConferenceVO	list
		 * @param ApplyConferenceVO
		 * @param PageController
		 * @return ArrayList<ApplyConferenceVO> 
		 * @throws Exception
		 */
		public static ArrayList<ApplyConferenceVO> query(ApplyConferenceVO applyConferenceVO,PageController pageController) throws Exception{
			logger.info("DAO	query	begin");
	 		ApplyConferenceMQB applyConferenceMQB=new ApplyConferenceMQB(ApplyConferenceMQB.QUERY_FROM_APPLYCONFERENCE,applyConferenceVO);
			
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	"+applyConferenceMQB.getSql());
			QueryTemplate.executeQueryForList(applyConferenceMQB, pageController);
			logger.info("list size	:	"+applyConferenceMQB.getApplyConferenceList().size());
			logger.info("DAO	query	end");
			return applyConferenceMQB.getApplyConferenceList();
		}
		
		/**
		 * query ApplyConferenceVO	list	by	IDs
		 * @param String
		 * @param PageController
		 * @return ArrayList<ApplyConferenceVO> 
		 * @throws Exception
		 */
		public static ArrayList<ApplyConferenceVO> queryByIDs(String ids,PageController pageController) throws Exception{
			logger.info("DAO	queryByIDs	begin");
	 		ApplyConferenceMQB applyConferenceMQB=new ApplyConferenceMQB(ApplyConferenceMQB.QUERY_FROM_APPLYCONFERENCE_BY_IDS,ids);
			
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	"+applyConferenceMQB.getSql());
			QueryTemplate.executeQueryForList(applyConferenceMQB, pageController);
			logger.info("list size	:	"+applyConferenceMQB.getApplyConferenceList().size());
			logger.info("DAO	queryByIDs	end");
			return applyConferenceMQB.getApplyConferenceList();
		}

		/**
		 * modify ApplyConferenceVO column by ID
		 * @param ApplyConferenceVO
		 * @param TransactionManager
		 * @return ApplyConferenceVO
		 * @throws Exception
		 */
		public static ApplyConferenceVO modify(ApplyConferenceVO applyConferenceVO,TransactionManager tManager)throws Exception{
			logger.info("DAO	modify	begin");
			ApplyConferenceTO applyConferenceTO=new ApplyConferenceTO(ApplyConferenceTO.MODIFY_APPLYCONFERENCE,applyConferenceVO);		
			applyConferenceTO.setSqlStr();
			logger.info("sqlStr	:	"+applyConferenceTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(applyConferenceTO, true);
			}else{
			   TransactionTemplate.executeTransaction(applyConferenceTO, tManager);
			}
			logger.info("DAO	modify	end");
			return applyConferenceVO;
		}
		
		
		
		/**
		 * delete	ApplyConferenceVO by ids
		 * @param String
		 * @param TransactionManager
		 * @return ApplyConferenceVO
		 * @throws Exception
		 */
		public static int deleteByID(String ids,TransactionManager tManager)throws Exception{
			logger.info("DAO	deleteByID	begin");
			ApplyConferenceVO applyConferenceVO = new ApplyConferenceVO();
			applyConferenceVO.setApplyID(ids);
			ApplyConferenceTO applyConferenceTO=new ApplyConferenceTO(ApplyConferenceTO.DEL_APPLYCONFERENCE,applyConferenceVO);
			
			applyConferenceTO.setSqlStr();
			logger.info("sqlStr	:	"+applyConferenceTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(applyConferenceTO, true);
			}else{
			   TransactionTemplate.executeTransaction(applyConferenceTO, tManager);
			}
			logger.info("result	:	"+applyConferenceTO.getexecuteResult());
			logger.info("DAO	deleteByID	end");
			return applyConferenceTO.getexecuteResult();
		}
		
		
		public static ArrayList<ApplyConferenceVO> queryNoServiceConference(PageController pageController) throws Exception{
			logger.info("DAO	queryNoServiceConference	begin");
			ApplyConferenceMQB applyConferenceMQB=new ApplyConferenceMQB(ApplyConferenceMQB.QUERY_NOSERVICECONFERENCE);
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT c.* FROM avic_t_vc_apply_info c WHERE c.status IN ("+ApplyEnum.STATUS_INVALID+","+ApplyEnum.STATUS_NONE+") AND c.applyID NOT IN (SELECT s.meetingDetailID FROM avic_t_service s WHERE s.status not in("+ApplyEnum.STATUS_REJECT+","+ApplyEnum.STATUS_REVOKE+")"+") ORDER BY c.startTime DESC; ");
			applyConferenceMQB.setSql(sql.toString());
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	"+sql.toString());
			QueryTemplate.executeQueryForList(applyConferenceMQB, pageController);
			logger.info("list size	:	"+applyConferenceMQB.getApplyConferenceList().size());
			logger.info("DAO	queryNoServiceConference	end");
			return applyConferenceMQB.getApplyConferenceList();
		}
		
		/**
		 * query queryApplyConferences	list	by	userId
		 * @param String
		 * @param PageController
		 * @return ArrayList<ApplyDetailVO> 
		 * @throws Exception
		 */
		public static ArrayList<ApplyConferenceVO> queryApplyConferences(ApplyConferenceVO applyConferenceVO,String ids,
				PageController pageController) throws Exception {
			logger.info("DAO queryApplyConferences	begin");
			ApplyConferenceMQB applyConferenceMQB = new ApplyConferenceMQB(
					ApplyConferenceMQB.QUERY_FROM_BY_USERID,applyConferenceVO, ids);

			if (pageController == null) {
				pageController = new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	" + applyConferenceMQB.getSql());
			QueryTemplate.executeQueryForList(applyConferenceMQB, pageController);
			logger.info("list size	:	"
							+ applyConferenceMQB.getApplyConferenceList().size());
			logger.info("DAO	queryApplyConferences	end");
			return applyConferenceMQB.getApplyConferenceList();
		}
		
		public static ArrayList<ApplyConferenceVO> queryApplyConferencesHistory(ApplyConferenceVO applyConferenceVO,String ids,
				PageController pageController) throws Exception {
			logger.info("DAO queryApplyConferences	begin");
			ApplyConferenceMQB applyConferenceMQB = new ApplyConferenceMQB(
					ApplyConferenceMQB.QUERY_HISTORY,applyConferenceVO, ids);

			if (pageController == null) {
				pageController = new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	" + applyConferenceMQB.getSql());
			QueryTemplate.executeQueryForList(applyConferenceMQB, pageController);
			logger.info("list size	:	"
							+ applyConferenceMQB.getApplyConferenceList().size());
			logger.info("DAO	queryApplyConferences	end");
			return applyConferenceMQB.getApplyConferenceList();
		}

		public static ArrayList<ApplyConferenceVO> queryApplyConferencesHistory(ApplyConferenceVO applyConferenceVO,
				PageController pageController) throws Exception {
			logger.info("DAO queryApplyConferencesHistory	begin");
			ApplyConferenceMQB applyConferenceMQB = new ApplyConferenceMQB(
					ApplyConferenceMQB.QUERY_HISTORY_ALL,applyConferenceVO,null);

			if (pageController == null) {
				pageController = new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	" + applyConferenceMQB.getSql());
			QueryTemplate.executeQueryForList(applyConferenceMQB, pageController);
			logger.info("list size	:	"
							+ applyConferenceMQB.getApplyConferenceList().size());
			logger.info("DAO	queryApplyConferencesHistory	end");
			return applyConferenceMQB.getApplyConferenceList();
		}



		public static ArrayList<ApplyConferenceVO> queryBusyMeetingRoom(
				ApplyConferenceVO applyConferenceVO,
				PageController pageController) throws Exception{
			logger.info("DAO	queryBusyMeetingRoom	begin");
			ApplyConferenceMQB applyConferenceMQB = new ApplyConferenceMQB(
					ApplyConferenceMQB.QUERY_BUSY_MEETINGROOM,applyConferenceVO);
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	" + applyConferenceMQB.getSql());
			QueryTemplate.executeQueryForList(applyConferenceMQB, pageController);
			logger.info("list size	:	"
							+ applyConferenceMQB.getApplyConferenceList().size());
			logger.info("DAO	queryBusyMeetingRoom	end");
			return applyConferenceMQB.getApplyConferenceList();
		}
    
    }

    