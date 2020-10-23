package operatingsystemalgorithm.themetwo.roundrobin;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2020/10/23
 */
public class RoundRobinAlgorithm {
    public static void main(String[] args) {
        RoundRobin roundRobin = new RoundRobin();
        roundRobin.createGanttChart();
        roundRobin.showProcessNames();
        roundRobin.showServiceTimes();
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

    public RoundRobin() {
//        q = 1;
        q = 4;
        processes = new Process[5];

        processes[0] = new Process("P1", 0, 21);
        processes[1] = new Process("P2", 3, 20);
        processes[2] = new Process("P3", 12, 15);
        processes[3] = new Process("P4", 20, 12);
        processes[4] = new Process("P5", 27, 9);

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

    public void createGanttChart() {
        while (frontIndexProcessNames <= rearIndexProcessNames) {
            int processServiceTime = getProcessServiceTime(processNames[frontIndexProcessNames]);
            if (processServiceTime >= q) {
                serviceTimes[indexServiceTimes + 1] = serviceTimes[indexServiceTimes] + q;
                indexServiceTimes++;
                addProcessToProcessNames(serviceTimes[indexServiceTimes]);
                updateServiceTime(processNames[frontIndexProcessNames], q);
                if (processServiceTime > q) {
                    addFrontProcessNameToRear();
                } else if (processServiceTime == q) {
                    frontIndexProcessNames++;
                }
            } else if (processServiceTime > 0) {
                serviceTimes[indexServiceTimes + 1] = serviceTimes[indexServiceTimes] + processServiceTime;
                indexServiceTimes++;
                addProcessToProcessNames(serviceTimes[indexServiceTimes]);
                updateServiceTime(processNames[frontIndexProcessNames], processServiceTime);
                frontIndexProcessNames++;
            }
        }
    }

    public void addFrontProcessNameToRear() {
        processNames[++rearIndexProcessNames] = processNames[frontIndexProcessNames++];
    }

    public void updateServiceTime(String processName, int time) {
        Process process = getProcess(processName);
        process.serviceTime = process.serviceTime - time;
    }

    public void addProcessToProcessNames(int currTime) {
        for (int i = 0; i < processes.length; i++) {
            if (!isInProcessNames[i] && processes[i].arrivalTime <= currTime) {
                processNames[++rearIndexProcessNames] = processes[i].name;
                isInProcessNames[i] = true;
            }
        }
    }

    public int getProcessServiceTime(String processName) {
        Process process = getProcess(processName);
        return process.serviceTime;
    }

    public Process getProcess(String processName) {
        for (int i = 0; i < processes.length; i++) {
            if (processes[i].name.equals(processName)) {
                return processes[i];
            }
        }
        return null;
    }

    public void showProcessNames() {
        System.out.println("processNames=" + Arrays.toString(processNames));
    }

    public void showServiceTimes() {
        System.out.println("serviceTimes=" + Arrays.toString(serviceTimes));
    }

    public void showTable() {
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
            System.out.printf("%5s%5d%5d%5d%5d%8.3f\n", Prs[i], Ft[i], process.arrivalTime, Tr[i], process.saveServiceTime, Wr[i]);
        }
        System.out.printf("T=%.2f\n", sumTr * 1.0 / processes.length);
        System.out.printf("W=%.2f\n", sumWr * 1.0 / processes.length);
    }
}

class Process {
    public String name;
    public int arrivalTime;
    public int serviceTime;

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
