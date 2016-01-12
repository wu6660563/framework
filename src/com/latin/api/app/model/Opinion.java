package com.latin.api.app.model;

import com.latin.model.BaseModel;

/**
 * 
 * @ClassName Opinion
 * @Description TODO
 * @author Nick
 * @version 1.0
 * @Date Jan 12, 2016 9:45:22 PM
 */
public class Opinion extends BaseModel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int opinion_id;
	
	private String phone;
	
	/**
	 * 1-android , 2-IOS , 3-HTML5, 4-PC
	 */
	private int os_type;
	
	private String email;
	
	private String user_name;
	
	private String content;
	
	/**
	 * 客户ID
	 */
	private int customer_id;
	
	/**
	 * 流量形式 1-wifi,2-2G,3-3G,4-4G
	 */
	private int netflow_type;
	
	/**
	 * 版本号
	 */
	private String version_number;
	
	/**
	 * 处理人
	 */
	private String deal_id;
	
	/**
	 * 处理意见
	 */
	private String deal_content;
	
	/**
	 * 处理时间
	 */
	private String deal_date;
	
	/**
	 * 添加时间
	 */
	private String date_added;
	
	/**
	 * 修改时间
	 */
	private String date_modified;

	public int getOpinion_id() {
		return opinion_id;
	}

	public void setOpinion_id(int opinion_id) {
		this.opinion_id = opinion_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public String getVersion_number() {
		return version_number;
	}

	public void setVersion_number(String version_number) {
		this.version_number = version_number;
	}

	public String getDeal_id() {
		return deal_id;
	}

	public void setDeal_id(String deal_id) {
		this.deal_id = deal_id;
	}

	public String getDeal_content() {
		return deal_content;
	}

	public void setDeal_content(String deal_content) {
		this.deal_content = deal_content;
	}

	public String getDeal_date() {
		return deal_date;
	}

	public void setDeal_date(String deal_date) {
		this.deal_date = deal_date;
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

	public int getOs_type() {
		return os_type;
	}

	public void setOs_type(int os_type) {
		this.os_type = os_type;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getNetflow_type() {
		return netflow_type;
	}

	public void setNetflow_type(int netflow_type) {
		this.netflow_type = netflow_type;
	}
	
}
