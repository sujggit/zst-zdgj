package com.zzst.action.meeting.address;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.config.BaseInfoAction;
import com.zzst.model.meeting.address.AddressVO;
import com.zzst.service.meeting.address.AddressService;
import com.zzst.service.meeting.address.AddressServiceImpl;

public class AddressAction extends CjfAction{
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(BaseInfoAction.class.getName());
	
	private AddressVO addressVO = new AddressVO();
	
	private ArrayList<AddressVO> addressVOList = new ArrayList<AddressVO>();
	
	//查询
	public String querryAddressList(){
		AddressService addressService = new AddressServiceImpl();
		try {
			addressVOList = addressService.query(addressVO, getPageControler());
		} catch (Exception e) {
			logger.error("querryAddressList error : "+e.getMessage());
			e.printStackTrace();
		}
		return "success";
	}
	
	//添加
	public String addAddressBefore(){
		return "success";
	}
	
	public String addAddress(){
		AddressService addressService = new AddressServiceImpl();
		//TODO
		try {
			addressService.add(addressVO);
		} catch (Exception e) {
			logger.error("querryAddressList error : "+e.getMessage());
		}
		addressVO = new AddressVO();
		return "success";
	}
	
	//修改
	public String modifyAddressBefore(){
		AddressService addressService = new AddressServiceImpl();
		//TODO
		try {
			addressVO = addressService.queryByID(addressVO.getAddressID());
		}catch (Exception e) {
			logger.error("querryAddressList error : "+e.getMessage());
			e.printStackTrace();
		}
		return "success";
	}
	
	public String modifyAddress(){
		AddressService addressService = new AddressServiceImpl();
		//TODO
		try {
			addressService.modify(addressVO);
		}catch (Exception e) {
			logger.error("querryAddressList error : "+e.getMessage());
			e.printStackTrace();
		}
		addressVO = new AddressVO();
		return "success";
	}
	
	//删除
	public String delAddress(){
		AddressService addressService = new AddressServiceImpl();
		//TODO
		try {
			addressService.deleteByID(addressVO.getAddressID());
		}catch (Exception e) {
			logger.error("querryAddressList error : "+e.getMessage());
			e.printStackTrace();
		}
		addressVO = new AddressVO();
		return "success";
	}
	
	//查看详情
	public String detailAddress(){
		AddressService addressService = new AddressServiceImpl();
		//TODO
		try {
			addressVO =addressService.queryByID(addressVO.getAddressID());
		} catch (Exception e) {
			logger.error("querryAddressList error : "+e.getMessage());
			e.printStackTrace();
		}
		return "success";
	}
	
	public String queryCheck()
	{
		logger.info("FuncAction		queryCheck	begin");
		AddressService addressService = new AddressServiceImpl();
		try {
			//查询全部功能
			addressVOList = addressService.query(null, null);
			
			logger.info("AddressAction		queryCheck	end");
		}catch (Exception e) {
			logger.error("AddressAction		ququeryCheckery	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("AddressAction		queryCheck	end");
		return SUCCESS;
	}

	public AddressVO getAddressVO() {
		return addressVO;
	}

	public void setAddressVO(AddressVO addressVO) {
		this.addressVO = addressVO;
	}


	public void setAddressVOList(ArrayList<AddressVO> addressVOList) {
		this.addressVOList = addressVOList;
	}


	public ArrayList<AddressVO> getAddressVOList() {
		return addressVOList;
	}
}
