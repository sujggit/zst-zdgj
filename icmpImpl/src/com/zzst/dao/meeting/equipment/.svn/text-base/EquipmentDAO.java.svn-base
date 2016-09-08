package com.zzst.dao.meeting.equipment;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.model.meeting.equipment.EquipmentVO;

/**
 * class description: Equipment DAO
 * 
 * @date Wed Nov 30 10:22:48 CST 2011
 * @author ryan
 */
public class EquipmentDAO {
	private static Logger logger = CjfLogger.getLogger(EquipmentDAO.class.getName());
	/**
	 * 查询所有状态为正常的MCU、终端设备、所属状态为正常的会议室、所属状态为正常的网络拓扑
	 * @param EquipmentVO
	 * @param PageController
	 * @return ArrayList<EquipmentVO>
	 * @throws Exception
	 */
	public static ArrayList<EquipmentVO> queryEquipmentRoomAddress(EquipmentVO equipmentVO, PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		 //////////////////////会议室分级分权@author:zhangjy/////////////////////////
		if(equipmentVO.isLevel()){
			if(!(equipmentVO.equals(""))){
			equipmentVO.setLsql(" and mr.meetingroomID in("+equipmentVO.getLsql()+") ");
			}else{
				equipmentVO.setLevel(false);
			}
		}
		//////////////////////////////end//////////////////////////////////////////
		EquipmentMQB equipmentMQB = new EquipmentMQB(EquipmentMQB.QUERY_FROM_EQUIPMENT_ADDRESS_ROOM, equipmentVO);
        
		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentMQB, pageController);
		logger.info("list size	:	" + equipmentMQB.getEquipmentList().size());
		logger.info("DAO	query	end");
		return equipmentMQB.getEquipmentList();
	}
	/**
	 * add EquipmentVO object
	 * 
	 * @param EquipmentVO
	 * @param TransactionManager
	 * @return EquipmentVO
	 * @throws Exception
	 */
	public static EquipmentVO add(EquipmentVO equipmentVO, TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		//equipmentVO.setEquipmentID(UtilDAO.getUUid());
		EquipmentTO equipmentTO = new EquipmentTO(EquipmentTO.ADD_EQUIPMENT, equipmentVO);
	
		equipmentTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentTO, tManager);
		}
		logger.info("DAO	add	end");
		return equipmentVO;
	}

	/**
	 * query EquipmentVO list
	 * 
	 * @param EquipmentVO
	 * @param PageController
	 * @return ArrayList<EquipmentVO>
	 * @throws Exception
	 */
	public static ArrayList<EquipmentVO> query(EquipmentVO equipmentVO, PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		 //////////////////////会议室分级分权@author:zhangjy/////////////////////////
		if(equipmentVO.isLevel()){
			if(!(equipmentVO.equals(""))){
			equipmentVO.setLsql(" and z_t_meetingroom.meetingroomID in("+equipmentVO.getLsql()+") ");
			}else{
				equipmentVO.setLevel(false);
			}
		}
		//////////////////////////////end//////////////////////////////////////////
		EquipmentMQB equipmentMQB = new EquipmentMQB(EquipmentMQB.QUERY_FROM_EQUIPMENT, equipmentVO);
        
		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentMQB, pageController);
		logger.info("list size	:	" + equipmentMQB.getEquipmentList().size());
		logger.info("DAO	query	end");
		return equipmentMQB.getEquipmentList();
	}
	
	/**
	 * query EquipmentVO list by equipment is scrapped.
	 * 
	 * @param EquipmentVO
	 * @param PageController
	 * @return ArrayList<EquipmentVO>
	 * @throws Exception
	 */
	public static ArrayList<EquipmentVO> queryScrap(EquipmentVO equipmentVO, PageController pageController) throws Exception {
		logger.info("DAO	queryScrap	begin");
		 //////////////////////会议室分级分权@author:zhangjy/////////////////////////
		if(equipmentVO.isLevel()){
			if(!(equipmentVO.equals(""))){
			equipmentVO.setLsql(" and z_t_meetingroom.meetingroomID in("+equipmentVO.getLsql()+") ");
			}else{
				equipmentVO.setLevel(false);
			}
		}
		//////////////////////////////end//////////////////////////////////////////
		EquipmentMQB equipmentMQB = new EquipmentMQB(EquipmentMQB.QUERY_FROM_EQUIPMENT_SCRAP, equipmentVO);
        
		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentMQB, pageController);
		logger.info("list size	:	" + equipmentMQB.getEquipmentList().size());
		logger.info("DAO	queryScrap	end");
		return equipmentMQB.getEquipmentList();
	}

	/**
	 * query EquipmentVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<EquipmentVO>
	 * @throws Exception
	 */
	public static ArrayList<EquipmentVO> queryByIDs(String ids, PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		EquipmentMQB equipmentMQB = new EquipmentMQB(EquipmentMQB.QUERY_FROM_EQUIPMENT_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentMQB, pageController);
		logger.info("list size	:	" + equipmentMQB.getEquipmentList().size());
		logger.info("DAO	queryByIDs	end");
		return equipmentMQB.getEquipmentList();
	}
	/**
	 * query EquipmentVO list by ID
	 * @param id
	 * @param pageController
	 * @return
	 * @throws Exception
	 * @author liujf0748
	 */
	public static ArrayList<EquipmentVO> queryByID(String ids, PageController pageController) throws Exception {
		logger.info("DAO	queryByID	begin");
		EquipmentMQB equipmentMQB = new EquipmentMQB(EquipmentMQB.QUERY_FROM_EQUIPMENT_BY_ID, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentMQB, pageController);
		logger.info("list size	:	" + equipmentMQB.getEquipmentList().size());
		logger.info("DAO	queryByID	end");
		return equipmentMQB.getEquipmentList();
	}

	/**
	 * modify EquipmentVO column by ID
	 * 
	 * @param EquipmentVO
	 * @param TransactionManager
	 * @return EquipmentVO
	 * @throws Exception
	 */
	public static EquipmentVO modify(EquipmentVO equipmentVO, TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		EquipmentTO equipmentTO = new EquipmentTO(EquipmentTO.MODIFY_EQUIPMENT, equipmentVO);
		equipmentTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentTO, tManager);
		}
		logger.info("DAO	modify	end");
		return equipmentVO;
	}
	
	
	
	public static EquipmentVO modifyState(EquipmentVO equipmentVO, TransactionManager tManager) throws Exception {
		logger.info("DAO	modifyState	begin");
		EquipmentTO equipmentTO = new EquipmentTO(EquipmentTO.MODIFY_STATE, equipmentVO);
		equipmentTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentTO, tManager);
		}
		logger.info("DAO	modifyState	end");
		return equipmentVO;
	}

	/**
	 * delete EquipmentVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return EquipmentVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager) throws Exception {
		logger.info("DAO	deleteByID	begin");
		EquipmentVO equipmentVO = new EquipmentVO();
		equipmentVO.setEquipmentID(ids);
		EquipmentTO equipmentTO = new EquipmentTO(EquipmentTO.DEL_EQUIPMENT, equipmentVO);

		equipmentTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentTO, tManager);
		}
		logger.info("result	:	" + equipmentTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return equipmentTO.getexecuteResult();
	}
	
	public static ArrayList<EquipmentVO> queryIP(String ids,  PageController pageController) throws Exception {
		logger.info("DAO	queryIP	begin");
		EquipmentMQB equipmentMQB = new EquipmentMQB(EquipmentMQB.QUERY_IP, ids);
		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentMQB, pageController);
		logger.info("list size	:	" + equipmentMQB.getEquipmentList().size());
		logger.info("DAO	queryIP	end");
		return equipmentMQB.getEquipmentList();
	}
	
	public static ArrayList<EquipmentVO> queryEquipmentVOByMeetingRoomIDs(String ids,PageController pageController) throws Exception{
		logger.info("DAO	queryEquipmentVOByMeetingRoomIDs	begin");
		EquipmentMQB equipmentMQB = new EquipmentMQB(EquipmentMQB.QUERY_BY_MEETINGROOM_IDS, ids);
		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentMQB, pageController);
		logger.info("list size	:	" + equipmentMQB.getEquipmentList().size());
		logger.info("DAO	queryEquipmentVOByMeetingRoomIDs	end");
		return equipmentMQB.getEquipmentList();
	}
	
	public static ArrayList<EquipmentVO> queryNotice(EquipmentVO equipmentVO, PageController pageController) throws Exception {
		logger.info("DAO	queryNotice	begin");
		EquipmentMQB equipmentMQB = new EquipmentMQB(EquipmentMQB.QUERY_NOTICE, equipmentVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentMQB, pageController);
		logger.info("list size	:	" + equipmentMQB.getEquipmentList().size());
		logger.info("DAO	queryNotice	end");
		return equipmentMQB.getEquipmentList();
	}
	
	public static ArrayList<EquipmentVO> queryNoticeByIds(String ids) throws Exception{
		logger.info("EquipmentDAO  queryNoticeByIds  begin");
		EquipmentMQB equipmentMQB  = new EquipmentMQB(EquipmentMQB.QUERY_NOTICE_BY_IDS,ids);
		logger.info("sqlStr :  " + equipmentMQB.getSql());
		PageController pageController = new PageController();
		pageController.setAll(true);
		QueryTemplate.executeQueryForList(equipmentMQB, pageController);
		logger.info("list size :   "+equipmentMQB.getEquipmentList().size());
		logger.info("EquipmentDAO  queryNoticeByIds  end");
		return equipmentMQB.getEquipmentList();
		
	}

	public static ArrayList<EquipmentVO> queryEquipments(
			EquipmentVO equipmentVO, PageController pageController) throws Exception {
		logger.info("DAO	queryEquipments	begin");
		 //////////////////////会议室分级分权@author:zhangjy/////////////////////////
		if(equipmentVO.isLevel()){
			if(!(equipmentVO.equals(""))){
			equipmentVO.setLsql(" and mr.meetingroomID in("+equipmentVO.getLsql()+") ");
			}else{
				equipmentVO.setLevel(false);
			}
		}
		//////////////////////////////end//////////////////////////////////////////
		EquipmentMQB equipmentMQB = new EquipmentMQB(EquipmentMQB.QUERY_EQUIPMENTS, equipmentVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentMQB, pageController);
		logger.info("list size	:	" + equipmentMQB.getEquipmentList().size());
		logger.info("DAO	queryEquipments	end");
		return equipmentMQB.getEquipmentList();
	}
	
	public static EquipmentVO modifyEquipmentName(EquipmentVO equipmentVO, TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		EquipmentTO equipmentTO = new EquipmentTO(EquipmentTO.MODIFY_EQUIPMENTNAME, equipmentVO);
		equipmentTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentTO, tManager);
		}
		logger.info("DAO	modify	end");
		return equipmentVO;
	}
	
	public static ArrayList<EquipmentVO> queryByTypeAndName(EquipmentVO equipmentVO, PageController pageController) throws Exception {
		logger.info("DAO	queryByTypeAndName	begin");
		EquipmentMQB equipmentMQB = new EquipmentMQB(EquipmentMQB.QUERY_FROM_EQUIPMENT_ONLY, equipmentVO);
        
		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentMQB, pageController);
		logger.info("list size	:	" + equipmentMQB.getEquipmentList().size());
		logger.info("DAO	queryByTypeAndName	end");
		return equipmentMQB.getEquipmentList();
	}
}
