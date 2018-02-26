package com.example.admin.imageloader.thread;

/**
 * 功能：
 * 描述：
 * Created by chenjie on 2018/2/25.
 */

public class ThreadDemo {

    public static void main(String[] args) {
        TicketThread ticketThread1 = new TicketThread("1号营业员");
        TicketThread ticketThread2 = new TicketThread("2号营业员");
        ticketThread1.start();
        ticketThread2.start();


//        TicketRunnable ticketRunnable = new TicketRunnable();
//        Thread thread1 = new Thread(ticketRunnable,"1号营业员");
//        Thread thread2 = new Thread(ticketRunnable,"2号营业员");
//        thread1.start();
//        thread2.start();
    }


}

