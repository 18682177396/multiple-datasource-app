package com.march.common.configuration;

import com.march.common.datasource.DynamicSwitchDataSource;
import com.march.common.enums.DataBaseType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 *@description: 多数据源配置Configuration
 *@see: MultipartsDataSourceConfiguration
 *@createTime: 2020/5/18 14:24
 *@version:1.0
 */
@Configuration
public class MultipartsDataSourceConfiguration {

    @Primary
    @Bean(name = "firstDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.first")
    public DataSource getDateSource1() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource getDateSource2() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dynamicSwitchDataSource")
    @ConditionalOnBean(name={"firstDataSource","secondDataSource"})
    public DynamicSwitchDataSource DataSource(@Qualifier("firstDataSource") DataSource firstDataSource,
                                              @Qualifier("secondDataSource") DataSource secondDataSource) {
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DataBaseType.FIRST.getName(), firstDataSource);
        targetDataSource.put(DataBaseType.SECOND.getName(), secondDataSource);
        DynamicSwitchDataSource dataSource = new DynamicSwitchDataSource();
        dataSource.setTargetDataSources(targetDataSource);
        dataSource.setDefaultTargetDataSource(firstDataSource);
        return dataSource;
    }

    /**
     * 配置事务管理器
     */
    @Bean
    @ConditionalOnBean(name="dynamicSwitchDataSource")
    public DataSourceTransactionManager transactionManager(@Qualifier("dynamicSwitchDataSource")DynamicSwitchDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }

}
