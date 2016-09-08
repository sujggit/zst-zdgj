package com.zzst.service.meeting.userPost;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.model.meeting.userPost.UserPostVO;

/**
 * class description: UserPost Service
 * 
 * @date Sun Jun 30 12:58:57 CST 2013
 * @author ryan
 */
public interface UserPostService {

	/**
	 * method description : add UserPostVO object
	 * 
	 * @param UserPostVO
	 * @return UserPostVO
	 * @throws Exception
	 */
	public UserPostVO add(UserPostVO userPostVO) throws Exception;

	/**
	 * method description : query UserPost list
	 * 
	 * @param UserPostVO
	 * @param PageController
	 * @return ArrayList<UserPostVO>
	 * @throws Exception
	 */
	public ArrayList<UserPostVO> query(UserPostVO userPostVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query UserPostVO by id
	 * 
	 * @param id
	 * @return UserPostVO
	 * @throws Exception
	 */
	public UserPostVO queryByID(String id) throws Exception;

	/**
	 * method description : query UserPostVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return UserPostVO
	 * @throws Exception
	 */
	public ArrayList<UserPostVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify UserPostVO by id
	 * 
	 * @param UserPostVO
	 * @return UserPostVO
	 * @throws Exception
	 */
	public UserPostVO modify(UserPostVO userPostVO) throws Exception;

	/**
	 * method description : delete UserPostVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete UserPostVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public void deleteByIDs(String id) throws Exception;
}
