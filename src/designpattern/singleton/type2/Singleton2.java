package designpattern.singleton.type2;

/**
 * @author 窦康泰
 * @date 2021/01/20
 */
public class Singleton2 {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println("instance1 == instance2 ? " + (instance1 == instance2));
        System.out.println("instance1.hashCode() = " + instance1.hashCode());
        System.out.println("instance2.hashCode() = " + instance2.hashCode());
    }
}

/**
 * 饿汉式（静态代码块）
 */
class Singleton {
    private Singleton() {
    }

    private static Singleton instance;

    static {
        instance = new Singleton();
    }

    public static Singleton getInstance() {
        return instance;
    }
}
