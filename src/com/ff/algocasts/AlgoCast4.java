package com.ff.algocasts;

import java.util.Arrays;

public class AlgoCast4 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 1;
        treeNode.left = new TreeNode();
        treeNode.right = new TreeNode();

        treeNode.left.val = 2;
        treeNode.left.left = new TreeNode();
        treeNode.left.right = new TreeNode();
        treeNode.left.left.val = 4;
        treeNode.left.right.val = 8;


        treeNode.right.val = 2;
        treeNode.right.left = new TreeNode();
        treeNode.right.right = new TreeNode();
        treeNode.right.left.val = 8;
        treeNode.right.right.val = 4;

        System.out.println();
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    private static int[] isSymmetric() {

    }


}
