package Graphs.Starting_Again;
import java.util.*;

public class topologicalSort {

    public static class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(02, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }
    
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<V;i++){
            if(!vis[i]) topoSort(graph, vis, st, i);
        }

        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
    }

    public static void topoSort(ArrayList<Edge>[] graph, boolean[] vis, Stack<Integer> st, int curr) {
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) topoSort(graph, vis, st, e.dest);
        }
        st.push(curr);
    }
}
