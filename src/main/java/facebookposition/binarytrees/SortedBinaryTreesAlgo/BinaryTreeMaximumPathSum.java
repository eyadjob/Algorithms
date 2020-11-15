package facebookposition.binarytrees.SortedBinaryTreesAlgo;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeMaximumPathSum {


    static List<Integer> nodes = new ArrayList<>();

    static int maxn;
    public static int maxPathSum(TreeNode root) {
        maxn = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxn;
    }

    static private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxn = Math.max(maxn, left + right + node.val);
        return Math.max(left, right) + node.val;
    }


    public static void maxPathSumRec(TreeNode root, int max, int curr) {
        if (root == null) return;
        if (root.left != null)
            maxPathSumRec(root.left, 0, 0);
        nodes.add(root.val);
        if (root.right != null)
            maxPathSumRec(root.right, 0, 0);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.right = new TreeNode(20);
        root.left = new TreeNode(9);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        System.out.println(maxPathSum(root));

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left = new TreeNode(2);
        maxPathSum(root2);
        System.out.println(maxn);

        TreeNode root3 = new TreeNode(-3);

        maxPathSum(root3);
        System.out.println(maxn);


        TreeNode root4 = new TreeNode(2);
        root4.left = new TreeNode(-1);

        maxPathSum(root4);
        System.out.println(maxn);
    }

    public static class TreeNode {
        static List<Integer> nodes = new ArrayList<>();
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