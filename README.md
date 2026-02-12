# algorithm

## stack
ex) Deque<Integer> stack = new ArrayDeque<>();
stack.push(sth);
stack.pop();
stack.peek();
stack.isEmpty();

## queue
ex) Queue<Integer> queue = new ArrayDeque<>();
queue.offer(sth);
queue.poll();
queue.peek();
queue.isEmpty();

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

## HashMap
* 목적: 데이터 저장
Map<String, Integer> map = new HashMap<>();
map.put("apple", 1);
map.get("apple");
map.containsKey(num); -> 존재여부 체크

## HashSet
* 목적: 존재여부 체크
Set<String> set = new HashSet<>();
set.add("apple");
contains(value) -> 존재여부 체크