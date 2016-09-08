package com.zzst.service.meeting.log;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.cbfImpl.util.TimeFormatUtil;
import com.zzst.dao.common.UtilDAO;
import com.zzst.dao.meeting.log.LogDAO;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.meeting.log.LogVO;

/**
 * class description: Log ServiceImpl
 * 
 * @date Tue Nov 29 14:55:07 CST 2011
 * @author ryan
 */
public class LogServiceImpl implements LogService {
	private static Logger logger = CjfLogger.getLogger(LogServiceImpl.class.getName());

	@Override
	public LogVO add(LogVO logVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		logVO.setLogID(UtilDAO.getUUid());
		logVO.setOperatorDate(TimeFormatUtil.getTimestamp());
		if(logVO.getLevel()==Integer.MIN_VALUE){
			logVO.setLevel(LogEnum.LEVEL_DeFAULT);	
		}
		
		logVO = LogDAO.add(logVO, null);
		logger.info("serviceImpl	add	end");
		return logVO;
	}

	@Override
	public ArrayList<LogVO> query(LogVO logVO, PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<LogVO> listLog = LogDAO.query(logVO, pageController);
		logger.info("serviceImpl	query	end");
		return listLog;
	}

	@Override
	public LogVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<LogVO> listLog = LogDAO.queryByIDs(id, null);
		if (listLog != null && listLog.size() == 1) {
			logger.info("serviceImpl	end");
			return listLog.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<LogVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<LogVO> listLog = LogDAO.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listLog;
	}

	@Override
	public LogVO modify(LogVO logVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		logVO = LogDAO.modify(logVO, null);
		logger.info("serviceImpl	modify	end");
		return logVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = LogDAO.deleteByID(id, null);
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
		int num = LogDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}
	
	public ArrayList<LogVO> queryInital(LogVO logVO, PageController pageController) throws Exception{
		logger.info("serviceImpl	queryInital	begin");
		ArrayList<LogVO> listLog = LogDAO.queryInital(logVO, pageController);
		logger.info("serviceImpl	queryInital	end");
		return listLog;
	}
}
