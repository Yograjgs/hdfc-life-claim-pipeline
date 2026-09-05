package com.hdfclife.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BranchBfs {

    public static List<String> bfs() {

        String[] branches = {"MUMBAI","PUNE","DELHI","HYDERABAD","KOLKATA","CHENNAI"};

        int[][] graph = {{1, 2},{3},{4},{5},{},{}};

        boolean[] visited =
                new boolean[branches.length];

        Queue<Integer> queue =
                new LinkedList<>();

        List<String> result =
                new ArrayList<>();

        queue.offer(0);

        visited[0] = true;

        while (!queue.isEmpty()) {

            int current =
                    queue.poll();

            result.add(branches[current]
             );

            for (int neighbour :graph[current]) {

                if (!visited[neighbour]) {

                    visited[neighbour] = true;

                    queue.offer(neighbour);
                }
            }
        }

        return result;
    }
}
