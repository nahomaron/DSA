package AdvancedGraphs;

import java.util.List;
import java.util.PriorityQueue;

public class Prims_Lazy {
    static class Edge implements Comparable<Edge>{
        int to, weight;
        Edge(int to, int weight){this.to = to; this.weight = weight;}

        @Override
        public int compareTo(Edge other){
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static int prim(int n, List<List<Edge>> graph){
        boolean[] inMST = new boolean[n];
        PriorityQueue<Edge> minHeap = new PriorityQueue<>();

        inMST[0] = true;
        for(Edge e : graph.get(0)){
            minHeap.offer(e);
        }

        int mstWeight = 0;
        int edgesAdded = 0;

        while(!minHeap.isEmpty() && edgesAdded < n - 1){
            Edge curr = minHeap.poll();

            int v = curr.to;

            if(inMST[v]) continue;

            inMST[v] = true;
            mstWeight += curr.weight;

            edgesAdded++;

            for(Edge next : graph.get(v)){
                if(!inMST[next.to]){
                    minHeap.offer(next);
                }
            }
        }

        return mstWeight;
    }
}
