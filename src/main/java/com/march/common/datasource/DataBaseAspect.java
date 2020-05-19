package com.march.common.datasource;

import com.march.common.annotation.DataBase;
import com.march.common.datasource.DataSourceHolder;
import com.march.common.enums.DataBaseType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wx
 * @version v1.0.0
 * @className DataBaseAspect
 * @description 多数据源配置
 * @date 2020/2/15 12:53
 */
@Configuration
@Aspect
@Slf4j
public class DataBaseAspect {

    private Map<String,Method> cacheMaps = new ConcurrentHashMap<>();

    @Pointcut("@annotation(com.march.common.annotation.DataBase) || @within(com.march.common.annotation.DataBase))")
    public void dbPointCut() {
    }

    @Before("dbPointCut()")
    public void beforeSwitchDS(JoinPoint point){
        Class<?> classzs = point.getTarget().getClass();
        DataBaseType dataBaseType = DataBaseType.FIRST;
        try {
            if(classzs.isAnnotationPresent(DataBase.class)){
                DataBase annotation = classzs.getAnnotation(DataBase.class);
                dataBaseType = annotation.value();
            }else{
                String methodName = point.getSignature().getName();
                Method method = cacheMaps.get(methodName);
                if(Objects.isNull(method)){
                    Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
                    method = classzs.getMethod(methodName, argClass);
                }
                if (method.isAnnotationPresent(DataBase.class)) {
                    DataBase annotation = method.getAnnotation(DataBase.class);
                    dataBaseType = annotation.value();
                }
            }
        } catch (Exception e) {
            log.error(String.format("动态数据源切换失败，"+ e.getMessage(),e));
        }
        // 切换数据源
        DataSourceHolder.switchDataSource(dataBaseType.getName());
    }

    @After("dbPointCut()")
    public void afterSwitchDS(JoinPoint point){
        DataSourceHolder.removeCurrent();
    }

}
