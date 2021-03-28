package leetcode.orderedmap;

import java.util.*;

/**
 * @author 窦康泰
 * @date 2021/03/28
 */
public class ExamRoom {
    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(8);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(0);
        examRoom.leave(7);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
    }

    TreeSet<int[]> container;
    Map<Integer, int[]> startCon;
    Map<Integer, int[]> endCon;
    int N;

    public ExamRoom(int N) {
        this.N = N;
        startCon = new HashMap<>();
        endCon = new HashMap<>();
        container = new TreeSet<>((o1, o2) -> {
            int len1 = distance(o1);
            int len2 = distance(o2);
            if (len1 == len2) {
                return o2[0] - o1[0];
            }
            return len1 - len2;
        });
        container.add(new int[]{-1, N});
    }

    public int distance(int[] line) {
        if (line[0] == -1) {
            return line[1];
        }
        if (line[1] == N) {
            return N - 1 - line[0];
        }
        return (line[1] - line[0]) / 2;
    }

    public int seat() {
        int[] longest = container.last();
        int seat = 0;
        if (longest[0] == -1) {
            seat = 0;
        } else if (longest[1] == N) {
            seat = N - 1;
        } else {
            seat = longest[0] + (longest[1] - longest[0]) / 2;
        }
        int[] left = {longest[0], seat};
        int[] right = {seat, longest[1]};
        removeLine(longest);
        addLine(left);
        addLine(right);
        return seat;
    }

    public void leave(int p) {
        int[] right = startCon.get(p);
        int[] left = endCon.get(p);
        int[] merge = {left[0], right[1]};
        removeLine(left);
        removeLine(right);
        addLine(merge);
    }

    public void addLine(int[] line) {
        container.add(line);
        startCon.put(line[0], line);
        endCon.put(line[1], line);
    }

    public void removeLine(int[] line) {
        container.remove(line);
        startCon.remove(line[0]);
        endCon.remove(line[1]);
    }
}
