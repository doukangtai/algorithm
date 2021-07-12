package imooc.design.pattern.behavioral.mediator;

import java.util.Date;

/**
 * @author 窦康泰
 * @date 2021/07/12
 */
public class StudyGroup {
    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
    }
}
