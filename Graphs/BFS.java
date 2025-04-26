package Graphs;
import java.util.*;

public class BFS {

    // making  new class having value Edge containing the source(starting) node annd destination(ending) node.
    public static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    // making of graph.
    public static void createGraph(ArrayList<Edge>[] graph){
        // we need to first change null values to empty arraylist of edges 
        // because without that compiler would not understand what we had initialized the graph with that is array of arraylist having edges as values.
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

    public static void bfsTraversal(ArrayList<Edge>[] graph , int v){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] traversed = new boolean[v];

        queue.add(0);

        // function for traversing over the graph and accessing its breadth nodes that is doing Breadth First Search.
        while(!queue.isEmpty()){
            int curr = queue.poll();
            if(traversed[curr] == false){
                traversed[curr] = true;
                System.out.print(curr+" ");
                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    queue.add(e.dest);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // initializing the array of arraylists having number of vertices stored while its initialization.
        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        bfsTraversal(graph,v);
    }
}
