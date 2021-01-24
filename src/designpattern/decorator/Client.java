package designpattern.decorator;

/**
 * @author 窦康泰
 * @date 2021/01/24
 */
public class Client {
    public static void main(String[] args) {
        Beverage beverage = new DarkRoast();
        beverage = new Milk(beverage);
        beverage = new Mocha(beverage);
        System.out.println(beverage.cost());
    }
}

class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 1 + this.beverage.cost();
    }
}

class Milk extends CondimentDecorator {
    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 1 + this.beverage.cost();
    }
}

abstract class CondimentDecorator implements Beverage {
    protected Beverage beverage;
}

class HouseBlend implements Beverage {
    @Override
    public double cost() {
        return 1;
    }
}

class DarkRoast implements Beverage {
    @Override
    public double cost() {
        return 1;
    }
}

interface Beverage {
    double cost();
}
