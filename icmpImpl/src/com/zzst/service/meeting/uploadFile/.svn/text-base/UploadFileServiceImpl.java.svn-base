package com.zzst.service.meeting.uploadFile;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.dao.meeting.uploadFile.UploadFileDAO;
import com.zzst.model.meeting.uploadFile.UploadFileVO;

/**
 * class description: UploadFile ServiceImpl
 * 
 * @date Thu Sep 20 14:13:12 CST 2012
 * @author ryan
 */
public class UploadFileServiceImpl implements UploadFileService {
	private static Logger logger = CjfLogger
			.getLogger(UploadFileServiceImpl.class.getName());

	@Override
	public UploadFileVO add(boolean ifNeedId , UploadFileVO uploadFileVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		if(ifNeedId){
			uploadFileVO.setUploadID(UtilDAO.getUUid());
		}
		
		uploadFileVO = UploadFileDAO.add(uploadFileVO, null);
		logger.info("serviceImpl	add	end");
		return uploadFileVO;
	}

	@Override
	public ArrayList<UploadFileVO> query(UploadFileVO uploadFileVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<UploadFileVO> listUploadFile = UploadFileDAO.query(
				uploadFileVO, pageController);
		logger.info("serviceImpl	query	end");
		return listUploadFile;
	}

	@Override
	public UploadFileVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<UploadFileVO> listUploadFile = UploadFileDAO.queryByIDs(id,
				null);
		if (listUploadFile != null && listUploadFile.size() == 1) {
			logger.info("serviceImpl	queryByID	end");
			return listUploadFile.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<UploadFileVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<UploadFileVO> listUploadFile = UploadFileDAO.queryByIDs(ids,
				null);
		logger.info("serviceImpl	queryByIDs	end");
		return listUploadFile;
	}

	@Override
	public UploadFileVO modify(UploadFileVO uploadFileVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		uploadFileVO = UploadFileDAO.modify(uploadFileVO, null);
		logger.info("serviceImpl	modify	end");
		return uploadFileVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = UploadFileDAO.deleteByID(id, null);
		if (num == 1) {
			logger.info("serviceImpl	deleteByID	end");
			return true;
		} else {
			logger.info("serviceImpl	deleteByID	end");
			return false;
		}
	}

	@Override
	public int deleteByIDs(String ids) throws Exception {
		logger.info("serviceImpl	deleteByIDs	begin");
		int num = UploadFileDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

	@Override
	public boolean delFileForState(String id) throws Exception {
		logger.info("serviceImpl	delFileForState	begin");
		int num = UploadFileDAO.delFileForState(id, null);
		if (num == 1) {
			logger.info("serviceImpl	delFileForState	end");
			return true;
		} else {
			logger.info("serviceImpl	delFileForState	end");
			return false;
		}
	}

	@Override
	public List<UploadFileVO> queryByPower(UploadFileVO uploadFileVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	queryByPower	begin");
		ArrayList<UploadFileVO> listUploadFile = UploadFileDAO.queryByPower(
				uploadFileVO, pageController);
		logger.info("serviceImpl	queryByPower	end");
		return listUploadFile;
	}

	@Override
	public List<UploadFileVO> queryBaseInfo(UploadFileVO uploadFileVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	queryBaseInfo	begin");
		ArrayList<UploadFileVO> listUploadFile = UploadFileDAO.queryBaseInfo(uploadFileVO, pageController);
		logger.info("serviceImpl	queryBaseInfo	end");
		return listUploadFile;
	}

	@Override
	public int deleteByMeeting(UploadFileVO uploadFileVO) throws Exception {
		logger.info("serviceImpl	deleteByMeeting	begin");
		int num = UploadFileDAO.deleteByMeeting(uploadFileVO, null);
		logger.info("serviceImpl	deleteByMeeting	end");
		return num;
	}
}
