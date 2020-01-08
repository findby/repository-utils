package com.develop.part.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.develop.part.quartz.impl.HelloQuartz;

public class QuartzTest {

    public static void main(String[] args) {
        try{
            //创建scheduler，执行计划
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            //定义一个Trigger,触发条件类
            Trigger trigger = TriggerBuilder.newTrigger().
                    withIdentity("trigger1", "group1") //定义name/group
                    .startNow()//一旦加入scheduler，立即生效
                   .withSchedule(SimpleScheduleBuilder.simpleSchedule() //使用SimpleTrigger
                           .withIntervalInSeconds(3) //每隔30秒执行一次
                           .repeatForever()) //一直执行，奔腾到老不停歇
                   .build();
           //定义一个JobDetail
           JobDetail job = JobBuilder.newJob(HelloQuartz.class) //定义Job类为HelloQuartz类，这是真正的执行逻辑所在
                   .withIdentity("job1", "group1") //定义name/group
                   .usingJobData("name", "quartz") //定义属性
                   .build();
           //加入这个调度
           scheduler.scheduleJob(job, trigger);
           //启动任务调度
           scheduler.start();
       }catch (Exception ex){
           ex.printStackTrace();
       }
   }
}
