package imooc.design.pattern.creational.singleton;

/**
 * @author 窦康泰
 * @date 2021/07/10
 */
public class Test {
    public static void main(String[] args) {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                StaticInnerClassSingleton instance = StaticInnerClassSingleton.getInstance();
//                System.out.println(Thread.currentThread().getName() + "\t" + instance);
//            }
//        };
//        Thread t1 = new Thread(runnable);
//        Thread t2 = new Thread(runnable);
//        t1.start();
//        t2.start();
//        System.out.println("main end");

        EnumInstance.getInstance().printTest();
    }
}
