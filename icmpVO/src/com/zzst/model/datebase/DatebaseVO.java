package com.zzst.model.datebase;
/**
 * @author zhangjy
 * @date 2013-11-29
 */
public class DatebaseVO {
 private String db_url;
 private String db_name;
 private String pass;
 private String db_jndi;
 private String bak_db_url;
 private String bak_db_name;
 private String bak_pass;
 private String bak_db_jndi;
 private boolean openbak;
public String getDb_url() {
	return db_url;
}
public void setDb_url(String dbUrl) {
	db_url = dbUrl;
}
public String getDb_name() {
	return db_name;
}
public void setDb_name(String dbName) {
	db_name = dbName;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getDb_jndi() {
	return db_jndi;
}
public void setDb_jndi(String dbJndi) {
	db_jndi = dbJndi;
}
public String getBak_db_url() {
	return bak_db_url;
}
public void setBak_db_url(String bakDbUrl) {
	bak_db_url = bakDbUrl;
}
public String getBak_db_name() {
	return bak_db_name;
}
public void setBak_db_name(String bakDbName) {
	bak_db_name = bakDbName;
}
public String getBak_pass() {
	return bak_pass;
}
public void setBak_pass(String bakPass) {
	bak_pass = bakPass;
}
public String getBak_db_jndi() {
	return bak_db_jndi;
}
public void setBak_db_jndi(String bakDbJndi) {
	bak_db_jndi = bakDbJndi;
}
public void setOpenbak(boolean openbak) {
	this.openbak = openbak;
}
public boolean isOpenbak() {
	return openbak;
}
 
}
