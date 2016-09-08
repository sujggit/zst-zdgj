package com.zzst.dao.meeting.address;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.address.AddressVO;


public class AddressMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(AddressMQB.class.getName());

	public static int QUERY_FROM_ADDRESS = 1;
	public static int QUERY_FROM_ADDRESS_BY_IDS = 2;
	public static int QUERY_CHECK_CHILD = 3;

	private AddressVO addressVO;
	private boolean res = false;
	private ArrayList<AddressVO> listAddress = new ArrayList<AddressVO>();

	private int _operatorType = -1;
	private String ids = "";

	
	public AddressMQB(int operatorType) {
		_operatorType = operatorType;
		makeSql();
	}
	
	public AddressMQB(int operatorType, AddressVO addressVO) {
		_operatorType = operatorType;
		this.addressVO = addressVO;
		makeSql();
	}

	public AddressMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select addressID,name,parentID,status,description,revision,leaf ");
		strsql.append(" from z_t_address ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_ADDRESS == _operatorType) {
			if (null != addressVO) {
				if (Integer.MIN_VALUE != addressVO.getLeaf()) {
					strsql.append(" and leaf= ? ");
					super.addIntForField(addressVO.getLeaf());
				}
				if (!StringUtils.isNullOrBlank(addressVO.getAddressID())) {
					strsql.append(" and addressID= ? ");
					super.addStringForField(addressVO.getAddressID());
				}
				if (!StringUtils.isNullOrBlank(addressVO.getName())) {
					strsql.append(" and name like '%"+addressVO.getName()+"%'");
//					strsql.append(" and name= ? ");
//					super.addStringForField(addressVO.getName());
				}
				if (!StringUtils.isNullOrBlank(addressVO.getParentID())) {
					strsql.append(" and parentID= ? ");
					super.addStringForField(addressVO.getParentID());
				}
				
				if (Integer.MIN_VALUE != addressVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(addressVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(addressVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(addressVO.getDescription());
				}
				if (Long.MIN_VALUE != addressVO.getRevision()) {
					strsql.append(" and revision= ? ");
					super.addLongForField(addressVO.getRevision());
				}
			}
		} else if (QUERY_FROM_ADDRESS_BY_IDS == _operatorType) {
			strsql.append(" and addressID in (?) ");
			super.addStringForField(ids);
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
		if( QUERY_CHECK_CHILD == _operatorType ){
			if(rs.getInt(1)>0)
				res =true;
		
		}else{
			addressVO = new AddressVO();
			addressVO.setAddressID(rs.getString("addressID"));
			addressVO.setName(rs.getString("name"));
			addressVO.setParentID(rs.getString("parentID"));
			addressVO.setStatus(rs.getInt("status"));
			addressVO.setDescription(rs.getString("description"));
			addressVO.setRevision(rs.getLong("revision"));
			addressVO.setLeaf(rs.getInt("leaf"));
			listAddress.add(addressVO);
		}
	}

	public ArrayList<AddressVO> getAddressList() {
		return listAddress;
	}

	public AddressVO getAddressVO() {
		return addressVO;
	}
	
	public boolean getRes() {
		return res;
	}


}
