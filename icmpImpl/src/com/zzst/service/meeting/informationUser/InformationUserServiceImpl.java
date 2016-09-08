package com.zzst.service.meeting.informationUser;
    
	import java.util.ArrayList;

import com.cbf.db.DBConnection;
	import com.cbf.db.PageController;
import com.cbf.log.CbfLogger;
import com.zzst.dao.meeting.informationUser.InformationUserDAO;
import com.zzst.model.meeting.informationUser.InformationUserVO;

import org.apache.log4j.Logger;

 /**	
 * class description: InformationUser ServiceImpl
 * @date  Tue Jan 29 18:25:43 CST 2013
 * @author ryan
 */
    public class InformationUserServiceImpl implements InformationUserService{
	private static Logger logger = CbfLogger.getLogger(InformationUserServiceImpl.class.getName());

		@Override
		public InformationUserVO add(InformationUserVO informationUserVO) throws Exception {
			logger.info("serviceImpl	add	begin");
			informationUserVO=InformationUserDAO.add(informationUserVO, null);
			logger.info("serviceImpl	add	end");
			return informationUserVO;
		}

		@Override
		public  ArrayList<InformationUserVO> query(InformationUserVO informationUserVO,PageController pageController) throws Exception{
			logger.info("serviceImpl	query	begin");
			ArrayList<InformationUserVO> listInformationUser = InformationUserDAO.query(informationUserVO,pageController);
			logger.info("serviceImpl	query	end");
			return  listInformationUser;
		}

		@Override
		public  InformationUserVO queryByID(String id) throws Exception{
			logger.info("serviceImpl	queryByID	begin");
			ArrayList<InformationUserVO> listInformationUser = InformationUserDAO.queryByIDs(id,null);
			if(listInformationUser!=null&&listInformationUser.size()==1){
				logger.info("serviceImpl	end");
				return listInformationUser.get(0);
			}
			logger.info("serviceImpl	queryByID	end");
			return null;
		}

		@Override
		public  ArrayList<InformationUserVO> queryByIDs(String ids) throws Exception{
			logger.info("serviceImpl	queryByIDs	begin");
			ArrayList<InformationUserVO> listInformationUser = InformationUserDAO.queryByIDs(ids,null);
			logger.info("serviceImpl	queryByIDs	end");
			return listInformationUser;
		}

		@Override
		public InformationUserVO modify(InformationUserVO informationUserVO )throws Exception{
			logger.info("serviceImpl	modify	begin");
			informationUserVO=InformationUserDAO.modify(informationUserVO,null);
			logger.info("serviceImpl	modify	end");
			return informationUserVO;
		}
		
		@Override
		public boolean deleteByID(String id )throws Exception{
			logger.info("serviceImpl	deleteByID	begin");
			int num	= InformationUserDAO.deleteByID(id,null);
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
			int num	= InformationUserDAO.deleteByID(ids,null);
			logger.info("serviceImpl	deleteByIDs	end");
			return num;
		}

		public static void main(String args[]) throws Exception {
//			DBConnection.setDbInfo("jdbc:oracle:thin:@10.1.3.182:1521:cinda", "cinda", "cinda");
			DBConnection.setDbInfo("jdbc:mysql://10.1.0.10:3306/icmp?characterEncoding=gb2312", "test", "123456");
			InformationUserVO vInformationUserVO = new InformationUserVO();
														vInformationUserVO.setInfoID("infoID");
																			vInformationUserVO.setDisposeUserID("disposeUserID");
																											vInformationUserVO.setStatus(8);
																			vInformationUserVO.setDescription("description");
								
			new InformationUserServiceImpl().add(vInformationUserVO);
			System.out.println("=========add Success!");

			ArrayList<InformationUserVO> lstInformationUser = new InformationUserServiceImpl().query(vInformationUserVO,null);
			
			
			if(lstInformationUser.size()>0){
				System.out.println("=========query Result:");
				InformationUserVO vvInformationUserVO = (InformationUserVO) lstInformationUser.get(0);
				            		System.out.println("infoID=" + vvInformationUserVO.getInfoID());	            	           			        
				            		System.out.println("disposeUserID=" + vvInformationUserVO.getDisposeUserID());	            	           			        
				            		System.out.println("disposeTime=" + vvInformationUserVO.getDisposeTime());	            	           			        
				            		System.out.println("status=" + vvInformationUserVO.getStatus());	            	           			        
				            		System.out.println("description=" + vvInformationUserVO.getDescription());	            	           			        
								
			}else{
				System.out.println("=========query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
			}
		
		}
 
	}

    