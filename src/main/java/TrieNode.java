import lombok.Data;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Data
public class TrieNode {


    char data;
//    List<TrieNode> childern = new LinkedList<>();
    public List<TrieNode> children = new LinkedList();
    TrieNode parent;
    boolean isEnd = true;

}
