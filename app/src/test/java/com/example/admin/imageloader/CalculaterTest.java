package com.example.admin.imageloader;

import com.example.admin.imageloader.unitTest.Calculater;

import org.junit.Assert;
import org.junit.Test;

/**
 * 功能：
 * 描述：
 * Created by chenjie on 2018/2/28.
 */

public class CalculaterTest {

    Calculater calculater = new Calculater();

    @Test
    public void testAdd() {
        int a = 1;
        int b = 2;

        int result = calculater.add(a, b);

        Assert.assertEquals(result, 3); // 验证result==3，如果不正确，测试不通过
    }
}
