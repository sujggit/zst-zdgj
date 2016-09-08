package com.zzst.action.meeting.pollTemplateManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.cbf.log.CbfLogger;
import com.cbf.web.util.PageSplittor;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.MeetingRoomEnum;
import com.zzst.model.enums.PollTerminalEnum;
import com.zzst.model.meeting.address.AddressVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.pollTemplate.PollTemplateVO;
import com.zzst.model.meeting.pollTerminal.PollTerminalVO;
import com.zzst.service.meeting.address.AddressService;
import com.zzst.service.meeting.address.AddressServiceImpl;
import com.zzst.service.meeting.equipment.EquipmentService;
import com.zzst.service.meeting.meetingRoom.MeetingRoomService;
import com.zzst.service.meeting.meetingRoom.MeetingRoomServiceImpl;
import com.zzst.service.meeting.pollTemplate.PollTemplateService;
import com.zzst.service.meeting.pollTerminal.PollTerminalService;

public class PollTemplateManagerAction extends BaseAction{
	private static final long serialVersionUID = 1L;

	private static Logger logger = CbfLogger.getLogger(PollTemplateManagerAction.class.getName());
	
	private ArrayList<PollTemplateVO> pollTemList = new ArrayList<PollTemplateVO>();
	private ArrayList<EquipmentVO> equipmentList = new ArrayList<EquipmentVO>();
	private PollTemplateService pollTemplateService = ServiceFactory.getPollTemplateService();
	private PollTerminalService pollTerminalService = ServiceFactory.getPollTerminalService();
	private EquipmentService equipmentService = ServiceFactory.getEquipmentService();
	private ArrayList<PollTerminalVO> pollTerList = new ArrayList<PollTerminalVO>();
	
	private PollTemplateVO pollTemplateVO = new PollTemplateVO();
	
	public String getPollTemplate(){
		logger.info("PollTemplateManagerAction	getPollTemplate	begin");
		PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
		try {
			pollTemList = pollTemplateService.query(pollTemplateVO, pSplittor.getPControler());
		} catch (Exception e) {
			logger.error(e.getMessage());
		    e.printStackTrace();
			return REQUEST_FAILURE;
		}
		
		logger.info("PollTemplateManagerAction	getPollTemplate	end");
		return REQUEST_SUCCESS;
	}
	
	
	public String pollTerminalBeforeAdd(){
		logger.info("PollTemplateManagerAction	pollTerminalBeforeAdd	begin");
		try {
			StringBuffer nodes = new StringBuffer();
			nodes.append("[");
			ArrayList<AddressVO> alist = new ArrayList<AddressVO>();
			AddressService addservice = new AddressServiceImpl();
			AddressVO addressVO = new AddressVO();
			alist= addservice.query(addressVO, null);//区域集合
			ArrayList<MeetingRoomVO> list = null;
			MeetingRoomService meetingRoomService = new MeetingRoomServiceImpl();
			if(alist.size()>0)
			{
				for(int i=0;i<alist.size();i++)
				{
					AddressVO add = alist.get(i);//当前区域
					
					MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
					meetingRoomVO.setMeetingRoomType(MeetingRoomEnum.ROOM_TYPE_VEDIO);
					meetingRoomVO.setAddressVO(add);
					list = meetingRoomService.query(meetingRoomVO, null);//当前区域下会场
					
					nodes.append("{id:\"");
					nodes.append(add.getAddressID());
					nodes.append("\",pId:\"");
					nodes.append(add.getParentID());
					nodes.append("\",name:\"");
					nodes.append(add.getName());
					if(i!=alist.size()-1){
						nodes.append("\",open:true,childOuter:false},");
					}else{
						if(list!=null&&list.size()>0){
							nodes.append("\",open:true,childOuter:false},");
						}else{
							nodes.append("\",open:true,childOuter:false}");
						}
						
					}
					ArrayList<EquipmentVO> listeq = new ArrayList<EquipmentVO>();
					EquipmentVO eqVO = new EquipmentVO();
					EquipmentVO eqVO1 = new EquipmentVO();
					eqVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
					for(int j=0;j<list.size();j++){
						meetingRoomVO = list.get(j);
						eqVO.setMeetingRoomVO(meetingRoomVO);
						listeq = ServiceFactory.getEquipmentService().query(eqVO, null);
						if(listeq!=null&&listeq.size()>0){
							eqVO1 = listeq.get(0);
						
						nodes.append("{id:\"");
						nodes.append(eqVO1.getEquipmentID());
						nodes.append("\",pId:\"");
						nodes.append(add.getAddressID());
						nodes.append("\",name:\"");
						nodes.append(meetingRoomVO.getMeetingRoomName());
						if((i==alist.size()-1)&&(j==list.size()-1)){
							nodes.append("\"}");
						}else{
							nodes.append("\"},");
							
						}
						}
					}
				}
			}
			nodes.append("]");
			/*MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
			meetingRoomVO.setMeetingRoomType(MeetingRoomEnum.ROOM_TYPE_VEDIO);
			list = meetingRoomService.query(meetingRoomVO, null);//会议室集合
			if(list.size()>0)
			{
				for(int i=0;i<list.size();i++)
				{
					MeetingRoomVO mro = list.get(i);
					
					EquipmentVO ev = new EquipmentVO();
					ev.setMeetingRoomVO(mro);
					ev.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
					ArrayList<EquipmentVO> listEqu = ServiceFactory.getEquipmentService().query(ev, null);
					if(listEqu!=null&&listEqu.size()>0)
						amequip.put(mro.getMeetingRoomID(), listEqu.get(0));//会议室终端集合(1会议室对应1个终端的情况)
				}
			}*/
			request.setAttribute("nodes", nodes.toString());
		} catch (Exception e) {
			logger.error(e.getMessage());
		    e.printStackTrace();
			return REQUEST_FAILURE;
		}
		
		logger.info("PollTemplateManagerAction	pollTerminalBeforeAdd	end");
		return REQUEST_SUCCESS;
	}
	
