public class two_pointer1 {
    public int[] twoSum(int[] numbers, int target) {
        int start = 1;
        while (start < numbers.length) {
            for (int end = start + 1; end <= numbers.length; end++) {
                int sum = numbers[start - 1] + numbers[end - 1];
                if (sum == target){
                    int[] result = {start, end};
                    return result;

                } else if (sum > target) {
                    break;
                }
            }
            start++;
        }
        int[] result = {0, 0};
        return result;
    }
}

// 위 답은 투포인터라고 보기 어려움.

public class two_pointer {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if(sum == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{0, 0};
    }
}
