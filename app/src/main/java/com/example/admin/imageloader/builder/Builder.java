package com.example.admin.imageloader.builder;

/**
 * Created by admin on 2017/5/4.
 */

public abstract class Builder {

    public abstract Builder builderBoard(String board);
    public abstract Builder builderOS(String os);
    public abstract Builder builderDisplay(String display);
    public abstract Computer create();

}
