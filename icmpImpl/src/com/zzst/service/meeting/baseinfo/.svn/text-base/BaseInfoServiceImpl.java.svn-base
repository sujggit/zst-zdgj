package com.zzst.service.meeting.baseinfo;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.baseinfo.BaseInfoDAO;
import com.zzst.model.meeting.config.BaseInfoVO;

/**
 * class description: BaseInfo ServiceImpl
 * 
 * @date Fri Jun 15 10:26:01 CST 2012
 * @author ryan
 */
public class BaseInfoServiceImpl implements BaseInfoService {
	private static Logger logger = CjfLogger.getLogger(BaseInfoServiceImpl.class.getName());

	@Override
	public BaseInfoVO add(BaseInfoVO baseInfoVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		baseInfoVO = BaseInfoDAO.add(baseInfoVO, null);
		logger.info("serviceImpl	add	end");
		return baseInfoVO;
	}

	@Override
	public ArrayList<BaseInfoVO> query(BaseInfoVO baseInfoVO, PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<BaseInfoVO> listBaseInfo = BaseInfoDAO.query(baseInfoVO, pageController);
		logger.info("serviceImpl	query	end");
		return listBaseInfo;
	}

	@Override
	public BaseInfoVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<BaseInfoVO> listBaseInfo = BaseInfoDAO.queryByIDs(id, null);
		if (listBaseInfo != null && listBaseInfo.size() == 1) {
			logger.info("serviceImpl	end");
			return listBaseInfo.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<BaseInfoVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<BaseInfoVO> listBaseInfo = BaseInfoDAO.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listBaseInfo;
	}

	@Override
	public BaseInfoVO modify(BaseInfoVO baseInfoVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		baseInfoVO = BaseInfoDAO.modify(baseInfoVO, null);
		logger.info("serviceImpl	modify	end");
		return baseInfoVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = BaseInfoDAO.deleteByID(id, null);
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
		int num = BaseInfoDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

	public boolean delete(BaseInfoVO baseInfoVO) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		ArrayList<BaseInfoVO> list = query(baseInfoVO,null);
		
		if(list!=null&&list.size()>0){
			logger.info(list.size());
			for(BaseInfoVO vo : list){
				BaseInfoDAO.deleteByID(vo.getId(), null);		
			}
		}
		return true;
	}

	@Override
	public ArrayList<BaseInfoVO> queryForKstInit(BaseInfoVO baseInfoVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<BaseInfoVO> listBaseInfo = BaseInfoDAO.queryForKstInit(baseInfoVO, pageController);
		logger.info("serviceImpl	query	end");
		return listBaseInfo;
	}

}
