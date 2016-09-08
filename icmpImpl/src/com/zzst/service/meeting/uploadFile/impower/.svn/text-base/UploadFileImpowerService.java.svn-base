package com.zzst.service.meeting.uploadFile.impower;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.zzst.model.meeting.uploadFile.UploadFileImpowerVO;

/**
 * class description: UploadFileImpower Service
 * 
 * @date Mon May 27 18:11:34 CST 2013
 * @author ryan
 */
public interface UploadFileImpowerService {

	/**
	 * method description : add UploadFileImpowerVO object
	 * 
	 * @param UploadFileImpowerVO
	 * @return UploadFileImpowerVO
	 * @throws Exception
	 */
	public UploadFileImpowerVO add(UploadFileImpowerVO uploadFileImpowerVO)
			throws Exception;

	/**
	 * method description : query UploadFileImpower list
	 * 
	 * @param UploadFileImpowerVO
	 * @param PageController
	 * @return ArrayList<UploadFileImpowerVO>
	 * @throws Exception
	 */
	public ArrayList<UploadFileImpowerVO> query(
			UploadFileImpowerVO uploadFileImpowerVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query UploadFileImpowerVO by id
	 * 
	 * @param id
	 * @return UploadFileImpowerVO
	 * @throws Exception
	 */
	public UploadFileImpowerVO queryByID(String id) throws Exception;

	/**
	 * method description : query UploadFileImpowerVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return UploadFileImpowerVO
	 * @throws Exception
	 */
	public ArrayList<UploadFileImpowerVO> queryByIDs(String ids)
			throws Exception;

	/**
	 * method description :modify UploadFileImpowerVO by id
	 * 
	 * @param UploadFileImpowerVO
	 * @return UploadFileImpowerVO
	 * @throws Exception
	 */
	public UploadFileImpowerVO modify(UploadFileImpowerVO uploadFileImpowerVO)
			throws Exception;

	/**
	 * method description : delete UploadFileImpowerVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete UploadFileImpowerVO by uploadIds删除拥有下载权限的人,将权限设置为可见
	 * @param uploadFileImpowerVOTemp
	 */
	public void deleteByUploadIds(String[] uploadIds) throws Exception;

	/**
	 * method description : delete UploadFileImpowerVO by uploadIds
	 * 删除某一文件下的所有用户，但不包含权限为status的
	 * @param uploadFileImpowerVOTemp
	 */
	public void deleteByUsers(String uploadId, String userIDs, int status) throws Exception;

	public boolean delete(UploadFileImpowerVO uploadFileImpowerVO) throws Exception;
}
