 package com.zzst.service.meeting.templateMeeting;
    

        import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.dao.meeting.templateMeeting.TemplateMeetingDAO;
import com.zzst.model.meeting.templateMeeting.TemplateMeetingVO;
	
 /**	
 * class description: TemplateMeeting Service 
 * @date  Wed Mar 20 17:56:26 CST 2013
 * @author ryan
 */
    public interface TemplateMeetingService {
		 
		/**
		 * method description : add TemplateMeetingVO	object
		 * @param TemplateMeetingVO
		 * @return TemplateMeetingVO
		 * @throws Exception
		 */
		public TemplateMeetingVO add(TemplateMeetingVO templateMeetingVO ) throws Exception;

		/**
		 * method description : query	TemplateMeeting	list
		 * @param TemplateMeetingVO
		 * @param PageController
		 * @return ArrayList<TemplateMeetingVO>
		 * @throws Exception
		 */
		public  ArrayList<TemplateMeetingVO> query(TemplateMeetingVO templateMeetingVO,PageController pageController) throws Exception;

		/**
		 * method description : query	TemplateMeetingVO	by	id
		 * @param id
		 * @return TemplateMeetingVO
		 * @throws Exception
		 */
		public  TemplateMeetingVO queryByID(String id) throws Exception;

		/**
		 * method description : query	TemplateMeetingVO	by	ids
		 * @param String example: 1,2,3,4
		 * @return TemplateMeetingVO
		 * @throws Exception
		 */
		public   ArrayList<TemplateMeetingVO> queryByIDs(String ids) throws Exception;

		/**
		 * method description :modify	TemplateMeetingVO	by id
		 * @param TemplateMeetingVO
		 * @return TemplateMeetingVO
		 * @throws Exception
		 */
		public TemplateMeetingVO modify(TemplateMeetingVO templateMeetingVO )throws Exception;


		/**
		 * method description : delete TemplateMeetingVO by	id
		 * @param String	
		 * @return boolean
		 * @throws Exception
		 */
		public boolean deleteByID(String id )throws Exception;

		/**
		 * method description : delete TemplateMeetingVO by	ids
		 * @param String example: 1,2,3,4
		 * @return int
		 * @throws Exception
		 */
		public int deleteByIDs(String id )throws Exception;
		
		
		/**
		 * 根据templateId删除会议信息
		 * @param templateId
		 * @return
		 * @throws Exception
		 */
		public int deleteByTemplateId(String templateId) throws Exception;
	}

    