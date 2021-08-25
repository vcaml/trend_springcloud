package cn.how2j.trend.job;

import java.util.List;

import cn.hutool.core.date.DateUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import cn.how2j.trend.pojo.Index;
import cn.how2j.trend.service.IndexDataService;
import cn.how2j.trend.service.IndexService;

public class IndexDataSyncJob extends QuartzJobBean {

    @Autowired
    private IndexService indexService;

    @Autowired
    private IndexDataService indexDataService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("定时启动：" + DateUtil.now());
        //同时刷新index和indexdata
        System.out.println("index数据开始刷新");
        List<Index> indexes = indexService.fresh();
        System.out.println("index数据刷新结束，开始循环刷新indexdata数据");
        for (Index index : indexes) {
            indexDataService.fresh(index.getCode());
        }
        System.out.println("定时结束：" + DateUtil.now());

    }

}