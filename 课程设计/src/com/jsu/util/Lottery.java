package com.jsu.util;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Lottery<T> {
    //Դ���ݳ�
    private List<T> source;
    //������
    private int smaple;
    //����ص��ӿ�
    private SampleShow<T> sampleShow;
    //�߳��б�
    private final List<Picker> threadList = new ArrayList<>();
    //ֹͣ��ʶ��ʹ��volatile������Ϊ���̹߳���ͬһ����ʱ����Ҫ�����ı�ʱ���߳��ܹ���ʱ����
    private volatile boolean stop = false;
    //��ͣ��ʶ
    private volatile boolean suspend = false;

    //��ͣ��
    private Object suspendLock=new Object();

    public Lottery(List<T> source, int sample, SampleShow<T> sampleShow) {
        this.source=source;//Դ���ݳ�
        this.smaple=sample;//������
        this.sampleShow=sampleShow;//����ص��ӿ�
    }

    //��ʼ�齱
    public void start() {
        for (int i = 0; i < smaple; i++) {
            Picker runnable = new Picker();
            threadList.add(runnable);
            Thread thread = new Thread(runnable, i + "");
            thread.start();
        }
    }

    //ֹͣ�齱
    public void stop() {
        stop = true;
    }
    //�齱�߳�
    private class Picker implements Runnable  {

        public T pickSeatNumber() {
            //�д�ȡ����λʱ��ȥȡ����������
            int count = source.size();
            if (count > 0) {
                //���ȡһ�����[0,count)
                int index = new Random().nextInt(count);
                //�õ���λ��
                T seatNumber = source.get(index);
                //����λ�Ӵ�ȡ��λ���Ƴ�
                source.remove(index);
                return seatNumber;
            }
            return null;
        }

        public T showSeatNumber(T seatNumber) throws RandomFetchException {
            //����ǰ�̸߳��µ��Ǻڰ����ĸ�λ�õ���λ��[0,sample)
            int index = Integer.valueOf(Thread.currentThread().getName());
            if(index >=0 && index < smaple) {
                T oldSample=sampleShow.show(index,seatNumber);
                //����ڰ��Ӧλ��֮ǰû����λ��ʱ���򷵻�Null
                if (oldSample == null || oldSample.equals("")) oldSample = null;
                return oldSample;
            }else{
                throw new RandomFetchException("thread name is not right,it should be between 0 and "+smaple);
            }
        }

        public void readyAgain(T oldSeatNumber) {
            //��ӵ���ȡ��λ�б���
            source.add(oldSeatNumber);
        }

        @Override
        public void run() {
            while (!stop) {
                if (suspend) {
                    //object.wait,object.notify������������
                    //�˴�����RandomFetch.this��ԭ���������̻߳����RandomFetch.this��ʱ����ǰ
                    //�߳��Կ�����ͣ
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

