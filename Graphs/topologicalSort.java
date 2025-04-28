package Graphs;

import java.util.ArrayList;
import java.util.Stack;


public class topologicalSort {
    public static class Edge{
        int src;
        int dest;
        public Edge(int src , int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 0));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topSort(ArrayList<Edge>[] graph , boolean[] vis, int curr , Stack<Integer> stack){
        vis[curr] = true;
        for(int i=0; i < graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topSort(graph, vis, e.dest, stack);
            }
        }
        stack.push(curr);
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);

        boolean[] vis = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topSort(graph,vis,i,stack);
            }
        }

        // Printing the elements in dependency order by excluding all elements from the stack one at a time.
        while (!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
    }
}