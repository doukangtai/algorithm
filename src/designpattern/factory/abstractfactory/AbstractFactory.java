package designpattern.factory.abstractfactory;

/**
 * @author 窦康泰
 * @date 2021/01/22
 */
public abstract class AbstractFactory {
    abstract AbstractProductA createProductA();
    abstract AbstractProductB createProductB();
}

class Client {
    public static void main(String[] args) {
        Factory1 factory1 = new Factory1();
        System.out.println(factory1.createProductA());
        System.out.println(factory1.createProductB());
        Factory2 factory2 = new Factory2();
        System.out.println(factory2.createProductA());
        System.out.println(factory2.createProductB());
    }
}

class Factory1 extends AbstractFactory {
    @Override
    AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    AbstractProductB createProductB() {
        return new ProductB1();
    }
}

class Factory2 extends AbstractFactory {
    @Override
    AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    AbstractProductB createProductB() {
        return new ProductB2();
    }
}

class ProductA1 extends AbstractProductA {}

class ProductA2 extends AbstractProductA {}

class ProductB1 extends AbstractProductB {}

class ProductB2 extends AbstractProductB {}

abstract class AbstractProductA {}

abstract class AbstractProductB {}
