package solutions.p0211_DesignAddandSearchWordsDataStructure;

public class P0211 {
    class WordDictionary {

        private WordDictionary[] children;
        boolean isCompleteWord;

        public WordDictionary() {
            children = new WordDictionary[26];
            isCompleteWord = false;
        }

        public void addWord(String word) {
            WordDictionary curr = this;
            for(char c: word.toCharArray()){
                if(curr.children[c - 'a'] == null)
                    curr.children[c - 'a'] = new WordDictionary();
                curr = curr.children[c - 'a'];
            }
            curr.isCompleteWord = true;
        }

        public boolean search(String word) {
            WordDictionary curr = this;
            for(int i = 0; i < word.length(); ++i){
                char c = word.charAt(i);
                if(c == '.'){
                    for(WordDictionary ch: curr.children)
                        if(ch != null && ch.search(word.substring(i+1))) return true;
                    return false;
                }
                if(curr.children[c - 'a'] == null) return false;
                curr = curr.children[c - 'a'];
            }
            return curr != null && curr.isCompleteWord;
        }
    }
}
