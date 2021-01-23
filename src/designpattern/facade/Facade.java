package designpattern.facade;

/**
 * @author 窦康泰
 * @date 2021/01/23
 */
public class Facade {
    private SubSystem subSystem = new SubSystem();
    public void watchMovie() {
        subSystem.turnOnTV();
        subSystem.setCD("一场电影");
        subSystem.startWatching();
    }
}

class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.watchMovie();
    }
}

class SubSystem {
    public void turnOnTV() {
        System.out.println("turnOnTV");
    }

    public void setCD(String cd) {
        System.out.println("setCD(" + cd + ")");
    }

    public void startWatching() {
        System.out.println("startWatching");
    }
}
