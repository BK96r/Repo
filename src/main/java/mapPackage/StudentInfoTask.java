package mapPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentInfoTask {
    /*
    Store student information in to the Map
    Store those student information into List
    From List of students, find out city of the student
    if student lives out of Chicago, --> " You can join Online"
    FirstName: David
LastName: Pena
Age: 25
Gender: M
City: Chicago

FirstName: Jeremiah
LastName: Michaelson
Age: 15
Gender: M
City: LakeForest

FirstName: Michael
LastName: White
Age: 35
Gender: M
City: Winnetka

FirstName: Sarah
LastName: Star
Age: 29
Gender: F
City: Chicago
     */

    public static void main(String[] args) {

        HashMap<String, String> student1 = new HashMap<>();
        student1.put("FirstName", "David");
        student1.put("LastName", "Pena");
        student1.put("Age", "25");
        student1.put("Gender", "M");
        student1.put("City", "Chicago");
        // System.out.println(student1);

        HashMap<String, String> student2 = new HashMap<>();
        student2.put("FirstName", "Jeremiah");
        student2.put("LastName", "Michaelson");
        student2.put("Age", "15");
        student2.put("Gender", "M");
        student2.put("City", "LakeForest");
        // System.out.println(student2);

        HashMap<String, String> student3 = new HashMap<>();
        student3.put("FirstName", "Michael");
        student3.put("LastName", "White");
        student3.put("Age", "35");
        student3.put("Gender", "M");
        student3.put("City", "Winnetka");
        // System.out.println(student3);

        HashMap<String, String> student4 = new HashMap<>();
        student4.put("FirstName", "Sarah");
        student4.put("LastName", "Star");
        student4.put("Age", "31");
        student4.put("Gender", "F");
        student4.put("City", "Chicago");
        // System.out.println(student3);


        List<HashMap<String, String>> studentInfo = new ArrayList<>();// this is list contains the map
        studentInfo.add(student1);
        studentInfo.add(student2);
        studentInfo.add(student3);
        studentInfo.add(student4);
        System.out.println(studentInfo);

        // find the student who are age of 30 or younger, they are from Chicago
        for(HashMap<String, String> info: studentInfo) {
            // I have to convert String to Integer, to compare the Age!
            if (Integer.parseInt(info.get("Age")) <= 30 && info.get("City").equalsIgnoreCase("Chicago")) {
                System.out.println(info.get("FirstName") + " is from Chicago and age of 30 or less");
            }
        }

        for (HashMap<String, String> student : studentInfo) {
            if (!student.get("City").equalsIgnoreCase("Chicago")) {
                System.out.println(student.get("FirstName") + " You can join Online ");

            }
        }
        // for loop with index number
        for (int i = 0; i < studentInfo.size(); i++) {
         if (!studentInfo.get(i).get("City").equalsIgnoreCase("Chicago")){
             System.out.println(studentInfo.get(i).get("FirstName") + "---> You can join Online *** ");


            }
        }
        //two methods they are doing similar functionality, but the return type is different
        // ont of them returning a List, another one returning a Map
        List<List<String>> result1=  fullNameFinder(studentInfo);
        HashMap<String, List> result2 = fullNameFinder1 (studentInfo);//<-- go ahead and find if the city is Winnetka
        //say ---> " you are lucky"
        for (Object city : result2.get("Cities")){
            //why "Cities now? not a City (because I reassigned in the HashMap method bellow
            System.out.println(city);
            if (city.toString().equalsIgnoreCase("Winnetka")){
                System.out.println("You are lucky since your are in "+city);
            }
        }
       // fullNameFinder(studentInfo);
        //fullNameFinder1(studentInfo);

    }
    // create a method
    // pass a parameter as List
    // return all student firstNames in one List and lastNames in other List

    public static List<List<String>> fullNameFinder(List<HashMap<String,String> > list ){
        //this method return the List
        List firstNames = new ArrayList();
        List lastNames = new ArrayList();
        List<List<String>> fullNames = new ArrayList<>();
        for (HashMap<String, String> student : list) {
            firstNames.add(student.get("FirstName"));
            lastNames.add(student.get("LastName"));

        }
        fullNames.add(firstNames);
        fullNames.add(lastNames);
        System.out.println(fullNames);
        return fullNames;

        }
    public static HashMap<String, List> fullNameFinder1(List<HashMap<String,String> > list ){
        //this method will return the Map

       //--> Create another list for cities
        List firstNames = new ArrayList();
        List lastNames = new ArrayList();
        List cities = new ArrayList();
        // now I want implementation in a Map
        HashMap<String, List> map1 = new HashMap<>();
       // List<List<String>> fullNames = new ArrayList<>();
        for (HashMap<String, String> student : list) {
            //find and add cities to the list you created
            cities.add(student.get("City"));
            firstNames.add(student.get("FirstName"));
            lastNames.add(student.get("LastName"));


        }
        //add your city list to the Map
        map1.put("Cities", cities);
        map1.put("FirstNames", firstNames);
        map1.put("LastNames", lastNames);

        //fullNames.add(firstNames);
        //fullNames.add(lastNames);
        System.out.println(map1);
        return map1; // <--- every single method have only one return
        //System.out.println(fullNames);
        //return fullNames;

    }
    }


