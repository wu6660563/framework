package com.latin.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;

/**
 * 实现了JOB，里面的execute默认执行方法
 * StatefulJob表示上次如果没执行完，下个定时器不会执行
 * @ClassName BaseJob
 * @Description TODO
 * @author Nick
 * @version 1.0
 * @Date Jan 12, 2016 10:29:24 PM
 */
public class BaseJob implements Job, StatefulJob {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
	}

}
