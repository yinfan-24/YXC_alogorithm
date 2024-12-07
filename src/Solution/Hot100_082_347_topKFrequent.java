package Solution;

import java.net.Inet4Address;
import java.util.*;

public class Hot100_082_347_topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        map.keySet().stream().forEach(queue::add);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
