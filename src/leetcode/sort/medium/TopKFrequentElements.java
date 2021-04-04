package leetcode.sort.medium;

import java.util.*;

/**
 * @author 窦康泰
 * @date 2021/04/04
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] listArr = new List[nums.length + 1];
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            Integer val = map.get(key);
            if (listArr[val] == null) {
                listArr[val] = new ArrayList<>();
            }
            listArr[val].add(key);
        }
        int[] res = new int[k];
        int count = 0;
        for (int i = listArr.length - 1; i >= 0; i--) {
            if (listArr[i] != null) {
                for (Integer integer : listArr[i]) {
                    if (count >= k) {
                        break;
                    }
                    res[count] = integer;
                    count++;
                }
            }
            if (count >= k) {
                break;
            }
        }
        return res;
    }
}
