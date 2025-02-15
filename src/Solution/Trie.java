package Solution;

class Trie {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        TrieNode(){
            isEnd = false;
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    Trie(){
        root = new TrieNode();
    }

    void insert(String word){
        TrieNode cur = root;
        for (char c: word.toCharArray()) {
            if (cur.children[c-'a'] == null){
                cur.children[c-'a'] = new TrieNode();
            }
            cur = cur.children[c-'a'];
        }
        cur.isEnd = true;
    }

    boolean search(String word){
        TrieNode cur = root;
        for (char c: word.toCharArray()) {
            if (cur.children[c-'a'] == null){
                return false;
            }
            cur = cur.children[c-'a'];
        }
        if (cur.isEnd) return true;
        else return false;
    }

    boolean startsWith(String prefix){
        TrieNode cur = root;
        for (char c: prefix.toCharArray()) {
            if (cur.children[c-'a'] == null){
                return false;
            }
            cur = cur.children[c-'a'];
        }
        return true;
    }
}
