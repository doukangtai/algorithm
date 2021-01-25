package designpattern.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/01/25
 */
public class Main {
    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.add(new ConcreteHandler1());
        chain.add(new ConcreteHandler2());
        Request request = new Request("一个测试请求", "请求消息体");
        System.out.println("处理前的请求：" + request);
        chain.process(request);
        System.out.println("处理后的请求：" + request);
    }
}

class HandlerChain {
    private List<Handler> chain = new ArrayList<>();

    public void add(Handler handler) {
        chain.add(handler);
    }

    public void process(Request request) {
        for (Handler handler : chain) {
            handler.process(request);
        }
    }
}

class ConcreteHandler2 implements Handler {
    @Override
    public void process(Request request) {
        request.setMsg(request.getMsg() + " -> 经过第二次处理");
    }
}

class ConcreteHandler1 implements Handler {
    @Override
    public void process(Request request) {
        request.setMsg(request.getMsg() + " -> 经过第一次处理");
    }
}

interface Handler {
    void process(Request request);
}

class Request {
    private String name;
    private String msg;

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    public Request(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
