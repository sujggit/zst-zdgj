package com.zzst.service.meeting.mailConfig;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.mailConfig.MailConfigDAO;
import com.zzst.model.meeting.mailConfig.MailConfigVO;

import org.apache.log4j.Logger;

/**
 * class description: MailConfig ServiceImpl
 * 
 * @date Mon Nov 11 14:59:57 CST 2013
 * @author ryan
 */
public class MailConfigServiceImpl implements MailConfigService {
	private static Logger logger = CjfLogger
			.getLogger(MailConfigServiceImpl.class.getName());

	@Override
	public MailConfigVO add(MailConfigVO mailConfigVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		mailConfigVO = MailConfigDAO.add(mailConfigVO, null);
		logger.info("serviceImpl	add	end");
		return mailConfigVO;
	}

	@Override
	public ArrayList<MailConfigVO> query(MailConfigVO mailConfigVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<MailConfigVO> listMailConfig = MailConfigDAO.query(
				mailConfigVO, pageController);
		logger.info("serviceImpl	query	end");
		return listMailConfig;
	}

	@Override
	public MailConfigVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<MailConfigVO> listMailConfig = MailConfigDAO.queryByIDs(id,
				null);
		if (listMailConfig != null && listMailConfig.size() == 1) {
			logger.info("serviceImpl	end");
			return listMailConfig.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<MailConfigVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<MailConfigVO> listMailConfig = MailConfigDAO.queryByIDs(ids,
				null);
		logger.info("serviceImpl	queryByIDs	end");
		return listMailConfig;
	}

	@Override
	public MailConfigVO modify(MailConfigVO mailConfigVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		mailConfigVO = MailConfigDAO.modify(mailConfigVO, null);
		logger.info("serviceImpl	modify	end");
		return mailConfigVO;
	}

	@Override
	public boolean deleteByID(int id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = MailConfigDAO.deleteByID(id, null);
		if (num == 1) {
			logger.info("serviceImpl	deleteByID	end");
			return true;
		} else {
			logger.info("serviceImpl	deleteByID	end");
			return false;
		}
	}

//	@Override
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
