package com.example.javademo.demo;

/**
 *
 * @author 陈杰
 * @date 2018/2/13
 */

public class Demo {

    public static void main(String[] args){
        Integer a = new Integer(3);
        Integer b = 3;                  // 将3自动装箱成Integer类型
        int c = 3;
        System.out.println(a == b);     // false 两个引用没有引用同一对象
        System.out.println(a == c);     // true a自动拆箱成int类型再和c比较
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;

        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
        Integer a11 = Integer.parseInt("111111");
    }
}
