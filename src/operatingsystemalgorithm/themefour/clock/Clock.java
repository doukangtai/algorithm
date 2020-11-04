package operatingsystemalgorithm.themefour.clock;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 窦康泰
 * @date 2020/10/21
 * Clock页面置换算法（低地址位优先）
 */
public class Clock {

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Init init = new Init();
        Optimal optimal = new Optimal(init);
        for (int i = 1; i < optimal.rs.length; i++) {
            // 获取rs索引为i之前的最后一次填充的页面
            int[] columnPage = getLastRamPage(optimal.ram, i);
            // 判断rs中待填入的数是否在page中
            boolean flag = judgeCurrRsIsInPage(optimal.rs[i], columnPage);
            if (!flag) {
                // 若待填入的数不在page中，进行页面替换
                replace(optimal, i, getLastRamPage(optimal.ram, i));
            } else {
                // 若待填入的数在page中，只变更访问位
                updateIsVisitedToOne(optimal, i);
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("==============================================================");
        optimal.showpr();
        optimal.showrs();
        optimal.showRam();
        optimal.showPF();
        optimal.showPR();
        optimal.showReplacedList();
        optimal.showPA();
        System.out.println("==============================================================");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static void updateIsVisitedToOne(Optimal optimal, int currIndex) {
        int[] lastRamPage = getLastRamPage(optimal.ram, currIndex);
        for (int i = 0; i < lastRamPage.length; i++) {
            if (lastRamPage[i] == optimal.rs[currIndex]) {
                optimal.isVisited[i] = 1;
                return;
            }
        }
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
     * @param currIndex   当前rs的索引
     * @param lastRamPage 上次被替换的page
     */
    public static void replace(Optimal optimal, int currIndex, int[] lastRamPage) {
        // 先将currIndex所在的页填充lastRamPage中的内容
        for (int i = 0; i < optimal.ram.length; i++) {
            optimal.ram[i][currIndex] = lastRamPage[i];
        }
        while (true) {
            if (optimal.isVisited[optimal.nf] == 1) {
                // 访问位为1，将访问位，置为0指针下移
                optimal.isVisited[optimal.nf] = 0;
                moveNf(optimal);
            } else {
                // 访问位为0，可以进行页面替换
                if (lastRamPage[optimal.nf] == -1) {
                    // 当前指针指向的ram的页为空，直接填入数字，并变更当前访问位为1，指针下移
                    optimal.ram[optimal.nf][currIndex] = optimal.rs[currIndex];
                    optimal.isVisited[optimal.nf] = 1;
                    moveNf(optimal);
                } else {
                    // 当前指针指向的ram的页不为空，将指针指向的页放入pr中，将当前rs放入指针指向的页，指针指向的页改访问位为1，指针下移
                    optimal.pr[currIndex] = lastRamPage[optimal.nf];
                    optimal.ram[optimal.nf][currIndex] = optimal.rs[currIndex];
                    optimal.isVisited[optimal.nf] = 1;
                    moveNf(optimal);
                }
                break;
            }
        }
    }

    public static void moveNf(Optimal optimal) {
        if (optimal.nf >= optimal.ram.length - 1) {
            optimal.nf = 0;
        } else {
            optimal.nf++;
        }
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
}

class Optimal {
    public int[] pr;
    public int[] rs;
    public int[][] ram;

    public int[] isVisited;
    public int nf;

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
        isVisited = new int[init.frameSize];
        for (int i = 0; i < init.isVisited.length; i++) {
            isVisited[i] = init.isVisited[i];
        }
        nf = init.nf;
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

    public void showPA() {
        System.out.print("(P-A)=");
        int[] lastRamPage = Clock.getLastRamPage(ram, rs.length);
        for (int i = 0; i < lastRamPage.length; i++) {
            if (i == 0) {
                System.out.print(lastRamPage[i] + "-" + isVisited[i]);
            } else {
                System.out.print("," + lastRamPage[i] + "-" + isVisited[i]);
            }
        }
        System.out.println();
    }
}

class Init {
    public int frameSize;
    public int[] page;
    public int[] rs;

    public int[] isVisited;
    public int nf;

    public Init() {
        System.out.println("Clock页面置换算法");
        System.out.print("请输入物理块大小（Frame）：");
        Scanner scanner = new Scanner(System.in);
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
        System.out.print("请输入访问位（空格分隔，若没有访问位，直接回车键）：");
        String isVisitedStr = scanner.nextLine();
        if (isVisitedStr.length() > 0) {
            String[] isVisitedArr = isVisitedStr.split(" ");
            isVisited = new int[isVisitedArr.length];
            for (int i = 0; i < isVisitedArr.length; i++) {
                isVisited[i] = Integer.parseInt(isVisitedArr[i]);
            }
        } else {
            isVisited = new int[0];
        }
        System.out.print("输入0代表替换指针NF开始指向最低地址的物理块，输入1代表指向最高地址：");
        if (scanner.nextInt() == 0) {
            nf = 0;
        } else {
            nf = frameSize - 1;
        }
        scanner.nextLine();
        System.out.print("请输入页面访问串（空格分隔）：");
        String[] rsStrArr = scanner.nextLine().split(" ");
        rs = new int[rsStrArr.length];
        for (int i = 0; i < rsStrArr.length; i++) {
            rs[i] = Integer.parseInt(rsStrArr[i]);
        }

//        frameSize = 5;
//        page = new int[]{2, 6, 7, 3};
//        isVisited = new int[]{0, 1, 1, 0};
//        nf = frameSize - 1;
//        rs = new int[]{0, 4, 7, 1, 2, 6, 1, 4, 6, 0, 1, 0, 5, 2, 7, 1, 4, 7, 6, 0, 4, 0, 7, 2};
    }

//    public Init() {
//        frameSize = 5;
//        page = new int[]{};
//        isVisited = new int[]{};
//        nf = 0;
//        rs = new int[]{5, 2, 6, 1, 5, 4, 5, 6, 4, 0, 2, 1, 7, 2, 5, 2, 3, 0, 4, 2, 4, 6, 5, 6};
//    }

    @Override
    public String toString() {
        return "Init{" +
                "frameSize=" + frameSize +
                ", page=" + Arrays.toString(page) +
                ", rs=" + Arrays.toString(rs) +
                '}';
    }
}
