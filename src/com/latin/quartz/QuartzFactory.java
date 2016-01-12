package com.latin.quartz;

import java.text.ParseException;
import java.util.Date;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 * <p>定时任务的生产调度类 <p>
 * 		- 所有的定时任务都由这个类统一来操作 采用单例模式
 * @ClassName QuartzFactory
 * @Description TODO
 * @author Nick
 * @version 1.0
 * @Date Jan 12, 2016 10:30:12 PM
 */
public class QuartzFactory {

	private static QuartzFactory quartzFactory = null;

	private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();

	private Scheduler scheduler = null;

	/**
	 * 存取正在运行的各个线程任务类
	 */
	// public static Vector<Scheduler> vector = new Vector<Scheduler>();

	/**
	 * 构造方法私有化
	 */
	private QuartzFactory() {
		try {
			scheduler = schedulerFactory.getScheduler();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取实例，并且锁定，线程同步
	 * @Title QuartzFactory getInstance
	 * @return QuartzFactory
	 * @Description TODO
	 */
	public static synchronized QuartzFactory getInstance() {
		if (quartzFactory == null) {
			quartzFactory = new QuartzFactory();
		}
		return quartzFactory;
	}

	/**
	 * 检查调度是否启动
	 * @Title QuartzFactory isStarted
	 * @return
	 * @throws SchedulerException boolean
	 * @Description TODO
	 */
	public boolean isStarted() throws SchedulerException {
		return scheduler.isStarted();
	}

	/**
	 * 启动调度
	 * @Title QuartzFactory start
	 * @throws SchedulerException void
	 * @Description TODO
	 */
	public void start() throws SchedulerException {
		if (!isStarted()) {
			scheduler.start();
		}
	}

	/**
	 * 关闭调度信息
	 * @Title QuartzFactory shutdown
	 * @throws SchedulerException void
	 * @Description TODO
	 */
	public void shutdown() throws SchedulerException {
		scheduler.shutdown();
	}

	/**
	 * 创建一个新的定时任务,使用默认的组,triggerName名与任务名一致
	 * @Title QuartzFactory createCrontab
	 * @param jobName 任务名
	 * @param clazz 任务执行类
	 * @param cronExpression 定时表达式
	 * @return 是否成功开启定时器
	 * @throws SchedulerException
	 * @throws ParseException boolean
	 * @Description TODO
	 */
	public boolean createCrontab(String jobName, Class<?> clazz,
			String cronExpression) throws SchedulerException, ParseException {
		boolean flag = true;
		// 任务名，任务组，任务执行类
		JobDetail jobDetail = new JobDetail(jobName, Scheduler.DEFAULT_GROUP,
				clazz);
		// 触发器名,触发器组
		CronTrigger trigger = new CronTrigger(jobName, Scheduler.DEFAULT_GROUP);
		// 触发器时间设定
		trigger.setCronExpression(cronExpression);
		//设置系统启动延时30s后启动
		trigger.setStartTime(new Date(new Date().getTime() + 30000L));
		scheduler.scheduleJob(jobDetail, trigger);
		// 启动
		if (!scheduler.isShutdown()) {
			scheduler.start();
		}
		flag = true;
		return flag;
	}

	/**
	 * <p>
	 * 修改触发器时间，任务名和触发器名保持一致的情况下，并且使用默认的组
	 * <p>
	 * @Title QuartzFactory modifyCrontabExpression
	 * @param jobName
	 * @param clazz
	 * @param cronExpression
	 * @return
	 * @throws SchedulerException
	 * @throws ParseException boolean
	 * @Description TODO
	 */
	public boolean modifyCrontabExpression(String jobName, Class<?> clazz,
			String cronExpression) throws SchedulerException, ParseException {
		CronTrigger trigger = (CronTrigger) scheduler.getTrigger(jobName,
				Scheduler.DEFAULT_GROUP);
		if (trigger == null) {
			return false;
		}
		if (!trigger.getCronExpression().equals(cronExpression)) {
			trigger.setCronExpression(cronExpression);
			scheduler.rescheduleJob(jobName, Scheduler.DEFAULT_GROUP, trigger);
		} else {
			scheduler.resumeJob(trigger.getJobName(), Scheduler.DEFAULT_GROUP);
		}
		return true;
	}

	/**
	 * 删除触发器
	 * @Title QuartzFactory deleteCrontab
	 * @param jobName
	 * @return
	 * @throws SchedulerException
	 * @throws ParseException boolean
	 * @Description TODO
	 */
	public boolean deleteCrontab(String jobName) throws SchedulerException,
			ParseException {
		CronTrigger trigger = (CronTrigger) scheduler.getTrigger(jobName,
				Scheduler.DEFAULT_GROUP);
		if (trigger == null) {
			return false;
		}
		return scheduler.deleteJob(trigger.getJobName(),
				Scheduler.DEFAULT_GROUP);
	}

	/**
	 * 暂停触发器
	 * @Title QuartzFactory pauseCrontab
	 * @param jobName
	 * @return
	 * @throws SchedulerException boolean
	 * @Description TODO
	 */
	public boolean pauseCrontab(String jobName) throws SchedulerException {
		CronTrigger trigger = (CronTrigger) scheduler.getTrigger(jobName,
				Scheduler.DEFAULT_GROUP);
		if (trigger == null) {
			return false;
		}
		scheduler.pauseJob(trigger.getJobName(), Scheduler.DEFAULT_GROUP);
		return true;
	}

	/**
	 * 触发器在关闭状态下继续执行
	 * @Title QuartzFactory resumeCrontab
	 * @param jobName
	 * @return
	 * @throws SchedulerException
	 * @throws ParseException boolean
	 * @Description TODO
	 */
	public boolean resumeCrontab(String jobName) throws SchedulerException,
			ParseException {
		CronTrigger trigger = (CronTrigger) scheduler.getTrigger(jobName,
				Scheduler.DEFAULT_GROUP);
		if (trigger == null) {
			return false;
		}
		scheduler.resumeJob(trigger.getJobName(), Scheduler.DEFAULT_GROUP);
		return true;
	}

	/**
	 * 停止调度Job任务
	 * @Title QuartzFactory unscheduleJob
	 * @param jobName
	 * @return
	 * @throws SchedulerException boolean
	 * @Description TODO
	 */
	public boolean unscheduleJob(String jobName) throws SchedulerException {
		return scheduler.unscheduleJob(jobName, Scheduler.DEFAULT_GROUP);
	}

	/**
	 * 暂停调度中所有的job任务
	 * @Title QuartzFactory pauseAll
	 * @throws SchedulerException void
	 * @Description TODO
	 */
	public void pauseAll() throws SchedulerException {
		scheduler.pauseAll();
	}

	/**
	 * 恢复调度中所有的job任务
	 * @Title QuartzFactory resumeAll
	 * @throws SchedulerException void
	 * @Description TODO
	 */
	public void resumeAll() throws SchedulerException {
		scheduler.resumeAll();
	}
	
	/**
	 * 立即执行一次，用来管理检测定时任务里面业务逻辑是否正常
	 * @Title QuartzFactory excuteOnce
	 * @param jobName
	 * @throws SchedulerException void
	 * @Description TODO
	 */
	public void excuteOnce(String jobName) throws SchedulerException {
		scheduler.triggerJob(jobName, Scheduler.DEFAULT_GROUP);
	}
}
