package designpattern.proxy.stc;

/**
 * @author 窦康泰
 * @date 2021/01/21
 */
public class StaticProxy {
    public static void main(String[] args) {
        String say = new MyProxy(new MyClass()).say("哈哈哈");
        System.out.println(say);
    }
}

class MyProxy implements MyInterface {

    private MyInterface myInterface;

    public MyProxy(MyInterface myInterface) {
        this.myInterface = myInterface;
    }

    @Override
    public String say(String msg) {
        System.out.println("before");
        String say = myInterface.say(msg);
        System.out.println("after");
        return msg;
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
