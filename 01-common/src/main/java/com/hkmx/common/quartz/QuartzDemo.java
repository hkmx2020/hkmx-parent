package com.hkmx.common.quartz;

import org.quartz.SchedulerException;

public class QuartzDemo {

    public static void main(String[] args) throws SchedulerException, InterruptedException {

        // SchedulerFactory schedFact = new StdSchedulerFactory();
        // Scheduler sched = schedFact.getScheduler();
        // sched.start();
        //
        //
        // JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
        //         .withIdentity("myJob", "group1")
        //         .usingJobData("name", "天龙八部第" + ThreadLocalRandom.current().nextInt(666))
        //         .build();
        //
        // SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder
        //         .simpleSchedule()
        //         .withIntervalInSeconds(5)
        //         .withRepeatCount(5);
        //
        // Trigger trigger = TriggerBuilder.newTrigger()
        //         .withIdentity("trigger1", "group1")
        //         .startAt(new Date())
        //         .forJob("job1", "group1")
        //         .withSchedule(simpleScheduleBuilder)
        //         .build();
        //
        // sched.scheduleJob(jobDetail, trigger);
        //
        // Thread.sleep(100000);


    }
}
