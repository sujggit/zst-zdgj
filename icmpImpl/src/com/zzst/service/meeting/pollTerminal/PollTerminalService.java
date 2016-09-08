package com.zzst.service.meeting.pollTerminal;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.pollTerminal.PollTerminalVO;

/**
 * class description: PollTerminal Service
 * 
 * @date Thu May 16 15:21:34 CST 2013
 * @author ryan
 */
public interface PollTerminalService {

	/**
	 * method description : add PollTerminalVO object
	 * 
	 * @param PollTerminalVO
	 * @return PollTerminalVO
	 * @throws Exception
	 */
	public PollTerminalVO add(PollTerminalVO pollTerminalVO) throws Exception;

	/**
	 * method description : query PollTerminal list
	 * 
	 * @param PollTerminalVO
	 * @param PageController
	 * @return ArrayList<PollTerminalVO>
	 * @throws Exception
	 */
	public ArrayList<PollTerminalVO> query(PollTerminalVO pollTerminalVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query PollTerminalVO by id
	 * 
	 * @param id
	 * @return PollTerminalVO
	 * @throws Exception
	 */
	public PollTerminalVO queryByID(String id) throws Exception;

	/**
	 * method description : query PollTerminalVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return PollTerminalVO
	 * @throws Exception
	 */
	public ArrayList<PollTerminalVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify PollTerminalVO by id
	 * 
	 * @param PollTerminalVO
	 * @return PollTerminalVO
	 * @throws Exception
	 */
	public PollTerminalVO modify(PollTerminalVO pollTerminalVO)
			throws Exception;

	/**
	 * method description : delete PollTerminalVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete PollTerminalVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
	
	public ArrayList<PollTerminalVO> queryWithEquipment(PollTerminalVO pollTerminalVO,PageController pageController) throws Exception;
	
	public ArrayList<PollTerminalVO> queryTerminal(PollTerminalVO pollTerminalVO,PageController pageController) throws Exception;
	
	public boolean deleteByVO( PollTerminalVO pollTerminalVO ) throws Exception ;
}
