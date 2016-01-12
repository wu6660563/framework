package com.latin.model;

import java.io.Serializable;

/**
 * 
 * 测试整个Spring MVC框架 AccountModel
 * 
 * @Description：TODO
 * @author：nick
 * @CreateTime：2015/09/08
 * @Remark：TODO
 * @version 1.0
 */
public class AccountModel implements Serializable {
	
	private static final long serialVersionUID = -7970848646314840509L;
	
	private int accountId;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String address;
	
	/**
	 * 
	 * @Title toString
	 * @Description 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.accountId + "#" + this.username + "#" + this.password + "#"
				+ this.email + "#" + this.address;
	}

	/**
	 * @return accountId
	 */
	public int getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId
	 * accountId
	 */
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 * username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 * password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 * email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 * address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

}
