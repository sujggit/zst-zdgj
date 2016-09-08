package com.zzst.service.meeting.templateEquipment;

import java.util.ArrayList;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.cbf.log.CbfLogger;

import com.zzst.dao.meeting.templateEquipment.TemplateEquipmentDAO;
import com.zzst.model.meeting.templateEquipment.TemplateEquipmentVO;

import org.apache.log4j.Logger;

/**	
 * class description: TemplateEquipment ServiceImpl
 * @date  Wed Mar 20 13:12:04 CST 2013
 * @author ryan
 */
public class TemplateEquipmentServiceImpl implements TemplateEquipmentService{
	private static Logger logger = CbfLogger.getLogger(TemplateEquipmentServiceImpl.class.getName());

	@Override
	public TemplateEquipmentVO add(TemplateEquipmentVO templateEquipmentVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		templateEquipmentVO=TemplateEquipmentDAO.add(templateEquipmentVO, null);
		logger.info("serviceImpl	add	end");
		return templateEquipmentVO;
	}

	@Override
	public  ArrayList<TemplateEquipmentVO> query(TemplateEquipmentVO templateEquipmentVO,PageController pageController) throws Exception{
		logger.info("serviceImpl	query	begin");
		ArrayList<TemplateEquipmentVO> listTemplateEquipment = TemplateEquipmentDAO.query(templateEquipmentVO,pageController);
		logger.info("serviceImpl	query	end");
		return  listTemplateEquipment;
	}

	@Override
	public  TemplateEquipmentVO queryByID(String id) throws Exception{
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<TemplateEquipmentVO> listTemplateEquipment = TemplateEquipmentDAO.queryByIDs(id,null);
		if(listTemplateEquipment!=null&&listTemplateEquipment.size()==1){
			logger.info("serviceImpl	end");
			return listTemplateEquipment.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public  ArrayList<TemplateEquipmentVO> queryByIDs(String ids) throws Exception{
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<TemplateEquipmentVO> listTemplateEquipment = TemplateEquipmentDAO.queryByIDs(ids,null);
		logger.info("serviceImpl	queryByIDs	end");
		return listTemplateEquipment;
	}

	@Override
	public TemplateEquipmentVO modify(TemplateEquipmentVO templateEquipmentVO )throws Exception{
		logger.info("serviceImpl	modify	begin");
		templateEquipmentVO=TemplateEquipmentDAO.modify(templateEquipmentVO,null);
		logger.info("serviceImpl	modify	end");
		return templateEquipmentVO;
	}

	@Override
	public boolean deleteByID(String id )throws Exception{
		logger.info("serviceImpl	deleteByID	begin");
		int num	= TemplateEquipmentDAO.deleteByID(id,null);
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
		int num	= TemplateEquipmentDAO.deleteByID(ids,null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

	public static void main(String args[]) throws Exception {
		//			DBConnection.setDbInfo("jdbc:oracle:thin:@10.1.3.182:1521:cinda", "cinda", "cinda");
		DBConnection.setDbInfo("jdbc:mysql://localhost:3306/icmp?characterEncoding=gb2312", "root", "yume");
		TemplateEquipmentVO vTemplateEquipmentVO = new TemplateEquipmentVO();
		vTemplateEquipmentVO.setID("ID");
		vTemplateEquipmentVO.setGroupId("groupId");
		vTemplateEquipmentVO.setEquipmentName("equipmentName");
		vTemplateEquipmentVO.setEquipmentIp("equipmentIp");
		vTemplateEquipmentVO.setPInterface("pInterface");
		vTemplateEquipmentVO.setAliasName("aliasName");
		vTemplateEquipmentVO.setAliasType("aliasType");
		vTemplateEquipmentVO.setPtsNumber("ptsNumber");
		vTemplateEquipmentVO.setLineRate("lineRate");
		vTemplateEquipmentVO.setMaxResolution("maxResolution");
		vTemplateEquipmentVO.setVideoProtocol("videoProtocol");
		vTemplateEquipmentVO.setCascadeRole("cascadeRole");
		vTemplateEquipmentVO.setAgc("agc");
		vTemplateEquipmentVO.setCallDirection("callDirection");
		vTemplateEquipmentVO.setIsMain(8);
		vTemplateEquipmentVO.setDescription("description");

		new TemplateEquipmentServiceImpl().add(vTemplateEquipmentVO);
		System.out.println("=========add Success!");

		ArrayList<TemplateEquipmentVO> lstTemplateEquipment = new TemplateEquipmentServiceImpl().query(vTemplateEquipmentVO,null);


		if(lstTemplateEquipment.size()>0){
			System.out.println("=========query Result:");
			TemplateEquipmentVO vvTemplateEquipmentVO = (TemplateEquipmentVO) lstTemplateEquipment.get(0);
			System.out.println("ID=" + vvTemplateEquipmentVO.getID());	            	           			        
			System.out.println("groupId=" + vvTemplateEquipmentVO.getGroupId());	            	           			        
			System.out.println("equipmentName=" + vvTemplateEquipmentVO.getEquipmentName());	            	           			        
			System.out.println("equipmentIp=" + vvTemplateEquipmentVO.getEquipmentIp());	            	           			        
			System.out.println("pInterface=" + vvTemplateEquipmentVO.getPInterface());	            	           			        
			System.out.println("aliasName=" + vvTemplateEquipmentVO.getAliasName());	            	           			        
			System.out.println("aliasType=" + vvTemplateEquipmentVO.getAliasType());	            	           			        
			System.out.println("ptsNumber=" + vvTemplateEquipmentVO.getPtsNumber());	            	           			        
			System.out.println("lineRate=" + vvTemplateEquipmentVO.getLineRate());	            	           			        
			System.out.println("maxResolution=" + vvTemplateEquipmentVO.getMaxResolution());	            	           			        
			System.out.println("videoProtocol=" + vvTemplateEquipmentVO.getVideoProtocol());	            	           			        
			System.out.println("cascadeRole=" + vvTemplateEquipmentVO.getCascadeRole());	            	           			        
			System.out.println("agc=" + vvTemplateEquipmentVO.getAgc());	            	           			        
			System.out.println("callDirection=" + vvTemplateEquipmentVO.getCallDirection());	            	           			        
			System.out.println("isMain=" + vvTemplateEquipmentVO.getIsMain());	            	           			        
			System.out.println("description=" + vvTemplateEquipmentVO.getDescription());	            	           			        

		}else{
			System.out.println("=========query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
		}

	}

}

