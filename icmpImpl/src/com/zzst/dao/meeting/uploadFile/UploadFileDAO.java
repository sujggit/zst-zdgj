package com.zzst.dao.meeting.uploadFile;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.uploadFile.UploadFileVO;

/**
 * class description: UploadFile DAO
 * 
 * @date Thu Sep 20 14:13:12 CST 2012
 * @author ryan
 */
public class UploadFileDAO {
	private static Logger logger = CjfLogger.getLogger(UploadFileDAO.class
			.getName());

	private static final String id = "UploadID";

	/**
	 * add UploadFileVO object
	 * 
	 * @param UploadFileVO
	 * @param TransactionManager
	 * @return UploadFileVO
	 * @throws Exception
	 */
	public static UploadFileVO add(UploadFileVO uploadFileVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		
		UploadFileTO uploadFileTO = new UploadFileTO(
				UploadFileTO.ADD_UPLOADFILE, uploadFileVO);

		uploadFileTO.setSqlStr();
		logger.info("sqlStr	:	" + uploadFileTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(uploadFileTO, true);
		} else {
			TransactionTemplate.executeTransaction(uploadFileTO, tManager);
		}
		logger.info("DAO	add	end");
		return uploadFileVO;
	}

	/**
	 * query UploadFileVO list
	 * 
	 * @param UploadFileVO
	 * @param PageController
	 * @return ArrayList<UploadFileVO>
	 * @throws Exception
	 */
	public static ArrayList<UploadFileVO> query(UploadFileVO uploadFileVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		UploadFileMQB uploadFileMQB = new UploadFileMQB(
				UploadFileMQB.QUERY_FROM_UPLOADFILE, uploadFileVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + uploadFileMQB.getSql());
		QueryTemplate.executeQueryForList(uploadFileMQB, pageController);
		logger.info("list size	:	" + uploadFileMQB.getUploadFileList().size());
		logger.info("DAO	query	end");
		return uploadFileMQB.getUploadFileList();
	}

	/**
	 * query UploadFileVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<UploadFileVO>
	 * @throws Exception
	 */
	public static ArrayList<UploadFileVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		UploadFileMQB uploadFileMQB = new UploadFileMQB(
				UploadFileMQB.QUERY_FROM_UPLOADFILE_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + uploadFileMQB.getSql());
		QueryTemplate.executeQueryForList(uploadFileMQB, pageController);
		logger.info("list size	:	" + uploadFileMQB.getUploadFileList().size());
		logger.info("DAO	queryByIDs	end");
		return uploadFileMQB.getUploadFileList();
	}

	/**
	 * modify UploadFileVO column by ID
	 * 
	 * @param UploadFileVO
	 * @param TransactionManager
	 * @return UploadFileVO
	 * @throws Exception
	 */
	public static UploadFileVO modify(UploadFileVO uploadFileVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		UploadFileTO uploadFileTO = new UploadFileTO(
				UploadFileTO.MODIFY_UPLOADFILE, uploadFileVO);
		uploadFileTO.setSqlStr();
		logger.info("sqlStr	:	" + uploadFileTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(uploadFileTO, true);
		} else {
			TransactionTemplate.executeTransaction(uploadFileTO, tManager);
		}
		logger.info("DAO	modify	end");
		return uploadFileVO;
	}

	/**
	 * delete UploadFileVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return UploadFileVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		UploadFileVO uploadFileVO = new UploadFileVO();
		uploadFileVO.setUploadID(ids);
		UploadFileTO uploadFileTO = new UploadFileTO(
				UploadFileTO.DEL_UPLOADFILE, uploadFileVO);

		uploadFileTO.setSqlStr();
		logger.info("sqlStr	:	" + uploadFileTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(uploadFileTO, true);
		} else {
			TransactionTemplate.executeTransaction(uploadFileTO, tManager);
		}
		logger.info("result	:	" + uploadFileTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return uploadFileTO.getexecuteResult();
	}
	
	/**
	 * 
	 * @param uploadFileVO
	 * @param tManager
	 * @return
	 * @throws Exception
	 */
	public static int delFileForState(String ids,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		UploadFileVO uploadFileVO = new UploadFileVO();
		uploadFileVO.setUploadID(ids);
		UploadFileTO uploadFileTO = new UploadFileTO(
				UploadFileTO.MODIFY_STATE, uploadFileVO);
		uploadFileTO.setSqlStr();
		logger.info("sqlStr	:	" + uploadFileTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(uploadFileTO, true);
		} else {
			TransactionTemplate.executeTransaction(uploadFileTO, tManager);
		}
		logger.info("DAO	modify	end");
		return uploadFileTO.getexecuteResult();
	}

	/**
	 * 关联表：z_t_uploadfileimpower
	 * @param uploadFileVO
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<UploadFileVO> queryByPower(
			UploadFileVO uploadFileVO, PageController pageController) throws Exception{
		logger.info("DAO	queryByPower	begin");
		UploadFileMQBByPower uploadFileMQB = new UploadFileMQBByPower(
				UploadFileMQBByPower.QUERY_FROM_UPLOADFILE_IMPOWER, uploadFileVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + uploadFileMQB.getSql());
		QueryTemplate.executeQueryForList(uploadFileMQB, pageController);
		logger.info("list size	:	" + uploadFileMQB.getUploadFileList().size());
		logger.info("DAO	queryByPower	end");
		return uploadFileMQB.getUploadFileList();
	}

	/**
	 * 
	 * @param uploadFileVO
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<UploadFileVO> queryBaseInfo(UploadFileVO uploadFileVO,
			PageController pageController) throws Exception {
		logger.info("DAO	queryBaseInfo	begin");
		UploadFileMQB uploadFileMQB = new UploadFileMQB(
				UploadFileMQB.QUERYBASEINFO_FROM_UPLOADFILE, uploadFileVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + uploadFileMQB.getSql());
		QueryTemplate.executeQueryForList(uploadFileMQB, pageController);
		logger.info("list size	:	" + uploadFileMQB.getUploadFileList().size());
		logger.info("DAO	queryBaseInfo	end");
		return uploadFileMQB.getUploadFileList();
	}

	public static int deleteByMeeting(UploadFileVO uploadFileVO, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByMeeting	begin");
		UploadFileTO uploadFileTO = new UploadFileTO(
				UploadFileTO.DEL_UPLOADFILE_BY_MEETING, uploadFileVO);

		uploadFileTO.setSqlStr();
		logger.info("sqlStr	:	" + uploadFileTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(uploadFileTO, true);
		} else {
			TransactionTemplate.executeTransaction(uploadFileTO, tManager);
		}
		logger.info("result	:	" + uploadFileTO.getexecuteResult());
		logger.info("DAO	deleteByMeeting	end");
		return uploadFileTO.getexecuteResult();
	}
}
