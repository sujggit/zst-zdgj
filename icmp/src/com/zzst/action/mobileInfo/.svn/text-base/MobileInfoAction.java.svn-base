package com.zzst.action.mobileInfo;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.model.mobileInfo.MobileInfoVO;
import com.zzst.service.mobileInfo.MobileInfoService;
import com.zzst.service.mobileInfo.MobileInfoServiceImpl;
public class MobileInfoAction extends CjfAction {

	/**/
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(MobileInfoAction.class.getName());
	private ArrayList<MobileInfoVO> mobileInfoList = new ArrayList<MobileInfoVO>();
	private MobileInfoVO mobileInfoVO = new MobileInfoVO();
	public String querymobileInfo(){
		logger.info("MobileInfoAction.querymobileInfo begin......");
		MobileInfoService mis = new MobileInfoServiceImpl();
		try {
			mobileInfoList = mis.query(new MobileInfoVO(), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String deleteMobileInfo(){
		logger.info("MobileInfoAction.deleteMobileInfo begin......");
		MobileInfoService mis = new MobileInfoServiceImpl();
		try {
			mis.deleteByID(mobileInfoVO.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String beforeModifyMobileInfo(){
		logger.info("MobileInfoAction.beforeModifyMobileInfo begin......");
		MobileInfoService mis = new MobileInfoServiceImpl();
		try {
			mobileInfoVO = mis.queryByID(mobileInfoVO.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String modifyMobileInfo(){
		logger.info("MobileInfoAction.modifyMobileInfo begin......");
		MobileInfoService mis = new MobileInfoServiceImpl();
		try {
			mis.modify(mobileInfoVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String addMobileInfo(){
		logger.info("MobileInfoAction.addMobileInfo begin......");
		MobileInfoService mis = new MobileInfoServiceImpl();
		try {
			mis.add(mobileInfoVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	public ArrayList<MobileInfoVO> getMobileInfoList() {
		return mobileInfoList;
	}
	public void setMobileInfoList(ArrayList<MobileInfoVO> mobileInfoList) {
		this.mobileInfoList = mobileInfoList;
	}
	public MobileInfoVO getMobileInfoVO() {
		return mobileInfoVO;
	}
	public void setMobileInfoVO(MobileInfoVO mobileInfoVO) {
		this.mobileInfoVO = mobileInfoVO;
	}
	
}
