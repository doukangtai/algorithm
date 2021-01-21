package designpattern.strategy;

/**
 * @author 窦康泰
 * @date 2021/01/21
 */
public class Strategy {
    private PersonBehavior personBehavior;

    public void setPersonBehavior(PersonBehavior personBehavior) {
        this.personBehavior = personBehavior;
    }

    public void doSomething() {
        if (personBehavior != null) {
            personBehavior.behavior();
        }
    }

    public static void main(String[] args) {
        Strategy strategy = new Strategy();
//        strategy.setPersonBehavior(new YoungMan());
        strategy.setPersonBehavior(new OldMan());
        strategy.doSomething();
    }
}

class YoungMan implements PersonBehavior {
    @Override
    public void behavior() {
        System.out.println("年轻人说话了");
    }
}

class OldMan implements PersonBehavior {
    @Override
    public void behavior() {
        System.out.println("老人说话了");
    }
}

interface PersonBehavior {
    void behavior();
}
