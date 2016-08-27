package com.ff.leetcode;


public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode numsOne = new ListNode(9);
        numsOne.next = new ListNode(9);
//        numsOne.next.next = new ListNode(3);

        ListNode numsTwo = new ListNode(9);
//        numsTwo.next = new ListNode(9);
//        numsTwo.next.next = new ListNode(4);


        ListNode currentNode = addTwoNumbers(numsOne, numsTwo);
        System.out.println("currentNode");
        while (currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
    }

    /**
     * You are given two linked lists representing two non-negative numbers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumNode = l1;
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        int flag = 0;
        int singleSum = 0;
        ListNode lastsumNode = null;
        while (l1 != null && l2 != null) {
            singleSum = l1.val + l2.val + flag;
            flag = singleSum / 10;
            l1.val = singleSum % 10;
            lastsumNode = l1;
            l1 = l1.next;
            l2 = l2.next;

        }

        if (flag > 0) {
            if (l1 == null) {
                lastsumNode.next = l2;
                while (l2!=null&&lastsumNode!=null){
                    singleSum=flag+l2.val;
                    flag=singleSum/10;
                    l2.val=singleSum % 10;
                    lastsumNode.next=l2;
                    lastsumNode=l2;
                    l2=l2.next;

                }
                if (flag>0){
                    lastsumNode.next=new ListNode(flag);
                }

            }else {
                lastsumNode.next = l1;
                while (l1!=null&&lastsumNode!=null){
                    singleSum=flag+l1.val;
                    flag=singleSum/10;
                    l1.val=singleSum % 10;
                    lastsumNode.next=l1;
                    lastsumNode=l1;
                    l1=l1.next;
                }
                if (flag>0){
                    lastsumNode.next=new ListNode(flag);
                }
            }
        } else {
            if (l1 == null) {
                lastsumNode.next = l2;
            }

            if (l2 == null) {
                lastsumNode.next = l1;
            }
        }


        return sumNode;

    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}

