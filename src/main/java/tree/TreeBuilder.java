package tree;

public class TreeBuilder {
    public static TreeNode constructTree(Integer[] input) {
        if (input == null || input.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(input[0]);
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < input.length; i += 2) {
            TreeNode current = queue.poll();
            if (input[i] != null) {
                current.left = new TreeNode(input[i]);
                queue.offer(current.left);
            }
            if (i + 1 < input.length && input[i + 1] != null) {
                current.right = new TreeNode(input[i + 1]);
                queue.offer(current.right);
            }
        }

        return root;
    }
}
