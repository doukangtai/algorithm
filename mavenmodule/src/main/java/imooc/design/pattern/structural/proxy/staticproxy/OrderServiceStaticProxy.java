package imooc.design.pattern.structural.proxy.staticproxy;

import imooc.design.pattern.structural.proxy.IOrderService;
import imooc.design.pattern.structural.proxy.Order;
import imooc.design.pattern.structural.proxy.OrderServiceImpl;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class OrderServiceStaticProxy {
    private IOrderService iOrderService;

    public int saveOrder(Order order) {
        beforeMethod(order);
        iOrderService = new OrderServiceImpl();
        int result = iOrderService.saveOrder(order);
        afterMethod();
        return result;
    }

    private void beforeMethod(Order order) {
        Integer userId = order.getUserId();
        int dbRouter = userId % 2;
        System.out.println("静态代理分配到【db" + dbRouter + "】处理数据");
        System.out.println("静态代理 before code");
    }

    private void afterMethod() {
        System.out.println("静态代理 after code");
    }
}
