/**
 * 
 */
package com.zzst.dao.meeting.kst;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.kst.CameraGroup;


/**
 * 
 * @author zhangliang
 * Mar 27, 2012 6:37:24 PM
 */
public class CameraMQB  extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(CameraMQB.class.getName());

	public static int QUERY_FROM_CAMERA = 1;
	private CameraGroup camera;
	private boolean res = false;
	private int _operatorType = -1;
	private ArrayList<CameraGroup> clist = new ArrayList<CameraGroup>();
	
	public CameraMQB (int operatorType) {
		_operatorType = operatorType;

	}
	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		if (QUERY_FROM_CAMERA == _operatorType) {
			camera = new CameraGroup();
			camera.setGroupid(rs.getString("groupid"));
			camera.setDomainid(rs.getString("domainid"));
			camera.setGroupname(rs.getString("groupname"));
			camera.setLeaf(rs.getInt("leaf"));
			camera.setParent_id(rs.getString("parent_id"));
			camera.setType(rs.getString("type"));
			clist.add(camera);
		}
		
	}
	/**
	 * @return the clist
	 */
	public ArrayList<CameraGroup> getClist() {
		return clist;
	}
	/**
	 * @return the camera
	 */
	public CameraGroup getCamera() {
		return camera;
	}
	/**
	 * @return the res
	 */
	public boolean isRes() {
		return res;
	}

}
