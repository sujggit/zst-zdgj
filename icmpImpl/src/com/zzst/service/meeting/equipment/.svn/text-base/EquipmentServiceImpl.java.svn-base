package com.zzst.service.meeting.equipment;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.dao.meeting.VideoCard.VideoCardDAO;
import com.zzst.dao.meeting.equipment.EquipmentDAO;
import com.zzst.dao.meeting.equipment.EquipmentMcuDAO;
import com.zzst.dao.meeting.equipment.EquipmentTerminalDAO;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.meeting.equipment.EquipmentMcuVO;
import com.zzst.model.meeting.equipment.EquipmentTerminalVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.videoCard.VideoCardVO;
import com.zzst.service.meeting.levelConfig.LevelConfigServiceImpl;

/**
 * class description: Equipment ServiceImpl
 * 
 * @date Wed Nov 30 10:22:48 CST 2011
 * @author ryan
 */
public class EquipmentServiceImpl implements EquipmentService {
	private static Logger logger = CjfLogger.getLogger(EquipmentServiceImpl.class.getName());


	/**
	 * 查询所有状态为正常的MCU、终端设备、所属状态为正常的会议室、所属状态为正常的网络拓扑
	 * @param EquipmentVO
	 * @param PageController
	 * @return ArrayList<EquipmentVO>
	 * @throws Exception
	 */
	@Override
	public ArrayList<EquipmentVO> queryEquipmentRoomAddress(EquipmentVO equipmentVO, PageController pageController) throws Exception  {
		 //////////////////////////分级分权@author:zhangjy///////////////////////
		if(equipmentVO.isLevel()){
			LevelConfigServiceImpl lcs=new LevelConfigServiceImpl();
			equipmentVO.setLsql(lcs.queryByTypeAndLid(equipmentVO.getLsql(), LevelEnum.LEVEL_ROOM));
		}
		////////////////////////////////END////////////////////////////////////////	
		return EquipmentDAO.queryEquipmentRoomAddress(equipmentVO, pageController);
	}
	
	@Override
	public ArrayList<EquipmentVO> query(EquipmentVO equipmentVO, PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
       //////////////////////////分级分权@author:zhangjy///////////////////////
		if(equipmentVO.isLevel()){
			LevelConfigServiceImpl lcs=new LevelConfigServiceImpl();
			equipmentVO.setLsql(lcs.queryByTypeAndLid(equipmentVO.getLsql(), LevelEnum.LEVEL_ROOM));
		}
		////////////////////////////////END////////////////////////////////////////
		ArrayList<EquipmentVO> listEquipment = EquipmentDAO.query(equipmentVO, pageController);
		logger.info("serviceImpl	query	end");
		return listEquipment;
	}
	
	@Override
	public ArrayList<EquipmentVO> queryScrap(EquipmentVO equipmentVO, PageController pageController) throws Exception {
		logger.info("serviceImpl	queryScrap	begin");
       //////////////////////////分级分权@author:zhangjy///////////////////////
		if(equipmentVO.isLevel()){
			LevelConfigServiceImpl lcs=new LevelConfigServiceImpl();
			equipmentVO.setLsql(lcs.queryByTypeAndLid(equipmentVO.getLsql(), LevelEnum.LEVEL_ROOM));
		}
		////////////////////////////////END////////////////////////////////////////
		ArrayList<EquipmentVO> listEquipment = EquipmentDAO.queryScrap(equipmentVO, pageController);
		logger.info("serviceImpl	queryScrap	end");
		return listEquipment;
	}

