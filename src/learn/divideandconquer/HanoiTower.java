package learn.divideandconquer;

/**
 * @author 窦康泰
 * @date 2020/10/09
 */
public class HanoiTower {

    public static void main(String[] args) {
        hanoiTower(3, 'A', 'B', 'C');
    }

    /**
     * 如果只有一个盘直接将这个盘从A移动到C
     * 否则先将num - 1个从A移动到B，将第num个从A移动到C，再将B柱上的num - 1个从B移动到C
     * @param num 盘的数量
     * @param a 柱子A
     * @param b 柱子B
     * @param c 柱子C
     */
    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第" + num + "个盘从：" + a + "-->" + c);
        } else {
            hanoiTower(num - 1, a, c, b);
            System.out.println("第" + num + "个盘从：" + a + "-->" + c);
            hanoiTower(num - 1, b, a, c);
        }
    }

}
