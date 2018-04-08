package com.ylpms.mysql.config;

import java.lang.annotation.*;

/**
 * 
* @ClassName: TargetDataSource 
* @Description: 数据源注解，用于设置数据源的 key，指定使用哪个数据源
* @author yuyao
* @date 2017年12月27日 下午5:07:40
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String value();
}
