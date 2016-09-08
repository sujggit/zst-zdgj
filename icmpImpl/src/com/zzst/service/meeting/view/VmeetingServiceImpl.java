package com.zzst.service.meeting.view;

import java.util.List;

import com.cbf.db.PageController;
import com.zzst.dao.view.VmeetingDAO;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.view.VmeetingVO;
import com.zzst.service.meeting.levelConfig.LevelConfigServiceImpl;

public class VmeetingServiceImpl implements VmeetingService {

	@Override
	public List<VmeetingVO> getAll(VmeetingVO mv, PageController mPageController) {
        //////////////////////////分级分权@author:zhangjy///////////////////////
		try {
			if(mv.isLevel()){
				LevelConfigServiceImpl lcs=new LevelConfigServiceImpl();
				mv.setLsql(lcs.queryByTypeAndLid(mv.getLsql(), LevelEnum.LEVEL_ROOM));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		////////////////////////////////END////////////////////////////////////////
		return VmeetingDAO.getAll(mv, mPageController);
	}

	@Override
	public List<VmeetingVO> getAllGroupBY(VmeetingVO mv,
			PageController mPageController) {
		// TODO Auto-generated method stub
		 //////////////////////////分级分权@author:zhangjy///////////////////////
		try {
			if(mv.isLevel()){
				LevelConfigServiceImpl lcs=new LevelConfigServiceImpl();
				mv.setLsql(lcs.queryByTypeAndLid(mv.getLsql(), LevelEnum.LEVEL_ROOM));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		////////////////////////////////END////////////////////////////////////////
		return VmeetingDAO.getAllGroupBY(mv, mPageController);
	}

	@Override
	public List<VmeetingVO> getNumAndTime(VmeetingVO mv,
			PageController mPageController) {
		  //////////////////////////分级分权@author:zhangjy///////////////////////
		try {
			if(mv.isLevel()){
				LevelConfigServiceImpl lcs=new LevelConfigServiceImpl();
				mv.setLsql(lcs.queryByTypeAndLid(mv.getLsql(), LevelEnum.LEVEL_ROOM));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		////////////////////////////////END////////////////////////////////////////
		return VmeetingDAO.getNumAndTime(mv, mPageController);
	}

	@Override
	public List<VmeetingVO> getAllChildGroupBY(VmeetingVO vm,
			PageController mPageController) {
		try {
			if(vm.isLevel()){
				LevelConfigServiceImpl lcs=new LevelConfigServiceImpl();
				vm.setLsql(lcs.queryByTypeAndLid(vm.getLsql(), LevelEnum.LEVEL_ROOM));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		////////////////////////////////END////////////////////////////////////////
		return VmeetingDAO.getAllChildGroupBY(vm, mPageController);
	}
}
