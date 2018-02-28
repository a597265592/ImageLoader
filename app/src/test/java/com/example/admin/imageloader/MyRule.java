package com.example.admin.imageloader;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * 功能：
 * 描述：
 * Created by chenjie on 2018/2/28.
 */

public class MyRule implements TestRule {

    @Override
    public Statement apply(final Statement base, final Description description) {

        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                // evaluate前执行方法相当于@Before
                String methodName = description.getMethodName(); // 获取测试方法的名字
                System.out.println(methodName + "测试开始！");

                base.evaluate();  // 运行的测试方法

                // evaluate后执行方法相当于@After
                System.out.println(methodName + "测试结束！");
            }
        };
    }

}
