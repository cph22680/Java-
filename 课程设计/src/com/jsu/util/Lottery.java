package com.jsu.util;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Lottery<T> {
    //源数据池
    private List<T> source;
    //样本数
    private int smaple;
    //结果回调接口
    private SampleShow<T> sampleShow;
    //线程列表
    private final List<Picker> threadList = new ArrayList<>();
    //停止标识，使用volatile，是因为多线程共享同一变量时，需要变量改变时，线程能够即时发现
    private volatile boolean stop = false;
    //暂停标识
    private volatile boolean suspend = false;

    //暂停锁
    private Object suspendLock=new Object();

    public Lottery(List<T> source, int sample, SampleShow<T> sampleShow) {
        this.source=source;//源数据池
        this.smaple=sample;//样本数
        this.sampleShow=sampleShow;//结果回调接口
    }

    //开始抽奖
    public void start() {
        for (int i = 0; i < smaple; i++) {
            Picker runnable = new Picker();
            threadList.add(runnable);
            Thread thread = new Thread(runnable, i + "");
            thread.start();
        }
    }

    //停止抽奖
    public void stop() {
        stop = true;
    }
    //抽奖线程
    private class Picker implements Runnable  {

        public T pickSeatNumber() {
            //有待取的座位时才去取，否则跳过
            int count = source.size();
            if (count > 0) {
                //随机取一个序号[0,count)
                int index = new Random().nextInt(count);
                //得到座位号
                T seatNumber = source.get(index);
                //将座位从待取座位中移除
                source.remove(index);
                return seatNumber;
            }
            return null;
        }

        public T showSeatNumber(T seatNumber) throws RandomFetchException {
            //看当前线程更新的是黑板上哪个位置的座位号[0,sample)
            int index = Integer.valueOf(Thread.currentThread().getName());
            if(index >=0 && index < smaple) {
                T oldSample=sampleShow.show(index,seatNumber);
                //如果黑板对应位置之前没有座位号时，则返回Null
                if (oldSample == null || oldSample.equals("")) oldSample = null;
                return oldSample;
            }else{
                throw new RandomFetchException("thread name is not right,it should be between 0 and "+smaple);
            }
        }

        public void readyAgain(T oldSeatNumber) {
            //添加到待取座位列表中
            source.add(oldSeatNumber);
        }

        @Override
        public void run() {
            while (!stop) {
                if (suspend) {
                    //object.wait,object.notify必须是锁对象
                    //此处不用RandomFetch.this，原因是其它线程获得了RandomFetch.this锁时，当前
                    //线程仍可以暂停
                    synchronized (suspendLock) {
                        try {
                            suspendLock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }

                synchronized (Lottery.this)  {
                    T seatNumnber = pickSeatNumber();
                    T oldSeatNumber = null;
                    if (seatNumnber != null) {
                        try {
                            oldSeatNumber = showSeatNumber(seatNumnber);
                        }catch (RandomFetchException e){
                            e.printStackTrace();
                        }
                    }

                    if (oldSeatNumber != null) {
                        readyAgain(oldSeatNumber);
                    }
                }
            }
        }
    }
}

