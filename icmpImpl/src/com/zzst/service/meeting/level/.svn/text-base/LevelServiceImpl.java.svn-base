package com.zzst.service.meeting.level;

import java.util.ArrayList;
import java.util.List;

import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.level.LevelDAO;
import com.zzst.model.meeting.level.LevelVO;

import org.apache.log4j.Logger;

/**
 * class description: LevelGrade ServiceImpl
 * 
 * @date Thu Nov 14 10:43:30 CST 2013
 * @author ryan
 */
public class LevelServiceImpl implements LevelService {
	private static Logger logger = CjfLogger.getLogger(LevelServiceImpl.class
			.getName());

	@Override
	public LevelVO add(LevelVO levelGradeVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		levelGradeVO = LevelDAO.add(levelGradeVO, null);
		logger.info("serviceImpl	add	end");
		return levelGradeVO;
	}

	@Override
	public ArrayList<LevelVO> query(LevelVO levelGradeVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<LevelVO> listLevelGrade = LevelDAO.query(levelGradeVO,
				pageController);
		logger.info("serviceImpl	query	end");
		return listLevelGrade;
	}
	@Override
	public ArrayList<LevelVO> queryByPid(LevelVO levelGradeVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	queryByPid	begin");
		ArrayList<LevelVO> listLevelGrade = LevelDAO.queryByPid(levelGradeVO,
				pageController);
		logger.info("serviceImpl	queryByPid	end");
		return listLevelGrade;
	}

	@Override
	public LevelVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<LevelVO> listLevelGrade = LevelDAO.queryByIDs(id, null);
		if (listLevelGrade != null && listLevelGrade.size() == 1) {
			logger.info("serviceImpl	end");
			return listLevelGrade.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<LevelVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<LevelVO> listLevelGrade = LevelDAO.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listLevelGrade;
	}

	@Override
	public LevelVO modify(LevelVO levelGradeVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		levelGradeVO = LevelDAO.modify(levelGradeVO, null);
		logger.info("serviceImpl	modify	end");
		return levelGradeVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = LevelDAO.deleteByID(id, null);
		if (num == 1) {
			logger.info("serviceImpl	deleteByID	end");
			return true;
		} else {
			logger.info("serviceImpl	deleteByID	end");
			return false;
		}
	}

	@Override
	public boolean deleteByPID(String id) throws Exception {
		logger.info("serviceImpl	deleteByPID	begin");
		int num = LevelDAO.deleteByPID(id, null);
		if (num == 1) {
			logger.info("serviceImpl	deleteByPID	end");
			return true;
		} else {
			logger.info("serviceImpl	deleteByPID	end");
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

	// 判断是否为叶子节点
	public boolean ishaveChild(String levelId) throws Exception {
		return LevelDAO.ishaveChild(levelId);
	}

	// 获得当前节点的所有子节点
	public ArrayList<LevelVO> getallChild(String id) throws Exception {
		ArrayList<LevelVO> LevelGradeVO_ = (ArrayList<LevelVO>) LevelDAO
				.getChildrenById(id);
		return LevelGradeVO_;
	}

	@Override
	public List<LevelVO> queryInLevelPath(String levelid) throws Exception {
		// TODO Auto-generated method stub
		
		return LevelDAO.queryForLevelPath(levelid);
	}
	
	public ArrayList<LevelVO> ishaveChildOne(LevelVO levelGradeVO,
			PageController pageController) throws Exception{
		logger.info("serviceImpl	ishaveChildOne	begin");
		ArrayList<LevelVO> listLevelGrade = LevelDAO.queryByPid(levelGradeVO,
				pageController);
		logger.info("serviceImpl	ishaveChildOne	end");
		return listLevelGrade;
	}

}
