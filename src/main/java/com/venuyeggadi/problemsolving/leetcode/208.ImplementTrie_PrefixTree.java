package com.venuyeggadi.problemsolving.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Using a Hashmap
 * Time: O(l) for all functions where l -> length of the word
 * Space: O(n * l) -> where n is the number of strings and l is the average length of the words, since each letter can potentially
       create a new node.
 */
class Trie1 {

    private TrieNode root;

    private class TrieNode {
        TrieNode() {
            children = new HashMap<>();
        }
        public Map<Character, TrieNode> children;
        public boolean isLast;
    }

    public Trie1() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }

        current.isLast = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c))
                return false;
            current = current.children.get(c);
        }

        return current.isLast;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            if (!current.children.containsKey(c))
                return false;
            current = current.children.get(c);
        }

        return true;
    }
}

/**
 * Using a Hashmap
 * Time: O(l) for all functions where l -> length of the word
 * Space: O(n * l) -> where n is the number of strings and l is the average length of the words, since each letter can potentially
       create a new node.
 */
class Trie2 {

    TrieNode root;

    public Trie2() {
        root = new TrieNode();
    }

    private class TrieNode {
        TrieNode() {
            children = new TrieNode[26];
            isLast = false;
        }
        public TrieNode[] children;
        public boolean isLast;
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null)
                current.children[c - 'a'] = new TrieNode();
            current = current.children[c - 'a'];
        }
        current.isLast = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null)
                return false;
            current = current.children[c - 'a'];
        }

        return current.isLast;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            if (current.children[c - 'a'] == null)
                return false;
            current = current.children[c - 'a'];
        }

        return true;
    }
}

