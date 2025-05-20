package Graphs.Apna_College;
import java.util.*;
public class allPathsFromSRCtoDEST {

    public static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

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

    // modified dfs code for the path finding.
    // in this we want to print all the paths and in order to do that we need to traverse for each paths which exists.
    // here we created boolean visited array and we mark it true to make sure that one node does not prints twice or stuck in a loop
    // and after the nodes are called again and same process is done then it does not prints same path again.
    // then after that we mark the path again false.
    public static void pathFinding(ArrayList<Edge>[] graph,boolean[] vis,int curr, int end, String res){
        if(curr == end){
            System.out.println(res);
            return;
        }

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            
            if(vis[e.dest] == false){
                vis[curr] = true;
                pathFinding(graph, vis, e.dest, end, res+e.dest);
                vis[curr] = false;
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        int st = 0,tar = 5;
        pathFinding(graph ,new boolean[v],st, tar, "0");
    }
}
