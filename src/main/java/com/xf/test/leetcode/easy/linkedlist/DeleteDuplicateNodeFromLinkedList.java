package com.xf.test.leetcode.easy.linkedlist;

import com.xf.test.leetcode.easy.linkedlist.AddTwoLinkList.ListNode;

/**
 * Created by xuefeng on 2019/2/27
 * <p>
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class DeleteDuplicateNodeFromLinkedList {

    public static ListNode deleteDuplicateNode(ListNode node) {
        ListNode retNode = node;
        while (node != null) {
            ListNode next = node.nextNode;
            if (next != null && node.val == next.val) {
                node.val = next.val;
                node.nextNode = next.nextNode;
            }
            node = node.nextNode;
        }
        return retNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1).setNextNode(new ListNode(2).setNextNode(new ListNode(2).setNextNode(new ListNode(2)).setNextNode(new ListNode(4))));
        AddTwoLinkList.printLinkedList(deleteDuplicateNode(l1));
    }
}
