package com.ff.algocasts;

/**
 *
 * 与 是进位
 * 异或 是值
 */
public class AlgoCast5 {
    public static void main(String[] args) {
        int a = 0b0001;
        int b = 0b1011;
        int r = a & b;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(a << 1));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(20));
        System.out.println(Integer.toBinaryString(r));
        System.out.println("sum " +Integer.toBinaryString(sum(a, b)));
        System.out.println("---------");
        System.out.println("add " +Integer.toBinaryString(add(a, b)));

    }


    private static int add(int a, int b) {
        if (b == 0) return a;
        int r1 = a ^ b;
        int r2 = a & b;

        r2 = r2 << 1;
        System.out.println("r1 " + Integer.toBinaryString(r1));
        System.out.println("r2 " + Integer.toBinaryString(r2));
        return add(r1, r2);
    }

    private static int sum(int a, int b) {
        System.out.println("a " + Integer.toBinaryString(a));
        System.out.println("b " + Integer.toBinaryString(b));
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }

        return a;
    }
}
