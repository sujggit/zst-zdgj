package com.zzst.service.meeting.dictionary;

import java.util.ArrayList;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.address.AddressDAO;
import com.zzst.dao.meeting.dictionary.DictionaryEquipmentDAO;
import com.zzst.model.meeting.address.AddressVO;
import com.zzst.model.meeting.dictionary.DictionaryEquipmentVO;

import org.apache.log4j.Logger;

/**
 * class description: DictionaryEquipment ServiceImpl
 * 
 * @date Tue Jan 14 10:15:59 CST 2014
 * @author ryan
 */
public class DictionaryEquipmentServiceImpl implements
		DictionaryEquipmentService {
	private static Logger logger = CjfLogger
			.getLogger(DictionaryEquipmentServiceImpl.class.getName());

	@Override
	public DictionaryEquipmentVO add(DictionaryEquipmentVO dictionaryEquipmentVO)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		dictionaryEquipmentVO = DictionaryEquipmentDAO.add(
				dictionaryEquipmentVO, null);
		logger.info("serviceImpl	add	end");
		return dictionaryEquipmentVO;
	}

	@Override
	public ArrayList<DictionaryEquipmentVO> query(
			DictionaryEquipmentVO dictionaryEquipmentVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<DictionaryEquipmentVO> listDictionaryEquipment = DictionaryEquipmentDAO
				.query(dictionaryEquipmentVO, pageController);
		logger.info("serviceImpl	query	end");
		return listDictionaryEquipment;
	}

	@Override
	public DictionaryEquipmentVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<DictionaryEquipmentVO> listDictionaryEquipment = DictionaryEquipmentDAO
				.queryByIDs(id, null);
		if (listDictionaryEquipment != null
				&& listDictionaryEquipment.size() == 1) {
			logger.info("serviceImpl	end");
			return listDictionaryEquipment.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<DictionaryEquipmentVO> queryByIDs(String ids)
			throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<DictionaryEquipmentVO> listDictionaryEquipment = DictionaryEquipmentDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listDictionaryEquipment;
	}

	@Override
	public DictionaryEquipmentVO modify(
			DictionaryEquipmentVO dictionaryEquipmentVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		dictionaryEquipmentVO = DictionaryEquipmentDAO.modify(
				dictionaryEquipmentVO, null);
		logger.info("serviceImpl	modify	end");
		return dictionaryEquipmentVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = DictionaryEquipmentDAO.deleteByID(id, null);
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
	@Override
	public ArrayList<DictionaryEquipmentVO> queryAllchildrenByID(String id) throws Exception{
		logger.info("queryAllchildrenByID	query	begin");
		ArrayList<DictionaryEquipmentVO> dicList = (ArrayList<DictionaryEquipmentVO>) DictionaryEquipmentDAO.getChildrenById(id);
		logger.info("queryAllchildrenByID	query	end");
		return dicList;
	}
	@Override
	public ArrayList<DictionaryEquipmentVO> queryByPid(DictionaryEquipmentVO dictionaryEquipmentVO,
			PageController pageController) throws Exception{
		logger.info("serviceImpl	queryByPid	begin");
		ArrayList<DictionaryEquipmentVO> listDictionaryEquipment = DictionaryEquipmentDAO.queryByPid(dictionaryEquipmentVO, pageController);
		logger.info("serviceImpl	queryByPid	end");
		return listDictionaryEquipment;
	}

	public ArrayList<DictionaryEquipmentVO> queryByDicValue(int value, PageController pageController) throws Exception {
		logger.info("serviceImpl	queryByDicValue	begin");
		DictionaryEquipmentVO dictionaryEquipmentVO = new DictionaryEquipmentVO();
		dictionaryEquipmentVO.setDicValue(value);
		ArrayList<DictionaryEquipmentVO> listDictionaryEquipment = DictionaryEquipmentDAO.queryByValue(dictionaryEquipmentVO, pageController);
		logger.info("serviceImpl	queryByDicValue	end");
		return listDictionaryEquipment;
	}
	
	@Override
	public ArrayList<DictionaryEquipmentVO> queryByStatusAndSysvalue(
			DictionaryEquipmentVO dictionaryEquipmentVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	queryByStatusAndSysvalue	begin");
		ArrayList<DictionaryEquipmentVO> listDictionaryEquipment = DictionaryEquipmentDAO
				.queryByStatusAndSysvalue(dictionaryEquipmentVO, pageController);
		logger.info("serviceImpl	queryByStatusAndSysvalue	end");
		return listDictionaryEquipment;
	}
}
