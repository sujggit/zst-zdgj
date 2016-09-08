package com.zzst.dao.meeting.department;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.enums.MeetingRoomEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.department.DepartmentVO;

/**
 * class description: Department MQB
 * 
 * @author ryan
 * @date Mon Aug 03 17:54:12 CST 2009
 */

public class DepartmentMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(DepartmentMQB.class.getName());

	public static int QUERY_FROM_DEPARTMENT = 1;
    public static int QUERY_FOR_ONE = 2;
	public static int QUERY_CHECK_CHILD = 3;
	public static int QUERY_CHILD = 4;
	
	private DepartmentVO vDepartmentVO;
	private boolean res = false;

	private ArrayList<DepartmentVO> lstDepartment = new ArrayList<DepartmentVO>();

	private int _operatorType = -1;

	public DepartmentMQB(int operatorType) {
		_operatorType = operatorType;

	}
	
	public DepartmentMQB(int operatorType,DepartmentVO vDepartmentVO) {
		_operatorType = operatorType;
		this.vDepartmentVO = vDepartmentVO;
		makeSql();
	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}
	
	public String getSql() {
		return this.sqlStr;
	}
	
	public void makeSql(){
		StringBuffer strsql = new StringBuffer();
		if(QUERY_FROM_DEPARTMENT == _operatorType){
			strsql.append("select * from z_t_department where 1=1");
			if (null != vDepartmentVO) {
				if (!StringUtils.isNullOrBlank(vDepartmentVO.getId())) {
					strsql.append(" and id= ? ");
					super.addStringForField(vDepartmentVO.getId());
				}
				if (!StringUtils.isNullOrBlank(vDepartmentVO.getParentId())) {
					strsql.append(" and parentId= ? ");
					super.addStringForField(vDepartmentVO.getParentId());
				}
				if (!StringUtils.isNullOrBlank(vDepartmentVO.getTitle())) {
					strsql.append(" and name= ? ");
					super.addStringForField(vDepartmentVO.getTitle());
				}
				if (!StringUtils.isNullOrBlank(vDepartmentVO.getDepNo())) {
					strsql.append(" and depNo= ? ");
					super.addStringForField(vDepartmentVO.getDepNo());
				}
			}
			strsql.append(" order by id");
		}
		setSql(strsql.toString());
		
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		if (QUERY_FROM_DEPARTMENT == _operatorType) {
			vDepartmentVO = new DepartmentVO();
			vDepartmentVO.setId(rs.getString("id"));
			vDepartmentVO.setParentId(rs.getString("parentID"));
			vDepartmentVO.setTitle(rs.getString("name"));
			vDepartmentVO.setLeaf(rs.getInt("leaf"));
			vDepartmentVO.setLinkCodeID(rs.getString("linkCodeID"));
			vDepartmentVO.setDepNo(rs.getString("depNo"));
			vDepartmentVO.setAddressID(rs.getString("addressID"));
			lstDepartment.add(vDepartmentVO);
		}
		else if(QUERY_FOR_ONE == _operatorType)
		{
			vDepartmentVO = new DepartmentVO();
			vDepartmentVO.setId(rs.getString("id"));
			vDepartmentVO.setParentId(rs.getString("parentID"));
			vDepartmentVO.setTitle(rs.getString("name"));
			vDepartmentVO.setLeaf(rs.getInt("leaf"));
			vDepartmentVO.setLinkCodeID(rs.getString("linkCodeID"));
			vDepartmentVO.setDepNo(rs.getString("depNo"));
			vDepartmentVO.setAddressID(rs.getString("addressID"));
		}
		else if(QUERY_CHECK_CHILD == _operatorType)
		{
			if(rs.getInt(1)>0)
				res =true;
		}else if (QUERY_CHILD == _operatorType) {
			vDepartmentVO = new DepartmentVO();
			vDepartmentVO.setId(rs.getString("id"));
			vDepartmentVO.setParentId(rs.getString("parentID"));
			vDepartmentVO.setTitle(rs.getString("name"));
			vDepartmentVO.setLeaf(rs.getInt("leaf"));
			vDepartmentVO.setLinkCodeID(rs.getString("linkCodeID"));
			vDepartmentVO.setDepNo(rs.getString("depNo"));
			vDepartmentVO.setAddressID(rs.getString("addressID"));
			lstDepartment.add(vDepartmentVO);
		}
	}

	public ArrayList<DepartmentVO> getDepartmentList() {
		return lstDepartment;

	}

	public DepartmentVO getDepartmentVO() {
		return vDepartmentVO;
	}

	/**
	 * @return the res
	 */
	public boolean getRes() {
		return res;
	}


}
