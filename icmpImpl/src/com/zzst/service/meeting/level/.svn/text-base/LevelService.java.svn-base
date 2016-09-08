package com.zzst.service.meeting.level;

import java.util.ArrayList;
import java.util.List;

import com.cbf.db.PageController;
import com.zzst.model.meeting.level.LevelVO;

/**
 * class description: LevelGrade Service
 * 
 * @date Thu Nov 14 10:43:30 CST 2013
 * @author ryan
 */
public interface LevelService {

	/**
	 * method description : add LevelGradeVO object
	 * 
	 * @param LevelVO
	 * @return LevelGradeVO
	 * @throws Exception
	 */
	public LevelVO add(LevelVO levelGradeVO) throws Exception;

	/**
	 * method description : query LevelGrade list
	 * 
	 * @param LevelVO
	 * @param PageController
	 * @return ArrayList<LevelGradeVO>
	 * @throws Exception
	 */
	public ArrayList<LevelVO> query(LevelVO levelGradeVO,
			PageController pageController) throws Exception;
	/**
	 * 
	 * @param levelGradeVO
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public ArrayList<LevelVO> queryByPid(LevelVO levelGradeVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query LevelGradeVO by id
	 * 
	 * @param id
	 * @return LevelGradeVO
	 * @throws Exception
	 */
	public LevelVO queryByID(String id) throws Exception;

	/**
	 * method description : query LevelGradeVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return LevelGradeVO
	 * @throws Exception
	 */
	public ArrayList<LevelVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify LevelGradeVO by id
	 * 
	 * @param LevelVO
	 * @return LevelGradeVO
	 * @throws Exception
	 */
	public LevelVO modify(LevelVO levelGradeVO) throws Exception;

	/**
	 * method description : delete LevelGradeVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete LevelGradeVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public void deleteByIDs(String id) throws Exception;
	//判断是否子节点
	public boolean ishaveChild(String levelId)  throws Exception ;
	
	public ArrayList<LevelVO> getallChild(String id) throws Exception ;

	public List<LevelVO> queryInLevelPath(String levelid) throws Exception;
	//根据pid删除子节点
	public boolean deleteByPID(String id) throws Exception;
	
	public ArrayList<LevelVO> ishaveChildOne(LevelVO levelGradeVO,
			PageController pageController) throws Exception;
}
