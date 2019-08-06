package com.springquartz.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class CronJob implements Job {

	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//		QuartzSchedulerThread
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println("=========================定时任务每5分钟执行一次===============================");
		System.out.println("===============开始时间：" + format.format(new Date()));
//		try {
//			Thread.sleep(6000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println("jobName=====:" + jobExecutionContext.getJobDetail().getKey().getName());
		System.out.println("jobGroup=====:" + jobExecutionContext.getJobDetail().getKey().getGroup());
		System.out.println("taskData=====:" + jobExecutionContext.getJobDetail().getJobDataMap().get("taskData"));
		System.out.println("===============结束时间：" + format.format(new Date()));
	}

}
