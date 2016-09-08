package com.zzst.service.meeting.equipment;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.equipment.EquipmentBackupDAO;
import com.zzst.model.meeting.equipment.EquipmentBackupVO;

/**
 * class description: EquipmentBackup ServiceImpl
 * 
 * @date Tue Jan 22 19:50:35 CST 2013
 * @author ryan
 */
public class EquipmentBackupServiceImpl implements EquipmentBackupService {
	private static Logger logger = CjfLogger
			.getLogger(EquipmentBackupServiceImpl.class.getName());

	@Override
	public EquipmentBackupVO add(EquipmentBackupVO equipmentBackupVO)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		equipmentBackupVO = EquipmentBackupDAO.add(equipmentBackupVO, null);
		logger.info("serviceImpl	add	end");
		return equipmentBackupVO;
	}

	@Override
	public ArrayList<EquipmentBackupVO> query(
			EquipmentBackupVO equipmentBackupVO, PageController pageController)
			throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<EquipmentBackupVO> listEquipmentBackup = EquipmentBackupDAO
				.query(equipmentBackupVO, pageController);
		logger.info("serviceImpl	query	end");
		return listEquipmentBackup;
	}
	@Override
	public ArrayList<EquipmentBackupVO> queryByMeetingID(String meetingID)
			throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<EquipmentBackupVO> listEquipmentBackup = EquipmentBackupDAO.queryByMeetingID(meetingID);
		logger.info("serviceImpl	query	end");
		return listEquipmentBackup;
	}

	@Override
	public EquipmentBackupVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<EquipmentBackupVO> listEquipmentBackup = EquipmentBackupDAO
				.queryByIDs(id, null);
		if (listEquipmentBackup != null && listEquipmentBackup.size() == 1) {
			logger.info("serviceImpl	end");
			return listEquipmentBackup.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<EquipmentBackupVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<EquipmentBackupVO> listEquipmentBackup = EquipmentBackupDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listEquipmentBackup;
	}

	@Override
	public EquipmentBackupVO modify(EquipmentBackupVO equipmentBackupVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		equipmentBackupVO = EquipmentBackupDAO.modify(equipmentBackupVO, null);
		logger.info("serviceImpl	modify	end");
		return equipmentBackupVO;
	}

	@Override
	public boolean deleteByID(String id, String bakcupId) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = EquipmentBackupDAO.deleteByID(id, bakcupId, null);
		if (num == 1) {
			logger.info("serviceImpl	deleteByID	end");
			return true;
		} else {
			logger.info("serviceImpl	deleteByID	end");
			return false;
		}
	}

	

	public static void main(String args[]) throws Exception {
		// DBConnection.setDbInfo("jdbc:oracle:thin:@10.1.3.182:1521:cinda",
		// "cinda", "cinda");
		DBConnection.setDbInfo("jdbc:mysql://10.1.8.7:3306/icmp?characterEncoding=gb2312",
				"root", "myroot");
		ArrayList<EquipmentBackupVO> listEquipmentBackup = EquipmentBackupDAO.queryByMeetingID("8a81889a40a9ddb70140a9f70ff60008");
		EquipmentBackupVO eb = new EquipmentBackupVO();
		//ArrayList<EquipmentBackupVO> listEquipmentBackup = EquipmentBackupDAO.query(null,null);
	    System.out.println(listEquipmentBackup.size());
		
		
	}

}
