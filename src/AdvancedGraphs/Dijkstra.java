package AdvancedGraphs;

import java.util.*;

class Dijkstra{
    static class Edge{
        int to, weight;
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    public static int[] dijkstra(int n, List<List<Edge>> graph, int source){
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, source});

        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int d = curr[0], node = curr[1];

            if(d > dist[node]) continue;

            for(Edge edge : graph.get(node)){
                int to = edge.to, weight = edge.weight;

                if(weight + dist[node] < dist[to]){
                    dist[to] = weight + dist[node];
                    minHeap.offer(new int[]{dist[to], to});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // Example edges
        graph.get(0).add(new Edge(1, 2));
        graph.get(0).add(new Edge(2, 4));
        graph.get(1).add(new Edge(2, 1));
        graph.get(1).add(new Edge(3, 7));
        graph.get(2).add(new Edge(4, 3));
        graph.get(3).add(new Edge(4, 1));

        int[] dist = dijkstra(n, graph, 0);

        System.out.println("Shortest distances from node 0:");
        for (int i = 0; i < n; i++) {
            System.out.println("To " + i + " = " + dist[i]);
        }
    }
}