package com.ff.leetcode;


/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 *
 */
public class Issue26 {
    public static void main(String[] args) {
        System.out.println(new Issue26().removeDuplicates(new int[]{1,1,2}));
        System.out.println(new Issue26().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public int removeDuplicates(int[] nums) {
        int slowIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[slowIndex]) {
                slowIndex++;
                nums[slowIndex] = nums[i];
            }
        }

        return slowIndex+1;
    }
}
