package facebookposition.binarytrees;

import java.util.*;

public class PrintBinaryTree {

    static int counter = 0;
    private static final int ans = 0;

    public static void main(String[] args) {

//          4
//       7     9
//    10   2     3
//           6
//         2
        TreeNode bt = new TreeNode(4);
        bt.left = new TreeNode(7);
        bt.right = new TreeNode(9);
        bt.right.right = new TreeNode(3);
        bt.left.left = new TreeNode(10);
        bt.left.right = new TreeNode(2);
        bt.left.right.right = new TreeNode(6);
        bt.left.right.right.left = new TreeNode(2);


        TreeNode bt2 = new TreeNode(4);
        bt2.left = new TreeNode(7);
        bt2.right = new TreeNode(9);
        bt2.right.right = new TreeNode(3);
        bt2.left.left = new TreeNode(10);
        bt2.left.right = new TreeNode(2);
        bt2.left.right.right = new TreeNode(6);
        bt2.left.right.right.left = new TreeNode(2);
//        bt2.ln.rn.rn.ln.ln = new Nod(1);

        TreeNode bt3 = new TreeNode(3);
        bt3.left = new TreeNode(9);
        bt3.right = new TreeNode(20);
        bt3.right.right = new TreeNode(7);
        bt3.right.left = new TreeNode(15);

        printBTDepthFirst(bt);
        System.out.println();
        System.out.println("----------- breadth printing --------------------------");
        printBTBreadthFirst(bt);
        System.out.println("-------------------------------------");
        getDepth(bt, 0);
        System.out.println(counter);
        System.out.println("-------------------------------------");
        printBtWithStyle(bt);
        System.out.println("-------------------------------------");
        System.out.println(compareTreeNodeTheSame(bt, bt2));
        System.out.println("-------------------------------------");
        System.out.println(breadthFirstSearch(bt, 6));

        System.out.println("-------------------------------------");
        counter = 0;
        getDepth(bt3, 0);
        System.out.println(counter);
        System.out.println("-------------------------------------");
        System.out.println(maxDepth(bt3));
        System.out.println("-------------------------------------");
        System.out.println(maxDepth(bt));
        System.out.println("-------------------------------------");
        System.out.println(maximumWidthOfTree(bt));
        System.out.println("-------------------------------------");
        System.out.println(checkBTAreEquals(bt, bt2));

        System.out.println("--------------Pre Order Traversal -----------------------");
        System.out.println(BTpreOrderTraversal(bt));


    }

    public static void printBTDepthFirst(TreeNode root) {
        if (root == null) return;

        System.out.print(root.value + " ");
        printBTDepthFirst(root.left);
        printBTDepthFirst(root.right);
    }

    public static void printBTBreadthFirst(TreeNode root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            TreeNode te = qu.remove();
            System.out.println(te.value);
            if (te.left != null) qu.add(te.left);
            if (te.right != null) qu.add(te.right);
        }
    }

    public static void printBtWithStyle(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> btq = new LinkedList<>();
        btq.add(root);
        while (!btq.isEmpty()) {
            TreeNode te = btq.remove();
            System.out.print(te.value);
            if (te.left != null) btq.add(te.left);
            if (te.right != null) btq.add(te.right);
            System.out.println();
        }
    }

    public static int maxDepth(TreeNode root) {
        return (root == null) ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void getDepth(TreeNode root, int max) {
        ++max;
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (counter < max) {
                counter = max;
                max = 0;
            }
        }
        getDepth(root.left, max);
        getDepth(root.right, max);
    }


    public static boolean compareTreeNodeTheSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        return (root1 == null) == (root2 == null) && root1.value == root2.value && compareTreeNodeTheSame(root1.left, root2.left) && compareTreeNodeTheSame(root1.right, root2.right);
    }


    public static boolean breadthFirstSearch(TreeNode root, int v) {
        if (root == null) return false;

        Queue<TreeNode> btq = new LinkedList<>();
        btq.add(root);
        while (!btq.isEmpty()) {
            TreeNode te = btq.remove();
            if (te.value == v) return true;
            if (te.left != null) btq.add(te.left);
            if (te.right != null) btq.add(te.right);
        }
        return false;

    }

    public static long maximumWidthOfTree(TreeNode root) {


        return widthHelper(root, 0, 1, new ArrayList<>());
    }

    public static long widthHelper(TreeNode root, int depth, int index, List<Integer> list) {
        if (root == null) return 0;
        if (depth == list.size()) list.add(index);
        int cw = index - list.get(depth) + 1;
        long lw = widthHelper(root.left, depth + 1, index * 2, list);
        long rw = widthHelper(root.right, depth + 1, index * 2 + 1, list);
        return Math.max(cw, Math.max(lw, rw));
    }

    public static boolean checkBTAreEquals(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        return (root1 == null) == (root2 == null) && root1.value == root2.value && checkBTAreEquals(root1.left, root2.left) && checkBTAreEquals(root1.right, root2.right);
    }

    public static List<Integer> BTpreOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                list.add(node.value);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
        return list;
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



