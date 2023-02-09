package com.ff.leetcode;

import com.ff.utils.Utils;

import java.util.*;

// 17. letter-combinations-of-a-phone-number
// 17. 电话号码的字母组合
public class Issue17SolutionBacktracking {
    public static void main(String[] args) {
        System.out.println(Utils.toString(new Issue17().letterCombinations("23")));
        System.out.println(Utils.toString(new Issue17().letterCombinations("2")));
        System.out.println(Utils.toString(new Issue17SolutionBacktracking().letterCombinations("")));
        System.out.println(Utils.toString(new Issue17SolutionBacktracking().letterCombinations("7")));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() <= 0) {
            return Collections.emptyList();
        }

        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> combinations = new LinkedList<>();

        backTrack(digits, phoneMap, 0, new StringBuffer(), combinations);
        return combinations;
    }

    private void backTrack(String digits, Map<Character, String> phoneMap, int index, StringBuffer combination, List<String> combinations) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
            return;
        }
        String letters = phoneMap.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            combination.append(letters.charAt(i));
            backTrack(digits, phoneMap, index + 1, combination, combinations);
            combination.deleteCharAt(index);
        }
    }


}
