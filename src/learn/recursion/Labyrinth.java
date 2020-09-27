package learn.recursion;

/**
 * @author 窦康泰
 * @date 2020/09/26
 */
public class Labyrinth {

    public static void main(String[] args) {
        int[][] map = new int[8][9];
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][8] = 1;
        }
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[3][3] = 1;
        map[2][3] = 1;
        map[1][3] = 1;
        System.out.println("原始的迷宫");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
        findWay(map, 5, 3);
        System.out.println("走过的迷宫");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 0代表没走过，1代表墙，2代表走过，3代表走过但走不通
     * @param map
     * @param i
     * @param j
     */
    public static boolean findWay(int[][] map, int i, int j) {
        if (map[6][7] == 2) {
            return true;
        }
        if (map[i][j] == 0) {
            map[i][j] = 2;
            if (findWay(map, i + 1, j)) {
                return true;
            } else if (findWay(map, i, j + 1)) {
                return true;
            } else if (findWay(map, i - 1, j)) {
                return true;
            } else if (findWay(map, i, j - 1)) {
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }
    }

}
