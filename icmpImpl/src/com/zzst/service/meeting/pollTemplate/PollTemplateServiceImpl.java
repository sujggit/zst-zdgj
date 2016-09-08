package com.zzst.service.meeting.pollTemplate;

import java.sql.Timestamp;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.pollTemplate.PollTemplateDAO;
import com.zzst.model.meeting.pollTemplate.PollTemplateVO;

/**
 * class description: PollTemplate ServiceImpl
 * 
 * @date Thu May 16 15:21:34 CST 2013
 * @author ryan
 */
public class PollTemplateServiceImpl implements PollTemplateService {
	private static Logger logger = CjfLogger
			.getLogger(PollTemplateServiceImpl.class.getName());

	@Override
	public PollTemplateVO add(PollTemplateVO pollTemplateVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		pollTemplateVO = PollTemplateDAO.add(pollTemplateVO, null);
		logger.info("serviceImpl	add	end");
		return pollTemplateVO;
	}

	@Override
	public ArrayList<PollTemplateVO> query(PollTemplateVO pollTemplateVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<PollTemplateVO> listPollTemplate = PollTemplateDAO.query(
				pollTemplateVO, pageController);
		logger.info("serviceImpl	query	end");
		return listPollTemplate;
	}

	@Override
	public PollTemplateVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<PollTemplateVO> listPollTemplate = PollTemplateDAO
				.queryByIDs(id, null);
		if (listPollTemplate != null && listPollTemplate.size() == 1) {
			logger.info("serviceImpl	end");
			return listPollTemplate.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<PollTemplateVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<PollTemplateVO> listPollTemplate = PollTemplateDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listPollTemplate;
	}

	@Override
	public PollTemplateVO modify(PollTemplateVO pollTemplateVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		pollTemplateVO = PollTemplateDAO.modify(pollTemplateVO, null);
		logger.info("serviceImpl	modify	end");
		return pollTemplateVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = PollTemplateDAO.deleteByID(id, null);
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
		int num = PollTemplateDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

}
