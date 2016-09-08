package com.zzst.service.meeting.information;
    
	import java.util.ArrayList;

import com.cbf.db.DBConnection;
	import com.cbf.db.PageController;
import com.cbf.log.CbfLogger;
import com.zzst.dao.meeting.information.InformationDAO;
import com.zzst.model.meeting.information.InformationVO;

import org.apache.log4j.Logger;

 /**	
 * class description: Information ServiceImpl
 * @date  Tue Jan 29 18:25:43 CST 2013
 * @author ryan
 */
    public class InformationServiceImpl implements InformationService{
	private static Logger logger = CbfLogger.getLogger(InformationServiceImpl.class.getName());

		public InformationVO add(InformationVO informationVO) throws Exception {
			logger.info("serviceImpl	add	begin");
			informationVO=InformationDAO.add(informationVO, null);
			logger.info("serviceImpl	add	end");
			return informationVO;
		}

		public  ArrayList<InformationVO> query(InformationVO informationVO,PageController pageController) throws Exception{
			logger.info("serviceImpl	query	begin");
			ArrayList<InformationVO> listInformation = InformationDAO.query(informationVO,pageController);
			logger.info("serviceImpl	query	end");
			return  listInformation;
		}
		
		public  ArrayList<InformationVO> queryNew(InformationVO informationVO,PageController pageController) throws Exception{
			logger.info("serviceImpl	query	begin");
			ArrayList<InformationVO> listInformation = InformationDAO.queryNew(informationVO,pageController);
			logger.info("serviceImpl	query	end");
			return  listInformation;
		}

		
		public  InformationVO queryByID(String id) throws Exception{
			logger.info("serviceImpl	queryByID	begin");
			ArrayList<InformationVO> listInformation = InformationDAO.queryByIDs(id,null);
			if(listInformation!=null&&listInformation.size()==1){
				logger.info("serviceImpl	end");
				return listInformation.get(0);
			}
			logger.info("serviceImpl	queryByID	end");
			return null;
		}

		public  ArrayList<InformationVO> queryByIDs(String ids) throws Exception{
			logger.info("serviceImpl	queryByIDs	begin");
			ArrayList<InformationVO> listInformation = InformationDAO.queryByIDs(ids,null);
			logger.info("serviceImpl	queryByIDs	end");
			return listInformation;
		}

		
		public InformationVO modify(InformationVO informationVO )throws Exception{
			logger.info("serviceImpl	modify	begin");
			informationVO=InformationDAO.modify(informationVO,null);
			logger.info("serviceImpl	modify	end");
			return informationVO;
		}
		
		
		public boolean deleteByID(String id )throws Exception{
			logger.info("serviceImpl	deleteByID	begin");
			int num	= InformationDAO.deleteByID(id,null);
			if(num==1){
				logger.info("serviceImpl	deleteByID	end");
				return true;
			}else{
				logger.info("serviceImpl	deleteByID	end");
				return false;
			}
		}

		
		public int deleteByIDs(String ids )throws Exception{
			logger.info("serviceImpl	deleteByIDs	begin");
			int num	= InformationDAO.deleteByID(ids,null);
			logger.info("serviceImpl	deleteByIDs	end");
			return num;
		}

		public static void main(String args[]) throws Exception {
//			DBConnection.setDbInfo("jdbc:oracle:thin:@10.1.3.182:1521:cinda", "cinda", "cinda");
			DBConnection.setDbInfo("jdbc:mysql://10.1.0.10:3306/icmp?characterEncoding=gb2312", "test", "123456");
			InformationVO vInformationVO = new InformationVO();
														vInformationVO.setInfoID("infoID");
																			vInformationVO.setInfoType(8);
																			vInformationVO.setTitle("title");
																			vInformationVO.setContent("content");
																			vInformationVO.setCreateUserID("createUserID");
																											vInformationVO.setStatus(8);
																			vInformationVO.setDescription("description");
								
			new InformationServiceImpl().add(vInformationVO);
			System.out.println("=========add Success!");

			ArrayList<InformationVO> lstInformation = new InformationServiceImpl().query(vInformationVO,null);
			
			
			if(lstInformation.size()>0){
				System.out.println("=========query Result:");
				InformationVO vvInformationVO = (InformationVO) lstInformation.get(0);
				            		System.out.println("infoID=" + vvInformationVO.getInfoID());	            	           			        
				            		System.out.println("infoType=" + vvInformationVO.getInfoType());	            	           			        
				            		System.out.println("title=" + vvInformationVO.getTitle());	            	           			        
				            		System.out.println("content=" + vvInformationVO.getContent());	            	           			        
				            		System.out.println("createUserID=" + vvInformationVO.getCreateUserID());	            	           			        
				            		System.out.println("createTime=" + vvInformationVO.getCreateTime());	            	           			        
				            		System.out.println("status=" + vvInformationVO.getStatus());	            	           			        
				            		System.out.println("description=" + vvInformationVO.getDescription());	            	           			        
								
			}else{
				System.out.println("=========query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
			}
		
		}
 
	}

    