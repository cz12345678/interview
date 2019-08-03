package com.thunisoft.my.util;

/**
 * @author chenzhen-1
 * @create 2019-07-05 11:08
 */
public class ConvertConstants {

    /**
     * 系统
     */
    public final static String SYSTEM = "dataconvert";

    /**
     * 存储数据方式
     */
    public final static String STORAGE_DATA_MODE = "dataconvert.configLocation.type";

    /**
     * 队列池最大条数
     */
    public final static String POOLQUEUE_MAX_COUNT = "dataconvert.pool.max.count";

    /**
     * 默认数据源名称
     */
    public final static String DEFAULT_DATASOURCE = "dataSource";


    /**
     * 转换所需数据Map生成key
     */
    public final static String CACHE_DATA_KEY = "cache.data";


    /**
     * 默认分隔符
     */
    public final static String CHAR_DOT = ",";

    /**
     * 参数正则
     */
    public final static String REGULAR_PARAMS = "\\$\\{\\w+\\}";

    /**
     * 解析库参数正则
     */
    public final static String REGULAR_DATABASE_PARAMS = "\\$\\{[\\w+\\.]+}";

    /**
     * 解析库名称参数正则
     */
    public final static String REGULAR_DATABASE_NAME = "[\\w+\\.]+";

    /**
     * 参数名称正则
     */
    public final static String REGULAR_PARAMS_NAME = "\\w+";

    /**
     * 时间默认格式化
     */
    public final static String DATATIME_FORMAT =  "yyyy-MM-dd HH:mm:ss";

    /**
     * String类型
     */
    public final static String TYPE_STRING = "STRING";

    /**
     * 双精度浮点类型
     */
    public final static String TYPE_DOUBLE = "DOUBLE";

    /**
     * 长整型
     */
    public final static String TYPE_LONG = "LONG";


}