	@Override
	public EquipmentVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<EquipmentVO> listEquipment = EquipmentDAO.queryByIDs(id, null);
		if (listEquipment != null && listEquipment.size() == 1) {
			logger.info("serviceImpl	end");
			return listEquipment.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}
	@Override
	public EquipmentVO queryByIDNew(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<EquipmentVO> listEquipment = EquipmentDAO.queryByID(id, null);
		if (listEquipment != null && listEquipment.size() == 1) {
			logger.info("serviceImpl	end");
			return listEquipment.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<EquipmentVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<EquipmentVO> listEquipment = EquipmentDAO.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listEquipment;
	}

	@Override
	public EquipmentVO modify(EquipmentVO equipmentVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		equipmentVO = EquipmentDAO.modify(equipmentVO, null);
		logger.info("serviceImpl	modify	end");
		return equipmentVO;
	}
	@Override
	public EquipmentVO modifyState(EquipmentVO equipmentVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		equipmentVO = EquipmentDAO.modifyState(equipmentVO, null);
		logger.info("serviceImpl	modify	end");
		return equipmentVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = EquipmentDAO.deleteByID(id, null);
		if (num == 1) {
			logger.info("serviceImpl	deleteByID	end");
			return true;
		} else {
			logger.info("serviceImpl	deleteByID	end");
			return false;
		}
	}
	

	@Override
	public int deleteByIDs(String ids) throws Exception {
		logger.info("serviceImpl	deleteByIDs	begin");
		int num = EquipmentDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}
	@Override
	public boolean delete(EquipmentVO equipmentVO) throws Exception {
		String equipmentID=equipmentVO.getEquipmentID();
		int equipmentType=equipmentVO.getEquipmentType();
		TransactionManager tManager = new TransactionManager();
		try {
			tManager.beginTransaction();
			if(equipmentType==EquipmentEnum.TYPE_ID_TERMINAL){
				  EquipmentTerminalDAO.deleteByID(equipmentID, null);
				  deleteByID(equipmentID);
				  
			}else if(equipmentType==EquipmentEnum.TYPE_ID_MCU){
				EquipmentMcuDAO.deleteByID(equipmentID, null);
				  deleteByID(equipmentID);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			tManager.endTransaction();
			tManager.rollback();
		}
		tManager.endTransaction();
		tManager.commit();
		return true;
	}

	public boolean addEquipmentTerminal(EquipmentVO equipmentVO,EquipmentTerminalVO equipmentTerminalVO) throws Exception{
			TransactionManager tManager=new TransactionManager();
			tManager.beginTransaction();
			try {
				if(equipmentVO.getEquipmentID()==null){
					equipmentVO.setEquipmentID(UtilDAO.getUUid());
				}
				String equipmentID=equipmentVO.getEquipmentID();
				equipmentTerminalVO.setEquipmentID(equipmentID);
				Calendar currentTime = Calendar.getInstance();
				equipmentVO.setCreateDate(new Timestamp(currentTime.getTimeInMillis()));
				equipmentTerminalVO.setCreateTime(equipmentVO.getCreateDate());
//				equipmentVO.setEquipmentName(EquipmentEnum.NAME_TERMINAL);
				equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
				equipmentVO.setStatus(EquipmentEnum.STATUS_VALID);
				equipmentVO = EquipmentDAO.add(equipmentVO, null);
				equipmentTerminalVO=EquipmentTerminalDAO.add(equipmentTerminalVO, null);
				
			} catch (Exception e) {
				logger.error(e.getMessage());
				tManager.endTransaction();
				tManager.rollback();
			}
			tManager.endTransaction();
		    tManager.commit();
		    return true;
	}
	
	
	public boolean addEquipmentMcu(EquipmentVO equipmentVO,EquipmentMcuVO equipmentMcuVO) throws Exception{
			TransactionManager tManager=new TransactionManager();
			tManager.beginTransaction();
			try {
				if(equipmentVO.getEquipmentID()==null){
					equipmentVO.setEquipmentID(UtilDAO.getUUid());
				}
				String equipmentID=equipmentVO.getEquipmentID();
				equipmentMcuVO.setEquipmentID(equipmentID);
//				equipmentVO.setEquipmentName(EquipmentEnum.NAME_MCU);
				equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_MCU);
				equipmentVO.setStatus(EquipmentEnum.STATUS_VALID);
				Calendar currentTime = Calendar.getInstance();
				equipmentVO.setCreateDate(new Timestamp(currentTime.getTimeInMillis()));
				equipmentVO = EquipmentDAO.add(equipmentVO, null);
				equipmentMcuVO=EquipmentMcuDAO.add(equipmentMcuVO, null);
			} catch (Exception e) {
				logger.error(e.getMessage());
				tManager.endTransaction();
				tManager.rollback();
			}
			tManager.endTransaction();
		    tManager.commit();
		    return true;
	}
	
	public boolean addEquipmentVideoCard(EquipmentVO equipmentVO,VideoCardVO videoCardVO) throws Exception{
		TransactionManager tManager=new TransactionManager();
		tManager.beginTransaction();
		try {
			if(equipmentVO.getEquipmentID()==null){
				equipmentVO.setEquipmentID(UtilDAO.getUUid());
			}
			String equipmentID=equipmentVO.getEquipmentID();
			videoCardVO.setEquipmentID(equipmentID);
//			equipmentVO.setEquipmentName(EquipmentEnum.TYPE_NAME_VIDEOCARD);
			equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_VIDEOCARD);
			equipmentVO = EquipmentDAO.add(equipmentVO, tManager);
			videoCardVO=VideoCardDAO.add(videoCardVO, tManager);
		} catch (Exception e) {
			e.printStackTrace();
			tManager.endTransaction();
			tManager.rollback();
		}
		tManager.endTransaction();
	    tManager.commit();
	    return true;
}
	
 
	@Override
	public EquipmentVO add(EquipmentVO equipmentVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		if(equipmentVO.getEquipmentID()==null){
			equipmentVO.setEquipmentID(UtilDAO.getUUid());
		}
//		equipmentVO.setEquipmentName(EquipmentEnum.NAME_CENTERCONTROL);
		equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
		equipmentVO = EquipmentDAO.add(equipmentVO, null);
		logger.info("serviceImpl	add	end");
		return equipmentVO;
	}
	@Override
	public EquipmentVO addEquipmentMicrophone(EquipmentVO equipmentVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		equipmentVO.setEquipmentID(UtilDAO.getUUid());
		equipmentVO.setEquipmentName(EquipmentEnum.NAME_MICROPHONE);
		equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_MICROPHONE);
		equipmentVO = EquipmentDAO.add(equipmentVO, null);
		logger.info("serviceImpl	add	end");
		return equipmentVO;
	}
	
	@Override
	public EquipmentVO addEqupment(EquipmentVO equipmentVO) throws Exception {
		logger.info("serviceImpl	addEqupment	begin");
		if(equipmentVO.getEquipmentID()==null){
			equipmentVO.setEquipmentID(UtilDAO.getUUid());
		}
		equipmentVO = EquipmentDAO.add(equipmentVO, null);
		logger.info("serviceImpl	addEqupment 	end");
		return equipmentVO;
	}

	@Override
	public boolean modifyEquipmentMcu(EquipmentVO equipmentVO,
			EquipmentMcuVO equipmentMcuVO)throws Exception  {
		 TransactionManager tManager = new TransactionManager();
		     try {
		    	tManager.beginTransaction(); 
		    	EquipmentMcuDAO.modify(equipmentMcuVO, null);
				modify(equipmentVO);
			} catch (Exception e) {
				tManager.endTransaction();
				tManager.rollback();
			}
			tManager.endTransaction();
			tManager.commit();
		   return true;
	}
	
	//修改比对卡信息
	@Override
	public boolean modifyVideoCard(EquipmentVO equipmentVO,VideoCardVO videoCardVO)throws Exception{
		 TransactionManager tManager = new TransactionManager();
		     try {
		    	tManager.beginTransaction(); 
		    	VideoCardDAO.modify(videoCardVO, null);
				modify(equipmentVO);
				
			} catch (Exception e) {
				tManager.endTransaction();
				tManager.rollback();
				e.printStackTrace();
			}
			tManager.endTransaction();
			tManager.commit();
		   return true;
	}
	
	
	

	@Override
	public boolean modifyEquipmentTerminal(EquipmentVO equipmentVO,
			EquipmentTerminalVO equipmentTerminalVO) throws Exception {
		 TransactionManager tManager = new TransactionManager();
	     try {
	    	tManager.beginTransaction(); 
	    	EquipmentTerminalDAO.modify(equipmentTerminalVO, null);
			modify(equipmentVO);
			
		} catch (Exception e) {
			tManager.endTransaction();
			tManager.rollback();
			e.printStackTrace();
		}
		tManager.endTransaction();
		tManager.commit();
	    return true;
	}

	@Override
	public ArrayList<EquipmentVO> queryMCUID(EquipmentVO equipmentVO) throws Exception {
		logger.info("serviceImpl	query	begin");
		equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_MCU);
		 //////////////////////////分级分权@author:zhangjy///////////////////////
		if(equipmentVO.isLevel()){
			LevelConfigServiceImpl lcs=new LevelConfigServiceImpl();
			equipmentVO.setLsql(lcs.queryByTypeAndLid(equipmentVO.getLsql(), LevelEnum.LEVEL_ROOM));
		}
		////////////////////////////////END////////////////////////////////////////
		ArrayList<EquipmentVO> listEquipment = EquipmentDAO.query(equipmentVO, null);
		logger.info("serviceImpl	query	end");
		return listEquipment;
	}

	@Override
	public ArrayList<EquipmentVO> queryIP(String ids) throws Exception {
		logger.info("serviceImpl	queryIP	begin");
		ArrayList<EquipmentVO> listEquipment = EquipmentDAO.queryIP(ids, null);
		logger.info("serviceImpl	queryIP	end");
		return listEquipment;
	}

	@Override
	public EquipmentVO addNotice(EquipmentVO equipmentVO) throws Exception {
		logger.info("serviceImpl	addNotice	begin");
		equipmentVO.setEquipmentID(UtilDAO.getUUid());
		equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_ENC);
