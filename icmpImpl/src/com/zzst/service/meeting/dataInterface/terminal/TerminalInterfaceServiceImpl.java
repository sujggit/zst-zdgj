package com.zzst.service.meeting.dataInterface.terminal;

import java.sql.Timestamp;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceDAO;
import com.zzst.dao.meeting.dataInterface.terminal.TerminalInterfaceDAO;
import com.zzst.model.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceVO;
import com.zzst.model.meeting.dataInterface.terminal.TerminalInterfaceVO;

/**
 * class description: TerminalInterface ServiceImpl
 * 
 * @date Sat Jun 08 11:18:45 CST 2013
 * @author ryan
 */
public class TerminalInterfaceServiceImpl implements TerminalInterfaceService {
	private static Logger logger = CjfLogger
			.getLogger(TerminalInterfaceServiceImpl.class.getName());

	@Override
	public TerminalInterfaceVO add(TerminalInterfaceVO terminalInterfaceVO)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		terminalInterfaceVO = TerminalInterfaceDAO.add(terminalInterfaceVO,
				null);
		logger.info("serviceImpl	add	end");
		return terminalInterfaceVO;
	}

	@Override
	public ArrayList<TerminalInterfaceVO> query(
			TerminalInterfaceVO terminalInterfaceVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<TerminalInterfaceVO> listTerminalInterface = TerminalInterfaceDAO
				.query(terminalInterfaceVO, pageController);
		logger.info("serviceImpl	query	end");
		return listTerminalInterface;
	}

	@Override
	public TerminalInterfaceVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<TerminalInterfaceVO> listTerminalInterface = TerminalInterfaceDAO
				.queryByIDs(id, null);
		if (listTerminalInterface != null && listTerminalInterface.size() == 1) {
			logger.info("serviceImpl	end");
			return listTerminalInterface.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<TerminalInterfaceVO> queryByIDs(String ids)
			throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<TerminalInterfaceVO> listTerminalInterface = TerminalInterfaceDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listTerminalInterface;
	}

	@Override
	public TerminalInterfaceVO modify(TerminalInterfaceVO terminalInterfaceVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		terminalInterfaceVO = TerminalInterfaceDAO.modify(terminalInterfaceVO,
				null);
		logger.info("serviceImpl	modify	end");
		return terminalInterfaceVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = TerminalInterfaceDAO.deleteByID(id, null);
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
		int num = TerminalInterfaceDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

	@Override
	public int deleteAll() throws Exception {
		logger.info("serviceImpl	deleteAll	begin");
		int num = TerminalInterfaceDAO.deleteAll(null);
		logger.info("serviceImpl	deleteAll	end");
		return num;
	}

	@Override
	public ArrayList<TerminalInterfaceVO> queryAvailable(
			TerminalInterfaceVO terminalInterfaceVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	queryAvailable	begin");
		ArrayList<TerminalInterfaceVO> listTerminalInterface = TerminalInterfaceDAO
				.queryAvailable(terminalInterfaceVO, pageController);
		
		/*LogVO  logVO  = new LogVO();
		logVO.setLogType(LogEnum.TYPE_DEFAULT);
		logVO.setLevel(LogEnum.LEVEL_DeFAULT);
		logVO.setOperatorContent("对 z_interface_in_meetingroom表 进行查询操作");
		new LogServiceImpl().add(logVO);*/
		
		
		logger.info("serviceImpl	queryAvailable	end");
		return listTerminalInterface;// TODO Auto-generated method stub
	}
	
	
}
