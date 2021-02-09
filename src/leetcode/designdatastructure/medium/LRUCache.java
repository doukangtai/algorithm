package leetcode.designdatastructure.medium;

import java.util.LinkedHashMap;

/**
 * @author 窦康泰
 * @date 2021/02/09
 */
public class LRUCache {
    private int cap;
    private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeRecent(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecent(key);
            return;
        }
        if (cache.size() >= cap) {
            Integer first = cache.keySet().iterator().next();
            cache.remove(first);
        }
        cache.put(key, value);
    }

    public void makeRecent(int key) {
        Integer val = cache.remove(key);
        cache.put(key, val);
    }
}
