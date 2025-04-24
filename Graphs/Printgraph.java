package Graphs;

import java.util.ArrayList;

public class Printgraph {

    public static class Edge{
        int src;
        int dest;

        public Edge(int src , int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static class Edge1{
        int src;
        int dest;
        // adding weights to the graphs.
        int wt;

        // for weighted undirected graphs.
        public Edge1(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 4;

        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        printGraph(graph);

        ArrayList<Edge1> graph1[] = new ArrayList[v];
        createGraph1(graph1);
        printGraph1(graph1);
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
    }

    public static void printGraph(ArrayList<Edge> graph[]){
        System.out.println("\nfor unweighted graphs");
        // for printing the unweighted undirectional graphs.
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Node " + i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print(e.dest + " ");
            }
            System.out.println();
        }
    }


    public static void createGraph1(ArrayList<Edge1> graph1[]){
        for(int i=0;i<graph1.length;i++){
            graph1[i] = new ArrayList<Edge1>();
        }
        // displaying the weighted graphs nodes with their weights.
        graph1[0].add(new Edge1(0, 2,2));

        graph1[1].add(new Edge1(1, 2, 10));
        graph1[1].add(new Edge1(1, 3,0));

        graph1[2].add(new Edge1(2, 0,2));
        graph1[2].add(new Edge1(2, 1, 10));
        graph1[2].add(new Edge1(2, 3, -1));

        graph1[3].add(new Edge1(3, 1,0));
        graph1[3].add(new Edge1(3, 2, -1));
    }

    public static void printGraph1(ArrayList<Edge1> graph1[]){
        System.out.println("\nfor weighted graphs");

        // for printing the weighted undirectional graphs.
        for (int i = 0; i < graph1.length; i++) {
            System.out.print("Node " + i + " -> ");
            for (Edge1 e : graph1[i]) {
                System.out.print("("+e.dest + " , "+e.wt+") " );
            }
            System.out.println();
        }
    }
}
