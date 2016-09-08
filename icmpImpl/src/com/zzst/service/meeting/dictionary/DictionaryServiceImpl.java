package com.zzst.service.meeting.dictionary;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.dictionary.DictionaryDAO;
import com.zzst.model.meeting.dictionary.DictionaryVO;

/**
 * class description: Dictionary ServiceImpl
 * 
 * @date Tue Feb 19 17:00:51 CST 2013
 * @author ryan
 */
public class DictionaryServiceImpl implements DictionaryService {
	private static Logger logger = CjfLogger
			.getLogger(DictionaryServiceImpl.class.getName());

	@Override
	public DictionaryVO add(DictionaryVO dictionaryVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		dictionaryVO = DictionaryDAO.add(dictionaryVO, null);
		logger.info("serviceImpl	add	end");
		return dictionaryVO;
	}

	@Override
	public ArrayList<DictionaryVO> query(DictionaryVO dictionaryVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<DictionaryVO> listDictionary = DictionaryDAO.query(
				dictionaryVO, pageController);
		logger.info("serviceImpl	query	end");
		return listDictionary;
	}

	@Override
	public DictionaryVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<DictionaryVO> listDictionary = DictionaryDAO.queryByIDs(id,
				null);
		if (listDictionary != null && listDictionary.size() == 1) {
			logger.info("serviceImpl	end");
			return listDictionary.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<DictionaryVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<DictionaryVO> listDictionary = DictionaryDAO.queryByIDs(ids,
				null);
		logger.info("serviceImpl	queryByIDs	end");
		return listDictionary;
	}

	@Override
	public DictionaryVO modify(DictionaryVO dictionaryVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		dictionaryVO = DictionaryDAO.modify(dictionaryVO, null);
		logger.info("serviceImpl	modify	end");
		return dictionaryVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = DictionaryDAO.deleteByID(id, null);
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
		int num = DictionaryDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

	@Override
	public DictionaryVO modifyDicValue(DictionaryVO dictionaryVO) throws Exception {
		logger.info("serviceImpl	modifyDicValue	begin");
		dictionaryVO = DictionaryDAO.modifyDicValue(dictionaryVO, null);
		logger.info("serviceImpl	modifyDicValue	end");
		return dictionaryVO;
	}

	@Override
	public boolean deleteByVO(DictionaryVO dictionaryVO) throws Exception {
		logger.info("serviceImpl	deleteByVO	begin");
		int num = DictionaryDAO.deleteByVO(dictionaryVO);
		if (num >= 0) {
			logger.info("DictionaryServiceImpl	deleteByVO	end");
			return true;
		} else {
			logger.info("DictionaryServiceImpl	deleteByVO	end");
			return false;
		}
	}
	

}
