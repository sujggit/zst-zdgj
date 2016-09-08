/**
 * 
 */
package com.zzst.dao.meeting.auth;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.auth.FuncVO;

/**
 * @author zhangliang
 * @Apr 18, 2011
 */
public class FuncMQB  extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(RoleMQB.class.getName());

	public static int QUERY_FROM_FUNC = 1;

	public static int QUERY_CHECK_CHILD = 2;
	
	public static int QUERY_ROLE_FUNC = 3;
	
	public static int  QUERY_FROM_FUNCTION		=	4;
	public static int  QUERY_FROM_FUNCTION_BY_IDS =	5;

	private FuncVO funcVO;
	private ArrayList<FuncVO> listfunc = new ArrayList<FuncVO>();
	
	private boolean res = false;

	private int _operatorType = -1;

	public FuncMQB(int operatorType) {
		_operatorType = operatorType;
	}
	public FuncMQB(int operatorType, FuncVO functionVO) {
		_operatorType = operatorType;
		this.funcVO = functionVO;
		makeSql();
	}

	public FuncMQB(int operatorType, String	ids) {
		_operatorType = operatorType;
		FuncVO functionVO = new FuncVO();
		functionVO.setFunc_id(ids);
		this.funcVO = functionVO;
		makeSql();
	}
	
	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select funcID,funcName,funcURL,parentID,leaf,status,orderNum,description,className,funcNo ");
		strsql.append(" from z_t_function ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_FUNCTION == _operatorType) {
			if (null != funcVO) {
				if (!StringUtils.isNullOrBlank(funcVO.getFunc_id())) {
					strsql.append(" and funcID= ? ");
					super.addStringForField(funcVO.getFunc_id());
				}
				if (!StringUtils.isNullOrBlank(funcVO.getFunc_name())) {
					strsql.append(" and funcName= ? ");
					super.addStringForField(funcVO.getFunc_name());
				}
				if (!StringUtils.isNullOrBlank(funcVO.getFunc_url())) {
					strsql.append(" and funcURL= ? ");
					super.addStringForField(funcVO.getFunc_url());
				}
				if (!StringUtils.isNullOrBlank(funcVO.getParent_id())) {
					strsql.append(" and parentID= ? ");
					super.addStringForField(funcVO.getParent_id());
				}
				if (Integer.MIN_VALUE != funcVO.getLeaf()) {
					strsql.append(" and leaf= ? ");
					super.addIntForField(funcVO.getLeaf());
				}
				if (Integer.MIN_VALUE != funcVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(funcVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(funcVO.getNumber())) {
					strsql.append(" and orderNum= ? ");
					super.addStringForField(funcVO.getNumber());
				}
				if (!StringUtils.isNullOrBlank(funcVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(funcVO.getDescription());
				}
				if (!StringUtils.isNullOrBlank(funcVO.getClassName())) {
					strsql.append(" and className= ? ");
					super.addStringForField(funcVO.getClassName());
				}
				if (!StringUtils.isNullOrBlank(funcVO.getFuncNo())) {
					strsql.append(" and funcNo= ? ");
					super.addStringForField(funcVO.getFuncNo());
				}
			}
		} else if (QUERY_FROM_FUNCTION_BY_IDS == _operatorType) {
			strsql.append(" and funcID in (?) ");
			super.addStringForField(funcVO.getFunc_id());
		}
		setSql(strsql.toString());
	}
	
	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		
		if (QUERY_FROM_FUNC == _operatorType) {
			funcVO = new FuncVO();
			funcVO.setFunc_id(rs.getString("funcID"));
			funcVO.setFunc_name(rs.getString("funcName"));
			funcVO.setFunc_url(rs.getString("funcURL"));
			funcVO.setParent_id(rs.getString("parentID"));	
			funcVO.setLeaf(rs.getInt("leaf"));
			funcVO.setDescription(rs.getString("description"));
			funcVO.setClassName(rs.getString("className"));
			funcVO.setFuncNo(rs.getString("funcNo"));
			listfunc.add(funcVO);
		}
		else if(QUERY_CHECK_CHILD == _operatorType)
		{
			if(rs.getInt(1)>0)
				res =true;
		}
		else if(QUERY_ROLE_FUNC == _operatorType)
		{
			funcVO = new FuncVO();
			funcVO.setFunc_id(rs.getString("funcID"));
			listfunc.add(funcVO);			
		}else{
			FuncVO functionVO = new FuncVO();
			functionVO.setFunc_id(rs.getString("funcID"));
			functionVO.setFunc_name(rs.getString("funcName"));
			functionVO.setFunc_url(rs.getString("funcURL"));
			functionVO.setParent_id(rs.getString("parentID"));
			functionVO.setLeaf(rs.getInt("leaf"));
			functionVO.setStatus(rs.getInt("status"));
			functionVO.setNumber(rs.getString("orderNum"));
			functionVO.setDescription(rs.getString("description"));
			functionVO.setClassName(rs.getString("className"));
			functionVO.setFuncNo(rs.getString("funcNo"));
			listfunc.add(functionVO);
		}
	}

	public ArrayList<FuncVO> getFuncList() {
		return listfunc;
	}

	public FuncVO getRoleVO() {
		return funcVO;
	}
	public boolean getres(){
	
		return res;
	}

}

