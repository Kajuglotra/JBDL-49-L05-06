package geeks.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class VisitorCount implements Runnable{

    private volatile AtomicInteger  visitor;

    public VisitorCount() {
        this.visitor = new AtomicInteger();
    }

    public int getVisitor() {
        return visitor.intValue();
    }

    @Override
    public void run() {
        visitor.getAndIncrement();
//        countVistor();
    }
//    public synchronized void countVistor(){
//        visitor++;
//    }
}
