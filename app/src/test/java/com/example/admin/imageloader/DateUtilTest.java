package com.example.admin.imageloader;

import com.example.admin.imageloader.unitTest.DateUtil;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;


/**
 * 功能：
 * 描述：
 * Created by chenjie on 2018/2/28.
 */

public class DateUtilTest {
    private String time = "2017-10-15 16:00:02";
    private long timeStamp = 1508054402000L;
    private Date mDate;

    @Before
    public void setUp() throws Exception{
        System.out.println("测试开始！");
        Date date = new Date();
        date.setTime(timeStamp);
    }

    @After
    public void tearDown() throws Exception{
        System.out.println("测试结束！");
    }

    @Test
    public void testTime() throws Exception{
        Assert.assertNotEquals(4, DateUtil.dateToStamp(time));
    }
}
