package com.zzst.action.meeting.util.tools;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * 加密解密类
 */
public class Eryptogram {
	private static String Algorithm = "DES";
	private String key;
	// 定义 加密算法,可用 DES,DESede,Blowfish
	static boolean debug = false;

	/**
	 * 构造子注解.
	 */
	public Eryptogram(String strkey) {
		this.key = strkey;
	}

	public Eryptogram() {
		this.key = "CB7A92E3D3491945";
	}
	
	/**
	 * 生成密钥
	 * 
	 * @return byte[] 返回生成的密钥
	 * @throws exception
	 *             扔出异常.
	 */
	public  byte[] getSecretKey() throws Exception {
		KeyGenerator keygen = KeyGenerator.getInstance(Algorithm);
		SecretKey deskey = keygen.generateKey();
		// System.out.println ("生成密钥:"+bytesToHexString (deskey.getEncoded ()));
		if (debug)
			System.out.println("生成密钥:" + bytesToHexString(deskey.getEncoded()));
		return deskey.getEncoded();
	}

	
	public  byte[] encryptData2(byte[] input, byte[] key) throws Exception {
		SecretKey deskey = new javax.crypto.spec.SecretKeySpec(key, Algorithm);
		if (debug) {
			System.out.println("加密前的二进串:" + byte2hex(input));
			System.out.println("加密前的字符串:" + new String(input));

		}
		Cipher c1 = Cipher.getInstance(Algorithm);
		c1.init(Cipher.ENCRYPT_MODE, deskey);
		byte[] cipherByte = c1.doFinal(input);
		if (debug)
			System.out.println("加密后的二进串:" + byte2hex(cipherByte));
		return cipherByte;

	}

	
	public  byte[] decryptData2(byte[] input, byte[] key) throws Exception {
		SecretKey deskey = new javax.crypto.spec.SecretKeySpec(key, Algorithm);
		if (debug)
			System.out.println("解密前的信息:" + byte2hex(input));
		Cipher c1 = Cipher.getInstance(Algorithm);
		c1.init(Cipher.DECRYPT_MODE, deskey);
		byte[] clearByte = c1.doFinal(input);
		if (debug) {
			System.out.println("解密后的二进串:" + byte2hex(clearByte));
			System.out.println("解密后的字符串:" + (new String(clearByte)));

		}
		return clearByte;

	}

	/**
	 * 字节码转换成16进制字符串
	 * 
	 * @param byte[] b 输入要转换的字节码
	 * @return String 返回转换后的16进制字符串
	 */
	public  String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
			if (n < b.length - 1)
				hs = hs + ":";

		}
		return hs.toUpperCase();

	}

	/**
	 * 字符串转成字节数组.
	 * 
	 * @param hex
	 *            要转化的字符串.
	 * @return byte[] 返回转化后的字符串.
	 */
	public  byte[] hexStringToByte(String hex) {
		int len = (hex.length() / 2);
		byte[] result = new byte[len];
		char[] achar = hex.toCharArray();
		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
		}
		return result;
	}

	private  byte toByte(char c) {
		byte b = (byte) "0123456789ABCDEF".indexOf(c);
		return b;
	}

	/**
	 * 字节数组转成字符串.
	 * 
	 * @param String
	 *            要转化的字符串.
	 * @return 返回转化后的字节数组.
	 */
	public  final String bytesToHexString(byte[] bArray) {
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 从数据库中获取密钥.
	 * 
	 * @param deptid
	 *            企业id.
	 * @return 要返回的字节数组.
	 * @throws Exception
	 *             可能抛出的异常.
	 */
	public  byte[] getSecretKey(long deptid) throws Exception {
		byte[] key = null;
		String value = null;
		// CommDao dao=new CommDao();
		// List list=dao.getRecordList("from Key k where k.deptid="+deptid);
		// if(list.size()>0){
		// value=((com.csc.sale.bean.Key)list.get(0)).getKey();
		value = "CB7A92E3D3491964";
		key = hexStringToByte(value);
		// }
		if (debug)
			System.out.println("密钥:" + value);
		return key;
	}
	
	/**
	 * 将指定的数据根据提供的密钥进行加密
	 * 
	 * @param input
	 *            需要加密的数据
	 * @param key
	 *            密钥
	 * @return byte[] 加密后的数据
	 * @throws Exception
	 */
	public String encryptData(String data) {
		String en = null;
		try {
			byte[] key = hexStringToByte(this.key);
			en = bytesToHexString(encryptData2(data.getBytes(), key));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return en;
	}
	
	/**
	 * 将给定的已加密的数据通过指定的密钥进行解密
	 * 
	 * @param input
	 *            待解密的数据
	 * @param key
	 *            密钥
	 * @return byte[] 解密后的数据
	 * @throws Exception
	 */
	public String decryptData(String data) {
		String de = null;
		try {
			byte[] key = hexStringToByte(this.key);
			de = new String(decryptData2(hexStringToByte(data), key));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return de;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public static void main(String[] str){
		try {
//			Eryptogram.encryptData("w".getBytes(), "sdf".getBytes());//加密
//			System.out.println(e.encryptData("熊"));
			//decryptData
			System.out.println(new Eryptogram().encryptData("123456"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
