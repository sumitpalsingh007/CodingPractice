package strings;

public class SumOfTwoIntegers {

    static String findSum(String str1, String str2) {
        // 2 +1 = 3
        // 1 + 1 = 2
        // 1981 contact 2 3 = 198123
        String longer;
        String shorter;

        if(str1.isEmpty() && str2.isEmpty()){
            return "0";
        }
        int lengthDiff;
        if(str1.length() >= str2.length()){
            longer = str1;
            shorter = str2;
            lengthDiff = str1.length() - str2.length();
        } else {
            longer = str2;
            shorter = str1;
            lengthDiff = str2.length() - str1.length();
        }
        int carry = 0;
        //int number = 0;
        StringBuilder number = new StringBuilder();
        //String number = "";
        for(int i = shorter.length() -1; i >= 0; i--){
            int a = shorter.charAt(i) - '0';
            int b = longer.charAt(lengthDiff + i) - '0';
            int sum = a + b + carry;
            number.insert(0, sum % 10);
            //number  = (sum % 10) + number;
            carry = sum / 10;
        }

        for (int i = longer.length() - shorter.length() -1 ; i >= 0; i--){
            int sum = (longer.charAt(i) - '0') + carry;
            number.insert(0, sum % 10);
            //number  = (sum % 10) + number;
            carry = sum / 10;
        }

        if(carry !=0){
            number = number.insert(0, carry);
            //number  = carry + number;
        }

        return number.toString();
        //return number;
    }

    public static String addLargeNumbersComma(String num1, String num2) {
        String[] newNum1 = num1.split(",");
        String[] newNum2 = num2.split(",");

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(String num: newNum1) sb1.append(num);
        for(String num: newNum2) sb2.append(num);

        String result = findSum(num1.replaceAll(",", ""), String.valueOf(sb2));
        StringBuilder sbResult = new StringBuilder();
        int count = 1;
        for(int i=result.length() -1; i >= 0; i--) {
            char ch = result.charAt(i);
            if(count % 3 == 0) {
                sbResult.insert(0, "," + ch );
            } else {
                sbResult.insert(0, ch);
            }
            count++;
        }
        return sbResult.toString().startsWith(",") ? String.valueOf(sbResult).substring(1, sbResult.length()) : String.valueOf(sbResult);
        //return String.valueOf(sbResult).substring(1, sbResult.length());
    }

    public static void main(String[] args) {
        String str1 = "12";
        String str2 = "198,189";

        //198189
        //12
        //
        // 2 + 9 = 11 . carry = 11 / 10 =1 and remainder 11 % 10 = 1
        // 8 + 1 + 1 (carry) = 10 // carry = 10 / 10 = 1 and remainder 10 % 10 = 0
        // 198(1+1)01 = 198201
        System.out.println(addLargeNumbersComma(str1, str2));
    }

}
