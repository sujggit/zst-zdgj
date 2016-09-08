package com.zzst.service.meeting.uploadFile.directory;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.uploadFile.directory.FileDirectoryDAO;
import com.zzst.model.meeting.uploadFile.directory.FileDirectoryVO;

/**
 * class description: FileDirectory ServiceImpl
 * 
 * @date Mon May 06 13:58:38 CST 2013
 * @author ryan
 */
public class FileDirectoryServiceImpl implements FileDirectoryService {
	private static Logger logger = CjfLogger.getLogger(FileDirectoryServiceImpl.class.getName());

	@Override
	public FileDirectoryVO add(FileDirectoryVO fileDirectoryVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		fileDirectoryVO = FileDirectoryDAO.add(fileDirectoryVO, null);
		logger.info("serviceImpl	add	end");
		return fileDirectoryVO;
	}

	@Override
	public ArrayList<FileDirectoryVO> query(FileDirectoryVO fileDirectoryVO, PageController pageController)
			throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<FileDirectoryVO> listFileDirectory = FileDirectoryDAO.query(fileDirectoryVO, pageController);
		logger.info("serviceImpl	query	end");
		return listFileDirectory;
	}

	@Override
	public FileDirectoryVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<FileDirectoryVO> listFileDirectory = FileDirectoryDAO.queryByIDs(id, null);
		if (listFileDirectory != null && listFileDirectory.size() == 1) {
			logger.info("serviceImpl	end");
			return listFileDirectory.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<FileDirectoryVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<FileDirectoryVO> listFileDirectory = FileDirectoryDAO.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listFileDirectory;
	}

	@Override
	public FileDirectoryVO modify(FileDirectoryVO fileDirectoryVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		fileDirectoryVO = FileDirectoryDAO.modify(fileDirectoryVO, null);
		logger.info("serviceImpl	modify	end");
		return fileDirectoryVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = FileDirectoryDAO.deleteByID(id, null);
		if (num == 1) {
			logger.info("serviceImpl	deleteByID	end");
			return true;
		} else {
			logger.info("serviceImpl	deleteByID	end");
			return false;
		}
	}

	@Override
	public void deleteByIDs(String ids) throws Exception {
		logger.info("serviceImpl	deleteByIDs	begin");
		if (ids != null && ids.length() > 0) {
			String[] id = ids.split(",");
			for (int i = id.length; i >= 0; i--) {
				queryByID(id[i]);
			}
		}
		logger.info("serviceImpl	deleteByIDs	end");
	}

	public static void main(String args[]) throws Exception {
		// DBConnection.setDbInfo("jdbc:oracle:thin:@10.1.3.182:1521:cinda",
		// "cinda", "cinda");
		DBConnection.setDbInfo("jdbc:mysql://10.1.8.7:3306/icmp?characterEncoding=gb2312", "root", "myroot");
		FileDirectoryVO vFileDirectoryVO = new FileDirectoryVO();
		vFileDirectoryVO.setDirID("dirID");
		vFileDirectoryVO.setName("name");
		vFileDirectoryVO.setParentID("1");
		vFileDirectoryVO.setStatus(1);
		vFileDirectoryVO.setUpdateUserID("updateUserID");
		vFileDirectoryVO.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		vFileDirectoryVO.setDescription("description");
		vFileDirectoryVO.setRevision(new Long(888));

		new FileDirectoryServiceImpl().add(vFileDirectoryVO);
		System.out.println("=========add Success!");

		ArrayList<FileDirectoryVO> lstFileDirectory = new FileDirectoryServiceImpl().query(vFileDirectoryVO, null);

		if (lstFileDirectory.size() > 0) {
			System.out.println("=========query Result:");
			FileDirectoryVO vvFileDirectoryVO = (FileDirectoryVO) lstFileDirectory.get(0);
			System.out.println("dirID=" + vvFileDirectoryVO.getDirID());
			System.out.println("name=" + vvFileDirectoryVO.getName());
			System.out.println("parentID=" + vvFileDirectoryVO.getParentID());
			System.out.println("status=" + vvFileDirectoryVO.getStatus());
			System.out.println("updateUserID=" + vvFileDirectoryVO.getUpdateUserID());
			System.out.println("updateTime=" + vvFileDirectoryVO.getUpdateTime());
			System.out.println("description=" + vvFileDirectoryVO.getDescription());
			System.out.println("revision=" + vvFileDirectoryVO.getRevision());

		} else {
			System.out.println("=========query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
		}

	}

}
