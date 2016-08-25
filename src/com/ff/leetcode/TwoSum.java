package com.ff.leetcode;

import java.util.Arrays;

/**
 * Created by fxd on 16/8/26.
 */
public class TwoSum {


    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        TwoSum twoSum =new TwoSum();
        int result[]=twoSum.twoSum(nums,target);
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum(int[] nums, int target) {
        int indices[] = new int[2];
        int length=nums.length;
        for (int i=0;i<length-1;i++){
            for (int j=i+1;j<length;j++){
                if (nums[i]+nums[j]==target){
                    indices[0]=i;
                    indices[1]=j;
                    return indices;
                }
            }
        }


        return indices;
    }
}
