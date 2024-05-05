package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.w3c.dom.Node;

public class InOrderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(result, root);
        return result;
    }

    private static void traverse(List<Integer> list, TreeNode node){
        if(node != null){
            traverse(list, node.left);
            list.add(node.val);
            traverse(list, node.right);
        }
    }

    private static List<Integer> nonRecursiveInorderTraversal(TreeNode root){
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();//Last In First Out
        TreeNode currentNode = root;
        boolean done = false;
        while(!done){
            if(currentNode != null){
                s.push(currentNode);
                currentNode = currentNode.left;
            } else {
                if(s.isEmpty()){
                    done = true;
                } else {
                    currentNode = s.pop();
                    res.add(currentNode.val);
                    currentNode = currentNode.right;
                }
            }

        }
        return res;
    }

    public static void main(String args[])
    {
        Integer arr[] = { 8,3,10,1,6,null,14,null,null,4,7,13 };
        Integer arr1[] = {1,null,2,3};
        Integer arr2[] = {1,2,3,4,5,6,7,8,9,0};
        var tree = TreeBuilder.constructTree(arr2);
        System.out.println("inorder :- " + inorderTraversal(tree));

    }
}
