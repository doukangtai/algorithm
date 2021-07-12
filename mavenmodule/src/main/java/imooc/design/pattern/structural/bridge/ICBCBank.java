package imooc.design.pattern.structural.bridge;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class ICBCBank extends Bank {
    public ICBCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开中国工商银行账号");
        account.openAccount();
        return account;
    }
}
