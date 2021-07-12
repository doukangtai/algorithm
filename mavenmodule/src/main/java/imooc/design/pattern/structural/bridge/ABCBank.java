package imooc.design.pattern.structural.bridge;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class ABCBank extends Bank {
    public ABCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开中国农业银行账号");
        account.openAccount();
        return account;
    }
}
