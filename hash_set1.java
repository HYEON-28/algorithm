import java.util.HashMap;
import java.util.Map;

// 217. Contains Duplicate
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(map.get(num) == null) {
                map.put(num, 1);
            } else {
                return true;
            }
        }

        return false;
    }
}

// HashSet이 더 적절한 풀이.
// import java.util.*;

// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         Set<Integer> set = new HashSet<>();

//         for (int num : nums) {
//             if (!set.add(num)) {  // 이미 있으면 false 반환
//                 return true;
//             }
//         }

//         return false;
//     }
// }