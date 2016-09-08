package com.zzst.service.meeting.kst;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.kst.WallPresetVO;

/**
 * class description: WallPreset Service
 * 
 * @date Mon Jul 30 14:19:01 CST 2012
 * @author ryan
 */
public interface WallPresetService {

	/**
	 * method description : add WallPresetVO object
	 * 
	 * @param WallPresetVO
	 * @return WallPresetVO
	 * @throws Exception
	 */
	public WallPresetVO add(WallPresetVO wallPresetVO) throws Exception;

	/**
	 * method description : query WallPreset list
	 * 
	 * @param WallPresetVO
	 * @param PageController
	 * @return ArrayList<WallPresetVO>
	 * @throws Exception
	 */
	public ArrayList<WallPresetVO> query(WallPresetVO wallPresetVO, PageController pageController) throws Exception;

	/**
	 * method description : query WallPresetVO by id
	 * 
	 * @param id
	 * @return WallPresetVO
	 * @throws Exception
	 */
	public WallPresetVO queryByID(String id) throws Exception;

	/**
	 * method description : query WallPresetVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return WallPresetVO
	 * @throws Exception
	 */
	public ArrayList<WallPresetVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify WallPresetVO by id
	 * 
	 * @param WallPresetVO
	 * @return WallPresetVO
	 * @throws Exception
	 */
	public WallPresetVO modify(WallPresetVO wallPresetVO) throws Exception;

	/**
	 * method description : delete WallPresetVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;
	
	/**
	 * method description : delete WallPresetVO all
	 * 
	 * @return boolean
	 * @throws Exception
	 */
	public int deleteAll() throws Exception;

	/**
	 * method description : delete WallPresetVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
}
