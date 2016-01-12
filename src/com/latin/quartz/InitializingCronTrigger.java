package com.latin.quartz;

import java.io.Serializable;
import java.text.ParseException;

import org.springframework.scheduling.quartz.CronTriggerBean;


/**
 * 初始化定时器
 * @ClassName InitializingCronTrigger
 * @Description TODO
 * @author Nick
 * @version 1.0
 * @Date Jan 12, 2016 10:29:35 PM
 */
public class InitializingCronTrigger extends CronTriggerBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//0/180 * * * * ?
	//0 00 01 * * ?
	private static final String iniVal = "0 10 17 * * ? 2099";
	
	/**
	 * 
	 * @Title InitializingCronTrigger
	 * 
	 * @Description TODO
	 * @throws ParseException
	 */
	public InitializingCronTrigger() throws ParseException {
		setCronExpression(iniVal);
	}
}
