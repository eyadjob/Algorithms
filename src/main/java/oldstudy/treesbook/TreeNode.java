package oldstudy.treesbook;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    List<TreeNode> children = new ArrayList<>();
    int value;


    public TreeNode(int value) {
        this.value = value;
    }

    public static void display_level_order(TreeNode node) {
        System.out.println(node.value);
        if (node.children.size() == 0){
            return;}
        for (TreeNode n : node.children) {
            display_level_order(n);
        }


    }


}
