package pojo;

import java.util.List;

public class Spouse {
    String name;
    int age;
    List<Integer> phone;

    public Spouse() {
    }

    public Spouse(String name, int age, List<Integer> phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
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

    public List<Integer> getPhone() {
        return phone;
    }

    public void setPhone(List<Integer> phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Spouse{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                '}';
    }
}
