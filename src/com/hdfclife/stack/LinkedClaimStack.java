package com.hdfclife.stack;

import com.hdfclife.exception.StackEmptyException;

public class LinkedClaimStack
        implements ClaimStack {

    private static class Node {

        int value;

        Node next;

        Node(int value) {

            this.value = value;
        }
    }

    private Node top;

    @Override
    public void push(int value) {

        Node newNode =
                new Node(value);

        newNode.next = top;

        top = newNode;
    }

    @Override
    public int pop() {

        if (isEmpty()) {

            throw new StackEmptyException(
                    "Stack is empty"
            );
        }

        int value = top.value;

        top = top.next;

        return value;
    }

    @Override
    public int peek() {

        if (isEmpty()) {

            throw new StackEmptyException(
                    "Stack is empty"
            );
        }

        return top.value;
    }

    @Override
    public boolean isEmpty() {

        return top == null;
    }
}