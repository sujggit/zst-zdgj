package com.zzst.action.meeting.util;


import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
/**
* This is a tool class for connecting to ldap.
* @author wang
*/
public class LDAPUtil {
    //store the connected information
    private Hashtable env = null;
    //ldap context
    private LdapContext ctx = null;
    //set some connected information
    private String INITIAL_CONTEXT_FACTORY = "com.sun.jndi.ldap.LdapCtxFactory";
    private String PROVIDER_URL = "ldap://10.27.132.17:389";
    private String SECURITY_AUTHENTICATION = "simple";
    //email login
    private String SECURITY_PRINCIPAL = "sphy@cnpc.com.cn";
    private String SECURITY_CREDENTIALS = "sphy321";
    /** Creates a new instance of ConnLDAP */
    public LDAPUtil(String ip, String port) {
        env = new Hashtable();
        PROVIDER_URL = "ldap://" + ip + ":389";
        
    }
    
    /**
     * authenticate user.
     * @param email
     * @param passwd
     * @return
     */
    public boolean authenticate(String email, String passwd){
    	SECURITY_PRINCIPAL = email;
        SECURITY_CREDENTIALS = passwd;
        try {
        	
    		LdapContext ctxs	= this.connectLdap();
    		if(ctx != null){
    			return true;
    		}
    	} catch (NamingException e) {
    		e.printStackTrace();
    	}
    	return false;
    }
   
    /**
     * Connect to ldap and initialize the ldap context.
     * @throws javax.naming.NamingException If connect fail,throw this exception.
     */
    public LdapContext connectLdap()throws NamingException{
        //set the initializing information of the context
        env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
        //set the URL of ldap server
        env.put(Context.PROVIDER_URL, PROVIDER_URL);
        //set the authentication mode
        env.put(Context.SECURITY_AUTHENTICATION, SECURITY_AUTHENTICATION);
        //set user of AD
        env.put(Context.SECURITY_PRINCIPAL, SECURITY_PRINCIPAL);
        //set password of user
        env.put(Context.SECURITY_CREDENTIALS, SECURITY_CREDENTIALS);
        //initialize the ldap context
        ctx = new InitialLdapContext(env,null);
        return ctx;
    }
   
    
    public void closeContext() throws NamingException{
        ctx.close();
    }
   
    /**
     * Return the ldap context.
     * @return Return the ldap context.
     */
    public LdapContext getContext(){
        return this.ctx;
    }
   
    public static void main(String[] args){
    	LDAPUtil UTIL = new LDAPUtil("10.1.8.3", "3268");
    	System.out.print(UTIL.authenticate("icmp.test@zst.com", "zst.123"));
    }
}