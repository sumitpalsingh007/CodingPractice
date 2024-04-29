package tree;

/*
Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.

A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.

Example 1:

Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation: We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
Example 2:

Input: root = [1,null,2,null,0,3]
Output: 3

Constraints:

The number of nodes in the tree is in the range [2, 5000].
0 <= Node.val <= 105

*/
public class MaximumDifferenceBetweenNodeAndAncestor {
    public static int maxAncestorDiff(TreeNode root) {
        //8 -> 8 , min =8 max =8
        //3        min (8,3)=3 max(8,3) = 8
        //1.       min (1,3) = 1 max(1, 8) = 8
        //6        min (6, 3)=3. max(6,8) = 8
        int min = root.val;
        int max = root.val;
        return compute(root, min, max);
    }
    static int compute(TreeNode node, int max, int min){
        int diff = max - min;
        if(null != node ){
            if(min > node.val){
                min = node.val;
            }if(max < node.val){
                max = node.val;
            }
            diff = max - min;
            int leftDiff = compute(node.left, max, min);
            int rightDiff = compute(node.right, max, min);
            if(leftDiff > diff){
                diff = leftDiff;
            } if(rightDiff > diff){
                diff = rightDiff;
            }
        }
        return diff;
    }

    public static void main(String args[])
    {
        Integer arr[] = { 8,3,10,1,6,null,14,null,null,4,7,13 };
        Integer arr1[] = {1,null,2,null,0,3};
        var tree = TreeBuilder.constructTree(arr1);
        System.out.println("max depth :- " + maxAncestorDiff(tree));

    }

}
