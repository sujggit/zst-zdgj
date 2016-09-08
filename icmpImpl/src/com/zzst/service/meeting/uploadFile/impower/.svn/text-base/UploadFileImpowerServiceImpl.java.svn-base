package com.zzst.service.meeting.uploadFile.impower;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.uploadFile.impower.UploadFileImpowerDAO;
import com.zzst.model.meeting.uploadFile.UploadFileImpowerVO;

import org.apache.log4j.Logger;

/**
 * class description: UploadFileImpower ServiceImpl
 * 
 * @date Mon May 27 18:11:34 CST 2013
 * @author ryan
 */
public class UploadFileImpowerServiceImpl implements UploadFileImpowerService {
	private static Logger logger = CjfLogger
			.getLogger(UploadFileImpowerServiceImpl.class.getName());

	@Override
	public UploadFileImpowerVO add(UploadFileImpowerVO uploadFileImpowerVO)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		uploadFileImpowerVO = UploadFileImpowerDAO.add(uploadFileImpowerVO,
				null);
		logger.info("serviceImpl	add	end");
		return uploadFileImpowerVO;
	}

	@Override
	public ArrayList<UploadFileImpowerVO> query(
			UploadFileImpowerVO uploadFileImpowerVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<UploadFileImpowerVO> listUploadFileImpower = UploadFileImpowerDAO
				.query(uploadFileImpowerVO, pageController);
		logger.info("serviceImpl	query	end");
		return listUploadFileImpower;
	}

	@Override
	public UploadFileImpowerVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<UploadFileImpowerVO> listUploadFileImpower = UploadFileImpowerDAO
				.queryByIDs(id, null);
		if (listUploadFileImpower != null && listUploadFileImpower.size() == 1) {
			logger.info("serviceImpl	end");
			return listUploadFileImpower.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<UploadFileImpowerVO> queryByIDs(String ids)
			throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<UploadFileImpowerVO> listUploadFileImpower = UploadFileImpowerDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listUploadFileImpower;
	}

	@Override
	public UploadFileImpowerVO modify(UploadFileImpowerVO uploadFileImpowerVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		uploadFileImpowerVO = UploadFileImpowerDAO.modify(uploadFileImpowerVO,
				null);
		logger.info("serviceImpl	modify	end");
		return uploadFileImpowerVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = UploadFileImpowerDAO.deleteByID(id, null);
		if (num == 1) {
			logger.info("serviceImpl	deleteByID	end");
			return true;
		} else {
			logger.info("serviceImpl	deleteByID	end");
			return false;
		}
	}

	@Override
	public void deleteByUploadIds(String[] uploadIds) throws Exception {
		logger.info("serviceImpl	deleteByUploadIds	begin");
		if (uploadIds != null && uploadIds.length > 0) {
			for (int i = 0; i < uploadIds.length; i++) {
				UploadFileImpowerDAO.deleteByUploadId(uploadIds[i], null);
			}
		}
		logger.info("serviceImpl	deleteByUploadIds	end");
	}

	@Override
	public void deleteByUsers(String uploadId, String userIDs, int status) throws Exception{
		logger.info("serviceImpl	deleteByUsers	begin");
		UploadFileImpowerDAO.deleteByUsers(uploadId,userIDs,status, null);
		logger.info("serviceImpl	deleteByUsers	end");
	}

	@Override
	public boolean delete(UploadFileImpowerVO uploadFileImpowerVO)
			throws Exception {
		logger.info("serviceImpl	delete	begin");
		int num = UploadFileImpowerDAO.delete(uploadFileImpowerVO,null);
		if (num == 1) {
			logger.info("serviceImpl	deleteByID	end");
			return true;
		} else {
			logger.info("serviceImpl	delete	end");
			return false;
		}
	}

}
