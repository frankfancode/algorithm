package com.ff.algocasts;

public class AlgoCasts1 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("as1d1d1sa"));

    }


    private static boolean isAlphaNumric(char c) {
        return ((c >= 'a' && c <= 'z') || (c > 'A' && c < 'Z') || (c >= '0' && c <= '9'));

    }

    private static boolean isEqual(char a, char b) {
        if (a >= 'A' && a <= 'Z') {
            a += 32;
        }

        if (b>= 'A' && b <= 'Z') {
            b += 32;
        }

        return a==b;
    }

    public static boolean isPalindrome(String s) {
        System.out.println(s);

        if (s == null || s.length() == 0) {
            return true;
        }

        int i = 0;
        int j = s.length() - 1;
        while (i<= j - 1) {

            if (!isAlphaNumric(s.charAt(i))) {
                i++;
                continue;
            }

            if (!isAlphaNumric(s.charAt(j))) {
                j--;
                continue;
            }

            if (isAlphaNumric(s.charAt(i)) && isAlphaNumric(s.charAt(j))) {
                System.out.println(s.charAt(i)  +" "+s.charAt(j) );
                if (isEqual(s.charAt(i), s.charAt(j))) {
                    i++;
                    j--;
                    continue;
                } else {
                    return false;
                }
            }
        }

        return true;


    }

}
