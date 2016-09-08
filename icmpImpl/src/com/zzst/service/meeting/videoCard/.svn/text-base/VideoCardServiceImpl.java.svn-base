package com.zzst.service.meeting.videoCard;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.VideoCard.VideoCardDAO;
import com.zzst.model.meeting.videoCard.VideoCardVO;

/**	
 * class description: VideoCard ServiceImpl
 * @date  Mon May 13 10:45:05 CST 2013
 * @author ryan
 */
public class VideoCardServiceImpl implements VideoCardService{
	private static Logger logger = CjfLogger.getLogger(VideoCardServiceImpl.class.getName());

	@Override
	public VideoCardVO add(VideoCardVO videoCardVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		videoCardVO=VideoCardDAO.add(videoCardVO, null);
		logger.info("serviceImpl	add	end");
		return videoCardVO;
	}

	@Override
	public  ArrayList<VideoCardVO> query(VideoCardVO videoCardVO,PageController pageController) throws Exception{
		logger.info("serviceImpl	query	begin");
		ArrayList<VideoCardVO> listVideoCard = VideoCardDAO.query(videoCardVO,pageController);
		logger.info("serviceImpl	query	end");
		return  listVideoCard;
	}

	@Override
	public  VideoCardVO queryByID(String id) throws Exception{
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<VideoCardVO> listVideoCard = VideoCardDAO.queryByIDs(id,null);
		if(listVideoCard!=null&&listVideoCard.size()==1){
			logger.info("serviceImpl	end");
			return listVideoCard.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public  ArrayList<VideoCardVO> queryByIDs(String ids) throws Exception{
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<VideoCardVO> listVideoCard = VideoCardDAO.queryByIDs(ids,null);
		logger.info("serviceImpl	queryByIDs	end");
		return listVideoCard;
	}

	@Override
	public VideoCardVO modify(VideoCardVO videoCardVO )throws Exception{
		logger.info("serviceImpl	modify	begin");
		videoCardVO=VideoCardDAO.modify(videoCardVO,null);
		logger.info("serviceImpl	modify	end");
		return videoCardVO;
	}

	@Override
	public boolean deleteByID(String id )throws Exception{
		logger.info("serviceImpl	deleteByID	begin");
		int num	= VideoCardDAO.deleteByID(id,null);
		if(num==1){
			logger.info("serviceImpl	deleteByID	end");
			return true;
		}else{
			logger.info("serviceImpl	deleteByID	end");
			return false;
		}
	}

	@Override
	public int deleteByIDs(String ids )throws Exception{
		logger.info("serviceImpl	deleteByIDs	begin");
		int num	= VideoCardDAO.deleteByID(ids,null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

	public static void main(String args[]) throws Exception {
		//			DBConnection.setDbInfo("jdbc:oracle:thin:@10.1.3.182:1521:cinda", "cinda", "cinda");
		DBConnection.setDbInfo("jdbc:mysql://10.1.0.10:3306/icmp?characterEncoding=gb2312", "test", "123456");
		VideoCardVO vVideoCardVO = new VideoCardVO();
		vVideoCardVO.setEquipmentID("equipmentID");
		vVideoCardVO.setAppraisalTaskNum("appraisalTaskNum");
		vVideoCardVO.setShowFormatFlag("showFormatFlag");
		vVideoCardVO.setOutputModel("outputModel");
		vVideoCardVO.setAppraisalModel("appraisalModel");
		vVideoCardVO.setCollectModel("collectModel");
		vVideoCardVO.setLoginPassWord("loginPassWord");
		vVideoCardVO.setLoginName("loginName");
		vVideoCardVO.setInputModel("inputModel");
		vVideoCardVO.setDescription("description");
		vVideoCardVO.setRevision(new Long(888));

		new VideoCardServiceImpl().add(vVideoCardVO);
		System.out.println("=========add Success!");

		ArrayList<VideoCardVO> lstVideoCard = new VideoCardServiceImpl().query(vVideoCardVO,null);


		if(lstVideoCard.size()>0){
			System.out.println("=========query Result:");
			VideoCardVO vvVideoCardVO = (VideoCardVO) lstVideoCard.get(0);
			System.out.println("equipmentID=" + vvVideoCardVO.getEquipmentID());	            	           			        
			System.out.println("appraisalTaskNum=" + vvVideoCardVO.getAppraisalTaskNum());	            	           			        
			System.out.println("showFormatFlag=" + vvVideoCardVO.getShowFormatFlag());	            	           			        
			System.out.println("outputModel=" + vvVideoCardVO.getOutputModel());	            	           			        
			System.out.println("appraisalModel=" + vvVideoCardVO.getAppraisalModel());	            	           			        
			System.out.println("collectModel=" + vvVideoCardVO.getCollectModel());	            	           			        
			System.out.println("loginPassWord=" + vvVideoCardVO.getLoginPassWord());	            	           			        
			System.out.println("loginName=" + vvVideoCardVO.getLoginName());	            	           			        
			System.out.println("inputModel=" + vvVideoCardVO.getInputModel());	            	           			        
			System.out.println("description=" + vvVideoCardVO.getDescription());	            	           			        
			System.out.println("revision=" + vvVideoCardVO.getRevision());	            	           			        

		}else{
			System.out.println("=========query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
		}

	}

}

