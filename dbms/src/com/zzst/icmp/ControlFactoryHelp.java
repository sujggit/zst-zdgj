package com.zzst.icmp;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.common.hibernate.db.FarHibernateSessionFactory;
import com.common.hibernate.db.HibernateSessionFactory;
import com.zzst.icmp.common.timerTask.CommonHelp;
import com.zzst.icmp.common.timerTask.MyTimerTask;
import com.zzst.icmp.entity.ZTLevel;

public class ControlFactoryHelp {
	private static Logger logger = Logger.getLogger(ControlFactoryHelp.class.getName());
	
	public static String columnName ="dbms_time";
	public static String far_db_name="";
	public static String far_db_password="";
	public static String far_db_datasource="";
	
	public static String local_db_name="";
	public static String local_db_password="";
	public static String local_db_datasource="";
	
	
	private static Session parentSession;
	private static Session localSession;
	private static Transaction parentTX ;
	private static Transaction localTX ;
	
	public static void z_t_level(){
		Criteria c =  parentSession.createCriteria(ZTLevel.class);
		List<ZTLevel> parentList =  c.list();
		logger.info("���ڵ�z_t_level��Ҫ���µ���������"+parentList.size());
		Map<String,ZTLevel> parentMap = new HashMap<String,ZTLevel>();
		for(int i=0;i<parentList.size();i++){
			ZTLevel level =parentList.get(i);
	        parentMap.put(level.getLevelId(), level);
        }
		Criteria c2 =  localSession.createCriteria(ZTLevel.class);
		List<ZTLevel> localList = c2.list();
		logger.info("���ؽڵ�z_t_level��Ҫ���µ���������"+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTLevel entity = (ZTLevel)localList.get(i);
			ZTLevel parentEntity =parentMap.get(entity.getLevelId());
			try{
				//������²���
				if(parentEntity!=null){
					parentMap.remove(entity.getLevelId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//�Ƚ����ڣ����µ�����Ϊ׼�����ظ���
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//���ڵ����
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
				}else{//���ض�һ������
					parentSession.merge(entity);
					parentSession.flush();
				}
			}catch(Exception e){
				logger.error("ͬ��z_t_level��ʱ�����쳣�����طּ���Ϣ��"+entity.getLevelName()+"("+entity.getLevelId()+")ʧ��");
			}
		}
		
		//�����ڵ��ж����������
		if(parentMap.size()>0){//���������ݱȱ��ض࣬����������������ݸ��µ�����
			for (Map.Entry<String, ZTLevel> mapEntry : parentMap.entrySet()) {
				ZTLevel entity = mapEntry.getValue();
				localSession.merge(entity);
				localSession.flush();
			}
		}
	}

	public static String updateLevel(String parentDBIP,String localNodeIP,String localNodeDBIP){
		String levelId="";
		try{
			
			SessionFactory sss =FarHibernateSessionFactory.getSessionFactory(); 
			 parentSession	=sss.openSession();
			 localSession	=HibernateSessionFactory.getSessionFactory().openSession();
			 parentTX		= parentSession.beginTransaction();
			 localTX			= localSession.beginTransaction();
			
			 List rootLst = localSession.createSQLQuery("select  levelId, levelName,pid,levelPath,createUserId,createTime,status,description,revision, nodeServer,nodeIp,nodePort,dbName, dbPwd,dbIp,dbPort,dbms_time,dbUserName from z_t_level where nodeIp ='"+localNodeIP+"' and dbIp='"+localNodeDBIP+"'").addEntity(ZTLevel.class).list();
			if(rootLst!=null&&rootLst.size()==1){
				ZTLevel rootEntity= (ZTLevel)rootLst.get(0);
				if(rootEntity.getLevelId().equalsIgnoreCase("a")){
					localSession.delete(rootEntity);
					localSession.flush();
				}

				String uuid = new UUIDGenerator().generate().toString();
				if(rootEntity.getLevelId().equalsIgnoreCase("a"))
					rootEntity.setLevelId(uuid);
				rootEntity.setDbmsTime(new Timestamp(System.currentTimeMillis()));

				localSession.clear();
				localSession.merge(rootEntity);
				localSession.flush();
				CommonHelp.nodeID = rootEntity.getLevelId();
				levelId = rootEntity.getLevelId();
				
			}else{
				logger.info("���������쳣��IDΪa������������Ϊ1");
				return "";
			}
			
			 z_t_level();
//			 
			
			//Ŀ�ģ����Բ�ѯ�����ڵ���Ϣ
			ZTLevel parentEntity = null;
			SQLQuery sqlQ = localSession.createSQLQuery("select levelId, levelName,pid,levelPath,createUserId,createTime,status,description,revision, nodeServer,nodeIp,nodePort,dbName, dbPwd,dbIp,dbPort,dbms_time,dbUserName  from z_t_level where dbIp='"+parentDBIP+"'").addEntity(ZTLevel.class);
			List lst = sqlQ.list();
			if(lst!=null&&lst.size()==1){
				parentEntity= (ZTLevel)lst.get(0);
			}else{
				logger.info("�쳣�����ڵ����ݲ�Ϊ1��"+lst.size());
				return "";
			}
			
			List rootLst2 = localSession.createSQLQuery("select levelId, levelName,pid,levelPath,createUserId,createTime,status,description,revision, nodeServer,nodeIp,nodePort,dbName, dbPwd,dbIp,dbPort,dbms_time,dbUserName  from z_t_level where nodeIp ='"+localNodeIP+"' and dbIp='"+localNodeDBIP+"'").addEntity(ZTLevel.class).list();
			if(rootLst2!=null&&rootLst2.size()==1&&parentEntity!=null){
				ZTLevel rootEntity= (ZTLevel)rootLst2.get(0);
				rootEntity.setPid(parentEntity.getLevelId());
				localSession.saveOrUpdate(rootEntity);
				localSession.flush();
			}else{
				logger.info("���������쳣��û��IDΪa������");
				return "";
			}
			
//			//Ŀ�ģ����±���������ȥ
			z_t_level();
			parentTX.commit();
			localTX.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			logger.info("ͬ��level���쳣"+e.getMessage());
			return "";
		}
		return levelId;
	}
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("./src/applog4j.properties");//����.properties�ļ�
		//new MyTimerTask().run();
		//updateLevel("10.1.5.216","10.1.5.34","10.1.8.7");
		updateStructure();
	}
	
