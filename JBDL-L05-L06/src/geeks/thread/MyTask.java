package geeks.thread;

public class MyTask implements Runnable{
    @Override
    public void run() {
        System.out.println("I am inside the Mytask run method body");
    }
}
