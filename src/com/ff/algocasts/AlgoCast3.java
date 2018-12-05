package com.ff.algocasts;

import java.util.Arrays;
import java.util.HashMap;

public class AlgoCast3 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 6, 8, 9, 12};
        int sum = 10;
        System.out.println(Arrays.toString(getTwoNumberSumToGivenValueSequence(nums, sum)));
    }

    private static int[] getTwoNumberSumToGivenValueSequence(int[] nums, int sum) {
        for (int i = 0; i < nums.length; ) {
            for (int j = nums.length - 1; j > i; ) {
                if (nums[i] + nums[j] == sum) {
                    return new int[]{i + 1, j + 1};
                } else if (nums[i] + nums[j] > sum) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return new int[]{-1, -1};
    }


}
