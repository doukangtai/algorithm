package leetcode.designdatastructure.hard;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author 窦康泰
 * @date 2021/02/09
 */
public class LFUCache {
    private int cap;
    private HashMap<Integer, Integer> keyToVal;
    private HashMap<Integer, Integer> keyToFre;
    private int minFre;
    private HashMap<Integer, LinkedHashSet<Integer>> freToKeys;

    public LFUCache(int capacity) {
        this.cap = capacity;
        keyToVal = new HashMap<>();
        keyToFre = new HashMap<>();
        minFre = 0;
        freToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        Integer val = keyToVal.get(key);
        increaseFre(key);
        return val;
    }

    private void increaseFre(int key) {
        Integer fre = keyToFre.get(key);
        keyToFre.put(key, fre + 1);
        LinkedHashSet<Integer> keysLinked = freToKeys.get(fre);
        keysLinked.remove(key);
        freToKeys.putIfAbsent(fre + 1, new LinkedHashSet<>());
        LinkedHashSet<Integer> keysLinked2 = freToKeys.get(fre + 1);
        keysLinked2.add(key);
        if (keysLinked.isEmpty()) {
            freToKeys.remove(fre);
            if (minFre == fre) {
                minFre++;
            }
        }
    }

    public void put(int key, int value) {
        if (cap <= 0) {
            return;
        }
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increaseFre(key);
            return;
        }
        if (keyToVal.size() >= cap) {
            LinkedHashSet<Integer> keysLinked = freToKeys.get(minFre);
            Integer first = keysLinked.iterator().next();
            keysLinked.remove(first);
            if (keysLinked.isEmpty()) {
                freToKeys.remove(minFre);
            }
            keyToVal.remove(first);
            keyToFre.remove(first);
        }
        keyToVal.put(key, value);
        keyToFre.put(key, 1);
        freToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freToKeys.get(1).add(key);
        minFre = 1;
    }
}
