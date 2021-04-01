package com.hkmx.common.quartz;

import com.hkmx.common.utils.DateUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

@Slf4j
@Data
public class MyJob implements Job {

    private String name;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("开始执行定时任务:" + DateUtil.getDateTime(new Date()));
    }
}
