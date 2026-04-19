import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
      int targetLength = s1.length();
      Map<Character, Integer> map = new HashMap<>();

      // map에 s1저장
      for (int i = 0; i < s1.length(); i++) {
        char c = s1.charAt(i);
        if (map.containsKey(c)) {
          int count = map.get(c);
          map.put(c, ++count);
        } else {
          map.put(c, 1);
        }
      }

      Map<Character, Integer> mapCopy = new HashMap<>();
      int startIdx = 0;
      int endIdx = 0;
      for (int i = 0; i < s2.length(); i++) {
        char c = s2.charAt(i);
        // 값이 아예 없는경우는 다음인덱스로 startIdx, endIdx옮김
        if(!mapCopy.containsKey(c)) {
          startIdx = i+1;
          endIdx = i+1;
          mapCopy = map; // mapCopy다시 복원
        }
        

      }
      return true;
    }
}

class Main {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        
        Solution solution = new Solution();
        boolean result = solution.checkInclusion(s1, s2);

        System.out.println(result);
    }
}