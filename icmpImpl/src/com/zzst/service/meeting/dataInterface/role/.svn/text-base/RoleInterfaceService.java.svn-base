package com.zzst.service.meeting.dataInterface.role;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.model.meeting.dataInterface.role.RoleInterfaceVO;

/**
 * class description: RoleInterface Service
 * 
 * @date Mon Jun 17 19:18:02 CST 2013
 * @author ryan
 */
public interface RoleInterfaceService {

	/**
	 * method description : add RoleInterfaceVO object
	 * 
	 * @param RoleInterfaceVO
	 * @return RoleInterfaceVO
	 * @throws Exception
	 */
	public RoleInterfaceVO add(RoleInterfaceVO roleInterfaceVO)
			throws Exception;
	
	/**
	 * 添加到角色接口表,VO主键
	 * @param roleInterfaceVO
	 * @return
	 * @throws Exception
	 */
	public RoleInterfaceVO addByCreateId(RoleInterfaceVO roleInterfaceVO)
			throws Exception;

	/**
	 * method description : query RoleInterface list
	 * 
	 * @param RoleInterfaceVO
	 * @param PageController
	 * @return ArrayList<RoleInterfaceVO>
	 * @throws Exception
	 */
	public ArrayList<RoleInterfaceVO> query(RoleInterfaceVO roleInterfaceVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query RoleInterfaceVO by id
	 * 
	 * @param id
	 * @return RoleInterfaceVO
	 * @throws Exception
	 */
	public RoleInterfaceVO queryByID(String id) throws Exception;

	/**
	 * method description : query RoleInterfaceVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return RoleInterfaceVO
	 * @throws Exception
	 */
	public ArrayList<RoleInterfaceVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify RoleInterfaceVO by id
	 * 
	 * @param RoleInterfaceVO
	 * @return RoleInterfaceVO
	 * @throws Exception
	 */
	public RoleInterfaceVO modify(RoleInterfaceVO roleInterfaceVO)
			throws Exception;

	/**
	 * method description : delete RoleInterfaceVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete RoleInterfaceVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
	
	public ArrayList<RoleInterfaceVO> queryAvailable( RoleInterfaceVO roleInterfaceVO,
			PageController pageController ) throws Exception;
	
	public int deleteAll() throws Exception;
}
