package imooc.design.pattern.creational.prototype;

/**
 * @author 窦康泰
 * @date 2021/07/10
 */
public class Test {
    public static void main(String[] args) {
        Mail mail = new Mail();
        mail.setContent("初始化模板");

        for (int i = 0; i < 10; i++) {
            Mail mailClone = null;
            try {
                mailClone = (Mail) mail.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            mailClone.setName("name" + i);
            mailClone.setContent("content" + i);
            mailClone.setEmailAddress("email address" + i);
            MailUtil.sendMail(mailClone);
        }

        MailUtil.saveOriginMailRecord(mail);
    }
}
