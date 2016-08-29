package com.ff.leetcode;

/**
 * Created by fxd on 16/8/29.
 */

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String args[]) {
        String s1 = "ab";
        //System.out.println(s1.substring(0,2));
        System.out.println(lengthOfLongestSubstring(s1));

    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int lastStartIndex = 0;
        int lastEndIndex = 0;

        int startIndex = 0;
        int endIndex = 0;

        int currentStartIndex = 0;
        int currentEndIndex = 0;

        while (endIndex < s.length()) {

            currentStartIndex = startIndex;
            currentEndIndex = endIndex;

            if ((s.length() - startIndex) < (lastEndIndex - lastStartIndex)) {
                break;
            }

            int i = endIndex + 1;
            if (i < s.length()) {
                String s2 = s.substring(i, i + 1);
                for (int j = startIndex; j <= endIndex; j++) {
                    String s1 = s.substring(j, j + 1);
                    if (s1.equals(s2)) {
                        currentStartIndex = j + 1;
                        break;
                    } else {
                        currentEndIndex = i;
                    }
                    if (j + 1 == i) {

                    }
                }

                if ((endIndex - startIndex) > (lastEndIndex - lastStartIndex)) {
                    lastEndIndex = endIndex;
                    lastStartIndex = startIndex;
                }


                startIndex = currentStartIndex;
                if (currentEndIndex<=currentStartIndex){
                    endIndex = currentStartIndex;
                }else {
                    endIndex=currentEndIndex;
                }

            }else {
                if ((endIndex - startIndex) > (lastEndIndex - lastStartIndex)) {
                    lastEndIndex = endIndex;
                    lastStartIndex = startIndex;
                }
                break;
            }

        }
        return lastEndIndex+1 - lastStartIndex;
    }

}
