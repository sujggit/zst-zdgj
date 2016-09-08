package com.zzst.service.meeting.equipment;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.equipment.EquipmentMcuDAO;
import com.zzst.model.meeting.equipment.EquipmentMcuVO;

/**
 * class description: EquipmentMcu ServiceImpl
 * 
 * @date Wed Nov 30 10:22:49 CST 2011
 * @author ryan
 */
public class EquipmentMcuServiceImpl implements EquipmentMcuService {
	private static Logger logger = CjfLogger.getLogger(EquipmentMcuServiceImpl.class.getName());

	@Override
	public EquipmentMcuVO add(EquipmentMcuVO equipmentMcuVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		equipmentMcuVO = EquipmentMcuDAO.add(equipmentMcuVO, null);
		logger.info("serviceImpl	add	end");
		return equipmentMcuVO;
	}

	@Override
	public ArrayList<EquipmentMcuVO> query(EquipmentMcuVO equipmentMcuVO, PageController pageController)
			throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<EquipmentMcuVO> listEquipmentMcu = EquipmentMcuDAO.query(equipmentMcuVO, pageController);
		logger.info("serviceImpl	query	end");
		return listEquipmentMcu;
	}

	@Override
	public EquipmentMcuVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<EquipmentMcuVO> listEquipmentMcu = EquipmentMcuDAO.queryByIDs(id, null);
		if (listEquipmentMcu != null && listEquipmentMcu.size() == 1) {
			logger.info("serviceImpl	end");
			return listEquipmentMcu.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<EquipmentMcuVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<EquipmentMcuVO> listEquipmentMcu = EquipmentMcuDAO.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listEquipmentMcu;
	}

	@Override
	public EquipmentMcuVO modify(EquipmentMcuVO equipmentMcuVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		equipmentMcuVO = EquipmentMcuDAO.modify(equipmentMcuVO, null);
		logger.info("serviceImpl	modify	end");
		return equipmentMcuVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = EquipmentMcuDAO.deleteByID(id, null);
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
		int num = EquipmentMcuDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}
	@Override
	public ArrayList<EquipmentMcuVO> queryByIPs(String ips) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<EquipmentMcuVO> listEquipmentMcu = EquipmentMcuDAO.queryByIPs(ips, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listEquipmentMcu;
	}
	/**
	 * @author John.Zhang
	 */
	@Override
	public ArrayList<EquipmentMcuVO> queryByMeetingID(String id) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<EquipmentMcuVO> listEquipmentMcu = EquipmentMcuDAO.queryByMeetingID(id, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listEquipmentMcu;
	}
	
	@Override
	public EquipmentMcuVO queryByMCUID(String id) throws Exception {
		logger.info("serviceImpl	queryByMCUID	begin");
		ArrayList<EquipmentMcuVO> listEquipmentMcu = EquipmentMcuDAO.queryByMCUID(id, null);
		if (listEquipmentMcu != null && listEquipmentMcu.size() == 1) {
			logger.info("serviceImpl	queryByMCUID end");
			return listEquipmentMcu.get(0);
		}
		logger.info("serviceImpl	queryByMCUID	end");
		return null;
	}

}
