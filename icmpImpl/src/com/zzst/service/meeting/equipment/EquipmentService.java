package com.zzst.service.meeting.equipment;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.equipment.EquipmentMcuVO;
import com.zzst.model.meeting.equipment.EquipmentTerminalVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.videoCard.VideoCardVO;

/**
 * class description: Equipment Service
 * 
 * @date Wed Nov 30 10:22:48 CST 2011
 * @author ryan
 */
public interface EquipmentService {

	/**
	 * 查询所有状态为正常的MCU、终端设备、所属状态为正常的会议室、所属状态为正常的网络拓扑
	 * @param EquipmentVO
	 * @param PageController
	 * @return ArrayList<EquipmentVO>
	 * @throws Exception
	 */
	public ArrayList<EquipmentVO> queryEquipmentRoomAddress(EquipmentVO equipmentVO, PageController pageController) throws Exception; 
	
	/**
	 * 添加设备--equipment单表
	 * @param equipmentVO
	 * @return
	 * @throws Exception
	 */
	public EquipmentVO addEqupment(EquipmentVO equipmentVO) throws Exception;
	
	/**
	 * 添加设备--equipment单表--话筒
	 * @param equipmentVO
	 * @return
	 * @throws Exception
	 */
	public EquipmentVO addEquipmentMicrophone(EquipmentVO equipmentVO) throws Exception;
	
	/**
	 * method description : add EquipmentVO object
	 * 
	 * @param EquipmentVO
	 * @return EquipmentVO
	 * @throws Exception
	 */
	public EquipmentVO add(EquipmentVO equipmentVO) throws Exception;
	
	
	
	/***
	 * method description:注册告示
	 * 
	 * 新增 
	 * 
	 */
	public EquipmentVO addNotice(EquipmentVO equipmentVO)throws Exception;

	/**
	 * method description : query Equipment list
	 * 根据条件查询状态为 不等于失效、报废的设备；关联状态不等于失效的会议室；关联状态不等于失效的人员
	 * @param EquipmentVO
	 * @param PageController
	 * @return ArrayList<EquipmentVO>
	 * @throws Exception
	 */
	public ArrayList<EquipmentVO> query(EquipmentVO equipmentVO, PageController pageController) throws Exception;

	/**
	 * method description : query Equipment list
	 * 根据条件查询状态为 不等于失效的设备；关联状态不等于失效的会议室；关联状态不等于失效的人员
	 * @param EquipmentVO
	 * @param PageController
	 * @return ArrayList<EquipmentVO>
	 * @throws Exception
	 */
	public ArrayList<EquipmentVO> queryScrap(EquipmentVO equipmentVO, PageController pageController) throws Exception;
	
	/**
	 * method description : query EquipmentVO by id
	 * 
	 * @param id
	 * @return EquipmentVO
	 * @throws Exception
	 */
	public EquipmentVO queryByID(String id) throws Exception;
	
	/***
	 * method description:根据会议室IDs查找告示信息
	 * 
	 * 新增 
	 * 
	 */
	public ArrayList<EquipmentVO> queryEquipmentVOByMeetingRoomIDs(String ids) throws Exception;

	/**
	 * method description : query EquipmentVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return EquipmentVO
	 * @throws Exception
	 */
	public ArrayList<EquipmentVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify EquipmentVO by id
	 * 
	 * @param EquipmentVO
	 * @return EquipmentVO
	 * @throws Exception
	 */
	public EquipmentVO modify(EquipmentVO equipmentVO) throws Exception;

	/**
	 * method description : delete EquipmentVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete EquipmentVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
	
	/**
	 * 添加及注册终端
	 * @param equipmentVO
	 * @param equipmentTerminalVO
	 * @return
	 * @throws Exception
	 * @date Wed Nov 30 10:22:48 CST 2011
     * @author ls
	 */
	public boolean addEquipmentTerminal(EquipmentVO equipmentVO,EquipmentTerminalVO equipmentTerminalVO) throws Exception;
	/**
	 * 添加及注册mcu
	 * @param equipmentVO
	 * @param equipmentMcuVO
	 * @return
	 * @throws Exception
	 * @date Wed Nov 30 10:22:48 CST 2011
     * @author ls
	 */
	public boolean addEquipmentMcu(EquipmentVO equipmentVO,EquipmentMcuVO equipmentMcuVO) throws Exception;

	public boolean addEquipmentVideoCard(EquipmentVO equipmentVO,VideoCardVO videoCardVO) throws Exception;

	
	public boolean delete(EquipmentVO equipmentVO)throws Exception;
	public boolean modifyEquipmentTerminal(EquipmentVO equipmentVO,EquipmentTerminalVO equipmentTerminalVO)throws Exception;
	public boolean modifyEquipmentMcu(EquipmentVO equipmentVO,EquipmentMcuVO equipmentMcuVO)throws Exception;
	public ArrayList<EquipmentVO> queryMCUID(EquipmentVO ev) throws Exception;
	public ArrayList<EquipmentVO> queryIP(String ids) throws Exception ;
	public EquipmentVO modifyState(EquipmentVO equipmentVO) throws Exception;
	public boolean modifyVideoCard(EquipmentVO equipmentVO,VideoCardVO videoCardVO)throws Exception;
	
	public ArrayList<EquipmentVO> queryNotice(EquipmentVO equipmentVO, PageController pageController) throws Exception;
	public ArrayList<EquipmentVO> queryNoticeByIds(String ids) throws Exception;

	/**
	 * 设备查询列表页。一个设备可以注册进多个会议室的情况
	 * @param equipmentVO
	 * @param pageControler
	 * @return
	 */
	public ArrayList<EquipmentVO> queryEquipments(EquipmentVO equipmentVO, PageController pageControler) throws Exception;
	
	public EquipmentVO modifyEquipmentName(EquipmentVO equipmentVO) throws Exception;
	
	public ArrayList<EquipmentVO> queryByTypeAndName(EquipmentVO equipmentVO, PageController pageController) throws Exception;
	
	public EquipmentVO queryByIDNew(String id) throws Exception;
}
