package com.zzst.service.meeting.address;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.address.AddressVO;

/**
 * class description: Address Service
 * 
 * @date Tue Jul 10 17:01:48 CST 2012
 * @author ryan
 */
public interface AddressService {

	/**
	 * method description : add AddressVO object
	 * 
	 * @param AddressVO
	 * @return AddressVO
	 * @throws Exception
	 */
	public AddressVO add(AddressVO addressVO) throws Exception;

	/**
	 * method description : query Address list
	 * 
	 * @param AddressVO
	 * @param PageController
	 * @return ArrayList<AddressVO>
	 * @throws Exception
	 */
	public ArrayList<AddressVO> query(AddressVO addressVO, PageController pageController) throws Exception;

	/**
	 * method description : query AddressVO by id
	 * 
	 * @param id
	 * @return AddressVO
	 * @throws Exception
	 */
	public AddressVO queryByID(String id) throws Exception;

	/**
	 * method description : query AddressVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return AddressVO
	 * @throws Exception
	 */
	public ArrayList<AddressVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify AddressVO by id
	 * 
	 * @param AddressVO
	 * @return AddressVO
	 * @throws Exception
	 */
	public AddressVO modify(AddressVO addressVO) throws Exception;

	/**
	 * method description : delete AddressVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete AddressVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
	/**
	 * method description : 根据父节点的id查找其子节点
	 * athor:tanzanlong
	 * @return ArrayList；
	 * @throws Exception
	 */
	public ArrayList<AddressVO> queryAllchildrenByID(String id) throws Exception;
	/**
	 * method description : 判断有没有子节点
	 * athor:tanzanlong
	 * @return boolean；
	 * @throws Exception
	 */
	public boolean ishaveChild(String id)  throws Exception ;

}




