package com.ff.leetcode;

import java.util.*;
import java.util.function.Consumer;

/**
 * https://leetcode.cn/problems/top-k-frequent-elements/?envType=study-plan-v2&envId=top-100-liked
 */
public class Issue347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> integerIntegerEntry, Map.Entry<Integer, Integer> t1) {
                return t1.getValue() - integerIntegerEntry.getValue();
            }
        });


        map.entrySet().forEach(new Consumer<Map.Entry<Integer, Integer>>() {
            @Override
            public void accept(Map.Entry<Integer, Integer> o) {
                queue.add(o);
            }
        });

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i]=queue.poll().getKey();
        }

        return result;
    }
}

