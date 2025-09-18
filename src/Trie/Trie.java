package Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TrieNode{
    TrieNode[] children;
    boolean isEnd;

    public TrieNode(){
        children = new TrieNode[26];
        isEnd = false;
    }
}

class Trie{
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;

        for(char ch :  word.toCharArray()){
            int idx = ch - 'a';
            if(node.children[idx] == null){
                node.children[idx] = new TrieNode();
            }
            node = (node.children[idx]);
        }

        node.isEnd = true;
    }

    public boolean search(String word){
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
            if(node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix){
        TrieNode node = root;
        for(char ch : prefix.toCharArray()){
            int idx = ch - 'a';
            if(node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return true;
    }

    public boolean delete(String word){
        if(!search(word)) return false; // quick exit
        remove(root, word, 0);
        return true;
    }

    private boolean remove(TrieNode node, String word, int depth){
        if(node == null || word == null) return false;

        if(depth == word.length()){
            node.isEnd = false;
            return noChildren(node);
        }

        int idx = word.charAt(depth) - 'a';
        TrieNode child = node.children[idx];
        boolean shouldRemove = remove(child, word, depth + 1);

        if(shouldRemove){
            node.children[idx] = null;
        }
        return !node.isEnd && noChildren(node);
    }

    private boolean noChildren(TrieNode node){
        for(TrieNode c : node.children) if(c != null) return false;
        return true;
    }

   public List<String> autoComplete(String prefix){
        TrieNode node = root;
        for(char c : prefix.toCharArray()){
            int idx = c - 'a';
            if(node.children[idx] == null) return Collections.emptyList();
            node = node.children[idx];
        }

        List<String> result = new ArrayList<>();
        collect(node, new StringBuilder(prefix), result);
        return result;
   }

   private void collect(TrieNode node, StringBuilder path, List<String> result){
        if(node.isEnd) result.add(path.toString());

        for (int i = 0; i < 26; i++) {
           if(node.children[i] != null){
               path.append((char) ('a' + i));
               collect(node.children[i], path, result);
               path.deleteCharAt(path.length() - 1);
           }
        }
   }
}