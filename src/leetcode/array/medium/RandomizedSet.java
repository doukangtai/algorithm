package leetcode.array.medium;

import java.util.*;

/**
 * @author 窦康泰
 * @date 2021/02/19
 */
public class RandomizedSet {
    private List<Integer> nums;
    private Map<Integer, Integer> valToIndex;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        valToIndex = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        }
        nums.add(val);
        valToIndex.put(val, nums.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        Integer index = valToIndex.get(val);
        Integer last = nums.get(nums.size() - 1);
        nums.set(index, last);
        valToIndex.put(last, index);
        nums.remove(nums.size() - 1);
        valToIndex.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        return nums.get(random.nextInt(nums.size()));
    }
}
