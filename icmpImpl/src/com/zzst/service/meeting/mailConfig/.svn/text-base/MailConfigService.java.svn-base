package com.zzst.service.meeting.mailConfig;

import java.sql.SQLException;
import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.model.meeting.mailConfig.MailConfigVO;

/**
 * class description: MailConfig Service
 * 
 * @date Mon Nov 11 14:59:57 CST 2013
 * @author ryan
 */
public interface MailConfigService {

	/**
	 * method description : add MailConfigVO object
	 * 
	 * @param MailConfigVO
	 * @return MailConfigVO
	 * @throws Exception
	 */
	public MailConfigVO add(MailConfigVO mailConfigVO) throws Exception;

	/**
	 * method description : query MailConfig list
	 * 
	 * @param MailConfigVO
	 * @param PageController
	 * @return ArrayList<MailConfigVO>
	 * @throws Exception
	 */
	public ArrayList<MailConfigVO> query(MailConfigVO mailConfigVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query MailConfigVO by id
	 * 
	 * @param id
	 * @return MailConfigVO
	 * @throws Exception
	 */
	public MailConfigVO queryByID(String id) throws Exception;

	/**
	 * method description : query MailConfigVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return MailConfigVO
	 * @throws Exception
	 */
	public ArrayList<MailConfigVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify MailConfigVO by id
	 * 
	 * @param MailConfigVO
	 * @return MailConfigVO
	 * @throws Exception
	 */
	public MailConfigVO modify(MailConfigVO mailConfigVO) throws Exception;

	/**
	 * method description : delete MailConfigVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(int id) throws Exception;

	/**
	 * method description : delete MailConfigVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
//	public void deleteByIDs(String id) throws Exception;
}
