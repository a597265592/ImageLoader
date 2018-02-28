package com.example.admin.imageloader;

import com.example.admin.imageloader.unitTest.DateUtil;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;



/**
 * 功能：
 * 描述：
 * Created by chenjie on 2018/2/28.
 */

@RunWith(Parameterized.class)
public class DateUtilTest {
    private String time = "2017-10-15 16:00:02";
    private long timeStamp = 1508054402000L;
    private Date mDate;

    public DateUtilTest(String time){
        this.time = time;
    }
//
//    public DateUtilTest(){
//    }

    @Parameterized.Parameters
    public  static Collection primeNumber(){
        return Arrays.asList("2017-10-15 16:00:02",
                "2017-10-15 ",
                "2017-10-15 16:00"
                );
    }

    @Rule
    public  MyRule mMyRule = new MyRule();

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
    public void testTime2()throws Exception{
        Assert.assertEquals(time, DateUtil.dateToStamp(time));
    }

//    @Test
//    public void testTime() throws Exception{
//        Assert.assertThat("1121564544", new IsMobilePhoneMatcher());
//    }
}
