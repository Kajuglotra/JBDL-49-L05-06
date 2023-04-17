package geeks.thread;

import java.util.concurrent.*;

public class CustomExecutorService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int corePoolSize = 5;
        int maxPoolSize = 10;
        // a thread is free for 5000 ms, then the thread will die
        long timeToLive  =5000;
        ExecutorService executorService = new ThreadPoolExecutor(corePoolSize, maxPoolSize, timeToLive , TimeUnit.MILLISECONDS, new PriorityBlockingQueue<>());
        // this run method has no return type
        // we need to do inside it, we can not return anything
        // requirement -> method which was doing something like run but returning the values, so that i can use those values later on
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                int num = 3;
                System.out.println("I am in the run method of custom Executor service");
            }
        });
        // creating a thread-> using the thread class methods Callable

        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(1000);
                return  3;
            }
        });
        //get method -> blocking
        System.out.println("Done1");
        System.out.println(future.get());
        System.out.println("Done2");
//        new Thread()

    }
}
