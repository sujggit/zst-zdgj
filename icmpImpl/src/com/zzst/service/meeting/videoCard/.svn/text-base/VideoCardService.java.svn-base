package com.zzst.service.meeting.videoCard;


import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.videoCard.VideoCardVO;

/**	
 * class description: VideoCard Service 
 * @date  Mon May 13 10:45:05 CST 2013
 * @author ryan
 */
public interface VideoCardService {

	/**
	 * method description : add VideoCardVO	object
	 * @param VideoCardVO
	 * @return VideoCardVO
	 * @throws Exception
	 */
	public VideoCardVO add(VideoCardVO videoCardVO ) throws Exception;

	/**
	 * method description : query	VideoCard	list
	 * @param VideoCardVO
	 * @param PageController
	 * @return ArrayList<VideoCardVO>
	 * @throws Exception
	 */
	public  ArrayList<VideoCardVO> query(VideoCardVO videoCardVO,PageController pageController) throws Exception;

	/**
	 * method description : query	VideoCardVO	by	id
	 * @param id
	 * @return VideoCardVO
	 * @throws Exception
	 */
	public  VideoCardVO queryByID(String id) throws Exception;

	/**
	 * method description : query	VideoCardVO	by	ids
	 * @param String example: 1,2,3,4
	 * @return VideoCardVO
	 * @throws Exception
	 */
	public   ArrayList<VideoCardVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify	VideoCardVO	by id
	 * @param VideoCardVO
	 * @return VideoCardVO
	 * @throws Exception
	 */
	public VideoCardVO modify(VideoCardVO videoCardVO )throws Exception;


	/**
	 * method description : delete VideoCardVO by	id
	 * @param String	
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id )throws Exception;

	/**
	 * method description : delete VideoCardVO by	ids
	 * @param String example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id )throws Exception;
}

