package com.zzst.service.meeting.templateEquipmentGroup;

import java.util.ArrayList;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.cbf.log.CbfLogger;
import com.zzst.dao.meeting.templateEquipmentGroup.TemplateEquipmentGroupDAO;
import com.zzst.model.meeting.templateEquipmentGroup.TemplateEquipmentGroupVO;

import org.apache.log4j.Logger;

/**	
 * class description: TemplateEquipmentGroup ServiceImpl
 * @date  Wed Mar 20 13:12:04 CST 2013
 * @author ryan
 */
public class TemplateEquipmentGroupServiceImpl implements TemplateEquipmentGroupService{
	private static Logger logger = CbfLogger.getLogger(TemplateEquipmentGroupServiceImpl.class.getName());

	@Override
	public TemplateEquipmentGroupVO add(TemplateEquipmentGroupVO templateEquipmentGroupVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		templateEquipmentGroupVO=TemplateEquipmentGroupDAO.add(templateEquipmentGroupVO, null);
		logger.info("serviceImpl	add	end");
		return templateEquipmentGroupVO;
	}

	@Override
	public  ArrayList<TemplateEquipmentGroupVO> query(TemplateEquipmentGroupVO templateEquipmentGroupVO,PageController pageController) throws Exception{
		logger.info("serviceImpl	query	begin");
		ArrayList<TemplateEquipmentGroupVO> listTemplateEquipmentGroup = TemplateEquipmentGroupDAO.query(templateEquipmentGroupVO,pageController);
		logger.info("serviceImpl	query	end");
		return  listTemplateEquipmentGroup;
	}

	@Override
	public  TemplateEquipmentGroupVO queryByID(String id) throws Exception{
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<TemplateEquipmentGroupVO> listTemplateEquipmentGroup = TemplateEquipmentGroupDAO.queryByIDs(id,null);
		if(listTemplateEquipmentGroup!=null&&listTemplateEquipmentGroup.size()==1){
			logger.info("serviceImpl	end");
			return listTemplateEquipmentGroup.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public  ArrayList<TemplateEquipmentGroupVO> queryByIDs(String ids) throws Exception{
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<TemplateEquipmentGroupVO> listTemplateEquipmentGroup = TemplateEquipmentGroupDAO.queryByIDs(ids,null);
		logger.info("serviceImpl	queryByIDs	end");
		return listTemplateEquipmentGroup;
	}

	@Override
	public TemplateEquipmentGroupVO modify(TemplateEquipmentGroupVO templateEquipmentGroupVO )throws Exception{
		logger.info("serviceImpl	modify	begin");
		templateEquipmentGroupVO=TemplateEquipmentGroupDAO.modify(templateEquipmentGroupVO,null);
		logger.info("serviceImpl	modify	end");
		return templateEquipmentGroupVO;
	}

	@Override
	public boolean deleteByID(String id )throws Exception{
		logger.info("serviceImpl	deleteByID	begin");
		int num	= TemplateEquipmentGroupDAO.deleteByID(id,null);
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
		int num	= TemplateEquipmentGroupDAO.deleteByID(ids,null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

	public static void main(String args[]) throws Exception {
		//			DBConnection.setDbInfo("jdbc:oracle:thin:@10.1.3.182:1521:cinda", "cinda", "cinda");
		DBConnection.setDbInfo("jdbc:mysql://localhost:3306/icmp?characterEncoding=gb2312", "root", "yume");
		TemplateEquipmentGroupVO vTemplateEquipmentGroupVO = new TemplateEquipmentGroupVO();
		vTemplateEquipmentGroupVO.setID("ID");
		vTemplateEquipmentGroupVO.setName("name");
		vTemplateEquipmentGroupVO.setStatus(8);
		vTemplateEquipmentGroupVO.setDescription("description");

		new TemplateEquipmentGroupServiceImpl().add(vTemplateEquipmentGroupVO);
		System.out.println("=========add Success!");

		ArrayList<TemplateEquipmentGroupVO> lstTemplateEquipmentGroup = new TemplateEquipmentGroupServiceImpl().query(vTemplateEquipmentGroupVO,null);


		if(lstTemplateEquipmentGroup.size()>0){
			System.out.println("=========query Result:");
			TemplateEquipmentGroupVO vvTemplateEquipmentGroupVO = (TemplateEquipmentGroupVO) lstTemplateEquipmentGroup.get(0);
			System.out.println("ID=" + vvTemplateEquipmentGroupVO.getID());	            	           			        
			System.out.println("name=" + vvTemplateEquipmentGroupVO.getName());	            	           			        
			System.out.println("status=" + vvTemplateEquipmentGroupVO.getStatus());	            	           			        
			System.out.println("description=" + vvTemplateEquipmentGroupVO.getDescription());	            	           			        

		}else{
			System.out.println("=========query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
		}

	}

}

