package com.march.common.annotation;


import com.march.common.enums.DataBaseType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface DataBase {

    DataBaseType value() default DataBaseType.FIRST;

}
