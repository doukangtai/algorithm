package test;

import java.util.TreeMap;

/**
 * @author 窦康泰
 * @date 2020/12/26
 */
public class Test {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(3, 1);
        map.put(1, 1);
        map.put(2, 1);
        System.out.println(map);
    }

}
