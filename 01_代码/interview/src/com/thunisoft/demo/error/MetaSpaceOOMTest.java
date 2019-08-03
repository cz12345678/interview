package com.thunisoft.demo.error;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author chenzhen-1
 * @create 2019-06-08 16:10
 */
public class MetaSpaceOOMTest {

    static class OOMTest{}

    /**
     * 演示OOM的Metaspace的方式
     *      思路：通过cglib不断创建代理对象
     *      配置参数：
     *          -XX:MetaspaceSize=15m -XX:MaxMetaspaceSize=15m
     *      异常：
     *          java.lang.OutOfMemoryError: Metaspace
     * @param args
     */
    public static void main(String[] args) {


        int count = 0;// 计数器
        try{
            while(true){
                count++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o,args);
                    }
                });
                enhancer.create();
            }
        }catch (Throwable e) {
            System.out.println("计数器：\t" + count);
            e.printStackTrace();
        }

    }

}
