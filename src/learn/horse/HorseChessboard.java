package learn.horse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2020/10/11
 */
public class HorseChessboard {

    public static void main(String[] args) {
        Chessboard chessboard = new Chessboard(6);
        horseChessboard(chessboard, 0, 0, 1);
        for (int i = 0; i < chessboard.board.length; i++) {
            for (int j = 0; j < chessboard.board[i].length; j++) {
                System.out.printf("%3d", chessboard.board[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 骑士周游回溯问题（马踏棋盘）即按照"日"字走
     * 按照广度优先搜索的思想，一直不断递归调用试错，若没成功，则通过回溯重置已经走过的点，若成功，则将isFinished设为true（即终止回溯的递归调用）
     * 结束递归调用则获取到指定棋盘的走棋顺序
     * @param chessboard
     * @param x
     * @param y
     * @param step
     */
    public static void horseChessboard(Chessboard chessboard, int x, int y, int step) {
        chessboard.isVisited[y][x] = true;
        chessboard.board[y][x] = step;
        List<Point> pointList = getNextPoints(chessboard, new Point(x, y));
        for (int i = 0; i < pointList.size(); i++) {
            Point point = pointList.get(i);
            if (!chessboard.isVisited[point.y][point.x]) {
                horseChessboard(chessboard, point.x, point.y, step + 1);
            }
        }
        if (step == Math.pow(chessboard.size, 2) || chessboard.isFinished) {
            chessboard.isFinished = true;
        } else {
            chessboard.isVisited[y][x] = false;
            chessboard.board[y][x] = 0;
        }
    }

    /**
     * 获取指定point可以按"日"字跳跃的点的list集合
     * @param chessboard
     * @param point
     * @return
     */
    public static List<Point> getNextPoints(Chessboard chessboard, Point point) {
        List<Point> pointList = new ArrayList<>();
        if ((point.x - 1) >= 0 && (point.y - 2) >= 0) {
            Point newPoint = new Point(point.x - 1, point.y - 2);
            pointList.add(newPoint);
        }
        if ((point.x + 1) < chessboard.size && (point.y - 2) >= 0) {
            Point newPoint = new Point(point.x + 1, point.y - 2);
            pointList.add(newPoint);
        }

        if ((point.x + 2) < chessboard.size && (point.y - 1) >= 0) {
            Point newPoint = new Point(point.x + 2, point.y - 1);
            pointList.add(newPoint);
        }
        if ((point.x + 2) < chessboard.size && (point.y + 1) < chessboard.size) {
            Point newPoint = new Point(point.x + 2, point.y + 1);
            pointList.add(newPoint);
        }

        if ((point.x + 1) < chessboard.size && (point.y + 2) < chessboard.size) {
            Point newPoint = new Point(point.x + 1, point.y + 2);
            pointList.add(newPoint);
        }
        if ((point.x - 1) >= 0 && (point.y + 2) < chessboard.size) {
            Point newPoint = new Point(point.x - 1, point.y + 2);
            pointList.add(newPoint);
        }

        if ((point.x - 2) >= 0 && (point.y + 1) < chessboard.size) {
            Point newPoint = new Point(point.x - 2, point.y + 1);
            pointList.add(newPoint);
        }
        if ((point.x - 2) >= 0 && (point.y - 1) >= 0) {
            Point newPoint = new Point(point.x - 2, point.y - 1);
            pointList.add(newPoint);
        }
        return pointList;
    }

}

class Chessboard {
    public int size;
    public int[][] board;
    public boolean[][] isVisited;
    public boolean isFinished;

    public Chessboard(int size) {
        this.size = size;
        this.board = new int[size][size];
        this.isVisited = new boolean[size][size];
        this.isFinished = false;
    }
}

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
