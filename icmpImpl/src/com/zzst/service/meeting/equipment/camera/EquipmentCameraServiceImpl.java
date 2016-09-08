package com.zzst.service.meeting.equipment.camera;

import java.util.ArrayList;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.equipment.camera.EquipmentCameraDAO;
import com.zzst.model.meeting.equipment.EquipmentCameraVO;

import org.apache.log4j.Logger;

/**
 * class description: EquipmentCamera ServiceImpl
 * 
 * @date Fri Jun 21 16:34:00 CST 2013
 * @author ryan
 */
public class EquipmentCameraServiceImpl implements EquipmentCameraService {
	private static Logger logger = CjfLogger
			.getLogger(EquipmentCameraServiceImpl.class.getName());

	@Override
	public EquipmentCameraVO add(EquipmentCameraVO equipmentCameraVO)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		equipmentCameraVO = EquipmentCameraDAO.add(equipmentCameraVO, null);
		logger.info("serviceImpl	add	end");
		return equipmentCameraVO;
	}

	@Override
	public ArrayList<EquipmentCameraVO> query(
			EquipmentCameraVO equipmentCameraVO, PageController pageController)
			throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<EquipmentCameraVO> listEquipmentCamera = EquipmentCameraDAO
				.query(equipmentCameraVO, pageController);
		logger.info("serviceImpl	query	end");
		return listEquipmentCamera;
	}

	@Override
	public EquipmentCameraVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<EquipmentCameraVO> listEquipmentCamera = EquipmentCameraDAO
				.queryByIDs(id, null);
		if (listEquipmentCamera != null && listEquipmentCamera.size() == 1) {
			logger.info("serviceImpl	end");
			return listEquipmentCamera.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<EquipmentCameraVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<EquipmentCameraVO> listEquipmentCamera = EquipmentCameraDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listEquipmentCamera;
	}

	@Override
	public EquipmentCameraVO modify(EquipmentCameraVO equipmentCameraVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		equipmentCameraVO = EquipmentCameraDAO.modify(equipmentCameraVO, null);
		logger.info("serviceImpl	modify	end");
		return equipmentCameraVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = EquipmentCameraDAO.deleteByID(id, null);
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
				deleteByID(id[i]);
			}
		}
		logger.info("serviceImpl	deleteByIDs	end");
	}

}
