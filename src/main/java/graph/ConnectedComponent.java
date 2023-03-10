package graph;

import java.util.*;

public class ConnectedComponent {

    Map<Integer, Set<Integer>> graph = new HashMap<>();

    public int countComponents(int n, int[][] edges) {

        buildGraph(n, edges);
        Set<Integer> isVisited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(!isVisited.contains(i)) {
                count++;
                DFS(i, graph, isVisited);
            }
        }
        return count;
    }

    private void buildGraph(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }

    public void DFS(int src, Map<Integer, Set<Integer>> graph, Set<Integer> isVisited) {
        if(isVisited.contains(src)) return;
        isVisited.add(src);
        for (int edge : graph.get(src)) {
            DFS(edge, graph, isVisited);
        }
    }

    public static void main(String[] args) {
        ConnectedComponent cc = new ConnectedComponent();
        // Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
       int n = 5;
       int[][] edges = {{0, 1}, {1, 2}};
//       int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(cc.countComponents(n, edges));
    }
}
