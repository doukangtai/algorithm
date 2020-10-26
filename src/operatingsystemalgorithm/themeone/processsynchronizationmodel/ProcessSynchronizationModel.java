package operatingsystemalgorithm.themeone.processsynchronizationmodel;

import java.util.*;

/**
 * @author 窦康泰
 * @date 2020/10/25
 */
public class ProcessSynchronizationModel {
    /**
     * 第一个进程名（例如：S）
     */
    public static String processNameA;
    /**
     * 第二个进程名
     */
    public static String processNameB;
    /**
     * 第一个进程的优先级高，用0表示；第二个进程的优先级高，用1表示
     */
    public static int priority;
    /**
     * 第一个进程的运算表达式数组
     */
    public static String[] processExpressionArrayA;
    /**
     * 第二个进程的运算表达式数组
     */
    public static String[] processExpressionArrayB;
    /**
     * 初始化变量和值的两个list集合
     */
    public static List<String> keyList;
    public static List<Integer> valueList;
    /**
     * 非抢占式优先级调度算法，用0表示；抢占式优先级调度算法，用1表示
     */
    public static int preemptive;
    /**
     * 并发执行的语句序列
     */
    public static List<String> order;
    /**
     * 当前执行的是哪个进程
     */
    public static int currProcess;

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        init();
        getOrder();
        showInfo();
        System.out.println();
        System.out.println();
        System.out.println();
        getInstruction();
    }

    public static void getInstruction() {
        System.out.println("Initialization   L.Value    R.Value    Q.Value");
        System.out.print("                    ");
        for (int i = 2; i < 5; i++) {
            Integer value = valueList.get(i);
            System.out.printf("%-10d", value);
        }
        System.out.println();
        for (int i = 0; i < order.size(); i++) {
            String prcOrderName = order.get(i);
            if ((prcOrderName.charAt(0) + "").equals(processNameA)) {
                int index = Integer.parseInt(prcOrderName.charAt(1) + "");
                String exp = processExpressionArrayA[index - 1];
                if (keyList.contains(exp.charAt(0) + "")) {
                    System.out.printf("%-15s", exp);
                    if (exp.charAt(2) > '0' && exp.charAt(2) < '9') {
                        int indexVar = keyList.indexOf(exp.charAt(0) + "");
                        valueList.set(indexVar, Integer.parseInt(exp.substring(2)));
                        System.out.printf("%-10d%-10d%-10d\n", valueList.get(2), valueList.get(3), valueList.get(4));
                    } else {
                        int index1 = keyList.indexOf(exp.charAt(0) + "");
                        int index2 = keyList.indexOf(exp.charAt(2) + "");
                        int index3 = keyList.indexOf(exp.charAt(4) + "");
                        Integer v2 = valueList.get(index2);
                        Integer v3 = valueList.get(index3);
                        if (exp.charAt(3) == '+') {
                            valueList.set(index1, v2 + v3);
                            System.out.printf("%-10d%-10d%-10d\n", valueList.get(2), valueList.get(3), valueList.get(4));
                        } else {
                            valueList.set(index1, v2 - v3);
                            System.out.printf("%-10d%-10d%-10d\n", valueList.get(2), valueList.get(3), valueList.get(4));
                        }
                    }
                }
            } else {
                int index = Integer.parseInt(prcOrderName.charAt(1) + "");
                String exp = processExpressionArrayB[index - 1];
                if (keyList.contains(exp.charAt(0) + "")) {
                    System.out.printf("%-15s", exp);
                    if (exp.charAt(2) > '0' && exp.charAt(2) < '9') {
                        int indexVar = keyList.indexOf(exp.charAt(0) + "");
                        valueList.set(indexVar, Integer.parseInt(exp.substring(2)));
                        System.out.printf("%-10d%-10d%-10d\n", valueList.get(2), valueList.get(3), valueList.get(4));
                    } else {
                        int index1 = keyList.indexOf(exp.charAt(0) + "");
                        int index2 = keyList.indexOf(exp.charAt(2) + "");
                        int index3 = keyList.indexOf(exp.charAt(4) + "");
                        Integer v2 = valueList.get(index2);
                        Integer v3 = valueList.get(index3);
                        if (exp.charAt(3) == '+') {
                            valueList.set(index1, v2 + v3);
                            System.out.printf("%-10d%-10d%-10d\n", valueList.get(2), valueList.get(3), valueList.get(4));
                        } else {
                            valueList.set(index1, v2 - v3);
                            System.out.printf("%-10d%-10d%-10d\n", valueList.get(2), valueList.get(3), valueList.get(4));
                        }
                    }
                }
            }
        }
        System.out.printf("%20d%10d%10d\n", valueList.get(2), valueList.get(3), valueList.get(4));
    }

    public static void getOrder() {
        int pointerA = 0;
        int pointerB = 0;
        while (pointerA < 6 || pointerB < 6) {
            if (currProcess == 0) {
                // 执行第一个进程
                while (pointerA < processExpressionArrayA.length) {
                    String expressionCharAt0 = processExpressionArrayA[pointerA].charAt(0) + "";
                    String expressionCharAt2 = processExpressionArrayA[pointerA].charAt(2) + "";
                    if (keyList.contains(expressionCharAt0)) {
                        order.add(processNameA + (pointerA + 1));
                        pointerA++;
                        if (pointerA == 6) {
                            currProcess = 1;
                        }
                    } else if ("P".equals(expressionCharAt0.toUpperCase())) {
                        int index = keyList.indexOf(expressionCharAt2);
                        Integer value = valueList.get(index);
                        value--;
                        valueList.set(index, value);
                        pointerA++;
                        order.add(processNameA + pointerA);
                        if (value < 0) {
                            currProcess = 1;
                            break;
                        }
                    } else if ("V".equals(expressionCharAt0.toUpperCase())) {
                        int index = keyList.indexOf(expressionCharAt2);
                        Integer value = valueList.get(index);
                        value++;
                        valueList.set(index, value);
                        pointerA++;
                        order.add(processNameA + pointerA);
                        if (value <= 0) {
                            if (preemptive == 1 && priority == 1) {
                                currProcess = 1;
                                break;
                            }
                        }
                    }
                }
            } else {
                // 执行第二个进程
                while (pointerB < processExpressionArrayB.length) {
                    String expressionCharAt0 = processExpressionArrayB[pointerB].charAt(0) + "";
                    String expressionCharAt2 = processExpressionArrayB[pointerB].charAt(2) + "";
                    if (keyList.contains(expressionCharAt0)) {
                        order.add(processNameB + (pointerB + 1));
                        pointerB++;
                        if (pointerB == 6) {
                            currProcess = 0;
                        }
                    } else if ("P".equals((expressionCharAt0).toUpperCase())) {
                        int index = keyList.indexOf(expressionCharAt2);
                        Integer value = valueList.get(index);
                        value--;
                        valueList.set(index, value);
                        pointerB++;
                        order.add(processNameB + pointerB);
                        if (value < 0) {
                            currProcess = 0;
                            break;
                        }
                    } else if ("V".equals(expressionCharAt0.toUpperCase())) {
                        int index = keyList.indexOf(expressionCharAt2);
                        Integer value = valueList.get(index);
                        value++;
                        valueList.set(index, value);
                        pointerB++;
                        order.add(processNameB + pointerB);
                        if (value <= 0) {
                            if (preemptive == 1 && priority == 0) {
                                currProcess = 0;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void showInfo() {
        System.out.println("processNameA:" + processNameA);
        System.out.println("processNameB:" + processNameB);
        System.out.println("priority:" + priority);
        System.out.println("processExpressionArrayA:" + Arrays.toString(processExpressionArrayA));
        System.out.println("processExpressionArrayB:" + Arrays.toString(processExpressionArrayB));
        System.out.println("keyList:" + keyList);
        System.out.println("valueList:" + valueList);
        System.out.println("preemptive:" + preemptive);
        System.out.println("order:" + order);
        System.out.println("currProcess:" + currProcess);
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
        currProcess = priority;
        scanner.nextLine();
        System.out.print("请输入进程" + processNameA + "的6个运算表达式（空格分隔）：");
        processExpressionArrayA = scanner.nextLine().split(" ");
        System.out.print("请输入进程" + processNameB + "的6个运算表达式（空格分隔）：");
        processExpressionArrayB = scanner.nextLine().split(" ");
        System.out.print("请输入5个变量的初值（举例格式：A=0 B=0 C=5 D=15 E=25)：");
        String[] initVariableValueStrArr = scanner.nextLine().split(" ");
        keyList = new ArrayList<>();
        valueList = new ArrayList<>();
        for (int i = 0; i < initVariableValueStrArr.length; i++) {
            String[] varAndValueStrArr = initVariableValueStrArr[i].split("=");
            keyList.add(varAndValueStrArr[0]);
            valueList.add(Integer.parseInt(varAndValueStrArr[1]));
        }
        System.out.print("若采用非抢占式优先级调度算法，请输入0；若采用抢占式优先级调度算法，请输入1：");
        preemptive = scanner.nextInt();
        order = new ArrayList<>();
    }
}
