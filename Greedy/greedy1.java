// 오름차순 정렬: Arrays.sort(arr);
import java.util.Arrays;

public class greedy1 {
    public static void main(String[] args) {
        int[] g = {5,3,4,1,2};
        int[] s = {5, 3, 2, 6};
        int result = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int sPointer = s.length - 1;
        for (int i = g.length - 1; i >= 0 && sPointer >= 0; i--) {
            if (s[sPointer] >= g[i]) {
                result++;
                sPointer--;
            }
        }

        System.out.println(result);
    }
    
}
