package com.ff.offer;

import java.util.HashMap;

public class Offer35 {
    public static void main(String[] args) {

    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node nHead = null;
        Node curr = null;
        Node srcCurr = head;
        while (srcCurr != null) {
            if (nHead == null) {
                nHead = new Node(head.val);
                curr = nHead;
            } else {
                curr.next = new Node(srcCurr.val);
                curr = curr.next;
            }
            map.put(srcCurr, curr);
            srcCurr = srcCurr.next;
        }

        srcCurr = head;
        curr = nHead;
        while (srcCurr != null) {
            if (srcCurr.random == null) {
                curr.random = null;
            } else {
                curr.random = map.get(srcCurr.random);
            }
            srcCurr = srcCurr.next;
            curr = curr.next;
        }

        return nHead;
    }
}
