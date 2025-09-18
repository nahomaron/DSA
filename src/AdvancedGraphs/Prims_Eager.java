package AdvancedGraphs;

import java.util.*;

public class Prims_Eager {
    static class Edge{
        int to, weight;
        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node>{
        int parent, v, key;
        Node(int parent, int v, int key){
            this.parent = parent;
            this.v = v;
            this.key = key;
        }

        @Override
        public int compareTo(Node n){
            return Integer.compare(this.key, n.key);
        }
    }

    static class MSTResult{
        List<int[]> edges;
        int totalWeight;
        MSTResult(List<int[]> edges, int totalWeight){
            this.edges = edges;
            this.totalWeight = totalWeight;
        }
    }

    public static MSTResult prim(int n, List<Edge>[] edges){
        boolean[] inMST = new boolean[n];
        int[] parent = new int[n];
        int[] key = new int[n];

        Arrays.fill(parent, -1);
        Arrays.fill(key, Integer.MAX_VALUE);

        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        key[0] = 0;
        minHeap.offer(new Node(-1, 0, 0));

        while(!minHeap.isEmpty()){
            Node curr = minHeap.poll();
            int vertex = curr.v;

            if(inMST[vertex]) continue;

            inMST[vertex] = true;
            parent[vertex] = curr.parent;

            for(Edge e : edges[vertex]){
                int to = e.to, w = e.weight;

                if(!inMST[to] && w < key[to]){
                    key[to] = w;
                    minHeap.offer(new Node(vertex, to, key[to]));
                }
            }
        }

        List<int[]> mstEdges = new ArrayList<>();
        int totalW = 0;
        for(int v = 0; v < n; v++){
            if(parent[v] != -1){
                mstEdges.add(new int[]{parent[v], v, key[v]});
                totalW += key[v];
            }
        }

        return new MSTResult(mstEdges, totalW);
    }

    static void addUndirectedEdge(List<Edge>[] g, int u, int v, int w) {
        g[u].add(new Edge(v, w));
        g[v].add(new Edge(u, w));
    }

    // Example usage
    public static void main(String[] args) {
        // build a sample graph with 5 vertices (0..4)
        int n = 5;
        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        // add undirected weighted edges
        addUndirectedEdge(graph, 0, 1, 2);
        addUndirectedEdge(graph, 0, 3, 6);
        addUndirectedEdge(graph, 1, 3, 8);
        addUndirectedEdge(graph, 1, 2, 3);
        addUndirectedEdge(graph, 1, 4, 5);
        addUndirectedEdge(graph, 2, 4, 7);
        addUndirectedEdge(graph, 3, 4, 9);

        // run Prim
        MSTResult res = prim(n, graph);

        // print result
        System.out.println("MST edges (u - v : weight):");
        for (int[] e : res.edges) {
            System.out.printf("%d - %d : %d%n", e[0], e[1], e[2]);
        }
        System.out.println("Total MST weight = " + res.totalWeight);
    }
}
