package com.zzst.action.meeting.camera;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfAction;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.meeting.kst.WallPresetVO;
import com.zzst.service.meeting.kst.WallPresetService;

public class WallPresetAction extends CjfAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private WallPresetVO wallPresetVO = new WallPresetVO();
	
	private ArrayList<WallPresetVO> wallPresetList = new ArrayList<WallPresetVO>();
	
	
	
	public String queryForWallPreset(){
		WallPresetService wallPresetService = ServiceFactory.getWallPresetService();
		try {
			PageController pc = this.getPageControler();
			pc.setPageSize(20);
			wallPresetList = wallPresetService.query(wallPresetVO, pc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "success";
	}


	public WallPresetVO getWallPresetVO() {
		return wallPresetVO;
	}


	public void setWallPresetVO(WallPresetVO wallPresetVO) {
		this.wallPresetVO = wallPresetVO;
	}


	public void setWallPresetList(ArrayList<WallPresetVO> wallPresetList) {
		this.wallPresetList = wallPresetList;
	}


	public ArrayList<WallPresetVO> getWallPresetList() {
		return wallPresetList;
	}

}
