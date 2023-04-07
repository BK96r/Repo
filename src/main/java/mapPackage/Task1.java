package mapPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task1 {

    public static void main(String[] args) {
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("Bananas", 10);
        map1.put("Orange", 27);
        map1.put("Apples", 31);
        map1.put("Sweet Cherry", 8);
List <Integer>list1 = largeNumberFinder(map1);
        System.out.println(list1);

    }

    /*
    create a method that will get a Map as parameter
    given Map as parameter should be MAP<String, Integer>
    this method will find all values from the given map
    this method will return if the value is greater than 25
    this method returns those greater numbers as a List
     */
    //Why is return type is Integer? Because the value is going to be Integer
    public static List<Integer> largeNumberFinder(Map<String, Integer> map1) {
List<Integer> items = new ArrayList<>();
       // map1.values(); //get all the values
        for (Integer numbers : map1.values()) {
            if (numbers > 25) {
                items.add(numbers);
              //  System.out.println(numbers);<---this print put will show me also numbers but not in the List
            }
        }
        return items;
    }
}

















