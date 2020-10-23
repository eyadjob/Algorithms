package oldstudy.treesbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTreeIterator {



    public void inorder_using_iterator(BinaryTreeNode root) {
        inorder_tree_iterator iter = new inorder_tree_iterator(root);
        while (iter.hasNext()) {
            System.out.print(iter.getNext().data + ", ");
        }
        System.out.println();
    }

    public List<Integer> inorder_using_iterator_to_list(BinaryTreeNode root) {
        List<Integer>  tree = new ArrayList<>();
        inorder_tree_iterator iter = new inorder_tree_iterator(root);
        while (iter.hasNext()) {
          tree.add(iter.getNext().data);
        }
      return tree;
    }

    public List<BinaryTreeNode> inorder_using_iterator_to_nods_list(BinaryTreeNode root) {
        List<BinaryTreeNode>  tree = new ArrayList<>();
        inorder_tree_iterator iter = new inorder_tree_iterator(root);
        while (iter.hasNext()) {
            tree.add(iter.getNext());
        }
        return tree;
    }


    class inorder_tree_iterator {
        Stack<BinaryTreeNode> stk = new Stack<BinaryTreeNode>();

        public inorder_tree_iterator(BinaryTreeNode root) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
        }

        public boolean hasNext() {
            return !stk.isEmpty();
        }

        public BinaryTreeNode getNext() {
            if (stk.isEmpty())
                return null;

            BinaryTreeNode rVal = stk.pop();
            BinaryTreeNode temp = rVal.right;
            while (temp != null) {
                stk.push(temp);
                temp = temp.left;
            }

            return rVal;
        }
    }

    public static void main(String[] args) {
        InorderTreeIterator instance = new InorderTreeIterator();

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

        instance.inorder_using_iterator(root);
        System.out.println();
    }

}