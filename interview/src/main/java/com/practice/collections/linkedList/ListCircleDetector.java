package com.practice.collections.linkedList;


public class ListCircleDetector<V> {
    private Node root;
    private Node last;
    private int size = 0;

    public ListCircleDetector() {
    }

    /**
     * hasCircle check if linked list has cycle detection.
     * @param root node.
     * @return true if has cycle.
     */
    public boolean hasCircle(Node<V> root) {
        if (root == null || root.next == null) {
            return false;
        }
        Node slow = root;
        Node fast = root.next;
        while (fast != null && fast.next != null && slow != null) {
            if (slow == fast) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;

        }
        return false;
    }

    public static class Node<V> {
        private V value;
        private Node next;

        public Node(V value) {
            this.value = value;
        }

        public Node(V value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

    }
}
