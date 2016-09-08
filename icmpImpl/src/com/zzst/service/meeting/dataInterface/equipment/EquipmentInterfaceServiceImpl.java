package com.zzst.service.meeting.dataInterface.equipment;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.dataInterface.equipment.EquipmentInterfaceDAO;
import com.zzst.dao.meeting.dataInterface.terminal.TerminalInterfaceDAO;
import com.zzst.model.meeting.dataInterface.equipment.EquipmentInterfaceVO;
import com.zzst.model.meeting.dataInterface.terminal.TerminalInterfaceVO;

/**
 * class description: EquipmentInterface ServiceImpl
 * 
 * @date Mon Jul 01 16:11:19 CST 2013
 * @author ryan
 */
public class EquipmentInterfaceServiceImpl implements EquipmentInterfaceService {
	private static Logger logger = CjfLogger
			.getLogger(EquipmentInterfaceServiceImpl.class.getName());

	@Override
	public EquipmentInterfaceVO add(EquipmentInterfaceVO equipmentInterfaceVO)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		equipmentInterfaceVO = EquipmentInterfaceDAO.add(equipmentInterfaceVO,
				null);
		logger.info("serviceImpl	add	end");
		return equipmentInterfaceVO;
	}

	@Override
	public ArrayList<EquipmentInterfaceVO> query(
			EquipmentInterfaceVO equipmentInterfaceVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<EquipmentInterfaceVO> listEquipmentInterface = EquipmentInterfaceDAO
				.query(equipmentInterfaceVO, pageController);
		logger.info("serviceImpl	query	end");
		return listEquipmentInterface;
	}

	@Override
	public EquipmentInterfaceVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<EquipmentInterfaceVO> listEquipmentInterface = EquipmentInterfaceDAO
				.queryByIDs(id, null);
		if (listEquipmentInterface != null
				&& listEquipmentInterface.size() == 1) {
			logger.info("serviceImpl	end");
			return listEquipmentInterface.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<EquipmentInterfaceVO> queryByIDs(String ids)
			throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<EquipmentInterfaceVO> listEquipmentInterface = EquipmentInterfaceDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listEquipmentInterface;
	}

	@Override
	public EquipmentInterfaceVO modify(EquipmentInterfaceVO equipmentInterfaceVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		equipmentInterfaceVO = EquipmentInterfaceDAO.modify(
				equipmentInterfaceVO, null);
		logger.info("serviceImpl	modify	end");
		return equipmentInterfaceVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = EquipmentInterfaceDAO.deleteByID(id, null);
		if (num == 1) {
			logger.info("serviceImpl	deleteByID	end");
			return true;
		} else {
			logger.info("serviceImpl	deleteByID	end");
			return false;
		}
	}

	@Override
	public int deleteByIDs(String ids) throws Exception {
		logger.info("serviceImpl	deleteByIDs	begin");
		int num = EquipmentInterfaceDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

	public static void main(String args[]) throws Exception {
		// DBConnection.setDbInfo("jdbc:oracle:thin:@10.1.3.182:1521:cinda",
		// "cinda", "cinda");
		DBConnection.setDbInfo(
				"jdbc:mysql://10.1.8.7:3306/icmp?characterEncoding=gb2312",
				"root", "myroot");
		EquipmentInterfaceVO vEquipmentInterfaceVO = new EquipmentInterfaceVO();
		vEquipmentInterfaceVO.setEquipmentID("equipmentID");
		vEquipmentInterfaceVO.setEquipmentType(8);
		vEquipmentInterfaceVO.setEquipmentModel("equipmentModel");
		vEquipmentInterfaceVO.setEquipmentNO("equipmentNO");
		vEquipmentInterfaceVO.setEquipmentStatus(8);
		vEquipmentInterfaceVO.setMac("mac");
		vEquipmentInterfaceVO.setIp("ip");
		vEquipmentInterfaceVO.setCommandIP("commandIP");
		vEquipmentInterfaceVO.setPort(8);
		vEquipmentInterfaceVO.setRoomNO("roomNO");
		vEquipmentInterfaceVO.setAdminName("adminName");
		vEquipmentInterfaceVO.setLoginName("loginName");
		vEquipmentInterfaceVO.setLoginPassword("loginPassword");
		vEquipmentInterfaceVO.setMcuIp("mcuIp");
		vEquipmentInterfaceVO.setAppraisalTaskNum("appraisalTaskNum");
		vEquipmentInterfaceVO.setShowFormatFlag("showFormatFlag");
		vEquipmentInterfaceVO.setInputModel("inputModel");
		vEquipmentInterfaceVO.setOutputModel("outputModel");
		vEquipmentInterfaceVO.setAppraisalModel("appraisalModel");
		vEquipmentInterfaceVO.setCollectModel("collectModel");
		vEquipmentInterfaceVO.setEquipmentDesc("equipmentDesc");
		vEquipmentInterfaceVO.setSerialNumber("serialNumber");
		vEquipmentInterfaceVO.setEquipmentIdentifier("equipmentIdentifier");
		vEquipmentInterfaceVO.setMaintainceStartTime(new Timestamp(System
				.currentTimeMillis()));
		vEquipmentInterfaceVO.setMaintainMonth(8);
		vEquipmentInterfaceVO.setStatus(8);
		vEquipmentInterfaceVO.setDescription("description");
		vEquipmentInterfaceVO.setCreatorId("creatorId");

		new EquipmentInterfaceServiceImpl().add(vEquipmentInterfaceVO);
		System.out.println("=========add Success!");

		ArrayList<EquipmentInterfaceVO> lstEquipmentInterface = new EquipmentInterfaceServiceImpl()
				.query(vEquipmentInterfaceVO, null);

		if (lstEquipmentInterface.size() > 0) {
			System.out.println("=========query Result:");
			EquipmentInterfaceVO vvEquipmentInterfaceVO = (EquipmentInterfaceVO) lstEquipmentInterface
					.get(0);
			System.out.println("equipmentID="
					+ vvEquipmentInterfaceVO.getEquipmentID());
			System.out.println("equipmentType="
					+ vvEquipmentInterfaceVO.getEquipmentType());
			System.out.println("equipmentModel="
					+ vvEquipmentInterfaceVO.getEquipmentModel());
			System.out.println("equipmentNO="
					+ vvEquipmentInterfaceVO.getEquipmentNO());
			System.out.println("equipmentStatus="
					+ vvEquipmentInterfaceVO.getEquipmentStatus());
			System.out.println("mac=" + vvEquipmentInterfaceVO.getMac());
			System.out.println("ip=" + vvEquipmentInterfaceVO.getIp());
			System.out.println("commandIP="
					+ vvEquipmentInterfaceVO.getCommandIP());
			System.out.println("port=" + vvEquipmentInterfaceVO.getPort());
			System.out.println("roomNO=" + vvEquipmentInterfaceVO.getRoomNO());
			System.out.println("adminName="
					+ vvEquipmentInterfaceVO.getAdminName());
			System.out.println("loginName="
					+ vvEquipmentInterfaceVO.getLoginName());
			System.out.println("loginPassword="
					+ vvEquipmentInterfaceVO.getLoginPassword());
			System.out.println("mcuIp=" + vvEquipmentInterfaceVO.getMcuIp());
			System.out.println("appraisalTaskNum="
					+ vvEquipmentInterfaceVO.getAppraisalTaskNum());
			System.out.println("showFormatFlag="
					+ vvEquipmentInterfaceVO.getShowFormatFlag());
			System.out.println("inputModel="
					+ vvEquipmentInterfaceVO.getInputModel());
			System.out.println("outputModel="
					+ vvEquipmentInterfaceVO.getOutputModel());
			System.out.println("appraisalModel="
					+ vvEquipmentInterfaceVO.getAppraisalModel());
			System.out.println("collectModel="
					+ vvEquipmentInterfaceVO.getCollectModel());
			System.out.println("equipmentDesc="
					+ vvEquipmentInterfaceVO.getEquipmentDesc());
			System.out.println("serialNumber="
					+ vvEquipmentInterfaceVO.getSerialNumber());
			System.out.println("equipmentIdentifier="
					+ vvEquipmentInterfaceVO.getEquipmentIdentifier());
			System.out.println("maintainceStartTime="
					+ vvEquipmentInterfaceVO.getMaintainceStartTime());
			System.out.println("maintainMonth="
					+ vvEquipmentInterfaceVO.getMaintainMonth());
			System.out.println("status=" + vvEquipmentInterfaceVO.getStatus());
			System.out.println("description="
					+ vvEquipmentInterfaceVO.getDescription());
			System.out.println("creatorId="
					+ vvEquipmentInterfaceVO.getCreatorId());

		} else {
			System.out
					.println("=========query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
		}

	}

	@Override
	public ArrayList<EquipmentInterfaceVO> queryAvailable(
			EquipmentInterfaceVO equipmentInterfaceVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	queryAvailable	begin");
		ArrayList<EquipmentInterfaceVO> listEquipmentInterface = EquipmentInterfaceDAO
				.queryAvailable(equipmentInterfaceVO, pageController);
		
		/*LogVO  logVO  = new LogVO();
		logVO.setLogType(LogEnum.TYPE_DEFAULT);
		logVO.setLevel(LogEnum.LEVEL_DeFAULT);
		logVO.setOperatorContent("对 z_interface_in_meetingroom表 进行查询操作");
		new LogServiceImpl().add(logVO);*/
		
		
		logger.info("serviceImpl	queryAvailable	end");
		return listEquipmentInterface;// TODO Auto-generated method stub
	}

	@Override
	public void deleteAll() throws Exception {
		logger.info("serviceImpl	deleteAll	begin");
		EquipmentInterfaceDAO.deleteAll();
		logger.info("serviceImpl	deleteAll	end");
		
	}
	
	
	
}
