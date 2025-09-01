class Trie {

    TrieNode root;

    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEndOfWord = false;
        }
    }

    public Trie() {

        this.root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode current = this.root;

        for (int i = 0 ; i < word.length() ; i++) {

            int currIdx = word.charAt(i) - 'a';

            if (current.children[currIdx] == null) {
                
                current.children[currIdx] = new TrieNode();
            }
            current = current.children[currIdx];
        }

        current.isEndOfWord = true;
    }

    public boolean search(String word) {

        TrieNode current = this.root;

        for (int i = 0 ; i < word.length() ; i++) {

            int currIdx = word.charAt(i) - 'a';

            if (current.children[currIdx] == null) {
                
                return false;
            }
            current = current.children[currIdx];
        }

        if(!current.isEndOfWord) {
            return false;
        }

        return true;
    }

    public boolean startsWith(String prefix) {

        TrieNode current = this.root;

        for (int i = 0 ; i < prefix.length() ; i++) {

            int currIdx = prefix.charAt(i) - 'a';

            if (current.children[currIdx] == null) {
                
                return false;
            }
            current = current.children[currIdx];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */