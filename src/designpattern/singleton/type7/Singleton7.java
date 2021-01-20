package designpattern.singleton.type7;

/**
 * @author 窦康泰
 * @date 2021/01/20
 */
public class Singleton7 {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println("instance1 == instance2 ? " + (instance1 == instance2));
        System.out.println("instance1.hashCode() = " + instance1.hashCode());
        System.out.println("instance2.hashCode() = " + instance2.hashCode());
        Singleton.say();
    }
}

/**
 * 枚举
 */
enum  Singleton {
    INSTANCE;

    public static void say() {
        System.out.println("aaa");
    }
}
