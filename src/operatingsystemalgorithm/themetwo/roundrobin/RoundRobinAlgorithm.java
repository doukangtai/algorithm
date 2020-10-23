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
        q = 4;
        processes = new Process[5];
        processes[0] = new Process("P1", 0, 26);
        processes[1] = new Process("P2", 1, 21);
        processes[2] = new Process("P3", 7, 13);
        processes[3] = new Process("P4", 15, 12);
        processes[4] = new Process("P5", 17, 9);

        isInProcessNames = new boolean[processes.length];

        int sum = 0;
        for (int i = 0; i < processes.length; i++) {
            sum += processes[i].serviceTime;
        }
        sum += processes.length * q;
        processNames = new String[sum / 4];
        processNames[0] = processes[0].name;
        isInProcessNames[0] = true;
        serviceTimes = new int[sum / 4];
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
            if (processServiceTime > q) {
                serviceTimes[indexServiceTimes + 1] = serviceTimes[indexServiceTimes] + q;
                indexServiceTimes++;
                addProcessToProcessNames(serviceTimes[indexServiceTimes]);
                updateServiceTime(processNames[frontIndexProcessNames], q);
                addFrontProcessNameToRear();
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
}

class Process {
    public String name;
    public int arrivalTime;
    public int serviceTime;

    public Process(String name, int arrivalTime, int serviceTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }

    @Override
    public String toString() {
        return "Process{" +
                "name='" + name + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", serviceTime=" + serviceTime +
                '}';
    }
}
