package twoPointers;

public class IsSubsequence {
    public static boolean isSubsequence(String input, String string) {
        int inputPointer=0, stringPointer=0;
        if(string.length() < input.length()){
            return false;
        }
        if(input.length() == 0){
            return true;
        }
        char[] inputArray = input.toCharArray();
        char[] stringArray = string.toCharArray();
        boolean isSubsequence = false;
        while(inputPointer < input.length()){
            boolean found = false;
            for(int i = stringPointer; i < string.length(); i++){
                if(inputArray[inputPointer] == stringArray[i]){
                    found = true;
                    inputPointer++;
                    stringPointer = i + 1;
                    break;
                }
            }
            if(!found){
                isSubsequence = false;
                break;
            }else{
                isSubsequence = true;
            }
        }
        return isSubsequence;
    }

    public static void main(String[] args){
      long start =  System.currentTimeMillis();
      System.out.println(isSubsequence("abc","ahbgdc"));
      long end = System.currentTimeMillis();
      System.out.println("time taken:- " + (end - start));

    }
}
