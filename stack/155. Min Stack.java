import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class MinStack {

    Deque<Integer> stack;
    LinkedList<Integer> list = new LinkedList<>();
    
    public MinStack() {
      stack = new ArrayDeque<>();
    }

    public void push(int val) {
      stack.push(val);
    }

    public void pop() {
      stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return 0; // TODO: 구현 필요
    }

    public static void main(String[] args) {
        // LeetCode 예제 테스트
        // ["MinStack","push","push","push","getMin","pop","top","getMin"]
        // [[],[-2],[0],[-3],[],[],[],[]]
        // Expected: [null,null,null,null,-3,null,0,-2]

        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);

        System.out.println("getMin() = " + obj.getMin()); // -3
        obj.pop();
        System.out.println("top()    = " + obj.top());    // 0
        System.out.println("getMin() = " + obj.getMin()); // -2

        System.out.println();

        // 추가 테스트
        MinStack obj2 = new MinStack();
        obj2.push(5);
        obj2.push(3);
        obj2.push(7);
        obj2.push(1);

        System.out.println("getMin() = " + obj2.getMin()); // 1
        obj2.pop();
        System.out.println("getMin() = " + obj2.getMin()); // 3
        obj2.pop();
        System.out.println("top()    = " + obj2.top());    // 3
        System.out.println("getMin() = " + obj2.getMin()); // 3
    }
}
