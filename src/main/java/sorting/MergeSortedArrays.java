package sorting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.



Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
*/
public class MergeSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < m; i++){
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        for(int j = 0; j < n; j++){
            map.put(nums2[j], map.getOrDefault(nums2[j], 0) + 1);
        }
        int index = 0;
        for(int num : map.keySet()){
            for(int i = 0; i < map.get(num); i++) {
                nums1[index] = num;
                index++;
            }
        }
    }

    public static void main(String[] args){
        MergeSortedArrays msa = new MergeSortedArrays();
        // Given input
        int[] nums1 = {0,0,3,0,0,0,0,0,0};
        int m = 3;
        int[] nums2 = {-1,1,1,1,2,3};
        int n = 3;

        // Merge nums2 into nums1
        msa.merge(nums1, m, nums2, n);

        // Print the merged array
        System.out.print("[");
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i]);
            if (i < nums1.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
