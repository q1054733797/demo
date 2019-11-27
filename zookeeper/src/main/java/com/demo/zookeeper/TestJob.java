package com.demo.zookeeper;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.elasticjob.lite.annotation.ElasticSimpleJob;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : TestJob
 * @date : Create in 2019/9/6 15:57
 */
@ElasticSimpleJob(cron = "")
public class TestJob implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {

    }
}
