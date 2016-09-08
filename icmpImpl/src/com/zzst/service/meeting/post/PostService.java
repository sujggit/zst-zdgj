package com.zzst.service.meeting.post;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.model.meeting.post.PostVO;

/**
 * class description: Post Service
 * 
 * @date Fri Jun 28 15:38:38 CST 2013
 * @author ryan
 */
public interface PostService {

	/**
	 * method description : add PostVO object
	 * 
	 * @param PostVO
	 * @return PostVO
	 * @throws Exception
	 */
	public PostVO add(PostVO postVO) throws Exception;

	/**
	 * method description : query Post list
	 * 
	 * @param PostVO
	 * @param PageController
	 * @return ArrayList<PostVO>
	 * @throws Exception
	 */
	public ArrayList<PostVO> query(PostVO postVO, PageController pageController)
			throws Exception;

	/**
	 * method description : query PostVO by id
	 * 
	 * @param id
	 * @return PostVO
	 * @throws Exception
	 */
	public PostVO queryByID(String id) throws Exception;

	/**
	 * method description : query PostVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return PostVO
	 * @throws Exception
	 */
	public ArrayList<PostVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify PostVO by id
	 * 
	 * @param PostVO
	 * @return PostVO
	 * @throws Exception
	 */
	public PostVO modify(PostVO postVO) throws Exception;

	/**
	 * method description : delete PostVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete PostVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public void deleteByIDs(String id) throws Exception;
}
