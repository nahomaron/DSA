package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class WeightedAndDirectedGraph {
    private int[][] adjMatrix;
    private char[] vertexData;
    private int size;

    public WeightedAndDirectedGraph(int size){
        this.size = size;
        this.adjMatrix = new int[size][size];
        this.vertexData = new char[size];
    }

    public void addEdge(int u, int v, int weight){
        if(u >= 0 && u < size && v >= 0 && v < size){
            adjMatrix[u][v] = weight;
        }
    }

    public void addVertexData(int vertex, char data){
        if(vertex >= 0 && vertex < size){
            vertexData[vertex] = data;
        }
    }

    public void printGraph(){
        for(int i = 0; i < size; i++){
            System.out.print("Vertex " + vertexData[i] + ":  ");
            for(int j = 0; j < size; j++){
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void dfs(char startVertexData){
        boolean[] visited = new boolean[size];
        int startVertex = new String(vertexData).indexOf(startVertexData);
        dfsUtil(startVertex, visited);
    }

    public void dfsUtil(int v, boolean[] visited){
        visited[v] = true;

        System.out.print(vertexData[v] + " ");

        for(int i = 0; i < size; i++){
            if(adjMatrix[v][i] != 0 && !visited[i]){
                dfsUtil(i, visited);
            }
        }
    }

    public void bfs(char startVertexData){
        boolean[] visited = new boolean[size];
        Queue<Integer> queue = new LinkedList<>();

        int startIndex = new String(vertexData).indexOf(startVertexData);
        queue.offer(startIndex);
        visited[startIndex] = true;

        while(!queue.isEmpty()){
            int currentVertex = queue.poll();

            System.out.print(vertexData[currentVertex] + " ");

            for(int i = 0; i < size; i++){
                if(adjMatrix[currentVertex][i] != 0 && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public boolean isCyclic(){
        boolean[] visited = new boolean[size];
        boolean[] recStack = new boolean[size];

        for(int i = 0; i < size; i++){
            if(!visited[i]){
                if(checkCycleDFS(i, visited, recStack)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkCycleDFS(int v, boolean[] visited, boolean[] recStack){
        visited[v] = true;
        recStack[v] = true;

        for(int i = 0; i < size; i++){
            if(adjMatrix[v][i] != 0){
                if(!visited[i]){
                    if(checkCycleDFS(i, visited, recStack)){
                        return true;
                    }
                }else{
                    if(recStack[i]){
                        return true;
                    }
                }
            }
        }

        recStack[v] = false;
        return false;
    }

    public static void main(String[] args){
        WeightedAndDirectedGraph g = new WeightedAndDirectedGraph(7);
        g.addVertexData(0, 'A');
        g.addVertexData(1, 'B');
        g.addVertexData(2, 'C');
        g.addVertexData(3, 'D');
        g.addVertexData(4, 'E');
        g.addVertexData(5, 'F');
        g.addVertexData(6, 'G');

        g.addEdge(3, 4, 8); // D -> E
        g.addEdge(3, 0, 5); // D -> A
        g.addEdge(4, 0, 4); // E -> A
        g.addEdge(0, 2, 2); // A -> C
        g.addEdge(2, 5, 9); // C -> F
        g.addEdge(2, 6, 3); // C -> G
        g.addEdge(5, 1, 1); // F -> B
        g.addEdge(1, 2, 10); // B -> C
        g.printGraph();

        System.out.println("\nDFS traversal");
        g.dfs('D');

        System.out.println("\nBFS traversal");
        g.bfs('D');

        System.out.println("\nIs cyclic: " + g.isCyclic());
    }
}
