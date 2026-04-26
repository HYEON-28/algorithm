# algorithm

> 파일 실행법: javac "733. Flood Fill.java" -d out && java -cp out Main

문제풀이 목표

> 플레티넘 수준까지 (못해도 골드까지) 최소 160문제는 풀어야하고, 필자는 1700문제 풀었음

## 알고리즘 종류 정리

1. 누적합
2. DFS
3. BFS
4. 그리디
5. 이분탐색
6. 투포인터
7. 트리순회
8. 그래프
9. 백트래킹
10. 구현, 완탐, 비트마스킹, 라인스위핑, LIS, DP, 최단거리, 펜윅트리

---

## 기본 자료구조 사용방법

### 정렬

Arrays.sort(arr);

### ArrayList

선언하며 값 할당하기
List<Integer> result = Arrays.asList(1, 2, 3); -- 값 추가, 삭제 불가
List<Integer> result = new ArrayList<>(Arrays.asList(1, 2, 3)); -- 값 추가, 삭제 가능

### Linked List

LinkedList<Integer> list = new LinkedList<>();

### Queue

Queue<Integer> queue = new ArrayDeque<>();
queue.offer(sth);
queue.poll();
queue.peek();
queue.isEmpty();

- queue: op!!

### Stack

Deque<Integer> stack = new ArrayDeque<>();
stack.push(sth);
stack.pop();
stack.peek();
stack.isEmpty();

- stack: pp!!
