// No. 278
public class binary_search2 extends VersionControl {
    public int firstBadVersion(int n) {
        int startIndex = 1;
        int endIndex = n;

        while (endIndex > 1) {
            int middleIndex = getMiddleIndex(startIndex, endIndex);
            // 중앙의 버전 확인, bad아닌 경우 
            if (!isBadVersion(middleIndex)) {
                startIndex = middleIndex + 1;
                continue;
            } 

            // middle== 1 또는 bad이고 이전인덱스가 bad가 아님 -> 최초 버그발생위치
            if (middleIndex == 1 || !isBadVersion(middleIndex-1)) {
                return middleIndex;
            } 

            endIndex = middleIndex - 1;
        }

        return 1;

    }

    public int getMiddleIndex(int startIndex, int endIndex) {
        return startIndex + (endIndex - startIndex) / 2;
    }
}
// while (endIndex > 1) {
// 이분탐색의 의미와 맞지 않음.
// 이분탐색의 표준은 아래처럼 구현.
// while (startIndex <= endIndex)