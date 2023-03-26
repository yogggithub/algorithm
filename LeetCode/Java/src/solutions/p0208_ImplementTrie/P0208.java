package solutions.p0208_ImplementTrie;

public class P0208 {
    /*
     * Solution v1: Brute Force
     *
     * Runtime: 38 ms @ (beats) 63.80%
     * Memory Usage: 50.9 MB @ (beats) 85.74%
     */
    class Trie {

        Object[] root;

        public Trie() {
            this.root = new Object[27];
        }

        public void insert(String word) {
            Object[] node = this.root;

            for (int i = 0; i < word.length(); i++) {
                int j = word.charAt(i) - 'a';
                if (node[j] == null) {
                    node[j] = new Object[27];
                }

                node = (Object[]) node[j];

            }

            node[26] = Boolean.TRUE;

        }

        public boolean search(String word) {
            Object[] node = this.root;

            for (int i = 0; i < word.length(); i++) {
                int j = word.charAt(i) - 'a';
                if (node[j] == null){
                    return false;
                }
                node = (Object[]) node[j];
            }

            return node[26] == Boolean.TRUE;
        }

        public boolean startsWith(String prefix) {
            Object[] node = this.root;

            for (int i = 0; i < prefix.length(); i++) {
                int j = prefix.charAt(i) - 'a';

                if (node[j] == null){
                    return false;
                }
                node = (Object[]) node[j];
            }

            return true;
        }
    }
}
