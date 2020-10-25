package operatingsystemalgorithm.themeone.processsynchronizationmodel;

import java.util.*;

/**
 * @author 窦康泰
 * @date 2020/10/25
 */
public class ProcessSynchronizationModel {
    public static String processNameA;
    public static String processNameB;
    public static int priority;
    public static String[] processExpressionArrayA;
    public static String[] processExpressionArrayB;
    public static List<Map<String, Integer>> valueList;
    public static int preemptive;

    public static void main(String[] args) {
        init();
        showInfo();
    }

    public static void showInfo() {
        System.out.println("processNameA:" + processNameA);
        System.out.println("processNameB:" + processNameB);
        System.out.println("priority:" + priority);
        System.out.println("processExpressionArrayA:" + Arrays.toString(processExpressionArrayA));
        System.out.println("processExpressionArrayB:" + Arrays.toString(processExpressionArrayB));
        System.out.println("valueList:" + valueList);
        System.out.println("preemptive:" + preemptive);
    }

    public static void init() {
        System.out.println("==========================================");
        System.out.println("||                                      ||");
        System.out.println("||    输入的英文字母必须为 全大写 或 全小写    ||");
        System.out.println("||                                      ||");
        System.out.println("==========================================");
        System.out.print("请输入两个进程的名称（空格分隔）：");
        Scanner scanner = new Scanner(System.in);
        String[] processNameArr = scanner.nextLine().split(" ");
        processNameA = processNameArr[0];
        processNameB = processNameArr[1];
        System.out.print("若进程" + processNameA + "的优先级高，请输入0；若进程" + processNameB + "的优先级高，请输入1：");
        priority = scanner.nextInt();
        scanner.nextLine();
        System.out.print("请输入进程" + processNameA + "的6个运算表达式（空格分隔）：");
        processExpressionArrayA = scanner.nextLine().split(" ");
        System.out.print("请输入进程" + processNameB + "的6个运算表达式（空格分隔）：");
        processExpressionArrayB = scanner.nextLine().split(" ");
        System.out.print("请输入三个变量的初值（举例格式：A=15 B=25 C=35)：");
        String[] initVariableValueStrArr = scanner.nextLine().split(" ");
        valueList = new ArrayList<>();
        for (int i = 0; i < initVariableValueStrArr.length; i++) {
            String[] varAndValueStrArr = initVariableValueStrArr[i].split("=");
            Map<String, Integer> valueMap = new HashMap<>();
            valueMap.put(varAndValueStrArr[0], Integer.parseInt(varAndValueStrArr[1]));
            valueList.add(valueMap);
        }
        System.out.print("若采用非抢占式优先级调度算法，请输入0；若采用抢占式优先级调度算法，请输入1：");
        preemptive = scanner.nextInt();
    }
}
