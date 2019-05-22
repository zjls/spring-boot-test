package com.example.demo.CountDownTest;

import java.util.concurrent.CountDownLatch;

/**
 * 描述: 调度中心
 * 作者: lishuai
 * 时间: 2019-05-19
 */
public abstract class ControlCenter implements Runnable {
    private CountDownLatch countDownLatch;
    private String station;
    private boolean ok;

    public ControlCenter(CountDownLatch countDownLatch,String station){
        this.countDownLatch = countDownLatch;
        this.station = station;
        this.ok = false;
    }

    @Override
    public void run() {
        try {
            check();
            ok = true;
        } catch (Exception e) {
            ok = false;
            e.printStackTrace();
        }finally {
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }

        }

    }

    public abstract void check() throws Exception;

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }
}
