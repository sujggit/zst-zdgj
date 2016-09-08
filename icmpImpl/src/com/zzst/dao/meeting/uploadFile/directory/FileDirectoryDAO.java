package com.zzst.dao.meeting.uploadFile.directory;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.uploadFile.directory.FileDirectoryVO;

/**
 * class description: FileDirectory DAO
 * 
 * @date Mon May 06 14:16:25 CST 2013
 * @author ryan
 */
public class FileDirectoryDAO {
	private static Logger logger = CjfLogger.getLogger(FileDirectoryDAO.class.getName());

	private static final String id = "DirID";

	/**
	 * add FileDirectoryVO object
	 * 
	 * @param FileDirectoryVO
	 * @param TransactionManager
	 * @return FileDirectoryVO
	 * @throws Exception
	 */
	public static FileDirectoryVO add(FileDirectoryVO fileDirectoryVO, TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		fileDirectoryVO.setDirID(UtilDAO.getUUid());
		FileDirectoryTO fileDirectoryTO = new FileDirectoryTO(FileDirectoryTO.ADD_FILEDIRECTORY, fileDirectoryVO);

		fileDirectoryTO.setSqlStr();
		logger.info("sqlStr	:	" + fileDirectoryTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(fileDirectoryTO, true);
		} else {
			TransactionTemplate.executeTransaction(fileDirectoryTO, tManager);
		}
		logger.info("DAO	add	end");
		return fileDirectoryVO;
	}

	/**
	 * query FileDirectoryVO list
	 * 
	 * @param FileDirectoryVO
	 * @param PageController
	 * @return ArrayList<FileDirectoryVO>
	 * @throws Exception
	 */
	public static ArrayList<FileDirectoryVO> query(FileDirectoryVO fileDirectoryVO, PageController pageController)
			throws Exception {
		logger.info("DAO	query	begin");
		FileDirectoryMQB fileDirectoryMQB = new FileDirectoryMQB(FileDirectoryMQB.QUERY_FROM_FILEDIRECTORY,
				fileDirectoryVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + fileDirectoryMQB.getSql());
		QueryTemplate.executeQueryForList(fileDirectoryMQB, pageController);
		logger.info("list size	:	" + fileDirectoryMQB.getFileDirectoryList().size());
		logger.info("DAO	query	end");
		return fileDirectoryMQB.getFileDirectoryList();
	}

	/**
	 * query FileDirectoryVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<FileDirectoryVO>
	 * @throws Exception
	 */
	public static ArrayList<FileDirectoryVO> queryByIDs(String ids, PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		FileDirectoryMQB fileDirectoryMQB = new FileDirectoryMQB(FileDirectoryMQB.QUERY_FROM_FILEDIRECTORY_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + fileDirectoryMQB.getSql());
		QueryTemplate.executeQueryForList(fileDirectoryMQB, pageController);
		logger.info("list size	:	" + fileDirectoryMQB.getFileDirectoryList().size());
		logger.info("DAO	queryByIDs	end");
		return fileDirectoryMQB.getFileDirectoryList();
	}

	/**
	 * modify FileDirectoryVO column by ID
	 * 
	 * @param FileDirectoryVO
	 * @param TransactionManager
	 * @return FileDirectoryVO
	 * @throws Exception
	 */
	public static FileDirectoryVO modify(FileDirectoryVO fileDirectoryVO, TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		FileDirectoryTO fileDirectoryTO = new FileDirectoryTO(FileDirectoryTO.MODIFY_FILEDIRECTORY, fileDirectoryVO);
		fileDirectoryTO.setSqlStr();
		logger.info("sqlStr	:	" + fileDirectoryTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(fileDirectoryTO, true);
		} else {
			TransactionTemplate.executeTransaction(fileDirectoryTO, tManager);
		}
		logger.info("DAO	modify	end");
		return fileDirectoryVO;
	}

	/**
	 * delete FileDirectoryVO by id
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return FileDirectoryVO
	 * @throws Exception
	 */
	public static int deleteByID(String id, TransactionManager tManager) throws Exception {
		logger.info("DAO	deleteByID	begin");
		FileDirectoryVO fileDirectoryVO = new FileDirectoryVO();
		fileDirectoryVO.setDirID(id);
		FileDirectoryTO fileDirectoryTO = new FileDirectoryTO(FileDirectoryTO.DEL_FILEDIRECTORY, fileDirectoryVO);

		fileDirectoryTO.setSqlStr();
		logger.info("sqlStr	:	" + fileDirectoryTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(fileDirectoryTO, true);
		} else {
			TransactionTemplate.executeTransaction(fileDirectoryTO, tManager);
		}
		logger.info("result	:	" + fileDirectoryTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return fileDirectoryTO.getexecuteResult();
	}
}
