package javabasic;

import java.util.Objects;

/**
 * @Author 窦康泰
 * @Date 2020-08-21 15:21
 */
public class NewTest {

    public static void main(String[] args) {
        String s1 = new String("123");
        String s2 = new String("123");
//        System.out.println(s1 == s2);
//        System.out.println(s1.equals(s2));
        Entity entity1 = new Entity("name1", 1);
        Entity entity2 = new Entity("name1", 1);
        System.out.println(entity1.equals(entity2));
    }

}

class Entity {

    private String name;

    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return age == entity.age &&
                Objects.equals(name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public Entity() {
    }

    public Entity(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
