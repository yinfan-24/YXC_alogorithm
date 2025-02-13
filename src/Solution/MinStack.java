package Solution;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

class MinStack {
    int min = Integer.MAX_VALUE;
    LinkedList<Integer> stack = new LinkedList<>();
    MinStack(){};

    void push(int val){
        if (val <= this.min){
            this.stack.push(this.min);
            this.min = val;
        }
        this.stack.push(val);
    }

    void pop(){
        int x = this.stack.pop();
        if (x == this.min){
            this.min = this.stack.pop();
        }
    }
    int top(){
        return this.stack.peek();
    }
    int getMin(){
        return this.min;
    }


}
