package imooc.design.pattern.behavioral.iterator;

import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/07/12
 */
public class CourseIteratorImpl implements CourseIterator {
    private List courseList;
    private int position;
    private Course course;

    public CourseIteratorImpl(List courseList) {
        this.courseList = courseList;
    }

    @Override
    public Course nextCourse() {
        System.out.println("返回课程，位置是：" + position);
        course = (Course) courseList.get(position);
        position++;
        return course;
    }

    @Override
    public boolean isLastCourse() {
        return position >= courseList.size();
    }
}
