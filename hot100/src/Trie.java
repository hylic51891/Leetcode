/**
 * ClassName: Trie
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/9/2 18:13
 * @Version 1.0
 */
public class Trie {
    // 哨兵节点+每个节点多叉树（用HashSet维护子节点序列）
    // search: dfs遍历
    // startsWith 也是遍历
    class TrieNode {
        char c;
        boolean isEnd;
        TrieNode[] sons = new TrieNode[26];
        public TrieNode(){
        }
        public TrieNode(char c){
            this.c = c;
        }
    }

    TrieNode sentinel;

    public Trie() {
        sentinel = new TrieNode();
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode curNode = sentinel;
        for(char c:chars){
            int index = c-'a';
            if(curNode.sons[index]==null){
                curNode.sons[index] = new TrieNode(c);
            }
            curNode = curNode.sons[index];
        }
        curNode.isEnd = true;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        int len = chars.length;
        TrieNode curNode = sentinel;
        int i;
        for(i = 0;i< len;i++){
            curNode = curNode.sons[chars[i]-'a'];
            if(curNode==null) return false;
        }
        return curNode.isEnd;
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        int len = chars.length;
        TrieNode curNode = sentinel;
        int i;
        for(i = 0;i< len;i++) {
            curNode = curNode.sons[chars[i]-'a'];
            if (curNode == null) return false;
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