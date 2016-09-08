package com.zzst.kst.org.tempuri;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;

public class VciSoapIMPL implements VciSoap {
    public static HttpClient client;
	public VciSoapIMPL(String ip) {
		client = new HttpClient();
		client.getHostConfiguration().setHost(ip,80, "http" );	
	}

	@Override
	public String checkUser(String username, String password) {
		Map<String,String> cs=new HashMap<String,String>();
		//http://10.1.6.93/vci.aspx?op=checkuser&username=admin&password=pass
		cs.put("username", username);
		cs.put("password", password);
		return getXmlStr("checkuser",cs);
	}

	@Override
	public int deletePreset(int cameraId, int presetIndex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int execTvWallPreset(int presetid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCameraPresets(int cameraId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCamerasByDomainID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCamerasByGroupID(String groupGUID) {
		Map<String,String> cs=new HashMap<String,String>();
		cs.put("groupid", groupGUID);
		return getXmlStr("getcamerasbygroupid", cs);
	}

	@Override
	public String getCamerasByGroupName(String groupName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDevicemesg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGroupsByDomainID(String domainGUID) {
		Map<String,String> cs=new HashMap<String,String>();
		cs.put("domainid", domainGUID);
		return getXmlStr("getallgroups", cs);
	}

	@Override
	public String getGroupsByDomainID2(String domainGUID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTvWallPreset() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTvWallStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserCameraTreeNodes(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String querySnapshotByCamera(int cameraId, String beginTime,
			String endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String querySnapshotByCar(String plateNum, String beginTime,
			String endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String queryVodUrl(int cameraId, String startTimeString,
			String stopTimeString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int startRecordDownload(int cameraId, String startTimeString,
			String stopTimeString) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getXmlStr(String op,Map<String,String> cs){
		String purls="/vci.aspx?op="+op;
		for(Map.Entry<String, String> entry:cs.entrySet()){    
			purls+="&"+entry.getKey()+"="+entry.getValue();
			}    
		PostMethod post = new PostMethod(purls);
		 try {
			client.executeMethod(post);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String str=post.getResponseBodyAsString();
		System.out.println(str);
		 return str;
	}
	
}
