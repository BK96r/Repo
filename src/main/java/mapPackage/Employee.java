package mapPackage;

import java.util.Random;

public class Employee {
    /*
-create an employee class with instance variables of name, city, age, id
-create one constructor to initialize instance variables
-create a method to generate random  employee id and use this id for employee
-create employeeTest class
-create 4 employee object and store them in a map
-while storing employees in the map, use their ids(as a keys)
-create a method to print only employee names from map

     */

    String name, city;
    Integer age, id;

    public Employee(String name, String city, Integer age) {
        this.name = name;
        this.city = city;
        this.age = age;
        this.id = idGenerator();// i want to get a id from somewhere, not either me giving
        // to see Constructor there are one more way to show it( just press right-click on the mouth and choose Generate)
    }

    public Integer idGenerator() {
        /*
        int a = 8, b = 3;
        return a+b;
        ---> But i do not want return those numbers, I want ot return a Random numbers, that is why i am use a Random()method
         */
        Random random = new Random();
        return random.nextInt(100000);

    }
    // how to shoe all employee information, without seeing HashCode?

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
    // I need a create  toString() method ---> Generate ---> toString()--> this will concat all the instance field
    // and then I will see all the information about employee in Employee class when I will run.
    // toString method will show me information without HashCode;
}