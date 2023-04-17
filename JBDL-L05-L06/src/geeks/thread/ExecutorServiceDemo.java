package geeks.thread;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        //something task which can get executed after certain time
        ScheduledExecutorService scheduledExecServic = Executors.newScheduledThreadPool(1);
        //to execute -> run method
        // 1 task -> with for loop i have 20 tasks
        for (int i = 0; i < 5; i++) {
            executorService2.submit(() -> {
                System.out.println("Task Running in : " + Thread.currentThread().getName() );
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
      scheduledExecServic.schedule(new Runnable() {
          @Override
          public void run() {
              System.out.println("I want to get executed after 5 sec");
          }
      },5, TimeUnit.SECONDS);
        //imp method
        //signal to executorService that please dont take other task
        executorService2.shutdown();
//        executorService.shutdownNow();
        executorService2.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Done");
        long endTime = System.currentTimeMillis();
        System.out.println("The complete time of execution was: "+ (endTime-startTime));
//        executorService.submit(() -> System.out.println("trying to have one more task"));
    }
}
