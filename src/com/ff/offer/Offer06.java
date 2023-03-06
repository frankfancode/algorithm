package com.ff.offer;

/**
 * https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * 剑指 Offer 06. 从尾到头打印链表
 */


import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */


public class Offer06 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }

        int[] nums = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            nums[i] = stack.pop();
            i++;
        }
        return nums;
    }
}

