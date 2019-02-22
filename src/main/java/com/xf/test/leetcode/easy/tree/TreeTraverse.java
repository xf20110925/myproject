package com.xf.test.leetcode.easy.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xuefeng on 2019/2/12
 * <p>
 * 树的遍历有两类:深度优先遍历和宽度优先遍历。深度优先遍历又可分为两种:先根(次序) 遍历和后根(次序)遍历。
 * 树的先根遍历是:先访问树的根结点，然后依次先根遍历根的各棵子树。树的先跟遍历的结果 与对应二叉树(孩子兄弟表示法)的先序遍历的结果相同。
 * 树的后根遍历是:先依次后根遍历树根的各棵子树，然后访问根结点。树的后跟遍历的结果与 对应二叉树的中序遍历的结果相同。
 * 二叉树的先根遍历有:先序遍历 (root->le->right)，root->right->le;后根遍历有:后序遍历 (le->right->root)，right->le->root;二叉树还有个一般的树没有的遍历次序，中序遍历 (le->root- >right)。
 * 5.1.1 Binary Tree Level Order Traversal
 * 描述
 * Given a binary tree, return the level order traversal of its nodes’ values. (ie, from le to right, level by level).
 * For example: Given binary tree {3,9,20,#,#,15,7},
 * 3
 * /\
 * 9 20
 * /\
 * 15 7
 * <p>
 * 第5章 树
 * 76 第5章 树 return its level order traversal as:
 * [ [3],
 * [9,20],
 * [15,7] ]
 * 分析
 */
public class TreeTraverse {

    static class Tree {
        public int val;

        public Tree(int val) {
            this.val = val;
        }

        public Tree left;
        public Tree right;

        public int getVal() {
            return val;
        }

        public Tree setVal(int val) {
            this.val = val;
            return this;
        }

        public Tree getLeft() {
            return left;
        }

        public Tree setLeft(Tree left) {
            this.left = left;
            return this;
        }

        public Tree getRight() {
            return right;
        }

        public Tree setRight(Tree right) {
            this.right = right;
            return this;
        }
    }

    //递归
    public static void solutionRecursion(Tree tree) {
        if (tree == null)
            return;
        System.out.println(tree.val);
        solutionRecursion(tree.left);
        solutionRecursion(tree.right);
    }

    //非递归
    public static void solutionNoRecursion(Tree tree) {
        LinkedList<Tree> stack = new LinkedList<>();
        stack.push(tree);
        while (!stack.isEmpty()) {
            Tree headTree = stack.poll();
            System.out.println(headTree.val);
            Tree left = headTree.getLeft();
            Tree right = headTree.getRight();
            if (right != null)
                stack.push(right);
            if (left != null)
                stack.push(left);
        }
    }

    //非递归,中序遍历
    public static void solutionNoRecursionMiddleTraverse(Tree tree) {
        LinkedList<Tree> stack = new LinkedList<>();
        ArrayList<Tree> list = new ArrayList<>();
        Tree treeNode = tree;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            Tree headTree = stack.pop();
            Tree right = headTree.right;
            treeNode = right;
            list.add(headTree);
        }
        for (Tree t : list) {
            System.out.println(t.val);
        }
    }

    //非递归
    public static void solutionNoRecursionLastTraverse(Tree tree) {
        LinkedList<Tree> stack = new LinkedList<>();
        LinkedList<Tree> result = new LinkedList<>();
        stack.push(tree);
        while (!stack.isEmpty()) {
            Tree headTree = stack.pop();
            Tree left = headTree.getLeft();
            Tree right = headTree.getRight();
            if (left != null)
                stack.push(left);
            if (right != null)
                stack.push(right);
            result.push(headTree);
        }
        while (!result.isEmpty()) {
            System.out.println(result.poll().val);
        }
    }

    //二叉树镜像反转
    public static void treeReverse(Tree tree) {
        if (tree == null)
            return;
        Tree left = tree.left;
        Tree right = tree.right;
        tree.left = right;
        tree.right = left;
        treeReverse(left);
        treeReverse(right);
    }

    //二叉树层次遍历
    public static void levelReverse(Tree tree) {
        LinkedList<Tree> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            Tree currentTree = queue.poll();
            System.out.println(currentTree.val);
            if (currentTree.left != null)
                queue.add(currentTree.left);
            if (currentTree.right != null)
                queue.add(currentTree.right);
        }
    }

    /**
     * 手写代码判断完全二叉树
     * <p>
     * 层序遍历，1、如果当前节点左节点为null并且右节点不为null直接返回false
     * 2、如果当前节点当前节点并不是左右节点都有，那么之后的节点必须为叶子节点，否则返回false
     */
    public static boolean isCompleteTree(Tree tree) {
        LinkedList<Tree> queue = new LinkedList<>();
        queue.add(tree);
        boolean isLeaf = false;
        while (!queue.isEmpty()) {
            Tree currentNode = queue.poll();
            if (currentNode.left == null && currentNode.right != null)
                return false;
            if (isLeaf && (currentNode.left != null || currentNode.right != null))
                return false;
            if (currentNode.left != null && currentNode.right == null) {
                isLeaf = true;
            }
            if (currentNode.left != null)
                queue.add(currentNode.left);
            if (currentNode.right != null)
                queue.add(currentNode.right);
        }
        return true;
    }

    public static void main(String[] args) {
        Tree tree = new Tree(3).setLeft(new Tree(9)).setRight(new Tree(20).setLeft(new Tree(15)).setRight(new Tree(7)));
        solutionRecursion(tree);
//        System.out.println("######################");
//        solutionNoRecursion(tree);
//        System.out.println("######################");
//        solutionNoRecursionMiddleTraverse(tree);
//        System.out.println("######################");
//        solutionNoRecursionLastTraverse(tree);

        treeReverse(tree);
        System.out.println("*********************");
        levelReverse(tree);

        Tree completeTree = new Tree(3).setLeft(new Tree(9).setLeft(new Tree(1))).setRight(new Tree(20));
        boolean is = isCompleteTree(completeTree);
        System.out.println(is);

        Tree noCompleteTree = new Tree(3).setLeft(new Tree(9).setLeft(new Tree(1))).setRight(new Tree(20).setLeft(new Tree(6)));
        boolean not = isCompleteTree(noCompleteTree);
        System.out.println(not);
    }
}
