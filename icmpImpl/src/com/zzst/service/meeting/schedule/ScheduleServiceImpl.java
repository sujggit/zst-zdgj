



	    	            
         
        	
		
	        
        	
		
        

    
   
    package com.zzst.service.meeting.schedule;
    
	import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.schedule.ScheduleDAO;
import com.zzst.model.meeting.schedule.ScheduleVO;

 /**	
 * class description: Schedule ServiceImpl
 * @date  Mon Aug 29 16:18:14 CST 2016
 * @author ryan
 */
    public class ScheduleServiceImpl implements ScheduleService{
	private static Logger logger = CjfLogger.getLogger(ScheduleServiceImpl.class.getName());

		@Override
		public ScheduleVO add(ScheduleVO scheduleVO) throws Exception {
			logger.info("serviceImpl	add	begin");
			scheduleVO=ScheduleDAO.add(scheduleVO, null);
			logger.info("serviceImpl	add	end");
			return scheduleVO;
		}

		@Override
		public  ArrayList<ScheduleVO> query(ScheduleVO scheduleVO,PageController pageController) throws Exception{
			logger.info("serviceImpl	query	begin");
			ArrayList<ScheduleVO> listSchedule = ScheduleDAO.query(scheduleVO,pageController);
			logger.info("serviceImpl	query	end");
			return  listSchedule;
		}

		@Override
		public  ScheduleVO queryByID(String id) throws Exception{
			logger.info("serviceImpl	queryByID	begin");
			ArrayList<ScheduleVO> listSchedule = ScheduleDAO.queryByIDs(id,null);
			if(listSchedule!=null&&listSchedule.size()==1){
				logger.info("serviceImpl	end");
				return listSchedule.get(0);
			}
			logger.info("serviceImpl	queryByID	end");
			return null;
		}

		@Override
		public  ArrayList<ScheduleVO> queryByIDs(String ids) throws Exception{
			logger.info("serviceImpl	queryByIDs	begin");
			ArrayList<ScheduleVO> listSchedule = ScheduleDAO.queryByIDs(ids,null);
			logger.info("serviceImpl	queryByIDs	end");
			return listSchedule;
		}

		@Override
		public ScheduleVO modify(ScheduleVO scheduleVO )throws Exception{
			logger.info("serviceImpl	modify	begin");
			scheduleVO=ScheduleDAO.modify(scheduleVO,null);
			logger.info("serviceImpl	modify	end");
			return scheduleVO;
		}
		
		@Override
		public boolean deleteByID(String id )throws Exception{
			logger.info("serviceImpl	deleteByID	begin");
			int num	= ScheduleDAO.deleteByID(id,null);
			if(num==1){
				logger.info("serviceImpl	deleteByID	end");
				return true;
			}else{
				logger.info("serviceImpl	deleteByID	end");
				return false;
			}
		}

		@Override
		public void deleteByIDs(String ids )throws Exception{
			logger.info("serviceImpl	deleteByIDs	begin");
		if(ids!=null&&ids.length()>0){
			String[] id = ids.split(",");
			for(int i=id.length;i>=0;i--){
				deleteByID(id[i]);
			}
		}
			logger.info("serviceImpl	deleteByIDs	end");
		}
		@Override
		public ArrayList<ScheduleVO> queryByWeek(String scheduleTime, String status, PageController mPageController) throws Exception {
			logger.info("serviceImpl	queryByWeek	begin");
			ArrayList<ScheduleVO> listSchedule;
			if("".equals(status) || status==null){
				listSchedule = ScheduleDAO.queryByWeek(scheduleTime, mPageController);
			}else{
				listSchedule = ScheduleDAO.queryByWeek(scheduleTime,status, mPageController);
			}
			
			logger.info("serviceImpl	queryByWeek	end");
			return listSchedule;
		}

		public static void main(String args[]) throws Exception {
//			DBConnection.setDbInfo("jdbc:oracle:thin:@10.1.3.182:1521:cinda", "cinda", "cinda");
			DBConnection.setDbInfo("jdbc:mysql://10.1.0.10:3306/icmp?characterEncoding=gb2312", "test", "123456");
			ScheduleVO vScheduleVO = new ScheduleVO();
														vScheduleVO.setScheduleId("scheduleId");
																			vScheduleVO.setScheduleTime("scheduleTime");
																			vScheduleVO.setWeekTime("weekTime");
																			vScheduleVO.setMeetingId("meetingId");
																			vScheduleVO.setWorkId("workId");
																			vScheduleVO.setIsEvent("isEvent");
																			vScheduleVO.setMark("mark");
																			vScheduleVO.setStatus("status");
																			vScheduleVO.setApplyId("applyId");
																			vScheduleVO.setLeaderId("leaderId");
																
			new ScheduleServiceImpl().add(vScheduleVO);
			System.out.println("=========add Success!");

			ArrayList<ScheduleVO> lstSchedule = new ScheduleServiceImpl().query(vScheduleVO,null);
			
			
			if(lstSchedule.size()>0){
				System.out.println("=========query Result:");
				ScheduleVO vvScheduleVO = (ScheduleVO) lstSchedule.get(0);
				            		System.out.println("scheduleId=" + vvScheduleVO.getScheduleId());	            	           			        
				            		System.out.println("scheduleTime=" + vvScheduleVO.getScheduleTime());	            	           			        
				            		System.out.println("weekTime=" + vvScheduleVO.getWeekTime());	            	           			        
				            		System.out.println("meetingId=" + vvScheduleVO.getMeetingId());	            	           			        
				            		System.out.println("workId=" + vvScheduleVO.getWorkId());	            	           			        
				            		System.out.println("isEvent=" + vvScheduleVO.getIsEvent());	            	           			        
				            		System.out.println("mark=" + vvScheduleVO.getMark());	            	           			        
				            		System.out.println("status=" + vvScheduleVO.getStatus());	            	           			        
				            		System.out.println("applyId=" + vvScheduleVO.getApplyId());	            	           			        
				            		System.out.println("leaderId=" + vvScheduleVO.getLeaderId());	            	           			        
				            		System.out.println("createTime=" + vvScheduleVO.getCreateTime());	            	           			        
								
			}else{
				System.out.println("=========query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
			}
		
		}
	}

    