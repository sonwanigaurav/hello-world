package graph;

import java.util.*;

public class UnionFind {
    // Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
    int[] parent;

    public UnionFind(int noOfNodes) {
        this.parent = new int[noOfNodes];
        Arrays.fill(parent, -1);
    }

    public boolean Union(int src, int dest) {
        return true;
    }

    // finds parent
    public boolean find(int src, int dest) {
        if(src == dest) return true;
       int parent = dest;
        while (this.parent[parent] != -1) {
            parent = this.parent[parent];
        }
        this.parent[dest] = src;
        return true;
    }

    public static void main(String[] args) {
        // Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
        int n = 5;
        UnionFind cc = new UnionFind(n);

    }
}
