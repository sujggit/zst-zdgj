



	    	            
         
        	
		
	        
        	
		
        

    
    		

    package com.zzst.dao.mobileInfo;
    
	import java.util.ArrayList;
	import com.cbf.db.PageController;
	import com.cbf.db.QueryTemplate;
	import com.cbf.db.TransactionManager;
	import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
	import com.gsiec.cjf.util.CjfSequenceUtil;
	import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.mobileInfo.MobileInfoVO;

import org.apache.log4j.Logger;

	/**
	 * class description:	MobileInfo DAO
	 * @date Mon Aug 01 09:37:00 CST 2016
	 * @author ryan
	 */
    public class MobileInfoDAO {
		private static Logger logger = CjfLogger.getLogger(MobileInfoDAO.class.getName());

		private static 	final	String	id="Id";
		
		/**
		 * add MobileInfoVO	object
		 * @param MobileInfoVO
		 * @param TransactionManager
		 * @return MobileInfoVO
		 * @throws Exception
		 */
		public static MobileInfoVO add(MobileInfoVO mobileInfoVO,TransactionManager tManager)throws Exception{
			logger.info("DAO	add	begin");
			mobileInfoVO.setId(UtilDAO.getUUid());
			MobileInfoTO mobileInfoTO=new MobileInfoTO(MobileInfoTO.ADD_MOBILEINFO,mobileInfoVO);
			
			mobileInfoTO.setSqlStr();
			logger.info("sqlStr	:	"+mobileInfoTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(mobileInfoTO, true);
			}else{
			   TransactionTemplate.executeTransaction(mobileInfoTO, tManager);
			}
			logger.info("DAO	add	end");
			return mobileInfoVO;
		}
	

	
		/**
		 * query MobileInfoVO	list
		 * @param MobileInfoVO
		 * @param PageController
		 * @return ArrayList<MobileInfoVO> 
		 * @throws Exception
		 */
		public static ArrayList<MobileInfoVO> query(MobileInfoVO mobileInfoVO,PageController pageController) throws Exception{
			logger.info("DAO	query	begin");
	 		MobileInfoMQB mobileInfoMQB=new MobileInfoMQB(MobileInfoMQB.QUERY_FROM_MOBILEINFO,mobileInfoVO);
			
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	"+mobileInfoMQB.getSql());
			QueryTemplate.executeQueryForList(mobileInfoMQB, pageController);
			logger.info("list size	:	"+mobileInfoMQB.getMobileInfoList().size());
			logger.info("DAO	query	end");
			return mobileInfoMQB.getMobileInfoList();
		}
		
		/**
		 * query MobileInfoVO	list	by	IDs
		 * @param String
		 * @param PageController
		 * @return ArrayList<MobileInfoVO> 
		 * @throws Exception
		 */
		public static ArrayList<MobileInfoVO> queryByIDs(String ids,PageController pageController) throws Exception{
			logger.info("DAO	queryByIDs	begin");
	 		MobileInfoMQB mobileInfoMQB=new MobileInfoMQB(MobileInfoMQB.QUERY_FROM_MOBILEINFO_BY_IDS,ids);
			
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	"+mobileInfoMQB.getSql());
			QueryTemplate.executeQueryForList(mobileInfoMQB, pageController);
			logger.info("list size	:	"+mobileInfoMQB.getMobileInfoList().size());
			logger.info("DAO	queryByIDs	end");
			return mobileInfoMQB.getMobileInfoList();
		}

		/**
		 * modify MobileInfoVO column by ID
		 * @param MobileInfoVO
		 * @param TransactionManager
		 * @return MobileInfoVO
		 * @throws Exception
		 */
		public static MobileInfoVO modify(MobileInfoVO mobileInfoVO,TransactionManager tManager)throws Exception{
			logger.info("DAO	modify	begin");
			MobileInfoTO mobileInfoTO=new MobileInfoTO(MobileInfoTO.MODIFY_MOBILEINFO,mobileInfoVO);		
			mobileInfoTO.setSqlStr();
			logger.info("sqlStr	:	"+mobileInfoTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(mobileInfoTO, true);
			}else{
			   TransactionTemplate.executeTransaction(mobileInfoTO, tManager);
			}
			logger.info("DAO	modify	end");
			return mobileInfoVO;
		}
		
		
		
		/**
		 * delete	MobileInfoVO by id
		 * @param String
		 * @param TransactionManager
		 * @return MobileInfoVO
		 * @throws Exception
		 */
		public static int deleteByID(String id,TransactionManager tManager)throws Exception{
			logger.info("DAO	deleteByID	begin");
			MobileInfoVO mobileInfoVO = new MobileInfoVO();
			mobileInfoVO.setId(id);
			MobileInfoTO mobileInfoTO=new MobileInfoTO(MobileInfoTO.DEL_MOBILEINFO,mobileInfoVO);
			
			mobileInfoTO.setSqlStr();
			logger.info("sqlStr	:	"+mobileInfoTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(mobileInfoTO, true);
			}else{
			   TransactionTemplate.executeTransaction(mobileInfoTO, tManager);
			}
			logger.info("result	:	"+mobileInfoTO.getexecuteResult());
			logger.info("DAO	deleteByID	end");
			return mobileInfoTO.getexecuteResult();
		}
    }

    