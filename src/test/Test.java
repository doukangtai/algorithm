package test;

/**
 * @Author 窦康泰
 * @Date 2020-08-21 10:14
 */
public class Test {

    public static void main(String[] args) {
        Pizza testPz = new Pizza();
        testPz.setStatus(Pizza.PizzaStatus.READY);
        System.out.println(testPz.isDeliverable());
    }
}

class Pizza {

    private PizzaStatus status;
    public enum PizzaStatus {
        ORDERED (5){
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY (2),
        DELIVERED (0){
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        public boolean isOrdered() {return false;}

        public boolean isReady() {return false;}

        public boolean isDelivered(){return false;}

        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        PizzaStatus (int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }

    public boolean isDeliverable() {
        return this.status.isReady();
    }

    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " +
                this.getStatus().getTimeToDelivery());
    }

    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }
}
