package com.hkmx.common.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;
import org.quartz.impl.calendar.CronCalendar;
import org.quartz.impl.calendar.DailyCalendar;
import org.quartz.impl.calendar.HolidayCalendar;
import org.quartz.impl.calendar.MonthlyCalendar;
import org.quartz.impl.calendar.WeeklyCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Controller
public class QuartzController {

    @Autowired
    private SchedulerFactory schedulerFactory;

    @GetMapping("/quartz/test")
    @ResponseBody
    public String quartz() throws SchedulerException, ParseException {

        //1.创建Scheduler的工厂
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // 2.年日历,  排除年日历中的天,  可以添加多个
        AnnualCalendar annualCalendar = new AnnualCalendar();
        Calendar fourthOfJuly = new GregorianCalendar(2020, 7, 8);
        annualCalendar.setDayExcluded(fourthOfJuly, true);

        // 3.Cron 日历,  排除 20-40 秒
        String excludeExpression = "0-20,40-59 * * * * ?";
        CronCalendar cronCalendar = new CronCalendar(excludeExpression);

        // 4.每日日历,  时间反转,  为 true 表示只有这次时间段才会被执行,  为 false 表示排除这时间段
        DailyCalendar dailyCalendar = new DailyCalendar("12:17:30", "12:18:20");
        dailyCalendar.setInvertTimeRange(true);


        // 5.假日日历
        HolidayCalendar holidayCalendar = new HolidayCalendar();
        holidayCalendar.addExcludedDate(new Date());

        // 6. 月日历
        MonthlyCalendar monthlyCalendar = new MonthlyCalendar();
        monthlyCalendar.setDayExcluded(2, true);

        // 7.周日历
        WeeklyCalendar weeklyCalendar = new WeeklyCalendar();
        weeklyCalendar.setDayExcluded(Calendar.THURSDAY, true);

        /**
         * 8.组合日历
         * 上面的例子都是每一个触发器(trigger)关联一个日历的例子, 我们在构建触发器的时候通过.modifiedByCalendar("日历的key")关联一个注册
         * 到引擎当中的日历, 这种情况已经能够满足我们大部分的需求。但是系统的需求往往是复杂多变的, 假设有这样一种情况, 需要一个触发器在每周一到周五,
         * 早8点-晚晚5点 每隔1小时执行, 那么该如何使用日历呢? 其实我们不用日历, 使用一个CronTrigger也是可以搞定的, 这里只不过是抛砖引玉而已。
         *
         * 我们写一个时间间隔的日历 combinationDailyCalendar, 将其作为参数传递给 combinationWeeklyCalendar 就可以了，这样引擎在计算日历
         * 日期的时候会先判断 combinationDailyCalendar 的时间范围，然后再判断 combinationWeeklyCalendar 是时间范围，当条件都满足的时候，
         * 触发器才会被触发
         */
        DailyCalendar combinationDailyCalendar = new DailyCalendar("8:00:00", "17:00:00");
        dailyCalendar.setInvertTimeRange(false);
        WeeklyCalendar combinationWeeklyCalendar = new WeeklyCalendar(combinationDailyCalendar);


        scheduler.addCalendar("holidayCalendar", holidayCalendar, false, false);

        // name 格式 sid
        String name = "name";
        String group = "schedule";

        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity(name, group)
                .usingJobData(name, group)
                .requestRecovery(true)
                .storeDurably(true)
                .build();

        // DateBuilder 用在 startAt() 和 endAt()
        // endTime属性的值会覆盖设置重复次数的属性值
        Date date = new Date();
        Trigger trigger = TriggerBuilder.newTrigger()
                // .startAt(DateBuilder.futureDate(2,  DateBuilder.IntervalUnit.SECOND))
                .startAt(date)
                // .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).withRepeatCount(100))
                // 1) 用在每天, 每工作日(每工作日通过其他api剔除非工作日)
                // .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(1,  1))
                // 2) 用在每周的星期几, 可以多个
                // .withSchedule(CronScheduleBuilder.atHourAndMinuteOnGivenDaysOfWeek( 12, 0, DateBuilder.MONDAY, DateBuilder.TUESDAY))

                // 3) 每两周, 两周为336h, 计算所选日期范围有几天则需要添加几个定时任务
                // .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInHours(336).repeatForever())
                // .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())

                // 4) 每月通过开始日期计算出表达式

                // 5) 每年按照每天的逻辑, 所选日期有多年的 todo 需要确定每年的日期是怎么选的

                // .modifiedByCalendar("holidayCalendar")

                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(3))

                // .endAt(DateUtil.addSecond(date, 10))
                .build();


        scheduler.scheduleJob(jobDetail, trigger);

        return "welcome to myworld 神雕侠侣";
    }

    public static void main(String[] args) {


    }
}
