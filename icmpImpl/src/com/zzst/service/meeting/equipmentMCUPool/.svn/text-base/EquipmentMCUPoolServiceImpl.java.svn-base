package com.zzst.service.meeting.equipmentMCUPool;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.equipmentMCUPool.EquipmentMCUPoolDAO;
import com.zzst.model.meeting.equipmentMCUPool.EquipmentMCUPoolVO;

/**
 * class description: EquipmentMCUPool ServiceImpl
 * 
 * @date Thu Jan 31 09:29:38 CST 2013
 * @author ryan
 */
public class EquipmentMCUPoolServiceImpl implements EquipmentMCUPoolService {
	private static Logger logger = CjfLogger
			.getLogger(EquipmentMCUPoolServiceImpl.class.getName());

	@Override
	public EquipmentMCUPoolVO add(EquipmentMCUPoolVO equipmentMCUPoolVO)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		equipmentMCUPoolVO = EquipmentMCUPoolDAO.add(equipmentMCUPoolVO, null);
		logger.info("serviceImpl	add	end");
		return equipmentMCUPoolVO;
	}

	@Override
	public ArrayList<EquipmentMCUPoolVO> query(
			EquipmentMCUPoolVO equipmentMCUPoolVO, PageController pageController)
			throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<EquipmentMCUPoolVO> listEquipmentMCUPool = EquipmentMCUPoolDAO
				.query(equipmentMCUPoolVO, pageController);
		logger.info("serviceImpl	query	end");
		return listEquipmentMCUPool;
	}

	@Override
	public EquipmentMCUPoolVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<EquipmentMCUPoolVO> listEquipmentMCUPool = EquipmentMCUPoolDAO
				.queryByIDs(id, null);
		if (listEquipmentMCUPool != null && listEquipmentMCUPool.size() == 1) {
			logger.info("serviceImpl	end");
			return listEquipmentMCUPool.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<EquipmentMCUPoolVO> queryByIDs(String ids)
			throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<EquipmentMCUPoolVO> listEquipmentMCUPool = EquipmentMCUPoolDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listEquipmentMCUPool;
	}

	@Override
	public EquipmentMCUPoolVO modify(EquipmentMCUPoolVO equipmentMCUPoolVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		equipmentMCUPoolVO = EquipmentMCUPoolDAO.modify(equipmentMCUPoolVO,
				null);
		logger.info("serviceImpl	modify	end");
		return equipmentMCUPoolVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = EquipmentMCUPoolDAO.deleteByID(id, null);
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
		int num = EquipmentMCUPoolDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}


}
