package com.zzst.service.meeting.uploadFile;

import java.util.ArrayList;
import java.util.List;

import com.cbf.db.PageController;
import com.zzst.model.meeting.uploadFile.UploadFileVO;

/**
 * class description: UploadFile Service
 * 
 * @date Thu Sep 20 14:13:12 CST 2012
 * @author ryan
 */
public interface UploadFileService {

	/**
	 * method description : add UploadFileVO object
	 * 
	 * @param UploadFileVO
	 * @return UploadFileVO
	 * @throws Exception
	 */
	public UploadFileVO add(boolean ifNeedId ,UploadFileVO uploadFileVO) throws Exception;

	/**
	 * method description : query UploadFile list,必填的字段uploadType：上传文件类型,展示列表以及查询
	 * 
	 * @param UploadFileVO
	 * @param PageController
	 * @return ArrayList<UploadFileVO>
	 * @throws Exception
	 */
	public ArrayList<UploadFileVO> query(UploadFileVO uploadFileVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query UploadFileVO by id
	 * 
	 * @param id
	 * @return UploadFileVO
	 * @throws Exception
	 */
	public UploadFileVO queryByID(String id) throws Exception;

	/**
	 * method description : query UploadFileVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return UploadFileVO
	 * @throws Exception
	 */
	public ArrayList<UploadFileVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify UploadFileVO by id
	 * 
	 * @param UploadFileVO
	 * @return UploadFileVO
	 * @throws Exception
	 */
	public UploadFileVO modify(UploadFileVO uploadFileVO) throws Exception;

	/**
	 * method description : delete UploadFileVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete UploadFileVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delFileForState(String id) throws Exception;

	/**
	 * method description : 通过权限查询列表
	 * @param uploadFileVO
	 * @param pControler
	 * @return
	 * @throws Exception
	 */
	public List<UploadFileVO> queryByPower(UploadFileVO uploadFileVO,
			PageController pControler) throws Exception;
	
	/**
	 * method description : 通过VO查询对应信息，必填的字段uploadType
	 * @param uploadFileVO
	 * @param pControler
	 * @return
	 * @throws Exception
	 */
	public List<UploadFileVO> queryBaseInfo(UploadFileVO uploadFileVO,
			PageController pControler) throws Exception;
	
	public int deleteByMeeting(UploadFileVO uploadFileVO) throws Exception;
}
