package com.march.common.annotation;

import com.march.common.configuration.MultipartsDataSourceConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 *@description: 多数据源配置
 *@see: EnableMulipartsDataSource
 *@createTime: 2020/5/18 13:57
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(MultipartsDataSourceConfiguration.class)
public @interface EnableMultipartsDataSource {
}
