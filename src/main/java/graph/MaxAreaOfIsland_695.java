package graph;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland_695 {
    int[] dx = {-1,0,1,0};
    int[] dy = { 0,1,0, -1};
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] isVisited = new boolean[row][col];

        int maxArea = 0;

        for (int r = 0; r < row; r++ ) {
            for (int c = 0; c < col; c++ ) {
                if (grid[r][c] != 0 && !isVisited[r][c]) {
                    System.out.println("processing row: " + r + " col: " + c);
                    maxArea = Math.max(maxArea, bfs(grid, r, c, isVisited));
                }
            }
        }
        return maxArea;
    }

    public int bfs(int[][] grid, int r, int c, boolean[][] isVisited) {
        int area = 0;
        int row;
        int col;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r,c});
        while (!queue.isEmpty()) {
            area++;
            int[] rc = queue.poll();
            row = rc[0];
            col = rc[1];
            System.out.println("Will check neighbour row: " + row + "col: " + col);

            for (int i = 0; i < dx.length; i++) {
                int x = row + dx[i];
                int y = col + dy[i];
                if (canVisit(grid, x, y, isVisited)) {
                    isVisited[x][y] = true;
                    queue.add(new int[]{x,y});
                }
            }
        }
        return area;
    }

    private boolean canVisit(int[][] grid, int r, int c, boolean[][] isVisited) {
        int row = grid.length;
        int col = grid[0].length;
        return r >= 0 && r < row && c >= 0 && c < col && grid[r][c] == 1 && !isVisited[r][c];
    }

    public static void main(String[] args) {
//        int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int[][] grid = new int[][]{{0,1},{1,1}};
       // [[0,1],[1,1]]
        MaxAreaOfIsland_695 maxAreaOfIsland_695 = new MaxAreaOfIsland_695();
        System.out.println(maxAreaOfIsland_695.maxAreaOfIsland(grid));
    }
}