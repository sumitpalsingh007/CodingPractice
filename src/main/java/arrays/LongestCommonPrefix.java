package arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        String output = "";
        Set<String> inputs = new HashSet<>();
        int shortestLength = strs[0].length();
        String shortestString = "";

// Find the shortest string in the array
        for (String input : strs) {
            if (shortestLength >= input.length()) {
                shortestLength = input.length();
                shortestString = input;
            }
            inputs.add(input);
        }

// Loop from the longest possible prefix to the shortest
        for (int i = shortestLength; i > 0; i--) {
            String test = shortestString.substring(0, i);
            boolean allPresent = true;
            for (String sample : inputs) {
                if (!sample.startsWith(test)) {
                    allPresent = false;
                    break;
                }
            }
            if (allPresent) {
                output = test;
                break; // Exit the loop once the longest common prefix is found
            }
        }

        System.out.println(output);
        return output;

    }

    public static void main(String[] args){

        longestCommonPrefix(new String[]{"flower","flower","flower","flower"});
    }
}
