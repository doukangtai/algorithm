package imooc.design.pattern.structural.proxy;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class OrderServiceImpl implements IOrderService{
    private IOrderDao iOrderDao;

    @Override
    public int saveOrder(Order order) {
        iOrderDao = new OrderDaoImpl();
        System.out.println("Service层调用Dao层添加Order");
        return iOrderDao.insert(order);
    }
}
