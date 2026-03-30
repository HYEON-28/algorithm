import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 2 1 1
// 1 1 0
// 0 1 1

// 0: 빈 곳
// 1: 신선한 오렌지
// 2: 썩은 오렌지
// 몇분 지나야 모두 썩은오렌지가 되나?
// 모두 썩은오렌지가 될수없다면 -1

/* 슈도코드
int passedMinute = 0; // 경과한 분 수
int freshCnt = 0; // 신선한 오렌지 개수 세기
freshCnt < 1 -> 0 리턴

Q에 썩은오렌지 넣음
while(!Q.isEmpty()) {
    int len = q 길이
    for (q길이만큼 반복) {
        상하좌우 확인하며 1인경우 
            2로바꿈, freshCnt--, Quque에 넣음
    }
    passedMinute++;
}
freshCnt ==0 -> passedMinute 리턴
frechCnt !=0 -> -1 리턴
*/
/* 
    시간복잡도: O(N*M)
    모든 칸을 최소 한번은 봐야 함
 */
class Solution {
    public int orangesRotting(int[][] grid) {
        int passedMinute = 0;
        int freshCnt = 0;
        int maxR = grid.length;
        int maxC = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();

        // 신선한 오렌지 개수 셈, 썩은오렌지는 Q로
        for (int i = 0; i < maxR; i++) {
            for (int j = 0; j < maxC; j++) {
                if(grid[i][j] == 1) {
                    freshCnt++;
                }
                if(grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        if(freshCnt == 0) return 0;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!q.isEmpty()) { // && freshCnt > 0 좋은 풀이
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] point = q.poll();
                // 4방향 확인 후 1인경우 2로 바꿈, q에 넣기
                for(int[] d : dirs) {
                    int r = point[0] + d[0];
                    int c = point[1] + d[1];

                    if(r >=0 && r < maxR && c >= 0 && c <maxC && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        freshCnt--;
                        q.offer(new int[] {r, c});
                    }    
                }
            }
            passedMinute++;
            if(freshCnt == 0) break; // 이걸 
        }

        if(freshCnt == 0) return passedMinute;
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};

        Solution solution = new Solution();
        int result = solution.orangesRotting(grid);
        System.err.println("result: "+ result);
    }
}

/* 과거 풀이
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

*/
