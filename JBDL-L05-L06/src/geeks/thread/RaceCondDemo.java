package geeks.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RaceCondDemo {
    public static void main(String[] args) throws InterruptedException {
        VisitorCount visitorCount = new VisitorCount();

        // either i can create threads
        // executor service
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for(int i = 0; i<40000; i++){
            executorService.submit(visitorCount);
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Total Visitors : " + visitorCount.getVisitor());
    }
}
