package com.zzst.service.meeting.kst;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.kst.WallPresetDAO;
import com.zzst.model.meeting.kst.WallPresetVO;

/**
 * class description: WallPreset ServiceImpl
 * 
 * @date Mon Jul 30 14:19:01 CST 2012
 * @author ryan
 */
public class WallPresetServiceImpl implements WallPresetService {
	private static Logger logger = CjfLogger.getLogger(WallPresetServiceImpl.class.getName());

	@Override
	public WallPresetVO add(WallPresetVO wallPresetVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		wallPresetVO = WallPresetDAO.add(wallPresetVO, null);
		logger.info("serviceImpl	add	end");
		return wallPresetVO;
	}

	@Override
	public ArrayList<WallPresetVO> query(WallPresetVO wallPresetVO, PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<WallPresetVO> listWallPreset = WallPresetDAO.query(wallPresetVO, pageController);
		logger.info("serviceImpl	query	end");
		return listWallPreset;
	}

	@Override
	public WallPresetVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<WallPresetVO> listWallPreset = WallPresetDAO.queryByIDs(id, null);
		if (listWallPreset != null && listWallPreset.size() == 1) {
			logger.info("serviceImpl	end");
			return listWallPreset.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<WallPresetVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<WallPresetVO> listWallPreset = WallPresetDAO.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listWallPreset;
	}

	@Override
	public WallPresetVO modify(WallPresetVO wallPresetVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		wallPresetVO = WallPresetDAO.modify(wallPresetVO, null);
		logger.info("serviceImpl	modify	end");
		return wallPresetVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = WallPresetDAO.deleteByID(id, null);
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
		int num = WallPresetDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

	public int deleteAll() throws Exception {
		logger.info("serviceImpl	deleteAll	begin");
		int num = WallPresetDAO.deleteAll(null);
		logger.info("serviceImpl	deleteAll	end");
		return num;
	}

}
