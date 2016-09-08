package com.zzst.service.meeting.dataInterface.terminal;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.model.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceVO;
import com.zzst.model.meeting.dataInterface.terminal.TerminalInterfaceVO;

/**
 * class description: TerminalInterface Service
 * 
 * @date Sat Jun 08 11:18:45 CST 2013
 * @author ryan
 */
public interface TerminalInterfaceService {

	/**
	 * method description : add TerminalInterfaceVO object
	 * 
	 * @param TerminalInterfaceVO
	 * @return TerminalInterfaceVO
	 * @throws Exception
	 */
	public TerminalInterfaceVO add(TerminalInterfaceVO terminalInterfaceVO)
			throws Exception;

	/**
	 * method description : query TerminalInterface list
	 * 
	 * @param TerminalInterfaceVO
	 * @param PageController
	 * @return ArrayList<TerminalInterfaceVO>
	 * @throws Exception
	 */
	public ArrayList<TerminalInterfaceVO> query(
			TerminalInterfaceVO terminalInterfaceVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query TerminalInterfaceVO by id
	 * 
	 * @param id
	 * @return TerminalInterfaceVO
	 * @throws Exception
	 */
	public TerminalInterfaceVO queryByID(String id) throws Exception;

	/**
	 * method description : query TerminalInterfaceVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return TerminalInterfaceVO
	 * @throws Exception
	 */
	public ArrayList<TerminalInterfaceVO> queryByIDs(String ids)
			throws Exception;

	/**
	 * method description :modify TerminalInterfaceVO by id
	 * 
	 * @param TerminalInterfaceVO
	 * @return TerminalInterfaceVO
	 * @throws Exception
	 */
	public TerminalInterfaceVO modify(TerminalInterfaceVO terminalInterfaceVO)
			throws Exception;

	/**
	 * method description : delete TerminalInterfaceVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete TerminalInterfaceVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
	
	public int deleteAll() throws Exception;
	
	public ArrayList<TerminalInterfaceVO> queryAvailable(
			TerminalInterfaceVO terminalInterfaceVO,
			PageController pageController) throws Exception;
}
