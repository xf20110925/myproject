package com.xf.test.leetcode.easy.linkedlist;

import com.xf.test.leetcode.easy.linkedlist.AddTwoLinkList.ListNode;

import static com.xf.test.leetcode.easy.linkedlist.AddTwoLinkList.printLinkedList;

/**
 * Created by xuefeng on 2019/2/26
 * <p>
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.nextNode;
            head.nextNode = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.nextNode == null) {
            return head;
        }
        ListNode newHead = reverseList1(head.nextNode);
        head.nextNode.nextNode = head;
        head.nextNode = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1).setNextNode(new ListNode(2).setNextNode(new ListNode(3).setNextNode(new ListNode(4))));
        printLinkedList(l1);

        System.out.println("############");
        printLinkedList(reverseList(l1));
    }
}
