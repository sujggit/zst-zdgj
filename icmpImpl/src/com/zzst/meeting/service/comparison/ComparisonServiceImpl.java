package com.zzst.meeting.service.comparison;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.comparison.ComparisonDAO;
import com.zzst.model.meeting.comparison.ComparisonVO;

/**	
 * class description: Comparison ServiceImpl
 * @date  Sat Apr 27 13:39:44 CST 2013
 * @author ryan
 */
public class ComparisonServiceImpl implements ComparisonService{
	private static Logger logger = CjfLogger.getLogger(ComparisonServiceImpl.class.getName());

	@Override
	public ComparisonVO add(ComparisonVO comparisonVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		comparisonVO=ComparisonDAO.add(comparisonVO, null);
		logger.info("serviceImpl	add	end");
		return comparisonVO;
	}
	@Override
	public ComparisonVO replace(ComparisonVO comparisonVO,TransactionManager tManager)throws Exception{
		logger.info("serviceImpl	replace	begin");
		comparisonVO=ComparisonDAO.replace(comparisonVO, null);
		logger.info("serviceImpl	replace	end");
		return comparisonVO;
	}
	@Override
	public ComparisonVO replaceAudio(ComparisonVO comparisonVO,TransactionManager tManager)throws Exception{
		logger.info("serviceImpl	replaceAudio	begin");
		comparisonVO=ComparisonDAO.replaceAudio(comparisonVO, null);
		logger.info("serviceImpl	replaceAudio	end");
		return comparisonVO;
	}
	@Override
	public  ArrayList<ComparisonVO> query(ComparisonVO comparisonVO,PageController pageController) throws Exception{
		logger.info("serviceImpl	query	begin");
		ArrayList<ComparisonVO> listComparison = ComparisonDAO.query(comparisonVO,pageController);
		logger.info("serviceImpl	query	end");
		return  listComparison;
	}
	public  ArrayList<ComparisonVO> queryHistory(ComparisonVO comparisonVO,PageController pageController) throws Exception{
		logger.info("serviceImpl	query	begin");
		ArrayList<ComparisonVO> listComparison = ComparisonDAO.queryHistory(comparisonVO, pageController);
		logger.info("serviceImpl	query	end");
		return  listComparison;
	}

	@Override
	public  ComparisonVO queryByID(String id) throws Exception{
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<ComparisonVO> listComparison = ComparisonDAO.queryByIDs(id,null);
		if(listComparison!=null&&listComparison.size()==1){
			logger.info("serviceImpl	end");
			return listComparison.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public  ArrayList<ComparisonVO> queryByIDs(String ids) throws Exception{
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<ComparisonVO> listComparison = ComparisonDAO.queryByIDs(ids,null);
		logger.info("serviceImpl	queryByIDs	end");
		return listComparison;
	}

	@Override
	public ComparisonVO modify(ComparisonVO comparisonVO )throws Exception{
		logger.info("serviceImpl	modify	begin");
		comparisonVO=ComparisonDAO.modify(comparisonVO,null);
		logger.info("serviceImpl	modify	end");
		return comparisonVO;
	}

	@Override
	public boolean deleteByID(String id )throws Exception{
		logger.info("serviceImpl	deleteByID	begin");
		int num	= ComparisonDAO.deleteByID(id,null);
		if(num==1){
			logger.info("serviceImpl	deleteByID	end");
			return true;
		}else{
			logger.info("serviceImpl	deleteByID	end");
			return false;
		}
	}

	@Override
	public int deleteByIDs(String ids )throws Exception{
		logger.info("serviceImpl	deleteByIDs	begin");
		int num	= ComparisonDAO.deleteByID(ids,null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}
	
	public  int deleteByMeetingDetailID(String ids,TransactionManager tManager)throws Exception{
		logger.info("serviceImpl	deleteByMeetingDetailID	begin");
		int num	= ComparisonDAO.deleteByMeetingDetailID(ids,null);
		logger.info("serviceImpl	deleteByMeetingDetailID	end");
		return num;
	}

	public static void main(String args[]) throws Exception {
		//			DBConnection.setDbInfo("jdbc:oracle:thin:@10.1.3.182:1521:cinda", "cinda", "cinda");
		DBConnection.setDbInfo("jdbc:mysql://10.1.0.10:3306/icmp?characterEncoding=gb2312", "test", "123456");
		ComparisonVO vComparisonVO = new ComparisonVO();
		vComparisonVO.setID("ID");
		vComparisonVO.setCompDetailID("compDetailID");
		vComparisonVO.setMeetingDetailID("meetingDetailID");
		vComparisonVO.setMeetingRoomID("meetingRoomID");
		vComparisonVO.setUpVideoQuality(8);
		vComparisonVO.setDownVideoQuality(8);
		vComparisonVO.setUpAudioQuality(8);
		vComparisonVO.setDownAudioQuality(8);
		vComparisonVO.setSendPacketLoss(new Float(1));
		vComparisonVO.setReceivePacketLoss(new Float(1));
		vComparisonVO.setSendframeRate(8);
		vComparisonVO.setReceiveframeRate(8);
		vComparisonVO.setUpdateUserID("updateUserID");
		vComparisonVO.setResult(8);
		vComparisonVO.setStatus(8);
		vComparisonVO.setDescription("description");

		new ComparisonServiceImpl().add(vComparisonVO);
		System.out.println("=========add Success!");

		ArrayList<ComparisonVO> lstComparison = new ComparisonServiceImpl().query(vComparisonVO,null);


		if(lstComparison.size()>0){
			System.out.println("=========query Result:");
			ComparisonVO vvComparisonVO = (ComparisonVO) lstComparison.get(0);
			System.out.println("ID=" + vvComparisonVO.getID());	            	           			        
			System.out.println("compDetailID=" + vvComparisonVO.getCompDetailID());	            	           			        
			System.out.println("meetingDetailID=" + vvComparisonVO.getMeetingDetailID());	            	           			        
			System.out.println("meetingRoomID=" + vvComparisonVO.getMeetingRoomID());	            	           			        
			System.out.println("upVideoQuality=" + vvComparisonVO.getUpVideoQuality());	            	           			        
			System.out.println("downVideoQuality=" + vvComparisonVO.getDownVideoQuality());	            	           			        
			System.out.println("upAudioQuality=" + vvComparisonVO.getUpAudioQuality());	            	           			        
			System.out.println("downAudioQuality=" + vvComparisonVO.getDownAudioQuality());	            	           			        
			System.out.println("sendPacketLoss=" + vvComparisonVO.getSendPacketLoss());	            	           			        
			System.out.println("receivePacketLoss=" + vvComparisonVO.getReceivePacketLoss());	            	           			        
			System.out.println("sendframeRate=" + vvComparisonVO.getSendframeRate());	            	           			        
			System.out.println("receiveframeRate=" + vvComparisonVO.getReceiveframeRate());	            	           			        
			System.out.println("updateTime=" + vvComparisonVO.getUpdateTime());	            	           			        
			System.out.println("updateUserID=" + vvComparisonVO.getUpdateUserID());	            	           			        
			System.out.println("result=" + vvComparisonVO.getResult());	            	           			        
			System.out.println("status=" + vvComparisonVO.getStatus());	            	           			        
			System.out.println("description=" + vvComparisonVO.getDescription());	            	           			        

		}else{
			System.out.println("=========query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
		}

	}

}

