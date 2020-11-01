package facebookposition.binarytrees.SortedBinaryTreesAlgo;

import facebookposition.binarytrees.BinaryTree;
import facebookposition.binarytrees.TreeNod;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TraversalTrees {
    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree(1);
        bt.root.left = new TreeNod(2);
        bt.root.right = new TreeNod(3);
        bt.root.left.left = new TreeNod(4);
        bt.root.left.right = new TreeNod(5);

        System.out.println("------------- in order traversal : Inorder (Left, Root, Right) : 4 2 5 1 3 --------------");
        System.out.println(inOrderTraversal(bt.root, new ArrayList<>()));
        System.out.println("------------- Pre order  traversal : Preorder (Root, Left, Right) : 1 2 4 5 3 --------------");
        System.out.println(PreOrderTraversal(bt.root, new ArrayList<>()));
        System.out.println("------------- Pre order  traversal : Preorder (Root, Left, Right) : 1 2 4 5 3 --------------");
        System.out.println(preOrderTraversalNotRecursive(bt.root));
        System.out.println("------------- Post order traversal : Postorder (Left, Right, Root) : 4 5 2 3 1--------------");
        System.out.println(PostOrderTraversal(bt.root, new ArrayList<>()));

    }

    public static List<Integer> inOrderTraversal(TreeNod root, List<Integer> re) {
        if (root == null) return re;
        inOrderTraversal(root.left, re);
        re.add(root.value);
        inOrderTraversal(root.right, re);
        return re;
    }

    public static List<Integer> PreOrderTraversal(TreeNod root, List<Integer> re) {
        if (root == null) return re;
        re.add(root.value);
        PreOrderTraversal(root.left, re);
        PreOrderTraversal(root.right, re);
        return re;
    }

    public static List<Integer> PostOrderTraversal(TreeNod root, List<Integer> re) {
        if (root == null) return re;
        PostOrderTraversal(root.left, re);
        PostOrderTraversal(root.right, re);
        re.add(root.value);
        return re;
    }


    public static List<Integer> preOrderTraversalNotRecursive(TreeNod root) {
        List<Integer> list = new ArrayList();
        Stack<TreeNod> stack = new Stack();
        TreeNod node = root;
        while(node!= null || stack.size() >0){
            if(node != null){
                list.add(node.value);
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                node = node.right;
            }
        }
        return list;
    }


}
