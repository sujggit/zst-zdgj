package com.zzst.service.meeting.authorization;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.authorization.AuthorizationVO;

/**
 * class description: Authorization Service
 * 
 * @date Tue May 28 11:26:12 CST 2013
 * @author ryan
 */
public interface AuthorizationService {

	/**
	 * method description : add AuthorizationVO object
	 * 
	 * @param AuthorizationVO
	 * @return AuthorizationVO
	 * @throws Exception
	 */
	public AuthorizationVO add(AuthorizationVO authorizationVO)
			throws Exception;

	/**
	 * method description : query Authorization list
	 * 
	 * @param AuthorizationVO
	 * @param PageController
	 * @return ArrayList<AuthorizationVO>
	 * @throws Exception
	 */
	public ArrayList<AuthorizationVO> query(AuthorizationVO authorizationVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query AuthorizationVO by id
	 * 
	 * @param id
	 * @return AuthorizationVO
	 * @throws Exception
	 */
	public AuthorizationVO queryByID(String id) throws Exception;

	/**
	 * method description : query AuthorizationVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return AuthorizationVO
	 * @throws Exception
	 */
	public ArrayList<AuthorizationVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify AuthorizationVO by id
	 * 
	 * @param AuthorizationVO
	 * @return AuthorizationVO
	 * @throws Exception
	 */
	public AuthorizationVO modify(AuthorizationVO authorizationVO)
			throws Exception;

	/**
	 * method description : delete AuthorizationVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete AuthorizationVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public void deleteByIDs(String id) throws Exception;
}
