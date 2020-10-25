package operatingsystemalgorithm.themefour.lru;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 窦康泰
 * @date 2020/10/21
 * LRU最近最少使用页面置换算法（低地址位优先）
 */
public class LeastRecentlyUsed {

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        System.out.println("LRU页面置换算法");
        Init init = new Init();
        Optimal optimal = new Optimal(init);
        for (int i = 1; i < optimal.rs.length; i++) {
            // 获取rs索引为i之前的最后一次填充的页面
            int[] columnPage = getLastRamPage(optimal.ram, i);
            // 判断rs中待填入的数是否在page中
            boolean flag = judgeCurrRsIsInPage(optimal.rs[i], columnPage);
            // 如果待填入的数不再page中继续操作，否则进入下次循环判断下一个rs
            if (!flag) {
                // 判断当前page是否满
                boolean pageIsFull = judgePageIsFull(columnPage);
                if (pageIsFull) {
                    // 获取需要被替代页的索引（第几个需要被替换）
                    int replaceIndex = getReplaceIndex(columnPage, optimal.rs, i);
                    // 进行替换
                    replace(optimal, i, replaceIndex, getLastRamPage(optimal.ram, init.rs.length));
                } else {
                    // page没满，则直接插入
                    insertPage(optimal, i);
                }
            }
        }
        optimal.showpr();
        optimal.showrs();
        optimal.showRam();
        optimal.showPF();
        optimal.showPR();
        optimal.showReplacedList();
    }

    /**
     * 获取指定索引之前最后一次替换的page数组
     *
     * @param ram
     * @param lastIndex
     * @return
     */
    public static int[] getLastRamPage(int[][] ram, int lastIndex) {
        int index = -1;
        for (int i = 0; i < lastIndex; i++) {
            if (ram[0][i] != -1) {
                index = i;
            }
        }
        int[] tempArr = new int[ram.length];
        Arrays.fill(tempArr, -1);
        if (index == -1) {
            return tempArr;
        }
        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i] = ram[i][index];
        }
        return tempArr;
    }

    /**
     * 进行页面的替换
     *
     * @param optimal
     * @param currIndex    当前rs的索引
     * @param replaceIndex ram中page需要被替换的索引
     * @param lastRamPage  上次被替换的page
     */
    public static void replace(Optimal optimal, int currIndex, int replaceIndex, int[] lastRamPage) {
        for (int i = 0; i < optimal.ram.length; i++) {
            if (i == replaceIndex) {
                optimal.pr[currIndex] = lastRamPage[replaceIndex];
                optimal.ram[i][currIndex] = optimal.rs[currIndex];
            } else {
                optimal.ram[i][currIndex] = lastRamPage[i];
            }
        }
    }

    /**
     * 直接在page中插入一个rs[currIndex]
     *
     * @param optimal
     * @param currIndex
     */
    public static void insertPage(Optimal optimal, int currIndex) {
        int[] lastRamPage = getLastRamPage(optimal.ram, currIndex);
        for (int i = 0; i < lastRamPage.length; i++) {
            if (lastRamPage[i] == -1) {
                optimal.ram[i][currIndex] = optimal.rs[currIndex];
                break;
            } else {
                optimal.ram[i][currIndex] = lastRamPage[i];
            }
        }
    }

    /**
     * 获取page中需要被替换的index
     *
     * @param page
     * @param rs
     * @param currIndex
     * @return
     */
    public static int getReplaceIndex(int[] page, int[] rs, int currIndex) {
        int[] flagArr = new int[page.length];
        int flagSize = 0;
        for (int i = currIndex - 1; i > 0; i--) {
            if (flagSize == page.length - 1) {
                for (int j = 0; j < flagArr.length; j++) {
                    if (flagArr[j] == 0) {
                        return j;
                    }
                }
            }
            for (int j = 0; j < page.length; j++) {
                if (page[j] == rs[i] && flagArr[j] != 1) {
                    flagArr[j] = 1;
                    flagSize++;
                }
            }
        }
        for (int i = 0; i < flagArr.length; i++) {
            if (flagArr[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 判断rs的页是否在page中
     *
     * @param num
     * @param page
     * @return
     */
    public static boolean judgeCurrRsIsInPage(int num, int[] page) {
        for (int p : page) {
            if (p == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断page是否满
     *
     * @param page
     * @return
     */
    public static boolean judgePageIsFull(int[] page) {
        for (int p : page) {
            if (p == -1) {
                return false;
            }
        }
        return true;
    }

}

class Optimal {
    public int[] pr;
    public int[] rs;
    public int[][] ram;

    public Optimal(Init init) {
        pr = new int[init.rs.length + 1];
        Arrays.fill(pr, -1);
        rs = new int[init.rs.length + 1];
        rs[0] = -1;
        for (int i = 1; i < rs.length; i++) {
            rs[i] = init.rs[i - 1];
        }
        ram = new int[init.frameSize][init.rs.length + 1];
        for (int[] r : ram) {
            Arrays.fill(r, -1);
        }
        for (int i = 0; i < init.page.length; i++) {
            ram[i][0] = init.page[i];
        }
    }

    public void showpr() {
        System.out.print(" PR:");
        for (int i = 1; i < pr.length; i++) {
            if (pr[i] == -1) {
                System.out.print("  ");
            } else {
                System.out.print(" " + pr[i]);
            }
        }
        System.out.println();
    }

    public void showrs() {
        System.out.print(" RS:");
        for (int i = 1; i < rs.length; i++) {
            System.out.print(" " + rs[i]);
        }
        System.out.println();
    }

    public void showRam() {
        for (int i = 0; i < ram.length; i++) {
            if (i == 0) {
                System.out.print("RAM:");
            } else {
                System.out.print("    ");
            }
            for (int j = 1; j < ram[i].length; j++) {
                if (ram[i][j] == -1) {
                    System.out.print("  ");
                } else {
                    System.out.print(" " + ram[i][j]);
                }
            }
            System.out.println();
        }
    }

    public void showPF() {
        int count = 0;
        for (int i = 1; i < ram[0].length; i++) {
            if (ram[0][i] != -1) {
                count++;
            }
        }
        System.out.println("PF=" + count);
    }

    public void showPR() {
        int count = 0;
        for (int i = 0; i < pr.length; i++) {
            if (pr[i] != -1) {
                count++;
            }
        }
        System.out.println("PR=" + count);
    }

    public void showReplacedList() {
        int count = 0;
        System.out.print("Pages=");
        for (int i = 0; i < pr.length; i++) {
            if (pr[i] != -1) {
                if (count == 0) {
                    System.out.print(pr[i]);
                    count++;
                } else {
                    System.out.print("," + pr[i]);
                }
            }
        }
        System.out.println();
    }
}

class Init {
    public int frameSize;
    public int[] page;
    public int[] rs;

//    public Init() {
//        frameSize = 5;
//        page = new int[]{2, 4, 3, 0, 5};
//        rs = new int[]{5, 1, 7, 1, 6, 1, 2, 5, 6, 2, 0, 7, 6, 1, 6, 5, 3, 5, 3, 6, 5, 3};
//    }

    public Init() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入物理块大小（Frame）：");
        frameSize = scanner.nextInt();
        scanner.nextLine();
        System.out.print("请输入已装入的页面（空格分隔，若没有页面，直接回车键）：");
        String pageStr = scanner.nextLine();
        if (pageStr.length() > 0) {
            String[] pageStrArr = pageStr.split(" ");
            page = new int[pageStrArr.length];
            for (int i = 0; i < pageStrArr.length; i++) {
                page[i] = Integer.parseInt(pageStrArr[i]);
            }
        } else {
            page = new int[0];
        }
        System.out.print("请输入页面访问串（空格分隔）：");
        String[] rsStrArr = scanner.nextLine().split(" ");
        rs = new int[rsStrArr.length];
        for (int i = 0; i < rsStrArr.length; i++) {
            rs[i] = Integer.parseInt(rsStrArr[i]);
        }
    }

    @Override
    public String toString() {
        return "Init{" +
                "frameSize=" + frameSize +
                ", page=" + Arrays.toString(page) +
                ", rs=" + Arrays.toString(rs) +
                '}';
    }
}
