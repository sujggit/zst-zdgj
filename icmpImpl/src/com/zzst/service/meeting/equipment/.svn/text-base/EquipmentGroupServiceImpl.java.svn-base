package com.zzst.service.meeting.equipment;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.equipment.EquipmentGroupDAO;
import com.zzst.model.meeting.equipment.EquipmentGroupVO;

/**
 * class description: EquipmentGroup ServiceImpl
 * 
 * @date Thu Apr 24 11:55:59 CST 2014
 * @author ryan
 */
public class EquipmentGroupServiceImpl implements EquipmentGroupService {
	private static Logger logger = CjfLogger
			.getLogger(EquipmentGroupServiceImpl.class.getName());

	@Override
	public EquipmentGroupVO add(EquipmentGroupVO equipmentGroupVO)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		equipmentGroupVO = EquipmentGroupDAO.add(equipmentGroupVO, null);
		logger.info("serviceImpl	add	end");
		return equipmentGroupVO;
	}

	@Override
	public ArrayList<EquipmentGroupVO> query(EquipmentGroupVO equipmentGroupVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<EquipmentGroupVO> listEquipmentGroup = EquipmentGroupDAO
				.query(equipmentGroupVO, pageController);
		logger.info("serviceImpl	query	end");
		return listEquipmentGroup;
	}
	
	@Override
	public ArrayList<EquipmentGroupVO> query(PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<EquipmentGroupVO> listEquipmentGroup = EquipmentGroupDAO
				.query(pageController);
		logger.info("serviceImpl	query	end");
		return listEquipmentGroup;
	}
	
	@Override
	public EquipmentGroupVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<EquipmentGroupVO> listEquipmentGroup = EquipmentGroupDAO
				.queryByIDs(id, null);
		if (listEquipmentGroup != null && listEquipmentGroup.size() == 1) {
			logger.info("serviceImpl	end");
			return listEquipmentGroup.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<EquipmentGroupVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<EquipmentGroupVO> listEquipmentGroup = EquipmentGroupDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listEquipmentGroup;
	}

	@Override
	public EquipmentGroupVO modify(EquipmentGroupVO equipmentGroupVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		equipmentGroupVO = EquipmentGroupDAO.modify(equipmentGroupVO, null);
		logger.info("serviceImpl	modify	end");
		return equipmentGroupVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = EquipmentGroupDAO.deleteByIDs(id, null);
		logger.info("delete number : " + num);
		if (num == 1) {
			logger.info("serviceImpl	deleteByID	end");
			return true;
		} else {
			logger.info("serviceImpl	deleteByID	end");
			return false;
		}
	}

	@Override
	public void deleteByIDs(String ids) throws Exception {
		logger.info("serviceImpl	deleteByIDs	begin");
		int num = EquipmentGroupDAO.deleteByIDs(ids, null);
		logger.info("delete number : " + num);
		logger.info("serviceImpl	deleteByIDs	end");
	}

	@Override
	public ArrayList<EquipmentGroupVO> queryFuzzySearch(String ids,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	queryFuzzySearch	begin");
		ArrayList<EquipmentGroupVO> listEquipmentGroup = EquipmentGroupDAO
				.queryFuzzySearch(ids, null);
		logger.info("serviceImpl	queryFuzzySearch	end");
		return listEquipmentGroup;
	}
	
	@Override
	public void deleteByName(String groupname) throws Exception {
		logger.info("serviceImpl	deleteByName	begin");
		int num = EquipmentGroupDAO.deleteByName(groupname, null);
		logger.info("delete number : " + num);
		logger.info("serviceImpl	deleteByName	end");
	}

	public static void main(String args[]) throws Exception {
		// DBConnection.setDbInfo("jdbc:oracle:thin:@10.1.3.182:1521:cinda",
		// "cinda", "cinda");
		DBConnection.setDbInfo(
				"jdbc:mysql://localhost:5522/icmp-dep?characterEncoding=gb2312",
				"test", "123456");
		EquipmentGroupVO vEquipmentGroupVO = new EquipmentGroupVO();
		vEquipmentGroupVO.setId("id");
		vEquipmentGroupVO.setGroupname("groupname");
		vEquipmentGroupVO.setEquipmentID("equipmentID");
		vEquipmentGroupVO.setStatus(8);
		vEquipmentGroupVO.setDescription("description");
		vEquipmentGroupVO.setRank("rank");

		new EquipmentGroupServiceImpl().add(vEquipmentGroupVO);
		System.out.println("=========add Success!");

		ArrayList<EquipmentGroupVO> lstEquipmentGroup = new EquipmentGroupServiceImpl()
				.query(vEquipmentGroupVO, null);

		if (lstEquipmentGroup.size() > 0) {
			System.out.println("=========query Result:");
			EquipmentGroupVO vvEquipmentGroupVO = (EquipmentGroupVO) lstEquipmentGroup
					.get(0);
			System.out.println("id=" + vvEquipmentGroupVO.getId());
			System.out
					.println("groupname=" + vvEquipmentGroupVO.getGroupname());
			System.out.println("equipmentID="
					+ vvEquipmentGroupVO.getEquipmentID());
			System.out.println("status=" + vvEquipmentGroupVO.getStatus());
			System.out.println("description="
					+ vvEquipmentGroupVO.getDescription());
			System.out.println("rank=" + vvEquipmentGroupVO.getRank());

		} else {
			System.out
					.println("=========query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
		}

		lstEquipmentGroup = new EquipmentGroupServiceImpl().queryByIDs("");
		if (lstEquipmentGroup.size() > 0) {
			System.out.println("=========query Result:");
			EquipmentGroupVO vvEquipmentGroupVO = (EquipmentGroupVO) lstEquipmentGroup
					.get(0);
			System.out.println("id=" + vvEquipmentGroupVO.getId());
			System.out
					.println("groupname=" + vvEquipmentGroupVO.getGroupname());
			System.out.println("equipmentID="
					+ vvEquipmentGroupVO.getEquipmentID());
			System.out.println("status=" + vvEquipmentGroupVO.getStatus());
			System.out.println("description="
					+ vvEquipmentGroupVO.getDescription());
			System.out.println("rank=" + vvEquipmentGroupVO.getRank());

		} else {
			System.out
					.println("=====���IDs====query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
		}

		lstEquipmentGroup = new EquipmentGroupServiceImpl().queryFuzzySearch(
				"-", null);
		if (lstEquipmentGroup.size() > 0) {
			System.out.println("=========query Result:");
			EquipmentGroupVO vvEquipmentGroupVO = (EquipmentGroupVO) lstEquipmentGroup
					.get(0);
			System.out.println("id=" + vvEquipmentGroupVO.getId());
			System.out
					.println("groupname=" + vvEquipmentGroupVO.getGroupname());
			System.out.println("equipmentID="
					+ vvEquipmentGroupVO.getEquipmentID());
			System.out.println("status=" + vvEquipmentGroupVO.getStatus());
			System.out.println("description="
					+ vvEquipmentGroupVO.getDescription());
			System.out.println("rank=" + vvEquipmentGroupVO.getRank());

		} else {
			System.out
					.println("=========ģ���ѯ=======query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
		}

	}

	

}
