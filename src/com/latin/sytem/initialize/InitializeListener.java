package com.latin.sytem.initialize;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.BasicConfigurator;

import com.latin.sytem.resource.SysResourceCenter;

/**
 * <p>
 * 初始化启动监听
 * <p>
 * 
 * @ClassName InitializeListener
 * @Description TODO
 * @author Nick
 * @version 1.0
 * @Date Jan 12, 2016 10:34:38 PM
 */
public class InitializeListener implements ServletContextListener {

	/**
	 * 
	 * @Title contextDestroyed
	 * @Description
	 * @param servletContextEvent
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

	}

	/**
	 * 系统初始化启动
	 * 
	 * @Title contextInitialized
	 * @Description
	 * @param servletContextEvent
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		// 配置系统变量
		String sysPath = servletContextEvent.getServletContext().getRealPath(
				"/");
		SysResourceCenter.getInstance().setSysPath(sysPath);
		// 初始化日志
		initLog();
	}

	/**
	 * <p>
	 * 初始化LOG4J日志配置
	 * 
	 * @Title InitializeListener initLog void
	 * @Description TODO
	 */
	private void initLog() {
		String sysPath = SysResourceCenter.getInstance().getSysPath();
		System.setProperty("sysPath", sysPath);
		System.out.println("====================sysPath:" + sysPath);
		BasicConfigurator.configure();
	}

}
