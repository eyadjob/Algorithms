
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreesAreEqualDepthFirstSearch {


    public static boolean are_identical(BinaryTree.BinaryTreeNode n1, BinaryTree.BinaryTreeNode n2) {


        if (n1 == null && n2 == null) {
            return Boolean.TRUE;
        }
         else if (n1 == null ^  n2 == null) {
            return Boolean.FALSE;
        }

        if (n1.getV() == n2.getV() && are_identical(n1.right, n2.right) && are_identical(n1.getLeft(), n2.getLeft())) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }


    public static class BinaryTree {
        static  BinaryTreeNode  head = new BinaryTreeNode();
        public static BinaryTreeNode create_BST(List<Integer> input1) {

            for (int i = 0; i < input1.size(); i++) {
                if (i == 0) {
                    BinaryTreeNode nod = new BinaryTreeNode();
                    nod.setV(input1.get(i));
                    head = nod;


                } else {
                    setNodValue(head, input1.get(i));
                }

            }

            return head;
        }

        public static void setNodValue(BinaryTreeNode headN, Integer v) {
            if (v < headN.getV()) {
                if (headN.getLeft() == null) {
                    BinaryTreeNode nod = new BinaryTreeNode();
                    nod.setV(v);
                    headN.setLeft(nod);
                } else {
                    setNodValue(headN.getLeft(), v);
                }

            } else {
                if (headN.getRight() == null) {
                    BinaryTreeNode nod = new BinaryTreeNode();
                    nod.setV(v);
                    headN.setRight(nod);
                } else {
                    setNodValue(headN.getRight(), v);
                }

            }
        }



        @Data
        public static class BinaryTreeNode {
            BinaryTreeNode left;
            BinaryTreeNode right;
            Integer v;

            public void setV(Integer value) {
                v = value;
            }


        }
    }


    public static void main(String[] argv) {

        List<Integer> input1 = new ArrayList<Integer>();
        input1.add(100);
        input1.add(50);
        input1.add(200);
        input1.add(25);
        input1.add(125);
        input1.add(250);
        BinaryTree.BinaryTreeNode root = BinaryTree.create_BST(input1);

        List<Integer> input2 = new ArrayList<Integer>();
        input2.add(1);
        input2.add(2);
        input2.add(10);
        input2.add(50);
        input2.add(180);
        input2.add(199);
        BinaryTree.BinaryTreeNode root2 = BinaryTree.create_BST(input2);

//                BinaryTree.display_level_order(root);
        System.out.println();

//                BinaryTree.display_level_order(root2);
        System.out.println();

        System.out.println("same " + Boolean.toString(are_identical(root, root) == true));
        System.out.println("null " + Boolean.toString(are_identical(root, null) == false));
        System.out.println("null,null " + Boolean.toString(are_identical(null, null) == true));
        System.out.println("different " + Boolean.toString(are_identical(root, root2) == false));
    }

}
