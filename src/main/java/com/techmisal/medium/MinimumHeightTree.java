package com.techmisal.medium;

import java.util.*;

public class MinimumHeightTree {
    private Integer vertices;
    private Integer[] degrees;
    private ArrayList<ArrayList<Integer>> adjacents = new ArrayList<>();

    private void addEdge(int[][] edges) {
        for (int[] edge : edges) {
            Integer v = edge[0];
            Integer w = edge[1];
            degrees[v]++;
            degrees[w]++;

            adjacents.get(v).add(w);
            adjacents.get(w).add(v);
        }
    }

    private void initSolution(int n) {
        vertices = n;
        degrees = new Integer[n];
        for (int x = 0; x < n; x++) {
            degrees[x] = 0;
            adjacents.add(new ArrayList<>());
        }
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        initSolution(n);
        addEdge(edges);

        LinkedList<Integer> queue = new LinkedList();
        for (int x = 0; x < vertices; x++){
            if (degrees[x] == 1){
                queue.add(x);
            }
        }

        while (vertices > 2) {
            vertices = vertices - queue.size();
            LinkedList<Integer> newQueue = new LinkedList<>();
            for(int l: queue) {
                int neighbor = adjacents.get(l).iterator().next();
                degrees[neighbor]--;
                if(degrees[neighbor] == 1)
                    newQueue.add(neighbor);

            }
            queue = newQueue;
        }

        return queue;

    }
}
