package Solution;

import java.util.Deque;
import java.util.LinkedList;

public class Hot100_065_739_dailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
//        维护一个单调栈：栈底大，栈顶小
//        正向遍历，每次比较栈顶
//        当前元素比栈顶大时，就找到了第一个大于栈顶元素的位置
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<Integer>();

        for (int i = 0; i < n; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]){
                int ans = stack.pop();
                res[ans] = i - ans;
            }
//            经过上面的while后，当前元素一定比栈顶要小
            stack.push(i);
        }

        return res;
    }
}
