package facebookposition.binarytrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllNodesDistanceKInBinaryTree {
    static List<Integer> nodes = new ArrayList<>();
    static List<Integer> res;
    static List<Integer> result2 = new ArrayList<>();
    static Stack<TreeNode> previousNodes = new Stack<>();

    public static void main(String[] args) {

        Stack<Integer> test = new Stack<Integer>();
        for (int i = 0; i < 10; i++) {
            test.add(i);
        }
        while (test.size() > 0) {
            System.out.println(test.pop());
        }
        TreeNode bt = new TreeNode(3);
        bt.left = new TreeNode(5);
        bt.right = new TreeNode(1);
        bt.right.right = new TreeNode(8);
        bt.right.left = new TreeNode(0);
        bt.left.left = new TreeNode(6);
        bt.left.right = new TreeNode(2);
        bt.left.right.right = new TreeNode(4);
        bt.left.right.left = new TreeNode(7);

        System.out.println(distanceK(bt, bt.left, 2));
//        System.out.println(distanceK2(bt, bt.left, 2));

//        findBelowTarget2(bt, bt.left, 2, 0, false);
//        System.out.println();
        distanceK2(bt, bt.left, 2);
        System.out.println(result2.toString());
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        res = new ArrayList<>();

        findBelowTarget(target, K, 0);
        findAboveTarget(root, target, K);

        return res;

    }

    public static void distanceK2(TreeNode root, TreeNode target, int k) {
        findBelowTarget2(root, target, k, 0, false);
        findAboveTheTarget2(previousNodes, target, k);
    }

    public static void findAboveTheTarget2(Stack<TreeNode> previousNodes, TreeNode target, int k) {
        String dir = "";
        previousNodes.remove(previousNodes.size() - 1);
        TreeNode node = previousNodes.firstElement();
        if (node.left == target)
            dir = "right";
        else
            dir = "left";
        while (previousNodes.size() > 0) {
            int size = previousNodes.size() + 1;
            if (dir.equals("left")) countFromNode(previousNodes.pop().left, k - size, 0);
            else
                countFromNode(previousNodes.pop().right, k - size, 0);
        }
    }

    public static void countFromNode(TreeNode root, int k, int dist) {
        if (root == null || dist > k) return;
        if (dist == k) result2.add(root.val);
        countFromNode(root.left, k, ++dist);
        countFromNode(root.right, k, ++dist);
    }

    public static void findBelowTarget2(TreeNode root, TreeNode target, int k, int dist, boolean targetFound) {
        if (root == null) {
            --dist;
            return;
        }
        if (!targetFound && root == target) targetFound = true;
        if (!targetFound) {
            if (previousNodes.size() >= k) {
                previousNodes.remove(previousNodes.size() - 1);
                previousNodes.add(root);
            } else {
                previousNodes.add(root);
            }
        }
        if (k == dist) result2.add(root.val);
        if (targetFound) dist++;
        findBelowTarget2(root.left, target, k, dist, targetFound);
        findBelowTarget2(root.right, target, k, dist, targetFound);
    }

    private static int findAboveTarget(TreeNode root, TreeNode target, int K) {
        if (root == null) return Integer.MIN_VALUE;
        if (root == target) return 0;

        int left = findAboveTarget(root.left, target, K);
        int right = findAboveTarget(root.right, target, K);

        if (left == K - 1 || right == K - 1) {
            res.add(root.val);
        }

        int retVal = Integer.MIN_VALUE;
        if (left != Integer.MIN_VALUE || right != Integer.MIN_VALUE) {
            if (left >= 0) {
                retVal = left + 1;
                findBelowTarget(root.right, K, left + 2);
            }

            if (right >= 0) {
                retVal = right + 1;
                findBelowTarget(root.left, K, right + 2);
            }
        }

        return retVal;

    }

    private static void findBelowTarget(TreeNode curr, int K, int currDist) {
        if (curr == null) return;

        if (currDist == K) {
            res.add(curr.val);
        }
        findBelowTarget(curr.left, K, currDist + 1);
        findBelowTarget(curr.right, K, currDist + 1);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
            this.val = 0;
            this.left = null;
            this.right = null;
        }

        TreeNode(int data) {
            this.val = data;
            this.left = null;
            this.right = null;
        }
    }

}
