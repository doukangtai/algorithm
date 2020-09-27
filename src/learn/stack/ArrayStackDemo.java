package learn.stack;

/**
 * @author 窦康泰
 * @date 2020/09/20
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
//        stack.push(5);
//        stack.push(6);
        System.out.println("原始队列");
        stack.show();
        System.out.println("出栈元素");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
        System.out.println("出栈后队列");
        stack.show();
    }
}

class ArrayStack {

    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isNull() {
        return top == -1;
    }

    public boolean isFull() {
        return maxSize - 1 == top;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("队列满");
            return;
        }
        stack[++top] = value;
    }

    public int pop() {
        if (isNull()) {
            throw new RuntimeException("队列空");
        }
        return stack[top--];
    }

    public void show() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

}
