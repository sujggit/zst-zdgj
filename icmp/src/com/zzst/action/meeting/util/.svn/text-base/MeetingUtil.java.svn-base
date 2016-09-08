/**
 * 
 */
package com.zzst.action.meeting.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zzst.application.mcuUtil.MCUConfig;
import com.zzst.application.mcuVO.ZZOConfVO;
import com.zzst.application.mcuVO.ZZOMainStatusVO;
import com.zzst.application.meeting.mcu.operate.OperateUtil;
import com.zzst.application.meeting.mcuFactory.ZZOMcuFactory;
import com.zzst.application.meeting.mcuInterface.IMcuDwrMethodHelp;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.meeting.equipment.EquipmentMcuVO;
import com.zzst.model.meeting.equipment.EquipmentTerminalVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.videoconference.VideoconferenceVO;
import com.zzst.service.meeting.equipment.EquipmentMcuService;
import com.zzst.service.meeting.equipment.EquipmentMcuServiceImpl;
import com.zzst.service.meeting.equipment.EquipmentTerminalService;
import com.zzst.service.meeting.equipment.EquipmentTerminalServiceImpl;

/**
 * @author zhangliang
 * @since 2011-12-08
 * 根据终端ip，查询所属MCU
 * 根据终端关联mcu，拼装mcu-对应关联终端list
 */
public class MeetingUtil
{
	private static HashMap<String,String> confModel = new HashMap<String,String>();
	
