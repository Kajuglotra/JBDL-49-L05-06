package geeks.thread;

public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.setName("Thread-0");
        myThread.start();
        //daemon thread -> jvm runs by self -> lowest priority -> garbage collector
        // operation doing by user thread -> high priority / normal priority
        // operation doing by the gc thread-> lowest priority -> background

        //Relation between main function and main thread
        MyTask mytask = new MyTask();
        MyTask mytask2 =new MyTask();
        Thread thread = new Thread(mytask);
        
        thread.start();
//        thread.start();


        //wait, notify , resume -> earlier getting used. -> deadlock
        //join method
        //main class -> mythread and mytask until they get completed
        myThread.join();
        thread.join();
        // mythread and mytask
        System.out.println("done from thread "+ Thread.currentThread() );



    }
}
