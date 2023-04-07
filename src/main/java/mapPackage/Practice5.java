package mapPackage;

import java.util.HashMap;
import java.util.Map;

public class Practice5 {
    public static void main(String[] args) {
        /*
        String str = "Soccer is the best sport";

        count numbers of each letter from the given String
        S-1
        0-1
        c-2
        e-1
        r-1

        ..
        t -3
         */

        String str = "coffee";
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            String str1 = "" + str.charAt(i); //We concatenate an empty string "" with str.charAt(i)
            // to convert the char to a string
            if (map.containsKey(str1)) {
                map.put("" + str.charAt(i), map.get(str1) + 1);//keys are letters
            } else {
                map.put(str1, 1);
            }
            System.out.println(map);
        }


        System.out.println( " ============================= ");
        String str2 = "Soccer is the best sport!";
        str = str.toLowerCase();
        // Create a map to store the count of each letter
        Map<Character, Integer> letterCount = new HashMap<>();
        // Loop over each character in the string
        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            // Ignore non-letter characters
            if (!Character.isLetter(c)) {
                continue;
            }
            // If the letter is already in the map, increment its count
            if (letterCount.containsKey(c)) {
                letterCount.put(c, letterCount.get(c) + 1);
            } else {
                // Otherwise, add it to the map with a count of 1
                letterCount.put(c, 1);
            }
        }
            // Print the counts of each letter
            for (char c : letterCount.keySet()) {
                System.out.println(c + " - " + letterCount.get(c));
            }
        }
        }


