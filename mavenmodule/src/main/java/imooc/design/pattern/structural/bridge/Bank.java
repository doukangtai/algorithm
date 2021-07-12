package imooc.design.pattern.structural.bridge;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public abstract class Bank {
    protected Account account;

    public Bank(Account account) {
        this.account = account;
    }

    abstract Account openAccount();
}
