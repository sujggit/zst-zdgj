package com.zzst.service.project.avic.applySysInsert;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.project.avic.applySysInsert.ApplySysInsertDAO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.project.avic.applySysInsert.ApplySysInsertVO;

/**
 * class description: ApplySysInsert ServiceImpl
 * 
 * @date Fri Sep 21 17:34:16 CST 2012
 * @author ryan
 */
public class ApplySysInsertServiceImpl implements ApplySysInsertService {
	private static Logger logger = CjfLogger
			.getLogger(ApplySysInsertServiceImpl.class.getName());

	@Override
	public ApplySysInsertVO add(ApplySysInsertVO applySysInsertVO)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		applySysInsertVO = ApplySysInsertDAO.add(applySysInsertVO, null);
		logger.info("serviceImpl	add	end");
		return applySysInsertVO;
	}

	@Override
	public ArrayList<ApplySysInsertVO> query(ApplySysInsertVO applySysInsertVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<ApplySysInsertVO> listApplySysInsert = ApplySysInsertDAO
				.query(applySysInsertVO, pageController);
		logger.info("serviceImpl	query	end");
		return listApplySysInsert;
	}

	@Override
	public ApplySysInsertVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<ApplySysInsertVO> listApplySysInsert = ApplySysInsertDAO
				.queryByIDs(id, null);
		if (listApplySysInsert != null && listApplySysInsert.size() == 1) {
			logger.info("serviceImpl	end");
			return listApplySysInsert.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<ApplySysInsertVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<ApplySysInsertVO> listApplySysInsert = ApplySysInsertDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listApplySysInsert;
	}

	@Override
	public ApplySysInsertVO modify(ApplySysInsertVO applySysInsertVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		applySysInsertVO = ApplySysInsertDAO.modify(applySysInsertVO, null);
		logger.info("serviceImpl	modify	end");
		return applySysInsertVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = ApplySysInsertDAO.deleteByID(id, null);
		if (num == 1) {
			logger.info("serviceImpl	deleteByID	end");
			return true;
		} else {
			logger.info("serviceImpl	deleteByID	end");
			return false;
		}
	}

	@Override
	public int deleteByIDs(String ids) throws Exception {
		logger.info("serviceImpl	deleteByIDs	begin");
		int num = ApplySysInsertDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

	@Override
	public ApplySysInsertVO addByUUID(ApplySysInsertVO applySysInsertVO)
			throws Exception {
		logger.info("serviceImpl	addByUUID	begin");
		applySysInsertVO = ApplySysInsertDAO.addByUUID(applySysInsertVO, null);
		logger.info("serviceImpl	addByUUID	end");
		return applySysInsertVO;
	}

	/**
	 * 根据用户登录id查询其接入审批信息
	 * @param ids
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	@Override
	public ArrayList<ApplySysInsertVO> queryApplySysInsert(UserVO userVO,ApplySysInsertVO applySysInsertVO,PageController pageController)
			throws Exception {
		logger.info("serviceImpl queryApplySysInsert	begin");
		ArrayList<ApplySysInsertVO> listApply;
		listApply = ApplySysInsertDAO.queryApplySysInsert(userVO.getUserID(), applySysInsertVO,pageController);
		logger.info("serviceImpl queryApplySysInsert	end");
		return listApply;
	}

	@Override
	public ArrayList<ApplySysInsertVO> queryApplySysInsertHistory(
			UserVO userVO, ApplySysInsertVO applySysInsertVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl queryApplySysInsert	begin");
		ArrayList<ApplySysInsertVO> listApply;
		listApply = ApplySysInsertDAO.queryApplySysInsertHistory(userVO.getUserID(), applySysInsertVO,pageController);
		logger.info("serviceImpl queryApplySysInsert	end");
		return listApply;
	}

	
	@Override
	public ArrayList<ApplySysInsertVO> queryApplySysInsertHistory(
			ApplySysInsertVO applySysInsertVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl queryApplySysInsertHistory	begin");
		ArrayList<ApplySysInsertVO> listApply;
		listApply = ApplySysInsertDAO.queryApplySysInsertHistory(applySysInsertVO,pageController);
		logger.info("serviceImpl queryApplySysInsertHistory	end");
		return listApply;
	}
	
	
	
}
