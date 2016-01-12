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
	 * @Fields serialVersionUID TODO
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @Fields opinion_id TODO
	 */
	private int opinion_id;
	
	/**
	 * @Fields phone TODO
	 */
	private String phone;
	
	/**
	 * 1-android , 2-IOS , 3-HTML5, 4-PC
	 */
	private int os_type;
	
	/**
	 * @Fields email TODO
	 */
	private String email;
	
	/**
	 * @Fields user_name TODO
	 */
	private String user_name;
	
	/**
	 * @Fields content TODO
	 */
	private String content;
	
	/**
	 * @Fields customer_id 客户ID
	 */
	private int customer_id;
	
	/**
	 * @Fields netflow_type 流量形式 1-wifi,2-2G,3-3G,4-4G
	 */
	private int netflow_type;
	
	/**
	 * @Fields version_number 版本号
	 */
	private String version_number;
	
	/**
	 * @Fields deal_id 处理人
	 */
	private String deal_id;
	
	/**
	 * @Fields deal_content 处理意见
	 */
	private String deal_content;
	
	/**
	 * @Fields deal_date 处理时间
	 */
	private String deal_date;
	
	/**
	 * @Fields date_added 添加时间
	 */
	private String date_added;
	
	/**
	 * @Fields date_modified 修改时间
	 */
	private String date_modified;

	/**
	 * @return opinion_id
	 */
	public int getOpinion_id() {
		return opinion_id;
	}

	/**
	 * @param opinion_id
	 * opinion_id
	 */
	public void setOpinion_id(int opinion_id) {
		this.opinion_id = opinion_id;
	}

	/**
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 * phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return os_type
	 */
	public int getOs_type() {
		return os_type;
	}

	/**
	 * @param os_type
	 * os_type
	 */
	public void setOs_type(int os_type) {
		this.os_type = os_type;
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
	 * @return user_name
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * @param user_name
	 * user_name
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * @return content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 * content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return customer_id
	 */
	public int getCustomer_id() {
		return customer_id;
	}

	/**
	 * @param customer_id
	 * customer_id
	 */
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	/**
	 * @return netflow_type
	 */
	public int getNetflow_type() {
		return netflow_type;
	}

	/**
	 * @param netflow_type
	 * netflow_type
	 */
	public void setNetflow_type(int netflow_type) {
		this.netflow_type = netflow_type;
	}

	/**
	 * @return version_number
	 */
	public String getVersion_number() {
		return version_number;
	}

	/**
	 * @param version_number
	 * version_number
	 */
	public void setVersion_number(String version_number) {
		this.version_number = version_number;
	}

	/**
	 * @return deal_id
	 */
	public String getDeal_id() {
		return deal_id;
	}

	/**
	 * @param deal_id
	 * deal_id
	 */
	public void setDeal_id(String deal_id) {
		this.deal_id = deal_id;
	}

	/**
	 * @return deal_content
	 */
	public String getDeal_content() {
		return deal_content;
	}

	/**
	 * @param deal_content
	 * deal_content
	 */
	public void setDeal_content(String deal_content) {
		this.deal_content = deal_content;
	}

	/**
	 * @return deal_date
	 */
	public String getDeal_date() {
		return deal_date;
	}

	/**
	 * @param deal_date
	 * deal_date
	 */
	public void setDeal_date(String deal_date) {
		this.deal_date = deal_date;
	}

	/**
	 * @return date_added
	 */
	public String getDate_added() {
		return date_added;
	}

	/**
	 * @param date_added
	 * date_added
	 */
	public void setDate_added(String date_added) {
		this.date_added = date_added;
	}

	/**
	 * @return date_modified
	 */
	public String getDate_modified() {
		return date_modified;
	}

	/**
	 * @param date_modified
	 * date_modified
	 */
	public void setDate_modified(String date_modified) {
		this.date_modified = date_modified;
	}

	
}
