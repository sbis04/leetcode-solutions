package com.techmisal.medium;

import java.util.*;

public class MinimumHeightTree {
    private Integer[] degrees;
    private ArrayList<ArrayList<Integer>> adjacents = new ArrayList<>();
    private Integer vertices;

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
        LinkedList<Integer> result = new LinkedList();

        if (n == 1) {
            result.add(0);
            return result;
        }

        initSolution(n);
        addEdge(edges);


        for (int x = 0; x < vertices; x++) {
            if (degrees[x] == 1) {
                result.add(x);
            }
        }

        while (vertices > 2) {
            vertices = vertices - result.size();
            LinkedList<Integer> newQueue = new LinkedList<>();
            for (int first : result) {
                int neighbor = adjacents.get(first).iterator().next();
                degrees[neighbor]--;
                if (degrees[neighbor] == 1)
                    newQueue.add(neighbor);

            }
            result = newQueue;
        }

        return result;

    }
}
