package imooc.design.pattern.structural.proxy.staticproxy;

import imooc.design.pattern.structural.proxy.Order;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class Test {
    public static void main(String[] args) {
        OrderServiceStaticProxy proxy = new OrderServiceStaticProxy();
        Order order = new Order();
        order.setUserId(1);
        proxy.saveOrder(order);
    }
}
