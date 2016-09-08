package com.zzst.mcu.service.impl.vo;


/**
 *@Description
 *@date 2011-3-16下午01:25:23
 *@author ryan
 */
public class ControlLoginVO {
	
	
	
	private boolean	hasLogin	=	false;
	private	String id;
	private String description;
	private String your_token1;
	private String your_token2;
	private String message_id;
	private String mcu_token;
	private String mcu_user_token;
	private String authorization_group;
	private String api_number;
	private String product_type;
	 
	
	public boolean hasLogin() {
		return hasLogin;
	}
	public void setLogin(boolean hasLogin) {
		this.hasLogin = hasLogin;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getYour_token1() {
		return your_token1;
	}
	public void setYour_token1(String yourToken1) {
		your_token1 = yourToken1;
	}
	public String getYour_tokend2() {
		return your_token2;
	}
	public void setYour_token2(String yourToken2) {
		your_token2 = yourToken2;
	}
	public String getMessage_id() {
		return message_id;
	}
	public void setMessage_id(String messageId) {
		message_id = messageId;
	}
	public String getMcu_token() {
		return mcu_token;
	}
	public void setMcu_token(String mcuToken) {
		mcu_token = mcuToken;
	}
	public String getMcu_user_token() {
		return mcu_user_token;
	}
	public void setMcu_user_token(String mcuUserToken) {
		mcu_user_token = mcuUserToken;
	}
	public String getAuthorization_group() {
		return authorization_group;
	}
	public void setAuthorization_group(String authorizationGroup) {
		authorization_group = authorizationGroup;
	}
	public String getApi_number() {
		return api_number;
	}
	public void setApi_number(String apiNumber) {
		api_number = apiNumber;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String productType) {
		product_type = productType;
	}
	
	
}
