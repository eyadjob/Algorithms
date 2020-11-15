package facebookposition.binarytrees;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(15);
        treeNode.right.left = new TreeNode(12);
        treeNode.right.right = new TreeNode(20);
        System.out.println(isValidBST(treeNode));
    }

    public static boolean isValidBST(TreeNode root) {

        return help(root,null,null);

    }

    private static boolean help(TreeNode p, Integer low, Integer high) {
        if (p == null) return true;
        return (low == null || p.val > low) && (high == null || p.val < high) && help(p.left, low, p.val) && help(p.right, p.val, high);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
