package imooc.design.pattern.behavioral.visitor;

/**
 * @author 窦康泰
 * @date 2021/07/12
 */
public class CodingCourse extends Course{
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void accept(IVistitor vistitor) {
        vistitor.visit(this);
    }
}
