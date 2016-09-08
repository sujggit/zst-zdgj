package com.zzst.service.meeting.authorization;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.authorization.AuthorizationDAO;
import com.zzst.model.meeting.authorization.AuthorizationVO;

/**
 * class description: Authorization ServiceImpl
 * 
 * @date Tue May 28 11:26:12 CST 2013
 * @author ryan
 */
public class AuthorizationServiceImpl implements AuthorizationService {
	private static Logger logger = CjfLogger
			.getLogger(AuthorizationServiceImpl.class.getName());

	@Override
	public AuthorizationVO add(AuthorizationVO authorizationVO)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		authorizationVO = AuthorizationDAO.add(authorizationVO, null);
		logger.info("serviceImpl	add	end");
		return authorizationVO;
	}

	@Override
	public ArrayList<AuthorizationVO> query(AuthorizationVO authorizationVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<AuthorizationVO> listAuthorization = AuthorizationDAO.query(
				authorizationVO, pageController);
		logger.info("serviceImpl	query	end");
		return listAuthorization;
	}

	@Override
	public AuthorizationVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<AuthorizationVO> listAuthorization = AuthorizationDAO
				.queryByIDs(id, null);
		if (listAuthorization != null && listAuthorization.size() == 1) {
			logger.info("serviceImpl	end");
			return listAuthorization.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<AuthorizationVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<AuthorizationVO> listAuthorization = AuthorizationDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listAuthorization;
	}

	@Override
	public AuthorizationVO modify(AuthorizationVO authorizationVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		authorizationVO = AuthorizationDAO.modify(authorizationVO, null);
		logger.info("serviceImpl	modify	end");
		return authorizationVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = AuthorizationDAO.deleteByID(id, null);
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
