package com.zzst.dao.meeting.templateEquipmentGroup;


import java.util.ArrayList;
import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.cbf.log.CbfLogger;
import com.gsiec.cjf.util.CjfSequenceUtil;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.templateEquipmentGroup.TemplateEquipmentGroupVO;

import org.apache.log4j.Logger;

/**
 * class description:	TemplateEquipmentGroup DAO
 * @date Wed Mar 20 18:48:48 CST 2013
 * @author ryan
 */
public class TemplateEquipmentGroupDAO {
	private static Logger logger = CbfLogger.getLogger(TemplateEquipmentGroupDAO.class.getName());

	private static 	final	String	id="ID";

	/**
	 * add TemplateEquipmentGroupVO	object
	 * @param TemplateEquipmentGroupVO
	 * @param TransactionManager
	 * @return TemplateEquipmentGroupVO
	 * @throws Exception
	 */
	public static TemplateEquipmentGroupVO add(TemplateEquipmentGroupVO templateEquipmentGroupVO,TransactionManager tManager)throws Exception{
		logger.info("DAO	add	begin");
		if(templateEquipmentGroupVO.getID()==null){
			templateEquipmentGroupVO.setID(UtilDAO.getUUid());
		}
		TemplateEquipmentGroupTO templateEquipmentGroupTO=new TemplateEquipmentGroupTO(TemplateEquipmentGroupTO.ADD_TEMPLATEEQUIPMENTGROUP,templateEquipmentGroupVO);

		templateEquipmentGroupTO.setSqlStr();
		logger.info("sqlStr	:	"+templateEquipmentGroupTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(templateEquipmentGroupTO, true);
		}else{
			TransactionTemplate.executeTransaction(templateEquipmentGroupTO, tManager);
		}
		logger.info("DAO	add	end");
		return templateEquipmentGroupVO;
	}



	/**
	 * query TemplateEquipmentGroupVO	list
	 * @param TemplateEquipmentGroupVO
	 * @param PageController
	 * @return ArrayList<TemplateEquipmentGroupVO> 
	 * @throws Exception
	 */
	public static ArrayList<TemplateEquipmentGroupVO> query(TemplateEquipmentGroupVO templateEquipmentGroupVO,PageController pageController) throws Exception{
		logger.info("DAO	query	begin");
		TemplateEquipmentGroupMQB templateEquipmentGroupMQB=new TemplateEquipmentGroupMQB(TemplateEquipmentGroupMQB.QUERY_FROM_TEMPLATEEQUIPMENTGROUP,templateEquipmentGroupVO);

		if(pageController==null){
			pageController=new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	"+templateEquipmentGroupMQB.getSql());
		QueryTemplate.executeQueryForList(templateEquipmentGroupMQB, pageController);
		logger.info("list size	:	"+templateEquipmentGroupMQB.getTemplateEquipmentGroupList().size());
		logger.info("DAO	query	end");
		return templateEquipmentGroupMQB.getTemplateEquipmentGroupList();
	}

	/**
	 * query TemplateEquipmentGroupVO	list	by	IDs
	 * @param String
	 * @param PageController
	 * @return ArrayList<TemplateEquipmentGroupVO> 
	 * @throws Exception
	 */
	public static ArrayList<TemplateEquipmentGroupVO> queryByIDs(String ids,PageController pageController) throws Exception{
		logger.info("DAO	queryByIDs	begin");
		TemplateEquipmentGroupMQB templateEquipmentGroupMQB=new TemplateEquipmentGroupMQB(TemplateEquipmentGroupMQB.QUERY_FROM_TEMPLATEEQUIPMENTGROUP_BY_IDS,ids);

		if(pageController==null){
			pageController=new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	"+templateEquipmentGroupMQB.getSql());
		QueryTemplate.executeQueryForList(templateEquipmentGroupMQB, pageController);
		logger.info("list size	:	"+templateEquipmentGroupMQB.getTemplateEquipmentGroupList().size());
		logger.info("DAO	queryByIDs	end");
		return templateEquipmentGroupMQB.getTemplateEquipmentGroupList();
	}

	/**
	 * modify TemplateEquipmentGroupVO column by ID
	 * @param TemplateEquipmentGroupVO
	 * @param TransactionManager
	 * @return TemplateEquipmentGroupVO
	 * @throws Exception
	 */
	public static TemplateEquipmentGroupVO modify(TemplateEquipmentGroupVO templateEquipmentGroupVO,TransactionManager tManager)throws Exception{
		logger.info("DAO	modify	begin");
		TemplateEquipmentGroupTO templateEquipmentGroupTO=new TemplateEquipmentGroupTO(TemplateEquipmentGroupTO.MODIFY_TEMPLATEEQUIPMENTGROUP,templateEquipmentGroupVO);		
		templateEquipmentGroupTO.setSqlStr();
		logger.info("sqlStr	:	"+templateEquipmentGroupTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(templateEquipmentGroupTO, true);
		}else{
			TransactionTemplate.executeTransaction(templateEquipmentGroupTO, tManager);
		}
		logger.info("DAO	modify	end");
		return templateEquipmentGroupVO;
	}



	/**
	 * delete	TemplateEquipmentGroupVO by ids
	 * @param String
	 * @param TransactionManager
	 * @return TemplateEquipmentGroupVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids,TransactionManager tManager)throws Exception{
		logger.info("DAO	deleteByID	begin");
		TemplateEquipmentGroupVO templateEquipmentGroupVO = new TemplateEquipmentGroupVO();
		templateEquipmentGroupVO.setID(ids);
		TemplateEquipmentGroupTO templateEquipmentGroupTO=new TemplateEquipmentGroupTO(TemplateEquipmentGroupTO.DEL_TEMPLATEEQUIPMENTGROUP,templateEquipmentGroupVO);

		templateEquipmentGroupTO.setSqlStr();
		logger.info("sqlStr	:	"+templateEquipmentGroupTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(templateEquipmentGroupTO, true);
		}else{
			TransactionTemplate.executeTransaction(templateEquipmentGroupTO, tManager);
		}
		logger.info("result	:	"+templateEquipmentGroupTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return templateEquipmentGroupTO.getexecuteResult();
	}
}

