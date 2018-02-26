package com.example.admin.imageloader.thread;


/**
 * 功能：
 * 描述：
 * Created by chenjie on 2018/2/25.
 */

public class TicketThread extends Thread{
    private int ticket = 5;
    private String name;

    public TicketThread(String name) {
        this.name = name;
    }

    @Override
    public  void run() {
        synchronized (this){
            for (int i = 0; i < 5; i++) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("T公司"+name + "卖了一张票，编号为t" + (ticket--));
                }
            }
        }
    }
}
