package com.zzst.service.meeting.templateMeeting;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.templateMeeting.TemplateMeetingDAO;
import com.zzst.model.meeting.templateMeeting.TemplateMeetingVO;

/**
 * class description: TemplateMeeting ServiceImpl
 * 
 * @date Wed Mar 20 17:56:26 CST 2013
 * @author ryan
 */
public class TemplateMeetingServiceImpl implements TemplateMeetingService {
	private static Logger logger = CjfLogger
			.getLogger(TemplateMeetingServiceImpl.class.getName());

	@Override
	public TemplateMeetingVO add(TemplateMeetingVO templateMeetingVO)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		Calendar c = Calendar.getInstance();
		templateMeetingVO.setCreateTime(new Timestamp(c.getTimeInMillis()));
		templateMeetingVO.setUpdateTime(new Timestamp(c.getTimeInMillis()));
		
		templateMeetingVO = TemplateMeetingDAO.add(templateMeetingVO, null);
		logger.info("serviceImpl	add	end");
		return templateMeetingVO;
	}

	@Override
	public ArrayList<TemplateMeetingVO> query(
			TemplateMeetingVO templateMeetingVO, PageController pageController)
			throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<TemplateMeetingVO> listTemplateMeeting = TemplateMeetingDAO
				.query(templateMeetingVO, pageController);
		logger.info("serviceImpl	query	end");
		return listTemplateMeeting;
	}

	@Override
	public TemplateMeetingVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<TemplateMeetingVO> listTemplateMeeting = TemplateMeetingDAO
				.queryByIDs(id, null);
		if (listTemplateMeeting != null && listTemplateMeeting.size() == 1) {
			logger.info("serviceImpl	end");
			return listTemplateMeeting.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<TemplateMeetingVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<TemplateMeetingVO> listTemplateMeeting = TemplateMeetingDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listTemplateMeeting;
	}

	@Override
	public TemplateMeetingVO modify(TemplateMeetingVO templateMeetingVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		Calendar c = Calendar.getInstance();
		templateMeetingVO.setUpdateTime(new Timestamp(c.getTimeInMillis()));
		
		templateMeetingVO = TemplateMeetingDAO.modify(templateMeetingVO, null);
		logger.info("serviceImpl	modify	end");
		return templateMeetingVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = TemplateMeetingDAO.deleteByID(id, null);
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
		int num = TemplateMeetingDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}
	
	@Override
	public int deleteByTemplateId(String templateId) throws Exception {
		logger.info("serviceImpl	deleteByTemplateId	begin");
		int num = TemplateMeetingDAO.deleteByTemplateId(templateId, null);
		logger.info("serviceImpl	deleteByTemplateId	end");
		return num;
	}

}
