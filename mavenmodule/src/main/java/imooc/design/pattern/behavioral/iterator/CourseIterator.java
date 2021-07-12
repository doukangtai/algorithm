package imooc.design.pattern.behavioral.iterator;

/**
 * @author 窦康泰
 * @date 2021/07/12
 */
public interface CourseIterator {
    Course nextCourse();

    boolean isLastCourse();
}
