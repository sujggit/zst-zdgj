package com.zzst.dao.meeting.messageContent;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.gsiec.cjf.util.CjfSequenceUtil;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.messageContent.MessageContentVO;

import org.apache.log4j.Logger;

/**
 * class description: MessageContent DAO
 * 
 * @date Thu May 09 09:33:18 CST 2013
 * @author ryan
 */
public class MessageContentDAO {
	private static Logger logger = CjfLogger.getLogger(MessageContentDAO.class
			.getName());

	private static final String id = "Id";

	/**
	 * add MessageContentVO object
	 * 
	 * @param MessageContentVO
	 * @param TransactionManager
	 * @return MessageContentVO
	 * @throws Exception
	 */
	public static MessageContentVO add(MessageContentVO messageContentVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		messageContentVO.setId(UtilDAO.getUUid());
		MessageContentTO messageContentTO = new MessageContentTO(
				MessageContentTO.ADD_MESSAGECONTENT, messageContentVO);

		messageContentTO.setSqlStr();
		logger.info("sqlStr	:	" + messageContentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(messageContentTO, true);
		} else {
			TransactionTemplate.executeTransaction(messageContentTO, tManager);
		}
		logger.info("DAO	add	end");
		return messageContentVO;
	}

	/**
	 * query MessageContentVO list
	 * 
	 * @param MessageContentVO
	 * @param PageController
	 * @return ArrayList<MessageContentVO>
	 * @throws Exception
	 */
	public static ArrayList<MessageContentVO> query(
			MessageContentVO messageContentVO, PageController pageController)
			throws Exception {
		logger.info("DAO	query	begin");
		MessageContentMQB messageContentMQB = new MessageContentMQB(
				MessageContentMQB.QUERY_FROM_MESSAGECONTENT, messageContentVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + messageContentMQB.getSql());
		QueryTemplate.executeQueryForList(messageContentMQB, pageController);
		logger.info("list size	:	"
				+ messageContentMQB.getMessageContentList().size());
		logger.info("DAO	query	end");
		return messageContentMQB.getMessageContentList();
	}
	
	
	public static ArrayList<MessageContentVO> queryTwo(
			String messageContentVO, PageController pageController)
			throws Exception {
		logger.info("DAO	queryTwo	begin");
		String ids=messageContentVO;
		MessageContentMQB messageContentMQB = new MessageContentMQB(
				MessageContentMQB.QUERY_FROM_MESSAGECONTENT_THREE, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		
		logger.info("sqlStr	:	" + messageContentMQB.getSql());
		QueryTemplate.executeQueryForList(messageContentMQB, pageController);
		logger.info("list size	:	"
				+ messageContentMQB.getMessageContentList().size());
		logger.info("DAO	queryTwo	end");
		return messageContentMQB.getMessageContentList();
	}

	/**
	 * query MessageContentVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<MessageContentVO>
	 * @throws Exception
	 */
	public static ArrayList<MessageContentVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		MessageContentMQB messageContentMQB = new MessageContentMQB(
				MessageContentMQB.QUERY_FROM_MESSAGECONTENT_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + messageContentMQB.getSql());
		QueryTemplate.executeQueryForList(messageContentMQB, pageController);
		logger.info("list size	:	"
				+ messageContentMQB.getMessageContentList().size());
		logger.info("DAO	queryByIDs	end");
		return messageContentMQB.getMessageContentList();
	}

	/**
	 * modify MessageContentVO column by ID
	 * 
	 * @param MessageContentVO
	 * @param TransactionManager
	 * @return MessageContentVO
	 * @throws Exception
	 */
	public static MessageContentVO modify(MessageContentVO messageContentVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		MessageContentTO messageContentTO = new MessageContentTO(
				MessageContentTO.MODIFY_MESSAGECONTENT, messageContentVO);
		messageContentTO.setSqlStr();
		logger.info("sqlStr	:	" + messageContentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(messageContentTO, true);
		} else {
			TransactionTemplate.executeTransaction(messageContentTO, tManager);
		}
		logger.info("DAO	modify	end");
		return messageContentVO;
	}

	/**
	 * delete MessageContentVO by id
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return MessageContentVO
	 * @throws Exception
	 */
	public static int deleteByID(String id, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		MessageContentVO messageContentVO = new MessageContentVO();
		messageContentVO.setId(id);
		MessageContentTO messageContentTO = new MessageContentTO(
				MessageContentTO.DEL_MESSAGECONTENT, messageContentVO);

		messageContentTO.setSqlStr();
		logger.info("sqlStr	:	" + messageContentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(messageContentTO, true);
		} else {
			TransactionTemplate.executeTransaction(messageContentTO, tManager);
		}
		logger.info("result	:	" + messageContentTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return messageContentTO.getexecuteResult();
	}
}
    