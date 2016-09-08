
package com.zzst.service.meeting.user;
    

    import java.sql.SQLException;
	import java.util.ArrayList;
	import com.cbf.db.PageController;
	import com.cbf.db.TransactionManager;
import com.zzst.dao.meeting.user.UserDAO;
import com.zzst.model.meeting.user.UserVO;
	
	/**
	* class description: User	Service
	* @author ryan
	* @date Mon Jul 27 10:00:55 CST 2009
	*/
    
    public interface UserService {
    	/**
    	 * method description : userLogin  all 
    	 * 
    	 * @param UserVO
    	 * @return UserVO
    	 * @throws SQLException
    	 */
    	public UserVO userLogin(UserVO vUserVO)throws SQLException;
    	
    	
		/**
		 * method description : addUser
		 * @param UserVO
		 * @return UserVO
		 * @throws SQLException
		 */
		public UserVO addUser(UserVO vUserVO, TransactionManager tManager) throws Exception;

		public UserVO addUserByCreateId(UserVO vUserVO, TransactionManager tManager) throws Exception;
		/**
		 * method description : delUser
		 * @param UserVO
		 * @return boolean
		 * @throws SQLException
		 */
		public boolean delUser(UserVO vUserVO , TransactionManager tManager)throws SQLException;
		
		/**
		 * 删除所有用户以及user_role user_depart（慎用）
		 * @param vUserVO
		 * @param tManager
		 * @return
		 * @throws SQLException
		 */
		public void delAllUser(TransactionManager tManager)throws SQLException;


		/**
		 * method description : modify User state by id
		 * @param UserVO
		 * @return UserVO
		 * @throws SQLException
		 */
		public UserVO delUserForState(UserVO vUserVO, TransactionManager tManager)throws SQLException;


		/**
		 * method description : modify User all columns by id
		 * @param UserVO
		 * @return UserVO
		 * @throws SQLException
		 */
		public UserVO modifyUser(UserVO vUserVO,TransactionManager tManager)throws SQLException;


		/**
		 * method description : getUserList
		 * @param UserVO
		 * @return ArrayList<UserVO>
		 * @throws SQLException
		 */
		public  ArrayList<UserVO> getUserList(UserVO vUserVO,PageController mPageController) throws SQLException;
		
		
		/**
		 * method description : get User  info
		 * @param UserVO
		 * @return UserVO
		 * @throws SQLException
		 */
		public  UserVO getUserInfo(UserVO vUserVO,TransactionManager tManager) throws SQLException;
		/**
		 * 有bug，不能使用
		 * 根据id查询，多个id已‘,分开’ 如：1,2,3
		 * @param String id   
		 * @param mPageController
		 * @return ArrayList<UserVO>
		 * @throws SQLException
		 */
//		public  ArrayList<UserVO> getListForIDS(String ids,
//				PageController mPageController) throws SQLException;
		
		/**
		 * 根据部门id查询所有人员
		 */
		public ArrayList<UserVO> getUsersByDeprtmentID( String departmentID, PageController mPageController )throws SQLException;


		public UserVO modifyUserByLoginName(UserVO vUserVO, TransactionManager tManager)
			throws SQLException;
		
		/**
		 * 根据vo查询出部门下的该岗位的人员20130704
		 * userID,departmentID,postNo
		 * @param vUserVO
		 * @param tManager
		 * @return
		 * @throws SQLException
		 */
		public ArrayList<UserVO> getUsersByDeptPost(UserVO vUserVO, PageController mPageController)throws Exception;
		
		
		 public ArrayList<UserVO> getUserListbyName(UserVO vUserVO,
					PageController mPageController) throws SQLException ;
	}
    
   

    