	public String pollTemplateDel(){
		logger.info("PollTemplateManagerAction	pollTemplateDel	begin");
		try {
			
			PollTerminalVO pollTerminalVO = new PollTerminalVO();
			pollTerminalVO.setPollTemplateID(pollTemplateVO.getPollTemplateID());
			pollTerminalService.deleteByVO(pollTerminalVO);
			pollTemplateService.deleteByID(pollTemplateVO.getPollTemplateID());
			
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		    e.printStackTrace();
			return REQUEST_FAILURE;
		}
		
		logger.info("PollTemplateManagerAction	pollTemplateDel	end");
		return REQUEST_SUCCESS;
	}
	
	public String pollTemplateBeforeModify(){
		logger.info("PollTemplateManagerAction	pollTemplateBeforeModify	begin");
		try {
			//查询轮询模板
			pollTemplateVO =  pollTemplateService.queryByID(pollTemplateVO.getPollTemplateID());
			PollTerminalVO ptv = new PollTerminalVO();
			ptv.setOrgType(PollTerminalEnum.LOC);
		    ptv.setPollTemplateID(pollTemplateVO.getPollTemplateID());
			pollTerList = pollTerminalService.query(ptv, null);
			
			ArrayList<AddressVO> alist = new ArrayList<AddressVO>();
			AddressService addservice = new AddressServiceImpl();
			AddressVO addressVO = new AddressVO();
			alist= addservice.query(addressVO, null);//区域集合
			
			ArrayList<AddressVO> alistNew = new ArrayList<AddressVO>();
			for(int i = 0;i<pollTerList.size();i++){
				for(int j=0;j<alist.size();j++){
					if(pollTerList.get(i).getEquipmentID().equals(alist.get(j).getAddressID())){
						alistNew.add(alist.get(j));
						alist.remove(j);
						break;
					}
				}
			}
			alistNew.addAll(alist);
			
			ptv.setOrgType(PollTerminalEnum.TER);
			pollTerList = pollTerminalService.query(ptv, null);
			///////////////////////
			StringBuffer nodes = new StringBuffer();
			nodes.append("[");
			ArrayList<MeetingRoomVO> list = null;
			
			MeetingRoomService meetingRoomService = new MeetingRoomServiceImpl();
			if(alistNew.size()>0)
			{
				for(int i=0;i<alistNew.size();i++)
				{
					AddressVO add = alistNew.get(i);//当前区域
					
					MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
					meetingRoomVO.setMeetingRoomType(MeetingRoomEnum.ROOM_TYPE_VEDIO);
					meetingRoomVO.setAddressVO(add);
					list = meetingRoomService.query(meetingRoomVO, null);//当前区域下会场
					
					nodes.append("{id:\"");
					nodes.append(add.getAddressID());
					nodes.append("\",pId:\"");
					nodes.append(add.getParentID());
					nodes.append("\",name:\"");
					nodes.append(add.getName());
					if(i!=alistNew.size()-1){
						nodes.append("\",open:true,childOuter:false},");
					}else{
						if(list!=null&&list.size()>0){
							nodes.append("\",open:true,childOuter:false},");
						}else{
							nodes.append("\",open:true,childOuter:false}");
						}
						
					}
					ArrayList<EquipmentVO> listeq = new ArrayList<EquipmentVO>();
					ArrayList<EquipmentVO> listeqNew = new ArrayList<EquipmentVO>();
					ArrayList<EquipmentVO> terListNew = new ArrayList<EquipmentVO>();
					EquipmentVO eqVO = new EquipmentVO();
					EquipmentVO eqVO1 = new EquipmentVO();
					eqVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
					for(int j=0;j<list.size();j++){
						meetingRoomVO = list.get(j);
						eqVO.setMeetingRoomVO(meetingRoomVO);
						listeq = ServiceFactory.getEquipmentService().query(eqVO, null);
						if(listeq!=null&&listeq.size()>0){
							listeqNew.add(listeq.get(0));
						}
						
					}
					for(int k=0;k<pollTerList.size();k++){
						for(int m=0;m<listeqNew.size();m++){
							if(pollTerList.get(k).getEquipmentID().equals(listeqNew.get(m).getEquipmentID())){
								
								terListNew.add(listeqNew.get(m));
								listeqNew.remove(m);
								break;
							}
							
						}
					}
					terListNew.addAll(listeqNew);
					for(int n=0;n<terListNew.size();n++){
						nodes.append("{id:\"");
						nodes.append(terListNew.get(n).getEquipmentID());
						nodes.append("\",pId:\"");
						nodes.append(add.getAddressID());
						nodes.append("\",name:\"");
						nodes.append(terListNew.get(n).getMeetingRoomVO().getMeetingRoomName());
						if((i==alistNew.size()-1)&&(n==list.size()-1)){
							nodes.append("\"}");
						}else{
							nodes.append("\"},");
							
						}
					}
					
				}
			}
			nodes.append("]");
			request.setAttribute("nodes", nodes.toString());
		} catch (Exception e) {
			logger.error(e.getMessage());
		    e.printStackTrace();
			return REQUEST_FAILURE;
		}
		
		logger.info("PollTemplateManagerAction	pollTemplateBeforeModify	end");
		return REQUEST_SUCCESS;
	}


	public ArrayList<PollTemplateVO> getPollTemList() {
		return pollTemList;
	}


	public void setPollTemList(ArrayList<PollTemplateVO> pollTemList) {
		this.pollTemList = pollTemList;
	}


	public PollTemplateVO getPollTemplateVO() {
		return pollTemplateVO;
	}


	public void setPollTemplateVO(PollTemplateVO pollTemplateVO) {
		this.pollTemplateVO = pollTemplateVO;
	}


	public ArrayList<EquipmentVO> getEquipmentList() {
		return equipmentList;
	}


	public void setEquipmentList(ArrayList<EquipmentVO> equipmentList) {
		this.equipmentList = equipmentList;
	}


	public ArrayList<PollTerminalVO> getPollTerList() {
		return pollTerList;
	}


	public void setPollTerList(ArrayList<PollTerminalVO> pollTerList) {
		this.pollTerList = pollTerList;
	}
	
	
	
}
