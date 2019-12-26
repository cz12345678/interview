package com.my.boot.springboothelloworld;

import com.alibaba.druid.pool.DruidDataSource;
import com.my.boot.springboothelloworld.yaml.bean.Person;
import com.my.boot.springboothelloworld.yaml.bean.Person2;
import com.my.boot.springboothelloworld.yaml.bean.Person3;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Arrays;

@SpringBootTest
class SpringBootHelloWorldApplicationTests {

    @Resource
    private Person person;

    @Resource
    private Person2 person2;

    @Resource
    private Person3 person3;

    @Resource
    private DruidDataSource dataSource;

    @Test
    void contextLoads() {
        System.err.println(Arrays.asList( dataSource.getFilterClassNames()));
        System.err.println(Arrays.asList( dataSource.getMaxPoolPreparedStatementPerConnectionSize()));

    }

}
