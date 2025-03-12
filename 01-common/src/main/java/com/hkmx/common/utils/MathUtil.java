package com.hkmx.common.utils;

/**
 * @author maoxwa
 * @version 1.0
 * @date 2021/6/18 20:42
 */
public class MathUtil {

    public static void main(String[] args) {
        // System.out.println("ExampleUnitTest-Sin 90°="+Math.sin(Math.PI/2));
        // System.out.println("ExampleUnitTest-30°-1="+Math.toDegrees(Math.PI/6));
        // System.out.println("ExampleUnitTest-30°-2="+Math.toDegrees(Math.asin(Math.sin(Math.PI/6))));
        // System.out.println("ExampleUnitTest-sin30°="+Math.sin(Math.PI/6));
        // System.out.println("ExampleUnitTest-asin 0.5="+Math.toDegrees(Math.asin(0.5)));//求一个正弦值的弧度对应角度
        // System.out.println("ExampleUnitTest-cos 60°=="+Math.cos(Math.PI/3));
        // System.out.println("ExampleUnitTest-tan 45°=="+Math.tan(Math.PI/4));
        // System.out.println("ExampleUnitTest-atan=="+Math.atan(Math.tan(Math.PI/4)));//求孤独
        // System.out.println("ExampleUnitTest-atan1=="+Math.atan(1));//求斜率对应的孤独
        // System.out.println("ExampleUnitTest-atan1=="+Math.toDegrees(Math.atan(1)));//求斜率对应的孤独的对应角度

        double shanxing = Math.PI * 0.9 * 0.9D / 3;
        System.out.println("扇形:" + shanxing);

        double r = Math.sqrt(0.9 * 0.9D - 0.45 * 0.45D);
        System.out.println("开根:" + r );

        double v1 = r * 0.45D;
        System.out.println("三角形:" + v1);
        double v2 = shanxing - v1;
        System.out.println("扇形 - 三角形:" + v2);



        double v4 = 2.25 * 0.675;
        System.out.println("长方形面积:" + v4);

        double v5 = v4 - v2;
        System.out.println("阴影部分的面积:" + v5);


        // double v = 2.0D * M * 2 * Math.PI * 0.75 * 0.75 / 360;
        // double singleDegree = 1.4 * 0.5D -  - 0.5 * 0.25D);
        // System.out.println(singleDegree);

    }
}
