package learn.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 窦康泰
 * @date 2020/09/26
 */
public class InfixExpressionToReversePolishNotation {

    public static void main(String[] args) {
        String infixExpression = "10+((2+3-3)*4)-50";
        List<String> list = getList(infixExpression);
        List<String> parse = parse(list);
        System.out.println(parse);
        int calculate = ReversePolishNotation.calculate(parse);
        System.out.println(calculate);
    }

    public static List<String> getList(String infixExpression) {
        int len = infixExpression.length();
        List<String> list = new ArrayList<>();
        String s = "";
        for (int i = 0; i < len; i++) {
            char c = infixExpression.charAt(i);
            if (c < 48 || c > 57) {
                list.add(String.valueOf(c));
            } else {
                s += c;
                if (i >= len - 1) {
                    list.add(s);
                    s = "";
                    break;
                }
                char c2 = infixExpression.charAt(i + 1);
                if (c2 < 48 || c2 > 57) {
                    list.add(s);
                    s = "";
                }
            }
        }
        return list;
    }

    public static List<String> parse(List<String> infixExpressionList) {
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        for (String s : infixExpressionList) {
            if (s.matches("\\d+")) {
                list.add(s);
            } else if (s.equals("(")) {
                stack.push(s);
            } else if (s.equals(")")) {
                while (!stack.peek().equals("(")) {
                    list.add(stack.pop());
                }
                stack.pop();
            } else if (stack.empty()) {
                stack.push(s);
            } else {
                if (getOperatorPriority(s) > getOperatorPriority(stack.peek())) {
                    stack.push(s);
                } else {
                    while (!stack.empty() && getOperatorPriority(s) <= getOperatorPriority(stack.peek())) {
                        list.add(stack.pop());
                    }
                    stack.push(s);
                }
            }
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public static int getOperatorPriority(String operator) {
        int flag = 0;
        switch (operator) {
            case "+":
            case "-":
                flag = 1;
                break;
            case "*":
            case "/":
                flag = 2;
                break;
            default:
                break;
        }
        return flag;
    }

}
