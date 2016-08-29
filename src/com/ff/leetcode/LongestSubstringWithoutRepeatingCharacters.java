package com.ff.leetcode;

/**
 * Created by fxd on 16/8/29.
 */

import java.util.Arrays;

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
        String s1 = "aaaa";
        //System.out.println(s1.substring(0,2));
        System.out.println(lengthOfLongestSubstring1(s1));

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
                char s2 = s.charAt(i);
                for (int j = startIndex; j <= endIndex; j++) {
                    char s1 = s.charAt(j);
                    if (s1==s2) {
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

    public static int lengthOfLongestSubstring1(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int [] countTable = new int[256];
        Arrays.fill(countTable, -1);
        int max = 1;
        int start = 0;
        int end = 1;

        countTable[s.charAt(0)] = 0;
        while (end < length) {
            //Has not reached a duplicate char
            int c=s.charAt(end);
            int countTableValue=countTable[c];
            if (countTableValue >= start) {
                start = countTable[s.charAt(end)] + 1;
            }
            max = Math.max(max, end - start + 1);
            countTable[s.charAt(end)] = end;
            end++;
        }
        return max;
    }

}
