package com.hdfclife.list;

import com.hdfclife.exception.EmptyListException;
import com.hdfclife.exception.InvalidIndexException;

public class ClaimLinkedList {

    private ClaimNode head;

    public ClaimNode getHead() {
        return head;
    }

    public void setHead(ClaimNode head) {
        this.head = head;
    }

    public void addLast(int amount) {

        ClaimNode newNode = new ClaimNode(amount);

        if (head == null) {
            head = newNode;
            return;
        }

        ClaimNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void addFirst(int amount) {

        ClaimNode newNode = new ClaimNode(amount);

        newNode.next = head;
        head = newNode;
    }

    public void insertAt(int index, int amount) {

        if (index < 0 || index > size()) {
            throw new InvalidIndexException(
                    "Invalid list index " + index
            );
        }

        if (index == 0) {
            addFirst(amount);
            return;
        }

        ClaimNode current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        ClaimNode newNode = new ClaimNode(amount);

        newNode.next = current.next;
        current.next = newNode;
    }

    public int deleteAt(int index) {

        if (head == null) {
            throw new EmptyListException("List is empty");
        }

        if (index < 0 || index >= size()) {
            throw new InvalidIndexException(
                    "Invalid list index " + index
            );
        }

        if (index == 0) {

            int value = head.amount;

            head = head.next;

            return value;
        }

        ClaimNode current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        int value = current.next.amount;

        current.next = current.next.next;

        return value;
    }

    public ClaimNode nodeAt(int index) {

        if (index < 0 || index >= size()) {
            throw new InvalidIndexException(
                    "Invalid list index " + index
            );
        }

        ClaimNode current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    public int size() {

        int count = 0;

        ClaimNode current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    public int[] toArray() {

        int[] arr = new int[size()];

        ClaimNode current = head;

        int index = 0;

        while (current != null) {

            arr[index++] = current.amount;

            current = current.next;
        }

        return arr;
    }

    public void print() {

        ClaimNode current = head;

        while (current != null) {

            System.out.print(current.amount);

            if (current.next != null) {
                System.out.print(", ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public ClaimLinkedList copy() {

        ClaimLinkedList copy =
                new ClaimLinkedList();

        ClaimNode current = head;

        while (current != null) {

            copy.addLast(current.amount);

            current = current.next;
        }

        return copy;
    }
}