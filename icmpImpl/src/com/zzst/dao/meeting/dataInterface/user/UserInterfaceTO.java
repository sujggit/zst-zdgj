package com.zzst.dao.meeting.dataInterface.user;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.dataInterface.user.UserInterfaceVO;

/**
 * class description: UserInterface TO
 * 
 * @date Tue Jun 18 18:58:24 CST 2013
 * @author ryan
 */
public class UserInterfaceTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(UserInterfaceTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_USERINTERFACE = 1;
	public static int MODIFY_USERINTERFACE = 2;
	public static int DEL_USERINTERFACE = 3;
	public static int DEL_ALL = 4;
	
	private int result = 0;

	private UserInterfaceVO userInterfaceVO;
	private String ids = "";

	public UserInterfaceTO(int operatorType, UserInterfaceVO userInterfaceVO) {
		this.operatorType = operatorType;
		this.userInterfaceVO = userInterfaceVO;
	}

	public UserInterfaceTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_USERINTERFACE == operatorType) {
			sqlstr.append("insert into z_t_interface_in_user ");
			sqlstr
					.append("(userid,userno,password,loginname,dispname,fullname,positionid,positionname,ordernum,sex,mobilephone,telphone,email,status,lastlogintime,sysproperty,birthdate,birthyear,birthmonth,birthday,userdesc,departmentid,departmentname,roleid,rolename,revision,usertype,createtime,creatorid,creatorname,importstatus,importdesc)");
			sqlstr
					.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(userInterfaceVO.getUserid());
			super.addStringForField(userInterfaceVO.getUserno());
			super.addStringForField(userInterfaceVO.getPassword());
			super.addStringForField(userInterfaceVO.getLoginname());
			super.addStringForField(userInterfaceVO.getDispname());
			super.addStringForField(userInterfaceVO.getFullname());
			super.addStringForField(userInterfaceVO.getPositionid());
			super.addStringForField(userInterfaceVO.getPositionname());
			super.addIntForField(userInterfaceVO.getOrdernum());
			super.addStringForField(userInterfaceVO.getSex());
			super.addStringForField(userInterfaceVO.getMobilephone());
			super.addStringForField(userInterfaceVO.getTelphone());
			super.addStringForField(userInterfaceVO.getEmail());
			super.addStringForField(userInterfaceVO.getStatus());
			super.addTimestampForField(userInterfaceVO.getLastlogintime());
			super.addStringForField(userInterfaceVO.getSysproperty());
			super.addTimestampForField(userInterfaceVO.getBirthdate());
			super.addIntForField(userInterfaceVO.getBirthyear());
			super.addIntForField(userInterfaceVO.getBirthmonth());
			super.addIntForField(userInterfaceVO.getBirthday());
			super.addStringForField(userInterfaceVO.getUserdesc());
			super.addStringForField(userInterfaceVO.getDepartmentid());
			super.addStringForField(userInterfaceVO.getDepartmentname());
			super.addStringForField(userInterfaceVO.getRoleid());
			super.addStringForField(userInterfaceVO.getRolename());
			super.addIntForField(userInterfaceVO.getRevision());
			super.addStringForField(userInterfaceVO.getUsertype());
			super.addTimestampForField(userInterfaceVO.getCreatetime());
			super.addStringForField(userInterfaceVO.getCreatorid());
			super.addStringForField(userInterfaceVO.getCreatorname());
			super.addIntForField(userInterfaceVO.getImportstatus());
			super.addStringForField(userInterfaceVO.getImportdesc());
		} else if (MODIFY_USERINTERFACE == operatorType) {
			sqlstr.append("update  z_t_interface_in_user set ");
			sqlstr.append(" userid = userid ");

			if (userInterfaceVO.getUserno() != null) {
				sqlstr.append(" , userno=? ");
				super.addStringForField(userInterfaceVO.getUserno());
			}

			if (userInterfaceVO.getPassword() != null) {
				sqlstr.append(" , password=? ");
				super.addStringForField(userInterfaceVO.getPassword());
			}

			if (userInterfaceVO.getLoginname() != null) {
				sqlstr.append(" , loginname=? ");
				super.addStringForField(userInterfaceVO.getLoginname());
			}

			if (userInterfaceVO.getDispname() != null) {
				sqlstr.append(" , dispname=? ");
				super.addStringForField(userInterfaceVO.getDispname());
			}

			if (userInterfaceVO.getFullname() != null) {
				sqlstr.append(" , fullname=? ");
				super.addStringForField(userInterfaceVO.getFullname());
			}

			if (userInterfaceVO.getPositionid() != null) {
				sqlstr.append(" , positionid=? ");
				super.addStringForField(userInterfaceVO.getPositionid());
			}

			if (userInterfaceVO.getPositionname() != null) {
				sqlstr.append(" , positionname=? ");
				super.addStringForField(userInterfaceVO.getPositionname());
			}

			if (userInterfaceVO.getOrdernum() != Integer.MIN_VALUE) {
				sqlstr.append(" , ordernum=?");
				super.addIntForField(userInterfaceVO.getOrdernum());
			}

			if (userInterfaceVO.getSex() != null) {
				sqlstr.append(" , sex=? ");
				super.addStringForField(userInterfaceVO.getSex());
			}

			if (userInterfaceVO.getMobilephone() != null) {
				sqlstr.append(" , mobilephone=? ");
				super.addStringForField(userInterfaceVO.getMobilephone());
			}

			if (userInterfaceVO.getTelphone() != null) {
				sqlstr.append(" , telphone=? ");
				super.addStringForField(userInterfaceVO.getTelphone());
			}

			if (userInterfaceVO.getEmail() != null) {
				sqlstr.append(" , email=? ");
				super.addStringForField(userInterfaceVO.getEmail());
			}

			if (userInterfaceVO.getStatus() != null) {
				sqlstr.append(" , status=? ");
				super.addStringForField(userInterfaceVO.getStatus());
			}

			if (userInterfaceVO.getLastlogintime() != null) {
				sqlstr.append(" , lastlogintime=? ");
				super.addTimestampForField(userInterfaceVO.getLastlogintime());
			}

			if (userInterfaceVO.getSysproperty() != null) {
				sqlstr.append(" , sysproperty=? ");
				super.addStringForField(userInterfaceVO.getSysproperty());
			}

			if (userInterfaceVO.getBirthdate() != null) {
				sqlstr.append(" , birthdate=? ");
				super.addTimestampForField(userInterfaceVO.getBirthdate());
			}

			if (userInterfaceVO.getBirthyear() != Integer.MIN_VALUE) {
				sqlstr.append(" , birthyear=?");
				super.addIntForField(userInterfaceVO.getBirthyear());
			}

			if (userInterfaceVO.getBirthmonth() != Integer.MIN_VALUE) {
				sqlstr.append(" , birthmonth=?");
				super.addIntForField(userInterfaceVO.getBirthmonth());
			}

			if (userInterfaceVO.getBirthday() != Integer.MIN_VALUE) {
				sqlstr.append(" , birthday=?");
				super.addIntForField(userInterfaceVO.getBirthday());
			}

			if (userInterfaceVO.getUserdesc() != null) {
				sqlstr.append(" , userdesc=? ");
				super.addStringForField(userInterfaceVO.getUserdesc());
			}

			if (userInterfaceVO.getDepartmentid() != null) {
				sqlstr.append(" , departmentid=? ");
				super.addStringForField(userInterfaceVO.getDepartmentid());
			}

			if (userInterfaceVO.getDepartmentname() != null) {
				sqlstr.append(" , departmentname=? ");
				super.addStringForField(userInterfaceVO.getDepartmentname());
			}

			if (userInterfaceVO.getRoleid() != null) {
				sqlstr.append(" , roleid=? ");
				super.addStringForField(userInterfaceVO.getRoleid());
			}

			if (userInterfaceVO.getRolename() != null) {
				sqlstr.append(" , rolename=? ");
				super.addStringForField(userInterfaceVO.getRolename());
			}

			if (userInterfaceVO.getRevision() != Integer.MIN_VALUE) {
				sqlstr.append(" , revision=?");
				super.addIntForField(userInterfaceVO.getRevision());
			}

			if (userInterfaceVO.getUsertype() != null) {
				sqlstr.append(" , usertype=? ");
				super.addStringForField(userInterfaceVO.getUsertype());
			}

			if (userInterfaceVO.getCreatetime() != null) {
				sqlstr.append(" , createtime=? ");
				super.addTimestampForField(userInterfaceVO.getCreatetime());
			}

			if (userInterfaceVO.getCreatorid() != null) {
				sqlstr.append(" , creatorid=? ");
				super.addStringForField(userInterfaceVO.getCreatorid());
			}

			if (userInterfaceVO.getCreatorname() != null) {
				sqlstr.append(" , creatorname=? ");
				super.addStringForField(userInterfaceVO.getCreatorname());
			}

			if (userInterfaceVO.getImportstatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , importstatus=?");
				super.addIntForField(userInterfaceVO.getImportstatus());
			}

			if (userInterfaceVO.getImportdesc() != null) {
				sqlstr.append(" , importdesc=? ");
				super.addStringForField(userInterfaceVO.getImportdesc());
			}

			sqlstr.append(" where userid in (?) ");
			if (userInterfaceVO.getUserid() != null) {
				super.addStringForField(userInterfaceVO.getUserid());
			}
		} else if (DEL_USERINTERFACE == operatorType) {
			sqlstr.append("delete  from  z_t_interface_in_user ");
			sqlstr.append(" where userid in (?) ");
			super.addStringForField(userInterfaceVO.getUserid());
		} else if ( DEL_ALL == operatorType ){
			sqlstr.append("delete  from  z_t_interface_in_user ");
		}
		this.sqlStr = sqlstr.toString();
	}

	public String getSqlStr() {
		return this.sqlStr;
	}

	public void setValues() throws SQLException {

	}

	public void execute() throws SQLException {
		result = this.stmt.executeUpdate();
	}

	public int getexecuteResult() {
		return result;
	}

}
