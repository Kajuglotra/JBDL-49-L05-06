package geeks.thread;

import java.util.Scanner;

public class MyThread extends Thread {

    @Override
    public void run(){
       System.out.println("I am inside run method of My thread class");
        System.out.println("Enter your name");
       Scanner scanner= new Scanner(System.in);
       System.out.println(scanner.next());
       // inside mythread class to wait until mytask gets completed

    }

}
