package imooc.design.pattern.structural.flyweight;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class Manager implements Employee{
    @Override
    public void report() {
        System.out.println(reportContent);
    }

    private String department;
    private String reportContent;

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public Manager(String department) {
        this.department = department;
    }
}
