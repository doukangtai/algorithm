package designpattern.singleton;

/**
 * @author 窦康泰
 * @date 2021/01/21
 * 静态内部类
 * JVM保证单例
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 */
public class Mgr07 {
    private Mgr07() {
    }

    private static class Mgr07Holder {
        private static final Mgr07 INSTANCE = new Mgr07();
    }

    public static Mgr07 getInstance() {
        return Mgr07Holder.INSTANCE;
    }

    public static void main(String[] args) {
        Mgr07 m1 = Mgr07.getInstance();
        Mgr07 m2 = Mgr07.getInstance();
        System.out.println(m1 == m2);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr07.getInstance().hashCode());
            }).start();
        }
    }
}
