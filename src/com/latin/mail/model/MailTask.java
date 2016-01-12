package com.latin.mail.model;

import com.latin.model.BaseModel;

public class MailTask extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int task_id;

	private String mail_from;

	private String mail_to;

	private String mail_subject;

	private String mail_message;

	/**
	 * 是否成功
	 */
	private int is_ok;

	public int getIs_ok() {
		return is_ok;
	}

	public void setIs_ok(int is_ok) {
		this.is_ok = is_ok;
	}

	public int getSend_count() {
		return send_count;
	}

	public void setSend_count(int send_count) {
		this.send_count = send_count;
	}

	/**
	 * 发送次数
	 */
	private int send_count;

	private String date_added;

	private String date_modified;
	
	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public String getMail_from() {
		return mail_from;
	}

	public void setMail_from(String mail_from) {
		this.mail_from = mail_from;
	}

	public String getMail_to() {
		return mail_to;
	}

	public void setMail_to(String mail_to) {
		this.mail_to = mail_to;
	}

	public String getMail_subject() {
		return mail_subject;
	}

	public void setMail_subject(String mail_subject) {
		this.mail_subject = mail_subject;
	}

	public String getMail_message() {
		return mail_message;
	}

	public void setMail_message(String mail_message) {
		this.mail_message = mail_message;
	}

	public String getDate_added() {
		return date_added;
	}

	public void setDate_added(String date_added) {
		this.date_added = date_added;
	}

	public String getDate_modified() {
		return date_modified;
	}

	public void setDate_modified(String date_modified) {
		this.date_modified = date_modified;
	}

}
