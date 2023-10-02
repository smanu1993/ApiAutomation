package pojo;

public class EmployeeWithSpouse {
    String name;
    int age;
    String job;
    Spouse sp;

    public EmployeeWithSpouse() {

    }

    public EmployeeWithSpouse(String name, int age, String job, Spouse sp) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.sp = sp;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Spouse getSp() {
        return sp;
    }

    public void setSp(Spouse sp) {
        this.sp = sp;
    }

    @Override
    public String toString() {
        return "EmployeeWithSpouse{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", sp=" + sp +
                '}';
    }
}
