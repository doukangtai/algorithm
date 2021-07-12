package imooc.design.pattern.structural.bridge;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class SavingAccount implements Account {
    @Override
    public Account openAccount() {
        System.out.println("打开活期账号");
        return new SavingAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是一个活期账号");
    }
}
