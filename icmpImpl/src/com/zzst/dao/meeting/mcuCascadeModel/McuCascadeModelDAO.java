package com.zzst.dao.meeting.mcuCascadeModel;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.mcuCascadeModel.McuCascadeModelVO;

/**
 * class description: McuCascadeModel DAO
 * 
 * @date Tue Nov 20 10:40:39 CST 2012
 * @author ryan
 */
public class McuCascadeModelDAO {
	private static Logger logger = CjfLogger.getLogger(McuCascadeModelDAO.class
			.getName());

	private static final String id = "CascadeID";

	/**
	 * add McuCascadeModelVO object
	 * 
	 * @param McuCascadeModelVO
	 * @param TransactionManager
	 * @return McuCascadeModelVO
	 * @throws Exception
	 */
	public static McuCascadeModelVO add(McuCascadeModelVO mcuCascadeModelVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		mcuCascadeModelVO.setCascadeID(UtilDAO.getUUid());
		McuCascadeModelTO mcuCascadeModelTO = new McuCascadeModelTO(
				McuCascadeModelTO.ADD_MCUCASCADEMODEL, mcuCascadeModelVO);

		mcuCascadeModelTO.setSqlStr();
		logger.info("sqlStr	:	" + mcuCascadeModelTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(mcuCascadeModelTO, true);
		} else {
			TransactionTemplate.executeTransaction(mcuCascadeModelTO, tManager);
		}
		logger.info("DAO	add	end");
		return mcuCascadeModelVO;
	}

	/**
	 * query McuCascadeModelVO list
	 * 
	 * @param McuCascadeModelVO
	 * @param PageController
	 * @return ArrayList<McuCascadeModelVO>
	 * @throws Exception
	 */
	public static ArrayList<McuCascadeModelVO> query(
			McuCascadeModelVO mcuCascadeModelVO, PageController pageController)
			throws Exception {
		logger.info("DAO	query	begin");
		McuCascadeModelMQB mcuCascadeModelMQB = null;
		if(mcuCascadeModelVO.getStatus()==-999){
			mcuCascadeModelMQB=new McuCascadeModelMQB(McuCascadeModelMQB.QUERY_FROM_MCUCASCADEMODEL_BACK,
				mcuCascadeModelVO);
		}else{
			mcuCascadeModelMQB=new McuCascadeModelMQB(McuCascadeModelMQB.QUERY_FROM_MCUCASCADEMODEL,
					mcuCascadeModelVO);
		}

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + mcuCascadeModelMQB.getSql());
		QueryTemplate.executeQueryForList(mcuCascadeModelMQB, pageController);
		logger.info("list size	:	"
				+ mcuCascadeModelMQB.getMcuCascadeModelList().size());
		logger.info("DAO	query	end");
		return mcuCascadeModelMQB.getMcuCascadeModelList();
	}

	public static ArrayList<McuCascadeModelVO> queryByMCUIP(
			McuCascadeModelVO mcuCascadeModelVO, PageController pageController)
			throws Exception {
		logger.info("DAO	queryByMCUIP	begin");
		McuCascadeModelMQB mcuCascadeModelMQB = null;
		if(mcuCascadeModelVO.getStatus()==-999){
			mcuCascadeModelMQB=new McuCascadeModelMQB(McuCascadeModelMQB.QUERY_FROM_MCUCASCADEMODEL_BACK,
				mcuCascadeModelVO);
		}else{
			mcuCascadeModelMQB=new McuCascadeModelMQB(McuCascadeModelMQB.QUERY_FROM_MCUCASCADEMODEL,
					mcuCascadeModelVO);
		}

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + mcuCascadeModelMQB.getSql());
		QueryTemplate.executeQueryForList(mcuCascadeModelMQB, pageController);
		logger.info("list size	:	"
				+ mcuCascadeModelMQB.getMcuCascadeModelList().size());
		logger.info("DAO	queryByMCUIP	end");
		return mcuCascadeModelMQB.getMcuCascadeModelList();
	}
	
	/**
	 * query McuCascadeModelVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<McuCascadeModelVO>
	 * @throws Exception
	 */
	public static ArrayList<McuCascadeModelVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		McuCascadeModelMQB mcuCascadeModelMQB = new McuCascadeModelMQB(
				McuCascadeModelMQB.QUERY_FROM_MCUCASCADEMODEL_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + mcuCascadeModelMQB.getSql());
		QueryTemplate.executeQueryForList(mcuCascadeModelMQB, pageController);
		logger.info("list size	:	"
				+ mcuCascadeModelMQB.getMcuCascadeModelList().size());
		logger.info("DAO	queryByIDs	end");
		return mcuCascadeModelMQB.getMcuCascadeModelList();
	}

	/**
	 * modify McuCascadeModelVO column by ID
	 * 
	 * @param McuCascadeModelVO
	 * @param TransactionManager
	 * @return McuCascadeModelVO
	 * @throws Exception
	 */
	public static McuCascadeModelVO modify(McuCascadeModelVO mcuCascadeModelVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		McuCascadeModelTO mcuCascadeModelTO = new McuCascadeModelTO(
				McuCascadeModelTO.MODIFY_MCUCASCADEMODEL, mcuCascadeModelVO);
		mcuCascadeModelTO.setSqlStr();
		logger.info("sqlStr	:	" + mcuCascadeModelTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(mcuCascadeModelTO, true);
		} else {
			TransactionTemplate.executeTransaction(mcuCascadeModelTO, tManager);
		}
		logger.info("DAO	modify	end");
		return mcuCascadeModelVO;
	}

	/**
	 * delete McuCascadeModelVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return McuCascadeModelVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		McuCascadeModelVO mcuCascadeModelVO = new McuCascadeModelVO();
		mcuCascadeModelVO.setCascadeID(ids);
		McuCascadeModelTO mcuCascadeModelTO = new McuCascadeModelTO(
				McuCascadeModelTO.DEL_MCUCASCADEMODEL, mcuCascadeModelVO);

		mcuCascadeModelTO.setSqlStr();
		logger.info("sqlStr	:	" + mcuCascadeModelTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(mcuCascadeModelTO, true);
		} else {
			TransactionTemplate.executeTransaction(mcuCascadeModelTO, tManager);
		}
		logger.info("result	:	" + mcuCascadeModelTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return mcuCascadeModelTO.getexecuteResult();
	}
	
	public static int deleteByMcuIP(String ip, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByMcuIP	begin");
		McuCascadeModelVO mcuCascadeModelVO = new McuCascadeModelVO();
		mcuCascadeModelVO.setMcuIp(ip);
		McuCascadeModelTO mcuCascadeModelTO = new McuCascadeModelTO(
				McuCascadeModelTO.DEL_MCUCASCADEMODEL_MCUIP, mcuCascadeModelVO);

		mcuCascadeModelTO.setSqlStr();
		logger.info("sqlStr	:	" + mcuCascadeModelTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(mcuCascadeModelTO, true);
		} else {
			TransactionTemplate.executeTransaction(mcuCascadeModelTO, tManager);
		}
		logger.info("result	:	" + mcuCascadeModelTO.getexecuteResult());
		logger.info("DAO	deleteByMcuIP	end");
		return mcuCascadeModelTO.getexecuteResult();
	}
}
