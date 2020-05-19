package com.march.common.datasource;

import org.springframework.util.StringUtils;

/**
 * @author wx
 * @version v1.0.0
 * @className DataSourceHolder1
 */
public class DataSourceHolder {

    private static final ThreadLocal<String> dsHolder = new ThreadLocal<String>();

    /**
     * 切换数据源
     *
     * @param keyName 必须是在Spring已定义的数据源的Bean Name
     */
    public static void switchDataSource(String keyName) {
        if(StringUtils.isEmpty(dsHolder.get())){
            dsHolder.set(keyName);
        }
    }

    /**
     * 返回当前使用的数据源的Bean Name，DynamicSwitchDataSource会根据此Name 去查找已注册的DataSource
     *
     * @return
     */
    public static String currentDataSource() {

        return dsHolder.get();
    }

    public static void removeCurrent() {

        dsHolder.remove();
    }
}
