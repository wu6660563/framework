package com.latin.sytem.resource;

/**
 * <p>
 * 系统资源中心，该类包含系统主要配置。
 * <p>
 * 
 * @ClassName SysResourceCenter
 * @Description TODO
 * @author Nick
 * @version 1.0
 * @Date Jan 12, 2016 10:35:14 PM
 */
public final class SysResourceCenter {

	/**
	 * 静态的唯一的 SysResourceCenter 实例
	 */
	private static SysResourceCenter instance;

	/**
	 * 系统路径
	 */
	private String sysPath = "";

	/**
	 * 创建一个新的 {@link SysResourceCenter} 实例。 由于该类使用单例模式，所以该方法为私有的。
	 * 
	 * @Title SysResourceCenter
	 * 
	 * @Description TODO
	 */
	private SysResourceCenter() {
	}

	/**
	 * getInstance单例模式，获取实例
	 * 
	 * @Title SysResourceCenter getInstance
	 * @return SysResourceCenter
	 * @Description TODO
	 */
	public static SysResourceCenter getInstance() {
		if (instance == null) {
			instance = new SysResourceCenter();
		}
		return instance;
	}

	/**
	 * 获取系统路径
	 * 
	 * @Title SysResourceCenter getSysPath
	 * @return String
	 * @Description TODO
	 */
	public String getSysPath() {
		return sysPath;
	}

	/**
	 * 设置系统路径
	 * 
	 * @Title SysResourceCenter setSysPath
	 * @param sysPath
	 *            void
	 * @Description TODO
	 */
	public void setSysPath(String sysPath) {
		this.sysPath = sysPath;
	}

}