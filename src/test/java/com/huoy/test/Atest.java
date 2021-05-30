package com.huoy.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Atest {
    private String name;

    private Btest btest;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Btest getBtest() {
        return btest;
    }

    public void setBtest(Btest btest) {
        this.btest = btest;
    }
}
