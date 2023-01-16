package com.ff.weekly.contest;

import java.util.Arrays;

public class Issue6292 {

    public static void printArrays(int[][] arrs) {
        for (int[] arr :
                arrs) {
            System.out.println(Arrays.toString(arr));
        }
    }
    public static void main(String[] args) {
        printArrays(new Issue6292().rangeAddQueries(3, new int[][]{{1, 1, 2, 2}, {0, 0, 1, 1}}));
        assert equalIntArray
                (new Issue6292().rangeAddQueries(3, new int[][]{{1, 1, 2, 2}, {0, 0, 1, 1}}),
                        new int[][]{{1, 1, 0}, {1, 2, 1}, {0, 1, 1}}) : "error";
    }

    public static boolean equalIntArray(int[][] src1, int[][] src2) {
        for (int i = 0; i < src1.length; i++) {
            for (int j = 0; j < src1.length; j++) {
                if (src1[i][j] != src2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] origin = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                origin[i][j] = 0;
            }
        }


        for (int[] query : queries) {
            int left = query[0];
            int top = query[1];
            int right = query[2];
            int bottom = query[3];
            for (int i = left; i <= right; i++) {
                for (int j = top; j <= bottom; j++) {
                    origin[i][j] = origin[i][j] + 1;
                }
            }
        }
        return origin;
    }
}
