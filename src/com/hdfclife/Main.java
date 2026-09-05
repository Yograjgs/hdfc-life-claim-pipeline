package com.hdfclife;

import com.hdfclife.list.ClaimLinkedList;
import com.hdfclife.list.ClaimNode;
import com.hdfclife.list.CycleDetector;
import com.hdfclife.list.DigitListAdder;
import com.hdfclife.list.ListReverser;
import com.hdfclife.model.Claim;
import com.hdfclife.model.Urgency;
import com.hdfclife.queue.BranchBfs;
import com.hdfclife.queue.CircularClaimQueue;
import com.hdfclife.queue.ClaimPriorityDesk;
import com.hdfclife.stack.ArrayClaimStack;
import com.hdfclife.stack.ParenthesesChecker;
import com.hdfclife.stack.PostfixEvaluator;
import com.hdfclife.thread.ClaimTotalCallable;
import com.hdfclife.thread.ProducerConsumer;
import com.hdfclife.thread.SeedRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args)
            throws Exception {

        ClaimLinkedList seed =
                createSeed();

        System.out.print(
                "Seed list -> "
        );

        seed.print();

        ClaimLinkedList demo =
                seed.copy();

        demo.insertAt(
                2,
                22000
        );

        System.out.print(
                "After insertAt(2, 22000) -> "
        );

        demo.print();

        demo.deleteAt(2);

        System.out.print(
                "After deleteAt(2) -> "
        );

        demo.print();

        ClaimLinkedList iterative =
                seed.copy();

        ListReverser.reverseIterative(
                iterative
        );

        System.out.print(
                "Reverse iterative -> "
        );

        iterative.print();

        ClaimLinkedList recursive =
                seed.copy();

        ListReverser.reverseRecursive(
                recursive
        );

        System.out.print(
                "Reverse recursive -> "
        );

        recursive.print();

        ClaimNode middle =
                CycleDetector.findMiddle(
                        seed
                );

        System.out.println(
                "Middle of seed -> "
                        + middle.amount
        );

        System.out.println(
                "hasCycle on seed -> "
                        + CycleDetector.hasCycle(seed)
        );

        ClaimLinkedList cycleList =
                seed.copy();

        ClaimNode tail =
                cycleList.nodeAt(
                        cycleList.size() - 1
                );

        ClaimNode index2 =
                cycleList.nodeAt(2);

        tail.next = index2;

        System.out.println(
                "hasCycle after linking tail to index 2 -> "
                        + CycleDetector.hasCycle(cycleList)
        );

        ClaimNode cycleStart =
                CycleDetector.findCycleStart(cycleList);

        System.out.println(
                "Cycle start amount -> "
                        + cycleStart.amount
        );

        tail.next = null;

        ClaimLinkedList number1 =
                digitList(25000);

        ClaimLinkedList number2 =
                digitList(18000);

        ClaimLinkedList answer =
                DigitListAdder.add(number1, number2);

        System.out.print(
                "Add-two-numbers -> "
        );

        answer.print();

        System.out.println(
                "Balanced ((TERM)(ULIP)) -> "
                        + ParenthesesChecker
                        .isBalanced(
                                "((TERM)(ULIP))"
                        )
        );

        System.out.println(
                "Balanced ((TERM)(ULIP) -> "
                        + ParenthesesChecker
                        .isBalanced(
                                "((TERM)(ULIP)"
                        )
        );

        System.out.println(
                "Balanced ([)] -> "
                        + ParenthesesChecker
                        .isBalanced(
                                "([)]"
                        )
        );

        int postfix =
                PostfixEvaluator.evaluate(
                        "25000 18000 + 1000 -"
                );

        System.out.println(
                "Postfix 25000 18000 + 1000 - -> "
                        + postfix
        );

        CircularClaimQueue circular =
                new CircularClaimQueue(4);

        circular.enqueue(25000);

        circular.enqueue(18000);

        circular.enqueue(42000);

        System.out.println(
                "Circular dequeue() -> "
                        + circular.dequeue()
        );

        circular.enqueue(15000);

        circular.enqueue(31000);

        System.out.print(
                "Circular queue after wrap -> "
        );

        while (!circular.isEmpty()) {

            System.out.print(
                    circular.dequeue()
            );

            if (!circular.isEmpty()) {

                System.out.print(", ");
            }
        }

        System.out.println();

        List<String> bfs =
                BranchBfs.bfs();

        System.out.println(
                "BFS from MUMBAI -> "
                        + String.join(
                        ", ",
                        bfs
                )
        );

        List<Claim> claims =
                createClaims();

        List<String> ids =
                ClaimPriorityDesk.process(
                        claims
                );

        System.out.println(
                "PriorityQueue poll ids -> "
                        + String.join(
                        ", ",
                        ids
                )
        );

        Thread thread =
                new Thread(
                        new SeedRunnable()
                );

        System.out.println(
                "Thread state before start -> "
                        + thread.getState()
        );

        thread.start();

        thread.join();

        System.out.println(
                "Thread state after join -> "
                        + thread.getState()
        );

        ExecutorService executor =
                Executors.newFixedThreadPool(2);

        int[] amounts = {
                25000,
                18000,
                42000,
                15000,
                31000,
                9000
        };

        Future<Integer> future =
                executor.submit(
                        new ClaimTotalCallable(
                                amounts
                        )
                );

        System.out.println(
                "Callable Future.get() sum -> "
                        + future.get()
        );

        System.out.println(
                "isDone after get -> "
                        + future.isDone()
        );

        CompletableFuture<Integer> cf =
                CompletableFuture.supplyAsync(
                        () -> {

                            int total = 0;

                            for (int amount :
                                    amounts) {

                                total += amount;
                            }

                            return total;

                        },
                        executor
                );

        System.out.println(
                "CompletableFuture.supplyAsync sum -> "
                        + cf.get()
        );

        Future<Integer> longTask =
                executor.submit(
                        () -> {

                            Thread.sleep(30000);

                            return 140000;
                        }
                );

        longTask.cancel(true);

        System.out.println(
                "Cancelled future -> "
                        + longTask.isCancelled()
        );

        Thread daemon =
                new Thread(
                        () -> {
                        }
                );

        daemon.setDaemon(true);

        System.out.println(
                "Daemon flag -> "
                        + daemon.isDaemon()
        );

        List<Integer> consumed =
                ProducerConsumer.run();

        System.out.println(
                "Producer-consumer takes -> "
                        + consumed.get(0)
                        + ", "
                        + consumed.get(1)
                        + ", "
                        + consumed.get(2)
        );

        try {

            seed.copy().deleteAt(99);

        } catch (Exception e) {

            System.out.println(
                    "Caught message for invalid list index 99 -> "
                            + e.getMessage()
            );
        }

        try {

            ArrayClaimStack emptyStack =
                    new ArrayClaimStack();

            emptyStack.pop();

        } catch (Exception e) {

            System.out.println(
                    "Caught message for empty stack pop -> "
                            + e.getMessage()
            );
        }

        try {

            CircularClaimQueue emptyQueue =
                    new CircularClaimQueue(4);

            emptyQueue.dequeue();

        } catch (Exception e) {

            System.out.println(
                    "Caught message for empty queue dequeue -> "
                            + e.getMessage()
            );
        }

        executor.shutdown();
    }

    private static ClaimLinkedList createSeed() {

        ClaimLinkedList list =
                new ClaimLinkedList();

        list.addLast(25000);

        list.addLast(18000);

        list.addLast(42000);

        list.addLast(15000);

        list.addLast(31000);

        list.addLast(9000);

        return list;
    }

    private static ClaimLinkedList digitList(
            int number) {

        ClaimLinkedList list =
                new ClaimLinkedList();

        if (number == 0) {

            list.addLast(0);

            return list;
        }

        while (number > 0) {

            list.addLast(
                    number % 10
            );

            number =
                    number / 10;
        }

        return list;
    }

    private static List<Claim> createClaims() {

        List<Claim> claims =
                new ArrayList<>();

        claims.add(
                new Claim(
                        "CLM-01",
                        25000,
                        "HDFC-LIFE-1001",
                        "Anita Sharma",
                        Urgency.HIGH
                )
        );

        claims.add(
                new Claim(
                        "CLM-02",
                        18000,
                        "HDFC-LIFE-1002",
                        "Rahul Mehta",
                        Urgency.MEDIUM
                )
        );

        claims.add(
                new Claim(
                        "CLM-03",
                        42000,
                        "HDFC-LIFE-1005",
                        "Sneha Patel",
                        Urgency.HIGH
                )
        );

        claims.add(
                new Claim(
                        "CLM-04",
                        15000,
                        "HDFC-LIFE-1004",
                        "Vikram Singh",
                        Urgency.LOW
                )
        );

        claims.add(
                new Claim(
                        "CLM-05",
                        31000,
                        "HDFC-LIFE-1001",
                        "Anita Sharma",
                        Urgency.MEDIUM
                )
        );

        claims.add(
                new Claim(
                        "CLM-06",
                        9000,
                        "HDFC-LIFE-1003",
                        "Priya Nair",
                        Urgency.LOW
                )
        );

        return claims;
    }
}