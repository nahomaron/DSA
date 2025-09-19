package AdvancedGraphs;

/* Bellman-Ford algo (Finding shortest path)
  - best for directed graph and with one or more negative edges

  # how it works
  1. set initial distance of all Infinity except the source = 0
  2. for each edge update distance if shorter distance is found
  3. check all edges (v - 1) times

 */
import java.util.*;

public class Bellman_Ford {
    private static List<Edge> edges = new ArrayList<>();

    public Bellman_Ford(){
        edges = new ArrayList<>();
    }
    static class Edge{
        int src, des, weight;
        Edge(int src, int des, int weight){this.src = src; this.des = des; this.weight = weight;}
    }

    public static void addEdge(int src, int des, int weight){
        edges.add(new Edge(src, des, weight));
    }

    public static int[] bellmanFord(int n, int src){
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < n - 1; i++) {
            for(Edge edge : edges){
                if(dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.des]){
                    dist[edge.des] = dist[edge.src] + edge.weight;
                }
            }
        }

        for(Edge edge : edges){
            if(dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.des]){
                throw new IllegalStateException("Negative Cycle detected");
            }
        }

        return dist;
    }

    public static void main(String[] arg){
        addEdge(0, 1, -1);
        addEdge(0, 2, 4);
        addEdge(1, 2, 3);
        addEdge(1, 3, 2);
        addEdge(1, 4, 2);

        int[] result = bellmanFord(5, 1);

        for(int i = 0; i < result.length; i++){
            String dist = (result[i] == Integer.MAX_VALUE) ? "INF" : "" + result[i];
            System.out.println("from " + 0 + " to " +  i + " = " + dist);
        }
    }
}
