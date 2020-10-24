package facebookposition.binarytrees;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintBinaryTree {

    static int counter = 0;

    public static void main(String[] args) {

//          4
//       7     9
//    10   2     3
//           6
//         2
        BinaryTree bt = new BinaryTree(4);
        bt.root.left = new TreeNod(7);
        bt.root.right = new TreeNod(9);
        bt.root.right.right = new TreeNod(3);
        bt.root.left.left = new TreeNod(10);
        bt.root.left.right = new TreeNod(2);
        bt.root.left.right.right = new TreeNod(6);
        bt.root.left.right.right.left = new TreeNod(2);


        BinaryTree bt2 = new BinaryTree(4);
        bt2.root.left = new TreeNod(7);
        bt2.root.right = new TreeNod(9);
        bt2.root.right.right = new TreeNod(3);
        bt2.root.left.left = new TreeNod(10);
        bt2.root.left.right = new TreeNod(2);
        bt2.root.left.right.right = new TreeNod(6);
        bt2.root.left.right.right.left = new TreeNod(2);
//        bt2.root.ln.rn.rn.ln.ln = new Nod(1);

        BinaryTree bt3 = new BinaryTree(3);
        bt3.root.left = new TreeNod(9);
        bt3.root.right = new TreeNod(20);
        bt3.root.right.right = new TreeNod(7);
        bt3.root.right.left = new TreeNod(15);

        printBTDepthFirst(bt.root);
        System.out.println();
        System.out.println("-------------------------------------");
        printBTBreadthFirst(bt.root);
        System.out.println("-------------------------------------");
        getDepth(bt.root, 0);
        System.out.println(counter);
        System.out.println("-------------------------------------");
        printBtWithStyle(bt.root);
        System.out.println("-------------------------------------");
        System.out.println(compareBinaryTreeTheSame(bt.root, bt2.root));
        System.out.println("-------------------------------------");
        System.out.println(breadthFirstSearch(bt.root, 6));

        System.out.println("-------------------------------------");
        counter = 0;
        getDepth(bt3.root, 0);
        System.out.println(counter);
        System.out.println("-------------------------------------");
        System.out.println(maxDepth(bt3.root));
        System.out.println("-------------------------------------");
        System.out.println(maxDepth(bt.root));
        System.out.println("-------------------------------------");
        System.out.println(maximumWidthOfTree(bt.root));


    }

    public static void printBTDepthFirst(TreeNod root) {
        if (root == null) return;

        System.out.println(root.v);
        printBTDepthFirst(root.left);
        printBTDepthFirst(root.right);
    }

    public static void printBTBreadthFirst(TreeNod root) {

        if (root == null) {
            return;
        }

        Queue<TreeNod> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            TreeNod te = qu.remove();
            System.out.println(te.v);
            if (te.left != null) qu.add(te.left);
            if (te.right != null) qu.add(te.right);
        }
    }

    public static void printBtWithStyle(TreeNod root) {
        if (root == null) return;
        Queue<TreeNod> btq = new LinkedList<>();
        btq.add(root);
        while (!btq.isEmpty()) {
            TreeNod te = btq.remove();
            System.out.print(te.v);
            if (te.left != null) btq.add(te.left);
            if (te.right != null) btq.add(te.right);
            System.out.println();
        }
    }

    public static int maxDepth(TreeNod root) {
        return (root == null) ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void getDepth(TreeNod root, int max) {
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


    public static boolean compareBinaryTreeTheSame(TreeNod root1, TreeNod root2) {
        if (root1 == null && root2 == null) return true;
        return (root1 == null) == (root2 == null) && root1.v == root2.v && compareBinaryTreeTheSame(root1.left, root2.left) && compareBinaryTreeTheSame(root1.right, root2.right);
    }


    public static boolean breadthFirstSearch(TreeNod root, int v) {
        if (root == null) return false;

        Queue<TreeNod> btq = new LinkedList<>();
        btq.add(root);
        while (!btq.isEmpty()) {
            TreeNod te = btq.remove();
            if (te.v == v) return true;
            if (te.left != null) btq.add(te.left);
            if (te.right != null) btq.add(te.right);
        }
        return false;

    }

    public static long maximumWidthOfTree(TreeNod root) {


        return widthHelper(root, 0, 1, new ArrayList<>());
    }

    public static long widthHelper(TreeNod root, int depth, int index, List<Integer> list) {
        if (root == null) return 0;
        if (depth == list.size()) list.add(index);
        int cw = index - list.get(depth) + 1;
        long lw = widthHelper(root.left, depth + 1, index * 2, list);
        long rw = widthHelper(root.right, depth + 1, index * 2 + 1, list);
        return Math.max(cw, Math.max(lw, rw ));
    }
    private static int ans = 0;




}



