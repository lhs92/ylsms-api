package com.ylpms.mysql.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 
* @ClassName: DynamicDataSourceAspect 
* @Description: 动态数据源切换的切面，切 @TargetDataSource 注解，实现数据源切换
* @author yuyao
* @date 2017年12月27日 下午4:58:36
 */
@Aspect
@Order(-1) // // 该切面应当先于 @Transactional 执行
@Component
public class DynamicDataSourceAspect {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    /**
     * 数据源开关
     *
     * @param point
     * @param targetDataSource
     */
    @Before("@annotation(targetDataSource))")
    public void switchDataSource(JoinPoint point, TargetDataSource targetDataSource) {
        if (!DynamicDataSourceContextHolder.containDataSourceKey(targetDataSource.value())) {
           // logger.error("DataSource [{}] 不存在，使用默认数据源[{}]", targetDataSource.value());
        } else {
        	 // 切换数据源
            DynamicDataSourceContextHolder.setDataSourceKey(targetDataSource.value());
            //logger.info("在方法[{}]中将数据源转换为[{}]", point.getSignature(),
                 //   DynamicDataSourceContextHolder.getDataSourceKey());
        }
    }

    /**
     * 恢复数据源
     *
     * @param point
     * @param targetDataSource
     */
    @After("@annotation(targetDataSource))")
    public void restoreDataSource(JoinPoint point, TargetDataSource targetDataSource) {
        DynamicDataSourceContextHolder.clearDataSourceKey();
        //logger.info("在方法[{}]中恢复数据源到[{}]", point.getSignature(),
                //DynamicDataSourceContextHolder.getDataSourceKey());
    }

}
