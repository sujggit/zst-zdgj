package com.zzst.dao.meeting.equipment;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.meeting.equipment.EquipmentMcuVO;

/**
 * class description: EquipmentMcu DAO
 * 
 * @date Wed Nov 30 10:22:49 CST 2011
 * @author ryan
 */
public class EquipmentMcuDAO {
	private static Logger logger = CjfLogger.getLogger(EquipmentMcuDAO.class.getName());

	private static final String id = "EquipmentID";

	/**
	 * add EquipmentMcuVO object
	 * 
	 * @param EquipmentMcuVO
	 * @param TransactionManager
	 * @return EquipmentMcuVO
	 * @throws Exception
	 */
	public static EquipmentMcuVO add(EquipmentMcuVO equipmentMcuVO, TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		//equipmentMcuVO.setEquipmentID(UtilDAO.getUUid());
		EquipmentMcuTO equipmentMcuTO = new EquipmentMcuTO(EquipmentMcuTO.ADD_EQUIPMENTMCU, equipmentMcuVO);

		equipmentMcuTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentMcuTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentMcuTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentMcuTO, tManager);
		}
		logger.info("DAO	add	end");
		return equipmentMcuVO;
	}

	/**
	 * query EquipmentMcuVO list
	 * 
	 * @param EquipmentMcuVO
	 * @param PageController
	 * @return ArrayList<EquipmentMcuVO>
	 * @throws Exception
	 */
	public static ArrayList<EquipmentMcuVO> query(EquipmentMcuVO equipmentMcuVO, PageController pageController)
			throws Exception {
		logger.info("DAO	query	begin");
		EquipmentMcuMQB equipmentMcuMQB = new EquipmentMcuMQB(EquipmentMcuMQB.QUERY_FROM_EQUIPMENTMCU, equipmentMcuVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentMcuMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentMcuMQB, pageController);
		logger.info("list size	:	" + equipmentMcuMQB.getEquipmentMcuList().size());
		logger.info("DAO	query	end");
		return equipmentMcuMQB.getEquipmentMcuList();
	}

	/**
	 * query EquipmentMcuVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<EquipmentMcuVO>
	 * @throws Exception
	 */
	public static ArrayList<EquipmentMcuVO> queryByIDs(String ids, PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		EquipmentMcuMQB equipmentMcuMQB = new EquipmentMcuMQB(EquipmentMcuMQB.QUERY_FROM_EQUIPMENTMCU_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentMcuMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentMcuMQB, pageController);
		logger.info("list size	:	" + equipmentMcuMQB.getEquipmentMcuList().size());
		logger.info("DAO	queryByIDs	end");
		return equipmentMcuMQB.getEquipmentMcuList();
	}
	
	public static ArrayList<EquipmentMcuVO> queryByIPs(String ips, PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		EquipmentMcuMQB equipmentMcuMQB = new EquipmentMcuMQB(EquipmentMcuMQB.QUERY_MCU_BY_IPS);
		
		StringBuffer strsql = new StringBuffer();

		strsql.append("select a.equipmentID,a.equipmentType,a.equipmentName,a.equipmentNO,a.equipmentModel,a.ip,a.port,b.parentID,b.loginName,b.loginPassword,b.CommandIP,b.description ");
		strsql.append("  from z_t_equipment  a left join z_t_equipment_mcu  b on a.equipmentID =b.equipmentID  ");
		strsql.append(" where a.equipmentID in ( ");
		strsql.append(" select distinct  equipmentMCUID  from z_t_equipment_terminal where equipmentID in ");
		strsql.append(" ( select equipmentID  from z_t_equipment where 1=1 ");

		if (null != ips) {		
			strsql.append(" and  ip in (" + ips+")");
		}
		strsql.append(" )) ");
		
		logger.info("sqlStr	:	" + strsql.toString());
		equipmentMcuMQB.setSql(strsql.toString());
		
		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}	
		
		QueryTemplate.executeQueryForList(equipmentMcuMQB, pageController);
		logger.info("list size	:	" + equipmentMcuMQB.getEquipmentMcuList().size());
		logger.info("DAO	queryByIDs	end");
		return equipmentMcuMQB.getEquipmentMcuList();
	}

	public static ArrayList<EquipmentMcuVO> queryByMeetingID(String id, PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		EquipmentMcuMQB equipmentMcuMQB = new EquipmentMcuMQB(EquipmentMcuMQB.QUERY_MCU_BY_IPS);
		
		StringBuffer strsql = new StringBuffer();

		strsql.append("select a.equipmentID,a.equipmentType,a.equipmentName,a.equipmentNO,a.equipmentModel,a.ip,a.port,b.parentID,b.loginName,b.loginPassword,b.CommandIP,b.description ");
		strsql.append("FROM z_t_meetingdetail_equipment zme ");
		strsql.append("left join z_t_equipment a on zme.equipmentID=a.equipmentID ");
		strsql.append("LEFT JOIN z_t_equipment_mcu b ON zme.equipmentID = b.equipmentID ");
		strsql.append("WHERE  zme.meetingDetailID='"+id+"' and zme.equipmentType="+EquipmentEnum.TYPE_ID_MCU);

		logger.info("sqlStr	:	" + strsql.toString());
		equipmentMcuMQB.setSql(strsql.toString());
		
		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}	
		
		QueryTemplate.executeQueryForList(equipmentMcuMQB, pageController);
		logger.info("list size	:	" + equipmentMcuMQB.getEquipmentMcuList().size());
		logger.info("DAO	queryByIDs	end");
		return equipmentMcuMQB.getEquipmentMcuList();
	}
	/**
	 * modify EquipmentMcuVO column by ID
	 * 
	 * @param EquipmentMcuVO
	 * @param TransactionManager
	 * @return EquipmentMcuVO
	 * @throws Exception
	 */
	public static EquipmentMcuVO modify(EquipmentMcuVO equipmentMcuVO, TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		EquipmentMcuTO equipmentMcuTO = new EquipmentMcuTO(EquipmentMcuTO.MODIFY_EQUIPMENTMCU, equipmentMcuVO);
		equipmentMcuTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentMcuTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentMcuTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentMcuTO, tManager);
		}
		logger.info("DAO	modify	end");
		return equipmentMcuVO;
	}

	/**
	 * delete EquipmentMcuVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return EquipmentMcuVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager) throws Exception {
		logger.info("DAO	deleteByID	begin");
		EquipmentMcuVO equipmentMcuVO = new EquipmentMcuVO();
		equipmentMcuVO.setEquipmentID(ids);
		EquipmentMcuTO equipmentMcuTO = new EquipmentMcuTO(EquipmentMcuTO.DEL_EQUIPMENTMCU, equipmentMcuVO);

		equipmentMcuTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentMcuTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentMcuTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentMcuTO, tManager);
		}
		logger.info("result	:	" + equipmentMcuTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return equipmentMcuTO.getexecuteResult();
	}
	
	/**
	 * 根据mcuid查询mcu对象
	 * @author chenshuo
	 * @param id
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<EquipmentMcuVO> queryByMCUID(String id, PageController pageController)
	throws Exception {
		logger.info("DAO	query	begin");
		EquipmentMcuMQB equipmentMcuMQB = new EquipmentMcuMQB(EquipmentMcuMQB.QUERY_MCU_BY_IPS);
		
		StringBuffer strsql = new StringBuffer();

		strsql.append("select a.equipmentID,a.equipmentType,a.equipmentName,a.equipmentNO,a.equipmentModel,a.ip,a.port,b.parentID,b.loginName,b.loginPassword,b.CommandIP,b.description ");
		strsql.append("  from z_t_equipment  a left join z_t_equipment_mcu  b on a.equipmentID = b.equipmentID  ");
		
		if (null != id && !"".equals(id)) {
			strsql.append(" where a.equipmentID = '" + id +"'");
		}
		equipmentMcuMQB.setSql(strsql.toString());
		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentMcuMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentMcuMQB, pageController);
		logger.info("list size	:	" + equipmentMcuMQB.getEquipmentMcuList().size());
		logger.info("DAO	query	end");
		return equipmentMcuMQB.getEquipmentMcuList();
	}
	
}
