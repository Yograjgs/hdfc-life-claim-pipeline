package com.hdfclife.queue;

import com.hdfclife.exception.QueueEmptyException;
import com.hdfclife.exception.QueueFullException;

public class CircularClaimQueue {

    private int[] queue;

    private int front = 0;

    private int rear = 0;

    private int size = 0;

    public CircularClaimQueue(
            int capacity) {

        queue = new int[capacity];
    }

    public void enqueue(int value) {

        if (size == queue.length) {

            throw new QueueFullException(
                    "Queue is full"
            );
        }

        queue[rear] = value;

        rear =
                (rear + 1) %
                        queue.length;

        size++;
    }

    public int dequeue() {

        if (size == 0) {

            throw new QueueEmptyException(
                    "Queue is empty"
            );
        }

        int value = queue[front];

        front =
                (front + 1) %
                        queue.length;

        size--;

        return value;
    }

    public boolean isEmpty() {

        return size == 0;
    }

    public int size() {

        return size;
    }
}