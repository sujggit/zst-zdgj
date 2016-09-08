package com.zzst.dao.meeting.templateEquipment;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.cbf.log.CbfLogger;
import com.gsiec.cjf.util.CjfSequenceUtil;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.templateEquipment.TemplateEquipmentVO;

import org.apache.log4j.Logger;

/**
 * class description:	TemplateEquipment DAO
 * @date Wed Mar 20 13:12:04 CST 2013
 * @author ryan
 */
public class TemplateEquipmentDAO {
	private static Logger logger = CbfLogger.getLogger(TemplateEquipmentDAO.class.getName());

	private static 	final	String	id="ID";

	/**
	 * add TemplateEquipmentVO	object
	 * @param TemplateEquipmentVO
	 * @param TransactionManager
	 * @return TemplateEquipmentVO
	 * @throws Exception
	 */
	public static TemplateEquipmentVO add(TemplateEquipmentVO templateEquipmentVO,TransactionManager tManager)throws Exception{
		logger.info("DAO	add	begin");
		templateEquipmentVO.setID(UtilDAO.getUUid());
		TemplateEquipmentTO templateEquipmentTO=new TemplateEquipmentTO(TemplateEquipmentTO.ADD_TEMPLATEEQUIPMENT,templateEquipmentVO);

		templateEquipmentTO.setSqlStr();
		logger.info("sqlStr	:	"+templateEquipmentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(templateEquipmentTO, true);
		}else{
			TransactionTemplate.executeTransaction(templateEquipmentTO, tManager);
		}
		logger.info("DAO	add	end");
		return templateEquipmentVO;
	}



	/**
	 * query TemplateEquipmentVO	list
	 * @param TemplateEquipmentVO
	 * @param PageController
	 * @return ArrayList<TemplateEquipmentVO> 
	 * @throws Exception
	 */
	public static ArrayList<TemplateEquipmentVO> query(TemplateEquipmentVO templateEquipmentVO,PageController pageController) throws Exception{
		logger.info("DAO	query	begin");
		TemplateEquipmentMQB templateEquipmentMQB=new TemplateEquipmentMQB(TemplateEquipmentMQB.QUERY_FROM_TEMPLATEEQUIPMENT,templateEquipmentVO);

		if(pageController==null){
			pageController=new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	"+templateEquipmentMQB.getSql());
		QueryTemplate.executeQueryForList(templateEquipmentMQB, pageController);
		logger.info("list size	:	"+templateEquipmentMQB.getTemplateEquipmentList().size());
		logger.info("DAO	query	end");
		return templateEquipmentMQB.getTemplateEquipmentList();
	}

	/**
	 * query TemplateEquipmentVO	list	by	IDs
	 * @param String
	 * @param PageController
	 * @return ArrayList<TemplateEquipmentVO> 
	 * @throws Exception
	 */
	public static ArrayList<TemplateEquipmentVO> queryByIDs(String ids,PageController pageController) throws Exception{
		logger.info("DAO	queryByIDs	begin");
		TemplateEquipmentMQB templateEquipmentMQB=new TemplateEquipmentMQB(TemplateEquipmentMQB.QUERY_FROM_TEMPLATEEQUIPMENT_BY_IDS,ids);

		if(pageController==null){
			pageController=new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	"+templateEquipmentMQB.getSql());
		QueryTemplate.executeQueryForList(templateEquipmentMQB, pageController);
		logger.info("list size	:	"+templateEquipmentMQB.getTemplateEquipmentList().size());
		logger.info("DAO	queryByIDs	end");
		return templateEquipmentMQB.getTemplateEquipmentList();
	}

	/**
	 * modify TemplateEquipmentVO column by ID
	 * @param TemplateEquipmentVO
	 * @param TransactionManager
	 * @return TemplateEquipmentVO
	 * @throws Exception
	 */
	public static TemplateEquipmentVO modify(TemplateEquipmentVO templateEquipmentVO,TransactionManager tManager)throws Exception{
		logger.info("DAO	modify	begin");
		TemplateEquipmentTO templateEquipmentTO=new TemplateEquipmentTO(TemplateEquipmentTO.MODIFY_TEMPLATEEQUIPMENT,templateEquipmentVO);		
		templateEquipmentTO.setSqlStr();
		logger.info("sqlStr	:	"+templateEquipmentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(templateEquipmentTO, true);
		}else{
			TransactionTemplate.executeTransaction(templateEquipmentTO, tManager);
		}
		logger.info("DAO	modify	end");
		return templateEquipmentVO;
	}



	/**
	 * delete	TemplateEquipmentVO by ids
	 * @param String
	 * @param TransactionManager
	 * @return TemplateEquipmentVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids,TransactionManager tManager)throws Exception{
		logger.info("DAO	deleteByID	begin");
		TemplateEquipmentVO templateEquipmentVO = new TemplateEquipmentVO();
		templateEquipmentVO.setID(ids);
		TemplateEquipmentTO templateEquipmentTO=new TemplateEquipmentTO(TemplateEquipmentTO.DEL_TEMPLATEEQUIPMENT,templateEquipmentVO);

		templateEquipmentTO.setSqlStr();
		logger.info("sqlStr	:	"+templateEquipmentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(templateEquipmentTO, true);
		}else{
			TransactionTemplate.executeTransaction(templateEquipmentTO, tManager);
		}
		logger.info("result	:	"+templateEquipmentTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return templateEquipmentTO.getexecuteResult();
	}
}

