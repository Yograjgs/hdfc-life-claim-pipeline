package com.hdfclife.list;

public class ListReverser {

    public static void reverseIterative(
            ClaimLinkedList list) {

        ClaimNode previous = null;

        ClaimNode current = list.getHead();

        while (current != null) {

            ClaimNode next = current.next;

            current.next = previous;

            previous = current;

            current = next;
        }

        list.setHead(previous);
    }

    public static void reverseRecursive(
            ClaimLinkedList list) {

        list.setHead(
                reverse(list.getHead())
        );
    }

    private static ClaimNode reverse(
            ClaimNode node) {

        if (node == null || node.next == null) {
            return node;
        }

        ClaimNode newHead =
                reverse(node.next);

        node.next.next = node;

        node.next = null;

        return newHead;
    }
}