package com.example.admin.imageloader.thread;

/**
 * 功能：
 * 描述：
 * Created by chenjie on 2018/2/25.
 */

public  class TicketRunnable implements Runnable {
    private int ticket = 5;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (ticket > 0) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("R公司"+Thread.currentThread().getName() + "卖了一张票，编号为r" + (ticket--));
            }
        }
    }
}