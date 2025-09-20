package AdvancedGraphs;

import java.util.Collections;
import java.util.List;

/* Kruskal algorithm (Finding Minimum spanning tree)
   - it add edges to MST starting from the lowest weighted edge
   - Edges that would create cycles are not added

   How it works
   1. sort edges in graph from lowest to highest based on edge weight
   2. starting from the lowest edge:
        a. check if it doesn't create cycle (using DSU/ union-find algo)
           - add it as long as added vertices are n - 1
 */

public class Kruskal {
    static class Edge implements Comparable<Edge>{
        int from, to, weight;
        Edge(int from, int to, int weight){
            this.from = from; this.to = to; this.weight = weight;
        }

        // make it comparable based on edge weight
        @Override
        public int compareTo(Edge other){
            return Integer.compare(this.weight, other.weight);
        }
    }

    // Disjoint Set Union (DSU) / union-find
    public static class DSU{
        int[] parent;
        int[] rank;
        int size;

        DSU(int size){
            parent = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]); // -> path compression
            }
            return parent[x];
        }
        // the method union is optimized using ranks
        public boolean union(int x, int y){
            int fx = find(x), fy = find(y);

            if(fx == fy) return false;

            if(rank[fx] < rank[fy]){
                parent[fx] = fy;
            }else if(rank[fy] < rank[fx]){
                parent[fy] = fx;
            }else{
                parent[fy] = fx;
                rank[fx]++;
            }
            return true;
        }
    }

    public int kruskalMST(int n, List<Edge> edges){
        Collections.sort(edges); // sort the comparable class "Edge"
        int mstWeight = 0;
        int edgesUsed = 0;

        DSU dsu = new DSU(n);
        for (Edge e : edges){
            if(dsu.union(e.from, e.to)){
                mstWeight += e.weight; // every added edge's weight is summed up to the total tree weight
                edgesUsed++;

                if(edgesUsed == n - 1) break; // -> if finding Minimum spanning forest, don't break here!
            }
        }

        return mstWeight;
    }
}
