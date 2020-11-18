package facebookposition.binarytrees.SortedBinaryTreesAlgo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class AverageOfBinaryTreeLevels {
//          4
//       7     9
//    10   2     3
//           6
//         2

    public static void main(String[] args) {

        TreeNode bt = new TreeNode(4);
        bt.left = new TreeNode(7);
        bt.right = new TreeNode(9);
        bt.right.right = new TreeNode(3);
        bt.left.left = new TreeNode(10);
        bt.left.right = new TreeNode(2);
        bt.left.right.right = new TreeNode(6);
        bt.left.right.right.left = new TreeNode(2);


//        System.out.println(getAverageOfEachLevelInBinaryTree(bt));
        for (Double list : getAverageOfEachLevelInBinaryTree(bt)) {
            System.out.println(list);
        }

        System.out.println(printBDS(bt).toString());

    }

    public static List<Integer> printBDS(TreeNode root) {
        List<Integer> re = new ArrayList<>();
        if (root == null) return re;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while ( q.size() > 0) {
            TreeNode node = q.poll();
            re.add(node.val);
            if ( node.left != null)
                q.add(node.left);
            if ( node.right != null)
                q.add(node.right);
        }
        return re;
    }

    public static List<Double>  getAverageOfEachLevelInBinaryTree(TreeNode root) {
        List<List<Integer>> re = new ArrayList<>();
        List<Double> average = new ArrayList<>();
        if (root == null) return average;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.size() > 0) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            average.add(level.stream().collect(Collectors.averagingInt(v -> Integer.parseInt(String.valueOf(v)))));
        }
        return average;
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
