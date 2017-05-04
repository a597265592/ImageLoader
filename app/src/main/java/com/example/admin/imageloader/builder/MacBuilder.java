package com.example.admin.imageloader.builder;

/**
 * Created by admin on 2017/5/4.
 */

public class MacBuilder extends Builder {
    private Computer mComputer =new MacBook();

    @Override
    public Builder builderBoard(String board) {
        mComputer.setBoard(board);
        return this;
    }

    @Override
    public Builder builderOS(String os) {
        mComputer.setOs(os);
        return this;
    }

    @Override
    public Builder builderDisplay(String display) {
        mComputer.setDisplay(display);
        return this;
    }

    @Override
    public Computer create() {
        return mComputer;
    }
}
