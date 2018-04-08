package com.ylpms.mysql.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
/**
 * 
* @ClassName: DruidDBConfig 
* @Description: mysql 连接池统一配置
* @author yuyao
* @date 2018年1月4日 下午2:05:44
 */
public class DruidDBConfig {  
    //初始化大小
    private int initialSize = 5;  
    //最小
    private int minIdle = 5;  
    //最大
    private int maxActive = 50;  
    //配置获取连接等待超时的时间
    private int maxWait = 60000;  
    // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
    private int timeBetweenEvictionRunsMillis=60000;  
    //配置一个连接在池中最小生存的时间，单位是毫秒
    private int minEvictableIdleTimeMillis=300000;  
    private String validationQuery = "SELECT 1 FROM DUAL";
    //建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
    private boolean testWhileIdle=true;  
    //申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
    private boolean testOnBorrow=false;  
    //归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能
    private boolean testOnReturn=false;  
     //是否缓存preparedStatement，也就是PSCache。PSCache对支持游标的数据库性能提升巨大，比如说oracle。在mysql下建议关闭。
    private boolean poolPreparedStatements=false;  
    //要启用PSCache，必须配置大于0，当大于0时，poolPreparedStatements自动触发修改为true。在Druid中，不会存在Oracle下PSCache占用内存过多的问题，可以把这个数值配置大一些，比如说100  
    private int maxPoolPreparedStatementPerConnectionSize=80;  
     //配置监控统计拦截的filters，去掉后监控界面sql无法统计，防御sql注入'wall'用于防火墙
    private String filters = "stat,wall";
    //通过connectProperties属性来打开mergeSql功能；慢SQL记录
    private String connectionProperties="druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000";  
      
    public DataSource dataSource(DruidDataSource druiddatasource){  
          
        //configuration  
    	druiddatasource.setInitialSize(initialSize);  
    	druiddatasource.setMinIdle(minIdle);  
    	druiddatasource.setMaxActive(maxActive);  
    	druiddatasource.setMaxWait(maxWait);  
    	druiddatasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);  
    	druiddatasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);  
        druiddatasource.setTestWhileIdle(testWhileIdle);  
        druiddatasource.setTestOnBorrow(testOnBorrow);  
        druiddatasource.setTestOnReturn(testOnReturn);  
        druiddatasource.setPoolPreparedStatements(poolPreparedStatements);  
        druiddatasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);  
        druiddatasource.setConnectionProperties(connectionProperties);  
        druiddatasource.setValidationQuery(validationQuery);
        try {
			druiddatasource.setFilters(filters);
		} catch (SQLException e) {
			e.printStackTrace();
		}
          
        return druiddatasource;  
    }  
}  