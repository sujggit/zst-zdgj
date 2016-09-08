package com.zzst.service.meeting.pollTerminal;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.pollTerminal.PollTerminalDAO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.pollTerminal.PollTerminalVO;

/**
 * class description: PollTerminal ServiceImpl
 * 
 * @date Thu May 16 15:21:34 CST 2013
 * @author ryan
 */
public class PollTerminalServiceImpl implements PollTerminalService {
	private static Logger logger = CjfLogger
			.getLogger(PollTerminalServiceImpl.class.getName());

	@Override
	public PollTerminalVO add(PollTerminalVO pollTerminalVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		pollTerminalVO = PollTerminalDAO.add(pollTerminalVO, null);
		logger.info("serviceImpl	add	end");
		return pollTerminalVO;
	}

	@Override
	public ArrayList<PollTerminalVO> query(PollTerminalVO pollTerminalVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<PollTerminalVO> listPollTerminal = PollTerminalDAO.query(
				pollTerminalVO, pageController);
		logger.info("serviceImpl	query	end");
		return listPollTerminal;
	}

	@Override
	public PollTerminalVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<PollTerminalVO> listPollTerminal = PollTerminalDAO
				.queryByIDs(id, null);
		if (listPollTerminal != null && listPollTerminal.size() == 1) {
			logger.info("serviceImpl	end");
			return listPollTerminal.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<PollTerminalVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<PollTerminalVO> listPollTerminal = PollTerminalDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listPollTerminal;
	}

	@Override
	public PollTerminalVO modify(PollTerminalVO pollTerminalVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		pollTerminalVO = PollTerminalDAO.modify(pollTerminalVO, null);
		logger.info("serviceImpl	modify	end");
		return pollTerminalVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = PollTerminalDAO.deleteByID(id, null);
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
		int num = PollTerminalDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}
	
	@Override
	public ArrayList<PollTerminalVO> queryWithEquipment(PollTerminalVO pollTerminalVO,PageController pageController) throws Exception{
		logger.info("serviceImpl	queryWithEquipment	begin");
		ArrayList<PollTerminalVO> list = PollTerminalDAO.queryWithEquipment(pollTerminalVO, pageController);
		logger.info("serviceImpl	queryWithEquipment	end");
		return list;
	}

	@Override
	public boolean deleteByVO(PollTerminalVO pollTerminalVO) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = PollTerminalDAO.deleteByVO(pollTerminalVO ,null);
		if (num > 0 ) {
			logger.info("serviceImpl	deleteByID	end");
			return true;
		} else {
			logger.info("serviceImpl	deleteByID	end");
			return false;
		}
	}

	@Override
	public ArrayList<PollTerminalVO> queryTerminal(PollTerminalVO pollTerminalVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	queryTerminal	begin");
		ArrayList<PollTerminalVO> list = PollTerminalDAO.queryTerminal(pollTerminalVO, pageController);
		logger.info("serviceImpl	queryTerminal	end");
		return list;
	}
	
	
	
}
