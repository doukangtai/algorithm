package learn.queue;

/**
 * @Author 窦康泰
 * @Date 2020-08-13 10:50
 */
public class ArrayQueue {

    private int maxSize;

    private int front;

    private int rear;

    private int[] queue;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        // front指向队列头数据
        this.front = 0;
        // rear指向队列尾的后一个位置
        this.rear = 0;
        this.queue = new int[maxSize];
    }

    public boolean isNull() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == maxSize;
    }

    public void add(int element) {
        if (isFull()) {
            throw new RuntimeException("队列满，添加失败");
        }
        queue[rear++] = element;
    }

    public int get() {
        if (isNull()) {
            throw new RuntimeException("队列空，出队列失败");
        }
        return queue[front++];
    }

    public void show() {
        for (int i = front; i < rear; i++) {
            System.out.println(i + ":" + queue[i]);
        }
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        System.out.println("原始队列");
        arrayQueue.show();
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);
        System.out.println("添加3个数据");
        arrayQueue.show();
        arrayQueue.get();
        arrayQueue.get();
        System.out.println("取出2个数据");
        arrayQueue.show();
    }

}
