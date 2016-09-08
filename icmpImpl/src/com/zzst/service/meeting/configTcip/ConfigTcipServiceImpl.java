package com.zzst.service.meeting.configTcip;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.configTcip.ConfigTcipDAO;
import com.zzst.model.meeting.configTcip.ConfigTcipVO;

import org.apache.log4j.Logger;

/**
 * class description: ConfigTcip ServiceImpl
 * 
 * @date Mon Nov 11 14:59:54 CST 2013
 * @author ryan
 */
public class ConfigTcipServiceImpl implements ConfigTcipService {
	private static Logger logger = CjfLogger
			.getLogger(ConfigTcipServiceImpl.class.getName());

	@Override
	public ConfigTcipVO add(ConfigTcipVO configTcipVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		configTcipVO = ConfigTcipDAO.add(configTcipVO, null);
		logger.info("serviceImpl	add	end");
		return configTcipVO;
	}

	@Override
	public ArrayList<ConfigTcipVO> query(ConfigTcipVO configTcipVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<ConfigTcipVO> listConfigTcip = ConfigTcipDAO.query(
				configTcipVO, pageController);
		logger.info("serviceImpl	query	end");
		return listConfigTcip;
	}

	@Override
	public ConfigTcipVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<ConfigTcipVO> listConfigTcip = ConfigTcipDAO.queryByIDs(id,
				null);
		if (listConfigTcip != null && listConfigTcip.size() == 1) {
			logger.info("serviceImpl	end");
			return listConfigTcip.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<ConfigTcipVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<ConfigTcipVO> listConfigTcip = ConfigTcipDAO.queryByIDs(ids,
				null);
		logger.info("serviceImpl	queryByIDs	end");
		return listConfigTcip;
	}

	@Override
	public ConfigTcipVO modify(ConfigTcipVO configTcipVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		configTcipVO = ConfigTcipDAO.modify(configTcipVO, null);
		logger.info("serviceImpl	modify	end");
		return configTcipVO;
	}

	@Override
	public boolean deleteByID(int id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = ConfigTcipDAO.deleteByID(id, null);
		if (num == 1) {
			logger.info("serviceImpl	deleteByID	end");
			return true;
		} else {
			logger.info("serviceImpl	deleteByID	end");
			return false;
		}
	}

//	public void deleteByIDs(String ids) throws Exception {
//		logger.info("serviceImpl	deleteByIDs	begin");
//		if (ids != null && ids.length() > 0) {
//			String[] id = ids.split(",");
//			for (int i = id.length; i >= 0; i--) {
//				deleteByID(id[i]);
//			}
//		}
//		logger.info("serviceImpl	deleteByIDs	end");
//	}


}
