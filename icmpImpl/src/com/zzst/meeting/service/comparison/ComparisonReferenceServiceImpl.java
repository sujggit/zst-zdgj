package com.zzst.meeting.service.comparison;


import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.comparison.ComparisonReferenceDAO;
import com.zzst.model.meeting.comparison.ComparisonReferenceVO;

/**	
 * class description: ComparisonReference ServiceImpl
 * @date  Sat Apr 27 11:12:39 CST 2013
 * @author ryan
 */
public class ComparisonReferenceServiceImpl implements ComparisonReferenceService{
	private static Logger logger = CjfLogger.getLogger(ComparisonReferenceServiceImpl.class.getName());

	@Override
	public ComparisonReferenceVO add(ComparisonReferenceVO comparisonReferenceVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		comparisonReferenceVO=ComparisonReferenceDAO.add(comparisonReferenceVO, null);
		logger.info("serviceImpl	add	end");
		return comparisonReferenceVO;
	}

	@Override
	public  ArrayList<ComparisonReferenceVO> query(ComparisonReferenceVO comparisonReferenceVO,PageController pageController) throws Exception{
		logger.info("serviceImpl	query	begin");
		ArrayList<ComparisonReferenceVO> listComparisonReference = ComparisonReferenceDAO.query(comparisonReferenceVO,pageController);
		logger.info("serviceImpl	query	end");
		return  listComparisonReference;
	}

	@Override
	public  ComparisonReferenceVO queryByID(String id) throws Exception{
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<ComparisonReferenceVO> listComparisonReference = ComparisonReferenceDAO.queryByIDs(id,null);
		if(listComparisonReference!=null&&listComparisonReference.size()==1){
			logger.info("serviceImpl	end");
			return listComparisonReference.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public  ArrayList<ComparisonReferenceVO> queryByIDs(String ids) throws Exception{
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<ComparisonReferenceVO> listComparisonReference = ComparisonReferenceDAO.queryByIDs(ids,null);
		logger.info("serviceImpl	queryByIDs	end");
		return listComparisonReference;
	}

	@Override
	public ComparisonReferenceVO modify(ComparisonReferenceVO comparisonReferenceVO )throws Exception{
		logger.info("serviceImpl	modify	begin");
		comparisonReferenceVO=ComparisonReferenceDAO.modify(comparisonReferenceVO,null);
		logger.info("serviceImpl	modify	end");
		return comparisonReferenceVO;
	}

	@Override
	public boolean deleteByID(String id )throws Exception{
		logger.info("serviceImpl	deleteByID	begin");
		int num	= ComparisonReferenceDAO.deleteByID(id,null);
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
		int num	= ComparisonReferenceDAO.deleteByID(ids,null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

	public static void main(String args[]) throws Exception {
		//			DBConnection.setDbInfo("jdbc:oracle:thin:@10.1.3.182:1521:cinda", "cinda", "cinda");
		DBConnection.setDbInfo("jdbc:mysql://localhost:3306/icmp?characterEncoding=gb2312", "root", "yume");
		ComparisonReferenceVO vComparisonReferenceVO = new ComparisonReferenceVO();
		vComparisonReferenceVO.setID("ID");
		vComparisonReferenceVO.setMeetingRoomID("meetingRoomID");
		vComparisonReferenceVO.setR_Pr("R_Pr");
		vComparisonReferenceVO.setG_Y("G_Y");
		vComparisonReferenceVO.setB_Pb("B_Pb");
		vComparisonReferenceVO.setRIndex(8);
		vComparisonReferenceVO.setGIndex(8);
		vComparisonReferenceVO.setBIndex(8);
		vComparisonReferenceVO.setS_R(8);
		vComparisonReferenceVO.setS_G(8);
		vComparisonReferenceVO.setS_B(8);
		vComparisonReferenceVO.setX_min(8);
		vComparisonReferenceVO.setX_max(8);
		vComparisonReferenceVO.setType(8);
		vComparisonReferenceVO.setUpdateTime(new Timestamp(System.currentTimeMillis())); 
		vComparisonReferenceVO.setUpdateUserID("updateUserID");
		vComparisonReferenceVO.setStatus(8);
		vComparisonReferenceVO.setDescription("description");

		new ComparisonReferenceServiceImpl().add(vComparisonReferenceVO);
		System.out.println("=========add Success!");

		ArrayList<ComparisonReferenceVO> lstComparisonReference = new ComparisonReferenceServiceImpl().query(vComparisonReferenceVO,null);


		if(lstComparisonReference.size()>0){
			System.out.println("=========query Result:");
			ComparisonReferenceVO vvComparisonReferenceVO = (ComparisonReferenceVO) lstComparisonReference.get(0);
			System.out.println("ID=" + vvComparisonReferenceVO.getID());	            	           			        
			System.out.println("meetingRoomID=" + vvComparisonReferenceVO.getMeetingRoomID());	            	           			        
			System.out.println("R_Pr=" + vvComparisonReferenceVO.getR_Pr());	            	           			        
			System.out.println("G_Y=" + vvComparisonReferenceVO.getG_Y());	            	           			        
			System.out.println("B_Pb=" + vvComparisonReferenceVO.getB_Pb());	            	           			        
			System.out.println("rIndex=" + vvComparisonReferenceVO.getRIndex());	            	           			        
			System.out.println("gIndex=" + vvComparisonReferenceVO.getGIndex());	            	           			        
			System.out.println("bIndex=" + vvComparisonReferenceVO.getBIndex());	            	           			        
			System.out.println("S_R=" + vvComparisonReferenceVO.getS_R());	            	           			        
			System.out.println("S_G=" + vvComparisonReferenceVO.getS_G());	            	           			        
			System.out.println("S_B=" + vvComparisonReferenceVO.getS_B());	            	           			        
			System.out.println("x_min=" + vvComparisonReferenceVO.getX_min());	            	           			        
			System.out.println("x_max=" + vvComparisonReferenceVO.getX_max());	            	           			        
			System.out.println("type=" + vvComparisonReferenceVO.getType());	            	           			        
			System.out.println("updateTime=" + vvComparisonReferenceVO.getUpdateTime());	            	           			        
			System.out.println("updateUserID=" + vvComparisonReferenceVO.getUpdateUserID());	            	           			        
			System.out.println("status=" + vvComparisonReferenceVO.getStatus());	            	           			        
			System.out.println("description=" + vvComparisonReferenceVO.getDescription());	            	           			        

		}else{
			System.out.println("=========query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
		}

	}

}

