package com.zzst.action.meeting.dictionary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionManager;
import com.cbf.log.CbfLogger;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.model.enums.DictionaryEnum;
import com.zzst.model.meeting.dictionary.DictionaryEquipmentVO;
import com.zzst.model.meeting.dictionary.DictionaryVO;
import com.zzst.service.meeting.dictionary.DictionaryService;
import com.zzst.service.meeting.dictionary.DictionaryServiceImpl;

public class DictionaryAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = CbfLogger.getLogger(DictionaryAction.class.getName());
	private DictionaryVO dictionaryVO = new DictionaryVO();
	private List<DictionaryVO> dList = new ArrayList<DictionaryVO>();
	private List<DictionaryVO> findList = new ArrayList<DictionaryVO>();
	private String checkList;
	public String controlMenuList(){
		 DictionaryVO dictionaryVOs = new DictionaryVO();
		 List<DictionaryVO> dLists = new ArrayList<DictionaryVO>();
		
		Map<String, String> controlMenuMap = DictionaryEnum.getControlMenuMap();//把所有的控制菜单放在一个map里
		
		dictionaryVOs.setDicType(DictionaryEnum.CONTROLMENU);
		try {
			dLists = ServiceFactory.getDictionaryService().query(dictionaryVOs, null);
			if(dLists!=null&&dLists.size()>0){
				for(DictionaryVO dvo:dLists){
				    String tempstr=dvo.getDescription();
				    String[] tempstrs=tempstr.split("~");
				    dvo.setDescription(tempstrs[0]);
				    dvo.setCreateUserID(tempstrs[1]);
					if(controlMenuMap.get(dvo.getDicValue())!=null){
						controlMenuMap.remove(dvo.getDicValue());//把已经分过组的控制菜单移除map
					}
				}
			}
			Iterator it = controlMenuMap.entrySet().iterator();
			while(it.hasNext()){
				DictionaryVO vo = new DictionaryVO();
				vo.setDicType(DictionaryEnum.CONTROLMENU);
				Map.Entry m = (Entry) it.next();
				if(m.getKey()==null) continue;
				vo.setDicValue(m.getKey().toString());
				vo.setDicViewName(m.getValue().toString());
				dLists.add(vo);//将尚未分组的控制菜单添加至dList中
			}
			findList=dLists;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return REQUEST_SUCCESS;
	}

	
	
	public String controlRightMenuList(){
		
		dictionaryVO.setDicType(DictionaryEnum.CONTROLRightMENU);
		dictionaryVO.setDescription("checked");
		try {
			dList = ServiceFactory.getDictionaryService().query(dictionaryVO, null);
			checkList="";
			for(DictionaryVO dv:dList){
				
				checkList+=dv.getDicValue()+",";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "SUCCESS";
	}
	
	/**
	 * 默认查询数据字典列表
	 * @return
	 */
	public String dictionaryList(){
		logger.info("DictionaryAction		dList	begin");
//		PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
		try{
								
			DictionaryService dictionaryService = new DictionaryServiceImpl();
	
			dList = dictionaryService.query(dictionaryVO, null);
			request.setAttribute("dList",dList);
		}catch(Exception e){
			request.setAttribute("info", "获取数据字典时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		
		logger.info("DictionaryAction		dList	end");	
		return this.REQUEST_SUCCESS;
	}
	
	/**
	 * beforeAdd增加数据字典前
	 * @return
	 */
	public String beforeAdd(){
		logger.info("DictionaryAction		beforeAdd	begin");
		logger.info("DictionaryAction		modifyDictionary	end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * 增加数据字典
	 * 
	 */
	public String addDictionary() {
		logger.info("DictionaryAction		addDictionary	begin");
		TransactionManager tManager = null;
		try {
			if(checkToken()){
				request.setAttribute("info", "请不要重复提交");
				return INVALID_TOKEN;
			}
			tManager = new TransactionManager();
			tManager.beginTransaction();
			DictionaryService dictionaryService = new DictionaryServiceImpl();
			dictionaryVO = dictionaryService.add(dictionaryVO);
			
			//back to add page
			request.setAttribute("retMsg", "已成功添加数据字典:" + dictionaryVO.getDicType() );
			
			tManager.commit();
		} catch (Exception e) {
			request.setAttribute("info", "添加数据字典失败！");
			logger.error(e.getMessage());
			if(tManager!=null){
				 tManager.rollback();
			}
			return REQUEST_FAILURE;
		}finally{
			if(tManager!=null){
				 tManager.endTransaction();
			}
		}
		
		logger.info("DictionaryAction		addDictionary	end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * 根据id查看详细数据字典
	 * @return
	 */
	public String detail(){
		logger.info("DictionaryAction		detail	begin");
		try{
			DictionaryService dictionaryService = new DictionaryServiceImpl();
			dictionaryVO = dictionaryService.queryByID(dictionaryVO.getDicID());
			
		}catch(Exception e){
			request.setAttribute("info", "获取数据字典时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		
		logger.info("DictionaryAction		detail	end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * beforeModify修改数据字典前
	 * @returnu
	 */
	public String beforeModify(){
		logger.info("DictionaryAction		beforeModify	begin");
		try{
			
//			System.out.println(dictionaryVO.getDicID());
			DictionaryService dictionaryService = new DictionaryServiceImpl();
			dictionaryVO = dictionaryService.queryByID(dictionaryVO.getDicID());
			
			
		}catch(Exception e){
			request.setAttribute("info", "获取数据字典时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		
		logger.info("DictionaryAction		beforeModify	end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * 修改数据字典
	 * @return
	 */
	public String modifyDictionary(){
		logger.info("DictionaryAction		modifyDictionary	begin");
		try{
			
			DictionaryService dictionaryService = new DictionaryServiceImpl();
			dictionaryVO = dictionaryService.modify(dictionaryVO);
			
		
		}catch(Exception e){
			request.setAttribute("info", "修改数据字典时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		
		logger.info("DictionaryAction		modifyDictionary	end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * 删除数据字典
	 * @return
	 */
	public String delDictionary(){
		logger.info("DictionaryAction		delDictionary	begin");
		try{
			DictionaryVO u = new DictionaryVO();
			u.setDicID(dictionaryVO.getDicID());
			DictionaryService dictionaryService = new DictionaryServiceImpl();
			dictionaryService.deleteByVO(u);
			
		}catch(Exception e){
			request.setAttribute("info", "删除数据字典时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		
		logger.info("DictionaryAction		delDictionary	end");
		return REQUEST_SUCCESS;
	}
	/**
	 * 重置设备配置信息。
	 * @return
	 */
	public String reSet(){
		logger.info("DictionaryAction		reSet	begin");
		try{
			//将被删除的基础数据重置原来的状态。
			DictionaryEquipmentVO dEquipmentVO = new DictionaryEquipmentVO();
			dEquipmentVO.setStatus(DictionaryEnum.STATUS_INVALID);
			dEquipmentVO.setSysValue(DictionaryEnum.sysValue_lock);
			ArrayList<DictionaryEquipmentVO> list = ServiceFactory.getDictionaryEquipmentService().queryByStatusAndSysvalue(dEquipmentVO, null);
			for(int i=0;i<list.size();i++){
				DictionaryEquipmentVO dVo =list.get(i);
				dVo.setStatus(DictionaryEnum.STATUS_VALID);
				ServiceFactory.getDictionaryEquipmentService().modify(dVo);
			}
			//将用户新增加的设备配置的状态修改为无效的。
//			DictionaryEquipmentVO dicEquipmentVO = new DictionaryEquipmentVO();
//			dicEquipmentVO.setStatus(DictionaryEnum.STATUS_VALID);
//			dicEquipmentVO.setSysValue(DictionaryEnum.sysValue);
//			ArrayList<DictionaryEquipmentVO> dList = ServiceFactory.getDictionaryEquipmentService().queryByStatusAndSysvalue(dicEquipmentVO, null);
//			for(int j=0;j<dList.size();j++){
//				DictionaryEquipmentVO deEquipmentVO = dList.get(j);
//				deEquipmentVO.setStatus(DictionaryEnum.STATUS_INVALID);
//				ServiceFactory.getDictionaryEquipmentService().modify(deEquipmentVO);
//			}
			
		}catch(Exception e){
			request.setAttribute("info", "重置设备配置信息时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		
		logger.info("DictionaryAction		reSet	end");
		return REQUEST_SUCCESS;
	}
	
	public DictionaryVO getDictionaryVO() {
		return dictionaryVO;
	}

	public void setDictionaryVO(DictionaryVO dictionaryVO) {
		this.dictionaryVO = dictionaryVO;
	}

	public String getCheckList() {
		return checkList;
	}



	public void setCheckList(String checkList) {
		this.checkList = checkList;
	}



	public List<DictionaryVO> getdList() {
		return dList;
	}

	public void setdList(List<DictionaryVO> dList) {
		this.dList = dList;
	}
	/**
	 * 
	 * add by liujf 20131010
	 */
	private String info;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}



	public void setFindList(List<DictionaryVO> findList) {
		this.findList = findList;
	}



	public List<DictionaryVO> getFindList() {
		return findList;
	}

}
