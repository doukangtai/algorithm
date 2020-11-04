package operatingsystemalgorithm.themethree.bankeralgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author 窦康泰
 * @date 2020/10/25
 */
public class BankerAlgorithm {

    public static int[] resource;
    public static Process[] processes;
    public static int processCount = 5;
    public static int resourceCount = 3;
    public static int pointer = 0;
    public static List<Process> processList;

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        // 初始化给定数据
        init();
        // 调用银行家算法
        bankerAlgorithm();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("==============================================================");
        showFirstTable();
        showSecondTable();
        System.out.println("==============================================================");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static void showSecondTable() {
        System.out.println("Process        Work            Need         Allocation   Work+Allocation   Finish");
        System.out.println("            A   B   C       A   B   C       A   B   C       A   B   C");
        for (int i = 0; i < processList.size(); i++) {
            Process process = processList.get(i);
            System.out.print("  " + process.name + "        ");
            for (int j = 0; j < process.work.length; j++) {
                System.out.printf("%-4d", process.work[j]);
            }
            System.out.print("    ");
            for (int j = 0; j < process.need.length; j++) {
                System.out.printf("%-4d", process.need[j]);
            }
            System.out.print("    ");
            for (int j = 0; j < process.allocation.length; j++) {
                System.out.printf("%-4d", process.allocation[j]);
            }
            System.out.print("    ");
            for (int j = 0; j < resourceCount; j++) {
                System.out.printf("%-4d", process.work[j] + process.allocation[j]);
            }
            System.out.println("    true");
        }
        System.out.println("Therefore,To is a (safe) state");
        System.out.print("Safe sequence is {");
        for (int i = 0; i < processList.size(); i++) {
            if (i == 0) {
                System.out.print(processList.get(i).name);
            } else {
                System.out.print("," + processList.get(i).name);
            }
        }
        System.out.println("}");
    }

    public static void showFirstTable() {
        System.out.println("Process    Max          Allocation        Need          Available");
        System.out.println("          A   B   C       A   B   C       A   B   C       A   B   C");
        for (int i = 0; i < processes.length; i++) {
            System.out.print(processes[i].name + "        ");
            for (int j = 0; j < resourceCount; j++) {
                System.out.printf("%-4d", processes[i].max[j]);
            }
            System.out.print("    ");
            for (int j = 0; j < resourceCount; j++) {
                System.out.printf("%-4d", processes[i].allocation[j]);
            }
            System.out.print("    ");
            for (int j = 0; j < resourceCount; j++) {
                System.out.printf("%-4d", processes[i].need[j]);
            }
            if (i == 0) {
                System.out.print("    ");
                int[] originalAvailable = getOriginalAvailable();
                for (int j = 0; j < originalAvailable.length; j++) {
                    System.out.printf("%-4d", originalAvailable[j]);
                }
            }
            System.out.println();
        }
    }

    /**
     * 银行家算法思想
     */
    public static void bankerAlgorithm() {
        // 计算need
        initNeed();
        // 获取Available数组
        int[] tempAvailable = getOriginalAvailable();
        processList = new ArrayList<>();
        for (int i = 0; i < processCount; i++) {
            // 获取一个可以执行的进程
            Process isExeProcess = getIsExeProcess(tempAvailable);
            // 将指向这个可执行进程的指针下移
            pointerMove();
            // 将可执行进程添加进List中
            processList.add(isExeProcess);
            for (int j = 0; j < tempAvailable.length; j++) {
                // 计算当前可执行进程在执行完之后系统剩余可利用资源，即：Work+Allocation
                tempAvailable[j] = isExeProcess.work[j] + isExeProcess.allocation[j];
            }
        }
    }

    /**
     * 获取最初没执行任何一个进程时，系统可用资源数组
     * @return
     */
    public static int[] getOriginalAvailable() {
        int[] tempAvailable = new int[resourceCount];
        for (int i = 0; i < resourceCount; i++) {
            int tempSum = 0;
            for (int j = 0; j < processes.length; j++) {
                tempSum += processes[j].allocation[i];
            }
            tempAvailable[i] = resource[i] - tempSum;
        }
        return tempAvailable;
    }

    /**
     * 获取一个可以执行的进程
     * @param tempAvailable 当前可用资源总量数组
     * @return
     */
    public static Process getIsExeProcess(int[] tempAvailable) {
        int breakCount = 0;
        while (true) {
            int tempCount = 0;
            for (int j = 0; j < processes[pointer].need.length; j++) {
                if (processes[pointer].need[j] <= tempAvailable[j]) {
                    tempCount++;
                }
            }
            breakCount++;
            if (tempCount == 3 && !processes[pointer].isUsed) {
                for (int i = 0; i < processes[pointer].work.length; i++) {
                    processes[pointer].work[i] = tempAvailable[i];
                }
                processes[pointer].isUsed = true;
                return processes[pointer];
            } else if (breakCount >= processCount) {
                break;
            }
            pointerMove();
        }
        return null;
    }

    /**
     * 5个进程循环扫描，指针移动方法
     */
    public static void pointerMove() {
        if (pointer != processCount - 1) {
            pointer++;
        } else {
            pointer = 0;
        }
    }

    /**
     * 计算need的值
     */
    public static void initNeed() {
        for (int i = 0; i < processes.length; i++) {
            int tempCount = 3;
            for (int j = 0; j < tempCount; j++) {
                processes[i].need[j] = processes[i].max[j] - processes[i].allocation[j];
            }
        }
    }

    /**
     * 初始化以及输入数据
     */
    public static void init() {
        System.out.print("请输入全部资源总量（空格分隔）：");
        Scanner scanner = new Scanner(System.in);
        resource = new int[resourceCount];
        for (int i = 0; i < resourceCount; i++) {
            resource[i] = scanner.nextInt();
        }
        processes = new Process[processCount];
        for (int i = 0; i < processCount; i++) {
            System.out.print("请输入P" + i + "的Max和Allocation（空格分隔）：");
            int[] max = new int[resourceCount];
            int[] allocation = new int[resourceCount];
            int[] need = new int[resourceCount];
            int[] work = new int[resourceCount];
            for (int j = 0; j < max.length; j++) {
                max[j] = scanner.nextInt();
            }
            for (int j = 0; j < allocation.length; j++) {
                allocation[j] = scanner.nextInt();
            }
            processes[i] = new Process("P" + i, max, allocation, need, work);
        }
    }

}

class Process {
    public String name;
    public int[] max;
    public int[] allocation;
    public int[] need;
    public int[] work;
    /**
     * 判断进程是否已经执行过
     */
    public boolean isUsed;

    public Process(String name, int[] max, int[] allocation, int[] need, int[] work) {
        this.name = name;
        this.max = max;
        this.allocation = allocation;
        this.need = need;
        this.work = work;
    }

    @Override
    public String toString() {
        return "Process{" +
                "\nname='" + name + '\'' +
                ", \nmax=" + Arrays.toString(max) +
                ", \nallocation=" + Arrays.toString(allocation) +
                ", \nneed=" + Arrays.toString(need) +
                ", \nwork=" + Arrays.toString(work) +
                ", \nisUsed=" + isUsed +
                "}\n\n";
    }
}
