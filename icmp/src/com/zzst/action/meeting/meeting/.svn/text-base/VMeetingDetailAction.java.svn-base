package com.zzst.action.meeting.meeting;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import com.gsiec.cjf.system.CjfAction;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.enums.VmeetingDetailEnum;
import com.zzst.model.view.VmeetingDetailVO;


public class VMeetingDetailAction extends CjfAction{

	private static final long serialVersionUID = 1L;
	List<VmeetingDetailVO> vdvlist=new ArrayList<VmeetingDetailVO>();
	String strsql;
	String[][] strtype;
	String[][] strname;
	public String query(){
		VmeetingDetailVO mdv=new VmeetingDetailVO();
		if(strsql!=null&&!(strsql.equals(""))){
			
			try {
				strsql=URLDecoder.decode(strsql,"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			strsql=strsql.replace("Percent", "%");
		}
		mdv.setMeetingName(strsql);
		vdvlist=ServiceFactory.getVmeetingDetailService().getAll(mdv, null);
		return this.SUCCESS;
	}
   
	
	public String queryBefore(){
		strtype=VmeetingDetailEnum.getType();
		strname=VmeetingDetailEnum.getName();
		return this.SUCCESS;
	}
	public List<VmeetingDetailVO> getVdvlist() {
		return vdvlist;
	}

	public void setVdvlist(List<VmeetingDetailVO> vdvlist) {
		this.vdvlist = vdvlist;
	}


	public String[][] getStrtype() {
		return strtype;
	}


	public void setStrtype(String[][] strtype) {
		this.strtype = strtype;
	}


	public String[][] getStrname() {
		return strname;
	}


	public void setStrname(String[][] strname) {
		this.strname = strname;
	}


	public String getStrsql() {
		return strsql;
	}


	public void setStrsql(String strsql) {
		this.strsql = strsql;
	}





	
	
}
