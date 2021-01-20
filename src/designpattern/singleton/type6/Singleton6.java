package designpattern.singleton.type6;

/**
 * @author 窦康泰
 * @date 2021/01/20
 */
public class Singleton6 {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println("instance1 == instance2 ? " + (instance1 == instance2));
        System.out.println("instance1.hashCode() = " + instance1.hashCode());
        System.out.println("instance2.hashCode() = " + instance2.hashCode());
    }
}

/**
 * 静态内部类
 */
class Singleton {
    private Singleton() {
    }

    private static class SingletonInstance {
        private static final Singleton SINGLETON = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonInstance.SINGLETON;
    }
}
