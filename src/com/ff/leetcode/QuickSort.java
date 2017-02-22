package com.ff.leetcode;

import java.util.Arrays;

/**
 * Created by frank on 17-2-22.
 */
public class QuickSort {
    public static void main(String[] args) {

        int[] nums = {13, 5, 7, 8, 9, 2, 4, 6, 8};
        QuickSort qs = new QuickSort();
        qs.quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int mid = nums[end];
        int left = start, right = end - 1;
        while (left < right) {
            while (nums[left] <= mid && left < right)
                left++;
            while (nums[right] >= mid && left < right)
                right--;
            swap(nums, left, right);
        }
        if (nums[left] >= nums[end])
            swap(nums, left, end);
        else
            left++;
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);

    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
