package designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author 窦康泰
 * @Date 2020-08-21 10:14
 */
public class DynamicProxyJDK {

    public static void main(String[] args) {
        MyInterface myProxyObject = (MyInterface) MyProxy.getMyProxyObject(new MyClass());
        String say = myProxyObject.say("你好啊，小伙子");
        System.out.println(say);
    }
}

class MyProxy {
    public static Object getMyProxyObject(Object o) {
        Object newProxyInstance = Proxy.newProxyInstance(
                o.getClass().getClassLoader(),
                o.getClass().getInterfaces(),
                new MyInvocationHandler(o)
        );
        return newProxyInstance;
    }
}

class MyInvocationHandler implements InvocationHandler {

    private Object object;

    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object invoke = method.invoke(object, args);
        System.out.println("after");
        return invoke;
    }
}

class MyClass implements MyInterface {
    @Override
    public String say(String msg) {
        System.out.println("说的内容：" + msg);
        return msg;
    }
}

interface MyInterface {
    String say(String msg);
}
