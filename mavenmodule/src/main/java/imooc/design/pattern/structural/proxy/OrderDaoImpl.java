package imooc.design.pattern.structural.proxy;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class OrderDaoImpl implements IOrderDao{
    @Override
    public int insert(Order order) {
        System.out.println("Dao层添加Order成功");
        return 1;
    }
}
