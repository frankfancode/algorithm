package com.ff.utils;

import java.util.Arrays;

public class Utils {
    public static String toString(boolean[][] arr) {
        StringBuffer stringBuffer = new StringBuffer();
        Arrays.stream(arr).forEach(subArr -> {
            stringBuffer.append(Arrays.toString(subArr)+'\n');
        });
        return stringBuffer.toString();
    }
}
