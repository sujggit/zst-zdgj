



	    	            
         
        	
		
	        
        	
		
        

    
   
    package com.zzst.service.mobileInfo;
    
	import java.util.ArrayList;

import com.cbf.db.DBConnection;
	import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.mobileInfo.MobileInfoDAO;
import com.zzst.model.mobileInfo.MobileInfoVO;

import org.apache.log4j.Logger;

 /**	
 * class description: MobileInfo ServiceImpl
 * @date  Mon Aug 01 09:37:00 CST 2016
 * @author ryan
 */
    public class MobileInfoServiceImpl implements MobileInfoService{
	private static Logger logger = CjfLogger.getLogger(MobileInfoServiceImpl.class.getName());

		@Override
		public MobileInfoVO add(MobileInfoVO mobileInfoVO) throws Exception {
			logger.info("serviceImpl	add	begin");
			mobileInfoVO=MobileInfoDAO.add(mobileInfoVO, null);
			logger.info("serviceImpl	add	end");
			return mobileInfoVO;
		}

		@Override
		public  ArrayList<MobileInfoVO> query(MobileInfoVO mobileInfoVO,PageController pageController) throws Exception{
			logger.info("serviceImpl	query	begin");
			ArrayList<MobileInfoVO> listMobileInfo = MobileInfoDAO.query(mobileInfoVO,pageController);
			logger.info("serviceImpl	query	end");
			return  listMobileInfo;
		}

		@Override
		public  MobileInfoVO queryByID(String id) throws Exception{
			logger.info("serviceImpl	queryByID	begin");
			ArrayList<MobileInfoVO> listMobileInfo = MobileInfoDAO.queryByIDs(id,null);
			if(listMobileInfo!=null&&listMobileInfo.size()==1){
				logger.info("serviceImpl	end");
				return listMobileInfo.get(0);
			}
			logger.info("serviceImpl	queryByID	end");
			return null;
		}

		@Override
		public  ArrayList<MobileInfoVO> queryByIDs(String ids) throws Exception{
			logger.info("serviceImpl	queryByIDs	begin");
			ArrayList<MobileInfoVO> listMobileInfo = MobileInfoDAO.queryByIDs(ids,null);
			logger.info("serviceImpl	queryByIDs	end");
			return listMobileInfo;
		}

		@Override
		public MobileInfoVO modify(MobileInfoVO mobileInfoVO )throws Exception{
			logger.info("serviceImpl	modify	begin");
			mobileInfoVO=MobileInfoDAO.modify(mobileInfoVO,null);
			logger.info("serviceImpl	modify	end");
			return mobileInfoVO;
		}
		
		@Override
		public boolean deleteByID(String id )throws Exception{
			logger.info("serviceImpl	deleteByID	begin");
			int num	= MobileInfoDAO.deleteByID(id,null);
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

		public static void main(String args[]) throws Exception {
//			DBConnection.setDbInfo("jdbc:oracle:thin:@10.1.3.182:1521:cinda", "cinda", "cinda");
			DBConnection.setDbInfo("jdbc:mysql://localhost:5522/icmp_zdgj?characterEncoding=gb2312", "root", "root");
			MobileInfoVO vMobileInfoVO = new MobileInfoVO();
														vMobileInfoVO.setId("id");
																			vMobileInfoVO.setName("name");
																			vMobileInfoVO.setMobile("mobile");
																			vMobileInfoVO.setStatus("status");
								
			new MobileInfoServiceImpl().add(vMobileInfoVO);
			System.out.println("=========add Success!");

			ArrayList<MobileInfoVO> lstMobileInfo = new MobileInfoServiceImpl().query(vMobileInfoVO,null);
			
			
			if(lstMobileInfo.size()>0){
				System.out.println("=========query Result:");
				MobileInfoVO vvMobileInfoVO = (MobileInfoVO) lstMobileInfo.get(0);
				            		System.out.println("id=" + vvMobileInfoVO.getId());	            	           			        
				            		System.out.println("name=" + vvMobileInfoVO.getName());	            	           			        
				            		System.out.println("mobile=" + vvMobileInfoVO.getMobile());	            	           			        
				            		System.out.println("status=" + vvMobileInfoVO.getStatus());	            	           			        
								
			}else{
				System.out.println("=========query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
			}
		
		}
 
	}

    