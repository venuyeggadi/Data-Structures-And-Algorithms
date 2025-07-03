package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Bruteforce
 * Time:
 *    O(1) for inserting word
 *    O(n * l) for searching where n is the number of words and l is the average length od the words.
 * Space:
 *    O(n * l)
 */
class WordDictionary {

    private List<String> list;

    public WordDictionary() {
        list = new ArrayList<>();
    }

    public void addWord(String word) {
        list.add(word);
    }

    public boolean search(String searchWord) {
        for (String word : list) {
            if (word.length() != searchWord.length())
                continue;
            int i;
            for (i = 0; i < word.length(); i++) {
                if (searchWord.charAt(i) != '.' && searchWord.charAt(i) != word.charAt(i))
                    break;
            }
            if (i == word.length())
                return true;
        }

        return false;
    }
}


/**
 * Using Trie
 * Time:
 *    O(n) for inserting word
 *    O(26^2 * n) => O(n) for searching, as there will be at most 2 '.' characters.
 * Space:
 *    O(n * l) where n is the number of words and l is the average length od the words.
 */
class WordDictionary2 {

    private TrieNode root;

    WordDictionary2() {
        root = new TrieNode();
    }

    private class TrieNode {
        public TrieNode[] children;
        public boolean isLast;
        TrieNode() {
            children = new TrieNode[26];
            isLast = false;
        }
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null)
                current.children[index] = new TrieNode();
            current = current.children[index];
        }
        current.isLast = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    public boolean search(String word, int startIndex, TrieNode root) {
        TrieNode current = root;
        for (int i = startIndex; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode node : current.children) {
                    if (node != null && search(word, i + 1, node))
                        return true;
                }
                return false;
            } else {
                int index = c - 'a';
                if (current.children[index] == null)
                    return false;
                current = current.children[index];
            }
        }

        return current.isLast;
    }
}

