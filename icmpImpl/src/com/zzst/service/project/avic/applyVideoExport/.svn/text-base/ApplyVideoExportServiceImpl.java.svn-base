package com.zzst.service.project.avic.applyVideoExport;

import java.sql.Timestamp;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.project.avic.applySysInsert.ApplySysInsertDAO;
import com.zzst.dao.project.avic.applyVideoExport.ApplyVideoExportDAO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.project.avic.applySysInsert.ApplySysInsertVO;
import com.zzst.model.project.avic.applyVideoExport.ApplyVideoExportVO;
import com.zzst.service.project.avic.applySysInsert.ApplySysInsertServiceImpl;

/**
 * class description: ApplyVideoExport ServiceImpl
 * 
 * @date Tue Sep 25 16:50:34 CST 2012
 * @author ryan
 */
public class ApplyVideoExportServiceImpl implements ApplyVideoExportService {
	private static Logger logger = CjfLogger
			.getLogger(ApplyVideoExportServiceImpl.class.getName());

	@Override
	public ApplyVideoExportVO add(ApplyVideoExportVO applyVideoExportVO)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		applyVideoExportVO = ApplyVideoExportDAO.add(applyVideoExportVO, null);
		logger.info("serviceImpl	add	end");
		return applyVideoExportVO;
	}

	@Override
	public ArrayList<ApplyVideoExportVO> query(ApplyVideoExportVO applyVideoExportVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<ApplyVideoExportVO> listApplyVideoExport = ApplyVideoExportDAO
				.query(applyVideoExportVO, pageController);
		logger.info("serviceImpl	query	end");
		return listApplyVideoExport;
	}

	@Override
	public ApplyVideoExportVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<ApplyVideoExportVO> listApplyVideoExport = ApplyVideoExportDAO
				.queryByIDs(id, null);
		if (listApplyVideoExport != null && listApplyVideoExport.size() == 1) {
			logger.info("serviceImpl	end");
			return listApplyVideoExport.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<ApplyVideoExportVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<ApplyVideoExportVO> listApplyVideoExport = ApplyVideoExportDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listApplyVideoExport;
	}

	@Override
	public ApplyVideoExportVO modify(ApplyVideoExportVO applyVideoExportVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		applyVideoExportVO = ApplyVideoExportDAO.modify(applyVideoExportVO, null);
		logger.info("serviceImpl	modify	end");
		return applyVideoExportVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = ApplyVideoExportDAO.deleteByID(id, null);
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
		int num = ApplyVideoExportDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

	@Override
	public ApplyVideoExportVO addByUUID(ApplyVideoExportVO applyVideoExportVO)
			throws Exception {
		logger.info("serviceImpl	addByUUID	begin");
		applyVideoExportVO = ApplyVideoExportDAO.addByUUID(applyVideoExportVO, null);
		logger.info("serviceImpl	addByUUID	end");
		return applyVideoExportVO;
	}

	/**
	 * 根据用户登录id查询其接入审批信息
	 * 
	 * @param ids
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	@Override
	public ArrayList<ApplyVideoExportVO> queryApplyVideoExport(UserVO userVO,
			ApplyVideoExportVO applyVideoExportVO, PageController pageController)
			throws Exception {
		logger.info("serviceImpl queryApplyVideoExport	begin");
		ArrayList<ApplyVideoExportVO> listApply;
		listApply = ApplyVideoExportDAO.queryApplyVideoExport(userVO.getUserID(),
				applyVideoExportVO, pageController);
		logger.info("serviceImpl queryApplyVideoExport	end");
		return listApply;
	}

	@Override
	public ArrayList<ApplyVideoExportVO> queryApplyVideoExportHistory(
			UserVO userVO, ApplyVideoExportVO applyVideoExportVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl queryApplyVideoExport	begin");
		ArrayList<ApplyVideoExportVO> listApply;
		listApply = ApplyVideoExportDAO.queryApplyVideoExportHistory(userVO
				.getUserID(), applyVideoExportVO, pageController);
		logger.info("serviceImpl queryApplyVideoExport	end");
		return listApply;
	}
	
	@Override
	public ArrayList<ApplyVideoExportVO> queryApplyVideoExportHistory(
			ApplyVideoExportVO applyVideoExportVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl queryApplyVideoExportHistory	begin");
		ArrayList<ApplyVideoExportVO> listApply;
		listApply = ApplyVideoExportDAO.queryApplyVideoExportHistory( applyVideoExportVO, pageController);
		logger.info("serviceImpl queryApplyVideoExportHistory	end");
		return listApply;
	}

}
