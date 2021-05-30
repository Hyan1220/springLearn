package com.huoy.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    /**
     * 只有singleton 可以注入循环依赖
     * prototype 模式下不能注入循环依赖
     */
    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-test.xml");
        TestAware testAware = (TestAware) applicationContext.getBean("testAware");
        testAware.testAware();
        System.out.println();
    }
}
