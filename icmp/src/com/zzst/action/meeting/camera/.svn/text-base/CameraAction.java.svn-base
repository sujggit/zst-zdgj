/**
 * 
 */
package com.zzst.action.meeting.camera;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.kst.service.KstObject;
import com.zzst.model.enums.BaseInfoEnum;
import com.zzst.model.meeting.config.BaseInfoVO;
import com.zzst.model.meeting.kst.Camera;
import com.zzst.model.meeting.kst.CameraGroup;
import com.zzst.service.meeting.kst.KstVedioMoniterServiceImpl;
import com.zzst.util.ControlFactory;
import com.zzst.util.ExcuteResultVO;

/**
 * 视频监控（可视通） Action
 * @author zhangliang
 * Dec 23, 20112:42:53 PM
 */
public class CameraAction extends BaseAction 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(CameraAction.class);
	
	private CameraGroup cGroup = new CameraGroup();
	private ArrayList<CameraGroup> glist = new ArrayList<CameraGroup>();
	private ArrayList<CameraGroup> subglist = new ArrayList<CameraGroup>();
	private ArrayList<Camera> clist = new ArrayList<Camera>(); 
	private String meetingDetailID = "";
	public String getMeetingDetailID() {
		return meetingDetailID;
	}

	public void setMeetingDetailID(String meetingDetailID) {
		this.meetingDetailID = meetingDetailID;
	}

	/**
	 * 提取省公司列表
	 */
	public ArrayList<CameraGroup> initList()
	{
		 ArrayList<CameraGroup> tlist = new ArrayList<CameraGroup>();
		try{
			BaseInfoVO b = new BaseInfoVO();
			b.setInfoType(BaseInfoEnum.TYPE_KST_DOMAIN_GUID);
			 ArrayList<BaseInfoVO> list = ServiceFactory.getBaseInfoService().query(b, null);
			for (int i = 0; i < list.size(); i++) {
				CameraGroup group = new CameraGroup();
				group.setGroupname(list.get(i).getInfoName());
				group.setGroupid(list.get(i).getInfoValue());
				group.setParent_id("0");
				group.setLeaf(0);        
		        tlist.add(group);		
			}
		}catch(Exception e){
			logger.error("CameraAction	initList	error:"+e.getMessage());
		}
        return tlist;
	}
	
	//生成分组树
	public String groupTree()
	{
		//省级菜单初始化
		ArrayList<CameraGroup> treelist = initList();
		try {
				treelist.addAll(new KstVedioMoniterServiceImpl().getKstVedioMoniterList(null,null));
		} catch (Exception e) {
			e.printStackTrace();
		}
        request.setAttribute("treelist", treelist);
		return REQUEST_SUCCESS;
	}
	
	public String jiankongTree(){
		ArrayList<CameraGroup> treelist = initList();
		ArrayList<CameraGroup> jTreeList = new ArrayList<CameraGroup>();
		try {
				treelist.addAll(new KstVedioMoniterServiceImpl().getKstVedioMoniterList(null,null));
				for(CameraGroup cg : treelist){
					if(cg.getLeaf()==1){
						cg.setLeaf(0);
						KstObject kstImpl = ControlFactory.getKstObject(MeetingAppConfig.kst_server_IP);
						ExcuteResultVO erVO = kstImpl.getCamerasbyGroupID(cg.getGroupid());
						ArrayList<com.zzst.kst.service.impl.vo.Camera> cameras = (ArrayList<com.zzst.kst.service.impl.vo.Camera>)erVO.getObject();
						for(com.zzst.kst.service.impl.vo.Camera c : cameras ){
								CameraGroup cg1 = new CameraGroup();
								cg1.setGroupid(c.getCameraid());
								cg1.setGroupname(c.getCameraname());
								cg1.setParent_id(cg.getGroupid());
								cg1.setType(cg.getType());
								cg1.setDomainid(cg.getDomainid());
								cg1.setLeaf(1);
								jTreeList.add(cg1);
						}
						jTreeList.add(cg);
					}else{
						jTreeList.add(cg);
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
        request.setAttribute("treelist", jTreeList);
		return REQUEST_SUCCESS;
	}
	//根据groupid 查询摄像头
	public String  getCamerasByGroupid()
	{
		String groupid = request.getParameter("groupid");
	    
		KstObject kstImpl = ControlFactory.getKstObject(MeetingAppConfig.kst_server_IP);
		ExcuteResultVO erVO = kstImpl.getCamerasbyGroupID(groupid);
		clist = (ArrayList<Camera>)erVO.getObject();
		
//	    String tmp = MeetingAppConfig.kst_server_province_camera.replaceFirst("##1", groupid);
//		clist =  KSTUtil.getCamerasbyGroupID(tmp,groupid);
		return REQUEST_SUCCESS;
	}
	
	
	/**
	 * @return the cGroup
	 */
	public CameraGroup getCGroup() {
		return cGroup;
	}
	/**
	 * @param group the cGroup to set
	 */
	public void setCGroup(CameraGroup group) {
		cGroup = group;
	}
	/**
	 * @return the glist
	 */
	public ArrayList<CameraGroup> getGlist() {
		return glist;
	}
	/**
	 * @param glist the glist to set
	 */
	public void setGlist(ArrayList<CameraGroup> glist) {
		this.glist = glist;
	}
	/**
	 * @return the clist
	 */
	public ArrayList<Camera> getClist() {
		return clist;
	}
	/**
	 * @param clist the clist to set
	 */
	public void setClist(ArrayList<Camera> clist) {
		this.clist = clist;
	}
	/**
	 * @return the subglist
	 */
	public ArrayList<CameraGroup> getSubglist() {
		return subglist;
	}
	/**
	 * @param subglist the subglist to set
	 */
	public void setSubglist(ArrayList<CameraGroup> subglist) {
		this.subglist = subglist;
	}
	

	
}
