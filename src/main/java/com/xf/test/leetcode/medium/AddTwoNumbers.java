package com.xf.test.leetcode.medium;

/**
 * 题目：
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * <p>
 * 翻译：
 * 给你2个链表，代表2个非负整数。链表中整数的每一位数字的存储是反序的，数组的每个节点都包含一个数字。把2个非负整数相加，并且用一个链表返回。
 * 输入: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 0 -> 8
 * <p>
 * 分析：
 * 由于刚好链表中数的存储是反序，也就是个位在最前面，正好方便我们从低位开始加。需要注意的几个点：
 * 1. 传入[][],也就是2个空链表，要返回null
 * 2. 传入[0][0]，也就是2个整数是0的处理，要返回[0]
 * 3. 传入[5][5],要新增一个节点，存储进位。也就是判断是否结束，要根据2个链表是否为空和是否有进位来判断。
 */
public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode add(ListNode l1, ListNode l2) {
        final ListNode retListNode = new ListNode(0);
        ListNode preNode = retListNode;
        int lastNum = 0;
        while (l1 != null && l2 != null) {
            final int newVal = l1.val + l2.val;
            final int shang = newVal / 10;
            final int yushu = newVal % 10;
            final ListNode listNode = new ListNode(yushu + lastNum);
            preNode.next = listNode;
            lastNum = shang;
            l1 = l1.next;
            l2 = l2.next;
            preNode = preNode.next;
        }

        if (l1 == null && l2 != null) {
            l2.val = l2.val + lastNum;
            retListNode.next = l2;
        }
        if (l2 == null && l1 != null) {
            l1.val = l1.val + lastNum;
            retListNode.next = l1;
        }
        return retListNode.next;
    }

    public static void main(String[] args) {
        final ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        final ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode retListNode = add(l1, l2);
        while (retListNode != null) {
            System.out.println(retListNode.val);
            retListNode = retListNode.next;
        }
    }
}
