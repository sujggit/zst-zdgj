package com.zzst.meeting.service.comparison;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.comparison.ComparisonCriteriaDAO;
import com.zzst.model.meeting.comparison.ComparisonCriteriaVO;

import org.apache.log4j.Logger;

/**
 * class description: ComparisonCriteria ServiceImpl
 * 
 * @date Fri Apr 26 16:04:41 CST 2013
 * @author ryan
 */
public class ComparisonCriteriaServiceImpl implements ComparisonCriteriaService {
	private static Logger logger = CjfLogger
			.getLogger(ComparisonCriteriaServiceImpl.class.getName());

	@Override
	public ComparisonCriteriaVO add(ComparisonCriteriaVO comparisonCriteriaVO)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		comparisonCriteriaVO = ComparisonCriteriaDAO.add(comparisonCriteriaVO,
				null);
		logger.info("serviceImpl	add	end");
		return comparisonCriteriaVO;
	}

	@Override
	public ArrayList<ComparisonCriteriaVO> query(
			ComparisonCriteriaVO comparisonCriteriaVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<ComparisonCriteriaVO> listComparisonCriteria = ComparisonCriteriaDAO
				.query(comparisonCriteriaVO, pageController);
		logger.info("serviceImpl	query	end");
		return listComparisonCriteria;
	}

	@Override
	public ComparisonCriteriaVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<ComparisonCriteriaVO> listComparisonCriteria = ComparisonCriteriaDAO
				.queryByIDs(id, null);
		if (listComparisonCriteria != null
				&& listComparisonCriteria.size() == 1) {
			logger.info("serviceImpl	end");
			return listComparisonCriteria.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<ComparisonCriteriaVO> queryByIDs(String ids)
			throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<ComparisonCriteriaVO> listComparisonCriteria = ComparisonCriteriaDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listComparisonCriteria;
	}

	@Override
	public ComparisonCriteriaVO modify(ComparisonCriteriaVO comparisonCriteriaVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		comparisonCriteriaVO = ComparisonCriteriaDAO.modify(
				comparisonCriteriaVO, null);
		logger.info("serviceImpl	modify	end");
		return comparisonCriteriaVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = ComparisonCriteriaDAO.deleteByID(id, null);
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
		int num = ComparisonCriteriaDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

	public static void main(String args[]) throws Exception {
		// DBConnection.setDbInfo("jdbc:oracle:thin:@10.1.3.182:1521:cinda",
		// "cinda", "cinda");
		DBConnection.setDbInfo(
				"jdbc:mysql://localhost:3306/icmp?characterEncoding=gb2312",
				"root", "yume");
		ComparisonCriteriaVO vComparisonCriteriaVO = new ComparisonCriteriaVO();
		vComparisonCriteriaVO.setComCriteriaID("ComCriteriaID");
		vComparisonCriteriaVO.setRsGap_Good_lower(8);
		vComparisonCriteriaVO.setRsGap_Good_upper(8);
		vComparisonCriteriaVO.setRsGap_Ok_lower(8);
		vComparisonCriteriaVO.setRsGap_Ok_upper(8);
		vComparisonCriteriaVO.setGsGap_Good_lower(8);
		vComparisonCriteriaVO.setGsGap_Good_upper(8);
		vComparisonCriteriaVO.setGsGap_Ok_lower(8);
		vComparisonCriteriaVO.setGsGap_Ok_upper(8);
		vComparisonCriteriaVO.setBsGap_Good_lower(8);
		vComparisonCriteriaVO.setBsGap_Good_upper(8);
		vComparisonCriteriaVO.setBsGap_Ok_lower(8);
		vComparisonCriteriaVO.setBsGap_Ok_upper(8);
		vComparisonCriteriaVO.setX_min(8);
		vComparisonCriteriaVO.setX_max(8);
		vComparisonCriteriaVO.setUpdateUserID("updateUserID");
		vComparisonCriteriaVO.setUpdateTime(new Timestamp(System
				.currentTimeMillis()));
		vComparisonCriteriaVO.setDescription("description");
		vComparisonCriteriaVO.setRevision(new Long(888));

		new ComparisonCriteriaServiceImpl().add(vComparisonCriteriaVO);
		System.out.println("=========add Success!");

		ArrayList<ComparisonCriteriaVO> lstComparisonCriteria = new ComparisonCriteriaServiceImpl()
				.query(vComparisonCriteriaVO, null);

		if (lstComparisonCriteria.size() > 0) {
			System.out.println("=========query Result:");
			ComparisonCriteriaVO vvComparisonCriteriaVO = (ComparisonCriteriaVO) lstComparisonCriteria
					.get(0);
			System.out.println("ComCriteriaID="
					+ vvComparisonCriteriaVO.getComCriteriaID());
			System.out.println("rsGap_Good_lower="
					+ vvComparisonCriteriaVO.getRsGap_Good_lower());
			System.out.println("rsGap_Good_upper="
					+ vvComparisonCriteriaVO.getRsGap_Good_upper());
			System.out.println("rsGap_Ok_lower="
					+ vvComparisonCriteriaVO.getRsGap_Ok_lower());
			System.out.println("rsGap_Ok_upper="
					+ vvComparisonCriteriaVO.getRsGap_Ok_upper());
			System.out.println("gsGap_Good_lower="
					+ vvComparisonCriteriaVO.getGsGap_Good_lower());
			System.out.println("gsGap_Good_upper="
					+ vvComparisonCriteriaVO.getGsGap_Good_upper());
			System.out.println("gsGap_Ok_lower="
					+ vvComparisonCriteriaVO.getGsGap_Ok_lower());
			System.out.println("gsGap_Ok_upper="
					+ vvComparisonCriteriaVO.getGsGap_Ok_upper());
			System.out.println("bsGap_Good_lower="
					+ vvComparisonCriteriaVO.getBsGap_Good_lower());
			System.out.println("bsGap_Good_upper="
					+ vvComparisonCriteriaVO.getBsGap_Good_upper());
			System.out.println("bsGap_Ok_lower="
					+ vvComparisonCriteriaVO.getBsGap_Ok_lower());
			System.out.println("bsGap_Ok_upper="
					+ vvComparisonCriteriaVO.getBsGap_Ok_upper());
			System.out.println("x_min=" + vvComparisonCriteriaVO.getX_min());
			System.out.println("x_max=" + vvComparisonCriteriaVO.getX_max());
			System.out.println("updateUserID="
					+ vvComparisonCriteriaVO.getUpdateUserID());
			System.out.println("updateTime="
					+ vvComparisonCriteriaVO.getUpdateTime());
			System.out.println("description="
					+ vvComparisonCriteriaVO.getDescription());
			System.out.println("revision="
					+ vvComparisonCriteriaVO.getRevision());

		} else {
			System.out
					.println("=========query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
		}

	}

}
