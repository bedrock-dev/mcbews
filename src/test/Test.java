package test;

import com.hhhxiao.debug.Task;

public class Test {
    public static void main(String[] args) {
        Task task = new Task(()->System.out.println("1212"));
        task.start();
    }
}
