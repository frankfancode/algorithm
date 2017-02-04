package com.ff.leetcode;

/**
 * Created by frank on 17-2-4.
 */
public class StringToInteger {

    public static void main(String[] args) {
        StringToInteger atoi = new StringToInteger();
        System.out.println(atoi.myAtoi("PAYPALISHIRING"));
        System.out.println(atoi.myAtoi("100"));
        System.out.println(atoi.myAtoi("-100"));
        System.out.println(atoi.myAtoi("-12312312312111111111"));
        System.out.println(atoi.myAtoi("123123121113"));
        System.out.println(atoi.myAtoi("+1"));
        System.out.println(atoi.myAtoi("1"));
        System.out.println(atoi.myAtoi("    010"));
        System.out.println(atoi.myAtoi("    010 22"));
        System.out.println(atoi.myAtoi("    010  1  "));
        System.out.println(atoi.myAtoi(" 00      01011  00111  "));

        System.out.println(atoi.myAtoi("     +004500"));


    }

    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int length = str.length();
        long value = 0;
        int sign = 1;
        boolean start = false;
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);

            if (!start) {
                if (c == 45) {
                    sign = -1;
                    start = true;
                    continue;
                } else if (c == 43) {
                    sign = 1;
                    start = true;
                    continue;
                } else if (c == 32) {
                    continue;
                } else {

                }
            }

            if (c >= 48 && c <= 57) {
                start = true;
                value = value * 10 + sign * (c - 48);

                if (value > Integer.MAX_VALUE) {
                    value = Integer.MAX_VALUE;
                } else if (value < Integer.MIN_VALUE) {
                    value = Integer.MIN_VALUE;
                }
            } else {
                break;
            }


        }

        return (int) value;
    }
}
