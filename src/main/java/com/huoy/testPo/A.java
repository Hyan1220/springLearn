package com.huoy.testPo;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public class A {
    public A() {
        Logger logger = Logger.getLogger(A.class);
        logger.info("A---start---1");
        System.out.println("A---start---");
    }

    @Value("name-a")
    private String name;
    @Value("12")
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
