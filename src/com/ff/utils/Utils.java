package com.ff.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static String toString(boolean[][] arr) {
        StringBuffer stringBuffer = new StringBuffer();
        Arrays.stream(arr).forEach(subArr -> {
            stringBuffer.append(Arrays.toString(subArr)+'\n');
        });
        return stringBuffer.toString();
    }

    public static String toString(List<String> list){
        return String.join(",", list);
    }
}
