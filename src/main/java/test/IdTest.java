package test;

import model.DbRep;
import test.sequence.SnowflakeIdGenerator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IdTest implements Runnable {
    public static void main(String[] args) {
        // 创建指定最大线程数的线程池执行器
        ExecutorService executor = Executors.newFixedThreadPool(3);
        //创建任务并添加到线程池
        for(int i = 0 ;i<3;i++){
            executor.execute(new IdTest());
        }
        // 关闭执行器
        executor.shutdown();
    }

    @Override
    public void run() {
        try {
            SnowflakeIdGenerator sg =SnowflakeIdGenerator.class.newInstance();
            sg.init();
            for (int i = 0;i< 10000;i++){
                DbRep.addId(sg.next(),Thread.currentThread().getName());
                System.out.println(sg.next()+"----"+Thread.currentThread().getName());
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
