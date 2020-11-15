package facebookposition.fbquestions.datastructure;

import java.util.HashMap;
import java.util.Map;

public class AddAndSearchWords {


    public static void main(String[] args) {
        AddAndSearchWords addAndSearchWords = new AddAndSearchWords();
        addAndSearchWords.test();
    }

    public void test() {

        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("eyad");
        wordDictionary.addWord("rocket");
        wordDictionary.addWord("rockets");
        System.out.println(wordDictionary.searchWord("eyaw"));
        System.out.println(wordDictionary.searchWord("eyad"));
        System.out.println(wordDictionary.searchWord(""));
        System.out.println(wordDictionary.searchWord("rocket"));
        System.out.println(wordDictionary.searchWord("rockets"));

    }


    public class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean word = false;


        public TrieNode() {

        }

    }

    public class WordDictionary {
        TrieNode trie;

        public WordDictionary() {
            trie = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode node = trie;
            for (char ch : word.toCharArray()) {
                if (!node.children.containsKey(ch)) {
                    node.children.put(ch, new TrieNode());
                }
                node = node.children.get(ch);
            }
            node.word = true;
        }

        public boolean searchWord(String word) {
            return searchWordInNod(word, trie);
        }

        public boolean searchWordInNod(String word, TrieNode node) {

            for (char ch : word.toCharArray()) {
                if (!node.children.containsKey(ch)) {
//                    if ( ch == '.') {
//                        for ( char x : node.children.keySet()) {
//                            TrieNode child = node.children.get(x);
//
//                        }
                    return false;
                } else {
                    node = node.children.get(ch);
                }
            }
            return node.word;
        }

    }

}



