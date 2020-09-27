package learn.stack;

/**
 * @author 窦康泰
 * @date 2020/09/21
 */
public class Calculator {
    public static void main(String[] args) {
        String exp = "100+20*30/40-15";
        int len = exp.length();
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operatorStack = new ArrayStack2(10);
        char c;
        int num1;
        int num2;
        String s = "";
        for (int i = 0; i < len; i++) {
            c = exp.charAt(i);
            if (!operatorStack.isOperator(c)) {
//                numStack.push(c - 48);
                s += c;
                if (i >= len - 1) {
                    numStack.push(Integer.parseInt(s));
                    break;
                }
                if (operatorStack.isOperator(exp.charAt(i + 1))) {
                    numStack.push(Integer.parseInt(s));
                    s = "";
                }
            } else {
                if (operatorStack.isNull()) {
                    operatorStack.push(c);
                } else {
                    if (operatorStack.priority((char) operatorStack.peek()) >= operatorStack.priority(c)) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        char oper = (char) operatorStack.pop();
                        int v = operatorStack.cal(num2, num1, oper);
                        numStack.push(v);
                        operatorStack.push(c);
                    } else {
                        operatorStack.push(c);
                    }
                }
            }
        }
        while (!operatorStack.isNull()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            c = (char) operatorStack.pop();
            numStack.push(operatorStack.cal(num2, num1, c));
        }
        System.out.println(numStack.pop());
    }
}

class ArrayStack2 {

    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return maxSize - 1 == top;
    }

    public boolean isNull() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
        } else {
            stack[++top] = value;
        }
    }

    public int pop() {
        if (isNull()) {
            throw new RuntimeException("栈空");
        } else {
            return stack[top--];
        }
    }

    public int peek() {
        if (isNull()) {
            throw new RuntimeException("栈空");
        } else {
            return stack[top];
        }
    }

    public int priority(char operator) {
        if (operator == '*' || operator == '/') {
            return 2;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/') {
            return true;
        } else {
            return false;
        }
    }

    public int cal(int num1, int num2, char c) {
        int value = 0;
        switch (c) {
            case '+':
                value = num1 + num2;
                break;
            case '-':
                value = num1 - num2;
                break;
            case '*':
                value = num1 * num2;
                break;
            case '/':
                value = num1 / num2;
                break;
            default:
                break;
        }
        return value;
    }

}
