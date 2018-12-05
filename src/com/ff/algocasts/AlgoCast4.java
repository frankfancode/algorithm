package com.ff.algocasts;

import java.util.Stack;

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

        System.out.println(treeNode);

        System.out.println(isSymmetric(treeNode.left, treeNode.right));
        System.out.println(isSymmetricTreeIterative(treeNode));
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    static boolean isSymmetric(TreeNode s, TreeNode t) {
        if (s != null && t != null)
            return s.val == t.val &&
                    isSymmetric(s.left, t.right) && isSymmetric(s.right, t.left);
        else return s == null && t == null;
    }

    static boolean isSymmetricTreeIterative(TreeNode rootNode) {
        if (rootNode == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(rootNode.left);
        stack.push(rootNode.right);
        while (!stack.empty()) {
            TreeNode s = stack.pop();
            TreeNode t = stack.pop();
            if (s == null && t == null) continue;
            if (s == null || t == null) return false;
            if (s.val != t.val) return false;

            stack.push(s.left);
            stack.push(t.right);

            stack.push(s.right);
            stack.push(t.left);

        }

        return true;

    }


}
