package com.latin.test;

import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 这个包所在的目录里面的文件都是测试类
 * @ClassName Test
 * @Description TODO
 * @author Nick
 * @version 1.0
 * @Date Jan 12, 2016 10:38:04 PM
 */
public class Test {
	
	/**
	 * @Fields queque TODO
	 */
	public static Vector<MyTask> queque = new Vector<MyTask>();
	
	/**
	 * @Title Test getQueque
	 * @return Vector<MyTask>
	 * @Description TODO
	 */
	public static Vector<MyTask> getQueque() {
		return queque;
	}

	/**
	 * @Fields countNum TODO
	 */
	public static int countNum = 0;
	
	/**
	 * @Title Test main
	 * @param args void
	 * @Description TODO
	 */
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

/**
 * @ClassName MyTask
 * @Description TODO
 * @author Nick
 * @version 1.0
 * @Date Jan 12, 2016 10:38:13 PM
 */
class MyTask implements Runnable {
	
    /**
     * @Fields taskNum TODO
     */
    private int taskNum;
     
    /**
     * @Title MyTask
     * 
     * @Description TODO
     * @param num
     */
    public MyTask(int num) {
        this.taskNum = num;
    }
     
    /**
     * @Title run
     * @Description 
     * @see java.lang.Runnable#run()
     */
    public void run() {
        System.out.println("正在执行task "+taskNum);
        
        synchronized (this) {
        	Test.countNum ++;
		}
        
        System.out.println("task "+taskNum+"执行完毕Test.countNum:"+Test.countNum);
    }
}
