package operatingsystemalgorithm.themetwo.roundrobin;

import java.util.Scanner;

/**
 * @author 窦康泰
 * @date 2020/10/23
 */
public class RoundRobinAlgorithm {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        RoundRobin roundRobin = new RoundRobin();
        roundRobin.createGanttChart();
        roundRobin.showGanttChart();
        roundRobin.showTable();
    }
}

class RoundRobin {
    public int q;
    public Process[] processes;

    public boolean[] isInProcessNames;

    public String[] processNames;
    public int frontIndexProcessNames;
    public int rearIndexProcessNames;
    public int[] serviceTimes;
    public int indexServiceTimes;

    public String[] Prs;
    public int[] Ft;
    public int[] At;
    public int[] Tr;
    public int[] Ts;
    public double[] Wr;

    public double T;
    public double W;

    /**
     * 初始化数据
     */
    public RoundRobin() {
        System.out.println("时间片轮转调度算法");
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入 q = ");
        q = scanner.nextInt();
//        q = 1;
//        q = 4;
        processes = new Process[5];

        int[] at = new int[5];
        int[] st = new int[5];
        System.out.print("请输入到达时间Arrival Time（空格分隔）：");
        for (int i = 0; i < at.length; i++) {
            at[i] = scanner.nextInt();
        }
        System.out.print("请输入服务时间Service Time（空格分隔）：");
        for (int i = 0; i < st.length; i++) {
            st[i] = scanner.nextInt();
        }
        for (int i = 0; i < processes.length; i++) {
            processes[i] = new Process("P" + (i + 1), at[i], st[i]);
        }

//        processes[0] = new Process("P1", 0, 21);
//        processes[1] = new Process("P2", 3, 20);
//        processes[2] = new Process("P3", 12, 15);
//        processes[3] = new Process("P4", 20, 12);
//        processes[4] = new Process("P5", 27, 9);

//        processes[0] = new Process("P1", 0, 6);
//        processes[1] = new Process("P2", 1, 4);
//        processes[2] = new Process("P3", 3, 6);
//        processes[3] = new Process("P4", 7, 5);
//        processes[4] = new Process("P5", 9, 2);

//        processes[0] = new Process("P1", 0, 4);
//        processes[1] = new Process("P2", 1, 5);
//        processes[2] = new Process("P3", 3, 4);
//        processes[3] = new Process("P4", 7, 5);
//        processes[4] = new Process("P5", 11, 2);

//        processes[0] = new Process("P1", 0, 19);
//        processes[1] = new Process("P2", 7, 22);
//        processes[2] = new Process("P3", 15, 15);
//        processes[3] = new Process("P4", 22, 9);
//        processes[4] = new Process("P5", 27, 7);

//        processes[0] = new Process("P1", 0, 26);
//        processes[1] = new Process("P2", 1, 21);
//        processes[2] = new Process("P3", 7, 13);
//        processes[3] = new Process("P4", 15, 12);
//        processes[4] = new Process("P5", 17, 9);

        isInProcessNames = new boolean[processes.length];

        int sum = 0;
        for (int i = 0; i < processes.length; i++) {
            sum += processes[i].serviceTime;
        }
        sum += processes.length * q;
        processNames = new String[sum / q];
        processNames[0] = processes[0].name;
        isInProcessNames[0] = true;
        serviceTimes = new int[sum / q];
        Prs = new String[processes.length];
        Ft = new int[processes.length];
        At = new int[processes.length];
        Tr = new int[processes.length];
        Ts = new int[processes.length];
        Wr = new double[processes.length];
    }

    /**
     * 轮转调度算法
     */
    public void createGanttChart() {
        while (frontIndexProcessNames <= rearIndexProcessNames) {
            // 获取制定进程的serviceTime
            int processServiceTime = getProcessServiceTime(processNames[frontIndexProcessNames]);
            // 判断需要服务的时间是否大于一个轮转周期
            if (processServiceTime >= q) {
                // 更新服务时间数组
                serviceTimes[indexServiceTimes + 1] = serviceTimes[indexServiceTimes] + q;
                // 索引后移
                indexServiceTimes++;
                // 将可以入队列的进程加入进来
                addProcessToProcessNames(serviceTimes[indexServiceTimes]);
                // 更新进程的服务时间
                updateServiceTime(processNames[frontIndexProcessNames], q);
                if (processServiceTime > q) {
                    // 进程还需要继续被服务，再入队列指针后移
                    addFrontProcessNameToRear();
                } else if (processServiceTime == q) {
                    // 最后剩余服务时间刚好够一个q，不再入队列，指针直接后移
                    frontIndexProcessNames++;
                }
            } else if (processServiceTime > 0) {
                // 剩余服务时间大于0并且小于q
                // 更新服务时间数组
                serviceTimes[indexServiceTimes + 1] = serviceTimes[indexServiceTimes] + processServiceTime;
                // 索引后移
                indexServiceTimes++;
                // 将可以入队列的进程加入进来
                addProcessToProcessNames(serviceTimes[indexServiceTimes]);
                // 更新进程的服务时间
                updateServiceTime(processNames[frontIndexProcessNames], processServiceTime);
                // 服务完，不再入队列，指针直接后移
                frontIndexProcessNames++;
            }
        }
    }

