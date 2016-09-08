/**
 * 
 */
package com.zzst.model.meeting.kst;

import java.util.ArrayList;
import java.util.List;

/**
 * 可视通接口：getallgroups 返回结果
 * @author zhangliang
 * Dec 29, 2011 9:54:45 AM
 */
public class GroupsOut {

	private List<Group> dataList = new ArrayList<Group>();

	public void add(Group obj) {
		dataList.add(obj);
	}

	//一级
	public static class Group {
		private String id;

		private String name;

		private String type;

		private List<SubGroup> gList = new ArrayList<SubGroup>();

		public void addgroup(SubGroup obj) {
			gList.add(obj);
		}

		//二级
		public static class SubGroup {
			private String id;

			private String name;

			private String type;			

			 

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			/**
			 * @return the type
			 */
			public String getType() {
				return type;
			}

			/**
			 * @param type the type to set
			 */
			public void setType(String type) {
				this.type = type;
			}

		}

		 
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the type
		 */
		public String getType() {
			return type;
		}

		/**
		 * @param type the type to set
		 */
		public void setType(String type) {
			this.type = type;
		}

		/**
		 * @return the gList
		 */
		public List<SubGroup> getGList() {
			return gList;
		}

		/**
		 * @param list the gList to set
		 */
		public void setGList(List<SubGroup> list) {
			gList = list;
		}

	}

	/**
	 * @return the dataList
	 */
	public List<Group> getDataList() {
		return dataList;
	}

	/**
	 * @param dataList the dataList to set
	 */
	public void setDataList(List<Group> dataList) {
		this.dataList = dataList;
	}

}
