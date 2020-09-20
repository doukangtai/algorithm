package javabasic.t2;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author 窦康泰
 * @Date 2020-08-21 10:15
 */
public class Test {

    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 8888);
            outputStream = socket.getOutputStream();
            Scanner in = new Scanner(System.in);
            while (true) {
                String info = in.next();
                outputStream.write(info.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

////        new ProxyFactory(new RealFactory()).show();
//        Human proxyInstance = (Human) DynamicProxyFactory.getProxyInstance(new Man());
//        proxyInstance.speak();
//        String s = proxyInstance.write("千古绝句");
//        System.out.println("返回的String" + s);
////        Factory proxyInstance = (Factory) DynamicProxyFactory.getProxyInstance(new RealFactory());
////        proxyInstance.show();
    }

}

class Test2 {
//    public static void main(String[] args) {
//        ServerSocket serverSocket = null;
//        Socket socket = null;
//        InputStream socketInputStream = null;
//        try {
//            serverSocket = new ServerSocket(8888);
//                socket = serverSocket.accept();
//                socketInputStream = socket.getInputStream();
//            while (true) {
//                byte[] bytes = new byte[1024];
//                int len = 0;
//                while ((len = socketInputStream.read(bytes)) != -1) {
//                    System.out.println(new String(bytes, 0, len));
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (socketInputStream != null) {
//                try {
//                    socketInputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (socket != null) {
//                try {
//                    socket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (serverSocket != null) {
//                try {
//                    serverSocket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}

class DynamicProxyFactory {

    public static Object getProxyInstance(Object object) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.bind(object);
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), myInvocationHandler);
    }

}

class MyInvocationHandler implements InvocationHandler {

    private Object object;

    public void bind(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println("proxy:" + proxy);
//        System.out.println(proxy.getClass());
//        System.out.println("method:" + method);
//        System.out.println("args:" + Arrays.toString(args));
        return method.invoke(object, args);
    }
}

class Man implements Human {
    @Override
    public void speak() {
        System.out.println("Man说话了！！！");
    }

    @Override
    public String write(String s) {
        System.out.println("Man写的内容：" + s);
        return s;
    }
}

interface Human {

    void speak();

    String write(String s);

}

class RealFactory implements Factory {
    @Override
    public void show() {
        System.out.println("RealFactory");
    }
}

class ProxyFactory implements Factory {

    private Factory factory;

    public ProxyFactory(Factory factory) {
        this.factory = factory;
    }

    @Override
    public void show() {
        System.out.println("before---ProxyFactory");
        factory.show();
        System.out.println("after---ProxyFactory");
    }
}

interface Factory {
    void show();
}
