package learn.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2020/10/10
 */
public class Greedy {

    public static void main(String[] args) {
        // 存放广播台以及对应可以覆盖的地区
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();

        HashSet<String> broadcast1 = new HashSet<>();
        broadcast1.add("北京");
        broadcast1.add("上海");
        broadcast1.add("天津");
        broadcasts.put("K1", broadcast1);
        HashSet<String> broadcast2 = new HashSet<>();
        broadcast2.add("广州");
        broadcast2.add("北京");
        broadcast2.add("深圳");
        broadcasts.put("K2", broadcast2);
        HashSet<String> broadcast3 = new HashSet<>();
        broadcast3.add("成都");
        broadcast3.add("上海");
        broadcast3.add("杭州");
        broadcasts.put("K3", broadcast3);
        HashSet<String> broadcast4 = new HashSet<>();
        broadcast4.add("上海");
        broadcast4.add("天津");
        broadcasts.put("K4", broadcast4);
        HashSet<String> broadcast5 = new HashSet<>();
        broadcast5.add("杭州");
        broadcast5.add("大连");
        broadcasts.put("K5", broadcast5);

        // 存放所有需要覆盖的地区
        HashSet<String> allAreas = new HashSet<>();
        for (String broadcast : broadcasts.keySet()) {
            allAreas.addAll(broadcasts.get(broadcast));
        }

        // 存放选择结果
        List<String> selects = new ArrayList<>();
        // 将已经覆盖的地区从allAreas中去除，所以用allAreas.size() > 0判断，当等于0是说明已经全部覆盖
        while (allAreas.size() > 0) {
            // 标记覆盖地区最多的那个广播台
            String maxKey = null;
            // 用于存放当前广播台覆盖地区与待覆盖地区的交集
            HashSet<String> tempAreas = new HashSet<>();
            for (String broadcast : broadcasts.keySet()) {
                // 每次clear一下
                tempAreas.clear();
                HashSet<String> areas = broadcasts.get(broadcast);
                tempAreas.addAll(areas);
                // 取交集
                tempAreas.retainAll(allAreas);
                HashSet<String> maxAreas = null;
                // 在maxKey != null时，取maxAreas的交集
                if (maxKey != null) {
                    maxAreas = broadcasts.get(maxKey);
                    maxAreas.retainAll(allAreas);
                }
                // 用于更新maxKey，获取覆盖最多的那个广播台
                if (tempAreas.size() > 0
                        && (maxKey == null || tempAreas.size() > maxAreas.size())) {
                    maxKey = broadcast;
                }
            }
            // 每一遍遍历完，将覆盖最多的广播台add进selects中
            selects.add(maxKey);
            // 同时从allAreas中移除已经被覆盖的地区
            allAreas.removeAll(broadcasts.get(maxKey));
        }
        System.out.println(selects);
    }

}
