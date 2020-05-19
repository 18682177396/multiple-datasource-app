package com.march.common.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;

/**
 *
 * @className DynamicSwitchDataSource
 * @description 继承自Spring，实现动态切换数据源
 * <p>
 * 因为Spring默认每个类的实例都是单例的，所以不能直接引入FactoryBean进行重设数据源，这样
 * 并发会导至数据源混乱的情形，从Spring2.0.1后就有AbstractRouteringDataSource可以实现
 * 动态地切换数据源，其实AbstractRouteringDataSource就是使用了Map保存了所有要进行切换的
 * DataSource，不过不确定具体的Key，在此实现中主要使用string来充当key
 * </p>
 * */
public class DynamicSwitchDataSource extends AbstractRoutingDataSource implements DataSource {
    
    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.currentDataSource();
    }
    
}
