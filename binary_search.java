class Solution {
    public int search(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (true) {
            if(startIndex > endIndex) {
                return -1;
            }
            int middleIndex = getMiddleIndex(startIndex, endIndex);
            if (nums[middleIndex] == target) {
                return middleIndex;
            }

            if(nums[middleIndex] > target)  {
                endIndex = middleIndex - 1;
            } else if (nums[middleIndex] < target) {
                startIndex = middleIndex + 1;
            } 
        }
    }
    public int getMiddleIndex(int startIndex, int endIndex) {
        return startIndex + (endIndex - startIndex) / 2;
    }
}

// 더 의도가 명확히 들어나는 코드
// while (startIndex <= endIndex) {
//     int mid = getMiddleIndex(startIndex, endIndex);
//     ...
// }
// return -1;

// getMiddleIndex를 메서드로 분리한 이유
// 테스트가 쉽고 의도가 명확히 드러나는 함수이기 때문에 코드가 간결해짐.
