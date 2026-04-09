import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 2 1 1
// 1 1 0
// 0 1 1
public class BFS1 {
    
    static int passedMinutes = 0;
    static int m, n;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) {
        // int[][] grid = {{2,1,1}, {1,1,0}, {0,1,1}};
        int[][] grid = {{0,2}};
        passedMinutes = 0;
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        while(!queue.isEmpty()) {

        }
        if(queue.size() > 0) {
            passOneMinute(grid);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    System.out.println(-1);
                }
            }
        }
        System.out.println(passedMinutes);
    }

    public static void passOneMinute(int[][] grid) {
        int queueCnt = queue.size();
        for (int k = 0; k < queueCnt; k++) {
            int[] target = queue.poll();
            rotAdjacentOranges(grid, target[0], target[1]);
        }

        if (queue.size() > 0) {
            passedMinutes++; // 새로썩은게 있는경우만 1분 추가
            passOneMinute(grid);
        }


    }

    public static void rotAdjacentOranges(int[][] grid, int i, int j) {
        if(i > 0 && grid[i-1][j] == 1) {
            grid[i-1][j] = 2;
            queue.offer(new int[] {i-1, j});
        }
        if(i + 1 < m && grid[i+1][j] == 1) {
            grid[i+1][j] = 2;
            queue.offer(new int[] {i+1, j});
        }
        if(j > 0 && grid[i][j-1] == 1) {
            grid[i][j-1] = 2;
            queue.offer(new int[] {i, j-1});
        }
        if(j + 1 < n && grid[i][j+1] == 1) {
            grid[i][j+1] = 2;
            queue.offer(new int[] {i, j+1});
        }
    }
}

// 개선점: BFS는 재귀보다는 큐 + while문 구조가 더 잘맞는다.