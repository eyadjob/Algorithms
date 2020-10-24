package oldstudy.treesbook;

public class BinaryTreeNode {

    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public BinaryTreeNode next;
    public BinaryTreeNode parent;
    public int data;

    public BinaryTreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(BinaryTreeNode parent) {
        this.parent = parent;
    }
}
