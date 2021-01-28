package designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 窦康泰
 * @date 2021/01/28
 */
public class Client {
    public static void main(String[] args) {
        FlyWeightFactory factory = new FlyWeightFactory();
        FlyWeight aaa = factory.getFlyWeight("aaa");
        FlyWeight bbb = factory.getFlyWeight("bbb");
        aaa.doOperation("aaaOut");
        bbb.doOperation("bbbOut");
    }
}

class FlyWeightFactory {
    private Map<String, FlyWeight> factory = new HashMap<>();

    public FlyWeight getFlyWeight(String in) {
        if (!factory.containsKey(in)) {
            factory.put(in, new ConcreteFlyWeight(in));
        }
        return factory.get(in);
    }
}

class ConcreteFlyWeight implements FlyWeight {
    private String in;

    public ConcreteFlyWeight(String in) {
        this.in = in;
    }

    @Override
    public void doOperation(String out) {
        System.out.println(this.hashCode() + " --- " + System.identityHashCode(this));
        System.out.println("out: " + out);
        System.out.println("in: " + in);
    }
}

interface FlyWeight {
    void doOperation(String out);
}
