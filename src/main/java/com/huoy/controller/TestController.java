package com.huoy.controller;

import com.alibaba.fastjson.JSON;
import com.huoy.pojo.User;
import com.huoy.service.inf.LoginService;
import com.huoy.testPo.A;
import com.huoy.testPo.C;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;


@Controller
public class TestController {
    final Logger logger = Logger.getLogger(TestController.class);

    @Autowired
    private LoginService LoginServiceImpl;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(A a) {
        System.out.println("A==" + a.getName());
        return "hello world  哈哈" + a.getName();
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public String getUser() {
        System.out.println("getUser");
        List<User> user = LoginServiceImpl.findUser();
        System.out.println(user);
        return JSON.toJSON(user).toString();
    }

    /**
     * springmvc 用 RequestParam获取简单单个数据
     * 前端传来的是json数据不多时：[id:id],可以直接用@RequestParam来获取值
     * eq:http://localhost:8080/springLearn/getJson1?name="aaa啊"&age=“age啊”
     */
    @RequestMapping("/getJson1")
    @ResponseBody
    public String getJson1(HttpServletRequest request, @RequestParam("name") String name, @RequestParam("age") String age) {
        System.out.println("request getParameter==" + request.getParameter("name"));
        System.out.println("request.getServletPath()===" + request.getServletPath());
        System.out.println("name" + name);
        System.out.println("age" + age);
        return "";
    }

    /**
     * springmvc 用 RequestBody 封装 数据 属性需对应
     * 前端传来的是一个json对象时：{ "name":"anxiCoach", "age":54 },可以用实体类直接进行自动绑定
     */
    @RequestMapping("/getJson2")
    @ResponseBody
    public String getJson2(@RequestBody A a) {

        System.out.println("name" + a.getName());
        System.out.println("age" + a.getAge());
        return "";
    }

    /**
     * springmvc 以Map接收
     * 前端传来的是一个json对象时：{ "name":"anxiCoach", "age":54 },可以用Map来获取
     */
    @RequestMapping("/getJson3")
    @ResponseBody
    public String getJson3(@RequestBody HashMap<String, String> map) {
        System.out.println("name" + map.get("name"));
        System.out.println("age" + map.get("age"));
        return "";
    }

    /**
     * {"name": { "name":"anxiCoach", "age":54 }}
     *
     * @param map
     * @return
     */
    @RequestMapping("/getJson6")
    @ResponseBody
    public String getJson6(@RequestBody HashMap<String, A> map) {
        System.out.println("name" + map.get("name"));
        return "";
    }

    /**
     * springmvc 以List接收
     * 当前端传来这样一个json数组：[{ "name":"anxiCoach啊1", "age":54 }, { "name":"anxiCoach啊2", "age":53 } ]
     * 时，用List<E>接收
     */
    @RequestMapping("/getJson4")
    @ResponseBody
    public String getJson4(@RequestBody List<A> list) {
        list.forEach((aa) -> {
            System.out.println(aa.getName());
            System.out.println(aa.getAge());
        });
        return "";
    }

    /**
     * springmvc 以List接收
     * 前端传来的是一个复杂json对象时：
     * [{"cname":"aaa","a":{ "name":"anxiCoach啊1", "age":54 }}, {"cname":"aaa1","a":{ "name":"anxiCoach啊2", "age":53 }} ]
     * 可以用以List接收来获取
     */
    @RequestMapping("/getJson5")
    @ResponseBody
    public String getJson5(@RequestBody List<C> list) {
        list.forEach((cc) -> {
            System.out.println(cc.getCname());
            System.out.println(cc.getA());
        });
        return "";
    }


}
