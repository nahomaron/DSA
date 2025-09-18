package Trie;

public class Main {
    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("Search: " + trie.search("apple"));
        System.out.println("Starts with: " + trie.startsWith("ap"));

        trie.delete("apple");
        System.out.println("Search: " + trie.search("apple"));

        boolean deletedNon = trie.delete("banana");
        System.out.println("Delete Non: " + deletedNon);
    }
}
