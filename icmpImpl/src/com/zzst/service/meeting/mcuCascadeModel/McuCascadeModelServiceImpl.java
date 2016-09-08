package com.zzst.service.meeting.mcuCascadeModel;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.mcuCascadeModel.McuCascadeModelDAO;
import com.zzst.model.meeting.mcuCascadeModel.McuCascadeModelVO;

/**	
 * class description: McuCascadeModel ServiceImpl
 * @date  Tue Nov 20 10:40:39 CST 2012
 * @author ryan
 */
public class McuCascadeModelServiceImpl implements McuCascadeModelService {
	private static Logger logger = CjfLogger
			.getLogger(McuCascadeModelServiceImpl.class.getName());

	@Override
	public McuCascadeModelVO add(McuCascadeModelVO mcuCascadeModelVO)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		mcuCascadeModelVO = McuCascadeModelDAO.add(mcuCascadeModelVO, null);
		logger.info("serviceImpl	add	end");
		return mcuCascadeModelVO;
	}

	@Override
	public ArrayList<McuCascadeModelVO> query(
			McuCascadeModelVO mcuCascadeModelVO, PageController pageController)
			throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<McuCascadeModelVO> listMcuCascadeModel = McuCascadeModelDAO
				.query(mcuCascadeModelVO, pageController);
		logger.info("serviceImpl	query	end");
		return listMcuCascadeModel;
	}

	@Override
	public ArrayList<McuCascadeModelVO> queryByMCUIP(
			String ip, PageController pageController)
			throws Exception {
		logger.info("serviceImpl	query	begin");
		if(ip ==null ||ip.length()==0)	return null;
		McuCascadeModelVO mcuCascadeModelVO = new McuCascadeModelVO();
		mcuCascadeModelVO.setMcuIp(ip);
		ArrayList<McuCascadeModelVO> listMcuCascadeModel = McuCascadeModelDAO
				.queryByMCUIP(mcuCascadeModelVO, pageController);
		logger.info("serviceImpl	query	end");
		return listMcuCascadeModel;
	}
	
	@Override
	public McuCascadeModelVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<McuCascadeModelVO> listMcuCascadeModel = McuCascadeModelDAO
				.queryByIDs(id, null);
		if (listMcuCascadeModel != null && listMcuCascadeModel.size() == 1) {
			logger.info("serviceImpl	end");
			return listMcuCascadeModel.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<McuCascadeModelVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<McuCascadeModelVO> listMcuCascadeModel = McuCascadeModelDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listMcuCascadeModel;
	}

	@Override
	public McuCascadeModelVO modify(McuCascadeModelVO mcuCascadeModelVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		mcuCascadeModelVO = McuCascadeModelDAO.modify(mcuCascadeModelVO, null);
		logger.info("serviceImpl	modify	end");
		return mcuCascadeModelVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = McuCascadeModelDAO.deleteByID(id, null);
		if (num == 1) {
			logger.info("serviceImpl	deleteByID	end");
			return true;
		} else {
			logger.info("serviceImpl	deleteByID	end");
			return false;
		}
	}

	@Override
	public boolean deleteByMcuIP(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = McuCascadeModelDAO.deleteByID(id, null);
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
		int num = McuCascadeModelDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}
}
