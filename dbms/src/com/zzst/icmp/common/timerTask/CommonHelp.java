package com.zzst.icmp.common.timerTask;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.common.hibernate.db.HibernateSessionFactory;
import com.zzst.icmp.entity.ZTBaseinfo;

public class CommonHelp {
	private static Logger logger = Logger.getLogger(CommonHelp.class.getName());

	//最后更新的时间在z_t_baseinfo存储，type类型为：dbms_lasttime
	public static String infotype = "dbms_lasttime";

	//当前节点的ID
	public static String nodeID = "";

	//最后更新的时间戳
	public static Timestamp LASTTIME;

	//当前是否在更新中
	public static boolean STATUS_UPDATING = false;

	/**
	 * 提取与父节点服务器同步的最后时间戳
	 * @param Timestamp 为空不允许同步
	 */
	public static Timestamp getUpdateLastTime() {
		if (STATUS_UPDATING) {
			logger.info("正在同步中。。。，不允许同时操作");
			return null;
		}
		Session session = HibernateSessionFactory.getSessionFactory()
				.openSession();
		Criteria c = session.createCriteria(ZTBaseinfo.class);
		c.add(Restrictions.eq("infotype", infotype));
		ArrayList<ZTBaseinfo> bList = new ArrayList<ZTBaseinfo>();
		ZTBaseinfo baseInfo = new ZTBaseinfo();
		bList = (ArrayList<ZTBaseinfo>) c.list();
		if (bList != null && bList.size() > 0) {
			baseInfo = bList.get(0);
			LASTTIME = new Timestamp(Long.valueOf(baseInfo.getInfovalue()));
			logger.info("最后的同步时间：" + LASTTIME);
		} else {
			LASTTIME = new Timestamp(System.currentTimeMillis());
			logger.info("系统第一次同步,时间：" + LASTTIME);
		}
		//        if(baseInfo ==null){
		//        	LASTTIME = new Timestamp(System.currentTimeMillis());
		//        	logger.info("系统第一次同步,时间："+LASTTIME);
		//        }else{
		//        	LASTTIME = new Timestamp(Long.valueOf(baseInfo.getInfovalue()));
		//        	logger.info("最后的同步时间："+LASTTIME);
		//        }
		session.close();
		return LASTTIME;
	}

	public static void updateLastTime(Timestamp lastTime) {
		logger.info("更新最后成功时间戳：" + lastTime);
		Session session = HibernateSessionFactory.getSessionFactory()
				.openSession();
		Transaction tx = session.beginTransaction();
		Criteria c = session.createCriteria(ZTBaseinfo.class);
		c.add(Restrictions.eq("infotype", infotype));
		ArrayList<ZTBaseinfo> bList = new ArrayList<ZTBaseinfo>();
		ZTBaseinfo baseInfo = new ZTBaseinfo();
		long time = lastTime.getTime() - 10000;//更新时间记录到当前时间的前10秒，同步数据避免错漏
		bList = (ArrayList<ZTBaseinfo>) c.list();
		if (bList != null && bList.size() > 0) {
			baseInfo = bList.get(0);
		}
		baseInfo.setInfovalue(time + "");
		baseInfo.setInfotype(infotype);
		session.merge(baseInfo);
		session.flush();
		tx.commit();
		session.close();

		LASTTIME = lastTime;
	}
	//比较两个对象的各个属性是否一样。result的key为属性名，如果一样value为true，不一样为false
	public static <T> Map<String, String> compare(T obj1, T Obj2)
			throws Exception {

		Map<String, String> result = new HashMap<String, String>();

		Field[] fs = obj1.getClass().getDeclaredFields();
		for (Field f : fs) {
			f.setAccessible(true);
			Object v1 = f.get(obj1);
			Object v2 = f.get(Obj2);
			result.put(f.getName(), String.valueOf(equals(v1, v2)));
		}
		return result;
	}

	public static boolean equals(Object obj1, Object obj2) {

		if (obj1 == obj2) {
			return true;
		}
		if (obj1 == null || obj2 == null) {
			return false;
		}
		return obj1.equals(obj2);
	}
}
