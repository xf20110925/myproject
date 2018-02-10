package com.xf.test.leetcode.easy;


import java.util.LinkedList;

/**
 * Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.
 * <p>
 * Example 1:
 * Input:
 * 1
 * / \
 * 0   2
 * <p>
 * L = 1
 * R = 2
 * <p>
 * Output:
 * 1
 * \
 * 2
 * Example 2:
 * Input:
 * 3
 * / \
 * 0   4
 * \
 * 2
 * /
 * 1
 * <p>
 * L = 1
 * R = 3
 * <p>
 * Output:
 * 3
 * /
 * 2
 * /
 * 1
 */
public class TrimBinarySearchTree {
    public static MergeTrees.TreeNode trimBST(MergeTrees.TreeNode root, int l, int r) {
        if (root == null)
            return root;
        if (root.val < l) {
            return trimBST(root.right, l, r);
        }
        if (root.val > r)
            return trimBST(root.left, l, r);

        root.left = trimBST(root.left, l, r);
        root.right = trimBST(root.right, l, r);

        return root;

    }

    //前序遍历 递归
    public static void preFor(MergeTrees.TreeNode treeNode) {
        if (treeNode == null)
            return;
        System.out.println(treeNode.val);
        preFor(treeNode.left);
        preFor(treeNode.right);
    }

    //前序遍历
    public static void preFor1(MergeTrees.TreeNode treeNode) {
        if (treeNode == null)
            return;
        final LinkedList<MergeTrees.TreeNode> stack = new LinkedList<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            final MergeTrees.TreeNode pop = stack.pop();
            System.out.println(pop.val);
            if (pop.right != null)
                stack.push(pop.right);
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }


    public static void main(String[] args) {
        final MergeTrees.TreeNode treeNode = new MergeTrees.TreeNode(3);
        treeNode.left = new MergeTrees.TreeNode(0);
        treeNode.right = new MergeTrees.TreeNode(4);
        treeNode.left.right = new MergeTrees.TreeNode(2);
        treeNode.left.right.left = new MergeTrees.TreeNode(1);
        final MergeTrees.TreeNode retNode = trimBST(treeNode, 1, 3);
        preFor(retNode);
        preFor1(retNode);
    }

}
