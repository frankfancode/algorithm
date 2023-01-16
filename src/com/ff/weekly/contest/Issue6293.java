package com.ff.weekly.contest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.ToIntFunction;

/**
 * 6293. 统计好子数组的数目
 * 6293. Count the Number of Good Subarrays
 */
public class Issue6293 {
    public static int[] getBigNums(String path) {
        int[] nums = new int[]{};
        try {
            String content = new String(Files.readAllBytes(Paths.get(path)));
            String[] numStrArr = content.split(",");
            nums = Arrays.stream(numStrArr).mapToInt(new ToIntFunction<String>() {
                @Override
                public int applyAsInt(String s) {
                    return Integer.parseInt(s);
                }
            }).toArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nums;

    }

    public static void main(String[] args) {
        System.out.println(new Issue6293().countGood(new int[]{3, 1, 4, 3, 2, 2, 4}, 1));
        System.out.println(new Issue6293().countGood(new int[]{1, 1, 1, 1, 1}, 1));
        System.out.println(new Issue6293().countGood(getBigNums("assets/input_data.txt"), 1));
        System.out.println(new Issue6293().countGood(getBigNums("assets/input_data_1.txt"), 1));
    }


    public long countGood(int[] nums, int k) {
        long res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0, cnt = 0;
        while (r < nums.length) {
            cnt = cnt + map.getOrDefault(nums[r], 0);
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (cnt >= k) {
                res = res + nums.length - r;
                cnt = cnt - map.getOrDefault(nums[l], 0) + 1;
                map.put(nums[l], map.getOrDefault(nums[l], 0) - 1);
                l = l + 1;
            }
            r = r + 1;
        }


        return res;
    }

}
