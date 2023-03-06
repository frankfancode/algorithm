package com.ff.offer;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=f4eq4ut
 * 剑指 Offer 24. 反转链表
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */


public class Offer24 {
     static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = null;
        System.out.println(new Offer24().reverseList(head).val);
    }



    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode newHead = null;
        ListNode cur = null;
        while (!stack.isEmpty()) {
            if (newHead == null) {
                newHead = stack.pop();
                cur = newHead;
            } else {
                cur.next = stack.pop();
                cur = cur.next;
            }
        }
        if (cur!=null){
            cur.next=null;
        }


        return newHead;
    }
}

