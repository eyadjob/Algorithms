package facebookposition.binarytrees;

public class TreeMaxDepth {

    public static void main(String[] args) {


        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.right.right = new TreeNode(3);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.left = new TreeNode(2);

        System.out.println(findMaxDepthForTree(root));
    }

    public static int findMaxDepthForTree(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null)
            return 1 + findMaxDepthForTree(root.right);
        if (root.right == null)
            return 1 + findMaxDepthForTree(root.left);
        return 1 + Math.max(findMaxDepthForTree(root.left), findMaxDepthForTree(root.right));
    }

    public static class TreeNode {
        TreeNode left = null;
        TreeNode right = null;
        int value;
        public TreeNode(int value) {
            this.value = value;
        }

    }
}
