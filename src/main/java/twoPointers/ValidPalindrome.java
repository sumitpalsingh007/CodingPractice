package twoPointers;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if(s.length() == 1){
            return true;
        }
        int start =0;
        int end = s.length() -1;
        boolean isPalindrome = false;
        while(start <= end) {
            String ss1 = s.substring(start, start + 1);
            String ss2 = s.substring(end, end + 1);
            if(!ss1.matches("[a-zA-Z0-9]")){
                start++;
                if(start == end && !s.substring(start, start + 1).matches("[a-zA-Z0-9]")){
                    isPalindrome = true;
                    break;
                }
                continue;
            }
            if(!ss2.matches("[a-zA-Z0-9]")){
                end = end - 1;
                if(start == end && !s.substring(end,end+1).matches("[a-zA-Z0-9]")){
                    isPalindrome = true;
                    break;
                }
                continue;
            }
            //System.out.println(ss1 + " : " + ss2);
            if (ss1.equalsIgnoreCase(ss2)) {
                isPalindrome = true;
                if(start != end) {
                    start++;
                    end--;

                } else {
                    break;
                }
            } else {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    public static void main(String[] args){
        //System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("0P"));
        //System.out.println(isPalindrome("race a car"));
        //System.out.println(isPalindrome(".,"));
        //System.out.println(isPalindrome(".a"));
        //System.out.println(isPalindrome("a."));
    }
}
