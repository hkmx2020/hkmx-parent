package com.hkmx.common.utils;

import java.util.regex.Pattern;

public class PatternUtil {

    /**
     * 校验英文和数字
     */
    private static final String NUMBER = "^[0-9]+$";


    private static Pattern NUMBER_PATTERN = Pattern.compile(NUMBER);

    public static boolean validateNumber(String value) {
        return NUMBER_PATTERN.matcher(value).matches();
    }

    public static void main(String[] args) {
        // String number = "100.2";
        // Pattern pattern = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$"); // 判断小数点后2位的数字的正则表达式
        // Matcher match = pattern.matcher(number);
        // boolean matches = match.matches();
        // System.out.println(matches);

        // String format = String.format("%05d", 1);
        // System.out.println(format);

        int i = 100;
        StringBuilder b = new StringBuilder();
        for (int i1 = 0; i1 < i; i1++) {
            b.append(i1);
        }
        System.out.println(b.toString());

        // BigDecimal bigDecimal = new BigDecimal(0);
        // bigDecimal = bigDecimal.add(new BigDecimal("1.22"));
        // System.out.println(bigDecimal.toString());

        // String attachment = "[{\"url\":\"http://www.baidu.com\",\"name\":\"我的附件\",\"size\":\"1k\"}]";
        // System.out.println(attachment.length());

        // BigDecimal b = new BigDecimal("100.00");
        // String s = b.stripTrailingZeros().toPlainString();
        // System.out.println(s);

        // List<String> rider = new ArrayList<>();
        // String s1 = GsonUtil.toJson(rider);
        // System.out.println(s1);


    }
}
