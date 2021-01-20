package designpattern.singleton.type4;

/**
 * @author 窦康泰
 * @date 2021/01/20
 */
public class Singleton4 {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println("instance1 == instance2 ? " + (instance1 == instance2));
        System.out.println("instance1.hashCode() = " + instance1.hashCode());
        System.out.println("instance2.hashCode() = " + instance2.hashCode());
    }
}

/**
 * 懒汉式（线程安全，同步方法，效率低）
 */
class Singleton {
    private Singleton() {
    }

    private static Singleton instance;

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
