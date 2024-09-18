package src.TreeNode;

class Trie {

    class TrieNode{
        boolean end;  // 标记节点是否为结尾节点
        TrieNode[] tns = new TrieNode[26];
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode p = root;
        for(int i = 0;i<word.length();i++){
            int u = word.charAt(i) - 'a';
            if(p.tns[u] == null) p.tns[u] = new TrieNode();
            // 记录完一个字符需要从他的下一个节点开始
            p = p.tns[u];
        }
        p.end = true;
    }

    public boolean search(String s) {
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) return false;
            p = p.tns[u];
        }
        return p.end;
    }

    public boolean startsWith(String s) {
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) return false;
            p = p.tns[u];
        }
        return true;
    }
}