package com.hdfclife.thread;

public class SeedRunnable
        implements Runnable {

    @Override
    public void run() {

        int sum = 0;

        int[] values = {
                25000,
                18000,
                42000,
                15000,
                31000,
                9000
        };

        for (int value : values) {

            sum += value;
        }
    }
}