package zookeeper;

/**
 * @author 窦康泰
 * @date 2021/05/20
 */
public class TicketSeller {
    public void sell() throws Exception {
        System.out.println("开始售票");
        Thread.sleep(3000);
        System.out.println("售票结束");
    }

    public void sellTicketWithLock() throws Exception {
        MyLock myLock = new MyLock();
        myLock.acquireLock();
        sell();
        myLock.releaseLock();
    }

    public static void main(String[] args) throws Exception {
        TicketSeller ticketSeller = new TicketSeller();
        for (int i = 0; i < 3; i++) {
            ticketSeller.sellTicketWithLock();
        }
    }
}
