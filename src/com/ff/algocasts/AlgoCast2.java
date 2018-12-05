package com.ff.algocasts;

import java.util.Arrays;
import java.util.HashMap;

public class AlgoCast2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 6, 8, 9, 12};
        int sum=112;
        System.out.println(Arrays.toString(getTwoNumberSumToGivenValueHash(nums,sum)));
    }

    private static int[] getTwoNumberSumToGivenValueHash(int[] nums, int sum) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(sum - nums[i])) {
                return new int[]{i, hashMap.get(sum - nums[i])};
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return new int[]{-1,  - 1};
    }


}
