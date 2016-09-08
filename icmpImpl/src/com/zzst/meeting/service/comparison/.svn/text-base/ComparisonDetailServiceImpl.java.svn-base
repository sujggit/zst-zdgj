package com.zzst.meeting.service.comparison;


import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.comparison.ComparisonDetailDAO;
import com.zzst.model.meeting.comparison.ComparisonDetailVO;

/**	
 * class description: ComparisonDetail ServiceImpl
 * @date  Sun Apr 28 13:09:54 CST 2013
 * @author ryan
 */
public class ComparisonDetailServiceImpl implements ComparisonDetailService{
	private static Logger logger = CjfLogger.getLogger(ComparisonDetailServiceImpl.class.getName());

	@Override
	public ComparisonDetailVO add(ComparisonDetailVO comparisonDetailVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		comparisonDetailVO=ComparisonDetailDAO.add(comparisonDetailVO, null);
		logger.info("serviceImpl	add	end");
		return comparisonDetailVO;
	}

	@Override
	public  ArrayList<ComparisonDetailVO> query(ComparisonDetailVO comparisonDetailVO,PageController pageController) throws Exception{
		logger.info("serviceImpl	query	begin");
		ArrayList<ComparisonDetailVO> listComparisonDetail = ComparisonDetailDAO.query(comparisonDetailVO,pageController);
		logger.info("serviceImpl	query	end");
		return  listComparisonDetail;
	}

