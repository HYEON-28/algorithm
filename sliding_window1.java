import java.util.HashSet;
import java.util.Set;
public class sliding_window1 {
    public static void main(String[] args) {
        String input = "abcabcbb";
        Set<Character> used = new HashSet<Character>();

        int left = 0;
        int right = 0;
        int maxLength = 0;

        for (; right < input.length(); right++) {
            char c = input.charAt(right);
            if(used.contains(c)) {
                while(left < right) {
                    char leftChar = input.charAt(left);
                    used.remove(leftChar);
                    left++;
                    if(leftChar == c) break;
                }
            }

            used.add(c);
            int nowLength = right - left + 1;
            maxLength = maxLength > nowLength ? maxLength : nowLength;
        }

        System.out.println("maxLength: " + maxLength);
    }
}




// 3. Longest Substring Without Repeating Characters
/* 개선버전
public class sliding_window1 {
    public static void main(String[] args) {
        String input = "abcabcbb";
        Set<Character> used = new HashSet<Character>();

        int left = 0;
        int right = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while (used.contains(c)) {
                used.remove(s.charAt(left));
                left++;
            }

            used.add(c);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println("maxLength: " + maxLength);
    }
}


 */