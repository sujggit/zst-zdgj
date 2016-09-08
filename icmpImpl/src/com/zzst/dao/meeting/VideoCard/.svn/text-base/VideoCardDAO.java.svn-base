package com.zzst.dao.meeting.VideoCard;


import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.videoCard.VideoCardVO;

/**
 * class description:	VideoCard DAO
 * @date Mon May 13 10:45:05 CST 2013
 * @author ryan
 */
public class VideoCardDAO {
	private static Logger logger = CjfLogger.getLogger(VideoCardDAO.class.getName());

	private static 	final	String	id="EquipmentID";

	/**
	 * add VideoCardVO	object
	 * @param VideoCardVO
	 * @param TransactionManager
	 * @return VideoCardVO
	 * @throws Exception
	 */
	public static VideoCardVO add(VideoCardVO videoCardVO,TransactionManager tManager)throws Exception{
		logger.info("DAO	add	begin");
		//videoCardVO.setEquipmentID(UtilDAO.getUUid());
		VideoCardTO videoCardTO=new VideoCardTO(VideoCardTO.ADD_VIDEOCARD,videoCardVO);

		videoCardTO.setSqlStr();
		logger.info("sqlStr	:	"+videoCardTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(videoCardTO, true);
		}else{
			TransactionTemplate.executeTransaction(videoCardTO, tManager);
		}
		logger.info("DAO	add	end");
		return videoCardVO;
	}



	/**
	 * query VideoCardVO	list
	 * @param VideoCardVO
	 * @param PageController
	 * @return ArrayList<VideoCardVO> 
	 * @throws Exception
	 */
	public static ArrayList<VideoCardVO> query(VideoCardVO videoCardVO,PageController pageController) throws Exception{
		logger.info("DAO	query	begin");
		VideoCardMQB videoCardMQB=new VideoCardMQB(VideoCardMQB.QUERY_FROM_VIDEOCARD,videoCardVO);

		if(pageController==null){
			pageController=new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	"+videoCardMQB.getSql());
		QueryTemplate.executeQueryForList(videoCardMQB, pageController);
		logger.info("list size	:	"+videoCardMQB.getVideoCardList().size());
		logger.info("DAO	query	end");
		return videoCardMQB.getVideoCardList();
	}

	/**
	 * query VideoCardVO	list	by	IDs
	 * @param String
	 * @param PageController
	 * @return ArrayList<VideoCardVO> 
	 * @throws Exception
	 */
	public static ArrayList<VideoCardVO> queryByIDs(String ids,PageController pageController) throws Exception{
		logger.info("DAO	queryByIDs	begin");
		VideoCardMQB videoCardMQB=new VideoCardMQB(VideoCardMQB.QUERY_FROM_VIDEOCARD_BY_IDS,ids);

		if(pageController==null){
			pageController=new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	"+videoCardMQB.getSql());
		QueryTemplate.executeQueryForList(videoCardMQB, pageController);
		logger.info("list size	:	"+videoCardMQB.getVideoCardList().size());
		logger.info("DAO	queryByIDs	end");
		return videoCardMQB.getVideoCardList();
	}

	/**
	 * modify VideoCardVO column by ID
	 * @param VideoCardVO
	 * @param TransactionManager
	 * @return VideoCardVO
	 * @throws Exception
	 */
	public static VideoCardVO modify(VideoCardVO videoCardVO,TransactionManager tManager)throws Exception{
		logger.info("DAO	modify	begin");
		VideoCardTO videoCardTO=new VideoCardTO(VideoCardTO.MODIFY_VIDEOCARD,videoCardVO);		
		videoCardTO.setSqlStr();
		logger.info("sqlStr	:	"+videoCardTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(videoCardTO, true);
		}else{
			TransactionTemplate.executeTransaction(videoCardTO, tManager);
		}
		logger.info("DAO	modify	end");
		return videoCardVO;
	}



	/**
	 * delete	VideoCardVO by ids
	 * @param String
	 * @param TransactionManager
	 * @return VideoCardVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids,TransactionManager tManager)throws Exception{
		logger.info("DAO	deleteByID	begin");
		VideoCardVO videoCardVO = new VideoCardVO();
		videoCardVO.setEquipmentID(ids);
		VideoCardTO videoCardTO=new VideoCardTO(VideoCardTO.DEL_VIDEOCARD,videoCardVO);

		videoCardTO.setSqlStr();
		logger.info("sqlStr	:	"+videoCardTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(videoCardTO, true);
		}else{
			TransactionTemplate.executeTransaction(videoCardTO, tManager);
		}
		logger.info("result	:	"+videoCardTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return videoCardTO.getexecuteResult();
	}
}

