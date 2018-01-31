package com.xf.test.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xuefeng on 2018-1-12.
 * Merge two sorted linked lists and return it as a new list.The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * 翻译:
 * 合并2个已经排序的链表，并且返回一个新的链表。这个新的链表应该由前面提到的2个链表的节点所组成。
 * https://leetcode.com/problems/merge-two-sorted-lists/solution/
 */
public class MergeTwoSortList {

    public static List<Integer> merge1(LinkedList<Integer> sortList1, LinkedList<Integer> sortList2) {
        List<Integer> mergeSortedList = new ArrayList<>();
        Integer i1 = sortList1.pollFirst();
        Integer i2 = sortList2.pollFirst();
        while (i1 != null || i2 != null) {
            if (i2 == null) {
                mergeSortedList.add(i1);
                i1 = sortList1.pollFirst();
            } else if (i1 == null) {
                mergeSortedList.add(i2);
                i2 = sortList2.pollFirst();
            } else if (i1 == i2) {
                mergeSortedList.add(i1);
                mergeSortedList.add(i2);
                i1 = sortList1.pollFirst();
                i2 = sortList2.pollFirst();
            } else if (i2 < i1) {
                mergeSortedList.add(i2);
                i2 = sortList2.pollFirst();
            } else if (i1 < i2) {
                mergeSortedList.add(i1);
                i1 = sortList1.pollFirst();
            }
        }
        return mergeSortedList;
    }

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //递归
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        //防止漏掉数据 l1或者l2不为空，把数据追加到最后
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    public static void main(String[] args) {
        final List<Integer> merge = merge1(new LinkedList<Integer>(Arrays.asList(1, 2, 5, 11, 22, 33)), new LinkedList<Integer>(Arrays.asList(10, 12, 25, 33, 42)));
        System.out.println(merge);
        final MergeTwoSortList mergeTwoSortList = new MergeTwoSortList();

        System.out.println("***********method2*************");
        final ListNode l1 = new ListNode(1);
        l1.next = new ListNode(10);
        final ListNode l2 = new ListNode(2);
        l2.next = new ListNode(8);
        l2.next.next = new ListNode(9);
//        ListNode listNode = mergeTwoSortList.mergeTwoLists1(l1, l2);
//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
        System.out.println("***********method3*************");
        ListNode ret = mergeTwoSortList.mergeTwoLists2(l1, l2);
        while (ret != null) {
            System.out.println(ret.val);
            ret = ret.next;
        }


    }
}
