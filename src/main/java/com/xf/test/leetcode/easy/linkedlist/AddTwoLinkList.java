package com.xf.test.leetcode.easy.linkedlist;

/**
 * Created by xuefeng on 2019/2/22
 * <p>
 * 1->2->3->4 + 2->3->4 = 1->4->6->8，只能采用单向链表
 */
public class AddTwoLinkList {
    static class ListNode {
        int val;
        ListNode nextNode;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode nextNode) {
            this.val = val;
            this.nextNode = nextNode;
        }

        public ListNode setNextNode(ListNode nextNode) {
            this.nextNode = nextNode;
            return this;
        }
    }

    public static ListNode add(ListNode l1, ListNode l2) {
        int i1 = getLength(l1);
        int i2 = getLength(l2);
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        double sum = 0;
        while (tmp1 != null || tmp2 != null) {
            if (tmp1 != null) {
                sum += tmp1.val * Math.pow(10, i1);
                tmp1 = tmp1.nextNode;
                i1--;
            }
            if (tmp2 != null) {
                sum += tmp2.val * Math.pow(10, i2);
                tmp2 = tmp2.nextNode;
                i2--;
            }
        }
        String numStr = String.valueOf((int) sum);
        System.out.println(numStr);
        ListNode tmpNode = new ListNode();
        ListNode l3 = tmpNode;
        for (int i = 0; i < numStr.length(); i++) {
            tmpNode.val = numStr.charAt(i) - 48;
            if (i < numStr.length() - 1) {
                tmpNode.nextNode = new ListNode(0, null);
                tmpNode = tmpNode.nextNode;
            }
        }

        return l3;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode temp = sum;

        int i = 0;
        while (l1 != null || l2 != null || i != 0) {
            if (l1 == null) {
                l1 = new ListNode(0);
            }

            if (l2 == null) {
                l2 = new ListNode(0);
            }
            if (sum == null) {
                sum = new ListNode(0);
            }
            if (l1.val + l2.val + i < 10) {
                sum.nextNode = new ListNode(l1.val + l2.val + i);
                sum = sum.nextNode;
                i = 0;
            } else {
                sum.nextNode = new ListNode(l1.val + l2.val + i - 10);
                sum = sum.nextNode;
                i = 1;
            }
            l1 = l1.nextNode;
            l2 = l2.nextNode;
        }
        return temp.nextNode;
    }

    public static int getLength(ListNode listNode) {
        int i = 0;
        ListNode currentNode = listNode;
        while (currentNode.nextNode != null) {
            i++;
            currentNode = currentNode.nextNode;
        }
        return i;
    }

    public static void printLinkedList(ListNode listNode) {
        ListNode head = listNode;
        while (head != null) {
            System.out.println(head.val);
            head = head.nextNode;
        }

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1).setNextNode(new ListNode(2).setNextNode(new ListNode(3).setNextNode(new ListNode(4))));
        ListNode l2 = new ListNode(2).setNextNode(new ListNode(3).setNextNode(new ListNode(4)));
        ListNode l3 = add(l1, l2);
        printLinkedList(l3);
        l3 = addTwoNumbers(l1, l2);
        System.out.println("#####################");
        printLinkedList(l3);
    }
}
