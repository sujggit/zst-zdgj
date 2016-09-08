package com.zzst.service.project.avic.staffsRecord;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.project.avic.staffsRecord.StaffsRecordDAO;
import com.zzst.model.project.avic.StaffsRecordVO;

/**
 * class description: StaffsRecord ServiceImpl
 * 
 * @date Fri Sep 14 18:17:43 CST 2012
 * @author ryan
 */
public class StaffsRecordServiceImpl implements StaffsRecordService {
	private static Logger logger = CjfLogger
			.getLogger(StaffsRecordServiceImpl.class.getName());

	@Override
	public StaffsRecordVO add(StaffsRecordVO staffsRecordVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		staffsRecordVO = StaffsRecordDAO.add(staffsRecordVO, null);
		logger.info("serviceImpl	add	end");
		return staffsRecordVO;
	}

	@Override
	public ArrayList<StaffsRecordVO> query(StaffsRecordVO staffsRecordVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<StaffsRecordVO> listStaffsRecord = StaffsRecordDAO.query(
				staffsRecordVO, pageController);
		logger.info("serviceImpl	query	end");
		return listStaffsRecord;
	}

	@Override
	public StaffsRecordVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<StaffsRecordVO> listStaffsRecord = StaffsRecordDAO
				.queryByIDs(id, null);
		if (listStaffsRecord != null && listStaffsRecord.size() == 1) {
			logger.info("serviceImpl	end");
			return listStaffsRecord.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<StaffsRecordVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<StaffsRecordVO> listStaffsRecord = StaffsRecordDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listStaffsRecord;
	}

	@Override
	public StaffsRecordVO modify(StaffsRecordVO staffsRecordVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		staffsRecordVO = StaffsRecordDAO.modify(staffsRecordVO, null);
		logger.info("serviceImpl	modify	end");
		return staffsRecordVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = StaffsRecordDAO.deleteByID(id, null);
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
		int num = StaffsRecordDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

	public static void main(String args[]) throws Exception {
		// DBConnection.setDbInfo("jdbc:oracle:thin:@10.1.3.182:1521:cinda",
		// "cinda", "cinda");
		DBConnection.setDbInfo(
				"jdbc:mysql://10.1.0.10:3306/icmp?characterEncoding=gb2312",
				"test", "123456");
		StaffsRecordVO vStaffsRecordVO = new StaffsRecordVO();
		vStaffsRecordVO.setStaffsRecordID("staffsRecordID");
		vStaffsRecordVO.setDepartmentName("departmentName");
		vStaffsRecordVO.setDepartmentID("departmentID");
		vStaffsRecordVO.setDepartmentNo("departmentNo");
		vStaffsRecordVO.setFacsimile("facsimile");
		vStaffsRecordVO.setMeetingRoomAddressOne("meetingRoomAddressOne");
		vStaffsRecordVO.setPeopleCountOne(8);
		vStaffsRecordVO.setMeetingRoomAddressTwo("meetingRoomAddressTwo");
		vStaffsRecordVO.setPeopleCountTwo(8);
		vStaffsRecordVO.setLeaderName("leaderName");
		vStaffsRecordVO.setLeaderMobile("leaderMobile");
		vStaffsRecordVO.setLeaderTel("leaderTel");
		vStaffsRecordVO.setTechnicalName("technicalName");
		vStaffsRecordVO.setTechnicalMobile("technicalMobile");
		vStaffsRecordVO.setTechnicalTel("technicalTel");
		vStaffsRecordVO.setTechnicalEmail("technicalEmail");
		vStaffsRecordVO.setNetTechnicalName("netTechnicalName");
		vStaffsRecordVO.setNetTechnicalMobile("netTechnicalMobile");
		vStaffsRecordVO.setNetTechnicalTel("netTechnicalTel");
		vStaffsRecordVO.setNetTechnicalEmail("netTechnicalEmail");
		vStaffsRecordVO.setCreatPersonID("creatPersonID");
		vStaffsRecordVO.setDescription("description");
		vStaffsRecordVO.setRevision(new Long(888));
		vStaffsRecordVO.setStatus(8);

		new StaffsRecordServiceImpl().add(vStaffsRecordVO);
		System.out.println("=========add Success!");

		ArrayList<StaffsRecordVO> lstStaffsRecord = new StaffsRecordServiceImpl()
				.query(vStaffsRecordVO, null);

		if (lstStaffsRecord.size() > 0) {
			System.out.println("=========query Result:");
			StaffsRecordVO vvStaffsRecordVO = (StaffsRecordVO) lstStaffsRecord
					.get(0);
			System.out.println("staffsRecordID="
					+ vvStaffsRecordVO.getStaffsRecordID());
			System.out.println("departmentName="
					+ vvStaffsRecordVO.getDepartmentName());
			System.out.println("departmentID="
					+ vvStaffsRecordVO.getDepartmentID());
			System.out.println("departmentNo="
					+ vvStaffsRecordVO.getDepartmentNo());
			System.out.println("facsimile=" + vvStaffsRecordVO.getFacsimile());
			System.out.println("meetingRoomAddressOne="
					+ vvStaffsRecordVO.getMeetingRoomAddressOne());
			System.out.println("peopleCountOne="
					+ vvStaffsRecordVO.getPeopleCountOne());
			System.out.println("meetingRoomAddressTwo="
					+ vvStaffsRecordVO.getMeetingRoomAddressTwo());
			System.out.println("peopleCountTwo="
					+ vvStaffsRecordVO.getPeopleCountTwo());
			System.out
					.println("leaderName=" + vvStaffsRecordVO.getLeaderName());
			System.out.println("leaderMobile="
					+ vvStaffsRecordVO.getLeaderMobile());
			System.out.println("leaderTel=" + vvStaffsRecordVO.getLeaderTel());
			System.out.println("technicalName="
					+ vvStaffsRecordVO.getTechnicalName());
			System.out.println("technicalMobile="
					+ vvStaffsRecordVO.getTechnicalMobile());
			System.out.println("technicalTel="
					+ vvStaffsRecordVO.getTechnicalTel());
			System.out.println("technicalEmail="
					+ vvStaffsRecordVO.getTechnicalEmail());
			System.out.println("netTechnicalName="
					+ vvStaffsRecordVO.getNetTechnicalName());
			System.out.println("netTechnicaMobile="
					+ vvStaffsRecordVO.getNetTechnicalMobile());
			System.out.println("netTechnicaTel="
					+ vvStaffsRecordVO.getNetTechnicalTel());
			System.out.println("netTechnicaEmail="
					+ vvStaffsRecordVO.getNetTechnicalEmail());
			System.out.println("creatPersonID="
					+ vvStaffsRecordVO.getCreatPersonID());
			System.out
					.println("createDate=" + vvStaffsRecordVO.getCreateDate());
			System.out.println("description="
					+ vvStaffsRecordVO.getDescription());
			System.out.println("revision=" + vvStaffsRecordVO.getRevision());
			System.out.println("status=" + vvStaffsRecordVO.getStatus());

		} else {
			System.out
					.println("=========query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
		}

	}

}
