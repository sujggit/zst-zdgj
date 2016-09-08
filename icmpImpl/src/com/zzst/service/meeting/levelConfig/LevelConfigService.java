package com.zzst.service.meeting.levelConfig;

import java.util.ArrayList;
import java.util.List;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.zzst.model.meeting.levelConfig.LevelConfigVO;

/**
 * class description: LevelConfig Service
 * 
 * @date Mon Nov 18 11:28:49 CST 2013
 * @author ryan
 */
public interface LevelConfigService {

	/**
	 * method description : add LevelConfigVO object
	 * 
	 * @param LevelConfigVO
	 * @return LevelConfigVO
	 * @throws Exception
	 */
	public LevelConfigVO add(LevelConfigVO levelConfigVO) throws Exception;

	/**
	 * method description : query LevelConfig list
	 * 
	 * @param LevelConfigVO
	 * @param PageController
	 * @return ArrayList<LevelConfigVO>
	 * @throws Exception
	 */
	public ArrayList<LevelConfigVO> query(LevelConfigVO levelConfigVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query LevelConfigVO by id
	 * 
	 * @param id
	 * @return LevelConfigVO
	 * @throws Exception
	 */
	public LevelConfigVO queryByID(String id) throws Exception;

	/**
	 * method description : query LevelConfigVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return LevelConfigVO
	 * @throws Exception
	 */
	public ArrayList<LevelConfigVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify LevelConfigVO by id
	 * 
	 * @param LevelConfigVO
	 * @return LevelConfigVO
	 * @throws Exception
	 */
	public LevelConfigVO modify(LevelConfigVO levelConfigVO) throws Exception;

	/**
	 * method description : delete LevelConfigVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete LevelConfigVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public void deleteByIDs(String id) throws Exception;

	/**
	 * 根据levelType关联查询
	 * @param levelConfigVO
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public List<LevelConfigVO> queryWithType(LevelConfigVO levelConfigVO,
			PageController pageController) throws Exception;

	String queryByTypeAndLid(String levelType,String lids) throws Exception;
	/**
	 * 根据levelID删除分级下所有的用户信息
	 * @param levelConfigVO
	 * @param tManager
	 * @return
	 * @throws Exception
	 */
	public boolean delLevelVO(LevelConfigVO levelConfigVO,
			TransactionManager tManager) throws Exception;
}
