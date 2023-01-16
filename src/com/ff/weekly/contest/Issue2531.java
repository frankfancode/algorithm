package com.ff.weekly.contest;

import java.util.HashMap;
import java.util.Set;

//2531. 使字符串总不同字符的数目相等
public class Issue2531 {
    public static void main(String[] args) {
        assert new Issue2531().isItPossible("aa", "ab") == false : "1";
        assert new Issue2531().isItPossible("aa", "bcd") == false : "1";
        assert new Issue2531().isItPossible("aab", "bccd") == true : "1";
        assert new Issue2531().isItPossible("a", "bb") == false : "1";
        assert new Issue2531().isItPossible("ac", "b") == false : "1";
        assert new Issue2531().isItPossible("abcc", "aab") == true : "1";
        assert new Issue2531().isItPossible("abcde", "fghij") == true : "1";
        assert new Issue2531().isItPossible("aaaaa", "bbbbb") == true : "1";

    }

    public boolean isItPossible(String word1, String word2) {

        HashMap<Integer, Integer> word1Map = new HashMap<>(26);
        HashMap<Integer, Integer> word2Map = new HashMap<>(26);

        for (int code : word1.toCharArray()) {
            int count = word1Map.getOrDefault(code, 0);
            if (count>0) {
                word1Map.put(code, count + 1);
            } else {
                word1Map.put(code, 1);
            }
        }

        for (int code : word2.toCharArray()) {
            int count = word2Map.getOrDefault(code, 0);
            if (count>0) {
                word2Map.put(code, count + 1);
            } else {
                word2Map.put(code, 1);
            }
        }

        Set<Integer> word1Keys = word1Map.keySet();
        Set<Integer> word2Keys = word2Map.keySet();
        int diffCount = word1Keys.size() - word2Keys.size();
        if (Math.abs(diffCount) <= 2) {
            for (Integer i : word1Keys) {
                for (Integer j : word2Keys) {
                    int word1Diff = 0;
                    int word2Diff = 0;
                    if (i.equals(j)) {
                        if (diffCount == 0) {
                            return true;
                        }
                    } else {
                        if (word1Map.get(i) == 1) {
                            --word1Diff;
                        }

                        if (!word1Map.containsKey(j)) {
                            ++word1Diff;
                        }

                        if (!word2Map.containsKey(i)) {
                            ++word2Diff;
                        }

                        if (word2Map.get(j) == 1) {
                            --word2Diff;
                        }
                        if (diffCount == word2Diff - word1Diff) {
                            return true;
                        }
                    }


                }


            }


            return false;
        }

        // same
        return false;
    }
}
