package imooc.design.pattern.creational.singleton;

/**
 * @author 窦康泰
 * @date 2021/07/10
 */
public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton() {
    }

    private static class InnerClass {
        private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return InnerClass.staticInnerClassSingleton;
    }
}
