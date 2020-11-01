package facebookposition.binarytrees;

public class BinaryTree {

    public TreeNod root;

    public BinaryTree(int v) {
        this.root = new TreeNod(v);
    }

    public TreeNod buildSortedBT(int[] values, TreeNod root) {
        root.value = values[0];
        for (int i = 0; i < values.length; i++) {
                    if ( i == 0) continue;
                    if (root.value >= values[i]) root.left = new TreeNod(values[i]);
                    else root.right = new TreeNod(values[i]);
        }
        return root;
    }
}
