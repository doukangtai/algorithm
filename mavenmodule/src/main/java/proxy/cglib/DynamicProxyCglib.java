package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 窦康泰
 * @date 2021/01/21
 */
public class DynamicProxyCglib {
    public static void main(String[] args) {
        MyClass proxyObject = (MyClass) MyProxy.getProxy(MyClass.class);
        String say = proxyObject.say("嘿嘿嘿");
        System.out.println(say);
    }
}

class MyProxy {
    public static Object getProxy(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new MyMethodInterceptor());
        return enhancer.create();
    }
}

class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before");
        Object invokeSuper = methodProxy.invokeSuper(o, objects);
        System.out.println("after");
        return invokeSuper;
    }
}

class MyClass {
    public String say(String msg) {
        System.out.println("说的内容：" + msg);
        return msg;
    }
}
