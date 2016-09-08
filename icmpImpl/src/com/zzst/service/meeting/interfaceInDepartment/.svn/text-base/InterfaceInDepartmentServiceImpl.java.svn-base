package com.zzst.service.meeting.interfaceInDepartment;    
	import java.util.ArrayList;

import com.cbf.db.DBConnection;
	import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.interfaceInDepartment.InterfaceInDepartmentDAO;
import com.zzst.model.meeting.interfaceInDepartment.InterfaceInDepartmentVO;

import org.apache.log4j.Logger;

 /**	
 * class description: InterfaceInDepartment ServiceImpl
 * @date  Mon Jun 17 16:54:25 CST 2013
 * @author ryan
 */
    public class InterfaceInDepartmentServiceImpl implements InterfaceInDepartmentService{
	private static Logger logger = CjfLogger.getLogger(InterfaceInDepartmentServiceImpl.class.getName());

		@Override
		public InterfaceInDepartmentVO add(InterfaceInDepartmentVO interfaceInDepartmentVO) throws Exception {
			logger.info("serviceImpl	add	begin");
			interfaceInDepartmentVO=InterfaceInDepartmentDAO.add(interfaceInDepartmentVO, null);
			logger.info("serviceImpl	add	end");
			return interfaceInDepartmentVO;
		}

		@Override
		public  ArrayList<InterfaceInDepartmentVO> query(InterfaceInDepartmentVO interfaceInDepartmentVO,PageController pageController) throws Exception{
			logger.info("serviceImpl	query	begin");
			ArrayList<InterfaceInDepartmentVO> listInterfaceInDepartment = InterfaceInDepartmentDAO.query(interfaceInDepartmentVO,pageController);
			logger.info("serviceImpl	query	end");
			return  listInterfaceInDepartment;
		}

		@Override
		public  InterfaceInDepartmentVO queryByID(String id) throws Exception{
			logger.info("serviceImpl	queryByID	begin");
			ArrayList<InterfaceInDepartmentVO> listInterfaceInDepartment = InterfaceInDepartmentDAO.queryByIDs(id,null);
			if(listInterfaceInDepartment!=null&&listInterfaceInDepartment.size()==1){
				logger.info("serviceImpl	end");
				return listInterfaceInDepartment.get(0);
			}
			logger.info("serviceImpl	queryByID	end");
			return null;
		}

		@Override
		public  ArrayList<InterfaceInDepartmentVO> queryByIDs(String ids) throws Exception{
			logger.info("serviceImpl	queryByIDs	begin");
			ArrayList<InterfaceInDepartmentVO> listInterfaceInDepartment = InterfaceInDepartmentDAO.queryByIDs(ids,null);
			logger.info("serviceImpl	queryByIDs	end");
			return listInterfaceInDepartment;
		}

		@Override
		public InterfaceInDepartmentVO modify(InterfaceInDepartmentVO interfaceInDepartmentVO )throws Exception{
			logger.info("serviceImpl	modify	begin");
			interfaceInDepartmentVO=InterfaceInDepartmentDAO.modify(interfaceInDepartmentVO,null);
			logger.info("serviceImpl	modify	end");
			return interfaceInDepartmentVO;
		}
		
		@Override
		public boolean deleteByID(String id )throws Exception{
			logger.info("serviceImpl	deleteByID	begin");
			int num	= InterfaceInDepartmentDAO.deleteByID(id,null);
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
			DBConnection.setDbInfo("jdbc:mysql://10.1.0.10:3306/icmp?characterEncoding=gb2312", "test", "123456");
			InterfaceInDepartmentVO vInterfaceInDepartmentVO = new InterfaceInDepartmentVO();
														vInterfaceInDepartmentVO.setDepartmentId("departmentId");
																			vInterfaceInDepartmentVO.setDepartmentCode("departmentCode");
																			vInterfaceInDepartmentVO.setDepartmentName("departmentName");
																			vInterfaceInDepartmentVO.setFullName("fullName");
																			vInterfaceInDepartmentVO.setParentId("parentId");
																			vInterfaceInDepartmentVO.setOrderNum(8);
																			vInterfaceInDepartmentVO.setParentcCode("parentcCode");
																			vInterfaceInDepartmentVO.setParentName("parentName");
																			vInterfaceInDepartmentVO.setLinkIds("linkIds");
																			vInterfaceInDepartmentVO.setDepartmentType("departmentType");
																			vInterfaceInDepartmentVO.setNodeProperty("nodeProperty");
																			vInterfaceInDepartmentVO.setTelephone("telephone");
																			vInterfaceInDepartmentVO.setFax("fax");
																			vInterfaceInDepartmentVO.setAddress("address");
																			vInterfaceInDepartmentVO.setPostcode("postcode");
																			vInterfaceInDepartmentVO.setEmail("email");
																																											vInterfaceInDepartmentVO.setCreatorId("creatorId");
																			vInterfaceInDepartmentVO.setCreatorName("creatorName");
								
			new InterfaceInDepartmentServiceImpl().add(vInterfaceInDepartmentVO);
			System.out.println("=========add Success!");

			ArrayList<InterfaceInDepartmentVO> lstInterfaceInDepartment = new InterfaceInDepartmentServiceImpl().query(vInterfaceInDepartmentVO,null);
			
			
			if(lstInterfaceInDepartment.size()>0){
				System.out.println("=========query Result:");
				InterfaceInDepartmentVO vvInterfaceInDepartmentVO = (InterfaceInDepartmentVO) lstInterfaceInDepartment.get(0);
				            		System.out.println("departmentId=" + vvInterfaceInDepartmentVO.getDepartmentId());	            	           			        
				            		System.out.println("departmentCode=" + vvInterfaceInDepartmentVO.getDepartmentCode());	            	           			        
				            		System.out.println("departmentName=" + vvInterfaceInDepartmentVO.getDepartmentName());	            	           			        
				            		System.out.println("fullName=" + vvInterfaceInDepartmentVO.getFullName());	            	           			        
				            		System.out.println("parentId=" + vvInterfaceInDepartmentVO.getParentId());	            	           			        
				            		System.out.println("orderNum=" + vvInterfaceInDepartmentVO.getOrderNum());	            	           			        
				            		System.out.println("parentcCode=" + vvInterfaceInDepartmentVO.getParentcCode());	            	           			        
				            		System.out.println("parentName=" + vvInterfaceInDepartmentVO.getParentName());	            	           			        
				            		System.out.println("linkIds=" + vvInterfaceInDepartmentVO.getLinkIds());	            	           			        
				            		System.out.println("departmentType=" + vvInterfaceInDepartmentVO.getDepartmentType());	            	           			        
				            		System.out.println("nodeProperty=" + vvInterfaceInDepartmentVO.getNodeProperty());	            	           			        
				            		System.out.println("telephone=" + vvInterfaceInDepartmentVO.getTelephone());	            	           			        
				            		System.out.println("fax=" + vvInterfaceInDepartmentVO.getFax());	            	           			        
				            		System.out.println("address=" + vvInterfaceInDepartmentVO.getAddress());	            	           			        
				            		System.out.println("postcode=" + vvInterfaceInDepartmentVO.getPostcode());	            	           			        
				            		System.out.println("email=" + vvInterfaceInDepartmentVO.getEmail());	            	           			        
				            		System.out.println("createtime=" + vvInterfaceInDepartmentVO.getCreatetime());	            	           			        
				            		System.out.println("departmentDesc=" + vvInterfaceInDepartmentVO.getDepartmentDesc());	            	           			        
				            		System.out.println("revision=" + vvInterfaceInDepartmentVO.getRevision());	            	           			        
				            		System.out.println("creatorId=" + vvInterfaceInDepartmentVO.getCreatorId());	            	           			        
				            		System.out.println("creatorName=" + vvInterfaceInDepartmentVO.getCreatorName());	            	           			        
								
			}else{
				System.out.println("=========query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
			}
		
		}
 
	}

    