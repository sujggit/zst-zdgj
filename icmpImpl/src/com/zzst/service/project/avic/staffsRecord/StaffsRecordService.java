package com.zzst.service.project.avic.staffsRecord;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.project.avic.StaffsRecordVO;

/**
 * class description: StaffsRecord Service
 * 
 * @date Fri Sep 14 18:17:43 CST 2012
 * @author ryan
 */
public interface StaffsRecordService {

	/**
	 * method description : add StaffsRecordVO object
	 * 
	 * @param StaffsRecordVO
	 * @return StaffsRecordVO
	 * @throws Exception
	 */
	public StaffsRecordVO add(StaffsRecordVO staffsRecordVO) throws Exception;

	/**
	 * method description : query StaffsRecord list
	 * 
	 * @param StaffsRecordVO
	 * @param PageController
	 * @return ArrayList<StaffsRecordVO>
	 * @throws Exception
	 */
	public ArrayList<StaffsRecordVO> query(StaffsRecordVO staffsRecordVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query StaffsRecordVO by id
	 * 
	 * @param id
	 * @return StaffsRecordVO
	 * @throws Exception
	 */
	public StaffsRecordVO queryByID(String id) throws Exception;

	/**
	 * method description : query StaffsRecordVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return StaffsRecordVO
	 * @throws Exception
	 */
	public ArrayList<StaffsRecordVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify StaffsRecordVO by id
	 * 
	 * @param StaffsRecordVO
	 * @return StaffsRecordVO
	 * @throws Exception
	 */
	public StaffsRecordVO modify(StaffsRecordVO staffsRecordVO)
			throws Exception;

	/**
	 * method description : delete StaffsRecordVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete StaffsRecordVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
}
