package com.zzst.action.meeting.schedule;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.model.meeting.scheduleWork.ScheduleWorkVO;
import com.zzst.service.meeting.scheduleWork.ScheduleWorkService;
import com.zzst.service.meeting.scheduleWork.ScheduleWorkServiceImpl;


/**
 *@Description
 *@date 2011-12-14下午07:53:57
 *@author ryan
 */
public class ScheduleWorkAction  extends CjfAction {
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(ScheduleWorkAction.class.getName());
	private ScheduleWorkVO scheduleWorkVO = new ScheduleWorkVO();
	ArrayList<ScheduleWorkVO> scheduleWorkVOList = new ArrayList<ScheduleWorkVO>();
	/**
	 * 查询方法
	 * @return
	 */
	public String query(){
		logger.info("ScheduleWorkAction.query()...begin");
		ScheduleWorkService sws = new ScheduleWorkServiceImpl();
		try {
			//PageController pageController = new PageController();
			scheduleWorkVOList = sws.query(scheduleWorkVO, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("ScheduleWorkAction.query()...end");
		return "success";
	}
	/**
	 * 添加方法
	 * @return
	 */
	public String add(){
		logger.info("ScheduleWorkAction.add()...begin");
		ScheduleWorkService sws = new ScheduleWorkServiceImpl();
		try {
			sws.add(scheduleWorkVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("ScheduleWorkAction.add()...end");
		return "success";
	}
	/**
	 * 删除方法
	 * @return
	 */
	public String delete(){
		logger.info("ScheduleWorkAction.delete()...begin");
		ScheduleWorkService sws = new ScheduleWorkServiceImpl();
		try {
			sws.deleteByID(scheduleWorkVO.getWorkId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("ScheduleWorkAction.delete()...end");
		return "success";
	}
	/**
	 * 查一个
	 * @return
	 */
	public String queryOne(){
		logger.info("ScheduleWorkAction.queryOne()...begin");
		ScheduleWorkService sws = new ScheduleWorkServiceImpl();
		try {
			scheduleWorkVO = sws.queryByID(scheduleWorkVO.getWorkId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("ScheduleWorkAction.queryOne()...end");
		return "success";
	}
	public String modify(){
		logger.info("ScheduleWorkAction.modify()...begin");
		ScheduleWorkService sws = new ScheduleWorkServiceImpl();
		try {
			sws.modify(scheduleWorkVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("ScheduleWorkAction.modify()...end");
		return "success";
	}
	public String modifyBefore(){
		logger.info("ScheduleWorkAction.modifyBefore()...begin");
		ScheduleWorkService sws = new ScheduleWorkServiceImpl();
		try {
			scheduleWorkVO = sws.queryByID(scheduleWorkVO.getWorkId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("ScheduleWorkAction.modifyBefore()...end");
		return "success";
	}
	
	public ScheduleWorkVO getScheduleWorkVO() {
		return scheduleWorkVO;
	}
	public void setScheduleWorkVO(ScheduleWorkVO scheduleWorkVO) {
		this.scheduleWorkVO = scheduleWorkVO;
	}
	public ArrayList<ScheduleWorkVO> getScheduleWorkVOList() {
		return scheduleWorkVOList;
	}
	public void setScheduleWorkVOList(ArrayList<ScheduleWorkVO> scheduleWorkVOList) {
		this.scheduleWorkVOList = scheduleWorkVOList;
	}
	
}
