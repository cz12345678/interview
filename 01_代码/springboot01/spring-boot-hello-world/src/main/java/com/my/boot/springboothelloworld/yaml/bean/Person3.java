package com.my.boot.springboothelloworld.yaml.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Person3 {

    @Value("${person3.name}")
    private String name;

    @Override
    public String toString() {
        return "Person3{" +
                "name='" + name + '\'' +
                '}';
    }
}
