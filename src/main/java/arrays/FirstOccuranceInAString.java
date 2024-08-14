package arrays;

public class FirstOccuranceInAString {

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args){
        int k = strStr("sadbutsad", "sad");
        System.out.println(k);
    }
}
