package Graphs.Starting_Again;

import java.util.*;

public class alien_dictionary {
    public static void main(String[] args) {
        String[] words1 = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(alienOrder(words1, words1.length, 4));
    }

    public static String alienOrder(String[] words, int n, int k) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }

            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    graph.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        List<Integer> order = topo_sort(graph, k);
        if (order.size() < k) return "";

        StringBuilder sb = new StringBuilder();
        for (int ch : order) {
            sb.append((char) (ch + 'a'));
        }

        return sb.toString();
    }

    public static List<Integer> topo_sort(ArrayList<ArrayList<Integer>> graph, int k) {
        int[] indegree = new int[k];
        for (int u = 0; u < k; u++) {
            for (int v : graph.get(u)) {
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            topo.add(u);
            for (int v : graph.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        return topo;
    }
}
