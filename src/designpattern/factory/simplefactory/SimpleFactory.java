package designpattern.factory.simplefactory;

/**
 * @author 窦康泰
 * @date 2021/01/22
 */
public class SimpleFactory {
    public Product createProduct(int type) {
        if (type == 1) {
            return new ProductA();
        } else if (type == 2) {
            return new ProductB();
        } else {
            return new ProductC();
        }
    }

    public static void main(String[] args) {
        Product product = new SimpleFactory().createProduct(2);
        System.out.println(product);
    }
}

class ProductA implements Product {}

class ProductB implements Product {}

class ProductC implements Product {}

interface Product {}
