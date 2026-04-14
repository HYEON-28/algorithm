# algorithm

```
진행중: 로드맵의 Week1.
994. Rotting Oranges 복습
```

> 파일 실행법: javac "733. Flood Fill.java" -d out && java -cp out Main

1. 문제 풀이 방식 (가장 중요)
   30분 고민 → 안되면 해설
   해설 보고 다시 혼자 구현
   2~3일 뒤 다시 풀기
2. 일본 빅테크 특징
   라인 / 메루카리 기준:
   Medium 중심
   Graph / DFS / BFS / DP 많이 나옴
   시간복잡도 설명 필수
3. 추천 주간 루틴
   평일: 1~2문제
   주말: 복습 + 재풀이
   총 목표: 약 120~150문제

👉 “많이 풀기”보다
👉 같은 패턴을 완전히 이해하고 재사용 가능하게 만드는 것

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

문제풀이: 플레티넘 수준까지 (못해도 골드까지)
최소 160문제는 풀어야하고, 필자는 1700문제 풀었음

## stack

ex) Deque<Integer> stack = new ArrayDeque<>();
stack.push(sth);
stack.pop();
stack.peek();
stack.isEmpty();

- stack: pp!!

## queue

ex) Queue<Integer> queue = new ArrayDeque<>();
queue.offer(sth);
queue.poll();
queue.peek();
queue.isEmpty();

- queue: op!!

Queue<TreeNode> queue = new LinkedList<>();
queue.offer(sth);
queue.poll();
queue.peek();
queue.isEmpty();

- 예외를 던지는 버전(add/remove)
- 안전한 버전(offer/poll)

## 정렬

Arrays.sort(arr);

## ArrayList

선언하며 값 할당하기
List<Integer> result = Arrays.asList(1, 2, 3); -- 값 추가, 삭제 불가
List<Integer> result = new ArrayList<>(Arrays.asList(1, 2, 3)); -- 값 추가, 삭제 가능

## Linked List

LinkedList<Integer> list = new LinkedList<>();
