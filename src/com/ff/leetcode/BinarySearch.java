package com.ff.leetcode;

/**
 * Created on 08/02/2017.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 7, 7, 9, 10, 11, 14, 19};
        BinarySearch search = new BinarySearch();

        System.out.println(search.binarySearch(nums, nums.length, -1));
        System.out.println(search.binarySearch(nums, nums.length, 1));
        System.out.println(search.binarySearch(nums, nums.length, 2));
        System.out.println(search.binarySearch(nums, nums.length, 7));
        System.out.println(search.binarySearch(nums, nums.length, 13));
        System.out.println(search.binarySearch(nums, nums.length, 20));
    }

    private int binarySearch(int[] nums, int length, int value) {
        int l = 0;
        int h = length - 1;

        while (l <= h) {
            int mid = (h + l) >>> 1;
            int midValue = nums[mid];
            if (midValue > value) {
                h = mid - 1;
            } else if (midValue < value) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return ~l;

    }
}
