package com.zzst.service.meeting.kst;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.dao.meeting.kst.CameraDAO;
import com.zzst.model.meeting.kst.CameraGroup;


/**
 *@Description	
 *@date 2012-4-9上午10:34:04
 *@author ryan
 */
public class KstVedioMoniterServiceImpl implements KstVedioMoniterService {

	@Override
	public void addKstVedioMoniter(ArrayList<CameraGroup> clist) throws Exception {
			CameraDAO.addCamera(clist, null);
	}

	@Override
	public ArrayList<CameraGroup> getKstVedioMoniterList(CameraGroup cameraGroup,PageController pageController) throws SQLException {
		return CameraDAO.getallgroupList(cameraGroup,pageController);
	}

	@Override
	public void delKstVedioMoniter() throws SQLException {
		CameraDAO.delCamera();
		
	}


}
