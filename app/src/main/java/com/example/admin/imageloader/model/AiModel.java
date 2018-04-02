package com.example.admin.imageloader.model;

import java.util.List;

/**
 * 功能：
 * 描述：
 * Created by chenjie on 2018/3/13.
 */

public class AiModel {
    
    public String text;
    public List<ItemsBean> items;
    

    public static class ItemsBean {
        /**
         * byte_length : 4
         * byte_offset : 0
         * formal : 
         * item : 百度
         * ne : ORG
         * pos : 
         * uri : 
         * loc_details : []
         * basic_words : ["百度"]
         */

        public int byte_length;
        public int byte_offset;
        public String formal;
        public String item;
        public String ne;
        public String pos;
        public String uri;
        public List<?> loc_details;
        public List<String> basic_words;
        
    }
}
