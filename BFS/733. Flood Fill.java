import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

// 이미지에서 특정 색을 찍어서 인접한 모든 같은색들을 새로운 색으로 바꿈.
// 인접한 같은색들 -> 큐에 넣기

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new ArrayDeque<>();
        int targetColor = image[sr][sc];
        if(targetColor == color) return image; // 현재색과 바꾸는 색이 같은 경우 > 무한루프 발생 가능

        int rowCnt = image.length;
        int colCnt = image[0].length;

        q.offer(new int[] {sr, sc});

        while(q.size() > 0) {
            int[] point = q.poll();
            int rowP = point[0];
            int colP = point[1];
            image[rowP][colP] = color;
            if(rowP - 1 >= 0 && image[rowP - 1][colP] == targetColor) q.offer(new int[] {rowP-1, colP});
            if(rowP + 1 < rowCnt && image[rowP + 1][colP] == targetColor) q.offer(new int[] {rowP+1, colP});
            if(colP - 1 >= 0 && image[rowP][colP - 1] == targetColor) q.offer(new int[] {rowP, colP-1});
            if(colP + 1 < colCnt && image[rowP][colP+1] == targetColor) q.offer(new int[] {rowP, colP+1});
        }

        return image;
    }
}

// image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2 을 넣어서 floodFill 실행시키기

class Main {
    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, color = 2;

        Solution solution = new Solution();
        int[][] result = solution.floodFill(image, sr, sc, color);

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}

class Solution2 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int targetColor = image[sr][sc];
        if (targetColor == color) return image;

        int rowCnt = image.length;
        int colCnt = image[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        // 방향 벡터 (상, 하, 좌, 우)
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            // 이미 색이 바뀌었다면 skip (중복 방지)
            if (image[r][c] != targetColor) continue;

            image[r][c] = color;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < rowCnt && nc >= 0 && nc < colCnt 
                    && image[nr][nc] == targetColor) {
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return image;
    }
}