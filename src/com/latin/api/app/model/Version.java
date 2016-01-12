package com.latin.api.app.model;

import com.latin.model.BaseModel;
/**
 * 
 * @ClassName Version
 * @Description TODO
 * @author Nick
 * @version 1.0
 * @Date Jan 12, 2016 9:45:37 PM
 */
public class Version extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int version_id;

	private int os_type;

	private String package_name;

	private String desc;

	public int getVersion_id() {
		return version_id;
	}

	public void setVersion_id(int version_id) {
		this.version_id = version_id;
	}

	public int getOs_type() {
		return os_type;
	}

	public void setOs_type(int os_type) {
		this.os_type = os_type;
	}

	public String getPackage_name() {
		return package_name;
	}

	public void setPackage_name(String package_name) {
		this.package_name = package_name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getVersion_number() {
		return version_number;
	}

	public void setVersion_number(String version_number) {
		this.version_number = version_number;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDate_added() {
		return date_added;
	}

	public void setDate_added(String date_added) {
		this.date_added = date_added;
	}

	private String version_number;

	private String url;

	private String date_added;

	private String date_modified;

	public String getDate_modified() {
		return date_modified;
	}

	public void setDate_modified(String date_modified) {
		this.date_modified = date_modified;
	}

}
