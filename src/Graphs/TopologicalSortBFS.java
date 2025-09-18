package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortBFS {

    static List<Integer> topologicalSortBFS(List<List<Integer>> graph, int numVertexes){
       int[] indegree = new int[numVertexes];

        for (int i = 0; i < graph.size(); i++) {
            for(int v : graph.get(i)){
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numVertexes; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            topoOrder.add(node);

            for(int v : graph.get(node)){
                indegree[v]--;

                if(indegree[v] == 0){
                    q.offer(v);
                }
            }
        }

        if(topoOrder.size() != numVertexes) throw new RuntimeException("Cycle detected");

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
        List<Integer> result = topologicalSortBFS(graph, numVertices);
        System.out.println("Topological Sort (Kahn's BFS): " + result);
    }

}