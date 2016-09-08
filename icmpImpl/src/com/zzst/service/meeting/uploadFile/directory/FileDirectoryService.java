package com.zzst.service.meeting.uploadFile.directory;

/**
 *@Description
 *@date 2013-5-6下午02:08:58
 *@author ryan
 */

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.uploadFile.directory.FileDirectoryVO;

public interface FileDirectoryService {

	/**
	 * method description : add FileDirectoryVO object
	 * 
	 * @param FileDirectoryVO
	 * @return FileDirectoryVO
	 * @throws Exception
	 */
	public FileDirectoryVO add(FileDirectoryVO fileDirectoryVO) throws Exception;

	/**
	 * method description : query FileDirectory list
	 * 
	 * @param FileDirectoryVO
	 * @param PageController
	 * @return ArrayList<FileDirectoryVO>
	 * @throws Exception
	 */
	public ArrayList<FileDirectoryVO> query(FileDirectoryVO fileDirectoryVO, PageController pageController)
			throws Exception;

	/**
	 * method description : query FileDirectoryVO by id
	 * 
	 * @param id
	 * @return FileDirectoryVO
	 * @throws Exception
	 */
	public FileDirectoryVO queryByID(String id) throws Exception;

	/**
	 * method description : query FileDirectoryVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return FileDirectoryVO
	 * @throws Exception
	 */
	public ArrayList<FileDirectoryVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify FileDirectoryVO by id
	 * 
	 * @param FileDirectoryVO
	 * @return FileDirectoryVO
	 * @throws Exception
	 */
	public FileDirectoryVO modify(FileDirectoryVO fileDirectoryVO) throws Exception;

	/**
	 * method description : delete FileDirectoryVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete FileDirectoryVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public void deleteByIDs(String id) throws Exception;
}
