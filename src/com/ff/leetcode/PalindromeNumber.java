package com.ff.leetcode;

/**
 * Created by frank on 17-2-5.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        PalindromeNumber o = new PalindromeNumber();
        System.out.println(o.isPalindrome(1111));
        System.out.println(o.isPalindrome(12));
        System.out.println(o.isPalindrome(121));
        System.out.println(o.isPalindrome(1000021));
    }

    public boolean isPalindrome(int x) {

        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }
}
