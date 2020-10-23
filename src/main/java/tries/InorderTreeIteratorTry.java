package tries;

import treesbook.BinaryTree;
import treesbook.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTreeIteratorTry {



    public  void inorder_using_iterator(BinaryTreeNode root) {
        IteratorImplementor ii = new IteratorImplementor(root);
            while ( ii.hasNext() ) {
                System.out.println(ii.next().data);
            }

    }

    public class IteratorImplementor {
        Stack<BinaryTreeNode> nods = new Stack<>();


        public IteratorImplementor(BinaryTreeNode root) {

            while (root != null) {
                nods.push(root);
                root = root.left;
            }
        }

        public boolean hasNext() {

            if (nods.size() > 0)
                return true;

            return false;
        }

        public BinaryTreeNode next() {

            if (nods.empty())
                return null;

            BinaryTreeNode v = nods.pop();
            BinaryTreeNode temp = v.right;
            while (temp != null) {

                nods.push(temp);
                temp = temp.left;
            }
            return v;


        }
    }
    public static void main(String[] args) {

        List<Integer> input = new ArrayList<Integer>();
        input.add(100);
        input.add(50);
        input.add(200);
        input.add(25);
        input.add(12);
        input.add(35);
        input.add(75);
        input.add(60);
        input.add(125);
        input.add(350);
        BinaryTreeNode root = BinaryTree.create_BST(input);
        InorderTreeIteratorTry instance = new InorderTreeIteratorTry();

        instance.inorder_using_iterator(root);
        System.out.println();
    }

}
