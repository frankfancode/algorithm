package com.ff.leetcode;

import com.ff.utils.Utils;

import java.util.*;
import java.util.stream.Collectors;

// 17. letter-combinations-of-a-phone-number
// 17. 电话号码的字母组合
public class Issue17 {
    public static void main(String[] args) {
//        letterCombinations()
//        System.out.println(Utils.toString(new Issue17().letterCombinations("23")));
//        System.out.println(Utils.toString(new Issue17().letterCombinations("2")));
        System.out.println(Utils.toString(new Issue17().letterCombinations("")));
        System.out.println(Utils.toString(new Issue17().letterCombinations("7")));
//        System.out.println(Utils.toString(new Issue17().letterCombinations("2345")));
    }

    public List<String> letterCombinations(String digits) {
        Set<String> sets = new HashSet<>();
        for (int i = 0; i < digits.length(); i++) {
            String letters = fromDigits(digits.charAt(i));
            Set<String> nSets = new HashSet<>();
            for (int j = 0; j < letters.length(); j++) {
                if (i == 0) {
                    nSets.add(letters.substring(j, j + 1));
                } else {
                    int finalJ = j;
                    sets.forEach(
                            s -> {
                                nSets.add(s + letters.charAt(finalJ));
                            }
                    );
                }
            }
            sets = nSets;
        }
        return new ArrayList<>(sets);
    }


    private String fromDigits(char c) {
        switch (c) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
        }
        return "";
    }
}
