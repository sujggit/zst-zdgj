package com.zzst.dao.meeting.dataInterface.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.dataInterface.user.UserInterfaceVO;

/**
 * class description: UserInterface MQB
 * 
 * @date Tue Jun 18 18:58:24 CST 2013
 * @author ryan
 */
public class UserInterfaceMQB extends MasterQueryObject {
	static Logger logger = CbfLogger
			.getLogger(UserInterfaceMQB.class.getName());

	public static int QUERY_FROM_USERINTERFACE = 1;
	public static int QUERY_FROM_USERINTERFACE_BY_IDS = 2;
	public static int QUERY_FROM_USERINTERFACE_AVAILABLE = 3;

	private UserInterfaceVO userInterfaceVO;
	private ArrayList<UserInterfaceVO> listUserInterface = new ArrayList<UserInterfaceVO>();

	private int _operatorType = -1;
	private String ids = "";

	public UserInterfaceMQB(int operatorType, UserInterfaceVO userInterfaceVO) {
		_operatorType = operatorType;
		this.userInterfaceVO = userInterfaceVO;
		makeSql();
	}

	public UserInterfaceMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql
				.append("select userid,userno,password,loginname,dispname,fullname,positionid,positionname,ordernum,sex,mobilephone,telphone,email,status,lastlogintime,sysproperty,birthdate,birthyear,birthmonth,birthday,userdesc,departmentid,departmentname,roleid,rolename,revision,usertype,createtime,creatorid,creatorname,importstatus,importdesc ");
		strsql.append(" from z_t_interface_in_user ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_USERINTERFACE == _operatorType) {
			if (null != userInterfaceVO) {
				if (!StringUtils.isNullOrBlank(userInterfaceVO.getUserid())) {
					strsql.append(" and userid= ? ");
					super.addStringForField(userInterfaceVO.getUserid());
				}
				if (!StringUtils.isNullOrBlank(userInterfaceVO.getUserno())) {
					strsql.append(" and userno= ? ");
					super.addStringForField(userInterfaceVO.getUserno());
				}
				if (!StringUtils.isNullOrBlank(userInterfaceVO.getPassword())) {
					strsql.append(" and password= ? ");
					super.addStringForField(userInterfaceVO.getPassword());
				}
				if (!StringUtils.isNullOrBlank(userInterfaceVO.getLoginname())) {
					strsql.append(" and loginname like ? ");
					super.addStringForField("%"+userInterfaceVO.getLoginname().trim()+"%");
				}
				if (!StringUtils.isNullOrBlank(userInterfaceVO.getDispname())) {
					strsql.append(" and dispname= ? ");
					super.addStringForField(userInterfaceVO.getDispname());
				}
				if (!StringUtils.isNullOrBlank(userInterfaceVO.getFullname())) {
					strsql.append(" and fullname= ? ");
					super.addStringForField(userInterfaceVO.getFullname());
				}
				if (!StringUtils.isNullOrBlank(userInterfaceVO.getPositionid())) {
					strsql.append(" and positionid= ? ");
					super.addStringForField(userInterfaceVO.getPositionid());
				}
				if (!StringUtils.isNullOrBlank(userInterfaceVO
						.getPositionname())) {
					strsql.append(" and positionname= ? ");
					super.addStringForField(userInterfaceVO.getPositionname());
				}
				if (Integer.MIN_VALUE != userInterfaceVO.getOrdernum()) {
					strsql.append(" and ordernum= ? ");
					super.addIntForField(userInterfaceVO.getOrdernum());
				}
				if (!StringUtils.isNullOrBlank(userInterfaceVO.getSex())) {
					strsql.append(" and sex= ? ");
					super.addStringForField(userInterfaceVO.getSex());
				}
				if (!StringUtils
						.isNullOrBlank(userInterfaceVO.getMobilephone())) {
					strsql.append(" and mobilephone= ? ");
					super.addStringForField(userInterfaceVO.getMobilephone());
				}
				if (!StringUtils.isNullOrBlank(userInterfaceVO.getTelphone())) {
					strsql.append(" and telphone= ? ");
					super.addStringForField(userInterfaceVO.getTelphone());
				}
				if (!StringUtils.isNullOrBlank(userInterfaceVO.getEmail())) {
					strsql.append(" and email= ? ");
					super.addStringForField(userInterfaceVO.getEmail());
				}
				if (!StringUtils.isNullOrBlank(userInterfaceVO.getStatus())) {
					strsql.append(" and status= ? ");
					super.addStringForField(userInterfaceVO.getStatus());
				}
				if (!StringUtils
						.isNullOrBlank(userInterfaceVO.getSysproperty())) {
					strsql.append(" and sysproperty= ? ");
					super.addStringForField(userInterfaceVO.getSysproperty());
				}
				if (Integer.MIN_VALUE != userInterfaceVO.getBirthyear()) {
					strsql.append(" and birthyear= ? ");
					super.addIntForField(userInterfaceVO.getBirthyear());
				}
				if (Integer.MIN_VALUE != userInterfaceVO.getBirthmonth()) {
					strsql.append(" and birthmonth= ? ");
					super.addIntForField(userInterfaceVO.getBirthmonth());
				}
				if (Integer.MIN_VALUE != userInterfaceVO.getBirthday()) {
					strsql.append(" and birthday= ? ");
					super.addIntForField(userInterfaceVO.getBirthday());
				}
				if (!StringUtils.isNullOrBlank(userInterfaceVO.getUserdesc())) {
					strsql.append(" and userdesc= ? ");
					super.addStringForField(userInterfaceVO.getUserdesc());
				}
				if (!StringUtils.isNullOrBlank(userInterfaceVO
						.getDepartmentid())) {
					strsql.append(" and departmentid= ? ");
					super.addStringForField(userInterfaceVO.getDepartmentid());
				}
				if (!StringUtils.isNullOrBlank(userInterfaceVO
						.getDepartmentname())) {
					strsql.append(" and departmentname= ? ");
					super
							.addStringForField(userInterfaceVO
									.getDepartmentname());
				}
				if (!StringUtils.isNullOrBlank(userInterfaceVO.getRoleid())) {
					strsql.append(" and roleid= ? ");
					super.addStringForField(userInterfaceVO.getRoleid());
				}
				if (!StringUtils.isNullOrBlank(userInterfaceVO.getRolename())) {
					strsql.append(" and rolename= ? ");
					super.addStringForField(userInterfaceVO.getRolename());
				}
				if (Integer.MIN_VALUE != userInterfaceVO.getRevision()) {
					strsql.append(" and revision= ? ");
					super.addIntForField(userInterfaceVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(userInterfaceVO.getUsertype())) {
					strsql.append(" and usertype= ? ");
					super.addStringForField(userInterfaceVO.getUsertype());
				}
				if (!StringUtils.isNullOrBlank(userInterfaceVO.getCreatorid())) {
					strsql.append(" and creatorid= ? ");
					super.addStringForField(userInterfaceVO.getCreatorid());
				}
				if (!StringUtils
						.isNullOrBlank(userInterfaceVO.getCreatorname())) {
					strsql.append(" and creatorname= ? ");
					super.addStringForField(userInterfaceVO.getCreatorname());
				}
				if (Integer.MIN_VALUE != userInterfaceVO.getImportstatus()) {
					strsql.append(" and importstatus= ? ");
					super.addIntForField(userInterfaceVO.getImportstatus());
				}
				if (!StringUtils.isNullOrBlank(userInterfaceVO.getImportdesc())) {
					strsql.append(" and importdesc= ? ");
					super.addStringForField(userInterfaceVO.getImportdesc());
				}
			}
		} else if (QUERY_FROM_USERINTERFACE_BY_IDS == _operatorType) {
			strsql.append(" and userid in (?) ");
			super.addStringForField(ids);
		} else if ( QUERY_FROM_USERINTERFACE_AVAILABLE == _operatorType ){
			strsql.append(" and importstatus != 1");
		}
		setSql(strsql.toString());
	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public String getSql() {
		return this.sqlStr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		userInterfaceVO = new UserInterfaceVO();
		userInterfaceVO.setUserid(rs.getString("userid"));
		userInterfaceVO.setUserno(rs.getString("userno"));
		userInterfaceVO.setPassword(rs.getString("password"));
		userInterfaceVO.setLoginname(rs.getString("loginname"));
		userInterfaceVO.setDispname(rs.getString("dispname"));
		userInterfaceVO.setFullname(rs.getString("fullname"));
		userInterfaceVO.setPositionid(rs.getString("positionid"));
		userInterfaceVO.setPositionname(rs.getString("positionname"));
		userInterfaceVO.setOrdernum(rs.getInt("ordernum"));
		userInterfaceVO.setSex(rs.getString("sex"));
		userInterfaceVO.setMobilephone(rs.getString("mobilephone"));
		userInterfaceVO.setTelphone(rs.getString("telphone"));
		userInterfaceVO.setEmail(rs.getString("email"));
		userInterfaceVO.setStatus(rs.getString("status"));
		userInterfaceVO.setLastlogintime(rs.getTimestamp("lastlogintime"));
		userInterfaceVO.setSysproperty(rs.getString("sysproperty"));
		userInterfaceVO.setBirthdate(rs.getTimestamp("birthdate"));
		userInterfaceVO.setBirthyear(rs.getInt("birthyear"));
		userInterfaceVO.setBirthmonth(rs.getInt("birthmonth"));
		userInterfaceVO.setBirthday(rs.getInt("birthday"));
		userInterfaceVO.setUserdesc(rs.getString("userdesc"));
		userInterfaceVO.setDepartmentid(rs.getString("departmentid"));
		userInterfaceVO.setDepartmentname(rs.getString("departmentname"));
		userInterfaceVO.setRoleid(rs.getString("roleid"));
		userInterfaceVO.setRolename(rs.getString("rolename"));
		userInterfaceVO.setRevision(rs.getInt("revision"));
		userInterfaceVO.setUsertype(rs.getString("usertype"));
		userInterfaceVO.setCreatetime(rs.getTimestamp("createtime"));
		userInterfaceVO.setCreatorid(rs.getString("creatorid"));
		userInterfaceVO.setCreatorname(rs.getString("creatorname"));
		userInterfaceVO.setImportstatus(rs.getInt("importstatus"));
		userInterfaceVO.setImportdesc(rs.getString("importdesc"));
		listUserInterface.add(userInterfaceVO);
	}

	public ArrayList<UserInterfaceVO> getUserInterfaceList() {
		return listUserInterface;
	}

	public UserInterfaceVO getUserInterfaceVO() {
		return userInterfaceVO;
	}

}
