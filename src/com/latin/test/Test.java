package com.latin.test;

import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 这个包所在的目录里面的文件都是测试类
 * @author nick
 * @since 2015/09/17
 *
 */
public class Test {
	
	public static Vector<MyTask> queque = new Vector<MyTask>();
	
	public static Vector<MyTask> getQueque() {
		return queque;
	}

	public static int countNum = 0;
	
	public static void main(String[] args) {   
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));
        
        int index = 150;
         
        for(int i=0; i < index; i++) {
            MyTask myTask = new MyTask(i);
//            getQueque().add(myTask);
            executor.getQueue().add(myTask);
        }
        while(executor.getQueue().size() > 0) {
        	executor.execute(getQueque().get(0));
        	getQueque().remove(0);
        	
        	System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
        			executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}

class MyTask implements Runnable {
    private int taskNum;
     
    public MyTask(int num) {
        this.taskNum = num;
    }
     
    public void run() {
        System.out.println("正在执行task "+taskNum);
        
        synchronized (this) {
        	Test.countNum ++;
		}
        
        System.out.println("task "+taskNum+"执行完毕Test.countNum:"+Test.countNum);
    }
}
