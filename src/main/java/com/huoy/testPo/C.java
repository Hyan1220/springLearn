package com.huoy.testPo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class C {
    private String cname;
    private A a;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}
