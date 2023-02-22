package com.ff.weekly.contest;

import java.util.HashSet;
import java.util.Set;

public class Issue6364 {
    public static void main(String[] args) {

//        System.out.println(new Issue6364().squareFreeSubsets(new int[]{3, 4, 4, 5}));
//        System.out.println(new Issue6364().squareFreeSubsets(new int[]{1}));
        System.out.println(new Issue6364().squareFreeSubsets(new int[]{26,6,4,27,6,18}));


    }


    public void printSet(Set<Set<Integer>> numsets) {
        //输出结果
        for (Set<Integer> subSet : numsets) {
            for (Integer num : subSet)
                System.out.print(num + ",");

            System.out.println("");
        }
    }

    public void printsinSet(Set<Integer> subSet) {
        //输出结果
        for (Integer num : subSet)
            System.out.print(num + ",");

        System.out.println();
    }


    public int squareFreeSubsets(int[] nums) {
        Set<Set<Integer>> subSets = getSubSet(nums);
        printSet(subSets);

        int count = 0;
        for (Set<Integer> set : subSets) {
            int mul = 1;
            for (Integer num : set) {
                mul = mul * num;
            }

            if (set.size()>=1 && !notContainSame(mul)) {
                System.out.println("real");
                printsinSet(set);
                count++;
            }
        }
        return count;
    }


    public static Set<Set<Integer>> getSubSet(int[] set) {
        Set<Set<Integer>> result = new HashSet<Set<Integer>>();    //用来存放子集的集合，如{{},{1},{2},{1,2}}
        int length = set.length;
        int num = length == 0 ? 0 : 1 << (length);    //2的n次方，若集合set为空，num为0；若集合set有4个元素，那么num为16.

        //从0到2^n-1（[00...00]到[11...11]）
        for (int i = 0; i < num; i++) {
            Set<Integer> subSet = new HashSet<Integer>();

            int index = i;
            for (int j = 0; j < length; j++) {
                if ((index & 1) == 1) {        //每次判断index最低位是否为1，为1则把集合set的第j个元素放到子集中
                    subSet.add(set[j]);
                }
                index >>= 1;        //右移一位
            }

            boolean same = result.add(subSet);        //把子集存储起来
            System.out.println("smae"+same);
        }
        return result;
    }


    public static boolean isPingfang(int num) {
        int[] pingfangnNums = {4, 9, 16, 25};
        for (int i = 0; i < pingfangnNums.length; i++) {
            if (num == pingfangnNums[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean notContainSame(int num) {
        int[] pingfangnNums = {4, 9, 16, 25,36,49,81};
        for (int i = 0; i < pingfangnNums.length; i++) {
            if (num % pingfangnNums[i] == 0) {
                return true;
            }
        }

        return false;
    }

    ;
}
