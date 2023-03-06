package com.ff.weekly.contest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Contest335Issue3 {
    public static void main(String[] args) {
//        System.out.println(new Contest335Issue3().findValidSplitOther(new int[]{4, 7, 8, 15, 3, 5}));
        System.out.println(new Contest335Issue3().findValidSplitOther(new int[]{4, 7, 16, 15, 3, 5}));
//        System.out.println(new Contest335Issue3().findValidSplit(new int[]{4, 7, 15, 8, 3, 5}));
//        System.out.println(new Contest335Issue3().findValidSplit(new int[]{233117, 253853, 295037, 678859, 829097, 272539, 809843, 269897, 4211, 136463, 650609, 945929, 117373, 83791, 233117, 355171, 618413, 66347, 119047, 103643, 966727, 796447, 726689, 642533, 150497, 968117, 747679, 81233, 696823, 818689, 859981, 895889, 647147, 95203, 749323, 892123, 253661, 719393, 671431, 53171, 415031, 88397, 250673, 111373, 648029, 855667, 40739, 532993, 892123, 429733, 390821, 769117, 71483, 306457, 721631, 658139, 671981, 916169, 250673, 140111, 655913, 152833, 227153, 963653, 778831, 506903, 286427, 750121, 68927, 33941, 656609, 126481, 606721, 593851, 281921, 487897, 609373, 497521, 327629, 431051, 453553, 978749, 917381, 659713, 155119, 660787, 761983, 410801, 508531, 322571, 317903, 185531, 969593, 286397, 800161, 730297, 132863, 453569, 879331, 39679, 149837, 877817, 45757, 268501, 841741, 91499, 813931, 765229, 340057, 193771, 24877, 122053, 264643, 882587, 514177, 929009, 437201, 981523, 483251, 593629, 193031, 508531, 601259, 510451, 615431, 575963, 791377, 907111, 787261, 8527, 827161, 986339, 308041, 544651, 953647, 762539, 29017, 81619, 944953, 137743, 529229, 742663, 349603, 444469, 960983, 750457, 800161, 575963, 302767, 737531, 220673, 886163, 604343, 340999, 916213, 141539, 995387, 832427, 297779, 155003, 850021, 499159, 699733, 412123, 168901, 743269, 952937, 913139, 401311, 946853, 191339, 155627, 236699, 825661, 264269, 450011, 948151, 306899, 996011, 64747, 924383, 740693, 845809, 932483, 550009, 862423, 876947, 329591, 728813, 830551, 280897, 647557, 756419, 889363, 337313, 173819, 869663, 144341, 709981, 866003, 978863, 229487, 41077, 763601, 309571, 389563, 499039, 496817, 160829, 812807, 674189, 454417, 602717, 116663, 957071, 816469, 427919, 162749, 279967, 896299, 411443, 965893, 22111, 23417, 156797, 268531, 116663}));
    }

    List<HashSet> list = new LinkedList<>();
    int[] originnums;

    public void complateHash(int index) {
        if (index >= list.size()) {
            list.add(getParse(originnums[index]));
        }
    }

    public int findValidSplit(int[] nums) {
        originnums = nums;
        for (int i = 0; i <= nums.length - 2; i++) {
            HashSet left = new HashSet();
            complateHash(i);
            for (int j = 0; j <= i; j++) {
                left.addAll(list.get(j));
            }



            HashSet right = new HashSet();
            for (int j = i + 1; j < nums.length; j++) {
                complateHash(j);
                right.addAll(list.get(j));
                HashSet allSet = new HashSet();
                allSet.addAll(left);
                allSet.addAll(right);
                if (j == nums.length - 1 && allSet.size() == left.size() + right.size()) {
                    return i;
                }
            }

//            allSet.stream().forEach(System.out::println);

        }
        return -1;
    }

    public static HashSet<Integer> getParse(int num) {
        HashSet<Integer> hashSet = new HashSet<>();
        int k = 2;
        int fennum = num / 2;
        while (k <= fennum) {
            if (num % k == 0) {
                if (isPrime(k)) {
                    hashSet.add(k);
                }
            }
            k++;
        }
        if (hashSet.size() < 1) {
            hashSet.add(num);
        }
        return hashSet;
    }

    public static boolean isPrime(int i) {
        boolean isPrime = true;
        for (int k = 2; k <= i / 2; k++) {
            if (i % k == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }


    public int findValidSplitOther(int[] nums) {
        int n = nums.length;
        var left = new HashMap<Integer, Integer>(); // left[p] 表示质数 p 首次出现的下标
        var right = new int[n]; // right[i] 表示左端点为 i 的区间的右端点的最大值

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int d = 2; d * d <= x; ++d)  // 分解质因数
                if (x % d == 0) {
                    if (left.containsKey(d))
                        right[left.get(d)] = i; // 记录左端点对应的右端点的最大值
                    else
                        left.put(d, i); // 第一次遇到质数 d
                    for (x /= d; x % d == 0; x /= d) ;
                }
            if (x > 1)
                if (left.containsKey(x))
                    right[left.get(x)] = i;
                else
                    left.put(x, i);
        }

        for (int l = 0, maxR = 0; l < n; l++) {
            if (l > maxR) // 最远可以遇到 maxR
                return maxR; // 也可以写 l-1
            maxR = Math.max(maxR, right[l]);
        }
        return -1;
    }
}

