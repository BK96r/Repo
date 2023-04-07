package mapPackage;

import java.util.Hashtable;

public class HashTablePractice {
    public static void main(String[] args) {
        Hashtable<String, Integer> table = new Hashtable();// but i also can put inside diamond any type of Object which i want
        //<Flower, Student, Cat etc>
        table.put("Rose", 3);
        table.put("Daisy", 5);
        table.put("SunFlower", 10);
        table.put("Tulip", 9);
        System.out.println(table); // structure the same as in the Map

        System.out.println(table.get("Tulip"));//9

        System.out.println(table.values());//will show me the value
        System.out.println(table.keySet());//will show me the keys
        System.out.println(table.entrySet());//will show me the keys and value

        //table.put(null,18); // NullPointerException --> HashTable does not allow 'null' keys
       // table.put("Orchird", null); //NullPointerException --> HashTable does not allow any null values

    }
}
