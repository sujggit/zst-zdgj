package com.zzst.service.meeting.equipment.maintain;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.equipment.maintain.EquipmentMaintainDAO;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.meeting.equipment.maintain.EquipmentMaintainVO;
import com.zzst.service.meeting.levelConfig.LevelConfigServiceImpl;

/**
 * class description: EquipmentMaintain ServiceImpl
 * 
 * @date Mon May 06 13:58:37 CST 2013
 * @author ryan
 */
public class EquipmentMaintainServiceImpl implements EquipmentMaintainService {
	private static Logger logger = CjfLogger.getLogger(EquipmentMaintainServiceImpl.class.getName());

	@Override
	public EquipmentMaintainVO add(EquipmentMaintainVO equipmentMaintainVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		equipmentMaintainVO = EquipmentMaintainDAO.add(equipmentMaintainVO, null);
		logger.info("serviceImpl	add	end");
		return equipmentMaintainVO;
	}

	@Override
	public ArrayList<EquipmentMaintainVO> query(EquipmentMaintainVO equipmentMaintainVO, PageController pageController)
			throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<EquipmentMaintainVO> listEquipmentMaintain = EquipmentMaintainDAO.query(equipmentMaintainVO,
				pageController);
		logger.info("serviceImpl	query	end");
		return listEquipmentMaintain;
	}

	@Override
	public EquipmentMaintainVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<EquipmentMaintainVO> listEquipmentMaintain = EquipmentMaintainDAO.queryByIDs(id, null);
		if (listEquipmentMaintain != null && listEquipmentMaintain.size() == 1) {
			logger.info("serviceImpl	end");
			return listEquipmentMaintain.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<EquipmentMaintainVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<EquipmentMaintainVO> listEquipmentMaintain = EquipmentMaintainDAO.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listEquipmentMaintain;
	}

	@Override
	public EquipmentMaintainVO modify(EquipmentMaintainVO equipmentMaintainVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		equipmentMaintainVO = EquipmentMaintainDAO.modify(equipmentMaintainVO, null);
		logger.info("serviceImpl	modify	end");
		return equipmentMaintainVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = EquipmentMaintainDAO.deleteByID(id, null);
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
			for (int i = 0; i <id.length ; i++) {
				deleteByID(id[i]);
			}
		}
		logger.info("serviceImpl	deleteByIDs	end");
	}

	

	@Override
	public ArrayList<EquipmentMaintainVO> queryWhereSQLS(
			EquipmentMaintainVO equipmentMaintainVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	queryWhereSQLS	begin");
		ArrayList<EquipmentMaintainVO> listEquipmentMaintain = EquipmentMaintainDAO.queryWhereSQLS(equipmentMaintainVO,
				pageController);
		logger.info("serviceImpl	queryWhereSQLS	end");
		return listEquipmentMaintain;
	}


	@Override
	public ArrayList<EquipmentMaintainVO> queryEquipmentMaintain(EquipmentMaintainVO equipmentMaintainVO,PageController pageController)
			throws Exception {
		
		logger.info("serviceImpl	queryEquipmentMaintain	begin");
         //////////////////////////分级分权@author:zhangjy///////////////////////
		if(equipmentMaintainVO.isLevel()){
			LevelConfigServiceImpl lcs=new LevelConfigServiceImpl();
			equipmentMaintainVO.setLsql(lcs.queryByTypeAndLid(equipmentMaintainVO.getLsql(), LevelEnum.LEVEL_ROOM));
		}
		////////////////////////////////END////////////////////////////////////////
		ArrayList<EquipmentMaintainVO> listEquipmentMaintain = EquipmentMaintainDAO.queryAll(equipmentMaintainVO,pageController);
		logger.info("serviceImpl	queryEquipmentMaintain	end");
		return listEquipmentMaintain;
	}
	
	@Override
	public ArrayList<EquipmentMaintainVO> queryDetail(EquipmentMaintainVO equipmentMaintainVO,PageController pageController)
			throws Exception {
		
		logger.info("serviceImpl	queryEquipmentMaintain	begin");
		ArrayList<EquipmentMaintainVO> listEquipmentMaintain = EquipmentMaintainDAO.queryDetail(equipmentMaintainVO,pageController);
		logger.info("serviceImpl	queryEquipmentMaintain	end");
		return listEquipmentMaintain;
	}

}
