package leetcode.sort.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/04/04
 */
public class SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println(new SortCharactersByFrequency().frequencySort("tree"));
    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Character>[] listArr = new List[s.length() + 1];
        Iterator<Character> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Character key = iterator.next();
            Integer val = map.get(key);
            if (listArr[val] == null) {
                listArr[val] = new ArrayList<>();
            }
            listArr[val].add(key);
        }
        StringBuilder res = new StringBuilder();
        for (int i = listArr.length - 1; i >= 0; i--) {
            if (listArr[i] != null) {
                for (int j = 0; j < listArr[i].size(); j++) {
                    for (int k = 0; k < i; k++) {
                        res.append(listArr[i].get(j));
                    }
                }
            }
        }
        return res.toString();
    }
}
