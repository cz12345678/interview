package com.atguigu.springboot.util;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;


/***
 * SpringContextUtils
 * 由于该该类是在系统初始化启动完成后才初始化的，所以使用时需要注意
 * 在系统启动中，使用此类，会报错
 * @description SpringContextUtils
 * @author dengpu
 * @date 2018年11月8日 下午2:20:16
 * @version 2.0
 */
public class SpringContextUtils {
    private static final Object LOCK = new Object();

    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        synchronized (LOCK) {
            if (SpringContextUtils.applicationContext == null) {
                SpringContextUtils.applicationContext = applicationContext;
            }
        }
    }

    public static ApplicationContext getApplicationContext() {
        return SpringContextUtils.applicationContext;
    }

    /**
     * 通过名称获取bean SpringContextUtils
     *
     * @description 通过名称获取bean
     * @param name
     * @return
     * @author dengpu
     * @date 2018年11月8日 下午2:19:26
     * @version 2.0
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    /**
     * SpringContextUtils
     *
     * @description 通过类获取bean
     * @param clazz
     * @return
     * @author dengpu
     * @date 2018年11月8日 下午2:19:07
     * @version 2.0
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /***
     * SpringContextUtils
     *
     * @description 通过名称及类型返回指定的bean
     * @param name
     * @param clazz
     * @return
     * @author dengpu
     * @date 2018年11月8日 下午2:19:50
     * @version 2.0
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

    /**
     * SpringContextUtils
     * @description 手动注入
     * @param bean
     * @return
     * @author dengpu
     * @date 2018年11月8日 下午4:16:11
     * @version 2.0
     */
    public static <T> T autowireBean(T bean) {
        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
        autowireCapableBeanFactory.autowireBeanProperties(bean, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, true);
        return bean;
    }

    private SpringContextUtils() {
    }
}

