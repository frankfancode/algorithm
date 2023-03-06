package com.ff.utils;

import java.util.Arrays;
import java.util.List;

public class Utils {
    public static String toString(boolean[][] arr) {
        StringBuffer stringBuffer = new StringBuffer();
        Arrays.stream(arr).forEach(subArr -> {
            stringBuffer.append(Arrays.toString(subArr)).append('\n');
        });
        return stringBuffer.toString();
    }

    public static String toString(int[][] arr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            stringBuffer.append("[");
            for (int j = 0; j < arr[i].length; j++) {
                if (j == arr[i].length - 1) {
                    stringBuffer.append(arr[i][j]).append("" + addWhite(String.valueOf(arr[i][j]), 8));
                } else {
                    stringBuffer.append(arr[i][j]).append("," + addWhite(String.valueOf(arr[i][j]), 8));
                }

            }
            stringBuffer.append("]\n");
        }
//        Arrays.stream(arr).forEach(subArr -> {
//            stringBuffer.append(Arrays.toString(subArr)).append('\n');
//        });
        return stringBuffer.toString();
    }

    public static String toString(List<String> list) {
        return String.join(",", list);
    }

    public static String addWhite(String s, int number) {
        StringBuffer stringBuffer = new StringBuffer();
        int left = number - s.length();
        for (int i = 0; i < left; i++) {
            stringBuffer.append(" ");
        }
        return stringBuffer.toString();
    }

    public static void equalOrException(Object need, Object actual) {
        if (need != actual) {
            throw new RuntimeException("need:" + need.toString() + "\t actual:" + actual.toString());
        }
    }
}
