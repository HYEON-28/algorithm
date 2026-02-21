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
/*
public class sliding_window_test {

    // Sliding Window + HashMap
    // Time: O(n), Space: O(min(n, 26))
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>(); // char -> 마지막 등장 인덱스
        int max = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // 중복 문자가 현재 window 안에 있으면 left를 그 다음으로 이동
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }

            map.put(c, right);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3 (abc)
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // 1 (b)
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 3 (wke)
        System.out.println(lengthOfLongestSubstring(""));         // 0
    }
}
 */