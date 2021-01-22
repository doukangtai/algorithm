package designpattern.factory.factorymethod;

/**
 * @author 窦康泰
 * @date 2021/01/22
 */
public abstract class Factory {
    abstract Product createProduct();
}

class Client {
    public static void main(String[] args) {
        Product product = new ProductBFactory().createProduct();
        System.out.println(product);
    }
}

class ProductAFactory extends Factory {
    @Override
    Product createProduct() {
        return new ProductA();
    }
}

class ProductBFactory extends Factory {
    @Override
    Product createProduct() {
        return new ProductB();
    }
}

class ProductCFactory extends Factory {
    @Override
    Product createProduct() {
        return new ProductC();
    }
}

class ProductA implements Product {}

class ProductB implements Product {}

class ProductC implements Product {}

interface Product {}
