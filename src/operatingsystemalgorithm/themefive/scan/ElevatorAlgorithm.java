package operatingsystemalgorithm.themefive.scan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 窦康泰
 * @date 2020/11/03
 */
public class ElevatorAlgorithm {

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

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        init();
        elevatorAlgorithm();
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

    public static void elevatorAlgorithm() {
        Arrays.sort(fifo);
        resultQueue[0] = direction[0];
        resultQueue[1] = direction[1];
        if (direction[1] - direction[0] > 0) {
            // 增大方向
            int bigIndex = getBigIndex();
            int currIndex = 2;
            for (int i = bigIndex; i < fifo.length; i++) {
                resultQueue[currIndex++] = fifo[i];
            }
            for (int i = bigIndex - 1; i >= 0; i--) {
                resultQueue[currIndex++] = fifo[i];
            }
        } else {
            // 减小方向
            int bigIndex = getBigIndex();
            int currIndex = 2;
            for (int i = bigIndex - 1; i >= 0; i--) {
                resultQueue[currIndex++] = fifo[i];
            }
            for (int i = bigIndex; i < fifo.length; i++) {
                resultQueue[currIndex++] = fifo[i];
            }
        }
    }

    public static void showList() {
        System.out.print(resultQueue[0] + "#->" + resultQueue[1] + "#");
        for (int i = 2; i < resultQueue.length; i++) {
            System.out.print("," + resultQueue[i]);
        }
        System.out.println();
    }

    public static void showASL() {
        int currIndex = 1;
        StringBuilder sb = new StringBuilder();
        int resultA = 0;
        if (direction[1] - direction[0] > 0) {
            for (int i = 0; i < resultQueue.length - 1; i++) {
                if (resultQueue[i] > resultQueue[i + 1]) {
                    sb.append("(").append(resultQueue[i]).append("-").append(resultQueue[currIndex]).append(")");
                    resultA += resultQueue[i] - resultQueue[currIndex];
                    currIndex = i;
                    break;
                }
            }
            sb.append("+(").append(resultQueue[currIndex]).append("-").append(resultQueue[resultQueue.length - 1]).append(")");
            resultA += resultQueue[currIndex] - resultQueue[resultQueue.length - 1];
        } else {
            for (int i = 0; i < resultQueue.length - 1; i++) {
                if (resultQueue[i] < resultQueue[i + 1]) {
                    sb.append("(").append(resultQueue[currIndex]).append("-").append(resultQueue[i]).append(")");
                    resultA += resultQueue[currIndex] - resultQueue[i];
                    currIndex = i;
                    break;
                }
            }
            sb.append("+(").append(resultQueue[resultQueue.length - 1]).append("-").append(resultQueue[currIndex]).append(")");
            resultA += resultQueue[resultQueue.length - 1] - resultQueue[currIndex];
        }
        System.out.println("        " + sb.toString());
        System.out.println("ASL=-------------------------------------------------------------------------");
        System.out.println("                " + fifo.length);
        System.out.printf("   =%.2f\n", resultA * 1.0 / fifo.length);
    }

    public static int getBigIndex() {
        for (int i = 0; i < fifo.length; i++) {
            if (fifo[i] > direction[1]) {
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
//        direction = new int[]{177, 150};
//        direction = new int[]{150, 177};
//        fifo = new int[]{297, 193, 15, 167, 200, 141, 88, 257, 169, 278, 183, 238, 277, 234, 52, 267, 73};
        resultQueue = new int[direction.length + fifo.length];
    }

}
