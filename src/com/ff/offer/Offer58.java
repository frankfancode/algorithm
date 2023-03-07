package com.ff.offer;

/**
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=f4eq4ut
 */
public class Offer58 {
    public static void main(String[] args) {
        System.out.println(new Offer58().reverseLeftWords("abcdefg", 2));
    }

    public String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i != n - 1; i = (i + 1) % s.length()) {
            stringBuilder.append(s.charAt(i));
        }
        stringBuilder.append(s.charAt(n-1));
        return stringBuilder.toString();
    }
}
