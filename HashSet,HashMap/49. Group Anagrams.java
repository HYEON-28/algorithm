import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            ArrayList<String> list = map.containsKey(sorted) ? map.get(sorted) : new ArrayList<>();
            list.add(str);
            map.put(sorted, list);
        }
        for(String key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result1 = solution.groupAnagrams(strs1);
        System.out.println("Test 1: " + result1);
        // 예상: [["eat","tea","ate"], ["tan","nat"], ["bat"]]

        // Test case 2
        String[] strs2 = {""};
        List<List<String>> result2 = solution.groupAnagrams(strs2);
        System.out.println("Test 2: " + result2);
        // 예상: [[""]]

        // Test case 3
        String[] strs3 = {"a"};
        List<List<String>> result3 = solution.groupAnagrams(strs3);
        System.out.println("Test 3: " + result3);
        // 예상: [["a"]]
    }
}
