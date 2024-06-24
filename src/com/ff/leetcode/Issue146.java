package com.ff.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/***
 * https://leetcode.cn/problems/lru-cache/?envType=study-plan-v2&envId=top-interview-150
 */
public class Issue146 {
}

class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}