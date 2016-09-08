package com.zzst.service.meeting.levelConfig;

import java.util.ArrayList;
import java.util.List;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.levelConfig.LevelConfigDAO;
import com.zzst.model.meeting.levelConfig.LevelConfigVO;

import org.apache.log4j.Logger;

/**
 * class description: LevelConfig ServiceImpl
 * 
 * @date Mon Nov 18 11:28:49 CST 2013
 * @author ryan
 */
public class LevelConfigServiceImpl implements LevelConfigService {
	private static Logger logger = CjfLogger
			.getLogger(LevelConfigServiceImpl.class.getName());

	@Override
	public LevelConfigVO add(LevelConfigVO levelConfigVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		levelConfigVO = LevelConfigDAO.add(levelConfigVO, null);
		logger.info("serviceImpl	add	end");
		return levelConfigVO;
	} 

	@Override
	public ArrayList<LevelConfigVO> query(LevelConfigVO levelConfigVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<LevelConfigVO> listLevelConfig = LevelConfigDAO.query(
				levelConfigVO, pageController);
		logger.info("serviceImpl	query	end");
		return listLevelConfig;
	}

	@Override
	public LevelConfigVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<LevelConfigVO> listLevelConfig = LevelConfigDAO.queryByIDs(
				id, null);
		if (listLevelConfig != null && listLevelConfig.size() == 1) {
			logger.info("serviceImpl	end");
			return listLevelConfig.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<LevelConfigVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<LevelConfigVO> listLevelConfig = LevelConfigDAO.queryByIDs(
				ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listLevelConfig;
	}

	@Override
	public LevelConfigVO modify(LevelConfigVO levelConfigVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		levelConfigVO = LevelConfigDAO.modify(levelConfigVO, null);
		logger.info("serviceImpl	modify	end");
		return levelConfigVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = LevelConfigDAO.deleteByID(id, null);
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

	@Override
	public List<LevelConfigVO> queryWithType(LevelConfigVO levelConfigVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	queryWithType	begin");
		ArrayList<LevelConfigVO> listLevelConfig = LevelConfigDAO.queryWithType(
				levelConfigVO, pageController);
		logger.info("serviceImpl	queryWithType	end");
		return listLevelConfig;
	}

	
	/**
	 * @author zhangjy
	 * 查到levelType类型的授权记录
	 */
	@Override
	public String queryByTypeAndLid(String lids,String levelType) throws Exception {
		logger.info("serviceImpl	queryByTypeAndLid	begin");
		String str="'zzstworldradc',";
		List<LevelConfigVO> lcvList=LevelConfigDAO.queryTypeAndLids(lids,levelType);
		for(LevelConfigVO lcv:lcvList){
			str+="'"+lcv.getLevelKey()+"',";
		}
		
		str=str.substring(0,str.length()-1);
		return str;
	}

	
	@Override
	public boolean delLevelVO(LevelConfigVO levelConfigVO,
			TransactionManager tManager) throws Exception {
		logger.info("serviceImpl	delLevelVO	begin");
		if(1==LevelConfigDAO.delLevelVO(levelConfigVO, tManager)){
			return true;
		}
		logger.info("serviceImpl	delLevelVO	end");
		return false;
	}

}
