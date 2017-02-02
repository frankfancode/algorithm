package com.ff.leetcode;

/**
 * Created on 02/02/2017.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(-2147483648));
        System.out.println(ri.reverse(1534236469));
        System.out.println(ri.reverse(0));
        System.out.println(ri.reverse(-123));
    }

    public int reverse(int x) {
        long y = x % 10;
        while ((x = x / 10) != 0) {
            y = y * 10 + x % 10;
            if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE) {
                return 0;
            }
        }

        return (int) y;
    }
}
