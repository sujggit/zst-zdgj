package com.zzst.service.meeting.messageContent;

import java.util.ArrayList;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.messageContent.MessageContentDAO;
import com.zzst.model.meeting.messageContent.MessageContentVO;
import com.zzst.model.meeting.user.UserVO;

import org.apache.log4j.Logger;

/**
 * class description: MessageContent ServiceImpl
 * 
 * @date Thu May 09 09:33:18 CST 2013
 * @author ryan
 */
public class MessageContentServiceImpl implements MessageContentService {
	private static Logger logger = CjfLogger
			.getLogger(MessageContentServiceImpl.class.getName());

	@Override
	public MessageContentVO add(MessageContentVO messageContentVO)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		messageContentVO = MessageContentDAO.add(messageContentVO, null);
		logger.info("serviceImpl	add	end");
		return messageContentVO;
	}

	@Override
	public ArrayList<MessageContentVO> query(MessageContentVO messageContentVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<MessageContentVO> listMessageContent = MessageContentDAO
				.query(messageContentVO, pageController);
		logger.info("serviceImpl	query	end");
		return listMessageContent;
	}
	
	@Override
	public ArrayList<MessageContentVO> queryTwo(UserVO sessionUserVO,MessageContentVO messageContentquery,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	queryTwo	begin");
		
		
		String sqls=" and messageType='99' and (ifSuccess>0 or (ifSuccess=0 and flowIdCont='"+sessionUserVO.getUserID()+"')) ";
		if(messageContentquery.getMessageSubject()!=null&&!(messageContentquery.getMessageSubject().equals(""))){
			sqls+=" and messageSubject like '%"+messageContentquery.getMessageSubject()+"%' ";
		}
		
		if(messageContentquery.getInsertTime()!=null){
			sqls+=" and insertTime>='"+messageContentquery.getInsertTime()+"' ";
		}
		if(messageContentquery.getSendTime()!=null){
			sqls+=" and insertTime<='"+messageContentquery.getSendTime()+"' ";
		}
		
//		if(messageContentquery.getInsertTime()!=null&&messageContentquery.getSendTime()!=null){
//			
//			sqls+=" and insertTime>='"+messageContentquery.getInsertTime()+"' and insertTime<='"+messageContentquery.getSendTime()+"' ";
//		}
		if(messageContentquery.getFlowIdCont()!=null&&!(messageContentquery.getFlowIdCont().equals(""))){
			sqls+=" and flowIdCont='"+messageContentquery.getFlowIdCont()+"'";
		}
		
		sqls+=" order by insertTime desc ";
		ArrayList<MessageContentVO> listMessageContent = MessageContentDAO.queryTwo(sqls, pageController);
		logger.info("serviceImpl	queryTwo	end");
		return listMessageContent;
	}

	@Override
	public MessageContentVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<MessageContentVO> listMessageContent = MessageContentDAO
				.queryByIDs(id, null);
		if (listMessageContent != null && listMessageContent.size() == 1) {
			logger.info("serviceImpl	end");
			return listMessageContent.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<MessageContentVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<MessageContentVO> listMessageContent = MessageContentDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listMessageContent;
	}

	@Override
	public MessageContentVO modify(MessageContentVO messageContentVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		messageContentVO = MessageContentDAO.modify(messageContentVO, null);
		logger.info("serviceImpl	modify	end");
		return messageContentVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = MessageContentDAO.deleteByID(id, null);
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

	public static void main(String args[]) throws Exception {
		// DBConnection.setDbInfo("jdbc:oracle:thin:@10.1.3.182:1521:cinda",
		// "cinda", "cinda");
		DBConnection.setDbInfo("jdbc:mysql://10.1.8.7:3306/icmp?characterEncoding=gb2312","root", "123456");
		MessageContentVO vMessageContentVO = new MessageContentVO();
		vMessageContentVO.setId("id");
		vMessageContentVO.setMessageSubject("messageSubject");
		vMessageContentVO.setMessageBody("messageBody");
		vMessageContentVO.setMessageAdress("messageAdress");
		vMessageContentVO.setIfSuccess(8);
		vMessageContentVO.setComment("comment");
		vMessageContentVO.setMessageType(1);
		vMessageContentVO.setFlowIdCont("flowIdCont");
		vMessageContentVO.setFlowType("flowType");

		new MessageContentServiceImpl().add(vMessageContentVO);
		System.out.println("=========add Success!");

		ArrayList<MessageContentVO> lstMessageContent = new MessageContentServiceImpl()
				.query(vMessageContentVO, null);

		if (lstMessageContent.size() > 0) {
			System.out.println("=========query Result:");
			MessageContentVO vvMessageContentVO = (MessageContentVO) lstMessageContent
					.get(0);
			System.out.println("id=" + vvMessageContentVO.getId());
			System.out.println("messageSubject="
					+ vvMessageContentVO.getMessageSubject());
			System.out.println("messageBody="
					+ vvMessageContentVO.getMessageBody());
			System.out.println("messageAdress="
					+ vvMessageContentVO.getMessageAdress());
			System.out
					.println("ifSuccess=" + vvMessageContentVO.getIfSuccess());
			System.out.println("comment=" + vvMessageContentVO.getComment());
			System.out.println("sendTime=" + vvMessageContentVO.getSendTime());
			System.out.println("insertTime="
					+ vvMessageContentVO.getInsertTime());
			System.out.println("messageType="
					+ vvMessageContentVO.getMessageType());
			System.out.println("flowIdCont="
					+ vvMessageContentVO.getFlowIdCont());
			System.out.println("flowType=" + vvMessageContentVO.getFlowType());
			System.out.println("nextClearTime="
					+ vvMessageContentVO.getNextClearTime());

		} else {
			System.out
					.println("=========query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
		}

	}

}
