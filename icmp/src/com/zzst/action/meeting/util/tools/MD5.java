package com.zzst.action.meeting.util.tools;

	import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
	/*
	 * MD5 算法
	*/
	public class MD5 {
	     
	    /**
	     * 16位
	     * @param strObj
	     * @return
	     */
	    public static String GetMD5Code(String strObj) {
	    	try {
    			MessageDigest md = MessageDigest.getInstance("MD5");
    			md.update(strObj.getBytes());
    			byte[]byteDigest = md.digest();
    			int i;
    			StringBuffer buf = new StringBuffer("");
    			for (int offset = 0; offset < byteDigest.length; offset++) {
    				i = byteDigest[offset];
    				if (i < 0)
    					i += 256;
    				if (i < 16)
    					buf.append("0");
    				buf.append(Integer.toHexString(i));
    			}
    			// 16位的加密
    			return buf.toString().substring(8, 24); 
    		} catch (NoSuchAlgorithmException e) {
    			e.printStackTrace();
    		}
	    	return null;
	    }
	    
	    /**
	     * 32位
	     * @param strObj
	     * @return
	     */
	    public static String GetMD5Code2(String strObj) {
	    	try {
    			MessageDigest md = MessageDigest.getInstance("MD5");
    			md.update(strObj.getBytes());
    			byte[]byteDigest = md.digest();
    			int i;
    			StringBuffer buf = new StringBuffer("");
    			for (int offset = 0; offset < byteDigest.length; offset++) {
    				i = byteDigest[offset];
    				if (i < 0)
    					i += 256;
    				if (i < 16)
    					buf.append("0");
    				buf.append(Integer.toHexString(i));
    			}
    			//32位加密
    			return buf.toString();
    		} catch (NoSuchAlgorithmException e) {
    			e.printStackTrace();
    		}
	    	return null;
	    }
	    
	    public static void main(String[] args) {
	        //System.out.println(MD5.GetMD5Code("000000"));
	        //System.out.println(MD5.GetMD5Code2("000000"));
	        System.out.println(MD5.GetMD5Code2("123456"));
	    }
	}
