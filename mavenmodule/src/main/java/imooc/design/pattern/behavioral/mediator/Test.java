package imooc.design.pattern.behavioral.mediator;

/**
 * @author 窦康泰
 * @date 2021/07/12
 */
public class Test {
    public static void main(String[] args) {
        User geely = new User("Geely");
        User tom = new User("Tom");

        geely.sendMessage(" Hey! Tom! Let's learn Design Pattern");
        tom.sendMessage("OK! Geely");
    }
}
