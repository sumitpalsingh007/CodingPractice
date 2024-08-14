package slidingWindow;

public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        /*int i = 0, j = 0;
        int length = nums.length;
        int minLength = -1;
        int sum = 0;
        boolean found = false;
        while (j < length){
            if (sum + nums[j] < target) {
                sum = sum + nums[j];
                j++;
            } else {
                if(!found) {
                    minLength = j - i + 1;
                }else if(minLength > (j - i + 1)){
                    minLength = j - i + 1;
                }
                i = i + 1;
                j = i;
                sum = 0;
                found = true;
            }
        }
        return found ? minLength : 0;*/
        int i = 0, j = 0;
        int length = nums.length;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        boolean found = false;
        while (j < length){
            if (sum + nums[j] < target) {
                sum = sum + nums[j];
                j++;
            } else {
                minLength = Math.min(minLength, j - i + 1);
                sum = sum - nums[i];
                i = i + 1;
                found = true;
            }
        }
        return found ? minLength : 0;
    }

    public static void main(String[] args){
        System.out.println(minSubArrayLen(15, new int[]{5,1,3,5,10,7,4,9,2,8}));//2
        //System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
