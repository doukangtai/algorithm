package imooc.design.pattern.structural.composite;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class Course extends CatalogComponent {
    private String name;
    private double price;

    public Course(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(CatalogComponent catalogComponent) {
        return this.name;
    }

    @Override
    public double getPrice(CatalogComponent catalogComponent) {
        return this.price;
    }

    @Override
    public void print() {
        System.out.println("course name: " + this.name + " course price: " + this.price);;
    }
}
