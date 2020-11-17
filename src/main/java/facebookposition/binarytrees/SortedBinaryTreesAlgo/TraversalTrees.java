package facebookposition.binarytrees.SortedBinaryTreesAlgo;

import facebookposition.binarytrees.BinaryTree;
import facebookposition.binarytrees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TraversalTrees {
    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(4);
        bt.root.left.right = new TreeNode(5);

        System.out.println("------------- in order traversal : Inorder (Left, Root, Right) : 4 2 5 1 3 --------------");
        System.out.println(inOrderTraversal(bt.root, new ArrayList<>()));
        System.out.println("------------- Pre order  traversal : Preorder (Root, Left, Right) : 1 2 4 5 3 --------------");
        System.out.println(PreOrderTraversal(bt.root, new ArrayList<>()));
        System.out.println("------------- Pre order  traversal : Preorder (Root, Left, Right) : 1 2 4 5 3 --------------");
        System.out.println(preOrderTraversalNotRecursive(bt.root));
        System.out.println("------------- Post order traversal : Postorder (Left, Right, Root) : 4 5 2 3 1--------------");
        System.out.println(PostOrderTraversal(bt.root, new ArrayList<>()));

    }

    public static List<Integer> inOrderTraversal(TreeNode root, List<Integer> re) {
        if (root == null) return re;
        inOrderTraversal(root.left, re);
        re.add(root.value);
        inOrderTraversal(root.right, re);
        return re;
    }

    public static List<Integer> PreOrderTraversal(TreeNode root, List<Integer> re) {
        if (root == null) return re;
        re.add(root.value);
        PreOrderTraversal(root.left, re);
        PreOrderTraversal(root.right, re);
        return re;
    }

    public static List<Integer> PostOrderTraversal(TreeNode root, List<Integer> re) {
        if (root == null) return re;
        PostOrderTraversal(root.left, re);
        PostOrderTraversal(root.right, re);
        re.add(root.value);
        return re;
    }


    public static List<Integer> preOrderTraversalNotRecursive(TreeNode root) {
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

    public static List<Integer> DFSIterativeInorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (stack.size() > 0 || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.value);
            root = root.right;
        }

        return list;
    }

    public static List<Integer> DFSIterativePreorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.value);
            if (root.right != null)
                stack.add(root.right);
            if (root.left != null)
                stack.add(root.left);
        }

        return list;

    }

    public static List<Integer> DFSIterativePostOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    list.add(temp.value);
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        list.add(temp.value);
                    }
                } else {
                    root = temp;
                }
            }
        }

        return list;
    }


}
