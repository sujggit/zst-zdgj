package com.zzst.service.meeting.kst;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.zzst.model.meeting.kst.CameraGroup;


/**
 *@Description
 *@date 2012-4-9上午10:33:42
 *@author ryan
 */
public interface KstVedioMoniterService {

	/**
	 * method description : 
	 * 
	 * @param ArrayList<CameraGroup> clist
	 * @param TransactionManager
	 * @return void
	 * @throws SQLException
	 */
	public void addKstVedioMoniter(ArrayList<CameraGroup> clist)
			throws Exception;
	
	/**
	 * method description : 
	 * 
	 * @return ArrayList<MeetingServiceVO>
	 * @throws SQLException
	 */
	public ArrayList<CameraGroup> getKstVedioMoniterList(CameraGroup cameraGroup,PageController pageController)
			throws SQLException;
	
	/***
	 * method description : 
	 * 
	 * @return void
	 * @throws SQLException
	 */
	public void delKstVedioMoniter()throws SQLException;
	
	
}
