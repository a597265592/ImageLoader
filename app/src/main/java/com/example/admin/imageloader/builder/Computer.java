package com.example.admin.imageloader.builder;

/**
 * Created by admin on 2017/5/4.
 */

public abstract class Computer {
     String mBoard;
     String mDisplay;
     String mOs;

     Computer(){

    }

    public String getBoard() {
        return mBoard;
    }

    public void setBoard(String board) {
        mBoard = board;
    }

    public String getDisplay() {
        return mDisplay;
    }

    public void setDisplay(String display) {
        mDisplay = display;
    }

    public String getOs() {
        return mOs;
    }

    public void setOs(String os) {
        mOs = os;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "mBoard='" + mBoard + '\'' +
                ", mDisplay='" + mDisplay + '\'' +
                ", mOs='" + mOs + '\'' +
                '}';
    }
}
