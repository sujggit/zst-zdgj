package com.zzst.service.meeting.template;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.template.TemplateVO;

/**
 * class description: Template Service
 * 
 * @date Wed Mar 20 17:56:26 CST 2013
 * @author ryan
 */
public interface TemplateService {

	/**
	 * method description : add TemplateVO object
	 * 
	 * @param TemplateVO
	 * @return TemplateVO
	 * @throws Exception
	 */
	public TemplateVO add(TemplateVO templateVO) throws Exception;

	/**
	 * method description : query Template list
	 * 
	 * @param TemplateVO
	 * @param PageController
	 * @return ArrayList<TemplateVO>
	 * @throws Exception
	 */
	public ArrayList<TemplateVO> query(TemplateVO templateVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query TemplateVO by id
	 * 
	 * @param id
	 * @return TemplateVO
	 * @throws Exception
	 */
	public TemplateVO queryByID(String id) throws Exception;

	/**
	 * method description : query TemplateVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return TemplateVO
	 * @throws Exception
	 */
	public ArrayList<TemplateVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify TemplateVO by id
	 * 
	 * @param TemplateVO
	 * @return TemplateVO
	 * @throws Exception
	 */
	public TemplateVO modify(TemplateVO templateVO) throws Exception;

	/**
	 * method description : delete TemplateVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete TemplateVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
	
	
}