	@Override
	public  ComparisonDetailVO queryByID(String id) throws Exception{
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<ComparisonDetailVO> listComparisonDetail = ComparisonDetailDAO.queryByIDs(id,null);
		if(listComparisonDetail!=null&&listComparisonDetail.size()==1){
			logger.info("serviceImpl	end");
			return listComparisonDetail.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public  ArrayList<ComparisonDetailVO> queryByIDs(String ids) throws Exception{
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<ComparisonDetailVO> listComparisonDetail = ComparisonDetailDAO.queryByIDs(ids,null);
		logger.info("serviceImpl	queryByIDs	end");
		return listComparisonDetail;
	}

	@Override
	public ComparisonDetailVO modify(ComparisonDetailVO comparisonDetailVO )throws Exception{
		logger.info("serviceImpl	modify	begin");
		comparisonDetailVO=ComparisonDetailDAO.modify(comparisonDetailVO,null);
		logger.info("serviceImpl	modify	end");
		return comparisonDetailVO;
	}

	@Override
	public boolean deleteByID(String id )throws Exception{
		logger.info("serviceImpl	deleteByID	begin");
		int num	= ComparisonDetailDAO.deleteByID(id,null);
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
		int num	= ComparisonDetailDAO.deleteByID(ids,null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

	public static void main(String args[]) throws Exception {
		//			DBConnection.setDbInfo("jdbc:oracle:thin:@10.1.3.182:1521:cinda", "cinda", "cinda");
		DBConnection.setDbInfo("jdbc:mysql://10.1.0.10:3306/icmp?characterEncoding=gb2312", "test", "123456");
		ComparisonDetailVO vComparisonDetailVO = new ComparisonDetailVO();
		vComparisonDetailVO.setID("ID");
		vComparisonDetailVO.setR_Pr("R_Pr");
		vComparisonDetailVO.setG_Y("G_Y");
		vComparisonDetailVO.setB_Pb("B_Pb");
		vComparisonDetailVO.setUplinkR_Pr("uplinkR_Pr");
		vComparisonDetailVO.setUplinkG_Y("uplinkG_Y");
		vComparisonDetailVO.setUplinkB_Pb("uplinkB_Pb");
		vComparisonDetailVO.setS_R(8);
		vComparisonDetailVO.setS_R_gap(new Float(1));
		vComparisonDetailVO.setS_R_result(8);
		vComparisonDetailVO.setS_G(8);
		vComparisonDetailVO.setS_G_gap(new Float(1));
		vComparisonDetailVO.setS_G_result(8);
		vComparisonDetailVO.setS_B(8);
		vComparisonDetailVO.setS_B_gap(new Float(1));
		vComparisonDetailVO.setS_B_result(8);
		vComparisonDetailVO.setUplinkS_R(8);
		vComparisonDetailVO.setUplinkS_R_gap(new Float(1));
		vComparisonDetailVO.setUplinkS_R_result(8);
		vComparisonDetailVO.setUplinkS_G(8);
		vComparisonDetailVO.setUplinkS_G_gap(new Float(1));
		vComparisonDetailVO.setUplinkS_G_result(8);
		vComparisonDetailVO.setUplinkS_B(8);
		vComparisonDetailVO.setUplinkS_B_gap(new Float(1));
		vComparisonDetailVO.setUplinkS_B_result(8);
		vComparisonDetailVO.setType(8);
		vComparisonDetailVO.setUpdateUserID("updateUserID");
		vComparisonDetailVO.setStatus(8);
		vComparisonDetailVO.setDescription("description");

		new ComparisonDetailServiceImpl().add(vComparisonDetailVO);
		System.out.println("=========add Success!");

		ArrayList<ComparisonDetailVO> lstComparisonDetail = new ComparisonDetailServiceImpl().query(vComparisonDetailVO,null);


		if(lstComparisonDetail.size()>0){
			System.out.println("=========query Result:");
			ComparisonDetailVO vvComparisonDetailVO = (ComparisonDetailVO) lstComparisonDetail.get(0);
			System.out.println("ID=" + vvComparisonDetailVO.getID());	            	           			        
			System.out.println("R_Pr=" + vvComparisonDetailVO.getR_Pr());	            	           			        
			System.out.println("G_Y=" + vvComparisonDetailVO.getG_Y());	            	           			        
			System.out.println("B_Pb=" + vvComparisonDetailVO.getB_Pb());	            	           			        
			System.out.println("uplinkR_Pr=" + vvComparisonDetailVO.getUplinkR_Pr());	            	           			        
			System.out.println("uplinkG_Y=" + vvComparisonDetailVO.getUplinkG_Y());	            	           			        
			System.out.println("uplinkB_Pb=" + vvComparisonDetailVO.getUplinkB_Pb());	            	           			        
			System.out.println("S_R=" + vvComparisonDetailVO.getS_R());	            	           			        
			System.out.println("S_R_gap=" + vvComparisonDetailVO.getS_R_gap());	            	           			        
			System.out.println("S_R_result=" + vvComparisonDetailVO.getS_R_result());	            	           			        
			System.out.println("S_G=" + vvComparisonDetailVO.getS_G());	            	           			        
			System.out.println("S_G_gap=" + vvComparisonDetailVO.getS_G_gap());	            	           			        
			System.out.println("S_G_result=" + vvComparisonDetailVO.getS_G_result());	            	           			        
			System.out.println("S_B=" + vvComparisonDetailVO.getS_B());	            	           			        
			System.out.println("S_B_gap=" + vvComparisonDetailVO.getS_B_gap());	            	           			        
			System.out.println("S_B_result=" + vvComparisonDetailVO.getS_B_result());	            	           			        
			System.out.println("uplinkS_R=" + vvComparisonDetailVO.getUplinkS_R());	            	           			        
			System.out.println("uplinkS_R_gap=" + vvComparisonDetailVO.getUplinkS_R_gap());	            	           			        
			System.out.println("uplinkS_R_result=" + vvComparisonDetailVO.getUplinkS_R_result());	            	           			        
			System.out.println("uplinkS_G=" + vvComparisonDetailVO.getUplinkS_G());	            	           			        
			System.out.println("uplinkS_G_gap=" + vvComparisonDetailVO.getUplinkS_G_gap());	            	           			        
			System.out.println("uplinkS_G_result=" + vvComparisonDetailVO.getUplinkS_G_result());	            	           			        
			System.out.println("uplinkS_B=" + vvComparisonDetailVO.getUplinkS_B());	            	           			        
			System.out.println("uplinkS_B_gap=" + vvComparisonDetailVO.getUplinkS_B_gap());	            	           			        
			System.out.println("uplinkS_B_result=" + vvComparisonDetailVO.getUplinkS_B_result());	            	           			        
			System.out.println("type=" + vvComparisonDetailVO.getType());	            	           			        
			System.out.println("updateTime=" + vvComparisonDetailVO.getUpdateTime());	            	           			        
			System.out.println("updateUserID=" + vvComparisonDetailVO.getUpdateUserID());	            	           			        
			System.out.println("status=" + vvComparisonDetailVO.getStatus());	            	           			        
			System.out.println("description=" + vvComparisonDetailVO.getDescription());	            	           			        

		}else{
			System.out.println("=========query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
		}

	}

}

