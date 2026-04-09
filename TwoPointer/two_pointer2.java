import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class two_pointer2 {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();

        // int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-4, -1, -1, 0, 1, 2};
        Arrays.sort(nums);
        int fix = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int start = i + 1;
            int end = nums.length;
            while(start < end) {
                int sum = nums[fix] + nums[start] + nums[end];
                if(sum > 0) {
                    end--;
                } else if(sum < 0) {
                    start++;
                } else {
                    result.add(new ArrayList<>(Arrays.asList(fix, start, end)));
                    if(nums[start] + 1 == nums[start]) {
                        start++;
                    } else if(nums[end - 1] == nums[end]) {
                        end--;
                    } else {
                        break;
                    }
                }
            }
        }

    }
}
