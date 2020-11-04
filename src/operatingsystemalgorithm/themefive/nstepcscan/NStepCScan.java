package operatingsystemalgorithm.themefive.nstepcscan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 窦康泰
 * @date 2020/11/03
 */
public class NStepCScan {

    /**
     * 初始化磁道号方向
     */
    public static int[] direction;
    /**
     * 依次请求访问的磁道号队列
     */
    public static int[] fifo;
    /**
     * 存放磁道访问序列结果，包含初始的两个值（direction的结果）
     */
    public static int[] resultQueue;
    public static int N;

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        init();
        nStepCScan();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("==============================================================");
        showList();
        showASL();
        System.out.println("==============================================================");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private static void nStepCScan() {
        int currIndex = 2;
        for (int i = 0; i < fifo.length; i += N) {
            int line = Math.min(i + N, fifo.length);
            Arrays.sort(fifo, i, line);
            if (i == 0) {
                resultQueue[0] = direction[0];
                resultQueue[1] = direction[1];
            }
            int bigIndex = getBigIndex(resultQueue[currIndex - 1], i, line);
            bigIndex = bigIndex == -1 ? line : bigIndex;
            if (direction[1] - direction[0] > 0) {
                // 增大方向
                for (int j = bigIndex; j < line; j++) {
                    resultQueue[currIndex++] = fifo[j];
                }
                for (int j = i; j < bigIndex; j++) {
                    resultQueue[currIndex++] = fifo[j];
                }
            } else {
                // 减小方向
                for (int j = bigIndex - 1; j >= i; j--) {
                    resultQueue[currIndex++] = fifo[j];
                }
                for (int j = line - 1; j >= bigIndex; j--) {
                    resultQueue[currIndex++] = fifo[j];
                }
            }
        }
    }

    public static void showASL() {
        int currIndex = 1;
        StringBuilder sb = new StringBuilder();
        int resultA = 0;
        if (direction[1] - direction[0] > 0) {
            for (int i = 0; i < resultQueue.length - 1; i++) {
                if (resultQueue[i] > resultQueue[i + 1]) {
                    if (resultA == 0) {
                        sb.append("(").append(resultQueue[i]).append("-").append(resultQueue[currIndex]).append(")");
                    } else {
                        sb.append("+(").append(resultQueue[i]).append("-").append(resultQueue[currIndex]).append(")");
                    }
                    sb.append("+(").append(resultQueue[i]).append("-").append(resultQueue[i + 1]).append(")");
                    resultA += resultQueue[i] * 2 - resultQueue[currIndex] - resultQueue[i + 1];
                    currIndex = i + 1;
                }
            }
            sb.append("+(").append(resultQueue[resultQueue.length - 1]).append("-").append(resultQueue[currIndex]).append(")");
            resultA += resultQueue[resultQueue.length - 1] - resultQueue[currIndex];
        } else {
            for (int i = 0; i < resultQueue.length - 1; i++) {
                if (resultQueue[i] < resultQueue[i + 1]) {
                    if (resultA == 0) {
                        sb.append("(").append(resultQueue[currIndex]).append("-").append(resultQueue[i]).append(")");
                    } else {
                        sb.append("+(").append(resultQueue[currIndex]).append("-").append(resultQueue[i]).append(")");
                    }
                    sb.append("+(").append(resultQueue[i + 1]).append("-").append(resultQueue[i]).append(")");
                    resultA += resultQueue[currIndex] + resultQueue[i + 1] - resultQueue[i] * 2;
                    currIndex = i + 1;
                }
            }
            sb.append("+(").append(resultQueue[currIndex]).append("-").append(resultQueue[resultQueue.length - 1]).append(")");
            resultA += resultQueue[currIndex] - resultQueue[resultQueue.length - 1];
        }
        System.out.println("        " + sb.toString());
        System.out.println("ASL=-------------------------------------------------------------------------");
        System.out.println("                " + fifo.length);
        System.out.printf("   =%.2f\n", resultA * 1.0 / fifo.length);
    }

    public static void showList() {
        System.out.print(resultQueue[0] + "#->" + resultQueue[1] + "#");
        for (int i = 2; i < resultQueue.length; i++) {
            System.out.print("," + resultQueue[i]);
        }
        System.out.println();
    }

    public static int getBigIndex(int key, int fromIndex, int toIndex) {
        for (int i = fromIndex; i < toIndex; i++) {
            if (fifo[i] > key) {
                return i;
            }
        }
        return -1;
    }

    private static void init() {
        System.out.print("请输入给出的两个磁道号（空格分隔，举例：86 98）：");
        Scanner scanner = new Scanner(System.in);
        String[] dirStrArr = scanner.nextLine().split(" ");
        direction = new int[2];
        direction[0] = Integer.parseInt(dirStrArr[0]);
        direction[1] = Integer.parseInt(dirStrArr[1]);
        System.out.print("请输入磁道号队列FIFO（空格分隔）：");
        String[] fifoStrArr = scanner.nextLine().split(" ");
        fifo = new int[fifoStrArr.length];
        for (int i = 0; i < fifoStrArr.length; i++) {
            fifo[i] = Integer.parseInt(fifoStrArr[i]);
        }
        System.out.print("请输入N：");
        N = scanner.nextInt();
//        direction = new int[]{129, 131};
//        direction = new int[]{131, 129};
//        fifo = new int[]{269, 228, 105, 268, 134, 190, 273, 229, 63, 182, 266, 171, 199, 70, 179, 138, 237, 148, 90, 283, 97};
//        N = 8;
        resultQueue = new int[direction.length + fifo.length];
    }

}
