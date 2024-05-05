package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.sun.source.tree.Tree;

/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109


Follow-up: Could you solve the problem in linear time and in O(1) space?
*/
public class MajorityElements {

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int highestCountNo = 0;
        int highestCount = 0;
        for(int num : nums){
            int currentCount = map.getOrDefault(num, 0) + 1;
            if(currentCount > highestCount){
                highestCount = currentCount;
                highestCountNo = num;
            }
            if(highestCount > nums.length/2){
                break;
            }
            map.put(num, currentCount);
        }
        return highestCountNo;
    }

    public static void main(String[] args){
        int[] nums = {2,2,1,1,1,2,2}; // Input array
        int k = majorityElement(nums); // Calls your implementation

        assert k == 2;
    }

    private class Model{
        int num;
        int count;

        @Override
        public boolean equals(Object o){
            return ((Model)o).num == this.num;
        }

        @Override
        public int hashCode(){
            return num;
        }
    }
}
