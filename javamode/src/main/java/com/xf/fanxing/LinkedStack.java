package com.xf.fanxing;

/**
 * Created by xuefeng on 2017-11-7.
 */
public class LinkedStack<T> {
    static class Node<U> {
        U item;
        Node<U> next;

        public Node() {
            item = null;
            next = null;
        }

        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        public U getItem() {
            return item;
        }

        public void setItem(U item) {
            this.item = item;
        }

        public Node<U> getNext() {
            return next;
        }

        public void setNext(Node<U> next) {
            this.next = next;
        }
    }

    Node<T> top = new Node<>();

    public void push(T item) {
        top = new Node<>(item, top);
    }

    public T pop() {
        Node<T> firstNode = top;
        top = top.next;
        return firstNode.getItem();
    }

    public boolean isEnd() {
        if (top.getNext() == null && top.getItem() == null)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        final LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while (!stack.isEnd()){
            System.out.println(stack.pop());
        }
    }
}
