package com.ff.leetcode;

/**
 * Created by fxd on 16/9/27.
 */
public class LongestPalindromicSubstring {

    public static void main(String args[]) {
        String s = "a";
        System.out.println(longestPalindrome_simple(s));
        System.out.println(longestPalindrome_DP(s));

    }


    /**
     * 动态规划
     * 参考   http://blog.csdn.net/hopeztm/article/details/7932245k
     * @param s
     * @return
     */
    public static String longestPalindrome_DP(String s) {
        int length = s.length();
        boolean dp[][] = new boolean[length][length];

        if (s.length()<=1){
            return s;
        }


        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i >= j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }

        int maxPalindromeS = 1;
        int j = 0;
        int pI = 0, pJ = 0;
        

        for (int k = 1; k < length; k++) {
            for (int i = 0; i + k < length; i++) {
                j = i + k;
                System.out.println("i: " + i + " k : " + k + " s: " + s.substring(i, j + 1));
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (k + 1 > maxPalindromeS) {
                        pI=i;
                        pJ=j+1;
                        maxPalindromeS = k + 1;
                        System.out.println(maxPalindromeS);
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }


        return s.substring(pI, pJ);
    }

    /**
     * 朴素解法
     *
     * @param s
     * @return
     */
    public static String longestPalindrome_simple(String s) {
        int longestLength = 0;
        int longestPalindromeI = 0, longestPalindromeJ = 0;
        int sLenght = s.length();
        for (int i = 0; i < sLenght; i++) {
            for (int j = i; j <= sLenght; j++) {
                String tempS = s.substring(i, j);
                if ((isPalindrome(tempS) && tempS.length() > longestLength)) {
                    longestLength = tempS.length();
                    longestPalindromeI = i;
                    longestPalindromeJ = j;
                }
            }
        }
        return s.substring(longestPalindromeI, longestPalindromeJ);
    }


    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        int length = s.length() - 1;
        int i = 0;
        while (i < length - i) {
            if (s.charAt(i) != s.charAt(length - i)) {
                return false;
            }
            i++;
        }

        return true;
    }
}
