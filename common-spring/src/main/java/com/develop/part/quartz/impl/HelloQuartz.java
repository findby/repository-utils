package com.develop.part.quartz.impl;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.develop.part.utils.DateUtils;

public class HelloQuartz implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("记时："+DateUtils.simpleDateToStr(new Date()));
	}

}
