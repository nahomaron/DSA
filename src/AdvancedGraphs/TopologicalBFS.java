package AdvancedGraphs;

import java.util.*;

public class TopologicalBFS {
    public static List<Integer> topoSort(List<List<Integer>> graph, int n){
        int[] in_degree = new int[n];

        for(int i = 0; i < n; i++){
            for(int v : graph.get(i)){
                in_degree[v]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            if(in_degree[i] == 0){
                queue.offer(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();
        while(!queue.isEmpty()){
            int curr = queue.poll();
            topoOrder.add(curr);

            for(int v : graph.get(curr)){
                in_degree[v]--;
                if(in_degree[v] == 0){
                    queue.offer(v);
                }
            }
        }

        return topoOrder;
    }

    public static void main(String[] args) {
        int numVertices = 7;

        // Initialize the adjacency list to represent the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Add directed edges (u -> v means u must come before v)
        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);
        graph.get(6).add(5);

        // Run Kahn’s algorithm and print the result
        List<Integer> result = topoSort(graph, numVertices);
        System.out.println("Topological Sort (Kahn's BFS): " + result);
    }

}
