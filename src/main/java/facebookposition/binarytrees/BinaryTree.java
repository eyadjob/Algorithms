package facebookposition.binarytrees;

public class BinaryTree {

    public TreeNode root;

    public BinaryTree(int v) {
        this.root = new TreeNode(v);
    }

    public TreeNode buildSortedBT(int[] values, TreeNode root) {
        root.value = values[0];
        for (int i = 0; i < values.length; i++) {
                    if ( i == 0) continue;
                    if (root.value >= values[i]) root.left = new TreeNode(values[i]);
                    else root.right = new TreeNode(values[i]);
        }
        return root;
    }
}
