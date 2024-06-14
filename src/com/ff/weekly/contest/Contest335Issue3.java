package com.ff.weekly.contest;

import com.ff.utils.Utils;

import java.util.*;

/**
 * https://leetcode.cn/problems/split-the-array-to-make-coprime-products/
 * 20230309 use solution learn from leetcode
 */
public class Contest335Issue3 {
    public static void main(String[] args) {
        Utils.equalOrException(2, new Contest335Issue3().findValidSplit(new int[]{4, 7, 16, 15, 3, 5}));
        Utils.equalOrException(-1, new Contest335Issue3().findValidSplit(new int[]{4, 7, 15, 8, 3, 5}));
        Utils.equalOrException(18, new Contest335Issue3().findValidSplit(new int[]{557663, 280817, 472963, 156253, 273349, 884803, 756869, 763183, 557663, 964357, 821411, 887849, 891133, 453379, 464279, 574373, 852749, 15031, 156253, 360169, 526159, 410203, 6101, 954851, 860599, 802573, 971693, 279173, 134243, 187367, 896953, 665011, 277747, 439441, 225683, 555143, 496303, 290317, 652033, 713311, 230107, 770047, 308323, 319607, 772907, 627217, 119311, 922463, 119311, 641131, 922463, 404773, 728417, 948281, 612373, 857707, 990589, 12739, 9127, 857963, 53113, 956003, 363397, 768613, 47981, 466027, 981569, 41597, 87149, 55021, 600883, 111953, 119083, 471871, 125641, 922463, 562577, 269069, 806999, 981073, 857707, 831587, 149351, 996461, 432457, 10903, 921091, 119083, 72671, 843289, 567323, 317003, 802129, 612373}));

    }

    public int findValidSplit(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];

            for (int j = 2; j * j <= x; j++) {
                if (x % j == 0) {
                    if (!left.containsKey(j)) {
                        left.put(j, i);
                        left.put(x / j, i);
                    } else {
                        right.put(left.get(x), i);
                    }
                }
            }

            if (!left.containsKey(x)) {
                left.put(x, i);
            } else {
                right.put(left.get(x), i);
            }
        }

        int max = -1;
        right.entrySet().stream().forEach(System.out::println);
        return max;
    }
}

