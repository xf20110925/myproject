package com.xf.test.leetcode.easy.linkedlist;

import com.xf.test.leetcode.easy.linkedlist.AddTwoLinkList.ListNode;

/**
 * Created by xuefeng on 2019/2/27
 * <p>
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * <p>
 * Given linked list -- head = [4,5,1,9], which looks like following:
 * <p>
 * Example 1:
 * <p>
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 * Example 2:
 * <p>
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 * <p>
 * <p>
 * Note:
 * <p>
 * The linked list will have at least two elements.
 * All of the nodes' values will be unique.
 * The given node will not be the tail and it will always be a valid node of the linked list.
 * Do not return anything from your function.
 */
public class DeleteNodeFromLinkedList {

    public static ListNode deleteNode(ListNode node, ListNode deleteNode) {
        ListNode retNode = node;
        while (node != null) {
            if (node.val == deleteNode.val) {
                node.val = node.nextNode.val;
                node.nextNode = node.nextNode.nextNode;
            }
            node = node.nextNode;
        }
        return retNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1).setNextNode(new ListNode(2).setNextNode(new ListNode(3).setNextNode(new ListNode(4))));
        ListNode listNode = deleteNode(l1, new ListNode(2));
        AddTwoLinkList.printLinkedList(listNode);
    }
}
