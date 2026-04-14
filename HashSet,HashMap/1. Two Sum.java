import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
      
      Map<Integer, Integer> map = new HashMap<>(); 

      for (int i = 0; i < nums.length; i++) {
        int val = nums[i];
        if(map.containsKey(val) && val * 2 == target) {
          return new int[] {map.get(val), i};
        } 
        map.put(val, i);
      }

      for (int i = 0; i < nums.length; i++) {
        int val = nums[i];
        int pairVal = target - val;
        if(val != pairVal && map.containsKey(pairVal)) {
          return (new int[] {i, map.get(pairVal)});
        }
      }

      return new int[] {};
    }
}
// nums = [2, 7, 11, 15], target = 9 을 넣어서 twoSum 실행시키기

// 루프 한번만 돌려도 됨.
class Solution_2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }

        return new int[] {};
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        Solution solution = new Solution();
        int[] result = solution.twoSum(nums, target);

        System.out.println(Arrays.toString(result));
    }
}