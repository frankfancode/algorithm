package com.ff.leetcode;

public class Issue62 {
    public static void main(String[] args) {
        System.out.println(new Issue62().uniquePaths(4, 5));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (i == 1 || j == 1) ? 1 : dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m][n];
    }


}
