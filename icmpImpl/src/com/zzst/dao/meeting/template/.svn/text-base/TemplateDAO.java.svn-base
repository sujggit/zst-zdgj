package com.zzst.dao.meeting.template;   
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.template.TemplateVO;

	/**
	 * class description:	Template DAO
	 * @date Wed Mar 20 17:56:26 CST 2013
	 * @author ryan
	 */
    public class TemplateDAO {
		private static Logger logger = CjfLogger.getLogger(TemplateDAO.class.getName());

		private static 	final	String	id="Id";
		
		/**
		 * add TemplateVO	object
		 * @param TemplateVO
		 * @param TransactionManager
		 * @return TemplateVO
		 * @throws Exception
		 */
		public static TemplateVO add(TemplateVO templateVO,TransactionManager tManager)throws Exception{
			logger.info("DAO	add	begin");
			templateVO.setId(UtilDAO.getUUid());
			TemplateTO templateTO=new TemplateTO(TemplateTO.ADD_TEMPLATE,templateVO);
			
			templateTO.setSqlStr();
			logger.info("sqlStr	:	"+templateTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(templateTO, true);
			}else{
			   TransactionTemplate.executeTransaction(templateTO, tManager);
			}
			logger.info("DAO	add	end");
			return templateVO;
		}
	

	
		/**
		 * query TemplateVO	list
		 * @param TemplateVO
		 * @param PageController
		 * @return ArrayList<TemplateVO> 
		 * @throws Exception
		 */
		public static ArrayList<TemplateVO> query(TemplateVO templateVO,PageController pageController) throws Exception{
			logger.info("DAO	query	begin");
			 //////////////////////会议室分级分权@author:zhangjy/////////////////////////
			if(templateVO.isLevel()){
				if(!(templateVO.equals(""))){
					templateVO.setLsql(" and id not in(SELECT ztm.templateId FROM z_t_template_meeting AS ztm left JOIN z_t_equipment AS zte ON zte.equipmentID = ztm.mcuEquipmentId where zte.roomID not in("+templateVO.getLsql()+"))");
				}else{
					templateVO.setLevel(false);
				}
			}
			//////////////////////////////end//////////////////////////////////////////
	 		TemplateMQB templateMQB=new TemplateMQB(TemplateMQB.QUERY_FROM_TEMPLATE,templateVO);
			
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	"+templateMQB.getSql());
			QueryTemplate.executeQueryForList(templateMQB, pageController);
			logger.info("list size	:	"+templateMQB.getTemplateList().size());
			logger.info("DAO	query	end");
			return templateMQB.getTemplateList();
		}
		
		/**
		 * query TemplateVO	list	by	IDs
		 * @param String
		 * @param PageController
		 * @return ArrayList<TemplateVO> 
		 * @throws Exception
		 */
		public static ArrayList<TemplateVO> queryByIDs(String ids,PageController pageController) throws Exception{
			logger.info("DAO	queryByIDs	begin");
	 		TemplateMQB templateMQB=new TemplateMQB(TemplateMQB.QUERY_FROM_TEMPLATE_BY_IDS,ids);
			
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	"+templateMQB.getSql());
			QueryTemplate.executeQueryForList(templateMQB, pageController);
			logger.info("list size	:	"+templateMQB.getTemplateList().size());
			logger.info("DAO	queryByIDs	end");
			return templateMQB.getTemplateList();
		}

		/**
		 * modify TemplateVO column by ID
		 * @param TemplateVO
		 * @param TransactionManager
		 * @return TemplateVO
		 * @throws Exception
		 */
		public static TemplateVO modify(TemplateVO templateVO,TransactionManager tManager)throws Exception{
			logger.info("DAO	modify	begin");
			TemplateTO templateTO=new TemplateTO(TemplateTO.MODIFY_TEMPLATE,templateVO);		
			templateTO.setSqlStr();
			logger.info("sqlStr	:	"+templateTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(templateTO, true);
			}else{
			   TransactionTemplate.executeTransaction(templateTO, tManager);
			}
			logger.info("DAO	modify	end");
			return templateVO;
		}
		
		
		
		/**
		 * delete	TemplateVO by ids
		 * @param String
		 * @param TransactionManager
		 * @return TemplateVO
		 * @throws Exception
		 */
		public static int deleteByID(String ids,TransactionManager tManager)throws Exception{
			logger.info("DAO	deleteByID	begin");
			TemplateVO templateVO = new TemplateVO();
			templateVO.setId(ids);
			TemplateTO templateTO=new TemplateTO(TemplateTO.DEL_TEMPLATE,templateVO);
			
			templateTO.setSqlStr();
			logger.info("sqlStr	:	"+templateTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(templateTO, true);
			}else{
			   TransactionTemplate.executeTransaction(templateTO, tManager);
			}
			logger.info("result	:	"+templateTO.getexecuteResult());
			logger.info("DAO	deleteByID	end");
			return templateTO.getexecuteResult();
		}
    }

    