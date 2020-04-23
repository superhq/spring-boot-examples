package com.example.myspringbootaop.controller;

import com.example.myspringbootaop.annotation.ControllerWebLog;
import com.example.myspringbootaop.annotation.LogExecutionTime;
import org.springframework.stereotype.Controller;

@Controller
public class WebController {
    public void testWebLog1() {
        System.out.println("调用:testWebLog1()");
    }

    @ControllerWebLog(name = "这是testWebLog2", intoDb = true)
    public void testWebLog2() {
        System.out.println("调用:testWebLog2()");
    }

    @LogExecutionTime
    @ControllerWebLog(name = "这里有两种注解", intoDb = false)
    public void testWebLog3() throws InterruptedException {
        System.out.println("调用:testWebLog3()");
    }

    @ControllerWebLog(name = "发生了异常", intoDb = true)
    public void testWebLog4() throws Exception {
        throw new Exception("这里发生了异常");
    }
}
