package com.example.demo.CountDownTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 描述: 江苏监控中心
 * 作者: lishuai
 * 时间: 2019-05-19
 */
public class JiangSuCenter extends ControlCenter {

    public JiangSuCenter(CountDownLatch countdown){
        super(countdown,"江苏监控中心");
    }

    @Override
    public void check() {
        System.out.println("江苏监控中心，开始检查。。。。。");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("江苏监控中心，结束检查，准备出发，go，go！！！！");
    }
}
