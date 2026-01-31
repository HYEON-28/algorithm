/* 
200. Number of Islands
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
*/

class Solution1 {
    boolean visited[][] = new boolean[300][300];
    int m, n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int islandsCnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '0') {
                    visited[i][j] = true;
                    continue;    
                } else if (grid[i][j] == '1') {
                    if(visited[i][j] == true) continue;
                    islandsCnt++;
                    visit(grid, i, j);
                }
            }
        }

        return islandsCnt;
    }

    public void visit(char[][] grid, int i, int j) {
        if(visited[i][j]) return;
        visited[i][j] = true;
        if(i <= m-2 && grid[i+1][j] == '1') visit(grid, i+1, j);
        if(j <= n-2 && grid[i][j+1] == '1') visit(grid, i, j+1);
        if(i >= 1 && grid[i-1][j] == '1') visit(grid, i-1, j);
        if(j >= 1 && grid[i][j-1] == '1') visit(grid, i, j-1);
    }
}

// 더 깔끔한 풀이
// 방문 처리를 '1'에서 '0'으로 바꾸는 방식으로 함
class Solution2 {
    int m, n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0'; // 방문 처리

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}