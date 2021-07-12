package imooc.design.pattern.creational.prototype;

/**
 * @author 窦康泰
 * @date 2021/07/10
 */
public class MailUtil {
    public static void sendMail(Mail mail) {
        System.out.println(mail);
    }

    public static void saveOriginMailRecord(Mail mail) {
        System.out.println("Content: " + mail.getContent());
    }
}
