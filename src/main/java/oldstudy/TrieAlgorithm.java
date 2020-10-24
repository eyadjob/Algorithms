package oldstudy;

import java.util.ArrayList;
import java.util.List;

public class TrieAlgorithm {

    static  TrieNode root = new TrieNode();
    public static void main(String[] args) {




//        TrieNode a = new TrieNode();
//        a.setData('a');
//        root.getChildren().put('a', a);
//
//        TrieNode m = new TrieNode();
//        m.setData('m');
//        a.getChildren().put('m', m);
//
//        TrieNode a2 = new TrieNode();
//        a2.setData('a');
//        m.getChildren().put('a', a2);
//
//        TrieNode z = new TrieNode();
//        z.setData('z');
//        a2.getChildren().put('z', z);
//
//        TrieNode o = new TrieNode();
//        o.setData('o');
//        z.getChildren().put('o', o);
//
//        TrieNode n = new TrieNode();
//        n.setData('n');
//        o.getChildren().put('n', n);
//        n.setEnd(true);
//
//        TrieNode i = new TrieNode();
//        i.setData('i');
//        i.getChildren().put('z', z);
//
//        TrieNode in = new TrieNode();
//        in.setData('i');
//        in.getChildren().put('i', i);
//
//        TrieNode g = new TrieNode();
//        g.setData('g');
//        in.getChildren().put('g',g);


        TrieNode a = new TrieNode();
        a.setData('a');
        root.getChildren().add(a);

        TrieNode m = new TrieNode();
        m.setData('m');
        a.getChildren().add(m);

        TrieNode a2 = new TrieNode();
        a2.setData('a');
        m.getChildren().add(a2);

        TrieNode z = new TrieNode();
        z.setData('z');
        a2.getChildren().add(z);

        TrieNode o = new TrieNode();
        o.setData('o');
        a2.getChildren().add(o);

        TrieNode n = new TrieNode();
        n.setData('n');
        o.getChildren().add(n);
        n.setEnd(true);

        TrieNode i = new TrieNode();
        i.setData('i');
        i.getChildren().add(n);

        TrieNode in = new TrieNode();
        in.setData('i');
        i.getChildren().add(in);

        TrieNode g = new TrieNode();
        g.setData('g');
        in.getChildren().add(g);


        System.out.println(getWordsMyBrain("amaz", 0,root,new StringBuilder()));
    }

//    public List<String> getWords(String prefix) {
//
//            List<String> words = new ArrayList<>();
//
//            if ( isEnd) {
//                words.add(toString());
//            }
//
//
//    }

//    public static List<String> getWords_book(String word,TrieNode tn, StringBuilder cs) {
//        List<String> strings = new ArrayList<>();
//
//
//        TrieNode current = root;
//        for (int i = 0; i < word.length(); i++) {
//            char ch = word.charAt(i);
//            TrieNode node = current.getChildren().get(ch);
//            if (node != null) {
//                if (node.isEnd) {
//                  strings.add(cs.toString());
//                  cs = new StringBuilder();
//                } else {
//                    cs.append(node.getData());
//                    continue;
//                }
//            }
//            strings.add(node.getData()) ;
//        }
//        return current.isEnd();
//    }

    public static  List<String> getWordsMyBrain(String word,int i , TrieNode tr, StringBuilder sb) {
        List<String> words = new ArrayList<>();
//amaz
//amb
//amazing
//amazon
        if ( i >= word.length()) {
            if ( !tr.isEnd) {
                TrieNode itn = tr.getChildren().get(tr.getData());
                sb.append(itn.getData());
                getWordsMyBrain(word, i, itn, sb);
            } else {
                words.add(sb.toString());
                return words;
            }
        }
//        for (int i=0; i < word.length(); i++) {
            char ch = word.charAt(i);
              TrieNode itn  =  tr.getChildren().get(i);
              if ( itn.getData() == ch) {
                  sb.append(ch);
                  getWordsMyBrain(word, i+1,itn, sb);
              } else {
                  sb = new StringBuilder();
                  return words;
              }
//        }

        return words;
    }


}











