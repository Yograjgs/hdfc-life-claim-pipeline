package com.hdfclife.stack;

import com.hdfclife.exception.StackEmptyException;
import com.hdfclife.exception.StackFullException;

public class ArrayClaimStack
        implements ClaimStack {

    private int[] stack;

    private int top = -1;

    public ArrayClaimStack() {

        stack = new int[32];
    }

    @Override
    public void push(int value) {

        if (top == stack.length - 1) {

            throw new StackFullException("Stack is full");
        }

        stack[++top] = value;
    }

    @Override
    public int pop() {

        if (isEmpty()) {
                throw new StackEmptyException("Stack is empty");
        }

        return stack[top--];
    }

    @Override
    public int peek() {

        if (isEmpty()) {

            throw new StackEmptyException("Stack is empty");
        }

        return stack[top];
    }

    @Override
    public boolean isEmpty() {

        return top == -1;
    }
}
