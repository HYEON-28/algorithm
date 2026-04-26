# Queue

ex) Queue<Integer> queue = new ArrayDeque<>();
queue.offer(sth);
queue.poll();
queue.peek();
queue.isEmpty();

- queue: op!!

과거 Queue 사용법
Queue<TreeNode> queue = new LinkedList<>();
queue.offer(sth);
queue.poll();
queue.peek();
queue.isEmpty();

- 예외를 던지는 버전(add/remove)
- 안전한 버전(offer/poll)
