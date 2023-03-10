import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        if (k == 1) return matrix[0][0];
        int m = matrix.length;
        int n = matrix[0].length;
        System.out.println("row: " + m + "col: " + n);
        if (k == m*n) return matrix[m-1][n-1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(maxHeap.size() < k)
                    maxHeap.add(matrix[i][j]);
                else if (maxHeap.peek() > matrix[i][j] ){
                    maxHeap.poll();
                    maxHeap.add(matrix[i][j]);
                }
            }
        }
        return maxHeap.peek();
    }
}
