package Solution;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

class MinStack {
    Deque<Integer> help_stack;
    Deque<Integer> min_stack;

    public MinStack() {
        this.min_stack = new LinkedList<>();
        this.help_stack = new LinkedList<>();
        help_stack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        this.help_stack.push(Math.min(help_stack.peek(), val));
        this.min_stack.push(val);
    }

    public void pop() {
        this.min_stack.pop();
        this.help_stack.pop();
    }

    public int top() {
        return this.min_stack.peek();
    }

    public int getMin() {
        return this.help_stack.peek();
    }
}
