package com.zzst.service.meeting.view;

import java.util.List;

import com.cbf.db.PageController;
import com.zzst.dao.view.VmeetingDetailDAO;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.view.VmeetingDetailVO;
import com.zzst.service.meeting.levelConfig.LevelConfigServiceImpl;

public class VmeetingDetailServiceImpl implements VmeetingDetailService {

	@Override
	public List<VmeetingDetailVO> getAll(VmeetingDetailVO mv,
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
		return VmeetingDetailDAO.getAll(mv, mPageController);
	}

	@Override
	public List<VmeetingDetailVO> getAllGroupBY(VmeetingDetailVO mv,
			PageController mPageController) {
		// TODO Auto-generated method stub
		return null;
	}

}
