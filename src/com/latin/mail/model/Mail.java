package com.latin.mail.model;

import com.latin.model.BaseModel;

/**
 * Mail的model SELECT * FROM oc_setting oc WHERE oc.code = 'config' AND oc.key
 * LIKE '%config_mail%'
 * 
 * @author nick
 *
 */
public class Mail extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 编码
	 */
	public static final String ENCODEING = "UTF-8";

	/**
	 * 服务器地址，例如：stmp.163.com
	 */
	private String hostName;

	/**
	 * 发送邮箱地址
	 */
	private String fromAddress;

	/**
	 * 收件人邮箱
	 */
	private String[] toAddress;

	/**
	 * 抄送邮件的用户
	 */
	private String[] ccAddress;

	/**
	 * 密送人
	 */
	private String[] bccAddress;

	/**
	 * 发送邮件的用户名
	 */
	private String userName;

	/**
	 * 发送邮件的密码
	 */
	private String password;

	/**
	 * 主题
	 */
	private String subject;

	/**
	 * 邮件内容，支持HTML
	 */
	private String content;

	/**
	 * 附件
	 */
	private String[] attachFileNames;

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String[] getToAddress() {
		return toAddress;
	}

	public void setToAddress(String[] toAddress) {
		this.toAddress = toAddress;
	}

	public String[] getCcAddress() {
		return ccAddress;
	}

	public void setCcAddress(String[] ccAddress) {
		this.ccAddress = ccAddress;
	}

	public String[] getBccAddress() {
		return bccAddress;
	}

	public void setBccAddress(String[] bccAddress) {
		this.bccAddress = bccAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String[] getAttachFileNames() {
		return attachFileNames;
	}

	public void setAttachFileNames(String[] attachFileNames) {
		this.attachFileNames = attachFileNames;
	}

}
