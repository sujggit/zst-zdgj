package com.zzst.model.meeting.authorization;

import java.io.Serializable;

/**
 * class description: authorization Object
 * 
 * @date Tue May 28 11:06:52 CST 2013
 * @author ryan
 */
public class AuthorizationVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String Infotype;
	private String InfoKey;
	private String InfoValue;
	private String description;
	private String REF1;
	private String REF2;
	private String REF3;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setInfotype(String Infotype) {
		this.Infotype = Infotype;
	}

	public String getInfotype() {
		return Infotype;
	}

	public void setInfoKey(String InfoKey) {
		this.InfoKey = InfoKey;
	}

	public String getInfoKey() {
		return InfoKey;
	}

	public void setInfoValue(String InfoValue) {
		this.InfoValue = InfoValue;
	}

	public String getInfoValue() {
		return InfoValue;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setREF1(String REF1) {
		this.REF1 = REF1;
	}

	public String getREF1() {
		return REF1;
	}

	public void setREF2(String REF2) {
		this.REF2 = REF2;
	}

	public String getREF2() {
		return REF2;
	}

	public void setREF3(String REF3) {
		this.REF3 = REF3;
	}

	public String getREF3() {
		return REF3;
	}

}
