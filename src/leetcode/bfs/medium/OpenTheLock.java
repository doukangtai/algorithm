package leetcode.bfs.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author 窦康泰
 * @date 2021/01/23
 */
public class OpenTheLock {
    public static void main(String[] args) {
        String[] deadends = new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String target = "8888";
        int step = new OpenTheLock().openLock(deadends, target);
        System.out.println(step);
    }

    private Queue<String> q = new LinkedList<>();
    private Set<String> visited = new HashSet<>();
    private int step = 0;

    public int openLock(String[] deadends, String target) {
        Set<String> deadQueue = new HashSet<>();
        for (String deadend : deadends) {
            deadQueue.add(deadend);
        }
        if (deadQueue.contains(target)) {
            return -1;
        }
        q.offer("0000");
        visited.add("0000");
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (deadQueue.contains(curr)) {
                    continue;
                }
                if (target.equals(curr)) {
                    return step;
                }
                for (int j = 0; j < curr.length(); j++) {
                    String upOne = upOne(curr, j);
                    if (!visited.contains(upOne)) {
                        q.offer(upOne);
                        visited.add(upOne);
                    }
                    String downOne = downOne(curr, j);
                    if (!visited.contains(downOne)) {
                        q.offer(downOne);
                        visited.add(downOne);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public String upOne(String target, int i) {
        char[] targetCharArray = target.toCharArray();
        if (targetCharArray[i] == '9') {
            targetCharArray[i] = '0';
        } else {
            targetCharArray[i]++;
        }
        return new String(targetCharArray);
    }

    public String downOne(String target, int i) {
        char[] targetCharArray = target.toCharArray();
        if (targetCharArray[i] == '0') {
            targetCharArray[i] = '9';
        } else {
            targetCharArray[i]--;
        }
        return new String(targetCharArray);
    }
}