	/**
	 * ���������ݿ��е�ÿ��������һ��ʱ����ֶ�dbms_time�����Ա������ӡ��޸�ʱ�Ĵ���������¼����޸�ʱ��
	 */
	public static void updateStructure(){
		try{
			String db_url = HibernateSessionFactory.getConfiguration().getProperties().getProperty("hibernate.connection.url");
			String tableSchema = db_url.substring(db_url.lastIndexOf("/")+1, db_url.length());
			System.out.println(tableSchema);
			//��ѯtest���ݿ��µ����б���
			 String selectSQL ="SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = '"+tableSchema+"'  and TABLE_TYPE='BASE TABLE' ;";
			 Session session =HibernateSessionFactory.getSessionFactory().openSession();
	         Transaction tx = session.beginTransaction();
	         SQLQuery sqlQ = session.createSQLQuery(selectSQL).addScalar("TABLE_NAME");
	         List list = sqlQ.list();
	         Iterator it = list.iterator();
	         while (it.hasNext()){
	             String tableName = (String)it.next();
	             System.out.println("������"+tableName);
	             if("z_t_delids".equalsIgnoreCase(tableName)) continue;
	             //��鵱ǰ���ݿ��Ƿ��и��ֶ�
	             String tableColumn="DESCRIBE "+tableName+" "+columnName;
	             int sd = session.createSQLQuery(tableColumn).executeUpdate();
	             if(sd==0){//�ñ�û�и��ֶ���
	            	 String addColumnSQL = "alter table "+tableName+"  add "+columnName+" datetime default NULL COMMENT '������ʱ��'";
	            	 session.createSQLQuery(addColumnSQL).executeUpdate();
	            	 session.flush();
	             }else{
	            	 System.out.println("��"+tableName+"�Ѿ���"+columnName+"�ֶ���");
	             }

	             String triggerName1 = tableName+"update";
	             String droptriggerSQL = "DROP TRIGGER IF EXISTS "+triggerName1;
	             session.createSQLQuery(droptriggerSQL).executeUpdate();
	             session.flush();
	             String triggerSQL = "CREATE TRIGGER "+triggerName1+" BEFORE UPDATE ON "+tableName+" FOR EACH ROW SET new."+columnName+" =now();";
	             session.createSQLQuery(triggerSQL).executeUpdate();
	             session.flush();
	             
	             String triggerName2 = tableName+"add";
	             droptriggerSQL = "DROP TRIGGER IF EXISTS "+triggerName2;
	             session.createSQLQuery(droptriggerSQL).executeUpdate();
	             session.flush();
	             triggerSQL = "CREATE TRIGGER "+triggerName2+" BEFORE INSERT ON "+tableName+" FOR EACH ROW SET new."+columnName+" =now();";
	             session.createSQLQuery(triggerSQL).executeUpdate();
	             session.flush();
	             
//	             String triggerName3 = tableName+"del";
//	             droptriggerSQL = "DROP TRIGGER IF EXISTS "+triggerName3;
//	             session.createSQLQuery(droptriggerSQL).executeUpdate();
//	             session.flush();
//	             triggerSQL = "insert into z_t_delids(id,tableID,tableName) values(uuid(),OLD.id,'a');";
//	             session.createSQLQuery(triggerSQL).executeUpdate();
//	             session.flush();
	         }
	         System.out.println("��ʼ�����ݿ�ɹ�����");
	         tx.commit();
	         session.close();
	     } catch (Exception e) {
	         e.printStackTrace();
	     }
	}
}