    /**
     * 将没服务完的进程继续添加到队列尾
     */
    public void addFrontProcessNameToRear() {
        processNames[++rearIndexProcessNames] = processNames[frontIndexProcessNames++];
    }

    /**
     * 更新进程的服务时间
     *
     * @param processName 进程名
     * @param time        需要减少的服务时间
     */
    public void updateServiceTime(String processName, int time) {
        Process process = getProcess(processName);
        process.serviceTime = process.serviceTime - time;
    }

    /**
     * 将进程添加进processName中
     *
     * @param currTime
     */
    public void addProcessToProcessNames(int currTime) {
        for (int i = 0; i < processes.length; i++) {
            if (!isInProcessNames[i] && processes[i].arrivalTime <= currTime) {
                processNames[++rearIndexProcessNames] = processes[i].name;
                isInProcessNames[i] = true;
            }
        }
    }

    /**
     * 获取制定进程的服务时间
     *
     * @param processName
     * @return
     */
    public int getProcessServiceTime(String processName) {
        Process process = getProcess(processName);
        return process.serviceTime;
    }

    /**
     * 获取制定进程
     *
     * @param processName
     * @return
     */
    public Process getProcess(String processName) {
        for (int i = 0; i < processes.length; i++) {
            if (processes[i].name.equals(processName)) {
                return processes[i];
            }
        }
        return null;
    }

    public void showGanttChart() {
        System.out.println("Gantt Chart:");
        System.out.print("  ");
        for (int i = 0; i < processNames.length; i++) {
            if (processNames[i] != null) {
                System.out.printf("%-4s", processNames[i]);
            }
        }
        System.out.println();
        for (int i = 0; i < serviceTimes.length; i++) {
            if (serviceTimes[i] != 0 || i == 0) {
                System.out.printf("%-4d", serviceTimes[i]);
            }
        }
        System.out.println();
    }

    public void showTable() {
        System.out.println("Table");
        for (int i = processNames.length - 1; i >= 0; i--) {
            if (processNames[i] != null) {
                for (int j = Prs.length - 1; j >= 0; j--) {
                    if (Prs[j] != null && Prs[j].equals(processNames[i])) {
                        break;
                    }
                    if (Prs[j] == null) {
                        Prs[j] = processNames[i];
                        Ft[j] = serviceTimes[i + 1];
                        break;
                    }
                }
            }
            if (Prs[0] != null) {
                break;
            }
        }
        int sumTr = 0;
        double sumWr = 0;
        for (int i = 0; i < Prs.length; i++) {
            Process process = getProcess(Prs[i]);
            Tr[i] = Ft[i] - process.arrivalTime;
            Wr[i] = Tr[i] * 1.0 / process.saveServiceTime;
            sumTr += Tr[i];
            sumWr += Wr[i];
            System.out.printf("%-5s%-5d%-5d%-5d%-5d%-8.3f\n", Prs[i], Ft[i], process.arrivalTime, Tr[i], process.saveServiceTime, Wr[i]);
        }
        System.out.printf("T=%.2f\n", sumTr * 1.0 / processes.length);
        System.out.printf("W=%.2f\n", sumWr * 1.0 / processes.length);
    }
}

class Process {
    public String name;
    public int arrivalTime;
    public int serviceTime;

    // 保存一份serviceTime
    public int saveServiceTime;

    public Process(String name, int arrivalTime, int serviceTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.saveServiceTime = serviceTime;
    }

    @Override
    public String toString() {
        return "Process{" +
                "name='" + name + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", serviceTime=" + serviceTime +
                ", saveServiceTime=" + saveServiceTime +
                '}';
    }
}
