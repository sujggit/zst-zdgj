package com.zzst.service.meeting.address;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.address.AddressDAO;
import com.zzst.model.enums.AddressEnu;
import com.zzst.model.meeting.address.AddressVO;

/**
 * class description: Address ServiceImpl
 * 
 * @date Tue Jul 10 17:01:48 CST 2012
 * @author ryan
 */
public class AddressServiceImpl implements AddressService {
	private static Logger logger = CjfLogger.getLogger(AddressServiceImpl.class.getName());

	//判断当前节点有没有子节点
	public boolean ishaveChild(String id) throws Exception {
		// TODO Auto-generated method stub
		return AddressDAO.ishaveChild(id);
	}

	

	public ArrayList<AddressVO> queryAllchildrenByID(String id) throws Exception{
		logger.info("queryAllchildrenByID	query	begin");
		ArrayList<AddressVO> listAddress = (ArrayList<AddressVO>) AddressDAO.getChildrenById(id);
		logger.info("queryAllchildrenByID	query	end");
		return listAddress;
	}
	
	
	@Override
	public AddressVO add(AddressVO addressVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		addressVO.setStatus(AddressEnu.VALID);
		addressVO = AddressDAO.add(addressVO, null);
		logger.info("serviceImpl	add	end");
		return addressVO;
	}

	@Override
	public ArrayList<AddressVO> query(AddressVO addressVO, PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<AddressVO> listAddress = AddressDAO.query(addressVO, pageController);
		logger.info("serviceImpl	query	end");
		return listAddress;
	}

	@Override
	public AddressVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<AddressVO> listAddress = AddressDAO.queryByIDs(id, null);
		if (listAddress != null && listAddress.size() == 1) {
			logger.info("serviceImpl	end");
			return listAddress.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<AddressVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<AddressVO> listAddress = AddressDAO.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listAddress;
	}

	@Override
	public AddressVO modify(AddressVO addressVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		addressVO = AddressDAO.modify(addressVO, null);
		logger.info("serviceImpl	modify	end");
		return addressVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = AddressDAO.deleteByID(id, null);
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
		int num = AddressDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

}
