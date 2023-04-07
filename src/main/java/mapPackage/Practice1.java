package mapPackage;

import java.util.HashMap;

public class Practice1 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap();
        System.out.println(map);
        map.put("Alex", "Smith"); // no add() method anymore here, only put() works
        map.put("David", "Brown");
        map.put("Mary", "White");
        System.out.println(map);//3 elements, not a six
        // how to print out individually? How can I reach out?
        System.out.println(map.get("David"));//Brown
        String valueDavid = map.get("David");//

        System.out.println(map.get("David"));//Brown
        System.out.println(valueDavid);//Brown
        System.out.println(map.get("SAm"));
        System.out.println(map.get("Kevin"));
        System.out.println(map.get("Brown"));


        // how can i print the key by itSelf?


    }
}
