package com.zzst.service.meeting.dataInterface.meetingModel;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.dataInterface.meetingModel.InterfaceMeetingModelVO;

/**
 * class description: InterfaceMeetingModel Service
 * 
 * @date Thu May 30 11:03:50 CST 2013
 * @author ryan
 */
public interface InterfaceMeetingModelService {

	/**
	 * method description : add InterfaceMeetingModelVO object
	 * 
	 * @param InterfaceMeetingModelVO
	 * @return InterfaceMeetingModelVO
	 * @throws Exception
	 */
	public InterfaceMeetingModelVO add(InterfaceMeetingModelVO interfaceMeetingModelVO) throws Exception;

	/**
	 * method description : query InterfaceMeetingModel list
	 * 
	 * @param InterfaceMeetingModelVO
	 * @param PageController
	 * @return ArrayList<InterfaceMeetingModelVO>
	 * @throws Exception
	 */
	public ArrayList<InterfaceMeetingModelVO> query(InterfaceMeetingModelVO interfaceMeetingModelVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query InterfaceMeetingModelVO by id
	 * 
	 * @param id
	 * @return InterfaceMeetingModelVO
	 * @throws Exception
	 */
	public InterfaceMeetingModelVO queryByID(String id) throws Exception;

	/**
	 * method description : query InterfaceMeetingModelVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return InterfaceMeetingModelVO
	 * @throws Exception
	 */
	public ArrayList<InterfaceMeetingModelVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify InterfaceMeetingModelVO by id
	 * 
	 * @param InterfaceMeetingModelVO
	 * @return InterfaceMeetingModelVO
	 * @throws Exception
	 */
	public InterfaceMeetingModelVO modify(InterfaceMeetingModelVO interfaceMeetingModelVO) throws Exception;

	/**
	 * method description : delete InterfaceMeetingModelVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete InterfaceMeetingModelVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public void deleteByIDs(String id) throws Exception;
}