//		equipmentVO.setEquipmentName(EquipmentEnum.NAME_ENC);
		equipmentVO = EquipmentDAO.add(equipmentVO, null);
		return equipmentVO;
	}

	@Override
	public ArrayList<EquipmentVO> queryEquipmentVOByMeetingRoomIDs(String ids)
			throws Exception {
		logger.info("serviceImpl	queryEquipmentVOByMeetingRoomIDs	begin");
		ArrayList<EquipmentVO> listEquipment = EquipmentDAO.queryEquipmentVOByMeetingRoomIDs(ids, null);
		logger.info("serviceImpl	queryEquipmentVOByMeetingRoomIDs	end");
		return listEquipment;
	}
	
	@Override
	public ArrayList<EquipmentVO> queryNotice(EquipmentVO equipmentVO , PageController pageController) throws Exception{
		logger.info("EquipmentServiceImpl queryNotice begin");
		equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_ENC);
		ArrayList<EquipmentVO> listEquipment = EquipmentDAO.queryNotice(equipmentVO, pageController);
		logger.info("EquipmentServiceImpl queryNotice end");
		return listEquipment;
	}

	@Override
	public ArrayList<EquipmentVO> queryNoticeByIds(String ids) throws Exception{
		logger.info("EquipmentServiceImpl queryNoticeByIds begin");
		ArrayList<EquipmentVO> listEquipment = EquipmentDAO.queryNoticeByIds(ids);
		logger.info("EquipmentServiceImpl queryNoticeByIds end");
		return listEquipment;
	}

	@Override
	public ArrayList<EquipmentVO> queryEquipments(EquipmentVO equipmentVO , PageController pageControler) throws Exception{
		logger.info("EquipmentServiceImpl queryEquipments begin");
		   //////////////////////////分级分权@author:zhangjy///////////////////////
		if(equipmentVO.isLevel()){
			LevelConfigServiceImpl lcs=new LevelConfigServiceImpl();
			equipmentVO.setLsql(lcs.queryByTypeAndLid(equipmentVO.getLsql(), LevelEnum.LEVEL_ROOM));
		}
		////////////////////////////////END////////////////////////////////////////
		ArrayList<EquipmentVO> listEquipment = EquipmentDAO.queryEquipments(equipmentVO, pageControler);
		logger.info("EquipmentServiceImpl queryEquipments end");
		return listEquipment;
	}
	@Override
	public EquipmentVO modifyEquipmentName(EquipmentVO equipmentVO) throws Exception{
		logger.info("serviceImpl	modifyEquipmentName	begin");
		equipmentVO = EquipmentDAO.modifyEquipmentName(equipmentVO, null);
		logger.info("serviceImpl	modifyEquipmentName	end");
		return equipmentVO;
	}
	
	@Override
	public ArrayList<EquipmentVO> queryByTypeAndName(EquipmentVO equipmentVO, PageController pageController) throws Exception {
		logger.info("serviceImpl	queryByTypeAndName	begin");
		ArrayList<EquipmentVO> listEquipment = EquipmentDAO.queryByTypeAndName(equipmentVO, pageController);
		logger.info("serviceImpl	queryByTypeAndName	end");
		return listEquipment;
	}
}
