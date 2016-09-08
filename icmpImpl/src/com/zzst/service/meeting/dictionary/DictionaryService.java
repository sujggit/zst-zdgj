package com.zzst.service.meeting.dictionary;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.zzst.model.meeting.dictionary.DictionaryVO;

/**
 * class description: Dictionary Service
 * 
 * @date Tue Feb 19 17:00:51 CST 2013
 * @author ryan
 */
public interface DictionaryService {

	/**
	 * method description : add DictionaryVO object
	 * 
	 * @param DictionaryVO
	 * @return DictionaryVO
	 * @throws Exception
	 */
	public DictionaryVO add(DictionaryVO dictionaryVO) throws Exception;

	/**
	 * method description : query Dictionary list
	 * 
	 * @param DictionaryVO
	 * @param PageController
	 * @return ArrayList<DictionaryVO>
	 * @throws Exception
	 */
	public ArrayList<DictionaryVO> query(DictionaryVO dictionaryVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query DictionaryVO by id
	 * 
	 * @param id
	 * @return DictionaryVO
	 * @throws Exception
	 */
	public DictionaryVO queryByID(String id) throws Exception;

	/**
	 * method description : query DictionaryVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return DictionaryVO
	 * @throws Exception
	 */
	public ArrayList<DictionaryVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify DictionaryVO by id
	 * 
	 * @param DictionaryVO
	 * @return DictionaryVO
	 * @throws Exception
	 */
	public DictionaryVO modify(DictionaryVO dictionaryVO) throws Exception;

	/**
	 * method description : delete DictionaryVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete DictionaryVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;

	/**
	 * 
	 * @param dictionaryVO
	 * @throws Exception
	 */
	public DictionaryVO modifyDicValue(DictionaryVO dictionaryVO) throws Exception;

	public boolean deleteByVO(DictionaryVO dictionaryVO) throws Exception;
	
}
