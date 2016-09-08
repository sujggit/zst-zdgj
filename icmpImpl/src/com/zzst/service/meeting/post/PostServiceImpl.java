package com.zzst.service.meeting.post;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.post.PostDAO;
import com.zzst.model.meeting.post.PostVO;

import org.apache.log4j.Logger;

/**
 * class description: Post ServiceImpl
 * 
 * @date Fri Jun 28 15:38:38 CST 2013
 * @author ryan
 */
public class PostServiceImpl implements PostService {
	private static Logger logger = CjfLogger.getLogger(PostServiceImpl.class
			.getName());

	@Override
	public PostVO add(PostVO postVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		postVO = PostDAO.add(postVO, null);
		logger.info("serviceImpl	add	end");
		return postVO;
	}

	@Override
	public ArrayList<PostVO> query(PostVO postVO, PageController pageController)
			throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<PostVO> listPost = PostDAO.query(postVO, pageController);
		logger.info("serviceImpl	query	end");
		return listPost;
	}

	@Override
	public PostVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<PostVO> listPost = PostDAO.queryByIDs(id, null);
		if (listPost != null && listPost.size() == 1) {
			logger.info("serviceImpl	end");
			return listPost.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<PostVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<PostVO> listPost = PostDAO.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listPost;
	}

	@Override
	public PostVO modify(PostVO postVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		postVO = PostDAO.modify(postVO, null);
		logger.info("serviceImpl	modify	end");
		return postVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = PostDAO.deleteByID(id, null);
		if (num == 1) {
			logger.info("serviceImpl	deleteByID	end");
			return true;
		} else {
			logger.info("serviceImpl	deleteByID	end");
			return false;
		}
	}

	@Override
	public void deleteByIDs(String ids) throws Exception {
		logger.info("serviceImpl	deleteByIDs	begin");
		if (ids != null && ids.length() > 0) {
			String[] id = ids.split(",");
			for (int i = id.length; i >= 0; i--) {
				deleteByID(id[i]);
			}
		}
		logger.info("serviceImpl	deleteByIDs	end");
	}

}
