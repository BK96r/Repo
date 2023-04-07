package mapPackage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Practice2 {
    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap();

        map.put(10, "Alex");
        map.put(20, "Sam");
        map.put(30, "Tom");
        System.out.println(map);
        System.out.println(map.get("Alex"));//null
        System.out.println(map.get(10));//Alex

        map.put(20, "Vitaly"); //<--- new value
        System.out.println(map); // <--it will update value, if the key is existing on the map, the value will be reassigned

        map.put(40, "Natalie");
        map.put(50, "Natalie");
       map.put(60, "Natalie");
       map.put(70, "Natalie");
        System.out.println(map);
        // can I see only the keys from my Map?

        // how to reach out values individually?
        System.out.println(map.get(10));//ALex
        System.out.println(map.get(20));//Vitaly
        System.out.println(map.get(30)); //Tom
        // How can I have all keys on hand?
        map.keySet(); //<-- this method will return all keys from the map to me
        // why Set? Because the keys are unique and map is using the set structured for the keys.
        // Once you take the keys they are coming as like a special, unique set.
        //Why return Integer? because we store the keys like an Integer

        Set<Integer> keys = map.keySet();//[50,20, 70, 40, 10, 60, 30]
        System.out.println(keys);// all the keys, on ,my hand

        for (Integer key :keys){
            map.get(key);// it will return values for me, because i am use get method, and get() returns only value
            System.out.println(map.get(key));
        }
        System.out.println("+++");
        for (Integer item : map.keySet()){
            System.out.println(" + "+ item);
        }
        //another method the reach out the values
        // values();
        Collection<String> values = map.values();
        System.out.println(values);// values one at the time
        for (String value: values){
            System.out.println("*" + value + "*");// value one by one
            // by above methods I can separate keys and values
        }
        // replace(); <-- replace the value for the keys --> however, we did it for by using the puts

        map.replace(40,"XXXX");// we replace "Natalie" to "XXXX"
        System.out.println(map);
        // replace can not create a new value, new key, only put() can create.
        // The replace method is actually to replace something existing.
        map.replace(90, "YYYYY");
        System.out.println(map);// we do not have key" 90 " , we can not replace not exiting value,
        // because replace() method, can not create value

        //and second way of replace() method
        map.replace(70, "Natalie", "Jenny");
        System.out.println(map);

        // map has size --> size(), we can use this method

        map.size(); // this method will return of all elements(int)
        System.out.println(map.size());

        //another method ---> contains()
        System.out.println(map.containsKey("Mustafa")); // false
        System.out.println(map.containsKey(10));//true
        //containsValue()
        System.out.println(map.containsValue("Natalie"));//true
        System.out.println("===================");
        System.out.println(map.containsKey("10"));
        System.out.println("====================");
       System.out.println(map.containsKey(Integer.parseInt("10")));//now we convert Integer to String, and now it is a true
        //isEmpty
        System.out.println(map.isEmpty() + "*");//false, because we did not clear
        //clear

        map.clear();
       // System.out.println(map.isEmpty());//true
        map.isEmpty();
      //  System.out.println(map.clear()); <--- why we can not do it in parentheses? Because return type is void.
        System.out.println(map.isEmpty());//true



    }
}
