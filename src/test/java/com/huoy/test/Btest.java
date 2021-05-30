package com.huoy.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Btest {
    private String name;

    private Atest atest;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Atest getAtest() {
        return atest;
    }

    public void setAtest(Atest atest) {
        this.atest = atest;
    }
}
