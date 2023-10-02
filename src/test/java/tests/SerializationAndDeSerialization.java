package tests;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;
import pojo.EmployeeWithSpouse;
import pojo.Spouse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SerializationAndDeSerialization extends BaseClass {
    @Test(priority = 1)
    public void serializeObject() {
        List<Integer> phn = new ArrayList<>();
        phn.add(1234);
        phn.add(5678);
        Spouse sp = new Spouse("Tanu" + getRandomNumber(), 26, phn);

        EmployeeWithSpouse emp = new EmployeeWithSpouse("Manu" + getRandomNumber(), 30, "SDET", sp);

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./data/employeeWithSpouse.json"), emp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 2)
    public void deserializeObject() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            EmployeeWithSpouse emp = mapper.readValue(new File("./data/employeeWithSpouse.json")
                    , EmployeeWithSpouse.class);
            System.out.println("Emp_name = "+emp.getName());
            System.out.println("Emp_age = "+emp.getAge());
            System.out.println("Emp_job = "+emp.getJob());
            System.out.println("Spouse_name = "+emp.getSp().getName());
            System.out.println("Spouse_age = "+emp.getSp().getAge());
            int count = 0;
            for (Integer phn : emp.getSp().getPhone()){
                count++;
                System.out.println("Spouse_phone"+count+"  = "+phn);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
