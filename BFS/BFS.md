# 너비우선탐색 BFS(Breadth-first search)
시작노드에서 출발해 시작 노드를 기준으로 가까운 노드를 먼저 방문하며 탐색
- 그래프 완전 탐색
- FIFO탐색
- Queue 자료구조 이용
- 방문배열 필요, 그래프를 인접리스트로 표현

Queue<Integer> queue = new LinkedList<>();
- queue.offer(a); // 넣기
- queue.poll(); // 꺼내기

---

733. Flood Fill
개선점
- q.size() 대신 q.isEmpty(): 표준스타일
- 방향벡터 배열로 상하좌우 체크
- 이미 색이 바뀐경우 skip(중복방지)