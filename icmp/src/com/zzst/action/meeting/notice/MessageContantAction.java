package com.zzst.action.meeting.notice;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.meeting.dwr.McuDwrMethod;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.messageContent.MessageContentVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.service.meeting.user.UserService;
import com.zzst.service.meeting.user.UserServiceImpl;

public class MessageContantAction extends CjfAction{
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(MessageContantAction.class.getName());
	private ArrayList<MessageContentVO> listMessageContent = new ArrayList<MessageContentVO>();
	private MessageContentVO messageContent;
	private MessageContentVO messageContentquery=new MessageContentVO();
	
	public String queryAll(){
		logger.info("====MessageContantAction start queryAll=======");
		try {
			UserVO sessionUserVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			listMessageContent=ServiceFactory.getMessageContentService().queryTwo(sessionUserVO,messageContentquery, getPageControler());
		    for(int i=0;i<listMessageContent.size();i++){
		    	MessageContentVO tempvo=listMessageContent.get(i);
		    
		    	UserService userService = new UserServiceImpl();
		    	
		    	try {
		    		UserVO tempuvo=new UserVO();
			    	tempuvo.setUserID(tempvo.getFlowIdCont());
			    	UserVO userVO = userService.getUserInfo(tempuvo,null);
			    	if(userVO!=null&&userVO.getName()!=null)
			    		listMessageContent.get(i).setFlowIdCont(userVO.getName());
			    	else
			    		listMessageContent.get(i).setFlowIdCont("");
				} catch (Exception e) {
					listMessageContent.get(i).setFlowIdCont("");
					logger.error(e.getMessage());
				}
		    }
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("====MessageContantAction end queryAll=======");
		return SUCCESS;
	}

    public String addMessageNoticeBefore(){
	
	return SUCCESS;
    }
    
    public String datilMessageNotice(){
    	try {
			messageContent=ServiceFactory.getMessageContentService().queryByID(messageContent.getId());
			
	    	UserService userService = new UserServiceImpl();
	    	UserVO tempuvo=new UserVO();
	    	tempuvo.setUserID(messageContent.getFlowIdCont());
	    	UserVO userVO = userService.getUserInfo(tempuvo,null);
	    	try {
	    		if(userVO!=null&&userVO.getName()!=null)
	    			messageContent.setFlowIdCont(userVO.getName());
		    	else
		    		messageContent.setFlowIdCont("");
	    		
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
    	return SUCCESS;
    	
    }
    
    
    
    public String addMessageNotice(){
    	logger.info("======MessageContantAction addMessageNotice start=========");
    	UserVO sessionUserVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
    	McuDwrMethod mdm=new McuDwrMethod();
    	mdm.addSysLog("添加公告", 2, sessionUserVO, "");
    	MessageContentVO temp=new MessageContentVO();
    	temp.setMessageType(99);
    	temp.setMessageBody(messageContent.getMessageBody());
    	temp.setMessageSubject(messageContent.getMessageSubject());
    	Calendar currentTime = Calendar.getInstance();
    	temp.setInsertTime(new Timestamp(currentTime.getTimeInMillis()));
    	temp.setFlowIdCont(messageContent.getFlowIdCont());
    	temp.setMessageAdress("message");
    	temp.setFlowType("message");
    	temp.setComment("ddd");
    	temp.setIfSuccess(messageContent.getIfSuccess());
    	try {
			ServiceFactory.getMessageContentService().add(temp);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("======MessageContantAction addMessageNotice end =====");
    	return SUCCESS;
        }
    
    
    public String updateMessageNotice(){
    	logger.info("======MessageContantAction updateMessageNotice start=========");
    	MessageContentVO temp=new MessageContentVO();
		try {
			temp = ServiceFactory.getMessageContentService().queryByID(messageContent.getId());
		} catch (Exception e1) {
			logger.error(e1.getMessage());
		};
    	temp.setMessageType(99);
    	temp.setMessageBody(messageContent.getMessageBody());
    	temp.setMessageSubject(messageContent.getMessageSubject());
    	temp.setMessageAdress("message");
    	temp.setFlowType("message");
    	temp.setComment("ddd");
    	temp.setIfSuccess(messageContent.getIfSuccess());
    	temp.setInsertTime(new Timestamp(System.currentTimeMillis()));
    	try {
			ServiceFactory.getMessageContentService().modify(temp);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("======MessageContantAction updateMessageNotice end =====");
    	return SUCCESS;
        }

    public String updateBefore(){
    	
    	try {
			messageContent=ServiceFactory.getMessageContentService().queryByID(messageContent.getId());
			
	    	UserService userService = new UserServiceImpl();
	    	UserVO tempuvo=new UserVO();
	    	tempuvo.setUserID(messageContent.getFlowIdCont());
	    	UserVO userVO = userService.getUserInfo(tempuvo,null);
	    	try {
	    		if(userVO!=null&&userVO.getName()!=null)
	    			messageContent.setFlowIdCont(userVO.getName());
	    		else
	    			messageContent.setFlowIdCont("");
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
    	return SUCCESS;
    }
    
    
    public String delMessageNotice(){
    	logger.info("======MessageContantAction delMessageNotice start=========");
    	try {
			ServiceFactory.getMessageContentService().deleteByID(messageContent.getId());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
    	logger.info("======MessageContantAction delMessageNotice end=========");
    	return SUCCESS;
    }
    
    
    
    
	public ArrayList<MessageContentVO> getListMessageContent() {
		return listMessageContent;
	}



	public void setListMessageContent(ArrayList<MessageContentVO> listMessageContent) {
		this.listMessageContent = listMessageContent;
	}

	public MessageContentVO getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(MessageContentVO messageContent) {
		this.messageContent = messageContent;
	}

	public void setMessageContentquery(MessageContentVO messageContentquery) {
		this.messageContentquery = messageContentquery;
	}

	public MessageContentVO getMessageContentquery() {
		return messageContentquery;
	}
	

   
}
