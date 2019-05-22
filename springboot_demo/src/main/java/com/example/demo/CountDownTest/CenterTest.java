package com.example.demo.CountDownTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述: 监控中心测试
 * 作者: lishuai
 * 时间: 2019-05-19
 */
public class CenterTest {
    private static List<ControlCenter> list;
    private static CountDownLatch countDownLatch;

    //检查所有的调度站
    public static boolean checkAllStations() throws InterruptedException {

        list = new ArrayList<>();

        countDownLatch = new CountDownLatch(2);
        list.add(new ShanXiCenter(countDownLatch));
        list.add(new JiangSuCenter(countDownLatch));

        //线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        //执行每个线程的任务
        list.forEach(e -> {
            executorService.execute(e);
        });
        executorService.shutdown();
        //所有线程等待
        countDownLatch.await();

        //查看检查的运行结果
        for (ControlCenter center : list) {
            if (center.isOk()) {
                return true;
            }
            return false;
        }
        return false;
    }



    public static void main(String[] args) {
        try {
            boolean b = CenterTest.checkAllStations();
            if (b) {
                System.out.println("可以全部发车了");
            } else {
                System.out.println("不能发车了，有故障了");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
