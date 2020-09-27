package learn.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 窦康泰
 * @date 2020/09/24
 */
public class ReversePolishNotation {

    public static void main(String[] args) {
        String suffixExpression = "1 2 + 3 * 40 -";
        List<String> list = getListString(suffixExpression);
        System.out.println(calculate(list));
    }

    public static List<String> getListString(String suffixExpression) {
        String[] strings = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String string : strings) {
            list.add(string);
        }
        return list;
    }

    public static int calculate(List<String> list) {
        int num1;
        int num2;
        int sum;
        Stack<Integer> stack = new Stack<>();
        for (String s : list) {
            if (s.equals("+")) {
                num2 = stack.pop();
                num1 = stack.pop();
                sum = num1 + num2;
                stack.push(sum);
            } else if (s.equals("-")) {
                num2 = stack.pop();
                num1 = stack.pop();
                sum = num1 - num2;
                stack.push(sum);
            } else if (s.equals("*")) {
                num2 = stack.pop();
                num1 = stack.pop();
                sum = num1 * num2;
                stack.push(sum);
            } else if (s.equals("/")) {
                num2 = stack.pop();
                num1 = stack.pop();
                sum = num1 / num2;
                stack.push(sum);
                // 正则表达式匹配多位数
            } else if (s.matches("\\d+")) {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

}
