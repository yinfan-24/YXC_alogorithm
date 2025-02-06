package Solution;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private int capacity;
    private Map<Integer, Integer> map;
    private Deque<Integer> state;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) return map.get(key);
        return -1;
    }

    public void put(int key, int value) {

    }
}
