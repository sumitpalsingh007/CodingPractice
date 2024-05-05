package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(result, root);
        return result;
    }

    private static void traverse(List<Integer> list, TreeNode node){
        if(node != null){
            list.add(node.val);
            traverse(list, node.left);
            traverse(list, node.right);
        }
    }

    public static void main(String args[])
    {
        Integer arr2[] = {1,2,3,4,5,6,7,8,9,0};
        var tree = TreeBuilder.constructTree(arr2);
        System.out.println("inorder :- " + preOrderTraversal(tree));

    }
}
