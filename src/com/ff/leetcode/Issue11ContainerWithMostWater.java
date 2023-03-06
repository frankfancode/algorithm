package com.ff.leetcode;

import com.ff.utils.Utils;

/**
 * https://leetcode.cn/problems/container-with-most-water/
 * 11. 盛最多水的容器
 */
public class Issue11ContainerWithMostWater {

    public static void main(String[] args) {
        Issue11ContainerWithMostWater issue11ContainerWithMostWater = new Issue11ContainerWithMostWater();
        Utils.equalOrException(49, issue11ContainerWithMostWater.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        Utils.equalOrException(1, issue11ContainerWithMostWater.maxArea(new int[]{1, 1}));
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                for (int i = left + 1; height[i] < height[left] && i <= right; i++) {
                    left++;
                }
                left = left+1;
            } else {
                for (int i = right-1; height[i] < height[right] && i >= left; i--) {
                    right --;
                }
                right = right -1;
            }
        }
        return max;
    }
}
