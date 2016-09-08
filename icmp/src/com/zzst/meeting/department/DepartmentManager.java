/**
 * 
 */
package com.zzst.meeting.department;

import java.io.Serializable;
import java.util.List;

import com.zzst.dao.meeting.department.DepartmentDAO;
import com.zzst.model.meeting.department.DepartmentVO;

/**
 * @author zhangliang
 * Nov 1, 2011 3:10:14 PM
 */
public class DepartmentManager {
	
	private DepartmentDAO dao = new DepartmentDAO();
	//
	public DepartmentVO get(Serializable id){
		return dao.get(id);
	}
	/**
	 * ���ָ���ڵ�����ж��ӽڵ�
	 * @param id
	 */
	@SuppressWarnings("unchecked")
	public List<DepartmentVO> getChildrenById(String id){
		return dao.getChildrenById(id);
	}
	/**
	 * �������
	 * @param obj 
	 */
	public void save(DepartmentVO obj){
		dao.addDepartment(obj,true);
	}
	/**
	 * �������
	 * @param obj 
	 */
	public void update(DepartmentVO obj){
		dao.modifyDepartment(obj);
	}
	/**
	 * ɾ��ָ����һ�����
	 * @param id
	 */
	public void removeById(String id){
		dao.delDepartment(id);
	}
	/**
	 * �첽���±���
	 * @param id
	 * @param title
	 * @return true-�޸ĳɹ� false-�޸�ʧ��
	 */
	public Boolean ajaxUpdateTitle(Integer id,String title){
		return dao.ajaxUpdateTitle(id+"", title);
	}
	/**
	 * �첽ɾ����ݣ�����������ڵ�
	 * @param id
	 * @param title
	 */
	public void ajaxRemoveNode(String id){
		DepartmentVO obj = dao.get(id);		
		dao.ajaxRemoveNode(id);
	}

}
