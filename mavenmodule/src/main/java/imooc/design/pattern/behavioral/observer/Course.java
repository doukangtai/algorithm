package imooc.design.pattern.behavioral.observer;

import java.util.Observable;

/**
 * @author 窦康泰
 * @date 2021/07/12
 */
public class Course extends Observable {
    private String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void produceQuestion(Course course, Question question) {
        System.out.println(question.getUserName() + "在" + course.courseName + "提交了一个问题");
        setChanged();
        notifyObservers(question);
    }
}
