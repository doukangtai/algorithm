package learn.queue;

/**
 * @Author 窦康泰
 * @Date 2020-08-13 12:42
 *
 * 循环数组队列
 * 1. (maxSize - front + rear) % maxSize获取当前队列元素个数
 * 2. (rear + 1) % maxSize == front判断当前队列是否满
 * 3. 注意数组越界，用 % 取模
 */
public class CircleArrayQueue {

    private int maxSize;

    private int front;

    private int rear;

    private int[] queue;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        // front指向队列头数据
        this.front = 0;
        // rear指向队列尾数据的下一个位置，预留了一个位置，因此最多添加maxSize-1个元素
        this.rear = 0;
        this.queue = new int[maxSize];
    }

    public boolean isNull() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public int queueSize() {
        return (maxSize - front + rear) % maxSize;
    }

    public void add(int element) {
        if (isFull()) {
            throw new RuntimeException("队列满，添加失败");
        }
        queue[rear] = element;
        rear = (rear + 1) % maxSize;
    }

    public int get() {
        if (isNull()) {
            throw new RuntimeException("队列空，出队列失败");
        }
        int temp = queue[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    public void show() {
        for (int i = front; i < front + queueSize(); i++) {
            System.out.println(i % maxSize + ":" + queue[i % maxSize]);
        }
    }

    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(5);
        System.out.println("原始队列");
        queue.show();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
//        queue.add(5);
//        queue.add(6);
        System.out.println("添加后");
        queue.show();
        queue.get();
        queue.get();
//        queue.get();
//        queue.get();
//        queue.get();
        System.out.println("2个元素出队列后");
        queue.show();
        queue.add(11);
        queue.add(12);
        System.out.println("添加11、12后");
        queue.show();
    }

}
