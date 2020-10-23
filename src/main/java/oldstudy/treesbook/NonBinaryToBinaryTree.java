package oldstudy.treesbook;

public class NonBinaryToBinaryTree {

    public static BinaryTreeNode convert_n_ary_to_binary(TreeNode root) {

BinaryTreeNode node = new BinaryTreeNode();
return node;
    }

    public static void main(String[] argv) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.children.add(node2);
        node1.children.add(node3);
        node1.children.add(node4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node3.children.add(node5);
        node3.children.add(node6);

        System.out.println("Level Order TreeNode Display:");
        TreeNode.display_level_order(node1);

        System.out.println("Converting N_ary Tree to BT\n");

        BinaryTreeNode bnode1 = convert_n_ary_to_binary(node1);
        System.out.println("Level Order BT Display:");
        BinaryTree.display_level_order(bnode1);
        System.out.println();
        //If the tree is converted into BT then the following statement must return "5"
        System.out.println("\nRoot.Left.Left.Right = " + bnode1.left.left.right.data);

        System.out.println("Converting BT to N_ary Tree\n");
//        TreeNode tnode1 = convert_binary_to_n_ary_tree(bnode1);
//        System.out.println("Level Order TreeNode Display:");
//        TreeNode.display_level_order(tnode1);
    }

}
