package com.zzst.icmp;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.common.hibernate.db.FarHibernateSessionFactory;
import com.common.hibernate.db.HibernateSessionFactory;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  try {
	            Session session =HibernateSessionFactory.getSessionFactory().openSession();
			    Transaction tx = session.beginTransaction();
	            SQLQuery sqlQ = session.createSQLQuery("select id from a").addScalar("id");
	            List list = sqlQ.list();
	            System.out.println(list.size());
	            Iterator it = list.iterator();
	            int i=0;
	            SessionFactory sf = FarHibernateSessionFactory.getSessionFactory();
	            while (it.hasNext()){
	            	if(i==1) return;
	            	i++;
	                //因为将查询结果与Student类关联，因此返回的是Student集合
	                String s = (String)it.next();
	                System.out.println(s);
	                Session session2 = sf.openSession();
	                
//	                session2.createSQLQuery("DROP TRIGGER IF EXISTS `as`;CREATE TRIGGER `as` BEFORE UPDATE ON `z_b` FOR EACH ROW begin  set new.a1 = 'aaa2';end ").executeUpdate();
	                sqlQ = session2.createSQLQuery("select id from b").addScalar("id");
		            List list2 = sqlQ.list();
		            System.out.println("###"+i+"=="+list2.size());
	                System.out.println("成功");
		            session2.close();
	            }
	            tx.commit();
	            session.close();
	        } catch (HibernateException e) {
	            e.printStackTrace();
	        }
	}


}
