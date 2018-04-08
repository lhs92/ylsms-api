package com.ylpms.mysql.config;


import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 
* @ClassName: MysqlDataSourceConfig 
* @Description: 手动创建数据源
* 数据源配置类，在该类中生成多个数据源实例并将其注入到 ApplicationContext 中
* @author yuyao
* @date 2017年12月27日 上午9:20:57
 */
@Configuration
public class MysqlDataSourceConfig {

	
	@Bean(name = "pamiss_othe_sod")
	@Primary
    @ConfigurationProperties(prefix = "spring.datasource.pamiss_othe_sod") // application.properteis中对应属性的前缀
    public DataSource dataSource1() {
        //return DataSourceBuilder.create().build();
        DruidDataSource druiddatasource = new DruidDataSource();
        return new DruidDBConfig().dataSource(druiddatasource);
    }

    @Bean(name = "usr_collect_api")
    @ConfigurationProperties(prefix = "spring.datasource.usr_collect_api") // application.properteis中对应属性的前缀
    public DataSource dataSource2() {
    	DruidDataSource druiddatasource = new DruidDataSource();
        return new DruidDBConfig().dataSource(druiddatasource);
    }
    
   
    /**
     * 
    * @Title: dynamicDataSource 
    * @Description: 动态数据源: 通过AOP在不同数据源之间动态切换 
    * @param @return    设定文件 
    * @return DataSource    返回类型 
    * @throws
     */
    @Bean("dynamicDataSource")
    public DataSource dynamicDataSource() {
    	DynamicRoutingDataSource dynamicRoutingDataSource = new DynamicRoutingDataSource();
        Map<Object, Object> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put("pamiss_othe_sod", dataSource1());
        dataSourceMap.put("usr_collect_api", dataSource2());

        // 将主数据源设置为默认值
        dynamicRoutingDataSource.setDefaultTargetDataSource(dataSource2());
        // 将主数据源和从数据源设置为目标数据源
        dynamicRoutingDataSource.setTargetDataSources(dataSourceMap);
        //将数据源键放入DataSourceContextHolder中，以判断数据源是否存在
        DynamicDataSourceContextHolder.dataSourceKeys.addAll(dataSourceMap.keySet());
        
        return dynamicRoutingDataSource;
    }
    /**
     * 
    * @Title: sqlSessionFactoryBean 
    * @Description: SqlSessionFactory配置数据源
    * @param @return    设定文件 
    * @return SqlSessionFactoryBean    返回类型 
    * @throws
     */
    @Bean
    @ConfigurationProperties(prefix = "mybatis")
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 将所有数据源放入sqlessionfactorybean
        sqlSessionFactoryBean.setDataSource(dynamicDataSource());
        return sqlSessionFactoryBean;
    }
    
    /**
     * 
    * @Title: transactionManager 
    * @Description: 事物管理
    * @param @return    设定文件 
    * @return PlatformTransactionManager    返回类型 
    * @throws
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
    
	
}
