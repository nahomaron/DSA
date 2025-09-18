package AdvancedGraphs;

import java.util.*;

/*
Algorithm steps
    1.Use a stack to store the current path.
    2.Use a list to store the final Eulerian path.
    3.Push start node into stack.
    4.While stack is not empty:
        * Look at the top of stack (u).
        * If u has outgoing edges left:
            - Choose an outgoing edge u → v.
            - Remove that edge from the graph.
            - Push v on stack.
        * Else (no edges left from u):
            - Pop u from stack and add it to the result path.
    5. At the end, the result list will be in reverse order, so reverse it.
 */
public class Hierholzer {

    public static List<Integer> findEulerianPath(List<int[]> edges){
        Map<Integer, Deque<Integer>> graph = new HashMap<>();

        for(int[] e : edges){
            int from = e[0], to = e[1];
            graph.computeIfAbsent(from, k -> new ArrayDeque<>()).add(to);
        }

        int start = edges.getFirst()[0];

        Map<Integer, Integer> ins = new HashMap<>(), outs = new HashMap<>();

        for(int[] e : edges){
            outs.put(e[0], outs.getOrDefault(e[0], 0) + 1);
            ins.put(e[1], ins.getOrDefault(e[1], 0) + 1);
        }

        for(int v : outs.keySet()){
            if(outs.get(v) - ins.getOrDefault(v, 0) == 1){
                start = v;
                break;
            }
        }

        Stack<Integer> stack = new Stack<>();
        List<Integer> path = new ArrayList<>();

        stack.push(start);

        while(!stack.isEmpty()){
            int u = stack.peek();

            if(graph.containsKey(u) && !graph.get(u).isEmpty()){
                int v = graph.get(u).poll();
                stack.push(v);
            }else{
                path.add(stack.pop());
            }
        }

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        List<int[]> edges = Arrays.asList(
                new int[]{0,1}, new int[]{1,2}, new int[]{2,0}, new int[]{0,3}, new int[]{3,4}
        );
        System.out.println(findEulerianPath(edges));
    }
}
