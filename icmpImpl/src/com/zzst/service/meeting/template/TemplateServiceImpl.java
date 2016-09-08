package com.zzst.service.meeting.template;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.template.TemplateDAO;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.meeting.template.TemplateVO;
import com.zzst.service.meeting.levelConfig.LevelConfigServiceImpl;

/**
 * class description: Template ServiceImpl
 * 
 * @date Wed Mar 20 17:56:26 CST 2013
 * @author ryan
 */
public class TemplateServiceImpl implements TemplateService {
	private static Logger logger = CjfLogger
			.getLogger(TemplateServiceImpl.class.getName());

	@Override
	public TemplateVO add(TemplateVO templateVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		Calendar c = Calendar.getInstance();
		templateVO.setCreateTime(new Timestamp(c.getTimeInMillis()));
		templateVO.setUpdateTime(new Timestamp(c.getTimeInMillis()));
		
		templateVO = TemplateDAO.add(templateVO, null);
		logger.info("serviceImpl	add	end");
		return templateVO;
	}

	@Override
	public ArrayList<TemplateVO> query(TemplateVO templateVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
        //////////////////////////分级分权@author:zhangjy///////////////////////
		if(templateVO.isLevel()){
			LevelConfigServiceImpl lcs=new LevelConfigServiceImpl();
			templateVO.setLsql(lcs.queryByTypeAndLid(templateVO.getLsql(), LevelEnum.LEVEL_ROOM));
		}
		////////////////////////////////END////////////////////////////////////////
		ArrayList<TemplateVO> listTemplate = TemplateDAO.query(templateVO,
				pageController);
		logger.info("serviceImpl	query	end");
		return listTemplate;
	}

	@Override
	public TemplateVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<TemplateVO> listTemplate = TemplateDAO.queryByIDs(id, null);
		if (listTemplate != null && listTemplate.size() == 1) {
			logger.info("serviceImpl	end");
			return listTemplate.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<TemplateVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<TemplateVO> listTemplate = TemplateDAO.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listTemplate;
	}

	@Override
	public TemplateVO modify(TemplateVO templateVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		Calendar c = Calendar.getInstance();
		templateVO.setUpdateTime(new Timestamp(c.getTimeInMillis()));
		
		templateVO = TemplateDAO.modify(templateVO, null);
		logger.info("serviceImpl	modify	end");
		return templateVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = TemplateDAO.deleteByID(id, null);
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
		int num = TemplateDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

}
