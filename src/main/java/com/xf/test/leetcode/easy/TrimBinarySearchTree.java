package com.xf.test.leetcode.easy;


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
    public MergeTrees.TreeNode trimBST(MergeTrees.TreeNode root, int l, int r) {
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

}