	@SuppressWarnings("unchecked")
	public static Map<EquipmentMcuVO, List<EquipmentTerminalVO>> getMCU(String ips)
	{
		ArrayList reslist = new ArrayList();
		
		ArrayList<EquipmentMcuVO> mculist = new ArrayList<EquipmentMcuVO>();
		ArrayList<EquipmentTerminalVO> terlist = new ArrayList<EquipmentTerminalVO>();
		
		Map<EquipmentMcuVO, List<EquipmentTerminalVO>> mcumap = new HashMap<EquipmentMcuVO, List<EquipmentTerminalVO>>();
		Map<String, EquipmentMcuVO> termap = new HashMap<String, EquipmentMcuVO>();
	
		EquipmentMcuService mcuser = new EquipmentMcuServiceImpl();
		EquipmentTerminalService terser = new EquipmentTerminalServiceImpl();
		try {
			//查询mcu
			mculist = mcuser.queryByIPs(ips);	
			for(int i=0;i<mculist.size();i++ )
			{
				EquipmentMcuVO mcu = mculist.get(i);
				termap.put(mcu.getEquipmentID(), mcu);
			}
			//查询终端
			terlist = terser.queryByIPs(ips);
			
			for(int j=0; j< terlist.size() ;j++)
			{
				EquipmentTerminalVO ter = terlist.get(j);
				String mcuID = ter.getEquipmentMCUID();
				
				if(!mcumap.containsKey(termap.get(mcuID))&&termap.containsKey(mcuID) )
				{
					ArrayList<EquipmentTerminalVO> tmplist = new ArrayList<EquipmentTerminalVO>();
					tmplist.add(ter);
					
					mcumap.put(termap.get(mcuID), tmplist);
				}
				else if(mcumap.containsKey(termap.get(mcuID))&&termap.containsKey(mcuID) )
				{
					ArrayList<EquipmentTerminalVO> tmplist = (ArrayList<EquipmentTerminalVO>) mcumap.get(termap.get(mcuID));
					tmplist.add(ter);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mcumap;
	}
	
	
	public static Map<EquipmentMcuVO, List<EquipmentTerminalVO>> getMCULevelTwo(String meetingDetialId)
	{
		
		ArrayList<EquipmentMcuVO> mculist = new ArrayList<EquipmentMcuVO>();
		ArrayList<EquipmentTerminalVO> terlist = new ArrayList<EquipmentTerminalVO>();
		
		Map<EquipmentMcuVO, List<EquipmentTerminalVO>> mcumap = new HashMap<EquipmentMcuVO, List<EquipmentTerminalVO>>();
		Map<String, EquipmentMcuVO> termap = new HashMap<String, EquipmentMcuVO>();
	
		EquipmentMcuService mcuser = new EquipmentMcuServiceImpl();
		EquipmentTerminalService terser = new EquipmentTerminalServiceImpl();
		try {
			//查询mcu
			mculist = mcuser.queryByMeetingID(meetingDetialId);	
			for(int i=0;i<mculist.size();i++ )
			{
				EquipmentMcuVO mcu = mculist.get(i);
				termap.put(mcu.getEquipmentID(), mcu);
			}
			//查询终端
			terlist = terser.queryByMeetingID(meetingDetialId);
			
			for(int j=0; j< terlist.size() ;j++)
			{
				EquipmentTerminalVO ter = terlist.get(j);
				String mcuID = ter.getEquipmentMCUID();
				
				if(!mcumap.containsKey(termap.get(mcuID))&&termap.containsKey(mcuID) )
				{
					ArrayList<EquipmentTerminalVO> tmplist = new ArrayList<EquipmentTerminalVO>();
					tmplist.add(ter);
					
					mcumap.put(termap.get(mcuID), tmplist);
				}
				else if(mcumap.containsKey(termap.get(mcuID))&&termap.containsKey(mcuID) )
				{
					ArrayList<EquipmentTerminalVO> tmplist = (ArrayList<EquipmentTerminalVO>) mcumap.get(termap.get(mcuID));
					tmplist.add(ter);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mcumap;
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		String ips ="'1.1.1.1','1.1.1.2','1.1.1.3'";
		Date now1 = new Date();
//		ArrayList list = getMCU(ips);
//		Date now2 = new Date();
		
	}
	

	/**
	 * 取得主会场
	 * @param videoConferenceVO 需meetingDetailID
	 * @return	EquipmentVO or null
	 */
	public static EquipmentVO getMainVenue(VideoconferenceVO videoConferenceVO){
		EquipmentVO eqVO = null;
		try {
		
		List<VideoconferenceVO> vcList =	ServiceFactory.getVideoconferenceService().getVideoconferenceListNoMeetingroom(videoConferenceVO, null);
		if(vcList!=null&&vcList.size()>0){
			for(VideoconferenceVO vc : vcList){
				if(String.valueOf(MeetingDetailEnum.mainVenue_valid).equals(String.valueOf(vc.getIsmain()))){
					EquipmentVO equipmentVO = new EquipmentVO();
					MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
					equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
					meetingRoomVO.setMeetingRoomID(vc.getSubmeetingRoomID());
					equipmentVO.setMeetingRoomVO(meetingRoomVO);
					
					List<EquipmentVO> eqList = ServiceFactory.getEquipmentService().query(equipmentVO, null);
					if(eqList!=null&&eqList.size()>0){
						eqVO = eqList.get(0);
					}
				}
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return eqVO;
	}
	
	/**
	 * 取得主会
	 * @param meetingDetailID
	 * @return
	 */
	public static ZZOConfVO getMasterConf(String meetingDetailID){
		ZZOConfVO confVO = new ZZOConfVO();
		confVO.setConfFlagId(meetingDetailID);
		List<ZZOConfVO> confList = ZZOMcuFactory.getInstance().getConfManager().getConfList(confVO);
		for(ZZOConfVO cVO : confList){
			if(cVO.getIsMasterConf()==MCUConfig.IS_MASTER_CONF){
				confVO = cVO;					//取得主会
			}else{
				confVO = null;
			}
		}
		return confVO;
	}

	/**
	 * 
	 * @param meetingDetail
	 * @return Model: 1 个人模式： 主会个人模式+从会个人模式   2 相同分屏模式: 主会相同分屏 + 从会演讲者 
	 *         3 演讲者模式: 主会演讲者 + 从会演讲者
	 */
	public static  HashMap<String,String>  setConfModel ( String meetingDetail, String Model ){
		confModel.put(meetingDetail, Model);
		return confModel;
	}
	
	public static void clearMap(){
		confModel.clear();
	}
	
	/**wangle 2013-7-20
	 * synchronize other conference casecade relation exception broadcaster conference. 
	 * @param ptsNameVconfGuidVmcuIp : 
	 * @param confList
	 */
	public static void synCascadeRelation(String ptsNameVconfGuidVmcuIp, List<ZZOConfVO> confList){
		if(confList == null || confList.size() < 2){
			return;
		}
		
		String[] ptsIpConfGuidMcuIpArray = OperateUtil.splitter(ptsNameVconfGuidVmcuIp, MCUConfig.OP_DELIMITER + MCUConfig.OP_DELIMITER);
		if(ptsIpConfGuidMcuIpArray == null || ptsIpConfGuidMcuIpArray.length != 3){
			return;
		}
		ZZOConfVO masterConfVO = null;
		ZZOConfVO broadcasterConfVO = null;
		for(ZZOConfVO cVO : confList){
			if(cVO.getIsMasterConf()==MCUConfig.IS_MASTER_CONF){
				masterConfVO = cVO;					//取得主会
			}
			if(cVO.getMcuIP().equals(ptsIpConfGuidMcuIpArray[2]) && cVO.getGuid().equals(ptsIpConfGuidMcuIpArray[1])){
				broadcasterConfVO = cVO;
			}
			if(masterConfVO != null && broadcasterConfVO != null){
				break;
			}
		}
		if(masterConfVO == null){
			return;
		}
		for(ZZOConfVO confVO : confList){
			if(confVO.getMcuIP().equals(ptsIpConfGuidMcuIpArray[2]) && confVO.getGuid().equals(ptsIpConfGuidMcuIpArray[1])){
				continue;
			}
			if(confVO.getIsMasterConf()==MCUConfig.IS_MASTER_CONF){
				//see broadcaster conference cascade point
				if(broadcasterConfVO == null){
					continue;
				}
				seeCP(broadcasterConfVO, masterConfVO);
			}else{
				//see master conference cascade point
				seeCP(masterConfVO, confVO);
			}	
		}
	}
	/**wangle 2013-7-20
	 * the second parameter conference is to see the first parameter conference. 
	 * @param seenConfVO
	 * @param seeConfVO
	 */
	public static void seeCP(ZZOConfVO seenConfVO, ZZOConfVO seeConfVO){
		List<ZZOMainStatusVO> venueList = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(seeConfVO.getConfFlagId(), seeConfVO.getMcuIP(),seeConfVO.getGuid());
		if(venueList == null || venueList.size() <= 0){
			return;
		}
		for(ZZOMainStatusVO mainStatusVO : venueList){
			if(mainStatusVO.getMcu_participant_ip().equals(seenConfVO.getMcuCommandIP()) && 
					mainStatusVO.getAliasName().equals(seenConfVO.getE164())){
				seeConfVO.setLayoutConfigGuid(mainStatusVO.getMcu_participant_id());
				IMcuDwrMethodHelp mcuDwrMethodHelp = ZZOMcuFactory.createMethodHelp(seeConfVO.getMcuType());
				mcuDwrMethodHelp.setVideo(seeConfVO);
				break;
			}
		}
	}
}
