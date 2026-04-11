import java.util.HashMap;
import java.util.Map;

public class hash2 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                int cnt = map.get(c);
                map.put(c, ++cnt);
            }
        }

        System.out.println(map);

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(!map.containsKey(c)) {
                System.out.println("false");
            } else {
                int cnt = map.get(c);
                if(cnt < 1) System.out.println("false");
                map.put(c, --cnt);
            }
        }

        System.out.println("true");
        
    }
}
