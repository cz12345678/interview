package com.my.boot.springboothelloworld;

import com.my.boot.springboothelloworld.yaml.bean.Person;
import com.my.boot.springboothelloworld.yaml.bean.Person2;
import com.my.boot.springboothelloworld.yaml.bean.Person3;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringBootHelloWorldApplicationTests {

    @Resource
    private Person person;

    @Resource
    private Person2 person2;

    @Resource
    private Person3 person3;

    @Test
    void contextLoads() {
        System.out.println(person);
        System.out.println(person2);
        System.out.println(person3);
    }

}
