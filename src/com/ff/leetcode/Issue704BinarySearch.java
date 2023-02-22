package com.ff.leetcode;

/**
 * https://leetcode.cn/problems/binary-search/
 */
public class Issue704BinarySearch {
    public static void main(String[] args) {
        System.out.println(new Issue704BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12},9));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int center = (left + right) / 2;
        while (left <= right) {

            center = (left + right) / 2;
            if (nums[center] < target) {
                left = center + 1;
            } else if (nums[center] > target) {
                right = center - 1;
            } else if (nums[center] == target) {
                return center;
            }
        }

        return -1;
    }
}
