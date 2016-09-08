package com.zzst.dao.meeting.uploadFile.impower;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.gsiec.cjf.util.CjfSequenceUtil;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.uploadFile.UploadFileImpowerVO;

import org.apache.log4j.Logger;

/**
 * class description: UploadFileImpower DAO
 * @date Mon May 27 18:11:34 CST 2013
 * @author ryan
 */
public class UploadFileImpowerDAO {
	private static Logger logger = CjfLogger
			.getLogger(UploadFileImpowerDAO.class.getName());

	private static final String id = "Id";

	/**
	 * add UploadFileImpowerVO object
	 * 
	 * @param UploadFileImpowerVO
	 * @param TransactionManager
	 * @return UploadFileImpowerVO
	 * @throws Exception
	 */
	public static UploadFileImpowerVO add(
			UploadFileImpowerVO uploadFileImpowerVO, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	add	begin");
		uploadFileImpowerVO.setId(UtilDAO.getUUid());
		UploadFileImpowerTO uploadFileImpowerTO = new UploadFileImpowerTO(
				UploadFileImpowerTO.ADD_UPLOADFILEIMPOWER, uploadFileImpowerVO);

		uploadFileImpowerTO.setSqlStr();
		logger.info("sqlStr	:	" + uploadFileImpowerTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(uploadFileImpowerTO, true);
		} else {
			TransactionTemplate.executeTransaction(uploadFileImpowerTO,
					tManager);
		}
		logger.info("DAO	add	end");
		return uploadFileImpowerVO;
	}

	/**
	 * query UploadFileImpowerVO list
	 * 
	 * @param UploadFileImpowerVO
	 * @param PageController
	 * @return ArrayList<UploadFileImpowerVO>
	 * @throws Exception
	 */
	public static ArrayList<UploadFileImpowerVO> query(
			UploadFileImpowerVO uploadFileImpowerVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		UploadFileImpowerMQB uploadFileImpowerMQB = new UploadFileImpowerMQB(
				UploadFileImpowerMQB.QUERY_FROM_UPLOADFILEIMPOWER,
				uploadFileImpowerVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + uploadFileImpowerMQB.getSql());
		QueryTemplate.executeQueryForList(uploadFileImpowerMQB, pageController);
		logger.info("list size	:	"
				+ uploadFileImpowerMQB.getUploadFileImpowerList().size());
		logger.info("DAO	query	end");
		return uploadFileImpowerMQB.getUploadFileImpowerList();
	}

