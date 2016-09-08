package com.zzst.service.meeting.pollTemplate;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.model.meeting.pollTemplate.PollTemplateVO;

/**
 * class description: PollTemplate Service
 * 
 * @date Thu May 16 15:21:34 CST 2013
 * @author ryan
 */
public interface PollTemplateService {

	/**
	 * method description : add PollTemplateVO object
	 * 
	 * @param PollTemplateVO
	 * @return PollTemplateVO
	 * @throws Exception
	 */
	public PollTemplateVO add(PollTemplateVO pollTemplateVO) throws Exception;

	/**
	 * method description : query PollTemplate list
	 * 
	 * @param PollTemplateVO
	 * @param PageController
	 * @return ArrayList<PollTemplateVO>
	 * @throws Exception
	 */
	public ArrayList<PollTemplateVO> query(PollTemplateVO pollTemplateVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query PollTemplateVO by id
	 * 
	 * @param id
	 * @return PollTemplateVO
	 * @throws Exception
	 */
	public PollTemplateVO queryByID(String id) throws Exception;

	/**
	 * method description : query PollTemplateVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return PollTemplateVO
	 * @throws Exception
	 */
	public ArrayList<PollTemplateVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify PollTemplateVO by id
	 * 
	 * @param PollTemplateVO
	 * @return PollTemplateVO
	 * @throws Exception
	 */
	public PollTemplateVO modify(PollTemplateVO pollTemplateVO)
			throws Exception;

	/**
	 * method description : delete PollTemplateVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete PollTemplateVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
}
