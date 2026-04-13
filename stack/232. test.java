import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {
    Deque<Integer> stack;
    Deque<Integer> rStack;

    public MyQueue() {
        stack = new ArrayDeque<>();
        rStack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        if(rStack.size() > 0) {
          return rStack.pop();
        }

        move();
        return rStack.pop();
    }
    
    public int peek() {
        if(rStack.size() > 0) {
          return rStack.peek();
        }

        move();
        return rStack.peek();
    }
    
    public boolean empty() {
        return rStack.isEmpty() && stack.isEmpty() ? true : false;
    }

    public void move() {
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            int val = stack.pop();
            rStack.push(val);
        }
    }
}