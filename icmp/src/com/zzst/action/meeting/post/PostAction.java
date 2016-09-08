package com.zzst.action.meeting.post;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cbf.log.CbfLogger;
import com.cbf.web.util.PageSplittor;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.model.enums.PostEnum;
import com.zzst.model.meeting.post.PostVO;

/**
 * ROLE action
 * @author zhangliang
 * Nov 4, 2011 11:24:59 AM
 */
public class PostAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;

	private static Logger logger = CbfLogger.getLogger(PostAction.class.getName());
	
	private PostVO postVO = new PostVO();
	private List<PostVO> postVOList = new ArrayList<PostVO>();
	
	/**
	 * add a Post
	 * @return
	 */
	public String addPost() {
		logger.info("PostAction		addPost		begin");
		try {	
			postVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			postVO.setStatus(PostEnum.STATUS_VALID);
			ServiceFactory.getPostService().add(postVO);
			
			request.setAttribute("info", "已添加一个" + postVO.getPostName() + "角色");
		} catch (Exception e) {
			logger.error(e.getMessage());
			this.request.setAttribute("failure_message","岗位编号必须是唯一不可重复的！");
			return "failure_meeting";//跳转到出错页面
		}
		logger.info("PostAction		addPost		end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * edit a Post
	 * @return
	 */
	public String getPostInfo(){
		logger.info("PostAction		getPostInfo	begin");
		try{
			postVO = ServiceFactory.getPostService().queryByID(postVO.getId());
		}catch(Exception e){
			request.setAttribute("info", "ϵͳ获取岗位信息时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		logger.info("PostAction		getPostInfo	end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * modify a Post
	 * @return
	 */
	public String modifyPost(){
		logger.info("PostAction		modifyPost	begin");
		try{
			ServiceFactory.getPostService().modify(postVO);
		}catch(Exception e){
			request.setAttribute("info", "ϵͳ修改岗位信息时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		
		logger.info("PostAction		modifyPost	end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * list Posts;
	 * @return
	 */
	public String managePostList(){
		logger.info("PostAction		managePostList	begin");
		PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
		try{
			postVOList = ServiceFactory.getPostService().query(postVO,pSplittor.getPControler());
			request.setAttribute("list", postVOList);
		}catch(Exception e){
			request.setAttribute("info", "ϵͳ获取岗位列表时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		
		logger.info("PostAction		managePostList	end");
		return REQUEST_SUCCESS;
	}
	/**
	 * delete Post;
	 * @return String
	 */
	public String delPost(){
		logger.info("PostAction		delPost	begin");
		try{
			//ServiceFactory.getPostService().deleteByID(postVO.getId());
			PostVO vo = ServiceFactory.getPostService().queryByID(postVO.getId());
			vo.setStatus(PostEnum.STATUS_INVALID);
			ServiceFactory.getPostService().modify(vo);
		}catch(Exception e){
			request.setAttribute("info", "ϵͳ删除岗位时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		
		logger.info("PostAction		delPost	end");
		return REQUEST_SUCCESS;
	}

	public PostVO getPostVO() {
		return postVO;
	}

	public void setPostVO(PostVO postVO) {
		this.postVO = postVO;
	}

	public List<PostVO> getPostVOList() {
		return postVOList;
	}

	public void setPostVOList(List<PostVO> postVOList) {
		this.postVOList = postVOList;
	}

}
