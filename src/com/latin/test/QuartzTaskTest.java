package com.latin.test;

import java.text.ParseException;

import org.apache.log4j.PropertyConfigurator;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;

import com.latin.common.utils.DateUtils;
import com.latin.quartz.BaseJob;
import com.latin.quartz.QuartzFactory;

/**
 * 测试定时器（定时测试）
 * 
 * @author nick
 *
 */
public class QuartzTaskTest extends BaseJob {

	/** 日志对象 */
	// private Logger logger = Logger.getLogger(QuartzTaskTest.class);

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("Test");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("TEST结束。。。");
	}

	public static void main(String[] args) {
		PropertyConfigurator
				.configure("E:/git/api/oc-service/WebRoot/WEB-INF/log4j.properties");

		QuartzFactory quartzFactory = QuartzFactory.getInstance();
		try {
			quartzFactory.createCrontab("Test", QuartzTaskTest.class,
					"0/3 * * * * ?");

			Thread.sleep(15000);
			// 15秒之后暂停触发器
			quartzFactory.pauseCrontab("Test");
			System.out.println(DateUtils.getCurrentTime() + "触发器暂停了1111111");

			Thread.sleep(10000);

			System.out.println(DateUtils.getCurrentTime()
					+ "触发器准备重新开启222222222");
			quartzFactory.resumeCrontab("Test");

			Thread.sleep(10000);

			System.out.println(DateUtils.getCurrentTime() + "触发器准备删除33333333");
			quartzFactory.deleteCrontab("Test");
			System.out.println(DateUtils.getCurrentTime() + "触发器已删除44444");
		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