	/**
	 * query UploadFileImpowerVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<UploadFileImpowerVO>
	 * @throws Exception
	 */
	public static ArrayList<UploadFileImpowerVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		UploadFileImpowerMQB uploadFileImpowerMQB = new UploadFileImpowerMQB(
				UploadFileImpowerMQB.QUERY_FROM_UPLOADFILEIMPOWER_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + uploadFileImpowerMQB.getSql());
		QueryTemplate.executeQueryForList(uploadFileImpowerMQB, pageController);
		logger.info("list size	:	"
				+ uploadFileImpowerMQB.getUploadFileImpowerList().size());
		logger.info("DAO	queryByIDs	end");
		return uploadFileImpowerMQB.getUploadFileImpowerList();
	}

	/**
	 * modify UploadFileImpowerVO column by ID
	 * 
	 * @param UploadFileImpowerVO
	 * @param TransactionManager
	 * @return UploadFileImpowerVO
	 * @throws Exception
	 */
	public static UploadFileImpowerVO modify(
			UploadFileImpowerVO uploadFileImpowerVO, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	modify	begin");
		UploadFileImpowerTO uploadFileImpowerTO = new UploadFileImpowerTO(
				UploadFileImpowerTO.MODIFY_UPLOADFILEIMPOWER,
				uploadFileImpowerVO);
		uploadFileImpowerTO.setSqlStr();
		logger.info("sqlStr	:	" + uploadFileImpowerTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(uploadFileImpowerTO, true);
		} else {
			TransactionTemplate.executeTransaction(uploadFileImpowerTO,
					tManager);
		}
		logger.info("DAO	modify	end");
		return uploadFileImpowerVO;
	}

	/**
	 * delete UploadFileImpowerVO by id
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return UploadFileImpowerVO
	 * @throws Exception
	 */
	public static int deleteByID(String id, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		UploadFileImpowerVO uploadFileImpowerVO = new UploadFileImpowerVO();
		uploadFileImpowerVO.setId(id);
		UploadFileImpowerTO uploadFileImpowerTO = new UploadFileImpowerTO(
				UploadFileImpowerTO.DEL_UPLOADFILEIMPOWER, uploadFileImpowerVO);

		uploadFileImpowerTO.setSqlStr();
		logger.info("sqlStr	:	" + uploadFileImpowerTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(uploadFileImpowerTO, true);
		} else {
			TransactionTemplate.executeTransaction(uploadFileImpowerTO,
					tManager);
		}
		logger.info("result	:	" + uploadFileImpowerTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return uploadFileImpowerTO.getexecuteResult();
	}

	public static int deleteByUploadId(String uploadId, TransactionManager tManager) throws Exception{
		logger.info("DAO	deleteByUploadId	begin");
		UploadFileImpowerVO uploadFileImpowerVO = new UploadFileImpowerVO();
		uploadFileImpowerVO.setUploadId(uploadId);
		UploadFileImpowerTO uploadFileImpowerTO = new UploadFileImpowerTO(
				UploadFileImpowerTO.DEL_UPLOADID_UPLOADFILEIMPOWER, uploadFileImpowerVO);

		uploadFileImpowerTO.setSqlStr();
		logger.info("sqlStr	:	" + uploadFileImpowerTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(uploadFileImpowerTO, true);
		} else {
			TransactionTemplate.executeTransaction(uploadFileImpowerTO,
					tManager);
		}
		logger.info("result	:	" + uploadFileImpowerTO.getexecuteResult());
		logger.info("DAO	deleteByUploadId	end");
		return uploadFileImpowerTO.getexecuteResult();
	}

	public static int deleteByUsers(String uploadId, String userIDs,int status, 
			TransactionManager tManager) throws Exception{
		logger.info("DAO	deleteByUsers	begin");
		UploadFileImpowerVO uploadFileImpowerVO = new UploadFileImpowerVO();
		uploadFileImpowerVO.setUploadId(uploadId);
		UploadFileImpowerTO uploadFileImpowerTO = new UploadFileImpowerTO(
				UploadFileImpowerTO.DEL_UPLOADFILEIMPOWER_BYUSERS, uploadId, userIDs, status);

		uploadFileImpowerTO.setSqlStr();
		logger.info("sqlStr	:	" + uploadFileImpowerTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(uploadFileImpowerTO, true);
		} else {
			TransactionTemplate.executeTransaction(uploadFileImpowerTO,
					tManager);
		}
		logger.info("result	:	" + uploadFileImpowerTO.getexecuteResult());
		logger.info("DAO	deleteByUsers	end");
		return uploadFileImpowerTO.getexecuteResult();
	}

	public static int delete(UploadFileImpowerVO uploadFileImpowerVO, 
			TransactionManager tManager) throws Exception{
		logger.info("DAO	deleteByID	begin");
		UploadFileImpowerTO uploadFileImpowerTO = new UploadFileImpowerTO(
				UploadFileImpowerTO.DELETE_UPLOADFILEIMPOWER, uploadFileImpowerVO);

		uploadFileImpowerTO.setSqlStr();
		logger.info("sqlStr	:	" + uploadFileImpowerTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(uploadFileImpowerTO, true);
		} else {
			TransactionTemplate.executeTransaction(uploadFileImpowerTO,
					tManager);
		}
		logger.info("result	:	" + uploadFileImpowerTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return uploadFileImpowerTO.getexecuteResult();
	}
}
