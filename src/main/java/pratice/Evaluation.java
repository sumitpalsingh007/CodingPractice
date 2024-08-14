package pratice;

import java.util.Arrays;

public class Evaluation {
    // sorted array of integers
    // -5, -3, -1, 0, 2, 4
    // -5, 0, 1, 2, 9, 10
    public static void main(String[] args){
        //squaresOfArray(new int[]{-5, -3, -1, 0, 2, 4});
        squaresOfArray(new int[]{-5, 0, 1, 2, 9, 10});
    }

    // add java doc
    // name should suggest it is a util method
    // grafana
    private static void squaresOfArray(int[] inpArr){
        //int length = inpArr.length; // remove unnecessary local variable
        int j = 0; // use proper naming
        int k = inpArr.length -1;// use proper naming
        while(j <= k) {
            //use local variables
            if (inpArr[j] * inpArr[j] > inpArr[k] * inpArr[k]) {
                System.out.println(inpArr[j] * inpArr[j]);
                j++;
            } else {
                System.out.println(inpArr[k] * inpArr[k]);
                k--;
            }
        }
    }

    //Date Type

    //10th  - 14
    //11th - 5  // 19
    //2th -8 // 27
}
