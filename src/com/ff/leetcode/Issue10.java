package com.ff.leetcode;


/**
 * 10. 正则表达式匹配
 * 10. Regular Expression Matching
 * https://leetcode.cn/problems/regular-expression-matching/
 */
public class Issue10 {
    public static void main(String[] args) {
        new Issue10().valid();
    }

    public void valid() {
        assert !isMatch("aa", "a") : "error";
        assert !isMatch("abc", "abcd") : "error";
        assert !isMatch("abc", "ab") : "error";
        assert isMatch("aa", "a*") : "error";
        assert isMatch("aa", ".*") : "error";
        assert isMatch("a", ".*") == "a".matches(".*") : "error";
        assert isMatch("abcdefg", ".*fg") : "error";
        assert isMatch("abcdefg", ".*.*.*.*.*.*.*.*.*.*") == "abcdefg".matches(".*.*.*.*.*.*.*.*.*.*") : "error";
        assert !isMatch("aaaaaaaaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*") : "error";
    }

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        dp[0][0] = true;
        for (int i = 0; i <= sLen; ++i) {
            for (int j = 1; j <= pLen; j++) {
                if (pArr[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (i > 0 && match(sArr[i - 1], pArr[j - 2])) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (i > 0) {
                        if (match(sArr[i - 1], pArr[j - 1])) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }

                    }
                }
            }
        }

        return dp[sLen][pLen];
    }

    private boolean match(char s2, char p2) {
        return s2 == p2 || p2 == '.';
    }
}
