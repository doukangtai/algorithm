package designpattern.singleton.type5;

/**
 * @author 窦康泰
 * @date 2021/01/20
 */
public class Singleton5 {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println("instance1 == instance2 ? " + (instance1 == instance2));
        System.out.println("instance1.hashCode() = " + instance1.hashCode());
        System.out.println("instance2.hashCode() = " + instance2.hashCode());
    }
}

/**
 * 懒汉式（线程安全，双重检查 double-check，效率高，volatile保证不同线程对instance的可见性）
 */
class Singleton {
    private Singleton() {
    }

    private volatile static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
