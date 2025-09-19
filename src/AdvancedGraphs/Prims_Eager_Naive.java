package AdvancedGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prims_Eager_Naive {
    static class MSTResult{
        List<int[]> edges;
        int totalWeight;
        MSTResult(List<int[]> edges, int totalWeight){
            this.edges = edges;
            this.totalWeight = totalWeight;
        }
    }

    public static MSTResult primMST(int[][] graph, int n){
       boolean[] inMST = new boolean[n];
       int[] parent = new int[n];
       int[] key = new int[n];

       Arrays.fill(parent, -1);
       Arrays.fill(key, Integer.MAX_VALUE);

       key[0] = 0;

       for(int count = 0; count < n - 1; count++){

           int u = -1, min = Integer.MAX_VALUE;
           for(int v = 0; v < n; v++){
               if(!inMST[v] && key[v] < min){
                   min = key[v];
                   u = v;
               }
           }


           inMST[u] = true;

           for (int v = 0; v < n; v++) {
               if(graph[u][v] != Integer.MAX_VALUE && !inMST[v] && graph[u][v] < key[v]){
                   key[v] = graph[u][v];
                   parent[v] = u;
               }
           }
       }


        List<int[]> mstResult = new ArrayList<>();
        int total = 0;
        for(int v = 0; v < n; v++){
            if(parent[v] != -1){
                mstResult.add(new int[]{parent[v], v, key[v]});
                total+= key[v];

            }
        }

        return new MSTResult(mstResult, total);
    }

    public static void main(String[] args){
        int INF = Integer.MAX_VALUE;

        int[][] graph = {
                //  0    1    2    3    4
                {  0,   2,  INF,  6,  INF }, // 0
                {  2,   0,   3,   8,   5  }, // 1
                { INF,  3,   0,  INF,  7  }, // 2
                {  6,   8,  INF,  0,  INF }, // 3
                { INF,  5,   7,  INF,  0  }  // 4
        };

        MSTResult result = primMST(graph, graph.length);

        System.out.println("total weight: " + result.totalWeight);
        for(int[] r : result.edges){
            System.out.println(r[0] + " - " + r[1] + " = " + r[2]);
        }
    }


}
