package com.ylpms.mysql.config;

import java.util.ArrayList;
import java.util.List;

/**
 * 
* @ClassName: DynamicDataSourceContextHolder 
* @Description: 该类为数据源上下文配置，用于切换数据源
* @author yuyao
* @date 2017年12月27日 下午5:04:27
 */
public class DynamicDataSourceContextHolder {

    //private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);

    /**
     * 为每个线程维护变量，以避免影响其他线程
     */
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>() {
        /**
         * 将 ds2 数据源的 key 作为默认数据源的 key
         */
    	@Override
        protected String initialValue() {
            return "ds2";
        }
    };

    /**
     * 所有数据源列表
     */
    public static List<Object> dataSourceKeys = new ArrayList<>();

    /**
     * 
    * @Title: setDataSourceKey 
    * @Description: 切换数据源
    * @param @param key    设定文件 
    * @return void    返回类型 
    * @throws
     */
    public static void setDataSourceKey(String key) {
        contextHolder.set(key);
    }

    /**
     * 
    * @Title: getDataSourceKey 
    * @Description: 得到当前数据源
    * @param @return    设定文件 
    * @return String    返回类型 
    * @throws
     */
    public static String getDataSourceKey() {
        return contextHolder.get();
    }
    /**
     * 
    * @Title: clearDataSourceKey 
    * @Description: 将DataSource设置为默认值
    * @param     设定文件 
    * @return void    返回类型 
    * @throws
     */
    public static void clearDataSourceKey() {
        contextHolder.remove();
    }

    /**
     * 
    * @Title: containDataSourceKey 
    * @Description: 检查是否在当前数据源列表中提供了数据源
    * @param @param key
    * @param @return    设定文件 
    * @return boolean    返回类型 
    * @throws
     */
    public static boolean containDataSourceKey(String key) {
        return dataSourceKeys.contains(key);
    }
}
