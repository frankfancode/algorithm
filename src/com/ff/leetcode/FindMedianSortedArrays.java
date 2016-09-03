package com.ff.leetcode;

/**
 * Created by fxd on 16/9/3.
 */
public class FindMedianSortedArrays {
    public static void main(String args[]) {
        int nums1[] = {1, 3};
        int nums2[] = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int num1Size = nums1.length;
        int num2Size = nums2.length;
        int num3[] = new int[num1Size + num2Size];
        int i = 0, j = 0;
        while (i + j <= num1Size + num2Size - 1) {
            if (j >= num2Size) {
                num3[i + j] = nums1[i];
                i++;
            } else if (i >= num1Size) {
                num3[i + j] = nums2[j];
                j++;
            } else if (nums1[i] > nums2[j]) {
                num3[i + j] = nums2[j];
                j++;
            } else {
                num3[i + j] = nums1[i];
                i++;
            }

        }
        int num3Size = num3.length;
        double median;
        if (0 == num3Size % 2) {
            median = (num3[num3Size / 2] + num3[num3Size / 2 - 1]) / 2.0d;
        } else {
            median = num3[num3Size / 2];
        }
        return median;
    }
}
