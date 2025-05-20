package Graphs.Apna_College;
import java.util.*;
public class DFS {

    // creation of the Edge class.
    public static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    // create graph function same as always.
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }
    
    // function for DFS Traversal on graph which is based on recursive loops.
    public static void dfs(ArrayList<Edge>[] graph , int curr , boolean[] vis){
        vis[curr] = true;
        System.out.print(curr+" ");


        // for every node we will check whether it's been traversed and if not then call the function again with that node as current index.
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest] == false)
                dfs(graph, e.dest, vis);
        }
    }

    // main function having the graph initialized and making of it, having the visited boolean array to keep count of how many nodes been visited
    // then calling of the vertices one taken as source node or make a loop to iterate over all the vertices if all vertices are not connected and
    // some of them are broken aka "Disconnected Components."

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        boolean[] vis = new boolean[v];
        boolean[] vis2 = new boolean[v];

        // for disconnected components if present in graph.
        for(int i=0;i<v;i++){
            if(vis[i] == false){
                dfs(graph, i, vis);
            }
        }
        System.out.println();

        // for simple connected graphs in which no nodes are disconnnected.
        dfs(graph,0,vis2);
    }
}
