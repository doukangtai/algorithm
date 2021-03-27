package leetcode.linesweep;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 窦康泰
 * @date 2021/03/27
 */
public class PerfectRectangle {
    public boolean isRectangleCover(int[][] rectangles) {
        int totalArea = 0;
        int X1 = Integer.MAX_VALUE;
        int Y1 = Integer.MAX_VALUE;
        int X2 = Integer.MIN_VALUE;
        int Y2 = Integer.MIN_VALUE;
        Set<String> container = new HashSet<>();
        for (int i = 0; i < rectangles.length; i++) {
            int x1 = rectangles[i][0];
            int y1 = rectangles[i][1];
            int x2 = rectangles[i][2];
            int y2 = rectangles[i][3];
            totalArea += (x2 - x1) * (y2 - y1);
            X1 = Math.min(X1, x1);
            Y1 = Math.min(Y1, y1);
            X2 = Math.max(X2, x2);
            Y2 = Math.max(Y2, y2);
            String[] points = {x1 + " " + y1, x1 + " " + y2, x2 + " " + y1, x2 + " " + y2};
            for (String point : points) {
                if (container.contains(point)) {
                    container.remove(point);
                } else {
                    container.add(point);
                }
            }
        }
        int area = (X2 - X1) * (Y2 - Y1);
        if (area == totalArea && container.size() == 4 && container.contains(X1 + " " + Y1) && container.contains(X1 + " " + Y2) && container.contains(X2 + " " + Y1) && container.contains(X2 + " " + Y2)) {
            return true;
        }
        return false;
    }
}
