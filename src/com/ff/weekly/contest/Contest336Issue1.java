package com.ff.weekly.contest;

import java.util.LinkedList;
import java.util.List;

public class Contest336Issue1 {
    static List<Character> characters = new LinkedList<>();


    public static void main(String[] args) {
        String[] strings = new String[]{"are", "amy", "u"};
        System.out.println(vowelStrings(strings, 0, 2));
    }

    public static int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (isO(word.charAt(0), word.charAt(word.length() - 1))) {
                count++;
            }
        }
        return count;
    }
    static char[] chars = new char[]{'a', 'e', 'i', 'o', 'u'};
    public static boolean isO(char s, char e) {


        boolean sOk = false;
        boolean eOk = false;
        for (char c : chars) {
            if (s == c) {
                sOk = true;
            }
            if (e == c) {
                eOk = true;
            }
        }

        return sOk && eOk;
    }


}
