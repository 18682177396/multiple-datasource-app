package com.march.common.enums;

/**
 * @author wx
 * @version v1.0.0
 * @className DataBaseType
 * @description 数据源类型
 * @date 2020/2/15 12:52
 */
public enum DataBaseType {

    FIRST("first"), SECOND("second");

    private String name;

    DataBaseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
