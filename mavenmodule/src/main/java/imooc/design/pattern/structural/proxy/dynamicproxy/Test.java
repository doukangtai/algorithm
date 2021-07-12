package imooc.design.pattern.structural.proxy.dynamicproxy;

import imooc.design.pattern.structural.proxy.IOrderService;
import imooc.design.pattern.structural.proxy.Order;
import imooc.design.pattern.structural.proxy.OrderServiceImpl;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class Test {
    public static void main(String[] args) {
        IOrderService orderServiceDynamicProxy = (IOrderService) new OrderServiceDynamicProxy(new OrderServiceImpl()).bind();
        orderServiceDynamicProxy.saveOrder(new Order());
    }
}
