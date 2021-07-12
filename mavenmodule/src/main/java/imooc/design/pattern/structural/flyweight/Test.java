package imooc.design.pattern.structural.flyweight;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class Test {
    private static final String[] departments = {"RD", "QA", "PM", "BD"};

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String department = departments[(int) (Math.random() * departments.length)];
            Employee manager = EmployeeFactory.getManager(department);
            manager.report();
        }
    }
}
