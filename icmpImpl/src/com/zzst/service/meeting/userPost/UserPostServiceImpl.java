package com.zzst.service.meeting.userPost;

import java.util.ArrayList;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.userPost.UserPostDAO;
import com.zzst.model.meeting.userPost.UserPostVO;

import org.apache.log4j.Logger;

/**
 * class description: UserPost ServiceImpl
 * 
 * @date Sun Jun 30 12:58:57 CST 2013
 * @author ryan
 */
public class UserPostServiceImpl implements UserPostService {
	private static Logger logger = CjfLogger
			.getLogger(UserPostServiceImpl.class.getName());

	@Override
	public UserPostVO add(UserPostVO userPostVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		userPostVO = UserPostDAO.add(userPostVO, null);
		logger.info("serviceImpl	add	end");
		return userPostVO;
	}

	@Override
	public ArrayList<UserPostVO> query(UserPostVO userPostVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<UserPostVO> listUserPost = UserPostDAO.query(userPostVO,
				pageController);
		logger.info("serviceImpl	query	end");
		return listUserPost;
	}

	@Override
	public UserPostVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<UserPostVO> listUserPost = UserPostDAO.queryByIDs(id, null);
		if (listUserPost != null && listUserPost.size() == 1) {
			logger.info("serviceImpl	end");
			return listUserPost.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<UserPostVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<UserPostVO> listUserPost = UserPostDAO.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listUserPost;
	}

	@Override
	public UserPostVO modify(UserPostVO userPostVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		userPostVO = UserPostDAO.modify(userPostVO, null);
		logger.info("serviceImpl	modify	end");
		return userPostVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = UserPostDAO.deleteByID(id, null);
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
