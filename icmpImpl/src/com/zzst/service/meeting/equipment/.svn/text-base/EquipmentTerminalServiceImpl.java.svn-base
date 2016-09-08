package com.zzst.service.meeting.equipment;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.equipment.EquipmentTerminalDAO;
import com.zzst.model.meeting.equipment.EquipmentTerminalVO;

/**
 * class description: EquipmentTerminal ServiceImpl
 * 
 * @date Wed Nov 30 10:22:49 CST 2011
 * @author ryan
 */
public class EquipmentTerminalServiceImpl implements EquipmentTerminalService {
	private static Logger logger = CjfLogger.getLogger(EquipmentTerminalServiceImpl.class.getName());

	@Override
	public EquipmentTerminalVO add(EquipmentTerminalVO equipmentTerminalVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		equipmentTerminalVO = EquipmentTerminalDAO.add(equipmentTerminalVO, null);
		logger.info("serviceImpl	add	end");
		return equipmentTerminalVO;
	}

	@Override
	public ArrayList<EquipmentTerminalVO> query(EquipmentTerminalVO equipmentTerminalVO, PageController pageController)
			throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<EquipmentTerminalVO> listEquipmentTerminal = EquipmentTerminalDAO.query(equipmentTerminalVO,
				pageController);
		logger.info("serviceImpl	query	end");
		return listEquipmentTerminal;
	}

	@Override
	public EquipmentTerminalVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<EquipmentTerminalVO> listEquipmentTerminal = EquipmentTerminalDAO.queryByIDs(id, null);
		if (listEquipmentTerminal != null && listEquipmentTerminal.size() == 1) {
			logger.info("serviceImpl	end");
			return listEquipmentTerminal.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<EquipmentTerminalVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<EquipmentTerminalVO> listEquipmentTerminal = EquipmentTerminalDAO.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listEquipmentTerminal;
	}

	@Override
	public EquipmentTerminalVO modify(EquipmentTerminalVO equipmentTerminalVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		equipmentTerminalVO = EquipmentTerminalDAO.modify(equipmentTerminalVO, null);
		logger.info("serviceImpl	modify	end");
		return equipmentTerminalVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = EquipmentTerminalDAO.deleteByID(id, null);
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
		int num = EquipmentTerminalDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}
	@Override
	public ArrayList<EquipmentTerminalVO> queryByRoomIDs(String ids) throws Exception {
		// TODO Auto-generated method stub
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<EquipmentTerminalVO> listEquipmentTerminal = EquipmentTerminalDAO.queryByRoomIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listEquipmentTerminal;
	}

	@Override
	public ArrayList<EquipmentTerminalVO> queryByIPs(String ips)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<EquipmentTerminalVO> listEquipmentTerminal = EquipmentTerminalDAO.queryByIPs(ips, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listEquipmentTerminal;
	}

	/**
	 * @author John.Zhang
	 */
	@Override
	public ArrayList<EquipmentTerminalVO> queryByMeetingID(String id)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("serviceImpl	queryByMeetingID	begin");
		ArrayList<EquipmentTerminalVO> listEquipmentTerminal = EquipmentTerminalDAO.queryByMeetingDetailId(id, null);
		logger.info("serviceImpl	queryByMeetingID	end");
		return listEquipmentTerminal;
	}

}
