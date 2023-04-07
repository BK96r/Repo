package mapPackage;

import java.util.HashMap;
import java.util.Map;

public class EmployeeTest {
    public static void main(String[] args) {
        /*-create 4 employee object and store them in a map
        -while storing employees in the map, use their ids(as a keys)
        -create a method to print only employee names from map*/
        Employee e1 = new Employee("Artem", "Chicago", 30);
        Employee e2 = new Employee("Diana", "Las Vegas", 27);
        Employee e3 = new Employee("Tanya", "Istanbul", 48);
        Employee e4 = new Employee("Viktor", "Minneapolis", 40);
// But it is okey also start from the just ---> Map
        // Why Integer? Because data type of ID is ---> Integer
        //Bellow---> calling the name finder method in the main, by providing previous employee map
        HashMap<Integer, Employee> employeeMap = new HashMap();


        employeeMap.put(e1.id, e1);
        employeeMap.put(e2.id, e2);
        employeeMap.put(e3.id,e3);
        employeeMap.put(e4.id, e4);

        System.out.println(employeeMap);// why I can not see the information of my employee? why I see the HashCode.
        // because I need a String method
        nameFinder(employeeMap);// will show me all the Employee's name

        // How print the name from the Map?
        employeeMap.values();


    }
    // creating a name finding method to get the Names from the Employees
    public static void nameFinder( Map < Integer, Employee> map){
        for (Employee employee: map.values()){
            System.out.println(employee.name);
        }
    }
}
