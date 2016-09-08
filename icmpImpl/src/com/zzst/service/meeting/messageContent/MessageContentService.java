package com.zzst.service.meeting.messageContent;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.model.meeting.messageContent.MessageContentVO;
import com.zzst.model.meeting.user.UserVO;

/**
 * class description: MessageContent Service
 * 
 * @date Thu May 09 09:33:18 CST 2013
 * @author ryan
 */
public interface MessageContentService {

	/**
	 * method description : add MessageContentVO object
	 * 
	 * @param MessageContentVO
	 * @return MessageContentVO
	 * @throws Exception
	 */
	public MessageContentVO add(MessageContentVO messageContentVO)
			throws Exception;

	/**
	 * method description : query MessageContent list
	 * 
	 * @param MessageContentVO
	 * @param PageController
	 * @return ArrayList<MessageContentVO>
	 * @throws Exception
	 */
	public ArrayList<MessageContentVO> query(MessageContentVO messageContentVO,
			PageController pageController) throws Exception;
	public ArrayList<MessageContentVO> queryTwo(UserVO uv,MessageContentVO messageContentVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query MessageContentVO by id
	 * 
	 * @param id
	 * @return MessageContentVO
	 * @throws Exception
	 */
	public MessageContentVO queryByID(String id) throws Exception;

	/**
	 * method description : query MessageContentVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return MessageContentVO
	 * @throws Exception
	 */
	public ArrayList<MessageContentVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify MessageContentVO by id
	 * 
	 * @param MessageContentVO
	 * @return MessageContentVO
	 * @throws Exception
	 */
	public MessageContentVO modify(MessageContentVO messageContentVO)
			throws Exception;

	/**
	 * method description : delete MessageContentVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete MessageContentVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public void deleteByIDs(String id) throws Exception;
}
