package com.ff.leetcode;

import java.util.Arrays;

/**
 * Created by frank on 17-2-16.
 * 将数组中的奇数放左边，偶数放右边
 */
public class OddChange {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 8, 8, 5, 6, 7, 5, 5, 5, 5, 9, 10};
        System.out.println(Arrays.toString(oddChange(nums)));
    }

    private static int[] oddChange(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            while (l < r && nums[l] % 2 == 1) {
                l++;
            }

            while (l < r && nums[r] % 2 == 0) {
                r--;
            }
            System.out.println("nums[" + l + "] " + nums[l] + " nums[" + r + "] " + nums[r] + " " + Arrays.toString(nums));
            swap(nums, l, r);
        }
        return nums;
    }

    private static void swap(int[] nums, int l, int r) {
        int swap = nums[l];
        nums[l] = nums[r];
        nums[r] = swap;
    }
}
