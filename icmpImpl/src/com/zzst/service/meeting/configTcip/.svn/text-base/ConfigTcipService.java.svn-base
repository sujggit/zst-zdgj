package com.zzst.service.meeting.configTcip;

import java.sql.SQLException;
import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.model.meeting.configTcip.ConfigTcipVO;

/**
 * class description: ConfigTcip Service
 * 
 * @date Mon Nov 11 14:59:54 CST 2013
 * @author ryan
 */
public interface ConfigTcipService {

	/**
	 * method description : add ConfigTcipVO object
	 * 
	 * @param ConfigTcipVO
	 * @return ConfigTcipVO
	 * @throws Exception
	 */
	public ConfigTcipVO add(ConfigTcipVO configTcipVO) throws Exception;

	/**
	 * method description : query ConfigTcip list
	 * 
	 * @param ConfigTcipVO
	 * @param PageController
	 * @return ArrayList<ConfigTcipVO>
	 * @throws Exception
	 */
	public ArrayList<ConfigTcipVO> query(ConfigTcipVO configTcipVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query ConfigTcipVO by id
	 * 
	 * @param id
	 * @return ConfigTcipVO
	 * @throws Exception
	 */
	public ConfigTcipVO queryByID(String id) throws Exception;

	/**
	 * method description : query ConfigTcipVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return ConfigTcipVO
	 * @throws Exception
	 */
	public ArrayList<ConfigTcipVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify ConfigTcipVO by id
	 * 
	 * @param ConfigTcipVO
	 * @return ConfigTcipVO
	 * @throws Exception
	 */
	public ConfigTcipVO modify(ConfigTcipVO configTcipVO) throws Exception;

	/**
	 * method description : delete ConfigTcipVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(int id) throws Exception;

	/**
	 * method description : delete ConfigTcipVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
//	public void deleteByIDs(String id) throws Exception;
}
